package kotlinx.coroutines.flow.internal;

import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3;
import com.google.android.gms.common.api.internal.zam;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.Handshake;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Handshake.AnonymousClass2 $arrayFactory;
    public final /* synthetic */ Flow[] $flows;
    public final /* synthetic */ FlowCollector $this_combineInternal;
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1$3 $transform;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Channel L$1;
    public byte[] L$2;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Flow[] $flows;
        public final /* synthetic */ int $i;
        public final /* synthetic */ AtomicInteger $nonClosed;
        public final /* synthetic */ BufferedChannel $resultChannel;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow[] flowArr, int i, AtomicInteger atomicInteger, BufferedChannel bufferedChannel, Continuation continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$i = i;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = bufferedChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            AtomicInteger atomicInteger = this.$nonClosed;
            BufferedChannel bufferedChannel = this.$resultChannel;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow[] flowArr = this.$flows;
                    int i2 = this.$i;
                    Flow flow = flowArr[i2];
                    zam zamVar = new zam(bufferedChannel, i2);
                    this.label = 1;
                    Object objCollect = flow.collect(zamVar, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCollect == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{84, 85, 9, 84, 66, 71, 90, 70, 16, 70, 0, 75, 23, 94, 80, 65, 23, 86, 0, 94, 13, 65, 80, 70, 16, 93, 11, 78, 13, 88, 80, 65, 23, 67, 12, 76, 10, 19, 86, 9, 69, 91, 16, 76, 11, 93, 80}, "74e8b35f", 7));
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    bufferedChannel.closeOrCancelImpl(null, false);
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                if (atomicInteger.decrementAndGet() == 0) {
                    bufferedChannel.closeOrCancelImpl(null, false);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(Flow[] flowArr, Handshake.AnonymousClass2 anonymousClass2, WorkConstraintsTracker$track$$inlined$combine$1$3 workConstraintsTracker$track$$inlined$combine$1$3, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = anonymousClass2;
        this.$transform = workConstraintsTracker$track$$inlined$combine$1$3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cc A[DONT_INVERT, EDGE_INSN: B:41:0x00cc->B:20:0x008a BREAK  A[LOOP:0: B:30:0x00ab->B:47:?]] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:0: B:30:0x00ab->B:47:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00f7 -> B:20:0x008a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
