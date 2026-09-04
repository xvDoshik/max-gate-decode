package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class TasksKt {
    public static final TaskContextImpl BlockingContext;
    public static final int CORE_POOL_SIZE;
    public static final String DEFAULT_SCHEDULER_NAME;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final TaskContextImpl NonBlockingContext;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static final NanoTimeSource schedulerTimeSource;

    static {
        String strDecode;
        String strDecode2 = C0000.decode(new byte[]{94, 11, 22, 85, 93, 13, 29, 74, 80, 13, 20, 9, 23, 69, 92, 10, 7, 74, 26, 16, 6, 12, 86, 6, 19, 10, 7, 67, 27, 0, 7, 95, 85, 22, 9, 16, 29, 12, 7, 11, 7}, "5db94ced3bffb1");
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            strDecode = System.getProperty(strDecode2);
        } catch (SecurityException unused) {
            strDecode = null;
        }
        if (strDecode == null) {
            strDecode = C0000.decode(new byte[]{112, 4, 85, 80, 66, 9, 71, 112, 89, 64, 18, 85, 70, 7, 92, 4, 65}, "4a317e3403b42d", 0.0f);
        }
        DEFAULT_SCHEDULER_NAME = strDecode;
        WORK_STEALING_TIME_RESOLUTION_NS = AtomicKt.systemProp(C0000.decode(new byte[]{13, 95, 22, 89, 89, 86, 73, 24, 5, 95, 16, 90, 69, 76, 88, 88, 3, 67, 76, 70, 83, 80, 84, 82, 19, 92, 7, 71, 30, 74, 84, 69, 9, 92, 23, 65, 89, 87, 95, 24, 8, 67}, "f0b50816", 0.0f), 100000L, 1L, Long.MAX_VALUE);
        int i2 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        if (i2 < 2) {
            i2 = 2;
        }
        CORE_POOL_SIZE = AtomicKt.systemProp$default(C0000.decode(new byte[]{92, 94, 70, 94, 90, 92, 74, 74, 84, 94, 64, 93, 70, 70, 91, 10, 82, 66, 28, 65, 80, 90, 87, 0, 66, 93, 87, 64, 29, 81, 93, 22, 82, 31, 66, 93, 92, 94, 28, 23, 94, 75, 87}, "7122322d", 0.0f), i2, 8);
        MAX_POOL_SIZE = AtomicKt.systemProp$default(C0000.decode(new byte[]{88, 88, 17, 88, 94, 93, 75, 25, 6, 91, 69, 92, 70, 67, 12, 90, 82, 64, 29, 68, 6, 92, 82, 87, 70, 91, 0, 70, 25, 94, 82, 79, 75, 68, 88, 92, 95, 25, 22, 93, 77, 86}, "37e473"), 2097150, 4);
        IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(AtomicKt.systemProp(C0000.decode(new byte[]{89, 14, 76, 94, 81, 92, 29, 31, 87, 11, 16, 94, 67, 64, 80, 93, 87, 18, 22, 65, 91, 90, 0, 85, 65, 8, 7, 67, 24, 95, 92, 86, 66, 79, 89, 94, 81, 68, 0, 31, 71, 1, 1}, "2a8282e14db16493", 0.0f), 60L, 1L, Long.MAX_VALUE));
        schedulerTimeSource = NanoTimeSource.INSTANCE;
        NonBlockingContext = new TaskContextImpl(0);
        BlockingContext = new TaskContextImpl(1);
    }
}
