package kotlin.collections.builders;

import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.ResultKt;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ListBuilder extends AbstractMutableList implements RandomAccess, Serializable {
    public static final ListBuilder Empty;
    public Object[] array;
    public final ListBuilder backing;
    public boolean isReadOnly;
    public int length;
    public final int offset;
    public final ListBuilder root;

    public final class Itr implements ListIterator {
        public int index;
        public int lastIndex = -1;
        public final ListBuilder list;

        public Itr(ListBuilder listBuilder, int i) {
            this.list = listBuilder;
            this.index = i;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            int i = this.index;
            this.index = i + 1;
            this.list.add(i, obj);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.list.length;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            int i = this.index;
            ListBuilder listBuilder = this.list;
            if (i >= listBuilder.length) {
                throw new NoSuchElementException();
            }
            this.index = i + 1;
            this.lastIndex = i;
            return listBuilder.array[listBuilder.offset + i];
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            int i = this.index;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.index = i2;
            this.lastIndex = i2;
            ListBuilder listBuilder = this.list;
            return listBuilder.array[listBuilder.offset + i2];
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            int i = this.lastIndex;
            if (i == -1) {
                throw new IllegalStateException(C0000.decode(new byte[]{119, 5, 14, 89, 17, 8, 1, 75, 66, 31, 25, 69, 13, 65, 20, 20, 16, 80, 71, 15, 11, 70, 69, 31, 25, 69, 0, 86, 82, 11, 16, 80, 17, 20, 1, 94, 89, 65, 89, 11, 5, 19, 81, 8, 7, 88, 84, 8, 16, 19, 80, 69, 95, 8, 66, 71, 92, 1, 66, 92, 69, 3, 22, 82, 66, 88, 66, 75}, "4db51fd3670eb3", true));
            }
            this.list.removeAt(i);
            this.index = this.lastIndex;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            int i = this.lastIndex;
            if (i == -1) {
                throw new IllegalStateException(C0000.decode(new byte[]{114, 82, 93, 94, 68, 93, 82, 27, 69, 27, 24, 18, 11, 65, 23, 19, 67, 86, 71, 91, 11, 70, 68, 75, 24, 19, 83, 87, 2, 92, 69, 6, 17, 65, 84, 66, 8, 82, 84, 10, 95, 84, 17, 87, 8, 86, 90, 6, 95, 71, 17, 84, 22, 92, 90, 67, 69, 91, 84, 18, 13, 71, 82, 17, 80, 71, 94, 64, 74}, "1312d37c", 7));
            }
            this.list.set(i, obj);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListBuilder(int i) {
        this(new Object[i], 0, 0, false, null, null);
        if (i < 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{85, 84, 22, 83, 87, 10, 16, 31, 25, 15, 67, 70, 18, 18, 86, 6, 68, 8, 86, 12, 27, 91, 3, 85, 85, 23, 13, 16, 92, 76}, "65f24cdf9b"));
        }
    }

    public ListBuilder(Object[] objArr, int i, int i2, boolean z, ListBuilder listBuilder, ListBuilder listBuilder2) {
        this.array = objArr;
        this.offset = i;
        this.length = i2;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        checkIsMutable();
        int i2 = this.length;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{91, 95, 93, 86, 72, 92, 65}, "21930fa7f4", 0), C0000.decode(new byte[]{28, 19, 75, 13, 27, 87, 10, 19}, "038da2", 3)));
        }
        addAtInternal(this.offset + i, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, obj);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        checkIsMutable();
        int i2 = this.length;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{93, 8, 6, 85, 75, 15, 19}, "4fb035339ecf"), C0000.decode(new byte[]{26, 24, 23, 95, 27, 6, 12, 21}, "68d6ac6564", 6)));
        }
        int size = collection.size();
        addAllInternal(this.offset + i, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        checkIsMutable();
        int size = collection.size();
        addAllInternal(this.offset + this.length, collection, size);
        return size > 0;
    }

    public final void addAllInternal(int i, Collection collection, int i2) {
        ListBuilder listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, collection, i2);
            this.array = listBuilder.array;
            this.length += i2;
        } else {
            insertAtInternal(i, i2);
            Iterator it = collection.iterator();
            for (int i3 = 0; i3 < i2; i3++) {
                this.array[i + i3] = it.next();
            }
        }
    }

    public final void addAtInternal(int i, Object obj) {
        ListBuilder listBuilder = this.backing;
        if (listBuilder == null) {
            insertAtInternal(i, 1);
            this.array[i] = obj;
        } else {
            listBuilder.addAtInternal(i, obj);
            this.array = listBuilder.array;
            this.length++;
        }
    }

    public final void checkIsMutable() {
        ListBuilder listBuilder;
        if (this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.array;
            int i = this.length;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (Intrinsics.areEqual(objArr[this.offset + i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.length;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{80, 90, 85, 85, 73, 88, 25}, "94101b", 0), C0000.decode(new byte[]{77, 25, 23, 89, 73, 3, 9, 66}, "a9d03f3b421155de")));
        }
        return this.array[this.offset + i];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.array;
        int i = this.length;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.offset + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public final void insertAtInternal(int i, int i2) {
        int i3 = this.length + i2;
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.array;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.array = Arrays.copyOf(objArr, i4);
        }
        Object[] objArr2 = this.array;
        ArraysKt.copyInto(objArr2, objArr2, i + i2, i, this.offset + this.length);
        this.length += i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i2 = this.length;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{90, 88, 85, 83, 65, 95, 19}, "36169e33a8", 0.0f), C0000.decode(new byte[]{27, 19, 18, 88, 79, 92, 95, 70}, "73a159ef", 0.0f)));
        }
        return new Itr(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        checkIsMutable();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            removeAt(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        checkIsMutable();
        int i2 = this.length;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{91, 88, 92, 83, 75, 10, 17}, "26863015a0723599", true), C0000.decode(new byte[]{74, 16, 67, 11, 78, 6, 3, 68}, "f00b4c9d82775d", 0)));
        }
        return removeAtInternal(this.offset + i);
    }

    public final Object removeAtInternal(int i) {
        ListBuilder listBuilder = this.backing;
        if (listBuilder != null) {
            Object objRemoveAtInternal = listBuilder.removeAtInternal(i);
            this.length--;
            return objRemoveAtInternal;
        }
        Object[] objArr = this.array;
        Object obj = objArr[i];
        int i2 = this.length;
        int i3 = this.offset;
        ArraysKt.copyInto(objArr, objArr, i, i + 1, i2 + i3);
        Object[] objArr2 = this.array;
        int i4 = this.length;
        objArr2[(i3 + i4) - 1] = null;
        this.length = i4 - 1;
        return obj;
    }

    public final void removeRangeInternal(int i, int i2) {
        ListBuilder listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i, i2);
        } else {
            Object[] objArr = this.array;
            ArraysKt.copyInto(objArr, objArr, i, i + i2, this.length);
            Object[] objArr2 = this.array;
            int i3 = this.length;
            ResultKt.resetRange(objArr2, i3 - i2, i3);
        }
        this.length -= i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
    }

    public final int retainOrRemoveAllInternal(int i, int i2, Collection collection, boolean z) {
        ListBuilder listBuilder = this.backing;
        if (listBuilder != null) {
            int iRetainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i, i2, collection, z);
            this.length -= iRetainOrRemoveAllInternal;
            return iRetainOrRemoveAllInternal;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.array[i5]) == z) {
                Object[] objArr = this.array;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.array;
        ArraysKt.copyInto(objArr2, objArr2, i + i4, i2 + i, this.length);
        Object[] objArr3 = this.array;
        int i7 = this.length;
        ResultKt.resetRange(objArr3, i7 - i6, i7);
        this.length -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        checkIsMutable();
        int i2 = this.length;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{10, 89, 92, 0, 30, 3, 67}, "c78ef9c3", true), C0000.decode(new byte[]{27, 68, 64, 88, 78, 83, 13, 23}, "7d314677a167", true)));
        }
        Object[] objArr = this.array;
        int i3 = this.offset;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Trace.checkRangeIndexes$kotlin_stdlib(i, i2, this.length);
        Object[] objArr = this.array;
        int i3 = this.offset + i;
        int i4 = i2 - i;
        boolean z = this.isReadOnly;
        ListBuilder listBuilder = this.root;
        return new ListBuilder(objArr, i3, i4, z, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.length;
        int i2 = this.offset;
        if (length < i) {
            return Arrays.copyOfRange(this.array, i2, i + i2, objArr.getClass());
        }
        ArraysKt.copyInto(this.array, objArr, 0, i2, i + i2);
        int length2 = objArr.length;
        int i3 = this.length;
        if (length2 > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        Object[] objArr = this.array;
        int i = this.length;
        StringBuilder sb = new StringBuilder((i * 3) + 2);
        sb.append(C0000.decode(new byte[]{111}, "4f42e867d1"));
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(C0000.decode(new byte[]{28, 24}, "084a5d"));
            }
            sb.append(objArr[this.offset + i2]);
        }
        sb.append(C0000.decode(new byte[]{104}, "5e0e67"));
        return sb.toString();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.array;
        int i = this.length;
        int i2 = this.offset;
        int i3 = i + i2;
        Headers.Companion.copyOfRangeToIndexCheck(i3, objArr.length);
        return Arrays.copyOfRange(objArr, i2, i3);
    }

    public ListBuilder() {
        this(10);
    }
}
