package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompletedContinuation implements Continuation<Object> {
    public static final CompletedContinuation INSTANCE = new CompletedContinuation();

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        throw new IllegalStateException(C0000.decode(new byte[]{49, 11, 15, 64, 70, 1, 89, 88, 17, 10, 8, 70, 7, 22, 95, 89, 11, 67, 15, 64, 70, 3, 90, 68, 0, 2, 2, 74, 70, 1, 89, 91, 21, 15, 3, 71, 3}, "ecf3fb66", 0.0f).toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        throw new IllegalStateException(C0000.decode(new byte[]{54, 11, 13, 16, 19, 1, 91, 15, 22, 10, 10, 22, 82, 22, 93, 14, 12, 67, 13, 16, 19, 3, 88, 19, 7, 2, 0, 26, 19, 1, 91, 12, 18, 15, 1, 23, 86}, "bcdc3b4a", 0.0f).toString());
    }

    public String toString() {
        return C0000.decode(new byte[]{101, 12, 13, 64, 17, 81, 9, 11, 69, 13, 10, 70, 80, 70, 15, 10, 95, 68, 13, 64, 17, 83, 10, 23, 84, 5, 0, 74, 17, 81, 9, 8, 65, 8, 1, 71, 84}, "1dd312fe", false);
    }

    private CompletedContinuation() {
    }
}
