package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.ListenableWorker;
import androidx.work.SystemClock;
import androidx.work.WorkerParameters;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    public volatile boolean areConstraintsUnmet;
    public ListenableWorker delegate;
    public final SettableFuture future;
    public final Object lock;
    public final WorkerParameters workerParameters;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.workerParameters = workerParameters;
        this.lock = new Object();
        this.future = new SettableFuture();
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        SystemClock systemClock = SystemClock.get();
        int i = ConstraintTrackingWorkerKt.$r8$clinit;
        workSpec.toString();
        systemClock.getClass();
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.lock) {
                this.areConstraintsUnmet = true;
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker == null || listenableWorker.mStopReason != -256) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? this.mStopReason : 0);
    }

    @Override // androidx.work.ListenableWorker
    public final SettableFuture startWork() {
        this.mWorkerParams.mBackgroundExecutor.execute(new CoroutineWorker$$ExternalSyntheticLambda0(3, this));
        return this.future;
    }
}
