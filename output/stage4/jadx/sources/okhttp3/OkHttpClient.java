package okhttp3;

import androidx.work.impl.WorkLauncherImpl;
import com.base.template.network.WsPersistManager$connect$1$1;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.net.ProtocolException;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealCall.AsyncCall;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OkHttpClient implements Cloneable {
    public final HttpUrl.Companion authenticator;
    public final CharsKt certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final List connectionSpecs;
    public final HttpUrl.Companion cookieJar;
    public final Dispatcher dispatcher;
    public final HttpUrl.Companion dns;
    public final TransportImpl$$ExternalSyntheticLambda0 eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List interceptors;
    public final long minWebSocketMessageToCompress;
    public final List networkInterceptors;
    public final List protocols;
    public final HttpUrl.Companion proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final ConnectionPool routeDatabase;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManager;
    public static final List DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    public final class Builder {
        public HttpUrl.Companion authenticator;
        public CharsKt certificateChainCleaner;
        public CertificatePinner certificatePinner;
        public int connectTimeout;
        public List connectionSpecs;
        public HttpUrl.Companion cookieJar;
        public HttpUrl.Companion dns;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public long minWebSocketMessageToCompress;
        public List protocols;
        public HttpUrl.Companion proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public ConnectionPool routeDatabase;
        public SocketFactory socketFactory;
        public SSLSocketFactory sslSocketFactoryOrNull;
        public int writeTimeout;
        public X509TrustManager x509TrustManagerOrNull;
        public Dispatcher dispatcher = new Dispatcher();
        public ConnectionPool connectionPool = new ConnectionPool(0);
        public final ArrayList interceptors = new ArrayList();
        public final ArrayList networkInterceptors = new ArrayList();
        public TransportImpl$$ExternalSyntheticLambda0 eventListenerFactory = new TransportImpl$$ExternalSyntheticLambda0(20);
        public boolean retryOnConnectionFailure = true;

        public Builder() {
            HttpUrl.Companion companion = HttpUrl.Companion.NONE;
            this.authenticator = companion;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = HttpUrl.Companion.NO_COOKIES;
            this.dns = HttpUrl.Companion.SYSTEM;
            this.proxyAuthenticator = companion;
            this.socketFactory = SocketFactory.getDefault();
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        public final void sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (!sSLSocketFactory.equals(this.sslSocketFactoryOrNull) || !x509TrustManager.equals(this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            Platform platform = Platform.platform;
            this.certificateChainCleaner = Platform.platform.buildCertificateChainCleaner(x509TrustManager);
            this.x509TrustManagerOrNull = x509TrustManager;
        }
    }

    public OkHttpClient(Builder builder) throws NoSuchAlgorithmException, KeyStoreException {
        this.dispatcher = builder.dispatcher;
        this.connectionPool = builder.connectionPool;
        this.interceptors = Collections.unmodifiableList(new ArrayList(builder.interceptors));
        this.networkInterceptors = Collections.unmodifiableList(new ArrayList(builder.networkInterceptors));
        this.eventListenerFactory = builder.eventListenerFactory;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.authenticator = builder.authenticator;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.cookieJar = builder.cookieJar;
        this.dns = builder.dns;
        ProxySelector proxySelector = builder.proxySelector;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.proxySelector = proxySelector == null ? NullProxySelector.INSTANCE : proxySelector;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.socketFactory = builder.socketFactory;
        List list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.protocols = builder.protocols;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.connectTimeoutMillis = builder.connectTimeout;
        this.readTimeoutMillis = builder.readTimeout;
        this.writeTimeoutMillis = builder.writeTimeout;
        this.minWebSocketMessageToCompress = builder.minWebSocketMessageToCompress;
        ConnectionPool connectionPool = builder.routeDatabase;
        this.routeDatabase = connectionPool == null ? new ConnectionPool(25) : connectionPool;
        if (list != null && list.isEmpty()) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.sslSocketFactoryOrNull = null;
                this.certificateChainCleaner = null;
                this.x509TrustManager = null;
                this.certificatePinner = CertificatePinner.DEFAULT;
                break;
            }
            if (((ConnectionSpec) it.next()).isTls) {
                SSLSocketFactory sSLSocketFactory = builder.sslSocketFactoryOrNull;
                if (sSLSocketFactory == null) {
                    Platform platform = Platform.platform;
                    X509TrustManager x509TrustManagerPlatformTrustManager = Platform.platform.platformTrustManager();
                    this.x509TrustManager = x509TrustManagerPlatformTrustManager;
                    this.sslSocketFactoryOrNull = Platform.platform.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                    CharsKt charsKtBuildCertificateChainCleaner = Platform.platform.buildCertificateChainCleaner(x509TrustManagerPlatformTrustManager);
                    this.certificateChainCleaner = charsKtBuildCertificateChainCleaner;
                    CertificatePinner certificatePinner = builder.certificatePinner;
                    this.certificatePinner = Intrinsics.areEqual(certificatePinner.certificateChainCleaner, charsKtBuildCertificateChainCleaner) ? certificatePinner : new CertificatePinner(certificatePinner.pins, charsKtBuildCertificateChainCleaner);
                    break;
                }
                this.sslSocketFactoryOrNull = sSLSocketFactory;
                CharsKt charsKt = builder.certificateChainCleaner;
                this.certificateChainCleaner = charsKt;
                this.x509TrustManager = builder.x509TrustManagerOrNull;
                CertificatePinner certificatePinner2 = builder.certificatePinner;
                this.certificatePinner = Intrinsics.areEqual(certificatePinner2.certificateChainCleaner, charsKt) ? certificatePinner2 : new CertificatePinner(certificatePinner2.pins, charsKt);
                break;
            }
        }
        X509TrustManager x509TrustManager = this.x509TrustManager;
        CharsKt charsKt2 = this.certificateChainCleaner;
        SSLSocketFactory sSLSocketFactory2 = this.sslSocketFactoryOrNull;
        List list2 = this.networkInterceptors;
        List list3 = this.interceptors;
        if (list3.contains(null)) {
            throw new IllegalStateException((C0000.decode(new byte[]{126, 77, 88, 10, 23, 95, 95, 23, 6, 68, 83, 82, 22, 68, 95, 74, 14, 70}, "084f761cc607f0", true) + list3).toString());
        }
        if (list2.contains(null)) {
            throw new IllegalStateException((C0000.decode(new byte[]{118, 70, 15, 8, 70, 15, 4, 71, 22, 12, 68, 95, 70, 90, 10, 66, 93, 65, 0, 1, 22, 21, 14, 65, 91, 67}, "83cdfaa3ac64f3d6", 7) + list2).toString());
        }
        List list4 = this.connectionSpecs;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((ConnectionSpec) it2.next()).isTls) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException(C0000.decode(new byte[]{74, 74, 94, 55, 91, 7, 9, 7, 70, 114, 87, 85, 21, 93, 75, 64, 18, 89, 9, 68, 12, 23, 94, 88}, "992d4dbb2466a2", 5));
                    }
                    if (charsKt2 == null) {
                        throw new IllegalStateException(C0000.decode(new byte[]{85, 80, 64, 21, 90, 82, 95, 86, 83, 21, 86, 119, 94, 84, 91, 15, 112, 88, 83, 84, 92, 4, 65, 20, 11, 8, 18, 15, 70, 88, 90}, "652a34", 0));
                    }
                    if (x509TrustManager == null) {
                        throw new IllegalStateException(C0000.decode(new byte[]{74, 87, 5, 93, 97, 23, 71, 22, 16, 123, 86, 90, 86, 5, 87, 16, 21, 89, 8, 69, 92, 16, 8, 90}, "2b5d5e2ed6747b", 7));
                    }
                    return;
                }
            }
        }
        String strDecode = C0000.decode(new byte[]{37, 80, 4, 0, 83, 17, 80, 88, 15, 91, 1, 7, 72}, "f8ac8169f7dc", 0);
        if (sSLSocketFactory2 != null) {
            throw new IllegalStateException(strDecode);
        }
        if (charsKt2 != null) {
            throw new IllegalStateException(strDecode);
        }
        if (x509TrustManager != null) {
            throw new IllegalStateException(strDecode);
        }
        if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException(strDecode);
        }
    }

    public final Object clone() {
        return super.clone();
    }

    public final RealWebSocket newWebSocket(Request request, WsPersistManager$connect$1$1 wsPersistManager$connect$1$1) {
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.INSTANCE, request, wsPersistManager$connect$1$1, new Random(), 0, this.minWebSocketMessageToCompress);
        if (((Headers) request.headers).get(C0000.decode(new byte[]{106, 83, 2, 78, 53, 81, 91, 101, 14, 0, 9, 81, 77, 27, 36, 27, 22, 81, 87, 69, 8, 12, 12, 71}, "96acb4", false)) != null) {
            realWebSocket.failWebSocket(new ProtocolException(C0000.decode(new byte[]{107, 3, 67, 71, 81, 68, 16, 66, 9, 82, 88, 2, 87, 64, 20, 89, 11, 22, 65, 71, 92, 20, 95, 91, 64, 67, 1, 6, 91, 23, 30, 53, 87, 81, 25, 96, 1, 0, 50, 88, 90, 13, 87, 70, 25, 114, 28, 22, 4, 89, 74, 15, 93, 92, 71, 16}, "9f2247dba7", 0.0f)));
            return realWebSocket;
        }
        Builder builder = new Builder();
        builder.dispatcher = this.dispatcher;
        builder.connectionPool = this.connectionPool;
        CollectionsKt__MutableCollectionsKt.addAll(builder.interceptors, this.interceptors);
        CollectionsKt__MutableCollectionsKt.addAll(builder.networkInterceptors, this.networkInterceptors);
        builder.eventListenerFactory = this.eventListenerFactory;
        builder.retryOnConnectionFailure = this.retryOnConnectionFailure;
        builder.authenticator = this.authenticator;
        builder.followRedirects = this.followRedirects;
        builder.followSslRedirects = this.followSslRedirects;
        builder.cookieJar = this.cookieJar;
        builder.dns = this.dns;
        builder.proxySelector = this.proxySelector;
        builder.proxyAuthenticator = this.proxyAuthenticator;
        builder.socketFactory = this.socketFactory;
        builder.sslSocketFactoryOrNull = this.sslSocketFactoryOrNull;
        builder.x509TrustManagerOrNull = this.x509TrustManager;
        builder.connectionSpecs = this.connectionSpecs;
        builder.protocols = this.protocols;
        builder.hostnameVerifier = this.hostnameVerifier;
        builder.certificatePinner = this.certificatePinner;
        builder.certificateChainCleaner = this.certificateChainCleaner;
        builder.connectTimeout = this.connectTimeoutMillis;
        builder.readTimeout = this.readTimeoutMillis;
        builder.writeTimeout = this.writeTimeoutMillis;
        builder.minWebSocketMessageToCompress = this.minWebSocketMessageToCompress;
        builder.routeDatabase = this.routeDatabase;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        builder.eventListenerFactory = new TransportImpl$$ExternalSyntheticLambda0(20);
        ArrayList arrayList = new ArrayList(RealWebSocket.ONLY_HTTP1);
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{73, 19, 87, 69, 93, 6, 94, 13, 71, 68, 14, 70, 21, 69, 16, 82, 86, 15, 76, 80, 91, 11, 17, 9, 6, 59, 19, 65, 15, 94, 66, 110, 82, 15, 87, 70, 94, 0, 85, 6, 81, 68, 12, 65, 70, 89, 68, 69, 73, 78, 9, 31, 3, 95, 17}, "9a812e1a4dc3f101", true) + arrayList).toString());
        }
        if (arrayList.contains(protocol) && arrayList.size() > 1) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{72, 22, 90, 64, 9, 85, 87, 8, 70, 20, 5, 89, 86, 16, 84, 93, 8, 95, 86, 3, 21, 92, 84, 105, 72, 22, 92, 91, 20, 105, 83, 10, 90, 67, 10, 83, 92, 3, 80, 20, 5, 87, 86, 10, 90, 64, 70, 67, 75, 1, 21, 91, 18, 94, 93, 22, 21, 68, 20, 89, 76, 11, 86, 91, 10, 69, 2, 68}, "8d54f6", true) + arrayList).toString());
        }
        if (arrayList.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{17, 20, 88, 70, 95, 85, 13, 14, 18, 70, 90, 71, 67, 66, 66, 12, 14, 18, 23, 81, 95, 88, 22, 3, 8, 8, 23, 90, 68, 66, 18, 77, 80, 72, 7, 8, 16}, "af7206bb") + arrayList).toString());
        }
        if (arrayList.contains(null)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{66, 16, 11, 22, 11, 1, 91, 9, 65, 66, 9, 23, 23, 22, 20, 11, 93, 22, 68, 1, 11, 12, 64, 4, 91, 12, 68, 12, 17, 14, 88}, "2bdbdb4e", false));
        }
        arrayList.remove(Protocol.SPDY_3);
        if (!arrayList.equals(builder.protocols)) {
            builder.routeDatabase = null;
        }
        builder.protocols = Collections.unmodifiableList(arrayList);
        OkHttpClient okHttpClient = new OkHttpClient(builder);
        Request.Builder builderNewBuilder = request.newBuilder();
        ((ConnectionPool) builderNewBuilder.headers).set(C0000.decode(new byte[]{108, 72, 4, 22, 83, 87, 85}, "98cd230f11ec", 0.0f), C0000.decode(new byte[]{21, 84, 83, 66, 90, 85, 88, 82, 16}, "b1115637db", 0.0f));
        ((ConnectionPool) builderNewBuilder.headers).set(C0000.decode(new byte[]{33, 14, 93, 95, 92, 90, 69, 10, 11, 92}, "ba31991cd27e", true), C0000.decode(new byte[]{96, 73, 87, 75, 85, 7, 4}, "59094ca2"));
        ((ConnectionPool) builderNewBuilder.headers).set(C0000.decode(new byte[]{49, 1, 82, 26, 97, 1, 7, 54, 88, 87, 94, 4, 22, 73, 122, 82, 79}, "bd176dee745a", 5), realWebSocket.key);
        ((ConnectionPool) builderNewBuilder.headers).set(C0000.decode(new byte[]{96, 87, 80, 30, 53, 84, 4, 102, 9, 2, 88, 87, 71, 30, 52, 84, 20, 70, 15, 14, 93}, "3233b1f5fa", 4), C0000.decode(new byte[]{80, 5}, "a6a130"));
        ((ConnectionPool) builderNewBuilder.headers).set(C0000.decode(new byte[]{102, 0, 84, 78, 101, 87, 7, 97, 93, 86, 13, 81, 18, 72, 112, 29, 67, 6, 92, 65, 12, 93, 92, 70}, "5e7c22e225f4fe", true), C0000.decode(new byte[]{67, 86, 65, 84, 7, 64, 64, 82, 84, 92, 79, 87, 86, 85, 95, 88, 22, 86}, "3339b3", 0.0f));
        Request requestBuild = builderNewBuilder.build();
        RealCall realCall = new RealCall(okHttpClient, requestBuild, true);
        realWebSocket.call = realCall;
        WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(realWebSocket, requestBuild);
        if (!realCall.executed.compareAndSet(false, true)) {
            throw new IllegalStateException(C0000.decode(new byte[]{119, 85, 19, 87, 83, 86, 26, 17, 114, 78, 83, 90, 20, 70, 87, 86}, "69a222c176", false));
        }
        Platform platform = Platform.platform;
        realCall.callStackTrace = Platform.platform.getStackTraceForCloseable();
        Dispatcher dispatcher = okHttpClient.dispatcher;
        RealCall.AsyncCall asyncCall = realCall.new AsyncCall(workLauncherImpl);
        synchronized (dispatcher) {
            ((ArrayDeque) dispatcher.readyAsyncCalls).add(asyncCall);
        }
        dispatcher.promoteAndExecute();
        return realWebSocket;
    }
}
