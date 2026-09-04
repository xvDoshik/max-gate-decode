package okhttp3.internal.http2;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Stream {
    public final Http2Connection connection;
    public int errorCode;
    public IOException errorException;
    public boolean hasResponseHeaders;
    public final ArrayDeque headersQueue;
    public final int id;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final StreamTimeout readTimeout;
    public final FramingSink sink;
    public final FramingSource source;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final StreamTimeout writeTimeout;

    public final class FramingSink implements Sink {
        public boolean closed;
        public final boolean finished;
        public final Buffer sendBuffer = new Buffer();

        public FramingSink(boolean z) {
            this.finished = z;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws SocketTimeoutException {
            boolean z;
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            synchronized (http2Stream) {
                if (this.closed) {
                    return;
                }
                synchronized (http2Stream) {
                    z = http2Stream.errorCode == 0;
                }
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.sink.finished) {
                    if (this.sendBuffer.size > 0) {
                        while (this.sendBuffer.size > 0) {
                            emitFrame(true);
                        }
                    } else if (z) {
                        http2Stream2.connection.writeData(http2Stream2.id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        public final void emitFrame(boolean z) throws SocketTimeoutException {
            long jMin;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.writeTimeout.enter();
                while (http2Stream.writeBytesTotal >= http2Stream.writeBytesMaximum && !this.finished && !this.closed) {
                    try {
                        synchronized (http2Stream) {
                            int i = http2Stream.errorCode;
                            if (i != 0) {
                                break;
                            }
                            try {
                                http2Stream.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        }
                    } catch (Throwable th) {
                        http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                jMin = Math.min(http2Stream.writeBytesMaximum - http2Stream.writeBytesTotal, this.sendBuffer.size);
                http2Stream.writeBytesTotal += jMin;
                z2 = z && jMin == this.sendBuffer.size;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream http2Stream2 = Http2Stream.this;
                http2Stream2.connection.writeData(http2Stream2.id, z2, this.sendBuffer, jMin);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws SocketTimeoutException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            synchronized (http2Stream) {
                http2Stream.checkOutNotClosed$okhttp();
            }
            while (this.sendBuffer.size > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public final void write(long j, Buffer buffer) throws SocketTimeoutException {
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            Buffer buffer2 = this.sendBuffer;
            buffer2.write(j, buffer);
            while (buffer2.size >= 16384) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements Source {
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public final Buffer receiveBuffer = new Buffer();
        public final Buffer readBuffer = new Buffer();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long j;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                Buffer buffer = this.readBuffer;
                j = buffer.size;
                buffer.skip(j);
                http2Stream.notifyAll();
            }
            if (j > 0) {
                Http2Stream http2Stream2 = Http2Stream.this;
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                http2Stream2.connection.updateConnectionFlowControl$okhttp(j);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws Throwable {
            int i;
            Throwable streamResetException;
            boolean z;
            long j2;
            do {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    http2Stream.readTimeout.enter();
                    try {
                        synchronized (http2Stream) {
                            i = http2Stream.errorCode;
                        }
                    } catch (Throwable th) {
                        http2Stream.readTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                if (i != 0 && !this.finished) {
                    streamResetException = http2Stream.errorException;
                    if (streamResetException == null) {
                        synchronized (http2Stream) {
                            streamResetException = new StreamResetException(http2Stream.errorCode);
                        }
                    }
                    throw th;
                }
                streamResetException = null;
                if (this.closed) {
                    throw new IOException(C0000.decode(new byte[]{68, 68, 22, 81, 7, 84, 70, 86, 13, 91, 70, 84, 83}, "70d4f9f5a45179"));
                }
                Buffer buffer2 = this.readBuffer;
                long j3 = buffer2.size;
                z = false;
                if (j3 > 0) {
                    j2 = buffer2.read(Math.min(8192L, j3), buffer);
                    long j4 = http2Stream.readBytesTotal + j2;
                    http2Stream.readBytesTotal = j4;
                    long j5 = j4 - http2Stream.readBytesAcknowledged;
                    if (streamResetException == null && j5 >= http2Stream.connection.okHttpSettings.getInitialWindowSize() / 2) {
                        http2Stream.connection.writeWindowUpdateLater$okhttp(http2Stream.id, j5);
                        http2Stream.readBytesAcknowledged = http2Stream.readBytesTotal;
                    }
                } else {
                    if (!this.finished && streamResetException == null) {
                        try {
                            http2Stream.wait();
                            z = true;
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    j2 = -1;
                }
                http2Stream.readTimeout.exitAndThrowIfTimedOut();
            } while (z);
            if (j2 != -1) {
                return j2;
            }
            if (streamResetException == null) {
                return -1L;
            }
            throw streamResetException;
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws SocketTimeoutException {
            if (exit()) {
                throw new SocketTimeoutException(C0000.decode(new byte[]{18, 93, 89, 1, 91, 76, 70}, "f44d492d", true));
            }
        }

        @Override // okio.AsyncTimeout
        public final void timedOut() {
            Http2Stream.this.closeLater(9);
            Http2Connection http2Connection = Http2Stream.this.connection;
            synchronized (http2Connection) {
                long j = http2Connection.degradedPongsReceived;
                long j2 = http2Connection.degradedPingsSent;
                if (j < j2) {
                    return;
                }
                http2Connection.degradedPingsSent = j2 + 1;
                http2Connection.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
                http2Connection.writerQueue.schedule(new TaskQueue$execute$1(FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), http2Connection.connectionName, C0000.decode(new byte[]{21, 73, 12, 91, 84}, "59e537", 0.0f)), http2Connection, 2), 0L);
            }
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        this.id = i;
        this.connection = http2Connection;
        this.writeBytesMaximum = http2Connection.peerSettings.getInitialWindowSize();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException(C0000.decode(new byte[]{70, 93, 8, 95, 22, 83, 88, 26, 26, 8, 93, 80, 22, 8, 85, 76, 0, 84, 66, 69, 64, 17, 82, 0, 94, 74, 66, 18, 92, 87, 16, 92, 6, 22, 92, 2, 65, 4, 19, 81, 7, 0, 80, 93, 23, 67}, "48e0b64c7a39ba", true));
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException(C0000.decode(new byte[]{8, 95, 2, 7, 14, 85, 29, 29, 8, 8, 11, 77, 13, 81, 21, 3, 6, 25, 23, 68, 19, 3, 3, 84, 23, 16, 18, 14, 13, 76, 8, 84, 15, 65, 22, 25, 12, 81, 23, 3, 66, 81, 1, 81, 5, 3, 16, 74, 68, 73, 4, 18}, "d0afb9", 1));
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001c  */
    public final void cancelStreamIfNecessary$okhttp() {
        boolean z;
        boolean zIsOpen;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            try {
                FramingSource framingSource = this.source;
                if (framingSource.finished || !framingSource.closed) {
                    z = false;
                } else {
                    FramingSink framingSink = this.sink;
                    if (framingSink.finished || framingSink.closed) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                zIsOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(9, null);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException(C0000.decode(new byte[]{65, 70, 19, 81, 4, 15, 24, 90, 94, 93, 18, 81, 1}, "22a4eb89", 0.0f));
        }
        if (framingSink.finished) {
            throw new IOException(C0000.decode(new byte[]{17, 71, 71, 6, 5, 88, 66, 85, 92, 13, 13, 70, 10, 86, 81}, "b35cd5", false));
        }
        if (this.errorCode != 0) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                throw new StreamResetException(this.errorCode);
            }
        }
    }

    public final void close(int i, IOException iOException) {
        if (closeInternal(i, iOException)) {
            this.connection.writer.rstStream(this.id, i);
        }
    }

    public final boolean closeInternal(int i, IOException iOException) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            if (this.errorCode != 0) {
                return false;
            }
            this.errorCode = i;
            this.errorException = iOException;
            notifyAll();
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void closeLater(int i) {
        if (closeInternal(i, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, i);
        }
    }

    public final FramingSink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException(C0000.decode(new byte[]{23, 83, 17, 14, 29, 17, 91, 0, 2, 87, 66, 82, 69, 75, 0, 71, 20, 7, 23, 69, 80, 11, 3, 24, 68, 95, 0, 25, 22, 95, 15, 9}, "e6abd19ed807e9"));
            }
        }
        return this.sink;
    }

    public final boolean isLocallyInitiated() {
        boolean z = (this.id & 1) == 1;
        this.connection.getClass();
        return true == z;
    }

    public final synchronized boolean isOpen() {
        try {
            if (this.errorCode != 0) {
                return false;
            }
            FramingSource framingSource = this.source;
            if (framingSource.finished || framingSource.closed) {
                FramingSink framingSink = this.sink;
                if ((framingSink.finished || framingSink.closed) && this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void receiveHeaders(Headers headers, boolean z) {
        boolean zIsOpen;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && z) {
                    this.source.getClass();
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (z) {
                    this.source.finished = true;
                }
                zIsOpen = isOpen();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.id);
    }
}
