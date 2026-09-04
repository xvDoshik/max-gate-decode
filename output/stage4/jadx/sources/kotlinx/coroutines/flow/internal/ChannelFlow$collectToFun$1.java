package kotlinx.coroutines.flow.internal;

import androidx.work.SystemClock;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.ConstraintTrackerKt;
import java.util.Objects;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ChannelFlow$collectToFun$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlow$collectToFun$1(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1((CallbackFlowBuilder) this.this$0, continuation, 0);
                channelFlow$collectToFun$1.L$0 = obj;
                return channelFlow$collectToFun$1;
            default:
                ChannelFlow$collectToFun$1 channelFlow$collectToFun$2 = new ChannelFlow$collectToFun$1((ConstraintController) this.this$0, continuation, 1);
                channelFlow$collectToFun$2.L$0 = obj;
                return channelFlow$collectToFun$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ProducerScope producerScope = (ProducerScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((ChannelFlow$collectToFun$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.work.impl.constraints.controllers.ConstraintController$track$1$1] */
    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope = (ProducerScope) this.L$0;
                    CallbackFlowBuilder callbackFlowBuilder = (CallbackFlowBuilder) this.this$0;
                    this.label = 1;
                    if (callbackFlowBuilder.collectTo(producerScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{83, 3, 9, 84, 16, 70, 95, 66, 66, 74, 85, 65, 69, 15, 0, 31, 16, 80, 85, 4, 10, 74, 85, 18, 23, 11, 11, 78, 95, 89, 85, 69, 69, 79, 89, 70, 88, 66, 6, 87, 66, 93, 69, 22, 12, 86, 85}, "0be802", 0.0f));
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ConstraintController constraintController = (ConstraintController) this.this$0;
                    final ConstraintController$track$1$listener$1 constraintController$track$1$listener$1 = new ConstraintController$track$1$listener$1(constraintController, producerScope2);
                    ConstraintTracker constraintTracker = constraintController.tracker;
                    synchronized (constraintTracker.lock) {
                        try {
                            if (constraintTracker.listeners.add(constraintController$track$1$listener$1)) {
                                if (constraintTracker.listeners.size() == 1) {
                                    constraintTracker.currentState = constraintTracker.readSystemState();
                                    SystemClock systemClock = SystemClock.get();
                                    int i3 = ConstraintTrackerKt.$r8$clinit;
                                    Objects.toString(constraintTracker.currentState);
                                    systemClock.getClass();
                                    constraintTracker.startTracking();
                                }
                                constraintController$track$1$listener$1.onConstraintChanged(constraintTracker.currentState);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    final ConstraintController constraintController2 = (ConstraintController) this.this$0;
                    ?? r3 = new Function0() { // from class: androidx.work.impl.constraints.controllers.ConstraintController$track$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            ConstraintTracker constraintTracker2 = constraintController2.tracker;
                            ConstraintController$track$1$listener$1 constraintController$track$1$listener$2 = constraintController$track$1$listener$1;
                            synchronized (constraintTracker2.lock) {
                                if (constraintTracker2.listeners.remove(constraintController$track$1$listener$2) && constraintTracker2.listeners.isEmpty()) {
                                    constraintTracker2.stopTracking();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (ResultKt.awaitClose(producerScope2, r3, this) == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{80, 2, 85, 13, 70, 16, 92, 67, 30, 19, 3, 23, 70, 14, 92, 70, 70, 6, 86, 5, 86, 19, 3, 68, 20, 10, 87, 23, 9, 15, 86, 68, 25, 22, 15, 16, 91, 67, 90, 14, 20, 11, 70, 23, 80, 15, 3}, "3c9afd", 0.0f));
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
