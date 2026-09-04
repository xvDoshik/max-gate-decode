package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.SystemClock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class WakeLocks {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{99, 0, 94, 93, 127, 90, 1, 14, 71}, "4a5835be", true));
    }

    public static final PowerManager.WakeLock newWakeLock(Context context, String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService(C0000.decode(new byte[]{21, 87, 19, 82, 70}, "e8d745809d"));
        String strConcat = C0000.decode(new byte[]{103, 87, 66, 93, 40, 84, 88, 7, 87, 93, 66, 12, 69}, "0806e56f", 0.0f).concat(str);
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, strConcat);
        synchronized (WakeLocksHolder.INSTANCE) {
        }
        return wakeLockNewWakeLock;
    }
}
