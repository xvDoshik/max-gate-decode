package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NetworkApi23 {
    public static final Network getActiveNetworkCompat(ConnectivityManager connectivityManager) {
        return connectivityManager.getActiveNetwork();
    }
}
