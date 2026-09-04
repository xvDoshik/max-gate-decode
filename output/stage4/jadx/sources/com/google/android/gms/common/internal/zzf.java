package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzf extends zza {
    public final IBinder zze;
    public final /* synthetic */ GmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(GmsClient gmsClient, int i, IBinder iBinder, Bundle bundle) {
        super(gmsClient, i, bundle);
        this.zzf = gmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        ConnectionPool connectionPool = this.zzf.zzx;
        if (connectionPool != null) {
            ((GoogleApiClient.OnConnectionFailedListener) connectionPool.delegate).onConnectionFailed(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        IInterface iInterfaceCreateServiceInterface;
        IBinder iBinder = this.zze;
        try {
            zzag.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            GmsClient gmsClient = this.zzf;
            if (!gmsClient.getServiceDescriptor().equals(interfaceDescriptor) || (iInterfaceCreateServiceInterface = gmsClient.createServiceInterface(iBinder)) == null) {
                return false;
            }
            if (!GmsClient.zzn(gmsClient, 2, 4, iInterfaceCreateServiceInterface) && !GmsClient.zzn(gmsClient, 3, 4, iInterfaceCreateServiceInterface)) {
                return false;
            }
            gmsClient.zzB = null;
            ConnectionPool connectionPool = gmsClient.zzw;
            if (connectionPool == null) {
                return true;
            }
            ((GoogleApiClient.ConnectionCallbacks) connectionPool.delegate).onConnected();
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
