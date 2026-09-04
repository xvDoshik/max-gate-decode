package okhttp3.internal;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final ResponseBody$Companion$asResponseBody$1 EMPTY_RESPONSE;
    public static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    public static final Regex VERIFY_AS_IP_ADDRESS;
    public static final String okHttpName;

    /* JADX WARN: Type inference failed for: r1v1, types: [okhttp3.ResponseBody$Companion$asResponseBody$1] */
    static {
        int i;
        int iCompareTo;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        final Buffer buffer = new Buffer();
        buffer.write(0, bArr);
        final long j = 0;
        EMPTY_RESPONSE = new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
            @Override // okhttp3.ResponseBody
            public final long contentLength() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            public final MediaType contentType() {
                return null;
            }

            @Override // okhttp3.ResponseBody
            public final BufferedSource source() {
                return buffer;
            }
        };
        checkOffsetAndCount(j, j, j);
        ByteString[] byteStringArr = {ByteString.Companion.decodeHex(C0000.decode(new byte[]{0, 87, 84, 86, 6, 2}, "e164ddfe04")), ByteString.Companion.decodeHex(C0000.decode(new byte[]{86, 86, 87, 81}, "0317e014")), ByteString.Companion.decodeHex(C0000.decode(new byte[]{82, 7, 95, 1}, "4a9dca505ec45dd5")), ByteString.Companion.decodeHex(C0000.decode(new byte[]{84, 8, 2, 0, 0, 87, 94, 82}, "d820f184")), ByteString.Companion.decodeHex(C0000.decode(new byte[]{5, 81, 94, 2, 83, 5, 7, 86}, "c78dc57f31"))};
        ArrayList arrayList = new ArrayList(new ArrayAsCollection(byteStringArr, false));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            ByteString byteString = byteStringArr[i2];
            arrayList2.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList2.toArray(new Integer[0]);
        ArrayList arrayListMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
        int i3 = 0;
        int i4 = 0;
        while (i3 < 5) {
            ByteString byteString2 = byteStringArr[i3];
            int i5 = i4 + 1;
            int size = arrayList.size();
            int size2 = arrayList.size();
            String strDecode = C0000.decode(new byte[]{76, 27}, "e5c2ad3ccb");
            if (size < 0) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{5, 22, 91, 8, 43, 91, 7, 1, 76, 69, 74, 5, 74, 68, 93, 22, 66, 82, 17, 1, 85, 17, 7, 71, 67, 16, 92, 4, 12, 21, 23, 11, 125, 11, 6, 80, 27, 68, 28}, "cd4eb5"), strDecode, size));
            }
            if (size > size2) {
                throw new IndexOutOfBoundsException(C0000.decode(new byte[]{17, 89, 126, 13, 84, 82, 29, 22, 16}, "e67c07e68ed8") + size + C0000.decode(new byte[]{24, 18, 11, 65, 66, 94, 68, 83, 86, 66, 84, 64, 66, 70, 10, 88, 88, 22, 68, 95, 75, 87, 66, 26}, "12b2b96676") + size2 + strDecode);
            }
            int i6 = size - 1;
            int i7 = 0;
            while (true) {
                if (i7 > i6) {
                    i = -(i7 + 1);
                    break;
                }
                i = (i7 + i6) >>> 1;
                Comparable comparable = (Comparable) arrayList.get(i);
                if (comparable == byteString2) {
                    iCompareTo = 0;
                } else if (comparable == null) {
                    iCompareTo = -1;
                } else {
                    iCompareTo = byteString2 == null ? 1 : comparable.compareTo(byteString2);
                }
                if (iCompareTo < 0) {
                    i7 = i + 1;
                } else if (iCompareTo <= 0) {
                    break;
                } else {
                    i6 = i - 1;
                }
            }
            arrayListMutableListOf.set(i, Integer.valueOf(i4));
            i3++;
            i4 = i5;
        }
        if (((ByteString) arrayList.get(0)).getSize$okio() <= 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{67, 11, 92, 25, 85, 12, 18, 66, 73, 70, 85, 26, 77, 92, 16, 18, 22, 68, 89, 8, 80, 67, 80, 74, 16, 15, 13, 66, 16, 7, 23, 16, 76, 73, 64, 14, 16, 66, 85, 2, 23, 12, 73, 77, 89, 14, 12}, "7c990ab60f"));
        }
        int i8 = 0;
        while (i8 < arrayList.size()) {
            ByteString byteString3 = (ByteString) arrayList.get(i8);
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 < arrayList.size()) {
                ByteString byteString4 = (ByteString) arrayList.get(i10);
                byteString4.getClass();
                if (!byteString4.rangeEquals(byteString3.getSize$okio(), byteString3)) {
                    break;
                }
                if (byteString4.getSize$okio() == byteString3.getSize$okio()) {
                    throw new IllegalArgumentException((C0000.decode(new byte[]{0, 68, 73, 91, 94, 81, 80, 17, 80, 25, 13, 19, 21, 80, 10, 10, 94, 17}, "d197721e59bca9ed") + byteString4).toString());
                }
                if (((Number) arrayListMutableListOf.get(i10)).intValue() > ((Number) arrayListMutableListOf.get(i8)).intValue()) {
                    arrayList.remove(i10);
                    arrayListMutableListOf.remove(i10);
                } else {
                    i10++;
                }
            }
            i8 = i9;
        }
        Buffer buffer2 = new Buffer();
        Options.Companion.buildTrieRecursive(0L, buffer2, 0, arrayList, 0, arrayList.size(), arrayListMutableListOf);
        int[] iArr = new int[(int) (buffer2.size / ((long) 4))];
        int i11 = 0;
        while (!buffer2.exhausted()) {
            iArr[i11] = buffer2.readInt();
            i11++;
        }
        UNICODE_BOMS = new Options((ByteString[]) Arrays.copyOf(byteStringArr, 5), iArr);
        UTC = TimeZone.getTimeZone(C0000.decode(new byte[]{112, 125, 54}, "70b8a566dd"));
        VERIFY_AS_IP_ADDRESS = new Regex(0);
        String name = OkHttpClient.class.getName();
        String strDecode2 = C0000.decode(new byte[]{86, 15, 13, 64, 68, 69, 10, 74}, "9de405");
        if (name.startsWith(strDecode2)) {
            name = name.substring(strDecode2.length());
        }
        if (name.endsWith(C0000.decode(new byte[]{32, 14, 89, 86, 11, 70}, "cb03e2"))) {
            name = name.substring(0, name.length() - 6);
        }
        okHttpName = name;
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        return Intrinsics.areEqual(httpUrl.host, httpUrl2.host) && httpUrl.port == httpUrl2.port && Intrinsics.areEqual(httpUrl.scheme, httpUrl2.scheme);
    }

    public static final int checkDuration(long j, TimeUnit timeUnit) {
        String strDecode = C0000.decode(new byte[]{77, 91, 12, 81, 93, 19, 17}, "92a42fe6", 0.0f);
        if (j < 0) {
            throw new IllegalStateException(strDecode.concat(C0000.decode(new byte[]{18, 12, 18, 9}, "2029f917", false)).toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{76, 91, 94, 65, 69, 5, 91, 17, 12, 77, 13, 92}, "9575e8f1b8a0", 0.0f));
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(strDecode.concat(C0000.decode(new byte[]{19, 21, 10, 12, 65, 88, 82, 19, 2, 6, 79}, "3aeca4")).toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(strDecode.concat(C0000.decode(new byte[]{17, 76, 9, 92, 67, 22, 14, 81, 89, 94, 25}, "18f3cec05277e06e", true)).toString());
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), C0000.decode(new byte[]{84, 90, 10, 23, 88, 14, 24, 87, 70, 13, 85}, "63e7e3893a926b", 0.0f))) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final int delimiterOffset(int i, int i2, String str, String str2) {
        while (i < i2) {
            if (StringsKt.contains$default(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final String format(String str, Object... objArr) {
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator comparator) {
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                int i = 0;
                while (true) {
                    if (i < strArr2.length) {
                        int i2 = i + 1;
                        try {
                            if (comparator.compare(str, strArr2[i]) == 0) {
                                return true;
                            }
                            i = i2;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new NoSuchElementException(e.getMessage());
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        String str = response.headers.get(C0000.decode(new byte[]{34, 13, 88, 77, 87, 95, 71, 79, 124, 0, 12, 87, 67, 93}, "ab69213b0eb075", 0.0f));
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List immutableListOf(Object... objArr) {
        Object[] objArr2 = (Object[]) objArr.clone();
        return Collections.unmodifiableList(CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(objArr2, objArr2.length)));
    }

    public static final int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Intrinsics.compare(cCharAt, 31) <= 0 || Intrinsics.compare(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i, int i2) {
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 != i) {
                    i3--;
                }
            }
        }
        return i;
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator comparator) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean isSensitiveHeader(String str) {
        return str.equalsIgnoreCase(C0000.decode(new byte[]{115, 23, 21, 13, 9, 69, 92, 75, 88, 77, 91, 13, 15}, "2baef75199", false)) || str.equalsIgnoreCase(C0000.decode(new byte[]{34, 11, 86, 95, 91, 92}, "ad94292520a908d3", false)) || str.equalsIgnoreCase(C0000.decode(new byte[]{99, 16, 90, 72, 74, 27, 112, 67, 66, 10, 9, 67, 90, 24, 84, 68, 90, 89, 95}, "3b5036166bf1", 0.0f)) || str.equalsIgnoreCase(C0000.decode(new byte[]{106, 6, 68, 79, 112, 94, 86, 8, 89, 7}, "9c0b31", 4));
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            return -1;
        }
        return c - '7';
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) {
        int iSelect = bufferedSource.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iSelect == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iSelect == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iSelect == 3) {
            Charset charset2 = Charsets.UTF_8;
            Charset charset3 = Charsets.utf_32be;
            if (charset3 != null) {
                return charset3;
            }
            Charset charsetForName = Charset.forName(C0000.decode(new byte[]{52, 99, 37, 73, 10, 83, 117, 118}, "a7cd9a7388"));
            Charsets.utf_32be = charsetForName;
            return charsetForName;
        }
        if (iSelect != 4) {
            throw new AssertionError();
        }
        Charset charset4 = Charsets.UTF_8;
        Charset charset5 = Charsets.utf_32le;
        if (charset5 != null) {
            return charset5;
        }
        Charset charsetForName2 = Charset.forName(C0000.decode(new byte[]{100, 98, 114, 76, 11, 86, 40, 33}, "164a8ddd9159eb", 7));
        Charsets.utf_32le = charsetForName2;
        return charsetForName2;
    }

    public static final int readMedium(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    public static final boolean skipAll(Source source, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(8192L, buffer) != -1) {
                buffer.skip(buffer.size);
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final Headers toHeaders(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            ByteString byteString = header.name;
            ByteString byteString2 = header.value;
            String strUtf8 = byteString.utf8();
            String strUtf9 = byteString2.utf8();
            arrayList.add(strUtf8);
            arrayList.add(StringsKt.trim(strUtf9).toString());
        }
        return new Headers((String[]) arrayList.toArray(new String[0]));
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        int i;
        int i2 = httpUrl.port;
        String str = httpUrl.host;
        if (StringsKt.contains$default(str, C0000.decode(new byte[]{15}, "593156c4864a", false))) {
            str = C0000.decode(new byte[]{98}, "983bc4a8f6c7f2f0", 0) + str + ']';
        }
        if (!z) {
            String str2 = httpUrl.scheme;
            if (str2.equals(C0000.decode(new byte[]{11, 65, 76, 67}, "c5835e4a686f", false))) {
                i = 80;
            } else {
                i = str2.equals(C0000.decode(new byte[]{90, 66, 23, 17, 21}, "26caffe58dffb7", 7)) ? 443 : -1;
            }
            if (i2 == i) {
                return str;
            }
        }
        return str + ':' + i2;
    }

    public static final int toNonNegativeInt(String str, int i) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final String trimSubstring(String str, int i, int i2) {
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i, i2);
        return str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i2));
    }

    public static final int delimiterOffset(String str, char c, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }
}
