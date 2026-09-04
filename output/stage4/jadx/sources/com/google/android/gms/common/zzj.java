package com.google.android.gms.common;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.common.zzc;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zzj extends zab implements zzz {
    public final int zza;

    public zzj(byte[] bArr) {
        super(C0000.decode(new byte[]{91, 12, 89, 30, 81, 88, 91, 82, 84, 6, 26, 81, 88, 83, 70, 90, 81, 7, 26, 87, 91, 68, 26, 86, 87, 14, 89, 95, 88, 25, 93, 91, 76, 6, 70, 94, 87, 91, 26, 124, 123, 6, 70, 68, 114, 86, 64, 84}, "8c406745", 0.0f));
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.zza = Arrays.hashCode(bArr);
    }

    public static byte[] zze(String str) {
        try {
            return str.getBytes(C0000.decode(new byte[]{122, 50, 123, 20, 8, 9, 12, 91, 75, 6}, "3a49019bf76a"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzz)) {
            return false;
        }
        try {
            zzz zzzVar = (zzz) obj;
            if (((zzj) zzzVar).zza != this.zza) {
                return false;
            }
            return Arrays.equals(zzf(), (byte[]) new ObjectWrapper(((zzj) zzzVar).zzf()).zza);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zza(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.zza);
            return true;
        }
        ObjectWrapper objectWrapper = new ObjectWrapper(zzf());
        parcel2.writeNoException();
        int i2 = zzc.$r8$clinit;
        parcel2.writeStrongBinder(objectWrapper);
        return true;
    }

    public abstract byte[] zzf();
}
