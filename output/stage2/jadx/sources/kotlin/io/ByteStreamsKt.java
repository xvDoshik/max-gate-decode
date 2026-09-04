package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0004*\u00020\tH\u0087\b\u001a\u001d\u0010\b\u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u0002*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0087\b\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087\b\u001a\u0017\u0010\u0012\u001a\u00020\u0013*\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u0014*\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0087\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087\b\u001a\u0017\u0010\u0018\u001a\u00020\u0019*\u00020\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087\b\u001a\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u001a\u0016\u0010\u001d\u001a\u00020\t*\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000bH\u0007\u001a\f\u0010\u001d\u001a\u00020\t*\u00020\u000eH\u0007¨\u0006\u001f"}, d2 = {"iterator", "Lkotlin/collections/ByteIterator;", "Ljava/io/BufferedInputStream;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "charset", "Ljava/nio/charset/Charset;", "inputStream", "", "offset", "", "length", "buffered", "Ljava/io/InputStream;", "bufferSize", "reader", "Ljava/io/InputStreamReader;", "bufferedReader", "Ljava/io/BufferedReader;", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "copyTo", "", "out", "readBytes", "estimatedSize", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteStreamsKt {
    private static final BufferedInputStream buffered(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{14, 16, 93, 15, 64, 14}, "2d5f305bf7bc", false));
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    private static final BufferedOutputStream buffered(OutputStream outputStream, int i) {
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{93, 70, 9, 89, 22, 11}, "a2a0e5a430", 0.0f));
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    static /* synthetic */ BufferedInputStream buffered$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{94, 69, 95, 13, 64, 93}, "b17d3c6899", 3));
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    static /* synthetic */ BufferedOutputStream buffered$default(OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{10, 65, 92, 92, 23, 6}, "6545d847e2e06aca", 6));
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    private static final BufferedReader bufferedReader(InputStream inputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{11, 17, 93, 10, 71, 91}, "7e5c4e5c0b", 2));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{85, 12, 89, 71, 18, 7, 18}, "6d85abfe88e2", 2));
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{88, 70, 91, 92, 64, 10}, "d23534a546946e", 5));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{0, 93, 80, 69, 68, 82, 66}, "c517776f6825ab", 3));
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
    }

    private static final BufferedWriter bufferedWriter(OutputStream outputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{10, 17, 90, 94, 74, 93}, "6e279c"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{1, 10, 88, 17, 75, 4, 22}, "bb9c8a", 6));
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, ConstantsKt.DEFAULT_BUFFER_SIZE);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{8, 76, 88, 81, 69, 10}, "4808645bc81d3a"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{6, 13, 4, 67, 66, 80, 67}, "eee1157a5d", 0));
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, ConstantsKt.DEFAULT_BUFFER_SIZE);
    }

    private static final ByteArrayInputStream byteInputStream(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 71, 13, 11, 64, 12}, "f3eb3288f25b784a", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{5, 14, 81, 68, 21, 80, 65}, "ff06f5585f73", true));
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{95, 81, 16, 115, 65, 66, 1, 21, 28, 72, 22, 26, 77}, "84d186df4f"));
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream byteInputStream$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 23, 95, 10, 65, 88}, "ac7c2f0b0ede49", 4));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{87, 9, 4, 20, 65, 81, 21}, "4aef24ae39", 0.0f));
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{1, 93, 65, 115, 74, 22, 87, 74, 78, 22, 27, 31, 26}, "f8513b29", 4));
        return new ByteArrayInputStream(bytes);
    }

    public static final long copyTo(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{95, 17, 92, 13, 21, 95}, "ce4dfa", 0.0f));
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{12, 65, 16}, "c4d6b9a06883", false));
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }

    private static final ByteArrayInputStream inputStream(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{14, 17, 90, 95, 66, 95}, "2e261a16891168", 0.0f));
        return new ByteArrayInputStream(bArr);
    }

    private static final ByteArrayInputStream inputStream(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{93, 68, 89, 94, 16, 8}, "a017c655cd263d", 4));
        return new ByteArrayInputStream(bArr, i, i2);
    }

    public static final ByteIterator iterator(final BufferedInputStream bufferedInputStream) {
        Intrinsics.checkNotNullParameter(bufferedInputStream, C0000.decode(new byte[]{14, 16, 9, 94, 23, 6}, "2da7d8e5d1", 7));
        return new ByteIterator() { // from class: kotlin.io.ByteStreamsKt.iterator.1
            private boolean finished;
            private int nextByte = -1;
            private boolean nextPrepared;

            @Override // kotlin.collections.ByteIterator
            public byte nextByte() throws IOException {
                prepareNext();
                if (this.finished) {
                    throw new NoSuchElementException(C0000.decode(new byte[]{121, 95, 17, 68, 68, 70, 22, 67, 17, 82, 81, 92, 65, 88, 67, 70, 10, 65, 6, 69, 30}, "01a10fe7c7", false));
                }
                byte b = (byte) this.nextByte;
                this.nextPrepared = false;
                return b;
            }

            public final int getNextByte() {
                return this.nextByte;
            }

            public final void setNextByte(int i) {
                this.nextByte = i;
            }

            public final boolean getNextPrepared() {
                return this.nextPrepared;
            }

            public final void setNextPrepared(boolean z) {
                this.nextPrepared = z;
            }

            public final boolean getFinished() {
                return this.finished;
            }

            public final void setFinished(boolean z) {
                this.finished = z;
            }

            private final void prepareNext() throws IOException {
                if (this.nextPrepared || this.finished) {
                    return;
                }
                int i = bufferedInputStream.read();
                this.nextByte = i;
                this.nextPrepared = true;
                this.finished = i == -1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() throws IOException {
                prepareNext();
                return !this.finished;
            }
        };
    }

    public static final byte[] readBytes(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{8, 16, 14, 81, 66, 12}, "4df81281423853cd", 0.0f));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(ConstantsKt.DEFAULT_BUFFER_SIZE, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, C0000.decode(new byte[]{21, 88, 114, 77, 18, 4, 39, 74, 20, 88, 79, 25, 79, 25, 30, 29}, "a704faf8f961", 7));
        return byteArray;
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{11, 77, 13, 11, 68, 11}, "79eb75acb4334d", 4));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, C0000.decode(new byte[]{16, 13, 114, 78, 16, 4, 37, 70, 75, 81, 29, 74, 30, 25, 74, 72}, "db07dad490", 5));
        return byteArray;
    }

    private static final InputStreamReader reader(InputStream inputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{14, 64, 95, 12, 18, 9}, "247ea74643e6ebcc"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{85, 89, 80, 75, 69, 87, 68}, "6119620196cc7f46", false));
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader reader$default(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(inputStream, C0000.decode(new byte[]{14, 69, 89, 13, 17, 14}, "211db0c71e4f69", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{81, 9, 89, 17, 74, 85, 66}, "2a8c906b1e75792c"));
        return new InputStreamReader(inputStream, charset);
    }

    private static final OutputStreamWriter writer(OutputStream outputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{9, 22, 90, 12, 16, 13}, "5b2ec326d7e3f0", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 81, 87, 75, 74, 7, 76}, "99699b88c9fc"));
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{15, 68, 12, 15, 65, 11}, "30df25", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{82, 80, 86, 70, 21, 4, 71}, "1874fa3137fefe", 0.0f));
        return new OutputStreamWriter(outputStream, charset);
    }

    public static /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        return copyTo(inputStream, outputStream, i);
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        return readBytes(inputStream, i);
    }
}
