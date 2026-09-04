package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WithinAppServiceConnection implements ServiceConnection {
    public WithinAppServiceBinder binder;
    public boolean connectionInProgress;
    public final Intent connectionIntent;
    public final Context context;
    public final ArrayDeque intentQueue;
    public final ScheduledThreadPoolExecutor scheduledExecutorService;

    public final class BindRequest {
        public final Intent intent;
        public final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();

        public BindRequest(Intent intent) {
            this.intent = intent;
        }
    }

    public WithinAppServiceConnection(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new NamedThreadFactory(C0000.decode(new byte[]{32, 12, 68, 87, 84, 4, 21, 0, 27, 116, 95, 23, 3, 7, 87, 65, 83, 44, 8, 22, 66, 83, 88, 6, 3, 44, 82, 97, 83, 23, 16, 12, 85, 87, 117, 10, 8, 11, 83, 81, 66, 12, 9, 11}, "fe626e")));
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(C0000.decode(new byte[]{6, 94, 88, 77, 3, 90, 92, 86, 9, 84, 27, 5, 13, 71, 86, 83, 4, 66, 80, 77, 41, 112, 96, 98, 36, 118, 124, 45, 35, 106, 118, 103, 32, 127, 97}, "e15cd531", 0)).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledThreadPoolExecutor;
    }

    public final synchronized void flushQueue() throws Throwable {
        WithinAppServiceConnection withinAppServiceConnection;
        while (!this.intentQueue.isEmpty()) {
            try {
                try {
                    WithinAppServiceBinder withinAppServiceBinder = this.binder;
                    if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                        if (!this.connectionInProgress) {
                            this.connectionInProgress = true;
                            try {
                                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                                Context context = this.context;
                                withinAppServiceConnection = this;
                                try {
                                    if (!connectionTracker.zzc(context, context.getClass().getName(), this.connectionIntent, withinAppServiceConnection, 65)) {
                                        withinAppServiceConnection.connectionInProgress = false;
                                        ArrayDeque arrayDeque = withinAppServiceConnection.intentQueue;
                                        while (!arrayDeque.isEmpty()) {
                                            ((BindRequest) arrayDeque.poll()).taskCompletionSource.trySetResult(null);
                                        }
                                    }
                                } catch (SecurityException unused) {
                                }
                            } catch (SecurityException unused2) {
                                withinAppServiceConnection = this;
                            }
                        }
                        return;
                    }
                    this.binder.send((BindRequest) this.intentQueue.poll());
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable(C0000.decode(new byte[]{114, 93, 70, 86, 6, 85, 75, 80, 40, 7, 71, 71, 85, 84, 13, 90, 95}, "4443d485eb"), 3)) {
                Objects.toString(componentName);
            }
            this.connectionInProgress = false;
            if (iBinder instanceof WithinAppServiceBinder) {
                this.binder = (WithinAppServiceBinder) iBinder;
                flushQueue();
            } else {
                Objects.toString(iBinder);
                ArrayDeque arrayDeque = this.intentQueue;
                while (!arrayDeque.isEmpty()) {
                    ((BindRequest) arrayDeque.poll()).taskCompletionSource.trySetResult(null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws Throwable {
        if (Log.isLoggable(C0000.decode(new byte[]{127, 94, 19, 82, 91, 85, 64, 92, 116, 82, 18, 68, 88, 83, 90, 87, 94}, "97a79439"), 3)) {
            Objects.toString(componentName);
        }
        flushQueue();
    }

    public final synchronized zzw sendIntent(Intent intent) {
        BindRequest bindRequest;
        bindRequest = new BindRequest(intent);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduledExecutorService;
        bindRequest.taskCompletionSource.zza.addOnCompleteListener(scheduledThreadPoolExecutor, new CctTransportBackend$$ExternalSyntheticLambda0(13, scheduledThreadPoolExecutor.schedule(new CoroutineWorker$$ExternalSyntheticLambda0(11, bindRequest), 20L, TimeUnit.SECONDS)));
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.taskCompletionSource.zza;
    }
}
