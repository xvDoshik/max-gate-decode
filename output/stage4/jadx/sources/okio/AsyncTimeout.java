package okio;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static final Condition condition;
    public static AsyncTimeout head;
    public static final ReentrantLock lock;
    public boolean inQueue;
    public AsyncTimeout next;
    public long timeoutAt;

    public final class Watchdog extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    ReentrantLock reentrantLock = AsyncTimeout.lock;
                    reentrantLock.lock();
                    try {
                        AsyncTimeout asyncTimeoutAwaitTimeout$okio = Options.Companion.awaitTimeout$okio();
                        if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            reentrantLock.unlock();
                            return;
                        } else {
                            reentrantLock.unlock();
                            if (asyncTimeoutAwaitTimeout$okio != null) {
                                asyncTimeoutAwaitTimeout$okio.timedOut();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        condition = reentrantLock.newCondition();
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void enter() {
        AsyncTimeout asyncTimeout;
        long j = this.timeoutNanos;
        boolean z = this.hasDeadline;
        if (j != 0 || z) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.inQueue) {
                    throw new IllegalStateException(C0000.decode(new byte[]{99, 91, 1, 89, 9, 81, 13, 90, 83, 81, 67, 93, 11, 68, 6, 75, 25, 80, 27, 81, 17}, "65c8e0c9", true));
                }
                this.inQueue = true;
                if (head == null) {
                    head = new AsyncTimeout();
                    Watchdog watchdog = new Watchdog(C0000.decode(new byte[]{46, 95, 80, 10, 65, 97, 5, 77, 84, 12, 5, 91, 94}, "a49ea6d97d", 0.0f));
                    watchdog.setDaemon(true);
                    watchdog.start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z) {
                    this.timeoutAt = Math.min(j, deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    this.timeoutAt = j + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    this.timeoutAt = deadlineNanoTime();
                }
                long j2 = this.timeoutAt - jNanoTime;
                AsyncTimeout asyncTimeout2 = head;
                while (true) {
                    asyncTimeout = asyncTimeout2.next;
                    if (asyncTimeout == null || j2 < asyncTimeout.timeoutAt - jNanoTime) {
                        break;
                        break;
                    }
                    asyncTimeout2 = asyncTimeout;
                }
                this.next = asyncTimeout;
                asyncTimeout2.next = this;
                if (asyncTimeout2 == head) {
                    condition.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (!this.inQueue) {
                return false;
            }
            this.inQueue = false;
            AsyncTimeout asyncTimeout = head;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.next;
                if (asyncTimeout2 == this) {
                    asyncTimeout.next = this.next;
                    this.next = null;
                    return false;
                }
                asyncTimeout = asyncTimeout2;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void timedOut() {
    }
}
