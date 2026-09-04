package com.google.android.gms.internal.base;

import android.os.Build;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zal {
    public static final int zaa;

    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = 33554432;
        if (i < 31) {
            if (i >= 30) {
                String str = Build.VERSION.CODENAME;
                if (str.length() != 1 || str.charAt(0) < 'S' || str.charAt(0) > 'Z') {
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
        }
        zaa = i2;
    }
}
