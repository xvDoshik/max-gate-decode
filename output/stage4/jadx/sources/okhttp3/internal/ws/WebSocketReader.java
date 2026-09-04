package okhttp3.internal.ws;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection$newWebSocketStreams$1;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WebSocketReader implements Closeable {
    public boolean closed;
    public final FrameCallback frameCallback;
    public long frameLength;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    public MessageDeflater messageInflater;
    public final boolean noContextTakeover;
    public int opcode;
    public final boolean perMessageDeflate;
    public boolean readingCompressedMessage;
    public final BufferedSource source;
    public final Buffer controlFrameBuffer = new Buffer();
    public final Buffer messageFrameBuffer = new Buffer();
    public final byte[] maskKey = null;

    public interface FrameCallback {
    }

    public WebSocketReader(BufferedSource bufferedSource, RealWebSocket realWebSocket, boolean z, boolean z2) {
        this.source = bufferedSource;
        this.frameCallback = realWebSocket;
        this.perMessageDeflate = z;
        this.noContextTakeover = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageInflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final void readControlFrame() throws ProtocolException, EOFException {
        String utf8;
        short s;
        RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        String strM;
        long j = this.frameLength;
        if (j > 0) {
            this.source.readFully(j, this.controlFrameBuffer);
        }
        switch (this.opcode) {
            case 8:
                Buffer buffer = this.controlFrameBuffer;
                long j2 = buffer.size;
                if (j2 == 1) {
                    throw new ProtocolException(C0000.decode(new byte[]{123, 4, 95, 87, 13, 70, 9, 93, 82, 25, 85, 9, 92, 66, 7, 20, 20, 89, 79, 85, 89, 4, 87, 17, 14, 81, 10, 95, 66, 81, 22, 10, 85, 17, 83, 26}, "6e31b4d869"));
                }
                if (j2 != 0) {
                    s = buffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    if (s < 1000 || s >= 5000) {
                        strM = NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{32, 9, 92, 1, 23, 84, 77, 70, 65, 20, 3, 93, 16, 8, 13, 70, 74, 5, 89, 94, 93, 21, 110, 5, 81, 8, 0, 77, 86, 86, 8, 84, 30, 3, 24}, "cf8d798554a80a", false), s);
                    } else {
                        strM = ((1004 > s || s >= 1007) && (1015 > s || s >= 3000)) ? null : NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{113, 87, 1, 87, 70}, "28e2fa", 6), C0000.decode(new byte[]{67, 91, 68, 67, 23, 82, 17, 6, 19, 19, 3, 86, 25, 87, 13, 86, 23, 14, 4, 78, 66, 13, 14, 17, 70, 80, 92, 22, 22, 65, 82, 7, 75}, "c27ce7bcaef296", 0.0f), s);
                    }
                    if (strM != null) {
                        throw new ProtocolException(strM);
                    }
                } else {
                    utf8 = "";
                    s = 1005;
                }
                RealWebSocket realWebSocket = (RealWebSocket) this.frameCallback;
                if (s == -1) {
                    realWebSocket.getClass();
                    throw new IllegalArgumentException(C0000.decode(new byte[]{112, 4, 81, 14, 80, 87, 21, 66, 83, 64, 76, 10, 66, 6, 15, 6, 88, 17, 22}, "6e8b5350619c0cbc", 0.0f));
                }
                synchronized (realWebSocket) {
                    if (realWebSocket.receivedCloseCode != -1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{84, 92, 16, 84, 7, 84, 77, 19, 80, 90, 95, 65, 0, 86}, "50b1f0433602e2", 0.0f));
                    }
                    realWebSocket.receivedCloseCode = s;
                    realWebSocket.receivedCloseReason = utf8;
                    if (realWebSocket.enqueuedClose && realWebSocket.messageAndCloseQueue.isEmpty()) {
                        realConnection$newWebSocketStreams$1 = realWebSocket.streams;
                        realWebSocket.streams = null;
                        webSocketReader = realWebSocket.reader;
                        realWebSocket.reader = null;
                        webSocketWriter = realWebSocket.writer;
                        realWebSocket.writer = null;
                        realWebSocket.taskQueue.shutdown();
                    } else {
                        realConnection$newWebSocketStreams$1 = null;
                        webSocketReader = null;
                        webSocketWriter = null;
                    }
                }
                try {
                    realWebSocket.close(null, 1000);
                    if (realConnection$newWebSocketStreams$1 != null) {
                        realWebSocket.listener.onClosed(utf8, s);
                        break;
                    }
                    if (realConnection$newWebSocketStreams$1 != null) {
                        Util.closeQuietly(realConnection$newWebSocketStreams$1);
                    }
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.closeQuietly(webSocketWriter);
                    }
                    this.closed = true;
                    return;
                } catch (Throwable th) {
                    if (realConnection$newWebSocketStreams$1 != null) {
                        Util.closeQuietly(realConnection$newWebSocketStreams$1);
                    }
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.closeQuietly(webSocketWriter);
                    }
                    throw th;
                }
            case 9:
                FrameCallback frameCallback = this.frameCallback;
                Buffer buffer2 = this.controlFrameBuffer;
                ByteString byteString = buffer2.readByteString(buffer2.size);
                RealWebSocket realWebSocket2 = (RealWebSocket) frameCallback;
                synchronized (realWebSocket2) {
                    try {
                        if (!realWebSocket2.failed && (!realWebSocket2.enqueuedClose || !realWebSocket2.messageAndCloseQueue.isEmpty())) {
                            realWebSocket2.pongQueue.add(byteString);
                            realWebSocket2.runWriter();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            case 10:
                FrameCallback frameCallback2 = this.frameCallback;
                Buffer buffer3 = this.controlFrameBuffer;
                buffer3.readByteString(buffer3.size);
                RealWebSocket realWebSocket3 = (RealWebSocket) frameCallback2;
                synchronized (realWebSocket3) {
                    realWebSocket3.awaitingPong = false;
                }
                return;
            default:
                int i = this.opcode;
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                throw new ProtocolException(C0000.decode(new byte[]{108, 93, 93, 90, 11, 64, 13, 68, 91, 91, 94, 67, 23, 89, 93, 20, 86, 67, 85, 91, 0, 82, 89, 68}, "9364d7cd8407e614", false).concat(Integer.toHexString(i)));
        }
    }

    public final void readHeader() throws IOException {
        boolean z;
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{2, 88, 94, 71, 87, 82}, "a4142686b5", true));
        }
        BufferedSource bufferedSource = this.source;
        long jTimeoutNanos = bufferedSource.timeout().timeoutNanos();
        bufferedSource.timeout().clearTimeout();
        try {
            byte b = bufferedSource.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            bufferedSource.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            int i = b & 15;
            this.opcode = i;
            boolean z2 = (b & 128) != 0;
            this.isFinalFrame = z2;
            boolean z3 = (b & 8) != 0;
            this.isControlFrame = z3;
            if (z3 && !z2) {
                throw new ProtocolException(C0000.decode(new byte[]{118, 12, 11, 71, 68, 13, 89, 67, 3, 65, 87, 15, 80, 16, 69, 94, 67, 17, 65, 67, 7, 86, 22, 4, 92, 13, 4, 95, 24}, "5ce36b", false));
            }
            boolean z4 = (b & 64) != 0;
            String strDecode = C0000.decode(new byte[]{100, 94, 6, 75, 70, 84, 82, 68, 6, 87, 22, 67, 66, 70, 82, 19, 80, 93, 80, 87}, "10c361", true);
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException(strDecode);
                    }
                    z = true;
                }
                this.readingCompressedMessage = z;
            } else if (z4) {
                throw new ProtocolException(strDecode);
            }
            if ((b & 32) != 0) {
                throw new ProtocolException(C0000.decode(new byte[]{54, 12, 1, 73, 69, 7, 7, 18, 83, 86, 19, 71, 21, 71, 4, 65, 5, 14, 5, 86}, "cbd15bdf6235f16a", 0.0f));
            }
            if ((b & 16) != 0) {
                throw new ProtocolException(C0000.decode(new byte[]{103, 93, 85, 29, 64, 82, 6, 66, 6, 85, 18, 65, 67, 19, 3, 23, 3, 90, 2, 86}, "230e07e6c1", false));
            }
            byte b2 = bufferedSource.readByte();
            boolean z5 = (b2 & 128) != 0;
            if (z5) {
                throw new ProtocolException(C0000.decode(new byte[]{55, 1, 65, 20, 86, 71, 79, 21, 3, 86, 17, 25, 2, 22, 82, 15, 86, 70, 66, 11, 19, 75, 17, 25, 10, 11, 71, 66, 81, 80, 66, 11, 7, 75, 14, 92, 0, 74}, "dd3b35bff8e9", false));
            }
            long j = b2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = bufferedSource.readShort() & 65535;
            } else if (j == 127) {
                long j2 = bufferedSource.readLong();
                this.frameLength = j2;
                if (j2 < 0) {
                    throw new ProtocolException(C0000.decode(new byte[]{32, 19, 80, 90, 81, 24, 94, 0, 95, 6, 64, 14, 70, 81, 73}, "fa17482e1a4f", 4) + Long.toHexString(this.frameLength) + C0000.decode(new byte[]{25, 95, 17, 8, 64, 81, 35, 34, 117, 39, 34, 32, 37, 112, 127, 39, 119, 126, 126, 32, 35}, "9a188fed3adfc6", 0.0f));
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException(C0000.decode(new byte[]{39, 93, 88, 65, 70, 13, 13, 25, 81, 67, 4, 88, 1, 18, 91, 64, 71, 22, 65, 91, 82, 17, 9, 80, 23, 65, 22, 65, 92, 3, 15, 25, 6, 3, 80, 119, 74}, "d2654ba971e5", 0.0f));
            }
            if (z5) {
                bufferedSource.readFully(this.maskKey);
            }
        } catch (Throwable th) {
            bufferedSource.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }
}
