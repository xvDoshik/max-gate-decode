package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001c\b\u0004\u0010\u0002\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0087H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"suspendCoroutineUninterceptedOrReturn", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "COROUTINE_SUSPENDED", "getCOROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
public class IntrinsicsKt__IntrinsicsKt extends IntrinsicsKt__IntrinsicsJvmKt {
    public static /* synthetic */ void getCOROUTINE_SUSPENDED$annotations() {
    }

    private static final <T> Object suspendCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        throw new NotImplementedError(C0000.decode(new byte[]{121, 89, 19, 90, 0, 8, 1, 15, 22, 3, 68, 81, 95, 90, 67, 89, 3, 69, 23, 20, 17, 18, 85, 86, 84, 119, 12, 68, 10, 16, 16, 8, 12, 7, 101, 86, 89, 90, 23, 83, 23, 6, 1, 17, 22, 7, 84, 119, 66, 102, 6, 66, 16, 23, 10, 65, 11, 17, 16, 81, 94, 64, 17, 95, 11, 22, 13, 2}, "04c6eedabb08"));
    }

    public static final Object getCOROUTINE_SUSPENDED() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }
}
