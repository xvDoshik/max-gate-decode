package okio;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    public long size;

    public final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        public Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.buffer == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{10, 87, 76, 65, 82, 71, 71, 86, 2, 9, 92, 81, 68, 76, 87, 65, 82, 19, 81, 66, 7, 7, 92, 71}, "d88a3337aa95", 0.0f));
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final void resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                }
                long j3 = j2 - j;
                while (j3 > 0) {
                    Segment segment = buffer.head.prev;
                    int i = segment.limit;
                    long j4 = i - segment.pos;
                    if (j4 > j3) {
                        segment.limit = i - ((int) j3);
                        break;
                    } else {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                        j3 -= j4;
                    }
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                int i2 = 1;
                boolean z = true;
                for (long j6 = 0; j5 > j6; j6 = 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
                    int iMin = (int) Math.min(j5, 8192 - segmentWritableSegment$okio.limit);
                    int i3 = segmentWritableSegment$okio.limit + iMin;
                    segmentWritableSegment$okio.limit = i3;
                    j5 -= (long) iMin;
                    if (z) {
                        this.segment = segmentWritableSegment$okio;
                        this.offset = j2;
                        this.data = segmentWritableSegment$okio.data;
                        this.start = i3 - iMin;
                        this.end = i3;
                        z = false;
                    }
                    i2 = 1;
                }
            }
            buffer.size = j;
        }

        public final int seek(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j >= -1) {
                long j2 = buffer.size;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment = buffer.head;
                    Segment segment2 = this.segment;
                    long j3 = 0;
                    if (segment2 != null) {
                        long j4 = this.offset - ((long) (this.start - segment2.pos));
                        if (j4 > j) {
                            segment2 = segment;
                            segment = segment2;
                            j2 = j4;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            long j5 = ((long) (segment2.limit - segment2.pos)) + j3;
                            if (j < j5) {
                                break;
                            }
                            segment2 = segment2.next;
                            j3 = j5;
                        }
                    } else {
                        while (j2 > j) {
                            segment = segment.prev;
                            j2 -= (long) (segment.limit - segment.pos);
                        }
                        segment2 = segment;
                        j3 = j2;
                    }
                    if (this.readWrite && segment2.shared) {
                        byte[] bArr = segment2.data;
                        Segment segment3 = new Segment(Arrays.copyOf(bArr, bArr.length), segment2.pos, segment2.limit, false, true);
                        if (buffer.head == segment2) {
                            buffer.head = segment3;
                        }
                        segment2.push(segment3);
                        segment3.prev.pop();
                        segment2 = segment3;
                    }
                    this.segment = segment2;
                    this.offset = j;
                    this.data = segment2.data;
                    int i = segment2.pos + ((int) (j - j3));
                    this.start = i;
                    int i2 = segment2.limit;
                    this.end = i2;
                    return i2 - i;
                }
            }
            throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size);
        }
    }

    public final Object clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segment = this.head;
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            segmentSharedCopy.prev.push(segment2.sharedCopy());
        }
        buffer.size = this.size;
        return buffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
    }

    public final void copyTo(Buffer buffer, long j, long j2) {
        long j3 = j;
        Options.Companion.checkOffsetAndCount(this.size, j3, j2);
        if (j2 == 0) {
            return;
        }
        buffer.size += j2;
        Segment segment = this.head;
        while (true) {
            long j4 = segment.limit - segment.pos;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            segment = segment.next;
        }
        Segment segment2 = segment;
        long j5 = j2;
        while (j5 > 0) {
            Segment segmentSharedCopy = segment2.sharedCopy();
            int i = segmentSharedCopy.pos + ((int) j3);
            segmentSharedCopy.pos = i;
            segmentSharedCopy.limit = Math.min(i + ((int) j5), segmentSharedCopy.limit);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer.head = segmentSharedCopy;
            } else {
                segment3.prev.push(segmentSharedCopy);
            }
            j5 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
            segment2 = segment2.next;
            j3 = 0;
        }
    }

    @Override // okio.BufferedSink
    public final BufferedSink emit() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        long j = this.size;
        Buffer buffer = (Buffer) obj;
        if (j != buffer.size) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        long j2 = 0;
        while (j2 < this.size) {
            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j2 += jMin;
        }
        return true;
    }

    public final boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.BufferedSink
    public final Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        Options.Companion.checkOffsetAndCount(this.size, j, 1L);
        Segment segment = this.head;
        segment.getClass();
        long j2 = this.size;
        if (j2 - j < j) {
            while (j2 > j) {
                segment = segment.prev;
                j2 -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return segment.data[(int) ((((long) i2) + j) - j3)];
            }
            segment = segment.next;
            j3 = j4;
        }
    }

    public final int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public final long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{65, 88, 73, 80, 94}, "2135c3b8") + this.size + C0000.decode(new byte[]{69, 94, 66, 94, 90, 44, 8, 84, 0, 64, 13}, "e8017ef0") + j + C0000.decode(new byte[]{19, 68, 11, 126, 91, 93, 84, 78, 89}, "30d75916da4341") + j2).toString());
        }
        long j4 = this.size;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (segment = this.head) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.prev;
                j4 -= (long) (segment.limit - segment.pos);
            }
            while (j4 < j2) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - j4);
                for (int i = (int) ((((long) segment.pos) + j) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - segment.pos)) + j4;
                    }
                }
                j4 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = ((long) (segment.limit - segment.pos)) + j3;
            if (j5 > j) {
                break;
            }
            segment = segment.next;
            j3 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - j3);
            for (int i2 = (int) ((((long) segment.pos) + j) - j3); i2 < iMin2; i2++) {
                if (bArr2[i2] == b) {
                    return ((long) (i2 - segment.pos)) + j3;
                }
            }
            j3 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j = j3;
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) {
        if (j < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{83, 27, 66, 0, 39, 13, 23, 87, 16, 69, 14, 21, 1, 88, 22}, "1b6edbb9de25", 4) + j).toString());
        }
        long j2 = this.size;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer.write(j, this);
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        byte[] bArr = okio.internal.Buffer.HEX_DIGIT_BYTES;
        if (unsafeCursor == Options.Companion.DEFAULT__new_UnsafeCursor) {
            unsafeCursor = new UnsafeCursor();
        }
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException(C0000.decode(new byte[]{82, 84, 16, 92, 2, 92, 26, 65, 82, 76, 22, 88, 0, 80, 6, 5, 19, 76, 13, 25, 2, 24, 1, 20, 85, 94, 7, 75}, "38b9c8ca", false));
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public final byte readByte() throws EOFException {
        long j = this.size;
        if (j == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size = j - 1;
        if (i3 != i2) {
            segment.pos = i3;
            return b;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return b;
    }

    public final byte[] readByteArray(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{3, 28, 65, 6, 118, 87, 20, 93, 17, 14, 18}, "ae5c58a3e42f9b", true) + j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{85, 31, 23, 83, 117, 11, 70, 15, 76, 94, 23}, "7fc66d3a8d7cd5", true) + j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(readByteArray(j));
        }
        ByteString byteStringSnapshot = snapshot((int) j);
        skip(j);
        return byteStringSnapshot;
    }

    @Override // okio.BufferedSource
    public final void readFully(long j, Buffer buffer) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(j, this);
        } else {
            buffer.write(j2, this);
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final long readHexadecimalUnsignedLong() throws EOFException {
        int i;
        if (this.size == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = this.head;
            byte[] bArr = segment.data;
            int i3 = segment.pos;
            int i4 = segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        z = true;
                        if (i2 != 0) {
                            break;
                        }
                        char[] cArr = okio.internal.ByteString.HEX_DIGIT_CHARS;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]})));
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    Buffer buffer = new Buffer();
                    buffer.m24writeHexadecimalUnsignedLong(j);
                    buffer.m23writeByte((int) b);
                    throw new NumberFormatException("Number too large: ".concat(buffer.readUtf8()));
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            if (z) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i2;
        return j;
    }

    @Override // okio.BufferedSource
    public final int readInt() throws EOFException {
        long j = this.size;
        if (j < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.size = j - 4;
        if (i5 != i2) {
            segment.pos = i5;
            return i6;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return i6;
    }

    @Override // okio.BufferedSource
    public final long readLong() throws EOFException {
        long j = this.size;
        if (j < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i3 = i + 7;
        long j2 = ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j3 = j2 | (((long) bArr[i3]) & 255);
        this.size = j - 8;
        if (i4 != i2) {
            segment.pos = i4;
            return j3;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return j3;
    }

    @Override // okio.BufferedSource
    public final short readShort() throws EOFException {
        long j = this.size;
        if (j < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.size = j - 2;
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    public final String readString(long j, Charset charset) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{0, 28, 65, 86, 117, 91, 67, 11, 22, 95, 21}, "be53646e", 0) + j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment.data, i, i2, charset);
        int i3 = segment.pos + i2;
        segment.pos = i3;
        this.size -= j;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public final String readString(Charset charset) {
        return readString(this.size, charset);
    }

    public final String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{14, 88, 92, 12, 23, 66, 89, 16, 85, 13, 25}, "b11ecbe0e79f") + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(jIndexOf, this);
        }
        if (j2 < this.size && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return okio.internal.Buffer.readUtf8Line(j2, this);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, this.size));
        throw new EOFException(C0000.decode(new byte[]{63, 90, 17, 87, 10, 21, 67, 82, 94, 76, 11, 5, 89, 20, 93, 80, 8, 8, 23, 9}, "c419ea", false) + Math.min(this.size, j) + C0000.decode(new byte[]{69, 5, 14, 11, 68, 6, 10, 65, 14}, "efae0cd53630", true) + buffer.readByteString(buffer.size).hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public final void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final int select(Options options) throws EOFException {
        int iSelectPrefix = okio.internal.Buffer.selectPrefix(this, options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        skip(options.byteStrings[iSelectPrefix].getSize$okio());
        return iSelectPrefix;
    }

    @Override // okio.BufferedSource
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Options.Companion.checkOffsetAndCount(this.size, 0L, i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 == i6) {
                throw new AssertionError(C0000.decode(new byte[]{69, 75, 95, 94, 85, 91, 68, 66, 5, 11, 69, 67, 72, 64, 94, 17}, "6e37820b86e0f01b"));
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final String toString() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j).toString();
        }
        throw new IllegalStateException((C0000.decode(new byte[]{23, 94, 74, 81, 18, 8, 16, 123, 15, 16, 29, 46, 37, 111, 111, 98, 115, 122, 101, 119, 91, 68}, "d7042602ad3c", 4) + this.size).toString());
    }

    public final Segment writableSegment$okio(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{16, 15, 1, 64, 66, 83, 91, 70, 0, 5, 68, 91, 83, 70, 89, 81, 12, 21, 29}, "ead82682", 0.0f));
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        Segment segment2 = segment.prev;
        if (segment2.limit + i <= 8192 && segment2.owner) {
            return segment2;
        }
        Segment segmentTake2 = SegmentPool.take();
        segment2.push(segmentTake2);
        return segmentTake2;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink write(ByteString byteString) {
        m22write(byteString);
        return this;
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) {
        Segment segmentTake;
        if (buffer == this) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{71, 91, 65, 17, 2, 81, 69, 13, 11, 67, 21, 93, 95, 69}, "444ca4e06ca5667e"));
        }
        Options.Companion.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            Segment segment = buffer.head;
            int i = segment.limit - segment.pos;
            if (j < i) {
                Segment segment2 = this.head;
                Segment segment3 = segment2 != null ? segment2.prev : null;
                if (segment3 != null && segment3.owner) {
                    if ((((long) segment3.limit) + j) - ((long) (segment3.shared ? 0 : segment3.pos)) <= 8192) {
                        segment.writeTo(segment3, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                int i2 = (int) j;
                if (i2 <= 0 || i2 > i) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{6, 76, 18, 4, 118, 86, 68, 10, 69, 24, 9, 23, 16, 21, 9, 7, 21, 75, 80, 10, 86, 93}, "d5fa591d18fb"));
                }
                if (i2 >= 1024) {
                    segmentTake = segment.sharedCopy();
                } else {
                    segmentTake = SegmentPool.take();
                    byte[] bArr = segment.data;
                    byte[] bArr2 = segmentTake.data;
                    int i3 = segment.pos;
                    System.arraycopy(bArr, i3, bArr2, 0, (i3 + i2) - i3);
                }
                segmentTake.limit = segmentTake.pos + i2;
                segment.pos += i2;
                segment.prev.push(segmentTake);
                buffer.head = segmentTake;
            }
            Segment segment4 = buffer.head;
            long j2 = segment4.limit - segment4.pos;
            buffer.head = segment4.pop();
            Segment segment5 = this.head;
            if (segment5 == null) {
                this.head = segment4;
                segment4.prev = segment4;
                segment4.next = segment4;
            } else {
                segment5.prev.push(segment4);
                Segment segment6 = segment4.prev;
                if (segment6 == segment4) {
                    throw new IllegalStateException(C0000.decode(new byte[]{85, 87, 90, 13, 93, 67, 22, 85, 91, 14, 66, 86, 85, 66}, "664c27"));
                }
                if (segment6.owner) {
                    int i4 = segment4.limit - segment4.pos;
                    if (i4 <= (8192 - segment6.limit) + (segment6.shared ? 0 : segment6.pos)) {
                        segment4.writeTo(segment6, i4);
                        segment4.pop();
                        SegmentPool.recycle(segment4);
                    }
                }
            }
            buffer.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    public final void writeAll(Source source) {
        while (source.read(8192L, this) != -1) {
        }
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        m23writeByte(i);
        return this;
    }

    /* JADX INFO: renamed from: writeByte, reason: collision with other method in class */
    public final void m23writeByte(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long j) {
        m24writeHexadecimalUnsignedLong(j);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        m25writeInt(i);
        return this;
    }

    /* JADX INFO: renamed from: writeInt, reason: collision with other method in class */
    public final void m25writeInt(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i2 + 2;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i2 + 3;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        int i6 = i2 + 4;
        bArr[i5] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i6;
        this.size += 4;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        m26writeShort(i);
        return this;
    }

    /* JADX INFO: renamed from: writeShort, reason: collision with other method in class */
    public final void m26writeShort(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        int i4 = i2 + 2;
        bArr[i3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i4;
        this.size += 2;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String str) {
        writeUtf8(str, 0, str.length());
        return this;
    }

    public final void writeUtf8(String str, int i, int i2) {
        char cCharAt;
        if (i < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{4, 83, 5, 81, 89, 122, 8, 82, 7, 64, 23, 15, 70, 6, 88, 24}, "f6b873"), i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(i2, i, C0000.decode(new byte[]{0, 88, 7, 42, 15, 83, 86, 26, 23, 90, 23, 0, 82, 86, 11, 8, 44, 88, 7, 6, 25, 13, 19}, "e6cca73b7f7b71bf", 0.0f), C0000.decode(new byte[]{19, 8, 69}, "34e528", 0.0f)).toString());
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{87, 12, 82, 120, 11, 2, 87, 26, 22, 15, 69, 21, 70, 16, 95, 95, 2, 72, 94, 7, 88, 86, 17, 14, 8, 66}, "2b61ef", 7) + i2 + C0000.decode(new byte[]{69, 93, 22}, "ec6d226d26", false) + str.length()).toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                Segment segmentWritableSegment$okio = writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i3 = segmentWritableSegment$okio.limit - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = segmentWritableSegment$okio.limit;
                int i6 = (i3 + i) - i5;
                segmentWritableSegment$okio.limit = i5 + i6;
                this.size += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i7 = segmentWritableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment$okio2.limit = i7 + 2;
                    this.size += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment segmentWritableSegment$okio3 = writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i8 = segmentWritableSegment$okio3.limit;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment$okio3.limit = i8 + 3;
                    this.size += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        m23writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i11 = segmentWritableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i11 + 4;
                        this.size += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void writeUtf8CodePoint(int i) {
        String strDecode;
        if (i < 128) {
            m23writeByte(i);
            return;
        }
        if (i < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            this.size += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            m23writeByte(63);
            return;
        }
        if (i < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            this.size += 3;
            return;
        }
        if (i <= 1114111) {
            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i4 = segmentWritableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio3.limit = i4 + 4;
            this.size += 4;
            return;
        }
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{103, 87, 3, 76, 17, 86, 80, 76, 87, 93, 70, 87, 14, 87, 86, 24, 66, 86, 15, 90, 21, 9, 19, 8, 74}, "29f4a338", 0.0f));
        if (i != 0) {
            char[] cArr = okio.internal.ByteString.HEX_DIGIT_CHARS;
            char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
            int i5 = 0;
            while (i5 < 8 && cArr2[i5] == '0') {
                i5++;
            }
            String strDecode2 = C0000.decode(new byte[]{69, 69, 89, 75, 22, 120, 88, 85, 1, 78, 8, 18}, "6189b161d622", 1);
            if (i5 < 0) {
                throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, C0000.decode(new byte[]{78, 69, 0, 88, 87, 43, 13, 80, 7, 29, 95, 22, 11, 78, 67, 71, 11, 31, 0, 12, 19, 90}, "bee63bc4", 7), i5));
            }
            if (i5 > 8) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, C0000.decode(new byte[]{19, 7, 66, 6, 93, 87, 125, 12, 2, 85, 74, 88, 19, 1}, "39bc334bf02b"), i5));
            }
            strDecode = new String(cArr2, i5, 8 - i5);
        } else {
            strDecode = C0000.decode(new byte[]{82}, "b63c74", false);
        }
        sb.append(strDecode);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: writeHexadecimalUnsignedLong, reason: collision with other method in class */
    public final void m24writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            m23writeByte(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = okio.internal.Buffer.HEX_DIGIT_BYTES[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        this.size += (long) i;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i = segment.pos + iMin;
        segment.pos = i;
        this.size -= (long) iMin;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public final void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        Options.Companion.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        System.arraycopy(bArr2, i3, bArr, i, (i3 + iMin) - i3);
        int i4 = segment.pos + iMin;
        segment.pos = i4;
        this.size -= (long) iMin;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    /* JADX INFO: renamed from: write, reason: collision with other method in class */
    public final void m22write(ByteString byteString) {
        byteString.write$okio(this, byteString.getSize$okio());
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i, 8192 - segmentWritableSegment$okio.limit);
            byteBuffer.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] bArr) {
        write(bArr.length, bArr);
        return this;
    }

    public final void write(int i, byte[] bArr) {
        int i2 = 0;
        long j = i;
        Options.Companion.checkOffsetAndCount(bArr.length, 0, j);
        while (i2 < i) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i - i2, 8192 - segmentWritableSegment$okio.limit);
            int i3 = i2 + iMin;
            System.arraycopy(bArr, i2, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i3 - i2);
            segmentWritableSegment$okio.limit += iMin;
            i2 = i3;
        }
        this.size += j;
    }
}
