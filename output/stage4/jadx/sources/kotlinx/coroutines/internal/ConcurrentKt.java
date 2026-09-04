package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConcurrentKt {
    public static final Method REMOVE_FUTURE_ON_CANCEL;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod(C0000.decode(new byte[]{75, 87, 77, 98, 3, 85, 86, 20, 85, 43, 86, 123, 2, 90, 6, 4, 84, 98, 86, 92, 15, 91, 64}, "8290f89b0d88c4ea", true), Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        REMOVE_FUTURE_ON_CANCEL = method;
    }
}
