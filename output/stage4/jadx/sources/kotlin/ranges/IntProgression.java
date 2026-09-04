package kotlin.ranges;

import java.util.Iterator;
import kotlin.text.CharsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class IntProgression implements Iterable {
    public final int first;
    public final int last;
    public final int step;

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{101, 71, 87, 22, 16, 89, 16, 74, 23, 67, 90, 0, 17, 90, 89, 93, 31, 28, 85, 70, 10, 23}, "632f04e9cc8e14", 0.0f));
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{48, 65, 3, 66, 24, 11, 66, 22, 23, 21, 4, 87, 24, 1, 69, 0, 2, 65, 3, 64, 24, 18, 95, 4, 13, 21, 47, 92, 76, 72, 122, 44, 45, 106, 48, 115, 116, 51, 114, 69, 23, 90, 70, 83, 78, 9, 94, 1, 67, 90, 16, 87, 74, 0, 91, 10, 20, 21, 9, 92, 24, 8, 82, 2, 2, 65, 15, 93, 86, 72}, "c5f28f7e", 1));
        }
        this.first = i;
        this.last = CharsKt.getProgressionLastElement(i, i2, i3);
        this.step = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntProgression)) {
            return false;
        }
        if (isEmpty() && ((IntProgression) obj).isEmpty()) {
            return true;
        }
        IntProgression intProgression = (IntProgression) obj;
        return this.first == intProgression.first && this.last == intProgression.last && this.step == intProgression.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        int i = this.step;
        int i2 = this.last;
        int i3 = this.first;
        if (i > 0) {
            return i3 > i2;
        }
        return i3 < i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new IntProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        StringBuilder sb;
        String strDecode = C0000.decode(new byte[]{25, 67, 21, 6, 69, 25}, "90ac59a8634d0981", true);
        int i = this.last;
        int i2 = this.first;
        int i3 = this.step;
        if (i3 > 0) {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(C0000.decode(new byte[]{75, 22}, "e8508c5cc8"));
            sb.append(i);
            sb.append(strDecode);
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(C0000.decode(new byte[]{23, 81, 86, 17, 92, 100, 10, 20}, "759f20e4c4bb83", 0.0f));
            sb.append(i);
            sb.append(strDecode);
            sb.append(-i3);
        }
        return sb.toString();
    }
}
