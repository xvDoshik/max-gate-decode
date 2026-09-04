package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableSet;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class TypeIntrinsics {
    public static Collection asMutableCollection(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableCollection)) {
            throwCce(obj, C0000.decode(new byte[]{88, 94, 64, 89, 90, 87, 75, 91, 10, 15, 95, 84, 87, 65, 90, 86, 11, 75, 75, 46, 70, 69, 85, 87, 95, 92, 38, 87, 9, 15, 86, 82, 64, 92, 92, 87}, "314539e8ec", 4));
        }
        return castToCollection(obj);
    }

    public static Iterable asMutableIterable(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableIterable)) {
            throwCce(obj, C0000.decode(new byte[]{88, 12, 16, 92, 8, 88, 22, 2, 9, 92, 95, 6, 7, 68, 8, 89, 86, 18, 72, 125, 70, 23, 5, 82, 13, 83, 113, 21, 3, 66, 82, 1, 8, 85}, "3cd0a68af0", true));
        }
        return castToIterable(obj);
    }

    public static Iterator asMutableIterator(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableIterator)) {
            throwCce(obj, C0000.decode(new byte[]{93, 89, 66, 93, 10, 95, 76, 0, 13, 85, 91, 3, 85, 66, 95, 94, 13, 66, 76, 46, 23, 77, 86, 4, 90, 83, ByteCompanionObject.MAX_VALUE, 69, 6, 67, 3, 23, 13, 75}, "6661c1bcb97f"));
        }
        return castToIterator(obj);
    }

    public static List asMutableList(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableList)) {
            throwCce(obj, C0000.decode(new byte[]{94, 92, 65, 8, 88, 86, 74, 87, 90, 95, 89, 1, 82, 76, 13, 91, 91, 64, 27, 41, 68, 76, 5, 86, 89, 86, 121, 13, 66, 76}, "535d18d4", false));
        }
        return castToList(obj);
    }

    public static ListIterator asMutableListIterator(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableListIterator)) {
            throwCce(obj, C0000.decode(new byte[]{13, 86, 69, 92, 11, 90, 79, 82, 89, 90, 14, 87, 2, 18, 15, 86, 95, 67, 76, 121, 20, 69, 87, 84, 14, 87, 45, 15, 21, 77, 120, 68, 7, 70, 0, 69, 89, 68}, "f910b4a166b2af", false));
        }
        return castToListIterator(obj);
    }

    public static Map asMutableMap(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap)) {
            throwCce(obj, C0000.decode(new byte[]{89, 11, 22, 89, 8, 12, 28, 7, 13, 89, 13, 7, 81, 16, 11, 90, 15, 17, 28, 41, 23, 65, 0, 0, 94, 1, 47, 84, 17}, "2db5ab"));
        }
        return castToMap(obj);
    }

    public static Map.Entry asMutableMapEntry(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap.Entry)) {
            throwCce(obj, C0000.decode(new byte[]{90, 14, 68, 91, 91, 10, 31, 2, 95, 91, 94, 1, 82, 21, 89, 88, 92, 23, 31, 44, 69, 67, 83, 6, 93, 4, 125, 86, 66, 74, 124, 20, 68, 86, 80, 8, 84, 36, 94, 67, 64, 29}, "1a072d", 5));
        }
        return castToMapEntry(obj);
    }

    public static Set asMutableSet(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableSet)) {
            throwCce(obj, C0000.decode(new byte[]{13, 89, 17, 84, 11, 94, 72, 85, 10, 84, 14, 85, 5, 66, 12, 87, 12, 67, 72, 123, 16, 76, 3, 82, 10, 83, 54, 93, 22}, "f6e8b0"));
        }
        return castToSet(obj);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i) {
        if (obj != null && !isFunctionOfArity(obj, i)) {
            throwCce(obj, C0000.decode(new byte[]{93, 87, 65, 9, 81, 91, 29, 8, 64, 85, 24, 94, 64, 11, 91, 65, 90, 13, 88, 75, 24, 126, 64, 11, 91, 65, 90, 13, 88}, "685e853b68", 5) + i);
        }
        return obj;
    }

    public static void throwCce(Object obj, String str) {
        throwCce((obj == null ? C0000.decode(new byte[]{8, 22, 95, 94}, "fc32cc") : obj.getClass().getName()) + C0000.decode(new byte[]{22, 2, 81, 8, 95, 14, 76, 19, 0, 82, 20, 6, 5, 71, 76, 19, 66, 14, 16}, "6a0f1a83b74ed483", 0.0f) + str);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return (T) Intrinsics.sanitizeStackTrace(t, TypeIntrinsics.class.getName());
    }

    public static void throwCce(String str) {
        throw throwCce(new ClassCastException(str));
    }

    public static ClassCastException throwCce(ClassCastException classCastException) {
        throw ((ClassCastException) sanitizeStackTrace(classCastException));
    }

    public static boolean isMutableIterator(Object obj) {
        if (obj instanceof Iterator) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableIterator);
        }
        return false;
    }

    public static Iterator asMutableIterator(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableIterator)) {
            throwCce(str);
        }
        return castToIterator(obj);
    }

    public static Iterator castToIterator(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableListIterator(Object obj) {
        if (obj instanceof ListIterator) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableListIterator);
        }
        return false;
    }

    public static ListIterator asMutableListIterator(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableListIterator)) {
            throwCce(str);
        }
        return castToListIterator(obj);
    }

    public static ListIterator castToListIterator(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableIterable(Object obj) {
        if (obj instanceof Iterable) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableIterable);
        }
        return false;
    }

    public static Iterable asMutableIterable(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableIterable)) {
            throwCce(str);
        }
        return castToIterable(obj);
    }

    public static Iterable castToIterable(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableCollection(Object obj) {
        if (obj instanceof Collection) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableCollection);
        }
        return false;
    }

    public static Collection asMutableCollection(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableCollection)) {
            throwCce(str);
        }
        return castToCollection(obj);
    }

    public static Collection castToCollection(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableList(Object obj) {
        if (obj instanceof List) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableList);
        }
        return false;
    }

    public static List asMutableList(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableList)) {
            throwCce(str);
        }
        return castToList(obj);
    }

    public static List castToList(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableSet(Object obj) {
        if (obj instanceof Set) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableSet);
        }
        return false;
    }

    public static Set asMutableSet(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableSet)) {
            throwCce(str);
        }
        return castToSet(obj);
    }

    public static Set castToSet(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableMap(Object obj) {
        if (obj instanceof Map) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableMap);
        }
        return false;
    }

    public static Map asMutableMap(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap)) {
            throwCce(str);
        }
        return castToMap(obj);
    }

    public static Map castToMap(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableMapEntry(Object obj) {
        if (obj instanceof Map.Entry) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableMap.Entry);
        }
        return false;
    }

    public static Map.Entry asMutableMapEntry(Object obj, String str) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap.Entry)) {
            throwCce(str);
        }
        return castToMapEntry(obj);
    }

    public static Map.Entry castToMapEntry(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static int getFunctionArity(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof Function4) {
            return 4;
        }
        if (obj instanceof Function5) {
            return 5;
        }
        if (obj instanceof Function6) {
            return 6;
        }
        if (obj instanceof Function7) {
            return 7;
        }
        if (obj instanceof Function8) {
            return 8;
        }
        if (obj instanceof Function9) {
            return 9;
        }
        if (obj instanceof Function10) {
            return 10;
        }
        if (obj instanceof Function11) {
            return 11;
        }
        if (obj instanceof Function12) {
            return 12;
        }
        if (obj instanceof Function13) {
            return 13;
        }
        if (obj instanceof Function14) {
            return 14;
        }
        if (obj instanceof Function15) {
            return 15;
        }
        if (obj instanceof Function16) {
            return 16;
        }
        if (obj instanceof Function17) {
            return 17;
        }
        if (obj instanceof Function18) {
            return 18;
        }
        if (obj instanceof Function19) {
            return 19;
        }
        if (obj instanceof Function20) {
            return 20;
        }
        if (obj instanceof Function21) {
            return 21;
        }
        return obj instanceof Function22 ? 22 : -1;
    }

    public static boolean isFunctionOfArity(Object obj, int i) {
        return (obj instanceof Function) && getFunctionArity(obj) == i;
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i, String str) {
        if (obj != null && !isFunctionOfArity(obj, i)) {
            throwCce(str);
        }
        return obj;
    }
}
