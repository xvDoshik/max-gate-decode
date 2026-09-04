package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.collection.ArrayMap;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzw;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.ExceptionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RequestDeduplicator {
    public static WithinAppServiceConnection fcmServiceConn;
    public static final Object lock = new Object();
    public final Object executor;
    public final Object getTokenRequests;

    public RequestDeduplicator(ExecutorService executorService) {
        this.getTokenRequests = new ArrayMap();
        this.executor = executorService;
    }

    public static zzw bindToMessagingService(Context context, Intent intent, boolean z) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            try {
                if (fcmServiceConn == null) {
                    fcmServiceConn = new WithinAppServiceConnection(context);
                }
                withinAppServiceConnection = fcmServiceConn;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            return withinAppServiceConnection.sendIntent(intent).continueWith(new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new TransportImpl$$ExternalSyntheticLambda0(14));
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context)) {
            synchronized (WakeLockHolder.syncObject) {
                try {
                    WakeLockHolder.checkAndInitWakeLock(context);
                    boolean booleanExtra = intent.getBooleanExtra(C0000.decode(new byte[]{83, 11, 11, 27, 94, 90, 88, 1, 92, 1, 72, 83, 80, 71, 82, 4, 81, 23, 3, 27, 80, 92, 83, 72, 103, 5, 13, 80, 117, 90, 84, 13, 120, 11, 10, 81, 92, 71, 25, 17, 81, 15, 3, 83, 76, 89, 94, 8, 68, 1, 8, 65}, "0df5957f", false), false);
                    intent.putExtra(C0000.decode(new byte[]{90, 94, 93, 26, 4, 12, 86, 86, 92, 81, 77, 5, 80, 67, 85, 86, 2, 16, 92, 31, 89, 93, 7, 77, 110, 80, 91, 81, 47, 12, 90, 90, 120, 91, 15, 7, 92, 67, 30, 67, 2, 8, 92, 87, 69, 88, 10, 13, 77, 84, 94, 64}, "9104cc"), true);
                    if (!booleanExtra) {
                        WakeLockHolder.wakeLock.acquire(WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                    }
                    zzw zzwVarSendIntent = withinAppServiceConnection.sendIntent(intent);
                    CctTransportBackend$$ExternalSyntheticLambda0 cctTransportBackend$$ExternalSyntheticLambda0 = new CctTransportBackend$$ExternalSyntheticLambda0(11, intent);
                    zzwVarSendIntent.getClass();
                    zzwVarSendIntent.zzb.zza(new zzh((Executor) TaskExecutors.MAIN_THREAD, (OnCompleteListener) cctTransportBackend$$ExternalSyntheticLambda0));
                    zzwVarSendIntent.zzi();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else {
            withinAppServiceConnection.sendIntent(intent);
        }
        return ExceptionsKt.forResult(-1);
    }

    public zzw process(final Intent intent) {
        String strDecode = C0000.decode(new byte[]{85, 85, 88, 31, 20, 4, 64, 112, 3, 66, 83, 0, 1}, "2651fe74b6", true);
        String stringExtra = intent.getStringExtra(strDecode);
        if (stringExtra != null) {
            intent.putExtra(C0000.decode(new byte[]{17, 2, 64, 119, 3, 77, 7}, "cc73b9fd", 0), Base64.decode(stringExtra, 0));
            intent.removeExtra(strDecode);
        }
        final Context context = (Context) this.executor;
        ArchTaskExecutor$$ExternalSyntheticLambda0 archTaskExecutor$$ExternalSyntheticLambda0 = (ArchTaskExecutor$$ExternalSyntheticLambda0) this.getTokenRequests;
        boolean z = context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z2 = (intent.getFlags() & 268435456) != 0;
        return (!z || z2) ? ExceptionsKt.call(archTaskExecutor$$ExternalSyntheticLambda0, new Callable() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i;
                Context context2 = context;
                Intent intent2 = intent;
                ServiceStarter serviceStarter = ServiceStarter.getInstance();
                ((ArrayDeque) serviceStarter.messagingEvents).offer(intent2);
                Intent intent3 = new Intent(C0000.decode(new byte[]{84, 86, 93, 77, 85, 91, 94, 80, 93, 86, 31, 80, 12, 71, 83, 86, 86, 74, 85, 77, 127, 113, 98, 100, 112, 116, 120, 120, 34, 106, 115, 98, 114, 119, 100}, "790c24171316e564", 5));
                intent3.setPackage(context2.getPackageName());
                synchronized (serviceStarter) {
                    try {
                        str = (String) serviceStarter.firebaseMessagingServiceClassName;
                        if (str == null) {
                            ResolveInfo resolveInfoResolveService = context2.getPackageManager().resolveService(intent3, 0);
                            if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null || !context2.getPackageName().equals(serviceInfo.packageName) || (str2 = serviceInfo.name) == null) {
                                str = null;
                            } else {
                                if (str2.startsWith(C0000.decode(new byte[]{31}, "187537053227", false))) {
                                    serviceStarter.firebaseMessagingServiceClassName = context2.getPackageName() + serviceInfo.name;
                                } else {
                                    serviceStarter.firebaseMessagingServiceClassName = serviceInfo.name;
                                }
                                str = (String) serviceStarter.firebaseMessagingServiceClassName;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (str != null) {
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    i = (serviceStarter.hasWakeLockPermission(context2) ? WakeLockHolder.startWakefulService(context2, intent3) : context2.startService(intent3)) == null ? 404 : -1;
                } catch (IllegalStateException e) {
                    e.toString();
                    i = 402;
                } catch (SecurityException unused) {
                    i = 401;
                }
                return Integer.valueOf(i);
            }
        }).continueWithTask(archTaskExecutor$$ExternalSyntheticLambda0, new Continuation() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ((Integer) task.getResult()).intValue() != 402 ? task : RequestDeduplicator.bindToMessagingService(context, intent, z2).continueWith(new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new TransportImpl$$ExternalSyntheticLambda0(13));
            }
        }) : bindToMessagingService(context, intent, z2);
    }

    public RequestDeduplicator(Context context) {
        this.executor = context;
        this.getTokenRequests = new ArchTaskExecutor$$ExternalSyntheticLambda0(1);
    }
}
