package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.UserManagerCompat$Api24Impl;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.SystemClock;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.gms.cloudmessaging.zzac;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.io.CloseableKt;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ForceStopRunnable implements Runnable {
    public static final long TEN_YEARS;
    public final Context mContext;
    public final IdGenerator mPreferenceUtils;
    public int mRetryCount = 0;
    public final WorkManagerImpl mWorkManager;

    public class BroadcastReceiver extends android.content.BroadcastReceiver {
        static {
            SystemClock.tagWithPrefix(C0000.decode(new byte[]{126, 94, 74, 85, 0, 55, 67, 13, 72, 99, 77, 88, 11, 5, 85, 14, 93, 21, 106, 85, 19, 22}, "8186ed7b", true));
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (C0000.decode(new byte[]{35, 116, 102, 122, 124, 125, 61, 113, 41, 98, 33, 114, 109, 96, 103, 124, 50, 104, 52, 117, 49, 116, 122, 118, 119, 102, 46, 114}, "b72333b7f0", false).equals(intent.getAction())) {
                    SystemClock.get().getClass();
                    ForceStopRunnable.setAlarm(context);
                }
            }
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{127, 10, 19, 85, 7, 50, 66, 93, 73, 55, 20, 88, 12, 0, 84, 94, 92}, "9ea6ba62", true));
        TEN_YEARS = TimeUnit.DAYS.toMillis(3650L);
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mPreferenceUtils = workManagerImpl.mPreferenceUtils;
    }

    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(C0000.decode(new byte[]{3, 9, 2, 66, 15}, "bec0b94fb15d3b79", 0.0f));
        int i = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction(C0000.decode(new byte[]{118, 114, 100, 47, 44, 42, 110, 126, 126, 51, 116, 116, 111, 53, 55, 43, 97, 103, 99, 36, 100, 114, 120, 35, 39, 49, 125, 125}, "710fcd181a", 0.0f));
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long jCurrentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x027d  */
    public final void forceStopRunnable() {
        boolean z;
        String strDecode = C0000.decode(new byte[]{84, 81, 69, 18, 106, 81, 92, 75, 91, 85, 105, 21, 65, 88, 67, 102, 85, 67}, "806f5739");
        IdGenerator idGenerator = this.mPreferenceUtils;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        Configuration configuration = workManagerImpl.mConfiguration;
        IdGenerator idGenerator2 = workManagerImpl.mPreferenceUtils;
        WorkDatabase workDatabase2 = workManagerImpl.mWorkDatabase;
        int i = SystemJobScheduler.$r8$clinit;
        String strDecode2 = C0000.decode(new byte[]{88, 93, 90, 68, 1, 89, 93, 7, 22, 91, 87, 64}, "2287b18cc7");
        Context context = this.mContext;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(strDecode2);
        ArrayList pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler);
        Dispatcher dispatcherSystemIdInfoDao = workDatabase.systemIdInfoDao();
        dispatcherSystemIdInfoDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{102, 125, 40, 35, 113, 100, 65, 39, 122, 96, 55, 45, 42, 115, 97, 24, 19, 9, 64, 91, 62, 16, 67, 86, 0, 59, 13, 84, 21, 126, 54, 41, 127, 16, 50, 26, 64, 71, 6, 9, 45, 84, 124, 86, 2, 9}, "58df20ac33cdd0", 5), 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) dispatcherSystemIdInfoDao.executorServiceOrNull;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
            if (pendingJobs != null && !pendingJobs.isEmpty()) {
                int size = pendingJobs.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = pendingJobs.get(i2);
                    i2++;
                    JobInfo jobInfo = (JobInfo) obj;
                    WorkGenerationalId workGenerationalIdFromJobInfo = SystemJobScheduler.getWorkGenerationalIdFromJobInfo(jobInfo);
                    if (workGenerationalIdFromJobInfo != null) {
                        hashSet.add(workGenerationalIdFromJobInfo.workSpecId);
                    } else {
                        SystemJobScheduler.cancelJobById(jobScheduler, jobInfo.getId());
                    }
                }
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    z = false;
                    break;
                }
                Object obj2 = arrayList.get(i3);
                i3++;
                if (!hashSet.contains((String) obj2)) {
                    SystemClock.get().getClass();
                    z = true;
                    break;
                }
            }
            if (z) {
                workDatabase.beginTransaction();
                try {
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                    int size3 = arrayList.size();
                    int i4 = 0;
                    while (i4 < size3) {
                        Object obj3 = arrayList.get(i4);
                        i4++;
                        workSpecDao_ImplWorkSpecDao.markWorkSpecScheduled(-1L, (String) obj3);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                } catch (Throwable th) {
                    workDatabase.internalEndTransaction();
                    throw th;
                }
            }
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao2 = workDatabase2.workSpecDao();
            zzac zzacVarWorkProgressDao = workDatabase2.workProgressDao();
            workDatabase2.beginTransaction();
            try {
                ArrayList runningWork = workSpecDao_ImplWorkSpecDao2.getRunningWork();
                boolean zIsEmpty = runningWork.isEmpty();
                if (!zIsEmpty) {
                    int size4 = runningWork.size();
                    int i5 = 0;
                    while (i5 < size4) {
                        Object obj4 = runningWork.get(i5);
                        i5++;
                        String str = ((WorkSpec) obj4).id;
                        workSpecDao_ImplWorkSpecDao2.setState(str, 1);
                        workSpecDao_ImplWorkSpecDao2.setStopReason(str, -512);
                        workSpecDao_ImplWorkSpecDao2.markWorkSpecScheduled(-1L, str);
                        runningWork = runningWork;
                        zIsEmpty = zIsEmpty;
                    }
                }
                boolean z2 = zIsEmpty;
                WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) zzacVarWorkProgressDao.zza;
                workDatabase_Impl2.assertNotSuspendingTransaction();
                WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = (WorkTagDao_Impl.AnonymousClass2) zzacVarWorkProgressDao.zzc;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                workDatabase_Impl2.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl2.setTransactionSuccessful();
                    workDatabase_Impl2.internalEndTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    workDatabase2.setTransactionSuccessful();
                    workDatabase2.internalEndTransaction();
                    boolean z3 = !z2 || z;
                    OperationImpl operationImplPreferenceDao = idGenerator2.workDatabase.preferenceDao();
                    String strDecode3 = C0000.decode(new byte[]{65, 6, 21, 85, 14, 82, 1, 22, 92, 87, 110, 11, 0, 83, 0, 93, 87}, "3cf6f7ec021ee6d8", 4);
                    Long longValue = operationImplPreferenceDao.getLongValue(strDecode3);
                    if (longValue != null && longValue.longValue() == 1) {
                        SystemClock.get().getClass();
                        workManagerImpl.rescheduleEligibleWork();
                        idGenerator2.getClass();
                        idGenerator2.workDatabase.preferenceDao().insertPreference(new Preference(strDecode3, 0L));
                        return;
                    }
                    try {
                        int i6 = Build.VERSION.SDK_INT;
                        int i7 = i6 >= 31 ? 570425344 : 536870912;
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
                        intent.setAction(C0000.decode(new byte[]{121, 123, 100, 120, 42, 122, 106, 115, 46, 55, 117, 114, 111, 99, 108, 119, 96, 110, 55, 113, 102, 118, 41, 32, 114, 98, 124, 117}, "8801e455ae6700", 7));
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i7);
                        if (i6 < 30) {
                            if (broadcast == null) {
                                setAlarm(context);
                                SystemClock.get().getClass();
                                workManagerImpl.rescheduleEligibleWork();
                                ((SystemClock) configuration.clock).getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                idGenerator.getClass();
                                idGenerator.workDatabase.preferenceDao().insertPreference(new Preference(strDecode, Long.valueOf(jCurrentTimeMillis)));
                                return;
                            }
                            if (z3) {
                                SystemClock.get().getClass();
                                Schedulers.schedule(configuration, workDatabase2, workManagerImpl.mSchedulers);
                            }
                        }
                        if (broadcast != null) {
                            broadcast.cancel();
                        }
                        List historicalProcessExitReasons = ((ActivityManager) context.getSystemService(C0000.decode(new byte[]{84, 85, 23, 88, 79, 10, 65, 76}, "56c19c5529fa"))).getHistoricalProcessExitReasons(null, 0, 0);
                        if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                            Long longValue2 = idGenerator.workDatabase.preferenceDao().getLongValue(strDecode);
                            long jLongValue = longValue2 != null ? longValue2.longValue() : 0L;
                            for (int i8 = 0; i8 < historicalProcessExitReasons.size(); i8++) {
                                ApplicationExitInfo applicationExitInfoM = ForceStopRunnable$$ExternalSyntheticApiModelOutline0.m(historicalProcessExitReasons.get(i8));
                                if (applicationExitInfoM.getReason() == 10 && applicationExitInfoM.getTimestamp() >= jLongValue) {
                                    SystemClock.get().getClass();
                                    workManagerImpl.rescheduleEligibleWork();
                                    ((SystemClock) configuration.clock).getClass();
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    idGenerator.getClass();
                                    idGenerator.workDatabase.preferenceDao().insertPreference(new Preference(strDecode, Long.valueOf(jCurrentTimeMillis2)));
                                    return;
                                }
                            }
                        }
                        if (z3) {
                            SystemClock.get().getClass();
                            Schedulers.schedule(configuration, workDatabase2, workManagerImpl.mSchedulers);
                        }
                    } catch (IllegalArgumentException | SecurityException unused) {
                        SystemClock.get().getClass();
                    }
                } catch (Throwable th2) {
                    workDatabase_Impl2.internalEndTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    throw th2;
                }
            } catch (Throwable th3) {
                workDatabase2.internalEndTransaction();
                throw th3;
            }
        } catch (Throwable th4) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th4;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zIsDefaultProcess;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        try {
            workManagerImpl.mConfiguration.getClass();
            boolean zIsEmpty = TextUtils.isEmpty(null);
            Context context = this.mContext;
            if (zIsEmpty) {
                SystemClock.get().getClass();
                zIsDefaultProcess = true;
            } else {
                zIsDefaultProcess = ProcessUtils.isDefaultProcess(context);
                SystemClock.get().getClass();
            }
            if (!zIsDefaultProcess) {
                workManagerImpl.onForceStopRunnableCompleted();
                return;
            }
            while (true) {
                try {
                    CloseableKt.migrateDatabase(context);
                    SystemClock.get().getClass();
                    try {
                        forceStopRunnable();
                        workManagerImpl.onForceStopRunnableCompleted();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e) {
                        int i = this.mRetryCount + 1;
                        this.mRetryCount = i;
                        if (i >= 3) {
                            String strDecode = UserManagerCompat$Api24Impl.isUserUnlocked(context) ? C0000.decode(new byte[]{50, 9, 83, 21, 87, 94, 10, 92, 69, 21, 31, 18, 66, 80, 92, 23, 9, 87, 69, 18, 14, 4, 22, 81, 84, 65, 15, 90, 0, 70, 15, 18, 22, 92, 95, 23, 7, 25, 7, 7, 2, 65, 69, 65, 80, 67, 3, 23, 69, 49, 9, 19, 93, 120, 80, 89, 7, 94, 0, 20, 70, 2, 87, 91, 95, 88, 18, 25, 4, 5, 5, 4, 69, 70, 17, 67, 14, 92, 69, 7, 22, 17, 17, 70, 17, 94, 8, 77, 0, 20, 8, 0, 90, 21, 85, 86, 18, 88, 69, 21, 18, 14, 68, 80, 31}, "fa6517f9ef", 0) : C0000.decode(new byte[]{50, 10, 71, 89, 43, 4, 92, 85, 80, 93, 67, 16, 7, 88, 86, 69, 17, 69, 87, 87, 70, 4, 81, 87, 82, 75, 66, 85, 0, 25, 94, 16, 10, 8, 21, 86, 15, 23, 87, 87, 67, 24, 83, 95, 11, 77, 20, 66, 7, 0, 86, 83, 19, 22, 87, 20, 84, 74, 84, 84, 1, 87, 76, 11, 4, 9, 21, 87, 8, 6, 64, 77, 71, 76, 84, 84, 68, 74, 76, 13, 23, 4, 82, 87, 70, 12, 65, 90, 16, 76, 17, 81, 7, 90, 93, 17, 22, 12, 87, 94, 3, 75, 56, 112, 88, 86, 22, 68, 68, 88, 91, 1, 0, 22, 70, 18, 9, 23, 18, 93, 89, 81, 69, 89, 5, 85, 81, 17, 0, 69, 98, 93, 20, 14, 127, 85, 89, 89, 86, 85, 22, 25, 94, 16, 10, 8, 21, 86, 15, 23, 87, 87, 67, 121, 70, 81, 22, 92, 24, 1, 10, 8, 69, 93, 8, 0, 92, 64, 68, 22, 17, 99, 1, 92, 24, 10, 17, 17, 69, 65, 92, 74, 29, 80, 82, 78, 84, 92, 11, 73, 93, 16, 75, 4, 91, 86, 20, 10, 91, 80, 25, 91, 94, 93, 75, 77, 74, 3, 12, 11, 92, 92, 1, 74, 83, 70, 67, 81, 82, 92, 1, 74, 23, 6, 12, 23, 80, 81, 18, 72, 80, 91, 88, 76}, "ee52fe247810d98b", false);
                            SystemClock.get().getClass();
                            IllegalStateException illegalStateException = new IllegalStateException(strDecode, e);
                            workManagerImpl.mConfiguration.getClass();
                            throw illegalStateException;
                        }
                        SystemClock.get().getClass();
                        try {
                            Thread.sleep(((long) this.mRetryCount) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e2) {
                    String strDecode2 = C0000.decode(new byte[]{108, 88, 87, 25, 71, 7, 85, 70, 6, 1, 18, 55, 103, 46, 80, 66, 87, 65, 82, 26, 85, 87, 19, 17, 91, 11, 88, 66, 93, 67, 64, 8, 89, 5, 22, 95, 10, 2, 64, 5, 66, 11, 86, 88, 65}, "962a7b62ce2d6b", false);
                    SystemClock.get().getClass();
                    IllegalStateException illegalStateException2 = new IllegalStateException(strDecode2, e2);
                    workManagerImpl.mConfiguration.getClass();
                    throw illegalStateException2;
                }
            }
        } catch (Throwable th) {
            workManagerImpl.onForceStopRunnableCompleted();
            throw th;
        }
    }
}
