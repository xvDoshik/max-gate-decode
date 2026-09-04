package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import androidx.work.SystemClock;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.google.android.gms.tasks.zzu;
import com.google.firebase.messaging.ServiceStarter;
import java.util.Objects;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobImpl;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DelayMetCommandHandler implements OnConstraintsStateChangedListener, WorkTimer.TimeLimitExceededListener {
    public final Context mContext;
    public final ExecutorCoroutineDispatcherImpl mCoroutineDispatcher;
    public int mCurrentState;
    public final SystemAlarmDispatcher mDispatcher;
    public boolean mHasConstraints;
    public volatile JobImpl mJob;
    public final Object mLock;
    public final zzu mMainThreadExecutor;
    public final SerialExecutorImpl mSerialExecutor;
    public final int mStartId;
    public final StartStopToken mToken;
    public PowerManager.WakeLock mWakeLock;
    public final ConnectionPool mWorkConstraintsTracker;
    public final WorkGenerationalId mWorkGenerationalId;

    /* JADX INFO: renamed from: $r8$lambda$82vXfMh9MXtN-tLNgTa3KWbb4VE, reason: not valid java name */
    public static void m7$r8$lambda$82vXfMh9MXtNtLNgTa3KWbb4VE(DelayMetCommandHandler delayMetCommandHandler) {
        int i = delayMetCommandHandler.mStartId;
        zzu zzuVar = delayMetCommandHandler.mMainThreadExecutor;
        Context context = delayMetCommandHandler.mContext;
        SystemAlarmDispatcher systemAlarmDispatcher = delayMetCommandHandler.mDispatcher;
        WorkGenerationalId workGenerationalId = delayMetCommandHandler.mWorkGenerationalId;
        if (delayMetCommandHandler.mCurrentState >= 2) {
            SystemClock.get().getClass();
            return;
        }
        delayMetCommandHandler.mCurrentState = 2;
        SystemClock.get().getClass();
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(C0000.decode(new byte[]{36, 122, 55, 47, 46, 120, 111, 106, 49, 44, 53, 102, 52, 41, 51, 125}, "e9cfa609ec", true));
        CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
        zzuVar.execute(new SystemForegroundService.AnonymousClass2(i, intent, systemAlarmDispatcher));
        if (!systemAlarmDispatcher.mProcessor.isEnqueued(workGenerationalId.workSpecId)) {
            SystemClock.get().getClass();
            return;
        }
        SystemClock.get().getClass();
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction(C0000.decode(new byte[]{118, 117, 49, 121, 43, 125, 107, 99, 116, 126, 32, 116, 49, 127, 113, 111, 96, 121, 55, 123}, "76e0d340"));
        CommandHandler.writeWorkGenerationalId(intent2, workGenerationalId);
        zzuVar.execute(new SystemForegroundService.AnonymousClass2(i, intent2, systemAlarmDispatcher));
    }

    /* JADX INFO: renamed from: $r8$lambda$r8ATJco-vysxdAeSwS9XE6krknU, reason: not valid java name */
    public static void m8$r8$lambda$r8ATJcovysxdAeSwS9XE6krknU(DelayMetCommandHandler delayMetCommandHandler) {
        if (delayMetCommandHandler.mCurrentState != 0) {
            SystemClock systemClock = SystemClock.get();
            Objects.toString(delayMetCommandHandler.mWorkGenerationalId);
            systemClock.getClass();
            return;
        }
        delayMetCommandHandler.mCurrentState = 1;
        SystemClock systemClock2 = SystemClock.get();
        Objects.toString(delayMetCommandHandler.mWorkGenerationalId);
        systemClock2.getClass();
        if (!delayMetCommandHandler.mDispatcher.mProcessor.startWork(delayMetCommandHandler.mToken, null)) {
            delayMetCommandHandler.cleanUp();
            return;
        }
        WorkTimer workTimer = delayMetCommandHandler.mDispatcher.mWorkTimer;
        WorkGenerationalId workGenerationalId = delayMetCommandHandler.mWorkGenerationalId;
        synchronized (workTimer.mLock) {
            SystemClock systemClock3 = SystemClock.get();
            Objects.toString(workGenerationalId);
            systemClock3.getClass();
            workTimer.stopTimer(workGenerationalId);
            WorkTimer.WorkTimerRunnable workTimerRunnable = new WorkTimer.WorkTimerRunnable(workTimer, workGenerationalId);
            workTimer.mTimerMap.put(workGenerationalId, workTimerRunnable);
            workTimer.mListeners.put(workGenerationalId, delayMetCommandHandler);
            ((Handler) workTimer.mRunnableScheduler.delegate).postDelayed(workTimerRunnable, 600000L);
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{34, 0, 94, 5, 64, 117, 6, 21, 114, 86, 93, 9, 87, 13, 2, 45, 83, 10, 93, 84, 6, 19}, "fe2d98ca190d6c"));
    }

    public DelayMetCommandHandler(Context context, int i, SystemAlarmDispatcher systemAlarmDispatcher, StartStopToken startStopToken) {
        this.mContext = context;
        this.mStartId = i;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkGenerationalId = startStopToken.id;
        this.mToken = startStopToken;
        ServiceStarter serviceStarter = systemAlarmDispatcher.mWorkManager.mTrackers;
        Dispatcher dispatcher = systemAlarmDispatcher.mTaskExecutor;
        this.mSerialExecutor = (SerialExecutorImpl) dispatcher.executorServiceOrNull;
        this.mMainThreadExecutor = (zzu) dispatcher.runningSyncCalls;
        this.mCoroutineDispatcher = (ExecutorCoroutineDispatcherImpl) dispatcher.readyAsyncCalls;
        this.mWorkConstraintsTracker = new ConnectionPool(serviceStarter);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    public final void cleanUp() {
        synchronized (this.mLock) {
            try {
                if (this.mJob != null) {
                    this.mJob.cancel(null);
                }
                this.mDispatcher.mWorkTimer.stopTimer(this.mWorkGenerationalId);
                PowerManager.WakeLock wakeLock = this.mWakeLock;
                if (wakeLock != null && wakeLock.isHeld()) {
                    SystemClock systemClock = SystemClock.get();
                    Objects.toString(this.mWakeLock);
                    Objects.toString(this.mWorkGenerationalId);
                    systemClock.getClass();
                    this.mWakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void handleProcessWork() {
        String str = this.mWorkGenerationalId.workSpecId;
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, str + C0000.decode(new byte[]{68, 25}, "d15a6f") + this.mStartId + C0000.decode(new byte[]{27}, "24172da74a4b", true));
        SystemClock systemClock = SystemClock.get();
        Objects.toString(this.mWakeLock);
        systemClock.getClass();
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.mWorkManager.mWorkDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec == null) {
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 0));
            return;
        }
        boolean zHasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = zHasConstraints;
        if (zHasConstraints) {
            this.mJob = WorkConstraintsTrackerKt.listen(this.mWorkConstraintsTracker, workSpec, this.mCoroutineDispatcher, this);
        } else {
            SystemClock.get().getClass();
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 1));
        }
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        boolean z = constraintsState instanceof ConstraintsState.ConstraintsMet;
        SerialExecutorImpl serialExecutorImpl = this.mSerialExecutor;
        if (z) {
            serialExecutorImpl.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 1));
        } else {
            serialExecutorImpl.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 0));
        }
    }

    public final void onExecuted(boolean z) {
        SystemClock systemClock = SystemClock.get();
        WorkGenerationalId workGenerationalId = this.mWorkGenerationalId;
        Objects.toString(workGenerationalId);
        systemClock.getClass();
        cleanUp();
        int i = this.mStartId;
        SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
        zzu zzuVar = this.mMainThreadExecutor;
        Context context = this.mContext;
        if (z) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction(C0000.decode(new byte[]{119, 38, 55, 45, 44, 45, 105, 48, 32, 120, 112, 39, 52, 47, 115, 58, 52, 43, 49, 40}, "6ecdcc6cc05cac", true));
            CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
            zzuVar.execute(new SystemForegroundService.AnonymousClass2(i, intent, systemAlarmDispatcher));
        }
        if (this.mHasConstraints) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction(C0000.decode(new byte[]{32, 38, 99, 47, 121, 120, 60, 119, 127, 122, 97, 55, 54, 34, 123, 119, 53, 54, 104, 37, 126, 119, 45, 115, 117, 112}, "ae7f66c4042cdc29", 3));
            zzuVar.execute(new SystemForegroundService.AnonymousClass2(i, intent2, systemAlarmDispatcher));
        }
    }
}
