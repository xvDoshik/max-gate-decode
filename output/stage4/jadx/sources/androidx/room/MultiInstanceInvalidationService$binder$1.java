package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MultiInstanceInvalidationService$binder$1 extends Binder implements IInterface {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
        attachInterface(this, C0000.decode(new byte[]{7, 95, 86, 75, 9, 88, 0, 30, 72, 67, 93, 86, 11, 31, 45, 43, 19, 93, 70, 80, 47, 95, 23, 18, 7, 95, 81, 92, 47, 95, 18, 7, 10, 88, 86, 88, 18, 88, 11, 8, 53, 84, 64, 79, 15, 82, 1}, "f129f1df", 0.0f));
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        String strDecode = C0000.decode(new byte[]{84, 12, 7, 69, 12, 13, 80, 76, 75, 23, 86, 95, 94, 25, 123, 126, 64, 14, 23, 94, 42, 10, 71, 64, 4, 11, 90, 85, 122, 89, 68, 82, 89, 11, 7, 86, 23, 13, 91, 90, 54, 0, 75, 70, 90, 84, 87}, "5bc7cd44ee903723", 0.0f);
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(strDecode);
        }
        if (i == 1598968902) {
            parcel2.writeString(strDecode);
            return true;
        }
        IMultiInstanceInvalidationCallback$Stub$Proxy iMultiInstanceInvalidationCallback$Stub$Proxy = null;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(C0000.decode(new byte[]{2, 89, 93, 70, 87, 11, 86, 64, 72, 71, 92, 10, 11, 23, 122, 116, 22, 91, 77, 93, 113, 12, 65, 76, 7, 91, 80, 0, 47, 87, 69, 88, 15, 94, 93, 85, 76, 11, 93, 86, 37, 84, 95, 9, 4, 88, 80, 82}, "c7948b28f53ef939", 0.0f));
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback$Stub$Proxy)) {
                    iMultiInstanceInvalidationCallback$Stub$Proxy = new IMultiInstanceInvalidationCallback$Stub$Proxy();
                    iMultiInstanceInvalidationCallback$Stub$Proxy.mRemote = strongBinder;
                } else {
                    iMultiInstanceInvalidationCallback$Stub$Proxy = (IMultiInstanceInvalidationCallback$Stub$Proxy) iInterfaceQueryLocalInterface;
                }
            }
            String string = parcel.readString();
            int i3 = 0;
            if (string != null) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
                synchronized (multiInstanceInvalidationService.callbackList) {
                    try {
                        int i4 = multiInstanceInvalidationService.maxClientId + 1;
                        multiInstanceInvalidationService.maxClientId = i4;
                        if (multiInstanceInvalidationService.callbackList.register(iMultiInstanceInvalidationCallback$Stub$Proxy, Integer.valueOf(i4))) {
                            multiInstanceInvalidationService.clientNames.put(Integer.valueOf(i4), string);
                            i3 = i4;
                        } else {
                            multiInstanceInvalidationService.maxClientId--;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            parcel2.writeNoException();
            parcel2.writeInt(i3);
            return true;
        }
        if (i == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(C0000.decode(new byte[]{89, 11, 81, 71, 14, 94, 92, 29, 27, 71, 14, 88, 85, 75, 124, 120, 20, 91, 76, 12, 124, 91, 18, 67, 89, 11, 86, 80, 40, 89, 78, 4, 89, 92, 5, 86, 76, 12, 90, 91, 34, 86, 84, 9, 87, 84, 2, 92}, "8e55a7", 4));
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMultiInstanceInvalidationCallback$Stub$Proxy)) {
                    iMultiInstanceInvalidationCallback$Stub$Proxy = new IMultiInstanceInvalidationCallback$Stub$Proxy();
                    iMultiInstanceInvalidationCallback$Stub$Proxy.mRemote = strongBinder2;
                } else {
                    iMultiInstanceInvalidationCallback$Stub$Proxy = (IMultiInstanceInvalidationCallback$Stub$Proxy) iInterfaceQueryLocalInterface2;
                }
            }
            int i5 = parcel.readInt();
            MultiInstanceInvalidationService multiInstanceInvalidationService2 = this.this$0;
            synchronized (multiInstanceInvalidationService2.callbackList) {
                multiInstanceInvalidationService2.callbackList.unregister(iMultiInstanceInvalidationCallback$Stub$Proxy);
            }
            parcel2.writeNoException();
            return true;
        }
        if (i != 3) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        int i6 = parcel.readInt();
        String[] strArrCreateStringArray = parcel.createStringArray();
        MultiInstanceInvalidationService multiInstanceInvalidationService3 = this.this$0;
        synchronized (multiInstanceInvalidationService3.callbackList) {
            try {
                String str = (String) multiInstanceInvalidationService3.clientNames.get(Integer.valueOf(i6));
                if (str != null) {
                    int iBeginBroadcast = multiInstanceInvalidationService3.callbackList.beginBroadcast();
                    for (int i7 = 0; i7 < iBeginBroadcast; i7++) {
                        try {
                            Integer num = (Integer) multiInstanceInvalidationService3.callbackList.getBroadcastCookie(i7);
                            int iIntValue = num.intValue();
                            String str2 = (String) multiInstanceInvalidationService3.clientNames.get(num);
                            if (i6 != iIntValue && str.equals(str2)) {
                                try {
                                    ((IMultiInstanceInvalidationCallback$Stub$Proxy) multiInstanceInvalidationService3.callbackList.getBroadcastItem(i7)).onInvalidation(strArrCreateStringArray);
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th2) {
                            multiInstanceInvalidationService3.callbackList.finishBroadcast();
                            throw th2;
                        }
                    }
                    multiInstanceInvalidationService3.callbackList.finishBroadcast();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return true;
    }
}
