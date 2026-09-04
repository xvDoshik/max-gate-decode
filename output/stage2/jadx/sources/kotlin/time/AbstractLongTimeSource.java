package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH$J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    /* JADX INFO: renamed from: zero$delegate, reason: from kotlin metadata */
    private final Lazy zero;

    public AbstractLongTimeSource(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{71, 93, 94, 66}, "2376a1"));
        this.unit = durationUnit;
        this.zero = LazyKt.lazy(new Function0() { // from class: kotlin.time.AbstractLongTimeSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(this.f$0.read());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long read();

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return read() - getZero();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        private LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2) {
            Intrinsics.checkNotNullParameter(abstractLongTimeSource, C0000.decode(new byte[]{67, 90, 94, 87, 49, 89, 20, 74, 84, 81}, "7332b6a874"));
            this.startedAt = j;
            this.timeSource = abstractLongTimeSource;
            this.offset = j2;
        }

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo1363minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, C0000.decode(new byte[]{91, 70, 12, 1, 71}, "42dd5da8d3", 4));
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m1400plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m1399minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{55, 19, 80, 69, 19, 4, 86, 23, 8, 11, 5, 17, 11, 20, 18, 82, 14, 8, 69, 2, 19, 12, 12, 86, 68, 18, 91, 92, 4, 69, 88, 2, 19, 14, 17, 17, 2, 20, 93, 92, 65, 1, 92, 5, 7, 0, 16, 84, 10, 18, 18, 69, 8, 8, 80, 67, 18, 10, 23, 67, 7, 3, 65, 17, 8, 22, 21, 13, 14, 17, 66, 65, 11, 21, 65, 88, 3, 9, 80, 89, 65}, "df21ae5caeb1") + this + C0000.decode(new byte[]{25, 0, 95, 0, 66}, "9a1dbe07", true) + other);
        }

        public String toString() {
            return C0000.decode(new byte[]{122, 12, 94, 3, 48, 11, 85, 83, 43, 5, 68, 8, 24}, "6c0ddb86fd", 6) + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + C0000.decode(new byte[]{70, 18, 19}, "f93ba205b748", 0) + ((Object) Duration.m1411toStringimpl(this.offset)) + C0000.decode(new byte[]{73, 65}, "ea0c56", 7) + this.timeSource + ')';
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo1362minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m1366minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo1361elapsedNowUwyO8pc() {
            return Duration.m1399minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo1364plusLRDsOJo(long duration) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m1396isInfiniteimpl(duration)) {
                return new LongTimeMark(LongSaturatedMathKt.m1476saturatingAddNuflL3o(this.startedAt, unit, duration), this.timeSource, Duration.INSTANCE.m1462getZEROUwyO8pc(), null);
            }
            long jM1414truncateToUwyO8pc$kotlin_stdlib = Duration.m1414truncateToUwyO8pc$kotlin_stdlib(duration, unit);
            long jM1400plusLRDsOJo = Duration.m1400plusLRDsOJo(Duration.m1399minusLRDsOJo(duration, jM1414truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long jM1476saturatingAddNuflL3o = LongSaturatedMathKt.m1476saturatingAddNuflL3o(this.startedAt, unit, jM1414truncateToUwyO8pc$kotlin_stdlib);
            long jM1414truncateToUwyO8pc$kotlin_stdlib2 = Duration.m1414truncateToUwyO8pc$kotlin_stdlib(jM1400plusLRDsOJo, unit);
            long jM1476saturatingAddNuflL3o2 = LongSaturatedMathKt.m1476saturatingAddNuflL3o(jM1476saturatingAddNuflL3o, unit, jM1414truncateToUwyO8pc$kotlin_stdlib2);
            long jM1399minusLRDsOJo = Duration.m1399minusLRDsOJo(jM1400plusLRDsOJo, jM1414truncateToUwyO8pc$kotlin_stdlib2);
            long jM1384getInWholeNanosecondsimpl = Duration.m1384getInWholeNanosecondsimpl(jM1399minusLRDsOJo);
            if (jM1476saturatingAddNuflL3o2 != 0 && jM1384getInWholeNanosecondsimpl != 0 && (jM1476saturatingAddNuflL3o2 ^ jM1384getInWholeNanosecondsimpl) < 0) {
                long duration2 = DurationKt.toDuration(MathKt.getSign(jM1384getInWholeNanosecondsimpl), unit);
                jM1476saturatingAddNuflL3o2 = LongSaturatedMathKt.m1476saturatingAddNuflL3o(jM1476saturatingAddNuflL3o2, unit, duration2);
                jM1399minusLRDsOJo = Duration.m1399minusLRDsOJo(jM1399minusLRDsOJo, duration2);
            }
            if ((1 | (jM1476saturatingAddNuflL3o2 - 1)) == LongCompanionObject.MAX_VALUE) {
                jM1399minusLRDsOJo = Duration.INSTANCE.m1462getZEROUwyO8pc();
            }
            return new LongTimeMark(jM1476saturatingAddNuflL3o2, this.timeSource, jM1399minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object other) {
            return (other instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource) && Duration.m1376equalsimpl0(mo1363minusUwyO8pc((ComparableTimeMark) other), Duration.INSTANCE.m1462getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m1392hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }
    }

    @Override // kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.INSTANCE.m1462getZEROUwyO8pc(), null);
    }
}
