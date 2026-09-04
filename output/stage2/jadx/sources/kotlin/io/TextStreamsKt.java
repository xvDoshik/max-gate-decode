package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001e\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u001a\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r*\u00020\u0002\u001aB\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0011\u0012\u0004\u0012\u0002H\u000f0\nH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0087\b\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011*\u00020\u0001\u001a\n\u0010\u0016\u001a\u00020\u000b*\u00020\u0002\u001a\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0017\u0010\u0016\u001a\u00020\u000b*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087\b\u001a\n\u0010\u001d\u001a\u00020\u001e*\u00020\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "forEachLine", "", "action", "Lkotlin/Function1;", "", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "reader", "Ljava/io/StringReader;", "lineSequence", "readText", "copyTo", "", "out", "Ljava/net/URL;", "charset", "Ljava/nio/charset/Charset;", "readBytes", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextStreamsKt {
    private static final BufferedReader buffered(Reader reader, int i) {
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{11, 71, 91, 13, 74, 15}, "733d91c1", 2));
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    private static final BufferedWriter buffered(Writer writer, int i) {
        Intrinsics.checkNotNullParameter(writer, C0000.decode(new byte[]{8, 67, 81, 95, 22, 12}, "4796e28421aba00e", 0.0f));
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    static /* synthetic */ BufferedReader buffered$default(Reader reader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{93, 16, 95, 92, 17, 15}, "ad75b1d0", 0.0f));
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer writer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        Intrinsics.checkNotNullParameter(writer, C0000.decode(new byte[]{15, 16, 80, 15, 71, 88}, "3d8f4f23c4dfa2", 0.0f));
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    public static final long copyTo(Reader reader, Writer writer, int i) throws IOException {
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{89, 64, 13, 8, 16, 12}, "e4eac25212", 0.0f));
        Intrinsics.checkNotNullParameter(writer, C0000.decode(new byte[]{87, 19, 18}, "8ffd470097", 0.0f));
        char[] cArr = new char[i];
        int i2 = reader.read(cArr);
        long j = 0;
        while (i2 >= 0) {
            writer.write(cArr, 0, i2);
            j += (long) i2;
            i2 = reader.read(cArr);
        }
        return j;
    }

    public static final void forEachLine(Reader reader, Function1<? super String, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{5, 67, 89, 81, 17, 13}, "9718b35372", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{0, 84, 22, 13, 10, 12}, "a7bdeb12", 0));
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, ConstantsKt.DEFAULT_BUFFER_SIZE);
        try {
            Iterator<String> it = lineSequence(bufferedReader).iterator();
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

    public static final Sequence<String> lineSequence(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, C0000.decode(new byte[]{11, 69, 95, 95, 75, 9}, "7176879482774f11", 1));
        return SequencesKt.constrainOnce(new LinesSequence(bufferedReader));
    }

    public static final byte[] readBytes(URL url) throws IOException {
        Intrinsics.checkNotNullParameter(url, C0000.decode(new byte[]{13, 23, 14, 12, 67, 9}, "1cfe07"));
        InputStream inputStreamOpenStream = url.openStream();
        try {
            InputStream inputStream = inputStreamOpenStream;
            Intrinsics.checkNotNull(inputStream);
            byte[] bytes = ByteStreamsKt.readBytes(inputStream);
            CloseableKt.closeFinally(inputStreamOpenStream, null);
            return bytes;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamOpenStream, th);
                throw th2;
            }
        }
    }

    public static final List<String> readLines(Reader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{93, 21, 12, 8, 17, 6}, "aadab8e62062974d", 0.0f));
        final ArrayList arrayList = new ArrayList();
        forEachLine(reader, new Function1() { // from class: kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextStreamsKt.readLines$lambda$1(arrayList, (String) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readLines$lambda$1(ArrayList arrayList, String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{92, 65}, "5540b75e812c", 0.0f));
        arrayList.add(str);
        return Unit.INSTANCE;
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{90, 16, 93, 88, 64, 7}, "fd51393e", 0.0f));
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{67, 89, 48, 76, 23, 15, 87, 3, 31, 24, 77, 22, 76}, "76c8ef9d"));
        return string;
    }

    private static final String readText(URL url, Charset charset) {
        Intrinsics.checkNotNullParameter(url, C0000.decode(new byte[]{12, 64, 81, 81, 69, 15}, "049861093f", 0.0f));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{0, 9, 80, 22, 67, 0, 18}, "ca1d0ef45f", true));
        return new String(readBytes(url), charset);
    }

    static /* synthetic */ String readText$default(URL url, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(url, C0000.decode(new byte[]{88, 67, 13, 11, 16, 9}, "d7ebc783abe8", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{85, 95, 81, 17, 22, 93, 22}, "670ce8b0", true));
        return new String(readBytes(url), charset);
    }

    private static final StringReader reader(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 23, 80, 91, 65, 12}, "0c8222d043", 0.0f));
        return new StringReader(str);
    }

    public static final <T> T useLines(Reader reader, Function1<? super Sequence<String>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(reader, C0000.decode(new byte[]{95, 76, 12, 80, 16, 8}, "c8d9c692", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{83, 88, 9, 86, 8}, "14f5c4"));
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, ConstantsKt.DEFAULT_BUFFER_SIZE);
        try {
            T tInvoke = function1.invoke(lineSequence(bufferedReader));
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

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        return copyTo(reader, writer, i);
    }
}
