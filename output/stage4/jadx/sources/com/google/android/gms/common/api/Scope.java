package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.zzb;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzb(6);
    public final int zza;
    public final String zzb;

    public Scope(String str, int i) {
        zzag.checkNotEmpty(str, C0000.decode(new byte[]{16, 2, 93, 19, 85, 54, 17, 8, 18, 14, 69, 16, 23, 65, 92, 12, 68, 67, 1, 4, 18, 13, 69, 15, 15, 65, 93, 17, 16, 6, 14, 17, 70, 26}, "ca2c0c"));
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzb.equals(((Scope) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.writeString(parcel, 2, this.zzb);
        CloseableKt.zzb(parcel, iZza);
    }
}
