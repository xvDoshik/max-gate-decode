package androidx.core.content;

import android.content.Context;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ContextCompat$Api23Impl {
    public static int getColor(Context context, int i) {
        return context.getColor(i);
    }

    public static <T> T getSystemService(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static String getSystemServiceName(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
