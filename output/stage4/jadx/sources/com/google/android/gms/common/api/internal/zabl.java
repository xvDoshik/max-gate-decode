package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.base.zaq;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zabl implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ GoogleApiManager zaa;

    public zabl(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        zaq zaqVar = this.zaa.zat;
        zaqVar.sendMessage(zaqVar.obtainMessage(1, Boolean.valueOf(z)));
    }
}
