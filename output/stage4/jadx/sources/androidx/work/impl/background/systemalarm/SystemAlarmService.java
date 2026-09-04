package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.LifecycleService;
import androidx.work.SystemClock;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WakeLocksHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class SystemAlarmService extends LifecycleService {
    public SystemAlarmDispatcher mDispatcher;
    public boolean mIsShutdown;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{100, 64, 74, 64, 85, 85, 118, 91, 86, 75, 84, 103, 85, 74, 65, 94, 84, 92}, "79940877", 0.0f));
    }

    public final void onAllCommandsCompleted() {
        this.mIsShutdown = true;
        SystemClock.get().getClass();
        int i = WakeLocks.$r8$clinit;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (WakeLocksHolder.INSTANCE) {
            linkedHashMap.putAll(WakeLocksHolder.wakeLocks);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            if (wakeLock != null && wakeLock.isHeld()) {
                SystemClock.get().getClass();
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.mDispatcher = systemAlarmDispatcher;
        if (systemAlarmDispatcher.mCompletedListener != null) {
            SystemClock.get().getClass();
        } else {
            systemAlarmDispatcher.mCompletedListener = this;
        }
        this.mIsShutdown = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
        systemAlarmDispatcher.getClass();
        SystemClock.get().getClass();
        systemAlarmDispatcher.mProcessor.removeExecutionListener(systemAlarmDispatcher);
        systemAlarmDispatcher.mCompletedListener = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            SystemClock.get().getClass();
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.getClass();
            SystemClock.get().getClass();
            systemAlarmDispatcher.mProcessor.removeExecutionListener(systemAlarmDispatcher);
            systemAlarmDispatcher.mCompletedListener = null;
            SystemAlarmDispatcher systemAlarmDispatcher2 = new SystemAlarmDispatcher(this);
            this.mDispatcher = systemAlarmDispatcher2;
            if (systemAlarmDispatcher2.mCompletedListener != null) {
                SystemClock.get().getClass();
            } else {
                systemAlarmDispatcher2.mCompletedListener = this;
            }
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.add(intent, i2);
        return 3;
    }
}
