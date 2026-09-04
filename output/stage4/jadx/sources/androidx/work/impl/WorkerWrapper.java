package androidx.work.impl;

import android.content.Context;
import android.database.Cursor;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.InputMergerKt;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.WorkerFactory$1;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import okhttp3.Dispatcher;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkerWrapper implements Runnable {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Context mAppContext;
    public final SystemClock mClock;
    public final Configuration mConfiguration;
    public final Api mDependencyDao;
    public final Processor mForegroundProcessor;
    public final ArrayList mTags;
    public final WorkDatabase mWorkDatabase;
    public String mWorkDescription;
    public final WorkSpec mWorkSpec;
    public final WorkSpecDao_Impl mWorkSpecDao;
    public final String mWorkSpecId;
    public final Dispatcher mWorkTaskExecutor;
    public ListenableWorker mWorker;
    public ListenableWorker.Result mResult = new ListenableWorker.Result.Failure();
    public final SettableFuture mFuture = new SettableFuture();
    public final SettableFuture mWorkerResultFuture = new SettableFuture();
    public volatile int mInterrupted = -256;

    public final class Builder implements Factory {
        public Object mAppContext;
        public Object mConfiguration;
        public Object mForegroundProcessor;
        public Object mTags;
        public Object mWorkDatabase;
        public Object mWorkSpec;
        public Object mWorkTaskExecutor;

        @Override // javax.inject.Provider
        public Object get() {
            return new Uploader((Context) ((Provider) this.mAppContext).get(), (MetadataBackendRegistry) ((Provider) this.mForegroundProcessor).get(), (EventStore) ((Provider) this.mWorkTaskExecutor).get(), (WorkTagDao_Impl) ((zzac) this.mConfiguration).get(), (Executor) ((Provider) this.mWorkDatabase).get(), (SynchronizationGuard) ((Provider) this.mWorkSpec).get(), new ProfileInstaller$2(), new ByteString.Companion(), (ClientHealthMetricsStore) ((Provider) this.mTags).get());
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{52, 14, 69, 95, 80, 75, 111, 20, 82, 70, 67, 85, 22}, "ca74598f3630d4"));
    }

    public WorkerWrapper(Builder builder) {
        this.mAppContext = (Context) builder.mAppContext;
        this.mWorkTaskExecutor = (Dispatcher) builder.mWorkTaskExecutor;
        this.mForegroundProcessor = (Processor) builder.mForegroundProcessor;
        WorkSpec workSpec = (WorkSpec) builder.mWorkSpec;
        this.mWorkSpec = workSpec;
        this.mWorkSpecId = workSpec.id;
        this.mWorker = null;
        Configuration configuration = (Configuration) builder.mConfiguration;
        this.mConfiguration = configuration;
        this.mClock = (SystemClock) configuration.clock;
        WorkDatabase workDatabase = (WorkDatabase) builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = workDatabase.dependencyDao();
        this.mTags = (ArrayList) builder.mTags;
    }

    public final void handleResult(ListenableWorker.Result result) {
        boolean z = result instanceof ListenableWorker.Result.Success;
        WorkSpec workSpec = this.mWorkSpec;
        if (!z) {
            if (result instanceof ListenableWorker.Result.Retry) {
                SystemClock.get().getClass();
                rescheduleAndResolve();
                return;
            }
            SystemClock.get().getClass();
            if (workSpec.isPeriodic()) {
                resetPeriodicAndResolve();
                return;
            } else {
                setFailedAndResolve();
                return;
            }
        }
        SystemClock.get().getClass();
        if (workSpec.isPeriodic()) {
            resetPeriodicAndResolve();
            return;
        }
        Api api = this.mDependencyDao;
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setState(str, 3);
            workSpecDao_Impl.setOutput(str, ((ListenableWorker.Result.Success) this.mResult).mOutputData);
            this.mClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList dependentWorkIds = api.getDependentWorkIds(str);
            int size = dependentWorkIds.size();
            int i = 0;
            while (i < size) {
                Object obj = dependentWorkIds.get(i);
                i++;
                String str2 = (String) obj;
                if (workSpecDao_Impl.getState(str2) == 5) {
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) api.zaa;
                    RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{98, 38, 46, 36, 114, 50, 67, 114, 126, 54, 44, 53, 25, 76, 74, 12, 1, 67, 36, 51, 126, 43, 67, 85, 84, 19, 7, 15, 85, 3, 13, 82, 72, 67, 53, 41, 116, 52, 38, 17, 70, 12, 16, 10, 110, 21, 19, 84, 82, 60, 11, 5, 12, 89, 67, 112, 127, 39, 66, 17, 67, 3, 17, 84, 64, 22, 11, 18, 88, 18, 6, 110, 88, 7, 66, 40, 127, 70, 75, 98, 116, 47, 39, 34, 101, 70, 10, 85, 17, 37, 48, 46, 124, 70, 20, 94, 67, 8, 17, 17, 84, 5, 67, 102, 121, 38, 48, 36, 17, 21, 23, 80, 69, 6, 67, 92, 3, 79}, "1cba1fc1"), 1);
                    if (str2 == null) {
                        roomSQLiteQueryAcquire.bindNull(1);
                    } else {
                        roomSQLiteQueryAcquire.bindString(str2, 1);
                    }
                    workDatabase_Impl.assertNotSuspendingTransaction();
                    Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                    try {
                        boolean z2 = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        if (z2) {
                            SystemClock.get().getClass();
                            workSpecDao_Impl.setState(str2, 1);
                            workSpecDao_Impl.setLastEnqueueTime(jCurrentTimeMillis, str2);
                        }
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            resolve(false);
        } catch (Throwable th2) {
            workDatabase.internalEndTransaction();
            resolve(false);
            throw th2;
        }
    }

    public final void onWorkFinished() {
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        this.mWorkDatabase.beginTransaction();
        try {
            int state = this.mWorkSpecDao.getState(this.mWorkSpecId);
            this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
            if (state == 0) {
                resolve(false);
            } else if (state == 2) {
                handleResult(this.mResult);
            } else if (!NetworkType$EnumUnboxingLocalUtility._isFinished(state)) {
                this.mInterrupted = -512;
                rescheduleAndResolve();
            }
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.internalEndTransaction();
        }
    }

    public final void rescheduleAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setState(str, 1);
            this.mClock.getClass();
            workSpecDao_Impl.setLastEnqueueTime(System.currentTimeMillis(), str);
            workSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride(str, this.mWorkSpec.nextScheduleTimeOverrideGeneration);
            workSpecDao_Impl.markWorkSpecScheduled(-1L, str);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.internalEndTransaction();
            resolve(true);
        }
    }

    public final void resetPeriodicAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            this.mClock.getClass();
            workSpecDao_Impl.setLastEnqueueTime(System.currentTimeMillis(), str);
            WorkDatabase_Impl workDatabase_Impl = workSpecDao_Impl.__db;
            workSpecDao_Impl.setState(str, 1);
            workDatabase_Impl.assertNotSuspendingTransaction();
            WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_Impl.__preparedStmtOfResetWorkSpecRunAttemptCount;
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
                workDatabase_Impl.internalEndTransaction();
                anonymousClass2.release(frameworkSQLiteStatementAcquire);
                workSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride(str, this.mWorkSpec.nextScheduleTimeOverrideGeneration);
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkTagDao_Impl.AnonymousClass2 anonymousClass3 = workSpecDao_Impl.__preparedStmtOfIncrementPeriodCount;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire2 = anonymousClass3.acquire();
                if (str == null) {
                    frameworkSQLiteStatementAcquire2.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire2.bindString(str, 1);
                }
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire2.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.internalEndTransaction();
                    anonymousClass3.release(frameworkSQLiteStatementAcquire2);
                    workSpecDao_Impl.markWorkSpecScheduled(-1L, str);
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                    resolve(false);
                } catch (Throwable th) {
                    workDatabase_Impl.internalEndTransaction();
                    anonymousClass3.release(frameworkSQLiteStatementAcquire2);
                    throw th;
                }
            } catch (Throwable th2) {
                workDatabase_Impl.internalEndTransaction();
                anonymousClass2.release(frameworkSQLiteStatementAcquire);
                throw th2;
            }
        } catch (Throwable th3) {
            workDatabase.internalEndTransaction();
            resolve(false);
            throw th3;
        }
    }

    public final void resolve(boolean z) {
        this.mWorkDatabase.beginTransaction();
        try {
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = this.mWorkDatabase.workSpecDao();
            workSpecDao_ImplWorkSpecDao.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{102, 36, 117, 35, 33, 108, 23, 32, 125, 101, 123, 50, 24, 28, 72, 16, 11, 65, 9, 70, 36, 106, 120, 46, 18, 71, 90, 20, 91, 69, 17, 85, 86, 65, 110, 46, 39, 106, 114, 67, 65, 68, 84, 18, 85, 22, 47, 127, 97, 65, 112, 40, 66, 16, 5, 79, 18, 3, 25, 70, 5, 31, 65, 124, 124, 44, 112, 50, 66, 9}, "5a9fb87c205f06a0"), 0);
            WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
            workDatabase_Impl.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
            try {
                boolean z2 = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                if (!z2) {
                    PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
                }
                if (z) {
                    this.mWorkSpecDao.setState(this.mWorkSpecId, 1);
                    this.mWorkSpecDao.setStopReason(this.mWorkSpecId, this.mInterrupted);
                    this.mWorkSpecDao.markWorkSpecScheduled(-1L, this.mWorkSpecId);
                }
                this.mWorkDatabase.setTransactionSuccessful();
                this.mWorkDatabase.internalEndTransaction();
                this.mFuture.set(Boolean.valueOf(z));
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWorkDatabase.internalEndTransaction();
            throw th2;
        }
    }

    public final void resolveIncorrectStatus() {
        if (this.mWorkSpecDao.getState(this.mWorkSpecId) == 2) {
            SystemClock.get().getClass();
            resolve(true);
        } else {
            SystemClock.get().getClass();
            resolve(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00c8 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:13:0x009b, B:16:0x00a1, B:21:0x00b5, B:23:0x00bb, B:25:0x00bf, B:35:0x00ea, B:30:0x00c8, B:32:0x00d9), top: B:101:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d9 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #0 {all -> 0x00b2, blocks: (B:13:0x009b, B:16:0x00a1, B:21:0x00b5, B:23:0x00bb, B:25:0x00bf, B:35:0x00ea, B:30:0x00c8, B:32:0x00d9), top: B:101:0x009b }] */
    @Override // java.lang.Runnable
    public final void run() {
        InputMerger inputMerger;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{52, 89, 75, 93, 69, 105, 69, 81, 82, 95}, "c696e2e86b01f7", 0.0f));
        String str = this.mWorkSpecId;
        sb.append(str);
        sb.append(C0000.decode(new byte[]{72, 25, 22, 4, 94, 22, 94, 25, 23}, "d9be9ecb77b5d0", 0.0f));
        ArrayList arrayList = this.mTags;
        int size = arrayList.size();
        boolean z = false;
        int i = 1;
        int i2 = 0;
        boolean z2 = true;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str2 = (String) obj;
            if (z2) {
                z2 = false;
            } else {
                sb.append(C0000.decode(new byte[]{77, 23}, "a7a9acc221d5b591"));
            }
            sb.append(str2);
        }
        sb.append(C0000.decode(new byte[]{67, 69, 69, 63}, "c8eb6b78ac", 7));
        this.mWorkDescription = sb.toString();
        WorkSpec workSpec = this.mWorkSpec;
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            int i3 = workSpec.state;
            Data dataMerge = workSpec.input;
            if (i3 != 1) {
                resolveIncorrectStatus();
                workDatabase.setTransactionSuccessful();
                SystemClock.get().getClass();
                workDatabase.internalEndTransaction();
                return;
            }
            if (workSpec.isPeriodic()) {
                this.mClock.getClass();
                if (System.currentTimeMillis() < workSpec.calculateNextRunTime()) {
                    SystemClock.get().getClass();
                    resolve(true);
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                    return;
                }
            } else {
                if (workSpec.state == 1 && workSpec.runAttemptCount > 0) {
                    this.mClock.getClass();
                    if (System.currentTimeMillis() < workSpec.calculateNextRunTime()) {
                        SystemClock.get().getClass();
                        resolve(true);
                        workDatabase.setTransactionSuccessful();
                        workDatabase.internalEndTransaction();
                        return;
                    }
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            boolean zIsPeriodic = workSpec.isPeriodic();
            WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
            Configuration configuration = this.mConfiguration;
            if (!zIsPeriodic) {
                SystemClock systemClock = (SystemClock) configuration.inputMergerFactory;
                String str3 = workSpec.inputMergerClassName;
                systemClock.getClass();
                int i4 = InputMergerKt.$r8$clinit;
                try {
                    inputMerger = (InputMerger) Class.forName(str3).getDeclaredConstructor(null).newInstance(null);
                } catch (Exception unused) {
                    SystemClock.get().getClass();
                    inputMerger = null;
                }
                if (inputMerger == null) {
                    SystemClock.get().getClass();
                    setFailedAndResolve();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(dataMerge);
                WorkDatabase_Impl workDatabase_Impl = workSpecDao_Impl.__db;
                RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{53, 33, 126, 36, 39, 97, 66, 95, 19, 16, 66, 20, 16, 21, 36, 98, 41, 41, 18, 22, 11, 71, 9, 67, 22, 1, 81, 65, 51, 125, 39, 98, 35, 68, 91, 5, 68, 124, 44, 58, 70, 68, 18, 65, 68, 21, 66, 16, 70, 68, 18, 65, 68, 29, 49, 117, 42, 33, 113, 53, 68, 69, 16, 85, 20, 1, 67, 20, 13, 70, 11, 68, 3, 59, 91, 5, 68, 115, 48, 127, 43, 68, 86, 4, 20, 80, 12, 84, 3, 10, 81, 24, 68, 98, 42, 117, 52, 33, 18, 22, 11, 71, 9, 111, 21, 20, 87, 2, 59, 92, 6, 13, 89, 77}, "fd2ad5b0", 0.0f), 1);
                if (str == null) {
                    roomSQLiteQueryAcquire.bindNull(1);
                } else {
                    roomSQLiteQueryAcquire.bindString(str, 1);
                }
                workDatabase_Impl.assertNotSuspendingTransaction();
                Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                try {
                    ArrayList arrayList3 = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList3.add(Data.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    arrayList2.addAll(arrayList3);
                    dataMerge = inputMerger.merge(arrayList2);
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
            UUID uuidFromString = UUID.fromString(str);
            ExecutorService executorService = (ExecutorService) configuration.executor;
            WorkerFactory$1 workerFactory$1 = (WorkerFactory$1) configuration.workerFactory;
            Processor processor = this.mForegroundProcessor;
            Dispatcher dispatcher = this.mWorkTaskExecutor;
            WorkForegroundUpdater workForegroundUpdater = new WorkForegroundUpdater(workDatabase, processor, dispatcher);
            WorkerParameters workerParameters = new WorkerParameters();
            workerParameters.mId = uuidFromString;
            workerParameters.mInputData = dataMerge;
            new HashSet(arrayList);
            workerParameters.mBackgroundExecutor = executorService;
            workerParameters.mWorkTaskExecutor = dispatcher;
            workerParameters.mWorkerFactory = workerFactory$1;
            if (this.mWorker == null) {
                String str4 = workSpec.workerClassName;
                workerFactory$1.getClass();
                this.mWorker = WorkerFactory$1.createWorkerWithDefaultFallback(this.mAppContext, str4, workerParameters);
            }
            ListenableWorker listenableWorker = this.mWorker;
            if (listenableWorker == null) {
                SystemClock.get().getClass();
                setFailedAndResolve();
                return;
            }
            if (listenableWorker.mUsed) {
                SystemClock.get().getClass();
                setFailedAndResolve();
                return;
            }
            listenableWorker.mUsed = true;
            workDatabase.beginTransaction();
            try {
                if (workSpecDao_Impl.getState(str) == 1) {
                    workSpecDao_Impl.setState(str, 2);
                    WorkDatabase_Impl workDatabase_Impl2 = workSpecDao_Impl.__db;
                    workDatabase_Impl2.assertNotSuspendingTransaction();
                    WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_Impl.__preparedStmtOfIncrementWorkSpecRunAttemptCount;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                    if (str == null) {
                        frameworkSQLiteStatementAcquire.bindNull(1);
                    } else {
                        frameworkSQLiteStatementAcquire.bindString(str, 1);
                    }
                    workDatabase_Impl2.beginTransaction();
                    try {
                        frameworkSQLiteStatementAcquire.executeUpdateDelete();
                        workDatabase_Impl2.setTransactionSuccessful();
                        workDatabase_Impl2.internalEndTransaction();
                        anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        workSpecDao_Impl.setStopReason(str, -256);
                        z = true;
                    } catch (Throwable th2) {
                        workDatabase_Impl2.internalEndTransaction();
                        anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        throw th2;
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.internalEndTransaction();
                if (!z) {
                    resolveIncorrectStatus();
                    return;
                }
                if (tryCheckForInterruptionAndResolve()) {
                    return;
                }
                WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workForegroundUpdater, this.mWorkTaskExecutor);
                ((zzu) dispatcher.runningSyncCalls).execute(workForegroundRunnable);
                SettableFuture settableFuture = workForegroundRunnable.mFuture;
                Processor$$ExternalSyntheticLambda2 processor$$ExternalSyntheticLambda2 = new Processor$$ExternalSyntheticLambda2(this, i, settableFuture);
                zzt zztVar = new zzt(1);
                SettableFuture settableFuture2 = this.mWorkerResultFuture;
                settableFuture2.addListener(processor$$ExternalSyntheticLambda2, zztVar);
                settableFuture.addListener(new Worker.AnonymousClass2(this, i, settableFuture), (zzu) dispatcher.runningSyncCalls);
                settableFuture2.addListener(new Worker.AnonymousClass1(this, this.mWorkDescription), (SerialExecutorImpl) dispatcher.executorServiceOrNull);
            } catch (Throwable th3) {
                workDatabase.internalEndTransaction();
                throw th3;
            }
        } catch (Throwable th4) {
            workDatabase.internalEndTransaction();
            throw th4;
        }
    }

    public final void setFailedAndResolve() {
        String str = this.mWorkSpecId;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
                if (zIsEmpty) {
                    Data data = ((ListenableWorker.Result.Failure) this.mResult).mOutputData;
                    workSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride(str, this.mWorkSpec.nextScheduleTimeOverrideGeneration);
                    workSpecDao_Impl.setOutput(str, data);
                    workDatabase.setTransactionSuccessful();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (workSpecDao_Impl.getState(str2) != 6) {
                    workSpecDao_Impl.setState(str2, 4);
                }
                linkedList.addAll(this.mDependencyDao.getDependentWorkIds(str2));
            }
        } finally {
            workDatabase.internalEndTransaction();
            resolve(false);
        }
    }

    public final boolean tryCheckForInterruptionAndResolve() {
        if (this.mInterrupted == -256) {
            return false;
        }
        SystemClock.get().getClass();
        int state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == 0) {
            resolve(false);
            return true;
        }
        resolve(!NetworkType$EnumUnboxingLocalUtility._isFinished(state));
        return true;
    }
}
