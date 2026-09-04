package kotlin.ranges;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class IntRange extends IntProgression {
    public static final IntRange EMPTY = new IntRange(1, 0, 1);

    public final boolean contains(int i) {
        return this.first <= i && i <= this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof IntRange)) {
            return false;
        }
        if (isEmpty() && ((IntRange) obj).isEmpty()) {
            return true;
        }
        IntRange intRange = (IntRange) obj;
        return this.first == intRange.first && this.last == intRange.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean isEmpty() {
        return this.first > this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.first);
        sb.append(C0000.decode(new byte[]{23, 76}, "9b5ce6aa555e"));
        sb.append(this.last);
        return sb.toString();
    }
}
