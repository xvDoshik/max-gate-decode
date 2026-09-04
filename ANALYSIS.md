# Max Gate Tg 2.1.apk — полный разбор

Источник: `/Users/xv/Downloads/AyuGram Desktop/Max Gate Tg 2.1.apk`  
SHA256: `fe01aafe9eabe4e2205816db3ed2ea5f086eb167220aa4fc6c37354fcd1dbef7`

## Вердикт

**4-ступенчатый Android dropper + stealer**, имитирующий Google Play / Telegram. Не официальный клиент Telegram.

## Цепочка декодирования

```
Shell APK (com.mobilex.hub)
  [1] assets/ۦۖ۫/... (1080549 B) → strip BE header (+149) → nativeCipher
  [2] stage2.zip → DexClassLoader com.template.shellapp
  [3] assets/payload.db → AES-CBC → stage3 com.coresoft.safe (15 dex, обфускация)
  [4] assets/ۦۖ۫/... в stage3 (1269400 B) → strip BE (+408) → nativeCipher
  [5] stage4.zip → runtime DexClassLoader com.base.template (реальный stealer)
```

### Ключи и параметры

| Стадия | Метод | Ключ / параметр |
|--------|--------|-----------------|
| 1→2 | `libcybqacsq.so` `IRGXHKLL.nativeCipher` | `!no#vbrj^?:%1Co@` |
| 1→2 | header | BE int + 4, skip **149** |
| 2→3 | AES-CBC PKCS5 | `c56ae8aa8f1e5aec2c15bcf1d4914dfde1832e3f6e146e85a8742b05443edb06`, IV=first 16 B |
| 3→4 | `libwvhqefmz.so` `neNfPhzo.nativeCipher` (32-bit ARM) | `HK{GZ%rkbBh9sYEO` (part2+part1) |
| 3→4 | header | BE int + 4, skip **408** |

### Пересборка

```bash
cd max-gate-apk/unidbg && mvn -q package -DskipTests
python3 decode_all.py
java -cp unidbg/target/max-gate-decode-1.0.jar local.DecodeCipherStage3 \
  output/stage3/native/libwvhqefmz.so \
  output/stage3/stripped_junk.bin 'HK{GZ%rkbBh9sYEO' output/stage4.zip
```

---

## Stage 0 — Shell (com.mobilex.hub)

| Поле | Значение |
|------|----------|
| Label | Max Gate Tg 2.1 |
| Main | `com.template.shellapp.MainActivity` |
| Loader | `com.mobilex.hub.RBVhpOZk` |
| Native | `libcybqacsq.so` (arm64) |
| UI | `assets/dropper.html` — фейк Google Play (RU) |

Permissions: `REQUEST_INSTALL_PACKAGES`, `QUERY_ALL_PACKAGES`, `RECEIVE_BOOT_COMPLETED`, manifest stuffing.

---

## Stage 2 — Loader (com.template.shellapp)

Устанавливает/грузит payload типа **stealer**, target package **`com.coresoft.safe`**.

- `BlockVpnService` — блок VPN до выдачи SMS/accessibility
- `SyncService` — foreground persistence
- `libnativelib.so` — daemon (`startDaemon`)
- WebView URL в этой сборке: **пустая строка**

---

## Stage 3 — Obfuscated loader (com.coresoft.safe)

15 dex, arabic class names, zip-bomb entry `.fn/...` (password-protected).

Readable assets:
- `assets/phish_tg.html` — фиш Telegram (phone/code/password → `Android.submit*`)
- `assets/onboarding_stealer.html` — onboarding SMS/VPN/battery/notifications (RU)
- `libwvhqefmz.so`, `libshadow.so` — native (32-bit ARM в arm64 path)

Runtime: `wgkqDvlG.a()` читает junk asset → `I2Wj0bzF` → `nativeCipher` → `cm0n62MK.apply()` загружает stage4 dex.

---

## Stage 4 — Stealer (com.base.template)

Распакован: `output/stage4/` (~1.5 MB `classes.dex`).

| Компонент | Назначение |
|-----------|------------|
| `TelegramPhishActivity` | WebView фиш Telegram |
| `OnboardingActivity` | PIN + onboarding (SMS default, VPN, battery) |
| `CommandService` | C2 command loop |
| `WsPersistManager` | WebSocket persistent (`/cable`) |
| `SmsFastSend` | exfil SMS/calls через HTTP JSON |
| `NativeBridge` + `libshadow.so` | C2 URLs, team_id, signing, USSD, proxy |
| `StealthVpnService` | VPN для обхода/защиты трафика |
| `ProxyService` | SOCKS/relay через C2 |
| `NotifListener` | перехват уведомлений |
| `FcmService` | Firebase push (fallback C2) |
| `BankPinScreens` | overlay PIN банков |

### C2 / IOC (из libshadow.so + dex)

| Тип | URL / path |
|-----|------------|
| Primary worker | `https://spring-bonus-4542.blackskripip.workers.dev` |
| Onboarding WebView | `http://robloxprem.com/` (`OnboardingConfig.WEBVIEW_URL`, dex) |
| WebSocket | `wss://.../cable` |
| Phish API | `/api/phish/start`, `/api/phish/verify`, `/api/phish/2fa` |
| SMS/API | `/api/` |
| Geo IP | `http://ip-api.com/json/?fields=query,country,countryCode,city,isp` |
| Firebase | project в `AppInit` (encrypted strings) |

Native lib: `libshadow.so` (arm64 + armeabi-v7a).

---

## Арtefакты

| Путь | Описание |
|------|----------|
| `output/stage2.zip` | Расшифрованный loader dex |
| `output/stage3_stealer.apk` | AES-decrypted payload |
| `output/stage3/stripped_junk.bin` | Junk asset после strip |
| `output/stage4.zip` | Финальный stealer APK (zip) |
| `output/stage4/jadx/` | Декомпил stage4 |
| `output/stage3/phish_tg.html` | Фиш UI |
| `unidbg/` | Эмуляция nativeCipher |

## Anti-analysis

- Zip paths 140+ nested `assets/ۦۖ۫/`
- Password-protected zip bomb в stage3
- Control-flow obfuscation + XOR string pools (short[])
- Native C2 config только в `libshadow.so`
- Fake Google Play / Telegram UI
- Trust-all TLS (`SmsFastSend`, `WsPersistManager`)
