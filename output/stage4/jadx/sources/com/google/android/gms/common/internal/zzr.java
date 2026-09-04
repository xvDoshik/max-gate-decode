package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.cloudmessaging.zzk;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.base.zaq;
import java.util.HashMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzr {
    public static HandlerThread zza;
    public static final Object zzc$1 = new Object();
    public static zzr zzd$1;
    public final HashMap zzb = new HashMap();
    public final Context zzc;
    public volatile zaq zzd;
    public final ConnectionTracker zzf;
    public final long zzg;
    public final long zzh;

    public zzr(Context context, Looper looper) {
        zzk zzkVar = new zzk(1, this);
        this.zzc = context.getApplicationContext();
        this.zzd = new zaq(looper, zzkVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = 300000L;
    }

    public final void zzb(String str, ServiceConnection serviceConnection, boolean z) {
        zzn zznVar = new zzn(str, z);
        String strDecode = C0000.decode(new byte[]{99, 71, 77, 13, 15, 81, 19, 16, 87, 70, 66, 91, 86, 13, 15, 82, 19, 5, 24, 33, 90, 70, 103, 1, 19, 64, 90, 7, 93, 37, 88, 91, 90, 1, 2, 66, 90, 11, 86, 70, 23, 65, 92, 5, 21, 22, 68, 5, 75, 70, 89, 90, 64, 68, 3, 89, 70, 10, 92, 70, 85, 80, 82, 11, 19, 83, 29, 68, 24, 5, 88, 91, 82, 13, 6, 11}, "754da63d8f", 1);
        String strDecode2 = C0000.decode(new byte[]{42, 91, 86, 7, 79, 8, 75, 68, 86, 88, 17, 17, 83, 95, 87, 10, 1, 87, 76, 11, 88, 15, 24, 67, 71, 87, 17, 68, 67, 16, 95, 11, 22, 20, 75, 7, 69, 23, 81, 83, 86, 22, 6, 94, 94, 86, 80, 3, 94, 20}, "d48b7a8036e1009d", 0.0f);
        zzag.checkNotNull(serviceConnection, C0000.decode(new byte[]{50, 82, 75, 18, 15, 83, 4, 38, 89, 90, 15, 3, 2, 67, 80, 11, 8, 16, 12, 16, 69, 64, 65, 8, 14, 67, 25, 6, 3, 16, 15, 16, 90, 88}, "a79df0ae64af", 2));
        synchronized (this.zzb) {
            try {
                zzo zzoVar = (zzo) this.zzb.get(zznVar);
                if (zzoVar == null) {
                    throw new IllegalStateException(strDecode2.concat(zznVar.toString()));
                }
                if (!zzoVar.zzb.containsKey(serviceConnection)) {
                    throw new IllegalStateException(strDecode.concat(zznVar.toString()));
                }
                zzoVar.zzb.remove(serviceConnection);
                if (zzoVar.zzb.isEmpty()) {
                    this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zznVar), this.zzg);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(zzn zznVar, zze zzeVar, String str) {
        boolean z;
        String strDecode = C0000.decode(new byte[]{100, 64, 26, 88, 88, 82, 16, 70, 12, 17, 84, 92, 94, 86, 67, 80, 22, 114, 93, 65, 48, 84, 68, 67, 89, 81, 6, 114, 89, 91, 94, 87, 0, 69, 95, 90, 94, 18, 23, 89, 87, 65, 16, 69, 2, 66, 22, 84, 92, 64, 6, 80, 82, 76, 16, 81, 12, 95, 88, 80, 83, 70, 6, 85, 22, 87, 85, 84, 12, 67, 83, 27, 16, 18, 0, 94, 88, 83, 89, 85, 94}, "02c165", 0.0f);
        synchronized (this.zzb) {
            try {
                zzo zzoVar = (zzo) this.zzb.get(zznVar);
                if (zzoVar == null) {
                    zzoVar = new zzo(this, zznVar);
                    zzoVar.zzb.put(zzeVar, zzeVar);
                    zzoVar.zze(str);
                    this.zzb.put(zznVar, zzoVar);
                } else {
                    this.zzd.removeMessages(0, zznVar);
                    if (zzoVar.zzb.containsKey(zzeVar)) {
                        throw new IllegalStateException(strDecode.concat(zznVar.toString()));
                    }
                    zzoVar.zzb.put(zzeVar, zzeVar);
                    int i = zzoVar.zzc;
                    if (i == 1) {
                        zzeVar.onServiceConnected(zzoVar.zzg, zzoVar.zze);
                    } else if (i == 2) {
                        zzoVar.zze(str);
                    }
                }
                z = zzoVar.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
