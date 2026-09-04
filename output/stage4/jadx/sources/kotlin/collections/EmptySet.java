package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EmptySet implements Set, Serializable {
    public static final EmptySet INSTANCE = new EmptySet();

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 64, 80, 71, 0, 66, 81, 95, 91, 21, 8, 69, 24, 94, 90, 65, 65, 69, 77, 64, 69, 90, 19, 66, 93, 84, 21, 83, 14, 68, 24, 66, 80, 84, 5, 27, 87, 94, 89, 76, 65, 85, 87, 92, 89, 80, 2, 66, 81, 95, 91}, "8055a6", 2));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 71, 84, 66, 81, 18, 13, 13, 86, 21, 11, 74, 17, 89, 94, 68, 16, 21, 17, 18, 72, 90, 16, 77, 84, 83, 17, 86, 95, 20, 68, 16, 93, 84, 6, 20, 94, 89, 93, 73, 16, 5, 11, 14, 84, 80, 1, 77, 88, 88, 95}, "17100fdb85b9", true));
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{118, 72, 92, 65, 2, 77, 89, 13, 90, 65, 8, 70, 16, 13, 86, 76, 25, 64, 22, 73, 64, 13, 70, 21, 4, 81, 16, 5, 86, 74, 25, 65, 6, 88, 84, 79, 91, 15, 13, 76, 16, 0, 86, 84, 85, 86, 0, 77, 89, 13, 90}, "9893c90b4aa50c", true));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 69, 3, 16, 89, 16, 10, 95, 90, 21, 15, 17, 24, 10, 12, 68, 20, 70, 19, 18, 72, 11, 17, 68, 81, 81, 70, 4, 87, 22, 67, 66, 81, 84, 2, 79, 87, 10, 15, 73, 20, 86, 9, 14, 84, 1, 0, 68, 93, 90, 8}, "45fb8dc0", 0));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 73, 0, 19, 5, 69, 89, 89, 94, 16, 88, 66, 17, 87, 10, 21, 68, 66, 69, 70, 64, 95, 67, 69, 84, 93, 69, 7, 11, 67, 16, 68, 85, 81, 85, 28, 94, 87, 9, 24, 68, 82, 95, 90, 92, 85, 82, 69, 88, 86, 11}, "19ead1060011"));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 18, 1, 22, 3, 77, 13, 11, 95, 20, 95, 17, 68, 10, 13, 77, 68, 23, 68, 68, 70, 13, 22, 16, 7, 93, 68, 2, 94, 70, 22, 16, 1, 5, 6, 20, 11, 10, 93, 77, 22, 1, 11, 8, 14, 92, 7, 16, 88, 91, 88}, "6bddb9dd14"));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.toArray(this);
    }

    public final String toString() {
        return C0000.decode(new byte[]{104, 59}, "3fb8ec0409f4", true);
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.toArray(this, objArr);
    }
}
