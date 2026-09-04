package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FlowCoroutine extends ScopeCoroutine {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }
}
