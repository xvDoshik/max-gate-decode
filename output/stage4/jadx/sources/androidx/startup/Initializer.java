package androidx.startup;

import android.content.Context;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Initializer {
    Object create(Context context);

    void dependencies();
}
