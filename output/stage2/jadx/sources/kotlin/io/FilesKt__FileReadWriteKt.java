package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a!\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0087\b\u001a\u0017\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a!\u0010\u000b\u001a\u00020\f*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0002\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010\u001a\u0012\u0010\u0014\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0017\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0019\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u001a\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d*\u00020\u0004H\u0000\u001a\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001dH\u0000\u001aB\u0010#\u001a\u00020\u0012*\u00020\u000226\u0010$\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120%\u001aJ\u0010#\u001a\u00020\u0012*\u00020\u00022\u0006\u0010*\u001a\u00020\b26\u0010$\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120%\u001a7\u0010+\u001a\u00020\u0012*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120,\u001a\r\u0010.\u001a\u00020/*\u00020\u0002H\u0087\b\u001a\r\u00100\u001a\u000201*\u00020\u0002H\u0087\b\u001a\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001603*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001aL\u00104\u001a\u0002H5\"\u0004\b\u0000\u00105*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0018\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001607\u0012\u0004\u0012\u0002H50,H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00108\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"reader", "Ljava/io/InputStreamReader;", "Ljava/io/File;", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "writer", "Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "", "writeBytes", "", "array", "appendBytes", "readText", "", "writeText", "text", "appendText", "writeTextImpl", "Ljava/io/OutputStream;", "newReplaceEncoder", "Ljava/nio/charset/CharsetEncoder;", "kotlin.jvm.PlatformType", "byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "encoder", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/FilesKt")
public class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public static final void appendBytes(File file, byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{14, 71, 14, 11, 17, 6}, "23fbb8725cbcf20f"));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{7, 68, 74, 3, 29}, "f68bd7", 0.0f));
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void appendText(File file, String str, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{11, 68, 80, 11, 69, 8}, "708b66b2707e", false));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{70, 0, 74, 21}, "2e2a1cbb0778"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{84, 94, 82, 69, 64, 80, 70}, "76373529de"));
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            FilesKt.writeTextImpl(fileOutputStream, str, charset);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    private static final BufferedReader bufferedReader(File file, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{95, 17, 94, 91, 66, 91}, "ce621eb6", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 11, 89, 74, 66, 84, 17}, "9c8811e0", true));
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{14, 76, 93, 12, 66, 12}, "285e12a846eb"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 9, 82, 17, 16, 1, 21}, "9a3ccdadef", 0.0f));
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i);
    }

    private static final BufferedWriter bufferedWriter(File file, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{12, 16, 93, 95, 17, 11}, "0d56b594f2b85db5", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{91, 13, 4, 66, 75, 0, 22}, "8ee08ebb73", 6));
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{8, 17, 92, 89, 18, 88}, "4e40af00", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{84, 13, 81, 23, 17, 92, 21}, "7e0eb9a6", 0.0f));
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i);
    }

    public static final ByteBuffer byteBufferForEncoding(int i, CharsetEncoder charsetEncoder) {
        Intrinsics.checkNotNullParameter(charsetEncoder, C0000.decode(new byte[]{7, 89, 81, 87, 85, 84, 75}, "b728119cea", 0.0f));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i * ((int) Math.ceil(charsetEncoder.maxBytesPerChar())));
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, C0000.decode(new byte[]{88, 10, 85, 14, 80, 89, 17, 87, 77, 26, 23, 28, 16}, "9f9a38e2e492", 0.0f));
        return byteBufferAllocate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [byte[], java.lang.Object] */
    public static final void forEachBlock(File file, int i, Function2<? super byte[], ? super Integer, Unit> function2) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 71, 91, 81, 74, 9}, "d3389726cd3b0985", true));
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{2, 81, 21, 81, 95, 92}, "c2a802c6d6a3"));
        ?? r6 = new byte[RangesKt.coerceAtLeast(i, ConstantsKt.MINIMUM_BLOCK_SIZE)];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            while (true) {
                int i2 = fileInputStream2.read(r6);
                if (i2 <= 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
                function2.invoke(r6, Integer.valueOf(i2));
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void forEachBlock(File file, Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{12, 18, 80, 11, 22, 9}, "0f8be7c6b95ac1", 3));
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{7, 85, 18, 15, 94, 88}, "f6ff164c5972ca", 0.0f));
        FilesKt.forEachBlock(file, ConstantsKt.DEFAULT_BLOCK_SIZE, function2);
    }

    public static final void forEachLine(File file, Charset charset, Function1<? super String, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{93, 16, 13, 80, 23, 90}, "ade9dd", 4));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{86, 89, 87, 69, 17, 81, 22}, "5167b4b19d89ab88", 7));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{82, 81, 71, 12, 92, 12}, "323e3bd40b208ff6", 7));
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
    }

    private static final FileInputStream inputStream(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{4, 22, 13, 81, 64, 9}, "8be837", 6));
        return new FileInputStream(file);
    }

    public static final CharsetEncoder newReplaceEncoder(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{88, 22, 13, 10, 67, 6}, "dbec08"));
        return charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private static final FileOutputStream outputStream(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{94, 65, 91, 89, 75, 11}, "b5308567f831", true));
        return new FileOutputStream(file);
    }

    private static final PrintWriter printWriter(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{5, 22, 10, 10, 16, 13}, "9bbcc357", 2));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{83, 12, 3, 69, 16, 6, 17}, "0db7cce8ea1d8b"));
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, ConstantsKt.DEFAULT_BUFFER_SIZE));
    }

    static /* synthetic */ PrintWriter printWriter$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 18, 88, 8, 16, 95}, "df0aca71", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 92, 89, 71, 69, 92, 17}, "948569ede7f5f2", 0.0f));
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, ConstantsKt.DEFAULT_BUFFER_SIZE));
    }

    public static final byte[] readBytes(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 68, 9, 93, 16, 7}, "d0a4c9c181e6d6", true));
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            long length = file.length();
            String strDecode = C0000.decode(new byte[]{115, 92, 92, 82, 67}, "5507c4", 0.0f);
            if (length > 2147483647L) {
                throw new OutOfMemoryError(strDecode + file + C0000.decode(new byte[]{21, 12, 16, 19, 22, 89, 86, 24, 90, 8, 4, 69, 29}, "5ec3b6988ace", false) + length + C0000.decode(new byte[]{17, 0, 75, 70, 81, 17, 29, 68, 17, 89, 68, 5, 12, 64, 66, 90, 95, 66, 95, 87, 89, 13, 70, 29, 75}, "1b224b4de6dce4b3", 4));
            }
            int i = (int) length;
            byte[] bArrCopyInto = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int i4 = fileInputStream2.read(bArrCopyInto, i3, i2);
                if (i4 < 0) {
                    break;
                }
                i2 -= i4;
                i3 += i4;
            }
            String strDecode2 = C0000.decode(new byte[]{91, 13, 69, 27, 44, 81, 27, 23, 72, 76, 74}, "8b5bc739fbc287");
            if (i2 > 0) {
                bArrCopyInto = Arrays.copyOf(bArrCopyInto, i3);
                Intrinsics.checkNotNullExpressionValue(bArrCopyInto, strDecode2);
            } else {
                int i5 = fileInputStream2.read();
                if (i5 != -1) {
                    ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                    exposingBufferByteArrayOutputStream.write(i5);
                    ByteStreamsKt.copyTo$default(fileInputStream2, exposingBufferByteArrayOutputStream, 0, 2, null);
                    int size = exposingBufferByteArrayOutputStream.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError(strDecode + file + C0000.decode(new byte[]{24, 95, 70, 66, 70, 13, 12, 65, 90, 95, 82, 66, 70, 13, 67, 7, 81, 66, 21, 11, 92, 66, 14, 4, 85, 89, 71, 27, 28}, "865b2bca"));
                    }
                    byte[] buffer = exposingBufferByteArrayOutputStream.getBuffer();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrCopyInto, size);
                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf, strDecode2);
                    bArrCopyInto = ArraysKt.copyInto(buffer, bArrCopyOf, i, 0, exposingBufferByteArrayOutputStream.size());
                }
            }
            CloseableKt.closeFinally(fileInputStream, null);
            return bArrCopyInto;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final List<String> readLines(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{15, 18, 95, 80, 67, 95}, "3f790a27067a"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{85, 91, 87, 71, 71, 85, 71}, "63654036f7a80c", 0.0f));
        final ArrayList arrayList = new ArrayList();
        FilesKt.forEachLine(file, charset, new Function1() { // from class: kotlin.io.FilesKt__FileReadWriteKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilesKt__FileReadWriteKt.readLines$lambda$9$FilesKt__FileReadWriteKt(arrayList, (String) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readLines$lambda$9$FilesKt__FileReadWriteKt(ArrayList arrayList, String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 18}, "eff9b47eee"));
        arrayList.add(str);
        return Unit.INSTANCE;
    }

    public static final String readText(File file, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 68, 13, 88, 71, 6}, "d0e148cfb3"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{7, 81, 86, 17, 21, 84, 71}, "d97cf13ce7cd", 6));
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
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

    private static final InputStreamReader reader(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{93, 67, 12, 92, 71, 14}, "a7d54035ea17", 3));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{87, 89, 2, 71, 70, 6, 71}, "41c55c332c", 0.0f));
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ InputStreamReader reader$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{14, 69, 13, 81, 75, 92}, "21e88b2b7e3e70b1", 2));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{7, 81, 83, 17, 23, 85, 67}, "d92cd078b2", true));
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T useLines(File file, Charset charset, Function1<? super Sequence<String>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{94, 77, 13, 15, 18, 10}, "b9efa4b6"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{83, 95, 0, 66, 74, 87, 68}, "07a0920a", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{3, 9, 93, 1, 88}, "ae2b3248"));
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
        try {
            T tInvoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            CloseableKt.closeFinally(bufferedReader, null);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ Object useLines$default(File file, Charset charset, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{94, 22, 88, 92, 22, 6}, "bb05e8adcfa8", 3));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{83, 10, 88, 17, 70, 81, 69}, "0b9c5413669ecf", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{90, 93, 87, 82, 83}, "818188"));
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
        try {
            Object objInvoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            CloseableKt.closeFinally(bufferedReader, null);
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static final void writeBytes(File file, byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{10, 17, 95, 88, 16, 93}, "6e71cc26b836d4", 3));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{4, 66, 16, 4, 75}, "e0be20a688", 0.0f));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeText(File file, String str, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{5, 21, 13, 88, 21, 9}, "9ae1f7abcc220f", false));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{18, 86, 72, 16}, "f30dbdd34f31445b", 2));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 12, 80, 74, 22, 4, 65}, "9d18ea563d32"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            FilesKt.writeTextImpl(fileOutputStream, str, charset);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeTextImpl(OutputStream outputStream, String str, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, C0000.decode(new byte[]{10, 18, 10, 11, 18, 6}, "6fbba8"));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{66, 7, 79, 64}, "6b744ac06a", true));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{91, 14, 80, 71, 17, 80, 22}, "8f15b5bb0249", 0.0f));
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{6, 4, 16, 113, 79, 76, 83, 74, 76, 24, 27, 25, 26}, "aad36869d6573ced", false));
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewReplaceEncoder = FilesKt.newReplaceEncoder(charset);
        CharBuffer charBufferAllocate = CharBuffer.allocate(ConstantsKt.DEFAULT_BUFFER_SIZE);
        Intrinsics.checkNotNull(charsetEncoderNewReplaceEncoder);
        ByteBuffer byteBufferByteBufferForEncoding = FilesKt.byteBufferForEncoding(ConstantsKt.DEFAULT_BUFFER_SIZE, charsetEncoderNewReplaceEncoder);
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iMin = Math.min(8192 - i2, str.length() - i);
            int i3 = i + iMin;
            char[] cArrArray = charBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(cArrArray, C0000.decode(new byte[]{80, 74, 64, 82, 76, 76, 30, 79, 22, 76}, "18235d0a8e"));
            str.getChars(i, i3, cArrArray, i2);
            charBufferAllocate.limit(iMin + i2);
            i2 = 1;
            if (!charsetEncoderNewReplaceEncoder.encode(charBufferAllocate, byteBufferByteBufferForEncoding, i3 == str.length()).isUnderflow()) {
                throw new IllegalStateException(C0000.decode(new byte[]{119, 94, 1, 91, 92, 70, 0, 0, 89, 15, 1, 7, 28}, "46d87ffa0cdc2b", 0.0f));
            }
            outputStream.write(byteBufferByteBufferForEncoding.array(), 0, byteBufferByteBufferForEncoding.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i2 = 0;
            }
            charBufferAllocate.clear();
            byteBufferByteBufferForEncoding.clear();
            i = i3;
        }
    }

    private static final OutputStreamWriter writer(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{89, 18, 95, 88, 75, 7}, "ef718968", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 13, 86, 22, 64, 83, 64}, "9e7d364b6450", 4));
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{4, 16, 90, 93, 65, 9}, "8d242732", 5));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{90, 95, 82, 69, 67, 85, 77}, "973700964dfa", 6));
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readText(file, charset);
    }

    public static /* synthetic */ void writeText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.writeText(file, str, charset);
    }

    public static /* synthetic */ void appendText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.appendText(file, str, charset);
    }

    public static /* synthetic */ void forEachLine$default(File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file, charset, function1);
    }

    public static /* synthetic */ List readLines$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readLines(file, charset);
    }
}
