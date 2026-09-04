package okio;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class InputStreamSource implements Source {
    public final /* synthetic */ int $r8$classId;
    public final Object input;
    public final Object timeout;

    public /* synthetic */ InputStreamSource(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.input = obj;
        this.timeout = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                ((InputStream) this.input).close();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) this.input;
                InputStreamSource inputStreamSource = (InputStreamSource) this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        inputStreamSource.close();
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e;
                        }
                        throw socketAsyncTimeout.newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009e  */
    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        boolean z;
        int i = this.$r8$classId;
        Object obj = this.timeout;
        Object obj2 = this.input;
        switch (i) {
            case 0:
                try {
                    ((Timeout) obj).throwIfReached();
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                    int i2 = ((InputStream) obj2).read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(8192L, 8192 - segmentWritableSegment$okio.limit));
                    if (i2 == -1) {
                        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                            buffer.head = segmentWritableSegment$okio.pop();
                            SegmentPool.recycle(segmentWritableSegment$okio);
                        }
                        return -1L;
                    }
                    segmentWritableSegment$okio.limit += i2;
                    long j2 = i2;
                    buffer.size += j2;
                    return j2;
                } catch (AssertionError e) {
                    Logger logger = Okio__JvmOkioKt.logger;
                    if (e.getCause() != null) {
                        String message = e.getMessage();
                        z = message != null ? StringsKt.contains$default(message, C0000.decode(new byte[]{80, 6, 22, 74, 92, 80, 13, 95, 5, 89, 87, 69, 87, 88, 89, 84, 82, 7}, "7cb933f1d42e1908")) : false;
                    }
                    if (z) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) obj2;
                InputStreamSource inputStreamSource = (InputStreamSource) obj;
                socketAsyncTimeout.enter();
                try {
                    try {
                        long j3 = inputStreamSource.read(8192L, buffer);
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return j3;
                    } catch (IOException e2) {
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(e2);
                        }
                        throw e2;
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                return (Timeout) this.timeout;
            default:
                return (SocketAsyncTimeout) this.input;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return C0000.decode(new byte[]{64, 90, 17, 17, 90, 0, 28}, "35dc9e47", 0.0f) + ((InputStream) this.input) + ')';
            default:
                return C0000.decode(new byte[]{116, 65, 79, 87, 84, 103, 92, 95, 83, 86, 66, 71, 27, 65, 89, 76, 69, 80, 80, 26}, "526973") + ((InputStreamSource) this.timeout) + ')';
        }
    }
}
