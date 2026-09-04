package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.util.Base64;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$ValuesCollection;
import androidx.core.os.UserManagerCompat$Api24Impl;
import androidx.work.impl.AutoMigration_14_15;
import androidx.work.impl.OperationImpl;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery$$ExternalSyntheticLambda0;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FirebaseApp {
    public final Context applicationContext;
    public final ComponentRuntime componentRuntime;
    public final Lazy dataCollectionConfigStorage;
    public final Provider defaultHeartBeatController;
    public final String name;
    public final FirebaseOptions options;
    public static final Object LOCK = new Object();
    public static final ArrayMap INSTANCES = new ArrayMap();
    public final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    public final AtomicBoolean deleted = new AtomicBoolean();
    public final CopyOnWriteArrayList backgroundStateChangeListeners = new CopyOnWriteArrayList();

    public final class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
        public static final AtomicReference INSTANCE = new AtomicReference();

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public final void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                try {
                    ArrayList arrayList = new ArrayList(FirebaseApp.INSTANCES.values());
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        FirebaseApp firebaseApp = (FirebaseApp) obj;
                        if (firebaseApp.automaticResourceManagementEnabled.get()) {
                            Iterator it = firebaseApp.backgroundStateChangeListeners.iterator();
                            while (it.hasNext()) {
                                FirebaseApp firebaseApp2 = ((FirebaseApp$$ExternalSyntheticLambda1) it.next()).f$0;
                                if (!z) {
                                    ((DefaultHeartBeatController) firebaseApp2.defaultHeartBeatController.get()).registerHeartBeat();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class UserUnlockReceiver extends BroadcastReceiver {
        public static final AtomicReference INSTANCE = new AtomicReference();
        public final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.LOCK) {
                try {
                    Iterator it = ((MapCollections$ValuesCollection) FirebaseApp.INSTANCES.values()).iterator();
                    while (it.hasNext()) {
                        ((FirebaseApp) it.next()).initializeAllApis();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.applicationContext.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        ?? arrayList;
        int i = 0;
        new CopyOnWriteArrayList();
        this.applicationContext = context;
        zzag.checkNotEmpty(str);
        this.name = str;
        this.options = firebaseOptions;
        StartupTime startupTime = FirebaseInitProvider.getStartupTime();
        Trace.beginSection(C0000.decode(new byte[]{127, 8, 70, 80, 7, 80, 74, 4}, "9a45e1", 3));
        Trace.beginSection(C0000.decode(new byte[]{118, 91, 84, 17, 91, 95, 93, 8, 69, 117, 88, 21, 83, 12, 19, 93, 71, 77}, "549a418f111f0ce8", 0.0f));
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Objects.toString(ComponentDiscoveryService.class);
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (bundle == null) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if (C0000.decode(new byte[]{6, 10, 89, 26, 4, 11, 10, 87, 90, 86, 75, 84, 95, 22, 0, 7, 85, 71, 6, 74, 6, 95, 91, 67, 10, 92, 83, 10, 17, 22, 26, 119, 12, 9, 21, 95, 88, 86, 11, 70, 100, 1, 2, 12, 71, 64, 17, 5, 23}, "ee44cde063e26d", false).equals(bundle.get(str2)) && str2.startsWith(C0000.decode(new byte[]{6, 93, 85, 25, 80, 95, 10, 85, 84, 82, 25, 86, 12, 64, 93, 85, 86, 67, 0, 28, 91, 88, 90, 64, 10, 92, 93, 89, 67, 67, 95}, "e28770", false))) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ComponentDiscovery$$ExternalSyntheticLambda0(i, (String) it.next()));
        }
        Trace.endSection();
        Trace.beginSection(C0000.decode(new byte[]{106, 20, 15, 76, 81, 14, 93}, "8aa88c", 2));
        UiExecutor uiExecutor = UiExecutor.INSTANCE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        int i2 = 1;
        arrayList3.add(new ComponentDiscovery$$ExternalSyntheticLambda0(i2, new FirebaseCommonRegistrar()));
        arrayList3.add(new ComponentDiscovery$$ExternalSyntheticLambda0(i2, new ExecutorsRegistrar()));
        arrayList4.add(Component.of(context, Context.class, new Class[0]));
        arrayList4.add(Component.of(this, FirebaseApp.class, new Class[0]));
        arrayList4.add(Component.of(firebaseOptions, FirebaseOptions.class, new Class[0]));
        AutoMigration_14_15 autoMigration_14_15 = new AutoMigration_14_15();
        if (UserManagerCompat$Api24Impl.isUserUnlocked(context) && FirebaseInitProvider.isCurrentlyInitializing()) {
            arrayList4.add(Component.of(startupTime, StartupTime.class, new Class[0]));
        }
        ComponentRuntime componentRuntime = new ComponentRuntime(arrayList3, arrayList4, autoMigration_14_15);
        this.componentRuntime = componentRuntime;
        Trace.endSection();
        this.dataCollectionConfigStorage = new Lazy(new FirebaseApp$$ExternalSyntheticLambda0(this, i, context));
        this.defaultHeartBeatController = componentRuntime.getProvider(DefaultHeartBeatController.class);
        FirebaseApp$$ExternalSyntheticLambda1 firebaseApp$$ExternalSyntheticLambda1 = new FirebaseApp$$ExternalSyntheticLambda1(this);
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.get()) {
            BackgroundDetector.zza.zzb.get();
        }
        this.backgroundStateChangeListeners.add(firebaseApp$$ExternalSyntheticLambda1);
        Trace.endSection();
    }

    public static ArrayList getApps() {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList(INSTANCES.values());
        }
        return arrayList;
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        String strDecode = C0000.decode(new byte[]{37, 81, 4, 86, 69, 8, 21, 20, 36, 94, 66, 1, 3, 85, 17, 82, 113, 20, 17, 20, 11, 68, 16, 10, 14, 64, 66, 94, 94, 13, 21, 93, 3, 91, 89, 30, 4, 80, 66, 94, 94, 68, 21, 92, 11, 68, 16, 20, 19, 91, 1, 82, 67, 23, 65}, "a4b70d", false);
        synchronized (LOCK) {
            try {
                firebaseApp = (FirebaseApp) INSTANCES.get(C0000.decode(new byte[]{109, 125, 118, 126, 115, 101, 122, 109, 110}, "693820", false));
                if (firebaseApp == null) {
                    throw new IllegalStateException(strDecode + Hex.getMyProcessName() + C0000.decode(new byte[]{29, 22, 117, 0, 82, 82, 19, 69, 77, 19, 92, 23, 71, 89, 24, 2, 88, 91, 95, 22, 126, 8, 75, 82, 81, 87, 75, 4, 120, 71, 67, 24, 81, 15, 80, 67, 90, 87, 84, 8, 67, 82, 114, 70, 72, 73, 122, 88, 93, 66, 93, 25, 77, 30, 19, 80, 81, 19, 74, 67, 29}, "368a97"));
                }
                ((DefaultHeartBeatController) firebaseApp.defaultHeartBeatController.get()).registerHeartBeat();
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        FirebaseApp firebaseApp;
        String strDecode = C0000.decode(new byte[]{108, 32, 118, 115, 37, 103, 46, 54, 106}, "7d35d2bb", 1);
        AtomicReference atomicReference = GlobalBackgroundStateListener.INSTANCE;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = GlobalBackgroundStateListener.INSTANCE;
            if (atomicReference2.get() == null) {
                GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                do {
                    if (atomicReference2.compareAndSet(null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                        backgroundDetector.getClass();
                        synchronized (backgroundDetector) {
                            backgroundDetector.zzd.add(globalBackgroundStateListener);
                        }
                        break;
                    }
                } while (atomicReference2.get() == null);
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            ArrayMap arrayMap = INSTANCES;
            boolean zContainsKey = arrayMap.containsKey(strDecode);
            String str = C0000.decode(new byte[]{114, 80, 70, 83, 6, 84, 16, 1, 35, 18, 69, 69, 10, 3, 89, 92, 20}, "4946d5cdbb5edb") + strDecode + C0000.decode(new byte[]{23, 86, 90, 22, 4, 0, 83, 78, 22, 1, 25, 8, 68, 67, 69, 69}, "776daa", 0.0f);
            if (zContainsKey) {
                throw new IllegalStateException(String.valueOf(str));
            }
            zzag.checkNotNull(context, C0000.decode(new byte[]{37, 73, 20, 85, 81, 90, 2, 66, 90, 91, 10, 25, 7, 86, 86, 77, 6, 78, 71, 20, 7, 88, 10, 87, 87, 77, 67, 84, 86, 20, 10, 76, 8, 85, 22}, "d9d989c634", false));
            firebaseApp = new FirebaseApp(context, strDecode, firebaseOptions);
            arrayMap.put(strDecode, firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }

    public final void checkNotDeleted() {
        if (this.deleted.get()) {
            throw new IllegalStateException(C0000.decode(new byte[]{126, 90, 68, 3, 4, 0, 65, 83, 118, 73, 69, 17, 79, 82, 69, 70, 2, 4, 94, 83, 67, 92, 81}, "836ffa267951", true));
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        FirebaseApp firebaseApp = (FirebaseApp) obj;
        firebaseApp.checkNotDeleted();
        return this.name.equals(firebaseApp.name);
    }

    public final String getPersistenceKey() {
        StringBuilder sb = new StringBuilder();
        checkNotDeleted();
        byte[] bytes = this.name.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append(C0000.decode(new byte[]{28}, "759b086f18accc4f", 4));
        checkNotDeleted();
        byte[] bytes2 = this.options.applicationId.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final void initializeAllApis() {
        HashMap map;
        if (!UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext)) {
            checkNotDeleted();
            Context context = this.applicationContext;
            AtomicReference atomicReference = UserUnlockReceiver.INSTANCE;
            if (atomicReference.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                while (!atomicReference.compareAndSet(null, userUnlockReceiver)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(userUnlockReceiver, new IntentFilter(C0000.decode(new byte[]{84, 12, 93, 67, 95, 95, 81, 76, 80, 95, 68, 83, 91, 22, 23, 80, 83, 66, 92, 13, 87, 31, 101, 101, 112, 48, 102, 100, 126, 122, 122, 33, 114, 116, 116}, "5b9106", 4)));
                return;
            }
            return;
        }
        checkNotDeleted();
        ComponentRuntime componentRuntime = this.componentRuntime;
        String strDecode = C0000.decode(new byte[]{61, 113, 125, 37, 39, 54, 121, 55, 59}, "f58cfc5c", 0.0f);
        checkNotDeleted();
        boolean zEquals = strDecode.equals(this.name);
        AtomicReference atomicReference2 = componentRuntime.eagerComponentsInitializedWith;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (!atomicReference2.compareAndSet(null, boolValueOf)) {
            if (atomicReference2.get() != null) {
                ((DefaultHeartBeatController) this.defaultHeartBeatController.get()).registerHeartBeat();
            }
        }
        synchronized (componentRuntime) {
            map = new HashMap(componentRuntime.components);
        }
        componentRuntime.doInitializeEagerComponents(map, zEquals);
        ((DefaultHeartBeatController) this.defaultHeartBeatController.get()).registerHeartBeat();
    }

    public final String toString() {
        OperationImpl operationImpl = new OperationImpl(this);
        operationImpl.add(this.name, C0000.decode(new byte[]{90, 83, 14, 4}, "42ca3662eb6474", true));
        operationImpl.add(this.options, C0000.decode(new byte[]{95, 72, 67, 12, 91, 13, 21}, "087e4cfd8b", 3));
        return operationImpl.toString();
    }
}
