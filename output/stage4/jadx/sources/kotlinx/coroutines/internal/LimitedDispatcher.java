package kotlinx.coroutines.internal;

import androidx.work.Worker;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.scheduling.UnlimitedIoScheduler;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    public static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, C0000.decode(new byte[]{75, 16, 90, 95, 89, 92, 80, 111, 89, 70, 92, 86, 75, 22}, "9e4102786473", 0.0f));
    public final int parallelism;
    public final LockFreeTaskQueue queue;
    private volatile int runningWorkers;
    public final Object workerAllocationLock;

    public LimitedDispatcher(int i) {
        CoroutineContext.Element element = UnlimitedIoScheduler.INSTANCE;
        this.parallelism = i;
        if ((element instanceof Delay ? (Delay) element : null) == null) {
            int i2 = DefaultExecutorKt.$r8$clinit;
        }
        this.queue = new LockFreeTaskQueue();
        this.workerAllocationLock = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableObtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        if (runningWorkers$FU.get(this) >= this.parallelism || !tryAllocateWorker() || (runnableObtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) == null) {
            return;
        }
        UnlimitedIoScheduler.INSTANCE.dispatch(this, new Worker.AnonymousClass2(this, 17, runnableObtainTaskOrDeallocateWorker));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableObtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        if (runningWorkers$FU.get(this) >= this.parallelism || !tryAllocateWorker() || (runnableObtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) == null) {
            return;
        }
        UnlimitedIoScheduler.INSTANCE.dispatchYield(this, new Worker.AnonymousClass2(this, 17, runnableObtainTaskOrDeallocateWorker));
    }

    public final Runnable obtainTaskOrDeallocateWorker() {
        while (true) {
            Runnable runnable = (Runnable) this.queue.removeFirstOrNull();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.workerAllocationLock) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.queue.getSize() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean tryAllocateWorker() {
        synchronized (this.workerAllocationLock) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
            if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
