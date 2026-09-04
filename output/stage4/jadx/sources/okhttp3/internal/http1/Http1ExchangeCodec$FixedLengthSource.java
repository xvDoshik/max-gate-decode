package okhttp3.internal.http1;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteSelector;
import okio.Buffer;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http1ExchangeCodec$FixedLengthSource extends Http1ExchangeCodec$AbstractSource {
    public long bytesRemaining;
    public final /* synthetic */ RouteSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http1ExchangeCodec$FixedLengthSource(RouteSelector routeSelector, long j) {
        super(routeSelector);
        this.this$0 = routeSelector;
        this.bytesRemaining = j;
        if (j == 0) {
            responseBodyComplete();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zSkipAll;
        if (this.closed) {
            return;
        }
        if (this.bytesRemaining != 0) {
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

    @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource, okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{0, 85, 9, 18, 3, 81}, "c9faf53c7d"));
        }
        long j2 = this.bytesRemaining;
        if (j2 == 0) {
            return -1L;
        }
        long j3 = super.read(Math.min(j2, 8192L), buffer);
        if (j3 == -1) {
            ((RealConnection) this.this$0.routeDatabase).noNewExchanges$okhttp();
            ProtocolException protocolException = new ProtocolException(C0000.decode(new byte[]{23, 89, 6, 78, 73, 93, 82, 70, 1, 1, 66, 82, 13, 82, 25, 87, 87, 18, 23, 17, 16, 82, 2, 91}, "b7c69812de", false));
            responseBodyComplete();
            throw protocolException;
        }
        long j4 = this.bytesRemaining - j3;
        this.bytesRemaining = j4;
        if (j4 == 0) {
            responseBodyComplete();
        }
        return j3;
    }
}
