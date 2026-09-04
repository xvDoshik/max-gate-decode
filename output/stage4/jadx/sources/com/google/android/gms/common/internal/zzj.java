package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new com.google.android.gms.common.zzb(11);
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;
    public ConnectionTelemetryConfiguration zzd;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeBundle(parcel, 1, this.zza);
        CloseableKt.writeTypedArray(parcel, 2, this.zzb, i);
        int i2 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i);
        CloseableKt.zzb(parcel, iZza);
    }
}
