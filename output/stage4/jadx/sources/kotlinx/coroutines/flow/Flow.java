package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Flow {
    Object collect(FlowCollector flowCollector, SuspendLambda suspendLambda);
}
