package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TopicsSyncTask implements Runnable {
    public static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    public static Boolean hasAccessNetworkStatePermission;
    public static Boolean hasWakeLockPermission;
    public final Context context;
    public final Metadata metadata;
    public final long nextDelaySeconds;
    public final PowerManager.WakeLock syncWakeLock;
    public final TopicsSubscriber topicsSubscriber;

    public final class ConnectivityChangeReceiver extends BroadcastReceiver {
        public TopicsSyncTask task;

        @Override // android.content.BroadcastReceiver
        public final synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.task;
            if (topicsSyncTask == null) {
                return;
            }
            if (topicsSyncTask.isDeviceConnected()) {
                TopicsSyncTask topicsSyncTask2 = this.task;
                topicsSyncTask2.topicsSubscriber.syncExecutor.schedule(topicsSyncTask2, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.task = null;
            }
        }
    }

    public TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j) {
        this.topicsSubscriber = topicsSubscriber;
        this.context = context;
        this.nextDelaySeconds = j;
        this.metadata = metadata;
        this.syncWakeLock = ((PowerManager) context.getSystemService(C0000.decode(new byte[]{67, 90, 69, 86, 17}, "3523c61ca3c0a2"))).newWakeLock(1, C0000.decode(new byte[]{20, 80, 14, 3, 88, 82, 14, 12, 77, 1, 12, 94, 2, 10, 7, 31, 7, 8, 17, 3, 1, 80, 22, 3, 76, 92, 4, 18, 16, 7, 4, 88, 11, 1}, "c1efb1aacf"));
    }

    public static boolean hasAccessNetworkStatePermission(Context context) {
        boolean zBooleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            try {
                Boolean bool = hasAccessNetworkStatePermission;
                if (bool == null) {
                    String strDecode = C0000.decode(new byte[]{82, 95, 2, 69, 87, 94, 83, 29, 67, 81, 71, 91, 13, 75, 75, 13, 92, 95, 72, 118, 123, 116, 114, 96, 96, 107, 123, 115, 48, 111, 119, 54, 120, 110, 53, 99, 121, 99, 114}, "31f787733456d88d", 6);
                    if (bool != null) {
                        zBooleanValue = bool.booleanValue();
                    } else {
                        zBooleanValue = context.checkCallingOrSelfPermission(strDecode) == 0;
                    }
                } else {
                    zBooleanValue = bool.booleanValue();
                }
                hasAccessNetworkStatePermission = Boolean.valueOf(zBooleanValue);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean hasWakeLockPermission(Context context) {
        boolean zBooleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            try {
                Boolean bool = hasWakeLockPermission;
                if (bool == null) {
                    String strDecode = C0000.decode(new byte[]{86, 10, 7, 19, 14, 88, 1, 76, 65, 0, 68, 88, 94, 23, 16, 8, 14, 95, 75, 53, 112, 46, 115, 106, 123, 43, 32, 42}, "7dcaa1eb1e65");
                    if (bool != null) {
                        zBooleanValue = bool.booleanValue();
                    } else {
                        zBooleanValue = context.checkCallingOrSelfPermission(strDecode) == 0;
                    }
                } else {
                    zBooleanValue = bool.booleanValue();
                }
                hasWakeLockPermission = Boolean.valueOf(zBooleanValue);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public final synchronized boolean isDeviceConnected() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService(C0000.decode(new byte[]{80, 92, 87, 94, 86, 5, 17, 93, 67, 92, 71, 74}, "33903fe455", false));
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Throwable th) {
            throw th;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    public final void run() {
        TopicsSubscriber topicsSubscriber = this.topicsSubscriber;
        Context context = this.context;
        boolean zHasWakeLockPermission = hasWakeLockPermission(context);
        PowerManager.WakeLock wakeLock = this.syncWakeLock;
        if (zHasWakeLockPermission) {
            wakeLock.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            try {
                try {
                    topicsSubscriber.setSyncScheduledOrRunning(true);
                    if (!this.metadata.isGmscorePresent()) {
                        topicsSubscriber.setSyncScheduledOrRunning(false);
                        if (hasWakeLockPermission(context)) {
                            try {
                                wakeLock.release();
                                return;
                            } catch (RuntimeException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    if (!hasAccessNetworkStatePermission(context) || isDeviceConnected()) {
                        if (topicsSubscriber.syncTopics()) {
                            topicsSubscriber.setSyncScheduledOrRunning(false);
                        } else {
                            topicsSubscriber.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                        }
                        if (hasWakeLockPermission(context)) {
                            wakeLock.release();
                            return;
                        }
                        return;
                    }
                    ConnectivityChangeReceiver connectivityChangeReceiver = new ConnectivityChangeReceiver();
                    connectivityChangeReceiver.task = this;
                    context.registerReceiver(connectivityChangeReceiver, new IntentFilter(C0000.decode(new byte[]{82, 86, 0, 67, 12, 10, 87, 22, 10, 84, 23, 77, 80, 87, 10, 95, 77, 32, 124, 118, 42, 116, 32, 55, 122, 110, 45, 101, 58, 60, 112, 112, 37, 127, 36, 38}, "38d1cc", 0)));
                    if (hasWakeLockPermission(context)) {
                        try {
                            wakeLock.release();
                        } catch (RuntimeException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    if (hasWakeLockPermission(context)) {
                        try {
                            wakeLock.release();
                        } catch (RuntimeException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                e.getMessage();
                topicsSubscriber.setSyncScheduledOrRunning(false);
                if (hasWakeLockPermission(context)) {
                    wakeLock.release();
                }
            }
        } catch (RuntimeException unused4) {
        }
    }
}
