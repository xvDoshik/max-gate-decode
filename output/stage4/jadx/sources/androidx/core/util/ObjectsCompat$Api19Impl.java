package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ObjectsCompat$Api19Impl {
    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int hash(Object... objArr) {
        return Objects.hash(objArr);
    }
}
