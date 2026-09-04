package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class SimpleArrayMap {
    public static Object[] mBaseCache;
    public static int mBaseCacheSize;
    public static Object[] mTwiceBaseCache;
    public static int mTwiceBaseCacheSize;
    public int[] mHashes = ContainerHelpers.EMPTY_INTS;
    public Object[] mArray = ContainerHelpers.EMPTY_OBJECTS;
    public int mSize = 0;

    public static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void allocArrays(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                try {
                    Object[] objArr = mTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                try {
                    Object[] objArr2 = mBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i << 1];
    }

    public final void clear() {
        int i = this.mSize;
        if (i > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return (obj == null ? indexOfNull() : indexOf(obj.hashCode(), obj)) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        int i;
        int i2;
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                if (this.mSize == simpleArrayMap.mSize) {
                    for (0; i2 < this.mSize; i2 + 1) {
                        Object obj2 = this.mArray[i2 << 1];
                        Object objValueAt = valueAt(i2);
                        Object obj3 = simpleArrayMap.get(obj2);
                        if (objValueAt == null) {
                            i2 = (obj3 == null && simpleArrayMap.containsKey(obj2)) ? i2 + 1 : 0;
                        } else if (objValueAt.equals(obj3)) {
                        }
                    }
                    return true;
                }
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.mSize == map.size()) {
                    for (0; i < this.mSize; i + 1) {
                        Object obj4 = this.mArray[i << 1];
                        Object objValueAt2 = valueAt(i);
                        Object obj5 = map.get(obj4);
                        if (objValueAt2 == null) {
                            i = (obj5 == null && map.containsKey(obj4)) ? i + 1 : 0;
                        } else if (objValueAt2.equals(obj5)) {
                        }
                    }
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object get(Object obj) {
        int iIndexOfNull = obj == null ? indexOfNull() : indexOf(obj.hashCode(), obj);
        if (iIndexOfNull >= 0) {
            return this.mArray[(iIndexOfNull << 1) + 1];
        }
        return null;
    }

    public final int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public final int indexOf(int i, Object obj) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iBinarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, i);
            if (iBinarySearch < 0 || obj.equals(this.mArray[iBinarySearch << 1])) {
                return iBinarySearch;
            }
            int i3 = iBinarySearch + 1;
            while (i3 < i2 && this.mHashes[i3] == i) {
                if (obj.equals(this.mArray[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iBinarySearch - 1; i4 >= 0 && this.mHashes[i4] == i; i4--) {
                if (obj.equals(this.mArray[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        try {
            int iBinarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
            if (iBinarySearch < 0 || this.mArray[iBinarySearch << 1] == null) {
                return iBinarySearch;
            }
            int i2 = iBinarySearch + 1;
            while (i2 < i && this.mHashes[i2] == 0) {
                if (this.mArray[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = iBinarySearch - 1; i3 >= 0 && this.mHashes[i3] == 0; i3--) {
                if (this.mArray[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int indexOfValue(Object obj) {
        int i = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i;
        int iIndexOf;
        int i2 = this.mSize;
        if (obj == null) {
            iIndexOf = indexOfNull();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iIndexOf = indexOf(iHashCode, obj);
        }
        if (iIndexOf >= 0) {
            int i3 = (iIndexOf << 1) + 1;
            Object[] objArr = this.mArray;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i4 = ~iIndexOf;
        int[] iArr = this.mHashes;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(i5);
            if (i2 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
            }
            freeArrays(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.mHashes;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.mSize - i4) << 1);
        }
        int i7 = this.mSize;
        if (i2 == i7) {
            int[] iArr4 = this.mHashes;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.mArray;
                int i8 = i4 << 1;
                objArr4[i8] = obj;
                objArr4[i8 + 1] = obj2;
                this.mSize = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object remove(Object obj) {
        int iIndexOfNull = obj == null ? indexOfNull() : indexOf(obj.hashCode(), obj);
        if (iIndexOfNull >= 0) {
            return removeAt(iIndexOfNull);
        }
        return null;
    }

    public final Object removeAt(int i) {
        Object[] objArr = this.mArray;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.mSize;
        int i4 = 0;
        if (i3 <= 1) {
            freeArrays(this.mHashes, objArr, i3);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                allocArrays(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i);
                    System.arraycopy(objArr, 0, this.mArray, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.mHashes, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.mArray, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i4;
        return obj;
    }

    public final int size() {
        return this.mSize;
    }

    public final String toString() {
        if (isEmpty()) {
            return C0000.decode(new byte[]{31, 72}, "d5590c5248", 0);
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(C0000.decode(new byte[]{25, 18}, "526a0b"));
            }
            Object obj = this.mArray[i << 1];
            String strDecode = C0000.decode(new byte[]{25, 21, 89, 10, 64, 65, 124, 0, 65, 74}, "1a1c3a", 0.0f);
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append(strDecode);
            }
            sb.append('=');
            Object objValueAt = valueAt(i);
            if (objValueAt != this) {
                sb.append(objValueAt);
            } else {
                sb.append(strDecode);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object valueAt(int i) {
        return this.mArray[(i << 1) + 1];
    }
}
