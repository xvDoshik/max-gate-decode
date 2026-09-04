#!/usr/bin/env python3
import re
from pathlib import Path

ROOT = Path('/Users/xv/pin2/max-gate-apk/output/stage2/jadx/sources')

def decode(b, s):
    b = bytearray(b)
    for i in range(len(b)):
        b[i] ^= ord(s[i % len(s)])
    return bytes(b).decode('utf-8', errors='replace')

def parse_bytes(raw):
    return [int(x.strip()) & 0xFF for x in raw.split(',') if x.strip()]

interesting = []
for jf in ROOT.rglob('*.java'):
    text = jf.read_text(errors='ignore')
    for m in re.finditer(r'C0000\.decode\(new byte\[\]\{([^}]+)\},\s*"([^"]+)"(?:,\s*[^)]+)?\)', text):
        bs, key = m.groups()
        s = decode(parse_bytes(bs), key)
        if any(x in s.lower() for x in ['http', '.com', '.ru', 'aes', 'payload', 'stealer', 'coresoft', 'telegram', 'package', 'com.', '/']):
            interesting.append((jf.relative_to(ROOT), s))

for path, s in sorted(set(interesting)):
    print(f'{path}: {s!r}')

print('\n--- PayloadInstaller constants ---')
pi = (ROOT / 'com/template/shellapp/PayloadInstaller.java').read_text()
for name in ['AES_KEY_HEX', 'ASSET_NAME', 'TARGET_PKG', 'PAYLOAD_TYPE', 'TAG']:
    m = re.search(rf'{name} = C0000\.decode\(new byte\[\]\{{([^}}]+)\}}, "([^"]+)"(?:,\s*[^)]+)?\)', pi)
    if m:
        print(name, repr(decode(parse_bytes(m.group(1)), m.group(2))))

PY