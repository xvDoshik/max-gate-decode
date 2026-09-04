package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ChildContinuation extends JobCancellingNode {
    public final CancellableContinuationImpl child;

    public ChildContinuation(CancellableContinuationImpl cancellableContinuationImpl) {
        this.child = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        JobSupport jobSupport = this.job;
        if (jobSupport == null) {
            jobSupport = null;
        }
        CancellationException cancellationException = jobSupport.getCancellationException();
        CancellableContinuationImpl cancellableContinuationImpl = this.child;
        if (cancellableContinuationImpl.isReusable()) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) cancellableContinuationImpl.delegate;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = AtomicKt.REUSABLE_CLAIMED;
                if (Intrinsics.areEqual(obj, symbol)) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, cancellationException)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                        }
                    }
                    return;
                } else {
                    if (obj instanceof Throwable) {
                        return;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == obj);
                }
            }
        }
        cancellableContinuationImpl.cancel(cancellationException);
        if (cancellableContinuationImpl.isReusable()) {
            return;
        }
        cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }
}
