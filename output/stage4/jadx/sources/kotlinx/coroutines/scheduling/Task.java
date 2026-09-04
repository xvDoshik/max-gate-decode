package kotlinx.coroutines.scheduling;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Task implements Runnable {
    public long submissionTime;
    public TaskContextImpl taskContext;

    public Task(long j, TaskContextImpl taskContextImpl) {
        this.submissionTime = j;
        this.taskContext = taskContextImpl;
    }
}
