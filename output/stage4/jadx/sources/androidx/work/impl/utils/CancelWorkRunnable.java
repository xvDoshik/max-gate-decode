package androidx.work.impl.utils;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.SystemClock;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    public final OperationImpl mOperation = new OperationImpl();

    /* JADX INFO: renamed from: androidx.work.impl.utils.CancelWorkRunnable$1, reason: invalid class name */
    public final class AnonymousClass1 extends CancelWorkRunnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$id;
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public /* synthetic */ AnonymousClass1(WorkManagerImpl workManagerImpl, Object obj, int i) {
            this.$r8$classId = i;
            this.val$workManagerImpl = workManagerImpl;
            this.val$id = obj;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        public final void runInternal() {
            switch (this.$r8$classId) {
                case 0:
                    WorkManagerImpl workManagerImpl = this.val$workManagerImpl;
                    WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        CancelWorkRunnable.cancel(workManagerImpl, ((UUID) this.val$id).toString());
                        workDatabase.setTransactionSuccessful();
                        workDatabase.internalEndTransaction();
                        Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                        return;
                    } catch (Throwable th) {
                        workDatabase.internalEndTransaction();
                        throw th;
                    }
                default:
                    WorkManagerImpl workManagerImpl2 = this.val$workManagerImpl;
                    WorkDatabase workDatabase2 = workManagerImpl2.mWorkDatabase;
                    workDatabase2.beginTransaction();
                    try {
                        ArrayList unfinishedWorkWithName = workDatabase2.workSpecDao().getUnfinishedWorkWithName((String) this.val$id);
                        int size = unfinishedWorkWithName.size();
                        int i = 0;
                        while (i < size) {
                            Object obj = unfinishedWorkWithName.get(i);
                            i++;
                            CancelWorkRunnable.cancel(workManagerImpl2, (String) obj);
                        }
                        workDatabase2.setTransactionSuccessful();
                        return;
                    } finally {
                        workDatabase2.internalEndTransaction();
                    }
            }
        }
    }

    public static void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        Api apiDependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int state = workSpecDao_ImplWorkSpecDao.getState(str2);
            if (state != 3 && state != 4) {
                WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_ImplWorkSpecDao.__preparedStmtOfSetCancelledState;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                if (str2 == null) {
                    frameworkSQLiteStatementAcquire.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire.bindString(str2, 1);
                }
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.internalEndTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                } catch (Throwable th) {
                    workDatabase_Impl.internalEndTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    throw th;
                }
            }
            linkedList.addAll(apiDependencyDao.getDependentWorkIds(str2));
        }
        Processor processor = workManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            SystemClock.get().getClass();
            processor.mCancelledIds.add(str);
            workerWrapperCleanUpWorkerUnsafe = processor.cleanUpWorkerUnsafe(str);
        }
        Processor.interrupt(workerWrapperCleanUpWorkerUnsafe, 1);
        Iterator it = workManagerImpl.mSchedulers.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(str);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        OperationImpl operationImpl = this.mOperation;
        try {
            runInternal();
            operationImpl.markState(Operation.SUCCESS);
        } catch (Throwable th) {
            operationImpl.markState(new Operation$State$FAILURE(th));
        }
    }

    public abstract void runInternal();
}
