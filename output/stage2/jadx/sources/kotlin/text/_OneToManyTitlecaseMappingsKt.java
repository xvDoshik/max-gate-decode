package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char c) {
        String strValueOf = String.valueOf(c);
        String strDecode = C0000.decode(new byte[]{10, 76, 91, 13, 17, 5, 86, 12, 10, 86, 67, 65, 83, 3, 23, 1, 5, 74, 67, 65, 69, 9, 23, 12, 11, 87, 26, 15, 68, 10, 91, 66, 16, 64, 71, 4, 17, 12, 86, 20, 5, 23, 91, 0, 95, 1, 25, 49, 16, 75, 94, 15, 86}, "d97a1f7b");
        Intrinsics.checkNotNull(strValueOf, strDecode);
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{66, 86, 102, 22, 68, 84, 66, 33, 0, 75, 83, 17, 29, 72, 26, 24}, "693f410ba8", false));
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        Intrinsics.checkNotNull(upperCase, strDecode);
        String strSubstring = upperCase.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{68, 65, 85, 23, 16, 64, 94, 90, 80, 76, 74, 28, 25, 29}, "747dd2", false));
        Intrinsics.checkNotNull(strSubstring, strDecode);
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{67, 14, 120, 88, 69, 80, 69, 122, 81, 66, 3, 25, 74, 29, 25, 72}, "7a47257901f1d3", true));
        return cCharAt + lowerCase;
    }
}
