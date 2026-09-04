package okhttp3.internal.concurrent;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Task {
    public final boolean cancelable;
    public final String name;
    public long nextExecuteNanoTime = -1;
    public TaskQueue queue;

    public Task(String str, boolean z) {
        this.name = str;
        this.cancelable = z;
    }

    public abstract long runOnce();

    public final String toString() {
        return this.name;
    }
}
