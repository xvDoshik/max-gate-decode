package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0007\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\n\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u000b\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\f\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00140\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"AtomicIntArray", "Lkotlin/concurrent/atomics/AtomicIntArray;", "size", "", "init", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicIntegerArray;", "fetchAndIncrementAt", "index", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;I)I", "incrementAndFetchAt", "decrementAndFetchAt", "fetchAndDecrementAt", "AtomicLongArray", "Lkotlin/concurrent/atomics/AtomicLongArray;", "", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicLongArray;", "(Ljava/util/concurrent/atomic/AtomicLongArray;I)J", "AtomicArray", "Lkotlin/concurrent/atomics/AtomicArray;", "T", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/concurrent/atomics/AtomicArraysKt")
class AtomicArraysKt__AtomicArrays_commonKt {
    public static final /* synthetic */ <T> AtomicReferenceArray<T> AtomicArray(int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{95, 15, 94, 23}, "6a7c04bc29", 0.0f));
        Intrinsics.reifiedOperationMarker(0, C0000.decode(new byte[]{109}, "995281c9cfd0b8e4"));
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = function1.invoke(Integer.valueOf(i2));
        }
        return new AtomicReferenceArray<>(objArr);
    }

    public static final AtomicIntegerArray AtomicIntArray(int i, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{12, 91, 89, 17}, "e50e16"));
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = function1.invoke(Integer.valueOf(i2)).intValue();
        }
        return new AtomicIntegerArray(iArr);
    }

    public static final AtomicLongArray AtomicLongArray(int i, Function1<? super Integer, Long> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{93, 13, 92, 17}, "4c5ede69"));
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = function1.invoke(Integer.valueOf(i2)).longValue();
        }
        return new AtomicLongArray(jArr);
    }

    public static final int decrementAndFetchAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, C0000.decode(new byte[]{4, 76, 14, 10, 22, 91}, "88fceeab8e25", 6));
        return atomicIntegerArray.addAndGet(i, -1);
    }

    public static final long decrementAndFetchAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, C0000.decode(new byte[]{13, 17, 95, 15, 23, 14}, "1e7fd0ce", 4));
        return atomicLongArray.addAndGet(i, -1L);
    }

    public static final int fetchAndDecrementAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, C0000.decode(new byte[]{10, 71, 95, 10, 17, 91}, "637cbe7d24", true));
        return atomicIntegerArray.getAndAdd(i, -1);
    }

    public static final long fetchAndDecrementAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, C0000.decode(new byte[]{9, 68, 89, 80, 64, 90}, "50193d4a", true));
        return atomicLongArray.getAndAdd(i, -1L);
    }

    public static final int fetchAndIncrementAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, C0000.decode(new byte[]{11, 17, 92, 90, 75, 8}, "7e4386", 0.0f));
        return atomicIntegerArray.getAndAdd(i, 1);
    }

    public static final long fetchAndIncrementAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, C0000.decode(new byte[]{10, 71, 12, 91, 74, 92}, "63d29b", true));
        return atomicLongArray.getAndAdd(i, 1L);
    }

    public static final int incrementAndFetchAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, C0000.decode(new byte[]{89, 64, 91, 11, 17, 12}, "e43bb29d", 0));
        return atomicIntegerArray.addAndGet(i, 1);
    }

    public static final long incrementAndFetchAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, C0000.decode(new byte[]{13, 71, 95, 15, 66, 8}, "137f16797b591f6f", 4));
        return atomicLongArray.addAndGet(i, 1L);
    }
}
