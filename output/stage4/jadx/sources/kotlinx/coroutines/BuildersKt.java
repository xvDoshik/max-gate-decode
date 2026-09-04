package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class BuildersKt {
    public static final Symbol RESUME_TOKEN = new Symbol(C0000.decode(new byte[]{98, 113, 102, 98, 46, 118, 111, 96, 122, 124, 38, 125}, "0457c3"), 0);
    public static final Symbol CLOSED_EMPTY = new Symbol(C0000.decode(new byte[]{112, 122, 123, 106, 39, 34, 62, 115, 41, 103, 103, 111}, "3649bfa6d7", 0), 0);
    public static final Symbol COMPLETING_ALREADY = new Symbol(C0000.decode(new byte[]{39, 126, 127, 103, 125, 114, 55, 125, 44, 37, 102, 121, 124, 55, 33, 112, 118, 110}, "d12717c4bb980e", 4), 0);
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol(C0000.decode(new byte[]{122, 45, 120, 103, 122, 116, 49, 45, 40, 34, 61, 51, 120, 43, 97, 126, 120, 118, 58, 39, 46, 44, 46, 32, 107, 39, 123}, "9b5761edfebd"), 0);
    public static final Symbol COMPLETING_RETRY = new Symbol(C0000.decode(new byte[]{32, 42, 116, 100, 42, 38, 103, 112, 44, 117, 60, 55, 124, 96, 52, 58}, "ce94fc39b2", 0.0f), 0);
    public static final Symbol TOO_LATE_TO_CANCEL = new Symbol(C0000.decode(new byte[]{102, 120, 125, 57, 127, 39, 100, 115, 109, 99, 125, 57, 112, 39, 126, 117, 119, 123}, "272f3f06", false), 0);
    public static final Symbol SEALED = new Symbol(C0000.decode(new byte[]{97, 119, 116, 122, 33, 38}, "2256db67", 0.0f), 0);
    public static final Empty EMPTY_NEW = new Empty(false);
    public static final Empty EMPTY_ACTIVE = new Empty(true);

    public static final ContextScope CoroutineScope(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key.$$INSTANCE) == null) {
            coroutineContext = coroutineContext.plus(new JobImpl());
        }
        return new ContextScope(coroutineContext);
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final CancellableContinuationImpl getOrCreateCancellableContinuation(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(1, continuation);
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Symbol symbol = AtomicKt.REUSABLE_CLAIMED;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
            cancellableContinuationImpl = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(dispatchedContinuation, symbol);
                cancellableContinuationImpl2 = null;
                break;
            }
            if (obj instanceof CancellableContinuationImpl) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, symbol)) {
                        cancellableContinuationImpl2 = (CancellableContinuationImpl) obj;
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == obj);
            } else if (obj != symbol && !(obj instanceof Throwable)) {
                throw new IllegalStateException((C0000.decode(new byte[]{42, 93, 83, 14, 12, 18, 90, 71, 69, 93, 89, 18, 67, 64, 68, 0, 22, 4, 19}, "c30aba34187f", 0.0f) + obj).toString());
            }
        }
        if (cancellableContinuationImpl2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._state$FU;
            Object obj2 = atomicReferenceFieldUpdater2.get(cancellableContinuationImpl2);
            if (!(obj2 instanceof CompletedContinuation) || ((CompletedContinuation) obj2).idempotentResume == null) {
                CancellableContinuationImpl._decisionAndIndex$FU.set(cancellableContinuationImpl2, 536870911);
                atomicReferenceFieldUpdater2.set(cancellableContinuationImpl2, Active.INSTANCE);
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                cancellableContinuationImpl2.detachChild$kotlinx_coroutines_core();
            }
            if (cancellableContinuationImpl != null) {
                return cancellableContinuationImpl;
            }
        }
        return new CancellableContinuationImpl(2, continuation);
    }

    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        try {
            AndroidExceptionPreHandler androidExceptionPreHandler = (AndroidExceptionPreHandler) coroutineContext.get(Job.Key.$$INSTANCE$1);
            if (androidExceptionPreHandler != null) {
                androidExceptionPreHandler.handleException(th);
            } else {
                AtomicKt.handleUncaughtCoroutineException(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException(C0000.decode(new byte[]{32, 27, 87, 1, 64, 22, 91, 88, 87, 69, 18, 11, 93, 8, 85, 66, 70, 69, 64, 12, 11, 4, 20, 16, 95, 66, 90, 86, 87, 1, 9, 6, 20, 7, 95, 16, 93, 66, 77, 12, 11, 6, 20, 1, 72, 1, 87, 71, 77, 12, 10, 13}, "ec4d0b279e", false), th2);
                ExceptionsKt.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            AtomicKt.handleUncaughtCoroutineException(coroutineContext, th);
        }
    }

    public static void launch$default(CoroutineScope coroutineScope, Function2 function2) {
        AbstractCoroutine standaloneCoroutine = new StandaloneCoroutine(newCoroutineContext(coroutineScope, EmptyCoroutineContext.INSTANCE), true);
        standaloneCoroutine.start(1, standaloneCoroutine, function2);
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextPlus;
        CoroutineContext coroutineContext2 = coroutineScope.getCoroutineContext();
        Boolean bool = Boolean.FALSE;
        CoroutineContextKt$foldCopies$1 coroutineContextKt$foldCopies$1 = CoroutineContextKt$foldCopies$1.INSTANCE$1;
        boolean zBooleanValue = ((Boolean) coroutineContext2.fold(bool, coroutineContextKt$foldCopies$1)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext.fold(bool, coroutineContextKt$foldCopies$1)).booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            CoroutineContextKt$foldCopies$1 coroutineContextKt$foldCopies$2 = new CoroutineContextKt$foldCopies$1(2, 2);
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext2.fold(emptyCoroutineContext, coroutineContextKt$foldCopies$2);
            Object objFold = coroutineContext;
            if (zBooleanValue2) {
                objFold = coroutineContext.fold(emptyCoroutineContext, CoroutineContextKt$foldCopies$1.INSTANCE);
            }
            coroutineContextPlus = coroutineContext3.plus((CoroutineContext) objFold);
        } else {
            coroutineContextPlus = coroutineContext2.plus(coroutineContext);
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return (coroutineContextPlus == defaultScheduler || coroutineContextPlus.get(ContinuationInterceptor$Key.$$INSTANCE) != null) ? coroutineContextPlus : coroutineContextPlus.plus(defaultScheduler);
    }

    public static final Object recoverResult(Object obj) {
        return obj instanceof CompletedExceptionally ? new Result.Failure(((CompletedExceptionally) obj).cause) : obj;
    }

    public static final void resume(CancellableContinuationImpl cancellableContinuationImpl, Continuation continuation, boolean z) {
        Object obj = CancellableContinuationImpl._state$FU.get(cancellableContinuationImpl);
        Throwable exceptionalResult$kotlinx_coroutines_core = cancellableContinuationImpl.getExceptionalResult$kotlinx_coroutines_core(obj);
        Object failure = exceptionalResult$kotlinx_coroutines_core != null ? new Result.Failure(exceptionalResult$kotlinx_coroutines_core) : cancellableContinuationImpl.getSuccessfulResult$kotlinx_coroutines_core(obj);
        if (!z) {
            continuation.resumeWith(failure);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        Object obj2 = dispatchedContinuation.countOrElement;
        CoroutineContext coroutineContext = continuationImpl._context;
        Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext, obj2);
        if (objUpdateThreadContext != AtomicKt.NO_THREAD_ELEMENTS) {
            updateUndispatchedCompletion(continuationImpl, coroutineContext);
        }
        try {
            continuationImpl.resumeWith(failure);
        } finally {
            AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
        }
    }

    public static final String toDebugString(Continuation continuation) {
        Object failure;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            failure = continuation + '@' + getHexAddress(continuation);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m12exceptionOrNullimpl(failure) != null) {
            failure = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) failure;
    }

    public static final void updateUndispatchedCompletion(Continuation continuation, CoroutineContext coroutineContext) {
        if ((continuation instanceof CoroutineStackFrame) && coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            do {
                callerFrame = callerFrame.getCallerFrame();
            } while (callerFrame != null);
        }
    }
}
