package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okio.Buffer;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Connection implements Closeable {
    public static final Settings DEFAULT_SETTINGS;
    public final String connectionName;
    public final LinkedHashSet currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public long intervalPongsReceived;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public Settings peerSettings;
    public final PushObserver$Companion$PushObserverCancel pushObserver;
    public final TaskQueue pushQueue;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final ReaderRunnable readerRunnable;
    public final TaskQueue settingsListenerQueue;
    public final Socket socket;
    public final LinkedHashMap streams = new LinkedHashMap();
    public final TaskRunner taskRunner;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final Http2Writer writer;
    public final TaskQueue writerQueue;

    public abstract class Listener {
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public void onSettings(Settings settings) {
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    public final class ReaderRunnable implements Function0 {
        public final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            this.reader = http2Reader;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Http2Connection http2Connection = Http2Connection.this;
            Http2Reader http2Reader = this.reader;
            try {
                if (!http2Reader.nextFrame(true, this)) {
                    throw new IOException(C0000.decode(new byte[]{49, 1, 21, 17, 81, 23, 85, 85, 19, 103, 117, 50, 49, 122, 45, 116, 48, 68, 20, 22, 93, 3, 81, 82, 86, 20, 94, 9, 17, 19, 17, 86, 0, 1, 13, 18, 93, 1}, "cddd8e01340fe3c3", false));
                }
                while (http2Reader.nextFrame(false, this)) {
                }
                http2Connection.close$okhttp(1, 9, null);
                Util.closeQuietly(http2Reader);
                return Unit.INSTANCE;
            } catch (IOException e) {
                http2Connection.close$okhttp(2, 2, e);
            } catch (Throwable th) {
                http2Connection.close$okhttp(3, 3, null);
                Util.closeQuietly(http2Reader);
                throw th;
            }
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Request request) {
        this.listener = (Listener) request.lazyCacheControl;
        String str = (String) request.method;
        this.connectionName = str == null ? null : str;
        this.nextStreamId = 3;
        TaskRunner taskRunner = (TaskRunner) request.url;
        this.taskRunner = taskRunner;
        this.writerQueue = taskRunner.newQueue();
        this.pushQueue = taskRunner.newQueue();
        this.settingsListenerQueue = taskRunner.newQueue();
        this.pushObserver = PushObserver$Companion$PushObserverCancel.CANCEL;
        Settings settings = new Settings();
        settings.set(7, 16777216);
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        Socket socket = (Socket) request.headers;
        this.socket = socket == null ? null : socket;
        RealBufferedSink realBufferedSink = (RealBufferedSink) request.tags;
        this.writer = new Http2Writer(realBufferedSink == null ? null : realBufferedSink);
        RealBufferedSource realBufferedSource = (RealBufferedSource) request.body;
        this.readerRunnable = new ReaderRunnable(new Http2Reader(realBufferedSource != null ? realBufferedSource : null));
        this.currentPushRequests = new LinkedHashSet();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close$okhttp(1, 9, null);
    }

    public final void close$okhttp(int i, int i2, IOException iOException) {
        int i3;
        Object[] array;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        try {
            shutdown(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                array = null;
            } else {
                array = this.streams.values().toArray(new Http2Stream[0]);
                this.streams.clear();
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(i2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() {
        this.writer.flush();
    }

    public final synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public final void shutdown(int i) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(Util.EMPTY_BYTE_ARRAY, this.lastGoodStreamId, i);
            }
        }
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    public final void writeData(int i, boolean z, Buffer buffer, long j) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j2 = this.writeBytesTotal;
                            j3 = this.writeBytesMaximum;
                            if (j2 >= j3) {
                                if (!this.streams.containsKey(Integer.valueOf(i))) {
                                    throw new IOException(C0000.decode(new byte[]{74, 77, 20, 1, 81, 93, 25, 90, 10, 11, 67, 85, 93}, "99fd00"));
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j, j3 - j2), this.writer.maxFrameSize);
                j4 = iMin;
                this.writeBytesTotal += j4;
            }
            j -= j4;
            this.writer.data(z && j == 0, i, buffer, iMin);
        }
    }

    public final void writeSynResetLater$okhttp(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.connectionName);
        sb.append('[');
        sb.append(i);
        sb.append(C0000.decode(new byte[]{57, 17, 79, 75, 89, 68, 92, 96, 76, 92, 55, 81, 23, 84, 76}, "d189009352e4", 1));
        this.writerQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(sb.toString(), this, i, i2, 0), 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.connectionName);
        sb.append('[');
        sb.append(i);
        sb.append(C0000.decode(new byte[]{104, 19, 17, 92, 8, 81, 90, 67, 101, 65, 85, 89, 66, 86}, "53f5f554011863", true));
        final String string = sb.toString();
        this.writerQueue.schedule(new Task(string) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            @Override // okhttp3.internal.concurrent.Task
            public final long runOnce() {
                Http2Connection http2Connection = this;
                try {
                    http2Connection.writer.windowUpdate(i, j);
                    return -1L;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
            }
        }, 0L);
    }
}
