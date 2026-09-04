package com.google.android.gms.internal.common;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zzc {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        zzc.class.getClassLoader();
    }

    public static Parcelable zza(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zzb(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{98, 83, 22, 7, 87, 10, 18, 86, 5, 16, 83, 70, 92, 93, 16, 68, 84, 19, 94, 94, 29, 68, 81, 9, 92, 65, 17, 9, 87, 2, 30, 18, 17, 10, 64, 3, 83, 86, 68, 23, 91, 28, 87, 8, 68}, "22dd2f"), iDataAvail));
        }
    }
}
