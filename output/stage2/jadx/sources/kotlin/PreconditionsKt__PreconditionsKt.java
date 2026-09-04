package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"require", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "requireNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "check", "checkNotNull", "error", "", "message", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/PreconditionsKt")
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    private static final void check(boolean z) {
        if (!z) {
            throw new IllegalStateException(C0000.decode(new byte[]{112, 90, 84, 0, 90, 18, 95, 86, 11, 10, 1, 2, 74}, "321c1297bfdfde9b"));
        }
    }

    private static final void check(boolean z, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{15, 81, 73, 79, 126, 84, 16, 67, 82, 81, 86}, "c03631", 0.0f));
        if (!z) {
            throw new IllegalStateException(function0.invoke().toString());
        }
    }

    private static final <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{99, 87, 65, 69, 93, 64, 80, 86, 69, 65, 80, 94, 69, 85, 20, 69, 84, 65, 69, 89, 68, 94, 92, 30}, "12004252e7").toString());
    }

    private static final <T> T checkNotNull(T t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{13, 80, 28, 65, 46, 3, 65, 17, 0, 86, 3}, "a1f8cf2b", 0.0f));
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(function0.invoke().toString());
    }

    private static final Void error(Object obj) {
        Intrinsics.checkNotNullParameter(obj, C0000.decode(new byte[]{93, 80, 21, 69, 0, 2, 1}, "05f6aedaaf0b03", 0));
        throw new IllegalStateException(obj.toString());
    }

    private static final void require(boolean z) {
        if (!z) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 87, 89, 15, 7, 5, 69, 17, 3, 68, 76, 95, 66, 6, 15, 4, 11, 23, 72}, "960cbaecf5", 0.0f).toString());
        }
    }

    private static final void require(boolean z, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{93, 89, 31, 75, 46, 85, 18, 65, 85, 87, 1}, "18e2c0a240df10"));
        if (!z) {
            throw new IllegalArgumentException(function0.invoke().toString());
        }
    }

    private static final <T> T requireNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{107, 81, 16, 64, 13, 75, 7, 87, 24, 71, 88, 8, 20, 93, 25, 67, 0, 70, 68, 87, 23, 95, 84, 31}, "94a5d9b3819da8").toString());
    }

    private static final <T> T requireNotNull(T t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{93, 85, 66, 75, 120, 87, 18, 16, 7, 2, 3}, "148252acfef8a017"));
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(function0.invoke().toString());
    }
}
