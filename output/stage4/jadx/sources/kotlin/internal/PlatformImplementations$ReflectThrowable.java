package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class PlatformImplementations$ReflectThrowable {
    public static final Method addSuppressed;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (Intrinsics.areEqual(method2.getName(), C0000.decode(new byte[]{83, 2, 93, 99, 71, 19, 67, 20, 86, 17, 21, 4, 86}, "2f902c3f3bfa", 3))) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                if (Intrinsics.areEqual(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        addSuppressed = method;
        int length2 = methods.length;
        for (int i2 = 0; i2 < length2 && !Intrinsics.areEqual(methods[i2].getName(), C0000.decode(new byte[]{84, 93, 68, 100, 69, 70, 21, 23, 84, 74, 18, 6, 80}, "380706ee19ac48", false)); i2++) {
        }
    }
}
