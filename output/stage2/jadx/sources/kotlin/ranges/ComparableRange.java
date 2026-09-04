package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, d2 = {"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getStart", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getEndInclusive", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    private final T endInclusive;
    private final T start;

    public ComparableRange(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{21, 68, 88, 65, 22}, "f093bd4239", 0.0f));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{4, 91, 84, 40, 15, 91, 9, 71, 16, 15, 64, 6}, "a50aa8e2cf6c16", true));
        this.start = t;
        this.endInclusive = t2;
    }

    public String toString() {
        return getStart() + C0000.decode(new byte[]{25, 30}, "70fa489f37") + getEndInclusive();
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public boolean contains(T t) {
        return ClosedRange.DefaultImpls.contains(this, t);
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public T getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getEndInclusive() {
        return this.endInclusive;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ComparableRange)) {
            return false;
        }
        if (isEmpty() && ((ComparableRange) other).isEmpty()) {
            return true;
        }
        ComparableRange comparableRange = (ComparableRange) other;
        return Intrinsics.areEqual(getStart(), comparableRange.getStart()) && Intrinsics.areEqual(getEndInclusive(), comparableRange.getEndInclusive());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }
}
