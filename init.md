# Max Gate Tg 2.1.apk

Entry point: [README.md](README.md)

Sample: `samples/Max Gate Tg 2.1.apk` or `MAX_GATE_APK=...`

## Quick

| | |
|-|-|
| Shell package | `com.mobilex.hub` |
| Stealer package | `com.base.template` (runtime) |
| Type | **4-stage dropper + stealer** |
| Final C2 | `https://spring-bonus-4542.blackskripip.workers.dev` |

Полный отчёт: [ANALYSIS.md](ANALYSIS.md)

## Decode

```bash
cd max-gate-apk
python3 decode_all.py
```

## Stages

1. Shell → native → `output/stage2.zip`
2. AES `payload.db` → `output/stage3_stealer.apk`
3. Stage3 junk asset → native → `output/stage4.zip` (реальный stealer)

## Keys

- Stage1 native: `!no#vbrj^?:%1Co@`
- Stage2 AES: `c56ae8aa8f1e5aec2c15bcf1d4914dfde1832e3f6e146e85a8742b05443edb06`
- Stage3 native: `HK{GZ%rkbBh9sYEO`
