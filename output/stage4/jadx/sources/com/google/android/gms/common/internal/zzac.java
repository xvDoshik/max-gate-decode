package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzac implements IInterface {
    public final IBinder zza;

    public zzac(IBinder iBinder) {
        this.zza = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    public final void getService(zzd zzdVar, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(C0000.decode(new byte[]{90, 94, 12, 27, 5, 94, 86, 95, 85, 87, 30, 85, 15, 86, 66, 11, 80, 85, 79, 82, 15, 66, 23, 91, 86, 95, 93, 91, 15, 28, 89, 10, 77, 84, 19, 91, 3, 93, 23, 113, 126, 95, 67, 103, 4, 64, 70, 13, 90, 84, 35, 71, 13, 90, 92, 74}, "91a5b1989204a20d", 0.0f));
            parcelObtain.writeStrongBinder(zzdVar);
            parcelObtain.writeInt(1);
            com.google.android.gms.common.zzb.zza(getServiceRequest, parcelObtain, 0);
            this.zza.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
