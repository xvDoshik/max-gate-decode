package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class VersionedParcel {
    public final ArrayMap mParcelizerCache;
    public final ArrayMap mReadCache;
    public final ArrayMap mWriteCache;

    public VersionedParcel(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    public abstract VersionedParcelParcel createSubParcel();

    public final Class findParcelClass(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        ArrayMap arrayMap = this.mParcelizerCache;
        Class cls2 = (Class) arrayMap.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + C0000.decode(new byte[]{27}, "572b0c5c3ec8145f", 2) + cls.getSimpleName() + C0000.decode(new byte[]{96, 7, 22, 82, 6, 8, 12, 31, 93, 17}, "0fd1cdee8cc4", 2), false, cls.getClassLoader());
        arrayMap.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method getReadMethod(String str) throws NoSuchMethodException {
        ArrayMap arrayMap = this.mReadCache;
        Method method = (Method) arrayMap.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod(C0000.decode(new byte[]{70, 82, 2, 86}, "47c2f3", false), VersionedParcel.class);
        arrayMap.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method getWriteMethod(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ArrayMap arrayMap = this.mWriteCache;
        Method method = (Method) arrayMap.get(name);
        if (method != null) {
            return method;
        }
        Class clsFindParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsFindParcelClass.getDeclaredMethod(C0000.decode(new byte[]{69, 22, 91, 70, 7}, "2d22b3e948ebecd9", 0.0f), cls, VersionedParcel.class);
        arrayMap.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean readField(int i);

    public final Parcelable readParcelable(Parcelable parcelable, int i) {
        if (!readField(i)) {
            return parcelable;
        }
        return ((VersionedParcelParcel) this).mParcel.readParcelable(VersionedParcelParcel.class.getClassLoader());
    }

    public final VersionedParcelable readVersionedParcelable$1() {
        String string = ((VersionedParcelParcel) this).mParcel.readString();
        if (string == null) {
            return null;
        }
        try {
            return (VersionedParcelable) getReadMethod(string).invoke(null, createSubParcel());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(C0000.decode(new byte[]{96, 80, 74, 22, 10, 87, 91, 84, 1, 103, 0, 64, 85, 80, 84, 69, 6, 86, 86, 94, 16, 89, 21, 87, 68, 80, 92, 69, 32, 84, 84, 66, 22, 121, 14, 70, 112, 90, 77, 11, 7, 125, 77, 82, 0, 71, 21, 91, 89, 91}, "658ec851e7a2", 0.0f), e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(C0000.decode(new byte[]{103, 4, 67, 66, 92, 13, 95, 81, 85, 49, 80, 67, 86, 7, 93, 20, 84, 15, 82, 94, 64, 12, 69, 81, 67, 4, 85, 17, 124, 14, 93, 81, 86, 0, 93, 112, 86, 1, 84, 71, 66, 36, 73, 82, 80, 18, 69, 93, 94, 15}, "1a115b14", true), e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(C0000.decode(new byte[]{97, 82, 68, 65, 15, 90, 91, 4, 93, 102, 80, 75, 87, 3, 89, 66, 82, 89, 85, 93, 19, 91, 65, 4, 75, 83, 85, 25, 122, 9, 102, 23, 84, 95, 123, 87, 18, 93, 90, 5, 124, 78, 82, 92, 68, 18, 92, 13, 89}, "7762f55a96194f5b", 0.0f), e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException(C0000.decode(new byte[]{55, 83, 68, 64, 89, 13, 10, 82, 92, 54, 4, 23, 5, 6, 89, 24, 4, 88, 85, 92, 69, 12, 16, 82, 74, 3, 1, 69, 47, 13, 67, 87, 2, 87, 66, 90, 95, 12, 48, 86, 74, 1, 0, 17, 35, 27, 86, 93, 17, 66, 95, 92, 94}, "a6630bd78feefc58"), e4);
        }
    }

    public abstract void setOutputField(int i);

    public final void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            ((VersionedParcelParcel) this).mParcel.writeString(null);
            return;
        }
        try {
            ((VersionedParcelParcel) this).mParcel.writeString(findParcelClass(versionedParcelable.getClass()).getName());
            VersionedParcelParcel versionedParcelParcelCreateSubParcel = createSubParcel();
            try {
                getWriteMethod(versionedParcelable.getClass()).invoke(null, versionedParcelable, versionedParcelParcelCreateSubParcel);
                Parcel parcel = versionedParcelParcelCreateSubParcel.mParcel;
                int i = versionedParcelParcelCreateSubParcel.mCurrentField;
                if (i >= 0) {
                    int i2 = versionedParcelParcelCreateSubParcel.mPositionLookup.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(C0000.decode(new byte[]{100, 1, 20, 18, 88, 90, 8, 81, 85, 98, 83, 22, 5, 4, 93, 21, 3, 90, 82, 93, 71, 10, 18, 4, 67, 80, 2, 20, 114, 94, 83, 23, 21, 47, 94, 65, 32, 91, 68, 92, 86, 33, 30, 2, 84, 69, 18, 93, 94, 92}, "2dfa15f412", true), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(C0000.decode(new byte[]{98, 82, 16, 74, 92, 11, 90, 82, 6, 105, 84, 22, 87, 82, 14, 25, 80, 10, 87, 88, 23, 87, 65, 1, 70, 82, 6, 25, 124, 8, 88, 82, 5, 88, 89, 37, 87, 84, 7, 74, 70, 33, 76, 84, 7, 73, 65, 13, 91, 89}, "47b95d"), e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(C0000.decode(new byte[]{98, 83, 69, 71, 12, 14, 95, 82, 80, 102, 86, 70, 6, 4, 93, 23, 81, 88, 84, 91, 16, 15, 69, 82, 70, 83, 83, 20, 43, 14, 98, 66, 87, 94, 122, 81, 17, 9, 94, 83, 113, 78, 84, 81, 21, 21, 88, 88, 90}, "4674ea17"), e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException(C0000.decode(new byte[]{101, 86, 69, 65, 11, 87, 93, 86, 83, 98, 3, 74, 80, 86, 91, 18, 7, 86, 80, 92, 66, 92, 22, 93, 65, 86, 83, 18, 43, 86, 69, 92, 84, 83, 22, 81, 92, 93, 99, 83, 16, 95, 86, 71, 114, 74, 1, 93, 67, 71, 94, 93, 12}, "3372b8", 4), e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(C0000.decode(new byte[]{19, 80, 89, 92, 67, 21, 87, 14, 23, 67, 10, 86, 69, 81, 22, 88, 16, 101, 88, 19, 0, 6, 14, 94, 73, 81, 68}, "3469059accb7")), e5);
        }
    }
}
