package kotlinx.coroutines.flow.internal;

import com.google.android.gms.common.api.internal.zam;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ zam this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2$1$1$emit$1(zam zamVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = zamVar;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
