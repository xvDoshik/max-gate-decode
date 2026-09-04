package okio;

import java.io.IOException;
import java.io.OutputStream;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OutputStreamSink implements Sink {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object out;
    public final SocketAsyncTimeout timeout;

    public OutputStreamSink(OutputStream outputStream, SocketAsyncTimeout socketAsyncTimeout) {
        this.out = outputStream;
        this.timeout = socketAsyncTimeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                ((OutputStream) this.out).close();
                return;
            default:
                OutputStreamSink outputStreamSink = (OutputStreamSink) this.out;
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        outputStreamSink.close();
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

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                ((OutputStream) this.out).flush();
                return;
            default:
                OutputStreamSink outputStreamSink = (OutputStreamSink) this.out;
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        outputStreamSink.flush();
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

    @Override // okio.Sink
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.timeout;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return C0000.decode(new byte[]{69, 12, 86, 9, 16}, "6e8b8e1a36") + ((OutputStream) this.out) + ')';
            default:
                return C0000.decode(new byte[]{34, 66, 75, 12, 7, 108, 11, 94, 84, 95, 23, 64, 75, 17, 10, 95, 89, 74}, "c12bd8b310b4eb") + ((OutputStreamSink) this.out) + ')';
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[LOOP:0: B:5:0x000d->B:18:0x003e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x0040 A[SYNTHETIC] */
    @Override // okio.Sink
    public final void write(long j, Buffer buffer) throws IOException {
        SocketAsyncTimeout socketAsyncTimeout;
        switch (this.$r8$classId) {
            case 0:
                Options.Companion.checkOffsetAndCount(buffer.size, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    this.timeout.throwIfReached();
                    Segment segment = buffer.head;
                    int iMin = (int) Math.min(j2, segment.limit - segment.pos);
                    ((OutputStream) this.out).write(segment.data, segment.pos, iMin);
                    int i = segment.pos + iMin;
                    segment.pos = i;
                    long j3 = iMin;
                    j2 -= j3;
                    buffer.size -= j3;
                    if (i == segment.limit) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                }
                return;
            default:
                Options.Companion.checkOffsetAndCount(buffer.size, 0L, j);
                while (true) {
                    long j4 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment2 = buffer.head;
                    try {
                        try {
                            while (j4 < 65536) {
                                j4 += (long) (segment2.limit - segment2.pos);
                                if (j4 >= j) {
                                    j4 = j;
                                    OutputStreamSink outputStreamSink = (OutputStreamSink) this.out;
                                    socketAsyncTimeout = this.timeout;
                                    socketAsyncTimeout.enter();
                                    outputStreamSink.write(j4, buffer);
                                    if (!socketAsyncTimeout.exit()) {
                                        throw socketAsyncTimeout.newTimeoutException(null);
                                    }
                                    j -= j4;
                                } else {
                                    segment2 = segment2.next;
                                }
                            }
                            outputStreamSink.write(j4, buffer);
                            if (!socketAsyncTimeout.exit()) {
                                throw socketAsyncTimeout.newTimeoutException(null);
                            }
                            j -= j4;
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
                    OutputStreamSink outputStreamSink2 = (OutputStreamSink) this.out;
                    socketAsyncTimeout = this.timeout;
                    socketAsyncTimeout.enter();
                }
                break;
        }
    }

    public OutputStreamSink(SocketAsyncTimeout socketAsyncTimeout, OutputStreamSink outputStreamSink) {
        this.timeout = socketAsyncTimeout;
        this.out = outputStreamSink;
    }
}
