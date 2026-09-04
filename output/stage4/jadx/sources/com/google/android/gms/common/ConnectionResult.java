package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.OperationImpl;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzag;
import java.util.Arrays;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public final int zza;
    public final int zzb;
    public final PendingIntent zzc;
    public final String zzd;
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb(0);

    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    public static String zza(int i) {
        if (i == 99) {
            return C0000.decode(new byte[]{109, 127, 35, 124, 119, 40, 100, 127, 125, 117}, "81e59a77", true);
        }
        if (i == 1500) {
            return C0000.decode(new byte[]{34, 103, 44, 98, 38, 109, 114, 104, 101, 39, 52, 123, 36, 120, 60, 97, 99, 127, 99, 35, 33, 112, 58, 102, 38, 99, 98, 121, 99, 39, 34}, "f5e4c2701b", 0.0f);
        }
        switch (i) {
            case -1:
                return C0000.decode(new byte[]{55, 44, 45, 123, 122, 52, 120}, "bbf55c6d5a6f7d", 0.0f);
            case 0:
                return C0000.decode(new byte[]{48, 99, 119, 32, 38, 100, 99}, "c64cc708", 0.0f);
            case 1:
                return C0000.decode(new byte[]{53, 113, 99, 101, 43, 119, 115, 110, 43, 125, 98, 96, 43, 122, 113}, "f413b461", false);
            case 2:
                return C0000.decode(new byte[]{97, 125, 107, 52, 123, 112, 124, 104, 52, 113, 96, 107, 112, 45, 124, 108, 108, 103, 38, 117, 102, 125, 102, 48, 119, 98, 108, 126, 48, 113, 118}, "289b2397b4", 4);
            case 3:
                return C0000.decode(new byte[]{53, 35, 102, 100, 122, 39, 119, 59, 34, 125, 98, 37, 36, 122, 117, 37}, "ff423d2df41df60a", 3);
            case 4:
                return C0000.decode(new byte[]{98, 45, 112, 126, 105, 127, 125, 104, 49, 33, 96, 49, 126, 98, 115, 114}, "1d706637cd", false);
            case 5:
                return C0000.decode(new byte[]{122, 47, 111, 32, 40, 47, 114, 109, 118, 117, 112, 46, 108, 47, 48}, "3a9adf6276", 0.0f);
            case 6:
                return C0000.decode(new byte[]{107, 124, 97, 42, 126, 54, 55, 42, 123, 124, 102, 107, 119, 52, 103, 42, 49, 38, 112}, "992e2ccc42");
            case 7:
                return C0000.decode(new byte[]{47, 36, 97, 53, 44, 48, 124, 110, 116, 54, 102, 118, 106}, "aa5bcb711d498e");
            case 8:
                return C0000.decode(new byte[]{125, 122, 53, 38, 100, 118, 39, 45, 58, 114, 55, 101, 122, 103}, "44ac68fae7e75551", 0.0f);
            case 9:
                return C0000.decode(new byte[]{55, 39, 100, 51, 112, 34, 113, 106, 120, 45, 96, 121, 41, 124, 124}, "db6e9a451c68e586", 7);
            case 10:
                return C0000.decode(new byte[]{112, 33, 52, 118, 124, 122, 102, 119, 107, 104, 113, 54, 48, 124, 98}, "4db3056297", 6);
            case 11:
                return C0000.decode(new byte[]{121, 121, 38, 33, 43, 48, 124, 104, 118, 120, 32, 39, 46, 60, 127, 118, 124, 124, 32, 32}, "50edec97", false);
            default:
                switch (i) {
                    case 13:
                        return C0000.decode(new byte[]{33, 119, 40, 116, 36, 121, 114, 37}, "b6f7a57a803fcb88", 0);
                    case 14:
                        return C0000.decode(new byte[]{48, 40, 126, 39, 118, 51, 100}, "da3b9f0ac8e6daef");
                    case 15:
                        return C0000.decode(new byte[]{124, 45, 98, 114, 101, 102, 96, 51, 98, 114, 115}, "5c6774");
                    case 16:
                        return C0000.decode(new byte[]{114, 104, 42, 59, 101, 122, 37, 97, 36, 45, 127, 121, 33, 40, 117}, "38cd04d7ed", 0.0f);
                    case 17:
                        return C0000.decode(new byte[]{96, 112, 37, 45, 110, 45, 44, 108, 118, 34, 43, 42, 38, 39}, "39bc1db30cbfcc72");
                    case 18:
                        return C0000.decode(new byte[]{49, 36, 54, 103, 42, 34, 115, 110, 101, 97, 113, 112, 55, 127, 126, 127}, "bad1ca610151c608", 0.0f);
                    case 19:
                        return C0000.decode(new byte[]{107, 36, 102, 96, 43, 118, 125, 62, 121, 127, 49, 102, 113, 47, 115, 105, 50, 112, 106, 44, 125, 101, 49, 124, 119, 47}, "8a46b5");
                    case 20:
                        return C0000.decode(new byte[]{100, 125, 106, 99, 103, 44, 33, 50, 115, 124, 102, 103, 103, 42, 36, 47, 122, 125}, "68975ebf", false);
                    case 21:
                        return C0000.decode(new byte[]{121, 96, 127, 104, 102, 33, 98, 55, 113, 127, 120, 104, 101, 52, 116, 37, 108, 117, 105, 101, 117, 53, 101, 45, 106, 117, 114}, "80670d0d", 2);
                    case 22:
                        return C0000.decode(new byte[]{98, 32, 48, 46, 124, 54, 100, 44, 44, 47, 111, 34, 115, 49, 42, 55, 121, 55, 105, 58, 45, 46, 100, 60, 118, 42, 54, 47, 116}, "0eca0c");
                    case 23:
                        return C0000.decode(new byte[]{32, 49, 113, 57, 34, 124, 100, 118, 112, 127, 39, 117}, "aa8ff57723b17a", true);
                    case 24:
                        return C0000.decode(new byte[]{32, 49, 43, 109, 125, 40, 101, 32, 118, 117, 116, 115, 104, 37, 46, 51, 61, 113, 118, 47, 120, 36, 119, 109, 120, 120, 121}, "aab29a6a49177c", false);
                    default:
                        return NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{52, 43, 42, 127, 44, 100, 127, 57, 114, 48, 106, 124, 96, 102, 32, 118, 37, 32, 73}, "aea1c31f7b8329c9", 0.0f), C0000.decode(new byte[]{31}, "6c73d5", false), i);
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.zzb == connectionResult.zzb && zzag.equal(this.zzc, connectionResult.zzc) && zzag.equal(this.zzd, connectionResult.zzd);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        OperationImpl operationImpl = new OperationImpl(this);
        operationImpl.add(zza(this.zzb), C0000.decode(new byte[]{70, 67, 80, 17, 17, 70, 115, 93, 0, 1}, "571ed502ddb3", 0.0f));
        operationImpl.add(this.zzc, C0000.decode(new byte[]{16, 80, 23, 11, 8, 76, 68, 92, 92, 8}, "b5ddd9053f9d", 0.0f));
        operationImpl.add(this.zzd, C0000.decode(new byte[]{11, 80, 67, 16, 85, 2, 85}, "f50c4e07b9fe18", 0.0f));
        return operationImpl.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i);
        CloseableKt.writeString(parcel, 4, this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }

    public ConnectionResult(int i) {
        this(1, i, null, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
