package com.google.android.datatransport.cct;

import com.google.android.datatransport.Encoding;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CCTDestination {
    public static final String DEFAULT_END_POINT = ResultKt.mergeStrings(C0000.decode(new byte[]{11, 64, 23, 27, 87, 64, 91, 68, 10, 6, 15, 1, 94, 95, 14, 81, 10, 26, 11, 27, 1, 81, 85, 80, 4, 21, 14, 0, 75, 81, 95, 67, 13, 68, 11, 91}, "c4d41297faff90b0", 0.0f), C0000.decode(new byte[]{17, 21, 91, 23, 8, 1, 4, 0, 14, 95, 15, 74, 10, 2, 4, 72, 18, 7, 8, 19, 2, 23, 14, 75, 4, 6, 94, 87, 12, 16, 15, 10, 62, 74, 21, 87}, "eea8ad", false));
    public static final CCTDestination LEGACY_INSTANCE;
    public static final Set SUPPORTED_ENCODINGS;
    public final String apiKey;
    public final String endPoint;

    static {
        String strMergeStrings = ResultKt.mergeStrings(C0000.decode(new byte[]{12, 21, 70, 29, 87, 64, 6, 68, 89, 82, 92, 80, 71, 31, 11, 6, 80, 66, 66, 81, 9, 65, 26, 92, 80, 88, 24, 84, 5, 24, 87, 70, 89, 93}, "da5212d7555771", false), C0000.decode(new byte[]{66, 17, 3, 30, 10, 85, 3, 93, 9, 84, 91, 75, 5, 86, 89, 13, 88, 88, 77, 95, 77, 9, 0, 65, 89, 1, 8, 86, 85, 78, 88, 82, 15, 87}, "6a91c0b8f35fd1"));
        String strMergeStrings2 = ResultKt.mergeStrings(C0000.decode(new byte[]{120, 27, 53, 38, 14, 11, 12, 11, 112, 22, 74, 45, 28, 46, 1, 87, 123, 1, 75, 14}, "9afeeb491a", 7), C0000.decode(new byte[]{113, 5, 29, 90, 9, 42, 89, 98, 106, 122, 87, 35, 112, 94, 9, 5, 35, 86, 41}, "8dd9bb0885ff62", true));
        SUPPORTED_ENCODINGS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding(C0000.decode(new byte[]{68, 17, 91, 66, 13}, "4c46b40d", 5)), new Encoding(C0000.decode(new byte[]{83, 71, 92, 93}, "943304", false)))));
        LEGACY_INSTANCE = new CCTDestination(strMergeStrings, strMergeStrings2);
    }

    public CCTDestination(String str, String str2) {
        this.endPoint = str;
        this.apiKey = str2;
    }

    public static CCTDestination fromByteArray(byte[] bArr) {
        String str = new String(bArr, Charset.forName(C0000.decode(new byte[]{55, 49, 117, 76, 12}, "be3a4d92ba908d", false)));
        if (!str.startsWith(C0000.decode(new byte[]{9, 22}, "825e18074e46d690", 0))) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{99, 87, 16, 71, 88, 91, 94, 66, 84, 84, 16, 83, 83, 20, 18, 95, 92, 65, 17, 93, 95, 83, 16, 4, 75, 90, 15, 24, 83, 30, 70, 64, 84, 65}, "52b4140b95b86f22", 0.0f));
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote(C0000.decode(new byte[]{111}, "3b5f637de4", 0.0f)), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{35, 26, 66, 75, 84, 22, 95, 66, 24, 89, 9, 22, 22, 88, 21, 64, 87, 93, 81, 83, 70, 7, 88, 90, 90, 82, 83, 85, 24, 123, 3, 5, 87, 90, 76, 112, 90, 86, 124, 82, 21, 22, 95, 87, 84, 66, 95, 94, 86}, "fb69566187"));
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{47, 90, 16, 74, 92, 11, 6, 69, 85, 15, 6, 69, 87, 95, 89, 76, 66, 90, 13, 25, 118, 38, 53, 33, 85, 18, 22, 92, 86, 87, 67, 81, 13, 93, 67, 92, 77, 17, 19, 4, 67}, "b3c95eae0ab58678"));
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new CCTDestination(str2, str3);
    }
}
