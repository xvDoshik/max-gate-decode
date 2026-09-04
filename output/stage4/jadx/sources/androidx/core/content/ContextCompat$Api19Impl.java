package androidx.core.content;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ContextCompat$Api19Impl {
    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }
}
