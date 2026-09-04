package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Api;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zabx extends BroadcastReceiver {
    public Context zaa;
    public final Api zab;

    public zabx(Api api) {
        this.zab = api;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if (C0000.decode(new byte[]{85, 93, 9, 29, 81, 90, 13, 2, 10, 6, 24, 83, 10, 87, 68, 90, 11, 1, 72, 4, 91, 65}, "62d365befc").equals(data != null ? data.getSchemeSpecificPart() : null)) {
            Object obj = this.zab.zac;
            throw null;
        }
    }
}
