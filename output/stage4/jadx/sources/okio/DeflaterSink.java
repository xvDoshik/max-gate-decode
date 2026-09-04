package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DeflaterSink implements Sink {
    public final /* synthetic */ int $r8$classId = 1;
    public boolean closed;
    public final Object deflater;
    public final Object sink;

    public DeflaterSink(Buffer buffer, Deflater deflater) {
        this.sink = new RealBufferedSink(buffer);
        this.deflater = deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                Deflater deflater = (Deflater) this.deflater;
                if (this.closed) {
                    return;
                }
                deflater.finish();
                deflate(false);
                th = null;
                try {
                    deflater.end();
                    break;
                } catch (Throwable th) {
                    if (th == null) {
                        th = th;
                    }
                }
                try {
                    ((RealBufferedSink) this.sink).close();
                    break;
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
                this.closed = true;
                if (th != null) {
                    throw th;
                }
                return;
            default:
                RouteSelector routeSelector = (RouteSelector) this.deflater;
                if (this.closed) {
                    return;
                }
                this.closed = true;
                ForwardingTimeout forwardingTimeout = (ForwardingTimeout) this.sink;
                Timeout timeout = forwardingTimeout.delegate;
                forwardingTimeout.delegate = Timeout.NONE;
                timeout.clearDeadline();
                timeout.clearTimeout();
                routeSelector.nextProxyIndex = 3;
                return;
        }
    }

    public void deflate(boolean z) throws IOException {
        Segment segmentWritableSegment$okio;
        int iDeflate;
        Deflater deflater = (Deflater) this.deflater;
        RealBufferedSink realBufferedSink = (RealBufferedSink) this.sink;
        Buffer buffer = realBufferedSink.bufferField;
        while (true) {
            segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            byte[] bArr = segmentWritableSegment$okio.data;
            if (z) {
                try {
                    int i = segmentWritableSegment$okio.limit;
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException(C0000.decode(new byte[]{114, 87, 4, 85, 86, 21, 92, 23, 16, 85, 13, 74, 83, 83, 6, 64, 23, 2, 85, 10, 67, 81, 5}, "62b97a9e04a8", true), e);
                }
            } else {
                int i2 = segmentWritableSegment$okio.limit;
                iDeflate = deflater.deflate(bArr, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                segmentWritableSegment$okio.limit += iDeflate;
                buffer.size += (long) iDeflate;
                realBufferedSink.emitCompleteSegments();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                deflate(true);
                ((RealBufferedSink) this.sink).flush();
                break;
            default:
                if (!this.closed) {
                    ((BufferedSink) ((RouteSelector) this.deflater).inetSocketAddresses).flush();
                    break;
                }
                break;
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                return ((RealBufferedSink) this.sink).sink.timeout();
            default:
                return (ForwardingTimeout) this.sink;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return C0000.decode(new byte[]{116, 86, 80, 84, 4, 71, 3, 23, 96, 89, 8, 15, 29}, "0368e3fe30fd586c", 0.0f) + ((RealBufferedSink) this.sink) + ')';
            default:
                return super.toString();
        }
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) throws IOException {
        switch (this.$r8$classId) {
            case 0:
                Options.Companion.checkOffsetAndCount(buffer.size, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    Segment segment = buffer.head;
                    int iMin = (int) Math.min(j2, segment.limit - segment.pos);
                    ((Deflater) this.deflater).setInput(segment.data, segment.pos, iMin);
                    deflate(false);
                    long j3 = iMin;
                    buffer.size -= j3;
                    int i = segment.pos + iMin;
                    segment.pos = i;
                    if (i == segment.limit) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                    j2 -= j3;
                }
                return;
            default:
                if (this.closed) {
                    throw new IllegalStateException(C0000.decode(new byte[]{82, 88, 95, 69, 4, 86}, "1406a2"));
                }
                Util.checkOffsetAndCount(buffer.size, 0L, j);
                ((BufferedSink) ((RouteSelector) this.deflater).inetSocketAddresses).write(j, buffer);
                return;
        }
    }

    public DeflaterSink(RouteSelector routeSelector) {
        this.deflater = routeSelector;
        this.sink = new ForwardingTimeout(((BufferedSink) routeSelector.inetSocketAddresses).timeout());
    }
}
