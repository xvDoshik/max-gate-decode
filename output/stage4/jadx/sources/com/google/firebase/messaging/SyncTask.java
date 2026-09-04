package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SyncTask implements Runnable {
    public final FirebaseMessaging firebaseMessaging;
    public final long nextDelaySeconds;
    public final PowerManager.WakeLock syncWakeLock;

    public final class ConnectivityChangeReceiver extends BroadcastReceiver {
        public SyncTask task;

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                SyncTask syncTask2 = this.task;
                syncTask2.firebaseMessaging.getClass();
                FirebaseMessaging.enqueueTaskWithDelaySeconds(syncTask2, 0L);
                this.task.firebaseMessaging.context.unregisterReceiver(this);
                this.task = null;
            }
        }
    }

    public SyncTask(FirebaseMessaging firebaseMessaging, long j) {
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(C0000.decode(new byte[]{94, 13, 66, 92, 91, 81, 70, 3, 29, 80, 81, 0, 29, 92, 65, 85, 86, 19, 68, 86, 74}, "8d09905f09", 7)));
        this.firebaseMessaging = firebaseMessaging;
        this.nextDelaySeconds = j;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) firebaseMessaging.context.getSystemService(C0000.decode(new byte[]{66, 87, 71, 85, 66}, "28000ff4b8fc69", false))).newWakeLock(1, C0000.decode(new byte[]{94, 94, 90, 86, 26, 68, 78, 90, 6}, "87327774ecedf0", 0));
        this.syncWakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public final boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.firebaseMessaging.context.getSystemService(C0000.decode(new byte[]{90, 90, 89, 95, 93, 81, 21, 12, 16, 93, 77, 76}, "957182aef49500"));
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean maybeRefreshToken() throws IOException {
        try {
            return this.firebaseMessaging.blockingGetToken() != null;
        } catch (IOException e) {
            String message = e.getMessage();
            if (C0000.decode(new byte[]{102, 124, 51, 55, 127, 118, 119, 105, 121, 118, 48, 60, 32, 53, 37, 44, 121, 120, 35, 45, 115}, "59aa652679dcacde").equals(message) || C0000.decode(new byte[]{42, 127, 99, 115, 106, 126, 39, 125, 102, 55, 125, 106, 102, 114, 49, 110, 114, 100, 106, 127, 52}, "c17680f19d8807").equals(message) || C0000.decode(new byte[]{40, 8, 64, 86, 20, 88, 2, 84, 106, 0, 19, 16, 81, 65, 35, 68, 17, 87, 75}, "af43f6c89e", 5).equals(message)) {
                e.getMessage();
                return false;
            }
            if (e.getMessage() == null) {
                return false;
            }
            throw e;
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        PowerManager.WakeLock wakeLock = this.syncWakeLock;
        ServiceStarter serviceStarter = ServiceStarter.getInstance();
        FirebaseMessaging firebaseMessaging = this.firebaseMessaging;
        if (serviceStarter.hasWakeLockPermission(firebaseMessaging.context)) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.syncScheduledOrRunning = true;
                }
                if (!firebaseMessaging.metadata.isGmscorePresent()) {
                    synchronized (firebaseMessaging) {
                        firebaseMessaging.syncScheduledOrRunning = false;
                    }
                    if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(firebaseMessaging.context) || isDeviceConnected()) {
                    if (maybeRefreshToken()) {
                        synchronized (firebaseMessaging) {
                            firebaseMessaging.syncScheduledOrRunning = false;
                        }
                    } else {
                        firebaseMessaging.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                    }
                    if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                ConnectivityChangeReceiver connectivityChangeReceiver = new ConnectivityChangeReceiver();
                connectivityChangeReceiver.task = this;
                connectivityChangeReceiver.task.firebaseMessaging.context.registerReceiver(connectivityChangeReceiver, new IntentFilter(C0000.decode(new byte[]{85, 93, 5, 23, 12, 89, 87, 24, 8, 1, 68, 77, 87, 92, 15, 11, 77, 115, 124, 120, 40, 33, 115, 55, 125, 101, 40, 49, 58, 111, 112, 126, 39, 42, 119, 38}, "43aec036fd0c", 0.0f)));
                if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                    wakeLock.release();
                }
            } catch (IOException e) {
                e.getMessage();
                synchronized (firebaseMessaging) {
                    firebaseMessaging.syncScheduledOrRunning = false;
                    if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                        wakeLock.release();
                    }
                }
            }
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                wakeLock.release();
            }
            throw th;
        }
    }
}
