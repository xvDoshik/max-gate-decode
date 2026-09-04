package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {
    public static final /* synthetic */ int $r8$clinit = 0;
    static final long MESSAGE_TIMEOUT_S = 20;
    private static final String TAG = C0000.decode(new byte[]{112, 86, 93, 85, 91, 2, 0, 92, 127, 13, 21, 86, 90, 16, 99, 85, 71, 78, 92, 87, 80}, "58545ae86ca34d00", 6);
    private Binder binder;
    final ExecutorService executor;
    private int lastStartId;
    private final Object lock;
    private int runningTasks;

    public EnhancedIntentService() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(C0000.decode(new byte[]{112, 13, 68, 80, 81, 86, 69, 1, 27, 120, 86, 68, 69, 5, 81, 92, 93, 80, 27, 45, 88, 65, 86, 89, 66, 73, 126, 84, 93, 83, 90, 1}, "6d6537", 4)));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.lock = new Object();
        this.runningTasks = 0;
    }

    public static Task access$000(EnhancedIntentService enhancedIntentService, Intent intent) {
        if (enhancedIntentService.handleIntentOnMainThread(intent)) {
            return ExceptionsKt.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        enhancedIntentService.executor.execute(new Processor$$ExternalSyntheticLambda1(enhancedIntentService, intent, taskCompletionSource, 4));
        return taskCompletionSource.zza;
    }

    public final void finishTask(Intent intent) {
        if (intent != null) {
            WakeLockHolder.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            try {
                int i = this.runningTasks - 1;
                this.runningTasks = i;
                if (i == 0) {
                    stopSelfResultHook(this.lastStartId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (this.binder == null) {
                this.binder = new WithinAppServiceBinder(new ConnectionPool(21, this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.binder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzw zzwVarForResult;
        synchronized (this.lock) {
            this.lastStartId = i2;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        if (handleIntentOnMainThread(startCommandIntent)) {
            zzwVarForResult = ExceptionsKt.forResult(null);
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.executor.execute(new Processor$$ExternalSyntheticLambda1(this, startCommandIntent, taskCompletionSource, 4));
            zzwVarForResult = taskCompletionSource.zza;
        }
        if (zzwVarForResult.isComplete()) {
            finishTask(intent);
            return 2;
        }
        zzwVarForResult.addOnCompleteListener(new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ComponentMonitor$$ExternalSyntheticLambda0(this, 4, intent));
        return 3;
    }

    public boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }
}
