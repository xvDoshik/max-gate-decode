package com.google.android.gms.common.api.internal;

import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zabn implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int zaa;
    public final /* synthetic */ Object zab;

    public /* synthetic */ zabn(Object obj, int i, int i2) {
        this.$r8$classId = i2;
        this.zab = obj;
        this.zaa = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((zabq) this.zab).zaH(this.zaa);
                break;
            default:
                ((SystemForegroundService) this.zab).mNotificationManager.cancel(this.zaa);
                break;
        }
    }
}
