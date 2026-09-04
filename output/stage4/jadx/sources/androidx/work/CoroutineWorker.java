package androidx.work;

import android.content.Context;
import androidx.tracing.Trace;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.common.api.Api;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    public final DefaultScheduler coroutineContext;
    public final SettableFuture future;
    public final JobImpl job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $jobFuture;
        public final /* synthetic */ int $r8$classId;
        public Object L$0;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$jobFuture = obj;
            this.this$0 = obj2;
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1((JobListenableFuture) this.$jobFuture, (CoroutineWorker) this.this$0, continuation, 0);
                case 1:
                    return new AnonymousClass1((ConnectionPool) this.L$0, (WorkSpec) this.$jobFuture, (OnConstraintsStateChangedListener) this.this$0, continuation);
                default:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((FlowCollector) this.$jobFuture, (CallbackFlowBuilder) this.this$0, continuation, 2);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) create(coroutineScope, continuation);
                    Unit unit = Unit.INSTANCE;
                    anonymousClass1.invokeSuspend(unit);
                    return unit;
                case 1:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Type inference failed for: r14v14, types: [java.io.Serializable, kotlinx.coroutines.flow.Flow[]] */
        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = (JobListenableFuture) this.$jobFuture;
                        this.label = 1;
                        throw new IllegalStateException(C0000.decode(new byte[]{122, 90, 71, 16, 95, 12, 70, 84, 81, 88, 86, 94, 66, 4, 82}, "45306a68", 0));
                    }
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{1, 83, 84, 13, 65, 22, 11, 23, 69, 64, 93, 18, 20, 15, 1, 16, 66, 80, 93, 7, 14, 16, 1, 23, 69, 91, 86, 23, 14, 9, 1, 16, 66, 69, 81, 21, 9, 66, 7, 88, 16, 93, 77, 21, 8, 12, 1}, "b28aabd7"));
                    }
                    JobListenableFuture jobListenableFuture = (JobListenableFuture) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    jobListenableFuture.underlying.set(obj);
                    return Unit.INSTANCE;
                case 1:
                    WorkSpec workSpec = (WorkSpec) this.$jobFuture;
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        List list = (List) ((ConnectionPool) this.L$0).delegate;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            if (((ConstraintController) obj2).hasConstraint(workSpec)) {
                                arrayList.add(obj2);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList));
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj3 = arrayList.get(i3);
                            i3++;
                            ConstraintController constraintController = (ConstraintController) obj3;
                            constraintController.getClass();
                            arrayList2.add(new CallbackFlowBuilder(0, new ChannelFlow$collectToFun$1(constraintController, null, 1)));
                        }
                        DistinctFlowImpl distinctFlowImpl = new DistinctFlowImpl(new CallbackFlowBuilder(1, (Flow[]) CollectionsKt.toList(arrayList2).toArray(new Flow[0])));
                        Api api = new Api((OnConstraintsStateChangedListener) this.this$0, workSpec, 3, false);
                        this.label = 1;
                        Object objCollect = distinctFlowImpl.collect(api, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objCollect == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException(C0000.decode(new byte[]{0, 81, 14, 88, 16, 18, 90, 21, 70, 67, 87, 17, 19, 85, 6, 23, 66, 86, 85, 0, 90, 71, 4, 17, 21, 11, 8, 78, 12, 91, 7, 19, 16, 17, 92, 65, 9, 17, 81, 13, 20, 87, 22, 68, 11, 90, 85}, "c0b40f55a12bf8", 0.0f));
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                default:
                    int i4 = this.label;
                    Unit unit = Unit.INSTANCE;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            throw new IllegalStateException(C0000.decode(new byte[]{85, 84, 85, 92, 16, 64, 89, 21, 30, 66, 85, 71, 67, 88, 92, 23, 16, 86, 83, 83, 86, 66, 85, 20, 17, 92, 87, 70, 95, 95, 83, 18, 25, 71, 89, 64, 94, 21, 90, 95, 66, 91, 67, 65, 80, 94, 85}, "659004"));
                        }
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    FlowCollector flowCollector = (FlowCollector) this.$jobFuture;
                    Function2 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1((CallbackFlowBuilder) this.this$0, null, 0);
                    ProducerCoroutine producerCoroutine = new ProducerCoroutine(BuildersKt.newCoroutineContext(coroutineScope, EmptyCoroutineContext.INSTANCE), ExceptionsKt.Channel$default(-2, 1, 4));
                    producerCoroutine.start(3, producerCoroutine, channelFlow$collectToFun$1);
                    this.label = 1;
                    Object objEmitAllImpl$FlowKt__ChannelsKt = Headers.Companion.emitAllImpl$FlowKt__ChannelsKt(flowCollector, producerCoroutine, true, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objEmitAllImpl$FlowKt__ChannelsKt != coroutineSingletons2) {
                        objEmitAllImpl$FlowKt__ChannelsKt = unit;
                    }
                    return objEmitAllImpl$FlowKt__ChannelsKt == coroutineSingletons2 ? coroutineSingletons2 : unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConnectionPool connectionPool, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = 1;
            this.L$0 = connectionPool;
            this.$jobFuture = workSpec;
            this.this$0 = onConstraintsStateChangedListener;
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    public final class C00011 extends SuspendLambda implements Function2 {
        public int label;

        public C00011(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CoroutineWorker.this.new C00011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00011) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineWorker coroutineWorker = CoroutineWorker.this;
            SettableFuture settableFuture = coroutineWorker.future;
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = coroutineWorker.doWork();
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{5, 83, 14, 90, 20, 65, 9, 18, 69, 68, 81, 70, 19, 95, 7, 17, 20, 87, 3, 84, 13, 68, 81, 21, 65, 91, 12, 64, 91, 94, 3, 21, 66, 65, 93, 65, 14, 18, 1, 89, 70, 90, 19, 70, 11, 88, 81}, "f2b645", false));
                    }
                    ResultKt.throwOnFailure(obj);
                }
                settableFuture.set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                settableFuture.setException(th);
            }
            return Unit.INSTANCE;
        }
    }

    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.job = new JobImpl();
        SettableFuture settableFuture = new SettableFuture();
        this.future = settableFuture;
        settableFuture.addListener(new CoroutineWorker$$ExternalSyntheticLambda0(0, this), (SerialExecutorImpl) workerParameters.mWorkTaskExecutor.executorServiceOrNull);
        this.coroutineContext = Dispatchers.Default;
    }

    public abstract Object doWork();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        JobImpl jobImpl = new JobImpl();
        DefaultScheduler defaultScheduler = this.coroutineContext;
        defaultScheduler.getClass();
        ContextScope contextScopeCoroutineScope = BuildersKt.CoroutineScope(Trace.plus(defaultScheduler, jobImpl));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(jobImpl);
        BuildersKt.launch$default(contextScopeCoroutineScope, new AnonymousClass1(jobListenableFuture, this, (Continuation) null, 0));
        return jobListenableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        this.future.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final SettableFuture startWork() {
        DefaultScheduler defaultScheduler = this.coroutineContext;
        defaultScheduler.getClass();
        BuildersKt.launch$default(BuildersKt.CoroutineScope(Trace.plus(defaultScheduler, this.job)), new C00011(null));
        return this.future;
    }
}
