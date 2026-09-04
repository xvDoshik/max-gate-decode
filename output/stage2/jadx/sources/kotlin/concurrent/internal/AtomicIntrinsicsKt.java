package kotlin.concurrent.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a\u001c\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0001\u001a-\u0010\u0000\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u0003\u001a\u0002H\t2\u0006\u0010\u0004\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010\u000b\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a$\u0010\u0000\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a5\u0010\u0000\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\t2\u0006\u0010\u0004\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"compareAndExchange", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "expected", "newValue", "", "Ljava/util/concurrent/atomic/AtomicLong;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "index", "Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AtomicIntrinsicsKt {
    public static final int compareAndExchange(AtomicInteger atomicInteger, int i, int i2) {
        Intrinsics.checkNotNullParameter(atomicInteger, C0000.decode(new byte[]{94, 70, 13, 8, 75, 6}, "b2ea8803be9d", 3));
        do {
            int i3 = atomicInteger.get();
            if (i != i3) {
                return i3;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static final int compareAndExchange(AtomicIntegerArray atomicIntegerArray, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, C0000.decode(new byte[]{95, 77, 90, 88, 75, 88}, "c9218f2d99e000ee", false));
        do {
            int i4 = atomicIntegerArray.get(i);
            if (i2 != i4) {
                return i4;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i2, i3));
        return i2;
    }

    public static final long compareAndExchange(AtomicLong atomicLong, long j, long j2) {
        Intrinsics.checkNotNullParameter(atomicLong, C0000.decode(new byte[]{93, 65, 93, 11, 70, 6}, "a55b58a9dd9635", false));
        do {
            long j3 = atomicLong.get();
            if (j != j3) {
                return j3;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        return j;
    }

    public static final long compareAndExchange(AtomicLongArray atomicLongArray, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(atomicLongArray, C0000.decode(new byte[]{89, 77, 11, 12, 23, 12}, "e9ced2af838b0974"));
        do {
            long j3 = atomicLongArray.get(i);
            if (j != j3) {
                return j3;
            }
        } while (!atomicLongArray.compareAndSet(i, j, j2));
        return j;
    }

    public static final <T> T compareAndExchange(AtomicReference<T> atomicReference, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReference, C0000.decode(new byte[]{88, 17, 90, 89, 69, 15}, "de206173c976"));
        do {
            T t3 = atomicReference.get();
            if (t != t3) {
                return t3;
            }
        } while (!AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, t, t2));
        return t;
    }

    public static final <T> T compareAndExchange(AtomicReferenceArray<T> atomicReferenceArray, int i, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReferenceArray, C0000.decode(new byte[]{4, 70, 13, 81, 21, 95}, "82e8fa3679", false));
        do {
            T t3 = atomicReferenceArray.get(i);
            if (t != t3) {
                return t3;
            }
        } while (!AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, t, t2));
        return t;
    }

    public static final boolean compareAndExchange(AtomicBoolean atomicBoolean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(atomicBoolean, C0000.decode(new byte[]{93, 64, 88, 90, 68, 88}, "a4037f"));
        do {
            boolean z3 = atomicBoolean.get();
            if (z != z3) {
                return z3;
            }
        } while (!atomicBoolean.compareAndSet(z, z2));
        return z;
    }
}
