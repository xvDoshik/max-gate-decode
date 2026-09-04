package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.content.ContextCompat$Api26Impl;
import androidx.tracing.Trace;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.SystemClock;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.tasks.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Processor implements ForegroundProcessor {
    public final Context mAppContext;
    public final Configuration mConfiguration;
    public final WorkDatabase mWorkDatabase;
    public final Dispatcher mWorkTaskExecutor;
    public final HashMap mEnqueuedWorkMap = new HashMap();
    public final HashMap mForegroundWorkMap = new HashMap();
    public final HashSet mCancelledIds = new HashSet();
    public final ArrayList mOuterListeners = new ArrayList();
    public PowerManager.WakeLock mForegroundLock = null;
    public final Object mLock = new Object();
    public final HashMap mWorkRuns = new HashMap();

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{51, 70, 9, 7, 0, 18, 21, 86, 17}, "c4fdeaf9", 2));
    }

    public Processor(Context context, Configuration configuration, Dispatcher dispatcher, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = dispatcher;
        this.mWorkDatabase = workDatabase;
    }

    public static boolean interrupt(WorkerWrapper workerWrapper, int i) {
        if (workerWrapper == null) {
            SystemClock.get().getClass();
            return false;
        }
        workerWrapper.mInterrupted = i;
        workerWrapper.tryCheckForInterruptionAndResolve();
        workerWrapper.mWorkerResultFuture.cancel(true);
        if (workerWrapper.mWorker == null || !(workerWrapper.mWorkerResultFuture.value instanceof AbstractFuture.Cancellation)) {
            Objects.toString(workerWrapper.mWorkSpec);
            SystemClock.get().getClass();
        } else {
            workerWrapper.mWorker.stop(i);
        }
        SystemClock.get().getClass();
        return true;
    }

    public final void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public final WorkerWrapper cleanUpWorkerUnsafe(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.mForegroundWorkMap.remove(str);
        boolean z = workerWrapper != null;
        if (!z) {
            workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z) {
            synchronized (this.mLock) {
                try {
                    if (this.mForegroundWorkMap.isEmpty()) {
                        Context context = this.mAppContext;
                        int i = SystemForegroundDispatcher.$r8$clinit;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction(C0000.decode(new byte[]{113, 122, 108, 112, 44, 121, 110, 53, 50, 41, 96, 102, 126, 118, 49, 114, 118, 52, 41, 51, 126, 125}, "0989c71fff"));
                        try {
                            this.mAppContext.startService(intent);
                        } catch (Throwable unused) {
                            SystemClock.get().getClass();
                        }
                        PowerManager.WakeLock wakeLock = this.mForegroundLock;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.mForegroundLock = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return workerWrapper;
    }

    public final WorkerWrapper getWorkerWrapperUnsafe(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.mForegroundWorkMap.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.mEnqueuedWorkMap.get(str) : workerWrapper;
    }

    public final boolean isEnqueued(String str) {
        boolean z;
        synchronized (this.mLock) {
            z = getWorkerWrapperUnsafe(str) != null;
        }
        return z;
    }

    public final void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public final void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                SystemClock.get().getClass();
                WorkerWrapper workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
                if (workerWrapper != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mAppContext, C0000.decode(new byte[]{53, 16, 88, 80, 6, 70, 23, 87, 69, 36, 95, 20, 86, 82, 23, 13, 66, 93, 7, 121, 7, 83}, "eb73c5d87b0f35", false));
                        this.mForegroundLock = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, workerWrapper);
                    ContextCompat$Api26Impl.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, Trace.generationalId(workerWrapper.mWorkSpec), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean startWork(StartStopToken startStopToken, SystemClock systemClock) {
        WorkGenerationalId workGenerationalId = startStopToken.id;
        String str = workGenerationalId.workSpecId;
        ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.mWorkDatabase.runInTransaction(new Processor$$ExternalSyntheticLambda0(this, arrayList, str, 0));
        if (workSpec == null) {
            SystemClock systemClock2 = SystemClock.get();
            workGenerationalId.toString();
            systemClock2.getClass();
            ((zzu) this.mWorkTaskExecutor.runningSyncCalls).execute(new Processor$$ExternalSyntheticLambda2(this, 0, workGenerationalId));
            return false;
        }
        synchronized (this.mLock) {
            try {
                if (isEnqueued(str)) {
                    Set set = (Set) this.mWorkRuns.get(str);
                    if (((StartStopToken) set.iterator().next()).id.generation == workGenerationalId.generation) {
                        set.add(startStopToken);
                        SystemClock systemClock3 = SystemClock.get();
                        workGenerationalId.toString();
                        systemClock3.getClass();
                    } else {
                        ((zzu) this.mWorkTaskExecutor.runningSyncCalls).execute(new Processor$$ExternalSyntheticLambda2(this, 0, workGenerationalId));
                    }
                    return false;
                }
                if (workSpec.generation != workGenerationalId.generation) {
                    ((zzu) this.mWorkTaskExecutor.runningSyncCalls).execute(new Processor$$ExternalSyntheticLambda2(this, 0, workGenerationalId));
                    return false;
                }
                Context context = this.mAppContext;
                Configuration configuration = this.mConfiguration;
                Dispatcher dispatcher = this.mWorkTaskExecutor;
                WorkDatabase workDatabase = this.mWorkDatabase;
                WorkerWrapper.Builder builder = new WorkerWrapper.Builder();
                new SystemClock();
                builder.mAppContext = context.getApplicationContext();
                builder.mWorkTaskExecutor = dispatcher;
                builder.mForegroundProcessor = this;
                builder.mConfiguration = configuration;
                builder.mWorkDatabase = workDatabase;
                builder.mWorkSpec = workSpec;
                builder.mTags = arrayList;
                WorkerWrapper workerWrapper = new WorkerWrapper(builder);
                SettableFuture settableFuture = workerWrapper.mFuture;
                settableFuture.addListener(new Processor$$ExternalSyntheticLambda1(this, settableFuture, workerWrapper, 0), (zzu) this.mWorkTaskExecutor.runningSyncCalls);
                this.mEnqueuedWorkMap.put(str, workerWrapper);
                HashSet hashSet = new HashSet();
                hashSet.add(startStopToken);
                this.mWorkRuns.put(str, hashSet);
                ((SerialExecutorImpl) this.mWorkTaskExecutor.executorServiceOrNull).execute(workerWrapper);
                SystemClock systemClock4 = SystemClock.get();
                workGenerationalId.toString();
                systemClock4.getClass();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
