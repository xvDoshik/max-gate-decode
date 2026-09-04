package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzq {
    public final /* synthetic */ int $r8$classId;
    public final int zza;
    public final TaskCompletionSource zzb = new TaskCompletionSource();
    public final int zzc;
    public final Bundle zzd;

    public zzq(int i, int i2, Bundle bundle, int i3) {
        this.$r8$classId = i3;
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{52, 4, 67, 71, 0, 71, 67, 25, 78, 66, 17, 9, 83, 70, 88}, "fa22e4795b", 0.0f));
        sb.append(this.zzc);
        sb.append(C0000.decode(new byte[]{24, 92, 85, 10}, "85171a5c046643", 1));
        sb.append(this.zza);
        sb.append(C0000.decode(new byte[]{65, 11, 90, 83, 49, 86, 31, 8}, "ad46f7f57d2c1911", 0.0f));
        sb.append(zzb());
        sb.append(C0000.decode(new byte[]{77}, "0329ec", 0.0f));
        return sb.toString();
    }

    public final boolean zzb() {
        switch (this.$r8$classId) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void zzc(zzs zzsVar) {
        if (Log.isLoggable(C0000.decode(new byte[]{47, 4, 70, 16, 3, 87, 87, 81, 17, 120, 18, 2, 118, 15, 15, 92, 94, 64}, "ba5cf904c1", false), 3)) {
            toString();
            zzsVar.toString();
        }
        this.zzb.zza.zza(zzsVar);
    }
}
