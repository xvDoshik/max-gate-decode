package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\"\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0001\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        JDK8PlatformImplementations jDK8PlatformImplementations = new JDK8PlatformImplementations();
        try {
            IMPLEMENTATIONS = jDK8PlatformImplementations;
        } catch (ClassCastException e) {
            ClassLoader classLoader = jDK8PlatformImplementations.getClass().getClassLoader();
            ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
            if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                throw new ClassNotFoundException(C0000.decode(new byte[]{121, 86, 67, 66, 0, 10, 81, 1, 16, 83, 95, 89, 66, 75, 16, 79, 81, 69, 65, 8, 93, 5, 84, 85, 87, 24, 87, 74, 95, 85, 16, 87, 65, 0, 91, 2, 86, 85, 65, 93, 95, 76, 16, 91, 92, 87, 18, 23, 94, 11, 81, 84, 86, 74, 11, 24}, "0806ad2d003818", 0.0f) + classLoader + C0000.decode(new byte[]{29, 65, 85, 86, 21, 92, 16, 68, 72, 17, 82, 23, 5, 85, 81, 67, 66, 13, 88, 86, 2, 92, 66, 10, 17}, "1a77f900", 0.0f) + classLoader2, e);
            }
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T castToBaseType(Object obj) throws ClassNotFoundException {
        String strDecode = C0000.decode(new byte[]{100}, "0a918950", 0);
        try {
            Intrinsics.reifiedOperationMarker(1, strDecode);
            return obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, strDecode);
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (Intrinsics.areEqual(classLoader, classLoader2)) {
                throw e;
            }
            throw new ClassNotFoundException(C0000.decode(new byte[]{40, 12, 64, 16, 89, 11, 2, 7, 19, 7, 84, 4, 18, 17, 19, 19, 89, 22, 65, 14, 92, 5, 92, 0, 5, 66, 85, 22, 87, 8, 65, 3, 19, 0, 81, 3, 7, 7, 65, 1, 86, 17, 65, 1, 95, 5, 75, 22, 13, 13, 82, 0, 93, 23, 91, 66}, "ab3d8e", 0.0f) + classLoader + C0000.decode(new byte[]{30, 70, 90, 83, 71, 83, 65, 18, 31, 20, 4, 22, 7, 84, 81, 16, 65, 10, 87, 83, 80, 83, 19, 92, 70}, "2f8246affda6d80c", true) + classLoader2, e);
        }
    }

    public static final boolean apiVersionIsAtLeast(int i, int i2, int i3) {
        return KotlinVersion.CURRENT.isAtLeast(i, i2, i3);
    }
}
