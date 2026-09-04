package okhttp3.internal.http1;

import java.io.IOException;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteSelector;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Http1ExchangeCodec$AbstractSource implements Source {
    public boolean closed;
    public final /* synthetic */ RouteSelector this$0;
    public final ForwardingTimeout timeout;

    public Http1ExchangeCodec$AbstractSource(RouteSelector routeSelector) {
        this.this$0 = routeSelector;
        this.timeout = new ForwardingTimeout(((BufferedSource) routeSelector.proxies).timeout());
    }

    @Override // okio.Source
    public long read(long j, Buffer buffer) throws IOException {
        RouteSelector routeSelector = this.this$0;
        try {
            return ((BufferedSource) routeSelector.proxies).read(j, buffer);
        } catch (IOException e) {
            ((RealConnection) routeSelector.routeDatabase).noNewExchanges$okhttp();
            responseBodyComplete();
            throw e;
        }
    }

    public final void responseBodyComplete() {
        RouteSelector routeSelector = this.this$0;
        int i = routeSelector.nextProxyIndex;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException(C0000.decode(new byte[]{75, 23, 7, 76, 6, 11, 20}, "8cf8c145d05723a4", false) + routeSelector.nextProxyIndex);
        }
        ForwardingTimeout forwardingTimeout = this.timeout;
        Timeout timeout = forwardingTimeout.delegate;
        forwardingTimeout.delegate = Timeout.NONE;
        timeout.clearDeadline();
        timeout.clearTimeout();
        routeSelector.nextProxyIndex = 6;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.timeout;
    }
}
