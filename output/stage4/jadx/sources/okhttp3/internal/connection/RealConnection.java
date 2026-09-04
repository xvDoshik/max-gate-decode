package okhttp3.internal.connection;

import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.InputStreamSource;
import okio.Okio__JvmOkioKt;
import okio.OutputStreamSink;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.SocketAsyncTimeout;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealConnection extends Http2Connection.Listener {
    public Handshake handshake;
    public Http2Connection http2Connection;
    public boolean noCoalescedConnections;
    public boolean noNewExchanges;
    public Protocol protocol;
    public Socket rawSocket;
    public int refusedStreamCount;
    public final Route route;
    public int routeFailureCount;
    public RealBufferedSink sink;
    public Socket socket;
    public RealBufferedSource source;
    public int successCount;
    public int allocationLimit = 1;
    public final ArrayList calls = new ArrayList();
    public long idleAtNs = Long.MAX_VALUE;

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RealConnection(Route route) {
        this.route = route;
    }

    public static void connectFailed$okhttp(OkHttpClient okHttpClient, Route route, IOException iOException) {
        if (route.proxy.type() != Proxy.Type.DIRECT) {
            Address address = route.address;
            address.proxySelector.connectFailed(address.url.uri(), route.proxy.address(), iOException);
        }
        ConnectionPool connectionPool = okHttpClient.routeDatabase;
        synchronized (connectionPool) {
            ((LinkedHashSet) connectionPool.delegate).add(route);
        }
    }

    public final void connect(int i, int i2, int i3, boolean z, RealCall realCall) throws Throwable {
        if (this.protocol != null) {
            throw new IllegalStateException(C0000.decode(new byte[]{4, 93, 65, 93, 85, 83, 27, 24, 81, 94, 11, 95, 86, 91, 64, 82, 6}, "e13847b821", 0.0f));
        }
        Address address = this.route.address;
        List list = address.connectionSpecs;
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        if (address.sslSocketFactory == null) {
            if (!list.contains(ConnectionSpec.CLEARTEXT)) {
                throw new RouteException(new UnknownServiceException(C0000.decode(new byte[]{116, 126, 39, 37, 99, 109, 114, 106, 54, 68, 82, 86, 90, 95, 23, 10, 88, 90, 86, 70, 11, 11, 95, 25, 89, 93, 22, 68, 84, 87, 86, 80, 14, 1, 85, 25, 81, 93, 16, 68, 82, 85, 94, 87, 12, 16}, "72bd19", 0)));
            }
            String str = this.route.address.url.host;
            Platform platform = Platform.platform;
            if (!Platform.platform.isCleartextTrafficPermitted(str)) {
                throw new RouteException(new UnknownServiceException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{113, 116, 32, 117, 97, 53, 113, 59, 102, 24, 6, 91, 94, 12, 65, 13, 91, 91, 4, 64, 90, 14, 90, 67, 70, 87, 69}, "28e43a4c", 3), str, C0000.decode(new byte[]{19, 95, 14, 65, 16, 66, 7, 64, 94, 88, 21, 65, 85, 86, 66, 80, 74, 17, 15, 80, 68, 69, 13, 64, 88, 17, 18, 80, 83, 71, 16, 91, 71, 72, 65, 69, 95, 94, 11, 81, 74}, "31a502b2", 0.0f))));
            }
        } else if (address.protocols.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException(C0000.decode(new byte[]{43, 81, 106, 103, 106, 123, 125, 106, 109, 121, 45, 44, 98, 123, 125, 118, 117, 125, 18, 81, 2, 13, 91, 88, 76, 18, 80, 93, 18, 71, 16, 6, 81, 23, 79, 91, 70, 80, 18, 122, 55, 55, 101, 100}, "cc57822822", 1)));
        }
        RouteException routeException = null;
        while (true) {
            try {
                Route route = this.route;
                if (route.address.sslSocketFactory != null && route.proxy.type() == Proxy.Type.HTTP) {
                    connectTunnel(i, i2, i3);
                    if (this.rawSocket != null) {
                        break;
                    } else {
                        break;
                    }
                }
                connectSocket(i, i2);
                establishProtocol(connectionSpecSelector);
                InetSocketAddress inetSocketAddress = this.route.socketAddress;
                break;
            } catch (IOException e) {
                Socket socket = this.socket;
                if (socket != null) {
                    Util.closeQuietly(socket);
                }
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                this.http2Connection = null;
                this.allocationLimit = 1;
                InetSocketAddress inetSocketAddress2 = this.route.socketAddress;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    ExceptionsKt.addSuppressed(routeException.firstConnectException, e);
                    routeException.lastConnectException = e;
                }
                if (!z) {
                    throw routeException;
                }
                connectionSpecSelector.isFallback = true;
                if (!connectionSpecSelector.isFallbackPossible) {
                    throw routeException;
                }
                if (e instanceof ProtocolException) {
                    throw routeException;
                }
                if (e instanceof InterruptedIOException) {
                    throw routeException;
                }
                if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                    throw routeException;
                }
                if (e instanceof SSLPeerUnverifiedException) {
                    throw routeException;
                }
                if (!(e instanceof SSLException)) {
                    throw routeException;
                }
            }
        }
        Route route2 = this.route;
        if (route2.address.sslSocketFactory != null && route2.proxy.type() == Proxy.Type.HTTP && this.rawSocket == null) {
            throw new RouteException(new ProtocolException(C0000.decode(new byte[]{109, 87, 89, 69, 92, 0, 87, 77, 67, 65, 23, 94, 11, 80, 14, 20, 90, 87, 88, 11, 84, 2, 77, 93, 12, 91, 17, 16, 4, 65, 22, 81, 84, 72, 66, 0, 85, 91, 25, 6, 82}, "986e1a94c5b0e5b4")));
        }
        this.idleAtNs = System.nanoTime();
    }

    public final void connectSocket(int i, int i2) throws IOException {
        Route route = this.route;
        Proxy proxy = route.proxy;
        Address address = route.address;
        Proxy.Type type = proxy.type();
        int i3 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        int i4 = 1;
        Socket socketCreateSocket = (i3 == 1 || i3 == 2) ? address.socketFactory.createSocket() : new Socket(proxy);
        this.rawSocket = socketCreateSocket;
        InetSocketAddress inetSocketAddress = this.route.socketAddress;
        socketCreateSocket.setSoTimeout(i2);
        try {
            Platform platform = Platform.platform;
            Platform.platform.connectSocket(socketCreateSocket, this.route.socketAddress, i);
            try {
                Logger logger = Okio__JvmOkioKt.logger;
                SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socketCreateSocket);
                this.source = new RealBufferedSource(new InputStreamSource(socketAsyncTimeout, i4, new InputStreamSource(socketCreateSocket.getInputStream(), 0, socketAsyncTimeout)));
                SocketAsyncTimeout socketAsyncTimeout2 = new SocketAsyncTimeout(socketCreateSocket);
                this.sink = new RealBufferedSink(new OutputStreamSink(socketAsyncTimeout2, new OutputStreamSink(socketCreateSocket.getOutputStream(), socketAsyncTimeout2)));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), C0000.decode(new byte[]{16, 94, 64, 9, 65, 68, 65, 88, 16, 94, 18, 8, 67, 8, 90, 17, 1, 78, 81, 3, 70, 16, 95, 94, 10}, "d62f6d61", 0.0f))) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException(C0000.decode(new byte[]{118, 5, 11, 93, 87, 86, 19, 21, 95, 68, 1, 94, 92, 92, 86, 2, 68, 68, 22, 94, 18}, "0db1223a") + this.route.socketAddress);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void connectTunnel(int i, int i2, int i3) throws IOException {
        Request.Builder builder = new Request.Builder();
        Route route = this.route;
        builder.url = route.address.url;
        builder.method(C0000.decode(new byte[]{34, 122, 125, 122, 125, 115, 103}, "a5348035a9"), null);
        Address address = route.address;
        ((ConnectionPool) builder.headers).set(C0000.decode(new byte[]{122, 91, 22, 16}, "24ed56bb48f27e"), Util.toHostHeader(address.url, true));
        ((ConnectionPool) builder.headers).set(C0000.decode(new byte[]{102, 17, 11, 77, 78, 26, 114, 91, 94, 10, 87, 2, 64, 15, 89, 13}, "6cd577140d2a4f"), C0000.decode(new byte[]{126, 81, 82, 69, 28, 35, 15, 88, 78, 83}, "54751bc18600"));
        ((ConnectionPool) builder.headers).set(C0000.decode(new byte[]{101, 21, 82, 16, 31, 114, 95, 4, 90, 17}, "0f7b238a4e"), C0000.decode(new byte[]{92, 95, 91, 21, 68, 70, 77, 13, 30, 5, 1, 26, 3}, "343a06b904"));
        Request requestBuild = builder.build();
        ConnectionPool connectionPool = new ConnectionPool(23);
        connectionPool.set(C0000.decode(new byte[]{49, 65, 88, 72, 31, 26, 118, 23, 22, 93, 4, 93, 67, 89, 5, 86, 67, 7}, "a370f77bb5"), C0000.decode(new byte[]{121, 10, 113, 68, 69, 17, 28, 50, 17, 84, 7, 95, 69, 21, 12, 79, 83}, "6a901a1bc1b25ae9"));
        connectionPool.build();
        address.proxyAuthenticator.getClass();
        HttpUrl httpUrl = (HttpUrl) requestBuild.url;
        connectSocket(i, i2);
        String str = C0000.decode(new byte[]{122, 43, 121, 45, 36, 123, 102, 65}, "9d7ca82a") + Util.toHostHeader(httpUrl, true) + C0000.decode(new byte[]{68, 126, 96, 98, 105, 78, 9, 22, 82}, "d6469a88c05ac6");
        RealBufferedSource realBufferedSource = this.source;
        RealBufferedSink realBufferedSink = this.sink;
        RouteSelector routeSelector = new RouteSelector(null, this, realBufferedSource, realBufferedSink);
        Timeout timeout = realBufferedSource.source.timeout();
        long j = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(j, timeUnit);
        realBufferedSink.sink.timeout().timeout(i3, timeUnit);
        routeSelector.writeRequest((Headers) requestBuild.headers, str);
        routeSelector.finishRequest();
        Response.Builder responseHeaders = routeSelector.readResponseHeaders(false);
        responseHeaders.request = requestBuild;
        Response responseBuild = responseHeaders.build();
        int i4 = responseBuild.code;
        long jHeadersContentLength = Util.headersContentLength(responseBuild);
        if (jHeadersContentLength != -1) {
            Http1ExchangeCodec$FixedLengthSource http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource = routeSelector.newFixedLengthSource(jHeadersContentLength);
            Util.skipAll(http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource, Integer.MAX_VALUE);
            http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource.close();
        }
        if (i4 != 200) {
            if (i4 != 407) {
                throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{99, 87, 86, 30, 68, 86, 82, 67, 83, 93, 19, 20, 81, 64, 65, 88, 88, 74, 86, 70, 87, 92, 85, 82, 22, 95, 92, 20, 20, 112, 126, 121, 120, 124, 112, 50, 14, 19}, "693f4317"), i4));
            }
            address.proxyAuthenticator.getClass();
            throw new IOException(C0000.decode(new byte[]{117, 7, 81, 15, 84, 5, 25, 17, 90, 21, 2, 71, 16, 10, 81, 13, 71, 15, 91, 2, 69, 4, 25, 18, 92, 65, 11, 18, 20, 16, 91, 27, 74}, "3f8c1a9e55c2db4c"));
        }
        if (!realBufferedSource.bufferField.exhausted() || !realBufferedSink.bufferField.exhausted()) {
            throw new IOException(C0000.decode(new byte[]{97, 40, 53, 22, 70, 76, 92, 87, 3, 90, 68, 83, 17, 84, 3, 81, 71, 1, 2, 22, 70, 86, 93, 25, 11, 87, 10, 72, 68, 80, 28, 64, 80, 23, 71}, "5df62929f6d1d2e4"));
        }
    }

    public final void establishProtocol(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        SSLSocket sSLSocket;
        String selectedProtocol;
        Protocol protocol = Protocol.HTTP_2;
        Protocol protocol2 = Protocol.HTTP_1_1;
        Protocol protocol3 = Protocol.H2_PRIOR_KNOWLEDGE;
        Address address = this.route.address;
        SSLSocketFactory sSLSocketFactory = address.sslSocketFactory;
        if (sSLSocketFactory == null) {
            if (!address.protocols.contains(protocol3)) {
                this.socket = this.rawSocket;
                this.protocol = protocol2;
                return;
            } else {
                this.socket = this.rawSocket;
                this.protocol = protocol3;
                startHttp2();
                return;
            }
        }
        String strDecode = C0000.decode(new byte[]{113, 88, 17, 69, 12, 4, 94, 82, 25}, "97b1be37", 0.0f);
        String strDecode2 = C0000.decode(new byte[]{51, 18, 20, 20, 68, 20, 25, 18, 20, 20, 68, 20, 25, 18, 20, 72, 44, 91, 74, 70, 90, 85, 9, 81, 25}, "9244d4", false);
        try {
            Socket socket = this.rawSocket;
            HttpUrl httpUrl = address.url;
            int i = 1;
            SSLSocket sSLSocket2 = (SSLSocket) sSLSocketFactory.createSocket(socket, httpUrl.host, httpUrl.port, true);
            try {
                ConnectionSpec connectionSpecConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                if (connectionSpecConfigureSecureSocket.supportsTlsExtensions) {
                    Platform platform = Platform.platform;
                    Platform.platform.configureTlsExtensions(sSLSocket2, address.url.host, address.protocols);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Handshake handshake = Trace.get(session);
                int i2 = 0;
                if (!address.hostnameVerifier.verify(address.url.host, session)) {
                    List listPeerCertificates = handshake.peerCertificates();
                    if (listPeerCertificates.isEmpty()) {
                        throw new SSLPeerUnverifiedException(strDecode + address.url.host + C0000.decode(new byte[]{65, 8, 88, 65, 68, 69, 85, 20, 95, 84, 8, 3, 83, 21, 76, 93, 95, 70, 85, 87, 19, 18, 94, 83, 13, 80, 81, 18, 83, 65, 72}, "af75d30f62", 0.0f));
                    }
                    X509Certificate x509Certificate = (X509Certificate) listPeerCertificates.get(0);
                    StringBuilder sb = new StringBuilder(strDecode2);
                    sb.append(address.url.host);
                    sb.append(C0000.decode(new byte[]{16, 89, 87, 64, 66, 18, 0, 68, 80, 5, 11, 80, 0, 2, 58, 23, 24, 20, 66, 68, 69, 22, 25, 67, 66, 21, 68, 24, 16, 75, 24, 20, 66, 68, 6, 83, 75, 23, 11, 83, 13, 91, 81, 67, 93, 14, 66}, "0784bde69cb5d8", false));
                    CertificatePinner certificatePinner = CertificatePinner.DEFAULT;
                    sb.append(ExceptionsKt.pin(x509Certificate));
                    sb.append(C0000.decode(new byte[]{108, 23, 68, 22, 24, 69, 70, 23, 68, 22, 24, 69, 70, 23, 68, 74, 24, 69, 70, 23, 32, 120, 2, 69}, "f7d68e", true));
                    sb.append(x509Certificate.getSubjectDN().getName());
                    sb.append(C0000.decode(new byte[]{110, 16, 22, 24, 20, 70, 68, 16, 22, 24, 20, 70, 68, 16, 22, 68, 20, 70, 68, 16, 69, 77, 86, 12, 1, 83, 66, 121, 88, 18, 42, 81, 91, 93, 71, 92, 68}, "d0684f"));
                    List subjectAltNames = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7);
                    List subjectAltNames2 = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2);
                    ArrayList arrayList = new ArrayList(subjectAltNames2.size() + subjectAltNames.size());
                    arrayList.addAll(subjectAltNames);
                    arrayList.addAll(subjectAltNames2);
                    sb.append(arrayList);
                    sb.append(C0000.decode(new byte[]{56, 65, 20, 18, 20, 70, 24, 20, 65, 19, 19, 25, 16, 68, 18}, "2a424f84a3390d"));
                    throw new SSLPeerUnverifiedException(StringsKt__IndentKt.trimMargin$default(sb.toString()));
                }
                CertificatePinner certificatePinner2 = address.certificatePinner;
                this.handshake = new Handshake(handshake.tlsVersion, handshake.cipherSuite, handshake.localCertificates, new RealConnection$connectTls$1(certificatePinner2, handshake, address, i2));
                String str = address.url.host;
                Iterator it = certificatePinner2.pins.iterator();
                if (it.hasNext()) {
                    NetworkType$EnumUnboxingLocalUtility.m(it.next());
                    throw null;
                }
                if (connectionSpecConfigureSecureSocket.supportsTlsExtensions) {
                    Platform platform2 = Platform.platform;
                    selectedProtocol = Platform.platform.getSelectedProtocol(sSLSocket2);
                } else {
                    selectedProtocol = null;
                }
                this.socket = sSLSocket2;
                Logger logger = Okio__JvmOkioKt.logger;
                SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(sSLSocket2);
                this.source = new RealBufferedSource(new InputStreamSource(socketAsyncTimeout, i, new InputStreamSource(sSLSocket2.getInputStream(), i2, socketAsyncTimeout)));
                SocketAsyncTimeout socketAsyncTimeout2 = new SocketAsyncTimeout(sSLSocket2);
                this.sink = new RealBufferedSink(new OutputStreamSink(socketAsyncTimeout2, new OutputStreamSink(sSLSocket2.getOutputStream(), socketAsyncTimeout2)));
                if (selectedProtocol != null) {
                    Protocol protocol4 = Protocol.HTTP_1_0;
                    if (selectedProtocol.equals(C0000.decode(new byte[]{90, 76, 64, 70, 74, 0, 31, 5}, "2846e115f82617", 5))) {
                        protocol2 = protocol4;
                    } else if (!selectedProtocol.equals(C0000.decode(new byte[]{9, 76, 65, 18, 29, 80, 77, 83}, "a85b2acb", true))) {
                        if (selectedProtocol.equals(C0000.decode(new byte[]{9, 81, 111, 70, 68, 93, 91, 71, 62, 8, 94, 89, 65, 88, 81, 81, 6, 6}, "ac066445", 0.0f))) {
                            protocol2 = protocol3;
                        } else if (selectedProtocol.equals(C0000.decode(new byte[]{90, 7}, "25a834311333ac09"))) {
                            protocol2 = protocol;
                        } else {
                            protocol2 = Protocol.SPDY_3;
                            if (!selectedProtocol.equals(C0000.decode(new byte[]{74, 20, 80, 78, 23, 5, 77, 3}, "9d4786c256", 7))) {
                                protocol2 = Protocol.QUIC;
                                if (!selectedProtocol.equals(C0000.decode(new byte[]{73, 17, 90, 80}, "8d330f"))) {
                                    throw new IOException(C0000.decode(new byte[]{103, 10, 84, 76, 69, 93, 91, 76, 92, 84, 19, 73, 64, 88, 70, 11, 82, 91, 89, 2, 24}, "2d145888903927", 0.0f).concat(selectedProtocol));
                                }
                            }
                        }
                    }
                }
                this.protocol = protocol2;
                Platform platform3 = Platform.platform;
                Platform.platform.afterHandshake(sSLSocket2);
                if (this.protocol == protocol) {
                    startHttp2();
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform platform4 = Platform.platform;
                    Platform.platform.afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sSLSocket = null;
        }
    }

    public final boolean isEligible$okhttp(Address address, List list) {
        Handshake handshake;
        HttpUrl httpUrl = address.url;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (this.calls.size() < this.allocationLimit && !this.noNewExchanges) {
            Route route = this.route;
            Address address2 = route.address;
            Address address3 = route.address;
            if (address2.equalsNonHost$okhttp(address)) {
                if (!Intrinsics.areEqual(httpUrl.host, address3.url.host)) {
                    if (this.http2Connection != null && list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            Route route2 = (Route) it.next();
                            Proxy.Type type = route2.proxy.type();
                            Proxy.Type type2 = Proxy.Type.DIRECT;
                            if (type == type2 && route.proxy.type() == type2 && Intrinsics.areEqual(route.socketAddress, route2.socketAddress)) {
                                if (address.hostnameVerifier != OkHostnameVerifier.INSTANCE) {
                                    break;
                                }
                                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                                HttpUrl httpUrl2 = address3.url;
                                int i = httpUrl.port;
                                String str = httpUrl.host;
                                if (i != httpUrl2.port) {
                                    break;
                                }
                                if (!Intrinsics.areEqual(str, httpUrl2.host)) {
                                    if (!this.noCoalescedConnections && (handshake = this.handshake) != null) {
                                        List listPeerCertificates = handshake.peerCertificates();
                                        if (listPeerCertificates.isEmpty() || !OkHostnameVerifier.verify(str, (X509Certificate) listPeerCertificates.get(0))) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        break;
                                        break;
                                    }
                                }
                                try {
                                    CertificatePinner certificatePinner = address.certificatePinner;
                                    this.handshake.peerCertificates();
                                    Iterator it2 = certificatePinner.pins.iterator();
                                    if (!it2.hasNext()) {
                                        return true;
                                    }
                                    NetworkType$EnumUnboxingLocalUtility.m(it2.next());
                                    throw null;
                                } catch (SSLPeerUnverifiedException unused) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isHealthy(boolean z) {
        long j;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        long jNanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Socket socket2 = this.socket;
        RealBufferedSource realBufferedSource = this.source;
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.isShutdown) {
                    return false;
                }
                return http2Connection.degradedPongsReceived >= http2Connection.degradedPingsSent || jNanoTime < http2Connection.degradedPongDeadlineNs;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.idleAtNs;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !realBufferedSource.exhausted();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        int i = realInterceptorChain.readTimeoutMillis;
        Socket socket = this.socket;
        RealBufferedSource realBufferedSource = this.source;
        RealBufferedSink realBufferedSink = this.sink;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection);
        }
        socket.setSoTimeout(i);
        Timeout timeout = realBufferedSource.source.timeout();
        long j = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(j, timeUnit);
        realBufferedSink.sink.timeout().timeout(realInterceptorChain.writeTimeoutMillis, timeUnit);
        return new RouteSelector(okHttpClient, this, realBufferedSource, realBufferedSink);
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final synchronized void onSettings(Settings settings) {
        this.allocationLimit = (settings.set & 16) != 0 ? settings.values[4] : Integer.MAX_VALUE;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void onStream(Http2Stream http2Stream) {
        http2Stream.close(8, null);
    }

    public final void startHttp2() throws SocketException {
        int i;
        Socket socket = this.socket;
        RealBufferedSource realBufferedSource = this.source;
        RealBufferedSink realBufferedSink = this.sink;
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.INSTANCE;
        Request request = new Request(taskRunner);
        String str = this.route.address.url.host;
        request.headers = socket;
        request.method = Util.okHttpName + ' ' + str;
        request.body = realBufferedSource;
        request.tags = realBufferedSink;
        request.lazyCacheControl = this;
        Http2Connection http2Connection = new Http2Connection(request);
        this.http2Connection = http2Connection;
        Settings settings = Http2Connection.DEFAULT_SETTINGS;
        this.allocationLimit = (settings.set & 16) != 0 ? settings.values[4] : Integer.MAX_VALUE;
        Http2Writer http2Writer = http2Connection.writer;
        String strDecode = C0000.decode(new byte[]{90, 91, 70, 39, 46, 119, 119, 39, 113, 49, 45, 42, 40, 68}, "defda99b2e", true);
        synchronized (http2Writer) {
            try {
                if (http2Writer.closed) {
                    throw new IOException(C0000.decode(new byte[]{6, 85, 10, 68, 85, 7}, "e9e70c5fcfbd85"));
                }
                Logger logger = Http2Writer.logger;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.format(strDecode + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                http2Writer.sink.write(Http2.CONNECTION_PREFACE);
                http2Writer.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Writer http2Writer2 = http2Connection.writer;
        Settings settings2 = http2Connection.okHttpSettings;
        synchronized (http2Writer2) {
            try {
                if (http2Writer2.closed) {
                    throw new IOException(C0000.decode(new byte[]{86, 91, 87, 68, 84, 0}, "57871d", true));
                }
                http2Writer2.frameHeader(0, Integer.bitCount(settings2.set) * 6, 4, 0);
                int i2 = 0;
                while (i2 < 10) {
                    boolean z = true;
                    if (((1 << i2) & settings2.set) == 0) {
                        z = false;
                    }
                    if (z) {
                        if (i2 != 4) {
                            i = i2 != 7 ? i2 : 4;
                        } else {
                            i = 3;
                        }
                        http2Writer2.sink.writeShort(i);
                        http2Writer2.sink.writeInt(settings2.values[i2]);
                    }
                    i2++;
                }
                http2Writer2.sink.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int initialWindowSize = http2Connection.okHttpSettings.getInitialWindowSize();
        if (initialWindowSize != 65535) {
            http2Connection.writer.windowUpdate(0, initialWindowSize - 65535);
        }
        taskRunner.newQueue().schedule(new TaskQueue$execute$1(http2Connection.connectionName, http2Connection.readerRunnable, 0), 0L);
    }

    public final String toString() {
        Object objDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{38, 11, 87, 10, 7, 83, 17, 13, 86, 10, 25}, "ed9db0", false));
        Route route = this.route;
        sb.append(route.address.url.host);
        sb.append(':');
        sb.append(route.address.url.port);
        sb.append(C0000.decode(new byte[]{27, 24, 66, 69, 87, 73, 78, 4}, "7827817956b4", false));
        sb.append(route.proxy);
        sb.append(C0000.decode(new byte[]{68, 94, 10, 69, 16, 39, 0, 82, 23, 83, 23, 21, 89}, "d6e6df", 1));
        sb.append(route.socketAddress);
        sb.append(C0000.decode(new byte[]{21, 7, 10, 69, 9, 93, 22, 101, 76, 80, 71, 81, 8}, "5dc5a8d69934", 0.0f));
        Handshake handshake = this.handshake;
        if (handshake == null || (objDecode = handshake.cipherSuite) == null) {
            objDecode = C0000.decode(new byte[]{94, 88, 10, 80}, "07d5cb3b", 1);
        }
        sb.append(objDecode);
        sb.append(C0000.decode(new byte[]{68, 64, 23, 92, 71, 87, 7, 95, 9, 14}, "d0e338", 0.0f));
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
