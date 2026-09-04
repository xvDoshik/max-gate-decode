package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ThreadState {
    public final ThreadContextElement[] elements;
    public final Object[] values;

    public ThreadState(int i, CoroutineContext coroutineContext) {
        this.values = new Object[i];
        this.elements = new ThreadContextElement[i];
    }
}
