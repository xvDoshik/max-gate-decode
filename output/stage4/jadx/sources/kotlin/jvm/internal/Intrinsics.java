package kotlin.jvm.internal;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase$query$cursorFactory$1;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Intrinsics {
    public static final Object[] EMPTY = new Object[0];

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void beforeCheckcastToFunctionOfArity(int i, Object obj) {
        int arity;
        int i2 = -1;
        if (obj instanceof Function) {
            if (obj instanceof FunctionBase) {
                arity = ((FunctionBase) obj).getArity();
            } else if (obj instanceof Function0) {
                arity = 0;
            } else if (obj instanceof Function1) {
                arity = 1;
            } else if (obj instanceof Function2) {
                arity = 2;
            } else if (obj instanceof WorkConstraintsTracker$track$$inlined$combine$1$3) {
                arity = 3;
            } else if (obj instanceof FrameworkSQLiteDatabase$query$cursorFactory$1) {
                arity = 4;
            } else {
                arity = obj instanceof Function6 ? 6 : -1;
            }
            if (arity == i) {
                return;
            }
        }
        String strM = NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{93, 92, 76, 84, 10, 88, 76, 15, 71, 9, 25, 2, 77, 11, 85, 71, 81, 87, 13, 69, 76, 35, 68, 10, 84, 16, 81, 10, 88}, "6388c6be1d7d8e", 0), i);
        ClassCastException classCastException = new ClassCastException(obj.getClass().getName() + C0000.decode(new byte[]{20, 91, 2, 88, 94, 13, 64, 19, 3, 80, 69, 83, 88, 64, 67, 23, 64, 87, 67}, "48c60b43a5e09377", 0.0f) + strM);
        String name = Intrinsics.class.getName();
        StackTraceElement[] stackTrace = classCastException.getStackTrace();
        int length = stackTrace.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (name.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        classCastException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        throw classCastException;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static final Object[] toArray(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        return Arrays.copyOf(objArrCopyOf, i2);
                    }
                    i = i2;
                }
            }
        }
        return EMPTY;
    }

    public static final Object[] toArray(Collection collection, Object[] objArr) {
        int size = collection.size();
        int i = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
        } else {
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                if (objArr.length > 0) {
                    objArr[0] = null;
                }
            } else {
                Object[] objArrCopyOf = size <= objArr.length ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i2] = null;
                            return objArr;
                        }
                        return Arrays.copyOf(objArrCopyOf, i2);
                    }
                    i = i2;
                }
            }
        }
        return objArr;
    }
}
