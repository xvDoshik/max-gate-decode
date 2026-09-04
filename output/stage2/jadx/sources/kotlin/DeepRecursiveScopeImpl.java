package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004BJ\u00129\u0010\u0005\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0017\u001a\u00020\u00182\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001bJ2\u0010\u001a\u001a\u0002H\u001c\"\u0004\b\u0002\u0010\u001d\"\u0004\b\u0003\u0010\u001c*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001c0\u001e2\u0006\u0010\t\u001a\u0002H\u001dH\u0096@¢\u0006\u0002\u0010\u001fJd\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042=\u0010!\u001a9\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\r¢\u0006\u0002\b\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0002¢\u0006\u0002\u0010\"J\u000b\u0010#\u001a\u00028\u0001¢\u0006\u0002\u0010$RG\u0010\f\u001a9\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\r¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "<init>", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "function", "Lkotlin/DeepRecursiveFunctionBlock;", "Lkotlin/jvm/functions/Function3;", "cont", "result", "Lkotlin/Result;", "Ljava/lang/Object;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "(Ljava/lang/Object;)V", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "runCallLoop", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {
    private Continuation<Object> cont;
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function;
    private Object result;
    private Object value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeepRecursiveScopeImpl(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3, T t) {
        super(null);
        Intrinsics.checkNotNullParameter(function3, C0000.decode(new byte[]{7, 15, 87, 83, 83}, "ec80892dcd"));
        this.function = function3;
        this.value = t;
        Intrinsics.checkNotNull(this, C0000.decode(new byte[]{8, 22, 85, 13, 24, 80, 81, 10, 8, 14, 18, 67, 91, 4, 24, 80, 81, 23, 18, 65, 18, 12, 25, 15, 87, 93, 29, 10, 19, 13, 10, 67, 77, 24, 72, 86, 16, 15, 9, 21, 10, 10, 87, 79, 91, 92, 66, 11, 19, 21, 15, 13, 92, 18, 22, 112, 95, 10, 18, 8, 8, 22, 88, 21, 81, 92, 94, 88, 13, 14, 18, 15, 80, 15, 22, 114, 94, 29, 89, 95}, "fc9a830dfa", true));
        this.cont = this;
        this.result = DeepRecursiveKt.UNDEFINED_RESULT;
    }

    @Override // kotlin.DeepRecursiveScope
    public Object callRecursive(T t, Continuation<? super R> continuation) {
        Intrinsics.checkNotNull(continuation, C0000.decode(new byte[]{11, 19, 85, 90, 65, 81, 82, 12, 86, 87, 77, 22, 7, 3, 25, 85, 0, 65, 71, 66, 76, 87, 25, 88, 10, 8, 20, 88, 20, 94, 95, 66, 76, 65, 73, 83, 69, 13, 86, 66, 13, 91, 93, 76, 91, 87, 75, 89, 16, 18, 80, 88, 4, 65, 29, 33, 87, 86, 77, 95, 11, 19, 88, 66, 8, 93, 93, 94, 83, 87, 77, 90, 12, 8, 23, 119, 15, 75, 12, 92}, "ef96a23b8896"));
        this.cont = continuation;
        this.value = t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // kotlin.DeepRecursiveScope
    public <U, S> Object callRecursive(DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, Continuation<? super S> continuation) {
        Function3<DeepRecursiveScope<U, S>, U, Continuation<? super S>, Object> block$kotlin_stdlib = deepRecursiveFunction.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNull(block$kotlin_stdlib, C0000.decode(new byte[]{13, 77, 84, 88, 21, 6, 86, 13, 86, 12, 23, 24, 90, 81, 21, 6, 86, 16, 76, 67, 23, 87, 24, 90, 90, 11, 26, 13, 77, 15, 15, 24, 76, 77, 69, 0, 23, 35, 99, 38, 27, 76, 93, 90, 70, 12, 88, 13, 126, 22, 13, 91, 76, 93, 90, 11, 99, 26, 72, 6, 62, 24, 83, 91, 65, 9, 94, 13, 22, 0, 12, 74, 87, 65, 65, 12, 89, 6, 75, 77, 48, 77, 75, 68, 80, 11, 83, 37, 77, 13, 0, 76, 81, 91, 91, 87, 11, 8, 87, 23, 15, 81, 86, 26, 113, 0, 82, 19, 106, 6, 0, 77, 74, 71, 92, 19, 82, 48, 91, 12, 19, 93, 4, 30, 25, 69, 29, 93, 20, 67, 8, 87, 76, 88, 92, 11, 25, 34, 86, 26, 92, 20, 24, 95, 90, 17, 91, 10, 86, 77, 34, 86, 65, 11, 11}, "c8845e7c8c", true));
        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.function;
        String strDecode = C0000.decode(new byte[]{89, 16, 93, 92, 22, 6, 84, 95, 87, 9, 17, 20, 81, 82, 68, 5, 86, 22, 69, 16, 66, 10, 21, 95, 86, 8, 72, 90, 70, 91, 8, 70, 67, 28, 65, 85, 22, 14, 90, 69, 85, 15, 11, 26, 80, 88, 22, 9, 66, 17, 88, 94, 83, 22, 27, 114, 86, 8, 17, 93, 93, 66, 5, 18, 94, 10, 95, 12, 93, 10, 65, 93, 80, 8, 75, 117, 93, 78, 91, 88}, "7e106e519fe437df");
        if (block$kotlin_stdlib != function3) {
            this.function = block$kotlin_stdlib;
            Intrinsics.checkNotNull(continuation, strDecode);
            this.cont = crossFunctionCompletion(function3, continuation);
        } else {
            Intrinsics.checkNotNull(continuation, strDecode);
            this.cont = continuation;
        }
        this.value = u;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        this.cont = null;
        this.result = result;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public CoroutineContext get$context() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final Continuation<Object> crossFunctionCompletion(final Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> currentFunction, final Continuation<Object> cont) {
        final EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        return new Continuation<Object>() { // from class: kotlin.DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return emptyCoroutineContext;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                this.function = currentFunction;
                this.cont = cont;
                this.result = result;
            }
        };
    }

    public final R runCallLoop() throws Throwable {
        while (true) {
            R r = (R) this.result;
            Continuation<Object> continuation = this.cont;
            if (continuation != null) {
                if (!Result.m28equalsimpl0(DeepRecursiveKt.UNDEFINED_RESULT, r)) {
                    this.result = DeepRecursiveKt.UNDEFINED_RESULT;
                    continuation.resumeWith(r);
                } else {
                    try {
                        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.function;
                        Object obj = this.value;
                        Object objWrapWithContinuationImpl = !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function3, this, obj, continuation) : ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(this, obj, continuation);
                        if (objWrapWithContinuationImpl != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            Result.Companion companion = Result.INSTANCE;
                            continuation.resumeWith(Result.m26constructorimpl(objWrapWithContinuationImpl));
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation.resumeWith(Result.m26constructorimpl(ResultKt.createFailure(th)));
                    }
                }
            } else {
                ResultKt.throwOnFailure(r);
                return r;
            }
        }
    }
}
