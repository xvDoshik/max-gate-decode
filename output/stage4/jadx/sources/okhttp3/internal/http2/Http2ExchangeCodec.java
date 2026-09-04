package okhttp3.internal.http2;

import androidx.room.RoomOpenHelper;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
import okhttp3.internal.http.RealInterceptorChain;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final List HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(C0000.decode(new byte[]{82, 94, 93, 11, 4, 82, 68, 15, 11, 90}, "113ea10fd4d88f", false), C0000.decode(new byte[]{80, 9, 74, 21}, "8f9af0e6", 0.0f), C0000.decode(new byte[]{93, 87, 6, 68, 73, 4, 14, 88, 67, 86}, "62c4deb153"), C0000.decode(new byte[]{72, 64, 92, 72, 73, 31, 80, 86, 90, 93, 93, 87, 76, 91, 92, 94}, "823002394384", true), C0000.decode(new byte[]{18, 83}, "f6b3f9133af482", 0.0f), C0000.decode(new byte[]{71, 23, 4, 86, 66, 5, 0, 17, 73, 85, 86, 86, 92, 1, 12, 86, 86}, "3ee81cecd085"), C0000.decode(new byte[]{92, 95, 90, 11, 83, 89, 87, 86}, "919d70", 0.0f), C0000.decode(new byte[]{22, 21, 6, 64, 0, 84, 4}, "cea2a0ab766fbbb0", 0.0f), C0000.decode(new byte[]{13, 8, 87, 67, 11, 10, 80}, "7e27ce44d7", 0.0f), C0000.decode(new byte[]{89, 70, 3, 21, 10}, "c6bab41b076fe3f4", true), C0000.decode(new byte[]{11, 16, 2, 10, 84, 11, 80}, "1cab1f5de4fb0af7", 0.0f), C0000.decode(new byte[]{91, 5, 64, 71, 95, 95, 67, 90, 17, 26}, "ad537013ec", 4));
    public static final List HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(C0000.decode(new byte[]{81, 9, 10, 91, 4, 82, 18, 94, 95, 95}, "2fd5a1f70121adce", false), C0000.decode(new byte[]{13, 86, 22, 21}, "e9ea3f", 4), C0000.decode(new byte[]{88, 6, 7, 18, 31, 89, 95, 10, 20, 7}, "3cbb28"), C0000.decode(new byte[]{20, 65, 91, 27, 26, 20, 7, 92, 90, 13, 6, 90, 16, 90, 91, 13}, "d34cc9", 7), C0000.decode(new byte[]{17, 6}, "ec568b189e"), C0000.decode(new byte[]{22, 74, 81, 15, 70, 82, 1, 70, 25, 80, 12, 91, 95, 5, 92, 90, 3}, "b80a54d445"), C0000.decode(new byte[]{87, 95, 6, 88, 82, 12, 95, 83}, "21e76e14fb79f7"), C0000.decode(new byte[]{17, 73, 82, 69, 87, 6, 82}, "d9576b7573becd30", 0.0f));
    public volatile boolean canceled;
    public final RealInterceptorChain chain;
    public final RealConnection connection;
    public final Http2Connection http2Connection;
    public final Protocol protocol;
    public volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        this.connection = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        List list = okHttpClient.protocols;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = list.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(9);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() throws SocketTimeoutException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        return this.stream.source;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        Headers headers;
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            throw new IOException(C0000.decode(new byte[]{68, 71, 17, 3, 0, 90, 23, 68, 2, 21, 15, 16, 67, 19, 0, 20, 4, 86, 67, 86, 7}, "73cfa7", 1));
        }
        synchronized (http2Stream) {
            http2Stream.readTimeout.enter();
            while (http2Stream.headersQueue.isEmpty() && http2Stream.errorCode == 0) {
                try {
                    try {
                        http2Stream.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    http2Stream.readTimeout.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            http2Stream.readTimeout.exitAndThrowIfTimedOut();
            if (http2Stream.headersQueue.isEmpty()) {
                IOException iOException = http2Stream.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                throw new StreamResetException(http2Stream.errorCode);
            }
            headers = (Headers) http2Stream.headersQueue.removeFirst();
        }
        Protocol protocol = this.protocol;
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        RoomOpenHelper roomOpenHelper = null;
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            String strValue = headers.value(i);
            if (Intrinsics.areEqual(strName, C0000.decode(new byte[]{10, 66, 77, 7, 21, 76, 16}, "019fa9c3a0"))) {
                roomOpenHelper = Headers.Companion.parse(C0000.decode(new byte[]{46, 50, 101, 96, 26, 9, 76, 6, 25}, "ff1058b79a2b", 7) + strValue);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strName)) {
                arrayList.add(strName);
                arrayList.add(StringsKt.trim(strValue).toString());
            }
        }
        if (roomOpenHelper == null) {
            throw new ProtocolException(C0000.decode(new byte[]{115, 76, 68, 86, 84, 23, 86, 81, 22, 19, 14, 64, 67, 2, 71, 64, 69, 19, 20, 91, 82, 2, 87, 80, 68, 20, 90, 92, 67, 67, 67, 71, 83, 71, 81, 93, 67}, "64437c35", 7));
        }
        Response.Builder builder = new Response.Builder();
        builder.protocol = protocol;
        builder.code = roomOpenHelper.version;
        builder.message = (String) roomOpenHelper.delegate;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ConnectionPool connectionPool = new ConnectionPool(23);
        ((ArrayList) connectionPool.delegate).addAll(Arrays.asList(strArr));
        builder.headers = connectionPool;
        if (z && builder.code == 100) {
            return null;
        }
        return builder;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (HttpHeaders.promisesBody(response)) {
            return Util.headersContentLength(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequestHeaders(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        boolean z;
        if (this.stream != null) {
            return;
        }
        boolean z2 = ((RoomOpenHelper) request.body) != null;
        Headers headers = (Headers) request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, (String) request.method));
        ByteString byteString = Header.TARGET_PATH;
        HttpUrl httpUrl = (HttpUrl) request.url;
        String strEncodedPath = httpUrl.encodedPath();
        String strEncodedQuery = httpUrl.encodedQuery();
        if (strEncodedQuery != null) {
            strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
        }
        arrayList.add(new Header(byteString, strEncodedPath));
        String str = headers.get("Host");
        if (str != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, str));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, httpUrl.scheme));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String lowerCase = headers.name(i2).toLowerCase(Locale.US);
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals("te") && Intrinsics.areEqual(headers.value(i2), "trailers"))) {
                arrayList.add(new Header(lowerCase, headers.value(i2)));
            }
        }
        Http2Connection http2Connection = this.http2Connection;
        boolean z3 = !z2;
        synchronized (http2Connection.writer) {
            synchronized (http2Connection) {
                try {
                    if (http2Connection.nextStreamId > 1073741823) {
                        http2Connection.shutdown(8);
                    }
                    if (http2Connection.isShutdown) {
                        throw new ConnectionShutdownException();
                    }
                    i = http2Connection.nextStreamId;
                    http2Connection.nextStreamId = i + 2;
                    http2Stream = new Http2Stream(i, http2Connection, z3, false, null);
                    z = !z2 || http2Connection.writeBytesTotal >= http2Connection.writeBytesMaximum || http2Stream.writeBytesTotal >= http2Stream.writeBytesMaximum;
                    if (http2Stream.isOpen()) {
                        http2Connection.streams.put(Integer.valueOf(i), http2Stream);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            http2Connection.writer.headers(z3, i, arrayList);
        }
        if (z) {
            http2Connection.writer.flush();
        }
        this.stream = http2Stream;
        if (this.canceled) {
            this.stream.closeLater(9);
            throw new IOException("Canceled");
        }
        Http2Stream.StreamTimeout streamTimeout = this.stream.readTimeout;
        long j = this.chain.readTimeoutMillis;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        streamTimeout.timeout(j, timeUnit);
        this.stream.writeTimeout.timeout(this.chain.writeTimeoutMillis, timeUnit);
    }
}
