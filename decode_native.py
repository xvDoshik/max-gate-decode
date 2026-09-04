#!/usr/bin/env python3
from pathlib import Path
from elftools.elf.elffile import ELFFile
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM

SO = Path('/Users/xv/pin2/max-gate-apk/output/raw/lib/arm64-v8a/libcybqacsq.so')
elf = ELFFile(open(SO, 'rb'))
md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)

syms = {}
for sec in elf.iter_sections():
    if sec.header['sh_type'] not in ('SHT_SYMTAB', 'SHT_DYNSYM'):
        continue
    for s in sec.iter_symbols():
        if s.name and s['st_value']:
            syms[s.name] = s['st_value']

text = elf.get_section_by_name('.text')
base = text['sh_addr']
code = text.data()

for name in ['JNI_OnLoad', 'library_entry', 'JNI_OnUnload']:
    if name not in syms:
        print('missing', name)
        continue
    va = syms[name]
    off = va - base
    print(f'=== {name} @ 0x{va:x} (text+0x{off:x}) ===')
    chunk = code[off:off + 512]
    for ins in md.disasm(chunk, va):
        print(f'0x{ins.address:x}:\t{ins.mnemonic}\t{ins.op_str}')
    print()
