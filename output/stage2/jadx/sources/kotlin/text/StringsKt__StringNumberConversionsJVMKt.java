package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u000e\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000f\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0001H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0001H\u0087\b\u001a\u0015\u0010\f\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0001H\u0087\b\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\r\u0010\u0018\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0087\b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u0001H\u0007\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a4\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H\u0002¢\u0006\u0002\b&\u001a \u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\b*\u001a\u0012\u0010+\u001a\u00020\b*\u00020,H\u0083\b¢\u0006\u0002\b-\u001a\u0012\u0010.\u001a\u00020\b*\u00020,H\u0083\b¢\u0006\u0002\b/\u001a\u0012\u00100\u001a\u00020\u0004*\u00020,H\u0083\b¢\u0006\u0002\b1\u001a6\u00102\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b4\u001a6\u00105\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b6\u001a>\u00107\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u00108\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b9¨\u0006:"}, d2 = {"toString", "", "", "radix", "", "", "", "toBoolean", "", "toByte", "toShort", "toInt", "toLong", "toFloat", "", "toDouble", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", "", "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, boolean z, Function1<? super Character, Boolean> function1) {
        boolean z2;
        String strDecode;
        int i3 = i;
        while (i3 <= i2 && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        boolean z3 = i != i3;
        if (i3 > i2) {
            if (z) {
                return -1;
            }
            return i3;
        }
        if (str.charAt(i3) == '.') {
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 <= i2 && function1.invoke(Character.valueOf(str.charAt(i5))).booleanValue()) {
                i5++;
            }
            z2 = i4 != i5;
            i3 = i5;
        } else {
            z2 = false;
        }
        if (z3 || z2) {
            return i3;
        }
        if (z) {
            return -1;
        }
        if (i2 == i3 + 2) {
            strDecode = C0000.decode(new byte[]{124, 88, 122}, "29453623d1", 5);
        } else {
            strDecode = i2 == i3 + 7 ? C0000.decode(new byte[]{125, 93, 95, 81, 90, 13, 70, 27}, "43984d2b1d", 4) : null;
        }
        if (strDecode != null && StringsKt.indexOf((CharSequence) str, strDecode, i3, false) == i3) {
            return i2 + 1;
        }
        return -1;
    }

    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char c) {
        return c | ' ';
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int i, int i2) {
        if (i2 == i + 2) {
            return C0000.decode(new byte[]{43, 85, 43}, "e4ecfc4c", 0.0f);
        }
        if (i2 == i + 7) {
            return C0000.decode(new byte[]{123, 88, 86, 92, 11, 95, 22, 73}, "2605e6b0ff1caeaf", 4);
        }
        return null;
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char c) {
        return ((c + 65488) & 65535) < 10;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char c) {
        return (((c | ' ') + (-97)) & 65535) < 6;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x014b  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String str) {
        char c;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        String strDecode;
        boolean z4;
        boolean z5 = true;
        int length = str.length() - 1;
        int i2 = 0;
        while (true) {
            c = ' ';
            if (i2 > length || str.charAt(i2) > ' ') {
                break;
            }
            i2++;
        }
        if (i2 > length) {
            return false;
        }
        while (length > i2 && str.charAt(length) <= ' ') {
            length--;
        }
        if (str.charAt(i2) == '+' || str.charAt(i2) == '-') {
            i2++;
        }
        if (i2 > length) {
            return false;
        }
        if (str.charAt(i2) != '0') {
            z = true;
            z2 = false;
        } else {
            int i3 = i2 + 1;
            if (i3 > length) {
                return true;
            }
            if ((str.charAt(i3) | ' ') == 120) {
                int i4 = i2 + 2;
                int i5 = i4;
                while (true) {
                    if (i5 > length) {
                        z = z5;
                        break;
                    }
                    char cCharAt = str.charAt(i5);
                    z = z5;
                    if (((cCharAt - '0') & 65535) >= 10 && (((cCharAt | ' ') - 97) & 65535) >= 6) {
                        break;
                    }
                    i5++;
                    z5 = z;
                }
                boolean z6 = i4 != i5 ? z : false;
                if (i5 <= length) {
                    if (str.charAt(i5) == '.') {
                        int i6 = i5 + 1;
                        int i7 = i6;
                        while (i7 <= length) {
                            char cCharAt2 = str.charAt(i7);
                            char c2 = c;
                            if (((cCharAt2 - '0') & 65535) >= 10 && (((cCharAt2 | ' ') - 97) & 65535) >= 6) {
                                break;
                            }
                            i7++;
                            c = c2;
                        }
                        z4 = i6 != i7 ? z : false;
                        i5 = i7;
                    } else {
                        z4 = false;
                    }
                    if (z6 || z4) {
                        i2 = i5;
                    }
                    if (i2 != -1 || i2 > length) {
                        return false;
                    }
                    z2 = z;
                }
                i2 = -1;
                if (i2 != -1) {
                }
                return false;
            }
            z = true;
            z2 = false;
        }
        if (!z2) {
            int i8 = i2;
            while (i8 <= length && ((str.charAt(i8) - '0') & 65535) < 10) {
                i8++;
            }
            boolean z7 = i2 != i8 ? z : false;
            if (i8 > length) {
                i2 = i8;
            } else {
                if (str.charAt(i8) == '.') {
                    int i9 = i8 + 1;
                    i = i9;
                    while (i <= length && ((str.charAt(i) - '0') & 65535) < 10) {
                        i++;
                    }
                    if (i9 != i) {
                        z3 = z;
                    }
                    if (!z7 || z3) {
                        i2 = i;
                    } else {
                        if (length == i + 2) {
                            strDecode = C0000.decode(new byte[]{123, 88, 42}, "59db7a1c", false);
                        } else {
                            strDecode = length == i + 7 ? C0000.decode(new byte[]{44, 11, 0, 89, 91, 13, 64, 74}, "eef05d438a36", true) : null;
                        }
                        i2 = (strDecode != null && StringsKt.indexOf((CharSequence) str, strDecode, i, false) == i) ? length + 1 : -1;
                    }
                } else {
                    i = i8;
                }
                z3 = false;
                if (z7) {
                    i2 = i;
                } else {
                    i2 = i;
                }
            }
            if (i2 == -1) {
                return false;
            }
            if (i2 > length) {
                return z;
            }
        }
        int i10 = i2 + 1;
        int iCharAt = str.charAt(i2) | ' ';
        if (iCharAt != (z2 ? 112 : 101)) {
            if (z2 || (!(iCharAt == 102 || iCharAt == 100) || i10 <= length)) {
                return false;
            }
            return z;
        }
        if (i10 > length) {
            return false;
        }
        if ((str.charAt(i10) == '+' || str.charAt(i10) == '-') && (i10 = i2 + 2) > length) {
            return false;
        }
        while (i10 <= length && ((str.charAt(i10) - '0') & 65535) < 10) {
            i10++;
        }
        if (i10 > length) {
            return z;
        }
        if (i10 != length) {
            return false;
        }
        int iCharAt2 = str.charAt(i10) | ' ';
        if (iCharAt2 == 102 || iCharAt2 == 100) {
            return z;
        }
        return false;
    }

    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 67, 91, 13, 68, 11}, "573d75a73b", false));
        return new BigDecimal(str);
    }

    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 70, 89, 91, 74, 15}, "52129162db7f", true));
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{91, 5, 77, 13, 33, 95, 88, 16, 92, 29, 22}, "6d9eb0", 0.0f));
        return new BigDecimal(str, mathContext);
    }

    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 67, 10, 88, 18, 93}, "47b1ac8db9", true));
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 65, 95, 91, 69, 95}, "e5726a3629f2", 0.0f));
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{9, 88, 17, 11, 37, 88, 10, 16, 85, 29, 16}, "d9ecf7dd0e", false));
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str, mathContext);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 21, 94, 90, 21, 8}, "5a63f6", 0.0f));
        return new BigInteger(str);
    }

    private static final BigInteger toBigInteger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 64, 90, 8, 71, 9}, "b42a4733", 0.0f));
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 16, 95, 11, 68, 8}, "4d7b76", true));
        return StringsKt.toBigIntegerOrNull(str, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 70, 10, 93, 18, 93}, "72b4acd447f779", false));
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
            }
        } else if (CharsKt.digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    private static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 17, 14, 91, 21, 12}, "5ef2f2049e4d", 1));
        return Byte.parseByte(str);
    }

    private static final byte toByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 22, 80, 90, 67, 91}, "5b830ec2a1", 0.0f));
        return Byte.parseByte(str, CharsKt.checkRadix(i));
    }

    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 16, 13, 15, 71, 90}, "5def4d", false));
        return Double.parseDouble(str);
    }

    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 76, 95, 95, 66, 91}, "f8761eabcf47", 7));
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 67, 93, 11, 71, 14}, "375b4032b2", false));
        return Float.parseFloat(str);
    }

    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 64, 11, 10, 17, 10}, "e4ccb4ddcc11f1b0", 0));
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 76, 89, 81, 68, 8}, "381876b98a2815"));
        return Integer.parseInt(str);
    }

    private static final int toInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 70, 95, 93, 17, 93}, "a274bc0a"));
        return Integer.parseInt(str, CharsKt.checkRadix(i));
    }

    private static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 18, 12, 80, 75, 95}, "5fd98a", 4));
        return Long.parseLong(str);
    }

    private static final long toLong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 18, 9, 8, 65, 15}, "4faa21fa33af", 2));
        return Long.parseLong(str, CharsKt.checkRadix(i));
    }

    private static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 77, 10, 13, 67, 14}, "b9bd008519a63831", true));
        return Short.parseShort(str);
    }

    private static final short toShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 70, 11, 13, 67, 95}, "82cd0adf635a56", 0.0f));
        return Short.parseShort(str, CharsKt.checkRadix(i));
    }

    private static final String toString(byte b, int i) {
        String string = Integer.toString(b, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{70, 90, 55, 16, 75, 80, 92, 82, 76, 74, 23, 23, 27}, "25dd99", 4));
        return string;
    }

    private static final String toString(int i, int i2) {
        String string = Integer.toString(i, CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{76, 93, 102, 77, 20, 93, 15, 85, 30, 30, 27, 30, 24}, "8259f4a260501f", 0.0f));
        return string;
    }

    private static final String toString(long j, int i) {
        String string = Long.toString(j, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{22, 89, 107, 68, 19, 90, 88, 87, 77, 79, 72, 29, 75}, "b680a360eaf3", true));
        return string;
    }

    private static final String toString(short s, int i) {
        String string = Integer.toString(s, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{21, 92, 53, 71, 71, 81, 90, 80, 16, 30, 72, 79, 16}, "a3f3584780fa97", false));
        return string;
    }

    private static final boolean toBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return function1.invoke(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i <= i2 && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 > i && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2--;
        }
        return i2;
    }
}
