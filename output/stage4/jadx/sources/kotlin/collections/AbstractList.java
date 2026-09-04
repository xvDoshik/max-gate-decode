package kotlin.collections;

import androidx.tracing.Trace;
import androidx.work.JobListenableFuture;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractList implements List, Collection {

    public final class ListIteratorImpl extends ArrayIterator implements ListIterator {
        public ListIteratorImpl(int i) {
            super(1, AbstractList.this);
            int size = AbstractList.this.getSize();
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, size, C0000.decode(new byte[]{80, 10, 92, 83, 74, 9, 19}, "9d862332b47672f5", 0.0f), C0000.decode(new byte[]{27, 66, 23, 80, 74, 1, 88, 69}, "7bd90dbea81614", 0.0f)));
            }
            this.index = i;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 73, 81, 64, 82, 17, 80, 11, 89, 20, 94, 74, 20, 92, 92, 17, 25, 23, 66, 68, 71, 86, 70, 70, 86, 1, 25, 2, 88, 70, 23, 75, 81, 83, 87, 72, 86, 10, 91, 77, 23, 90, 91, 94, 95, 0, 90, 16, 94, 91, 89}, "79423e9d74", 0.0f));
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i = this.index - 1;
            this.index = i;
            return AbstractList.this.get(i);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 66, 1, 17, 3, 70, 93, 93, 10, 67, 11, 65, 20, 92, 11, 23, 66, 65, 65, 66, 20, 12, 16, 70, 81, 86, 68, 5, 13, 64, 20, 64, 1, 2, 6, 31, 91, 92, 8, 26, 66, 81, 91, 94, 8, 6, 1, 70, 93, 93, 10}, "42dcb2"));
        }
    }

    public final class SubList extends AbstractList implements RandomAccess {
        public final int _size;
        public final int fromIndex;
        public final AbstractList list;

        public SubList(AbstractList abstractList, int i, int i2) {
            this.list = abstractList;
            this.fromIndex = i;
            Trace.checkRangeIndexes$kotlin_stdlib(i, i2, abstractList.getSize());
            this._size = i2 - i;
        }

        @Override // java.util.List
        public final Object get(int i) {
            int i2 = this._size;
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{90, 11, 80, 86, 76, 91, 25}, "3e434a9012"), C0000.decode(new byte[]{73, 17, 16, 91, 30, 81, 92, 20}, "e1c2d4f4f36e", 0.0f)));
            }
            return this.list.get(this.fromIndex + i);
        }

        @Override // kotlin.collections.AbstractList
        public final int getSize() {
            return this._size;
        }
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 69, 86, 69, 84, 77, 92, 88, 10, 21, 90, 68, 21, 87, 90, 67, 68, 70, 70, 71, 69, 86, 71, 67, 1, 81, 19, 81, 90, 75, 21, 69, 1, 84, 87, 26, 90, 87, 89, 78, 68, 86, 92, 91, 89, 92, 86, 67, 13, 90, 93}, "d5375957"));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 68, 81, 65, 85, 21, 8, 12, 93, 17, 13, 17, 24, 8, 12, 21, 66, 71, 65, 67, 68, 14, 19, 23, 86, 85, 68, 4, 87, 20, 67, 19, 7, 85, 80, 30, 91, 15, 13, 26, 19, 82, 11, 14, 84, 3, 0, 21, 11, 91, 90}, "b4434aac31db8fca"));
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 18, 82, 68, 88, 76, 92, 91, 12, 25, 80, 64, 20, 12, 88, 66, 25, 75, 64, 68, 18, 86, 75, 71, 81, 6, 23, 80, 86, 74, 21, 70, 7, 88, 93, 30, 91, 12, 91, 79, 25, 91, 90, 88, 14, 92, 90, 71, 93, 13, 89}, "4b769854b993", 0));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{44, 71, 7, 68, 85, 70, 92, 91, 92, 67, 90, 18, 16, 12, 87, 66, 67, 68, 23, 70, 68, 93, 71, 64, 87, 7, 19, 7, 95, 16, 24, 68, 6, 86, 6, 27, 91, 92, 89, 77, 18, 0, 92, 13, 92, 7, 91, 66, 10, 88, 12}, "c7b642542c3a0b86", 0.0f));
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 18, 4, 20, 84, 22, 94, 88, 90, 68, 80, 71, 20, 12, 14, 18, 21, 17, 66, 71, 68, 11, 75, 64, 81, 6, 65, 0, 90, 16, 23, 69, 81, 5, 93, 25, 91, 12, 13, 31, 21, 1, 88, 91, 88, 1, 90, 64, 93, 13, 15}, "4baf5b774d94", true));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
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

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        if (size() == collection.size()) {
            Iterator it = collection.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    public abstract int getSize();

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return getSize() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new ArrayIterator(1, this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{127, 70, 80, 74, 85, 70, 89, 89, 91, 24, 93, 65, 16, 88, 90, 76, 20, 65, 69, 70, 69, 87, 70, 70, 85, 82, 21, 94, 91, 64, 16, 68, 80, 89, 80, 31, 95, 88, 89, 65, 20, 81, 95, 90, 89, 93, 87, 70, 89, 89, 91}, "065842", 0.0f));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{124, 67, 0, 64, 2, 17, 80, 91, 95, 69, 90, 64, 69, 92, 12, 17, 25, 71, 68, 21, 67, 92, 23, 70, 6, 1, 25, 82, 94, 23, 19, 65, 0, 83, 7, 72, 86, 90, 93, 28, 19, 80, 10, 94, 15, 0, 90, 64, 88, 10, 93}, "33e2ce941e", 0.0f));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 66, 6, 74, 88, 77, 88, 87, 11, 18, 10, 75, 25, 87, 94, 76, 69, 65, 22, 72, 73, 86, 67, 76, 0, 86, 67, 94, 86, 75, 17, 74, 0, 83, 7, 21, 86, 87, 93, 65, 69, 81, 12, 84, 85, 92, 82, 76, 12, 93, 13}, "e2c89918"));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 17, 1, 75, 80, 71, 12, 89, 12, 65, 13, 74, 17, 93, 10, 66, 66, 18, 17, 73, 65, 92, 23, 66, 7, 5, 68, 95, 94, 65, 69, 68, 7, 0, 0, 20, 94, 93, 9, 79, 66, 2, 11, 85, 93, 86, 6, 66, 11, 14, 10}, "bad913e6", 0.0f));
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 73, 84, 67, 7, 77, 93, 89, 90, 25, 88, 66, 70, 87, 91, 66, 20, 74, 68, 65, 22, 86, 70, 66, 81, 93, 17, 87, 9, 75, 20, 68, 81, 88, 85, 28, 9, 87, 88, 79, 20, 90, 94, 93, 10, 92, 87, 66, 93, 86, 95}, "4911f946", 1));
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        return new SubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.toArray(this);
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this, C0000.decode(new byte[]{24, 16}, "40651d", false), new JobListenableFuture.AnonymousClass1(3, this), 24);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new ListIteratorImpl(i);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.toArray(this, objArr);
    }
}
