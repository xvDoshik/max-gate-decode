package com.base.template.network;

import com.base.template.NativeBridge;
import com.base.template.services.CommandService$onCreate$1$2;
import kotlin.text.StringsKt;
import okhttp3.WebSocket;
import okhttp3.internal.ws.RealWebSocket;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WsPersistManager$connect$1$1 {
    public final /* synthetic */ long $gen;

    public WsPersistManager$connect$1$1(long j) {
        this.$gen = j;
    }

    public final void onClosed(String str, int i) {
        Object obj = WsPersistManager.lock;
        WsPersistManager.access$onDisconnected(this.$gen);
    }

    public final void onOpen(WebSocket webSocket) {
        String strDecode = C0000.decode(new byte[]{72, 64, 67, 29, 19, 82, 65, 91, 17, 3, 66, 16, 11, 21, 79, 67, 87, 11, 83, 70, 89, 21}, "3b7dc7ca", 0.0f);
        Object obj = WsPersistManager.lock;
        long j = this.$gen;
        synchronized (obj) {
            if (WsPersistManager.generation.get() != j) {
                try {
                    ((RealWebSocket) webSocket).call.cancel();
                } catch (Exception unused) {
                }
                return;
            }
            WsPersistManager.isConnected = true;
            WsPersistManager.lastConnectedAtMs = System.currentTimeMillis();
            WsPersistManager.lastPongMs = WsPersistManager.lastConnectedAtMs;
            WsPersistManager.reconnectDelay = 3000L;
            String teamId = NativeBridge.getTeamId();
            try {
                ((RealWebSocket) webSocket).send(strDecode + WsPersistManager.deviceId + C0000.decode(new byte[]{20, 26, 21, 16, 13, 83, 17, 91, 19}, "667dd73a1cc4", 0.0f) + StringsKt.take(teamId, 16) + C0000.decode(new byte[]{67, 72}, "a5d27b5c03", 4));
            } catch (Exception unused2) {
            }
            Object obj2 = WsPersistManager.lock;
            Thread thread = WsPersistManager.heartbeatThread;
            if (thread != null) {
                thread.interrupt();
            }
            WsPersistManager.heartbeatThread = null;
            Thread thread2 = new Thread(new WsPersistManager$$ExternalSyntheticLambda2(0));
            thread2.setDaemon(true);
            thread2.start();
            WsPersistManager.heartbeatThread = thread2;
            try {
                CommandService$onCreate$1$2 commandService$onCreate$1$2 = WsPersistManager.connectCallback;
                if (commandService$onCreate$1$2 != null) {
                    commandService$onCreate$1$2.invoke();
                }
            } catch (Exception unused3) {
            }
        }
    }
}
