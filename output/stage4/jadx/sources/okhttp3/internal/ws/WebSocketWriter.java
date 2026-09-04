package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;
import kotlin.io.CloseableKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Options;
import okio.Segment;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WebSocketWriter implements Closeable {
    public MessageDeflater messageDeflater;
    public final long minimumDeflateSize;
    public final boolean noContextTakeover;
    public final boolean perMessageDeflate;
    public final Random random;
    public final BufferedSink sink;
    public final Buffer sinkBuffer;
    public boolean writerClosed;
    public final Buffer messageBuffer = new Buffer();
    public final byte[] maskKey = new byte[4];
    public final Buffer.UnsafeCursor maskCursor = new Buffer.UnsafeCursor();

    public WebSocketWriter(BufferedSink bufferedSink, Random random, boolean z, boolean z2, long j) {
        this.sink = bufferedSink;
        this.random = random;
        this.perMessageDeflate = z;
        this.noContextTakeover = z2;
        this.minimumDeflateSize = j;
        this.sinkBuffer = bufferedSink.getBuffer();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            throw new IOException(C0000.decode(new byte[]{80, 92, 92, 17, 92, 87}, "303b9371", 0));
        }
        int size$okio = byteString.getSize$okio();
        if (size$okio > 125) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{101, 5, 65, 90, 10, 84, 81, 68, 75, 95, 31, 80, 21, 9, 77, 69, 17, 21, 87, 1, 24, 90, 0, 70, 70, 68, 76, 94, 4, 91, 21, 11, 74, 22, 0, 68, 64, 5, 84, 22, 17, 90, 21, 85, 10, 3}, "5d86e5", false));
        }
        Buffer buffer = this.sinkBuffer;
        buffer.m23writeByte(i | 128);
        buffer.m23writeByte(size$okio | 128);
        Random random = this.random;
        byte[] bArr = this.maskKey;
        random.nextBytes(bArr);
        buffer.write(bArr.length, bArr);
        if (size$okio > 0) {
            long j = buffer.size;
            byteString.write$okio(buffer, byteString.getSize$okio());
            Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
            buffer.readAndWriteUnsafe(unsafeCursor);
            unsafeCursor.seek(j);
            CloseableKt.toggleMask(unsafeCursor, bArr);
            unsafeCursor.close();
        }
        this.sink.flush();
    }

    public final void writeMessageFrame(ByteString byteString) throws IOException {
        int i;
        if (this.writerClosed) {
            throw new IOException(C0000.decode(new byte[]{90, 94, 86, 71, 84, 7}, "92941cc8bcd1"));
        }
        int size$okio = byteString.getSize$okio();
        Buffer buffer = this.messageBuffer;
        byteString.write$okio(buffer, size$okio);
        if (!this.perMessageDeflate || byteString.data.length < this.minimumDeflateSize) {
            i = 129;
        } else {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(0, this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            DeflaterSink deflaterSink = (DeflaterSink) messageDeflater.deflaterSink;
            Buffer buffer2 = messageDeflater.deflatedBytes;
            if (buffer2.size != 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{116, 4, 91, 84, 92, 6, 24, 23, 80, 64, 68, 93, 64, 0, 95, 93, 87, 22, 22}, "2e289b8e5114", true));
            }
            if (messageDeflater.noContextTakeover) {
                ((Deflater) messageDeflater.deflater).reset();
            }
            deflaterSink.write(buffer.size, buffer);
            deflaterSink.flush();
            ByteString byteString2 = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
            long j = buffer2.size;
            byte[] bArr = byteString2.data;
            long length = j - ((long) bArr.length);
            int length2 = bArr.length;
            if (length < 0 || length2 < 0 || j - length < length2 || bArr.length < length2) {
                buffer2.m23writeByte(0);
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    long j2 = buffer2.size - ((long) 4);
                    Buffer.UnsafeCursor andWriteUnsafe = buffer2.readAndWriteUnsafe(Options.Companion.DEFAULT__new_UnsafeCursor);
                    try {
                        andWriteUnsafe.resizeBuffer(j2);
                        andWriteUnsafe.close();
                        break;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(andWriteUnsafe, th);
                            throw th2;
                        }
                    }
                }
                if (buffer2.getByte(((long) i2) + length) != byteString2.data[i2]) {
                    buffer2.m23writeByte(0);
                    break;
                }
                i2++;
            }
            buffer.write(buffer2.size, buffer2);
            i = 193;
        }
        long j3 = buffer.size;
        Buffer buffer3 = this.sinkBuffer;
        buffer3.m23writeByte(i);
        if (j3 <= 125) {
            buffer3.m23writeByte(((int) j3) | 128);
        } else if (j3 <= 65535) {
            buffer3.m23writeByte(254);
            buffer3.m26writeShort((int) j3);
        } else {
            buffer3.m23writeByte(255);
            Segment segmentWritableSegment$okio = buffer3.writableSegment$okio(8);
            byte[] bArr2 = segmentWritableSegment$okio.data;
            int i3 = segmentWritableSegment$okio.limit;
            bArr2[i3] = (byte) ((j3 >>> 56) & 255);
            bArr2[i3 + 1] = (byte) ((j3 >>> 48) & 255);
            bArr2[i3 + 2] = (byte) ((j3 >>> 40) & 255);
            bArr2[i3 + 3] = (byte) ((j3 >>> 32) & 255);
            bArr2[i3 + 4] = (byte) ((j3 >>> 24) & 255);
            bArr2[i3 + 5] = (byte) ((j3 >>> 16) & 255);
            bArr2[i3 + 6] = (byte) ((j3 >>> 8) & 255);
            bArr2[i3 + 7] = (byte) (j3 & 255);
            segmentWritableSegment$okio.limit = i3 + 8;
            buffer3.size += 8;
        }
        Random random = this.random;
        byte[] bArr3 = this.maskKey;
        random.nextBytes(bArr3);
        buffer3.write(bArr3.length, bArr3);
        if (j3 > 0) {
            Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
            buffer.readAndWriteUnsafe(unsafeCursor);
            unsafeCursor.seek(0L);
            CloseableKt.toggleMask(unsafeCursor, bArr3);
            unsafeCursor.close();
        }
        buffer3.write(j3, buffer);
        this.sink.emit();
    }
}
