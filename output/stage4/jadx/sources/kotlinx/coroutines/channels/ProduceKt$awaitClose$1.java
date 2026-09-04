package kotlinx.coroutines.channels;

import androidx.work.impl.constraints.controllers.ConstraintController$track$1$1;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    public ConstraintController$track$1$1 L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ResultKt.awaitClose(null, null, this);
    }
}
