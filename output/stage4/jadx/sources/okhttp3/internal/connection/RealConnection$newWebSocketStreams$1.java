package okhttp3.internal.connection;

import java.io.Closeable;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealConnection$newWebSocketStreams$1 implements Closeable {
    public final /* synthetic */ Exchange $exchange;
    public final BufferedSink sink;
    public final BufferedSource source;

    public RealConnection$newWebSocketStreams$1(BufferedSource bufferedSource, BufferedSink bufferedSink, Exchange exchange) {
        this.$exchange = exchange;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.$exchange.bodyComplete(true, true, null);
    }
}
