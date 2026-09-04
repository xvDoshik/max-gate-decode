package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "<init>", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "iterator", "Lkotlin/collections/IntIterator;", "isEmpty", "", "equals", "other", "", "hashCode", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int first;
    private final int last;
    private final int step;

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{107, 68, 83, 66, 19, 15, 67, 71, 69, 23, 3, 7, 70, 89, 94, 12, 21, 74, 83, 64, 92, 76}, "80623b6417abf71b", 0));
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{54, 76, 83, 68, 24, 88, 69, 75, 21, 69, 81, 87, 69, 95, 68, 81, 89, 65, 85, 74, 65, 17, 91, 83, 11, 24, ByteCompanionObject.MAX_VALUE, 90, 76, 27, 125, 113, 47, 58, 101, 115, 41, 109, 115, 20, 76, 90, 16, 89, 23, 10, 90, 86, 69, 87, 64, 81, 74, 83, 92, 87, 22, 69, 92, 92, 69, 86, 83, 83, 89, 65, 89, 87, 15, 75}, "e8648508ae32", 0.0f));
        }
        this.first = i;
        this.last = ProgressionUtilKt.getProgressionLastElement(i, i2, i3);
        this.step = i3;
    }

    public String toString() {
        StringBuilder sbAppend;
        int i;
        int i2 = this.step;
        String strDecode = C0000.decode(new byte[]{23, 22, 67, 87, 17, 18}, "7e72a2", 0.0f);
        if (i2 > 0) {
            sbAppend = new StringBuilder().append(this.first).append(C0000.decode(new byte[]{24, 77}, "6cd64c", 0)).append(this.last).append(strDecode);
            i = this.step;
        } else {
            sbAppend = new StringBuilder().append(this.first).append(C0000.decode(new byte[]{69, 85, 9, 64, 91, 96, 10, 17}, "e1f754", false)).append(this.last).append(strDecode);
            i = -this.step;
        }
        return sbAppend.append(i).toString();
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new IntProgressionIterator(this.first, this.last, this.step);
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            return this.first > this.last;
        }
        return this.first < this.last;
    }

    public boolean equals(Object other) {
        if (!(other instanceof IntProgression)) {
            return false;
        }
        if (isEmpty() && ((IntProgression) other).isEmpty()) {
            return true;
        }
        IntProgression intProgression = (IntProgression) other;
        return this.first == intProgression.first && this.last == intProgression.last && this.step == intProgression.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    /* JADX INFO: compiled from: Progressions.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntProgression fromClosedRange(int rangeStart, int rangeEnd, int step) {
            return new IntProgression(rangeStart, rangeEnd, step);
        }
    }
}
