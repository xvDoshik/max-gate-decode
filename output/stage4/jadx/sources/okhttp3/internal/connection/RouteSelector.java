package okhttp3.internal.connection;

import androidx.room.RoomOpenHelper;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.EmptyList;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource;
import okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource;
import okhttp3.internal.http1.Http1ExchangeCodec$UnknownLengthSource;
import okio.Buffer;
import okio.BufferedSink;
import okio.DeflaterSink;
import okio.ForwardingTimeout;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RouteSelector implements ExchangeCodec {
    public final Object address;
    public Object inetSocketAddresses;
    public int nextProxyIndex;
    public final Object postponedRoutes;
    public final Object proxies;
    public final Object routeDatabase;

    public RouteSelector(Address address, ConnectionPool connectionPool, RealCall realCall) {
        List listImmutableListOf;
        this.address = address;
        this.routeDatabase = connectionPool;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.proxies = emptyList;
        this.inetSocketAddresses = emptyList;
        this.postponedRoutes = new ArrayList();
        URI uri = address.url.uri();
        if (uri.getHost() == null) {
            listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = address.proxySelector.select(uri);
            listImmutableListOf = (listSelect == null || listSelect.isEmpty()) ? Util.immutableListOf(Proxy.NO_PROXY) : Collections.unmodifiableList(new ArrayList(listSelect));
        }
        this.proxies = listImmutableListOf;
        this.nextProxyIndex = 0;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        Socket socket = ((RealConnection) this.routeDatabase).rawSocket;
        if (socket != null) {
            Util.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request request, long j) {
        Object obj = request.body;
        boolean zEqualsIgnoreCase = C0000.decode(new byte[]{5, 13, 71, 90, 9, 6, 2}, "fe24bc", 0).equalsIgnoreCase(((Headers) request.headers).get(C0000.decode(new byte[]{48, 16, 85, 95, 16, 94, 84, 23, 26, 33, 86, 83, 11, 6, 93, 95, 4}, "db41c81e7d80", true)));
        String strDecode = C0000.decode(new byte[]{65, 70, 85, 65, 85, 14, 22}, "224504639759516a", true);
        if (zEqualsIgnoreCase) {
            if (this.nextProxyIndex == 1) {
                this.nextProxyIndex = 2;
                return new Sink() { // from class: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSink
                    public boolean closed;
                    public final ForwardingTimeout timeout;

                    {
                        this.timeout = new ForwardingTimeout(((BufferedSink) this.this$0.inetSocketAddresses).timeout());
                    }

                    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                    public final synchronized void close() {
                        if (this.closed) {
                            return;
                        }
                        this.closed = true;
                        ((BufferedSink) this.this$0.inetSocketAddresses).writeUtf8(C0000.decode(new byte[]{3, 61, 110, 107, 107}, "30dfa6df379d7f", false));
                        ForwardingTimeout forwardingTimeout = this.timeout;
                        Timeout timeout = forwardingTimeout.delegate;
                        forwardingTimeout.delegate = Timeout.NONE;
                        timeout.clearDeadline();
                        timeout.clearTimeout();
                        this.this$0.nextProxyIndex = 3;
                    }

                    @Override // okio.Sink, java.io.Flushable
                    public final synchronized void flush() {
                        if (this.closed) {
                            return;
                        }
                        ((BufferedSink) this.this$0.inetSocketAddresses).flush();
                    }

                    @Override // okio.Sink
                    public final Timeout timeout() {
                        return this.timeout;
                    }

                    @Override // okio.Sink
                    public final void write(long j2, Buffer buffer) {
                        BufferedSink bufferedSink = (BufferedSink) this.this$0.inetSocketAddresses;
                        if (this.closed) {
                            throw new IllegalStateException(C0000.decode(new byte[]{2, 85, 90, 70, 93, 80}, "a9558486", false));
                        }
                        if (j2 == 0) {
                            return;
                        }
                        bufferedSink.writeHexadecimalUnsignedLong(j2);
                        String strDecode2 = C0000.decode(new byte[]{107, 57}, "f3eb0e", true);
                        bufferedSink.writeUtf8(strDecode2);
                        bufferedSink.write(j2, buffer);
                        bufferedSink.writeUtf8(strDecode2);
                    }
                };
            }
            throw new IllegalStateException((strDecode + this.nextProxyIndex).toString());
        }
        if (j == -1) {
            throw new IllegalStateException(C0000.decode(new byte[]{123, 89, 87, 11, 90, 23, 65, 71, 64, 19, 7, 85, 85, 66, 89, 24, 75, 0, 68, 22, 4, 71, 64, 65, 0, 91, 92, 27, 24, 79, 80, 17, 93, 12, 20, 64, 20, 2, 10, 65, 86, 9, 93, 92, 25, 0, 91, 0, 14, 80, 93, 15, 5, 20, 87, 16, 24, 89, 25, 14, 91, 12, 22, 90, 20, 2, 13, 90, 76, 7, 86, 76, 25, 9, 80, 13, 6, 64, 92, 64}, "889e5ca44ab48b", true));
        }
        if (this.nextProxyIndex == 1) {
            this.nextProxyIndex = 2;
            return new DeflaterSink(this);
        }
        throw new IllegalStateException((strDecode + this.nextProxyIndex).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        ((BufferedSink) this.inetSocketAddresses).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        ((BufferedSink) this.inetSocketAddresses).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return (RealConnection) this.routeDatabase;
    }

    public boolean hasNext() {
        return this.nextProxyIndex < ((List) this.proxies).size() || !((ArrayList) this.postponedRoutes).isEmpty();
    }

    public Http1ExchangeCodec$FixedLengthSource newFixedLengthSource(long j) {
        if (this.nextProxyIndex == 4) {
            this.nextProxyIndex = 5;
            return new Http1ExchangeCodec$FixedLengthSource(this, j);
        }
        throw new IllegalStateException((C0000.decode(new byte[]{69, 76, 0, 67, 92, 91, 20}, "68a79a447bd9d0", 0.0f) + this.nextProxyIndex).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0L);
        }
        String str = response.headers.get(C0000.decode(new byte[]{98, 69, 80, 87, 67, 82, 6, 75, 29, 38, 92, 81, 88, 84, 95, 89, 86}, "671904c90c2270", 0.0f));
        if (str == null) {
            str = null;
        }
        boolean zEqualsIgnoreCase = C0000.decode(new byte[]{91, 80, 23, 15, 93, 84, 5}, "88ba61aa6a923c", 3).equalsIgnoreCase(str);
        String strDecode = C0000.decode(new byte[]{68, 67, 0, 65, 92, 13, 19}, "77a5973eb4de37");
        if (zEqualsIgnoreCase) {
            final HttpUrl httpUrl = (HttpUrl) response.request.url;
            if (this.nextProxyIndex == 4) {
                this.nextProxyIndex = 5;
                return new Http1ExchangeCodec$AbstractSource(httpUrl) { // from class: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource
                    public long bytesRemainingInChunk;
                    public boolean hasMoreChunks;
                    public final HttpUrl url;

                    {
                        super(this.this$0);
                        this.url = httpUrl;
                        this.bytesRemainingInChunk = -1L;
                        this.hasMoreChunks = true;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        boolean zSkipAll;
                        if (this.closed) {
                            return;
                        }
                        if (this.hasMoreChunks) {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            try {
                                zSkipAll = Util.skipAll(this, 100);
                            } catch (IOException unused) {
                                zSkipAll = false;
                            }
                            if (!zSkipAll) {
                                ((RealConnection) this.this$0.routeDatabase).noNewExchanges$okhttp();
                                responseBodyComplete();
                            }
                        }
                        this.closed = true;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
                    
                        if (r10.hasMoreChunks == false) goto L28;
                     */
                    @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource, okio.Source
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final long read(long r11, okio.Buffer r13) throws java.io.IOException {
                        /*
                            Method dump skipped, instruction units count: 319
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource.read(long, okio.Buffer):long");
                    }
                };
            }
            throw new IllegalStateException((strDecode + this.nextProxyIndex).toString());
        }
        long jHeadersContentLength = Util.headersContentLength(response);
        if (jHeadersContentLength != -1) {
            return newFixedLengthSource(jHeadersContentLength);
        }
        if (this.nextProxyIndex == 4) {
            this.nextProxyIndex = 5;
            ((RealConnection) this.routeDatabase).noNewExchanges$okhttp();
            return new Http1ExchangeCodec$UnknownLengthSource(this);
        }
        throw new IllegalStateException((strDecode + this.nextProxyIndex).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z) {
        HeadersReader headersReader = (HeadersReader) this.postponedRoutes;
        int i = this.nextProxyIndex;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException((C0000.decode(new byte[]{22, 69, 82, 77, 6, 10, 18}, "e139c02851eac9", 0.0f) + this.nextProxyIndex).toString());
        }
        try {
            String utf8LineStrict = headersReader.source.readUtf8LineStrict(headersReader.headerLimit);
            headersReader.headerLimit -= (long) utf8LineStrict.length();
            RoomOpenHelper roomOpenHelper = Headers.Companion.parse(utf8LineStrict);
            int i2 = roomOpenHelper.version;
            Response.Builder builder = new Response.Builder();
            builder.protocol = (Protocol) roomOpenHelper.configuration;
            builder.code = i2;
            builder.message = (String) roomOpenHelper.delegate;
            builder.headers = headersReader.readHeaders().newBuilder();
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.nextProxyIndex = 3;
                return builder;
            }
            if (102 > i2 || i2 >= 200) {
                this.nextProxyIndex = 4;
                return builder;
            }
            this.nextProxyIndex = 3;
            return builder;
        } catch (EOFException e) {
            throw new IOException(C0000.decode(new byte[]{70, 89, 86, 74, 19, 83, 82, 70, 86, 83, 19, 87, 13, 82, 17, 93, 85, 23, 64, 70, 17, 83, 80, 95, 19, 88, 93, 18}, "3732c612").concat(((RealConnection) this.routeDatabase).route.address.url.redact()), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        String str = response.headers.get(C0000.decode(new byte[]{97, 75, 2, 90, 65, 84, 92, 19, 29, 119, 93, 83, 90, 93, 10, 90, 85}, "59c4229a0230", true));
        if (str == null) {
            str = null;
        }
        if (C0000.decode(new byte[]{90, 94, 69, 88, 89, 84, 6}, "960621b6b7c414e0", 0.0f).equalsIgnoreCase(str)) {
            return -1L;
        }
        return Util.headersContentLength(response);
    }

    public void writeRequest(Headers headers, String str) {
        BufferedSink bufferedSink = (BufferedSink) this.inetSocketAddresses;
        if (this.nextProxyIndex != 0) {
            throw new IllegalStateException((C0000.decode(new byte[]{64, 16, 85, 67, 87, 3, 19}, "3d4729", 0.0f) + this.nextProxyIndex).toString());
        }
        BufferedSink bufferedSinkWriteUtf8 = bufferedSink.writeUtf8(str);
        String strDecode = C0000.decode(new byte[]{60, 62}, "14508ced84", true);
        bufferedSinkWriteUtf8.writeUtf8(strDecode);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            bufferedSink.writeUtf8(headers.name(i)).writeUtf8(C0000.decode(new byte[]{88, 68}, "bd973c")).writeUtf8(headers.value(i)).writeUtf8(strDecode);
        }
        bufferedSink.writeUtf8(strDecode);
        this.nextProxyIndex = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        Proxy.Type type = ((RealConnection) this.routeDatabase).route.proxy.type();
        StringBuilder sb = new StringBuilder();
        sb.append((String) request.method);
        sb.append(' ');
        HttpUrl httpUrl = (HttpUrl) request.url;
        if (httpUrl.isHttps || type != Proxy.Type.HTTP) {
            String strEncodedPath = httpUrl.encodedPath();
            String strEncodedQuery = httpUrl.encodedQuery();
            if (strEncodedQuery != null) {
                strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
            }
            sb.append(strEncodedPath);
        } else {
            sb.append(httpUrl);
        }
        sb.append(C0000.decode(new byte[]{17, 120, 109, 102, 53, 76, 87, 28, 87}, "1092ecf2f50cb3"));
        writeRequest((Headers) request.headers, sb.toString());
    }

    public RouteSelector(OkHttpClient okHttpClient, RealConnection realConnection, RealBufferedSource realBufferedSource, RealBufferedSink realBufferedSink) {
        this.address = okHttpClient;
        this.routeDatabase = realConnection;
        this.proxies = realBufferedSource;
        this.inetSocketAddresses = realBufferedSink;
        this.postponedRoutes = new HeadersReader(realBufferedSource);
    }
}
