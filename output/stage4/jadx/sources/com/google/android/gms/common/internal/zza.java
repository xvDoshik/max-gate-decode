package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zza {
    public final int zza;
    public Boolean zza$1;
    public final Bundle zzb;
    public boolean zzb$1;
    public final /* synthetic */ GmsClient zzc;
    public final /* synthetic */ GmsClient zzd;

    public zza(GmsClient gmsClient, int i, Bundle bundle) {
        this.zzc = gmsClient;
        Boolean bool = Boolean.TRUE;
        this.zzd = gmsClient;
        this.zza$1 = bool;
        this.zzb$1 = false;
        this.zza = i;
        this.zzb = bundle;
    }

    public abstract void zzb(ConnectionResult connectionResult);

    public abstract boolean zzd();

    public final void zzg() {
        synchronized (this) {
            this.zza$1 = null;
        }
        synchronized (this.zzd.zzt) {
            this.zzd.zzt.remove(this);
        }
    }
}
