package com.google.android.gms.common.api;

import android.os.Looper;
import okio.ByteString;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GoogleApi$Settings {
    public static final GoogleApi$Settings DEFAULT_SETTINGS = new GoogleApi$Settings(new ByteString.Companion(), Looper.getMainLooper());
    public final ByteString.Companion zaa;

    public GoogleApi$Settings(ByteString.Companion companion, Looper looper) {
        this.zaa = companion;
    }
}
