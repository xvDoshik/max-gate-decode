package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.concurrent.zza;
import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.Executor;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzu implements Executor {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzu(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((zaq) this.zza).post(runnable);
                break;
            case 1:
                ((Handler) ((Dispatcher) this.zza).runningAsyncCalls).post(runnable);
                break;
            default:
                ((Executor) this.zza).execute(new zza(runnable, 1));
                break;
        }
    }

    public zzu() {
        this.$r8$classId = 0;
        this.zza = new zaq(Looper.getMainLooper());
    }
}
