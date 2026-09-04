package okhttp3.internal.http;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class HttpHeaders {
    static {
        Charset charset = Charsets.UTF_8;
        String strDecode = C0000.decode(new byte[]{26, 61}, "8a91b23bdb4ac0", false);
        new ByteString(strDecode.getBytes(charset)).utf8 = strDecode;
        Charset charset2 = Charsets.UTF_8;
        String strDecode2 = C0000.decode(new byte[]{56, 67, 78, 91}, "1cbfcae9", 0);
        new ByteString(strDecode2.getBytes(charset2)).utf8 = strDecode2;
    }

    public static final boolean promisesBody(Response response) {
        if (Intrinsics.areEqual((String) response.request.method, C0000.decode(new byte[]{46, 116, 112, 37}, "f11a64f7"))) {
            return false;
        }
        int i = response.code;
        if (((i < 100 || i >= 200) && i != 204 && i != 304) || Util.headersContentLength(response) != -1) {
            return true;
        }
        String str = response.headers.get(C0000.decode(new byte[]{49, 69, 80, 90, 68, 3, 0, 67, 27, 124, 11, 84, 94, 80, 94, 11, 2}, "e7147ee169"));
        if (str == null) {
            str = null;
        }
        return C0000.decode(new byte[]{80, 80, 76, 86, 14, 86, 87}, "3898e33779", 0.0f).equalsIgnoreCase(str);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:31:0x0093  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void receiveHeaders(HttpUrl.Companion companion, HttpUrl httpUrl, Headers headers) {
        int i;
        int i2;
        Cookie cookie;
        Cookie cookie2;
        if (companion == HttpUrl.Companion.NO_COOKIES) {
            return;
        }
        Pattern pattern = Cookie.YEAR_PATTERN;
        int size = headers.size();
        int i3 = 0;
        int i4 = 0;
        ArrayList arrayList = null;
        while (true) {
            i = 2;
            if (i4 >= size) {
                break;
            }
            if (C0000.decode(new byte[]{102, 92, 23, 20, 119, 89, 91, 9, 12, 4}, "59c9464beae47f", 0.0f).equalsIgnoreCase(headers.name(i4))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i4));
            }
            i4++;
        }
        List listUnmodifiableList = EmptyList.INSTANCE;
        List listUnmodifiableList2 = arrayList != null ? Collections.unmodifiableList(arrayList) : listUnmodifiableList;
        int size2 = listUnmodifiableList2.size();
        int i5 = 0;
        ArrayList arrayList2 = null;
        while (i5 < size2) {
            String str = (String) listUnmodifiableList2.get(i5);
            long jCurrentTimeMillis = System.currentTimeMillis();
            char c = ';';
            int iDelimiterOffset$default = Util.delimiterOffset$default(str, ';', i3, i3, 6);
            char c2 = '=';
            int iDelimiterOffset$default2 = Util.delimiterOffset$default(str, '=', i3, iDelimiterOffset$default, i);
            if (iDelimiterOffset$default2 == iDelimiterOffset$default) {
                i2 = i3;
                cookie = null;
            } else {
                String strTrimSubstring = Util.trimSubstring(str, i3, iDelimiterOffset$default2);
                if (strTrimSubstring.length() != 0 && Util.indexOfControlOrNonAscii(strTrimSubstring) == -1) {
                    String strTrimSubstring2 = Util.trimSubstring(str, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
                    if (Util.indexOfControlOrNonAscii(strTrimSubstring2) == -1) {
                        int i6 = iDelimiterOffset$default + 1;
                        int length = str.length();
                        long j = 253402300799999L;
                        int i7 = i3;
                        int i8 = i7;
                        boolean z = i8 == true ? 1 : 0;
                        long expires = 253402300799999L;
                        String str2 = null;
                        String str3 = null;
                        long j2 = -1;
                        boolean z2 = true;
                        boolean z3 = i8;
                        while (true) {
                            if (i6 >= length) {
                                if (j2 == Long.MIN_VALUE) {
                                    j = Long.MIN_VALUE;
                                } else if (j2 != -1) {
                                    long j3 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * ((long) 1000) : Long.MAX_VALUE);
                                    if (j3 >= jCurrentTimeMillis && j3 <= 253402300799999L) {
                                        j = j3;
                                    }
                                } else {
                                    j = expires;
                                }
                                String str4 = httpUrl.host;
                                if (str2 != null) {
                                    if (!Intrinsics.areEqual(str4, str2) && (!str4.endsWith(str2) || str4.charAt((str4.length() - str2.length()) - 1) != '.' || ((Pattern) Util.VERIFY_AS_IP_ADDRESS.nativePattern).matcher(str4).matches())) {
                                        i2 = 0;
                                        cookie2 = null;
                                    }
                                    cookie = cookie2;
                                    break;
                                }
                                str2 = str4;
                                if (str4.length() != str2.length()) {
                                    PublicSuffixDatabase.Companion.getClass();
                                    if (PublicSuffixDatabase.instance.getEffectiveTldPlusOne(str2) == null) {
                                        i2 = 0;
                                        cookie2 = null;
                                    }
                                    cookie = cookie2;
                                    break;
                                }
                                String strDecode = C0000.decode(new byte[]{75}, "d8fa718ad5", 0.0f);
                                if (str3 == null || !str3.startsWith(strDecode)) {
                                    String strEncodedPath = httpUrl.encodedPath();
                                    i2 = 0;
                                    int iLastIndexOf$default = StringsKt.lastIndexOf$default(strEncodedPath, '/', 0, 6);
                                    if (iLastIndexOf$default != 0) {
                                        strDecode = strEncodedPath.substring(0, iLastIndexOf$default);
                                    }
                                    str3 = strDecode;
                                } else {
                                    i2 = 0;
                                }
                                cookie2 = new Cookie(strTrimSubstring, strTrimSubstring2, j, str2, str3, z ? 1 : 0, i7, z3, z2);
                                cookie = cookie2;
                                break;
                            }
                            int iDelimiterOffset = Util.delimiterOffset(str, c, i6, length);
                            int iDelimiterOffset2 = Util.delimiterOffset(str, c2, i6, iDelimiterOffset);
                            String strTrimSubstring3 = Util.trimSubstring(str, i6, iDelimiterOffset2);
                            String strTrimSubstring4 = iDelimiterOffset2 < iDelimiterOffset ? Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
                            if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{86, 30, 71, 80, 74, 81, 17}, "3f7984b5ef39", false))) {
                                try {
                                    expires = ResultKt.parseExpires(strTrimSubstring4, strTrimSubstring4.length());
                                    z3 = 1;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{95, 82, 74, 24, 80, 2, 4}, "23251ea7410a5c"))) {
                                try {
                                    j2 = Long.parseLong(strTrimSubstring4);
                                    if (j2 <= 0) {
                                        j2 = Long.MIN_VALUE;
                                    }
                                } catch (NumberFormatException e) {
                                    if (!Pattern.compile(C0000.decode(new byte[]{24, 94, 109, 81, 72}, "5a15c8c01deaaac9", 3)).matcher(strTrimSubstring4).matches()) {
                                        throw e;
                                    }
                                    j2 = strTrimSubstring4.startsWith(C0000.decode(new byte[]{29}, "0e37cd", 0)) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                }
                                z3 = 1;
                            } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{81, 10, 85, 0, 93, 95}, "5e8a41ffac"))) {
                                String strDecode2 = C0000.decode(new byte[]{27}, "5d01931e2f86a69f", true);
                                if (strTrimSubstring4.endsWith(strDecode2)) {
                                    throw new IllegalArgumentException(C0000.decode(new byte[]{127, 7, 94, 93, 86, 93, 16, 71, 1, 72, 20, 12, 75, 83, 94, 80, 87, 18, 25}, "9f713905d9ae9635"));
                                }
                                if (strTrimSubstring4.startsWith(strDecode2)) {
                                    strTrimSubstring4 = strTrimSubstring4.substring(strDecode2.length());
                                }
                                String canonicalHost = ExceptionsKt.toCanonicalHost(strTrimSubstring4);
                                if (canonicalHost == null) {
                                    throw new IllegalArgumentException();
                                }
                                str2 = canonicalHost;
                                z2 = false;
                            } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{68, 80, 70, 94}, "4126667a0a", 0.0f))) {
                                str3 = strTrimSubstring4;
                            } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{74, 81, 84, 76, 74, 4}, "94798a13d1c89c", false))) {
                                z = true;
                            } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{80, 23, 17, 64, 86, 89, 14, 31}, "8ce097bf"))) {
                                i7 = 1;
                            }
                            i6 = iDelimiterOffset + 1;
                            c = ';';
                            c2 = '=';
                            z3 = z3;
                            z = z;
                        }
                    } else {
                        i2 = i3;
                        cookie = null;
                    }
                } else {
                    i2 = i3;
                    cookie = null;
                }
            }
            if (cookie != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(cookie);
            }
            i5++;
            i3 = i2;
            i = 2;
        }
        if (arrayList2 != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        }
        listUnmodifiableList.isEmpty();
    }
}
