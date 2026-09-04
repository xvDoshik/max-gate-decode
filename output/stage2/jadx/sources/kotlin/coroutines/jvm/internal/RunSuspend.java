package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u000f\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "resumeWith", "(Ljava/lang/Object;)V", "await", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RunSuspend implements Continuation<Unit> {
    private Result<Unit> result;

    public final void await() {
        synchronized (this) {
            while (true) {
                Result<Unit> result = this.result;
                if (result == null) {
                    Intrinsics.checkNotNull(this, C0000.decode(new byte[]{12, 71, 13, 94, 24, 0, 3, 92, 15, 93, 76, 67, 0, 87, 65, 81, 89, 16, 22, 18, 21, 93, 24, 13, 13, 92, 76, 92, 77, 15, 14, 18, 21, 75, 72, 6, 66, 88, 0, 68, 89, 77, 14, 83, 15, 85, 22, 44, 0, 88, 4, 81, 76}, "b2a28c"));
                    wait();
                } else {
                    ResultKt.throwOnFailure(result.getValue());
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        synchronized (this) {
            this.result = Result.m25boximpl(result);
            Intrinsics.checkNotNull(this, C0000.decode(new byte[]{89, 67, 85, 94, 16, 85, 5, 10, 88, 87, 22, 16, 85, 83, 25, 81, 81, 69, 16, 68, 66, 87, 66, 94, 88, 88, 20, 92, 69, 90, 8, 68, 66, 65, 18, 85, 23, 92, 88, 68, 81, 24, 8, 5, 88, 95, 76, ByteCompanionObject.MAX_VALUE, 85, 92, 92, 81, 68}, "769206dd68b0", 2));
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* JADX INFO: renamed from: getResult-xLWZpok, reason: not valid java name */
    public final Result<Unit> m1237getResultxLWZpok() {
        return this.result;
    }

    public final void setResult(Result<Unit> result) {
        this.result = result;
    }
}
