package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(Continuation<Object> continuation) {
        super(continuation);
        if (continuation != null && continuation.getContext() != EmptyCoroutineContext.INSTANCE) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{116, 10, 69, 86, 16, 71, 15, 10, 4, 17, 17, 19, 8, 21, 95, 69, 69, 92, 22, 71, 20, 13, 2, 22, 84, 0, 65, 18, 66, 22, 71, 92, 11, 64, 15, 11, 15, 66, 92, 17, 18, 21, 23, 13, 86, 79, 0, 19, 35, 9, 17, 22, 72, 39, 14, 19, 88, 16, 67, 80, 11, 86, 37, 11, 15, 22, 84, 28, 21}, "7e79e3fdab1daa").toString());
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
