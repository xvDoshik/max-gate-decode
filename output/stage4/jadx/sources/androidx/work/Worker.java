package androidx.work;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.MutableLiveData;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.greedy.DelayedWorkTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import com.base.template.services.GuardianService;
import com.google.android.gms.cloudmessaging.zzn;
import com.google.android.gms.cloudmessaging.zzq;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzd;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzw;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.concurrent.SequentialExecutor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.UnlimitedIoScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Worker extends ListenableWorker {
    public SettableFuture mFuture;

    /* JADX INFO: renamed from: androidx.work.Worker$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        private final void run$com$google$android$gms$tasks$zzg() {
            synchronized (((zzh) this.this$0).zzb) {
                ((OnCanceledListener) ((zzh) this.this$0).zzc).onCanceled();
            }
        }

        public SetBuilder checkUpdatedTable() throws IOException {
            InvalidationTracker invalidationTracker = (InvalidationTracker) this.this$0;
            SetBuilder setBuilder = new SetBuilder();
            Cursor cursorQuery = invalidationTracker.database.query(new Symbol(C0000.decode(new byte[]{49, 125, 117, 115, 37, 100, 66, 18, 25, 112, 52, 127, 47, 24, 75, 89, 9, 93, 61, 76, 88, 84, 10, 85, 61, 85, 86, 82, 15, 86, 11, 91, 88, 66, 15, 95, 12, 103, 85, 89, 1, 16, 53, 112, 124, 100, 35, 16, 11, 86, 79, 87, 10, 89, 6, 89, 77, 83, 2, 16, 95, 24, 8, 13}, "b896f0", true), 1));
            while (cursorQuery.moveToNext()) {
                try {
                    setBuilder.add(Integer.valueOf(cursorQuery.getInt(0)));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            cursorQuery.close();
            SetBuilder setBuilderBuild = ExceptionsKt.build(setBuilder);
            if (setBuilderBuild.backing.isEmpty()) {
                return setBuilderBuild;
            }
            FrameworkSQLiteStatement frameworkSQLiteStatement = ((InvalidationTracker) this.this$0).cleanupStatement;
            String strDecode = C0000.decode(new byte[]{102, 0, 68, 77, 12, 19, 83, 85, 19, 78, 84, 9, 77, 92, 20, 18, 84, 75, 69, 15, 67, 93, 95, 22}, "4e58ea61385e89", 0.0f);
            if (frameworkSQLiteStatement == null) {
                throw new IllegalStateException(strDecode);
            }
            FrameworkSQLiteStatement frameworkSQLiteStatement2 = ((InvalidationTracker) this.this$0).cleanupStatement;
            if (frameworkSQLiteStatement2 == null) {
                throw new IllegalArgumentException(strDecode);
            }
            frameworkSQLiteStatement2.executeUpdateDelete();
            return setBuilderBuild;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object obj;
            Set setCheckUpdatedTable;
            Task taskAwaitTaskToRun;
            long jNanoTime;
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = null;
            switch (this.$r8$classId) {
                case 0:
                    Worker worker = (Worker) this.this$0;
                    try {
                        worker.mFuture.set(worker.doWork());
                        return;
                    } catch (Throwable th) {
                        worker.mFuture.setException(th);
                        return;
                    }
                case 1:
                    try {
                        super/*android.app.Activity*/.onBackPressed();
                        return;
                    } catch (IllegalStateException e) {
                        if (!TextUtils.equals(e.getMessage(), C0000.decode(new byte[]{37, 5, 94, 68, 13, 92, 65, 25, 70, 82, 20, 2, 95, 22, 14, 19, 65, 81, 95, 68, 70, 5, 83, 16, 10, 92, 91, 25, 87, 81, 18, 1, 66, 68, 12, 93, 102, 88, 64, 82, 47, 10, 67, 16, 2, 93, 86, 92, 101, 67, 7, 16, 85}, "fd0dc35967"))) {
                            throw e;
                        }
                        return;
                    } catch (NullPointerException e2) {
                        if (!TextUtils.equals(e2.getMessage(), C0000.decode(new byte[]{34, 76, 67, 82, 9, 19, 70, 23, 23, 95, 70, 95, 94, 68, 12, 83, 82, 23, 18, 10, 64, 67, 22, 81, 10, 22, 93, 87, 23, 80, 88, 83, 68, 68, 83, 89, 7, 66, 9, 95, 84, 28, 12, 75, 25, 127, 5, 13, 86, 91, 6, 66, 70, 87, 94, 86, 17, 87, 94, 83, 74, 2, 66, 71, 77, 118, 20, 87, 87, 95, 6, 86, 67, 127, 11, 16, 70, 116, 2, 92, 10, 84, 81, 81, 8, 22, 80, 82, 16, 43, 83, 89, 7, 92, 3, 68, 24, 27, 68, 24, 88, 89, 68, 2, 18, 89, 22, 92, 10, 22, 95, 80, 9, 93, 84, 67, 68, 17, 87, 81, 6, 66, 3, 88, 83, 87}, "c877dc27c0f602"))) {
                            throw e2;
                        }
                        return;
                    }
                case 2:
                    ((FragmentManagerImpl) this.this$0).execPendingActions();
                    return;
                case 3:
                    FragmentTransition.setViewVisibility((ArrayList) this.this$0, 4);
                    return;
                case 4:
                    synchronized (((MutableLiveData) this.this$0).mDataLock) {
                        obj = ((MutableLiveData) this.this$0).mPendingData;
                        ((MutableLiveData) this.this$0).mPendingData = MutableLiveData.NOT_SET;
                        break;
                    }
                    MutableLiveData mutableLiveData = (MutableLiveData) this.this$0;
                    ArchTaskExecutor.getInstance().mDelegate.getClass();
                    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                        throw new IllegalStateException(C0000.decode(new byte[]{115, 0, 8, 89, 13, 64, 24, 12, 94, 23, 9, 92, 7, 20, 75, 0, 68, 55, 7, 91, 23, 81, 24, 10, 94, 65, 7, 23, 0, 85, 91, 14, 87, 19, 9, 66, 12, 80, 24, 17, 88, 19, 3, 86, 6}, "0af7b48e"));
                    }
                    mutableLiveData.mData = obj;
                    if (mutableLiveData.mDispatchingValue) {
                        mutableLiveData.mDispatchInvalidated = true;
                        return;
                    }
                    mutableLiveData.mDispatchingValue = true;
                    do {
                        mutableLiveData.mDispatchInvalidated = false;
                        SafeIterableMap safeIterableMap = mutableLiveData.mObservers;
                        safeIterableMap.getClass();
                        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = safeIterableMap.new IteratorWithAdditions();
                        safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                        if (iteratorWithAdditions.hasNext()) {
                            throw null;
                        }
                    } while (mutableLiveData.mDispatchInvalidated);
                    mutableLiveData.mDispatchingValue = false;
                    return;
                case 5:
                    ReentrantReadWriteLock.ReadLock lock = ((InvalidationTracker) this.this$0).database.readWriteLock.readLock();
                    lock.lock();
                    try {
                        try {
                            if (((InvalidationTracker) this.this$0).ensureInitialization$room_runtime_release() && ((InvalidationTracker) this.this$0).pendingRefresh.compareAndSet(true, false)) {
                                SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = ((InvalidationTracker) this.this$0).database.internalOpenHelper;
                                if (supportSQLiteOpenHelper2 == null) {
                                    supportSQLiteOpenHelper2 = null;
                                }
                                if (!supportSQLiteOpenHelper2.getWritableDatabase().inTransaction()) {
                                    SupportSQLiteOpenHelper supportSQLiteOpenHelper3 = ((InvalidationTracker) this.this$0).database.internalOpenHelper;
                                    if (supportSQLiteOpenHelper3 != null) {
                                        supportSQLiteOpenHelper = supportSQLiteOpenHelper3;
                                    }
                                    FrameworkSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
                                    writableDatabase.beginTransactionNonExclusive();
                                    try {
                                        setCheckUpdatedTable = checkUpdatedTable();
                                        writableDatabase.setTransactionSuccessful();
                                        writableDatabase.endTransaction();
                                        lock.unlock();
                                        if (setCheckUpdatedTable.isEmpty()) {
                                            return;
                                        }
                                        InvalidationTracker invalidationTracker = (InvalidationTracker) this.this$0;
                                        synchronized (invalidationTracker.observerMap) {
                                            Iterator it = invalidationTracker.observerMap.iterator();
                                            while (true) {
                                                SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) it;
                                                if (ascendingIterator.hasNext()) {
                                                    ((InvalidationTracker.ObserverWrapper) ((Map.Entry) ascendingIterator.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setCheckUpdatedTable);
                                                }
                                            }
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        writableDatabase.endTransaction();
                                        throw th2;
                                    }
                                }
                            }
                            lock.unlock();
                            return;
                        } catch (Throwable th3) {
                            lock.unlock();
                            throw th3;
                        }
                    } catch (SQLiteException unused) {
                        setCheckUpdatedTable = EmptySet.INSTANCE;
                    } catch (IllegalStateException unused2) {
                        setCheckUpdatedTable = EmptySet.INSTANCE;
                    }
                    break;
                case 6:
                    WorkerWrapper workerWrapper = (WorkerWrapper) this.this$0;
                    WorkSpec workSpec = workerWrapper.mWorkSpec;
                    try {
                        ListenableWorker.Result result = (ListenableWorker.Result) workerWrapper.mWorkerResultFuture.get();
                        if (result == null) {
                            SystemClock systemClock = SystemClock.get();
                            int i = WorkerWrapper.$r8$clinit;
                            String str = workSpec.workerClassName;
                            systemClock.getClass();
                        } else {
                            SystemClock systemClock2 = SystemClock.get();
                            int i2 = WorkerWrapper.$r8$clinit;
                            String str2 = workSpec.workerClassName;
                            result.toString();
                            systemClock2.getClass();
                            workerWrapper.mResult = result;
                        }
                        break;
                    } catch (InterruptedException | ExecutionException unused3) {
                        SystemClock systemClock3 = SystemClock.get();
                        int i3 = WorkerWrapper.$r8$clinit;
                        systemClock3.getClass();
                    } catch (CancellationException unused4) {
                        SystemClock systemClock4 = SystemClock.get();
                        int i4 = WorkerWrapper.$r8$clinit;
                        systemClock4.getClass();
                    } finally {
                        workerWrapper.onWorkFinished();
                    }
                    return;
                case 7:
                    GuardianService guardianService = (GuardianService) this.this$0;
                    try {
                        GuardianService.access$checkAndRestart(guardianService);
                        break;
                    } catch (Exception e3) {
                        e3.getMessage();
                    }
                    guardianService.handler.postDelayed(this, 10000L);
                    return;
                case 8:
                    ((TaskCompletionSource) this.this$0).trySetException(new IOException(C0000.decode(new byte[]{53, 45, 44, 118, 42, 103, 96}, "ada3e24fd2e356", false)));
                    return;
                case 9:
                    ((zabq) this.this$0).zaG();
                    return;
                case 10:
                    Api.Client client = ((zabq) ((ConnectionPool) this.this$0).delegate).zac;
                    client.disconnect(client.getClass().getName().concat(C0000.decode(new byte[]{20, 82, 81, 68, 5, 12, 90, 88, 93, 84, 18, 10, 90, 81, 24, 85, 3, 0, 85, 67, 75, 82, 70, 10, 64, 22, 79, 86, 21, 67, 71, 95, 95, 89, 3, 7, 20, 89, 77, 67, 72}, "4687fc")));
                    return;
                case 11:
                    throw null;
                case 12:
                    WakeLock wakeLock = (WakeLock) this.this$0;
                    synchronized (wakeLock.zzf) {
                        try {
                            if (wakeLock.isHeld()) {
                                String.valueOf(wakeLock.zzp).concat(C0000.decode(new byte[]{16, 26, 72, 19, 127, 53, 70, 117, 41, 106, 115, 117, 79, 97, 115, 42, 35, 114, 53, 125, 116, 16, 45, 125, 22, 50, 47, 126, 35, 119, 101, 100, 66, 25, 28}, "00b36ff3f8", true));
                                wakeLock.zzc();
                                if (wakeLock.isHeld()) {
                                    wakeLock.zzh = 1;
                                    wakeLock.zzd();
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                case 13:
                    run$com$google$android$gms$tasks$zzg();
                    return;
            }
            while (true) {
                TaskRunner taskRunner = (TaskRunner) this.this$0;
                synchronized (taskRunner) {
                    taskAwaitTaskToRun = taskRunner.awaitTaskToRun();
                }
                if (taskAwaitTaskToRun == null) {
                    return;
                }
                TaskQueue taskQueue = taskAwaitTaskToRun.queue;
                TaskRunner taskRunner2 = (TaskRunner) this.this$0;
                boolean zIsLoggable = TaskRunner.logger.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    TaskRunner taskRunner3 = taskQueue.taskRunner;
                    jNanoTime = System.nanoTime();
                    ResultKt.access$log(taskAwaitTaskToRun, taskQueue, C0000.decode(new byte[]{75, 16, 86, 75, 17, 88, 88, 86}, "8d79e16187ac", true));
                } else {
                    jNanoTime = -1;
                }
                try {
                    TaskRunner.access$runTask(taskRunner2, taskAwaitTaskToRun);
                    if (zIsLoggable) {
                        TaskRunner taskRunner4 = taskQueue.taskRunner;
                        ResultKt.access$log(taskAwaitTaskToRun, taskQueue, C0000.decode(new byte[]{4, 89, 11, 15, 18, 80, 7, 84, 69, 20, 20, 86, 66, 89, 11, 70}, "b0efa8").concat(ResultKt.formatDuration(System.nanoTime() - jNanoTime)));
                    }
                } catch (Throwable th5) {
                    try {
                        ((ThreadPoolExecutor) taskRunner2.backend.delegate).execute(this);
                        throw th5;
                    } catch (Throwable th6) {
                        if (zIsLoggable) {
                            TaskRunner taskRunner5 = taskQueue.taskRunner;
                            ResultKt.access$log(taskAwaitTaskToRun, taskQueue, C0000.decode(new byte[]{5, 86, 93, 85, 81, 6, 66, 82, 22, 22, 22, 89, 20, 80, 90, 66}, "c7494bb36d").concat(ResultKt.formatDuration(System.nanoTime() - jNanoTime)));
                        }
                        throw th6;
                    }
                }
            }
        }

        public AnonymousClass1(zaae zaaeVar, zam zamVar) {
            this.$r8$classId = 11;
            this.this$0 = zamVar;
        }

        public AnonymousClass1(WorkerWrapper workerWrapper, String str) {
            this.$r8$classId = 6;
            this.this$0 = workerWrapper;
        }
    }

    /* JADX INFO: renamed from: androidx.work.Worker$2, reason: invalid class name */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;
        public Object val$future;

        public /* synthetic */ AnonymousClass2(Object obj, int i, Object obj2) {
            this.$r8$classId = i;
            this.this$0 = obj;
            this.val$future = obj2;
        }

        private final void run$com$google$android$gms$cloudmessaging$zzg() {
            zzn zznVar = (zzn) this.val$future;
            IBinder iBinder = (IBinder) this.this$0;
            synchronized (zznVar) {
                if (iBinder == null) {
                    zznVar.zza(C0000.decode(new byte[]{40, 69, 15, 9, 18, 66, 3, 66, 21, 12, 81, 84, 70, 83, 12, 11, 92, 84, 5, 68, 10, 10, 92}, "f0ce21", 5));
                    return;
                }
                try {
                    zznVar.zzc = new OperationImpl(iBinder);
                    zznVar.zza = 2;
                    zznVar.zzf.zzc.execute(new com.google.android.gms.cloudmessaging.zzh(zznVar, 0));
                } catch (RemoteException e) {
                    zznVar.zza(e.getMessage());
                }
            }
        }

        private final void run$com$google$android$gms$cloudmessaging$zzl() {
            zzn zznVar = (zzn) this.val$future;
            int i = ((zzq) this.this$0).zza;
            synchronized (zznVar) {
                zzq zzqVar = (zzq) zznVar.zze.get(i);
                if (zzqVar != null) {
                    zznVar.zze.remove(i);
                    zzqVar.zzc(new zzs(C0000.decode(new byte[]{99, 8, 14, 3, 2, 21, 95, 20, 16, 22, 78, 0, 94, 21, 10, 8, 1, 21, 86, 14, 22, 22, 75, 4, 68, 17, 12, 8, 21, 80}, "7acff50ad69a", 0.0f), null));
                    zznVar.zzf();
                }
            }
        }

        private final void run$com$google$android$gms$tasks$zzi() {
            synchronized (((zzh) this.this$0).zzb) {
                ((OnCompleteListener) ((zzh) this.this$0).zzc).onComplete((com.google.android.gms.tasks.Task) this.val$future);
            }
        }

        private final void run$com$google$android$gms$tasks$zzk() {
            synchronized (((zzh) this.this$0).zzb) {
                OnFailureListener onFailureListener = (OnFailureListener) ((zzh) this.this$0).zzc;
                Exception exception = ((com.google.android.gms.tasks.Task) this.val$future).getException();
                zzag.checkNotNull(exception);
                onFailureListener.onFailure(exception);
            }
        }

        private final void run$com$google$android$gms$tasks$zzm() {
            synchronized (((zzh) this.this$0).zzb) {
                ((OnSuccessListener) ((zzh) this.this$0).zzc).onSuccess(((com.google.android.gms.tasks.Task) this.val$future).getResult());
            }
        }

        private final void run$com$google$firebase$concurrent$SequentialExecutor$QueueWorker() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (((SequentialExecutor) this.this$0).queue) {
                    ((SequentialExecutor) this.this$0).workerRunningState = 1;
                    throw e;
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAccountAccessor iAccountAccessor;
            WorkSpec workSpec = null;
            switch (this.$r8$classId) {
                case 0:
                    try {
                        ((Worker) this.this$0).getClass();
                        throw new IllegalStateException(C0000.decode(new byte[]{36, 28, 67, 84, 92, 81, 17, 84, 80, 17, 53, 87, 23, 10, 49, 93, 16, 17, 86, 66, 76, 75, 69, 67, 81, 64, 23, 81, 23, 4, 67, 89, 65, 51, 92, 67, 83, 93, 23, 17, 64, 94, 66, 72, 23, 14, 21, 81, 5, 1, 19, 80, 86, 24, 12, 92, 68, 93, 7, 85, 0, 15, 23, 89, 21, 13, 92, 95, 24, 94, 10, 67, 20, 59, 66, 88, 2, 4, 23, 126, 14, 22, 86, 86, 74, 87, 16, 95, 80, 120, 12, 94, 10, 73, 74, 88}, "ad3188e141b8eac8"));
                    } catch (Throwable th) {
                        ((SettableFuture) this.val$future).setException(th);
                        return;
                    }
                case 1:
                    if (((WorkerWrapper) this.this$0).mWorkerResultFuture.value instanceof AbstractFuture.Cancellation) {
                        return;
                    }
                    try {
                        ((ListenableFuture) this.val$future).get();
                        SystemClock systemClock = SystemClock.get();
                        int i = WorkerWrapper.$r8$clinit;
                        String str = ((WorkerWrapper) this.this$0).mWorkSpec.workerClassName;
                        systemClock.getClass();
                        WorkerWrapper workerWrapper = (WorkerWrapper) this.this$0;
                        workerWrapper.mWorkerResultFuture.setFuture(workerWrapper.mWorker.startWork());
                        return;
                    } catch (Throwable th2) {
                        ((WorkerWrapper) this.this$0).mWorkerResultFuture.setException(th2);
                        return;
                    }
                case 2:
                    SystemClock systemClock2 = SystemClock.get();
                    int i2 = DelayedWorkTracker.$r8$clinit;
                    WorkSpec workSpec2 = (WorkSpec) this.val$future;
                    systemClock2.getClass();
                    ((DelayedWorkTracker) this.this$0).mImmediateScheduler.schedule(workSpec2);
                    return;
                case 3:
                    Processor processor = ((SystemForegroundDispatcher) this.this$0).mWorkManagerImpl.mProcessor;
                    String str2 = (String) this.val$future;
                    synchronized (processor.mLock) {
                        try {
                            WorkerWrapper workerWrapperUnsafe = processor.getWorkerWrapperUnsafe(str2);
                            if (workerWrapperUnsafe != null) {
                                workSpec = workerWrapperUnsafe.mWorkSpec;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    if (workSpec == null || !workSpec.hasConstraints()) {
                        return;
                    }
                    synchronized (((SystemForegroundDispatcher) this.this$0).mLock) {
                        ((SystemForegroundDispatcher) this.this$0).mWorkSpecById.put(Trace.generationalId(workSpec), workSpec);
                        SystemForegroundDispatcher systemForegroundDispatcher = (SystemForegroundDispatcher) this.this$0;
                        ((SystemForegroundDispatcher) this.this$0).mTrackedWorkSpecs.put(Trace.generationalId(workSpec), WorkConstraintsTrackerKt.listen(systemForegroundDispatcher.mConstraintsTracker, workSpec, (ExecutorCoroutineDispatcherImpl) systemForegroundDispatcher.mTaskExecutor.readyAsyncCalls, systemForegroundDispatcher));
                        break;
                    }
                    return;
                case 4:
                    try {
                        ((Runnable) this.this$0).run();
                        synchronized (((SerialExecutorImpl) this.val$future).mLock) {
                            ((SerialExecutorImpl) this.val$future).scheduleNext();
                            break;
                        }
                        return;
                    } catch (Throwable th4) {
                        synchronized (((SerialExecutorImpl) this.val$future).mLock) {
                            ((SerialExecutorImpl) this.val$future).scheduleNext();
                            throw th4;
                        }
                    }
                case 5:
                    String strDecode = C0000.decode(new byte[]{53, 14, 70, 10, 7, 20, 19, 18, 3, 18, 20, 12, 3, 20, 88, 0, 6, 65, 93, 12, 18, 9, 65, 17, 3, 15, 64, 65, 74}, "ba4abf3e", 0.0f);
                    if (((WorkForegroundRunnable) this.this$0).mFuture.value instanceof AbstractFuture.Cancellation) {
                        return;
                    }
                    try {
                        final ForegroundInfo foregroundInfo = (ForegroundInfo) ((SettableFuture) this.val$future).get();
                        if (foregroundInfo == null) {
                            throw new IllegalStateException(strDecode + ((WorkForegroundRunnable) this.this$0).mWorkSpec.workerClassName + C0000.decode(new byte[]{16, 66, 87, 77, 68, 18, 1, 93, 5, 22, 94, 88, 77, 66, 69, 74, 95, 68, 12, 80, 4, 22, 118, 88, 75, 7, 82, 74, 95, 71, 11, 80, 40, 88, 86, 88}, "9b5802e4a607", 7));
                        }
                        SystemClock systemClock3 = SystemClock.get();
                        int i3 = WorkForegroundRunnable.$r8$clinit;
                        String str3 = ((WorkForegroundRunnable) this.this$0).mWorkSpec.workerClassName;
                        systemClock3.getClass();
                        WorkForegroundRunnable workForegroundRunnable = (WorkForegroundRunnable) this.this$0;
                        SettableFuture settableFuture = workForegroundRunnable.mFuture;
                        final WorkForegroundUpdater workForegroundUpdater = workForegroundRunnable.mForegroundUpdater;
                        final Context context = workForegroundRunnable.mContext;
                        final UUID uuid = workForegroundRunnable.mWorker.mWorkerParams.mId;
                        workForegroundUpdater.getClass();
                        final SettableFuture settableFuture2 = new SettableFuture();
                        workForegroundUpdater.mTaskExecutor.executeOnTaskThread(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundUpdater.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (!(settableFuture2.value instanceof AbstractFuture.Cancellation)) {
                                        String string = uuid.toString();
                                        WorkSpec workSpec3 = WorkForegroundUpdater.this.mWorkSpecDao.getWorkSpec(string);
                                        if (workSpec3 == null || NetworkType$EnumUnboxingLocalUtility._isFinished(workSpec3.state)) {
                                            throw new IllegalStateException(C0000.decode(new byte[]{117, 83, 9, 10, 68, 23, 65, 12, 20, 65, 93, 77, 116, 93, 16, 82, 81, 64, 10, 19, 89, 83, 116, 16, 77, 92, 91, 17, 27, 18, 15, 66, 69, 70, 69, 5, 88, 90, 69, 15, 81, 70, 93, 25, 80, 87, 4, 88, 68, 87, 69, 7, 23, 123, 92, 16, 64, 87, 86, 88, 80, 94, 7, 96, 89, 64, 14, 3, 69, 23, 70, 10, 83, 92, 89, 85, 65, 18, 1, 88, 91, 66, 9, 3, 67, 94, 90, 13, 20, 93, 94, 25, 69, 93, 16, 92, 22, 80, 28, 70, 69, 82, 65, 22, 70, 92, 81, 87, 85, 18, 3, 89, 22, 91, 11, 21, 67, 86, 91, 0, 81, 18, 87, 95, 18, 96, 7, 68, 67, 94, 17, 72}, "62ef775c428922b7", false));
                                        }
                                        ((Processor) WorkForegroundUpdater.this.mForegroundProcessor).startForeground(string, foregroundInfo);
                                        context.startService(SystemForegroundDispatcher.createNotifyIntent(context, Trace.generationalId(workSpec3), foregroundInfo));
                                    }
                                    settableFuture2.set(null);
                                } catch (Throwable th5) {
                                    settableFuture2.setException(th5);
                                }
                            }
                        });
                        settableFuture.setFuture(settableFuture2);
                        return;
                    } catch (Throwable th5) {
                        ((WorkForegroundRunnable) this.this$0).mFuture.setException(th5);
                        return;
                    }
                case 6:
                    run$com$google$android$gms$cloudmessaging$zzg();
                    return;
                case 7:
                    run$com$google$android$gms$cloudmessaging$zzl();
                    return;
                case 8:
                    ConnectionResult connectionResult = (ConnectionResult) this.val$future;
                    zabu zabuVar = (zabu) this.this$0;
                    Api.Client client = zabuVar.zab;
                    zabq zabqVar = (zabq) zabuVar.zaa.zap.get(zabuVar.zac);
                    if (zabqVar == null) {
                        return;
                    }
                    if (connectionResult.zzb != 0) {
                        zabqVar.zar(connectionResult, null);
                        return;
                    }
                    zabuVar.zaf = true;
                    if (client.requiresSignIn()) {
                        if (!zabuVar.zaf || (iAccountAccessor = zabuVar.zad) == null) {
                            return;
                        }
                        client.getRemoteService(iAccountAccessor, zabuVar.zae);
                        return;
                    }
                    try {
                        client.getRemoteService(null, client.getScopesForConnectionlessNonSignIn());
                        return;
                    } catch (SecurityException unused) {
                        client.disconnect(C0000.decode(new byte[]{116, 7, 11, 94, 92, 86, 19, 69, 14, 16, 83, 84, 70, 70, 17, 87, 75, 68, 90, 82, 4, 16, 82, 67, 93, 11, 66, 80, 75, 93, 88, 84, 19, 30}, "2fb29231a041", true));
                        zabqVar.zar(new ConnectionResult(10), null);
                        return;
                    }
                case 9:
                    if (((zzw) ((com.google.android.gms.tasks.Task) this.val$future)).zzd) {
                        ((zzd) this.this$0).zzc.zzc();
                        return;
                    }
                    try {
                        ((zzd) this.this$0).zzc.zzb(((zzd) this.this$0).zzb.then((com.google.android.gms.tasks.Task) this.val$future));
                        return;
                    } catch (RuntimeExecutionException e) {
                        if (e.getCause() instanceof Exception) {
                            ((zzd) this.this$0).zzc.zza((Exception) e.getCause());
                            return;
                        } else {
                            ((zzd) this.this$0).zzc.zza(e);
                            return;
                        }
                    } catch (Exception e2) {
                        ((zzd) this.this$0).zzc.zza(e2);
                        return;
                    }
                case 10:
                    zzd zzdVar = (zzd) this.this$0;
                    zzw zzwVar = zzdVar.zzc;
                    try {
                        com.google.android.gms.tasks.Task task = (com.google.android.gms.tasks.Task) zzdVar.zzb.then((com.google.android.gms.tasks.Task) this.val$future);
                        if (task == null) {
                            zzdVar.onFailure(new NullPointerException(C0000.decode(new byte[]{116, 92, 88, 77, 80, 87, 19, 86, 16, 10, 86, 93, 23, 65, 83, 77, 76, 75, 8, 82, 0, 67, 87, 70, 91, 95}, "736999f7dc93", 7)));
                            return;
                        }
                        zzt zztVar = TaskExecutors.zza;
                        task.addOnSuccessListener(zztVar, zzdVar);
                        zzw zzwVar2 = (zzw) task;
                        zzr zzrVar = zzwVar2.zzb;
                        zzrVar.zza(new zzh((Executor) zztVar, (OnFailureListener) zzdVar));
                        zzwVar2.zzi();
                        zzrVar.zza(new zzh((Executor) zztVar, (OnCanceledListener) zzdVar));
                        zzwVar2.zzi();
                        return;
                    } catch (RuntimeExecutionException e3) {
                        if (e3.getCause() instanceof Exception) {
                            zzwVar.zza((Exception) e3.getCause());
                            return;
                        } else {
                            zzwVar.zza(e3);
                            return;
                        }
                    } catch (Exception e4) {
                        zzwVar.zza(e4);
                        return;
                    }
                case 11:
                    run$com$google$android$gms$tasks$zzi();
                    return;
                case 12:
                    run$com$google$android$gms$tasks$zzk();
                    return;
                case 13:
                    run$com$google$android$gms$tasks$zzm();
                    return;
                case 14:
                    zzh zzhVar = (zzh) this.this$0;
                    try {
                        zzw zzwVarThen = ((SuccessContinuation) zzhVar.zzb).then(((com.google.android.gms.tasks.Task) this.val$future).getResult());
                        zzr zzrVar2 = zzwVarThen.zzb;
                        zzt zztVar2 = TaskExecutors.zza;
                        zzwVarThen.addOnSuccessListener(zztVar2, zzhVar);
                        zzrVar2.zza(new zzh((Executor) zztVar2, (OnFailureListener) zzhVar));
                        zzwVarThen.zzi();
                        zzrVar2.zza(new zzh((Executor) zztVar2, (OnCanceledListener) zzhVar));
                        zzwVarThen.zzi();
                        return;
                    } catch (RuntimeExecutionException e5) {
                        if (e5.getCause() instanceof Exception) {
                            zzhVar.onFailure((Exception) e5.getCause());
                            return;
                        } else {
                            zzhVar.onFailure(e5);
                            return;
                        }
                    } catch (CancellationException unused2) {
                        zzhVar.onCanceled();
                        return;
                    } catch (Exception e6) {
                        zzhVar.onFailure(e6);
                        return;
                    }
                case 15:
                    zzw zzwVar3 = (zzw) this.val$future;
                    try {
                        zzwVar3.zzb(((Callable) this.this$0).call());
                        return;
                    } catch (Exception e7) {
                        zzwVar3.zza(e7);
                        return;
                    } catch (Throwable th6) {
                        zzwVar3.zza(new RuntimeException(th6));
                        return;
                    }
                case 16:
                    run$com$google$firebase$concurrent$SequentialExecutor$QueueWorker();
                    return;
                default:
                    LimitedDispatcher limitedDispatcher = (LimitedDispatcher) this.this$0;
                    int i4 = 0;
                    do {
                        try {
                            ((Runnable) this.val$future).run();
                        } catch (Throwable th7) {
                            BuildersKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th7);
                        }
                        Runnable runnableObtainTaskOrDeallocateWorker = limitedDispatcher.obtainTaskOrDeallocateWorker();
                        if (runnableObtainTaskOrDeallocateWorker == null) {
                            return;
                        }
                        this.val$future = runnableObtainTaskOrDeallocateWorker;
                        i4++;
                        break;
                    } while (i4 < 16);
                    UnlimitedIoScheduler.INSTANCE.dispatch(limitedDispatcher, this);
                    return;
            }
        }

        public String toString() {
            String strDecode;
            switch (this.$r8$classId) {
                case 16:
                    Runnable runnable = (Runnable) this.val$future;
                    String strDecode2 = C0000.decode(new byte[]{69}, "81388c25");
                    if (runnable != null) {
                        return C0000.decode(new byte[]{101, 85, 73, 17, 82, 11, 66, 89, 89, 8, 114, 29, 83, 83, 77, 16, 88, 23, 97, 95, 74, 15, 82, 23, 77, 66, 77, 10, 89, 12, 88, 87, 5}, "608d7e", 0.0f) + runnable + strDecode2;
                    }
                    StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{55, 81, 70, 20, 7, 87, 68, 10, 2, 14, 32, 25, 1, 87, 66, 21, 13, 75, 103, 12, 17, 9, 0, 19, 31, 71, 67, 0, 22, 92, 13}, "d47ab90ccbea", 3));
                    int i = ((SequentialExecutor) this.this$0).workerRunningState;
                    if (i == 1) {
                        strDecode = C0000.decode(new byte[]{124, 117, 46, 36}, "51ba053632", 6);
                    } else if (i == 2) {
                        strDecode = C0000.decode(new byte[]{99, 103, 112, 96, 125, 121, 113}, "22554764", 0.0f);
                    } else if (i != 3) {
                        strDecode = i != 4 ? C0000.decode(new byte[]{92, 22, 13, 95}, "2ca3c9264d35", 0.0f) : C0000.decode(new byte[]{103, 51, 119, 118, 45, 47, 118}, "5f98da1bad8c17", 0.0f);
                    } else {
                        strDecode = C0000.decode(new byte[]{97, 52, 115, 103, 117, 113}, "0a6205d99668f44c", true);
                    }
                    sb.append(strDecode);
                    sb.append(strDecode2);
                    return sb.toString();
                default:
                    return super.toString();
            }
        }

        /* JADX WARN: Code duplicated, block: B:47:0x003c A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        
            if (r1 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        
            ((java.lang.Runnable) r13.val$future).run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
        
            com.google.firebase.concurrent.SequentialExecutor.log.log(java.util.logging.Level.SEVERE, p000.C0000.decode(new byte[]{118, 65, 7, 3, 19, 77, 92, 12, 91, 17, 68, 81, 13, 10, 6, 25, 80, 27, 80, 82, 70, 77, 13, 8, 4, 25, 71, 22, 91, 95, 82, 91, 8, 3, 67}, "39dfc95c51", false) + ((java.lang.Runnable) r13.val$future), (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        
            r13.val$future = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void workOnQueue() {
            /*
                r13 = this;
                r0 = 0
                r1 = r0
            L2:
                java.lang.Object r2 = r13.this$0     // Catch: java.lang.Throwable -> L58
                com.google.firebase.concurrent.SequentialExecutor r2 = (com.google.firebase.concurrent.SequentialExecutor) r2     // Catch: java.lang.Throwable -> L58
                java.util.ArrayDeque r2 = r2.queue     // Catch: java.lang.Throwable -> L58
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
                r3 = 1
                if (r0 != 0) goto L2c
                java.lang.Object r0 = r13.this$0     // Catch: java.lang.Throwable -> L20
                com.google.firebase.concurrent.SequentialExecutor r0 = (com.google.firebase.concurrent.SequentialExecutor) r0     // Catch: java.lang.Throwable -> L20
                int r4 = r0.workerRunningState     // Catch: java.lang.Throwable -> L20
                r5 = 4
                if (r4 != r5) goto L22
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L46
            L18:
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                goto L46
            L20:
                r0 = move-exception
                goto L89
            L22:
                long r6 = r0.workerRunCount     // Catch: java.lang.Throwable -> L20
                r8 = 1
                long r6 = r6 + r8
                r0.workerRunCount = r6     // Catch: java.lang.Throwable -> L20
                r0.workerRunningState = r5     // Catch: java.lang.Throwable -> L20
                r0 = r3
            L2c:
                java.lang.Object r4 = r13.this$0     // Catch: java.lang.Throwable -> L20
                com.google.firebase.concurrent.SequentialExecutor r4 = (com.google.firebase.concurrent.SequentialExecutor) r4     // Catch: java.lang.Throwable -> L20
                java.util.ArrayDeque r4 = r4.queue     // Catch: java.lang.Throwable -> L20
                java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
                java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
                r13.val$future = r4     // Catch: java.lang.Throwable -> L20
                if (r4 != 0) goto L47
                java.lang.Object r0 = r13.this$0     // Catch: java.lang.Throwable -> L20
                com.google.firebase.concurrent.SequentialExecutor r0 = (com.google.firebase.concurrent.SequentialExecutor) r0     // Catch: java.lang.Throwable -> L20
                r0.workerRunningState = r3     // Catch: java.lang.Throwable -> L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L46
                goto L18
            L46:
                return
            L47:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L58
                r1 = r1 | r2
                r2 = 0
                java.lang.Object r3 = r13.val$future     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
                r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            L55:
                r13.val$future = r2     // Catch: java.lang.Throwable -> L58
                goto L2
            L58:
                r0 = move-exception
                goto L8b
            L5a:
                r0 = move-exception
                goto L86
            L5c:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.SequentialExecutor.log     // Catch: java.lang.Throwable -> L5a
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
                r6.<init>()     // Catch: java.lang.Throwable -> L5a
                r10 = 35
                byte[] r10 = new byte[r10]     // Catch: java.lang.Throwable -> L5a
                r10 = {x0096: FILL_ARRAY_DATA , data: [118, 65, 7, 3, 19, 77, 92, 12, 91, 17, 68, 81, 13, 10, 6, 25, 80, 27, 80, 82, 70, 77, 13, 8, 4, 25, 71, 22, 91, 95, 82, 91, 8, 3, 67} // fill-array     // Catch: java.lang.Throwable -> L5a
                java.lang.String r7 = "39dfc95c51"
                r12 = 0
                java.lang.String r7 = p000.C0000.decode(r10, r7, r12)     // Catch: java.lang.Throwable -> L5a
                r6.append(r7)     // Catch: java.lang.Throwable -> L5a
                java.lang.Object r7 = r13.val$future     // Catch: java.lang.Throwable -> L5a
                java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
                r6.append(r7)     // Catch: java.lang.Throwable -> L5a
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
                goto L55
            L86:
                r13.val$future = r2     // Catch: java.lang.Throwable -> L58
                throw r0     // Catch: java.lang.Throwable -> L58
            L89:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                throw r0     // Catch: java.lang.Throwable -> L58
            L8b:
                if (r1 == 0) goto L94
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L94:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Worker.AnonymousClass2.workOnQueue():void");
        }

        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, int i, boolean z) {
            this.$r8$classId = i;
            this.val$future = obj;
            this.this$0 = obj2;
        }

        public AnonymousClass2(SequentialExecutor sequentialExecutor) {
            this.$r8$classId = 16;
            this.this$0 = sequentialExecutor;
        }
    }

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        this.mWorkerParams.mBackgroundExecutor.execute(new AnonymousClass2(this, 0, settableFuture));
        return settableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final SettableFuture startWork() {
        this.mFuture = new SettableFuture();
        this.mWorkerParams.mBackgroundExecutor.execute(new AnonymousClass1(0, this));
        return this.mFuture;
    }
}
