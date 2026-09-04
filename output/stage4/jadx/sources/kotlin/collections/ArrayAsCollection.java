package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ArrayAsCollection implements Collection {
    public final boolean isVarargs;
    public final Object[] values;

    public ArrayAsCollection(Object[] objArr, boolean z) {
        this.values = objArr;
        this.isVarargs = z;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 66, 83, 66, 86, 65, 94, 95, 10, 68, 15, 21, 68, 92, 89, 68, 23, 70, 66, 64, 20, 11, 20, 18, 1, 86, 22, 86, 88, 71, 23, 66, 1, 5, 2, 75, 11, 92, 90, 73, 23, 86, 88, 92, 8, 1, 5, 18, 13, 93, 88}, "d2607570ddff", false));
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 68, 3, 64, 82, 23, 11, 90, 89, 17, 88, 21, 65, 90, 86, 16, 20, 71, 19, 66, 67, 12, 16, 65, 82, 85, 17, 0, 14, 70, 25, 22, 81, 85, 2, 31, 92, 13, 14, 76, 23, 82, 94, 10, 13, 81, 90, 16, 93, 91, 8}, "44f23cb5711fa49d", 4));
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 69, 7, 23, 89, 23, 95, 92, 95, 68, 92, 70, 66, 11, 87, 23, 22, 64, 68, 20, 69, 90, 16, 17, 93, 7, 22, 85, 94, 22, 21, 71, 7, 4, 92, 78, 89, 93, 93, 29, 21, 86, 13, 9, 84, 6, 85, 71, 88, 11, 91}, "55be8c631d"));
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i;
        Object[] objArr = this.values;
        if (obj == null) {
            int length = objArr.length;
            i = 0;
            while (i < length) {
                if (objArr[i] != null) {
                    i++;
                }
            }
            i = -1;
        } else {
            int length2 = objArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (obj.equals(objArr[i2])) {
                    i = i2;
                }
            }
            i = -1;
        }
        return i >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.values.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new ArrayIterator(0, this.values);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 67, 3, 22, 3, 17, 91, 92, 8, 68, 11, 22, 18, 93, 9, 16, 66, 22, 71, 67, 22, 11, 16, 17, 87, 87, 70, 2, 13, 23, 18, 65, 3, 5, 6, 72, 93, 93, 10, 29, 66, 6, 93, 95, 10, 1, 1, 17, 91, 92, 8}, "23fdbe"));
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 17, 80, 20, 4, 21, 91, 92, 93, 16, 93, 67, 69, 15, 90, 18, 69, 18, 71, 67, 67, 95, 70, 68, 0, 5, 21, 0, 10, 19, 18, 65, 86, 81, 80, 29, 10, 15, 89, 31, 69, 2, 93, 95, 95, 85, 87, 68, 12, 14, 91}, "ea5fea233040", true));
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 22, 86, 69, 83, 64, 89, 11, 15, 20, 11, 16, 16, 15, 91, 18, 19, 68, 71, 68, 64, 11, 19, 64, 7, 7, 16, 7, 91, 20, 19, 69, 87, 85, 84, 73, 14, 90, 14, 26, 16, 2, 91, 10, 95, 82, 81, 64, 89, 11, 15}, "4f37240da4bc0a", 6));
    }

    @Override // java.util.Collection
    public final int size() {
        return this.values.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.toArray(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.values;
        return (this.isVarargs && objArr.getClass().equals(Object[].class)) ? objArr : Arrays.copyOf(objArr, objArr.length, Object[].class);
    }
}
