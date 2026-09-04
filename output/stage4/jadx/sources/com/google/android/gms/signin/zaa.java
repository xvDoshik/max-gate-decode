package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import okhttp3.Headers;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zaa extends Headers.Companion {
    public abstract Api.Client buildClient(Context context, Looper looper, zzac zzacVar, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
}
