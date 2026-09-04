package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkQueue {
    private volatile int blockingTasksInBuffer;
    public final AtomicReferenceArray buffer = new AtomicReferenceArray(128);
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;
    public static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, C0000.decode(new byte[]{94, 3, 16, 77, 103, 90, 95, 4, 81, 77, 94, 7, 7, 109, 85, 74, 92}, "2bc9497a58", 0));
    public static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, C0000.decode(new byte[]{73, 17, 10, 0, 22, 7, 0, 64, 125, 10, 85, 92, 29}, "9cedcde24d19e4e8", 3));
    public static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, C0000.decode(new byte[]{2, 86, 15, 64, 20, 90, 93, 68, 40, 87, 5, 86, 25}, "a9a3a786", 3));
    public static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, C0000.decode(new byte[]{0, 15, 87, 84, 94, 80, 86, 3, 101, 82, 75, 93, 17, 42, 86, 117, 64, 95, 94, 1, 67}, "bc87598d1386", 1));

    public final Task addLast(Task task) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = producerIndex$FU;
        if (atomicIntegerFieldUpdater.get(this) - consumerIndex$FU.get(this) == 127) {
            return task;
        }
        if (task.taskContext.taskMode == 1) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.buffer;
            if (atomicReferenceArray.get(i) == null) {
                atomicReferenceArray.lazySet(i, task);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final Task pollBuffer() {
        Task task;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = consumerIndex$FU;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - producerIndex$FU.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (task = (Task) this.buffer.getAndSet(i2, null)) != null) {
                if (task.taskContext.taskMode == 1) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
    }

    public final Task tryExtractFromTheMiddle(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.buffer;
        Task task = (Task) atomicReferenceArray.get(i2);
        if (task != null) {
            if ((task.taskContext.taskMode == 1) == z) {
                while (!atomicReferenceArray.compareAndSet(i2, task, null)) {
                    if (atomicReferenceArray.get(i2) != task) {
                    }
                }
                if (z) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }
}
