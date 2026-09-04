[EN](../README.md) | RU

## max-gate-decode 📦

![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

**4-ступенчатый Android dropper → stealer** — пайплайн декода с unidbg, дамп stage4 jadx и артефакты C2-проб.

Семпл: **Max Gate Tg 2.1.apk** (`com.mobilex.hub` → `com.coresoft.safe` → `com.base.template`). APK в репо нет — [samples/](../samples/).

Канал распространения: [@getmaxtg](https://t.me/getmaxtg) — **Max Gate Tg+Max**, ~15k подписчиков.

Полный разбор: [ANALYSIS.md](../ANALYSIS.md) · Пентest: [c2-pentest/output/PENTEST-REPORT.md](../c2-pentest/output/PENTEST-REPORT.md)

---

## ✨ Основное

| | |
|---|---|
| **4 стадии** | Shell → AES payload → obfuscated loader → финальный stealer |
| **Native crypto** | `libcybqacsq.so` (arm64) + `libwvhqefmz.so` (32-bit) через unidbg |
| **Stage4 RE** | Декомпил `com.base.template` — SMS, phish WebView, FCM, WS |
| **C2** | Workers `/v1/*`, onboarding `robloxprem.com`, Firebase wake |
| **Пентest** | curl/WS матрица + robloxprem `/jphone/{id}` |

---

## 🔄 Пайплайн декода

| Стадия | Вход | Метод | Ключ / skip |
|--------|------|-------|-------------|
| 1→2 | junk asset (BE header) | `libcybqacsq.so` unidbg arm64 | `!no#vbrj^?:%1Co@`, skip **149** |
| 2→3 | `assets/payload.db` | AES-CBC PKCS5 | ключ в `decode_all.py`, IV = первые 16 B |
| 3→4 | junk asset stage3 | `libwvhqefmz.so` unidbg **32-bit** | `HK{GZ%rkbBh9sYEO` (part2+part1 reversed), skip **408** |

Результат: `output/stage4.zip` — финальный stealer APK.

---

## 🚀 Quick start

### Требования

- Python **3.10+**
- Java **17**, Maven **3**

### Запуск

```bash
git clone <repo-url> max-gate-decode
cd max-gate-decode

python3 -m venv .venv && source .venv/bin/activate
pip install -r requirements.txt

cp "/path/to/Max Gate Tg 2.1.apk" samples/

cd unidbg && mvn -q package -DskipTests && cd ..
python3 decode_all.py
```

Путь к APK:

```bash
export MAX_GATE_APK=samples/Max\ Gate\ Tg\ 2.1.apk
```

Ручной stage3→4:

```bash
java -cp unidbg/target/max-gate-decode-1.0.jar local.DecodeCipherStage3 \
  output/stage3/native/libwvhqefmz.so \
  output/stage3/stripped_junk.bin 'HK{GZ%rkbBh9sYEO' output/stage4.zip
```

---

## 📁 Структура

```
max-gate-decode/
├── decode_all.py
├── unidbg/
├── output/stage4/jadx/
├── c2-pentest/
├── ANALYSIS.md
└── samples/
```

---

## 🌐 C2 & exfil

| Роль | URL / path |
|------|------------|
| TG-канал | [@getmaxtg](https://t.me/getmaxtg) |
| Workers C2 | `https://spring-bonus-4542.blackskripip.workers.dev` |
| Onboarding | `http://robloxprem.com/` |
| SMS | `POST /v1/events` |
| Регистрация | `/v1/init`, `/v1/sync`, `/v1/telemetry` |
| PIN / phone / contacts | `/v1/pin`, `/v1/phone`, `/v1/contacts`, `/v1/ack` |
| TG phish (in-app) | `/api/phish/start`, `/api/phish/2fa`, `/api/phish/verify` |
| WebSocket | `wss://…/cable` |
| FCM | `app-push-service-ca920` |

Auth:

```
Cookie: _ts=<unix_sec>; _sg=<HmacSHA256(team_id + ts)>
```

`team_id` и fallback URL — в `libshadow.so`.

---

## 🔍 C2 pentest

```bash
cd c2-pentest && python3 probe_c2.py
```

Workers `/v1/*` — CF 403 с desktop; `robloxprem.com` — живой onboarding phish.

---

## 🔒 Security

- Не коммить APK, live `_sg`, данные жертв
- Декодированный malware — только изолированная лаборатория

---

## 📜 License

Архив для изучения **своих** семплов и defensive research в разрешённом scope.
