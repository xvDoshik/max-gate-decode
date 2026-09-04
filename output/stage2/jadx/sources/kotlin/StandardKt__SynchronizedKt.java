package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/StandardKt")
class StandardKt__SynchronizedKt extends StandardKt__StandardKt {
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    private static final <R> R m36synchronized(Object obj, Function0<? extends R> function0) {
        R rInvoke;
        Intrinsics.checkNotNullParameter(obj, C0000.decode(new byte[]{94, 9, 86, 88}, "2f53a3be64"));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{0, 9, 9, 80, 90}, "bef31f553d5c6b"));
        synchronized (obj) {
            rInvoke = function0.invoke();
        }
        return rInvoke;
    }
}
