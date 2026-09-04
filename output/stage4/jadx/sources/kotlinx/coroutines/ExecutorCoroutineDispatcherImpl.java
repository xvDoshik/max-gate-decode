package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    public final Executor executor;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        Method method;
        this.executor = executor;
        Method method2 = ConcurrentKt.REMOVE_FUTURE_ON_CANCEL;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = ConcurrentKt.REMOVE_FUTURE_ON_CANCEL) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.executor;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException(C0000.decode(new byte[]{53, 12, 85, 66, 16, 4, 74, 9, 20, 18, 81, 21, 20, 64, 4, 14, 85, 1, 16, 0, 93}, "ad0bde9b4e0f42", 0.0f));
            cancellationException.initCause(e);
            Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
            if (job != null) {
                job.cancel(cancellationException);
            }
            Dispatchers.IO.dispatch(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).executor == this.executor;
    }

    public final int hashCode() {
        return System.identityHashCode(this.executor);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return this.executor.toString();
    }
}
