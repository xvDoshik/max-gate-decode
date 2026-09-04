package androidx.work.impl.utils;

import androidx.work.SystemClock;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StopWorkRunnable implements Runnable {
    public final Processor processor;
    public final int reason;
    public final boolean stopInForeground;
    public final StartStopToken token;

    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z, int i) {
        this.processor = processor;
        this.token = startStopToken;
        this.stopInForeground = z;
        this.reason = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        if (this.stopInForeground) {
            Processor processor = this.processor;
            StartStopToken startStopToken = this.token;
            int i = this.reason;
            processor.getClass();
            String str = startStopToken.id.workSpecId;
            synchronized (processor.mLock) {
                workerWrapperCleanUpWorkerUnsafe = processor.cleanUpWorkerUnsafe(str);
            }
            Processor.interrupt(workerWrapperCleanUpWorkerUnsafe, i);
        } else {
            Processor processor2 = this.processor;
            StartStopToken startStopToken2 = this.token;
            int i2 = this.reason;
            processor2.getClass();
            String str2 = startStopToken2.id.workSpecId;
            synchronized (processor2.mLock) {
                try {
                    if (processor2.mForegroundWorkMap.get(str2) != null) {
                        SystemClock.get().getClass();
                    } else {
                        Set set = (Set) processor2.mWorkRuns.get(str2);
                        if (set != null && set.contains(startStopToken2)) {
                            Processor.interrupt(processor2.cleanUpWorkerUnsafe(str2), i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        SystemClock systemClock = SystemClock.get();
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{101, 76, 10, 70, 54, 91, 17, 94, 52, 68, 91, 10, 87, 90, 9, 83}, "68e6a4c5f15d", 0.0f));
        WorkGenerationalId workGenerationalId = this.token.id;
        systemClock.getClass();
    }
}
