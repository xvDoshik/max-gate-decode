package kotlin.collections;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ArrayDeque extends AbstractMutableList {
    public static final Object[] emptyElementData = new Object[0];
    public Object[] elementData = emptyElementData;
    public int head;
    public int size;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{88, 95, 80, 81, 65, 10, 21}, "114490578c31eb", 2), C0000.decode(new byte[]{20, 16, 17, 93, 28, 93, 11, 16}, "80b4f81041a043", 7)));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            ensureCapacity$1(i2 + 1);
            int length = this.head;
            if (length == 0) {
                length = this.elementData.length;
            }
            int i3 = length - 1;
            this.head = i3;
            this.elementData[i3] = obj;
            this.size++;
            return;
        }
        ensureCapacity$1(i2 + 1);
        int iPositiveMod = positiveMod(this.head + i);
        int i4 = this.size;
        if (i < ((i4 + 1) >> 1)) {
            int length2 = iPositiveMod == 0 ? this.elementData.length - 1 : iPositiveMod - 1;
            int i5 = this.head;
            int length3 = i5 == 0 ? this.elementData.length - 1 : i5 - 1;
            if (length2 >= i5) {
                Object[] objArr = this.elementData;
                objArr[length3] = objArr[i5];
                ArraysKt.copyInto(objArr, objArr, i5, i5 + 1, length2 + 1);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt.copyInto(objArr3, objArr3, 0, 1, length2 + 1);
            }
            this.elementData[length2] = obj;
            this.head = length3;
        } else {
            int iPositiveMod2 = positiveMod(i4 + this.head);
            if (iPositiveMod < iPositiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt.copyInto(objArr4, objArr4, iPositiveMod + 1, iPositiveMod, iPositiveMod2);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, 1, 0, iPositiveMod2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt.copyInto(objArr6, objArr6, iPositiveMod + 1, iPositiveMod, objArr6.length - 1);
            }
            this.elementData[iPositiveMod] = obj;
        }
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{11, 15, 80, 1, 27, 88, 22}, "ba4dcb6bba799624", true), C0000.decode(new byte[]{77, 25, 68, 15, 75, 0, 94, 66}, "a97f1edb", 5)));
        }
        if (collection.isEmpty()) {
            return false;
        }
        int i3 = this.size;
        if (i == i3) {
            return addAll(collection);
        }
        ensureCapacity$1(collection.size() + i3);
        int iPositiveMod = positiveMod(this.size + this.head);
        int iPositiveMod2 = positiveMod(this.head + i);
        int size = collection.size();
        if (i >= ((this.size + 1) >> 1)) {
            int i4 = iPositiveMod2 + size;
            if (iPositiveMod2 < iPositiveMod) {
                int i5 = size + iPositiveMod;
                Object[] objArr = this.elementData;
                if (i5 <= objArr.length) {
                    ArraysKt.copyInto(objArr, objArr, i4, iPositiveMod2, iPositiveMod);
                } else if (i4 >= objArr.length) {
                    ArraysKt.copyInto(objArr, objArr, i4 - objArr.length, iPositiveMod2, iPositiveMod);
                } else {
                    int length = iPositiveMod - (i5 - objArr.length);
                    ArraysKt.copyInto(objArr, objArr, 0, length, iPositiveMod);
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, i4, iPositiveMod2, length);
                }
            } else {
                Object[] objArr3 = this.elementData;
                ArraysKt.copyInto(objArr3, objArr3, size, 0, iPositiveMod);
                Object[] objArr4 = this.elementData;
                if (i4 >= objArr4.length) {
                    ArraysKt.copyInto(objArr4, objArr4, i4 - objArr4.length, iPositiveMod2, objArr4.length);
                } else {
                    ArraysKt.copyInto(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, i4, iPositiveMod2, objArr5.length - size);
                }
            }
            copyCollectionElements(iPositiveMod2, collection);
            return true;
        }
        int i6 = this.head;
        int length2 = i6 - size;
        if (iPositiveMod2 < i6) {
            Object[] objArr6 = this.elementData;
            ArraysKt.copyInto(objArr6, objArr6, length2, i6, objArr6.length);
            if (size >= iPositiveMod2) {
                Object[] objArr7 = this.elementData;
                ArraysKt.copyInto(objArr7, objArr7, objArr7.length - size, 0, iPositiveMod2);
            } else {
                Object[] objArr8 = this.elementData;
                ArraysKt.copyInto(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.elementData;
                ArraysKt.copyInto(objArr9, objArr9, 0, size, iPositiveMod2);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.elementData;
            ArraysKt.copyInto(objArr10, objArr10, length2, i6, iPositiveMod2);
        } else {
            Object[] objArr11 = this.elementData;
            length2 += objArr11.length;
            int i7 = iPositiveMod2 - i6;
            int length3 = objArr11.length - length2;
            if (length3 >= i7) {
                ArraysKt.copyInto(objArr11, objArr11, length2, i6, iPositiveMod2);
            } else {
                ArraysKt.copyInto(objArr11, objArr11, length2, i6, i6 + length3);
                Object[] objArr12 = this.elementData;
                ArraysKt.copyInto(objArr12, objArr12, 0, this.head + length3, iPositiveMod2);
            }
        }
        this.head = length2;
        int length4 = iPositiveMod2 - size;
        if (length4 < 0) {
            length4 += this.elementData.length;
        }
        copyCollectionElements(length4, collection);
        return true;
    }

    public final void addLast(Object obj) {
        ensureCapacity$1(getSize() + 1);
        this.elementData[positiveMod(getSize() + this.head)] = obj;
        this.size = getSize() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iPositiveMod = positiveMod(getSize() + this.head);
        int i = this.head;
        if (i < iPositiveMod) {
            Arrays.fill(this.elementData, i, iPositiveMod, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            Arrays.fill(objArr, this.head, objArr.length, (Object) null);
            Arrays.fill(this.elementData, 0, iPositiveMod, (Object) null);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void copyCollectionElements(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = collection.size() + this.size;
    }

    public final void ensureCapacity$1(int i) {
        if (i < 0) {
            throw new IllegalStateException(C0000.decode(new byte[]{124, 81, 20, 71, 82, 19, 93, 75, 24, 64, 10, 93, 23, 81, 93, 95, 22}, "84e27348", 2));
        }
        Object[] objArr = this.elementData;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            if (i < 10) {
                i = 10;
            }
            this.elementData = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        ArraysKt.copyInto(objArr, objArr2, 0, this.head, objArr.length);
        Object[] objArr3 = this.elementData;
        int length2 = objArr3.length;
        int i3 = this.head;
        ArraysKt.copyInto(objArr3, objArr2, length2 - i3, 0, i3);
        this.head = 0;
        this.elementData = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, size, C0000.decode(new byte[]{13, 94, 92, 82, 75, 15, 69}, "d08735e7819354fd", true), C0000.decode(new byte[]{26, 68, 64, 80, 79, 6, 88, 65}, "6d395cba7c72", 0.0f)));
        }
        return this.elementData[positiveMod(this.head + i)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.size;
    }

    public final int incremented(int i) {
        if (i == this.elementData.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iPositiveMod = positiveMod(getSize() + this.head);
        int length = this.head;
        if (length < iPositiveMod) {
            while (length < iPositiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[length])) {
                    i = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iPositiveMod) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (length < length2) {
            if (Intrinsics.areEqual(obj, this.elementData[length])) {
                i = this.head;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iPositiveMod; i2++) {
            if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                length = i2 + this.elementData.length;
                i = this.head;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return getSize() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iPositiveMod = positiveMod(getSize() + this.head);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            length = iPositiveMod - 1;
            if (i2 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
            return -1;
        }
        if (i2 > iPositiveMod) {
            for (int i3 = iPositiveMod - 1; -1 < i3; i3--) {
                if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                    length = i3 + this.elementData.length;
                    i = this.head;
                    return length - i;
                }
            }
            length = this.elementData.length - 1;
            int i4 = this.head;
            if (i4 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i4) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
        }
        return -1;
    }

    public final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iPositiveMod;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.size + this.head);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (i < iPositiveMod2) {
                    Object obj = this.elementData[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    }
                    i++;
                }
                Arrays.fill(this.elementData, iPositiveMod, iPositiveMod2, (Object) null);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.elementData[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    }
                }
                z = z2;
            }
            if (z) {
                int length2 = iPositiveMod - this.head;
                if (length2 < 0) {
                    length2 += this.elementData.length;
                }
                this.size = length2;
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, i2, C0000.decode(new byte[]{12, 89, 0, 1, 26, 11, 68}, "e7ddb1d57ba5dde9", false), C0000.decode(new byte[]{21, 22, 66, 95, 66, 1, 13, 70}, "96168d7f", true)));
        }
        if (i == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            if (isEmpty()) {
                throw new NoSuchElementException(C0000.decode(new byte[]{115, 65, 17, 85, 72, 125, 92, 16, 70, 92, 18, 90, 16, 20, 84, 84, 73, 21, 74, 23}, "23c4199a39", false));
            }
            int iPositiveMod = positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head);
            Object[] objArr = this.elementData;
            Object obj = objArr[iPositiveMod];
            objArr[iPositiveMod] = null;
            this.size--;
            return obj;
        }
        if (i == 0) {
            return removeFirst();
        }
        int iPositiveMod2 = positiveMod(this.head + i);
        Object[] objArr2 = this.elementData;
        Object obj2 = objArr2[iPositiveMod2];
        if (i < (this.size >> 1)) {
            int i3 = this.head;
            if (iPositiveMod2 >= i3) {
                ArraysKt.copyInto(objArr2, objArr2, i3 + 1, i3, iPositiveMod2);
            } else {
                ArraysKt.copyInto(objArr2, objArr2, 1, 0, iPositiveMod2);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i4 = this.head;
                ArraysKt.copyInto(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i5 = this.head;
            objArr4[i5] = null;
            this.head = incremented(i5);
        } else {
            int iPositiveMod3 = positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head);
            if (iPositiveMod2 <= iPositiveMod3) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, iPositiveMod2, iPositiveMod2 + 1, iPositiveMod3 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt.copyInto(objArr6, objArr6, iPositiveMod2, iPositiveMod2 + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.copyInto(objArr7, objArr7, 0, 1, iPositiveMod3 + 1);
            }
            this.elementData[iPositiveMod3] = null;
        }
        this.size--;
        return obj2;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{35, 71, 67, 81, 64, 124, 87, 19, 71, 83, 66, 92, 66, 16, 92, 85, 66, 22, 75, 24}, "b510982b26", 0.0f));
        }
        Object[] objArr = this.elementData;
        int i = this.head;
        Object obj = objArr[i];
        objArr[i] = null;
        this.head = incremented(i);
        this.size = getSize() - 1;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iPositiveMod;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.size + this.head);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (i < iPositiveMod2) {
                    Object obj = this.elementData[i];
                    if (collection.contains(obj)) {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(this.elementData, iPositiveMod, iPositiveMod2, (Object) null);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                int length2 = iPositiveMod - this.head;
                if (length2 < 0) {
                    length2 += this.elementData.length;
                }
                this.size = length2;
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(NetworkType$EnumUnboxingLocalUtility.m(i, size, C0000.decode(new byte[]{11, 91, 82, 83, 78, 14, 16}, "b566640f4725ef4a", true), C0000.decode(new byte[]{25, 70, 69, 91, 27, 3, 15, 70}, "5f62af")));
        }
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj2 = objArr[iPositiveMod];
        objArr[iPositiveMod] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[getSize()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.size;
        if (length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        int iPositiveMod = positiveMod(this.size + this.head);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            ArraysKt.copyInto$default(this.elementData, objArr, i2, iPositiveMod, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
            Object[] objArr3 = this.elementData;
            ArraysKt.copyInto(objArr3, objArr, objArr3.length - this.head, 0, iPositiveMod);
        }
        int length2 = objArr.length;
        int i3 = this.size;
        if (length2 > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity$1(collection.size() + getSize());
        copyCollectionElements(positiveMod(getSize() + this.head), collection);
        return true;
    }
}
