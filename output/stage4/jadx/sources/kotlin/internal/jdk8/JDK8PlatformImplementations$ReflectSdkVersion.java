package kotlin.internal.jdk8;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class JDK8PlatformImplementations$ReflectSdkVersion {
    public static final Integer sdkVersion;

    static {
        Integer num;
        Integer num2 = null;
        try {
            Object obj = Class.forName(C0000.decode(new byte[]{89, 87, 86, 22, 9, 8, 80, 79, 12, 23, 22, 123, 71, 13, 10, 5, 16, 55, 38, 54, 107, 112, 125, 42}, "892dfa4acd")).getField(C0000.decode(new byte[]{53, 34, 121, 109, 126, 126, 50}, "ff2270", 0.0f)).get(null);
            num = obj instanceof Integer ? (Integer) obj : null;
        } catch (Throwable unused) {
        }
        if (num != null && num.intValue() > 0) {
            num2 = num;
        }
        sdkVersion = num2;
    }
}
