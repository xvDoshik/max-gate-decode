package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ContextScope implements CoroutineScope {
    public final CoroutineContext coroutineContext;

    public ContextScope(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{34, 95, 70, 95, 66, 65, 92, 91, 82, 97, 80, 95, 17, 85, 28, 83, 88, 71, 90, 64, 67, 91, 93, 85, 34, 95, 90, 68, 82, 77, 65, 8}, "a04075557230"));
        sb.append(this.coroutineContext);
        sb.append(')');
        return sb.toString();
    }
}
