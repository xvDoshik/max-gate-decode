package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback$Stub$Proxy;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {
    public final AnonymousClass1 mBinder = new AnonymousClass1();

    /* JADX INFO: renamed from: androidx.core.content.UnusedAppRestrictionsBackportService$1, reason: invalid class name */
    public final class AnonymousClass1 extends Binder implements IUnusedAppRestrictionsBackportService {
        public AnonymousClass1() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback;
            String str = IUnusedAppRestrictionsBackportService.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                iUnusedAppRestrictionsBackportCallback = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) {
                    IUnusedAppRestrictionsBackportCallback$Stub$Proxy iUnusedAppRestrictionsBackportCallback$Stub$Proxy = new IUnusedAppRestrictionsBackportCallback$Stub$Proxy();
                    iUnusedAppRestrictionsBackportCallback$Stub$Proxy.mRemote = strongBinder;
                    iUnusedAppRestrictionsBackportCallback = iUnusedAppRestrictionsBackportCallback$Stub$Proxy;
                } else {
                    iUnusedAppRestrictionsBackportCallback = (IUnusedAppRestrictionsBackportCallback) iInterfaceQueryLocalInterface;
                }
            }
            if (iUnusedAppRestrictionsBackportCallback == null) {
                return true;
            }
            UnusedAppRestrictionsBackportService.this.isPermissionRevocationEnabled();
            return true;
        }
    }

    public abstract void isPermissionRevocationEnabled();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
