package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.SystemClock;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.StartWorkRunnable;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{123, 94, 90, 16, 67, 19, 86, 69, 100, 17, 88, 25, 65, 100, 68, 7, 67, 51, 93, 82, 66, 17}, "814c7a"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (C0000.decode(new byte[]{86, 13, 86, 19, 91, 92, 1, 29, 25, 66, 90, 75, 13, 79, 94, 14, 66, 13, 26, 87, 4, 6, 92, 82, 71, 86, 19, 15, 83, 77, 65, 24, 71, 65, 0, 8, 86, 89, 84, 75, 11, 79, 98, 19, 86, 0, 64, 80, 53, 23, 88, 77, 92, 92, 21}, "7c2a45ee7559fa").equals(intent != null ? intent.getAction() : null)) {
            WorkManagerImpl.getInstance$1(context).mWorkTaskExecutor.executeOnTaskThread(new StartWorkRunnable(intent, context, goAsync(), 1));
        } else {
            SystemClock.get().getClass();
        }
    }
}
