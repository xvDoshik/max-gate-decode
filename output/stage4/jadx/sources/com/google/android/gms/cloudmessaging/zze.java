package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zze implements Parcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzb(1);
    public final Messenger zza;

    public zze(IBinder iBinder) {
        this.zza = new Messenger(iBinder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Messenger messenger = this.zza;
            messenger.getClass();
            IBinder binder = messenger.getBinder();
            Messenger messenger2 = ((zze) obj).zza;
            messenger2.getClass();
            return binder.equals(messenger2.getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        Messenger messenger = this.zza;
        messenger.getClass();
        return messenger.getBinder().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zza;
        messenger.getClass();
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
