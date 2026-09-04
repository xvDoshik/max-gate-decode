EN | [RU](docs/README_RU.md)

## max-gate-decode 📦

![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

**4-stage Android dropper → stealer** decode pipeline with unidbg native decryptors, stage4 jadx dump, and C2 probe artifacts.

Sample: **Max Gate Tg 2.1.apk** (`com.mobilex.hub` → `com.coresoft.safe` → `com.base.template`). APK is not in the repo — see [samples/](samples/).

Distribution (scammer channel): [@getmaxtg](https://t.me/getmaxtg) — **Max Gate Tg+Max**, ~15k subs.

Full RE write-up: [ANALYSIS.md](ANALYSIS.md) · Pentest: [c2-pentest/output/PENTEST-REPORT.md](c2-pentest/output/PENTEST-REPORT.md)

---

## ✨ Highlights

| | |
|---|---|
| **4-stage chain** | Shell → AES payload → obfuscated loader → final stealer APK |
| **Native crypto** | `libcybqacsq.so` (arm64) + `libwvhqefmz.so` (32-bit) via unidbg |
| **Stage4 RE** | Decompiled `com.base.template` — SMS exfil, phish WebView, FCM, WS |
| **C2 map** | Workers `/v1/*`, onboarding host `robloxprem.com`, Firebase wake channel |
| **Pentest probes** | External curl/WS matrix + robloxprem session poll |

---

## 🔄 Decode pipeline

| Stage | Input | Method | Key / skip |
|-------|-------|--------|------------|
| 1→2 | junk asset (BE header) | `libcybqacsq.so` unidbg arm64 | `!no#vbrj^?:%1Co@`, skip **149** |
| 2→3 | `assets/payload.db` | AES-CBC PKCS5 | key in `decode_all.py`, IV = first 16 B |
| 3→4 | stage3 junk asset | `libwvhqefmz.so` unidbg **32-bit** | `HK{GZ%rkbBh9sYEO` (part2+part1 reversed), skip **408** |

Output: `output/stage4.zip` — final stealer APK (+ extracted tree under `output/stage4/`).

---

## 🚀 Quick start

### Requirements

- Python **3.10+**
- Java **17**, Maven **3**

### Run

```bash
git clone <repo-url> max-gate-decode
cd max-gate-decode

python3 -m venv .venv && source .venv/bin/activate
pip install -r requirements.txt

cp "/path/to/Max Gate Tg 2.1.apk" samples/

cd unidbg && mvn -q package -DskipTests && cd ..
python3 decode_all.py
```

Override sample path:

```bash
export MAX_GATE_APK=samples/Max\ Gate\ Tg\ 2.1.apk
```

Manual stage3→4 (if needed):

```bash
java -cp unidbg/target/max-gate-decode-1.0.jar local.DecodeCipherStage3 \
  output/stage3/native/libwvhqefmz.so \
  output/stage3/stripped_junk.bin 'HK{GZ%rkbBh9sYEO' output/stage4.zip
```

---

## 📁 Repository structure

```
max-gate-decode/
├── decode_all.py              # full 1→4 pipeline
├── decode_stage2_strings.py   # C0000 string decoder helper
├── decode_native.py
├── unidbg/                    # DecodeCipher + DecodeCipherStage3
├── output/
│   ├── stage2.zip
│   ├── stage3_stealer.apk
│   ├── stage4.zip
│   ├── stage4/jadx/           # stealer decompile
│   └── stage3/                # stage3 RE artifacts
├── c2-pentest/
│   ├── probe_c2.py
│   └── output/                # probe JSON + reports
├── ANALYSIS.md                # full malware breakdown (RU)
└── samples/                   # place APK here
```

---

## 🌐 C2 & exfil

| Role | URL / path |
|------|------------|
| Scammer TG channel | [@getmaxtg](https://t.me/getmaxtg) |
| Primary worker | `https://spring-bonus-4542.blackskripip.workers.dev` |
| Onboarding WebView | `http://robloxprem.com/` |
| SMS / events | `POST /v1/events` |
| Register / telemetry | `/v1/init`, `/v1/sync`, `/v1/telemetry` |
| PIN / phone / contacts | `/v1/pin`, `/v1/phone`, `/v1/contacts`, `/v1/ack` |
| In-app TG phish API | `/api/phish/start`, `/api/phish/2fa`, `/api/phish/verify` |
| WebSocket | `wss://…/cable` |
| FCM project | `app-push-service-ca920` (wake / heartbeat, not log storage) |

Auth on worker HTTP:

```
Cookie: _ts=<unix_sec>; _sg=<HmacSHA256(team_id + ts)>
```

Team credentials and fallback URLs live in `libshadow.so` (`nativeGetTeamId`, `nativeGetFallbackUrl*`).

---

## 🔍 C2 pentest

```bash
cd c2-pentest
python3 probe_c2.py
```

Probe notes (2026-09-04): Workers `/v1/*` → CF 403 from desktop; `robloxprem.com` → live onboarding phish, unauth `GET /jphone/{id}` poll.

---

## 🔒 Security

- **Do not commit:** sample APK, live `_sg` cookies, victim data, `.env`
- Archive contains **decoded malware** and IOCs — handle in isolated lab only
- Pentest probes are passive enumeration; no authorization bypass attempted without valid implant creds

---

## 📜 License

Archive for studying and restoring **your own** malware samples and defensive research in permitted scope.
