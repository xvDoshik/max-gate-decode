package kotlinx.coroutines.flow;

import androidx.work.CoroutineWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.text.CharsKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.flow.internal.FlowCoroutine;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.Handshake;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CallbackFlowBuilder implements Flow {
    public final /* synthetic */ int $r8$classId;
    public final Serializable block$1;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public ProducerScope L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallbackFlowBuilder.this.collectTo(null, this);
        }
    }

    public /* synthetic */ CallbackFlowBuilder(int i, Serializable serializable) {
        this.$r8$classId = i;
        this.block$1 = serializable;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, SuspendLambda suspendLambda) {
        switch (this.$r8$classId) {
            case 0:
                CoroutineWorker.AnonymousClass1 anonymousClass1 = new CoroutineWorker.AnonymousClass1(flowCollector, this, (Continuation) null, 2);
                ScopeCoroutine scopeCoroutine = new ScopeCoroutine(suspendLambda._context, suspendLambda);
                Object objStartUndispatchedOrReturn = CharsKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, anonymousClass1);
                return objStartUndispatchedOrReturn == CoroutineSingletons.COROUTINE_SUSPENDED ? objStartUndispatchedOrReturn : Unit.INSTANCE;
            default:
                Flow[] flowArr = (Flow[]) this.block$1;
                CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(flowArr, new Handshake.AnonymousClass2(4, flowArr), new WorkConstraintsTracker$track$$inlined$combine$1$3(3, null), flowCollector, null);
                FlowCoroutine flowCoroutine = new FlowCoroutine(suspendLambda._context, suspendLambda);
                Object objStartUndispatchedOrReturn2 = CharsKt.startUndispatchedOrReturn(flowCoroutine, flowCoroutine, combineKt$combineInternal$2);
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objStartUndispatchedOrReturn2 != coroutineSingletons) {
                    objStartUndispatchedOrReturn2 = unit;
                }
                return objStartUndispatchedOrReturn2 == coroutineSingletons ? objStartUndispatchedOrReturn2 : unit;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object collectTo(ProducerScope producerScope, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Unit unit = Unit.INSTANCE;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = producerScope;
            anonymousClass1.label = 1;
            Object objInvoke = ((ChannelFlow$collectToFun$1) this.block$1).invoke(producerScope, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke != coroutineSingletons) {
                objInvoke = unit;
            }
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException(C0000.decode(new byte[]{0, 88, 91, 84, 16, 16, 12, 25, 16, 74, 85, 23, 22, 84, 82, 31, 16, 6, 6, 95, 88, 74, 85, 68, 68, 80, 89, 78, 95, 15, 6, 30, 23, 79, 89, 16, 11, 25, 84, 87, 66, 11, 22, 77, 94, 86, 85}, "c9780d", false));
            }
            producerScope = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((ProducerCoroutine) producerScope)._channel.isClosedForSend()) {
            return unit;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{66, 83, 66, 89, 94, 64, 32, 88, 12, 69, 4, 70, 30, 18, 76, 87, 66, 70, 32, 85, 15, 90, 3, 7, 6, 89, 122, 74, 123, 93, 16, 64, 6, 88, 4, 20, 75, 81, 84, 86, 84, 81, 15, 28, 74, 22, 28, 65, 69, 65, 93, 87, 66, 88, 7, 20, 1, 83, 65, 19, 22, 87, 81, 24, 94, 90, 67, 64, 11, 83, 65, 3, 11, 86, 21, 87, 81, 20, 0, 85, 15, 90, 3, 7, 6, 89, 115, 84, 88, 67, 67, 86, 15, 89, 2, 13, 75, 56, 122, 76, 95, 81, 17, 67, 10, 69, 4, 74, 69, 83, 21, 91, 86, 88, 15, 86, 2, 85, 10, 73, 9, 91, 70, 76, 82, 90, 6, 70, 67, 91, 0, 31, 69, 94, 80, 89, 92, 20, 10, 90, 67, 85, 0, 21, 0, 18, 90, 94, 23, 81, 27, 64, 6, 68, 15, 7, 9, 18, 86, 89, 89, 87, 6, 88, 15, 87, 21, 15, 10, 92, 27, 50, 100, 81, 6, 20, 0, 87, 13, 10, 7, 83, 86, 83, 113, 88, 12, 67, 67, 119, 49, 47, 69, 86, 90, 91, 66, 89, 6, 90, 23, 87, 21, 15, 10, 92, 21, 94, 88, 70, 67, 64, 11, 83, 65, 2, 0, 70, 84, 81, 91, 71, 77}, "e25874c4c6af", 4));
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return C0000.decode(new byte[]{91, 94, 88, 80, 14, 62}, "9273ee5b44b60d", true) + ((ChannelFlow$collectToFun$1) this.block$1) + C0000.decode(new byte[]{57, 68, 27, 13, 25}, "dd6399d5d90bf70e", true) + toString$kotlinx$coroutines$flow$internal$ChannelFlow();
            default:
                return super.toString();
        }
    }

    public String toString$kotlinx$coroutines$flow$internal$ChannelFlow() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(C0000.decode(new byte[]{6, 3, 67, 4, 7, 81, 71, 29, 88, 79, 1}, "eb3ed83d"));
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append(CollectionsKt.joinToString$default(arrayList, C0000.decode(new byte[]{28, 25}, "09381c9acc45", 0), null, 62));
        sb.append(']');
        return sb.toString();
    }
}
