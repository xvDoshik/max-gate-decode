package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u001a2\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001aG\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0005*\u0002H\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00050\n¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001aK\u0010\r\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u000e\u001a\u0002H\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00050\n¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\f\u001aA\u0010\u000f\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00100\n¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a<\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00100\nH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001aB\u0010\u0012\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0005*\u0002H\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00050\nH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a>\u0010\u0013\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00150\nH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a>\u0010\u0016\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t*\u0002H\t2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00150\nH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a3\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\nH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"TODO", "", "reason", "", "run", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "with", "receiver", "apply", "", "also", "let", "takeIf", "predicate", "", "takeUnless", "repeat", "times", "", "action", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/StandardKt")
class StandardKt__StandardKt {
    private static final Void TODO(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{70, 84, 80, 75, 95, 88}, "411806f3", 0.0f));
        throw new NotImplementedError(C0000.decode(new byte[]{116, 13, 70, 12, 64, 4, 71, 2, 18, 10, 95, 15, 21, 10, 21, 67, 94, 14, 65, 67, 15, 14, 64, 13, 80, 14, 3, 13, 68, 4, 81, 89, 70}, "5cfc0a", 3) + str);
    }

    private static final <T> T also(T t, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{82, 95, 88, 81, 15}, "0372d08361"));
        function1.invoke(t);
        return t;
    }

    private static final <T> T apply(T t, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{80, 15, 12, 1, 89}, "2ccb2ac6b68973e8", false));
        function1.invoke(t);
        return t;
    }

    private static final <T, R> R let(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{83, 84, 90, 83, 13}, "1850f9f6"));
        return function1.invoke(t);
    }

    private static final void repeat(int i, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{5, 84, 23, 93, 11, 13}, "d7c4dc51", 0.0f));
        for (int i2 = 0; i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final <T, R> R run(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{7, 93, 11, 2, 89}, "e1da21ac", 0.0f));
        return function1.invoke(t);
    }

    private static final <R> R run(Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{0, 93, 93, 83, 93}, "b120609977ca0e25", 0.0f));
        return function0.invoke();
    }

    private static final <T> T takeIf(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{68, 23, 87, 87, 91, 2, 80, 22, 92}, "4e232a1b96", false));
        if (function1.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    private static final <T> T takeUnless(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{65, 22, 4, 7, 13, 7, 87, 66, 3}, "1dacdd66fd489c51", false));
        if (function1.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    private static final <T, R> R with(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{7, 84, 90, 2, 91}, "e85a00c889682cfe", 0.0f));
        return function1.invoke(t);
    }

    private static final Void TODO() {
        throw new NotImplementedError(null, 1, null);
    }
}
