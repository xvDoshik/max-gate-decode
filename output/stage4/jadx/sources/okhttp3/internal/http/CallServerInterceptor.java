package okhttp3.internal.http;

import androidx.room.RoomOpenHelper;
import androidx.tracing.Trace;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Exchange.RequestBodySink;
import okhttp3.internal.connection.Exchange.ResponseBodySource;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CallServerInterceptor implements Interceptor {
    public final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x025f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0263  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fa A[Catch: IOException -> 0x0194, TryCatch #3 {IOException -> 0x0194, blocks: (B:61:0x017f, B:65:0x0187, B:74:0x01db, B:76:0x01eb, B:79:0x01f4, B:86:0x020d, B:88:0x0211, B:92:0x021e, B:94:0x0244, B:95:0x024c, B:96:0x0256, B:81:0x01fa, B:68:0x0197, B:73:0x01d5, B:99:0x0259, B:100:0x025c, B:69:0x019f, B:72:0x01be), top: B:114:0x017f, inners: #1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v3, types: [okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r12v4, types: [okhttp3.Response$Builder] */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws Throwable {
        ?? r12;
        IOException iOException;
        ?? responseHeaders;
        Response responseBuild;
        String strDecode = C0000.decode(new byte[]{37, 91, 89, 91, 85, 1, 64, 93, 9, 90}, "f4750b44", false);
        String strDecode2 = C0000.decode(new byte[]{83, 14, 14, 22, 3}, "0baef9861a2145ac", true);
        String strDecode3 = C0000.decode(new byte[]{42, 108, 49, 99, 18}, "b8e32d24", 7);
        Exchange exchange = realInterceptorChain.exchange;
        Request request = realInterceptorChain.request;
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) request.body;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            exchange.getClass();
            try {
                RealCall realCall = (RealCall) exchange.call;
                ExchangeCodec exchangeCodec = (ExchangeCodec) exchange.codec;
                exchangeCodec.writeRequestHeaders(request);
                ?? PermitsRequestBody = Trace.permitsRequestBody((String) request.method);
                boolean z = true;
                try {
                    if (PermitsRequestBody == 0 || roomOpenHelper == null) {
                        realCall.messageDone$okhttp(exchange, true, false, null);
                        PermitsRequestBody = 0;
                    } else {
                        if (C0000.decode(new byte[]{7, 81, 4, 28, 84, 90, 92, 16, 95, 15, 65, 84}, "6a41752d", 3).equalsIgnoreCase(((Headers) request.headers).get(C0000.decode(new byte[]{119, 30, 73, 7, 90, 17}, "2f9b9ebf627e", 0.0f)))) {
                            try {
                                exchangeCodec.flushRequest();
                                PermitsRequestBody = exchange.readResponseHeaders(true);
                            } catch (IOException e) {
                                exchange.trackFailure(e);
                                throw e;
                            }
                        } else {
                            PermitsRequestBody = 0;
                        }
                        if (PermitsRequestBody == 0) {
                            long j = ((RoomOpenHelper) request.body).version;
                            RealBufferedSink realBufferedSink = new RealBufferedSink(exchange.new RequestBodySink(exchangeCodec.createRequestBody(request, j), j));
                            byte[] bArr = (byte[]) roomOpenHelper.delegate;
                            int i = roomOpenHelper.version;
                            if (realBufferedSink.closed) {
                                throw new IllegalStateException(C0000.decode(new byte[]{86, 8, 87, 75, 87, 1}, "5d882ec69584ce", 0.0f));
                            }
                            realBufferedSink.bufferField.write(i, bArr);
                            realBufferedSink.emitCompleteSegments();
                            realBufferedSink.close();
                        } else {
                            realCall.messageDone$okhttp(exchange, true, false, null);
                            if (((RealConnection) exchange.connection).http2Connection == null) {
                                z = false;
                            }
                            if (!z) {
                                exchangeCodec.getConnection().noNewExchanges$okhttp();
                            }
                        }
                    }
                    try {
                        exchangeCodec.finishRequest();
                        iOException = null;
                        responseHeaders = PermitsRequestBody;
                    } catch (IOException e2) {
                        exchange.trackFailure(e2);
                        throw e2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    r12 = PermitsRequestBody;
                    if (e instanceof ConnectionShutdownException) {
                        throw e;
                    }
                    if (!exchange.hasFailure) {
                        throw e;
                    }
                    iOException = e;
                }
                if (responseHeaders == 0) {
                    try {
                        responseHeaders = r12;
                        responseHeaders = exchange.readResponseHeaders(false);
                    } catch (IOException e4) {
                        e = e4;
                        if (iOException != null) {
                            throw e;
                        }
                        ExceptionsKt.addSuppressed(iOException, e);
                        throw iOException;
                    }
                }
                responseHeaders = r12;
                responseHeaders.request = request;
                responseHeaders.handshake = ((RealConnection) exchange.connection).handshake;
                responseHeaders.sentRequestAtMillis = jCurrentTimeMillis;
                responseHeaders.receivedResponseAtMillis = System.currentTimeMillis();
                Response responseBuild2 = responseHeaders.build();
                int i2 = responseBuild2.code;
                if (i2 == 100 || (102 <= i2 && i2 < 200)) {
                    Response.Builder responseHeaders2 = exchange.readResponseHeaders(false);
                    responseHeaders2.request = request;
                    responseHeaders2.handshake = ((RealConnection) exchange.connection).handshake;
                    responseHeaders2.sentRequestAtMillis = jCurrentTimeMillis;
                    responseHeaders2.receivedResponseAtMillis = System.currentTimeMillis();
                    responseBuild2 = responseHeaders2.build();
                    i2 = responseBuild2.code;
                }
                try {
                    if (this.forWebSocket && i2 == 101) {
                        Response.Builder builderNewBuilder = responseBuild2.newBuilder();
                        builderNewBuilder.body = Util.EMPTY_RESPONSE;
                        responseBuild = builderNewBuilder.build();
                    } else {
                        Response.Builder builderNewBuilder2 = responseBuild2.newBuilder();
                        ExchangeCodec exchangeCodec2 = (ExchangeCodec) exchange.codec;
                        try {
                            String str = responseBuild2.headers.get(C0000.decode(new byte[]{116, 94, 91, 69, 83, 88, 67, 28, 97, 72, 70, 83}, "715166", 6));
                            if (str == null) {
                                str = null;
                            }
                            long jReportedContentLength = exchangeCodec2.reportedContentLength(responseBuild2);
                            builderNewBuilder2.body = new RealResponseBody(str, jReportedContentLength, new RealBufferedSource(exchange.new ResponseBodySource(exchangeCodec2.openResponseBodySource(responseBuild2), jReportedContentLength)));
                            responseBuild = builderNewBuilder2.build();
                        } catch (IOException e5) {
                            exchange.trackFailure(e5);
                            throw e5;
                        }
                    }
                    if (strDecode2.equalsIgnoreCase(((Headers) responseBuild.request.headers).get(strDecode))) {
                        ((ExchangeCodec) exchange.codec).getConnection().noNewExchanges$okhttp();
                    } else {
                        String str2 = responseBuild.headers.get(strDecode);
                        if (str2 == null) {
                            str2 = null;
                        }
                        if (strDecode2.equalsIgnoreCase(str2)) {
                            ((ExchangeCodec) exchange.codec).getConnection().noNewExchanges$okhttp();
                        }
                    }
                    if (i2 == 204 || i2 == 205) {
                        ResponseBody responseBody = responseBuild.body;
                        if ((responseBody != null ? responseBody.contentLength() : -1L) > 0) {
                            StringBuilder sb = new StringBuilder(strDecode3);
                            sb.append(i2);
                            sb.append(C0000.decode(new byte[]{24, 89, 87, 93, 66, 89, 14, 94, 20, 27, 86, 65, 88, 24, 123, 94, 88, 77, 7, 89, 21, 29, 117, 4, 93, 84, 67, 80, 2, 17}, "8169b7a09a3378"));
                            ResponseBody responseBody2 = responseBuild.body;
                            sb.append(responseBody2 != null ? Long.valueOf(responseBody2.contentLength()) : null);
                            throw new ProtocolException(sb.toString());
                        }
                    }
                    return responseBuild;
                } catch (IOException e6) {
                    e = e6;
                    if (iOException != null) {
                        throw e;
                    }
                    ExceptionsKt.addSuppressed(iOException, e);
                    throw iOException;
                }
            } catch (IOException e7) {
                exchange.trackFailure(e7);
                throw e7;
            }
        } catch (IOException e8) {
            e = e8;
            r12 = 0;
        }
    }
}
