package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.firebase.messaging.RequestDeduplicator;
import java.util.concurrent.ExecutionException;
import kotlin.ExceptionsKt;
import kotlin.text.CharsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public final int onMessageReceive(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) ExceptionsKt.await(new RequestDeduplicator(context).process(cloudMessage.zza))).intValue();
        } catch (InterruptedException | ExecutionException unused) {
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public final void onNotificationDismissed(Bundle bundle) {
        Intent intentPutExtras = new Intent(C0000.decode(new byte[]{90, 95, 8, 75, 81, 14, 91, 1, 85, 85, 75, 3, 95, 19, 81, 4, 88, 67, 0, 75, 91, 4, 71, 21, 88, 87, 12, 11, 81, 79, 122, 41, 109, 121, 35, 44, 117, 32, 96, 47, 118, 126, 58, 33, 127, 50, 121, 47, 106, 99}, "90ee6a4f", 0.0f)).putExtras(bundle);
        if (CharsKt.shouldUploadScionMetrics(intentPutExtras)) {
            CharsKt.logToScion(C0000.decode(new byte[]{108, 88, 80}, "36484d"), intentPutExtras.getExtras());
        }
    }
}
