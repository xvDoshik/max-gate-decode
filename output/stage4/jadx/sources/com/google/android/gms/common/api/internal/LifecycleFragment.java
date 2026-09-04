package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface LifecycleFragment {
    Activity getLifecycleActivity();

    void startActivityForResult(Intent intent, int i);
}
