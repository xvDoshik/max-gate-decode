package androidx.work.impl.utils;

import android.app.Application;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Api28Impl {
    public static final Api28Impl INSTANCE = new Api28Impl();

    public final String getProcessName() {
        return Application.getProcessName();
    }
}
