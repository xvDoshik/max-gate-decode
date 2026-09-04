package okhttp3.internal.ws;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import com.base.template.network.WsPersistManager;
import com.base.template.network.WsPersistManager$connect$1$1;
import com.base.template.services.ProxyService;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection$newWebSocketStreams$1;
import okio.Buffer;
import okio.ByteString;
import okio.InflaterSource;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final List ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    public boolean awaitingPong;
    public RealCall call;
    public boolean enqueuedClose;
    public boolean failed;
    public final String key;
    public final WsPersistManager$connect$1$1 listener;
    public final long minimumDeflateSize;
    public String name;
    public final long pingIntervalMillis;
    public long queueSize;
    public final Random random;
    public WebSocketReader reader;
    public String receivedCloseReason;
    public int sentPingCount;
    public RealConnection$newWebSocketStreams$1 streams;
    public final TaskQueue taskQueue;
    public WebSocketWriter writer;
    public WriterTask writerTask;
    public WebSocketExtensions extensions = null;
    public final ArrayDeque pongQueue = new ArrayDeque();
    public final ArrayDeque messageAndCloseQueue = new ArrayDeque();
    public int receivedCloseCode = -1;

    public final class Close {
        public final int code;
        public final ByteString reason;

        public Close(int i, ByteString byteString) {
            this.code = i;
            this.reason = byteString;
        }
    }

    public final class Message {
        public final ByteString data;

        public Message(ByteString byteString) {
            this.data = byteString;
        }
    }

    public final class WriterTask extends Task {
        public final /* synthetic */ int $r8$classId = 1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WriterTask(String str, RealWebSocket realWebSocket) {
            super(str, true);
            RealWebSocket.this = realWebSocket;
        }

        public WriterTask() {
            super(FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), RealWebSocket.this.name, C0000.decode(new byte[]{68, 20, 23, 91, 23, 4, 22}, "dce2cad206455c33", 3)), true);
        }

        @Override // okhttp3.internal.concurrent.Task
        public final long runOnce() {
            switch (this.$r8$classId) {
                case 0:
                    RealWebSocket realWebSocket = RealWebSocket.this;
                    try {
                        return realWebSocket.writeOneFrame$okhttp() ? 0L : -1L;
                    } catch (IOException e) {
                        realWebSocket.failWebSocket(e);
                    }
                    break;
                default:
                    RealWebSocket.this.call.cancel();
                    return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WsPersistManager$connect$1$1 wsPersistManager$connect$1$1, Random random, long j, long j2) {
        this.listener = wsPersistManager$connect$1$1;
        this.random = random;
        this.pingIntervalMillis = j;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.newQueue();
        String str = (String) request.method;
        if (!C0000.decode(new byte[]{36, 115, 96}, "c641e7f584").equals(str)) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{54, 92, 65, 20, 80, 71, 76, 22, 9, 76, 67, 21, 21, 86, 93, 22, 35, 124, 100, 91, 21}, "d90a5486", true) + str).toString());
        }
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.Companion.of$default(bArr).base64();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) {
        Headers headers = response.headers;
        int i = response.code;
        if (i != 101) {
            throw new ProtocolException(C0000.decode(new byte[]{35, 75, 73, 82, 84, 16, 86, 80, 24, 45, 101, 49, 101, 67, 87, 3, 8, 23, 69, 1, 64, 68, 87, 11, 66, 0, 21, 1, 19, 71, 25, 64, 86, 23, 19, 19}, "f3977d348e1e5c", false) + i + ' ' + response.message + '\'');
        }
        String str = headers.get(C0000.decode(new byte[]{116, 91, 90, 11, 81, 1, 65, 11, 88, 15}, "744e4b5b7a", 0.0f));
        if (str == null) {
            str = null;
        }
        String strDecode = C0000.decode(new byte[]{100, 66, 95, 17, 88, 0, 92}, "128c9d93", false);
        if (!strDecode.equalsIgnoreCase(str)) {
            throw new ProtocolException(C0000.decode(new byte[]{115, 73, 70, 6, 5, 65, 92, 83, 65, 66, 115, 94, 88, 95, 83, 0, 18, 92, 86, 89, 70, 69, 88, 84, 87, 85, 83, 17, 70, 67, 88, 91, 20, 0, 16, 22, 99, 65, 81, 17, 7, 81, 92, 16, 65, 7, 69, 69, 22, 70, 87, 16, 70, 18}, "616cf597ae01") + str + '\'');
        }
        String str2 = headers.get(strDecode);
        if (str2 == null) {
            str2 = null;
        }
        if (!C0000.decode(new byte[]{78, 87, 87, 69, 88, 91, 88, 85, 66}, "9256783069a9", 0.0f).equalsIgnoreCase(str2)) {
            throw new ProtocolException(C0000.decode(new byte[]{114, 28, 22, 4, 84, 17, 6, 83, 68, 23, 48, 69, 80, 22, 7, 5, 82, 66, 67, 95, 1, 81, 1, 80, 69, 68, 16, 0, 91, 16, 6, 23, 67, 71, 0, 87, 68, 11, 5, 10, 82, 17, 68, 23, 6, 69, 17, 21, 64, 5, 21, 65, 16}, "7dfa7ec7d0e5", 1) + str2 + '\'');
        }
        String str3 = headers.get(C0000.decode(new byte[]{106, 7, 82, 72, 51, 87, 4, 98, 86, 2, 88, 82, 70, 26, 112, 91, 90, 7, 65, 17}, "9b1ed2f19a372718"));
        String str4 = str3 != null ? str3 : null;
        byte[] bytes = FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), this.key, C0000.decode(new byte[]{0, 2, 14, 124, 39, 32, 112, 3, 79, 119, 11, 6, 2, 20, 82, 81, 117, 119, 79, 11, 7, 116, 119, 20, 37, 83, 112, 116, 82, 118, 113, 15, 3, 123, 87, 87}, "2769ff16b2")).getBytes(Charsets.UTF_8);
        MessageDigest messageDigest = MessageDigest.getInstance(C0000.decode(new byte[]{101, 125, 32, 75, 4}, "65af500a513986cf"));
        messageDigest.update(bytes, 0, bytes.length);
        String strBase64 = new ByteString(messageDigest.digest()).base64();
        if (Intrinsics.areEqual(strBase64, str4)) {
            if (exchange == null) {
                throw new ProtocolException(C0000.decode(new byte[]{53, 93, 87, 19, 50, 9, 91, 82, 85, 23, 66, 93, 77, 80, 9, 7, 86, 94, 85, 67, 15, 81, 70, 64, 8, 8, 95, 3, 16, 1, 3, 92, 21, 90, 15, 18, 93, 75, 83, 6, 18, 76, 90, 65, 94}, "b853af890c"));
            }
            return;
        }
        throw new ProtocolException(C0000.decode(new byte[]{36, 28, 17, 85, 83, 64, 85, 81, 66, 67, 48, 85, 83, 79, 54, 1, 3, 99, 95, 87, 91, 80, 22, 73, 34, 83, 83, 7, 17, 16, 70, 16, 88, 81, 81, 81, 7, 22, 67, 70, 81, 14, 20, 1, 65, 23}, "ada00405bdc00b") + strBase64 + C0000.decode(new byte[]{21, 24, 81, 68, 17, 25, 68, 81, 68, 67, 23}, "2831e9307c01", 0.0f) + str4 + '\'');
    }

    public final boolean close(String str, int i) {
        String str2;
        String strDecode = C0000.decode(new byte[]{69, 86, 7, 21, 87, 15, 25, 64, 15, 28, 93, 73, 30, 19, 88, 70, 9, 83, 4, 9, 70}, "73ff8a", 0.0f);
        synchronized (this) {
            ByteString byteString = null;
            try {
                if (i < 1000 || i >= 5000) {
                    str2 = C0000.decode(new byte[]{32, 9, 7, 83, 66, 84, 16, 18, 70, 67, 84, 84, 18, 11, 11, 23, 17, 7, 13, 81, 7, 25, 62, 80, 2, 83, 6, 29, 7, 82, 85, 7, 74, 92, 67}, "cfc6b9ea2c612be7", 0.0f) + i;
                } else if ((1004 > i || i >= 1007) && (1015 > i || i >= 3000)) {
                    str2 = null;
                } else {
                    str2 = C0000.decode(new byte[]{115, 13, 2, 87, 22}, "0bf26399859ac493", false) + i + C0000.decode(new byte[]{25, 91, 17, 67, 17, 4, 74, 87, 16, 21, 6, 5, 25, 83, 12, 7, 67, 12, 88, 75, 66, 13, 12, 21, 25, 80, 7, 67, 22, 18, 92, 86, 76}, "92bcca", 3);
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    byte[] bytes = str.getBytes(Charsets.UTF_8);
                    byteString = new ByteString(bytes);
                    byteString.utf8 = str;
                    if (bytes.length > 123) {
                        throw new IllegalArgumentException(strDecode.concat(str).toString());
                    }
                }
                if (!this.failed && !this.enqueuedClose) {
                    this.enqueuedClose = true;
                    this.messageAndCloseQueue.add(new Close(i, byteString));
                    runWriter();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void failWebSocket(Exception exc) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1 = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            try {
                WsPersistManager$connect$1$1 wsPersistManager$connect$1$1 = this.listener;
                Object obj = WsPersistManager.lock;
                long j = wsPersistManager$connect$1$1.$gen;
                exc.getMessage();
                WsPersistManager.access$onDisconnected(j);
            } finally {
                if (realConnection$newWebSocketStreams$1 != null) {
                    Util.closeQuietly(realConnection$newWebSocketStreams$1);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    public final void initReaderAndWriter(String str, RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1) {
        String strDecode = C0000.decode(new byte[]{67, 71, 15, 90, 85}, "c7f421d96096", 0.0f);
        WebSocketExtensions webSocketExtensions = this.extensions;
        synchronized (this) {
            try {
                this.name = str;
                this.streams = realConnection$newWebSocketStreams$1;
                this.writer = new WebSocketWriter(realConnection$newWebSocketStreams$1.sink, this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.clientNoContextTakeover, this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j = this.pingIntervalMillis;
                if (j != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    TaskQueue taskQueue = this.taskQueue;
                    final String strConcat = str.concat(strDecode);
                    taskQueue.schedule(new Task(strConcat) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1
                        @Override // okhttp3.internal.concurrent.Task
                        public final long runOnce() {
                            WebSocketWriter webSocketWriter;
                            RealWebSocket realWebSocket = this;
                            synchronized (realWebSocket) {
                                try {
                                    if (!realWebSocket.failed && (webSocketWriter = realWebSocket.writer) != null) {
                                        int i = realWebSocket.awaitingPong ? realWebSocket.sentPingCount : -1;
                                        realWebSocket.sentPingCount++;
                                        realWebSocket.awaitingPong = true;
                                        if (i != -1) {
                                            realWebSocket.failWebSocket(new SocketTimeoutException(C0000.decode(new byte[]{71, 82, 90, 21, 22, 73, 13, 89, 85, 70, 90, 69, 64, 23, 80, 8, 82, 87, 67, 67, 18, 20, 93, 83, 81, 94, 66, 4, 22, 73, 11, 89, 85, 70, 79, 89, 64, 95, 93, 15, 22}, "474a69d72f80", false) + realWebSocket.pingIntervalMillis + C0000.decode(new byte[]{93, 64, 24, 73, 4, 80, 64, 80, 16, 66}, "038ae645bb", false) + (i - 1) + C0000.decode(new byte[]{69, 67, 22, 84, 86, 4, 68, 68, 4, 64, 9, 16, 19, 94, 91, 6, 24, 71, 13, 91, 2, 67, 74}, "e0c75a77b5", 4)));
                                        } else {
                                            try {
                                                webSocketWriter.writeControlFrame(9, ByteString.EMPTY);
                                            } catch (IOException e) {
                                                realWebSocket.failWebSocket(e);
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return nanos;
                        }
                    }, nanos);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(realConnection$newWebSocketStreams$1.source, this, webSocketExtensions.perMessageDeflate, webSocketExtensions.serverNoContextTakeover);
    }

    public final void loopReader() {
        JSONObject jSONObjectOptJSONObject;
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            webSocketReader.readHeader();
            if (webSocketReader.isControlFrame) {
                webSocketReader.readControlFrame();
            } else {
                int i = webSocketReader.opcode;
                if (i != 1 && i != 2) {
                    byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                    throw new ProtocolException(C0000.decode(new byte[]{103, 93, 15, 86, 13, 69, 10, 69, 88, 65, 84, 95, 86, 93, 8, 22}, "23d8b2de71702826", 6).concat(Integer.toHexString(i)));
                }
                while (true) {
                    if (!webSocketReader.closed) {
                        long j = webSocketReader.frameLength;
                        if (j > 0) {
                            webSocketReader.source.readFully(j, webSocketReader.messageFrameBuffer);
                        }
                        if (webSocketReader.isFinalFrame) {
                            if (webSocketReader.readingCompressedMessage) {
                                MessageDeflater messageDeflater = webSocketReader.messageInflater;
                                if (messageDeflater == null) {
                                    messageDeflater = new MessageDeflater(1, webSocketReader.noContextTakeover);
                                    webSocketReader.messageInflater = messageDeflater;
                                }
                                Buffer buffer = webSocketReader.messageFrameBuffer;
                                Inflater inflater = (Inflater) messageDeflater.deflater;
                                Buffer buffer2 = messageDeflater.deflatedBytes;
                                if (buffer2.size != 0) {
                                    throw new IllegalArgumentException(C0000.decode(new byte[]{37, 4, 10, 91, 80, 2, 67, 23, 6, 70, 64, 15, 17, 0, 14, 82, 91, 18, 77}, "cec75f", false));
                                }
                                if (messageDeflater.noContextTakeover) {
                                    inflater.reset();
                                }
                                buffer2.writeAll(buffer);
                                buffer2.m25writeInt(65535);
                                long bytesRead = inflater.getBytesRead() + buffer2.size;
                                do {
                                    ((InflaterSource) messageDeflater.deflaterSink).readOrInflate(Long.MAX_VALUE, buffer);
                                } while (inflater.getBytesRead() < bytesRead);
                            }
                            if (i != 1) {
                                WebSocketReader.FrameCallback frameCallback = webSocketReader.frameCallback;
                                Buffer buffer3 = webSocketReader.messageFrameBuffer;
                                buffer3.readByteString(buffer3.size);
                                WsPersistManager$connect$1$1 wsPersistManager$connect$1$1 = ((RealWebSocket) frameCallback).listener;
                                break;
                            }
                            WebSocketReader.FrameCallback frameCallback2 = webSocketReader.frameCallback;
                            String utf8 = webSocketReader.messageFrameBuffer.readUtf8();
                            if (WsPersistManager.generation.get() == ((RealWebSocket) frameCallback2).listener.$gen) {
                                try {
                                    JSONObject jSONObject = new JSONObject(utf8);
                                    String strOptString = jSONObject.optString(C0000.decode(new byte[]{65, 73, 73, 80}, "5095dd2c489374", false), "");
                                    if (strOptString != null) {
                                        int iHashCode = strOptString.hashCode();
                                        if (iHashCode == 98618) {
                                            if (!strOptString.equals(C0000.decode(new byte[]{0, 89, 2}, "c4fda205", true)) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(C0000.decode(new byte[]{80, 4, 76, 85}, "4e845997d7a8ebee"))) == null) {
                                                break;
                                                break;
                                            }
                                            jSONObjectOptJSONObject.optString(C0000.decode(new byte[]{86, 13, 15, 84, 2, 12, 81}, "5bb9cb5651", true), C0000.decode(new byte[]{6}, "90564b63fe", true));
                                            ProxyService.AnonymousClass1 anonymousClass1 = WsPersistManager.commandCallback;
                                            if (anonymousClass1 == null) {
                                                break;
                                            }
                                            anonymousClass1.invoke(jSONObjectOptJSONObject);
                                            break;
                                        }
                                        if (iHashCode == 3441010) {
                                            if (!strOptString.equals(C0000.decode(new byte[]{22, 93, 95, 2}, "f41eb26a273e4f9e", 0.0f))) {
                                                break;
                                            }
                                            synchronized (WsPersistManager.lock) {
                                                WsPersistManager.lastPongMs = System.currentTimeMillis();
                                            }
                                            try {
                                                RealWebSocket realWebSocket = WsPersistManager.ws;
                                                if (realWebSocket == null) {
                                                    break;
                                                }
                                                realWebSocket.send(C0000.decode(new byte[]{79, 64, 66, 76, 64, 3, 22, 2, 19, 68, 91, 12, 81, 23, 77}, "4b650f4814", false));
                                                break;
                                            } catch (Exception unused) {
                                                break;
                                            }
                                        }
                                        if (iHashCode != 3446776 || !strOptString.equals(C0000.decode(new byte[]{64, 11, 87, 6}, "0d9ad5d265de", 0.0f))) {
                                            break;
                                            break;
                                        } else {
                                            synchronized (WsPersistManager.lock) {
                                                WsPersistManager.lastPongMs = System.currentTimeMillis();
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                } catch (Exception e) {
                                    e.getMessage();
                                    break;
                                }
                            }
                            break;
                        }
                        while (!webSocketReader.closed) {
                            webSocketReader.readHeader();
                            if (!webSocketReader.isControlFrame) {
                                break;
                            } else {
                                webSocketReader.readControlFrame();
                            }
                        }
                        if (webSocketReader.opcode != 0) {
                            int i2 = webSocketReader.opcode;
                            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                            throw new ProtocolException(C0000.decode(new byte[]{35, 79, 71, 4, 81, 18, 7, 6, 24, 5, 10, 12, 66, 93, 8, 66, 86, 21, 91, 9, 12, 66, 87, 22, 6, 13, 82, 81, 72, 23, 112, 14, 70, 92, 66}, "f77a2fbb8feb64", false).concat(Integer.toHexString(i2)));
                        }
                    } else {
                        throw new IOException(C0000.decode(new byte[]{6, 15, 95, 18, 0, 85}, "ec0ae1071f"));
                    }
                }
            }
        }
    }

    public final void runWriter() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        WriterTask writerTask = this.writerTask;
        if (writerTask != null) {
            this.taskQueue.schedule(writerTask, 0L);
        }
    }

    public final boolean send(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        ByteString byteString = new ByteString(bytes);
        byteString.utf8 = str;
        synchronized (this) {
            if (!this.failed && !this.enqueuedClose) {
                long j = this.queueSize;
                if (((long) bytes.length) + j > 16777216) {
                    close(null, 1001);
                    return false;
                }
                this.queueSize = j + ((long) bytes.length);
                this.messageAndCloseQueue.add(new Message(byteString));
                runWriter();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[Catch: all -> 0x008a, TRY_ENTER, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008d A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0091 A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00aa A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0100 A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x011d A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0127 A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x013d A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0144  */
    /* JADX WARN: Code duplicated, block: B:72:0x0149  */
    /* JADX WARN: Code duplicated, block: B:74:0x014e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0156 A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0160 A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:28:0x0081, B:31:0x008d, B:33:0x0091, B:34:0x0098, B:36:0x00a4, B:39:0x00a8, B:40:0x00a9, B:41:0x00aa, B:43:0x00ae, B:57:0x00d1, B:60:0x011d, B:62:0x0127, B:63:0x012e, B:66:0x0139, B:68:0x013d, B:77:0x0153, B:78:0x0155, B:79:0x0156, B:80:0x015f, B:58:0x0100, B:81:0x0160, B:82:0x0165, B:65:0x0136, B:35:0x0099), top: B:97:0x007f, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0100, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean writeOneFrame$okhttp() {
        Object objPoll;
        String str;
        int i;
        ?? r4;
        ?? r8;
        ?? r7;
        int i2;
        ByteString byteString;
        Buffer buffer;
        Message message;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter = this.writer;
                Object objPoll2 = this.pongQueue.poll();
                String str2 = null;
                try {
                    if (objPoll2 == null) {
                        objPoll = this.messageAndCloseQueue.poll();
                        if (objPoll instanceof Close) {
                            i = this.receivedCloseCode;
                            str = this.receivedCloseReason;
                            if (i != -1) {
                                RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1 = this.streams;
                                this.streams = null;
                                WebSocketReader webSocketReader = this.reader;
                                this.reader = null;
                                WebSocketWriter webSocketWriter2 = this.writer;
                                this.writer = null;
                                this.taskQueue.shutdown();
                                r4 = realConnection$newWebSocketStreams$1;
                                r7 = webSocketReader;
                                r8 = webSocketWriter2;
                            } else {
                                this.taskQueue.schedule(new WriterTask(this.name + C0000.decode(new byte[]{24, 87, 85, 10, 0, 92, 84}, "844dc9", 0.0f), this), TimeUnit.MILLISECONDS.toNanos(60000L));
                                r4 = 0;
                                r7 = 0;
                                r8 = 0;
                            }
                        } else {
                            if (objPoll == null) {
                                return false;
                            }
                            str = null;
                        }
                        if (objPoll2 != null) {
                            webSocketWriter.writeControlFrame(10, (ByteString) objPoll2);
                        } else if (objPoll instanceof Message) {
                            message = (Message) objPoll;
                            webSocketWriter.writeMessageFrame(message.data);
                            synchronized (this) {
                                this.queueSize -= (long) message.data.data.length;
                            }
                        } else {
                            if (objPoll instanceof Close) {
                                throw new AssertionError();
                            }
                            Close close = (Close) objPoll;
                            i2 = close.code;
                            byteString = close.reason;
                            webSocketWriter.getClass();
                            if (i2 >= 1000 || i2 >= 5000) {
                                str2 = C0000.decode(new byte[]{38, 13, 87, 4, 66, 15, 16, 17, 71, 65, 0, 7, 69, 11, 93, 65, 16, 3, 11, 5, 86, 65, 57, 83, 85, 82, 3, 77, 87, 82, 85, 82, 26, 91, 66}, "eb3abb") + i2;
                            } else if ((1004 <= i2 && i2 < 1007) || (1015 <= i2 && i2 < 3000)) {
                                str2 = C0000.decode(new byte[]{122, 92, 2, 84, 69}, "93f1ee04dd320b3e", 0.0f) + i2 + C0000.decode(new byte[]{69, 10, 68, 22, 70, 81, 64, 93, 23, 21, 82, 82, 20, 85, 93, 92, 69, 14, 86, 79, 20, 90, 92, 76, 69, 1, 82, 22, 65, 71, 86, 92, 75}, "ec764438", 0);
                            }
                            if (str2 == null) {
                                throw new IllegalArgumentException(str2.toString());
                            }
                            buffer = new Buffer();
                            buffer.m26writeShort(i2);
                            if (byteString != null) {
                                byteString.write$okio(buffer, byteString.getSize$okio());
                            }
                            try {
                                webSocketWriter.writeControlFrame(8, buffer.readByteString(buffer.size));
                                webSocketWriter.writerClosed = true;
                                if (r4 != 0) {
                                    this.listener.onClosed(str, i);
                                }
                            } catch (Throwable th) {
                                webSocketWriter.writerClosed = true;
                                throw th;
                            }
                        }
                        if (r4 != 0) {
                            Util.closeQuietly((Closeable) r4);
                        }
                        if (r7 != 0) {
                            Util.closeQuietly((Closeable) r7);
                        }
                        if (r8 != 0) {
                            Util.closeQuietly((Closeable) r8);
                        }
                        return true;
                    }
                    objPoll = null;
                    str = null;
                    if (objPoll2 != null) {
                        webSocketWriter.writeControlFrame(10, (ByteString) objPoll2);
                    } else if (objPoll instanceof Message) {
                        message = (Message) objPoll;
                        webSocketWriter.writeMessageFrame(message.data);
                        synchronized (this) {
                            this.queueSize -= (long) message.data.data.length;
                        }
                    } else {
                        if (objPoll instanceof Close) {
                            throw new AssertionError();
                        }
                        Close close2 = (Close) objPoll;
                        i2 = close2.code;
                        byteString = close2.reason;
                        webSocketWriter.getClass();
                        if (i2 >= 1000) {
                            str2 = C0000.decode(new byte[]{38, 13, 87, 4, 66, 15, 16, 17, 71, 65, 0, 7, 69, 11, 93, 65, 16, 3, 11, 5, 86, 65, 57, 83, 85, 82, 3, 77, 87, 82, 85, 82, 26, 91, 66}, "eb3abb") + i2;
                        } else {
                            str2 = C0000.decode(new byte[]{38, 13, 87, 4, 66, 15, 16, 17, 71, 65, 0, 7, 69, 11, 93, 65, 16, 3, 11, 5, 86, 65, 57, 83, 85, 82, 3, 77, 87, 82, 85, 82, 26, 91, 66}, "eb3abb") + i2;
                        }
                        if (str2 == null) {
                            throw new IllegalArgumentException(str2.toString());
                        }
                        buffer = new Buffer();
                        buffer.m26writeShort(i2);
                        if (byteString != null) {
                            byteString.write$okio(buffer, byteString.getSize$okio());
                        }
                        webSocketWriter.writeControlFrame(8, buffer.readByteString(buffer.size));
                        webSocketWriter.writerClosed = true;
                        if (r4 != 0) {
                            this.listener.onClosed(str, i);
                        }
                    }
                    if (r4 != 0) {
                        Util.closeQuietly((Closeable) r4);
                    }
                    if (r7 != 0) {
                        Util.closeQuietly((Closeable) r7);
                    }
                    if (r8 != 0) {
                        Util.closeQuietly((Closeable) r8);
                    }
                    return true;
                } catch (Throwable th2) {
                    if (r4 != 0) {
                        Util.closeQuietly((Closeable) r4);
                    }
                    if (r7 != 0) {
                        Util.closeQuietly((Closeable) r7);
                    }
                    if (r8 != 0) {
                        Util.closeQuietly((Closeable) r8);
                    }
                    throw th2;
                }
                String str3 = str;
                String str4 = str3;
                i = -1;
                r4 = str4;
                r7 = str3;
                r8 = str4;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
