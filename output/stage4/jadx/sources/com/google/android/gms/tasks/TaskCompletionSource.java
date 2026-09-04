package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzag;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TaskCompletionSource {
    public final zzw zza = new zzw();

    public final void setResult(Object obj) {
        this.zza.zzb(obj);
    }

    public final void trySetException(Exception exc) {
        zzw zzwVar = this.zza;
        zzwVar.getClass();
        zzag.checkNotNull(exc, C0000.decode(new byte[]{116, 76, 85, 4, 67, 76, 91, 90, 87, 21, 88, 70, 69, 69, 23, 88, 94, 64, 22, 3, 86, 24, 92, 64, 85, 89}, "146a382595536176", 0.0f));
        synchronized (zzwVar.zza) {
            try {
                if (zzwVar.zzc) {
                    return;
                }
                zzwVar.zzc = true;
                zzwVar.zzf = exc;
                zzwVar.zzb.zzb(zzwVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void trySetResult(Object obj) {
        zzw zzwVar = this.zza;
        synchronized (zzwVar.zza) {
            try {
                if (zzwVar.zzc) {
                    return;
                }
                zzwVar.zzc = true;
                zzwVar.zze = obj;
                zzwVar.zzb.zzb(zzwVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
