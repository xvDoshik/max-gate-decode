package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final DefaultExecutor INSTANCE;
    public static final long KEEP_ALIVE_NANOS;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        defaultExecutor.incrementUseCount(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong(C0000.decode(new byte[]{9, 91, 70, 94, 90, 94, 26, 26, 81, 93, 65, 95, 23, 64, 91, 92, 86, 67, 76, 112, 87, 84, 82, 69, 14, 64, 119, 74, 86, 83, 23, 64, 93, 64, 29, 91, 7, 81, 66, 115, 95, 89, 20, 81}, "b42230", 0.0f), 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void acknowledgeShutdownIfNeeded() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            EventLoopImplBase._queue$FU.set(this, null);
            EventLoopImplBase._delayed$FU.set(this, null);
            notifyAll();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final void enqueue(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException(C0000.decode(new byte[]{115, 80, 82, 5, 65, 90, 16, 124, 79, 80, 87, 17, 64, 89, 22, 25, 64, 84, 71, 68, 71, 94, 17, 77, 23, 81, 91, 19, 90, 24, 68, 109, 95, 92, 71, 68, 81, 68, 22, 86, 69, 21, 93, 10, 80, 95, 7, 88, 67, 80, 71, 68, 64, 94, 5, 77, 23, 113, 93, 23, 68, 87, 16, 90, 95, 80, 70, 23, 26, 69, 12, 76, 67, 81, 91, 19, 90, 30, 77, 25, 64, 84, 71, 68, 93, 88, 18, 86, 92, 80, 80, 68, 68, 68, 13, 86, 69, 21, 64, 11, 20, 85, 11, 84, 71, 89, 81, 16, 93, 89, 10, 25, 88, 83, 20, 1, 76, 95, 16, 80, 89, 82, 20, 7, 91, 68, 11, 76, 67, 92, 90, 1, 71, 26, 68, 85, 82, 84, 66, 13, 90, 81, 68, 90, 88, 71, 91, 17, 64, 95, 10, 92, 68, 21, 93, 10, 20, 95, 10, 90, 88, 88, 68, 8, 81, 66, 1, 25, 68, 65, 85, 16, 81, 24, 68, 105, 91, 80, 85, 23, 81, 22, 22, 92, 81, 80, 70, 68, 64, 89, 68, 125, 94, 70, 68, 5, 64, 85, 12, 92, 69, 70, 26, 23, 92, 67, 16, 93, 88, 66, 90, 68, 80, 89, 7, 76, 90, 80, 90, 16, 85, 66, 13, 86, 89, 21, 82, 11, 70, 22, 9, 86, 69, 80, 20, 0, 81, 66, 5, 80, 91, 70}, "754d46d9", 2));
        }
        super.enqueue(runnable);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final Thread getThread() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, C0000.decode(new byte[]{88, 91, 18, 85, 8, 89, 73, 31, 1, 10, 65, 91, 19, 77, 8, 89, 84, 66, 76, 33, 86, 82, 7, 76, 13, 67, 116, 73, 7, 6, 70, 64, 9, 75}, "34f9a711be", 0.0f));
                _thread = thread;
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadLocalEventLoop.ref.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    _thread = null;
                    acknowledgeShutdownIfNeeded();
                    if (isEmpty()) {
                        return;
                    }
                    getThread();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jProcessNextEvent = processNextEvent();
                    if (jProcessNextEvent == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = KEEP_ALIVE_NANOS + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            if (isEmpty()) {
                                return;
                            }
                            getThread();
                            return;
                        }
                        if (jProcessNextEvent > j2) {
                            jProcessNextEvent = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jProcessNextEvent > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            if (isEmpty()) {
                                return;
                            }
                            getThread();
                            return;
                        }
                        LockSupport.parkNanos(this, jProcessNextEvent);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            if (!isEmpty()) {
                getThread();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoopImplPlatform
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
