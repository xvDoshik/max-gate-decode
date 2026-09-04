package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.ContainerHelpers;
import androidx.work.Worker;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zan;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Api.Client zac;
    public final ApiKey zad;
    public final WorkLauncherImpl zae;
    public final int zah;
    public boolean zaj;
    public final LinkedList zab = new LinkedList();
    public final HashSet zaf = new HashSet();
    public final HashMap zag = new HashMap();
    public final ArrayList zak = new ArrayList();
    public ConnectionResult zal = null;

    public zabq(GoogleApiManager googleApiManager, zao zaoVar) {
        this.zaa = googleApiManager;
        Looper looper = googleApiManager.zat.getLooper();
        Context context = zaoVar.zab;
        WorkTagDao_Impl workTagDao_Impl = new WorkTagDao_Impl();
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) workTagDao_Impl.__db) == null) {
            workTagDao_Impl.__db = new ArraySet(0);
        }
        ((ArraySet) workTagDao_Impl.__db).addAll(set);
        workTagDao_Impl.__preparedStmtOfDeleteByWorkSpecId = context.getClass().getName();
        workTagDao_Impl.__insertionAdapterOfWorkTag = context.getPackageName();
        zzac zzacVar = new zzac((ArraySet) workTagDao_Impl.__db, (String) workTagDao_Impl.__insertionAdapterOfWorkTag, (String) workTagDao_Impl.__preparedStmtOfDeleteByWorkSpecId);
        zan zanVar = (zan) zaoVar.zad.zaa;
        zzag.checkNotNull(zanVar);
        Context context2 = zaoVar.zab;
        TelemetryLoggingOptions telemetryLoggingOptions = zaoVar.zae$1;
        zanVar.getClass();
        zap zapVar = new zap(context2, looper, zzacVar, telemetryLoggingOptions, this, this);
        String str = zaoVar.zac;
        if (str != null) {
            zapVar.zzA = str;
        }
        this.zac = zapVar;
        this.zad = zaoVar.zaf;
        this.zae = new WorkLauncherImpl();
        this.zah = zaoVar.zah;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected() {
        Looper looperMyLooper = Looper.myLooper();
        zaq zaqVar = this.zaa.zat;
        if (looperMyLooper == zaqVar.getLooper()) {
            zaG();
        } else {
            zaqVar.post(new Worker.AnonymousClass1(9, this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Looper looperMyLooper = Looper.myLooper();
        zaq zaqVar = this.zaa.zat;
        if (looperMyLooper == zaqVar.getLooper()) {
            zaH(i);
        } else {
            zaqVar.post(new zabn(this, i, 0));
        }
    }

    public final void zaC(ConnectionResult connectionResult) {
        HashSet hashSet = this.zaf;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (zzag.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                this.zac.getEndpointPackageName();
            }
            throw null;
        }
    }

    public final void zaD(Status status) {
        zzag.checkHandlerThread(this.zaa.zat);
        zaE(status, null, false);
    }

    public final void zaE(Status status, Exception exc, boolean z) {
        zzag.checkHandlerThread(this.zaa.zat);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{54, 64, 82, 18, 71, 16, 18, 57, 121, 55, 66, 6, 30, 80, 81, 21, 17, 93, 92, 8, 18, 16, 90, 14, 67, 9, 6, 67, 4, 86, 20, 11, 16, 88, 95}, "e43f2c2a6ebcf34e", 0.0f));
        }
        Iterator it = this.zab.iterator();
        while (it.hasNext()) {
            zac zacVar = (zac) it.next();
            if (!z || zacVar.zac == 2) {
                if (status != null) {
                    zacVar.zad(status);
                } else {
                    zacVar.zae(exc);
                }
                it.remove();
            }
        }
    }

    public final void zaF() {
        LinkedList linkedList = this.zab;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zac zacVar = (zac) arrayList.get(i);
            if (!this.zac.isConnected()) {
                return;
            }
            if (zaL(zacVar)) {
                linkedList.remove(zacVar);
            }
        }
    }

    public final void zaG() {
        GoogleApiManager googleApiManager = this.zaa;
        zzag.checkHandlerThread(googleApiManager.zat);
        this.zal = null;
        zaC(ConnectionResult.RESULT_SUCCESS);
        zaq zaqVar = googleApiManager.zat;
        if (this.zaj) {
            ApiKey apiKey = this.zad;
            zaqVar.removeMessages(11, apiKey);
            zaqVar.removeMessages(9, apiKey);
            this.zaj = false;
        }
        Iterator it = this.zag.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        zaF();
        zaI();
    }

    public final void zaH(int i) {
        GoogleApiManager googleApiManager = this.zaa;
        zaq zaqVar = googleApiManager.zat;
        zzag.checkHandlerThread(googleApiManager.zat);
        this.zal = null;
        this.zaj = true;
        String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
        WorkLauncherImpl workLauncherImpl = this.zae;
        workLauncherImpl.getClass();
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{100, 12, 7, 24, 82, 89, 94, 10, 7, 91, 69, 95, 95, 10, 66, 76, 94, 22, 119, 11, 13, 95, 93, 83, 16, 52, 14, 89, 72, 22, 67, 1, 16, 78, 88, 85, 85, 23, 66, 79, 80, 69, 16, 8, 13, 75, 69}, "0db816"));
        if (i == 1) {
            sb.append(C0000.decode(new byte[]{18, 2, 71, 83, 20, 22, 10, 17, 71, 85, 65, 19, 91, 5, 87, 22, 80, 11, 22, 82, 91, 94, 93, 0, 81, 18, 91, 89, 90, 76}, "2f264be1403e", 0.0f));
        } else if (i == 3) {
            sb.append(C0000.decode(new byte[]{18, 6, 67, 86, 65, 66, 91, 67, 84, 3, 82, 7, 18, 13, 84, 89, 4, 85, 64, 67, 85, 30, 80, 6, 66, 22, 95, 92, 15, 24}, "2b63a64c0f3c", 0.0f));
        }
        if (lastDisconnectMessage != null) {
            sb.append(C0000.decode(new byte[]{18, 125, 80, 71, 23, 70, 71, 84, 5, 66, 11, 10, 19, 95, 93, 67, 18, 85, 88, 71, 0, 9, 91, 95, 1, 82, 16, 94, 19}, "2114cf51d1dd3921", 0));
            sb.append(lastDisconnectMessage);
        }
        workLauncherImpl.zah(true, new Status(sb.toString(), 20));
        ApiKey apiKey = this.zad;
        zaqVar.sendMessageDelayed(Message.obtain(zaqVar, 9, apiKey), 5000L);
        zaqVar.sendMessageDelayed(Message.obtain(zaqVar, 11, apiKey), 120000L);
        ((SparseIntArray) googleApiManager.zam.zaa).clear();
        Iterator it = this.zag.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void zaI() {
        GoogleApiManager googleApiManager = this.zaa;
        zaq zaqVar = googleApiManager.zat;
        ApiKey apiKey = this.zad;
        zaqVar.removeMessages(12, apiKey);
        zaqVar.sendMessageDelayed(zaqVar.obtainMessage(12, apiKey), googleApiManager.zag);
    }

    public final boolean zaL(zac zacVar) {
        Feature feature;
        String strDecode = C0000.decode(new byte[]{115, 92, 7, 83, 126, 82, 88, 4, 85, 65, 114, 65, 5, 82, 65, 68, 91, 14, 88, 21, 67, 81, 20, 88, 70, 94, 18, 22, 94, 92, 91, 92, 70, 69, 68, 94, 92, 8, 88, 82, 23, 120, 22, 94, 114, 81, 94, 13, 100, 64, 89, 87, 3, 69, 31}, "79f7102a65");
        if (zacVar == null) {
            WorkLauncherImpl workLauncherImpl = this.zae;
            Api.Client client = this.zac;
            zacVar.zag(workLauncherImpl, client.requiresSignIn());
            try {
                zacVar.zaf(this);
                return true;
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                client.disconnect(strDecode);
                return true;
            }
        }
        Feature[] featureArrZab = zacVar.zab(this);
        if (featureArrZab == null || featureArrZab.length == 0) {
            feature = null;
            break;
        }
        Feature[] availableFeatures = this.zac.getAvailableFeatures();
        if (availableFeatures == null) {
            availableFeatures = new Feature[0];
        }
        int length = availableFeatures.length;
        ArrayMap arrayMap = new ArrayMap();
        if (length == 0) {
            arrayMap.mHashes = ContainerHelpers.EMPTY_INTS;
            arrayMap.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            arrayMap.allocArrays(length);
        }
        arrayMap.mSize = 0;
        for (Feature feature2 : availableFeatures) {
            arrayMap.put(feature2.zza, Long.valueOf(feature2.getVersion()));
        }
        int length2 = featureArrZab.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                feature = null;
                break;
            }
            feature = featureArrZab[i];
            Long l = (Long) arrayMap.get(feature.zza);
            if (l == null || l.longValue() < feature.getVersion()) {
                break;
            }
            i++;
        }
        if (feature == null) {
            WorkLauncherImpl workLauncherImpl2 = this.zae;
            Api.Client client2 = this.zac;
            zacVar.zag(workLauncherImpl2, client2.requiresSignIn());
            try {
                zacVar.zaf(this);
                return true;
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                client2.disconnect(strDecode);
                return true;
            }
        }
        new StringBuilder(this.zac.getClass().getName().length() + 77 + String.valueOf(feature.zza).length());
        if (!this.zaa.zau || !zacVar.zaa(this)) {
            zacVar.zae(new UnsupportedApiCallException(feature));
            return true;
        }
        zabs zabsVar = new zabs(this.zad, feature);
        int iIndexOf = this.zak.indexOf(zabsVar);
        if (iIndexOf >= 0) {
            zabs zabsVar2 = (zabs) this.zak.get(iIndexOf);
            this.zaa.zat.removeMessages(15, zabsVar2);
            zaq zaqVar = this.zaa.zat;
            zaqVar.sendMessageDelayed(Message.obtain(zaqVar, 15, zabsVar2), 5000L);
        } else {
            this.zak.add(zabsVar);
            zaq zaqVar2 = this.zaa.zat;
            zaqVar2.sendMessageDelayed(Message.obtain(zaqVar2, 15, zabsVar), 5000L);
            zaq zaqVar3 = this.zaa.zat;
            zaqVar3.sendMessageDelayed(Message.obtain(zaqVar3, 16, zabsVar), 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!zaM(connectionResult)) {
                this.zaa.zaG(connectionResult, this.zah);
            }
        }
        return false;
    }

    public final boolean zaM(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.zac) {
        }
        return false;
    }

    public final void zao() {
        GoogleApiManager googleApiManager = this.zaa;
        zzag.checkHandlerThread(googleApiManager.zat);
        Api.Client client = this.zac;
        if (client.isConnected() || client.isConnecting()) {
            return;
        }
        try {
            Api api = googleApiManager.zam;
            Context context = googleApiManager.zak;
            SparseIntArray sparseIntArray = (SparseIntArray) api.zaa;
            zzag.checkNotNull(context);
            int minApkVersion = client.getMinApkVersion();
            int iIsGooglePlayServicesAvailable = ((SparseIntArray) api.zaa).get(minApkVersion, -1);
            if (iIsGooglePlayServicesAvailable == -1) {
                iIsGooglePlayServicesAvailable = 0;
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iIsGooglePlayServicesAvailable = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (iIsGooglePlayServicesAvailable == -1) {
                    iIsGooglePlayServicesAvailable = ((GoogleApiAvailability) api.zac).isGooglePlayServicesAvailable(context, minApkVersion);
                }
                sparseIntArray.put(minApkVersion, iIsGooglePlayServicesAvailable);
            }
            if (iIsGooglePlayServicesAvailable != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iIsGooglePlayServicesAvailable, null);
                new StringBuilder(client.getClass().getName().length() + 35 + connectionResult.toString().length());
                zar(connectionResult, null);
                return;
            }
            zabu zabuVar = new zabu(googleApiManager, client, this.zad);
            if (client.requiresSignIn()) {
                zzag.checkNotNull(null);
                throw null;
            }
            try {
                client.connect(zabuVar);
            } catch (SecurityException e) {
                zar(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e2) {
            zar(new ConnectionResult(10), e2);
        }
    }

    public final void zap(zac zacVar) {
        zzag.checkHandlerThread(this.zaa.zat);
        boolean zIsConnected = this.zac.isConnected();
        LinkedList linkedList = this.zab;
        if (zIsConnected) {
            if (zaL(zacVar)) {
                zaI();
                return;
            } else {
                linkedList.add(zacVar);
                return;
            }
        }
        linkedList.add(zacVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult == null || connectionResult.zzb == 0 || connectionResult.zzc == null) {
            zao();
        } else {
            zar(connectionResult, null);
        }
    }

    public final void zar(ConnectionResult connectionResult, RuntimeException runtimeException) {
        zzag.checkHandlerThread(this.zaa.zat);
        zzag.checkHandlerThread(this.zaa.zat);
        this.zal = null;
        ((SparseIntArray) this.zaa.zam.zaa).clear();
        zaC(connectionResult);
        if ((this.zac instanceof zap) && connectionResult.zzb != 24) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zah = true;
            zaq zaqVar = googleApiManager.zat;
            zaqVar.sendMessageDelayed(zaqVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.zzb == 4) {
            zaD(GoogleApiManager.zab);
            return;
        }
        if (this.zab.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (runtimeException != null) {
            zzag.checkHandlerThread(this.zaa.zat);
            zaE(null, runtimeException, false);
            return;
        }
        if (!this.zaa.zau) {
            zaD(GoogleApiManager.zaH(this.zad, connectionResult));
            return;
        }
        zaE(GoogleApiManager.zaH(this.zad, connectionResult), null, true);
        if (this.zab.isEmpty() || zaM(connectionResult) || this.zaa.zaG(connectionResult, this.zah)) {
            return;
        }
        if (connectionResult.zzb == 18) {
            this.zaj = true;
        }
        if (!this.zaj) {
            zaD(GoogleApiManager.zaH(this.zad, connectionResult));
        } else {
            zaq zaqVar2 = this.zaa.zat;
            zaqVar2.sendMessageDelayed(Message.obtain(zaqVar2, 9, this.zad), 5000L);
        }
    }

    public final void zav() {
        zzag.checkHandlerThread(this.zaa.zat);
        Status status = GoogleApiManager.zaa;
        zaD(status);
        this.zae.zah(false, status);
        for (ListenerHolder$ListenerKey listenerHolder$ListenerKey : (ListenerHolder$ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder$ListenerKey[0])) {
            zap(new zah(new TaskCompletionSource()));
        }
        zaC(new ConnectionResult(4));
        Api.Client client = this.zac;
        if (client.isConnected()) {
            client.onUserSignOut(new ConnectionPool(14, this));
        }
    }
}
