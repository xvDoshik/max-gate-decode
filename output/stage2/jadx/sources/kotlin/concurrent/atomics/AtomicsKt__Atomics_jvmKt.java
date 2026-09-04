package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0011\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0011\u0010\u0000\u001a\u00020\b*\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u0004\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0002\u0010\n\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\rH\u0007¢\u0006\u0002\u0010\u000e\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\f0\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u000bH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"asJavaAtomic", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/concurrent/atomics/AtomicInt;", "(Ljava/util/concurrent/atomic/AtomicInteger;)Ljava/util/concurrent/atomic/AtomicInteger;", "asKotlinAtomic", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlin/concurrent/atomics/AtomicLong;", "(Ljava/util/concurrent/atomic/AtomicLong;)Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "(Ljava/util/concurrent/atomic/AtomicBoolean;)Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicReference;", "T", "Lkotlin/concurrent/atomics/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/concurrent/atomics/AtomicsKt")
class AtomicsKt__Atomics_jvmKt extends AtomicsKt__Atomics_commonKt {
    public static final AtomicBoolean asJavaAtomic(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, C0000.decode(new byte[]{90, 76, 90, 81, 16, 91}, "f828ce750d", true));
        return atomicBoolean;
    }

    public static final AtomicInteger asJavaAtomic(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{5, 70, 94, 8, 22, 88}, "926aef99e0b273ed", 0.0f));
        return atomicInteger;
    }

    public static final AtomicLong asJavaAtomic(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{93, 22, 11, 88, 71, 90}, "abc14d"));
        return atomicLong;
    }

    public static final <T> AtomicReference<T> asJavaAtomic(AtomicReference<T> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, C0000.decode(new byte[]{94, 66, 92, 10, 23, 90}, "b64cdd6a86a2", 0));
        return atomicReference;
    }

    public static final AtomicBoolean asKotlinAtomic(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, C0000.decode(new byte[]{5, 22, 10, 90, 23, 15}, "9bb3d1dd2160", 2));
        return atomicBoolean;
    }

    public static final AtomicInteger asKotlinAtomic(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{93, 17, 91, 89, 65, 15}, "ae30216767", true));
        return atomicInteger;
    }

    public static final AtomicLong asKotlinAtomic(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{14, 23, 10, 92, 70, 8}, "2cb556f4", true));
        return atomicLong;
    }

    public static final <T> AtomicReference<T> asKotlinAtomic(AtomicReference<T> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, C0000.decode(new byte[]{8, 77, 12, 90, 71, 14}, "49d340ab11ed", 7));
        return atomicReference;
    }
}
