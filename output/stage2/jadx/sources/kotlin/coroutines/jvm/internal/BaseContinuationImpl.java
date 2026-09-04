package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rH$¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "<init>", "(Lkotlin/coroutines/Continuation;)V", "getCompletion", "()Lkotlin/coroutines/Continuation;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "create", "value", "toString", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public Continuation<Unit> create(Object value, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, C0000.decode(new byte[]{83, 12, 11, 18, 89, 84, 77, 80, 11, 90}, "0cfb5199d426", false));
        throw new UnsupportedOperationException(C0000.decode(new byte[]{80, 16, 6, 87, 76, 7, 16, 119, 15, 24, 12, 89, 32, 89, 86, 22, 81, 88, 20, 0, 71, 11, 12, 88, 17, 66, 80, 87, 18, 65, 93, 13, 23, 22, 90, 7, 93, 88, 65, 14, 69, 7, 17, 68, 81, 6, 92, 83, 15}, "3bc68b86aa", 0.0f));
    }

    public Continuation<Unit> create(Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, C0000.decode(new byte[]{7, 11, 89, 21, 91, 83, 16, 13, 91, 11}, "dd4e76", 2));
        throw new UnsupportedOperationException(C0000.decode(new byte[]{91, 70, 1, 87, 22, 82, 16, 119, 11, 88, 22, 94, 86, 65, 5, 66, 11, 88, 86, 29, 68, 94, 3, 68, 24, 90, 11, 66, 66, 85, 93, 81, 10, 22, 13, 65, 93, 70, 22, 95, 6, 83, 93, 90}, "84d6b7", false));
    }

    protected abstract Object invokeSuspend(Object result);

    protected void releaseIntercepted() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{37, 86, 93, 22, 95, 8, 16, 7, 18, 80, 92, 12, 22, 7, 17, 70}, "f93b6fef", 0.0f));
        Serializable stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        return sb.append(stackTraceElement).toString();
    }

    public BaseContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object result) {
        Continuation<Object> continuation = this;
        while (true) {
            DebugProbesKt.probeCoroutineResumed(continuation);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) continuation;
            Continuation<Object> continuation2 = baseContinuationImpl.completion;
            Intrinsics.checkNotNull(continuation2);
            try {
                Object objInvokeSuspend = baseContinuationImpl.invokeSuspend(result);
                if (objInvokeSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return;
                }
                Result.Companion companion = Result.INSTANCE;
                result = Result.m26constructorimpl(objInvokeSuspend);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                result = Result.m26constructorimpl(ResultKt.createFailure(th));
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(continuation2 instanceof BaseContinuationImpl)) {
                continuation2.resumeWith(result);
                return;
            }
            continuation = continuation2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }
}
