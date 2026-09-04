package kotlinx.coroutines.channels;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BufferedChannel$receiveCatching$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BufferedChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel bufferedChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m13receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        return objM13receiveCatchingJP2dKIU$suspendImpl == CoroutineSingletons.COROUTINE_SUSPENDED ? objM13receiveCatchingJP2dKIU$suspendImpl : new ChannelResult(objM13receiveCatchingJP2dKIU$suspendImpl);
    }
}
