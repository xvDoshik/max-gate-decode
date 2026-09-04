package androidx.work.impl.constraints;

import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkConstraintsTracker$track$$inlined$combine$1$3 extends SuspendLambda implements Function {
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object[] L$1;
    public int label;

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConstraintsState constraintsState;
        ConstraintsState constraintsState2;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.L$0;
            ConstraintsState[] constraintsStateArr = (ConstraintsState[]) this.L$1;
            int length = constraintsStateArr.length;
            int i2 = 0;
            while (true) {
                constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                if (i2 >= length) {
                    constraintsState2 = null;
                    break;
                }
                constraintsState2 = constraintsStateArr[i2];
                if (!Intrinsics.areEqual(constraintsState2, constraintsState)) {
                    break;
                }
                i2++;
            }
            if (constraintsState2 != null) {
                constraintsState = constraintsState2;
            }
            this.label = 1;
            Object objEmit = flowCollector.emit(constraintsState, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objEmit == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(C0000.decode(new byte[]{84, 5, 91, 85, 25, 67, 95, 70, 19, 70, 85, 68, 70, 92, 82, 67, 23, 91, 92, 81, 95, 20, 81, 20, 23, 94, 93, 71, 88, 15, 82, 30, 25, 64, 89, 18, 92, 20, 83, 88, 65, 94, 66, 16, 94, 87, 92}, "7d79970f440731"));
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
