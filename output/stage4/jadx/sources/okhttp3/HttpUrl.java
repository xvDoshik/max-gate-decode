package okhttp3;

import androidx.tracing.Trace;
import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.Buffer;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class HttpUrl {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String fragment;
    public final String host;
    public final boolean isHttps;
    public final String password;
    public final int port;
    public final List queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    public final class Builder {
        public String encodedFragment;
        public final ArrayList encodedPathSegments;
        public ArrayList encodedQueryNamesAndValues;
        public String host;
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{23, 82, 90, 7, 95, 0, 65, 89, 94, 66, 10, 68, 94, 14}, "d12b2eadcb"));
            }
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(this.encodedUsername, 0, 0, 7);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(this.encodedPassword, 0, 0, 7);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{81, 9, 66, 16, 23, 92, 10, 24, 10, 66, 85, 10}, "9f1d7a78d7"));
            }
            int iEffectivePort = effectivePort();
            ArrayList arrayList2 = this.encodedPathSegments;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2));
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                arrayList3.add(Companion.percentDecode$okhttp$default((String) obj, 0, 0, 7));
            }
            ArrayList arrayList4 = this.encodedQueryNamesAndValues;
            if (arrayList4 != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4));
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    String str3 = (String) obj2;
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(str3, 0, 0, 3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(str4, 0, 0, 7) : null, toString());
        }

        public final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            String str = this.scheme;
            if (str.equals(C0000.decode(new byte[]{80, 64, 65, 68}, "8454ebb12a97"))) {
                return 80;
            }
            return str.equals(C0000.decode(new byte[]{95, 70, 76, 71, 64}, "72873a", 0.0f)) ? 443 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0079  */
        public final void parse$okhttp(HttpUrl httpUrl, String str) {
            int i;
            String str2;
            int i2;
            int iDelimiterOffset;
            int i3;
            int i4;
            char cCharAt;
            String str3 = str;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int iIndexOfFirstNonAsciiWhitespace = Util.indexOfFirstNonAsciiWhitespace(str3, 0, str3.length());
            int iIndexOfLastNonAsciiWhitespace = Util.indexOfLastNonAsciiWhitespace(str3, iIndexOfFirstNonAsciiWhitespace, str3.length());
            byte b = -1;
            if (iIndexOfLastNonAsciiWhitespace - iIndexOfFirstNonAsciiWhitespace >= 2) {
                char cCharAt2 = str3.charAt(iIndexOfFirstNonAsciiWhitespace);
                if ((Intrinsics.compare(cCharAt2, 97) >= 0 && Intrinsics.compare(cCharAt2, 122) <= 0) || (Intrinsics.compare(cCharAt2, 65) >= 0 && Intrinsics.compare(cCharAt2, 90) <= 0)) {
                    int i5 = iIndexOfFirstNonAsciiWhitespace + 1;
                    while (true) {
                        if (i5 < iIndexOfLastNonAsciiWhitespace) {
                            char cCharAt3 = str3.charAt(i5);
                            if (('a' <= cCharAt3 && cCharAt3 < '{') || (('A' <= cCharAt3 && cCharAt3 < '[') || (('0' <= cCharAt3 && cCharAt3 < ':') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                                i5++;
                            } else if (cCharAt3 == ':') {
                                i = i5;
                                break;
                            }
                        }
                        i = -1;
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
            String strDecode = C0000.decode(new byte[]{14, 23, 68, 21}, "fc0ef6");
            String strDecode2 = C0000.decode(new byte[]{11, 67, 23, 70, 75}, "c7c68f8c03da5d", true);
            int i6 = 1;
            if (i != -1) {
                str2 = strDecode2;
                if (str3.regionMatches(true, iIndexOfFirstNonAsciiWhitespace, C0000.decode(new byte[]{10, 67, 70, 19, 75, 3}, "b72c89", 7), 0, 6)) {
                    this.scheme = str2;
                    iIndexOfFirstNonAsciiWhitespace += 6;
                    str3 = str;
                } else {
                    str3 = str;
                    if (!str3.regionMatches(true, iIndexOfFirstNonAsciiWhitespace, C0000.decode(new byte[]{92, 18, 69, 18, 91}, "4f1ba055"), 0, 5)) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{125, 76, 70, 93, 90, 71, 1, 1, 16, 96, 101, 45, 20, 64, 91, 92, 83, 85, 92, 19, 67, 13, 68, 65, 71, 70, 20, 92, 74, 20, 17, 80, 77, 71, 20, 22, 23, 21, 85, 20, 64, 19, 79, 85, 69, 24, 30}, "846893de057a43", true) + str3.substring(0, i) + '\'');
                    }
                    this.scheme = strDecode;
                    iIndexOfFirstNonAsciiWhitespace += 5;
                }
            } else {
                str2 = strDecode2;
                if (httpUrl == null) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{35, 79, 18, 92, 86, 21, 3, 83, 66, 108, 103, 45, 70, 68, 1, 81, 80, 12, 3, 23, 69, 81, 65, 21, 22, 16, 66, 86, 71, 65, 65, 95, 22, 77, 69, 18, 65, 23, 0, 76, 65, 65, 8, 88, 66, 74, 86, 9, 3, 90, 7, 25, 66, 0, 21, 23, 4, 86, 64, 15, 2, 23, 4, 86, 71, 65}, "f7b95a") + (str3.length() > 6 ? StringsKt.take(str3, 6).concat(C0000.decode(new byte[]{72, 75, 75}, "fee9282f9988c4cb")) : str3));
                }
                this.scheme = httpUrl.scheme;
            }
            int i7 = iIndexOfFirstNonAsciiWhitespace;
            int i8 = 0;
            while (true) {
                i2 = i6;
                if (i7 >= iIndexOfLastNonAsciiWhitespace || !((cCharAt = str3.charAt(i7)) == '\\' || cCharAt == '/')) {
                    break;
                }
                i8++;
                i7++;
                i6 = i2;
            }
            String strDecode3 = C0000.decode(new byte[]{69, 21, 68, 15, 11, 21}, "e7c356b656");
            ArrayList arrayList = this.encodedPathSegments;
            byte b2 = 35;
            if (i8 >= 2 || httpUrl == null || !Intrinsics.areEqual(httpUrl.scheme, this.scheme)) {
                int i9 = iIndexOfFirstNonAsciiWhitespace + i8;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(i9, iIndexOfLastNonAsciiWhitespace, str3, C0000.decode(new byte[]{34, 27, 104, 8, 19}, "b44702305fb60eb5"));
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace ? str3.charAt(iDelimiterOffset) : b;
                    if (bCharAt == b || bCharAt == b2 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        String strDecode4 = C0000.decode(new byte[]{24, 65, 16, 3, 9, 93, 8, 93, 35, 63, 56, 63, 88, 24, 74, 69, 29, 61, 10, 64}, "8c792a5ccdea", 3);
                        String strDecode5 = C0000.decode(new byte[]{18, 3, 3}, "773683aa40077b86", true);
                        if (i10 == 0) {
                            int iDelimiterOffset2 = Util.delimiterOffset(str3, ':', i9, iDelimiterOffset);
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(str3, i9, iDelimiterOffset2, strDecode4, 240);
                            if (i11 != 0) {
                                strCanonicalize$okhttp$default = this.encodedUsername + strDecode5 + strCanonicalize$okhttp$default;
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(str3, iDelimiterOffset2 + 1, iDelimiterOffset, strDecode4, 240);
                                i10 = i2;
                            }
                            i11 = i2;
                        } else {
                            this.encodedPassword += strDecode5 + Companion.canonicalize$okhttp$default(str3, i9, iDelimiterOffset, strDecode4, 240);
                        }
                        i9 = iDelimiterOffset + 1;
                        b = -1;
                        b2 = 35;
                    }
                }
                int i12 = i9;
                while (true) {
                    if (i12 >= iDelimiterOffset) {
                        i12 = iDelimiterOffset;
                        break;
                    }
                    char cCharAt4 = str3.charAt(i12);
                    if (cCharAt4 == '[') {
                        do {
                            i12++;
                            if (i12 >= iDelimiterOffset) {
                                break;
                            }
                        } while (str3.charAt(i12) != ']');
                    } else if (cCharAt4 == ':') {
                        break;
                    }
                    i12++;
                }
                int i13 = i12 + 1;
                if (i13 < iDelimiterOffset) {
                    this.host = ExceptionsKt.toCanonicalHost(Companion.percentDecode$okhttp$default(str3, i9, i12, 4));
                    try {
                        i4 = Integer.parseInt(Companion.canonicalize$okhttp$default(str3, i13, iDelimiterOffset, "", 248));
                        if (i2 > i4 || i4 >= 65536) {
                            i4 = -1;
                        }
                    } catch (NumberFormatException unused) {
                    }
                    this.port = i4;
                    if (i4 == -1) {
                        throw new IllegalArgumentException((C0000.decode(new byte[]{121, 92, 67, 7, 95, 93, 0, 22, 100, 107, 117, 69, 65, 88, 74, 69, 10, 18, 23}, "025f34d6199e1781", 0.0f) + str3.substring(i13, iDelimiterOffset) + '\"').toString());
                    }
                } else {
                    this.host = ExceptionsKt.toCanonicalHost(Companion.percentDecode$okhttp$default(str3, i9, i12, 4));
                    String str4 = this.scheme;
                    if (str4.equals(strDecode)) {
                        i3 = 80;
                    } else {
                        i3 = str4.equals(str2) ? 443 : -1;
                    }
                    this.port = i3;
                }
                if (this.host == null) {
                    throw new IllegalArgumentException((C0000.decode(new byte[]{44, 12, 69, 2, 95, 89, 7, 21, 99, 100, 41, 66, 91, 12, 64, 68, 89, 21, 20}, "eb3c30c566", true) + str3.substring(i9, i12) + '\"').toString());
                }
                iIndexOfFirstNonAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                arrayList.clear();
                arrayList.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace == iIndexOfLastNonAsciiWhitespace || str3.charAt(iIndexOfFirstNonAsciiWhitespace) == '#') {
                    String strEncodedQuery = httpUrl.encodedQuery();
                    this.encodedQueryNamesAndValues = strEncodedQuery != null ? Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(strEncodedQuery, 0, 0, strDecode3, 211)) : null;
                }
            }
            int iDelimiterOffset3 = Util.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iIndexOfLastNonAsciiWhitespace, str3, C0000.decode(new byte[]{90, 26}, "e9e934", 3));
            if (iIndexOfFirstNonAsciiWhitespace != iDelimiterOffset3) {
                char cCharAt5 = str3.charAt(iIndexOfFirstNonAsciiWhitespace);
                if (cCharAt5 == '/' || cCharAt5 == '\\') {
                    arrayList.clear();
                    arrayList.add("");
                    iIndexOfFirstNonAsciiWhitespace++;
                } else {
                    arrayList.set(arrayList.size() - 1, "");
                }
                while (iIndexOfFirstNonAsciiWhitespace < iDelimiterOffset3) {
                    int iDelimiterOffset4 = Util.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset3, str3, C0000.decode(new byte[]{23, 106}, "863ee82c"));
                    boolean z = iDelimiterOffset4 < iDelimiterOffset3;
                    String strCanonicalize$okhttp$default2 = Companion.canonicalize$okhttp$default(str3, iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset4, C0000.decode(new byte[]{23, 20, 4, 14, 60, 84, 76, 75, 68, 31, 62, 11, 20}, "7680b4"), 240);
                    if (!strCanonicalize$okhttp$default2.equals(C0000.decode(new byte[]{76}, "b07e6d2e3e021f", 0.0f)) && !strCanonicalize$okhttp$default2.equalsIgnoreCase(C0000.decode(new byte[]{16, 81, 87}, "5c2bd73f88", 1))) {
                        if (!strCanonicalize$okhttp$default2.equals(C0000.decode(new byte[]{76, 28}, "b26c2d2dec")) && !strCanonicalize$okhttp$default2.equalsIgnoreCase(C0000.decode(new byte[]{28, 1, 81, 72}, "934fdcdf7a", false)) && !strCanonicalize$okhttp$default2.equalsIgnoreCase(C0000.decode(new byte[]{28, 21, 84, 86}, "20f3720d", true)) && !strCanonicalize$okhttp$default2.equalsIgnoreCase(C0000.decode(new byte[]{28, 11, 3, 64, 80, 3}, "99febf3ce04f2247", 7))) {
                            if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
                                arrayList.set(arrayList.size() - 1, strCanonicalize$okhttp$default2);
                            } else {
                                arrayList.add(strCanonicalize$okhttp$default2);
                            }
                            if (z) {
                                arrayList.add("");
                            }
                        } else if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                            arrayList.add("");
                        } else {
                            arrayList.set(arrayList.size() - 1, "");
                        }
                    }
                    iIndexOfFirstNonAsciiWhitespace = z ? iDelimiterOffset4 + 1 : iDelimiterOffset4;
                }
            }
            if (iDelimiterOffset3 < iIndexOfLastNonAsciiWhitespace && str3.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset5 = Util.delimiterOffset(str3, '#', iDelimiterOffset3, iIndexOfLastNonAsciiWhitespace);
                this.encodedQueryNamesAndValues = Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(str3, iDelimiterOffset3 + 1, iDelimiterOffset5, strDecode3, 208));
                iDelimiterOffset3 = iDelimiterOffset5;
            }
            if (iDelimiterOffset3 >= iIndexOfLastNonAsciiWhitespace || str3.charAt(iDelimiterOffset3) != '#') {
                return;
            }
            this.encodedFragment = Companion.canonicalize$okhttp$default(str3, iDelimiterOffset3 + 1, iIndexOfLastNonAsciiWhitespace, "", 176);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x00c0  */
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append(C0000.decode(new byte[]{91, 29, 28}, "a23ef0", 0.0f));
            } else {
                sb.append(C0000.decode(new byte[]{73, 27}, "f47f7e", true));
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (StringsKt.contains$default((CharSequence) str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            int i = -1;
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                } else {
                    if (str3.equals(C0000.decode(new byte[]{14, 23, 65, 18}, "fc5b5d67c6a96025"))) {
                        i = 80;
                    } else if (str3.equals(C0000.decode(new byte[]{93, 69, 18, 22, 67}, "51ff0dd945", true))) {
                        i = 443;
                    }
                    if (iEffectivePort != i) {
                        sb.append(':');
                        sb.append(iEffectivePort);
                    }
                }
            }
            ArrayList arrayList = this.encodedPathSegments;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append((String) arrayList.get(i2));
            }
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                ArrayList arrayList2 = this.encodedQueryNamesAndValues;
                IntProgression intProgressionStep = Trace.step(Trace.until(0, arrayList2.size()), 2);
                int i3 = intProgressionStep.first;
                int i4 = intProgressionStep.last;
                int i5 = intProgressionStep.step;
                if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                    while (true) {
                        String str4 = (String) arrayList2.get(i3);
                        String str5 = (String) arrayList2.get(i3 + 1);
                        if (i3 > 0) {
                            sb.append('&');
                        }
                        sb.append(str4);
                        if (str5 != null) {
                            sb.append('=');
                            sb.append(str5);
                        }
                        if (i3 == i4) {
                            break;
                        }
                        i3 += i5;
                    }
                }
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }
    }

    public final class Companion {
        public static final Companion NONE = new Companion();
        public static final Companion NO_COOKIES = new Companion();
        public static final Companion SYSTEM = new Companion();

        public static final CipherSuite access$init(Companion companion, String str) {
            CipherSuite cipherSuite = new CipherSuite(str);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        public static String canonicalize$okhttp$default(String str, int i, int i2, String str2, int i3) throws EOFException {
            int i4 = 0;
            int i5 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? str.length() : i2;
            boolean z = (i3 & 8) == 0;
            boolean z2 = (i3 & 16) == 0;
            boolean z3 = (i3 & 32) == 0;
            boolean z4 = (i3 & 64) == 0;
            int iCharCount = i5;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                int i6 = 32;
                int i7 = 43;
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || StringsKt.contains$default(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z || (z2 && !isPercentEncoded(str, iCharCount, length)))) || (iCodePointAt == 43 && z3)))) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i5, iCharCount);
                    Buffer buffer2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = str.codePointAt(iCharCount);
                        if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 == i7 && z3) {
                                String strDecode = z ? C0000.decode(new byte[]{24}, "3a15a515b7ef4ea4", 0) : C0000.decode(new byte[]{64, 81, 118}, "ec49bf");
                                buffer.writeUtf8(strDecode, i4, strDecode.length());
                            } else {
                                if (iCodePointAt2 >= i6 && iCodePointAt2 != 127) {
                                    if ((iCodePointAt2 < 128 || z4) && !StringsKt.contains$default(str2, (char) iCodePointAt2) && (iCodePointAt2 != 37 || (z && (!z2 || isPercentEncoded(str, iCharCount, length))))) {
                                        buffer.writeUtf8CodePoint(iCodePointAt2);
                                    }
                                }
                                if (buffer2 == null) {
                                    buffer2 = new Buffer();
                                }
                                buffer2.writeUtf8CodePoint(iCodePointAt2);
                                while (!buffer2.exhausted()) {
                                    byte b = buffer2.readByte();
                                    buffer.m23writeByte(37);
                                    char[] cArr = HttpUrl.HEX_DIGITS;
                                    buffer.m23writeByte((int) cArr[((b & 255) >> 4) & 15]);
                                    buffer.m23writeByte((int) cArr[b & 15]);
                                }
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i4 = 0;
                        i6 = 32;
                        i7 = 43;
                    }
                    return buffer.readUtf8();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            return str.substring(i5, length);
        }

        public static boolean isPercentEncoded(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1 && Util.parseHexDigit(str.charAt(i3)) != -1;
        }

        public static String percentDecode$okhttp$default(String str, int i, int i2, int i3) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            boolean z = (i3 & 4) == 0;
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, iCharCount);
                    while (iCharCount < i2) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int hexDigit = Util.parseHexDigit(str.charAt(iCharCount + 1));
                            int hexDigit2 = Util.parseHexDigit(str.charAt(i4));
                            if (hexDigit == -1 || hexDigit2 == -1) {
                                buffer.writeUtf8CodePoint(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                buffer.m23writeByte((hexDigit << 4) + hexDigit2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            }
                        } else if (iCodePointAt == 43 && z) {
                            buffer.m23writeByte(32);
                            iCharCount++;
                        } else {
                            buffer.writeUtf8CodePoint(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer.readUtf8();
                }
                iCharCount++;
            }
            return str.substring(i, i2);
        }

        public static ArrayList toQueryNamesAndValues$okhttp(String str) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '&', i, 4);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '=', i, 4);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                    arrayList.add(str.substring(i, iIndexOf$default));
                    arrayList.add(null);
                } else {
                    arrayList.add(str.substring(i, iIndexOf$default2));
                    arrayList.add(str.substring(iIndexOf$default2 + 1, iIndexOf$default));
                }
                i = iIndexOf$default + 1;
            }
            return arrayList;
        }

        public synchronized CipherSuite forJavaName(String str) {
            CipherSuite cipherSuite;
            String strConcat;
            try {
                LinkedHashMap linkedHashMap = CipherSuite.INSTANCES;
                cipherSuite = (CipherSuite) linkedHashMap.get(str);
                if (cipherSuite == null) {
                    String strDecode = C0000.decode(new byte[]{100, 102, 46, 103}, "75b8f930eac7721d", false);
                    String strDecode2 = C0000.decode(new byte[]{48, 116, 103, 60}, "d84c55e236b6", 0.0f);
                    if (str.startsWith(strDecode2)) {
                        strConcat = strDecode.concat(str.substring(4));
                    } else {
                        strConcat = str.startsWith(strDecode) ? strDecode2.concat(str.substring(4)) : str;
                    }
                    cipherSuite = (CipherSuite) linkedHashMap.get(strConcat);
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(str);
                    }
                    linkedHashMap.put(str, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, ArrayList arrayList, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.queryNamesAndValues = arrayList;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = Intrinsics.areEqual(str, C0000.decode(new byte[]{9, 66, 18, 70, 21}, "a6f6f974027506", false));
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return str.substring(StringsKt.indexOf$default((CharSequence) str, ':', length, 4) + 1, StringsKt.indexOf$default((CharSequence) str, '@', 0, 6));
    }

    public final String encodedPath() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', length, 4);
        return str.substring(iIndexOf$default, Util.delimiterOffset(iIndexOf$default, str.length(), str, C0000.decode(new byte[]{9, 19}, "60d967")));
    }

    public final ArrayList encodedPathSegments() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', length, 4);
        int iDelimiterOffset = Util.delimiterOffset(iIndexOf$default, str.length(), str, C0000.decode(new byte[]{90, 64}, "ec9c3e1c3f", true));
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iDelimiterOffset) {
            int i = iIndexOf$default + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(str, '/', i, iDelimiterOffset);
            arrayList.add(str.substring(i, iDelimiterOffset2));
            iIndexOf$default = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '?', 0, 6) + 1;
        return str.substring(iIndexOf$default, Util.delimiterOffset(str, '#', iIndexOf$default, str.length()));
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String strDecode = C0000.decode(new byte[]{9, 114}, "32258dfb2fb7dc");
        String str = this.url;
        return str.substring(length, Util.delimiterOffset(length, str.length(), str, strDecode));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) obj).url, this.url);
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String redact() {
        Builder builder;
        String strDecode = C0000.decode(new byte[]{31, 30, 75, 31}, "00e1b3ef02");
        try {
            builder = new Builder();
            builder.parse$okhttp(this, strDecode);
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        builder.getClass();
        String strDecode2 = C0000.decode(new byte[]{17, 26, 18, 95, 13, 13, 15, 92, 116, 63, 108, 102, 85, 29, 76, 68, 26, 57, 9, 18}, "185e612b4d185f", false);
        builder.encodedUsername = Companion.canonicalize$okhttp$default("", 0, 0, strDecode2, 251);
        builder.encodedPassword = Companion.canonicalize$okhttp$default("", 0, 0, strDecode2, 251);
        return builder.build().url;
    }

    public final String toString() {
        return this.url;
    }

    public final URI uri() {
        String strSubstring;
        Builder builder = new Builder();
        String str = this.scheme;
        builder.scheme = str;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        int i = str.equals(C0000.decode(new byte[]{94, 77, 16, 70}, "69d6097c", 0.0f)) ? 80 : str.equals(C0000.decode(new byte[]{91, 70, 66, 18, 66}, "326b1e77da7e5486", true)) ? 443 : -1;
        int i2 = this.port;
        builder.port = i2 != i ? i2 : -1;
        ArrayList arrayList = builder.encodedPathSegments;
        arrayList.clear();
        arrayList.addAll(encodedPathSegments());
        String strEncodedQuery = encodedQuery();
        builder.encodedQueryNamesAndValues = strEncodedQuery != null ? Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(strEncodedQuery, 0, 0, C0000.decode(new byte[]{20, 16, 16, 88, 93, 18}, "427dc129d45735c9"), 211)) : null;
        if (this.fragment == null) {
            strSubstring = null;
        } else {
            String str2 = this.url;
            strSubstring = str2.substring(StringsKt.indexOf$default((CharSequence) str2, '#', 0, 6) + 1);
        }
        builder.encodedFragment = strSubstring;
        String str3 = builder.host;
        builder.host = str3 != null ? Pattern.compile(C0000.decode(new byte[]{62, 27, 9, 8, 60, 86, 30, 69, 72, 107}, "e956b6", true)).matcher(str3).replaceAll("") : null;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.set(i3, Companion.canonicalize$okhttp$default((String) arrayList.get(i3), 0, 0, C0000.decode(new byte[]{106, 56}, "1efd047205e6e3", true), 227));
        }
        ArrayList arrayList2 = builder.encodedQueryNamesAndValues;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                String str4 = (String) arrayList2.get(i4);
                arrayList2.set(i4, str4 != null ? Companion.canonicalize$okhttp$default(str4, 0, 0, C0000.decode(new byte[]{111, 109, 82, 75, 68, 76}, "33208179f34643b2", 0.0f), 195) : null);
            }
        }
        String str5 = builder.encodedFragment;
        builder.encodedFragment = str5 != null ? Companion.canonicalize$okhttp$default(str5, 0, 0, C0000.decode(new byte[]{68, 18, 17, 93, 8, 110, 110, 88, 76, 26, 25}, "d02a62087f", 0.0f), 163) : null;
        String string = builder.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(Pattern.compile(C0000.decode(new byte[]{57, 63, 68, 86, 86, 9, 82, 78, 109, 19, 86, 9, 83, 37, 109, 19, 86, 9, 85, 37, 28, 58, 19, 9, 82, 90, 119, 58, 22, 66, 8, 2, 71, 7, 49, 81, 11, 23, 84, 21, 22, 88, 1, 6, 76, 59}, "bc1ff9", false)).matcher(string).replaceAll(""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }
}
