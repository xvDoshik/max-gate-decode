package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.work.Worker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class GmsClient implements Api.Client {
    public static final Feature[] zze = new Feature[0];
    public final Set zac;
    public volatile String zzA;
    public ConnectionResult zzB;
    public boolean zzC;
    public volatile zzj zzD;
    public zzu zza;
    public final zzb zzb;
    public zabu zzc;
    public final AtomicInteger zzd;
    public volatile String zzk;
    public final Context zzl;
    public final zzr zzn;
    public final Object zzp;
    public final Object zzq;
    public zzac zzr;
    public IInterface zzs;
    public final ArrayList zzt;
    public zze zzu;
    public int zzv;
    public final ConnectionPool zzw;
    public final ConnectionPool zzx;
    public final int zzy;
    public final String zzz;

    public GmsClient(Context context, Looper looper, int i, com.google.android.gms.cloudmessaging.zzac zzacVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        synchronized (zzr.zzc$1) {
            try {
                if (zzr.zzd$1 == null) {
                    zzr.zzd$1 = new zzr(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzr zzrVar = zzr.zzd$1;
        Object obj = GoogleApiAvailability.zaa;
        zzag.checkNotNull(connectionCallbacks);
        zzag.checkNotNull(onConnectionFailedListener);
        ConnectionPool connectionPool = new ConnectionPool(16, connectionCallbacks);
        ConnectionPool connectionPool2 = new ConnectionPool(17, onConnectionFailedListener);
        String str = (String) zzacVar.zzb;
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        zzag.checkNotNull(context, C0000.decode(new byte[]{32, 9, 13, 70, 7, 78, 18, 25, 14, 23, 74, 23, 67, 8, 12, 70, 66, 84, 3, 25, 13, 23, 85, 15}, "cfc2b6f9cb9c"));
        this.zzl = context;
        zzag.checkNotNull(looper, C0000.decode(new byte[]{47, 11, 11, 72, 6, 65, 67, 9, 17, 75, 23, 19, 13, 11, 16, 24, 1, 86, 67, 10, 17, 84, 15}, "cdd8c3", 4));
        zzag.checkNotNull(zzrVar, C0000.decode(new byte[]{54, 76, 22, 7, 16, 65, 93, 16, 86, 23, 21, 84, 20, 23, 77, 70, 11, 86, 18, 66, 0, 82, 20, 13, 76, 9, 89}, "e9fbb74c9e59ad9f", false));
        this.zzn = zzrVar;
        this.zzb = new zzb(this, looper);
        this.zzy = i;
        this.zzw = connectionPool;
        this.zzx = connectionPool2;
        this.zzz = str;
        Set set = (Set) zzacVar.zza;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException(C0000.decode(new byte[]{118, 25, 64, 7, 86, 83, 90, 94, 81, 20, 71, 81, 92, 17, 85, 21, 24, 94, 64, 16, 88, 91, 64, 18, 67, 4, 66, 11, 81, 67, 71, 85, 82, 24, 20, 71, 64, 4, 16, 15, 85, 71, 95, 89, 83, 80, 20, 65, 80, 14, 64, 3, 75, 23, 90, 94, 69, 64, 81, 83, 87}, "3a0f87306442", 1));
            }
        }
        this.zac = set;
    }

    public static /* bridge */ /* synthetic */ boolean zzn(GmsClient gmsClient, int i, int i2, IInterface iInterface) {
        synchronized (gmsClient.zzp) {
            try {
                if (gmsClient.zzv != i) {
                    return false;
                }
                gmsClient.zzp(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void connect(zabu zabuVar) {
        this.zzc = zabuVar;
        zzp(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    @Override // com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    zza zzaVar = (zza) this.zzt.get(i);
                    synchronized (zzaVar) {
                        zzaVar.zza$1 = null;
                    }
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    public abstract Feature[] getApiFeatures();

    @Override // com.google.android.gms.common.api.Api.Client
    public final Feature[] getAvailableFeatures() {
        zzj zzjVar = this.zzD;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.zzb;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void getEndpointPackageName() {
        if (!isConnected() || this.zza == null) {
            throw new RuntimeException(C0000.decode(new byte[]{35, 83, 13, 14, 6, 80, 21, 70, 9, 23, 86, 14, 10, 91, 0, 81, 16, 66, 20, 92, 80, 92, 70, 84, 93, 4, 7, 94, 12, 92, 3, 66, 19, 85, 86, 89, 7, 80, 80}, "e2dbc452f75ad5", 2));
        }
    }

    public abstract Bundle getGetServiceRequestExtraArgs();

    @Override // com.google.android.gms.common.api.Api.Client
    public final String getLastDisconnectMessage() {
        return this.zzk;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        int i = this.zzy;
        String str = this.zzA;
        int i2 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i, i2, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            getServiceRequest.zzj = new Account(C0000.decode(new byte[]{95, 89, 84, 80, 85, 7, 17, 90, 18, 22, 82, 84, 82, 89, 22, 11, 68, 11, 13}, "ce053fd6f63716", 2), C0000.decode(new byte[]{6, 13, 88, 28, 5, 93, 94, 83, 10, 0}, "eb52b214fef4d2", 0.0f));
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = ((zzv) iAccountAccessor).zza;
            }
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        try {
            try {
                synchronized (this.zzq) {
                    try {
                        zzac zzacVar = this.zzr;
                        if (zzacVar != null) {
                            zzacVar.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (RemoteException | RuntimeException unused) {
                int i3 = this.zzd.get();
                zzb zzbVar = this.zzb;
                zzbVar.sendMessage(zzbVar.obtainMessage(1, i3, -1, new zzf(this, 8, null, null)));
            }
        } catch (DeadObjectException unused2) {
            zzb zzbVar2 = this.zzb;
            zzbVar2.sendMessage(zzbVar2.obtainMessage(6, this.zzd.get(), 3));
        } catch (SecurityException e) {
            throw e;
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.EMPTY_SET;
    }

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public abstract boolean getUseDynamicLookup();

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(ConnectionPool connectionPool) {
        ((zabq) connectionPool.delegate).zaa.zat.post(new Worker.AnonymousClass1(10, connectionPool));
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return false;
    }

    public final void zzp(int i, IInterface iInterface) {
        zzu zzuVar;
        if ((i == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                if (i == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        zzr zzrVar = this.zzn;
                        String str = this.zza.zza;
                        zzag.checkNotNull(str);
                        this.zza.getClass();
                        if (this.zzz == null) {
                            this.zzl.getClass();
                        }
                        zzrVar.zzb(str, zzeVar, this.zza.zzd);
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzuVar = this.zza) != null) {
                        String str2 = zzuVar.zza;
                        zzr zzrVar2 = this.zzn;
                        zzag.checkNotNull(str2);
                        this.zza.getClass();
                        if (this.zzz == null) {
                            this.zzl.getClass();
                        }
                        zzrVar2.zzb(str2, zzeVar2, this.zza.zzd);
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    String startServiceAction = getStartServiceAction();
                    boolean useDynamicLookup = getUseDynamicLookup();
                    this.zza = new zzu(startServiceAction, useDynamicLookup);
                    if (useDynamicLookup && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException(C0000.decode(new byte[]{45, 93, 76, 6, 23, 87, 7, 94, 69, 125, 22, 65, 87, 17, 73, 25, 18, 90, 0, 24, 9, 90, 86, 10, 8, 76, 11, 18, 4, 72, 15, 19, 78, 6, 23, 74, 15, 93, 11, 24, 11, 85, 24, 23, 13, 80, 21, 18, 39, 89, 23, 86, 127, 14, 22, 122, 10, 91, 0, 86, 16, 19, 81, 16, 69, 77, 9, 93, 69, 84, 11, 68, 24, 23, 10, 25, 21, 71, 21, 72, 11, 65, 76, 67, 1, 64, 8, 83, 8, 81, 7, 19, 84, 12, 10, 82, 19, 66, 75, 24, 55, 71, 89, 17, 17, 25, 21, 87, 23, 78, 13, 80, 93, 67, 4, 90, 18, 91, 10, 86, 94, 19}, "d38ce9f2e8", 0.0f).concat(String.valueOf(this.zza.zza)));
                    }
                    zzr zzrVar3 = this.zzn;
                    String str3 = this.zza.zza;
                    zzag.checkNotNull(str3);
                    this.zza.getClass();
                    String name = this.zzz;
                    if (name == null) {
                        name = this.zzl.getClass().getName();
                    }
                    if (!zzrVar3.zzc(new zzn(str3, this.zza.zzd), zzeVar3, name)) {
                        String str4 = this.zza.zza;
                        int i2 = this.zzd.get();
                        zzb zzbVar = this.zzb;
                        zzbVar.sendMessage(zzbVar.obtainMessage(7, i2, -1, new zzg(this, 16)));
                    }
                } else if (i == 4) {
                    zzag.checkNotNull(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
