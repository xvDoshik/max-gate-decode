package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzc;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzv implements IAccountAccessor, IInterface {
    public final IBinder zza;

    public zzv(IBinder iBinder) {
        this.zza = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    public final Account zzb() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(C0000.decode(new byte[]{2, 11, 8, 75, 83, 91, 9, 2, 94, 0, 28, 81, 13, 84, 19, 11, 12, 1, 26, 83, 11, 22, 28, 6, 93, 93, 14, 95, 15, 74, 12, 11, 64, 81, 20, 11, 83, 9, 28, 121, 34, 83, 2, 11, 16, 11, 64, 117, 5, 6, 87, 22, 65, 95, 17}, "adee44fe2e20c0", 0.0f));
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                this.zza.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                Account account = (Account) zzc.zza(parcelObtain2, Account.CREATOR);
                parcelObtain2.recycle();
                return account;
            } catch (RuntimeException e) {
                parcelObtain2.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }
}
