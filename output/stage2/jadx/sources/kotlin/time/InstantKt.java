package kotlin.time;

import java.io.IOException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0003\u001a'\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0082\b\u001a'\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0082\b\u001a\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0014H\u0000\u001a\u0014\u0010&\u001a\u00020\u0014*\u00020\u00142\u0006\u0010$\u001a\u00020\u0001H\u0002\u001a\u0014\u0010,\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010-\u001a\u00020\u0014H\u0002\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001f\u0010\u0006\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0014X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"isDistantPast", "", "Lkotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", "", "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "isoString", "", "formatIso", "", "instant", "DAYS_PER_CYCLE", "", "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", "action", "Lkotlin/Function0;", "", "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", "", "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MILLIS_PER_SECOND = 1000;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int[] POWERS_OF_TEN = {1, 10, 100, MILLIS_PER_SECOND, 10000, 100000, 1000000, 10000000, 100000000, NANOS_PER_SECOND};
    private static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    private static final int[] colonsInIsoOffsetString = {3, 6};
    private static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatIso(Instant instant) throws IOException {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime unboundLocalDateTimeFromInstant = UnboundLocalDateTime.INSTANCE.fromInstant(instant);
        int year = unboundLocalDateTimeFromInstant.getYear();
        int i = 0;
        if (Math.abs(year) < MILLIS_PER_SECOND) {
            StringBuilder sb2 = new StringBuilder();
            String strDecode = C0000.decode(new byte[]{5, 4, 91, 6, 65, 85, 34, 9, 4, 19, 32, 21, 31, 77, 27, 30, 72}, "aa7c50aaea", 0.0f);
            if (year >= 0) {
                Intrinsics.checkNotNullExpressionValue(sb2.append(year + 10000).deleteCharAt(0), strDecode);
            } else {
                Intrinsics.checkNotNullExpressionValue(sb2.append(year - 10000).deleteCharAt(1), strDecode);
            }
            sb.append((CharSequence) sb2);
        } else {
            if (year >= 10000) {
                sb.append('+');
            }
            sb.append(year);
        }
        sb.append('-');
        StringBuilder sb3 = sb;
        formatIso$lambda$8$appendTwoDigits(sb3, sb, unboundLocalDateTimeFromInstant.getMonth());
        sb.append('-');
        formatIso$lambda$8$appendTwoDigits(sb3, sb, unboundLocalDateTimeFromInstant.getDay());
        sb.append('T');
        formatIso$lambda$8$appendTwoDigits(sb3, sb, unboundLocalDateTimeFromInstant.getHour());
        sb.append(':');
        formatIso$lambda$8$appendTwoDigits(sb3, sb, unboundLocalDateTimeFromInstant.getMinute());
        sb.append(':');
        formatIso$lambda$8$appendTwoDigits(sb3, sb, unboundLocalDateTimeFromInstant.getSecond());
        if (unboundLocalDateTimeFromInstant.getNanosecond() != 0) {
            sb.append('.');
            while (true) {
                int nanosecond = unboundLocalDateTimeFromInstant.getNanosecond();
                iArr = POWERS_OF_TEN;
                int i2 = i + 1;
                if (nanosecond % iArr[i2] != 0) {
                    break;
                }
                i = i2;
            }
            int i3 = i - (i % 3);
            String strValueOf = String.valueOf((unboundLocalDateTimeFromInstant.getNanosecond() / iArr[i3]) + iArr[9 - i3]);
            Intrinsics.checkNotNull(strValueOf, C0000.decode(new byte[]{91, 16, 15, 14, 25, 6, 85, 86, 11, 95, 65, 69, 1, 7, 25, 6, 85, 75, 17, 16, 65, 10, 67, 12, 86, 11, 25, 86, 16, 92, 89, 69, 23, 27, 73, 0, 20, 82, 4, 70, 84, 75, 15, 3, 87, 2, 26, 107, 17, 66, 92, 11, 4}, "5ecb9e48e0"));
            String strSubstring = strValueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{22, 77, 86, 69, 18, 22, 93, 94, 5, 24, 29, 76, 74, 25}, "e846fd40b03bd0f8", true));
            sb.append(strSubstring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final boolean isDistantFuture(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, C0000.decode(new byte[]{9, 64, 9, 10, 17, 15}, "54acb1f1fc", 0.0f));
        return instant.compareTo(Instant.INSTANCE.getDISTANT_FUTURE()) >= 0;
    }

    public static /* synthetic */ void isDistantFuture$annotations(Instant instant) {
    }

    private static final boolean isDistantPast(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, C0000.decode(new byte[]{95, 69, 88, 13, 17, 92}, "c10dbb"));
        return instant.compareTo(Instant.INSTANCE.getDISTANT_PAST()) <= 0;
    }

    public static /* synthetic */ void isDistantPast$annotations(Instant instant) {
    }

    private static final int monthLength(int i, boolean z) {
        if (i != 2) {
            return (i == 4 || i == 6 || i == 9 || i == 11) ? 30 : 31;
        }
        return z ? 29 : 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Instant parseIso(CharSequence charSequence) {
        int i;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        char cCharAt2;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{116, 12, 65, 83, 91, 21, 23, 27, 21, 17, 21, 68, 95, 11, 4, 66, 92, 17, 65, 88, 89, 17, 67, 3, 21, 20, 0, 90, 95, 1, 67, 43, 91, 17, 21, 87, 88, 17}, "5ba66ecb").toString());
        }
        char cCharAt3 = charSequence.charAt(0);
        if (cCharAt3 == '+' || cCharAt3 == '-') {
            i = 1;
        } else {
            i = 0;
            cCharAt3 = ' ';
        }
        int iCharAt = 0;
        int i5 = i;
        while (i5 < charSequence.length() && '0' <= (cCharAt2 = charSequence.charAt(i5)) && cCharAt2 < ':') {
            iCharAt = (iCharAt * 10) + (charSequence.charAt(i5) - '0');
            i5++;
        }
        int i6 = i5 - i;
        String strDecode = C0000.decode(new byte[]{21, 1, 81, 1, 15, 21, 68}, "5e8ffa70");
        if (i6 > 10) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{118, 74, 22, 82, 83, 67, 82, 92, 68, 86, 64, 69, 88, 11, 68, 64, 19, 3, 86, 23, 84, 94, 80, 81, 16, 68, 20, 3, 90, 22, 23, 64, 91, 87, 70, 78, 85, 86, 69, 24, 10, 66, 89, 7, 80, 22, 27, 20, 84, 93, 18, 23}, "32f70778d74e5d74", 3) + i6 + strDecode);
            throw new KotlinNothingValueException();
        }
        if (i6 == 10 && Intrinsics.compare((int) charSequence.charAt(i), 50) >= 0) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{124, 77, 18, 80, 85, 16, 4, 2, 18, 2, 16, 66, 84, 90, 17, 65, 22, 93, 65, 2, 91, 4, 13, 22, 74, 21, 4, 90, 68, 68, 21, 14, 87, 67, 29, 7, 88, 71, 66, 91, 67, 9, 3, 3, 64, 67, 11, 16, 25, 76, 7, 84, 68, 68, 80, 86, 2, 83, 84, 82, 9, 5, 82, 5, 26, 68, 6, 9, 70, 67}, "95b56daf2cdb", 2) + i6 + strDecode);
            throw new KotlinNothingValueException();
        }
        if (i6 < 4) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{98, 81, 7, 18, 65, 80, 85, 19, 24, 90, 66, 84, 86, 3, 22, 23, 91, 76, 17, 70, 24, 87, 81, 65, 72, 85, 83, 93, 81, 2, 68, 67, 89, 25, 86, 18, 92, 92, 83, 8, 76, 71, 27, 25, 83, 9, 16, 23}, "69b2854a84794fd7", 0.0f) + i6 + strDecode);
            throw new KotlinNothingValueException();
        }
        if (cCharAt3 == '+' && i6 == 4) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{53, 90, 80, 70, 22, 74, 70, 23, 75, 94, 5, 91, 65, 83, 65, 70, 69, 9, 4, 23, 75, 67, 3, 71, 21, 18, 92, 21, 17, 14, 15, 91, 65, 23, 20, 84, 13, 91, 81, 70, 87, 14, 19, 23, 65, 82, 3, 71, 65, 92, 64, 11, 83, 4, 19, 68, 24, 91, 13, 91, 6, 87, 71, 70, 69, 9, 0, 89, 24, 3, 66, 81, 8, 85, 92, 18, 66}, "a25f1aa787b5", false));
            throw new KotlinNothingValueException();
        }
        if (cCharAt3 == ' ' && i6 != 4) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{117, 68, 23, 27, 65, 22, 88, 66, 24, 19, 25, 67, 16, 67, 15, 81, 89, 16, 81, 71, 20, 22, 85, 65, 19, 95, 69, 85, 92, 20, 82, 11, 66, 16, 31, 83, 86, 66, 24, 90, 65, 9, 82, 85, 20, 69, 23, 92, 87, 90, 83, 1, 66, 16, 18, 94, 86, 94, 24, 0, 20, 0, 89, 87, 15, 66, 68}, "4d00f67084", false));
            throw new KotlinNothingValueException();
        }
        if (cCharAt3 == '-') {
            iCharAt = -iCharAt;
        }
        int i7 = iCharAt;
        int i8 = i5 + 16;
        if (charSequence.length() < i8) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{99, 10, 6, 65, 11, 11, 70, 23, 69, 20, 66, 76, 69, 11, 13, 6, 66, 12, 69, 66, 69, 91, 94, 24, 68, 10, 12, 19, 22}, "7bcabe6b1418", true));
            throw new KotlinNothingValueException();
        }
        Function1 function1 = new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$1(((Character) obj).charValue()));
            }
        };
        String strDecode2 = C0000.decode(new byte[]{23, 76, 70}, "0aaa9f1a71", 5);
        parseIso$expect(charSequence, strDecode2, i5, function1);
        parseIso$expect(charSequence, strDecode2, i5 + 3, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$2(((Character) obj).charValue()));
            }
        });
        parseIso$expect(charSequence, C0000.decode(new byte[]{23, 55, 19, 17, 90, 23, 68, 16, 68, 68}, "0c415ed7", false), i5 + 6, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$3(((Character) obj).charValue()));
            }
        });
        Function1 function2 = new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$4(((Character) obj).charValue()));
            }
        };
        String strDecode3 = C0000.decode(new byte[]{22, 3, 20}, "1931db26ce2971", true);
        parseIso$expect(charSequence, strDecode3, i5 + 9, function2);
        parseIso$expect(charSequence, strDecode3, i5 + 12, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$5(((Character) obj).charValue()));
            }
        });
        for (int i9 : asciiDigitPositionsInIsoStringAfterYear) {
            parseIso$expect(charSequence, C0000.decode(new byte[]{86, 15, 16, 115, 53, 39, 43, 44, 16, 81, 91, 6, 11, 69}, "7a02fdbe052ab1", 1), i9 + i5, new Function1() { // from class: kotlin.time.InstantKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(InstantKt.parseIso$lambda$6(((Character) obj).charValue()));
                }
            });
        }
        int iso$twoDigitNumber = parseIso$twoDigitNumber(charSequence, i5 + 1);
        int iso$twoDigitNumber2 = parseIso$twoDigitNumber(charSequence, i5 + 4);
        int iso$twoDigitNumber3 = parseIso$twoDigitNumber(charSequence, i5 + 7);
        int iso$twoDigitNumber4 = parseIso$twoDigitNumber(charSequence, i5 + 10);
        int iso$twoDigitNumber5 = parseIso$twoDigitNumber(charSequence, i5 + 13);
        int i10 = i5 + 15;
        if (charSequence.charAt(i10) == '.') {
            i10 = i8;
            int iCharAt2 = 0;
            while (i10 < charSequence.length() && '0' <= (cCharAt = charSequence.charAt(i10)) && cCharAt < ':') {
                iCharAt2 = (iCharAt2 * 10) + (charSequence.charAt(i10) - '0');
                i10++;
            }
            int i11 = i10 - i8;
            if (1 > i11 || i11 >= 10) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{7, 31, 79, 92, 65, 85, 93, 81, 8, 71, 22, 17, 2, 69, 6, 20, 69, 68, 17, 21, 14, 67, 64, 83, 5, 19, 3, 94, 17, 23, 23, 92, 83, 17, 7, 23, 0, 82, 64, 95, 14, 93, 69, 94, 5, 23, 23, 92, 83, 17, 18, 0, 2, 94, 90, 82, 77, 19, 2, 94, 23, 23}, "61aea146a3e1c7c4", false) + i11 + strDecode);
                throw new KotlinNothingValueException();
            }
            i2 = iCharAt2 * POWERS_OF_TEN[9 - i11];
        } else {
            i2 = 0;
        }
        if (i10 >= charSequence.length()) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{48, 89, 92, 20, 108, 53, 123, 68, 92, 87, 2, 66, 92, 64, 25, 0, 76, 68, 71, 89, 1, 17, 92, 90, 93, 65, 87, 2, 19, 69, 12, 84, 25, 71, 77, 19, 81, 10, 84, 17, 13, 66, 25, 89, 80, 18, 75, 13, 93, 86}, "d1949a8d31", 0.0f));
            throw new KotlinNothingValueException();
        }
        char cCharAt4 = charSequence.charAt(i10);
        String strDecode4 = C0000.decode(new byte[]{73, 16, 86, 91, 64, 25, 70}, "e01449a0caee31", false);
        if (cCharAt4 == '+' || cCharAt4 == '-') {
            int length = charSequence.length() - i10;
            if (length > 9) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{102, 12, 7, 21, 100, 109, 123, 24, 93, 2, 4, 70, 84, 77, 24, 75, 70, 22, 11, 91, 86, 25, 26}, "2db51988", false) + truncateForErrorMessage(charSequence.subSequence(i10, charSequence.length()).toString(), 16) + C0000.decode(new byte[]{67, 25, 15, 21, 65, 16, 88, 92, 68, 84, 92, 12, 6}, "a9ffad73d83b"));
                throw new KotlinNothingValueException();
            }
            if (length % 3 != 0) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{112, 12, 79, 86, 14, 10, 5, 67, 52, 100, 122, 66, 86, 81, 4, 16, 4, 23, 65, 67, 77, 16, 80, 89, 5, 67, 67}, "9b97bcaca0", 0.0f) + charSequence.subSequence(i10, charSequence.length()).toString() + Typography.quote);
                throw new KotlinNothingValueException();
            }
            for (int i12 : colonsInIsoOffsetString) {
                int i13 = i10 + i12;
                if (i13 >= charSequence.length()) {
                    break;
                }
                if (charSequence.charAt(i13) != ':') {
                    parseIso$parseFailure(charSequence, C0000.decode(new byte[]{119, 75, 72, 3, 5, 68, 81, 93, 68, 20, 12, 23, 70, 85, 70, 19, 81, 8, 2, 85, 76, 25}, "238ff049d360f4", false) + i13 + strDecode4 + charSequence.charAt(i13) + '\'');
                    throw new KotlinNothingValueException();
                }
            }
            int[] iArr = asciiDigitsInIsoOffsetString;
            int length2 = iArr.length;
            int i14 = 0;
            while (i14 < length2) {
                int i15 = iArr[i14] + i10;
                if (i15 >= charSequence.length()) {
                    break;
                }
                char cCharAt5 = charSequence.charAt(i15);
                int[] iArr2 = iArr;
                if ('0' > cCharAt5 || cCharAt5 >= ':') {
                    parseIso$parseFailure(charSequence, C0000.decode(new byte[]{118, 74, 67, 0, 81, 70, 3, 6, 22, 81, 15, 18, 114, 97, 112, 44, 123, 18, 2, 11, 81, 89, 21, 18, 82, 70, 19, 12, 92, 86, 3, 26, 22}, "323e22fb60a2", true) + i15 + strDecode4 + charSequence.charAt(i15) + '\'');
                    throw new KotlinNothingValueException();
                }
                i14++;
                iArr = iArr2;
            }
            int iso$twoDigitNumber6 = parseIso$twoDigitNumber(charSequence, i10 + 1);
            int iso$twoDigitNumber7 = length > 3 ? parseIso$twoDigitNumber(charSequence, i10 + 4) : 0;
            int iso$twoDigitNumber8 = length > 6 ? parseIso$twoDigitNumber(charSequence, i10 + 7) : 0;
            if (iso$twoDigitNumber7 > 59) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{32, 78, 21, 0, 80, 68, 86, 85, 65, 11, 82, 87, 22, 83, 17, 72, 94, 89, 93, 68, 21, 1, 25, 94, 3, 27, 13, 10, 70, 66, 19, 88, 15, 68, 4, 31, 75, 3, 92, 73, 19, 87, 92, 69, 65}, "e6ee3031ad41", 3) + iso$twoDigitNumber7);
                throw new KotlinNothingValueException();
            }
            if (iso$twoDigitNumber8 > 59) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{114, 73, 64, 85, 7, 65, 84, 1, 18, 95, 81, 87, 67, 85, 16, 24, 66, 0, 81, 95, 89, 85, 29, 95, 2, 24, 92, 12, 92, 69, 67, 84, 16, 89, 10, 21, 1, 75, 28, 5, 14, 29, 16, 87, 11, 65, 17}, "7100d51e20", 0.0f) + iso$twoDigitNumber8);
                throw new KotlinNothingValueException();
            }
            if (iso$twoDigitNumber6 > 17 && (iso$twoDigitNumber6 != 18 || iso$twoDigitNumber7 != 0 || iso$twoDigitNumber8 != 0)) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{35, 28, 20, 7, 82, 76, 0, 83, 21, 7, 11, 67, 92, 84, 0, 23, 1, 22, 17, 81, 11, 23, 24, 87, 93, 89, 3, 2, 72, 74, 79, 83, 9, 2, 85, 7, 25, 70, 2, 12, 71, 18}, "fddb18e75fec32", 1) + charSequence.subSequence(i10, charSequence.length()).toString());
                throw new KotlinNothingValueException();
            }
            i3 = (cCharAt4 == '-' ? -1 : 1) * ((iso$twoDigitNumber6 * SECONDS_PER_HOUR) + (iso$twoDigitNumber7 * SECONDS_PER_MINUTE) + iso$twoDigitNumber8);
            i4 = 1;
        } else {
            if (cCharAt4 != 'Z' && cCharAt4 != 'z') {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{35, 25, 73, 84, 2, 21, 82, 84, 24, 22, 11, 86, 70, 52, 109, 114, 65, 14, 81, 86, 75, 7, 23, 19, 7, 21, 25, 65, 14, 18, 94, 68, 81, 13, 13, 19}, "fa91aa708bc3", 2) + i10 + strDecode4 + cCharAt4 + '\'');
                throw new KotlinNothingValueException();
            }
            int i16 = i10 + 1;
            if (charSequence.length() != i16) {
                parseIso$parseFailure(charSequence, C0000.decode(new byte[]{32, 28, 65, 16, 84, 67, 23, 82, 29, 67, 69, 5, 83, 22, 80, 17, 67, 67, 13, 82, 69, 13, 91, 17, 65, 2, 13, 67, 69, 86, 17, 68, 69, 13, 70, 10, 23, 94, 10, 89, 69}, "ed5b5cc7e7") + i16);
                throw new KotlinNothingValueException();
            }
            i4 = 1;
            i3 = 0;
        }
        if (i4 > iso$twoDigitNumber || iso$twoDigitNumber >= 13) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{112, 65, 20, 6, 83, 77, 87, 5, 17, 85, 67, 84, 90, 87, 16, 11, 16, 87, 71, 12, 83, 81, 17, 25, 92, 87, 68, 82, 30, 23, 3, 83, 29, 20, 4, 86, 65, 25}, "59dc092a14c9", 0.0f) + iso$twoDigitNumber);
            throw new KotlinNothingValueException();
        }
        if (i4 > iso$twoDigitNumber2 || iso$twoDigitNumber2 > monthLength(iso$twoDigitNumber, isLeapYear(i7))) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{118, 74, 65, 93, 82, 66, 92, 80, 17, 89, 65, 79, 81, 94, 11, 93, 19, 86, 80, 65, 28, 89, 95, 25, 92, 87, 15, 77, 88, 18, 4, 86, 65, 18, 92, 87, 95, 66, 81, 20}, "3218169418a902b9", 4) + iso$twoDigitNumber + C0000.decode(new byte[]{16, 11, 80, 19, 24, 84, 80, 70, 70}, "0d63a114fb2bd0", 0.0f) + i7 + C0000.decode(new byte[]{74, 66, 87, 88, 67, 66}, "fb077ba01ae39da2", 5) + iso$twoDigitNumber2);
            throw new KotlinNothingValueException();
        }
        if (iso$twoDigitNumber3 > 23) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{113, 25, 69, 7, 87, 76, 86, 92, 20, 9, 90, 23, 70, 24, 90, 86, 20, 81, 27, 76, 6, 11, 31, 24, 83, 14, 65, 66}, "4a5b4838", 7) + iso$twoDigitNumber3);
            throw new KotlinNothingValueException();
        }
        if (iso$twoDigitNumber4 > 59) {
            parseIso$parseFailure(charSequence, C0000.decode(new byte[]{125, 73, 73, 93, 85, 70, 7, 5, 17, 12, 92, 94, 67, 77, 92, 78, 87, 87, 20, 80, 89, 71, 16, 65, 88, 15, 21, 0, 24, 23, 12, 90, 20, 17, 94, 87, 66, 18}, "819862ba1a50699c", true) + iso$twoDigitNumber4);
            throw new KotlinNothingValueException();
        }
        if (iso$twoDigitNumber5 <= 59) {
            return new UnboundLocalDateTime(i7, iso$twoDigitNumber, iso$twoDigitNumber2, iso$twoDigitNumber3, iso$twoDigitNumber4, iso$twoDigitNumber5, i2).toInstant(i3);
        }
        parseIso$parseFailure(charSequence, C0000.decode(new byte[]{32, 79, 22, 82, 6, 71, 80, 1, 65, 21, 3, 5, 89, 95, 1, 26, 9, 81, 72, 94, 92, 11, 20, 18, 3, 70, 95, 95, 69, 7, 72, 25, 80, 10, 25, 69, 6, 9, 18, 70}, "e7f7e35eafff61", false) + iso$twoDigitNumber5);
        throw new KotlinNothingValueException();
    }

    private static final void parseIso$expect(CharSequence charSequence, String str, int i, Function1<? super Character, Boolean> function1) {
        char cCharAt = charSequence.charAt(i);
        if (function1.invoke(Character.valueOf(cCharAt)).booleanValue()) {
            return;
        }
        parseIso$parseFailure(charSequence, C0000.decode(new byte[]{125, 26, 67, 0, 2, 21, 86, 5, 24}, "8b3eaa3a8f355b83") + str + C0000.decode(new byte[]{30, 65, 81, 17, 64, 65, 82, 12, 65, 25, 21}, "2a3d4a5c59", 0) + cCharAt + C0000.decode(new byte[]{65, 17, 86, 71, 67, 17, 94, 65, 89, 71, 15, 94, 89, 19}, "f173ca1203", 4) + i);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$1(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$2(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$3(char c) {
        return c == 'T' || c == 't';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$4(char c) {
        return c == ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$5(char c) {
        return c == ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$6(char c) {
        return '0' <= c && c < ':';
    }

    private static final Void parseIso$parseFailure(CharSequence charSequence, String str) {
        throw new InstantFormatException(str + C0000.decode(new byte[]{65, 68, 12, 93, 93, 20, 17, 82, 22, 75, 90, 90, 6, 19, 5, 86, 19, 125, 15, 64, 16, 89, 93, 64, 65, 85, 22, 87, 94, 20, 67}, "a3d834", 0.0f) + truncateForErrorMessage(charSequence, 64) + Typography.quote);
    }

    private static final String truncateForErrorMessage(CharSequence charSequence, int i) {
        return charSequence.length() <= i ? charSequence.toString() : charSequence.subSequence(0, i).toString() + C0000.decode(new byte[]{26, 24, 24}, "466af971d6");
    }

    private static final int parseIso$twoDigitNumber(CharSequence charSequence, int i) {
        return ((charSequence.charAt(i) - '0') * 10) + (charSequence.charAt(i + 1) - '0');
    }

    private static final void formatIso$lambda$8$appendTwoDigits(Appendable appendable, StringBuilder sb, int i) throws IOException {
        if (i < 10) {
            appendable.append('0');
        }
        sb.append(i);
    }

    private static final long safeAddOrElse(long j, long j2, Function0 function0) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    private static final long safeMultiplyOrElse(long j, long j2, Function0 function0) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0L;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    public static final boolean isLeapYear(int i) {
        if ((i & 3) == 0) {
            return i % 100 != 0 || i % 400 == 0;
        }
        return false;
    }
}
