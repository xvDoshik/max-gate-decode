package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0007\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0087\n\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0002¨\u0006\u0010"}, d2 = {"digitToInt", "", "", "radix", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "digitToChar", "titlecase", "", "plus", "other", "equals", "", "ignoreCase", "isSurrogate", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final char digitToChar(int i) {
        if (i < 0 || i >= 10) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{123, 94, 67, 16}, "20709bf9", 7) + i + C0000.decode(new byte[]{70, 92, 70, 67, 88, 95, 68, 17, 7, 21, 81, 6, 85, 89, 93, 80, 10, 21, 81, 10, 81, 89, 68}, "f55c6001", 4));
        }
        return (char) (i + 48);
    }

    public static final char digitToChar(int i, int i2) {
        if (2 > i2 || i2 >= 37) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{120, 95, 69, 89, 10, 92, 80, 25, 75, 88, 85, 88, 75, 2, 70}, "1138f54999", 6) + i2 + C0000.decode(new byte[]{31, 68, 101, 88, 88, 94, 82, 20, 23, 82, 93, 8, 75, 16, 71, 5, 95, 76, 81, 68, 22, 85, 23, 86, 25, 8, 93, 16, 67, 5, 93, 94, 81, 23, 4, 26, 75, 0, 15}, "1d394764e39a30", false));
        }
        if (i < 0 || i >= i2) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{125, 94, 80, 92, 66, 16}, "977560", 0.0f) + i + C0000.decode(new byte[]{65, 7, 9, 93, 66, 18, 93, 9, 68, 20, 71, 86, 17, 17, 3, 75, 84, 92, 71, 70, 81, 20, 67, 82, 13, 10, 2, 24, 85, 91, 84, 15, 68, 20, 92, 93, 65, 17, 7, 92, 88, 74, 19}, "acf8123f0453", 0.0f) + i2);
        }
        return (char) (i < 10 ? i + 48 : ((char) (i + 65)) - '\n');
    }

    public static final int digitToInt(char c) {
        int iDigitOf = CharsKt.digitOf(c, 10);
        if (iDigitOf >= 0) {
            return iDigitOf;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{118, 91, 0, 74, 66}, "53a8bdbd955e752f", 0.0f) + c + C0000.decode(new byte[]{21, 80, 64, 20, 87, 11, 65, 25, 82, 20, 93, 1, 86, 80, 94, 85, 85, 68, 81, 80, 84, 93, 77}, "59349d", 2));
    }

    public static final int digitToInt(char c, int i) {
        Integer numDigitToIntOrNull = CharsKt.digitToIntOrNull(c, i);
        if (numDigitToIntOrNull != null) {
            return numDigitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{32, 90, 85, 68, 20}, "c24645", 3) + c + C0000.decode(new byte[]{65, 8, 64, 70, 15, 91, 76, 67, 89, 22, 85, 15, 81, 94, 21, 65, 90, 8, 65, 64, 80, 6, 24, 81, 88, 16, 83, 89, 65, 19, 82, 2, 8, 76, 5}, "aa3fa48c861f67", false) + i);
    }

    public static final boolean isSurrogate(char c) {
        return 55296 <= c && c < 57344;
    }

    private static final String plus(char c, String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 16, 88, 0, 74}, "ed0e828162ddee"));
        return c + str;
    }

    public static final Integer digitToIntOrNull(char c) {
        Integer numValueOf = Integer.valueOf(CharsKt.digitOf(c, 10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    public static final Integer digitToIntOrNull(char c, int i) {
        CharsKt.checkRadix(i);
        Integer numValueOf = Integer.valueOf(CharsKt.digitOf(c, i));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    public static final String titlecase(char c) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(c);
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return CharsKt.equals(c, c2, z);
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
