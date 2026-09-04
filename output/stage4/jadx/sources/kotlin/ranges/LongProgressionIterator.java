package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class LongProgressionIterator implements Iterator {
    public final long finalElement;
    public boolean hasNext;
    public long next;
    public final long step;

    public LongProgressionIterator(long j, long j2, long j3) {
        this.step = j3;
        this.finalElement = j2;
        boolean z = false;
        if (j3 <= 0 ? j >= j2 : j <= j2) {
            z = true;
        }
        this.hasNext = z;
        this.next = z ? j : j2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j = this.next;
        if (j != this.finalElement) {
            this.next = this.step + j;
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return Long.valueOf(j);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 66, 0, 22, 7, 23, 95, 95, 10, 18, 12, 23, 70, 13, 89, 68, 68, 65, 16, 20, 22, 12, 68, 68, 1, 86, 69, 2, 9, 17, 22, 66, 1, 83, 1, 73, 9, 13, 90, 73, 68, 81, 10, 8, 10, 6, 85, 68, 13, 93, 11}, "d2edfc60", 4));
    }
}
