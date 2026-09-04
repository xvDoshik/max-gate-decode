package com.base.template;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SmsReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        new Thread(new SmsReceiver$$ExternalSyntheticLambda0(context.getApplicationContext(), intent, this, goAsync(), 0)).start();
    }
}
