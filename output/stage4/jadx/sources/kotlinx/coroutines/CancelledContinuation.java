package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CancelledContinuation extends CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, C0000.decode(new byte[]{103, 20, 83, 22, 69, 85, 81, 86}, "8f6e0842081c"));
    private volatile int _resumed;

    public CancelledContinuation(CancellableContinuationImpl cancellableContinuationImpl, Throwable th, boolean z) {
        super(th, z);
        this._resumed = 0;
    }
}
