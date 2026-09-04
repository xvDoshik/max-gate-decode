package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.ThreadLocalEventLoop;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DispatchedContinuation extends DispatchedTask implements CoroutineStackFrame, Continuation {
    public static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, C0000.decode(new byte[]{108, 17, 93, 64, 23, 4, 82, 88, 7, 38, 82, 13, 91, 80, 8, 9, 81, 86, 14, 0, 112, 12, 86, 65, 13, 11, 69, 85, 22, 12, 92, 13}, "3c85de04be", 0.0f));
    private volatile Object _reusableCancellableContinuation;
    public Object _state;
    public final ContinuationImpl continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, ContinuationImpl continuationImpl) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuationImpl;
        this._state = AtomicKt.UNDEFINED;
        this.countOrElement = continuationImpl._context.fold(0, ThreadContextKt$findOne$1.INSTANCE$1);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException) {
        if (obj instanceof CompletedWithCancellation) {
            throw null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        ContinuationImpl continuationImpl = this.continuation;
        if (continuationImpl != null) {
            return continuationImpl;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.continuation._context;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ContinuationImpl continuationImpl = this.continuation;
        CoroutineContext coroutineContext = continuationImpl._context;
        Throwable thM12exceptionOrNullimpl = Result.m12exceptionOrNullimpl(obj);
        Object completedExceptionally = thM12exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM12exceptionOrNullimpl, false);
        CoroutineDispatcher coroutineDispatcher = this.dispatcher;
        if (coroutineDispatcher.isDispatchNeeded()) {
            this._state = completedExceptionally;
            this.resumeMode = 0;
            coroutineDispatcher.dispatch(coroutineContext, this);
            return;
        }
        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
            this._state = completedExceptionally;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            CoroutineContext coroutineContext2 = continuationImpl._context;
            Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext2, this.countOrElement);
            try {
                continuationImpl.resumeWith(obj);
                AtomicKt.restoreThreadContext(coroutineContext2, objUpdateThreadContext);
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
            } catch (Throwable th) {
                AtomicKt.restoreThreadContext(coroutineContext2, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                handleFatalException$kotlinx_coroutines_core(th2, null);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount();
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        this._state = AtomicKt.UNDEFINED;
        return obj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{38, 8, 23, 18, 81, 18, 83, 12, 86, 1, 122, 90, 15, 16, 11, 15, 17, 3, 68, 15, 95, 10, 104}, "badb0f0d3e95ad", 6));
        sb.append(this.dispatcher);
        sb.append(C0000.decode(new byte[]{74, 66}, "fbd7de70", false));
        sb.append(BuildersKt.toDebugString(this.continuation));
        sb.append(']');
        return sb.toString();
    }
}
