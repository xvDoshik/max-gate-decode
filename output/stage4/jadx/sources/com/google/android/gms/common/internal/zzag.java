package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zzag {
    public static final Object zza = new Object();
    public static boolean zzb;
    public static int zzd;

    public static void checkHandlerThread(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : C0000.decode(new byte[]{92, 77, 94, 15, 18, 82, 71, 74, 64, 6, 92, 69, 18, 84, 93, 12, 66, 84, 64}, "282c21", 3);
            throw new IllegalStateException(C0000.decode(new byte[]{41, 17, 67, 17, 17, 83, 80, 23, 2, 89, 8, 8, 85, 1, 17, 94, 91, 23}, "dd0e1157a8") + handler.getLooper().getThread().getName() + C0000.decode(new byte[]{65, 17, 91, 17, 87, 5, 83, 74, 22, 81, 64, 69, 68, 85, 14, 77, 65}, "ae3c2d7f6351d2a9") + name + C0000.decode(new byte[]{76}, "b5f3e89f", 0.0f));
        }
    }

    public static void checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{33, 92, 19, 82, 95, 21, 98, 71, 70, 15, 91, 80, 17, 13, 21, 21, 0, 90, 65, 65, 72, 19, 91, 20, 21, 89, 68, 8, 10}, "f5e715134f571d"));
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException(C0000.decode(new byte[]{87, 76, 89, 10, 70, 64, 80, 0, 92, 75, 80, 8, 5, 87}, "995ff25f"));
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void checkNotEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }
}
