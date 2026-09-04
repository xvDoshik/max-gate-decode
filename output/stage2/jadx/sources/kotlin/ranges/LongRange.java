package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.LongCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001bB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0013\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\f\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006\u001c"}, d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJ)V", "getStart", "()Ljava/lang/Long;", "getEndInclusive", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "contains", "", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LongRange extends LongProgression implements ClosedRange<Long>, OpenEndRange<Long> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LongRange EMPTY = new LongRange(1, 0);

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static /* synthetic */ void getEndExclusive$annotations() {
    }

    @Override // kotlin.ranges.OpenEndRange
    public Long getEndExclusive() {
        if (getLast() != LongCompanionObject.MAX_VALUE) {
            return Long.valueOf(getLast() + 1);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{117, 81, 89, 93, 87, 16, 22, 67, 86, 70, 22, 69, 94, 22, 66, 88, 82, 19, 93, 28, 85, 93, 70, 65, 10, 65, 85, 22, 67, 64, 71, 86, 74, 68, 84, 94, 70, 92, 7, 23, 95, 80, 22, 81, 23, 65, 89, 10, 81, 84, 19, 70, 11, 86, 68, 22, 95, 94, 84, 95, 77, 0, 83, 66, 19, ByteCompanionObject.MAX_VALUE, 34, 111, 111, 96, 119, 124, 98, 118, 22}, "60738d6132c706", true).toString());
    }

    @Override // kotlin.ranges.LongProgression
    public String toString() {
        return getFirst() + C0000.decode(new byte[]{25, 72}, "7f122805a07cdf98", 1) + getLast();
    }

    public LongRange(long j, long j2) {
        super(j, j2, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).longValue());
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public Long getStart() {
        return Long.valueOf(getFirst());
    }

    @Override // kotlin.ranges.ClosedRange
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    public boolean contains(long value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // kotlin.ranges.LongProgression, kotlin.ranges.ClosedRange, kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.LongProgression
    public boolean equals(Object other) {
        if (!(other instanceof LongRange)) {
            return false;
        }
        if (isEmpty() && ((LongRange) other).isEmpty()) {
            return true;
        }
        LongRange longRange = (LongRange) other;
        return getFirst() == longRange.getFirst() && getLast() == longRange.getLast();
    }

    @Override // kotlin.ranges.LongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/ranges/LongRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongRange getEMPTY() {
            return LongRange.EMPTY;
        }
    }
}
