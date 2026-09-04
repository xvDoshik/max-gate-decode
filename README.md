# Max Gate Tg 2.1 — decode & C2 research

4-stage Android dropper → stealer (`com.mobilex.hub` → `com.coresoft.safe` → `com.base.template`).

**Sample:** `Max Gate Tg 2.1.apk` (не в репо, см. [samples/](samples/))

## Quick start

```bash
# deps
python3 -m venv .venv && source .venv/bin/activate
pip install -r requirements.txt

# положи APK
cp "/path/to/Max Gate Tg 2.1.apk" samples/

# native decoder (Java 17 + Maven)
cd unidbg && mvn -q package -DskipTests && cd ..

# full pipeline
python3 decode_all.py
```

Env override:

```bash
export MAX_GATE_APK=samples/Max\ Gate\ Tg\ 2.1.apk
```

## Pipeline

| Stage | Input | Method | Key / skip |
|-------|-------|--------|------------|
| 1→2 | junk asset BE header | `libcybqacsq.so` arm64 unidbg | `!no#vbrj^?:%1Co@`, skip **149** |
| 2→3 | `assets/payload.db` | AES-CBC PKCS5 | hex key в `decode_all.py`, IV=first 16 B |
| 3→4 | stage3 junk BE | `libwvhqefmz.so` **32-bit** unidbg | `HK{GZ%rkbBh9sYEO` (part2+part1 reversed), skip **408** |

Output: `output/stage4.zip` → финальный stealer APK.

## Repo layout

```
decode_all.py          # главный скрипт decode
decode_stage2_strings.py
decode_native.py
unidbg/                # nativeCipher эмуляция (DecodeCipher + DecodeCipherStage3)
output/
  stage2.zip           # loader dex
  stage3_stealer.apk   # AES payload
  stage4.zip           # stealer
  stage4/jadx/         # декомпил stealer (com.base.template)
  stage3/              # промежуточный stage3 RE
c2-pentest/            # probe C2 + robloxprem
ANALYSIS.md            # полный разбор
TODO.md                # что делать дальше
```

## IOC (кратко)

| | |
|-|-|
| Workers C2 | `https://spring-bonus-4542.blackskripip.workers.dev` |
| Onboarding phish | `http://robloxprem.com/` |
| Exfil paths | `/v1/events`, `/v1/init`, `/v1/sync`, `/v1/telemetry`, `/v1/phone`, `/v1/pin`, `/v1/contacts`, `/v1/ack` |
| Auth | `Cookie: _ts=<unix>; _sg=<HmacSHA256>` |
| FCM project | `app-push-service-ca920` |

Подробнее: [ANALYSIS.md](ANALYSIS.md), [c2-pentest/output/PENTEST-REPORT.md](c2-pentest/output/PENTEST-REPORT.md).

## C2 pentest

```bash
cd c2-pentest
python3 probe_c2.py
```

## Требования

- Python 3.10+
- Java 17, Maven 3
- jadx/apktool — опционально, jadx output уже в `output/`

## Contributing

1. Форк / clone
2. Ветка от `main`
3. PR с описанием что нашёл и как воспроизвести
4. Не коммить APK, ключи жертв, live `_sg`

Следующие задачи: [TODO.md](TODO.md)
