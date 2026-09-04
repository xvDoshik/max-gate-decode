package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class Intrinsics {
    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str + C0000.decode(new byte[]{18, 94, 69, 64, 21, 24, 88, 86, 70, 19, 82, 86, 65, 86, 67, 85, 94}, "2303a869", 4))));
        }
    }

    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(C0000.decode(new byte[]{39, 91, 82, 88, 81, 66, 21, 71, 93, 83, 10, 7, 8, 87, 83, 20, 84, 17, 70, 89, 87, 94, 78, 15, 20, 94, 91, 20, 92, 17, 70, 89, 77, 92, 15, 91, 65}, "a2745bf780ca", false) + str + C0000.decode(new byte[]{79}, "abec5a", 2) + str2)));
        }
    }

    public static void checkHasClass(String str) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException(C0000.decode(new byte[]{122, 94, 83, 71, 71, 69}, "92244e188b21", 4) + strReplace + C0000.decode(new byte[]{25, 93, 65, 70, 15, 86, 77, 20, 84, 9, 20, 87, 93, 26, 18, 54, 13, 92, 88, 71, 87, 70, 20, 73, 93, 85, 70, 3, 65, 77, 81, 81, 18, 45, 14, 77, 85, 93, 92, 70, 19, 76, 87, 64, 91, 11, 4, 25, 77, 91, 18, 18, 9, 92, 25, 88, 83, 18, 4, 74, 77, 20, 68, 3, 19, 74, 80, 91, 92}, "942fa9", false), e)));
        }
    }

    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException(C0000.decode(new byte[]{118, 14, 2, 70, 67, 25}, "5bc509ea", 0.0f) + strReplace + C0000.decode(new byte[]{18, 13, 64, 69, 87, 91, 21, 69, 95, 90, 23, 92, 5, 11, 18, 16, 91, 12, 74, 20, 2, 10, 93, 80, 66, 64, 4, 64, 71, 13, 65, 0, 74, 20, 21, 13, 92, 21, 41, 93, 21, 93, 91, 10, 19, 23, 76, 90, 21, 12, 84, 80, 66, 93, 7, 17, 68, 1, 65, 22, 80, 91, 15, 69, 88, 65, 66, 94, 4, 80, 65, 16, 19}, "2d3e94ae95b2a1", 0.0f) + str2, e)));
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str + C0000.decode(new byte[]{69, 88, 70, 67, 21, 20, 13, 91, 67, 65, 7, 80, 19, 94, 20, 88, 15}, "e530a4c47a", 2))));
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(C0000.decode(new byte[]{41, 82, 70, 14, 86, 86, 16, 22, 72, 85, 7, 94, 84, 15, 92, 86, 16, 4, 75, 16, 10, 88, 92, 75, 87, 71, 92, 9, 24, 66, 1, 67, 71, 20, 87, 87, 84, 69, 86, 69, 8, 91, 8, 70}, "d72f920e80", 4) + str + C0000.decode(new byte[]{23}, "9542a86302608c", 0.0f) + str2)));
        }
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static String createParameterIsNullExceptionMessage(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return C0000.decode(new byte[]{99, 81, 17, 4, 15, 0, 65, 6, 70, 66, 64, 64, 6, 6, 11, 3, 92, 6, 80, 66, 82, 67, 67, 11, 13, 11, 24, 13, 65, 14, 95, 16, 10, 22, 66, 11, 64, 15, 88, 88, 19, 93, 6, 17, 10, 10, 81, 67}, "30cebe5c4b") + stackTraceElement.getClassName() + C0000.decode(new byte[]{72}, "fd6ce3b9", 6) + stackTraceElement.getMethodName() + C0000.decode(new byte[]{21, 69, 21, 89, 68, 83, 12, 87, 65, 0, 20, 68}, "9ee862a25efd", false) + str;
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified(C0000.decode(new byte[]{53, 89, 12, 23, 21, 0, 69, 11, 6, 17, 95, 90, 15, 17, 13, 5, 70, 70, 81, 69, 23, 0, 95, 83, 8, 84, 1, 68, 65, 31, 64, 0, 69, 21, 87, 71, 0, 92, 0, 16, 80, 20, 16, 4, 11, 1, 22, 65, 9, 68, 22, 68, 86, 7, 94, 69, 10, 11, 90, 76, 65, 83, 0, 68, 92, 8, 92, 12, 11, 0, 82, 21, 0, 69, 69, 7, 90, 11, 64, 12, 9, 4, 66, 92, 14, 95, 69, 16, 92, 11, 85, 73, 69, 11, 89, 65, 65, 82, 4, 8, 89, 3, 84, 69, 1, 12, 68, 80, 2, 69, 9, 29, 27}, "a1ed5f0eee65", false));
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty(C0000.decode(new byte[]{15, 84, 21, 1, 92, 93, 91, 65, 67, 69, 19, 11, 69, 86, 64, 65, 26, 21}, "c5ad5325", 0.0f) + str + C0000.decode(new byte[]{66, 92, 3, 67, 22, 90, 87, 69, 67, 90, 6, 3, 12, 70, 88, 94, 11, 64, 11, 81, 90, 93, 66, 84, 7}, "b4b06481c8cfbf10", 0.0f));
    }

    private Intrinsics() {
    }

    public static String stringPlus(String str, Object obj) {
        return str + obj;
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    public static void throwNpe(String str) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(str)));
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwJavaNpe(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str)));
    }

    public static void throwUninitializedProperty(String str) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(str)));
    }

    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    public static void throwAssert(String str) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(str)));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    public static void throwIllegalArgument(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(str)));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    public static void throwIllegalState(String str) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
        }
    }

    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullIAE(str);
        }
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullNPE(str);
        }
    }

    private static void throwParameterIsNullIAE(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(str))));
    }

    private static void throwParameterIsNullNPE(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(str))));
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean areEqual(Double d, Double d2) {
        if (d == null) {
            return d2 == null;
        }
        return d2 != null && d.doubleValue() == d2.doubleValue();
    }

    public static boolean areEqual(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    public static boolean areEqual(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    public static boolean areEqual(Float f, Float f2) {
        if (f == null) {
            return f2 == null;
        }
        return f2 != null && f.floatValue() == f2.floatValue();
    }

    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return (T) sanitizeStackTrace(t, Intrinsics.class.getName());
    }

    static <T extends Throwable> T sanitizeStackTrace(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static class Kotlin {
        private Kotlin() {
        }
    }
}
