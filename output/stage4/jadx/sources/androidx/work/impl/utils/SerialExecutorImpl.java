package androidx.work.impl.utils;

import androidx.work.Worker;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SerialExecutorImpl implements Executor {
    public Runnable mActive;
    public final Executor mExecutor;
    public final ArrayDeque mTasks = new ArrayDeque();
    public final Object mLock = new Object();

    public SerialExecutorImpl(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                this.mTasks.add(new Worker.AnonymousClass2(this, runnable, 4, false));
                if (this.mActive == null) {
                    scheduleNext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleNext() {
        Runnable runnable = (Runnable) this.mTasks.poll();
        this.mActive = runnable;
        if (runnable != null) {
            this.mExecutor.execute(runnable);
        }
    }
}
