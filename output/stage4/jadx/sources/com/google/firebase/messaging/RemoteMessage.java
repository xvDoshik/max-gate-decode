package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzb;
import java.util.Map;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzb(15);
    public final Bundle bundle;
    public ArrayMap data;

    public RemoteMessage(Bundle bundle) {
        this.bundle = bundle;
    }

    public final Map getData() {
        if (this.data == null) {
            ArrayMap arrayMap = new ArrayMap();
            Bundle bundle = this.bundle;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith(C0000.decode(new byte[]{86, 14, 90, 2, 95, 85, 31}, "1a5e30", 4)) && !str.startsWith(C0000.decode(new byte[]{3, 6, 84, 77}, "de9c8cc2a8", 7)) && !str.equals(C0000.decode(new byte[]{0, 17, 13, 85}, "fcb8b39b4b", 7)) && !str.equals(C0000.decode(new byte[]{89, 93, 67, 22, 87, 87, 83, 57, 64, 65, 64, 0}, "480e606f", 0)) && !str.equals(C0000.decode(new byte[]{91, 12, 85, 88, 87, 69, 75, 6, 102, 95, 83, 76}, "8c9465", false))) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.data = arrayMap;
        }
        return this.data;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeBundle(parcel, 2, this.bundle);
        CloseableKt.zzb(parcel, iZza);
    }
}
