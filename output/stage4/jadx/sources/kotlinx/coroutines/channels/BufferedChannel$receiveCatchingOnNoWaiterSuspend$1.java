package kotlinx.coroutines.channels;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel bufferedChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM15receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m15receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM15receiveCatchingOnNoWaiterSuspendGKJJFZk == CoroutineSingletons.COROUTINE_SUSPENDED ? objM15receiveCatchingOnNoWaiterSuspendGKJJFZk : new ChannelResult(objM15receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
