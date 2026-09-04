package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zze implements ServiceConnection {
    public final /* synthetic */ GmsClient zza;
    public final int zzb;

    public zze(GmsClient gmsClient, int i) {
        this.zza = gmsClient;
        this.zzb = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        GmsClient gmsClient = this.zza;
        if (iBinder == null) {
            synchronized (gmsClient.zzp) {
                i = gmsClient.zzv;
            }
            if (i == 3) {
                gmsClient.zzC = true;
                i2 = 5;
            } else {
                i2 = 4;
            }
            zzb zzbVar = gmsClient.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(i2, gmsClient.zzd.get(), 16));
            return;
        }
        synchronized (gmsClient.zzq) {
            try {
                GmsClient gmsClient2 = this.zza;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(C0000.decode(new byte[]{5, 9, 93, 28, 81, 88, 95, 3, 94, 4, 30, 84, 10, 1, 20, 9, 89, 86, 24, 80, 93, 23, 28, 2, 95, 88, 9, 10, 8, 72, 89, 92, 66, 82, 66, 10, 83, 13, 30, 124, 35, 8, 21, 53, 85, 64, 64, 94, 83, 1, 112, 19, 95, 94, 1, 23}, "ff02670d2a05de", true));
                gmsClient2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzac)) ? new zzac(iBinder) : (zzac) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        GmsClient gmsClient3 = this.zza;
        int i3 = this.zzb;
        zzb zzbVar2 = gmsClient3.zzb;
        zzbVar2.sendMessage(zzbVar2.obtainMessage(7, i3, -1, new zzg(gmsClient3, 0)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        GmsClient gmsClient;
        synchronized (this.zza.zzq) {
            gmsClient = this.zza;
            gmsClient.zzr = null;
        }
        zzb zzbVar = gmsClient.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(6, this.zzb, 1));
    }
}
