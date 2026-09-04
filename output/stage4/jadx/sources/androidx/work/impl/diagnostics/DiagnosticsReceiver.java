package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.OneTimeWorkRequest;
import androidx.work.SystemClock;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.workers.DiagnosticsWorker;
import java.util.Collections;
import java.util.List;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{34, 90, 88, 82, 91, 94, 67, 17, 81, 84, 64, 48, 0, 70, 20}, "f395510e873bc0", false));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        SystemClock.get().getClass();
        try {
            WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
            List listSingletonList = Collections.singletonList((OneTimeWorkRequest) new OneTimeWorkRequest.Builder(DiagnosticsWorker.class).build());
            if (listSingletonList.isEmpty()) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{82, 88, 71, 77, 7, 70, 7, 24, 95, 4, 82, 82, 69, 24, 3, 71, 66, 84, 84, 0, 68, 66, 22, 87, 12, 86, 66, 111, 94, 19, 92, 100, 83, 73, 23, 86, 17, 76, 31}, "7668b3b81a"));
            }
            new WorkContinuationImpl(instance$1, null, 2, listSingletonList, 0).enqueue();
        } catch (IllegalStateException unused) {
            SystemClock.get().getClass();
        }
    }
}
