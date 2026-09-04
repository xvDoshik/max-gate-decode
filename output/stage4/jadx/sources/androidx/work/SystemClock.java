package androidx.work;

import java.util.Collections;
import java.util.List;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemClock {
    public static volatile SystemClock sLogger;
    public static final Object sLock = new Object();
    public static final SystemClock INSTANCE = new SystemClock();

    public SystemClock() {
        List list = Collections.EMPTY_LIST;
    }

    public static SystemClock get() {
        SystemClock systemClock;
        synchronized (sLock) {
            try {
                if (sLogger == null) {
                    sLogger = new SystemClock();
                }
                systemClock = sLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemClock;
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append(C0000.decode(new byte[]{110, 46, 73}, "9cd227cf"));
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }
}
