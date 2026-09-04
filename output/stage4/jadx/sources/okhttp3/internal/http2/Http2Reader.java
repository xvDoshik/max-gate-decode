package okhttp3.internal.http2;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final BufferedSource source;

    public abstract class Companion {
        public static int lengthWithoutPadding(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(i3, i, C0000.decode(new byte[]{98, 106, 127, 49, 45, 33, 44, 42, 111, 118, 96, 106, 127, 55, 66, 18, 2, 2, 84, 90, 92, 95, 16}, "280ebbcf03", 0.0f), C0000.decode(new byte[]{65, 7, 66, 71, 80, 89, 2, 15, 15, 81, 89, 1, 25, 8, 7, 15, 6, 77, 10, 21}, "a9b554cfa87f9dba", 1)));
        }
    }

    public final class ContinuationSource implements Source {
        public int flags;
        public int left;
        public int length;
        public int padding;
        public final BufferedSource source;
        public int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws IOException {
            int i;
            int i2;
            do {
                int i3 = this.left;
                BufferedSource bufferedSource = this.source;
                if (i3 == 0) {
                    bufferedSource.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) == 0) {
                        i = this.streamId;
                        int medium = Util.readMedium(bufferedSource);
                        this.left = medium;
                        this.length = medium;
                        int i4 = bufferedSource.readByte() & 255;
                        this.flags = bufferedSource.readByte() & 255;
                        Logger logger = Http2Reader.logger;
                        if (logger.isLoggable(Level.FINE)) {
                            ByteString byteString = Http2.CONNECTION_PREFACE;
                            logger.fine(Http2.frameLog(true, this.streamId, this.length, i4, this.flags));
                        }
                        i2 = bufferedSource.readInt() & Integer.MAX_VALUE;
                        this.streamId = i2;
                        if (i4 != 9) {
                            throw new IOException(i4 + C0000.decode(new byte[]{66, 16, 14, 68, 108, 107, 102, 33, 61, 114, 124, 42, 108, 123, 120, 49, 35, 101, 122, 43, 118}, "b13d826d", 0.0f));
                        }
                    }
                } else {
                    long j2 = bufferedSource.read(Math.min(8192L, i3), buffer);
                    if (j2 != -1) {
                        this.left -= (int) j2;
                        return j2;
                    }
                }
                return -1L;
            } while (i2 == i);
            throw new IOException(C0000.decode(new byte[]{48, 97, 105, 112, 111, 39, 43, 118, 109, 124, 126, 49, 37, 108, 112, 122, 126, 68, 23, 76, 75, 80, 81, 9, 45, 92, 25, 86, 88, 5, 10, 95, 92, 81}, "d8950d", false));
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.timeout();
        }
    }

    public Http2Reader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z, Http2Connection.ReaderRunnable readerRunnable) throws IOException {
        int i;
        int i2;
        Object[] array;
        int i3 = 0;
        try {
            this.source.require(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{115, 99, 119, 121, 39, 107, 96, 47, 57, 124, 106, 116, 100, 102, 45, 102, 9, 70}, "5164b43fc9", 0.0f), medium));
            }
            int i4 = this.source.readByte() & 255;
            byte b = this.source.readByte();
            int i5 = b & 255;
            int i6 = this.source.readInt();
            int i7 = Integer.MAX_VALUE & i6;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, i7, medium, i4, i5));
            }
            if (z && i4 != 4) {
                StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{36, 78, 66, 81, 81, 69, 7, 85, 66, 81, 70, 101, 36, 98, 102, 125, 124, 118, 49, 17, 4, 66, 7, 91, 4, 22, 80, 65, 70, 17, 21, 80, 17, 16}, "a62421b1b0f6", false));
                String[] strArr = Http2.FRAME_NAMES;
                sb.append(i4 < strArr.length ? strArr[i4] : Util.format(C0000.decode(new byte[]{3, 76, 23, 85, 84, 64}, "342ef877854cde"), Integer.valueOf(i4)));
                throw new IOException(sb.toString());
            }
            switch (i4) {
                case 0:
                    readData(readerRunnable, medium, i5, i7);
                    return true;
                case 1:
                    readHeaders(readerRunnable, medium, i5, i7);
                    return true;
                case 2:
                    if (medium != 5) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{98, 109, 103, 115, 106, 54, 100, 125, 120, 100, 124, 50, 111, 20, 91, 83, 91, 1, 66, 92, 13, 22}, "64765f"), C0000.decode(new byte[]{16, 66, 12, 16, 83}, "0c10ff", 0.0f), medium));
                    }
                    if (i7 == 0) {
                        throw new IOException(C0000.decode(new byte[]{99, 108, 100, 116, 62, 53, 48, 121, 123, 49, 127, 50, 97, 23, 22, 22, 69, 80, 85, 92, 40, 1, 66, 13, 9, 67, 6}, "7541aeb04c6f87eb", 5));
                    }
                    BufferedSource bufferedSource = this.source;
                    bufferedSource.readInt();
                    bufferedSource.readByte();
                    return true;
                case 3:
                    if (medium != 4) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{98, 61, 53, 38, 103, 54, 55, 108, 107, 101, 98, 54, 32, 34, 117, 68, 8, 93, 90, 81, 66, 12, 95, 67}, "6dec8dd846"), C0000.decode(new byte[]{20, 22, 88, 70, 4}, "47ef0812025f88c7", false), medium));
                    }
                    if (i7 == 0) {
                        throw new IOException(C0000.decode(new byte[]{100, 63, 51, 124, 60, 107, 97, 55, 57, 54, 100, 52, 38, 120, 46, 25, 65, 23, 20, 0, 81, 11, 42, 93, 67, 4, 15, 67, 86}, "0fc9c92cfe", false));
                    }
                    int i8 = this.source.readInt();
                    int[] iArrValues = FileSectionType$EnumUnboxingLocalUtility.values(14);
                    int length = iArrValues.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 < length) {
                            i = iArrValues[i9];
                            if (FileSectionType$EnumUnboxingLocalUtility.ordinal(i) != i8) {
                                i9++;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{102, 106, 96, 113, 57, 100, 48, 48, 107, 50, 50, 100, 124, 118, 127, 19, 69, 90, 3, 78, 19, 1, 87, 21, 3, 82, 25, 82, 64, 65, 95, 70, 70, 85, 12, 0, 81, 91, 70}, "2304f6cd4af697", false), i8));
                    }
                    Http2Connection http2Connection = Http2Connection.this;
                    if (i7 != 0 && (i6 & 1) == 0) {
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(http2Connection.connectionName + '[' + i7 + C0000.decode(new byte[]{101, 17, 92, 13, 107, 83, 64, 4, 76}, "813c963a", true), http2Connection, i7, i), 0L);
                        return true;
                    }
                    Http2Stream http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i7);
                    if (http2StreamRemoveStream$okhttp != null) {
                        synchronized (http2StreamRemoveStream$okhttp) {
                            if (http2StreamRemoveStream$okhttp.errorCode == 0) {
                                http2StreamRemoveStream$okhttp.errorCode = i;
                                http2StreamRemoveStream$okhttp.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    return true;
                case 4:
                    BufferedSource bufferedSource2 = this.source;
                    if (i7 != 0) {
                        throw new IOException(C0000.decode(new byte[]{98, 60, 98, 118, 110, 107, 115, 49, 102, 122, 127, 127, 101, 69, 65, 71, 67, 93, 87, 8, 123, 87, 17, 25, 11, 69, 2}, "6e2318", 0.0f));
                    }
                    if ((b & 1) != 0) {
                        if (medium != 0) {
                            throw new IOException(C0000.decode(new byte[]{119, 51, 116, 124, 116, 108, 98, 40, 111, 116, 110, 118, 99, 51, 122, 99, 17, 82, 82, 10, 21, 87, 67, 82, 92, 4, 21, 66, 89, 92, 68, 13, 81, 17, 83, 86, 17, 4, 88, 65, 69, 74, 16}, "1a5113", 1));
                        }
                        return true;
                    }
                    if (medium % 6 != 0) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{55, 110, 104, 36, 62, 100, 33, 53, 103, 45, 45, 112, 107, 65, 13, 82, 10, 6, 71, 12, 67, 18, 24, 87, 65, 22, 89, 65, 3, 94, 67}, "c78aa7da3d", true), medium));
                    }
                    Settings settings = new Settings();
                    IntProgression intProgressionStep = Trace.step(Trace.until(0, medium), 6);
                    int i10 = intProgressionStep.first;
                    int i11 = intProgressionStep.last;
                    int i12 = intProgressionStep.step;
                    if ((i12 > 0 && i10 <= i11) || (i12 < 0 && i11 <= i10)) {
                        while (true) {
                            short s = bufferedSource2.readShort();
                            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                            int i13 = s & 65535;
                            int i14 = bufferedSource2.readInt();
                            if (i13 != 2) {
                                if (i13 == 3) {
                                    i13 = 4;
                                } else if (i13 == 4) {
                                    if (i14 < 0) {
                                        throw new IOException(C0000.decode(new byte[]{52, 100, 42, 96, 118, 32, 125, 125, 59, 115, 55, 102, 118, 49, 18, 98, 33, 98, 49, 125, 119, 36, 97, 110, 45, 120, 44, 96, 112, 34, 126, 110, 51, 127, 43, 112, 118, 52, 109, 98, 45, 108, 32, 20, 7, 67, 0, 111, 87, 7, 69, 25, 25, 82}, "d6e49c21"));
                                    }
                                    i13 = 7;
                                } else if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                                    throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{101, 54, 119, 108, 123, 114, 122, 40, 105, 118, 106, 48, 121, 49, 66, 106, 112, 48, 108, 113, 122, 118, 102, 59, 123, 114, 96, 61, 112, 49, 35, 116, 112, 59, 107, 113, 110, 116, 15, 68}, "5d88415d638b6cb9", 0.0f), i14));
                                }
                            } else if (i14 != 0 && i14 != 1) {
                                throw new IOException(C0000.decode(new byte[]{50, 97, 126, 53, 125, 113, 43, 121, 61, 118, 99, 51, 125, 96, 68, 102, 39, 103, 101, 40, 124, 117, 55, 106, 39, 125, 112, 35, 126, 119, 59, 101, 55, 96, 121, 65, 19, 15, 68, 5, 66, 92, 67, 65, 3}, "b31a22d5", 0.0f));
                            }
                            settings.set(i13, i14);
                            if (i10 != i11) {
                                i10 += i12;
                            }
                        }
                    }
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.writerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), http2Connection2.connectionName, C0000.decode(new byte[]{17, 7, 21, 18, 95, 73, 39, 11, 80, 37, 87, 8, 102, 80, 68, 23, 88, 8, 2, 17}, "1feb30fe4d4c550c", 0.0f)), readerRunnable, settings, i3), 0L);
                    return true;
                case 5:
                    readPushPromise(readerRunnable, medium, i5, i7);
                    return true;
                case 6:
                    if (medium != 8) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{108, 63, 97, 35, 58, 49, 42, 118, 118, 66, 95, 80, 11, 2, 76, 14, 17, 71, 88, 65, 91, 2, 17}, "8f1feac81b35ee", 0.0f), medium));
                    }
                    if (i7 != 0) {
                        throw new IOException(C0000.decode(new byte[]{50, 58, 96, 119, 105, 51, 112, 118, 33, 16, 21, 23, 66, 87, 87, 14, 112, 92, 70, 17, 91, 67, 0}, "fc026c98f0", 0.0f));
                    }
                    int i15 = this.source.readInt();
                    int i16 = this.source.readInt();
                    if (((b & 1) != 0 ? 1 : 0) == 0) {
                        Http2Connection.this.writerQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), Http2Connection.this.connectionName, C0000.decode(new byte[]{18, 65, 90, 12, 83}, "213b447f3f741df4", 0.0f)), Http2Connection.this, i15, i16, 1), 0L);
                        return true;
                    }
                    Http2Connection http2Connection3 = Http2Connection.this;
                    synchronized (http2Connection3) {
                        try {
                            if (i15 == 1) {
                                http2Connection3.intervalPongsReceived++;
                            } else if (i15 == 2) {
                                http2Connection3.degradedPongsReceived++;
                            } else if (i15 == 3) {
                                http2Connection3.notifyAll();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return true;
                case 7:
                    if (medium < 8) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{101, 58, 101, 125, 106, 116, 126, 34, 98, 121, 108, 19, 93, 6, 91, 95, 65, 91, 17, 95, 21, 0, 15, 19}, "1c5853", 5), medium));
                    }
                    if (i7 != 0) {
                        throw new IOException(C0000.decode(new byte[]{49, 108, 103, 36, 108, 116, 125, 114, 100, 39, 56, 19, 21, 18, 17, 81, 4, 88, 126, 5, 19, 18, 15, 19, 3}, "e57a33233fa3ffc4", false));
                    }
                    int i17 = this.source.readInt();
                    int i18 = this.source.readInt();
                    int i19 = medium - 8;
                    int[] iArrValues2 = FileSectionType$EnumUnboxingLocalUtility.values(14);
                    int length2 = iArrValues2.length;
                    int i20 = 0;
                    while (true) {
                        if (i20 < length2) {
                            i2 = iArrValues2[i20];
                            if (FileSectionType$EnumUnboxingLocalUtility.ordinal(i2) != i18) {
                                i20++;
                            }
                        } else {
                            i2 = 0;
                        }
                    }
                    if (i2 == 0) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{100, 56, 101, 114, 104, 127, 124, 39, 97, 120, 110, 17, 70, 12, 81, 25, 64, 4, 86, 67, 82, 92, 19, 3, 68, 75, 88, 67, 19, 1, 91, 5, 85, 91, 21}, "0a57783f69713b4a", true), i18));
                    }
                    ByteString byteString = ByteString.EMPTY;
                    if (i19 > 0) {
                        byteString = this.source.readByteString(i19);
                    }
                    byteString.getSize$okio();
                    Http2Connection http2Connection4 = Http2Connection.this;
                    synchronized (http2Connection4) {
                        array = http2Connection4.streams.values().toArray(new Http2Stream[0]);
                        http2Connection4.isShutdown = true;
                    }
                    Http2Stream[] http2StreamArr = (Http2Stream[]) array;
                    int length3 = http2StreamArr.length;
                    while (i3 < length3) {
                        Http2Stream http2Stream = http2StreamArr[i3];
                        if (http2Stream.id > i17 && http2Stream.isLocallyInitiated()) {
                            synchronized (http2Stream) {
                                if (http2Stream.errorCode == 0) {
                                    http2Stream.errorCode = 8;
                                    http2Stream.notifyAll();
                                }
                                break;
                            }
                            Http2Connection.this.removeStream$okhttp(http2Stream.id);
                        }
                        i3++;
                    }
                    return true;
                case 8:
                    if (medium != 4) {
                        throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{48, 105, 53, 32, 107, 97, 124, 127, 33, 123, 51, 111, 48, 53, 112, 119, 97, 116, 69, 88, 1, 94, 2, 17, 92, 22, 20, 12, 81, 14, 68}, "d0ee4651e4", 5), medium));
                    }
                    long j = ((long) this.source.readInt()) & 2147483647L;
                    if (j == 0) {
                        throw new IOException(C0000.decode(new byte[]{68, 10, 13, 83, 91, 71, 49, 10, 77, 86, 122, 12, 80, 17, 6, 90, 81, 94, 22, 67, 64, 82, 64, 66, 3}, "3cc740bc733b"));
                    }
                    if (i7 == 0) {
                        Http2Connection http2Connection5 = Http2Connection.this;
                        synchronized (http2Connection5) {
                            http2Connection5.writeBytesMaximum += j;
                            http2Connection5.notifyAll();
                        }
                        return true;
                    }
                    Http2Stream stream = Http2Connection.this.getStream(i7);
                    if (stream != null) {
                        synchronized (stream) {
                            stream.writeBytesMaximum += j;
                            if (j > 0) {
                                stream.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readData(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, final int i3) throws IOException {
        int i4;
        boolean z;
        long j;
        boolean z2;
        if (i3 == 0) {
            throw new IOException(C0000.decode(new byte[]{104, 48, 43, 96, 45, 112, 127, 123, 102, 112, 54, 55, 122, 96, 2, 66, 48, 109, 50, 118, 111, 115, 120, 97, 37, 69, 70, 70, 74, 7, 5, 89, 43, 87, 16, 10, 4, 21, 84}, "8bd4b30795de52", 3));
        }
        final boolean z3 = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException(C0000.decode(new byte[]{97, 99, 43, 49, 44, 117, 123, 122, 102, 39, 96, 99, 41, 51, 15, 68, 119, 125, 37, 34, 60, 117, 123, 123, 105, 48, 119, 98, 53, 36, 113, 68, 70, 88, 16, 13, 12, 67, 64, 22, 106, 39, 102, 101, 47, 47, 114, 55, 110, 114, 43, 40, 51, 100, 113, 101, 106, 61, 118, 112, 50, 32}, "11dec6469b21fa5d"));
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        final int iLengthWithoutPadding = Companion.lengthWithoutPadding(i, i2, i4);
        BufferedSource bufferedSource = this.source;
        final Http2Connection http2Connection = Http2Connection.this;
        long j2 = 0;
        if (i3 == 0 || (i3 & 1) != 0) {
            Http2Stream stream = http2Connection.getStream(i3);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater$okhttp(i3, 2);
                long j3 = iLengthWithoutPadding;
                Http2Connection.this.updateConnectionFlowControl$okhttp(j3);
                bufferedSource.skip(j3);
            } else {
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                Http2Stream.FramingSource framingSource = stream.source;
                long j4 = iLengthWithoutPadding;
                framingSource.getClass();
                long j5 = j4;
                while (true) {
                    if (j5 <= j2) {
                        Http2Stream http2Stream = Http2Stream.this;
                        byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                        http2Stream.connection.updateConnectionFlowControl$okhttp(j4);
                        break;
                    }
                    synchronized (Http2Stream.this) {
                        z = framingSource.finished;
                        j = j2;
                        z2 = framingSource.readBuffer.size + j5 > framingSource.maxByteCount;
                    }
                    if (z2) {
                        bufferedSource.skip(j5);
                        Http2Stream.this.closeLater(4);
                        break;
                    }
                    if (z) {
                        bufferedSource.skip(j5);
                        break;
                    }
                    long j6 = bufferedSource.read(j5, framingSource.receiveBuffer);
                    if (j6 == -1) {
                        throw new EOFException();
                    }
                    j5 -= j6;
                    Http2Stream http2Stream2 = Http2Stream.this;
                    synchronized (http2Stream2) {
                        try {
                            if (framingSource.closed) {
                                Buffer buffer = framingSource.receiveBuffer;
                                buffer.skip(buffer.size);
                            } else {
                                Buffer buffer2 = framingSource.readBuffer;
                                boolean z4 = buffer2.size == j;
                                buffer2.writeAll(framingSource.receiveBuffer);
                                if (z4) {
                                    http2Stream2.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    j2 = j;
                }
                if (z3) {
                    stream.receiveHeaders(Util.EMPTY_HEADERS, true);
                }
            }
        } else {
            final Buffer buffer3 = new Buffer();
            long j7 = iLengthWithoutPadding;
            bufferedSource.require(j7);
            bufferedSource.read(j7, buffer3);
            TaskQueue taskQueue = http2Connection.pushQueue;
            final String str = http2Connection.connectionName + '[' + i3 + C0000.decode(new byte[]{101, 25, 86, 13, 113, 80, 70, 4}, "899c512eeb832d", true);
            taskQueue.schedule(new Task(str, http2Connection, i3, buffer3, iLengthWithoutPadding, z3) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1
                public final /* synthetic */ Buffer $buffer$inlined;
                public final /* synthetic */ int $byteCount$inlined;
                public final /* synthetic */ int $streamId$inlined;
                public final /* synthetic */ Http2Connection this$0;

                @Override // okhttp3.internal.concurrent.Task
                public final long runOnce() {
                    try {
                        PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = this.this$0.pushObserver;
                        Buffer buffer4 = this.$buffer$inlined;
                        int i5 = this.$byteCount$inlined;
                        pushObserver$Companion$PushObserverCancel.getClass();
                        buffer4.skip(i5);
                        this.this$0.writer.rstStream(this.$streamId$inlined, 9);
                        synchronized (this.this$0) {
                            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                        }
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }, 0L);
        }
        this.source.skip(i4);
    }

    public final List readHeaderBlock(int i, int i2, int i3, int i4) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = i2;
        continuationSource.flags = i3;
        continuationSource.streamId = i4;
        Hpack.Reader reader = this.hpackReader;
        RealBufferedSource realBufferedSource = reader.source;
        ArrayList arrayList = reader.headerList;
        while (!realBufferedSource.exhausted()) {
            byte b = realBufferedSource.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int i5 = b & 255;
            if (i5 == 128) {
                throw new IOException(C0000.decode(new byte[]{90, 13, 5, 80, 73, 23, 95, 4, 25, 83}, "3ca517b99c", false));
            }
            if ((b & 128) == 128) {
                int i6 = reader.readInt(i5, 127);
                int i7 = i6 - 1;
                if (i7 >= 0) {
                    Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                    if (i7 <= headerArr.length - 1) {
                        arrayList.add(headerArr[i7]);
                    }
                }
                int length = reader.nextHeaderIndex + 1 + (i7 - Hpack.STATIC_HEADER_TABLE.length);
                if (length >= 0) {
                    Header[] headerArr2 = reader.dynamicTable;
                    if (length < headerArr2.length) {
                        arrayList.add(headerArr2[length]);
                    }
                }
                throw new IOException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{120, 85, 86, 81, 85, 71, 66, 93, 87, 82, 85, 65, 16, 68, 88, 90, 16, 89, 3, 70, 94, 83, 16}, "007505b49609", 0.0f), i6));
            }
            if (i5 == 64) {
                Header[] headerArr3 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString = reader.readByteString();
                Hpack.checkLowercase(byteString);
                reader.insertIntoDynamicTable(new Header(byteString, reader.readByteString()));
            } else if ((b & 64) == 64) {
                reader.insertIntoDynamicTable(new Header(reader.getName(reader.readInt(i5, 63) - 1), reader.readByteString()));
            } else if ((b & 32) == 32) {
                int i8 = reader.readInt(i5, 31);
                reader.maxDynamicTableByteCount = i8;
                if (i8 < 0 || i8 > 4096) {
                    throw new IOException(C0000.decode(new byte[]{120, 10, 70, 88, 85, 13, 87, 25, 87, 78, 94, 85, 90, 90, 87, 21, 69, 5, 82, 85, 92, 68, 64, 80, 73, 82, 16, 65, 71, 87, 85, 65, 84, 68}, "1d099d3937047345", 0.0f) + reader.maxDynamicTableByteCount);
                }
                int i9 = reader.dynamicTableByteCount;
                if (i8 < i9) {
                    if (i8 == 0) {
                        Header[] headerArr4 = reader.dynamicTable;
                        Arrays.fill(headerArr4, 0, headerArr4.length, (Object) null);
                        reader.nextHeaderIndex = reader.dynamicTable.length - 1;
                        reader.headerCount = 0;
                        reader.dynamicTableByteCount = 0;
                    } else {
                        reader.evictToRecoverBytes(i9 - i8);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                Header[] headerArr5 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString2 = reader.readByteString();
                Hpack.checkLowercase(byteString2);
                arrayList.add(new Header(byteString2, reader.readByteString()));
            } else {
                arrayList.add(new Header(reader.getName(reader.readInt(i5, 15) - 1), reader.readByteString()));
            }
        }
        List list = CollectionsKt.toList(arrayList);
        arrayList.clear();
        return list;
    }

    public final void readHeaders(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException(C0000.decode(new byte[]{50, 49, 44, 108, 46, 116, 122, 123, 107, 39, 103, 106, 127, 102, 88, 67, 55, 97, 49, 114, 106, 127, 113, 35, 113, 125, 98, 103, 66, 16, 23, 74, 4, 86, 88, 126, 80, 66, 8, 5, 16, 4}, "bcc8a7574b5804"));
        }
        int i4 = 0;
        boolean z = (i2 & 1) != 0;
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        }
        if ((i2 & 32) != 0) {
            BufferedSource bufferedSource = this.source;
            bufferedSource.readInt();
            bufferedSource.readByte();
            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
            i -= 5;
        }
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i, i2, i4), i4, i2, i3);
        Http2Connection http2Connection = Http2Connection.this;
        if (i3 != 0 && (i3 & 1) == 0) {
            http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(http2Connection.connectionName + '[' + i3 + C0000.decode(new byte[]{104, 17, 14, 94, 126, 3, 84, 85, 4, 66, 69}, "51a06f"), http2Connection, i3, headerBlock, z), 0L);
            return;
        }
        synchronized (http2Connection) {
            Http2Stream stream = http2Connection.getStream(i3);
            if (stream != null) {
                stream.receiveHeaders(Util.toHeaders(headerBlock), z);
                return;
            }
            if (http2Connection.isShutdown) {
                return;
            }
            if (i3 <= http2Connection.lastGoodStreamId) {
                return;
            }
            int i5 = 2;
            if (i3 % 2 == http2Connection.nextStreamId % 2) {
                return;
            }
            Http2Stream http2Stream = new Http2Stream(i3, http2Connection, false, z, Util.toHeaders(headerBlock));
            http2Connection.lastGoodStreamId = i3;
            http2Connection.streams.put(Integer.valueOf(i3), http2Stream);
            http2Connection.taskRunner.newQueue().schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(http2Connection.connectionName + '[' + i3 + C0000.decode(new byte[]{63, 21, 11, 93, 102, 69, 20, 87, 0, 88}, "b5d351f2a558a0ee"), http2Connection, http2Stream, i5), 0L);
        }
    }

    public final void readPushPromise(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            throw new IOException(C0000.decode(new byte[]{104, 51, 41, 100, 122, 122, 43, 127, 110, 117, 54, 52, 119, 51, 92, 16, 97, 96, 52, 118, 110, 96, 49, 53, 112, 62, 54, 98, 122, 116, 45, 96, 116, 16, 23, 18, 74, 4, 7, 93, 124, 93, 68, 14, 12, 16, 84}, "8af059d310df", 0.0f));
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        int i5 = this.source.readInt() & Integer.MAX_VALUE;
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, i4), i4, i2, i3);
        Http2Connection http2Connection = Http2Connection.this;
        synchronized (http2Connection) {
            if (http2Connection.currentPushRequests.contains(Integer.valueOf(i5))) {
                http2Connection.writeSynResetLater$okhttp(i5, 2);
                return;
            }
            http2Connection.currentPushRequests.add(Integer.valueOf(i5));
            http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(http2Connection.connectionName + '[' + i5 + C0000.decode(new byte[]{101, 65, 90, 88, 102, 1, 64, 19, 86, 17, 76}, "8a564d1f3b86", 5), http2Connection, i5, headerBlock), 0L);
        }
    }
}
