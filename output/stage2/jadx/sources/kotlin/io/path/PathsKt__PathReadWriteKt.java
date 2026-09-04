package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.ConstantsKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001a:\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\u0010\u001a:\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0002H\u0087\b\u001a.\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0015\u0010\u001a\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0087\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a7\u0010\u001d\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a=\u0010\"\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00170$H\u0087\bø\u0001\u0000\u001a&\u0010(\u001a\u00020)*\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010*\u001a&\u0010+\u001a\u00020,*\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0/*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001aL\u00100\u001a\u0002H1\"\u0004\b\u0000\u00101*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c03\u0012\u0004\u0012\u0002H10$H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00104\u001a>\u00105\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f072\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u00108\u001a>\u00105\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f032\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u00109\u001a%\u0010:\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010:\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f032\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"reader", "Ljava/io/InputStreamReader;", "Ljava/nio/file/Path;", "charset", "Ljava/nio/charset/Charset;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "readBytes", "", "writeBytes", "", "array", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "appendBytes", "readText", "", "writeText", "text", "", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "appendText", "forEachLine", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeLines", "lines", "", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "appendLines", "kotlin-stdlib-jdk7"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt {
    private static final void appendBytes(Path path, byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{4, 77, 89, 89, 17, 7}, "8910b9cc75", 2));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{83, 75, 66, 88, 73}, "29090cff0d704b"));
        OpenOption[] openOptionArr = new OpenOption[1];
        openOptionArr[0] = StandardOpenOption.APPEND;
        Files.write(path, bArr, openOptionArr);
    }

    private static final Path appendLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{4, 77, 88, 81, 22, 88}, "8908ef490bda6c", 5));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{95, 10, 15, 6, 69}, "3cac65f4fea64b37", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{83, 13, 84, 17, 17, 7, 68}, "0e5cbb", 2));
        OpenOption[] openOptionArr = new OpenOption[1];
        openOptionArr[0] = StandardOpenOption.APPEND;
        Path pathWrite = Files.write(path, iterable, charset, openOptionArr);
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{68, 71, 8, 17, 85, 74, 77, 79, 29, 28}, "35ae0bca", 0.0f));
        return pathWrite;
    }

    private static final Path appendLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 69, 89, 8, 16, 11}, "d11ac50005"));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{15, 95, 91, 84, 74}, "c6519ee1"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{80, 94, 88, 68, 68, 93, 71}, "369678", 0.0f));
        Iterable iterableAsIterable = SequencesKt.asIterable(sequence);
        OpenOption[] openOptionArr = new OpenOption[1];
        openOptionArr[0] = StandardOpenOption.APPEND;
        Path pathWrite = Files.write(path, iterableAsIterable, charset, openOptionArr);
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{64, 19, 93, 17, 83, 24, 72, 77, 22, 28}, "7a4e60fc8508", 0.0f));
        return pathWrite;
    }

    static /* synthetic */ Path appendLines$default(Path path, Iterable iterable, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{94, 23, 14, 95, 75, 13}, "bcf683d3bc0519", true));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{91, 81, 91, 7, 67}, "785b0e", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{80, 11, 0, 66, 17, 81, 21}, "3ca0b4aea5", 0.0f));
        Path pathWrite = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{21, 19, 90, 23, 86, 27, 22, 72, 24, 26}, "ba3c338f632167", 4));
        return pathWrite;
    }

    static /* synthetic */ Path appendLines$default(Path path, Sequence sequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{89, 18, 11, 88, 17, 15}, "efc1b1", 7));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{91, 13, 93, 6, 16}, "7d3cce515a", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{84, 89, 3, 68, 21, 82, 70}, "71b6f72c4b", 3));
        Path pathWrite = Files.write(path, SequencesKt.asIterable(sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{20, 75, 12, 77, 86, 26, 24, 29, 77, 16}, "c9e93263"));
        return pathWrite;
    }

    public static final void appendText(Path path, CharSequence charSequence, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{5, 23, 10, 94, 17, 6}, "9cb7b8ed3853fd", true));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{76, 7, 75, 64}, "8b349ecff235b3", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 10, 3, 71, 70, 86, 23}, "9bb553ccc40221"));
        OpenOption[] openOptionArr = new OpenOption[1];
        openOptionArr[0] = StandardOpenOption.APPEND;
        PathsKt.writeText(path, charSequence, charset, openOptionArr);
    }

    private static final BufferedReader bufferedReader(Path path, Charset charset, int i, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{90, 65, 90, 13, 64, 12}, "f52d325ade84", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{91, 88, 4, 70, 69, 80, 23}, "80e465ccee0885", true));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{10, 21, 21, 13, 95, 92, 16}, "eead02cbf9e9"));
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 18, 95, 15, 68, 10}, "2f7f743e"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{82, 14, 81, 22, 70, 93, 16}, "1f0d58d5cb40c4"));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{12, 69, 65, 93, 11, 92, 74}, "c554d29f"));
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final BufferedWriter bufferedWriter(Path path, Charset charset, int i, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 18, 92, 91, 74, 92}, "2f429b", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{81, 13, 2, 65, 23, 7, 76}, "2ec3db8cb5e3"));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{10, 64, 64, 80, 92, 94, 22}, "e04930", 5));
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{14, 65, 10, 81, 64, 15}, "25b8314db23b", 0));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 13, 7, 69, 21, 7, 77}, "9ef7fb"));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{13, 73, 69, 91, 14, 87, 70}, "b912a95ef48f9552", 6));
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final void forEachLine(Path path, Charset charset, Function1<? super String, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{4, 16, 89, 93, 17, 11}, "8d14b5bd1a5acafe"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{1, 80, 3, 65, 67, 7, 77}, "b8b30b970eee6b", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{3, 85, 71, 89, 10, 15}, "b630ea8a9e", 0.0f));
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(bufferedReaderNewBufferedReader, C0000.decode(new byte[]{89, 82, 67, 123, 19, 5, 85, 81, 75, 0, 1, 96, 82, 86, 80, 92, 20, 75, 29, 26, 23, 76}, "7749fc349ee2"));
        BufferedReader bufferedReader = bufferedReaderNewBufferedReader;
        try {
            Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    static /* synthetic */ void forEachLine$default(Path path, Charset charset, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 22, 91, 91, 68, 11}, "ab3275", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{82, 89, 85, 16, 64, 6, 21}, "114b3ca4b79ac3", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{0, 86, 21, 92, 9, 92}, "a5a5f2ffe4f2f6"));
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(bufferedReaderNewBufferedReader, C0000.decode(new byte[]{93, 1, 68, 36, 22, 84, 0, 92, 66, 92, 87, 54, 86, 7, 7, 87, 20, 17, 30, 23, 29, 77}, "3d3fc2f909", 4));
        BufferedReader bufferedReader = bufferedReaderNewBufferedReader;
        try {
            Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    private static final InputStream inputStream(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{13, 22, 80, 95, 68, 88}, "1b867fdb163c", true));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{10, 64, 23, 10, 9, 95, 68}, "e0ccf176ad0d"));
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(inputStreamNewInputStream, C0000.decode(new byte[]{8, 1, 19, 125, 95, 20, 19, 16, 55, 64, 67, 1, 7, 9, 76, 26, 31, 74, 79}, "fdd41d", 4));
        return inputStreamNewInputStream;
    }

    private static final OutputStream outputStream(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{95, 67, 10, 15, 66, 91}, "c7bf1e", 5));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{13, 69, 77, 95, 88, 86, 74}, "b59678971058a3", 0.0f));
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, C0000.decode(new byte[]{13, 82, 78, 119, 66, 77, 68, 19, 67, 49, 18, 20, 6, 86, 84, 16, 25, 23, 26, 79}, "c798794f7bff", false));
        return outputStreamNewOutputStream;
    }

    private static final byte[] readBytes(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 64, 88, 94, 22, 90}, "d407edc4b23e69", true));
        byte[] allBytes = Files.readAllBytes(path);
        Intrinsics.checkNotNullExpressionValue(allBytes, C0000.decode(new byte[]{75, 92, 7, 93, 34, 92, 91, 32, 72, 71, 3, 23, 29, 75, 79, 24, 16}, "99f9c07b13fd5ea6", 1));
        return allBytes;
    }

    private static final List<String> readLines(Path path, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 17, 14, 10, 68, 88}, "3efc7feb", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{85, 13, 87, 65, 23, 86, 68}, "6e63d30f8b6a", 1));
        List<String> allLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(allLines, C0000.decode(new byte[]{68, 4, 3, 93, 117, 93, 90, 45, 11, 87, 81, 66, 30, 79, 76, 23, 29}, "6ab941", 7));
        return allLines;
    }

    static /* synthetic */ List readLines$default(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{13, 65, 94, 89, 17, 92}, "1560bb404eb777d1", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 88, 0, 22, 68, 0, 21}, "90ad7eafb7", false));
        List<String> allLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(allLines, C0000.decode(new byte[]{16, 81, 4, 93, 115, 90, 84, 117, 94, 95, 3, 64, 77, 29, 76, 26, 76}, "b4e9268971f3e3", 6));
        return allLines;
    }

    public static final String readText(Path path, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{9, 70, 95, 88, 23, 12}, "5271d2c4", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{83, 90, 2, 74, 23, 3, 21}, "02c8dfae4c49"));
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String text = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    private static final InputStreamReader reader(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 76, 81, 91, 65, 13}, "a89223abc0"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{84, 80, 84, 64, 68, 4, 68}, "78527a0671a8d5", 7));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{88, 18, 65, 95, 11, 90, 21}, "7b56d4ffc6a8c138", 0.0f));
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ InputStreamReader reader$default(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{15, 17, 80, 8, 22, 6}, "3e8ae87d9c2ff527", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{7, 88, 89, 70, 64, 7, 21}, "d0843ba79b03f0", 0.0f));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{14, 70, 65, 89, 95, 91, 75}, "a650058e37ad", false));
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    private static final <T> T useLines(Path path, Charset charset, Function1<? super Sequence<String>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 77, 11, 90, 70, 12}, "a9c352c4ff", 6));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{81, 12, 5, 23, 18, 82, 17}, "2ddea7e571a681"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{7, 8, 95, 80, 8}, "ed03c0e1b4ba", 0));
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        try {
            BufferedReader bufferedReader = bufferedReaderNewBufferedReader;
            Intrinsics.checkNotNull(bufferedReader);
            T tInvoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            CloseableKt.closeFinally(bufferedReaderNewBufferedReader, null);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReaderNewBufferedReader, th);
                throw th2;
            }
        }
    }

    static /* synthetic */ Object useLines$default(Path path, Charset charset, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{95, 71, 93, 94, 22, 10}, "c357e450118eb5", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{6, 90, 88, 19, 16, 86, 77}, "e29ac39b"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{90, 84, 93, 84, 93}, "882764d2", 0));
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        try {
            BufferedReader bufferedReader = bufferedReaderNewBufferedReader;
            Intrinsics.checkNotNull(bufferedReader);
            Object objInvoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            CloseableKt.closeFinally(bufferedReaderNewBufferedReader, null);
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReaderNewBufferedReader, th);
                throw th2;
            }
        }
    }

    private static final void writeBytes(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{5, 66, 9, 91, 69, 6}, "96a2685b8d98b208", 0.0f));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{89, 68, 70, 5, 24}, "864da13c1f21", 0.0f));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{86, 67, 67, 80, 95, 93, 74}, "937903", 4));
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    private static final Path writeLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{93, 16, 14, 13, 66, 88}, "adfd1f93c37c", true));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{90, 93, 91, 83, 21}, "6456fa02e71e", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{80, 94, 88, 23, 75, 1, 71}, "369e8d3f9c"));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{92, 72, 21, 94, 12, 95, 75}, "38a7c188"));
        Path pathWrite = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{19, 71, 95, 77, 93, 31, 75, 72, 31, 25}, "d56987ef10eb"));
        return pathWrite;
    }

    private static final Path writeLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{94, 66, 90, 95, 21, 14}, "b626f059"));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{95, 89, 11, 92, 75}, "30e982027891", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{87, 14, 88, 64, 22, 0, 22}, "4f92eeb1", false));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{93, 21, 68, 81, 90, 88, 21}, "2e0856f40bb34e", 0.0f));
        Path pathWrite = Files.write(path, SequencesKt.asIterable(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{64, 69, 90, 69, 92, 25, 31, 74, 25, 30}, "7731911d", 0.0f));
        return pathWrite;
    }

    static /* synthetic */ Path writeLines$default(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{89, 65, 90, 15, 64, 91}, "e52f3e68c5dd27", true));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{15, 80, 13, 84, 70}, "c9c157799d"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{7, 94, 3, 19, 69, 0, 17}, "d6ba6ee3ad", 0.0f));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{93, 18, 77, 95, 87, 92, 75}, "2b96828c16a0", 0.0f));
        Path pathWrite = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{68, 16, 94, 18, 1, 27, 74, 24, 29, 75}, "3b7fd3d6", 5));
        return pathWrite;
    }

    static /* synthetic */ Path writeLines$default(Path path, Sequence sequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 18, 92, 10, 65, 9}, "4f4c27", true));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{95, 80, 13, 84, 69}, "39c16221", 7));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{0, 11, 81, 67, 23, 87, 64}, "cc01d2466417", true));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{92, 73, 16, 13, 13, 93, 18}, "39ddb3a7"));
        Path pathWrite = Files.write(path, SequencesKt.asIterable(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(pathWrite, C0000.decode(new byte[]{64, 19, 93, 70, 83, 31, 77, 26, 72, 29}, "7a4267c4f4", 7));
        return pathWrite;
    }

    public static final void writeText(Path path, CharSequence charSequence, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 64, 80, 81, 71, 14}, "d488407c13"));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{67, 87, 28, 67}, "72d71337", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{84, 94, 0, 64, 21, 93, 67}, "76a2f875435ded35"));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{91, 22, 70, 92, 90, 13, 16}, "4f255cc8045eab1b"));
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        try {
            OutputStream outputStream = outputStreamNewOutputStream;
            if (charSequence instanceof String) {
                Intrinsics.checkNotNull(outputStream);
                FilesKt.writeTextImpl(outputStream, (String) charSequence, charset);
            } else {
                CharsetEncoder charsetEncoderNewReplaceEncoder = FilesKt.newReplaceEncoder(charset);
                CharBuffer charBufferAsReadOnlyBuffer = charSequence instanceof CharBuffer ? ((CharBuffer) charSequence).asReadOnlyBuffer() : CharBuffer.wrap(charSequence);
                int iMin = Math.min(charSequence.length(), ConstantsKt.DEFAULT_BUFFER_SIZE);
                Intrinsics.checkNotNull(charsetEncoderNewReplaceEncoder);
                ByteBuffer byteBufferByteBufferForEncoding = FilesKt.byteBufferForEncoding(iMin, charsetEncoderNewReplaceEncoder);
                while (charBufferAsReadOnlyBuffer.hasRemaining()) {
                    if (charsetEncoderNewReplaceEncoder.encode(charBufferAsReadOnlyBuffer, byteBufferByteBufferForEncoding, true).isError()) {
                        throw new IllegalStateException(C0000.decode(new byte[]{32, 14, 3, 6, 94, 24, 86, 2, 90, 14, 87, 84, 77}, "cffe580c3b20", 5));
                    }
                    outputStream.write(byteBufferByteBufferForEncoding.array(), 0, byteBufferByteBufferForEncoding.position());
                    byteBufferByteBufferForEncoding.clear();
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamNewOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStreamNewOutputStream, th);
                throw th2;
            }
        }
    }

    private static final OutputStreamWriter writer(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{88, 64, 90, 89, 65, 8}, "d42026", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{81, 93, 4, 74, 71, 84, 77}, "25e8419de9d09e", 7));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{87, 68, 64, 94, 89, 92, 17}, "844762b9b42c07", 7));
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{10, 70, 81, 88, 18, 12}, "6291a2", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{6, 88, 83, 74, 18, 0, 65}, "e028ae5dd8ba", true));
        Intrinsics.checkNotNullParameter(openOptionArr, C0000.decode(new byte[]{88, 71, 71, 89, 10, 10, 16}, "7730edc1"));
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    public static /* synthetic */ String readText$default(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return PathsKt.readText(path, charset);
    }

    public static /* synthetic */ void writeText$default(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.writeText(path, charSequence, charset, openOptionArr);
    }

    public static /* synthetic */ void appendText$default(Path path, CharSequence charSequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.appendText(path, charSequence, charset);
    }
}
