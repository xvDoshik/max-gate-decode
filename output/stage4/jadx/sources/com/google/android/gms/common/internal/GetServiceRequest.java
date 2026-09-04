package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new com.google.android.gms.common.zzb(13);
    public static final Scope[] zza = new Scope[0];
    public static final Feature[] zzb = new Feature[0];
    public final int zzc;
    public final int zzd;
    public final int zze;
    public String zzf;
    public IBinder zzg;
    public Scope[] zzh;
    public Bundle zzi;
    public Account zzj;
    public Feature[] zzk;
    public Feature[] zzl;
    public final boolean zzm;
    public final int zzn;
    public final boolean zzo;
    public final String zzp;

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4, boolean z2, String str2) {
        scopeArr = scopeArr == null ? zza : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = zzb;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzf = "com.google.android.gms";
        } else {
            this.zzf = str;
        }
        if (i < 2) {
            Account accountZzb = null;
            if (iBinder != null) {
                int i5 = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface zzvVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzv(iBinder);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    accountZzb = ((zzv) zzvVar).zzb();
                } catch (RemoteException unused) {
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
            this.zzj = accountZzb;
        } else {
            this.zzg = iBinder;
            this.zzj = account;
        }
        this.zzh = scopeArr;
        this.zzi = bundle;
        this.zzk = featureArr;
        this.zzl = featureArr2;
        this.zzm = z;
        this.zzn = i4;
        this.zzo = z2;
        this.zzp = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.common.zzb.zza(this, parcel, i);
    }
}
