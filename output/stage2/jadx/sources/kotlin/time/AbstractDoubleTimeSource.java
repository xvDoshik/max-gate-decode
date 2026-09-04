package kotlin.time;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Deprecated(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "markNow", "Lkotlin/time/ComparableTimeMark;", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    public AbstractDoubleTimeSource(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{76, 93, 93, 67}, "9347cdcad5", 6));
        this.unit = durationUnit;
    }

    protected abstract double read();

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        private DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j) {
            Intrinsics.checkNotNullParameter(abstractDoubleTimeSource, C0000.decode(new byte[]{18, 94, 93, 7, 107, 14, 68, 64, 5, 7}, "f70b8a12fb", false));
            this.startedAt = d;
            this.timeSource = abstractDoubleTimeSource;
            this.offset = j;
        }

        public /* synthetic */ DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, abstractDoubleTimeSource, j);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
        public long mo1363minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, C0000.decode(new byte[]{95, 71, 81, 81, 68}, "03946d", 0));
            if (other instanceof DoubleTimeMark) {
                DoubleTimeMark doubleTimeMark = (DoubleTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, doubleTimeMark.timeSource)) {
                    if (Duration.m1376equalsimpl0(this.offset, doubleTimeMark.offset) && Duration.m1396isInfiniteimpl(this.offset)) {
                        return Duration.INSTANCE.m1462getZEROUwyO8pc();
                    }
                    long jM1399minusLRDsOJo = Duration.m1399minusLRDsOJo(this.offset, doubleTimeMark.offset);
                    long duration = DurationKt.toDuration(this.startedAt - doubleTimeMark.startedAt, this.timeSource.getUnit());
                    return Duration.m1376equalsimpl0(duration, Duration.m1415unaryMinusUwyO8pc(jM1399minusLRDsOJo)) ? Duration.INSTANCE.m1462getZEROUwyO8pc() : Duration.m1400plusLRDsOJo(duration, jM1399minusLRDsOJo);
                }
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{96, 64, 81, 66, 16, 5, 83, 69, 92, 87, 84, 21, 92, 68, 66, 7, 95, 92, 69, 88, 65, 92, 93, 81, 66, 16, 89, 92, 80, 25, 94, 84, 65, 93, 17, 68, 86, 67, 90, 84, 19, 81, 90, 80, 4, 1, 66, 84, 91, 77, 19, 65, 90, 91, 7, 68, 67, 94, 64, 75, 80, 80, 64, 22, 11, 23, 16, 95, 90, 77, 19, 69, 92, 69, 17, 13, 82, 93, 80, 3, 19}, "3536bd0159") + this + C0000.decode(new byte[]{16, 4, 95, 7, 68}, "0e1cdd34608497e4", 0) + other);
        }

        public String toString() {
            return C0000.decode(new byte[]{38, 88, 71, 81, 88, 93, 97, 80, 89, 93, 47, 86, 64, 88, 28}, "b723485948", 0.0f) + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + C0000.decode(new byte[]{18, 27, 66}, "20be02c638cac89a", true) + ((Object) Duration.m1411toStringimpl(this.offset)) + C0000.decode(new byte[]{74, 22}, "f6df0a2b", 5) + this.timeSource + ')';
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
        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo1362minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m1366minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public long mo1361elapsedNowUwyO8pc() {
            return Duration.m1399minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo1364plusLRDsOJo(long duration) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m1400plusLRDsOJo(this.offset, duration), null);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object other) {
            return (other instanceof DoubleTimeMark) && Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) other).timeSource) && Duration.m1376equalsimpl0(mo1363minusUwyO8pc((ComparableTimeMark) other), Duration.INSTANCE.m1462getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return Duration.m1392hashCodeimpl(Duration.m1400plusLRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }
    }

    @Override // kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new DoubleTimeMark(read(), this, Duration.INSTANCE.m1462getZEROUwyO8pc(), null);
    }
}
