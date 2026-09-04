package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzu {
    public static zzu zza;
    public final Context zzb;
    public final ScheduledExecutorService zzc;
    public zzn zzd = new zzn(this);
    public int zze = 1;

    public zzu(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzu zzb(Context context) {
        try {
            if (zza == null) {
                zza = new zzu(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory(C0000.decode(new byte[]{46, 87, 75, 67, 81, 91, 80, 7, 17, 123, 72, 83, 119, 89, 94, 7, 13, 70}, "c280457b", 0.0f)))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    public final synchronized zzw zzg(zzq zzqVar) {
        try {
            if (Log.isLoggable(C0000.decode(new byte[]{41, 83, 23, 68, 93, 94, 3, 6, 16, 124, 20, 85, 39, 91, 81, 85, 10, 23}, "d6d780dcb5", true), 3)) {
                C0000.decode(new byte[]{103, 68, 85, 67, 0, 80, 12, 83, 69}, "6106e9b4e5", true).concat(zzqVar.toString());
            }
            if (!this.zzd.zzg(zzqVar)) {
                zzn zznVar = new zzn(this);
                this.zzd = zznVar;
                zznVar.zzg(zzqVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzqVar.zzb.zza;
    }
}
