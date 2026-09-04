package okhttp3.internal.concurrent;

import androidx.profileinstaller.ProfileInstaller$2;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.ResultKt;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TaskQueue {
    public Task activeTask;
    public boolean cancelActiveTask;
    public final ArrayList futureTasks = new ArrayList();
    public final String name;
    public boolean shutdown;
    public final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String str) {
        this.taskRunner = taskRunner;
        this.name = str;
    }

    public final void cancelAll() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.cancelable) {
            this.cancelActiveTask = true;
        }
        ArrayList arrayList = this.futureTasks;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((Task) arrayList.get(size)).cancelable) {
                Task task2 = (Task) arrayList.get(size);
                ProfileInstaller$2 profileInstaller$2 = TaskRunner.Companion;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    ResultKt.access$log(task2, this, C0000.decode(new byte[]{80, 80, 86, 86, 0, 93, 86, 86}, "3185e1320b408641", 0.0f));
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void schedule(Task task, long j) {
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            } else if (task.cancelable) {
                ProfileInstaller$2 profileInstaller$2 = TaskRunner.Companion;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    ResultKt.access$log(task, this, C0000.decode(new byte[]{65, 83, 92, 82, 83, 66, 8, 83, 22, 87, 2, 89, 81, 85, 88, 82, 83, 23, 76, 71, 67, 81, 22, 82, 18, 89, 71, 23, 68, 95, 17, 66, 82, 91, 20, 89, 27}, "204777d664c7"));
                }
            } else {
                ProfileInstaller$2 profileInstaller$3 = TaskRunner.Companion;
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    ResultKt.access$log(task, this, C0000.decode(new byte[]{16, 84, 80, 83, 6, 71, 95, 83, 67, 85, 0, 94, 15, 82, 92, 22, 74, 67, 70, 83, 22, 86, 65, 94, 16, 23, 75, 94, 23, 70, 87, 89, 20, 93, 72}, "c786b236c3a7", 0.0f));
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    /* JADX WARN: Code duplicated, block: B:20:0x006d  */
    /* JADX WARN: Code duplicated, block: B:24:0x008f  */
    /* JADX WARN: Code duplicated, block: B:27:0x009f A[LOOP:0: B:23:0x008d->B:27:0x009f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3 A[EDGE_INSN: B:39:0x00a3->B:29:0x00a3 BREAK  A[LOOP:0: B:23:0x008d->B:27:0x009f], SYNTHETIC] */
    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z) {
        int size;
        int size2;
        int i;
        Object obj;
        String strConcat;
        TaskQueue taskQueue = task.queue;
        if (taskQueue != this) {
            if (taskQueue != null) {
                throw new IllegalStateException(C0000.decode(new byte[]{70, 82, 67, 8, 20, 95, 18, 25, 11, 87, 18, 94, 69, 15, 64, 95, 17, 85, 7, 25, 67, 70, 85, 22, 81, 69}, "230c46a9b9"));
            }
            task.queue = this;
        }
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime + j;
        ArrayList arrayList = this.futureTasks;
        int iIndexOf = arrayList.indexOf(task);
        if (iIndexOf == -1) {
            task.nextExecuteNanoTime = j2;
            ProfileInstaller$2 profileInstaller$2 = TaskRunner.Companion;
            if (TaskRunner.logger.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = C0000.decode(new byte[]{68, 16, 15, 69, 88, 87, 81, 95, 94, 67, 85, 2, 69, 86, 68, 69}, "6eae90060c4d13").concat(ResultKt.formatDuration(j2 - jNanoTime));
                } else {
                    strConcat = C0000.decode(new byte[]{17, 6, 10, 81, 5, 77, 8, 85, 87, 21, 82, 87, 71, 83, 16, 69}, "beb4a8d0353136").concat(ResultKt.formatDuration(j2 - jNanoTime));
                }
                ResultKt.access$log(task, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((Task) obj).nextExecuteNanoTime - jNanoTime > j) {
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, task);
            if (size2 == 0) {
                return true;
            }
        } else if (task.nextExecuteNanoTime <= j2) {
            ProfileInstaller$2 profileInstaller$3 = TaskRunner.Companion;
            if (TaskRunner.logger.isLoggable(Level.FINE)) {
                ResultKt.access$log(task, this, C0000.decode(new byte[]{84, 90, 74, 1, 86, 86, 64, 68, 70, 85, 80, 1, 83, 71, 85, 1, 81}, "568d729d"));
                return false;
            }
        } else {
            arrayList.remove(iIndexOf);
            task.nextExecuteNanoTime = j2;
            ProfileInstaller$2 profileInstaller$4 = TaskRunner.Companion;
            if (TaskRunner.logger.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = C0000.decode(new byte[]{68, 16, 15, 69, 88, 87, 81, 95, 94, 67, 85, 2, 69, 86, 68, 69}, "6eae90060c4d13").concat(ResultKt.formatDuration(j2 - jNanoTime));
                } else {
                    strConcat = C0000.decode(new byte[]{17, 6, 10, 81, 5, 77, 8, 85, 87, 21, 82, 87, 71, 83, 16, 69}, "beb4a8d0353136").concat(ResultKt.formatDuration(j2 - jNanoTime));
                }
                ResultKt.access$log(task, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((Task) obj).nextExecuteNanoTime - jNanoTime > j) {
                    break;
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, task);
            if (size2 == 0) {
                return true;
            }
        }
        return false;
    }

    public final void shutdown() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final String toString() {
        return this.name;
    }
}
