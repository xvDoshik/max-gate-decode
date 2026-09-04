package com.base.template;

import android.app.Application;
import android.content.Context;
import androidx.work.JobListenableFuture;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.base.template.services.CommandService;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Store;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AppInit {
    private static final String FCM_API_KEY = C0000.decode(new byte[]{36, 126, 67, 3, 107, 65, 114, 7, 26, 0, 45, 98, 45, 56, 7, 101, 13, 111, 75, 8, 106, 13, 108, 54, 55, 12, 80, 119, 44, 54, 15, 101, 58, 89, 107, 91, 113, 11, 64}, "e79b883ecde6faf6", false);
    private static final String FCM_APP_ID = C0000.decode(new byte[]{82, 3, 87, 85, 5, 3, 83, 1, 86, 11, 2, 9, 3, 13, 7, 90, 7, 75, 12, 11, 87, 11, 81, 85, 5, 15, 3, 91, 13, 81, 5, 0, 87, 92, 84, 86, 0, 4, 85, 81, 7, 14, 86, 11}, "c9cb31c4c80947f4", true);
    private static final String FCM_PROJECT_ID = C0000.decode(new byte[]{87, 19, 21, 29, 73, 16, 16, 88, 31, 67, 93, 23, 64, 10, 6, 85, 20, 6, 2, 9, 0, 0}, "6ce09ec0208e", 0.0f);
    private static final String FCM_SENDER_ID = C0000.decode(new byte[]{85, 7, 15, 10, 4, 84, 0, 81, 83, 0, 14}, "a0984a5b");
    public static final AppInit INSTANCE = new AppInit();

    private AppInit() {
    }

    public static final void init(Application application) {
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                String strDecode = C0000.decode(new byte[]{85, 92, 80, 0, 6, 81, 6, 6, 1, 82, 86, 86, 83, 13, 81, 13, 82, 65, 91, 8, 0, 92, 86, 86, 86, 84, 5, 81, 13, 7, 7, 82, 80, 82, 7, 87, 5, 6, 2, 4, 0, 80, 2, 5}, "dfd70c634a");
                zzag.checkNotEmpty(strDecode, C0000.decode(new byte[]{118, 71, 67, 84, 81, 1, 86, 23, 13, 86, 90, 112, 83, 23, 94, 77, 75, 22, 23, 1, 1, 25, 71, 92, 67, 25}, "77388b7cd949", 7));
                String strDecode2 = C0000.decode(new byte[]{39, 45, 79, 81, 53, 65, 117, 84, 28, 93, 44, 53, 45, 61, 84, 99, 14, 96, 70, 92, 55, 12, 59, 50, 50, 12, 0, 113, 44, 111, 93, 101, 58, 87, 54, 88, 47, 87, 70}, "fd50f846e9da");
                zzag.checkNotEmpty(strDecode2, C0000.decode(new byte[]{121, 68, 94, 42, 92, 74, 70, 85, 66, 21, 70, 70, 85, 85, 22, 68, 93, 64, 25}, "847a93f87f2f7067", true));
                FirebaseApp.initializeApp(application, new FirebaseOptions(strDecode, strDecode2, null, null, C0000.decode(new byte[]{0, 0, 1, 10, 3, 7, 84, 10, 3, 1, 3}, "477832a911", 2), null, C0000.decode(new byte[]{80, 20, 22, 72, 64, 67, 70, 91, 21, 68, 84, 22, 16, 12, 83, 83, 24, 80, 89, 14, 3, 84}, "1dfe065387", true)));
            }
            INSTANCE.requestFcmToken(application);
        } catch (Exception unused) {
        }
        CommandService commandService = CommandService.instance;
        Headers.Companion.safeStartService(application.getApplicationContext(), C0000.decode(new byte[]{35, 98, 100, 62, 122, 125, 42, 50}, "b24a33cfa7310241", 6));
    }

    private final void requestFcmToken(Context context) {
        FirebaseMessaging firebaseMessaging;
        try {
            Store store = FirebaseMessaging.store;
            synchronized (FirebaseMessaging.class) {
                firebaseMessaging = FirebaseMessaging.getInstance(FirebaseApp.getInstance());
            }
            firebaseMessaging.getClass();
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            firebaseMessaging.initExecutor.execute(new Processor$$ExternalSyntheticLambda2(firebaseMessaging, 17, taskCompletionSource));
            zzw zzwVar = taskCompletionSource.zza;
            CctTransportBackend$$ExternalSyntheticLambda0 cctTransportBackend$$ExternalSyntheticLambda0 = new CctTransportBackend$$ExternalSyntheticLambda0(3, new JobListenableFuture.AnonymousClass1(2, context));
            zzwVar.getClass();
            zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, cctTransportBackend$$ExternalSyntheticLambda0);
        } catch (Exception unused) {
        }
    }
}
