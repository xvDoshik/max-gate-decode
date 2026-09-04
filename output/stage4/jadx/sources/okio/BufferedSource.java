package okio;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    byte readByte();

    ByteString readByteString(long j);

    void readFully(long j, Buffer buffer);

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    long readLong();

    short readShort();

    String readString(Charset charset);

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j);

    void require(long j);

    int select(Options options);

    void skip(long j);
}
