package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zai implements IInterface {
    public final IBinder zaa;
    public final String zab;

    public zai(IBinder iBinder, String str) {
        this.zaa = iBinder;
        this.zab = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zaa;
    }
}
