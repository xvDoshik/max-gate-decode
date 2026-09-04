package okhttp3.internal.http2;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Writer implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public boolean closed;
    public final Buffer hpackBuffer;
    public final Hpack.Writer hpackWriter;
    public int maxFrameSize;
    public final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink) {
        this.sink = bufferedSink;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(buffer);
    }

    public final synchronized void applyAndAckSettings(Settings settings) {
        try {
            if (this.closed) {
                throw new IOException(C0000.decode(new byte[]{1, 88, 95, 65, 93, 2}, "b4028f", false));
            }
            int i = this.maxFrameSize;
            int i2 = settings.set;
            if ((i2 & 32) != 0) {
                i = settings.values[5];
            }
            this.maxFrameSize = i;
            if (((i2 & 2) != 0 ? settings.values[1] : -1) != -1) {
                Hpack.Writer writer = this.hpackWriter;
                int iMin = Math.min((i2 & 2) != 0 ? settings.values[1] : -1, 16384);
                int i3 = writer.maxDynamicTableByteCount;
                if (i3 != iMin) {
                    if (iMin < i3) {
                        writer.smallestHeaderTableSizeSetting = Math.min(writer.smallestHeaderTableSizeSetting, iMin);
                    }
                    writer.emitDynamicTableSizeUpdate = true;
                    writer.maxDynamicTableByteCount = iMin;
                    int i4 = writer.dynamicTableByteCount;
                    if (iMin < i4) {
                        if (iMin == 0) {
                            Header[] headerArr = writer.dynamicTable;
                            Arrays.fill(headerArr, 0, headerArr.length, (Object) null);
                            writer.nextHeaderIndex = writer.dynamicTable.length - 1;
                            writer.headerCount = 0;
                            writer.dynamicTableByteCount = 0;
                        } else {
                            writer.evictToRecoverBytes(i4 - iMin);
                        }
                    }
                }
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void data(boolean z, int i, Buffer buffer, int i2) {
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{1, 15, 92, 23, 82, 2}, "bc3d7f98fbf3", true));
        }
        frameHeader(i, i2, 0, z ? 1 : 0);
        if (i2 > 0) {
            this.sink.write(i2, buffer);
        }
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{5, 94, 10, 70, 84, 6}, "f2e51b47dc", false));
        }
        this.sink.flush();
    }

    public final void frameHeader(int i, int i2, int i3, int i4) {
        Level level = Level.FINE;
        Logger logger2 = logger;
        if (logger2.isLoggable(level)) {
            logger2.fine(Http2.frameLog(false, i, i2, i3, i4));
        }
        if (i2 > this.maxFrameSize) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{32, 107, 35, 121, 119, 105, 53, 112, 56, 113, 109, 115, 52, 107, 45, 102, 18, 90, 3, 87, 5, 64, 90, 22, 88, 25}, "f9b426", 7) + this.maxFrameSize + C0000.decode(new byte[]{94, 24}, "d8f568c83d30", 5) + i2).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{65, 4, 67, 81, 20, 71, 4, 83, 66, 6, 11, 69, 19, 74, 86, 21, 10, 20}, "3a04f1a7bdb139"), i).toString());
        }
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        BufferedSink bufferedSink = this.sink;
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
        bufferedSink.writeByte(i3 & 255);
        bufferedSink.writeByte(i4 & 255);
        bufferedSink.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void goAway(byte[] bArr, int i, int i2) {
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{82, 9, 11, 23, 6, 93}, "1eddc9500b9b8474"));
        }
        if (FileSectionType$EnumUnboxingLocalUtility.ordinal(i2) == -1) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{0, 71, 66, 93, 17, 119, 94, 6, 4, 27, 88, 71, 64, 19, 38, 90, 84, 87, 67, 9, 12, 66, 76, 4}, "e502c41ba5034c", 0.0f));
        }
        frameHeader(0, bArr.length + 8, 7, 0);
        this.sink.writeInt(i);
        this.sink.writeInt(FileSectionType$EnumUnboxingLocalUtility.ordinal(i2));
        if (bArr.length != 0) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z, int i, ArrayList arrayList) {
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{80, 9, 90, 17, 92, 82}, "3e5b96ee", 0.0f));
        }
        this.hpackWriter.writeHeaders(arrayList);
        long j = this.hpackBuffer.size;
        long jMin = Math.min(this.maxFrameSize, j);
        int i2 = j == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        frameHeader(i, (int) jMin, 1, i2);
        this.sink.write(jMin, this.hpackBuffer);
        if (j > jMin) {
            long j2 = j - jMin;
            while (j2 > 0) {
                long jMin2 = Math.min(this.maxFrameSize, j2);
                j2 -= jMin2;
                frameHeader(i, (int) jMin2, 9, j2 == 0 ? 4 : 0);
                this.sink.write(jMin2, this.hpackBuffer);
            }
        }
    }

    public final synchronized void ping(boolean z, int i, int i2) {
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{91, 10, 88, 18, 81, 87}, "8f7a4391f7", true));
        }
        frameHeader(0, 8, 6, z ? 1 : 0);
        this.sink.writeInt(i);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public final synchronized void rstStream(int i, int i2) {
        if (this.closed) {
            throw new IOException(C0000.decode(new byte[]{87, 8, 95, 16, 1, 87}, "4d0cd3c4", 0.0f));
        }
        if (FileSectionType$EnumUnboxingLocalUtility.ordinal(i2) == -1) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{37, 88, 11, 10, 80, 80, 67, 71, 6, 72, 23, 15, 71, 81, 14, 80, 13, 77, 76}, "c9bf54c5", false));
        }
        frameHeader(i, 4, 3, 0);
        this.sink.writeInt(FileSectionType$EnumUnboxingLocalUtility.ordinal(i2));
        this.sink.flush();
    }

    public final synchronized void windowUpdate(int i, long j) {
        String strDecode = C0000.decode(new byte[]{79, 95, 92, 80, 87, 67, 55, 94, 72, 6, 127, 93, 86, 68, 6, 15, 93, 88, 70, 20, 5, 9, 68, 7, 18, 31, 74, 19, 66, 95, 13, 6, 87, 65, 97, 93, 66, 81, 45, 89, 81, 17, 83, 94, 80, 88, 23, 66, 6, 22, 2, 76, 15, 82, 2, 81, 84, 5, 80, 85, 121, 12, 67}, "862484d72c6356cb", false);
        synchronized (this) {
            if (this.closed) {
                throw new IOException(C0000.decode(new byte[]{6, 91, 95, 71, 6, 84}, "e704c0d8a9f80d", false));
            }
            if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException((strDecode + j).toString());
            }
            frameHeader(i, 4, 8, 0);
            this.sink.writeInt((int) j);
            this.sink.flush();
        }
    }
}
