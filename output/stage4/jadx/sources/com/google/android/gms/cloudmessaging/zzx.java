package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzw;
import java.io.IOException;
import kotlin.ExceptionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class zzx implements Continuation, SuccessContinuation {
    public static final /* synthetic */ zzx zza$1 = new zzx();
    public static final /* synthetic */ zzx zza = new zzx();

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public zzw then(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = Rpc.zza;
        return (bundle == null || !bundle.containsKey(C0000.decode(new byte[]{85, 13, 89, 80, 92, 82, 77, 15, 6, 21, 64, 92, 87, 1, 87, 16}, "2b6707cbcf399f", true))) ? ExceptionsKt.forResult(bundle) : ExceptionsKt.forResult(null);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) throws IOException {
        if (task.isSuccessful()) {
            return (Bundle) task.getResult();
        }
        if (Log.isLoggable(C0000.decode(new byte[]{97, 68, 81}, "3422608275b1b8", 0.0f), 3)) {
            C0000.decode(new byte[]{125, 16, 19, 11, 67, 65, 94, 7, 83, 90, 86, 5, 65, 22, 84, 16, 70, 3, 75, 71, 2, 66}, "8bad1a3f83", 0.0f).concat(String.valueOf(task.getException()));
        }
        throw new IOException(C0000.decode(new byte[]{97, 113, 101, 98, 121, 114, 33, 102, 45, 46, 102, 107, 118, 98, 113, 120, 40, 120, 33, 45, 119}, "247401d9ca", 0.0f), task.getException());
    }
}
