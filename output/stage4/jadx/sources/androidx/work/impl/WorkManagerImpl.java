package androidx.work.impl;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.SystemClock;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.SerialExecutorImpl;
import com.google.firebase.messaging.ServiceStarter;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.CloseableKt;
import okhttp3.Dispatcher;
import okhttp3.internal.connection.RealConnection$connectTls$1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkManagerImpl extends CloseableKt {
    public static WorkManagerImpl sDefaultInstance;
    public static WorkManagerImpl sDelegatedInstance;
    public static final Object sLock;
    public final Configuration mConfiguration;
    public final Context mContext;
    public boolean mForceStopRunnableCompleted = false;
    public final IdGenerator mPreferenceUtils;
    public final Processor mProcessor;
    public BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    public final List mSchedulers;
    public final ServiceStarter mTrackers;
    public final WorkDatabase mWorkDatabase;
    public final Dispatcher mWorkTaskExecutor;

    public abstract class Api24Impl {
        public static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{99, 87, 69, 9, 123, 2, 10, 87, 6, 7, 16, 124, 89, 72, 91}, "487b6cd6abb5", false));
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public WorkManagerImpl(Context context, final Configuration configuration, Dispatcher dispatcher, final WorkDatabase workDatabase, final List list, Processor processor, ServiceStarter serviceStarter) {
        Context applicationContext = context.getApplicationContext();
        if (Api24Impl.isDeviceProtectedStorage(applicationContext)) {
            throw new IllegalStateException(C0000.decode(new byte[]{122, 81, 93, 91, 91, 66, 17, 81, 87, 89, 71, 92, 85, 90, 88, 66, 92, 16, 100, 90, 70, 93, 124, 89, 87, 81, 84, 80, 70, 22, 88, 86, 25, 84, 90, 71, 81, 85, 69, 24, 91, 95, 92, 65, 20, 91, 94, 92, 92}, "90354618"));
        }
        SystemClock systemClock = new SystemClock();
        synchronized (SystemClock.sLock) {
            SystemClock.sLogger = systemClock;
        }
        this.mContext = applicationContext;
        this.mWorkTaskExecutor = dispatcher;
        this.mWorkDatabase = workDatabase;
        this.mProcessor = processor;
        this.mTrackers = serviceStarter;
        this.mConfiguration = configuration;
        this.mSchedulers = list;
        this.mPreferenceUtils = new IdGenerator(workDatabase);
        final SerialExecutorImpl serialExecutorImpl = (SerialExecutorImpl) dispatcher.executorServiceOrNull;
        int i = Schedulers.$r8$clinit;
        processor.addExecutionListener(new ExecutionListener() { // from class: androidx.work.impl.Schedulers$$ExternalSyntheticLambda0
            @Override // androidx.work.impl.ExecutionListener
            public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
                serialExecutorImpl.execute(new Schedulers$$ExternalSyntheticLambda1(list, workGenerationalId, configuration, workDatabase, 0));
            }
        });
        dispatcher.executeOnTaskThread(new ForceStopRunnable(applicationContext, this));
    }

    public static WorkManagerImpl getInstance$1(Context context) {
        WorkManagerImpl workManagerImpl;
        Object obj = sLock;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    try {
                        workManagerImpl = sDelegatedInstance;
                        if (workManagerImpl == null) {
                            workManagerImpl = sDefaultInstance;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return workManagerImpl;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (workManagerImpl != null) {
            return workManagerImpl;
        }
        context.getApplicationContext();
        throw new IllegalStateException(C0000.decode(new byte[]{98, 90, 67, 82, 124, 83, 95, 84, 95, 83, 20, 20, 89, 68, 16, 95, 90, 65, 17, 80, 95, 91, 69, 92, 89, 90, 15, 78, 85, 83, 16, 65, 71, 90, 65, 92, 67, 94, 72, 27, 24, 22, 63, 91, 69, 23, 88, 80, 67, 80, 17, 92, 73, 66, 93, 92, 91, 95, 18, 88, 73, 23, 84, 88, 70, 84, 83, 85, 84, 86, 17, 98, 87, 68, 13, 121, 81, 89, 81, 86, 80, 71, 120, 87, 88, 70, 88, 84, 84, 95, 28, 81, 66, 23, 89, 95, 21, 76, 94, 76, 67, 18, 92, 84, 86, 95, 0, 81, 67, 67, 28, 17, 93, 84, 71, 92, 17, 92, 94, 65, 24, 91, 7, 90, 69, 86, 92, 93, 76, 21, 82, 88, 93, 94, 84, 81, 24, 97, 9, 70, 91, 122, 81, 95, 84, 82, 84, 75, 18, 91, 95, 92, 76, 95, 7, 88, 89, 77, 85, 17, 84, 65, 17, 77, 89, 91, 66, 21, 72, 89, 15, 90, 68, 27, 16, 80, 91, 81, 17, 64, 94, 71, 67, 21, 121, 70, 22, 88, 89, 84, 81, 69, 92, 90, 95, 25, 85, 93, 84, 70, 24, 88, 9, 64, 16, 94, 93, 65, 89, 80, 92, 92, 95, 70, 17, 118, 87, 88, 0, 93, 87, 66, 66, 80, 65, 92, 94, 87, 31, 98, 67, 90, 78, 95, 2, 81, 66, 25}, "5519121586f40701", 0));
    }

    public final Operation enqueueUniquePeriodicWork(PeriodicWorkRequest periodicWorkRequest) {
        OperationImpl operationImpl = new OperationImpl();
        ((SerialExecutorImpl) this.mWorkTaskExecutor.executorServiceOrNull).execute(new Schedulers$$ExternalSyntheticLambda1(this, operationImpl, new RealConnection$connectTls$1(periodicWorkRequest, this, operationImpl, 1), periodicWorkRequest, 1));
        return operationImpl;
    }

    public final void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void rescheduleEligibleWork() {
        ArrayList pendingJobs;
        int i = SystemJobScheduler.$r8$clinit;
        String strDecode = C0000.decode(new byte[]{83, 93, 3, 16, 2, 11, 85, 5, 17, 84, 92, 64}, "92acac0ad8", 0.0f);
        Context context = this.mContext;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(strDecode);
        if (jobScheduler != null && (pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            int size = pendingJobs.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = pendingJobs.get(i2);
                i2++;
                SystemJobScheduler.cancelJobById(jobScheduler, ((JobInfo) obj).getId());
            }
        }
        WorkDatabase workDatabase = this.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_ImplWorkSpecDao.__preparedStmtOfResetScheduledState;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
            Schedulers.schedule(this.mConfiguration, workDatabase, this.mSchedulers);
        } catch (Throwable th) {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
            throw th;
        }
    }
}
