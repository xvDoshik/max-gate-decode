package okhttp3.internal.http;

import androidx.room.RoomOpenHelper;
import androidx.tracing.Trace;
import androidx.work.Configuration;
import com.google.android.gms.common.api.internal.zam;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.GzipSource;
import okio.RealBufferedSource;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BridgeInterceptor implements Interceptor {
    public final /* synthetic */ int $r8$classId;
    public final Object cookieJar;

    public /* synthetic */ BridgeInterceptor(int i, Object obj) {
        this.$r8$classId = i;
        this.cookieJar = obj;
    }

    public static int retryAfter(Response response, int i) {
        String str = response.headers.get(C0000.decode(new byte[]{55, 87, 71, 66, 72, 24, 113, 80, 17, 82, 65}, "e2301506e73e"));
        if (str == null) {
            str = null;
        }
        if (str == null) {
            return i;
        }
        if (Pattern.compile(C0000.decode(new byte[]{111, 87, 77}, "33fb85")).matcher(str).matches()) {
            return Integer.valueOf(str).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x016a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0174  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:71:0x0100  */
    /* JADX WARN: Code duplicated, block: B:75:0x0106  */
    /* JADX WARN: Code duplicated, block: B:80:0x0119  */
    /* JADX WARN: Code duplicated, block: B:81:0x011e  */
    /* JADX WARN: Code duplicated, block: B:91:0x013f  */
    /* JADX WARN: Code duplicated, block: B:95:0x014b  */
    public Request followUpRequest(Response response, Exchange exchange) throws ProtocolException {
        String strDecode;
        OkHttpClient okHttpClient;
        String str;
        Request request;
        HttpUrl.Builder builder;
        HttpUrl httpUrlBuild;
        Request.Builder builderNewBuilder;
        boolean z;
        Response response2;
        RealConnection realConnection;
        Route route = (exchange == null || (realConnection = (RealConnection) exchange.connection) == null) ? null : realConnection.route;
        int i = response.code;
        String str2 = (String) response.request.method;
        if (i == 307 || i == 308) {
            strDecode = C0000.decode(new byte[]{53, 101, 121, 51, 127, 45, 127, 33}, "e76c9d1efd");
            okHttpClient = (OkHttpClient) this.cookieJar;
            if (okHttpClient.followRedirects) {
                str = response.headers.get(C0000.decode(new byte[]{117, 94, 1, 5, 16, 94, 90, 13}, "91bdd75c59"));
                if (str == null) {
                    str = null;
                }
                request = response.request;
                if (str != null) {
                    HttpUrl httpUrl = (HttpUrl) request.url;
                    httpUrl.getClass();
                    try {
                        builder = new HttpUrl.Builder();
                        builder.parse$okhttp(httpUrl, str);
                    } catch (IllegalArgumentException unused) {
                        builder = null;
                    }
                    if (builder != null) {
                        httpUrlBuild = builder.build();
                    } else {
                        httpUrlBuild = null;
                    }
                    if (httpUrlBuild != null && (Intrinsics.areEqual(httpUrlBuild.scheme, ((HttpUrl) request.url).scheme) || okHttpClient.followSslRedirects)) {
                        builderNewBuilder = request.newBuilder();
                        if (Trace.permitsRequestBody(str2)) {
                            int i2 = response.code;
                            z = !str2.equals(strDecode) || i2 == 308 || i2 == 307;
                            if (!str2.equals(strDecode) || i2 == 308 || i2 == 307) {
                                builderNewBuilder.method(str2, z ? (RoomOpenHelper) request.body : null);
                            } else {
                                builderNewBuilder.method(C0000.decode(new byte[]{117, 118, 55}, "23c4b8"), null);
                            }
                            if (!z) {
                                builderNewBuilder.removeHeader(C0000.decode(new byte[]{100, 23, 7, 13, 21, 94, 87, 67, 27, 118, 92, 82, 91, 0, 89, 11, 1}, "0efcf82163214d"));
                                builderNewBuilder.removeHeader(C0000.decode(new byte[]{33, 11, 87, 22, 80, 90, 67, 75, 40, 84, 86, 82, 22, 12}, "bd9b547fd185"));
                                builderNewBuilder.removeHeader(C0000.decode(new byte[]{34, 95, 15, 23, 82, 89, 21, 29, 53, 26, 71, 82}, "a0ac77"));
                            }
                        }
                        if (!Util.canReuseConnectionFor((HttpUrl) request.url, httpUrlBuild)) {
                            builderNewBuilder.removeHeader(C0000.decode(new byte[]{118, 67, 18, 91, 94, 17, 94, 76, 7, 71, 88, 12, 89}, "76f31c"));
                        }
                        builderNewBuilder.url = httpUrlBuild;
                        return builderNewBuilder.build();
                    }
                }
            }
        } else {
            if (i == 401) {
                ((OkHttpClient) this.cookieJar).authenticator.getClass();
                return null;
            }
            if (i != 421) {
                if (i == 503) {
                    Response response3 = response.priorResponse;
                    if ((response3 == null || response3.code != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                        return response.request;
                    }
                } else {
                    if (i == 407) {
                        if (route.proxy.type() != Proxy.Type.HTTP) {
                            throw new ProtocolException(C0000.decode(new byte[]{54, 82, 6, 3, 94, 70, 6, 84, 23, 43, 99, 101, 52, 104, 53, 52, 120, 104, 58, 111, 118, 54, 99, 121, 68, 31, 81, 86, 0, 25, 67, 83, 88, 7, 82, 17, 19, 95, 12, 10, 82, 16, 13, 95, 67, 67, 66, 66, 13, 89, 2, 70, 71, 66, 12, 72, 78}, "d7ef70c07c71"));
                        }
                        ((OkHttpClient) this.cookieJar).proxyAuthenticator.getClass();
                        return null;
                    }
                    if (i != 408) {
                        switch (i) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                strDecode = C0000.decode(new byte[]{53, 101, 121, 51, 127, 45, 127, 33}, "e76c9d1efd");
                                okHttpClient = (OkHttpClient) this.cookieJar;
                                if (okHttpClient.followRedirects) {
                                    str = response.headers.get(C0000.decode(new byte[]{117, 94, 1, 5, 16, 94, 90, 13}, "91bdd75c59"));
                                    if (str == null) {
                                        str = null;
                                    }
                                    request = response.request;
                                    if (str != null) {
                                        HttpUrl httpUrl2 = (HttpUrl) request.url;
                                        httpUrl2.getClass();
                                        builder = new HttpUrl.Builder();
                                        builder.parse$okhttp(httpUrl2, str);
                                        if (builder != null) {
                                            httpUrlBuild = builder.build();
                                        } else {
                                            httpUrlBuild = null;
                                        }
                                        if (httpUrlBuild != null) {
                                            builderNewBuilder = request.newBuilder();
                                            if (Trace.permitsRequestBody(str2)) {
                                                int i3 = response.code;
                                                if (str2.equals(strDecode)) {
                                                }
                                                if (str2.equals(strDecode)) {
                                                    builderNewBuilder.method(str2, z ? (RoomOpenHelper) request.body : null);
                                                } else {
                                                    builderNewBuilder.method(str2, z ? (RoomOpenHelper) request.body : null);
                                                }
                                                if (!z) {
                                                    builderNewBuilder.removeHeader(C0000.decode(new byte[]{100, 23, 7, 13, 21, 94, 87, 67, 27, 118, 92, 82, 91, 0, 89, 11, 1}, "0efcf82163214d"));
                                                    builderNewBuilder.removeHeader(C0000.decode(new byte[]{33, 11, 87, 22, 80, 90, 67, 75, 40, 84, 86, 82, 22, 12}, "bd9b547fd185"));
                                                    builderNewBuilder.removeHeader(C0000.decode(new byte[]{34, 95, 15, 23, 82, 89, 21, 29, 53, 26, 71, 82}, "a0ac77"));
                                                }
                                            }
                                            if (!Util.canReuseConnectionFor((HttpUrl) request.url, httpUrlBuild)) {
                                                builderNewBuilder.removeHeader(C0000.decode(new byte[]{118, 67, 18, 91, 94, 17, 94, 76, 7, 71, 88, 12, 89}, "76f31c"));
                                            }
                                            builderNewBuilder.url = httpUrlBuild;
                                            return builderNewBuilder.build();
                                        }
                                    }
                                }
                            default:
                                return null;
                        }
                    } else if (((OkHttpClient) this.cookieJar).retryOnConnectionFailure && (((response2 = response.priorResponse) == null || response2.code != 408) && retryAfter(response, 0) <= 0)) {
                        return response.request;
                    }
                }
            } else if (exchange != null && !Intrinsics.areEqual(((Address) ((Configuration) exchange.finder).taskExecutor).url.host, ((RealConnection) exchange.connection).route.address.url.host)) {
                RealConnection realConnection2 = (RealConnection) exchange.connection;
                synchronized (realConnection2) {
                    realConnection2.noCoalescedConnections = true;
                }
                return response.request;
            }
        }
        return null;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        ResponseBody responseBody;
        Response responseProceed;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        switch (this.$r8$classId) {
            case 0:
                String strDecode = C0000.decode(new byte[]{38, 94, 10, 68, 87, 93, 17, 28, 33, 94, 81, 92, 1, 88, 10, 87}, "e1d023", 3);
                String strDecode2 = C0000.decode(new byte[]{108, 16, 87, 19, 73, 113, 95, 3, 8, 23}, "9c2ad08ffcecf833", 0);
                HttpUrl.Companion companion = (HttpUrl.Companion) this.cookieJar;
                String strDecode3 = C0000.decode(new byte[]{81, 31, 88, 19}, "6e1c17f216", false);
                String strDecode4 = C0000.decode(new byte[]{117, 1, 82, 7, 73, 22, 73, 113, 87, 87, 91, 7, 93, 12, 86}, "4b1b9bd4944c", true);
                String strDecode5 = C0000.decode(new byte[]{114, 88, 95, 8, 93, 80, 66, 13, 94, 89}, "171f836d", 0.0f);
                String strDecode6 = C0000.decode(new byte[]{121, 90, 69, 67}, "15670157bd40b9", true);
                String strDecode7 = C0000.decode(new byte[]{108, 74, 88, 11, 18, 94, 84, 66, 25, 39, 87, 90, 87, 92, 80, 11, 6}, "889ea8104b99", 2);
                String strDecode8 = C0000.decode(new byte[]{39, 94, 10, 76, 86, 11, 70, 25, 48, 72, 20, 93}, "d1d83e24", 0.0f);
                String strDecode9 = C0000.decode(new byte[]{117, 89, 94, 16, 80, 93, 71, 24, 121, 83, 87, 84, 71, 91}, "660d5335569333d2");
                Request request = realInterceptorChain.request;
                Request.Builder builderNewBuilder = request.newBuilder();
                HttpUrl httpUrl = (HttpUrl) request.url;
                Headers headers = (Headers) request.headers;
                RoomOpenHelper roomOpenHelper = (RoomOpenHelper) request.body;
                if (roomOpenHelper != null) {
                    MediaType mediaType = (MediaType) roomOpenHelper.configuration;
                    if (mediaType != null) {
                        builderNewBuilder.header(strDecode8, mediaType.mediaType);
                    }
                    long j = roomOpenHelper.version;
                    if (j != -1) {
                        builderNewBuilder.header(strDecode9, String.valueOf(j));
                        builderNewBuilder.removeHeader(strDecode7);
                    } else {
                        builderNewBuilder.header(strDecode7, C0000.decode(new byte[]{7, 94, 19, 11, 93, 85, 92}, "d6fe6083", 3));
                        builderNewBuilder.removeHeader(strDecode9);
                    }
                }
                boolean z = false;
                if (headers.get(strDecode6) == null) {
                    builderNewBuilder.header(strDecode6, Util.toHostHeader(httpUrl, false));
                }
                if (headers.get(strDecode5) == null) {
                    builderNewBuilder.header(strDecode5, C0000.decode(new byte[]{127, 81, 1, 69, 72, 34, 88, 15, 66, 81}, "44d5ec4f", 7));
                }
                if (headers.get(strDecode4) == null && headers.get(C0000.decode(new byte[]{107, 4, 86, 84, 6}, "9e83c58916045286")) == null) {
                    builderNewBuilder.header(strDecode4, strDecode3);
                    z = true;
                }
                companion.getClass();
                if (headers.get(strDecode2) == null) {
                    builderNewBuilder.header(strDecode2, C0000.decode(new byte[]{14, 15, 11, 65, 77, 19, 74, 5, 79, 85, 81, 27, 9}, "adc59ce1"));
                }
                Response responseProceed2 = realInterceptorChain.proceed(builderNewBuilder.build());
                Headers headers2 = responseProceed2.headers;
                HttpHeaders.receiveHeaders(companion, httpUrl, headers2);
                Response.Builder builderNewBuilder2 = responseProceed2.newBuilder();
                builderNewBuilder2.request = request;
                if (z) {
                    String str = headers2.get(strDecode);
                    if (str == null) {
                        str = null;
                    }
                    if (strDecode3.equalsIgnoreCase(str) && HttpHeaders.promisesBody(responseProceed2) && (responseBody = responseProceed2.body) != null) {
                        GzipSource gzipSource = new GzipSource(responseBody.source());
                        ConnectionPool connectionPoolNewBuilder = headers2.newBuilder();
                        connectionPoolNewBuilder.removeAll(strDecode);
                        connectionPoolNewBuilder.removeAll(strDecode9);
                        builderNewBuilder2.headers = connectionPoolNewBuilder.build().newBuilder();
                        String str2 = headers2.get(strDecode8);
                        builderNewBuilder2.body = new RealResponseBody(str2 != null ? str2 : null, -1L, new RealBufferedSource(gzipSource));
                    }
                }
                return builderNewBuilder2.build();
            default:
                Request request2 = realInterceptorChain.request;
                RealCall realCall = realInterceptorChain.call;
                List list = EmptyList.INSTANCE;
                Response response = null;
                int i = 0;
                Request requestFollowUpRequest = request2;
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        if (realCall.interceptorScopedExchange != null) {
                            throw new IllegalStateException(C0000.decode(new byte[]{113, 80, 1, 6, 15, 68, 5, 85, 88, 88, 7, 5, 28}, "28deddc414ba"));
                        }
                        synchronized (realCall) {
                            try {
                                if (realCall.responseBodyOpen) {
                                    throw new IllegalStateException(C0000.decode(new byte[]{90, 0, 87, 11, 11, 16, 70, 85, 5, 13, 4, 23, 2, 69, 94, 6, 78, 65, 75, 0, 21, 17, 3, 75, 16, 70, 3, 82, 0, 4, 69, 16, 92, 65, 77, 13, 1, 68, 22, 74, 1, 16, 8, 88, 22, 22, 16, 17, 92, 18, 73, 10, 10, 23, 3, 24, 13, 21, 65, 68, 23, 12, 92, 15, 25, 14, 73, 0, 10, 94, 70, 72, 8, 3, 0, 68, 6, 69, 83, 2, 85, 13, 25, 23, 1, 23, 22, 87, 10, 21, 4, 25, 0, 9, 95, 16, 92, 73, 16}, "9a9eddf8dfa7ce0c", 3));
                                }
                                if (realCall.requestBodyOpen) {
                                    throw new IllegalStateException(C0000.decode(new byte[]{39, 10, 92, 5, 14, 65, 7, 4, 90, 89, 85, 92, 75}, "db9feaae3508e305"));
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z2) {
                            RealConnectionPool realConnectionPool = realCall.connectionPool;
                            HttpUrl httpUrl2 = (HttpUrl) requestFollowUpRequest.url;
                            OkHttpClient okHttpClient = realCall.client;
                            if (httpUrl2.isHttps) {
                                SSLSocketFactory sSLSocketFactory2 = okHttpClient.sslSocketFactoryOrNull;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException(C0000.decode(new byte[]{116, 40, 115, 114, 103, 103, 32, 61, 49, 21, 90, 92, 91, 29, 22, 80, 89, 90, 0, 11, 17}, "7d6353eee852", 0.0f));
                                }
                                HostnameVerifier hostnameVerifier2 = okHttpClient.hostnameVerifier;
                                certificatePinner = okHttpClient.certificatePinner;
                                sSLSocketFactory = sSLSocketFactory2;
                                hostnameVerifier = hostnameVerifier2;
                            } else {
                                sSLSocketFactory = null;
                                hostnameVerifier = null;
                                certificatePinner = null;
                            }
                            realCall.exchangeFinder = new Configuration(realConnectionPool, new Address(httpUrl2.host, httpUrl2.port, okHttpClient.dns, okHttpClient.socketFactory, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator, okHttpClient.protocols, okHttpClient.connectionSpecs, okHttpClient.proxySelector), realCall);
                        }
                        try {
                            if (realCall.canceled) {
                                throw new IOException(C0000.decode(new byte[]{115, 89, 95, 81, 4, 91, 1, 81}, "0812a7d5", 0));
                            }
                            try {
                                try {
                                    responseProceed = realInterceptorChain.proceed(requestFollowUpRequest);
                                } catch (RouteException e) {
                                    if (!recover(e.lastConnectException, realCall, requestFollowUpRequest, false)) {
                                        IOException iOException = e.firstConnectException;
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            ExceptionsKt.addSuppressed(iOException, (Exception) it.next());
                                        }
                                        throw iOException;
                                    }
                                    IOException iOException2 = e.firstConnectException;
                                    ArrayList arrayList = new ArrayList(list.size() + 1);
                                    arrayList.addAll(list);
                                    arrayList.add(iOException2);
                                    realCall.exitNetworkInterceptorExchange$okhttp(true);
                                    list = arrayList;
                                    z2 = false;
                                }
                            } catch (IOException e2) {
                                if (!recover(e2, realCall, requestFollowUpRequest, !(e2 instanceof ConnectionShutdownException))) {
                                    Iterator it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        ExceptionsKt.addSuppressed(e2, (Exception) it2.next());
                                    }
                                    throw e2;
                                }
                                ArrayList arrayList2 = new ArrayList(list.size() + 1);
                                arrayList2.addAll(list);
                                arrayList2.add(e2);
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                list = arrayList2;
                                z2 = false;
                            }
                        } catch (Throwable th2) {
                            realCall.exitNetworkInterceptorExchange$okhttp(true);
                            throw th2;
                        }
                        break;
                    }
                    if (response != null) {
                        Response.Builder builderNewBuilder3 = responseProceed.newBuilder();
                        Response.Builder builderNewBuilder4 = response.newBuilder();
                        builderNewBuilder4.body = null;
                        Response responseBuild = builderNewBuilder4.build();
                        if (responseBuild.body != null) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{21, 23, 89, 88, 70, 49, 86, 16, 71, 89, 10, 70, 0, 75, 82, 88, 80, 26, 19, 66, 10, 22, 10, 64, 9, 9}, "ee074c3c76d5", false));
                        }
                        builderNewBuilder3.priorResponse = responseBuild;
                        responseProceed = builderNewBuilder3.build();
                    }
                    response = responseProceed;
                    requestFollowUpRequest = followUpRequest(response, realCall.interceptorScopedExchange);
                    if (requestFollowUpRequest == null) {
                        realCall.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    ResponseBody responseBody2 = response.body;
                    if (responseBody2 != null) {
                        Util.closeQuietly(responseBody2);
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException(C0000.decode(new byte[]{48, 94, 86, 65, 11, 84, 89, 75, 19, 4, 10, 90, 8, 94, 78, 76, 19, 69, 23, 64, 86, 19, 16, 83, 23, 69, 74, 91, 70}, "d19af5723be6", 0.0f) + i);
                    }
                    realCall.exitNetworkInterceptorExchange$okhttp(true);
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0046  */
    /* JADX WARN: Code duplicated, block: B:36:0x004d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0050  */
    /* JADX WARN: Code duplicated, block: B:49:0x0067 A[ADDED_TO_REGION, DONT_GENERATE, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:51:0x0069 A[Catch: all -> 0x0081, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:47:0x0063, B:51:0x0069, B:55:0x007d), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0086  */
    /* JADX WARN: Code duplicated, block: B:63:0x0088  */
    /* JADX WARN: Code duplicated, block: B:64:0x008a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0090  */
    /* JADX WARN: Code duplicated, block: B:69:0x0097  */
    /* JADX WARN: Code duplicated, block: B:75:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean recover(IOException iOException, RealCall realCall, Request request, boolean z) {
        Configuration configuration;
        int i;
        boolean zHasNext;
        Route route;
        zam zamVar;
        RouteSelector routeSelector;
        RealConnection realConnection;
        if (!((OkHttpClient) this.cookieJar).retryOnConnectionFailure || ((z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException))) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            configuration = realCall.exchangeFinder;
            i = configuration.maxJobSchedulerId;
            if (i != 0) {
                if (((Route) configuration.runnableScheduler) != null) {
                    zHasNext = true;
                } else {
                    route = null;
                    if (i <= 1) {
                        synchronized (realConnection) {
                            if (realConnection.routeFailureCount != 0) {
                                route = realConnection.route;
                            }
                        }
                    }
                    if (route != null) {
                        configuration.runnableScheduler = route;
                    } else {
                        zamVar = (zam) configuration.workerFactory;
                        zHasNext = zamVar != null ? routeSelector.hasNext() : routeSelector.hasNext();
                    }
                    zHasNext = true;
                }
            } else if (((Route) configuration.runnableScheduler) != null) {
                zHasNext = true;
            } else {
                route = null;
                if (i <= 1) {
                    synchronized (realConnection) {
                        if (realConnection.routeFailureCount != 0) {
                            route = realConnection.route;
                        }
                    }
                }
                if (route != null) {
                    configuration.runnableScheduler = route;
                } else {
                    zamVar = (zam) configuration.workerFactory;
                    if (zamVar != null) {
                    }
                }
                zHasNext = true;
            }
            if (!zHasNext) {
                return true;
            }
        } else if ((iOException instanceof SocketTimeoutException) && !z) {
            configuration = realCall.exchangeFinder;
            i = configuration.maxJobSchedulerId;
            if (i != 0 && configuration.contentUriTriggerWorkersLimit == 0 && configuration.maxSchedulerLimit == 0) {
                zHasNext = false;
            } else if (((Route) configuration.runnableScheduler) != null) {
                zHasNext = true;
            } else {
                route = null;
                if (i <= 1 && configuration.contentUriTriggerWorkersLimit <= 1 && configuration.maxSchedulerLimit <= 0 && (realConnection = ((RealCall) configuration.clock).connection) != null) {
                    synchronized (realConnection) {
                        if (realConnection.routeFailureCount != 0 && Util.canReuseConnectionFor(realConnection.route.address.url, ((Address) configuration.taskExecutor).url)) {
                            route = realConnection.route;
                        }
                    }
                }
                if (route != null) {
                    configuration.runnableScheduler = route;
                } else {
                    zamVar = (zam) configuration.workerFactory;
                    if ((zamVar != null || !zamVar.hasNext()) && (routeSelector = (RouteSelector) configuration.inputMergerFactory) != null) {
                    }
                }
                zHasNext = true;
            }
            if (!zHasNext) {
                return true;
            }
        }
        return false;
    }
}
