package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\u0010\u000e\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\u0010\u000e\u001a\u0011\u0010\u0007\u001a\u00020\r*\u00020\fH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0011\u0010\t\u001a\u00020\r*\u00020\fH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0011\u0010\n\u001a\u00020\r*\u00020\fH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0011\u0010\u000b\u001a\u00020\r*\u00020\fH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"plusAssign", "", "Lkotlin/concurrent/atomics/AtomicInt;", "delta", "", "(Ljava/util/concurrent/atomic/AtomicInteger;I)V", "minusAssign", "fetchAndIncrement", "(Ljava/util/concurrent/atomic/AtomicInteger;)I", "incrementAndFetch", "decrementAndFetch", "fetchAndDecrement", "Lkotlin/concurrent/atomics/AtomicLong;", "", "(Ljava/util/concurrent/atomic/AtomicLong;J)V", "(Ljava/util/concurrent/atomic/AtomicLong;)J", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/concurrent/atomics/AtomicsKt")
class AtomicsKt__Atomics_commonKt {
    public static final int decrementAndFetch(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{94, 71, 95, 94, 67, 12}, "b37702b0d14b9628", 7));
        return atomicInteger.addAndGet(-1);
    }

    public static final long decrementAndFetch(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{94, 66, 88, 15, 66, 7}, "b60f19e3", 0.0f));
        return atomicLong.addAndGet(-1L);
    }

    public static final int fetchAndDecrement(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{89, 69, 89, 10, 18, 12}, "e11ca2b3f3", 6));
        return atomicInteger.getAndAdd(-1);
    }

    public static final long fetchAndDecrement(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{9, 71, 11, 95, 70, 12}, "53c652a08ca202f2", 6));
        return atomicLong.getAndAdd(-1L);
    }

    public static final int fetchAndIncrement(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{15, 64, 90, 90, 18, 12}, "3423a251d2d26048", 2));
        return atomicInteger.getAndAdd(1);
    }

    public static final long fetchAndIncrement(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{13, 77, 89, 91, 23, 13}, "1912d320680a", 0.0f));
        return atomicLong.getAndAdd(1L);
    }

    public static final int incrementAndFetch(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{89, 71, 88, 15, 18, 88}, "e30fafd577d3"));
        return atomicInteger.addAndGet(1);
    }

    public static final long incrementAndFetch(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{11, 23, 9, 89, 75, 11}, "7ca085c2af8bdc05", 2));
        return atomicLong.addAndGet(1L);
    }

    public static final void minusAssign(AtomicInteger atomicInteger, int i) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{95, 66, 11, 92, 68, 92}, "c6c57bf45caddb"));
        atomicInteger.addAndGet(-i);
    }

    public static final void minusAssign(AtomicLong atomicLong, long j) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{12, 67, 81, 15, 66, 14}, "079f10987c", 6));
        atomicLong.addAndGet(-j);
    }

    public static final void plusAssign(AtomicInteger atomicInteger, int i) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{12, 68, 81, 15, 65, 6}, "009f28b1ee", 4));
        atomicInteger.addAndGet(i);
    }

    public static final void plusAssign(AtomicLong atomicLong, long j) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{90, 22, 94, 80, 64, 14}, "fb69306c2c81b70a", true));
        atomicLong.addAndGet(j);
    }
}
