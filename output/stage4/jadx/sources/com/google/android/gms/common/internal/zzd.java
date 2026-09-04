package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.common.zzc;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzd extends zab {
    public GmsClient zza;
    public final int zzb;

    public zzd(GmsClient gmsClient, int i) {
        super(C0000.decode(new byte[]{7, 91, 85, 76, 3, 88, 93, 87, 8, 81, 22, 3, 10, 83, 64, 95, 13, 80, 22, 5, 9, 68, 28, 83, 11, 89, 85, 13, 10, 25, 91, 94, 16, 81, 74, 12, 5, 91, 28, 121, 35, 89, 75, 33, 5, 91, 94, 82, 5, 87, 83, 17}, "d48bd720", 6));
        this.zza = gmsClient;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zza(int i, Parcel parcel, Parcel parcel2) {
        String strDecode = C0000.decode(new byte[]{90, 15, 100, 14, 69, 21, 124, 93, 92, 21, 119, 14, 91, 17, 89, 86, 65, 4, 20, 2, 87, 15, 21, 81, 80, 65, 87, 0, 90, 13, 80, 87, 21, 14, 90, 13, 79, 65, 90, 93, 86, 4, 20, 17, 83, 19, 21, 80, 84, 13, 88, 65, 66, 14, 21, 84, 80, 21, 102, 4, 91, 14, 65, 86, 102, 4, 70, 23, 95, 2, 80}, "5a4a6a53");
        if (i == 1) {
            int i2 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            zzag.checkNotNull(this.zza, strDecode);
            GmsClient gmsClient = this.zza;
            int i3 = this.zzb;
            zzb zzbVar = gmsClient.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(1, i3, -1, new zzf(gmsClient, i2, strongBinder, bundle)));
            this.zza = null;
        } else if (i == 2) {
            parcel.readInt();
            zzc.zzb(parcel);
            new Exception();
        } else {
            if (i != 3) {
                return false;
            }
            int i4 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) zzc.zza(parcel, zzj.CREATOR);
            zzc.zzb(parcel);
            GmsClient gmsClient2 = this.zza;
            zzag.checkNotNull(gmsClient2, C0000.decode(new byte[]{87, 90, 50, 90, 18, 22, 124, 94, 93, 21, 123, 91, 15, 69, 13, 7, 65, 85, 99, 8, 76, 92, 33, 90, 15, 12, 80, 83, 64, 8, 87, 90, 43, 91, 7, 13, 21, 83, 85, 15, 24, 86, 7, 21, 2, 3, 89, 92, 81, 5, 24, 91, 12, 89, 24, 66, 90, 94, 87, 4, 24, 68, 7, 71, 65, 1, 84, 92, 88, 65, 76, 91, 5, 80, 21, 48, 80, 93, 91, 21, 93, 103, 7, 71, 23, 11, 86, 85}, "84b5ab504a"));
            zzag.checkNotNull(zzjVar);
            gmsClient2.zzD = zzjVar;
            Bundle bundle2 = zzjVar.zza;
            zzag.checkNotNull(this.zza, strDecode);
            GmsClient gmsClient3 = this.zza;
            int i5 = this.zzb;
            zzb zzbVar2 = gmsClient3.zzb;
            zzbVar2.sendMessage(zzbVar2.obtainMessage(1, i5, -1, new zzf(gmsClient3, i4, strongBinder2, bundle2)));
            this.zza = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
