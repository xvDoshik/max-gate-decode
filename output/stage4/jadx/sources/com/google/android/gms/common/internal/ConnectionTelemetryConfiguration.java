package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new com.google.android.gms.common.zzb(12);
    public final RootTelemetryConfiguration zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int[] zzd;
    public final int zze;
    public final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        int[] iArr = this.zzd;
        if (iArr != null) {
            int iZza2 = CloseableKt.zza(parcel, 4);
            parcel.writeIntArray(iArr);
            CloseableKt.zzb(parcel, iZza2);
        }
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        int[] iArr2 = this.zzf;
        if (iArr2 != null) {
            int iZza3 = CloseableKt.zza(parcel, 6);
            parcel.writeIntArray(iArr2);
            CloseableKt.zzb(parcel, iZza3);
        }
        CloseableKt.zzb(parcel, iZza);
    }
}
