package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContextImpl;
import kotlinx.coroutines.scheduling.TasksKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class DispatchedTask extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        super(0L, TasksKt.NonBlockingContext);
        this.resumeMode = i;
    }

    public abstract void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException);

    public abstract Continuation getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public Object getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        BuildersKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError(C0000.decode(new byte[]{113, 88, 64, 85, 8, 16, 7, 77, 6, 0, 21, 65, 94, 86, 90, 20, 13, 94, 66, 86, 10, 23, 10, 64, 67, 80, 90, 81, 23, 16, 15, 84, 6, 13, 12, 91, 82, 75, 77, 20, 2, 95, 16, 21}, "7944d0b5eee5", 0.0f) + this + C0000.decode(new byte[]{74, 66, 49, 10, 87, 87, 22, 86, 19, 70, 1, 3, 5, 70, 121, 114, 10, 80, 19, 64, 11, 66, 70, 14, 83, 88, 1, 95, 86, 114, 5, 22, 0, 10, 119, 78, 6, 86, 67, 64, 13, 13, 15, 65, 18, 91, 0, 71, 91, 91, 0, 66, 0, 8, 86, 22, 23, 86, 67, 91, 22, 22, 65, 18, 90, 95, 22, 19, 90, 90, 7, 11, 5, 3, 92, 66, 69, 71, 92, 20, 9, 3, 8, 8, 70, 87, 12, 93, 86, 70, 23}, "dbaf26e334", false), th));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0043  */
    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Job job;
        Object failure = Unit.INSTANCE;
        TaskContextImpl taskContextImpl = this.taskContext;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) getDelegate$kotlinx_coroutines_core();
            ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext coroutineContext = continuationImpl._context;
            Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext, obj);
            if (objUpdateThreadContext != AtomicKt.NO_THREAD_ELEMENTS) {
                BuildersKt.updateUndispatchedCompletion(continuationImpl, coroutineContext);
            }
            try {
                CoroutineContext coroutineContext2 = continuationImpl._context;
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null) {
                    int i = this.resumeMode;
                    boolean z = true;
                    if (i != 1 && i != 2) {
                        z = false;
                    }
                    if (z) {
                        job = (Job) coroutineContext2.get(Job.Key.$$INSTANCE);
                    } else {
                        job = null;
                    }
                } else {
                    job = null;
                }
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = ((JobSupport) job).getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    continuationImpl.resumeWith(new Result.Failure(cancellationException));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    continuationImpl.resumeWith(new Result.Failure(exceptionalResult$kotlinx_coroutines_core));
                } else {
                    continuationImpl.resumeWith(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core));
                }
                AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                try {
                    taskContextImpl.getClass();
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                handleFatalException$kotlinx_coroutines_core(null, Result.m12exceptionOrNullimpl(failure));
            } catch (Throwable th2) {
                AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                taskContextImpl.getClass();
            } catch (Throwable th4) {
                failure = new Result.Failure(th4);
            }
            handleFatalException$kotlinx_coroutines_core(th3, Result.m12exceptionOrNullimpl(failure));
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
