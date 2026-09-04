package com.google.firebase.messaging;

import android.os.Binder;
import android.os.Process;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WithinAppServiceBinder extends Binder {
    public final ConnectionPool intentHandler;

    public WithinAppServiceBinder(ConnectionPool connectionPool) {
        this.intentHandler = connectionPool;
    }

    public final void send(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException(C0000.decode(new byte[]{118, 8, 92, 0, 90, 94, 83, 20, 12, 91, 91, 29, 20, 0, 94, 8, 92, 71, 81, 80, 67, 66, 94, 16, 92, 8, 92, 68, 82, 64, 68}, "4a2d3044c57d", true));
        }
        EnhancedIntentService.access$000((EnhancedIntentService) this.intentHandler.delegate, bindRequest.intent).addOnCompleteListener(new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new CctTransportBackend$$ExternalSyntheticLambda0(12, bindRequest));
    }
}
