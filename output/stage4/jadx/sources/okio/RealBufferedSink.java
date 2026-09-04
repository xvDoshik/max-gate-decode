package okio;

import java.nio.ByteBuffer;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        this.sink = sink;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Sink sink = this.sink;
        if (this.closed) {
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j > 0) {
            sink.write(j, buffer);
        }
        th = null;
        try {
            sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    public final BufferedSink emit() {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{1, 91, 95, 16, 92, 5}, "b70c9a7daa8e", 0.0f));
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j > 0) {
            this.sink.write(j, buffer);
        }
        return this;
    }

    public final BufferedSink emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{84, 14, 13, 18, 0, 5}, "7bbaeab70bec97"));
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j == 0) {
            j = 0;
        } else {
            Segment segment = buffer.head.prev;
            int i = segment.limit;
            if (i < 8192 && segment.owner) {
                j -= (long) (i - segment.pos);
            }
        }
        if (j > 0) {
            this.sink.write(j, buffer);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{86, 15, 11, 22, 83, 2}, "5cde6f"));
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        Sink sink = this.sink;
        if (j > 0) {
            sink.write(j, buffer);
        }
        sink.flush();
    }

    @Override // okio.BufferedSink
    public final Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{85, 20, 94, 80, 85, 70, 31}, "7a8604", 0));
        sb.append(this.sink);
        sb.append(')');
        return sb.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{81, 10, 13, 21, 1, 80}, "2fbfd430d5dff0"));
        }
        int iWrite = this.bufferField.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString byteString) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{2, 9, 95, 69, 84, 1}, "ae061ef571", false));
        }
        this.bufferField.m22write(byteString);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] bArr) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{87, 91, 95, 75, 84, 85}, "470811", false));
        }
        this.bufferField.write(bArr.length, bArr);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{0, 94, 87, 74, 80, 92}, "c28958932fce43"));
        }
        this.bufferField.write(j, buffer);
        emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int i) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{0, 88, 87, 22, 81, 85}, "c48e41e79a34edf5", true));
        }
        this.bufferField.m23writeByte(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{6, 88, 11, 23, 93, 85}, "e4dd810c2701", 0.0f));
        }
        this.bufferField.m24writeHexadecimalUnsignedLong(j);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{86, 92, 95, 69, 82, 80}, "5006742dff8e65fe", true));
        }
        this.bufferField.m25writeInt(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShort(int i) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{7, 13, 89, 66, 93, 93}, "da6189", 2));
        }
        this.bufferField.m26writeShort(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String str) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{6, 8, 9, 16, 82, 92}, "edfc782101254d", false));
        }
        this.bufferField.writeUtf8(str, 0, str.length());
        emitCompleteSegments();
        return this;
    }
}
