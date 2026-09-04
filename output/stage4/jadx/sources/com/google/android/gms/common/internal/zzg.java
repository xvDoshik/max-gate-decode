package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzg extends zza {
    public final /* synthetic */ GmsClient zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(GmsClient gmsClient, int i) {
        super(gmsClient, i, null);
        this.zze = gmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        this.zze.zzc.onReportServiceBinding(connectionResult);
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        this.zze.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
