package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\b\u001a\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", "duration", "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1475checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m1396isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{55, 22, 94, 88, 90, 90, 82, 16, 13, 13, 85, 92, 93, 93, 65, 89, 1, 16, 19, 90, 85, 20, 81, 89, 2, 5, 86, 71, 86, 90, 65, 16, 23, 10, 84, 91, 64}, "dc353450", false));
    }

    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == LongCompanionObject.MAX_VALUE;
    }

    public static final long saturatingDiff(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{23, 94, 8, 67}, "b0a7db", true));
        return (1 | (j2 - 1)) == LongCompanionObject.MAX_VALUE ? Duration.m1415unaryMinusUwyO8pc(infinityOfSign(j2)) : saturatingFiniteDiff(j, j2, durationUnit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{17, 8, 95, 17}, "df6efbdf957ef321", 0.0f));
        if (((j2 - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return j == j2 ? Duration.INSTANCE.m1462getZEROUwyO8pc() : Duration.m1415unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return (1 | (j - 1)) == LongCompanionObject.MAX_VALUE ? infinityOfSign(j) : saturatingFiniteDiff(j, j2, durationUnit);
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m1476saturatingAddNuflL3o(long j, DurationUnit unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jM1410toLongimpl = Duration.m1410toLongimpl(j2, unit);
        if (((j - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return m1475checkInfiniteSumDefinedPjuGub4(j, j2, jM1410toLongimpl);
        }
        if (((jM1410toLongimpl - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return m1477saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + jM1410toLongimpl;
        if (((j ^ j3) & (jM1410toLongimpl ^ j3)) >= 0) {
            return j3;
        }
        if (j < 0) {
            return Long.MIN_VALUE;
        }
        return LongCompanionObject.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m1477saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long jM1374divUwyO8pc = Duration.m1374divUwyO8pc(j2, 2);
        long jM1410toLongimpl = Duration.m1410toLongimpl(jM1374divUwyO8pc, durationUnit);
        return (1 | (jM1410toLongimpl - 1)) == LongCompanionObject.MAX_VALUE ? jM1410toLongimpl : m1476saturatingAddNuflL3o(m1476saturatingAddNuflL3o(j, durationUnit, jM1374divUwyO8pc), durationUnit, Duration.m1399minusLRDsOJo(j2, jM1374divUwyO8pc));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.INSTANCE.m1461getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.INSTANCE.m1460getINFINITEUwyO8pc();
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            if (durationUnit.compareTo(DurationUnit.MILLISECONDS) < 0) {
                long jConvertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, durationUnit);
                long j4 = (j / jConvertDurationUnit) - (j2 / jConvertDurationUnit);
                long j5 = (j % jConvertDurationUnit) - (j2 % jConvertDurationUnit);
                Duration.Companion companion = Duration.INSTANCE;
                return Duration.m1400plusLRDsOJo(DurationKt.toDuration(j4, DurationUnit.MILLISECONDS), DurationKt.toDuration(j5, durationUnit));
            }
            return Duration.m1415unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnit);
    }
}
