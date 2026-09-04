package com.base.template.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SyncAdapterService extends Service {
    public StubSyncAdapter syncAdapter;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        StubSyncAdapter stubSyncAdapter = this.syncAdapter;
        if (stubSyncAdapter == null) {
            stubSyncAdapter = null;
        }
        return stubSyncAdapter.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.syncAdapter = new StubSyncAdapter(getApplicationContext(), true);
    }
}
