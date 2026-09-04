package okio;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.CharsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        this.source = source;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        Buffer buffer = this.bufferField;
        buffer.skip(buffer.size);
    }

    public final boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{82, 13, 90, 66, 80, 2}, "1a515f6d8143a304", true));
        }
        Buffer buffer = this.bufferField;
        return buffer.exhausted() && this.source.read(8192L, buffer) == -1;
    }

    public final long indexOf(byte b, long j, long j2) {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{87, 88, 93, 22, 81, 85}, "442e41af63"));
        }
        if (0 > j2) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{2, 17, 91, 91, 45, 90, 0, 6, 76, 11, 84, 20, 16, 12, 125, 88, 0, 81, 28, 94}, "dc46d4") + j2).toString());
        }
        long jMax = 0;
        while (jMax < j2) {
            Buffer buffer = this.bufferField;
            byte b2 = b;
            long j3 = j2;
            long jIndexOf = buffer.indexOf(b2, jMax, j3);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long j4 = buffer.size;
            if (j4 >= j3 || this.source.read(8192L, buffer) == -1) {
                break;
            }
            jMax = Math.max(jMax, j4);
            b = b2;
            j2 = j3;
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        Buffer buffer = this.bufferField;
        if (buffer.size == 0 && this.source.read(8192L, buffer) == -1) {
            return -1;
        }
        return buffer.read(byteBuffer);
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) {
        if (j < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{0, 77, 69, 86, 115, 93, 64, 90, 22, 20, 13, 19, 0, 8, 21}, "b4130254", 0.0f) + j).toString());
        }
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{87, 85, 92, 21, 3, 1}, "493ffe", 0.0f));
        }
        Buffer buffer2 = this.bufferField;
        if (buffer2.size == 0 && this.source.read(8192L, buffer2) == -1) {
            return -1L;
        }
        return buffer2.read(Math.min(j, buffer2.size), buffer);
    }

    @Override // okio.BufferedSource
    public final byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long j) throws EOFException {
        require(j);
        return this.bufferField.readByteString(j);
    }

    @Override // okio.BufferedSource
    public final void readFully(byte[] bArr) throws EOFException {
        Buffer buffer = this.bufferField;
        try {
            require(bArr.length);
            buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                long j = buffer.size;
                if (j <= 0) {
                    throw e;
                }
                int i2 = buffer.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // okio.BufferedSource
    public final long readHexadecimalUnsignedLong() throws EOFException {
        Buffer buffer;
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            boolean zRequest = request(i2);
            buffer = this.bufferField;
            if (!zRequest) {
                break;
            }
            byte b = buffer.getByte(i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (i != 0) {
                    break;
                }
                CharsKt.checkRadix(16);
                CharsKt.checkRadix(16);
                throw new NumberFormatException(C0000.decode(new byte[]{36, 28, 66, 86, 81, 76, 92, 2, 65, 8, 87, 82, 86, 81, 87, 1, 65, 63, 2, 30, 11, 89, 20, 0, 32, 73, 116, 110, 18, 91, 81, 7, 19, 5, 81, 71, 87, 74, 25, 4, 20, 16, 18, 68, 83, 75, 25, 86, 25}, "ad23289f").concat(Integer.toString(b, 16)));
            }
            i = i2;
        }
        return buffer.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public final int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    public final int readIntLe() throws EOFException {
        require(4L);
        int i = this.bufferField.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // okio.BufferedSource
    public final long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public final short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public final String readString(Charset charset) {
        Source source = this.source;
        Buffer buffer = this.bufferField;
        buffer.writeAll(source);
        return buffer.readString(buffer.size, charset);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{9, 88, 8, 91, 18, 66, 4, 67, 3, 94, 69}, "e1e2fb8c3d", 0.0f) + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        Buffer buffer = this.bufferField;
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(jIndexOf, buffer);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && buffer.getByte(j2 - 1) == 13 && request(j2 + 1) && buffer.getByte(j2) == 10) {
            return okio.internal.Buffer.readUtf8Line(j2, buffer);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size));
        throw new EOFException(C0000.decode(new byte[]{100, 11, 25, 11, 87, 17, 20, 80, 14, 17, 86, 1, 3, 69, 84, 12, 89, 95, 21, 89}, "8e9e8e46ad", 1) + Math.min(buffer.size, j) + C0000.decode(new byte[]{16, 80, 89, 8, 68, 81, 12, 77, 95}, "036f04b9be767114", false) + buffer2.readByteString(buffer2.size).hex() + (char) 8230);
    }

    public final boolean request(long j) {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{90, 31, 69, 80, 118, 10, 22, 86, 23, 67, 12, 21, 86, 94, 24}, "8f155ec8cc05fd") + j).toString());
        }
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{82, 94, 89, 69, 83, 5}, "12666a6b", 1));
        }
        do {
            buffer = this.bufferField;
            if (buffer.size >= j) {
                return true;
            }
        } while (this.source.read(8192L, buffer) != -1);
        return false;
    }

    @Override // okio.BufferedSource
    public final void require(long j) throws EOFException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final int select(Options options) throws EOFException {
        Buffer buffer;
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{83, 15, 87, 18, 4, 5}, "0c8aaa", 0.0f));
        }
        do {
            buffer = this.bufferField;
            int iSelectPrefix = okio.internal.Buffer.selectPrefix(buffer, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    break;
                }
                buffer.skip(options.byteStrings[iSelectPrefix].getSize$okio());
                return iSelectPrefix;
            }
        } while (this.source.read(8192L, buffer) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public final void skip(long j) throws EOFException {
        if (this.closed) {
            throw new IllegalStateException(C0000.decode(new byte[]{2, 10, 10, 23, 93, 92}, "afed88"));
        }
        while (j > 0) {
            Buffer buffer = this.bufferField;
            if (buffer.size == 0 && this.source.read(8192L, buffer) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, buffer.size);
            buffer.skip(jMin);
            j -= jMin;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{90, 67, 85, 2, 92, 70, 25}, "863d94145be1d6", 1));
        sb.append(this.source);
        sb.append(')');
        return sb.toString();
    }

    @Override // okio.BufferedSource
    public final void readFully(long j, Buffer buffer) throws EOFException {
        Buffer buffer2 = this.bufferField;
        try {
            require(j);
            buffer2.readFully(j, buffer);
        } catch (EOFException e) {
            buffer.writeAll(buffer2);
            throw e;
        }
    }
}
