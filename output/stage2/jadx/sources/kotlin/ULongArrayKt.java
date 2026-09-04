package kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"ULongArray", "Lkotlin/ULongArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ULong;", "(ILkotlin/jvm/functions/Function1;)[J", "ulongArrayOf", "elements", "ulongArrayOf-QwZRm1k", "([J)[J", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ULongArrayKt {
    private static final long[] ULongArray(int i, Function1<? super Integer, ULong> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{92, 91, 90, 66}, "55368ba1982e94", true));
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = function1.invoke(Integer.valueOf(i2)).getData();
        }
        return ULongArray.m255constructorimpl(jArr);
    }

    /* JADX INFO: renamed from: ulongArrayOf-QwZRm1k, reason: not valid java name */
    private static final long[] m271ulongArrayOfQwZRm1k(long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{85, 88, 87, 11, 84, 95, 16, 22}, "042f11de625b903a", true));
        return jArr;
    }
}
