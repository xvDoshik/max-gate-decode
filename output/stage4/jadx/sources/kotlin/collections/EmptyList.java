package kotlin.collections;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EmptyList implements List, Serializable, RandomAccess {
    public static final EmptyList INSTANCE = new EmptyList();

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{118, 22, 3, 71, 85, 64, 89, 93, 11, 25, 15, 71, 67, 90, 10, 76, 25, 21, 19, 69, 68, 91, 66, 70, 0, 93, 70, 82, 12, 70, 69, 74, 92, 7, 2, 24, 91, 90, 92, 75, 69, 90, 9, 88, 15, 81, 6, 76, 80, 9, 8}, "9ff54402e9f4c4e8", 1));
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 69, 92, 75, 4, 22, 8, 87, 8, 22, 11, 75, 24, 11, 94, 65, 25, 74, 16, 18, 17, 87, 20, 66, 7, 92, 24, 3, 94, 71, 25, 75, 0, 3, 5, 21, 9, 88, 14, 65, 24, 6, 94, 89, 85, 92, 6, 22, 8, 87, 8}, "1599eba8f6b88e", true));
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 71, 81, 17, 86, 69, 94, 11, 8, 66, 93, 68, 17, 89, 91, 23, 23, 66, 66, 20, 22, 13, 70, 67, 84, 83, 20, 5, 88, 67, 23, 22, 3, 3, 80, 26, 94, 89, 88, 26, 23, 82, 88, 8, 10, 7, 87, 67, 88, 88, 90}, "174c717dfb47"));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 21, 86, 69, 84, 17, 80, 86, 91, 21, 94, 67, 17, 86, 89, 17, 19, 68, 64, 21, 73, 86, 71, 65, 82, 84, 17, 94, 89, 23, 19, 69, 80, 4, 93, 20, 90, 91, 91, 73, 17, 91, 89, 9, 95, 82, 86, 17, 80, 86, 91}, "6e375e99557018", 0.0f));
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 71, 7, 70, 80, 70, 92, 88, 12, 20, 88, 65, 21, 89, 13, 64, 17, 65, 64, 71, 18, 91, 67, 70, 80, 83, 66, 82, 94, 64, 21, 69, 7, 85, 85, 31, 90, 89, 14, 77, 17, 81, 90, 91, 14, 81, 82, 70, 92, 88, 12}, "57b412"));
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List
    public final Object get(int i) {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{112, 84, 20, 67, 74, 68, 93, 12, 67, 21, 21, 93, 11, 82, 64, 10, 22, 17, 16, 2, 90, 87, 16, 86, 90, 10, 17, 0, 92, 4, 88, 92, 10, 67, 19, 5, 69, 69, 89, 15, 81, 92, 28, 23}, "59d73d1e0a"));
        sb.append(i);
        sb.append('.');
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        if (i == 0) {
            return EmptyIterator.INSTANCE;
        }
        throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{43, 8, 84, 7, 79, 94, 19}, "bf0b7d387cbe", 4), i));
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 71, 1, 71, 83, 67, 15, 93, 10, 24, 89, 18, 20, 10, 94, 67, 68, 70, 71, 71, 22, 93, 22, 76, 85, 5, 20, 2, 94, 69, 68, 71, 87, 86, 2, 31, 11, 86, 92, 24, 20, 7, 94, 91, 8, 80, 81, 67, 15, 93, 10}, "17d527f2d80a4d", false));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 65, 86, 66, 7, 71, 89, 14, 15, 19, 93, 66, 19, 94, 9, 71, 16, 18, 20, 67, 68, 94, 65, 68, 3, 87, 16, 7, 14, 65, 20, 67, 86, 81, 2, 30, 95, 15, 13, 74, 20, 82, 92, 92, 10, 86, 83, 21, 8, 92, 90}, "4130f30aa3"));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 68, 83, 67, 88, 18, 81, 87, 93, 65, 13, 16, 23, 90, 89, 69, 25, 21, 77, 72, 67, 14, 22, 23, 82, 80, 22, 87, 86, 20, 24, 74, 86, 0, 0, 78, 88, 90, 90, 72, 25, 5, 87, 84, 95, 4, 7, 23, 94, 91, 88}, "74619f883adc", true));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 20, 84, 20, 82, 77, 80, 88, 95, 17, 92, 22, 17, 10, 94, 18, 19, 74, 76, 71, 65, 94, 71, 17, 84, 0, 17, 0, 92, 75, 25, 69, 84, 80, 81, 72, 94, 10, 93, 31, 19, 90, 86, 91, 93, 84, 86, 17, 88, 11, 95}, "1d1f3997115e", 0.0f));
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 73, 80, 23, 83, 77, 11, 90, 94, 23, 80, 22, 22, 92, 88, 77, 21, 22, 71, 73, 18, 90, 66, 67, 92, 1, 22, 84, 88, 75, 21, 23, 87, 88, 6, 24, 95, 89, 85, 28, 22, 81, 88, 85, 89, 0, 81, 77, 11, 90, 94}, "795e29b5079e62", false));
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return 0;
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{0, 69, 9, 11, 47, 12, 2, 82, 30, 92, 70}, "f7fffb", 5), C0000.decode(new byte[]{74, 16, 66, 89, 123, 90, 6, 1, 27, 8, 23}, "f06624bdc27215")));
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.toArray(this);
    }

    public final String toString() {
        return C0000.decode(new byte[]{56, 104}, "c5eaa984c4");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.toArray(this, objArr);
    }
}
