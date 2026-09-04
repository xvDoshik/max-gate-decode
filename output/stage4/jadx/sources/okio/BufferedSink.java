package okio;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink emit();

    @Override // okio.Sink, java.io.Flushable
    void flush();

    Buffer getBuffer();

    BufferedSink write(ByteString byteString);

    BufferedSink write(byte[] bArr);

    BufferedSink writeByte(int i);

    BufferedSink writeHexadecimalUnsignedLong(long j);

    BufferedSink writeInt(int i);

    BufferedSink writeShort(int i);

    BufferedSink writeUtf8(String str);
}
