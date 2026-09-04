package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.OperationImpl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.zzb;
import java.util.Arrays;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzb(7);
    public final int zzb;
    public final int zzc;
    public final String zzd;
    public final PendingIntent zze;
    public final ConnectionResult zzf;

    public Status(int i, int i2, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && this.zzc == status.zzc && zzag.equal(this.zzd, status.zzd) && zzag.equal(this.zze, status.zze) && zzag.equal(this.zzf, status.zzf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf});
    }

    public final String toString() {
        OperationImpl operationImpl = new OperationImpl(this);
        String strDecode = this.zzd;
        if (strDecode == null) {
            int i = this.zzc;
            switch (i) {
                case -1:
                    strDecode = C0000.decode(new byte[]{49, 54, 33, 116, 115, 50, 49, 60, 33, 118, 117, 41, 39}, "bcb76a", false);
                    break;
                case 0:
                    strDecode = C0000.decode(new byte[]{103, 97, 113, 114, 33, 96, 103}, "4421d3", 0);
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strDecode = NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{70, 15, 90, 8, 95, 68, 92, 23, 64, 21, 80, 18, 69, 64, 18, 84, 92, 5, 84, 92, 16}, "3a1f0327", 7), i);
                    break;
                case 2:
                    strDecode = C0000.decode(new byte[]{97, 32, 100, 52, 43, 117, 119, 58, 96, 39, 48, 101, 123, 42, 120, 61, 55, 102, 118, 36, 98, 39, 61, 100, 119, 52, 99, 43, 48, 115, 118}, "2e6bb6");
                    break;
                case 3:
                    strDecode = C0000.decode(new byte[]{97, 118, 96, 52, 122, 118, 33, 108, 116, 126, 97, 114, 112, 46, 118, 113}, "232b35d307", 7);
                    break;
                case 4:
                    strDecode = C0000.decode(new byte[]{107, 120, 35, 45, 111, 127, 40, 58, 51, 113, 98, 49, 44, 49, 33, 114}, "81dc06fea43decd6");
                    break;
                case 5:
                    strDecode = C0000.decode(new byte[]{123, 121, 100, 39, 122, 127, 112, 59, 114, 117, 117, 41, 98, 47, 102}, "272f664d366f7a");
                    break;
                case 6:
                    strDecode = C0000.decode(new byte[]{55, 114, 48, 123, 127, 51, 101, 127, 43, 118, 102, 97, 112, 101, 48, 126, 49, 113, 119}, "e7c43f16d89354", 7);
                    break;
                case 7:
                    strDecode = C0000.decode(new byte[]{127, 32, 108, 54, 46, 103, 122, 58, 125, 51, 51, 122, 99}, "1e8aa5");
                    break;
                case 8:
                    strDecode = C0000.decode(new byte[]{47, 122, 101, 115, 97, 124, 39, 120, 110, 115, 97, 96, 41, 102}, "f41632");
                    break;
                case 10:
                    strDecode = C0000.decode(new byte[]{118, 114, 99, 124, 46, 121, 97, 119, 98, 61, 119, 101, 103, 118, 48}, "2759b6120b", 6);
                    break;
                case 13:
                    strDecode = C0000.decode(new byte[]{117, 49, 106, 44, 100}, "0c8c69e6");
                    break;
                case 14:
                    strDecode = C0000.decode(new byte[]{112, 42, 48, 113, 98, 107, 98, 105, 101, 115, 34}, "9dd4097916ffb258", true);
                    break;
                case 15:
                    strDecode = C0000.decode(new byte[]{54, 127, 127, 119, 120, 103, 102}, "b622722d");
                    break;
                case 16:
                    strDecode = C0000.decode(new byte[]{118, 120, 44, 122, 33, 120, 112, 125}, "59b9d4", 7);
                    break;
                case 17:
                    strDecode = C0000.decode(new byte[]{115, 102, 45, 57, 121, 42, 103, 59, 32, 123, 125, 126, 118, 39, 49, 125, 118}, "26df7e3dc4303de8", true);
                    break;
                case 18:
                    strDecode = C0000.decode(new byte[]{117, 125, 37, 125, 110, 38, 127, 113, 116, 118, 48}, "18d91e38", 5);
                    break;
                case 19:
                    strDecode = C0000.decode(new byte[]{100, 32, 46, 122, 97, 39, 108, 33, 110, 37, 114, 96, 98, 44, 44, 123}, "6ec55b3d6f70", false);
                    break;
                case 20:
                    strDecode = C0000.decode(new byte[]{123, 45, 47, 124, 117, 119, 100, 123, 119, 44, 62, 97, 101, 103, 96, 119, 118, 38, 36, 118, 111, 112, 101, 96, 113, 44, 38, 109, 115, 117, 124, 126}, "8ba20402", 0.0f);
                    break;
                case 21:
                    strDecode = C0000.decode(new byte[]{99, 114, 119, 121, 120, 43, 38, 116, 101, 126, 123, 120, 105, 49, 42, 122, 116, 115, 107, 121, 99, 49, 60, 115, 100, 101, 125, 120, 113, 58, 54, 103, 117, 118, 96, 115}, "17466ec7", 0.0f);
                    break;
                case 22:
                    strDecode = C0000.decode(new byte[]{100, 36, 37, 126, 120, 121, 35, 37, 53, 125, 123, 127, 102, 109, 127, 44, 35, 117, 105, 120, 51, 50}, "6af167ffa44199", 0.0f);
                    break;
            }
        }
        operationImpl.add(strDecode, C0000.decode(new byte[]{67, 77, 82, 77, 71, 17, 34, 91, 82, 86}, "09392ba463"));
        operationImpl.add(this.zze, C0000.decode(new byte[]{74, 0, 69, 93, 93, 65, 68, 11, 87, 13}, "8e62140b8c86", 0.0f));
        return operationImpl.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.writeString(parcel, 2, this.zzd);
        CloseableKt.writeParcelable(parcel, 3, this.zze, i);
        CloseableKt.writeParcelable(parcel, 4, this.zzf, i);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzb(parcel, iZza);
    }

    public Status(String str, int i) {
        this(1, i, str, null, null);
    }
}
