package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Headers;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ScopeCoroutine extends AbstractCoroutine implements CoroutineStackFrame {
    public final SuspendLambda uCont;

    public ScopeCoroutine(CoroutineContext coroutineContext, SuspendLambda suspendLambda) {
        super(coroutineContext, true);
        this.uCont = suspendLambda;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void afterCompletion(Object obj) {
        AtomicKt.resumeCancellableWith(BuildersKt.recoverResult(obj), Headers.Companion.intercepted(this.uCont));
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void afterResume(Object obj) {
        this.uCont.resumeWith(BuildersKt.recoverResult(obj));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        SuspendLambda suspendLambda = this.uCont;
        if (suspendLambda != null) {
            return suspendLambda;
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean isScopedCoroutine() {
        return true;
    }
}
