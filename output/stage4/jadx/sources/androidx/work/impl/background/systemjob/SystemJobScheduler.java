package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.tracing.Trace;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.SystemClock;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemJobScheduler implements Scheduler {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Configuration mConfiguration;
    public final Context mContext;
    public final JobScheduler mJobScheduler;
    public final SystemJobInfoConverter mSystemJobInfoConverter;
    public final WorkDatabase mWorkDatabase;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{99, 77, 64, 64, 0, 90, 115, 9, 6, 50, 5, 88, 80, 85, 77, 85, 85, 70}, "0434e79fdaf05189", 0.0f));
    }

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(C0000.decode(new byte[]{88, 14, 91, 21, 84, 80, 92, 2, 22, 9, 80, 66}, "2a9f789fce50", false));
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context, (SystemClock) configuration.clock);
        this.mContext = context;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
        this.mWorkDatabase = workDatabase;
        this.mConfiguration = configuration;
    }

    public static void cancelJobById(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable unused) {
            SystemClock systemClock = SystemClock.get();
            String.format(Locale.getDefault(), C0000.decode(new byte[]{33, 78, 82, 4, 70, 23, 11, 87, 12, 16, 19, 94, 88, 13, 83, 67, 22, 74, 27, 89, 10, 81, 17, 21, 89, 67, 1, 89, 12, 83, 1, 90, 17, 11, 89, 1, 66, 16, 71, 84, 77}, "d61a6cb8b0", 4), Integer.valueOf(i));
            systemClock.getClass();
        }
    }

    public static ArrayList getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable unused) {
            SystemClock.get().getClass();
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo jobInfo) {
        String strDecode = C0000.decode(new byte[]{124, 107, 102, 52, 118, 57, 96, 42, 52, 126, 102, 96, 98, 35, 116, 57, 126, 33}, "932f7f7ef5", 0.0f);
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey(strDecode)) {
                return null;
            }
            return new WorkGenerationalId(extras.getString(strDecode), extras.getInt(C0000.decode(new byte[]{39, 57, 50, 96, 37, 103, 100, 118, 99, 120, 61, 99, 54, 118, 33, 62, 33, 119, 42, 125, 97, 120, 101, 122, 45, 126}, "baf2d83913b0f3"), 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String str) {
        ArrayList arrayList;
        Context context = this.mContext;
        JobScheduler jobScheduler = this.mJobScheduler;
        ArrayList pendingJobs = getPendingJobs(context, jobScheduler);
        int i = 0;
        if (pendingJobs == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            int size = pendingJobs.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = pendingJobs.get(i2);
                i2++;
                JobInfo jobInfo = (JobInfo) obj;
                WorkGenerationalId workGenerationalIdFromJobInfo = getWorkGenerationalIdFromJobInfo(jobInfo);
                if (workGenerationalIdFromJobInfo != null && str.equals(workGenerationalIdFromJobInfo.workSpecId)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            cancelJobById(jobScheduler, ((Integer) obj2).intValue());
        }
        Dispatcher dispatcherSystemIdInfoDao = this.mWorkDatabase.systemIdInfoDao();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) dispatcherSystemIdInfoDao.executorServiceOrNull;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = (WorkTagDao_Impl.AnonymousClass2) dispatcherSystemIdInfoDao.runningSyncCalls;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecArr) {
        int iIntValue;
        Configuration configuration = this.mConfiguration;
        WorkDatabase workDatabase = this.mWorkDatabase;
        final IdGenerator idGenerator = new IdGenerator(workDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.id);
                if (workSpec2 != null && workSpec2.state == 1) {
                    WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workSpec);
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workGenerationalIdGenerationalId);
                    if (systemIdInfo != null) {
                        iIntValue = systemIdInfo.systemId;
                    } else {
                        configuration.getClass();
                        final int i = configuration.maxJobSchedulerId;
                        iIntValue = ((Number) idGenerator.workDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda1
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                WorkDatabase workDatabase2 = idGenerator.workDatabase;
                                OperationImpl operationImplPreferenceDao = workDatabase2.preferenceDao();
                                String strDecode = C0000.decode(new byte[]{89, 93, 29, 76, 107, 94, 88, 0, 106, 71, 5, 80, 83, 5, 22, 92, 82, 74, 58, 81, 80}, "78e8447b54f86ac0", true);
                                Long longValue = operationImplPreferenceDao.getLongValue(strDecode);
                                int i2 = 0;
                                int iLongValue = longValue != null ? (int) longValue.longValue() : 0;
                                workDatabase2.preferenceDao().insertPreference(new Preference(strDecode, Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                if (iLongValue < 0 || iLongValue > i) {
                                    workDatabase2.preferenceDao().insertPreference(new Preference(strDecode, Long.valueOf(1)));
                                } else {
                                    i2 = iLongValue;
                                }
                                return Integer.valueOf(i2);
                            }
                        })).intValue();
                    }
                    if (systemIdInfo == null) {
                        workDatabase.systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workGenerationalIdGenerationalId.workSpecId, workGenerationalIdGenerationalId.generation, iIntValue));
                    }
                    scheduleInternal(workSpec, iIntValue);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemClock.get().getClass();
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.internalEndTransaction();
            } catch (Throwable th) {
                workDatabase.internalEndTransaction();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Switch 'out' block B:20:0x007b for B:16:0x0073 already processed. Defaulting to fallback option. */
    public final void scheduleInternal(WorkSpec workSpec, int i) {
        int i2;
        JobScheduler jobScheduler = this.mJobScheduler;
        SystemJobInfoConverter systemJobInfoConverter = this.mSystemJobInfoConverter;
        systemJobInfoConverter.getClass();
        Constraints constraints = workSpec.constraints;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.id);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", workSpec.generation);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
        JobInfo.Builder builder = new JobInfo.Builder(i, systemJobInfoConverter.mWorkServiceComponent);
        boolean z = constraints.requiresCharging;
        Set<Constraints.ContentUriTrigger> set = constraints.contentUriTriggers;
        JobInfo.Builder requiresCharging = builder.setRequiresCharging(z);
        boolean z2 = constraints.requiresDeviceIdle;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z2).setExtras(persistableBundle);
        int i3 = constraints.requiredNetworkType;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 30 || i3 != 6) {
            int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(i3);
            if (iOrdinal == 0) {
                i2 = 0;
            } else if (iOrdinal == 1) {
                i2 = 1;
            } else if (iOrdinal != 2) {
                i2 = 3;
                if (iOrdinal != 3) {
                    i2 = 4;
                    if (iOrdinal != 4) {
                        SystemClock systemClock = SystemClock.get();
                        switch (i3) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                systemClock.getClass();
                                i2 = 1;
                                break;
                            default:
                                throw null;
                        }
                    }
                }
            } else {
                i2 = 2;
            }
            extras.setRequiredNetworkType(i2);
        } else {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
        if (!z2) {
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, workSpec.backoffPolicy == 2 ? 0 : 1);
        }
        long jCalculateNextRunTime = workSpec.calculateNextRunTime();
        systemJobInfoConverter.mClock.getClass();
        long jMax = Math.max(jCalculateNextRunTime - System.currentTimeMillis(), 0L);
        if (i4 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!workSpec.expedited) {
            extras.setImportantWhileForeground(true);
        }
        if (!set.isEmpty()) {
            for (Constraints.ContentUriTrigger contentUriTrigger : set) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(contentUriTrigger.uri, contentUriTrigger.isTriggeredForDescendants ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(constraints.contentTriggerUpdateDelayMillis);
            extras.setTriggerContentMaxDelay(constraints.contentTriggerMaxDelayMillis);
        }
        extras.setPersisted(false);
        int i5 = Build.VERSION.SDK_INT;
        extras.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow);
        extras.setRequiresStorageNotLow(constraints.requiresStorageNotLow);
        Object[] objArr = workSpec.runAttemptCount > 0;
        Object[] objArr2 = jMax > 0;
        if (i5 >= 31 && workSpec.expedited && objArr == false && objArr2 == false) {
            extras.setExpedited(true);
        }
        JobInfo jobInfoBuild = extras.build();
        SystemClock.get().getClass();
        try {
            if (jobScheduler.schedule(jobInfoBuild) == 0) {
                SystemClock.get().getClass();
                if (workSpec.expedited && workSpec.outOfQuotaPolicy == 1) {
                    workSpec.expedited = false;
                    SystemClock.get().getClass();
                    scheduleInternal(workSpec, i);
                }
            }
        } catch (IllegalStateException e) {
            ArrayList pendingJobs = getPendingJobs(this.mContext, jobScheduler);
            String str = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(pendingJobs != null ? pendingJobs.size() : 0), Integer.valueOf(this.mWorkDatabase.workSpecDao().getScheduledWork().size()), Integer.valueOf(this.mConfiguration.maxSchedulerLimit));
            SystemClock.get().getClass();
            throw new IllegalStateException(str, e);
        } catch (Throwable unused) {
            SystemClock systemClock2 = SystemClock.get();
            workSpec.toString();
            systemClock2.getClass();
        }
    }
}
