package androidx.collection;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SparseArrayCompat implements Cloneable {
    public static final Object DELETED = new Object();
    public boolean mGarbage;
    public int[] mKeys;
    public int mSize;
    public Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    public final Object clone() {
        try {
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public final int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public final String toString() {
        if (size() <= 0) {
            return C0000.decode(new byte[]{26, 77}, "a053ed", 0.0f);
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(C0000.decode(new byte[]{74, 69}, "fe5603e6f4", 0.0f));
            }
            if (this.mGarbage) {
                gc();
            }
            sb.append(this.mKeys[i]);
            sb.append('=');
            Object objValueAt = valueAt(i);
            if (objValueAt != this) {
                sb.append(objValueAt);
            } else {
                sb.append(C0000.decode(new byte[]{31, 76, 14, 93, 74, 19, 122, 89, 22, 29}, "78f493", false));
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i];
    }

    public SparseArrayCompat(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i2 = i * 4;
            for (int i3 = 4; i3 < 32; i3++) {
                int i4 = (1 << i3) - 12;
                if (i2 <= i4) {
                    i2 = i4;
                    break;
                }
            }
            int i5 = i2 / 4;
            this.mKeys = new int[i5];
            this.mValues = new Object[i5];
        }
        this.mSize = 0;
    }
}
