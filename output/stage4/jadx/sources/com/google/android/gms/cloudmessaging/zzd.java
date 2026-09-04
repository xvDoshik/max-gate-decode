package com.google.android.gms.cloudmessaging;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzd extends ClassLoader {
    @Override // java.lang.ClassLoader
    public final Class loadClass(String str, boolean z) {
        String strDecode = C0000.decode(new byte[]{2, 12, 93, 79, 3, 92, 9, 1, 13, 6, 30, 0, 10, 87, 20, 9, 8, 7, 30, 6, 9, 64, 72, 15, 8, 7, 30, 44, 1, 64, 21, 3, 15, 4, 85, 19, 39, 92, 11, 22, 0, 23}, "ac0ad3ff", 0.0f);
        if (str != strDecode) {
            return (str == null || !str.equals(strDecode)) ? super.loadClass(str, z) : zze.class;
        }
        return zze.class;
    }
}
