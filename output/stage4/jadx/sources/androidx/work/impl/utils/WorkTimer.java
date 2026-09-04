package androidx.work.impl.utils;

import androidx.work.SystemClock;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler$$ExternalSyntheticLambda0;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Objects;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkTimer {
    public final ConnectionPool mRunnableScheduler;
    public final HashMap mTimerMap = new HashMap();
    public final HashMap mListeners = new HashMap();
    public final Object mLock = new Object();

    public interface TimeLimitExceededListener {
    }

    public final class WorkTimerRunnable implements Runnable {
        public final WorkGenerationalId mWorkGenerationalId;
        public final WorkTimer mWorkTimer;

        public WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = workGenerationalId;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (((WorkTimerRunnable) this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId)) != null) {
                        TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                        if (timeLimitExceededListener != null) {
                            WorkGenerationalId workGenerationalId = this.mWorkGenerationalId;
                            DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) timeLimitExceededListener;
                            SystemClock systemClock = SystemClock.get();
                            Objects.toString(workGenerationalId);
                            systemClock.getClass();
                            delayMetCommandHandler.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(delayMetCommandHandler, 0));
                        }
                    } else {
                        SystemClock systemClock2 = SystemClock.get();
                        this.mWorkGenerationalId.toString();
                        systemClock2.getClass();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{98, 11, 74, 10, 101, 10, 95, 4, 71}, "5d8a1c2a53ed", 0.0f));
    }

    public WorkTimer(ConnectionPool connectionPool) {
        this.mRunnableScheduler = connectionPool;
    }

    public final void stopTimer(WorkGenerationalId workGenerationalId) {
        synchronized (this.mLock) {
            try {
                if (((WorkTimerRunnable) this.mTimerMap.remove(workGenerationalId)) != null) {
                    SystemClock systemClock = SystemClock.get();
                    Objects.toString(workGenerationalId);
                    systemClock.getClass();
                    this.mListeners.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
