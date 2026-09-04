package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class InvokeOnCancelling extends JobCancellingNode {
    public static final AtomicIntegerFieldUpdater _invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, C0000.decode(new byte[]{58, 8, 10, 64, 86, 94, 85, 6}, "ead6950bc208", 1));
    private volatile int _invoked;
    public final Function1 handler;

    public InvokeOnCancelling(Function1 function1) {
        this.handler = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        if (_invoked$FU.compareAndSet(this, 0, 1)) {
            this.handler.invoke(th);
        }
    }
}
