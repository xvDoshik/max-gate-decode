package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final RealBufferedSource source;

    public InflaterSource(RealBufferedSource realBufferedSource, Inflater inflater) {
        this.source = realBufferedSource;
        this.inflater = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        do {
            long orInflate = readOrInflate(8192L, buffer);
            if (orInflate > 0) {
                return orInflate;
            }
            Inflater inflater = this.inflater;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException(C0000.decode(new byte[]{18, 93, 16, 65, 80, 85, 65, 87, 29, 91, 82, 69, 18, 70, 0, 87, 19, 64, 19, 87, 8, 82, 71, 69, 19, 87, 9, 74}, "a2e330"));
    }

    public final long readOrInflate(long j, Buffer buffer) throws IOException {
        Inflater inflater = this.inflater;
        if (j < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{90, 73, 66, 6, 114, 13, 71, 89, 77, 22, 10, 22, 84, 12, 24}, "806c1b279666d6", 4) + j).toString());
        }
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{86, 95, 87, 70, 80, 2}, "53855fa5afdc", 0.0f));
        }
        if (j != 0) {
            try {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                int iMin = (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit);
                boolean zNeedsInput = inflater.needsInput();
                RealBufferedSource realBufferedSource = this.source;
                if (zNeedsInput && !realBufferedSource.exhausted()) {
                    Segment segment = realBufferedSource.bufferField.head;
                    int i = segment.limit;
                    int i2 = segment.pos;
                    int i3 = i - i2;
                    this.bufferBytesHeldByInflater = i3;
                    inflater.setInput(segment.data, i2, i3);
                }
                int iInflate = inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
                int i4 = this.bufferBytesHeldByInflater;
                if (i4 != 0) {
                    int remaining = i4 - inflater.getRemaining();
                    this.bufferBytesHeldByInflater -= remaining;
                    realBufferedSource.skip(remaining);
                }
                if (iInflate > 0) {
                    segmentWritableSegment$okio.limit += iInflate;
                    long j2 = iInflate;
                    buffer.size += j2;
                    return j2;
                }
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    buffer.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }
}
