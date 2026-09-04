package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.tracing.Trace;
import androidx.work.Constraints;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.SystemClock;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.StopWorkRunnable;
import com.google.android.gms.tasks.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CommandHandler implements ExecutionListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SystemClock mClock;
    public final Context mContext;
    public final StartStopTokens mStartStopTokens;
    public final HashMap mPendingDelayMet = new HashMap();
    public final Object mLock = new Object();

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{123, 14, 14, 12, 88, 87, 83, 124, 88, 91, 82, 89, 93, 19}, "8aca99749565", 0.0f));
    }

    public CommandHandler(Context context, SystemClock systemClock, StartStopTokens startStopTokens) {
        this.mContext = context;
        this.mClock = systemClock;
        this.mStartStopTokens = startStopTokens;
    }

    public static WorkGenerationalId readWorkGenerationalId(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra(C0000.decode(new byte[]{125, 39, 58, 58, 103, 127, 100, 41, 48, 53, 117, 115, 105, 43, 39}, "6bce00")), intent.getIntExtra(C0000.decode(new byte[]{45, 124, 58, 110, 99, 124, 48, 122, 49, 50, 33, 112, 104, 38, 119, 45, 35, 107, 34, 101, 125, 124, 44}, "f9c143b1bbd37a2c", 2), 0));
    }

    public static void writeWorkGenerationalId(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra(C0000.decode(new byte[]{124, 113, 107, 110, 54, 118, 98, 123, 100, 100, 119, 114, 62, 112, 116}, "7421a900", 2), workGenerationalId.workSpecId);
        intent.putExtra(C0000.decode(new byte[]{121, 116, 59, 110, 101, 42, 107, 120, 103, 104, 114, 122, 109, 118, 39, 127, 119, 55, 120, 103, 125, 119, 121}, "21b12e934879", true), workGenerationalId.generation);
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.mLock) {
            try {
                DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) this.mPendingDelayMet.remove(workGenerationalId);
                this.mStartStopTokens.remove(workGenerationalId);
                if (delayMetCommandHandler != null) {
                    delayMetCommandHandler.onExecuted(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onHandleIntent(int i, Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) throws Throwable {
        List<StartStopToken> listRemove;
        ArrayList arrayList;
        String action = intent.getAction();
        int i2 = 0;
        if (C0000.decode(new byte[]{39, 37, 103, 44, 123, 118, 59, 119, 41, 40, 96, 49, 102, 121, 45, 122, 50, 53, 108, 38, 124, 121, 42, 115, 35, 34}, "ff3e48d4").equals(action)) {
            SystemClock systemClock = SystemClock.get();
            Objects.toString(intent);
            systemClock.getClass();
            Context context = this.mContext;
            ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(context, this.mClock, i, systemAlarmDispatcher);
            ArrayList scheduledWork = systemAlarmDispatcher.mWorkManager.mWorkDatabase.workSpecDao().getScheduledWork();
            int i3 = ConstraintProxy.$r8$clinit;
            int size = scheduledWork.size();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            int i4 = 0;
            while (i4 < size) {
                Object obj = scheduledWork.get(i4);
                i4++;
                Constraints constraints = ((WorkSpec) obj).constraints;
                z |= constraints.requiresBatteryNotLow;
                z2 |= constraints.requiresCharging;
                z3 |= constraints.requiresStorageNotLow;
                z4 |= constraints.requiredNetworkType != 1;
                if (z && z2 && z3 && z4) {
                    break;
                }
            }
            int i5 = ConstraintProxyUpdateReceiver.$r8$clinit;
            Intent intent2 = new Intent(C0000.decode(new byte[]{5, 92, 86, 75, 87, 95, 0, 73, 29, 65, 11, 64, 89, 23, 81, 91, 20, 93, 29, 84, 5, 81, 89, 94, 74, 89, 17, 95, 87, 24, 23, 75, 65, 77, 93, 91, 5, 93, 82, 68, 9, 28, 103, 73, 92, 87, 16, 84, 99, 68, 11, 74, 91, 92, 75}, "d22986d136"));
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra(C0000.decode(new byte[]{114, 115, 105, 103, 119, 117, 50, 109, 124, 100, 105, 103, 123, 123, 50, 102, 117, 121, 103, 103, 101, 102, 41, 97, 96, 105, 117, 118, 116, 118, 42, 124, 125}, "960854f9"), z).putExtra(C0000.decode(new byte[]{127, 124, 111, 61, 118, 120, 99, 48, 113, 107, 111, 61, 119, 113, 118, 54, 115, 112, 120, 37, 107, 105, 101, 43, 108, 96, 105, 39, 122, 120, 117, 40, 113, 125}, "496b497d"), z2).putExtra(C0000.decode(new byte[]{42, 116, 59, 59, 99, 99, 42, 107, 117, 127, 124, 106, 47, 126, 54, 59, 124, 120, 50, 102, 100, 106, 118, 109, 56, 110, 39, 42, 113, 117, 41, 124, 112}, "a1bd07e94895"), z3).putExtra(C0000.decode(new byte[]{40, 112, 60, 62, 121, 118, 100, 101, 126, 49, 40, 106, 54, 53, 118, 103, 117, 109, 97, 49, 44, 109, 60, 62, 114, 125, 113, 112, 125, 38, 39}, "c5ea73021c"), z4);
            context.sendBroadcast(intent2);
            ArrayList arrayList2 = new ArrayList(scheduledWork.size());
            constraintsCommandHandler.mClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size2 = scheduledWork.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = scheduledWork.get(i6);
                i6++;
                WorkSpec workSpec = (WorkSpec) obj2;
                if (jCurrentTimeMillis >= workSpec.calculateNextRunTime() && (!workSpec.hasConstraints() || constraintsCommandHandler.mWorkConstraintsTracker.areAllConstraintsMet(workSpec))) {
                    arrayList2.add(workSpec);
                }
            }
            int size3 = arrayList2.size();
            while (i2 < size3) {
                Object obj3 = arrayList2.get(i2);
                i2++;
                WorkSpec workSpec2 = (WorkSpec) obj3;
                String str = workSpec2.id;
                WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workSpec2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction(C0000.decode(new byte[]{117, 116, 48, 112, 41, 125, 61, 39, 35, 40, 32, 110, 110, 120, 113, 99}, "47d9f3bcfda715"));
                writeWorkGenerationalId(intent3, workGenerationalIdGenerationalId);
                SystemClock.get().getClass();
                ((zzu) systemAlarmDispatcher.mTaskExecutor.runningSyncCalls).execute(new SystemForegroundService.AnonymousClass2(constraintsCommandHandler.mStartId, intent3, systemAlarmDispatcher));
            }
            return;
        }
        if (C0000.decode(new byte[]{121, 32, 50, 123, 123, 42, 106, 100, 125, 48, 37, 122, 113, 32, 96, 122, 125}, "8cf24d56").equals(action)) {
            SystemClock systemClock2 = SystemClock.get();
            Objects.toString(intent);
            systemClock2.getClass();
            systemAlarmDispatcher.mWorkManager.rescheduleEligibleWork();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {C0000.decode(new byte[]{41, 38, 60, 102, 102, 42, 49, 127, 49, 96, 39, 32, 58, 112, 117}, "bce91ec4b0")};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            SystemClock.get().getClass();
            return;
        }
        if (C0000.decode(new byte[]{35, 112, 48, 125, 120, 125, 62, 50, 33, 126, 36, 117, 55, 127, 33, 107, 96, 124, 51, 42}, "b3d473aab6a1").equals(action)) {
            Context context2 = this.mContext;
            WorkGenerationalId workGenerationalId = readWorkGenerationalId(intent);
            SystemClock systemClock3 = SystemClock.get();
            workGenerationalId.toString();
            systemClock3.getClass();
            WorkDatabase workDatabase = systemAlarmDispatcher.mWorkManager.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec3 = workDatabase.workSpecDao().getWorkSpec(workGenerationalId.workSpecId);
                if (workSpec3 == null) {
                    SystemClock systemClock4 = SystemClock.get();
                    workGenerationalId.toString();
                    systemClock4.getClass();
                    return;
                }
                if (NetworkType$EnumUnboxingLocalUtility._isFinished(workSpec3.state)) {
                    SystemClock systemClock5 = SystemClock.get();
                    workGenerationalId.toString();
                    systemClock5.getClass();
                    return;
                }
                long jCalculateNextRunTime = workSpec3.calculateNextRunTime();
                if (workSpec3.hasConstraints()) {
                    SystemClock systemClock6 = SystemClock.get();
                    workGenerationalId.toString();
                    systemClock6.getClass();
                    Alarms.setAlarm(context2, workDatabase, workGenerationalId, jCalculateNextRunTime);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction(C0000.decode(new byte[]{121, 39, 100, 44, 121, 119, 103, 39, 127, 43, 101, 109, 106, 37, 121, 43, 98, 106, 103, 39, 120, 36, 120, 126, 125, 32}, "8d0e69"));
                    ((zzu) systemAlarmDispatcher.mTaskExecutor.runningSyncCalls).execute(new SystemForegroundService.AnonymousClass2(i, intent4, systemAlarmDispatcher));
                } else {
                    SystemClock systemClock7 = SystemClock.get();
                    workGenerationalId.toString();
                    systemClock7.getClass();
                    Alarms.setAlarm(context2, workDatabase, workGenerationalId, jCalculateNextRunTime);
                }
                workDatabase.setTransactionSuccessful();
                return;
            } finally {
                workDatabase.internalEndTransaction();
            }
        }
        if (C0000.decode(new byte[]{119, 38, 99, 45, 45, 123, 105, 33, 114, 40, 35, 108, 105, 40, 114, 48}, "6e7db5").equals(action)) {
            synchronized (this.mLock) {
                try {
                    WorkGenerationalId workGenerationalId2 = readWorkGenerationalId(intent);
                    SystemClock systemClock8 = SystemClock.get();
                    workGenerationalId2.toString();
                    systemClock8.getClass();
                    if (this.mPendingDelayMet.containsKey(workGenerationalId2)) {
                        SystemClock systemClock9 = SystemClock.get();
                        workGenerationalId2.toString();
                        systemClock9.getClass();
                    } else {
                        DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i, systemAlarmDispatcher, this.mStartStopTokens.tokenFor(workGenerationalId2));
                        this.mPendingDelayMet.put(workGenerationalId2, delayMetCommandHandler);
                        delayMetCommandHandler.handleProcessWork();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (!C0000.decode(new byte[]{116, 116, 49, 120, 126, 121, 109, 107, 108, 46, 51, 108, 100, 46, 103, 124}, "57e117288ac33a").equals(action)) {
            if (!C0000.decode(new byte[]{120, 123, 101, 125, 124, 44, 60, 113, 106, 36, 114, 98, 48, 121, 118, 118, 110, 119, 124, 47, 51, 120, 119, 53, 116, 115}, "98143bc42a17d0").equals(action)) {
                SystemClock systemClock10 = SystemClock.get();
                intent.toString();
                systemClock10.getClass();
                return;
            } else {
                WorkGenerationalId workGenerationalId3 = readWorkGenerationalId(intent);
                boolean z5 = intent.getExtras().getBoolean(C0000.decode(new byte[]{41, 32, 58, 103, 126, 35, 39, 33, 48, 103, 98, 35, 49, 38, 43, 125, 116, 51, 46, 32}, "bec80f"));
                SystemClock systemClock11 = SystemClock.get();
                intent.toString();
                systemClock11.getClass();
                onExecuted(workGenerationalId3, z5);
                return;
            }
        }
        StartStopTokens startStopTokens = this.mStartStopTokens;
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString(C0000.decode(new byte[]{114, 36, 56, 60, 96, 121, 107, 42, 50, 51, 114, 117, 102, 40, 37}, "9aac76"));
        String strDecode = C0000.decode(new byte[]{122, 38, 111, 58, 98, 120, 99, 40, 101, 53, 112, 116, 110, 36, 115, 43, 112, 101, 112, 55, 127, 42, 123}, "1c6e57");
        if (extras2.containsKey(strDecode)) {
            int i7 = extras2.getInt(strDecode);
            arrayList = new ArrayList(1);
            StartStopToken startStopTokenRemove = startStopTokens.remove(new WorkGenerationalId(string, i7));
            if (startStopTokenRemove != null) {
                listRemove = arrayList;
                arrayList.add(startStopTokenRemove);
                listRemove = arrayList;
            }
        } else {
            listRemove = startStopTokens.remove(string);
        }
        listRemove = arrayList;
        for (StartStopToken startStopToken : listRemove) {
            SystemClock.get().getClass();
            WorkLauncher workLauncher = systemAlarmDispatcher.mWorkLauncher;
            workLauncher.getClass();
            WorkLauncherImpl workLauncherImpl = (WorkLauncherImpl) workLauncher;
            ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StopWorkRunnable((Processor) workLauncherImpl.processor, startStopToken, false, -512));
            WorkGenerationalId workGenerationalId4 = startStopToken.id;
            Context context3 = this.mContext;
            WorkDatabase workDatabase2 = systemAlarmDispatcher.mWorkManager.mWorkDatabase;
            int i8 = Alarms.$r8$clinit;
            Dispatcher dispatcherSystemIdInfoDao = workDatabase2.systemIdInfoDao();
            SystemIdInfo systemIdInfo = dispatcherSystemIdInfoDao.getSystemIdInfo(workGenerationalId4);
            if (systemIdInfo != null) {
                Alarms.cancelExactAlarm(context3, workGenerationalId4, systemIdInfo.systemId);
                SystemClock systemClock12 = SystemClock.get();
                workGenerationalId4.toString();
                systemClock12.getClass();
                String str2 = workGenerationalId4.workSpecId;
                int i9 = workGenerationalId4.generation;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) dispatcherSystemIdInfoDao.executorServiceOrNull;
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = (WorkTagDao_Impl.AnonymousClass2) dispatcherSystemIdInfoDao.runningAsyncCalls;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                if (str2 == null) {
                    frameworkSQLiteStatementAcquire.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire.bindString(str2, 1);
                }
                frameworkSQLiteStatementAcquire.bindLong(2, i9);
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.internalEndTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                } catch (Throwable th2) {
                    workDatabase_Impl.internalEndTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    throw th2;
                }
            }
            systemAlarmDispatcher.onExecuted(workGenerationalId4, false);
        }
    }
}
