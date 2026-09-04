package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractList;
import kotlin.sequences.DropSequence;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ArrayIterator implements Iterator {
    public final /* synthetic */ int $r8$classId;
    public final Object array;
    public int index;

    public /* synthetic */ ArrayIterator(int i, Object obj) {
        this.$r8$classId = i;
        this.array = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                return this.index < ((Object[]) this.array).length;
            case 1:
                return this.index < ((AbstractList) this.array).getSize();
            default:
                Iterator it = (Iterator) this.array;
                while (this.index > 0 && it.hasNext()) {
                    it.next();
                    this.index--;
                }
                return it.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.array;
                    int i = this.index;
                    this.index = i + 1;
                    return objArr[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.index--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 1:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                AbstractList abstractList = (AbstractList) this.array;
                int i2 = this.index;
                this.index = i2 + 1;
                return abstractList.get(i2);
            default:
                Iterator it = (Iterator) this.array;
                while (this.index > 0 && it.hasNext()) {
                    it.next();
                    this.index--;
                }
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 72, 6, 65, 2, 66, 15, 93, 8, 65, 95, 74, 66, 88, 94, 76, 67, 64, 22, 70, 22, 93, 20, 21, 83, 93, 66, 80, 94, 74, 67, 65, 6, 87, 2, 31, 9, 15, 90, 64, 66, 85, 94, 84, 15, 86, 0, 66, 15, 93, 8}, "18c3c6f2fa69b6", true));
            case 1:
                throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 68, 80, 70, 86, 71, 81, 11, 88, 20, 92, 71, 23, 93, 87, 16, 22, 71, 64, 68, 71, 92, 74, 16, 83, 80, 21, 82, 88, 65, 24, 22, 83, 85, 81, 25, 88, 93, 84, 29, 22, 87, 90, 88, 91, 86, 91, 16, 95, 91, 91}, "6454738d", 4));
            default:
                throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 66, 93, 22, 7, 65, 10, 14, 95, 23, 92, 18, 19, 89, 13, 70, 24, 23, 19, 69, 19, 14, 67, 67, 80, 5, 19, 81, 13, 64, 24, 22, 3, 84, 7, 76, 94, 89, 89, 24, 19, 84, 13, 94, 84, 1, 5, 65, 10, 14, 95}, "b28df5ca175a37", 5));
        }
    }

    public ArrayIterator(DropSequence dropSequence) {
        this.$r8$classId = 2;
        this.array = dropSequence.sequence.iterator();
        this.index = dropSequence.count;
    }
}
