package kotlin.jvm.internal;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Reflection {
    public static final ReflectionFactory factory;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName(C0000.decode(new byte[]{83, 87, 66, 10, 95, 92, 24, 19, 85, 87, 84, 84, 86, 17, 22, 82, 64, 11, 24, 91, 88, 21, 85, 67, 86, 80, 89, 75, 106, 93, 80, 10, 83, 81, 66, 8, 95, 95, 126, 80, 86, 17, 87, 74, 79, 47, 91, 66, 90}, "886f626a01815e")).newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        factory = reflectionFactory;
    }
}
