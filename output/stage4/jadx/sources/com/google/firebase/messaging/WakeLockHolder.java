package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class WakeLockHolder {
    public static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    public static final Object syncObject = new Object();
    public static WakeLock wakeLock;

    public static void checkAndInitWakeLock(Context context) {
        if (wakeLock == null) {
            WakeLock wakeLock2 = new WakeLock(context);
            wakeLock = wakeLock2;
            synchronized (wakeLock2.zzf) {
                wakeLock2.zzl = true;
            }
        }
    }

    public static void completeWakefulIntent(Intent intent) {
        synchronized (syncObject) {
            try {
                if (wakeLock != null && intent.getBooleanExtra(C0000.decode(new byte[]{6, 86, 85, 75, 4, 14, 95, 87, 89, 83, 29, 94, 80, 23, 0, 91, 89, 22, 6, 79, 89, 89, 81, 24, 100, 89, 82, 0, 41, 86, 91, 14, 43, 14, 92, 84, 80, 68, 29, 79, 88, 14, 0, 95, 77, 9, 10, 15, 68, 85, 91, 66}, "e98eca0056389e"), false)) {
                    intent.putExtra(C0000.decode(new byte[]{7, 91, 91, 31, 3, 13, 90, 5, 15, 87, 28, 83, 13, 19, 1, 86, 87, 66, 1, 76, 92, 11, 7, 28, 101, 84, 15, 4, 40, 91, 85, 90, 44, 13, 89, 6, 6, 64, 28, 66, 5, 10, 1, 82, 67, 93, 13, 12, 65, 7, 13, 70}, "d461db5bc225da", 0.0f), false);
                    wakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName startWakefulService(Context context, Intent intent) {
        synchronized (syncObject) {
            try {
                checkAndInitWakeLock(context);
                boolean booleanExtra = intent.getBooleanExtra(C0000.decode(new byte[]{82, 12, 93, 23, 85, 11, 94, 4, 92, 92, 28, 2, 88, 17, 85, 91, 83, 23, 84, 77, 89, 80, 86, 74, 102, 2, 91, 92, 126, 11, 82, 8, 120, 86, 94, 0, 84, 17, 30, 78, 83, 15, 84, 5, 69, 85, 91, 10, 69, 6, 94, 77}, "1c092d", 3), false);
                intent.putExtra(C0000.decode(new byte[]{1, 86, 12, 23, 1, 12, 87, 82, 90, 93, 29, 95, 11, 74, 4, 3, 3, 74, 4, 23, 15, 10, 92, 27, 97, 89, 88, 92, 46, 87, 2, 10, 42, 86, 13, 93, 3, 17, 22, 66, 87, 83, 86, 95, 23, 84, 8, 15, 22, 92, 15, 77}, "b9a9fc856839b8aa", false), true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!booleanExtra) {
                    wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
