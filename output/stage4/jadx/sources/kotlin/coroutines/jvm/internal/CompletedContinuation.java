package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CompletedContinuation implements Continuation {
    public static final CompletedContinuation INSTANCE = new CompletedContinuation();

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        throw new IllegalStateException(C0000.decode(new byte[]{55, 11, 90, 68, 22, 85, 95, 94, 71, 12, 13, 22, 82, 67, 95, 89, 94, 16, 90, 22, 67, 2, 95, 69, 83, 87, 84, 73, 19, 6, 12, 14, 67, 91, 83, 66, 85}, "cc3766003e"));
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        throw new IllegalStateException(C0000.decode(new byte[]{97, 93, 11, 23, 66, 5, 9, 86, 65, 92, 12, 17, 3, 18, 15, 87, 91, 21, 11, 23, 66, 7, 10, 74, 80, 84, 6, 29, 66, 5, 9, 85, 69, 89, 7, 16, 7}, "55bdbff8", 0.0f));
    }

    public final String toString() {
        return C0000.decode(new byte[]{96, 9, 8, 67, 65, 1, 90, 95, 64, 8, 15, 69, 0, 22, 92, 94, 90, 65, 8, 67, 65, 3, 89, 67, 81, 0, 5, 73, 65, 1, 90, 92, 68, 13, 4, 68, 4}, "4aa0ab51", 2);
    }
}
