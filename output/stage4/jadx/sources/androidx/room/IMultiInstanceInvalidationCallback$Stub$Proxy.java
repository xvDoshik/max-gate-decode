package androidx.room;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class IMultiInstanceInvalidationCallback$Stub$Proxy implements IInterface {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void onInvalidation(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(C0000.decode(new byte[]{88, 88, 93, 23, 89, 90, 80, 74, 72, 16, 13, 87, 84, 24, 112, 40, 67, 95, 64, 91, 47, 12, 17, 76, 88, 88, 90, 0, 127, 93, 66, 83, 10, 11, 6, 89, 77, 95, 86, 11, 117, 82, 88, 94, 4, 3, 1, 83}, "969e6342fbb8", true));
            parcelObtain.writeStringArray(strArr);
            this.mRemote.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
