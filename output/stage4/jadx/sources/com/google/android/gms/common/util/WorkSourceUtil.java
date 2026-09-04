package com.google.android.gms.common.util;

import android.os.Build;
import android.os.Process;
import android.os.WorkSource;
import java.lang.reflect.Method;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class WorkSourceUtil {
    public static final Method zzb;
    public static final Method zzc;

    static {
        Method method;
        Method method2;
        String strDecode = C0000.decode(new byte[]{4, 7, 84}, "ec0f825df49d", 6);
        Class cls = Integer.TYPE;
        Process.myUid();
        try {
            method = WorkSource.class.getMethod(strDecode, cls);
        } catch (Exception unused) {
            method = null;
        }
        zzb = method;
        try {
            method2 = WorkSource.class.getMethod(strDecode, cls, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        zzc = method2;
        try {
            WorkSource.class.getMethod(C0000.decode(new byte[]{66, 90, 79, 4}, "135acbe02227f6bd", 0.0f), null);
        } catch (Exception unused3) {
        }
        try {
            WorkSource.class.getMethod(C0000.decode(new byte[]{6, 84, 68}, "a10dba5537e5", true), cls);
        } catch (Exception unused4) {
        }
        try {
            WorkSource.class.getMethod(C0000.decode(new byte[]{1, 0, 23, 44, 3, 91, 86}, "fecbb63a9c4f3a0a", 0.0f), cls);
        } catch (Exception unused5) {
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WorkSource.class.getMethod(C0000.decode(new byte[]{0, 66, 3, 89, 64, 86, 54, 11, 17, 91, 37, 80, 85, 90, 15}, "c0f843ad", 0.0f), null);
            } catch (Exception unused6) {
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class.forName(C0000.decode(new byte[]{81, 86, 92, 69, 11, 88, 86, 23, 95, 75, 22, 96, 11, 67, 89, 106, 95, 77, 74, 84, 1, 21, 101, 86, 66, 83, 123, 95, 5, 88, 92}, "0887d129", 0.0f)).getMethod(C0000.decode(new byte[]{84, 0, 83, 122, 12, 92, 80}, "5d74c8", 0.0f), cls, String.class);
            } catch (Exception unused7) {
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WorkSource.class.getMethod(C0000.decode(new byte[]{88, 74, 114, 14, 20, 16, 75}, "197cdd2f05", false), null).setAccessible(true);
            } catch (Exception unused8) {
            }
        }
    }
}
