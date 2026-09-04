package com.google.firebase.messaging;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.collection.ArrayMap;
import androidx.room.InvalidationTracker;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FirebaseMessaging {
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public static Store store;
    public static ScheduledThreadPoolExecutor syncExecutor;
    public static TransportFactory transportFactory;
    public final InvalidationTracker.ObservedTableTracker autoInit;
    public final Context context;
    public final ThreadPoolExecutor fileExecutor;
    public final FirebaseApp firebaseApp;
    public final Request gmsRpc;
    public final ScheduledThreadPoolExecutor initExecutor;
    public final Metadata metadata;
    public final RequestDeduplicator requestDeduplicator;
    public boolean syncScheduledOrRunning;

    public FirebaseMessaging(FirebaseApp firebaseApp, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber) {
        firebaseApp.checkNotDeleted();
        Context context = firebaseApp.applicationContext;
        final Metadata metadata = new Metadata(context);
        final Request request = new Request(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory(C0000.decode(new byte[]{126, 92, 75, 86, 80, 87, 21, 80, 31, 46, 3, 17, 17, 80, 3, 90, 86, 82, 20, 103, 83, 69, 13}, "859326f52cfbb1d3")));
        final int i = 1;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(C0000.decode(new byte[]{119, 15, 66, 93, 90, 5, 21, 7, 27, 41, 82, 67, 66, 7, 87, 81, 86, 3, 75, 43, 88, 13, 67}, "1f088dfb6d70", 3)));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(C0000.decode(new byte[]{35, 11, 22, 87, 85, 84, 68, 6, 78, 123, 87, 17, 18, 88, 2, 11, 10, 85, 26, 115, 94, 15, 6, 27, 123, 13}, "ebd2757cc62ba9", 0.0f)));
        final int i2 = 0;
        this.syncScheduledOrRunning = false;
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp;
        this.autoInit = new InvalidationTracker.ObservedTableTracker(this, subscriber);
        firebaseApp.checkNotDeleted();
        final Context context2 = firebaseApp.applicationContext;
        this.context = context2;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.metadata = metadata;
        this.gmsRpc = request;
        this.requestDeduplicator = new RequestDeduplicator(executorServiceNewSingleThreadExecutor);
        this.initExecutor = scheduledThreadPoolExecutor;
        this.fileExecutor = threadPoolExecutor;
        firebaseApp.checkNotDeleted();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Objects.toString(context);
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda0
            public final /* synthetic */ FirebaseMessaging f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final boolean z;
                ApplicationInfo applicationInfo;
                Bundle bundle;
                switch (i2) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f$0;
                        if (firebaseMessaging.autoInit.isEnabled() && firebaseMessaging.tokenNeedsRefresh(firebaseMessaging.getTokenWithoutTriggeringSync())) {
                            synchronized (firebaseMessaging) {
                                if (!firebaseMessaging.syncScheduledOrRunning) {
                                    firebaseMessaging.syncWithDelaySecondsInternal(0L);
                                }
                                break;
                            }
                            return;
                        }
                        return;
                    default:
                        final Context context3 = this.f$0.context;
                        Context applicationContext = context3.getApplicationContext();
                        if (applicationContext == null) {
                            applicationContext = context3;
                        }
                        if (applicationContext.getSharedPreferences(C0000.decode(new byte[]{91, 93, 9, 30, 5, 12, 87, 84, 91, 3, 25, 2, 90, 20, 7, 82, 89, 65, 1, 30, 15, 6, 75, 64, 86, 1, 94, 10, 84}, "82d0bc837f7d3fb0", 0.0f), 0).getBoolean(C0000.decode(new byte[]{65, 69, 91, 79, 28, 60, 95, 88, 64, 94, 3, 10, 82, 86, 64, 94, 10, 13, 110, 94, 90, 94, 17, 10, 80, 91, 93, 77, 0, 7}, "1747ec"), false)) {
                            return;
                        }
                        String strDecode = C0000.decode(new byte[]{94, 92, 16, 92, 87, 4, 71, 80, 107, 88, 85, 68, 21, 81, 5, 88, 86, 82, 61, 87, 90, 17, 93, 83, 93, 86, 81, 67, 15, 95, 12, 110, 92, 80, 14, 92, 82, 4, 64, 92, 91, 91, 111, 82, 8, 81, 0, 93, 93, 81}, "85b95e454507f0b1", true);
                        try {
                            Context applicationContext2 = context3.getApplicationContext();
                            PackageManager packageManager = applicationContext2.getPackageManager();
                            z = (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(applicationContext2.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(strDecode)) ? applicationInfo.metaData.getBoolean(strDecode) : true;
                            break;
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if (Build.VERSION.SDK_INT < 29) {
                            ExceptionsKt.forResult(null);
                            return;
                        } else {
                            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                            new Runnable() { // from class: com.google.firebase.messaging.ProxyNotificationInitializer$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Context context4 = context3;
                                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                                    String strDecode2 = C0000.decode(new byte[]{2, 14, 95, 77, 95, 93, 93, 3, 13, 4, 28, 2, 86, 86, 64, 11, 8, 5, 28, 4, 85, 65}, "aa2c822d", true);
                                    try {
                                        if (Binder.getCallingUid() != context4.getApplicationInfo().uid) {
                                            context4.getPackageName();
                                            return;
                                        }
                                        Context applicationContext3 = context4.getApplicationContext();
                                        if (applicationContext3 == null) {
                                            applicationContext3 = context4;
                                        }
                                        SharedPreferences.Editor editorEdit = applicationContext3.getSharedPreferences(C0000.decode(new byte[]{80, 88, 14, 31, 80, 87, 95, 6, 91, 83, 29, 81, 10, 67, 82, 90, 81, 18, 82, 24, 94, 82, 16, 66, 86, 95, 89, 15, 80}, "37c1780a76", false), 0).edit();
                                        editorEdit.putBoolean(C0000.decode(new byte[]{73, 22, 13, 26, 31, 103, 87, 11, 22, 11, 0, 81, 90, 5, 22, 11, 9, 86, 102, 13, 12, 11, 18, 81, 88, 8, 11, 24, 3, 92}, "9dbbf8"), true);
                                        editorEdit.apply();
                                        NotificationManager notificationManager = (NotificationManager) context4.getSystemService(NotificationManager.class);
                                        if (z) {
                                            notificationManager.setNotificationDelegate(C0000.decode(new byte[]{91, 9, 12, 74, 83, 91, 12, 82, 91, 92, 24, 80, 88, 87, 74, 9, 8, 0, 26, 83, 14, 70}, "8fad44c5796163", 0.0f));
                                        } else if (strDecode2.equals(notificationManager.getNotificationDelegate())) {
                                            notificationManager.setNotificationDelegate(null);
                                        }
                                    } finally {
                                        taskCompletionSource2.trySetResult(null);
                                    }
                                }
                            }.run();
                            return;
                        }
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(C0000.decode(new byte[]{114, 13, 17, 80, 85, 81, 74, 4, 20, 125, 4, 74, 21, 88, 83, 13, 13, 82, 26, 100, 86, 17, 80, 83, 18, 20, 47, 86}, "4dc5709a90a9f9", 2)));
        int i3 = TopicsSubscriber.$r8$clinit;
        ExceptionsKt.call(scheduledThreadPoolExecutor2, new Callable() { // from class: com.google.firebase.messaging.TopicsSubscriber$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsStore topicsStore;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                Metadata metadata2 = metadata;
                Request request2 = request;
                synchronized (TopicsStore.class) {
                    try {
                        WeakReference weakReference = TopicsStore.topicsStoreWeakReference;
                        topicsStore = weakReference != null ? (TopicsStore) weakReference.get() : null;
                        if (topicsStore == null) {
                            SharedPreferences sharedPreferences = context3.getSharedPreferences(C0000.decode(new byte[]{85, 87, 90, 30, 85, 14, 95, 81, 9, 83, 23, 88, 88, 92, 69, 95, 91, 5, 30, 81, 8, 69, 23, 88, 70, 72, 94, 84}, "68702a06e699", 1), 0);
                            TopicsStore topicsStore2 = new TopicsStore();
                            synchronized (topicsStore2) {
                                topicsStore2.topicOperationsQueue = Request.Builder.createInstance(sharedPreferences, scheduledThreadPoolExecutor3);
                            }
                            TopicsStore.topicsStoreWeakReference = new WeakReference(topicsStore2);
                            topicsStore = topicsStore2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new TopicsSubscriber(firebaseMessaging, metadata2, topicsStore, request2, context3, scheduledThreadPoolExecutor3);
            }
        }).addOnSuccessListener(scheduledThreadPoolExecutor, new CctTransportBackend$$ExternalSyntheticLambda0(10, this));
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda0
            public final /* synthetic */ FirebaseMessaging f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final boolean z;
                ApplicationInfo applicationInfo;
                Bundle bundle;
                switch (i) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f$0;
                        if (firebaseMessaging.autoInit.isEnabled() && firebaseMessaging.tokenNeedsRefresh(firebaseMessaging.getTokenWithoutTriggeringSync())) {
                            synchronized (firebaseMessaging) {
                                if (!firebaseMessaging.syncScheduledOrRunning) {
                                    firebaseMessaging.syncWithDelaySecondsInternal(0L);
                                }
                                break;
                            }
                            return;
                        }
                        return;
                    default:
                        final Context context3 = this.f$0.context;
                        Context applicationContext = context3.getApplicationContext();
                        if (applicationContext == null) {
                            applicationContext = context3;
                        }
                        if (applicationContext.getSharedPreferences(C0000.decode(new byte[]{91, 93, 9, 30, 5, 12, 87, 84, 91, 3, 25, 2, 90, 20, 7, 82, 89, 65, 1, 30, 15, 6, 75, 64, 86, 1, 94, 10, 84}, "82d0bc837f7d3fb0", 0.0f), 0).getBoolean(C0000.decode(new byte[]{65, 69, 91, 79, 28, 60, 95, 88, 64, 94, 3, 10, 82, 86, 64, 94, 10, 13, 110, 94, 90, 94, 17, 10, 80, 91, 93, 77, 0, 7}, "1747ec"), false)) {
                            return;
                        }
                        String strDecode = C0000.decode(new byte[]{94, 92, 16, 92, 87, 4, 71, 80, 107, 88, 85, 68, 21, 81, 5, 88, 86, 82, 61, 87, 90, 17, 93, 83, 93, 86, 81, 67, 15, 95, 12, 110, 92, 80, 14, 92, 82, 4, 64, 92, 91, 91, 111, 82, 8, 81, 0, 93, 93, 81}, "85b95e454507f0b1", true);
                        try {
                            Context applicationContext2 = context3.getApplicationContext();
                            PackageManager packageManager = applicationContext2.getPackageManager();
                            z = (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(applicationContext2.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(strDecode)) ? applicationInfo.metaData.getBoolean(strDecode) : true;
                            break;
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if (Build.VERSION.SDK_INT < 29) {
                            ExceptionsKt.forResult(null);
                            return;
                        } else {
                            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                            new Runnable() { // from class: com.google.firebase.messaging.ProxyNotificationInitializer$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Context context4 = context3;
                                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                                    String strDecode2 = C0000.decode(new byte[]{2, 14, 95, 77, 95, 93, 93, 3, 13, 4, 28, 2, 86, 86, 64, 11, 8, 5, 28, 4, 85, 65}, "aa2c822d", true);
                                    try {
                                        if (Binder.getCallingUid() != context4.getApplicationInfo().uid) {
                                            context4.getPackageName();
                                            return;
                                        }
                                        Context applicationContext3 = context4.getApplicationContext();
                                        if (applicationContext3 == null) {
                                            applicationContext3 = context4;
                                        }
                                        SharedPreferences.Editor editorEdit = applicationContext3.getSharedPreferences(C0000.decode(new byte[]{80, 88, 14, 31, 80, 87, 95, 6, 91, 83, 29, 81, 10, 67, 82, 90, 81, 18, 82, 24, 94, 82, 16, 66, 86, 95, 89, 15, 80}, "37c1780a76", false), 0).edit();
                                        editorEdit.putBoolean(C0000.decode(new byte[]{73, 22, 13, 26, 31, 103, 87, 11, 22, 11, 0, 81, 90, 5, 22, 11, 9, 86, 102, 13, 12, 11, 18, 81, 88, 8, 11, 24, 3, 92}, "9dbbf8"), true);
                                        editorEdit.apply();
                                        NotificationManager notificationManager = (NotificationManager) context4.getSystemService(NotificationManager.class);
                                        if (z) {
                                            notificationManager.setNotificationDelegate(C0000.decode(new byte[]{91, 9, 12, 74, 83, 91, 12, 82, 91, 92, 24, 80, 88, 87, 74, 9, 8, 0, 26, 83, 14, 70}, "8fad44c5796163", 0.0f));
                                        } else if (strDecode2.equals(notificationManager.getNotificationDelegate())) {
                                            notificationManager.setNotificationDelegate(null);
                                        }
                                    } finally {
                                        taskCompletionSource2.trySetResult(null);
                                    }
                                }
                            }.run();
                            return;
                        }
                }
            }
        });
    }

    public static void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (syncExecutor == null) {
                    syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(C0000.decode(new byte[]{97, 32, 112}, "5a7b0f")));
                }
                syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        firebaseApp.checkNotDeleted();
        firebaseMessaging = (FirebaseMessaging) firebaseApp.componentRuntime.get(FirebaseMessaging.class);
        zzag.checkNotNull(firebaseMessaging, C0000.decode(new byte[]{115, 80, 20, 92, 4, 5, 70, 92, 70, 116, 3, 23, 70, 88, 1, 80, 8, 3, 21, 90, 9, 84, 22, 11, 91, 92, 8, 77, 70, 13, 70, 25, 8, 86, 18, 68, 69, 75, 3, 74, 3, 10, 65}, "59f9fd", 0.0f));
        return firebaseMessaging;
    }

    public static synchronized Store getStore(Context context) {
        try {
            if (store == null) {
                store = new Store(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return store;
    }

    public final String blockingGetToken() throws IOException {
        Task taskContinueWithTask;
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return tokenWithoutTriggeringSync.token;
        }
        String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        RequestDeduplicator requestDeduplicator = this.requestDeduplicator;
        synchronized (requestDeduplicator) {
            taskContinueWithTask = (Task) ((ArrayMap) requestDeduplicator.getTokenRequests).get(defaultSenderId);
            if (taskContinueWithTask == null) {
                Request request = this.gmsRpc;
                taskContinueWithTask = request.extractResponseWhenComplete(request.startRpc(Metadata.getDefaultSenderId((FirebaseApp) request.url), C0000.decode(new byte[]{26}, "0f4b2ec5843187", false), new Bundle())).onSuccessTask(this.fileExecutor, new FirebaseMessaging$$ExternalSyntheticLambda4(this, defaultSenderId, tokenWithoutTriggeringSync, 0)).continueWithTask((Executor) requestDeduplicator.executor, new ComponentMonitor$$ExternalSyntheticLambda0(requestDeduplicator, defaultSenderId));
                ((ArrayMap) requestDeduplicator.getTokenRequests).put(defaultSenderId, taskContinueWithTask);
            }
        }
        try {
            return (String) ExceptionsKt.await(taskContinueWithTask);
        } catch (InterruptedException | ExecutionException e) {
            throw new IOException(e);
        }
    }

    public final Store.Token getTokenWithoutTriggeringSync() {
        Store.Token token;
        Store store2 = getStore(this.context);
        String strDecode = C0000.decode(new byte[]{63, 125, 115, 112, 112, 52, 41, 55, 110}, "d9661aec37", 0.0f);
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        String persistenceKey = strDecode.equals(firebaseApp.name) ? "" : firebaseApp.getPersistenceKey();
        String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        synchronized (store2) {
            token = Store.Token.parse(store2.store.getString(persistenceKey + C0000.decode(new byte[]{25, 109, 79}, "e934b0", true) + defaultSenderId + C0000.decode(new byte[]{30, 24}, "b26cd6c5", 5), null));
        }
        return token;
    }

    public final synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, 2 * j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    public final boolean tokenNeedsRefresh(Store.Token token) {
        if (token != null) {
            return System.currentTimeMillis() > token.timestamp + Store.Token.REFRESH_PERIOD_MILLIS || !this.metadata.getAppVersionCode().equals(token.appVersion);
        }
        return true;
    }
}
