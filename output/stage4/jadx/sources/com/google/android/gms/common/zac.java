package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zac extends zaq {
    public final /* synthetic */ GoogleApiAvailability zaa;
    public final Context zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.zaa = googleApiAvailability;
        this.zab = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws PackageManager.NameNotFoundException {
        if (message.what != 1) {
            return;
        }
        int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        GoogleApiAvailability googleApiAvailability = this.zaa;
        Context context = this.zab;
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context, i);
        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
        if (iIsGooglePlayServicesAvailable == 1 || iIsGooglePlayServicesAvailable == 2 || iIsGooglePlayServicesAvailable == 3 || iIsGooglePlayServicesAvailable == 9) {
            Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, C0000.decode(new byte[]{87}, "9a31641142234a", 0.0f), iIsGooglePlayServicesAvailable);
            googleApiAvailability.zae(context, iIsGooglePlayServicesAvailable, errorResolutionIntent == null ? null : PendingIntent.getActivity(context, 0, errorResolutionIntent, 201326592));
        }
    }
}
