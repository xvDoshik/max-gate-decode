package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.tracing.Trace;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import com.google.firebase.messaging.ServiceStarter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.Job;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {
    public final Configuration mConfiguration;
    public final ConnectionPool mConstraintsTracker;
    public final Context mContext;
    public final DelayedWorkTracker mDelayedWorkTracker;
    public Boolean mInDefaultProcess;
    public final Processor mProcessor;
    public boolean mRegisteredExecutionListener;
    public final Dispatcher mTaskExecutor;
    public final TimeLimiter mTimeLimiter;
    public final WorkLauncherImpl mWorkLauncher;
    public final HashMap mConstrainedWorkSpecs = new HashMap();
    public final Object mLock = new Object();
    public final StartStopTokens mStartStopTokens = new StartStopTokens();
    public final HashMap mFirstRunAttempts = new HashMap();

    public final class AttemptData {
        public final int mRunAttemptCount;
        public final long mTimeStamp;

        public AttemptData(int i, long j) {
            this.mRunAttemptCount = i;
            this.mTimeStamp = j;
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{118, 20, 0, 6, 80, 31, 101, 87, 81, 0, 1, 66, 84, 4, 67}, "1fec4f649ee78a"));
    }

    public GreedyScheduler(Context context, Configuration configuration, ServiceStarter serviceStarter, Processor processor, WorkLauncherImpl workLauncherImpl, Dispatcher dispatcher) {
        this.mContext = context;
        ConnectionPool connectionPool = (ConnectionPool) configuration.runnableScheduler;
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, connectionPool, (SystemClock) configuration.clock);
        this.mTimeLimiter = new TimeLimiter(connectionPool, workLauncherImpl);
        this.mTaskExecutor = dispatcher;
        this.mConstraintsTracker = new ConnectionPool(serviceStarter);
        this.mConfiguration = configuration;
        this.mProcessor = processor;
        this.mWorkLauncher = workLauncherImpl;
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String str) {
        Runnable runnable;
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            SystemClock.get().getClass();
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        SystemClock.get().getClass();
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null && (runnable = (Runnable) delayedWorkTracker.mRunnables.remove(str)) != null) {
            ((Handler) delayedWorkTracker.mRunnableScheduler.delegate).removeCallbacks(runnable);
        }
        for (StartStopToken startStopToken : this.mStartStopTokens.remove(str)) {
            this.mTimeLimiter.cancel(startStopToken);
            WorkLauncherImpl workLauncherImpl = this.mWorkLauncher;
            workLauncherImpl.getClass();
            ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StopWorkRunnable((Processor) workLauncherImpl.processor, startStopToken, false, -512));
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        boolean zContainsKey;
        WorkLauncherImpl workLauncherImpl = this.mWorkLauncher;
        TimeLimiter timeLimiter = this.mTimeLimiter;
        StartStopTokens startStopTokens = this.mStartStopTokens;
        WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workSpec);
        if (!(constraintsState instanceof ConstraintsState.ConstraintsMet)) {
            SystemClock systemClock = SystemClock.get();
            workGenerationalIdGenerationalId.toString();
            systemClock.getClass();
            StartStopToken startStopTokenRemove = startStopTokens.remove(workGenerationalIdGenerationalId);
            if (startStopTokenRemove != null) {
                timeLimiter.cancel(startStopTokenRemove);
                int i = ((ConstraintsState.ConstraintsNotMet) constraintsState).reason;
                workLauncherImpl.getClass();
                ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StopWorkRunnable((Processor) workLauncherImpl.processor, startStopTokenRemove, false, i));
                return;
            }
            return;
        }
        synchronized (startStopTokens.lock) {
            zContainsKey = startStopTokens.runs.containsKey(workGenerationalIdGenerationalId);
        }
        if (zContainsKey) {
            return;
        }
        SystemClock systemClock2 = SystemClock.get();
        workGenerationalIdGenerationalId.toString();
        systemClock2.getClass();
        StartStopToken startStopToken = startStopTokens.tokenFor(workGenerationalIdGenerationalId);
        timeLimiter.track(startStopToken);
        workLauncherImpl.getClass();
        ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StartWorkRunnable((Processor) workLauncherImpl.processor, startStopToken, null, 0));
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        Job job;
        StartStopToken startStopTokenRemove = this.mStartStopTokens.remove(workGenerationalId);
        if (startStopTokenRemove != null) {
            this.mTimeLimiter.cancel(startStopTokenRemove);
        }
        synchronized (this.mLock) {
            job = (Job) this.mConstrainedWorkSpecs.remove(workGenerationalId);
        }
        if (job != null) {
            SystemClock systemClock = SystemClock.get();
            Objects.toString(workGenerationalId);
            systemClock.getClass();
            job.cancel(null);
        }
        if (z) {
            return;
        }
        synchronized (this.mLock) {
            this.mFirstRunAttempts.remove(workGenerationalId);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecArr) {
        boolean zContainsKey;
        long jMax;
        boolean zContainsKey2;
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            SystemClock.get().getClass();
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        HashSet<WorkSpec> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workSpec);
            StartStopTokens startStopTokens = this.mStartStopTokens;
            synchronized (startStopTokens.lock) {
                zContainsKey = startStopTokens.runs.containsKey(workGenerationalIdGenerationalId);
            }
            if (!zContainsKey) {
                synchronized (this.mLock) {
                    try {
                        WorkGenerationalId workGenerationalIdGenerationalId2 = Trace.generationalId(workSpec);
                        AttemptData attemptData = (AttemptData) this.mFirstRunAttempts.get(workGenerationalIdGenerationalId2);
                        if (attemptData == null) {
                            int i = workSpec.runAttemptCount;
                            ((SystemClock) this.mConfiguration.clock).getClass();
                            attemptData = new AttemptData(i, System.currentTimeMillis());
                            this.mFirstRunAttempts.put(workGenerationalIdGenerationalId2, attemptData);
                        }
                        jMax = (((long) Math.max((workSpec.runAttemptCount - attemptData.mRunAttemptCount) - 5, 0)) * 30000) + attemptData.mTimeStamp;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                long jMax2 = Math.max(workSpec.calculateNextRunTime(), jMax);
                ((SystemClock) this.mConfiguration.clock).getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (workSpec.state != 1) {
                    continue;
                } else if (jCurrentTimeMillis < jMax2) {
                    DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                    if (delayedWorkTracker != null) {
                        ConnectionPool connectionPool = delayedWorkTracker.mRunnableScheduler;
                        HashMap map = delayedWorkTracker.mRunnables;
                        Runnable runnable = (Runnable) map.remove(workSpec.id);
                        if (runnable != null) {
                            ((Handler) connectionPool.delegate).removeCallbacks(runnable);
                        }
                        Worker.AnonymousClass2 anonymousClass2 = new Worker.AnonymousClass2(delayedWorkTracker, 2, workSpec);
                        map.put(workSpec.id, anonymousClass2);
                        delayedWorkTracker.mClock.getClass();
                        ((Handler) connectionPool.delegate).postDelayed(anonymousClass2, jMax2 - System.currentTimeMillis());
                    }
                } else if (workSpec.hasConstraints()) {
                    Constraints constraints = workSpec.constraints;
                    if (constraints.requiresDeviceIdle) {
                        SystemClock systemClock = SystemClock.get();
                        workSpec.toString();
                        systemClock.getClass();
                    } else if (constraints.contentUriTriggers.isEmpty()) {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.id);
                    } else {
                        SystemClock systemClock2 = SystemClock.get();
                        workSpec.toString();
                        systemClock2.getClass();
                    }
                } else {
                    StartStopTokens startStopTokens2 = this.mStartStopTokens;
                    WorkGenerationalId workGenerationalIdGenerationalId3 = Trace.generationalId(workSpec);
                    synchronized (startStopTokens2.lock) {
                        zContainsKey2 = startStopTokens2.runs.containsKey(workGenerationalIdGenerationalId3);
                    }
                    if (!zContainsKey2) {
                        SystemClock.get().getClass();
                        StartStopToken startStopToken = this.mStartStopTokens.tokenFor(Trace.generationalId(workSpec));
                        this.mTimeLimiter.track(startStopToken);
                        WorkLauncherImpl workLauncherImpl = this.mWorkLauncher;
                        workLauncherImpl.getClass();
                        ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StartWorkRunnable((Processor) workLauncherImpl.processor, startStopToken, null, 0));
                    }
                }
            }
        }
        synchronized (this.mLock) {
            try {
                if (!hashSet.isEmpty()) {
                    TextUtils.join(C0000.decode(new byte[]{78}, "b4496669"), hashSet2);
                    SystemClock.get().getClass();
                    for (WorkSpec workSpec2 : hashSet) {
                        WorkGenerationalId workGenerationalIdGenerationalId4 = Trace.generationalId(workSpec2);
                        if (!this.mConstrainedWorkSpecs.containsKey(workGenerationalIdGenerationalId4)) {
                            this.mConstrainedWorkSpecs.put(workGenerationalIdGenerationalId4, WorkConstraintsTrackerKt.listen(this.mConstraintsTracker, workSpec2, (ExecutorCoroutineDispatcherImpl) this.mTaskExecutor.readyAsyncCalls, this));
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
