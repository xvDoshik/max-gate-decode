package okhttp3.internal.concurrent;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.Worker;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import okhttp3.ConnectionPool;
import okhttp3.internal.Util;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TaskRunner {
    public static final ProfileInstaller$2 Companion = new ProfileInstaller$2();
    public static final TaskRunner INSTANCE = new TaskRunner(new ConnectionPool(new Util$$ExternalSyntheticLambda1(FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), Util.okHttpName, C0000.decode(new byte[]{18, 96, 0, 22, 83, 97, 68, 93, 88, 7, 69}, "24ae83136b794310", true)), true)));
    public static final Logger logger = Logger.getLogger(TaskRunner.class.getName());
    public final ConnectionPool backend;
    public boolean coordinatorWaiting;
    public long coordinatorWakeUpAt;
    public int nextQueueName = 10000;
    public final ArrayList busyQueues = new ArrayList();
    public final ArrayList readyQueues = new ArrayList();
    public final Worker.AnonymousClass1 runnable = new Worker.AnonymousClass1(14, this);

    public TaskRunner(ConnectionPool connectionPool) {
        this.backend = connectionPool;
    }

    public static final void access$runTask(TaskRunner taskRunner, Task task) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task.name);
        try {
            long jRunOnce = task.runOnce();
            synchronized (taskRunner) {
                taskRunner.afterRun(task, jRunOnce);
            }
        } finally {
            synchronized (taskRunner) {
                taskRunner.afterRun(task, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void afterRun(Task task, long j) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        TaskQueue taskQueue = task.queue;
        if (taskQueue.activeTask != task) {
            throw new IllegalStateException(C0000.decode(new byte[]{119, 9, 6, 5, 91, 24, 86, 80, 15, 14, 83, 2, 26}, "4acf0801fb6f4119", true));
        }
        boolean z = taskQueue.cancelActiveTask;
        taskQueue.cancelActiveTask = false;
        taskQueue.activeTask = null;
        this.busyQueues.remove(taskQueue);
        if (j != -1 && !z && !taskQueue.shutdown) {
            taskQueue.scheduleAndDecide$okhttp(task, j, true);
        }
        if (taskQueue.futureTasks.isEmpty()) {
            return;
        }
        this.readyQueues.add(taskQueue);
    }

    public final Task awaitTaskToRun() {
        long j;
        Task task;
        boolean z;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        while (true) {
            ArrayList arrayList = this.readyQueues;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i = 0;
            Task task2 = null;
            while (true) {
                if (i >= size) {
                    j = jNanoTime;
                    task = null;
                    z = false;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                Task task3 = (Task) ((TaskQueue) obj).futureTasks.get(0);
                j = jNanoTime;
                task = null;
                long jMax = Math.max(0L, task3.nextExecuteNanoTime - j);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task2 != null) {
                        z = true;
                        break;
                    }
                    task2 = task3;
                }
                jNanoTime = j;
            }
            ArrayList arrayList2 = this.busyQueues;
            if (task2 != null) {
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                task2.nextExecuteNanoTime = -1L;
                TaskQueue taskQueue = task2.queue;
                taskQueue.futureTasks.remove(task2);
                arrayList.remove(taskQueue);
                taskQueue.activeTask = task2;
                arrayList2.add(taskQueue);
                if (z || (!this.coordinatorWaiting && !arrayList.isEmpty())) {
                    ((ThreadPoolExecutor) this.backend.delegate).execute(this.runnable);
                }
                return task2;
            }
            if (this.coordinatorWaiting) {
                if (jMin >= this.coordinatorWakeUpAt - j) {
                    return task;
                }
                notify();
                return task;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = j + jMin;
            try {
                try {
                    long j2 = jMin / 1000000;
                    long j3 = jMin - (1000000 * j2);
                    if (j2 > 0 || jMin > 0) {
                        wait(j2, (int) j3);
                    }
                } catch (InterruptedException unused) {
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((TaskQueue) arrayList2.get(size2)).cancelAllAndDecide$okhttp();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        TaskQueue taskQueue2 = (TaskQueue) arrayList.get(size3);
                        taskQueue2.cancelAllAndDecide$okhttp();
                        if (taskQueue2.futureTasks.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
                this.coordinatorWaiting = false;
            } catch (Throwable th) {
                this.coordinatorWaiting = false;
                throw th;
            }
        }
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (taskQueue.activeTask == null) {
            boolean zIsEmpty = taskQueue.futureTasks.isEmpty();
            ArrayList arrayList = this.readyQueues;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else if (!arrayList.contains(taskQueue)) {
                arrayList.add(taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            notify();
        } else {
            ((ThreadPoolExecutor) this.backend.delegate).execute(this.runnable);
        }
    }

    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.nextQueueName;
            this.nextQueueName = i + 1;
        }
        return new TaskQueue(this, NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{52}, "e707866e4012509d", 2), i));
    }
}
