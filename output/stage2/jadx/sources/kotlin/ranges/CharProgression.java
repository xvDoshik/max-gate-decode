package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\t\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "<init>", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "iterator", "Lkotlin/collections/CharIterator;", "isEmpty", "", "equals", "other", "", "hashCode", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final char first;
    private final char last;
    private final int step;

    public CharProgression(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{100, 67, 93, 20, 24, 14, 19, 69, 66, 70, 90, 80, 23, 89, 87, 10, 21, 25, 3, 68, 89, 72}, "778d8cf66f85", true));
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{107, 17, 7, 19, 67, 14, 19, 69, 64, 68, 90, 0, 66, 4, 17, 6, 7, 66, 81, 22, 24, 17, 10, 2, 13, 67, 47, 88, 64, 74, 117, 44, 44, 60, 53, 34, 42, 99, 113, 68, 76, 10, 66, 2, 21, 12, 15, 82, 20, 11, 78, 0, 16, 5, 15, 12, 17, 22, 91, 10, 24, 11, 7, 4, 2, 23, 15, 89, 90, 74}, "8ebcccf64d", 5));
        }
        this.first = c;
        this.last = (char) ProgressionUtilKt.getProgressionLastElement((int) c, (int) c2, i);
        this.step = i;
    }

    public String toString() {
        StringBuilder sbAppend;
        int i;
        int i2 = this.step;
        String strDecode = C0000.decode(new byte[]{66, 65, 71, 82, 70, 23}, "b237671e217123", 4);
        if (i2 > 0) {
            sbAppend = new StringBuilder().append(this.first).append(C0000.decode(new byte[]{75, 75}, "eee3d8384a", 0.0f)).append(this.last).append(strDecode);
            i = this.step;
        } else {
            sbAppend = new StringBuilder().append(this.first).append(C0000.decode(new byte[]{19, 7, 86, 22, 12, 101, 95, 17}, "3c9ab10174403055", 7)).append(this.last).append(strDecode);
            i = -this.step;
        }
        return sbAppend.append(i).toString();
    }

    public final char getFirst() {
        return this.first;
    }

    public final char getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            return Intrinsics.compare((int) this.first, (int) this.last) > 0;
        }
        return Intrinsics.compare((int) this.first, (int) this.last) < 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof CharProgression)) {
            return false;
        }
        if (isEmpty() && ((CharProgression) other).isEmpty()) {
            return true;
        }
        CharProgression charProgression = (CharProgression) other;
        return this.first == charProgression.first && this.last == charProgression.last && this.step == charProgression.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    /* JADX INFO: compiled from: Progressions.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CharProgression fromClosedRange(char rangeStart, char rangeEnd, int step) {
            return new CharProgression(rangeStart, rangeEnd, step);
        }
    }
}
