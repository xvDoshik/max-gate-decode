package kotlin.internal.jdk7;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class JDK7PlatformImplementations$ReflectSdkVersion {
    public static final Integer sdkVersion;

    static {
        Integer num;
        Integer num2 = null;
        try {
            Object obj = Class.forName(C0000.decode(new byte[]{83, 90, 5, 68, 95, 13, 81, 27, 93, 16, 75, 119, 70, 80, 8, 5, 22, 98, 36, 100, 99, 45, 122, 123}, "24a60d552ce539da", 0.0f)).getField(C0000.decode(new byte[]{102, 33, 126, 102, 45, 47, 55}, "5e59dace51", 1)).get(null);
            num = obj instanceof Integer ? (Integer) obj : null;
        } catch (Throwable unused) {
        }
        if (num != null && num.intValue() > 0) {
            num2 = num;
        }
        sdkVersion = num2;
    }
}
