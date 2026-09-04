package androidx.core.content;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ContextCompat$Api24Impl {
    public static Context createDeviceProtectedStorageContext(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    public static File getDataDir(Context context) {
        return context.getDataDir();
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        return context.isDeviceProtectedStorage();
    }
}
