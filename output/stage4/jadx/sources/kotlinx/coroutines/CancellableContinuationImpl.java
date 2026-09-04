package kotlinx.coroutines;

import androidx.startup.StartupException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CancellableContinuationImpl extends DispatchedTask implements CancellableContinuation, CoroutineStackFrame, Waiter {
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;
    public final CoroutineContext context;
    public final Continuation delegate;
    public static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, C0000.decode(new byte[]{105, 86, 83, 81, 89, 68, 91, 93, 93, 115, 15, 82, 120, 10, 82, 87, 78}, "6262072232a61d"));
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, C0000.decode(new byte[]{57, 64, 23, 89, 16, 87}, "f3c8d2"));
    public static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, C0000.decode(new byte[]{103, 70, 5, 23, 92, 12, 17, 112, 82, 11, 92, 90, 1}, "86de9be83e", 5));

    public CancellableContinuationImpl(int i, Continuation continuation) {
        super(i);
        this.delegate = continuation;
        this.context = continuation.getContext();
        this._decisionAndIndex = 536870911;
        this._state = Active.INSTANCE;
    }

    public static void multipleHandlersError(Segment segment, Object obj) {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{127, 69, 67, 18, 23, 73, 74, 93, 11, 81, 7, 88, 66, 84, 0, 65, 67, 86, 24, 64, 6, 95, 12, 66, 66, 84, 22, 65, 90, 76, 84, 70, 10, 72, 9, 84, 22, 89, 5, 15, 83, 85, 93, 64, 16, 20, 69, 69, 68, 88, 1, 5, 23, 77, 87, 18, 17, 93, 2, 88, 69, 69, 1, 19, 23}, "61da7982c8e1", true));
        sb.append(segment);
        sb.append(C0000.decode(new byte[]{73, 68, 7, 84, 71, 4, 4, 0, 31, 24, 93, 0, 22, 68}, "edf85a", 4));
        sb.append(obj);
        throw new IllegalStateException(sb.toString().toString());
    }

    public final void callOnCancellation(Function1 function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            BuildersKt.handleCoroutineException(this.context, new StartupException(C0000.decode(new byte[]{116, 27, 0, 81, 73, 76, 80, 87, 10, 19, 81, 90, 69, 20, 3, 67, 68, 14, 6, 20, 86, 86, 122, 89, 10, 80, 93, 88, 9, 7, 18, 89, 94, 13, 67, 92, 88, 86, 93, 84, 1, 65, 24, 82, 10, 20, 70}, "1cc49898d384eff0") + this, th2));
        }
    }

    public final void callSegmentOnCancellation(Segment segment, Throwable th) {
        CoroutineContext coroutineContext = this.context;
        int i = _decisionAndIndex$FU.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException(C0000.decode(new byte[]{101, 12, 85, 69, 92, 92, 85, 1, 72, 69, 83, 93, 67, 68, 99, 0, 82, 95, 84, 10, 68, 75, 90, 92, 114, 5, 94, 6, 80, 94, 93, 5, 68, 12, 90, 92, 25, 74, 30, 76, 21, 91, 66, 68, 82, 23, 90, 89, 84, 10}, "1d0e52", false));
        }
        try {
            segment.onCancellation(i, coroutineContext);
        } catch (Throwable th2) {
            BuildersKt.handleCoroutineException(coroutineContext, new StartupException(C0000.decode(new byte[]{32, 75, 5, 1, 17, 64, 13, 89, 89, 23, 12, 93, 70, 13, 15, 66, 11, 93, 82, 120, 11, 112, 7, 10, 2, 81, 8, 90, 86, 67, 12, 92, 8, 68, 9, 85, 10, 82, 91, 82, 23, 19, 0, 11, 19, 20}, "e3fda4d677", true) + this, th2));
        }
    }

    public final void cancel(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                return;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, th, obj instanceof Segment);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, cancelledContinuation)) {
                    if (((NotCompleted) obj) instanceof Segment) {
                        callSegmentOnCancellation((Segment) obj, th);
                    }
                    if (!isReusable()) {
                        detachChild$kotlinx_coroutines_core();
                    }
                    dispatchResume(this.resumeMode);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void cancelCompletedResult$kotlinx_coroutines_core(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException(C0000.decode(new byte[]{42, 13, 18, 68, 84, 91, 14, 21, 8, 7, 18, 1, 83}, "dbfd74ce", 4));
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (!(obj2 instanceof CompletedContinuation)) {
                CompletedContinuation completedContinuation = new CompletedContinuation(obj2, (Function1) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuation)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
                return;
            }
            CompletedContinuation completedContinuation2 = (CompletedContinuation) obj2;
            if (completedContinuation2.cancelCause != null) {
                throw new IllegalStateException(C0000.decode(new byte[]{126, 65, 75, 23, 19, 87, 80, 67, 80, 89, 93, 90, 1, 82, 19, 85, 76, 67, 94, 90, 70, 23, 19, 87, 95, 85, 1}, "348c355c3816d6"));
            }
            CompletedContinuation completedContinuationCopy$default = CompletedContinuation.copy$default(completedContinuation2, cancellationException, 15);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuationCopy$default)) {
                    Function1 function1 = completedContinuation2.onCancellation;
                    if (function1 != null) {
                        callOnCancellation(function1, cancellationException);
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater.get(this);
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
    }

    public final void dispatchResume(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = _decisionAndIndex$FU;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException(C0000.decode(new byte[]{114, 10, 65, 92, 0, 1, 31, 67, 16, 84, 65, 70, 12, 92, 6}, "3f39aefcb123a9b3"));
                }
                boolean z = i == 4;
                Continuation continuation = this.delegate;
                if (!z && (continuation instanceof DispatchedContinuation)) {
                    boolean z2 = i == 1 || i == 2;
                    int i4 = this.resumeMode;
                    if (z2 == (i4 == 1 || i4 == 2)) {
                        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
                        CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
                        CoroutineContext coroutineContext = dispatchedContinuation.continuation._context;
                        if (coroutineDispatcher.isDispatchNeeded()) {
                            coroutineDispatcher.dispatch(coroutineContext, this);
                            return;
                        }
                        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
                        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
                            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
                            return;
                        }
                        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
                        try {
                            BuildersKt.resume(this, continuation, true);
                            do {
                            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
                        } catch (Throwable th) {
                            try {
                                handleFatalException$kotlinx_coroutines_core(th, null);
                            } finally {
                                eventLoop$kotlinx_coroutines_core.decrementUseCount();
                            }
                        }
                        return;
                    }
                }
                BuildersKt.resume(this, continuation, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public final Object getResult() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        Job job;
        boolean zIsReusable = isReusable();
        do {
            atomicIntegerFieldUpdater = _decisionAndIndex$FU;
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException(C0000.decode(new byte[]{36, 94, 66, 4, 7, 93, 64, 17, 16, 68, 16, 64, 4, 90, 1, 87, 84}, "e20af991c1c0a4"));
                }
                if (zIsReusable) {
                    releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                }
                Object obj = _state$FU.get(this);
                if (obj instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) obj).cause;
                }
                int i3 = this.resumeMode;
                if ((i3 != 1 && i3 != 2) || (job = (Job) this.context.get(Job.Key.$$INSTANCE)) == null || job.isActive()) {
                    return getSuccessfulResult$kotlinx_coroutines_core(obj);
                }
                CancellationException cancellationException = ((JobSupport) job).getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
                throw cancellationException;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((DisposableHandle) _parentHandle$FU.get(this)) == null) {
            installParentHandle();
        }
        if (zIsReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).result : obj;
    }

    public final DisposableHandle installParentHandle() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.context.get(Job.Key.$$INSTANCE);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleInvokeOnCompletion = ((JobSupport) job).invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new ChildContinuation(this));
        do {
            atomicReferenceFieldUpdater = _parentHandle$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, disposableHandleInvokeOnCompletion)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return disposableHandleInvokeOnCompletion;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = _decisionAndIndex$FU;
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException(C0000.decode(new byte[]{10, 90, 21, 11, 83, 92, 44, 87, 119, 87, 13, 87, 6, 8, 84, 88, 23, 80, 91, 88, 67, 71, 11, 11, 77, 85, 7, 25, 86, 83, 67, 87, 2, 8, 84, 92, 7, 25, 85, 66, 67, 89, 12, 23, 76, 25, 12, 87, 87, 83}, "c4cd89c946", 2));
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Active) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, segment)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            if (obj instanceof Segment) {
                multipleHandlersError(segment, obj);
                throw null;
            }
            if (obj instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                if (!CompletedExceptionally._handled$FU.compareAndSet(completedExceptionally, 0, 1)) {
                    multipleHandlersError(segment, obj);
                    throw null;
                }
                if (obj instanceof CancelledContinuation) {
                    callSegmentOnCancellation(segment, completedExceptionally.cause);
                    return;
                }
                return;
            }
            if (!(obj instanceof CompletedContinuation)) {
                if (segment != null) {
                    return;
                }
                if (segment != null) {
                    throw new ClassCastException();
                }
                if (segment != null) {
                    throw new ClassCastException();
                }
                CompletedContinuation completedContinuation = new CompletedContinuation(obj, (Function1) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, completedContinuation)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            CompletedContinuation completedContinuation2 = (CompletedContinuation) obj;
            if (segment != null) {
                return;
            }
            if (segment != null) {
                throw new ClassCastException();
            }
            if (completedContinuation2.cancelCause == null) {
                if (segment != null) {
                    throw new ClassCastException();
                }
                CompletedContinuation completedContinuationCopy$default = CompletedContinuation.copy$default(completedContinuation2, null, 29);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, completedContinuationCopy$default)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            if (segment != null) {
                throw new ClassCastException();
            }
            try {
                throw null;
            } catch (Throwable th) {
                BuildersKt.handleCoroutineException(this.context, new StartupException(C0000.decode(new byte[]{33, 65, 5, 82, 64, 69, 13, 86, 8, 23, 89, 95, 68, 80, 8, 65, 95, 90, 1, 118, 8, 116, 81, 95, 7, 92, 10, 91, 81, 69, 13, 86, 8, 23, 88, 80, 10, 93, 10, 82, 66, 17, 2, 86, 20, 23}, "d9f701", true) + this, th));
                return;
            }
        }
    }

    public final boolean isReusable() {
        if (this.resumeMode == 2) {
            return DispatchedContinuation._reusableCancellableContinuation$FU.get((DispatchedContinuation) this.delegate) != null;
        }
        return false;
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Continuation continuation = this.delegate;
        Throwable th = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = AtomicKt.REUSABLE_CLAIMED;
                if (obj != symbol) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException((C0000.decode(new byte[]{112, 94, 0, 14, 93, 17, 92, 18, 77, 85, 13, 21, 19, 17, 65, 0, 77, 85, 67}, "90ca3b5a") + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{118, 81, 88, 14, 87, 93, 69, 23, 85, 71, 69, 89, 67, 7, 95, 92, 11, 17, 30}, "001b29ee06", true));
                        }
                    }
                    th = (Throwable) obj;
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, this)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == symbol);
            }
            if (th == null) {
                return;
            }
            detachChild$kotlinx_coroutines_core();
            cancel(th);
        }
    }

    public final void resumeImpl(Object obj, int i, Function1 function1) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (CancelledContinuation._resumed$FU.compareAndSet(cancelledContinuation, 0, 1)) {
                        if (function1 != null) {
                            callOnCancellation(function1, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException((C0000.decode(new byte[]{37, 15, 22, 84, 4, 5, 29, 67, 22, 84, 22, 20, 9, 6, 0, 29, 69, 3, 17, 23, 68, 65, 23, 14, 20, 12, 23, 84, 1, 65, 19, 10, 16, 89, 69, 20, 20, 7, 5, 69, 0, 65}, "dcd1ea", false) + obj).toString());
            }
            Object completedContinuation = (!(obj instanceof CompletedExceptionally) && (i == 1 || i == 2) && function1 != null) ? new CompletedContinuation(obj, function1, (CancellationException) null, 16) : obj;
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, completedContinuation)) {
                    if (!isReusable()) {
                        detachChild$kotlinx_coroutines_core();
                    }
                    dispatchResume(i);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM12exceptionOrNullimpl = Result.m12exceptionOrNullimpl(obj);
        if (thM12exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(thM12exceptionOrNullimpl, false);
        }
        resumeImpl(obj, this.resumeMode, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object takeState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    public final String toString() {
        String strDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{34, 88, 15, 86, 6, 91, 94, 82, 82, 88, 87, 33, 14, 87, 21, 92, 13, 66, 83, 71, 89, 91, 92, 74}, "a9a5c723042b", false));
        sb.append(BuildersKt.toDebugString(this.delegate));
        sb.append(C0000.decode(new byte[]{75, 26}, "ba41918f", 0.0f));
        Object obj = _state$FU.get(this);
        if (obj instanceof NotCompleted) {
            strDecode = C0000.decode(new byte[]{119, 1, 71, 95, 71, 82}, "6b361711fc12", 0.0f);
        } else {
            strDecode = obj instanceof CancelledContinuation ? C0000.decode(new byte[]{122, 83, 94, 85, 4, 8, 91, 80, 93}, "9206ad75", 0.0f) : C0000.decode(new byte[]{119, 95, 93, 19, 88, 85, 16, 6, 0}, "400c40dcdf", 0.0f);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{74, 113}, "71fcb32a0a45", 0.0f));
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }
}
