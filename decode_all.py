#!/usr/bin/env python3
import re
import struct
import subprocess
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent
OUT = ROOT / 'output'
APK = Path(__import__('os').environ.get(
    'MAX_GATE_APK',
    str(ROOT / 'samples' / 'Max Gate Tg 2.1.apk'),
))

SHELL_KEY = '!no#vbrj^?:%1Co@'
AES_KEY = bytes.fromhex('c56ae8aa8f1e5aec2c15bcf1d4914dfde1832e3f6e146e85a8742b05443edb06')
STAGE3_KEY = 'HK{GZ%rkbBh9sYEO'


def se(x):
    x = x & 0xFFFF
    return x if x < 0x8000 else x - 0x10000


def parse_short_array(name, text):
    pat = 'private static short\\[\\] ' + name + ' = \\{([^;]+)\\};'
    m = re.search(pat, text, re.S)
    return [int(x.strip()) for x in m.group(1).split(',') if x.strip()]


def m350(arr, off, xor, ln):
    return ''.join(chr((se(arr[off + i]) ^ xor) & 0xFFFF) for i in range(ln))


def compute_stage3_key():
    base = OUT / 'stage3/jadx-all/sources/com/coresoft/safe'
    if not (base / 'OUHQwdrD.java').exists():
        return STAGE3_KEY
    ou = (base / 'OUHQwdrD.java').read_text(errors='ignore')
    yg = (base / 'yGhVwXcV.java').read_text(errors='ignore')
    f18 = parse_short_array('f18', ou)
    f52 = parse_short_array('f52', yg)
    p1 = m350(f18, 7, 877296148 ^ 1024489563, 8)
    p2 = m350(f52, 1163, 2063381446 ^ 808104718, 8)
    return p2 + p1


def strip_be(data: bytes) -> bytes:
    n = struct.unpack('>I', data[:4])[0]
    return data[n + 4:]


def junk_name(z: zipfile.ZipFile) -> str:
    return next(n for n in z.namelist() if 'ۦ' in n)


def native_shell(data: bytes, key: str, lib: Path, cls: str) -> bytes:
    jar = ROOT / 'unidbg/target/max-gate-decode-1.0.jar'
    if not jar.exists():
        subprocess.check_call(['mvn', '-q', '-f', str(ROOT / 'unidbg/pom.xml'), 'package', '-DskipTests'])
    tmp_in = OUT / 'tmp_native_in.bin'
    tmp_out = OUT / 'tmp_native_out.bin'
    tmp_in.write_bytes(data)
    if 'coresoft' in cls:
        subprocess.check_call([
            'java', '-cp', str(jar), 'local.DecodeCipherStage3',
            str(lib), str(tmp_in), key, str(tmp_out)
        ])
    else:
        subprocess.check_call([
            'java', '-jar', str(jar), str(tmp_in), key, str(tmp_out)
        ])
    return tmp_out.read_bytes()


def aes_payload_db(raw: bytes) -> bytes:
    from Crypto.Cipher import AES
    iv, ct = raw[:16], raw[16:]
    plain = AES.new(AES_KEY, AES.MODE_CBC, iv).decrypt(ct)
    pad = plain[-1]
    if 1 <= pad <= 16 and plain[-pad:] == bytes([pad]) * pad:
        plain = plain[:-pad]
    return plain


def main():
    OUT.mkdir(parents=True, exist_ok=True)
    if not APK.is_file():
        raise SystemExit(
            f'APK not found: {APK}\n'
            'Place sample in samples/ or set MAX_GATE_APK=/path/to/apk'
        )
    with zipfile.ZipFile(APK) as z:
        junk1 = z.read(junk_name(z))
        payload_db = z.read('assets/payload.db')

    s1 = strip_be(junk1)
    (OUT / 'stripped_payload.bin').write_bytes(s1)
    stage2 = native_shell(s1, SHELL_KEY, OUT / 'raw/lib/arm64-v8a/libcybqacsq.so', 'shell')
    (OUT / 'stage2.zip').write_bytes(stage2)
    print('[1→2] stage2', len(stage2), stage2[:2])

    stage3 = aes_payload_db(payload_db)
    (OUT / 'stage3_stealer.apk').write_bytes(stage3)
    print('[2→3] stage3 apk', len(stage3), stage3[:2])

    with zipfile.ZipFile(OUT / 'stage3_stealer.apk') as z:
        junk3 = z.read(junk_name(z))
        so = OUT / 'stage3/native/libwvhqefmz.so'
        so.parent.mkdir(parents=True, exist_ok=True)
        so.write_bytes(z.read('lib/arm64-v8a/libwvhqefmz.so'))

    s3 = strip_be(junk3)
    (OUT / 'stage3/stripped_junk.bin').write_bytes(s3)
    key3 = compute_stage3_key()
    (OUT / 'stage3_key.txt').write_text(key3)
    stage4 = native_shell(s3, key3, so, 'coresoft')
    (OUT / 'stage4.zip').write_bytes(stage4)
    print('[3→4] stage4', len(stage4), stage4[:2], 'key', repr(key3))

    if stage4[:2] == b'PK':
        dest = OUT / 'stage4'
        dest.mkdir(exist_ok=True)
        with zipfile.ZipFile(OUT / 'stage4.zip') as z:
            z.extractall(dest)
        print('extracted', len(list(dest.rglob('*'))), 'files to', dest)


if __name__ == '__main__':
    main()
