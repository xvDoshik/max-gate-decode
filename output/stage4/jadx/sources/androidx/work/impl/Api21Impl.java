package androidx.work.impl;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Api21Impl {
    public static final Api21Impl INSTANCE = new Api21Impl();

    public final File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }
}
