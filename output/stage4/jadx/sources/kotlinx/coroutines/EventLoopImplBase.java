package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;
    public static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, C0000.decode(new byte[]{109, 20, 16, 87, 66, 3}, "2ee27f1edd35d5", true));
    public static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, C0000.decode(new byte[]{108, 2, 80, 91, 5, 31, 84, 1}, "3f57df1e", 6));
    public static final AtomicIntegerFieldUpdater _isCompleted$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, C0000.decode(new byte[]{104, 92, 70, 32, 10, 93, 71, 89, 80, 23, 0, 84}, "755ce0", 0.0f));

    public abstract class DelayedTaskQueue extends ThreadSafeHeap {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (_isCompleted$FU.get(this) == 0) {
                if (obj == null) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == null);
                } else if (obj instanceof LockFreeTaskQueueCore) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                    int iAddLast = lockFreeTaskQueueCore.addLast(runnable);
                    if (iAddLast == 0) {
                        break;
                    }
                    if (iAddLast == 1) {
                        LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                        }
                    } else if (iAddLast != 2) {
                    }
                } else if (obj != BuildersKt.CLOSED_EMPTY) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                    lockFreeTaskQueueCore2.addLast((Runnable) obj);
                    lockFreeTaskQueueCore2.addLast(runnable);
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                }
            }
            DefaultExecutor.INSTANCE.enqueue(runnable);
            return;
        }
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            LockSupport.unpark(thread);
        }
    }

    public final boolean isEmpty() {
        ArrayDeque arrayDeque = this.unconfinedQueue;
        if (arrayDeque != null ? arrayDeque.isEmpty() : true) {
            Object obj = _queue$FU.get(this);
            if (obj != null) {
                if (obj instanceof LockFreeTaskQueueCore) {
                    long j = LockFreeTaskQueueCore._state$FU.get((LockFreeTaskQueueCore) obj);
                    return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
                }
                if (obj == BuildersKt.CLOSED_EMPTY) {
                }
            }
            return true;
        }
        return false;
    }

    public final long processNextEvent() {
        Runnable runnable;
        if (!processUnconfinedEvent()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                runnable = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof LockFreeTaskQueueCore) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                    Object objRemoveFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                    if (objRemoveFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                        runnable = (Runnable) objRemoveFirstOrNull;
                        break;
                    }
                    LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                    }
                } else {
                    if (obj == BuildersKt.CLOSED_EMPTY) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                            runnable = (Runnable) obj;
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                }
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            ArrayDeque arrayDeque = this.unconfinedQueue;
            if (((arrayDeque == null || arrayDeque.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object obj2 = _queue$FU.get(this);
                if (obj2 == null) {
                } else if (obj2 instanceof LockFreeTaskQueueCore) {
                    long j = LockFreeTaskQueueCore._state$FU.get((LockFreeTaskQueueCore) obj2);
                    if (((int) (1073741823 & j)) != ((int) ((j & 1152921503533105152L) >> 30))) {
                        return 0L;
                    }
                } else if (obj2 == BuildersKt.CLOSED_EMPTY) {
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public void shutdown() {
        ThreadLocalEventLoop.ref.set(null);
        _isCompleted$FU.set(this, 1);
        Symbol symbol = BuildersKt.CLOSED_EMPTY;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).close();
                break;
            } else {
                if (obj == symbol) {
                    break;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (processNextEvent() <= 0) {
        }
        System.nanoTime();
    }
}
