package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzb implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = CharsKt.validateObjectHeader(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i = parcel.readInt();
                    if (((char) i) != 1) {
                        CharsKt.skipUnknownField(parcel, i);
                    } else {
                        intent = (Intent) CharsKt.createParcelable(parcel, i, Intent.CREATOR);
                    }
                }
                CharsKt.ensureAtEnd(parcel, iValidateObjectHeader);
                return new CloudMessage(intent);
            default:
                return new zze(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new CloudMessage[i];
            default:
                return new zze[i];
        }
    }
}
