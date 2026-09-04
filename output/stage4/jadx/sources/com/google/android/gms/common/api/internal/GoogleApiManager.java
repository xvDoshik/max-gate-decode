package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import androidx.collection.MapCollections$ArrayIterator;
import androidx.work.impl.WorkLauncherImpl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi$Settings;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(C0000.decode(new byte[]{100, 90, 86, 95, 73, 10, 77, 69, 68, 14, 84, 80, 68, 67, 22, 0, 92, 17, 19, 9, 94, 95, 84, 17, 16, 13, 81, 66, 68, 32, 103, 122, 17, 82, 5, 9, 84, 17, 19, 0, 68, 19, 88, 95, 68, 21, 74, 94, 3, 19, 82, 64, 66, 31}, "7311de81da"), 4);
    public static final Status zab = new Status(C0000.decode(new byte[]{109, 14, 83, 67, 71, 74, 86, 67, 16, 95, 71, 64, 77, 70, 84, 6, 18, 74, 90, 86, 94, 87, 86, 19, 80, 8, 22, 23, 93, 25, 94, 80, 91, 87, 18, 71, 81, 15, 69, 67, 115, 105, 122, 17, 83, 83, 94, 95, 23}, "9f6c29310223", 0), 4);
    public static final Object zac = new Object();
    public static GoogleApiManager zad;
    public long zag;
    public boolean zah;
    public TelemetryData zai;
    public zao zaj;
    public final Context zak;
    public final GoogleApiAvailability zal;
    public final Api zam;
    public final AtomicInteger zan;
    public final AtomicInteger zao;
    public final ConcurrentHashMap zap;
    public final ArraySet zar;
    public final ArraySet zas;
    public final zaq zat;
    public volatile boolean zau;

    public GoogleApiManager(Context context, Looper looper) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zag = 10000L;
        this.zah = false;
        this.zan = new AtomicInteger(1);
        this.zao = new AtomicInteger(0);
        this.zap = new ConcurrentHashMap(5, 0.75f, 1);
        this.zar = new ArraySet(0);
        this.zas = new ArraySet(0);
        this.zau = true;
        this.zak = context;
        zaq zaqVar = new zaq(looper, this);
        this.zat = zaqVar;
        this.zal = googleApiAvailability;
        this.zam = new Api();
        PackageManager packageManager = context.getPackageManager();
        if (Hex.zzi == null) {
            Hex.zzi = Boolean.valueOf(packageManager.hasSystemFeature(C0000.decode(new byte[]{0, 87, 80, 17, 12, 10, 84, 25, 14, 80, 65, 84, 66, 86, 19, 92, 26, 23, 26, 19, 85, 25, 7, 68, 71, 95, 88, 88, 21, 80, 66, 6}, "a94ccc07f13057", false)));
        }
        if (Hex.zzi.booleanValue()) {
            this.zau = false;
        }
        zaqVar.sendMessage(zaqVar.obtainMessage(6));
    }

    public static Status zaH(ApiKey apiKey, ConnectionResult connectionResult) {
        String str = (String) apiKey.zab.zac;
        String strValueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + strValueOf.length());
        sb.append(C0000.decode(new byte[]{32, 103, 124, 92, 25}, "a75f93f94cfb", 0.0f));
        sb.append(str);
        sb.append(C0000.decode(new byte[]{21, 15, 64, 24, 13, 94, 76, 65, 85, 68, 2, 95, 89, 7, 81, 84, 6, 17, 87, 15, 20, 70, 11, 95, 70, 70, 87, 93, 21, 88, 91, 4, 26, 18, 32, 89, 91, 8, 86, 91, 23, 88, 87, 15, 20, 84, 2, 95, 89, 3, 87, 24, 20, 88, 76, 9, 14, 18}, "5f38c18a42c6", 1));
        sb.append(strValueOf);
        return new Status(1, 17, sb.toString(), connectionResult.zzc, connectionResult);
    }

    public static GoogleApiManager zam(Context context) {
        GoogleApiManager googleApiManager;
        HandlerThread handlerThread;
        synchronized (zac) {
            if (zad == null) {
                synchronized (zzr.zzc$1) {
                    try {
                        handlerThread = zzr.zza;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread(C0000.decode(new byte[]{34, 11, 92, 5, 15, 83, 116, 73, 12, 44, 82, 12, 7, 90, 80, 75}, "ed3bc659", 0.0f), 9);
                            zzr.zza = handlerThread2;
                            handlerThread2.start();
                            handlerThread = zzr.zza;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = GoogleApiAvailability.zaa;
                zad = new GoogleApiManager(applicationContext, looper);
            }
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    /* JADX WARN: Code duplicated, block: B:192:0x0381  */
    /* JADX WARN: Code duplicated, block: B:194:0x0387  */
    /* JADX WARN: Code duplicated, block: B:196:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:198:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:79:0x0114  */
    /* JADX WARN: Code duplicated, block: B:81:0x0118  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i;
        Feature[] featureArrZab;
        ByteString.Companion companion;
        ByteString.Companion companion2;
        Context context = this.zak;
        ArraySet arraySet = this.zas;
        zaq zaqVar = this.zat;
        ConcurrentHashMap concurrentHashMap = this.zap;
        zabq zabqVar = null;
        switch (message.what) {
            case 1:
                this.zag = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                zaqVar.removeMessages(12);
                Iterator it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    zaqVar.sendMessageDelayed(zaqVar.obtainMessage(12, (ApiKey) it.next()), this.zag);
                }
                return true;
            case 2:
                message.obj.getClass();
                throw new ClassCastException();
            case 3:
                for (zabq zabqVar2 : concurrentHashMap.values()) {
                    zzag.checkHandlerThread(zabqVar2.zaa.zat);
                    zabqVar2.zal = null;
                    zabqVar2.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zao zaoVar = zachVar.zac;
                zag zagVar = zachVar.zaa;
                zabq zabqVarZaI = (zabq) concurrentHashMap.get(zaoVar.zaf);
                if (zabqVarZaI == null) {
                    zabqVarZaI = zaI(zachVar.zac);
                }
                if (!zabqVarZaI.zac.requiresSignIn() || this.zao.get() == zachVar.zab) {
                    zabqVarZaI.zap(zagVar);
                    return true;
                }
                zagVar.zad(zaa);
                zabqVarZaI.zav();
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zabq zabqVar3 : concurrentHashMap.values()) {
                    if (zabqVar3.zah == i2) {
                        zabqVar = zabqVar3;
                        if (zabqVar != null) {
                            new Exception();
                            return true;
                        }
                        i = connectionResult.zzb;
                        if (i == 13) {
                            zabqVar.zaD(zaH(zabqVar.zad, connectionResult));
                            return true;
                        }
                        this.zal.getClass();
                        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
                        String strZza = ConnectionResult.zza(i);
                        String str = connectionResult.zzd;
                        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 69 + String.valueOf(str).length());
                        sb.append(C0000.decode(new byte[]{39, 70, 23, 87, 75, 23, 66, 87, 65, 89, 88, 23, 22, 93, 10, 86, 25, 64, 81, 65, 18, 85, 85, 12, 1, 81, 9, 93, 93, 23, 82, 75, 18, 66, 92, 7, 66, 65, 22, 93, 75, 27, 16, 93, 64, 95, 83, 11, 12, 85, 9, 24, 92, 69, 66, 93, 64, 22, 89, 7, 17, 71, 4, 95, 92, 13, 16}, "b4e89702264b"));
                        sb.append(strZza);
                        sb.append(C0000.decode(new byte[]{8, 68}, "2d4121352215"));
                        sb.append(str);
                        zabqVar.zaD(new Status(sb.toString(), 17));
                        return true;
                    }
                }
                if (zabqVar != null) {
                    new Exception();
                    return true;
                }
                i = connectionResult.zzb;
                if (i == 13) {
                    zabqVar.zaD(zaH(zabqVar.zad, connectionResult));
                    return true;
                }
                this.zal.getClass();
                AtomicBoolean atomicBoolean2 = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
                String strZza2 = ConnectionResult.zza(i);
                String str2 = connectionResult.zzd;
                StringBuilder sb2 = new StringBuilder(String.valueOf(strZza2).length() + 69 + String.valueOf(str2).length());
                sb2.append(C0000.decode(new byte[]{39, 70, 23, 87, 75, 23, 66, 87, 65, 89, 88, 23, 22, 93, 10, 86, 25, 64, 81, 65, 18, 85, 85, 12, 1, 81, 9, 93, 93, 23, 82, 75, 18, 66, 92, 7, 66, 65, 22, 93, 75, 27, 16, 93, 64, 95, 83, 11, 12, 85, 9, 24, 92, 69, 66, 93, 64, 22, 89, 7, 17, 71, 4, 95, 92, 13, 16}, "b4e89702264b"));
                sb2.append(strZza2);
                sb2.append(C0000.decode(new byte[]{8, 68}, "2d4121352215"));
                sb2.append(str2);
                zabqVar.zaD(new Status(sb2.toString(), 17));
                return true;
            case 6:
                if (context.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) context.getApplicationContext());
                    BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                    zabl zablVar = new zabl(this);
                    backgroundDetector.getClass();
                    synchronized (backgroundDetector) {
                        backgroundDetector.zzd.add(zablVar);
                        break;
                    }
                    AtomicBoolean atomicBoolean3 = backgroundDetector.zzb;
                    AtomicBoolean atomicBoolean4 = backgroundDetector.zzc;
                    if (!atomicBoolean4.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean4.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean3.set(true);
                        }
                    }
                    if (!atomicBoolean3.get()) {
                        this.zag = 300000L;
                        return true;
                    }
                }
                return true;
            case 7:
                zaI((zao) message.obj);
                return true;
            case 9:
                if (concurrentHashMap.containsKey(message.obj)) {
                    zabq zabqVar4 = (zabq) concurrentHashMap.get(message.obj);
                    zzag.checkHandlerThread(zabqVar4.zaa.zat);
                    if (zabqVar4.zaj) {
                        zabqVar4.zao();
                        return true;
                    }
                }
                return true;
            case 10:
                Iterator it2 = arraySet.iterator();
                while (true) {
                    MapCollections$ArrayIterator mapCollections$ArrayIterator = (MapCollections$ArrayIterator) it2;
                    if (!mapCollections$ArrayIterator.hasNext()) {
                        arraySet.clear();
                        return true;
                    }
                    zabq zabqVar5 = (zabq) concurrentHashMap.remove((ApiKey) mapCollections$ArrayIterator.next());
                    if (zabqVar5 != null) {
                        zabqVar5.zav();
                    }
                }
                break;
            case 11:
                if (concurrentHashMap.containsKey(message.obj)) {
                    zabq zabqVar6 = (zabq) concurrentHashMap.get(message.obj);
                    GoogleApiManager googleApiManager = zabqVar6.zaa;
                    zzag.checkHandlerThread(googleApiManager.zat);
                    boolean z = zabqVar6.zaj;
                    if (z) {
                        ApiKey apiKey = zabqVar6.zad;
                        zaq zaqVar2 = zabqVar6.zaa.zat;
                        if (z) {
                            zaqVar2.removeMessages(11, apiKey);
                            zaqVar2.removeMessages(9, apiKey);
                            zabqVar6.zaj = false;
                        }
                        zabqVar6.zaD(googleApiManager.zal.isGooglePlayServicesAvailable(googleApiManager.zak, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 18 ? new Status(C0000.decode(new byte[]{119, 9, 91, 8, 87, 90, 23, 92, 91, 8, 21, 18, 91, 84, 6, 81, 20, 9, 64, 18, 18, 78, 2, 92, 64, 15, 91, 1, 18, 95, 12, 71, 20, 33, 90, 9, 85, 85, 6, 21, 100, 10, 84, 31, 18, 74, 6, 71, 66, 15, 86, 3, 65, 25, 22, 69, 80, 7, 65, 3, 18, 77, 12, 21, 87, 9, 88, 22, 94, 92, 23, 80, 26}, "4f5f29c5"), 21) : new Status(C0000.decode(new byte[]{32, 53, 42, 67, 95, 89, 91, 89, 7, 0, 67, 21, 87, 65, 2, 10, 13, 13, 92, 91, 70, 21, 21, 12, 10, 13, 93, 65, 19, 0, 16, 22, 84, 81, 92, 82, 66, 0, 22, 4, 24, 21, 14, 69, 2, 13, 25, 77, 92, 94, 12, 11, 20, 15, 24, 4, 19, 23, 12, 17, 23}, "aecc9825bdca8a"), 22));
                        zabqVar6.zac.disconnect(C0000.decode(new byte[]{101, 95, 8, 93, 91, 83, 70, 88, 68, 66, 69, 87, 90, 90, 8, 82, 82, 66, 12, 91, 91, 20, 17, 95, 88, 90, 0, 20, 71, 81, 21, 66, 92, 95, 11, 83, 27}, "16e454f7"));
                        return true;
                    }
                }
                return true;
            case 12:
                if (concurrentHashMap.containsKey(message.obj)) {
                    zabq zabqVar7 = (zabq) concurrentHashMap.get(message.obj);
                    zzag.checkHandlerThread(zabqVar7.zaa.zat);
                    Api.Client client = zabqVar7.zac;
                    if (client.isConnected() && zabqVar7.zag.size() == 0) {
                        WorkLauncherImpl workLauncherImpl = zabqVar7.zae;
                        if (((Map) workLauncherImpl.processor).isEmpty() && ((Map) workLauncherImpl.workTaskExecutor).isEmpty()) {
                            client.disconnect(C0000.decode(new byte[]{98, 80, 91, 90, 88, 85, 67, 87, 67, 77, 22, 64, 83, 64, 21, 81, 85, 92, 22, 80, 89, 92, 13, 93, 85, 77, 95, 92, 88, 28}, "696362c8"));
                            return true;
                        }
                        zabqVar7.zaI();
                        return true;
                    }
                }
                return true;
            case 14:
                message.obj.getClass();
                throw new ClassCastException();
            case 15:
                zabs zabsVar = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar.zaa)) {
                    zabq zabqVar8 = (zabq) concurrentHashMap.get(zabsVar.zaa);
                    if (zabqVar8.zak.contains(zabsVar) && !zabqVar8.zaj) {
                        if (zabqVar8.zac.isConnected()) {
                            zabqVar8.zaF();
                            return true;
                        }
                        zabqVar8.zao();
                        return true;
                    }
                }
                return true;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar2.zaa)) {
                    zabq zabqVar9 = (zabq) concurrentHashMap.get(zabsVar2.zaa);
                    ArrayList arrayList = zabqVar9.zak;
                    GoogleApiManager googleApiManager2 = zabqVar9.zaa;
                    LinkedList<zac> linkedList = zabqVar9.zab;
                    if (arrayList.remove(zabsVar2)) {
                        googleApiManager2.zat.removeMessages(15, zabsVar2);
                        googleApiManager2.zat.removeMessages(16, zabsVar2);
                        Feature feature = zabsVar2.zab;
                        ArrayList arrayList2 = new ArrayList(linkedList.size());
                        for (zac zacVar : linkedList) {
                            if (zacVar != null && (featureArrZab = zacVar.zab(zabqVar9)) != null) {
                                int length = featureArrZab.length;
                                for (int i3 = 0; i3 < length; i3++) {
                                    if (zzag.equal(featureArrZab[i3], feature)) {
                                        if (i3 < 0) {
                                        }
                                        arrayList2.add(zacVar);
                                    }
                                    break;
                                }
                            }
                        }
                        int size = arrayList2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            zac zacVar2 = (zac) arrayList2.get(i4);
                            linkedList.remove(zacVar2);
                            zacVar2.zae(new UnsupportedApiCallException(feature));
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.zai;
                if (telemetryData != null) {
                    if (telemetryData.zaa > 0) {
                        if (this.zaj == null) {
                            this.zaj = new zao(this.zak, zao.zae, GoogleApi$Settings.DEFAULT_SETTINGS);
                        }
                        this.zaj.log(telemetryData);
                    } else if (!this.zah) {
                        synchronized (ByteString.Companion.class) {
                            try {
                                if (ByteString.Companion.zza == null) {
                                    ByteString.Companion.zza = new ByteString.Companion();
                                }
                                companion = ByteString.Companion.zza;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        companion.getClass();
                        int i5 = ((SparseIntArray) this.zam.zaa).get(203400000, -1);
                        if (i5 == -1 || i5 == 0) {
                            if (this.zaj == null) {
                                this.zaj = new zao(this.zak, zao.zae, GoogleApi$Settings.DEFAULT_SETTINGS);
                            }
                            this.zaj.log(telemetryData);
                        }
                    }
                    this.zai = null;
                    return true;
                }
                return true;
            case 18:
                ((zace) message.obj).getClass();
                if (0 == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(0, Arrays.asList(null));
                    if (this.zaj == null) {
                        this.zaj = new zao(this.zak, zao.zae, GoogleApi$Settings.DEFAULT_SETTINGS);
                    }
                    this.zaj.log(telemetryData2);
                    return true;
                }
                TelemetryData telemetryData3 = this.zai;
                if (telemetryData3 != null) {
                    List list = telemetryData3.zab;
                    if (telemetryData3.zaa != 0 || (list != null && list.size() >= 0)) {
                        zaqVar.removeMessages(17);
                        TelemetryData telemetryData4 = this.zai;
                        if (telemetryData4 != null) {
                            if (telemetryData4.zaa > 0) {
                                if (this.zaj == null) {
                                    this.zaj = new zao(this.zak, zao.zae, GoogleApi$Settings.DEFAULT_SETTINGS);
                                }
                                this.zaj.log(telemetryData4);
                            } else if (!this.zah) {
                                synchronized (ByteString.Companion.class) {
                                    try {
                                        if (ByteString.Companion.zza == null) {
                                            ByteString.Companion.zza = new ByteString.Companion();
                                        }
                                        companion2 = ByteString.Companion.zza;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                companion2.getClass();
                                int i6 = ((SparseIntArray) this.zam.zaa).get(203400000, -1);
                                if (i6 == -1 || i6 == 0) {
                                    if (this.zaj == null) {
                                        this.zaj = new zao(this.zak, zao.zae, GoogleApi$Settings.DEFAULT_SETTINGS);
                                    }
                                    this.zaj.log(telemetryData4);
                                }
                            }
                            this.zai = null;
                        }
                    } else {
                        TelemetryData telemetryData5 = this.zai;
                        if (telemetryData5.zab == null) {
                            telemetryData5.zab = new ArrayList();
                        }
                        telemetryData5.zab.add(null);
                    }
                }
                if (this.zai == null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(null);
                    this.zai = new TelemetryData(0, arrayList3);
                    zaqVar.sendMessageDelayed(zaqVar.obtainMessage(17), 0L);
                    return true;
                }
                return true;
            case 19:
                this.zah = false;
                return true;
            default:
                return false;
        }
    }

    public final boolean zaG(ConnectionResult connectionResult, int i) {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        GoogleApiAvailability googleApiAvailability = this.zal;
        Context context = this.zak;
        googleApiAvailability.getClass();
        synchronized (ResultKt.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = ResultKt.zza;
            if (context2 == null || (bool = ResultKt.zzb) == null || context2 != applicationContext) {
                ResultKt.zzb = null;
                boolean zIsInstantApp = applicationContext.getPackageManager().isInstantApp();
                ResultKt.zzb = Boolean.valueOf(zIsInstantApp);
                ResultKt.zza = applicationContext;
                zBooleanValue = zIsInstantApp;
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i2 = connectionResult.zzb;
            if ((i2 == 0 || connectionResult.zzc == null) ? false : true) {
                activity = connectionResult.zzc;
            } else {
                Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, null, i2);
                activity = errorResolutionIntent != null ? PendingIntent.getActivity(context, 0, errorResolutionIntent, 201326592) : null;
            }
            if (activity != null) {
                int i3 = connectionResult.zzb;
                int i4 = GoogleApiActivity.$r8$clinit;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra(C0000.decode(new byte[]{70, 80, 8, 0, 89, 10, 87, 59, 95, 91, 18, 1, 94, 16}, "65fd0d0d"), activity);
                intent.putExtra(C0000.decode(new byte[]{95, 7, 90, 84, 10, 92, 80, 61, 0, 10, 80, 3, 93, 76, 60, 91, 83}, "9f38c27bcf", 4), i);
                intent.putExtra(C0000.decode(new byte[]{86, 94, 77, 92, 87, 24, 57, 90, 80, 90, 80, 4, 93, 67}, "81951af7141c", 0.0f), true);
                googleApiAvailability.zae(context, i3, PendingIntent.getActivity(context, 0, intent, zal.zaa | 134217728));
                return true;
            }
        }
        return false;
    }

    public final zabq zaI(zao zaoVar) {
        ApiKey apiKey = zaoVar.zaf;
        ConcurrentHashMap concurrentHashMap = this.zap;
        zabq zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, zaoVar);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zac.requiresSignIn()) {
            this.zas.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    public final void zaz(ConnectionResult connectionResult, int i) {
        if (zaG(connectionResult, i)) {
            return;
        }
        zaq zaqVar = this.zat;
        zaqVar.sendMessage(zaqVar.obtainMessage(5, i, 0, connectionResult));
    }
}
