package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a<\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u00020\u000b2\u001a\b\u0004\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH\u0087\bø\u0001\u0000\u001aA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u0002H\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0017\u001a;\u0010\u0018\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001aT\u0010\u0018\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u0002H\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rH\u0087H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001d\"\u001b\u0010\u001e\u001a\u00020\u000b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"resume", "", "T", "Lkotlin/coroutines/Continuation;", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Continuation", "context", "Lkotlin/coroutines/CoroutineContext;", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContinuationKt {
    private static final <T> Continuation<T> Continuation(final CoroutineContext coroutineContext, final Function1<? super Result<? extends T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineContext, C0000.decode(new byte[]{2, 88, 94, 65, 85, 25, 21}, "a7050a"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{17, 7, 71, 67, 92, 80, 54, 10, 69, 93}, "cb4615ac15fddaac", true));
        return new Continuation<T>() { // from class: kotlin.coroutines.ContinuationKt.Continuation.1
            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return coroutineContext;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                function1.invoke(Result.m25boximpl(result));
            }
        };
    }

    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{90, 77, 12, 15, 18, 15}, "f9dfa1fa33ef73", false));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{91, 95, 15, 21, 89, 1, 76, 89, 13, 11}, "80be5d", 6));
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{93, 23, 88, 88, 66, 12}, "ac0112b8", true));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{5, 14, 90, 69, 92, 86, 22, 92, 89, 8}, "fa7503b56f0d27", true));
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError(C0000.decode(new byte[]{44, 84, 65, 13, 1, 15, 81, 89, 77, 0, 83, 19, 4, 74, 17, 8, 10, 22, 70, 94, 87, 22, 94, 80}, "e91adb479e73", 0.0f));
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    private static final <T> void resume(Continuation<? super T> continuation, T t) {
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{93, 18, 11, 91, 74, 91}, "afc29eb3fda5", 0.0f));
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m26constructorimpl(t));
    }

    private static final <T> void resumeWithException(Continuation<? super T> continuation, Throwable th) {
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{95, 16, 9, 10, 18, 7}, "cdaca94aa70a"));
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{92, 73, 81, 6, 19, 65, 10, 89, 91}, "912cc5c6548dee89"));
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m26constructorimpl(ResultKt.createFailure(th)));
    }

    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{12, 23, 11, 88, 21, 88}, "0cc1ffa6", 7));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{5, 94, 92, 66, 10, 80, 71, 81, 13, 13}, "f112f538bc40", 5));
        Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation));
        Result.Companion companion = Result.INSTANCE;
        continuationIntercepted.resumeWith(Result.m26constructorimpl(Unit.INSTANCE));
    }

    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{4, 16, 11, 10, 23, 95}, "8dccdadb7aea71", 0.0f));
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{87, 10, 90, 17, 95, 6, 66, 10, 91, 11}, "4e7a3c6c4e63", 1));
        Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation));
        Result.Companion companion = Result.INSTANCE;
        continuationIntercepted.resumeWith(Result.m26constructorimpl(Unit.INSTANCE));
    }

    private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function1.invoke(safeContinuation);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
