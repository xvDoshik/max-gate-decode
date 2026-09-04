package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.tasks.zzu;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkForegroundRunnable implements Runnable {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Context mContext;
    public final WorkForegroundUpdater mForegroundUpdater;
    public final SettableFuture mFuture = new SettableFuture();
    public final Dispatcher mTaskExecutor;
    public final WorkSpec mWorkSpec;
    public final ListenableWorker mWorker;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{96, 14, 71, 91, 39, 10, 20, 80, 81, 67, 88, 20, 91, 84, 51, 16, 8, 91, 87, 83, 91, 4}, "7a50aef561", false));
    }

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, WorkForegroundUpdater workForegroundUpdater, Dispatcher dispatcher) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = listenableWorker;
        this.mForegroundUpdater = workForegroundUpdater;
        this.mTaskExecutor = dispatcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.mWorkSpec.expedited || Build.VERSION.SDK_INT >= 31) {
            this.mFuture.set(null);
            return;
        }
        SettableFuture settableFuture = new SettableFuture();
        Dispatcher dispatcher = this.mTaskExecutor;
        ((zzu) dispatcher.runningSyncCalls).execute(new Processor$$ExternalSyntheticLambda2(this, 4, settableFuture));
        settableFuture.addListener(new Worker.AnonymousClass2(this, 5, settableFuture), (zzu) dispatcher.runningSyncCalls);
    }
}
