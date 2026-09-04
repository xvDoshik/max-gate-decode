package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import okhttp3.Headers;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1 extends ContinuationImpl {
    public FlowCollector L$0;
    public ReceiveChannel L$1;
    public BufferedChannel.BufferedChannelIterator L$2;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Headers.Companion.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
    }
}
