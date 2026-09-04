package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Api this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistinctFlowImpl$collect$2$emit$1(Api api, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = api;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
