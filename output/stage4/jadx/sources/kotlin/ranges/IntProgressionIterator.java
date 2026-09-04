package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class IntProgressionIterator implements Iterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public IntProgressionIterator(int i, int i2, int i3) {
        this.step = i3;
        this.finalElement = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.hasNext = z;
        this.next = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = this.step + i;
            return i;
        }
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        this.hasNext = false;
        return i;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 22, 86, 64, 88, 18, 94, 11, 15, 65, 91, 21, 19, 92, 86, 18, 23, 23, 20, 17, 66, 9, 65, 70, 92, 2, 23, 2, 14, 19, 18, 20, 86, 83, 93, 75, 88, 10, 13, 24, 18, 5, 92, 94, 85, 3, 84, 16, 8, 14, 92}, "2f329f7daa"));
    }
}
