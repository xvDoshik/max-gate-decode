package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NetworkApi21 {
    public static final NetworkCapabilities getNetworkCapabilitiesCompat(ConnectivityManager connectivityManager, Network network) {
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean hasCapabilityCompat(NetworkCapabilities networkCapabilities, int i) {
        return networkCapabilities.hasCapability(i);
    }

    public static final void unregisterNetworkCallbackCompat(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
