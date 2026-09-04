package androidx.core.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ContextCompat$Api21Impl {
    public static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }
}
