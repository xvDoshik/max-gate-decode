package okhttp3.internal.http1;

import java.io.IOException;
import okio.Buffer;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http1ExchangeCodec$UnknownLengthSource extends Http1ExchangeCodec$AbstractSource {
    public boolean inputExhausted;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        if (!this.inputExhausted) {
            responseBodyComplete();
        }
        this.closed = true;
    }

    @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource, okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{2, 89, 89, 17, 82, 5}, "a56b7a31baf1"));
        }
        if (this.inputExhausted) {
            return -1L;
        }
        long j2 = super.read(8192L, buffer);
        if (j2 != -1) {
            return j2;
        }
        this.inputExhausted = true;
        responseBodyComplete();
        return -1L;
    }
}
