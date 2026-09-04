package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzag;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.YieldContext;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zam implements FlowCollector {
    public int zaa;
    public final Object zab;

    public zam(BufferedChannel bufferedChannel, int i) {
        this.zab = bufferedChannel;
        this.zaa = i;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, ContinuationImpl continuationImpl) {
        CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
        Object obj2;
        if (continuationImpl instanceof CombineKt$combineInternal$2$1$1$emit$1) {
            combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuationImpl;
            int i = combineKt$combineInternal$2$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                combineKt$combineInternal$2$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuationImpl);
            }
        } else {
            combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuationImpl);
        }
        Object obj3 = combineKt$combineInternal$2$1$1$emit$1.result;
        int i2 = combineKt$combineInternal$2$1$1$emit$1.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            BufferedChannel bufferedChannel = (BufferedChannel) this.zab;
            IndexedValue indexedValue = new IndexedValue(this.zaa, obj);
            combineKt$combineInternal$2$1$1$emit$1.label = 1;
            if (bufferedChannel.send(indexedValue, combineKt$combineInternal$2$1$1$emit$1) != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException(C0000.decode(new byte[]{80, 82, 91, 13, 69, 65, 11, 18, 67, 71, 82, 71, 66, 8, 86, 20, 23, 3, 0, 83, 11, 64, 1, 21, 16, 93, 89, 19, 92, 88, 82, 70, 69, 66, 13, 70, 12, 21, 84, 91, 69, 10, 70, 71, 94, 15, 0}, "337ae5d2d5747e", false));
            }
            ResultKt.throwOnFailure(obj3);
            return unit;
        }
        ResultKt.throwOnFailure(obj3);
        combineKt$combineInternal$2$1$1$emit$1.label = 2;
        CoroutineContext coroutineContext = combineKt$combineInternal$2$1$1$emit$1._context;
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null && !job.isActive()) {
            throw ((JobSupport) job).getCancellationException();
        }
        Continuation continuationIntercepted = Headers.Companion.intercepted(combineKt$combineInternal$2$1$1$emit$1);
        DispatchedContinuation dispatchedContinuation = continuationIntercepted instanceof DispatchedContinuation ? (DispatchedContinuation) continuationIntercepted : null;
        if (dispatchedContinuation == null) {
            obj2 = unit;
        } else {
            CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
            if (coroutineDispatcher.isDispatchNeeded()) {
                dispatchedContinuation._state = unit;
                dispatchedContinuation.resumeMode = 1;
                coroutineDispatcher.dispatchYield(coroutineContext, dispatchedContinuation);
            } else {
                CoroutineContext coroutineContextPlus = coroutineContext.plus(new YieldContext(YieldContext.Key));
                dispatchedContinuation._state = unit;
                dispatchedContinuation.resumeMode = 1;
                coroutineDispatcher.dispatchYield(coroutineContextPlus, dispatchedContinuation);
            }
            obj2 = coroutineSingletons;
        }
        if (obj2 != coroutineSingletons) {
            obj2 = unit;
        }
        return obj2 == coroutineSingletons ? coroutineSingletons : unit;
    }

    public boolean hasNext() {
        return this.zaa < ((ArrayList) this.zab).size();
    }

    public zam(ConnectionResult connectionResult, int i) {
        zzag.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = i;
    }

    public zam(ArrayList arrayList) {
        this.zab = arrayList;
    }
}
