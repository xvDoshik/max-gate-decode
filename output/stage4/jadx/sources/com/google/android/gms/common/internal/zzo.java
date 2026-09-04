package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzo implements ServiceConnection {
    public final /* synthetic */ zzr zza;
    public final HashMap zzb = new HashMap();
    public int zzc = 2;
    public boolean zzd;
    public IBinder zze;
    public final zzn zzf;
    public ComponentName zzg;

    public zzo(zzr zzrVar, zzn zznVar) {
        this.zza = zzrVar;
        this.zzf = zznVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zza.zzb) {
            try {
                this.zza.zzd.removeMessages(1, this.zzf);
                this.zze = iBinder;
                this.zzg = componentName;
                Iterator it = this.zzb.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.zzc = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzb) {
            try {
                this.zza.zzd.removeMessages(1, this.zzf);
                this.zze = null;
                this.zzg = componentName;
                Iterator it = this.zzb.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.zzc = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zze(String str) throws Throwable {
        this.zzc = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            zzr zzrVar = this.zza;
            ConnectionTracker connectionTracker = zzrVar.zzf;
            Context context = zzrVar.zzc;
            try {
                boolean zZzc = connectionTracker.zzc(context, str, this.zzf.zzc(context), this, this.zzf.zze);
                this.zzd = zZzc;
                if (zZzc) {
                    this.zza.zzd.sendMessageDelayed(this.zza.zzd.obtainMessage(1, this.zzf), this.zza.zzh);
                } else {
                    this.zzc = 2;
                    try {
                        zzr zzrVar2 = this.zza;
                        zzrVar2.zzf.unbindService(zzrVar2.zzc, this);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                StrictMode.setVmPolicy(vmPolicy);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
