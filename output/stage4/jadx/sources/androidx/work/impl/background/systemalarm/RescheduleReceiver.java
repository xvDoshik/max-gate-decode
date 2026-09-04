package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.SystemClock;
import androidx.work.impl.WorkManagerImpl;
import java.util.Objects;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{51, 85, 18, 2, 92, 80, 87, 22, 8, 87, 106, 80, 2, 85, 8, 23, 81, 71}, "a0aa453cd285"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        SystemClock systemClock = SystemClock.get();
        Objects.toString(intent);
        systemClock.getClass();
        try {
            WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (WorkManagerImpl.sLock) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = instance$1.mRescheduleReceiverResult;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    instance$1.mRescheduleReceiverResult = pendingResultGoAsync;
                    if (instance$1.mForceStopRunnableCompleted) {
                        pendingResultGoAsync.finish();
                        instance$1.mRescheduleReceiverResult = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException unused) {
            SystemClock.get().getClass();
        }
    }
}
