package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.impl.OperationImpl;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb(14);
    public final String zza;
    public final int zzb;
    public final long zzc;

    public Feature() {
        this.zza = C0000.decode(new byte[]{33, 117, 125, 115, 45, 103, 111, 54, 115, 42, 113, 41, 118, 98, 48, 96}, "b946c30b6f4d36", 0.0f);
        this.zzc = 1L;
        this.zzb = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = feature.zza;
            String str2 = this.zza;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final long getVersion() {
        long j = this.zzc;
        return j == -1 ? this.zzb : j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    public final String toString() {
        OperationImpl operationImpl = new OperationImpl(this);
        operationImpl.add(this.zza, C0000.decode(new byte[]{12, 84, 89, 92}, "b5498556", false));
        operationImpl.add(Long.valueOf(getVersion()), C0000.decode(new byte[]{67, 1, 65, 21, 93, 92, 11}, "5d3f43ecad45", 0.0f));
        return operationImpl.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        long version = getVersion();
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(version);
        CloseableKt.zzb(parcel, iZza);
    }

    public Feature(int i, long j, String str) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }
}
