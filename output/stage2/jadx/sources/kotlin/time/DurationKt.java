package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j, int i) {
        return Duration.m1371constructorimpl((j << 1) + ((long) i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j) {
        return Duration.m1371constructorimpl((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j) {
        return Duration.m1371constructorimpl(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j) {
        return j * ((long) NANOS_IN_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j) {
        return j / ((long) NANOS_IN_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseDuration(String str, boolean z) {
        int i;
        char cCharAt;
        char cCharAt2;
        int i2;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{101, 89, 82, 18, 75, 17, 64, 15, 11, 95, 21, 12, 18, 65, 86, 8, 65, 69, 78}, "11728e2fe85eaa3e", 7));
        }
        long jM1462getZEROUwyO8pc = Duration.INSTANCE.m1462getZEROUwyO8pc();
        char cCharAt3 = str.charAt(0);
        int length2 = (cCharAt3 == '+' || cCharAt3 == '-') ? 1 : 0;
        boolean z2 = length2 > 0;
        DurationUnit durationUnit = null;
        boolean z3 = z2 && StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null);
        String strDecode = C0000.decode(new byte[]{126, 95, 24, 5, 93, 85, 18, 88, 89, 81, 10, 22, 65}, "008f28b774db2cf0");
        if (length <= length2) {
            throw new IllegalArgumentException(strDecode);
        }
        char cCharAt4 = str.charAt(length2);
        String strDecode2 = C0000.decode(new byte[]{101, 10, 7, 72, 71, 87, 84, 71, 0, 87, 24, 11, 66, 93, 85, 22, 66, 95, 81, 18, 83, 70, 23, 82, 76, 13, 95, 87, 16, 7, 13, 93, 71, 93, 89, 86, 11, 71, 75}, "0db07273e38d09", false);
        char c = ':';
        char c2 = '0';
        String strDecode3 = C0000.decode(new byte[]{70, 67, 6, 64, 67, 67, 90, 15, 82, 30, 74, 29, 25, 24}, "56d3713a", 0.0f);
        String strDecode4 = C0000.decode(new byte[]{8, 16, 10, 94, 67, 80, 82, 10, 95, 86, 68, 68, 4, 0, 70, 81, 2, 64, 71, 68, 69, 86, 16, 10, 9, 11, 75, 92, 22, 95, 95, 68, 69, 64, 64, 1, 70, 15, 7, 68, 2, 29, 95, 5, 95, 94, 30, 55, 18, 23, 15, 92, 4}, "fef2c33d190d", true);
        if (cCharAt4 == 'P') {
            int i3 = length2 + 1;
            if (i3 == length) {
                throw new IllegalArgumentException();
            }
            DurationUnit durationUnit2 = null;
            boolean z4 = false;
            while (i3 < length) {
                if (str.charAt(i3) != 'T') {
                    int i4 = i3;
                    while (true) {
                        if (i4 >= str.length()) {
                            i2 = length;
                            break;
                        }
                        char cCharAt5 = str.charAt(i4);
                        if (c2 > cCharAt5 || cCharAt5 >= c) {
                            i2 = length;
                            if (!StringsKt.contains$default((CharSequence) "+-.", cCharAt5, false, 2, (Object) null)) {
                                break;
                            }
                        } else {
                            i2 = length;
                        }
                        i4++;
                        length = i2;
                        c = ':';
                        c2 = '0';
                    }
                    Intrinsics.checkNotNull(str, strDecode4);
                    String strSubstring = str.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, strDecode3);
                    String str2 = strSubstring;
                    if (str2.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i3 + strSubstring.length();
                    String str3 = str;
                    if (length3 < 0 || length3 >= str3.length()) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{124, 80, 23, 69, 90, 94, 95, 70, 71, 8, 88, 77, 68, 80, 92, 66, 24, 16, 83, 10, 68, 92, 68}, "19d6308f2f") + strSubstring);
                    }
                    char cCharAt6 = str3.charAt(length3);
                    i3 = length3 + 1;
                    DurationUnit durationUnitDurationUnitByIsoChar = DurationUnitKt.durationUnitByIsoChar(cCharAt6, z4);
                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitDurationUnitByIsoChar) <= 0) {
                        throw new IllegalArgumentException(strDecode2);
                    }
                    int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, '.', 0, false, 6, (Object) null);
                    if (durationUnitDurationUnitByIsoChar != DurationUnit.SECONDS || iIndexOf$default <= 0) {
                        jM1462getZEROUwyO8pc = Duration.m1400plusLRDsOJo(jM1462getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(strSubstring), durationUnitDurationUnitByIsoChar));
                    } else {
                        Intrinsics.checkNotNull(strSubstring, strDecode4);
                        String strSubstring2 = strSubstring.substring(0, iIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, strDecode3);
                        long jM1400plusLRDsOJo = Duration.m1400plusLRDsOJo(jM1462getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(strSubstring2), durationUnitDurationUnitByIsoChar));
                        Intrinsics.checkNotNull(strSubstring, strDecode4);
                        String strSubstring3 = strSubstring.substring(iIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, strDecode3);
                        jM1462getZEROUwyO8pc = Duration.m1400plusLRDsOJo(jM1400plusLRDsOJo, toDuration(Double.parseDouble(strSubstring3), durationUnitDurationUnitByIsoChar));
                    }
                    durationUnit2 = durationUnitDurationUnitByIsoChar;
                    length = i2;
                    c = ':';
                    c2 = '0';
                } else {
                    if (z4 || (i3 = i3 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z4 = true;
                }
            }
        } else {
            if (z) {
                throw new IllegalArgumentException();
            }
            String strDecode5 = C0000.decode(new byte[]{44, 86, 86, 91, 15, 15, 16, 29}, "e802afdd604abc");
            int iMax = Math.max(length - length2, strDecode5.length());
            char c3 = ':';
            if (StringsKt.regionMatches(str, length2, strDecode5, 0, iMax, true)) {
                jM1462getZEROUwyO8pc = Duration.INSTANCE.m1460getINFINITEUwyO8pc();
            } else {
                boolean z5 = !z2;
                if (z2 && str.charAt(length2) == '(' && StringsKt.last(str) == ')') {
                    length2++;
                    int i5 = length - 1;
                    if (length2 == i5) {
                        throw new IllegalArgumentException(strDecode);
                    }
                    i = i5;
                    z5 = true;
                } else {
                    i = length;
                }
                boolean z6 = false;
                while (length2 < i) {
                    if (z6 && z5) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i6 = length2;
                    while (i6 < str.length() && (('0' <= (cCharAt2 = str.charAt(i6)) && cCharAt2 < c3) || cCharAt2 == '.')) {
                        i6++;
                    }
                    Intrinsics.checkNotNull(str, strDecode4);
                    String strSubstring4 = str.substring(length2, i6);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, strDecode3);
                    String str4 = strSubstring4;
                    if (str4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i7 = length4;
                    while (i7 < str.length() && 'a' <= (cCharAt = str.charAt(i7)) && cCharAt < '{') {
                        i7++;
                    }
                    Intrinsics.checkNotNull(str, strDecode4);
                    String strSubstring5 = str.substring(length4, i7);
                    Intrinsics.checkNotNullExpressionValue(strSubstring5, strDecode3);
                    length2 = length4 + strSubstring5.length();
                    DurationUnit durationUnitDurationUnitByShortName = DurationUnitKt.durationUnitByShortName(strSubstring5);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitDurationUnitByShortName) <= 0) {
                        throw new IllegalArgumentException(strDecode2);
                    }
                    int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str4, '.', 0, false, 6, (Object) null);
                    if (iIndexOf$default2 > 0) {
                        Intrinsics.checkNotNull(strSubstring4, strDecode4);
                        String strSubstring6 = strSubstring4.substring(0, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, strDecode3);
                        long jM1400plusLRDsOJo2 = Duration.m1400plusLRDsOJo(jM1462getZEROUwyO8pc, toDuration(Long.parseLong(strSubstring6), durationUnitDurationUnitByShortName));
                        Intrinsics.checkNotNull(strSubstring4, strDecode4);
                        String strSubstring7 = strSubstring4.substring(iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, strDecode3);
                        jM1462getZEROUwyO8pc = Duration.m1400plusLRDsOJo(jM1400plusLRDsOJo2, toDuration(Double.parseDouble(strSubstring7), durationUnitDurationUnitByShortName));
                        if (length2 < i) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 71, 89, 5, 16, 92, 95, 12, 88, 89, 24, 5, 11, 88, 64, 13, 87, 80, 86, 18, 68, 88, 69, 17, 77, 21, 90, 3, 68, 89, 81, 17, 77}, "958fd50b", true));
                        }
                    } else {
                        jM1462getZEROUwyO8pc = Duration.m1400plusLRDsOJo(jM1462getZEROUwyO8pc, toDuration(Long.parseLong(strSubstring4), durationUnitDurationUnitByShortName));
                    }
                    durationUnit = durationUnitDurationUnitByShortName;
                    z6 = true;
                    c3 = ':';
                }
            }
        }
        return z3 ? Duration.m1415unaryMinusUwyO8pc(jM1462getZEROUwyO8pc) : jM1462getZEROUwyO8pc;
    }

    private static final long parseOverLongIsoComponent(String str) {
        char cCharAt;
        int length = str.length();
        int i = (length <= 0 || !StringsKt.contains$default((CharSequence) C0000.decode(new byte[]{27, 73}, "0d876438", true), str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i > 16) {
            int i2 = i;
            while (true) {
                if (i >= length) {
                    if (length - i2 <= 16) {
                        break;
                    }
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return LongCompanionObject.MAX_VALUE;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '0') {
                    if (i2 == i) {
                        i2++;
                    }
                } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                    break;
                }
                i++;
            }
        }
        return (!StringsKt.startsWith$default(str, C0000.decode(new byte[]{28}, "717a84", false), false, 2, (Object) null) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(StringsKt.drop(str, 1));
    }

    private static final String substringWhile(String str, int i, Function1<? super Character, Boolean> function1) {
        int i2 = i;
        while (i2 < str.length() && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        Intrinsics.checkNotNull(str, C0000.decode(new byte[]{94, 22, 9, 92, 17, 86, 84, 94, 94, 12, 17, 16, 83, 80, 21, 83, 81, 16, 17, 16, 69, 90, 21, 94, 95, 13, 72, 94, 68, 89, 89, 16, 68, 26, 21, 85, 17, 95, 84, 70, 81, 77, 9, 81, 95, 82, 27, 99, 68, 17, 12, 94, 86}, "0ce01550", 5));
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{17, 69, 81, 64, 18, 64, 95, 93, 85, 17, 27, 28, 23, 17}, "b033f263295298", false));
        return strSubstring;
    }

    public static final long toDuration(double d, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{65, 89, 90, 71}, "4733ac2262", 0.0f));
        double dConvertDurationUnit = DurationUnitKt.convertDurationUnit(d, durationUnit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(dConvertDurationUnit)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{33, 17, 75, 80, 69, 80, 13, 93, 16, 69, 3, 88, 16, 1, 25, 82, 80, 87, 12, 92, 68, 19, 0, 81, 69, 42, 88, ByteCompanionObject.MAX_VALUE, 31}, "ed9119b303b4").toString());
        }
        long jRoundToLong = MathKt.roundToLong(dConvertDurationUnit);
        return (-4611686018426999999L > jRoundToLong || jRoundToLong >= 4611686018427000000L) ? durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(d, durationUnit, DurationUnit.MILLISECONDS))) : durationOfNanos(jRoundToLong);
    }

    public static final long toDuration(int i, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{68, 15, 92, 22}, "1a5b44d45a", 0.0f));
        return durationUnit.compareTo(DurationUnit.SECONDS) <= 0 ? durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(i, durationUnit, DurationUnit.NANOSECONDS)) : toDuration(i, durationUnit);
    }

    public static final long toDuration(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{76, 87, 15, 67}, "99f76916f49255e8", true));
        long jConvertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, durationUnit);
        return ((-jConvertDurationUnitOverflow) > j || j > jConvertDurationUnitOverflow) ? durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(j, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS)) : durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(j, durationUnit, DurationUnit.NANOSECONDS));
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m1468timesmvk6XK0(int i, long j) {
        return Duration.m1402timesUwyO8pc(j, i);
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m1467timeskIfJnKk(double d, long j) {
        return Duration.m1401timesUwyO8pc(j, d);
    }

    private static final int skipWhile(String str, int i, Function1<? super Character, Boolean> function1) {
        while (i < str.length() && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j) {
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j) {
        if (-4611686018426L <= j && j < 4611686018427L) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, MAX_MILLIS));
    }
}
