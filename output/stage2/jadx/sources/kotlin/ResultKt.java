package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\f\u001a@\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\t*\u0002H\r2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\t0\u000e¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0006H\u0087\b¢\u0006\u0002\u0010\u0012\u001a[\u0010\u0013\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001a0\u0010\u0017\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062\u0006\u0010\u0018\u001a\u0002H\tH\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0084\u0001\u0010\u001a\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\t0\u000e2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001d\u001a]\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001aP\u0010 \u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aa\u0010!\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001aT\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u001aW\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010#\u001a\u001d\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"createFailure", "", "exception", "", "throwOnFailure", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "runCatching", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "onFailure", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "fold", "onSuccess", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "map", "transform", "mapCatching", "recover", "recoverCatching", "action", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ResultKt {
    public static final Object createFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{80, 76, 87, 86, 19, 77, 15, 88, 91}, "5443c9f75e"));
        return new Result.Failure(th);
    }

    private static final <R, T> R fold(Object obj, Function1<? super T, ? extends R> function1, Function1<? super Throwable, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{86, 15, 106, 64, 0, 0, 93, 23, 65}, "9a95cc8d27", 5));
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{11, 90, 39, 84, 8, 84, 76, 68, 1}, "d4a5a896", 0.0f));
        Throwable thM29exceptionOrNullimpl = Result.m29exceptionOrNullimpl(obj);
        return thM29exceptionOrNullimpl == null ? function1.invoke(obj) : function2.invoke(thM29exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{94, 92, 126, 2, 95, 8, 77, 70, 84}, "128c6d841aac", 1));
        Throwable thM29exceptionOrNullimpl = Result.m29exceptionOrNullimpl(obj);
        return thM29exceptionOrNullimpl == null ? obj : function1.invoke(thM29exceptionOrNullimpl);
    }

    private static final <R, T> Object map(Object obj, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{66, 71, 0, 91, 22, 86, 11, 74, 95}, "65a5e0d82c1b988b", 5));
        if (!Result.m33isSuccessimpl(obj)) {
            return Result.m26constructorimpl(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m26constructorimpl(function1.invoke(obj));
    }

    private static final <R, T> Object mapCatching(Object obj, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{68, 71, 84, 11, 75, 4, 89, 68, 14}, "055e8b66cc"));
        if (!Result.m33isSuccessimpl(obj)) {
            return Result.m26constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m26constructorimpl(function1.invoke(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m26constructorimpl(createFailure(th));
        }
    }

    private static final <T> Object onFailure(Object obj, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{5, 0, 21, 89, 93, 92}, "dca022ee", 1));
        Throwable thM29exceptionOrNullimpl = Result.m29exceptionOrNullimpl(obj);
        if (thM29exceptionOrNullimpl != null) {
            function1.invoke(thM29exceptionOrNullimpl);
        }
        return obj;
    }

    private static final <T> Object onSuccess(Object obj, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{3, 85, 69, 8, 90, 88}, "b61a56b715ac87"));
        if (Result.m33isSuccessimpl(obj)) {
            function1.invoke(obj);
        }
        return obj;
    }

    private static final <R, T extends R> Object recover(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{17, 22, 83, 93, 68, 94, 10, 70, 8}, "ed2378e4e0952c65", false));
        Throwable thM29exceptionOrNullimpl = Result.m29exceptionOrNullimpl(obj);
        if (thM29exceptionOrNullimpl == null) {
            return obj;
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m26constructorimpl(function1.invoke(thM29exceptionOrNullimpl));
    }

    private static final <R, T extends R> Object recoverCatching(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{21, 17, 2, 13, 75, 83, 9, 16, 11}, "accc85fbf9"));
        Throwable thM29exceptionOrNullimpl = Result.m29exceptionOrNullimpl(obj);
        if (thM29exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m26constructorimpl(function1.invoke(thM29exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m26constructorimpl(createFailure(th));
        }
    }

    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{90, 94, 95, 90, 82}, "82099d71", 0.0f));
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m26constructorimpl(function1.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m26constructorimpl(createFailure(th));
        }
    }

    private static final <R> Object runCatching(Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{6, 10, 88, 81, 89}, "df7225", 0.0f));
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m26constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m26constructorimpl(createFailure(th));
        }
    }

    public static final void throwOnFailure(Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object obj) throws Throwable {
        throwOnFailure(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object obj, R r) {
        return Result.m32isFailureimpl(obj) ? r : obj;
    }
}
