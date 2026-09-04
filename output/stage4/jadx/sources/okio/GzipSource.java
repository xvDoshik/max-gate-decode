package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GzipSource implements Source {
    public final CRC32 crc;
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public byte section;
    public final RealBufferedSource source;

    public GzipSource(Source source) {
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource(realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    public static void checkEqual(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        throw new IOException(String.format(C0000.decode(new byte[]{65, 66, 91, 17, 89, 82, 65, 22, 5, 93, 65, 1, 64, 20, 5, 91, 28, 17, 64, 12, 24, 84, 77, 19, 1, 82, 21, 84, 92, 17, 5, 27, 65, 1, 89, 73}, "d1a1815c", 0.0f), Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        long j2;
        GzipSource gzipSource = this;
        byte b = gzipSource.section;
        CRC32 crc32 = gzipSource.crc;
        RealBufferedSource realBufferedSource = gzipSource.source;
        if (b == 0) {
            realBufferedSource.require(10L);
            Buffer buffer2 = realBufferedSource.bufferField;
            byte b2 = buffer2.getByte(3L);
            boolean z = ((b2 >> 1) & 1) == 1;
            if (z) {
                gzipSource.updateCrc(buffer2, 0L, 10L);
            }
            checkEqual(C0000.decode(new byte[]{120, 118, 3, 120, 115, 81}, "12217c4b43", true), 8075, realBufferedSource.readShort());
            realBufferedSource.skip(8L);
            if (((b2 >> 2) & 1) == 1) {
                realBufferedSource.require(2L);
                if (z) {
                    updateCrc(buffer2, 0L, 2L);
                }
                short s = buffer2.readShort();
                long j3 = ((short) (((s & 255) << 8) | ((s & 65280) >>> 8))) & 65535;
                realBufferedSource.require(j3);
                if (z) {
                    updateCrc(buffer2, 0L, j3);
                }
                realBufferedSource.skip(j3);
            }
            if (((b2 >> 3) & 1) == 1) {
                long jIndexOf = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j2 = 2;
                    updateCrc(buffer2, 0L, jIndexOf + 1);
                } else {
                    j2 = 2;
                }
                realBufferedSource.skip(jIndexOf + 1);
            } else {
                j2 = 2;
            }
            if (((b2 >> 4) & 1) == 1) {
                j2 = j2;
                long jIndexOf2 = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    gzipSource = this;
                    gzipSource.updateCrc(buffer2, 0L, jIndexOf2 + 1);
                } else {
                    gzipSource = this;
                }
                realBufferedSource.skip(jIndexOf2 + 1);
            } else {
                gzipSource = this;
            }
            if (z) {
                realBufferedSource.require(j2);
                short s2 = buffer2.readShort();
                checkEqual(C0000.decode(new byte[]{113, 125, 32, 100, 33}, "75c6befbcc3bcd92"), (short) (((s2 & 255) << 8) | ((s2 & 65280) >>> 8)), (short) crc32.getValue());
                crc32.reset();
            }
            gzipSource.section = (byte) 1;
        }
        if (gzipSource.section == 1) {
            long j4 = buffer.size;
            long j5 = gzipSource.inflaterSource.read(8192L, buffer);
            if (j5 != -1) {
                gzipSource.updateCrc(buffer, j4, j5);
                return j5;
            }
            gzipSource.section = (byte) 2;
        }
        if (gzipSource.section == 2) {
            checkEqual(C0000.decode(new byte[]{114, 55, 33}, "1ebbf6923eb88b", 5), realBufferedSource.readIntLe(), (int) crc32.getValue());
            checkEqual(C0000.decode(new byte[]{47, 102, 42, 104, 113}, "f5c24cde"), realBufferedSource.readIntLe(), (int) gzipSource.inflater.getBytesWritten());
            gzipSource.section = (byte) 3;
            if (!realBufferedSource.exhausted()) {
                throw new IOException(C0000.decode(new byte[]{84, 79, 94, 72, 22, 94, 92, 94, 90, 16, 11, 80, 87, 21, 64, 81, 66, 80, 90, 69, 71, 67, 6, 77, 91, 84, 66, 75, 66, 81, 91, 87, 19, 16, 12, 64, 65, 86, 82}, "357868503cc5"));
            }
        }
        return -1L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }

    public final void updateCrc(Buffer buffer, long j, long j2) {
        Segment segment = buffer.head;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) segment.pos) + j);
            int iMin = (int) Math.min(segment.limit - i3, j2);
            this.crc.update(segment.data, i3, iMin);
            j2 -= (long) iMin;
            segment = segment.next;
            j = 0;
        }
    }
}
