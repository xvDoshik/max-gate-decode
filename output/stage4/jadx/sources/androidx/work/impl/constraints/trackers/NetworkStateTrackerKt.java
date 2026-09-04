package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat$Api16Impl;
import androidx.work.SystemClock;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NetworkStateTrackerKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{40, 85, 67, 69, 13, 23, 9, 101, 18, 81, 67, 87, 54, 23, 3, 85, 13, 85, 69}, "f072beb6"));
    }

    public static final NetworkState getActiveNetworkState(ConnectivityManager connectivityManager) {
        boolean zHasCapabilityCompat;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilitiesCompat = NetworkApi21.getNetworkCapabilitiesCompat(connectivityManager, NetworkApi23.getActiveNetworkCompat(connectivityManager));
            zHasCapabilityCompat = networkCapabilitiesCompat != null ? NetworkApi21.hasCapabilityCompat(networkCapabilitiesCompat, 16) : false;
        } catch (SecurityException unused) {
            SystemClock.get().getClass();
        }
        return new NetworkState(z, zHasCapabilityCompat, ConnectivityManagerCompat$Api16Impl.isActiveNetworkMetered(connectivityManager), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
