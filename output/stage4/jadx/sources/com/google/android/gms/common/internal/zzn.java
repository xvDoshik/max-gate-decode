package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzn {
    public static final Uri zza = new Uri.Builder().scheme(C0000.decode(new byte[]{80, 86, 13, 65, 93, 88, 70}, "39c5862d11", 0.0f)).authority(C0000.decode(new byte[]{0, 86, 88, 75, 87, 10, 89, 4, 10, 80, 24, 86, 95, 2, 71, 90, 10, 93, 27, 2, 93, 22, 24, 0, 14, 92, 91, 82, 67, 7}, "c95e0e6cf5671f55", false)).build();
    public final String zzb;
    public final String zzc;
    public final int zze;
    public final boolean zzf;

    public zzn(String str, boolean z) {
        zzag.checkNotEmpty(str);
        this.zzb = str;
        String strDecode = C0000.decode(new byte[]{81, 14, 84, 28, 3, 91, 95, 82, 13, 81, 77, 84, 15, 92, 23, 93, 91, 5, 23, 85, 9, 71}, "2a92d405a4c5a8e2", 0.0f);
        zzag.checkNotEmpty(strDecode);
        this.zzc = strDecode;
        this.zze = 4225;
        this.zzf = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        return zzag.equal(this.zzb, zznVar.zzb) && zzag.equal(this.zzc, zznVar.zzc) && zzag.equal(null, null) && this.zze == zznVar.zze && this.zzf == zznVar.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, null, Integer.valueOf(this.zze), Boolean.valueOf(this.zzf)});
    }

    public final String toString() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        zzag.checkNotNull(null);
        throw null;
    }

    public final Intent zzc(Context context) {
        Bundle bundleCall;
        Intent intent = null;
        String str = this.zzb;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.zzf) {
            Bundle bundle = new Bundle();
            bundle.putString(C0000.decode(new byte[]{18, 1, 66, 69, 95, 6, 4, 36, 82, 70, 8, 11, 94, 113, 67, 11, 5, 9, 84, 121, 4, 29}, "ad036eae12", false), str);
            try {
                bundleCall = context.getContentResolver().call(zza, C0000.decode(new byte[]{17, 92, 65, 19, 93, 5, 7, 112, 93, 17, 81, 8, 22, 122, 82, 9, 88}, "b93e4f", 0.0f), (String) null, bundle);
            } catch (IllegalArgumentException e) {
                C0000.decode(new byte[]{115, 26, 11, 85, 12, 13, 90, 18, 80, 89, 66, 85, 89, 23, 69, 70, 4, 23, 86, 94, 76, 67, 95, 95, 89, 67, 3, 85, 8, 8, 92, 86, 3, 23}, "7ce4ad929760", 2).concat(e.toString());
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable(C0000.decode(new byte[]{16, 82, 71, 78, 15, 6, 6, 101, 80, 75, 22, 10, 13, 68, 80, 113, 8, 17, 6, 89, 65, 115, 3, 28}, "c758fe", 0)) : null;
            if (intent == null) {
                C0000.decode(new byte[]{32, 64, 92, 88, 91, 91, 85, 65, 13, 93, 13, 93, 69, 68, 18, 80, 11, 75, 18, 80, 88, 70, 83, 15, 21, 18, 4, 87, 89, 88, 87, 82, 68, 95, 93, 75, 22, 83, 85, 21, 8, 93, 12, 12, 16}, "d929626aa2b60426").concat(String.valueOf(str));
            }
        }
        return intent != null ? intent : new Intent(str).setPackage(this.zzc);
    }
}
