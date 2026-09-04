# TODO — куда копать дальше

## Decode / RE

- [ ] Достать `team_id` + HMAC secret из `libshadow.so` (unidbg / frida на девайсе)
- [ ] Расшифровать fallback URL list (`nativeGetFallbackUrlAt`)
- [ ] Полный runtime dump `NativeBridge.getAllUrls()` на эмуляторе
- [ ] Repack stage3 без zip-bomb `.fn/` entry
- [ ] Автоматизировать jadx/apktool в `decode_all.py`

## C2 / infra

- [ ] Обход CF 403 на `/v1/*` Workers (mobile fingerprint + valid `_sg`)
- [ ] Перехват live `_sg` с заражённого девайса / MITM
- [ ] Мониторинг `robloxprem.com` `/jphone/{id}` enumeration
- [ ] Firebase `app-push-service-ca920` — FCM topic / admin API (если ключи утекут)
- [ ] Карта panel UI Workers (если CF пропустит)

## Intel

- [ ] IOC pack для SIEM (paths, cookies, domains)
- [ ] YARA: `libshadow.so`, dex string pools
- [ ] Сравнить версии APK (другие build'ы Max Gate)

## Done

- [x] 4-stage decode pipeline
- [x] stage4 jadx + ANALYSIS.md
- [x] C2 endpoint map + pentest probe
- [x] robloxprem.com onboarding phish
