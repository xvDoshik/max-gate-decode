package okhttp3.internal.tls;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.ExceptionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    public static List getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
        } catch (CertificateParsingException unused) {
        }
        return EmptyList.INSTANCE;
    }

    public static boolean isAscii(String str) {
        int i;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{92, 8, 85, 113, 87, 87, 86, 26, 69, 11, 65, 81, 92, 84, 92, 10, 112, 8, 85, 93, 65, 9, 19}, "9f18933be7a3935d"), C0000.decode(new byte[]{24, 13, 17, 7}, "81172bab"), length2).toString());
        }
        if (length2 > str.length()) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{92, 15, 0, 127, 89, 83, 87, 29, 24, 15, 20, 69, 76, 69, 80, 15, 3, 24, 91, 82, 92, 2, 76, 89, 14, 22}, "9ad6772e814687") + length2 + C0000.decode(new byte[]{70, 6, 24}, "f88581") + str.length()).toString());
        }
        long j = 0;
        int i2 = 0;
        while (i2 < length2) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i = 3;
                } else {
                    int i3 = i2 + 1;
                    char cCharAt2 = i3 < length2 ? str.charAt(i3) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i2 = i3;
                    } else {
                        j += (long) 4;
                        i2 += 2;
                    }
                }
                j += (long) i;
            }
            i2++;
        }
        return length == ((int) j);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x011f  */
    public static boolean verify(String str, X509Certificate x509Certificate) {
        boolean zAreEqual;
        int length;
        if (((Pattern) Util.VERIFY_AS_IP_ADDRESS.nativePattern).matcher(str).matches()) {
            String canonicalHost = ExceptionsKt.toCanonicalHost(str);
            List subjectAltNames = getSubjectAltNames(x509Certificate, 7);
            if (!subjectAltNames.isEmpty()) {
                Iterator it = subjectAltNames.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(canonicalHost, ExceptionsKt.toCanonicalHost((String) it.next()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (isAscii(str)) {
            str = str.toLowerCase(Locale.US);
        }
        List<String> subjectAltNames2 = getSubjectAltNames(x509Certificate, 2);
        if (!subjectAltNames2.isEmpty()) {
            for (String str2 : subjectAltNames2) {
                if (str.length() == 0) {
                    zAreEqual = false;
                } else {
                    String strDecode = C0000.decode(new byte[]{22}, "81cd41d8bdc7", 3);
                    if (str.startsWith(strDecode)) {
                        zAreEqual = false;
                    } else {
                        String strDecode2 = C0000.decode(new byte[]{24, 27}, "65dfeaa632");
                        if (str.endsWith(strDecode2) || str2 == null || str2.length() == 0 || str2.startsWith(strDecode) || str2.endsWith(strDecode2)) {
                            zAreEqual = false;
                        } else {
                            String strConcat = !str.endsWith(strDecode) ? str.concat(strDecode) : str;
                            boolean zEndsWith = str2.endsWith(strDecode);
                            String strConcat2 = str2;
                            if (!zEndsWith) {
                                strConcat2 = str2.concat(strDecode);
                            }
                            boolean zIsAscii = isAscii(strConcat2);
                            String lowerCase = strConcat2;
                            if (zIsAscii) {
                                lowerCase = strConcat2.toLowerCase(Locale.US);
                            }
                            if (StringsKt.contains$default(lowerCase, C0000.decode(new byte[]{29}, "7f226d6fa110", 0))) {
                                String strDecode3 = C0000.decode(new byte[]{25, 75}, "3e65e3", 7);
                                if (!lowerCase.startsWith(strDecode3) || StringsKt.indexOf$default((CharSequence) lowerCase, '*', 1, 4) != -1 || strConcat.length() < lowerCase.length() || strDecode3.equals(lowerCase)) {
                                    zAreEqual = false;
                                } else {
                                    String strSubstring = lowerCase.substring(1);
                                    if (strConcat.endsWith(strSubstring) && ((length = strConcat.length() - strSubstring.length()) <= 0 || StringsKt.lastIndexOf$default(strConcat, '.', length - 1, 4) == -1)) {
                                        zAreEqual = true;
                                    } else {
                                        zAreEqual = false;
                                    }
                                }
                            } else {
                                zAreEqual = Intrinsics.areEqual(strConcat, lowerCase);
                            }
                        }
                    }
                }
                if (zAreEqual) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        if (isAscii(str)) {
            try {
                return verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            } catch (SSLException unused) {
            }
        }
        return false;
    }
}
