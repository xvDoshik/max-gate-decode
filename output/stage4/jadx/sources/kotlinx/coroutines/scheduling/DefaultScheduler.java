package kotlinx.coroutines.scheduling;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;

    static {
        int i = TasksKt.CORE_POOL_SIZE;
        int i2 = TasksKt.MAX_POOL_SIZE;
        long j = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        String str = TasksKt.DEFAULT_SCHEDULER_NAME;
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        defaultScheduler.coroutineScheduler = new CoroutineScheduler(i, i2, j, str);
        INSTANCE = defaultScheduler;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 12, 23, 71, 3, 71, 90, 89, 86, 23, 23, 25, 38, 86, 95, 80, 70, 9, 16, 23, 1, 82, 87, 95, 92, 17, 68, 85, 7, 19, 90, 93, 92, 22, 1, 83}, "3ed7b391"));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return C0000.decode(new byte[]{119, 10, 71, 69, 82, 65, 2, 88, 92, 75, 69, 79, 113, 80, 2, 7, 70, 15, 64}, "3c4535a0996a55df");
    }
}
