package com.base.template.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.base.template.services.CommandService;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ExactAlarmPermissionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        try {
            CommandService commandService = CommandService.instance;
            CommandService commandService2 = CommandService.instance;
            if (commandService2 != null) {
                try {
                    commandService2.scheduleDailyRestart$app_release();
                } catch (Exception unused) {
                }
            } else {
                Headers.Companion.safeStartService(context, C0000.decode(new byte[]{34, 46, 115, 51, 41, 106, 99, 119, 103, 126, 102, 34, 122, 37, 44, 37, 38}, "cb2ad532539a2dbb", 0.0f));
            }
        } finally {
            pendingResultGoAsync.finish();
        }
    }
}
