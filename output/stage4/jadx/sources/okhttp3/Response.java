package okhttp3;

import java.io.Closeable;
import okhttp3.internal.connection.Exchange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Response implements Closeable {
    public final ResponseBody body;
    public final Response cacheResponse;
    public final int code;
    public final Exchange exchange;
    public final Handshake handshake;
    public final Headers headers;
    public final String message;
    public final Response networkResponse;
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;

    public final class Builder {
        public ResponseBody body;
        public Response cacheResponse;
        public Exchange exchange;
        public Handshake handshake;
        public String message;
        public Response networkResponse;
        public Response priorResponse;
        public Protocol protocol;
        public long receivedResponseAtMillis;
        public Request request;
        public long sentRequestAtMillis;
        public int code = -1;
        public ConnectionPool headers = new ConnectionPool(23);

        public static void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (response.body != null) {
                    throw new IllegalArgumentException(str.concat(C0000.decode(new byte[]{77, 0, 13, 81, 75, 21, 66, 94, 23, 13, 22, 14, 14}, "cbb525cc7c")).toString());
                }
                if (response.networkResponse != null) {
                    throw new IllegalArgumentException(str.concat(C0000.decode(new byte[]{31, 15, 87, 18, 68, 91, 74, 13, 99, 83, 66, 67, 87, 95, 69, 86, 17, 64, 15, 70, 93, 65, 84, 10}, "1a2f348f16138163")).toString());
                }
                if (response.cacheResponse != null) {
                    throw new IllegalArgumentException(str.concat(C0000.decode(new byte[]{23, 90, 2, 6, 95, 80, 52, 83, 71, 66, 88, 12, 75, 84, 25, 24, 94, 69, 89, 64, 10, 90}, "99ce75f6427b81", 7)).toString());
                }
                if (response.priorResponse != null) {
                    throw new IllegalArgumentException(str.concat(C0000.decode(new byte[]{24, 22, 64, 89, 13, 65, 103, 3, 16, 67, 89, 8, 65, 85, 66, 18, 8, 70, 13, 70, 90, 10}, "6f20b35fc3", false)).toString());
                }
            }
        }

        public final Response build() {
            int i = this.code;
            if (i < 0) {
                throw new IllegalStateException((C0000.decode(new byte[]{91, 95, 84, 86, 68, 13, 17, 3, 2, 24}, "8003d11388") + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{64, 7, 18, 68, 87, 16, 65, 70, 9, 13, 17, 10, 67, 94, 94}, "2bc12c5f401d62", 5));
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{71, 67, 86, 76, 9, 85, 13, 10, 18, 9, 10, 17, 87, 77, 10, 90}, "7198f6bf24", 3));
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException(C0000.decode(new byte[]{84, 81, 23, 23, 86, 86, 80, 17, 11, 95, 66, 12, 76, 88, 8}, "94dd71516bbb"));
        }
    }

    public Response(Request request, Protocol protocol, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, Exchange exchange) {
        this.request = request;
        this.protocol = protocol;
        this.message = str;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{19, 92, 64, 22, 90, 88, 18, 92, 19, 15, 70, 22, 15, 86, 71, 70, 80, 90, 8, 94, 90, 4, 89, 83, 65, 95, 92, 20, 21, 87, 65, 91, 92, 2, 76, 22, 0, 87, 87, 70, 88, 67, 18, 77, 19, 8, 90, 66, 65, 91, 86, 70, 86, 90, 14, 74, 86, 2}, "a93f56", true));
        }
        responseBody.close();
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.request = this.request;
        builder.protocol = this.protocol;
        builder.code = this.code;
        builder.message = this.message;
        builder.handshake = this.handshake;
        builder.headers = this.headers.newBuilder();
        builder.body = this.body;
        builder.networkResponse = this.networkResponse;
        builder.cacheResponse = this.cacheResponse;
        builder.priorResponse = this.priorResponse;
        builder.sentRequestAtMillis = this.sentRequestAtMillis;
        builder.receivedResponseAtMillis = this.receivedResponseAtMillis;
        builder.exchange = this.exchange;
        return builder;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{55, 1, 65, 64, 92, 87, 69, 87, 30, 20, 64, 95, 71, 86, 85, 93, 9, 89}, "ed203962", false));
        sb.append(this.protocol);
        sb.append(C0000.decode(new byte[]{27, 19, 82, 11, 92, 4, 10}, "731d8a"));
        sb.append(this.code);
        sb.append(C0000.decode(new byte[]{24, 18, 15, 3, 65, 70, 85, 85, 7, 91}, "42bf25"));
        sb.append(this.message);
        sb.append(C0000.decode(new byte[]{74, 23, 71, 23, 84, 11}, "f72e866d", 0.0f));
        sb.append((HttpUrl) this.request.url);
        sb.append('}');
        return sb.toString();
    }
}
