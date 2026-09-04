package com.google.android.gms.internal.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zab extends Binder implements IInterface {
    public final /* synthetic */ int $r8$classId = 1;

    public zab(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (this.$r8$classId) {
            case 1:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return zza(i, parcel, parcel2);
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    public boolean zza(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }
}
