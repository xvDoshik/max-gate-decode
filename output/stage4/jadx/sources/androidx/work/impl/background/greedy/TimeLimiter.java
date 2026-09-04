package androidx.work.impl.background.greedy;

import android.os.Handler;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncherImpl;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TimeLimiter {
    public final WorkLauncherImpl launcher;
    public final Object lock;
    public final ConnectionPool runnableScheduler;
    public final long timeoutMs;
    public final LinkedHashMap tracked;

    public TimeLimiter(ConnectionPool connectionPool, WorkLauncherImpl workLauncherImpl) {
        long millis = TimeUnit.MINUTES.toMillis(90L);
        this.runnableScheduler = connectionPool;
        this.launcher = workLauncherImpl;
        this.timeoutMs = millis;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    public final void cancel(StartStopToken startStopToken) {
        Runnable runnable;
        synchronized (this.lock) {
            runnable = (Runnable) this.tracked.remove(startStopToken);
        }
        if (runnable != null) {
            ((Handler) this.runnableScheduler.delegate).removeCallbacks(runnable);
        }
    }

    public final void track(StartStopToken startStopToken) {
        Processor$$ExternalSyntheticLambda2 processor$$ExternalSyntheticLambda2 = new Processor$$ExternalSyntheticLambda2(this, 2, startStopToken);
        synchronized (this.lock) {
        }
        ConnectionPool connectionPool = this.runnableScheduler;
        ((Handler) connectionPool.delegate).postDelayed(processor$$ExternalSyntheticLambda2, this.timeoutMs);
    }
}
