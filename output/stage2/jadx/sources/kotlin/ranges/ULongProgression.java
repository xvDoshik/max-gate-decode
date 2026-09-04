package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0086\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0013\u0010\t\u001a\u00020\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "iterator", "", "isEmpty", "", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    private ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{106, 66, 1, 18, 25, 88, 77, 21, 77, 69, 1, 7, 25, 88, 11, 12, 20, 79, 93, 20, 86, 75}, "96db958f9ecb", false));
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{49, 69, 0, 22, 16, 9, 77, 64, 71, 67, 82, 87, 66, 86, 23, 3, 81, 16, 93, 65, 19, 23, 88, 83, 12, 17, 41, 9, 94, 3, 22, 126, 122, 45, 111, 100, 35, 125, 48, 35, 16, 16, 87, 19, 82, 21, 95, 91, 6, 17, 10, 16, 85, 22, 94, 95, 92, 20, 16, 93, 12, 17, 11, 3, 87, 5, 76, 90, 92, 13, 30}, "b1ef0d833c02"));
        }
        this.first = j;
        this.last = UProgressionUtilKt.m1240getProgressionLastElement7ftBX0g(j, j2, j3);
        this.step = j3;
    }

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public String toString() {
        StringBuilder sbAppend;
        long j;
        long j2 = this.step;
        String strDecode = C0000.decode(new byte[]{25, 68, 21, 0, 70, 17}, "97ae614528f84f", true);
        if (j2 > 0) {
            sbAppend = new StringBuilder().append((Object) ULong.m246toStringimpl(this.first)).append(C0000.decode(new byte[]{30, 29}, "038b3e3b345d92", 0.0f)).append((Object) ULong.m246toStringimpl(this.last)).append(strDecode);
            j = this.step;
        } else {
            sbAppend = new StringBuilder().append((Object) ULong.m246toStringimpl(this.first)).append(C0000.decode(new byte[]{66, 85, 9, 18, 90, 101, 86, 19}, "b1fe419331adc9a5")).append((Object) ULong.m246toStringimpl(this.last)).append(strDecode);
            j = -this.step;
        }
        return sbAppend.append(j).toString();
    }

    /* JADX INFO: renamed from: getFirst-s-VKNKU, reason: not valid java name and from getter */
    public final long getFirst() {
        return this.first;
    }

    /* JADX INFO: renamed from: getLast-s-VKNKU, reason: not valid java name and from getter */
    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public boolean isEmpty() {
        long j = this.step;
        long j2 = this.first;
        long j3 = this.last;
        if (j > 0) {
            return Long.compareUnsigned(j2, j3) > 0;
        }
        return Long.compareUnsigned(j2, j3) < 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ULongProgression)) {
            return false;
        }
        if (isEmpty() && ((ULongProgression) other).isEmpty()) {
            return true;
        }
        ULongProgression uLongProgression = (ULongProgression) other;
        return this.first == uLongProgression.first && this.last == uLongProgression.last && this.step == uLongProgression.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.first;
        int iM200constructorimpl = ((int) ULong.m200constructorimpl(j ^ ULong.m200constructorimpl(j >>> 32))) * 31;
        long j2 = this.last;
        int iM200constructorimpl2 = (iM200constructorimpl + ((int) ULong.m200constructorimpl(j2 ^ ULong.m200constructorimpl(j2 >>> 32)))) * 31;
        long j3 = this.step;
        return iM200constructorimpl2 + ((int) ((j3 >>> 32) ^ j3));
    }

    /* JADX INFO: compiled from: ULongRange.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final ULongProgression m1268fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new ULongProgression(rangeStart, rangeEnd, step, null);
        }
    }
}
