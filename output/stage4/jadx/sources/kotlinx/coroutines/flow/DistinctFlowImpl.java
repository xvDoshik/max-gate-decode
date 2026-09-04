package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DistinctFlowImpl implements Flow {
    public final CallbackFlowBuilder upstream;

    public DistinctFlowImpl(CallbackFlowBuilder callbackFlowBuilder) {
        this.upstream = callbackFlowBuilder;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, SuspendLambda suspendLambda) {
        Regex regex = new Regex(1);
        regex.nativePattern = NullSurrogateKt.NULL;
        Object objCollect = this.upstream.collect(new Api(this, regex, flowCollector), suspendLambda);
        return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
    }
}
