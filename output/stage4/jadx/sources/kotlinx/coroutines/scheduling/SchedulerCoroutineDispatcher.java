package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    public CoroutineScheduler coroutineScheduler;

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, 6);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, 2);
    }
}
