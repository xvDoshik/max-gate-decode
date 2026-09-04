package kotlin.time;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b*\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b*\u0010(J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\r¢\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\r¢\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r¢\u0006\u0004\b6\u0010\u000fJ\r\u00107\u001a\u00020\r¢\u0006\u0004\b8\u0010\u000fJ\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010JJ\u0088\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010LJs\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010NJ^\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010PJ\u0015\u0010^\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bb\u00100J\u0015\u0010c\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bd\u0010eJ\u000f\u0010t\u001a\u00020uH\u0016¢\u0006\u0004\bv\u0010wJA\u0010x\u001a\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010.\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\rH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J!\u0010t\u001a\u00020u2\u0006\u0010.\u001a\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001a\u00020\t¢\u0006\u0005\bv\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020u¢\u0006\u0005\b\u0085\u0001\u0010wJ\u0015\u0010\u0086\u0001\u001a\u00020\r2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u00109\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010\u0005R\u001a\u0010Q\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010\u000bR\u001a\u0010U\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bV\u0010S\u001a\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\\\u0010S\u001a\u0004\b]\u0010\u000bR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0005R\u0011\u0010j\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u0005R\u0011\u0010l\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0005R\u0011\u0010p\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u0005R\u0011\u0010r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m1371constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1368appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            String strDecode = C0000.decode(new byte[]{85, 65, 18, 86, 86, 1, 28, 72, 79, 76, 77}, "41b38e4fabd63c0a");
            if (z || i6 >= 3) {
                Intrinsics.checkNotNullExpressionValue(sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3), strDecode);
            } else {
                Intrinsics.checkNotNullExpressionValue(sb.append((CharSequence) strPadStart, 0, i6), strDecode);
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m1369boximpl(long j) {
        return new Duration(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1371constructorimpl(long j) {
        if (!DurationJvmKt.getDurationAssertionsEnabled()) {
            return j;
        }
        if (m1395isInNanosimpl(j)) {
            long jM1391getValueimpl = m1391getValueimpl(j);
            if (-4611686018426999999L > jM1391getValueimpl || jM1391getValueimpl >= 4611686018427000000L) {
                throw new AssertionError(m1391getValueimpl(j) + C0000.decode(new byte[]{68, 92, 68, 19, 10, 21, 68, 93, 66, 71, 67, 9, 2, 18, 89, 82, 13, 9, 23, 87, 84, 92, 13, 2, 23, 18, 69, 82, 13, 1, 1}, "d273cf"));
            }
            return j;
        }
        long jM1391getValueimpl2 = m1391getValueimpl(j);
        if (-4611686018427387903L > jM1391getValueimpl2 || jM1391getValueimpl2 >= 4611686018427387904L) {
            throw new AssertionError(m1391getValueimpl(j) + C0000.decode(new byte[]{65, 15, 68, 20, 13, 67, 65, 95, 20, 22, 23, 91, 2, 16, 12, 89, 13, 14, 94, 71, 1, 83, 14, 94, 5, 17, 23, 70, 5, 94, 6, 85}, "ab74d0a0", 0.0f));
        }
        long jM1391getValueimpl3 = m1391getValueimpl(j);
        if (-4611686018426L > jM1391getValueimpl3 || jM1391getValueimpl3 >= 4611686018427L) {
            return j;
        }
        throw new AssertionError(m1391getValueimpl(j) + C0000.decode(new byte[]{16, 9, 68, 68, 8, 64, 16, 0, 82, 10, 14, 65, 93, 5, 91, 13, 27, 86, 84}, "0d7da3", 7));
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1374divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m1398isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m1397isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{125, 11, 64, 89, 87, 11, 87, 5, 22, 74, 86, 16, 86, 66, 82, 69, 65, 3, 77, 11, 89, 94, 19, 0, 64, 66, 76, 85, 65, 13, 25, 27, 95, 85, 95, 6, 74, 66, 87, 94, 19, 23, 87, 6, 83, 86, 90, 12, 92, 6, 22, 66, 86, 17, 76, 14, 66, 30}, "9b603b", 6));
        }
        if (m1395isInNanosimpl(j)) {
            return DurationKt.durationOfNanos(m1391getValueimpl(j) / ((long) i));
        }
        if (m1396isInfiniteimpl(j)) {
            return m1402timesUwyO8pc(j, MathKt.getSign(i));
        }
        long j2 = i;
        long jM1391getValueimpl = m1391getValueimpl(j) / j2;
        if (-4611686018426L > jM1391getValueimpl || jM1391getValueimpl >= 4611686018427L) {
            return DurationKt.durationOfMillis(jM1391getValueimpl);
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(jM1391getValueimpl) + (DurationKt.millisToNanos(m1391getValueimpl(j) - (jM1391getValueimpl * j2)) / j2));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1375equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1376equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1390getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m1391getValueimpl(long j) {
        return j >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1392hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1394isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1395isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1397isNegativeimpl(long j) {
        return j < 0;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1398isPositiveimpl(long j) {
        return j > 0;
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1400plusLRDsOJo(long j, long j2) {
        if (m1396isInfiniteimpl(j)) {
            if (m1393isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{107, 70, 9, 93, 10, 13, 5, 67, 15, 95, 94, 90, 10, 89, 23, 6, 66, 7, 19, 67, 89, 71, 13, 95, 13, 16, 66, 12, 0, 17, 92, 90, 2, 86, 6, 17, 7, 13, 18, 17, 75, 90, 3, 94, 16, 67, 27, 10, 3, 93, 92, 64, 68, 81, 13, 67, 23, 13, 2, 84, 94, 90, 10, 85, 7, 67, 16, 6, 21, 68, 84, 71, 74}, "83d0ccbcf1"));
        }
        if (m1396isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return m1394isInMillisimpl(j) ? m1367addValuesMixedRangesUwyO8pc(j, m1391getValueimpl(j), m1391getValueimpl(j2)) : m1367addValuesMixedRangesUwyO8pc(j, m1391getValueimpl(j2), m1391getValueimpl(j));
        }
        long jM1391getValueimpl = m1391getValueimpl(j) + m1391getValueimpl(j2);
        return m1395isInNanosimpl(j) ? DurationKt.durationOfNanosNormalized(jM1391getValueimpl) : DurationKt.durationOfMillisNormalized(jM1391getValueimpl);
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1402timesUwyO8pc(long j, int i) {
        if (m1396isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m1415unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{117, 65, 14, 22, 95, 71, 90, 72, 80, 91, 94, 16, 92, 88, 94, 93, 12, 11, 66, 82, 22, 85, 76, 71, 88, 68, 92, 89, 86, 20, 0, 27, 22, 77, 83, 67, 86, 21, 64, 89, 80, 90, 92, 71, 66, 3, 88, 23, 67, 95, 93, 80, 95, 89, 91, 83, 92, 20, 16, 7, 69, 66, 90, 69, 23}, "84bb6761959056"));
        }
        if (i == 0) {
            return ZERO;
        }
        long jM1391getValueimpl = m1391getValueimpl(j);
        long j2 = i;
        long j3 = jM1391getValueimpl * j2;
        if (!m1395isInNanosimpl(j)) {
            if (j3 / j2 == jM1391getValueimpl) {
                return DurationKt.durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            return MathKt.getSign(jM1391getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM1391getValueimpl && jM1391getValueimpl < 2147483648L) {
            return DurationKt.durationOfNanos(j3);
        }
        if (j3 / j2 == jM1391getValueimpl) {
            return DurationKt.durationOfNanosNormalized(j3);
        }
        long jNanosToMillis = DurationKt.nanosToMillis(jM1391getValueimpl);
        long j4 = jNanosToMillis * j2;
        long jNanosToMillis2 = DurationKt.nanosToMillis((jM1391getValueimpl - DurationKt.millisToNanos(jNanosToMillis)) * j2) + j4;
        if (j4 / j2 != jNanosToMillis || (jNanosToMillis2 ^ j4) < 0) {
            return MathKt.getSign(jM1391getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(jNanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1403toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{7, 7, 76, 91, 89, 87}, "fd8269", 0.0f));
        return function2.invoke(Long.valueOf(m1385getInWholeSecondsimpl(j)), Integer.valueOf(m1387getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1404toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, C0000.decode(new byte[]{89, 82, 65, 8, 10, 90}, "815ae40fdc20e6", 3));
        return function3.invoke(Long.valueOf(m1383getInWholeMinutesimpl(j)), Integer.valueOf(m1388getSecondsComponentimpl(j)), Integer.valueOf(m1387getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1405toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, C0000.decode(new byte[]{82, 2, 64, 91, 94, 10}, "3a421d", 3));
        return function4.invoke(Long.valueOf(m1380getInWholeHoursimpl(j)), Integer.valueOf(m1386getMinutesComponentimpl(j)), Integer.valueOf(m1388getSecondsComponentimpl(j)), Integer.valueOf(m1387getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1406toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, C0000.decode(new byte[]{82, 5, 70, 12, 13, 95}, "3f2eb1", 0));
        return function5.invoke(Long.valueOf(m1379getInWholeDaysimpl(j)), Integer.valueOf(m1378getHoursComponentimpl(j)), Integer.valueOf(m1386getMinutesComponentimpl(j)), Integer.valueOf(m1388getSecondsComponentimpl(j)), Integer.valueOf(m1387getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1407toDoubleimpl(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{69, 86, 93, 66}, "0846447fdb3f8b", true));
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m1391getValueimpl(j), m1389getStorageUnitimpl(j), durationUnit);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m1408toIntimpl(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{70, 13, 91, 17}, "3c2e5d34aa9d1e"));
        return (int) RangesKt.coerceIn(m1410toLongimpl(j, durationUnit), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m1409toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m1397isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append(C0000.decode(new byte[]{105, 54}, "9b813ad09a"));
        long jM1377getAbsoluteValueUwyO8pc = m1377getAbsoluteValueUwyO8pc(j);
        long jM1380getInWholeHoursimpl = m1380getInWholeHoursimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1386getMinutesComponentimpl = m1386getMinutesComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1388getSecondsComponentimpl = m1388getSecondsComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1387getNanosecondsComponentimpl = m1387getNanosecondsComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        long j2 = m1396isInfiniteimpl(j) ? 9999999999999L : jM1380getInWholeHoursimpl;
        boolean z = true;
        boolean z2 = j2 != 0;
        boolean z3 = (iM1388getSecondsComponentimpl == 0 && iM1387getNanosecondsComponentimpl == 0) ? false : true;
        if (iM1386getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(j2).append('H');
        }
        if (z) {
            sb.append(iM1386getMinutesComponentimpl).append('M');
        }
        if (z3 || (!z2 && !z)) {
            m1368appendFractionalimpl(j, sb, iM1388getSecondsComponentimpl, iM1387getNanosecondsComponentimpl, 9, C0000.decode(new byte[]{54}, "ee413d2bc60f", 0.0f), true);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1410toLongimpl(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{66, 92, 90, 16}, "723d6e0d0c835390", false));
        if (j == INFINITE) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m1391getValueimpl(j), m1389getStorageUnitimpl(j), durationUnit);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m1412toStringimpl(long j, DurationUnit durationUnit, int i) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{65, 87, 10, 66}, "49c6e7c89711", 4));
        if (i < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{81, 93, 80, 12, 14, 89, 84, 75, 68, 9, 17, 21, 71, 17, 87, 93, 19, 11, 12, 76, 24, 86, 1, 3, 5, 18, 90, 71, 80, 20, 19, 7, 22, 76, 24, 79, 5, 23, 68}, "583ec888dddf31", 0) + i).toString());
        }
        double dM1407toDoubleimpl = m1407toDoubleimpl(j, durationUnit);
        return Double.isInfinite(dM1407toDoubleimpl) ? String.valueOf(dM1407toDoubleimpl) : DurationJvmKt.formatToExactDecimals(dM1407toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt.shortName(durationUnit);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m1414truncateToUwyO8pc$kotlin_stdlib(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{23, 94, 13, 22}, "b0db1c42", 0.0f));
        DurationUnit durationUnitM1389getStorageUnitimpl = m1389getStorageUnitimpl(j);
        if (durationUnit.compareTo(durationUnitM1389getStorageUnitimpl) <= 0 || m1396isInfiniteimpl(j)) {
            return j;
        }
        return DurationKt.toDuration(m1391getValueimpl(j) - (m1391getValueimpl(j) % DurationUnitKt.convertDurationUnit(1L, durationUnit, durationUnitM1389getStorageUnitimpl)), durationUnitM1389getStorageUnitimpl);
    }

    public boolean equals(Object other) {
        return m1375equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m1392hashCodeimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1416compareToLRDsOJo(duration.getRawValue());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m1389getStorageUnitimpl(long j) {
        return m1395isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b5\u00103J\u0015\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b7J\u0015\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b9R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0017\u0010\u001bR\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001dR\u001f\u0010!\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001f\u0010!\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001bR\u001f\u0010!\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001dR\u001f\u0010$\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001f\u0010$\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u001f\u0010$\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001dR\u001f\u0010'\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001f\u0010'\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001bR\u001f\u0010'\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u0010*\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001bR\u001f\u0010*\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001dR\u001f\u0010-\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001f\u0010-\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001bR\u001f\u0010-\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001d¨\u0006:"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "ZERO", "Lkotlin/time/Duration;", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "", "(J)V", "(J)J", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1421getDaysUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1422getDaysUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1423getDaysUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1427getHoursUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1428getHoursUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1429getHoursUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1433getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1434getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1435getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1439getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1440getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1441getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1445getMinutesUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1446getMinutesUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1447getMinutesUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1451getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1452getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1453getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1457getSecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1458getSecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1459getSecondsUwyO8pc$annotations(long j) {
        }

        public final double convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, C0000.decode(new byte[]{70, 90, 19, 65, 7, 1, 54, 8, 11, 70}, "55f3ddcfb2e3be"));
            Intrinsics.checkNotNullParameter(targetUnit, C0000.decode(new byte[]{67, 7, 20, 94, 4, 77, 101, 12, 13, 65}, "7ff9a90bd5b7", false));
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m1463parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{19, 83, 9, 19, 1}, "e2efd7a5f26642", false));
            try {
                return DurationKt.parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{45, 15, 65, 3, 94, 15, 80, 70, 93, 68, 22, 4, 16, 8, 88, 12, 18, 21, 64, 20, 80, 95, 3, 69, 2, 14, 69, 15, 83, 18, 14, 70, 30}, "da7b2f4f91de", true) + value + C0000.decode(new byte[]{66, 24}, "e677fb", false), e);
            }
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m1464parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{68, 86, 13, 19, 6}, "27afcac61f"));
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{124, 91, 23, 86, 85, 11, 82, 68, 44, 106, 123, 25, 84, 16, 71, 84, 21, 94, 86, 12, 22, 23, 17, 75, 93, 87, 87, 69, 83, 90, 19, 90, 88, 22, 12, 68, 66}, "55a79b6de9490e") + value + C0000.decode(new byte[]{69, 25}, "b70daf06", 4), e);
            }
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m1465parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{79, 83, 94, 69, 3}, "9220ff8fb8f32b", 0.0f));
            try {
                return Duration.m1369boximpl(DurationKt.parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m1466parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{23, 82, 9, 64, 84}, "a3e519942c7bd58a"));
            try {
                return Duration.m1369boximpl(DurationKt.parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m1462getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m1460getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m1461getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1449getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1450getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1448getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1431getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1432getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1430getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1437getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1438getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1436getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1455getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1456getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1454getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1443getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1444getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1442getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1425getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1426getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1424getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1419getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1420getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1418getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1415unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m1391getValueimpl(j), ((int) j) & 1);
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m1367addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long j4 = j2 + jNanosToMillis;
        if (-4611686018426L > j4 || j4 >= 4611686018427L) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, DurationKt.MAX_MILLIS));
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(j4) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1399minusLRDsOJo(long j, long j2) {
        return m1400plusLRDsOJo(j, m1415unaryMinusUwyO8pc(j2));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1401timesUwyO8pc(long j, double d) {
        int iRoundToInt = MathKt.roundToInt(d);
        if (iRoundToInt == d) {
            return m1402timesUwyO8pc(j, iRoundToInt);
        }
        DurationUnit durationUnitM1389getStorageUnitimpl = m1389getStorageUnitimpl(j);
        return DurationKt.toDuration(m1407toDoubleimpl(j, durationUnitM1389getStorageUnitimpl) * d, durationUnitM1389getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1373divUwyO8pc(long j, double d) {
        int iRoundToInt = MathKt.roundToInt(d);
        if (iRoundToInt == d && iRoundToInt != 0) {
            return m1374divUwyO8pc(j, iRoundToInt);
        }
        DurationUnit durationUnitM1389getStorageUnitimpl = m1389getStorageUnitimpl(j);
        return DurationKt.toDuration(m1407toDoubleimpl(j, durationUnitM1389getStorageUnitimpl) / d, durationUnitM1389getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1372divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.maxOf(m1389getStorageUnitimpl(j), m1389getStorageUnitimpl(j2));
        return m1407toDoubleimpl(j, durationUnit) / m1407toDoubleimpl(j2, durationUnit);
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1396isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1393isFiniteimpl(long j) {
        return !m1396isInfiniteimpl(j);
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1377getAbsoluteValueUwyO8pc(long j) {
        return m1397isNegativeimpl(j) ? m1415unaryMinusUwyO8pc(j) : j;
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1416compareToLRDsOJo(long j) {
        return m1370compareToLRDsOJo(this.rawValue, j);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1370compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m1397isNegativeimpl(j) ? -i : i;
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1378getHoursComponentimpl(long j) {
        if (m1396isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1380getInWholeHoursimpl(j) % ((long) 24));
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1386getMinutesComponentimpl(long j) {
        if (m1396isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1383getInWholeMinutesimpl(j) % ((long) 60));
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1388getSecondsComponentimpl(long j) {
        if (m1396isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1385getInWholeSecondsimpl(j) % ((long) 60));
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1387getNanosecondsComponentimpl(long j) {
        long jM1391getValueimpl;
        if (m1396isInfiniteimpl(j)) {
            return 0;
        }
        if (m1394isInMillisimpl(j)) {
            jM1391getValueimpl = DurationKt.millisToNanos(m1391getValueimpl(j) % ((long) 1000));
        } else {
            jM1391getValueimpl = m1391getValueimpl(j) % ((long) InstantKt.NANOS_PER_SECOND);
        }
        return (int) jM1391getValueimpl;
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1379getInWholeDaysimpl(long j) {
        return m1410toLongimpl(j, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1380getInWholeHoursimpl(long j) {
        return m1410toLongimpl(j, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1383getInWholeMinutesimpl(long j) {
        return m1410toLongimpl(j, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1385getInWholeSecondsimpl(long j) {
        return m1410toLongimpl(j, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1382getInWholeMillisecondsimpl(long j) {
        return (m1394isInMillisimpl(j) && m1393isFiniteimpl(j)) ? m1391getValueimpl(j) : m1410toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1381getInWholeMicrosecondsimpl(long j) {
        return m1410toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1384getInWholeNanosecondsimpl(long j) {
        long jM1391getValueimpl = m1391getValueimpl(j);
        if (m1395isInNanosimpl(j)) {
            return jM1391getValueimpl;
        }
        if (jM1391getValueimpl > 9223372036854L) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (jM1391getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(jM1391getValueimpl);
    }

    public String toString() {
        return m1411toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1411toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM1397isNegativeimpl = m1397isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM1397isNegativeimpl) {
            sb.append('-');
        }
        long jM1377getAbsoluteValueUwyO8pc = m1377getAbsoluteValueUwyO8pc(j);
        long jM1379getInWholeDaysimpl = m1379getInWholeDaysimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1378getHoursComponentimpl = m1378getHoursComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1386getMinutesComponentimpl = m1386getMinutesComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1388getSecondsComponentimpl = m1388getSecondsComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        int iM1387getNanosecondsComponentimpl = m1387getNanosecondsComponentimpl(jM1377getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM1379getInWholeDaysimpl != 0;
        boolean z2 = iM1378getHoursComponentimpl != 0;
        boolean z3 = iM1386getMinutesComponentimpl != 0;
        boolean z4 = (iM1388getSecondsComponentimpl == 0 && iM1387getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM1379getInWholeDaysimpl).append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM1378getHoursComponentimpl).append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM1386getMinutesComponentimpl).append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM1388getSecondsComponentimpl != 0 || z || z2 || z3) {
                m1368appendFractionalimpl(j, sb, iM1388getSecondsComponentimpl, iM1387getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM1387getNanosecondsComponentimpl >= 1000000) {
                m1368appendFractionalimpl(j, sb, iM1387getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS, iM1387getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (iM1387getNanosecondsComponentimpl >= 1000) {
                m1368appendFractionalimpl(j, sb, iM1387getNanosecondsComponentimpl / 1000, iM1387getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM1387getNanosecondsComponentimpl).append("ns");
            }
            i = i4;
        }
        if (zM1397isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m1413toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1412toStringimpl(j, durationUnit, i);
    }
}
