package kotlinx.coroutines.scheduling;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile int _isTerminated;
    private volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray workers;
    public static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, C0000.decode(new byte[]{19, 85, 64, 91, 84, 85, 110, 12, 23, 88, 86, 64, 17, 49, 16, 83, 0, 95}, "c420119ce332bbd2"));
    public static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, C0000.decode(new byte[]{0, 14, 12, 76, 65, 92, 13, 55, 77, 88, 76, 4}, "cab833ad998a", false));
    public static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, C0000.decode(new byte[]{109, 91, 17, 109, 80, 17, 85, 80, 94, 87, 16, 7, 86}, "22b95c8906db", 5));
    public static final Symbol NOT_IN_STACK = new Symbol(C0000.decode(new byte[]{45, 42, 99, 59, 47, 123, 59, 102, 55, 36, 116, 47}, "ce7df5d5", false), 0);

    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, C0000.decode(new byte[]{18, 87, 71, 95, 87, 68, 113, 76, 14}, "e8542628b4f430", true));
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        public int rngState;
        public int state;
        public final Regex stolenTask;
        public long terminationDeadline;
        private volatile int workerCtl;

        public Worker(int i) {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new Regex(1);
            this.state = 4;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.defaultRandom.nextInt();
            setIndexInArray(i);
        }

        public final Task findTask(boolean z) {
            Task taskPollGlobalQueues;
            Task taskPollGlobalQueues2;
            long j;
            int i = this.state;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            Task task = null;
            WorkQueue workQueue = this.localQueue;
            if (i != 1) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
                do {
                    j = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        workQueue.getClass();
                        loop1: while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.lastScheduledTask$FU;
                            Task task2 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task2 == null || task2.taskContext.taskMode != 1) {
                                int i2 = WorkQueue.consumerIndex$FU.get(workQueue);
                                int i3 = WorkQueue.producerIndex$FU.get(workQueue);
                                while (i2 != i3 && WorkQueue.blockingTasksInBuffer$FU.get(workQueue) != 0) {
                                    i3--;
                                    Task taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(i3, true);
                                    if (taskTryExtractFromTheMiddle != null) {
                                        task = taskTryExtractFromTheMiddle;
                                        break;
                                    }
                                }
                                break;
                            }
                            do {
                                if (atomicReferenceFieldUpdater.compareAndSet(workQueue, task2, null)) {
                                    task = task2;
                                    break loop1;
                                }
                            } while (atomicReferenceFieldUpdater.get(workQueue) == task2);
                        }
                        if (task != null) {
                            return task;
                        }
                        Task task3 = (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
                        return task3 == null ? trySteal(1) : task3;
                    }
                } while (!CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
                this.state = 1;
            }
            if (z) {
                boolean z2 = nextInt(coroutineScheduler.corePoolSize * 2) == 0;
                if (z2 && (taskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues2;
                }
                workQueue.getClass();
                Task taskPollBuffer = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, null);
                if (taskPollBuffer == null) {
                    taskPollBuffer = workQueue.pollBuffer();
                }
                if (taskPollBuffer != null) {
                    return taskPollBuffer;
                }
                if (!z2 && (taskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues;
                }
            } else {
                Task taskPollGlobalQueues3 = pollGlobalQueues();
                if (taskPollGlobalQueues3 != null) {
                    return taskPollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final Task pollGlobalQueues() {
            int iNextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (iNextInt == 0) {
                Task task = (Task) coroutineScheduler.globalCpuQueue.removeFirstOrNull();
                return task != null ? task : (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            return task2 != null ? task2 : (Task) coroutineScheduler.globalCpuQueue.removeFirstOrNull();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            long j;
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    if (CoroutineScheduler._isTerminated$FU.get(CoroutineScheduler.this) != 0 || this.state == 5) {
                        break loop0;
                    }
                    Task taskFindTask = findTask(this.mayHaveLocalTasks);
                    if (taskFindTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                        int i = taskFindTask.taskContext.taskMode;
                        this.terminationDeadline = 0L;
                        if (this.state == 3) {
                            this.state = 2;
                        }
                        if (i != 0 && tryReleaseCpu(2) && !coroutineScheduler.tryUnpark() && !coroutineScheduler.tryCreateWorker(CoroutineScheduler.controlState$FU.get(coroutineScheduler))) {
                            coroutineScheduler.tryUnpark();
                        }
                        try {
                            taskFindTask.run();
                        } catch (Throwable th) {
                            Thread threadCurrentThread = Thread.currentThread();
                            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                        }
                        if (i != 0) {
                            CoroutineScheduler.controlState$FU.addAndGet(coroutineScheduler, -2097152L);
                            if (this.state == 5) {
                                break;
                            }
                            this.state = 4;
                            break;
                        }
                        break;
                    }
                    this.mayHaveLocalTasks = false;
                    if (this.minDelayUntilStealableTaskNs == 0) {
                        Object obj = this.nextParkedWorker;
                        Symbol symbol = CoroutineScheduler.NOT_IN_STACK;
                        if (obj != symbol) {
                            workerCtl$FU.set(this, -1);
                            while (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = workerCtl$FU;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = CoroutineScheduler._isTerminated$FU;
                                if (atomicIntegerFieldUpdater2.get(coroutineScheduler2) != 0 || this.state == 5) {
                                    break;
                                }
                                tryReleaseCpu(3);
                                Thread.interrupted();
                                if (this.terminationDeadline == 0) {
                                    j = 2097151;
                                    this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                } else {
                                    j = 2097151;
                                }
                                LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                if (System.nanoTime() - this.terminationDeadline >= 0) {
                                    this.terminationDeadline = 0L;
                                    CoroutineScheduler coroutineScheduler3 = CoroutineScheduler.this;
                                    synchronized (coroutineScheduler3.workers) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(coroutineScheduler3) != 0)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
                                                if (((int) (atomicLongFieldUpdater.get(coroutineScheduler3) & j)) > coroutineScheduler3.corePoolSize) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i2 = this.indexInArray;
                                                        setIndexInArray(0);
                                                        coroutineScheduler3.parkedWorkersStackTopUpdate(this, i2, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(coroutineScheduler3) & j);
                                                        if (andDecrement != i2) {
                                                            Worker worker = (Worker) coroutineScheduler3.workers.get(andDecrement);
                                                            coroutineScheduler3.workers.setSynchronized(i2, worker);
                                                            worker.setIndexInArray(i2);
                                                            coroutineScheduler3.parkedWorkersStackTopUpdate(worker, andDecrement, i2);
                                                        }
                                                        coroutineScheduler3.workers.setSynchronized(andDecrement, null);
                                                        this.state = 5;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                    }
                                }
                            }
                        } else {
                            CoroutineScheduler coroutineScheduler4 = CoroutineScheduler.this;
                            if (this.nextParkedWorker == symbol) {
                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = CoroutineScheduler.parkedWorkersStack$FU;
                                while (true) {
                                    long j2 = atomicLongFieldUpdater2.get(coroutineScheduler4);
                                    int i3 = this.indexInArray;
                                    this.nextParkedWorker = coroutineScheduler4.workers.get((int) (j2 & 2097151));
                                    CoroutineScheduler coroutineScheduler5 = coroutineScheduler4;
                                    if (CoroutineScheduler.parkedWorkersStack$FU.compareAndSet(coroutineScheduler5, j2, ((j2 + 2097152) & (-2097152)) | ((long) i3))) {
                                        break;
                                    } else {
                                        coroutineScheduler4 = coroutineScheduler5;
                                    }
                                }
                            }
                        }
                    } else {
                        if (z) {
                            tryReleaseCpu(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                            break;
                        }
                        z = true;
                    }
                }
            }
            tryReleaseCpu(5);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append(C0000.decode(new byte[]{27, 66, 86, 71, 9, 86, 68, 24}, "6595b3", 0.0f));
            sb.append(i == 0 ? C0000.decode(new byte[]{48, 116, 55, 47, 45, 125, 113, 101, 39, 37}, "d1ebd301ba5585", 0.0f) : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(int i) {
            int i2 = this.state;
            boolean z = i2 == 1;
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (i2 != i) {
                this.state = i;
            }
            return z;
        }

        public final Task trySteal(int i) {
            long j;
            Task taskTryExtractFromTheMiddle;
            long j2;
            long j3;
            Task task;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$FU;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i2 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            Task task2 = null;
            if (i2 < 2) {
                return null;
            }
            int iNextInt = nextInt(i2);
            int i3 = 0;
            long jMin = Long.MAX_VALUE;
            while (i3 < i2) {
                iNextInt++;
                if (iNextInt > i2) {
                    iNextInt = 1;
                }
                Worker worker = (Worker) coroutineScheduler.workers.get(iNextInt);
                if (worker != null && worker != this) {
                    WorkQueue workQueue = worker.localQueue;
                    if (i != 3) {
                        workQueue.getClass();
                        int i4 = WorkQueue.consumerIndex$FU.get(workQueue);
                        int i5 = WorkQueue.producerIndex$FU.get(workQueue);
                        boolean z = i == 1;
                        while (true) {
                            if (i4 != i5) {
                                j = 0;
                                if (!z || WorkQueue.blockingTasksInBuffer$FU.get(workQueue) != 0) {
                                    int i6 = i4 + 1;
                                    taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(i4, z);
                                    if (taskTryExtractFromTheMiddle != null) {
                                        break;
                                    }
                                    i4 = i6;
                                }
                            } else {
                                j = 0;
                            }
                            taskTryExtractFromTheMiddle = task2;
                            break;
                        }
                    } else {
                        taskTryExtractFromTheMiddle = workQueue.pollBuffer();
                        j = 0;
                    }
                    Regex regex = this.stolenTask;
                    if (taskTryExtractFromTheMiddle == null) {
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.lastScheduledTask$FU;
                            Task task3 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task3 == null) {
                                j2 = -1;
                            } else {
                                j2 = -1;
                                if (((task3.taskContext.taskMode == 1 ? 1 : 2) & i) != 0) {
                                    TasksKt.schedulerTimeSource.getClass();
                                    WorkQueue workQueue2 = workQueue;
                                    long jNanoTime = System.nanoTime() - task3.submissionTime;
                                    long j4 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
                                    if (jNanoTime < j4) {
                                        j3 = j4 - jNanoTime;
                                        task = null;
                                        break;
                                    }
                                    do {
                                        task = null;
                                        if (atomicReferenceFieldUpdater.compareAndSet(workQueue2, task3, null)) {
                                            regex.nativePattern = task3;
                                            j3 = -1;
                                            break;
                                        }
                                    } while (atomicReferenceFieldUpdater.get(workQueue2) == task3);
                                    workQueue = workQueue2;
                                    task2 = null;
                                }
                            }
                            j3 = -2;
                            task = task2;
                            break;
                        }
                    } else {
                        regex.nativePattern = taskTryExtractFromTheMiddle;
                        task = task2;
                        j3 = -1;
                        j2 = -1;
                    }
                    if (j3 == j2) {
                        Task task4 = (Task) regex.nativePattern;
                        regex.nativePattern = task;
                        return task4;
                    }
                    if (j3 > j) {
                        jMin = Math.min(jMin, j3);
                    }
                }
                i3++;
                task2 = null;
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i < 1) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{119, 94, 74, 80, 23, 66, 88, 87, 91, 65, 68, 10, 78, 84, 24}, "418572787a7c", 1), C0000.decode(new byte[]{16, 69, 95, 91, 64, 89, 86, 16, 86, 80, 22, 81, 68, 22, 91, 81, 84, 70, 70, 16, 5}, "067455204560", 7), i).toString());
        }
        String strDecode = C0000.decode(new byte[]{122, 4, 28, 67, 18, 91, 13, 84, 22, 22, 92, 75, 1, 16}, "7edcb4b86e51d03a");
        if (i2 < i) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(i2, i, strDecode, C0000.decode(new byte[]{69, 21, 88, 88, 70, 90, 1, 70, 82, 82, 19, 81, 23, 3, 81, 67, 86, 68, 69, 18, 88, 86, 93, 22, 10, 20, 16, 82, 66, 67, 4, 10, 67, 23, 71, 89, 69, 5, 95, 69, 86, 22, 21, 9, 95, 91, 19, 69, 12, 28, 85, 23}, "ef0736", true)).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(strDecode, C0000.decode(new byte[]{22, 22, 92, 92, 66, 92, 83, 65, 10, 89, 71, 66, 93, 73, 2, 86, 83, 1, 20, 94, 86, 72, 94, 12, 5, 90, 19, 17, 77, 65, 17, 92, 68, 17, 81, 87, 23, 94, 66, 12, 6, 83, 65, 66, 87, 87, 65, 71, 94, 23, 81, 82, 83, 67, 23, 83, 84, 15, 4, 83, 13, 1}, "6e43707ad63b81a3", 7), i2).toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{44, 81, 85, 86, 21, 65, 10, 71, 82, 86, 71, 22, 14, 80, 92, 67, 21, 87, 9, 92, 79, 86, 21, 66, 12, 88, 92, 19}, "e59356") + j + C0000.decode(new byte[]{18, 11, 76, 16, 66, 21, 80, 3, 25, 19, 89, 70, 91, 18, 80, 21, 83}, "2f9c65", 0)).toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((i + 1) * 2);
        this.controlState = ((long) i) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, int i) {
        coroutineScheduler.dispatch(runnable, TasksKt.NonBlockingContext, (i & 4) == 0);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        Task taskFindTask;
        if (_isTerminated$FU.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
            if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
                worker = null;
            }
            synchronized (this.workers) {
                i = (int) (controlState$FU.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Worker worker2 = (Worker) this.workers.get(i2);
                    if (worker2 != worker) {
                        while (worker2.isAlive()) {
                            LockSupport.unpark(worker2);
                            worker2.join(10000L);
                        }
                        WorkQueue workQueue = worker2.localQueue;
                        GlobalQueue globalQueue = this.globalBlockingQueue;
                        workQueue.getClass();
                        Task task = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, null);
                        if (task != null) {
                            globalQueue.addLast(task);
                        }
                        while (true) {
                            Task taskPollBuffer = workQueue.pollBuffer();
                            if (taskPollBuffer == null) {
                                break;
                            } else {
                                globalQueue.addLast(taskPollBuffer);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (worker != null) {
                    taskFindTask = worker.findTask(true);
                    if (taskFindTask == null) {
                        taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                        if (taskFindTask == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                    if (taskFindTask == null && (taskFindTask = (Task) this.globalBlockingQueue.removeFirstOrNull()) == null) {
                        break;
                    }
                }
                try {
                    taskFindTask.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (worker != null) {
                worker.tryReleaseCpu(5);
            }
            parkedWorkersStack$FU.set(this, 0L);
            controlState$FU.set(this, 0L);
        }
    }

    public final int createNewWorker() {
        synchronized (this.workers) {
            try {
                if (_isTerminated$FU.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.workers.get(i3) != null) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{112, 3, 11, 13, 83, 83, 65, 66, 83, 19, 23, 8, 68, 82, 12, 85, 88, 22, 76}, "6bba67a0", 5));
                }
                Worker worker = new Worker(i3);
                this.workers.setSynchronized(i3, worker);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{118, 83, 10, 95, 83, 6, 19, 19, 4, 20, 77, 81, 19, 85, 92, 85, 94, 70, 77}, "02c36b3aae88a010", 2));
                }
                int i4 = i2 + 1;
                worker.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void dispatch(Runnable runnable, TaskContextImpl taskContextImpl, boolean z) {
        Task taskImpl;
        int i;
        TasksKt.schedulerTimeSource.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            taskImpl = (Task) runnable;
            taskImpl.submissionTime = jNanoTime;
            taskImpl.taskContext = taskContextImpl;
        } else {
            taskImpl = new TaskImpl(runnable, jNanoTime, taskContextImpl);
        }
        boolean z2 = false;
        boolean z3 = taskImpl.taskContext.taskMode == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            worker = null;
        }
        if (worker != null && (i = worker.state) != 5 && (taskImpl.taskContext.taskMode != 0 || i != 2)) {
            worker.mayHaveLocalTasks = true;
            WorkQueue workQueue = worker.localQueue;
            if (z) {
                taskImpl = workQueue.addLast(taskImpl);
            } else {
                workQueue.getClass();
                Task task = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, taskImpl);
                taskImpl = task == null ? null : workQueue.addLast(task);
            }
        }
        if (taskImpl != null) {
            if (!(taskImpl.taskContext.taskMode == 1 ? this.globalBlockingQueue.addLast(taskImpl) : this.globalCpuQueue.addLast(taskImpl))) {
                throw new RejectedExecutionException(FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), this.schedulerName, C0000.decode(new byte[]{66, 68, 0, 69, 16, 21, 4, 64, 15, 90, 15, 87, 68, 4, 5}, "b3a60aa2", 1)));
            }
        }
        if (z && worker != null) {
            z2 = true;
        }
        if (z3) {
            if (z2 || tryUnpark() || tryCreateWorker(jAddAndGet)) {
                return;
            }
            tryUnpark();
            return;
        }
        if (z2 || tryUnpark() || tryCreateWorker(atomicLongFieldUpdater.get(this))) {
            return;
        }
        tryUnpark();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch$default(this, runnable, 6);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            long j = parkedWorkersStack$FU.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object nextParkedWorker = worker.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            i3 = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            i3 = 0;
                            break;
                        }
                        Worker worker2 = (Worker) nextParkedWorker;
                        int indexInArray = worker2.getIndexInArray();
                        if (indexInArray != 0) {
                            i3 = indexInArray;
                            break;
                        }
                        nextParkedWorker = worker2.getNextParkedWorker();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, ((long) i3) | j2)) {
                    return;
                }
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray resizableAtomicArray = this.workers;
        int iCurrentLength = resizableAtomicArray.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iCurrentLength; i6++) {
            Worker worker = (Worker) resizableAtomicArray.get(i6);
            if (worker != null) {
                WorkQueue workQueue = worker.localQueue;
                workQueue.getClass();
                int i7 = WorkQueue.lastScheduledTask$FU.get(workQueue) != null ? (WorkQueue.producerIndex$FU.get(workQueue) - WorkQueue.consumerIndex$FU.get(workQueue)) + 1 : WorkQueue.producerIndex$FU.get(workQueue) - WorkQueue.consumerIndex$FU.get(workQueue);
                int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(worker.state);
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iOrdinal == 4) {
                    i5++;
                }
            }
        }
        long j = controlState$FU.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(BuildersKt.getHexAddress(this));
        sb4.append(C0000.decode(new byte[]{108, 51, 93, 12, 88, 69, 101, 11, 72, 6, 19, 78, 84, 12, 64, 6, 20, 88, 22}, "7c2c4e6b2c35"));
        int i8 = this.corePoolSize;
        sb4.append(i8);
        sb4.append(C0000.decode(new byte[]{21, 68, 15, 7, 28, 16, 5, 70}, "9dbfd08f74"));
        sb4.append(this.maxPoolSize);
        sb4.append(C0000.decode(new byte[]{31, 20, 67, 53, 9, 67, 9, 93, 17, 66, 53, 69, 3, 76, 6, 17, 70, 74, 33, 104, 54, 66, 91, 17}, "b8cbf1"));
        sb4.append(i);
        sb4.append(C0000.decode(new byte[]{26, 16, 86, 14, 11, 81, 95, 93, 90, 5, 18, 9, 22}, "604bd2444b24"));
        sb4.append(i2);
        sb4.append(C0000.decode(new byte[]{74, 21, 67, 80, 64, 83, 3, 81, 19, 12, 18}, "f53128"));
        sb4.append(i3);
        sb4.append(C0000.decode(new byte[]{28, 69, 5, 90, 23, 14, 81, 11, 21, 21, 88, 67}, "0ea5ec"));
        sb4.append(i4);
        sb4.append(C0000.decode(new byte[]{28, 23, 66, 84, 19, 15, 91, 95, 81, 67, 83, 85, 65, 95, 18}, "0761ab21"));
        sb4.append(i5);
        sb4.append(C0000.decode(new byte[]{79, 73, 69, 74, 64, 15, 94, 12, 15, 5, 18, 18, 10, 74, 94, 4, 66, 22, 65, 19, 71, 0, 16, 93, 70, 65, 13, 69}, "2ee85a0eab"));
        sb4.append(arrayList);
        sb4.append(C0000.decode(new byte[]{77, 67, 6, 95, 86, 1, 82, 89, 16, 34, 102, 49, 16, 21, 22, 0, 20, 6, 65, 64, 80, 25, 86, 21, 13, 65}, "aca39c350a6d0dce"));
        sb4.append(this.globalCpuQueue.getSize());
        sb4.append(C0000.decode(new byte[]{79, 70, 5, 8, 11, 0, 88, 13, 18, 4, 8, 11, 83, 13, 12, 11, 4, 70, 19, 17, 1, 23, 92, 65, 65, 15, 30, 1, 16, 91, 69}, "cfbddb9a2fdd0fee"));
        sb4.append(this.globalBlockingQueue.getSize());
        sb4.append(C0000.decode(new byte[]{72, 66, 118, 12, 90, 64, 19, 9, 89, 22, 55, 68, 5, 64, 1, 66, 78, 0, 70, 81, 0, 18, 80, 82, 68, 71, 11, 70, 15, 7, 71, 16, 9, 20}, "db5c44af56d0d4"));
        sb4.append((int) (2097151 & j));
        sb4.append(C0000.decode(new byte[]{78, 20, 81, 8, 94, 90, 92, 8, 94, 84, 22, 64, 81, 16, 15, 23, 66, 9, 19}, "b43d197a03640cdd"));
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(C0000.decode(new byte[]{74, 67, 119, 101, 101, 22, 70, 82, 85, 21, 23, 10, 23, 6, 2, 67, 9, 21}, "fc450ef36dbcec"));
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append(C0000.decode(new byte[]{31, 105}, "b409dcc88732"));
        return sb4.toString();
    }

    public final boolean tryCreateWorker(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.corePoolSize;
        if (i < i2) {
            int iCreateNewWorker = createNewWorker();
            if (iCreateNewWorker == 1 && i2 > 1) {
                createNewWorker();
            }
            if (iCreateNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        Symbol symbol;
        int indexInArray;
        while (true) {
            long j = parkedWorkersStack$FU.get(this);
            Worker worker = (Worker) this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object nextParkedWorker = worker.getNextParkedWorker();
                while (true) {
                    symbol = NOT_IN_STACK;
                    if (nextParkedWorker == symbol) {
                        indexInArray = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        indexInArray = 0;
                        break;
                    }
                    Worker worker2 = (Worker) nextParkedWorker;
                    indexInArray = worker2.getIndexInArray();
                    if (indexInArray != 0) {
                        break;
                    }
                    nextParkedWorker = worker2.getNextParkedWorker();
                }
                if (indexInArray >= 0) {
                    if (parkedWorkersStack$FU.compareAndSet(this, j, ((long) indexInArray) | j2)) {
                        worker.setNextParkedWorker(symbol);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }
}
