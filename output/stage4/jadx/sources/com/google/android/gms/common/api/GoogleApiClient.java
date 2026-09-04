package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class GoogleApiClient {

    public interface ConnectionCallbacks {
        void onConnected();

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    static {
        Collections.newSetFromMap(new WeakHashMap());
    }
}
