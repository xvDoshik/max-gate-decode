package com.base.template.services;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.service.quicksettings.TileService;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class KeepAliveTileService extends TileService {
    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        try {
            long j = getSharedPreferences(C0000.decode(new byte[]{81, 0, 82, 71, 18, 0, 92, 4, 71}, "9e35fb", 5), 0).getLong(C0000.decode(new byte[]{88, 3, 66, 21, 61, 80, 84, 83, 70, 107, 90, 67}, "4b1ab21224701b"), 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (jCurrentTimeMillis > 60000 && j > 0) {
                long j2 = jCurrentTimeMillis / ((long) 1000);
                Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{108, 43, 122, 114, 61, 98, 35, 97, 121, 111, 125}, "8b67b0f709", 0.0f));
            }
            Context applicationContext = getApplicationContext();
            try {
                Intent intent = new Intent(applicationContext, (Class<?>) GuardianService.class);
                intent.putExtra(C0000.decode(new byte[]{102, 92, 80, 91, 93, 57, 21, 92, 81}, "91123fe55a5a", 1), Process.myPid());
                applicationContext.startForegroundService(intent);
            } catch (Exception e) {
                e.getMessage();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
