package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.work.SystemClock;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import com.base.template.services.CommandService$registerNetworkReceiver$cb$1;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NetworkStateTracker24 extends ConstraintTracker {
    public final ConnectivityManager connectivityManager;
    public final CommandService$registerNetworkReceiver$cb$1 networkCallback;

    public NetworkStateTracker24(Context context, Dispatcher dispatcher) {
        super(context, dispatcher);
        this.connectivityManager = (ConnectivityManager) this.appContext.getSystemService(C0000.decode(new byte[]{81, 89, 8, 12, 6, 82, 22, 89, 78, 89, 71, 73}, "26fbc1b08030a949"));
        this.networkCallback = new CommandService$registerNetworkReceiver$cb$1(1, this);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void startTracking() {
        try {
            SystemClock systemClock = SystemClock.get();
            int i = NetworkStateTrackerKt.$r8$clinit;
            systemClock.getClass();
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException unused) {
            SystemClock systemClock2 = SystemClock.get();
            int i2 = NetworkStateTrackerKt.$r8$clinit;
            systemClock2.getClass();
        } catch (SecurityException unused2) {
            SystemClock systemClock3 = SystemClock.get();
            int i3 = NetworkStateTrackerKt.$r8$clinit;
            systemClock3.getClass();
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void stopTracking() {
        try {
            SystemClock systemClock = SystemClock.get();
            int i = NetworkStateTrackerKt.$r8$clinit;
            systemClock.getClass();
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException unused) {
            SystemClock systemClock2 = SystemClock.get();
            int i2 = NetworkStateTrackerKt.$r8$clinit;
            systemClock2.getClass();
        } catch (SecurityException unused2) {
            SystemClock systemClock3 = SystemClock.get();
            int i3 = NetworkStateTrackerKt.$r8$clinit;
            systemClock3.getClass();
        }
    }
}
