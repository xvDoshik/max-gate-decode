package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.CancelWorkRunnable;
import java.util.Objects;
import java.util.UUID;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class SystemForegroundService extends LifecycleService {
    public static final /* synthetic */ int $r8$clinit = 0;
    public SystemForegroundDispatcher mDispatcher;
    public Handler mHandler;
    public boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Notification val$notification;
        public final /* synthetic */ int val$notificationId;
        public final /* synthetic */ int val$notificationType;

        public AnonymousClass1(int i, Notification notification, int i2) {
            this.val$notificationId = i;
            this.val$notification = notification;
            this.val$notificationType = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = Build.VERSION.SDK_INT;
            int i2 = this.val$notificationType;
            Notification notification = this.val$notification;
            int i3 = this.val$notificationId;
            SystemForegroundService systemForegroundService = SystemForegroundService.this;
            if (i >= 31) {
                Api31Impl.startForeground(systemForegroundService, i3, notification, i2);
            } else if (i >= 29) {
                Api29Impl.startForeground(systemForegroundService, i3, notification, i2);
            } else {
                systemForegroundService.startForeground(i3, notification);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$2, reason: invalid class name */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object this$0;
        public final Object val$notification;
        public final int val$notificationId;

        public AnonymousClass2(SystemForegroundService systemForegroundService, int i, Notification notification) {
            this.this$0 = systemForegroundService;
            this.val$notificationId = i;
            this.val$notification = notification;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    ((SystemForegroundService) this.this$0).mNotificationManager.notify(this.val$notificationId, (Notification) this.val$notification);
                    break;
                default:
                    ((SystemAlarmDispatcher) this.val$notification).add((Intent) this.this$0, this.val$notificationId);
                    break;
            }
        }

        public AnonymousClass2(int i, Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
            this.val$notification = systemAlarmDispatcher;
            this.this$0 = intent;
            this.val$notificationId = i;
        }
    }

    public abstract class Api29Impl {
        public static void startForeground(Service service, int i, Notification notification, int i2) {
            service.startForeground(i, notification, i2);
        }
    }

    public abstract class Api31Impl {
        public static void startForeground(Service service, int i, Notification notification, int i2) {
            try {
                service.startForeground(i, notification, i2);
            } catch (ForegroundServiceStartNotAllowedException unused) {
                SystemClock systemClock = SystemClock.get();
                int i3 = SystemForegroundService.$r8$clinit;
                systemClock.getClass();
            }
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{106, 31, 16, 17, 92, 14, 112, 94, 53, 4, 20, 66, 89, 80, 81}, "9fce9c69faf40344", 4));
    }

    public final void initializeDispatcher$1() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(C0000.decode(new byte[]{86, 13, 66, 92, 4, 88, 91, 3, 66, 92, 13, 95}, "8b65b1"));
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        if (systemForegroundDispatcher.mCallback != null) {
            SystemClock.get().getClass();
        } else {
            systemForegroundDispatcher.mCallback = this;
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        initializeDispatcher$1();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            SystemClock.get().getClass();
            this.mDispatcher.onDestroy();
            initializeDispatcher$1();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
        systemForegroundDispatcher.getClass();
        String action = intent.getAction();
        boolean zEquals = C0000.decode(new byte[]{117, 33, 100, 125, 44, 127, 104, 103, 100, 37, 101, 97, 107, 36, 127, 102, 38, 118, 101, 123, 101, 42, 115}, "4b04c1740d75").equals(action);
        String strDecode = C0000.decode(new byte[]{122, 115, 106, 110, 51, 41, 103, 40, 107, 102, 116, 117, 108, 120, 32}, "1631df5c86", 7);
        if (zEquals) {
            SystemClock systemClock = SystemClock.get();
            Objects.toString(intent);
            systemClock.getClass();
            systemForegroundDispatcher.mTaskExecutor.executeOnTaskThread(new Worker.AnonymousClass2(systemForegroundDispatcher, 3, intent.getStringExtra(strDecode)));
            systemForegroundDispatcher.handleNotify(intent);
            return 3;
        }
        if (C0000.decode(new byte[]{116, 122, 102, 124, 118, 127, 104, 123, 127, 97, 120, 113, 105}, "59259175051703", 3).equals(action)) {
            systemForegroundDispatcher.handleNotify(intent);
            return 3;
        }
        if (!C0000.decode(new byte[]{112, 116, 100, 45, 42, 127, 110, 114, 36, 44, 114, 114, 124, 59, 50, 126, 99, 122}, "170de111eb", 5).equals(action)) {
            if (!C0000.decode(new byte[]{113, 116, 102, 125, 45, 123, 57, 55, 101, 45, 96, 104, 116, 123, 48, 112, 33, 54, 126, 55, 126, 115}, "0724b5fd1b", 0.0f).equals(action)) {
                return 3;
            }
            SystemClock.get().getClass();
            SystemForegroundService systemForegroundService = systemForegroundDispatcher.mCallback;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.mIsShutdown = true;
            SystemClock.get().getClass();
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
        SystemClock systemClock2 = SystemClock.get();
        Objects.toString(intent);
        systemClock2.getClass();
        String stringExtra = intent.getStringExtra(strDecode);
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        WorkManagerImpl workManagerImpl = systemForegroundDispatcher.mWorkManagerImpl;
        UUID uuidFromString = UUID.fromString(stringExtra);
        workManagerImpl.getClass();
        workManagerImpl.mWorkTaskExecutor.executeOnTaskThread(new CancelWorkRunnable.AnonymousClass1(workManagerImpl, uuidFromString, 0));
        return 3;
    }
}
