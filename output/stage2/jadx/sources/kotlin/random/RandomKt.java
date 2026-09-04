package kotlin.random;

import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "fastLog2", "value", "takeUpperBits", "bitCount", "checkRangeBounds", "", "from", "until", "", "boundsErrorMessage", "", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RandomKt {
    public static final String boundsErrorMessage(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(obj, C0000.decode(new byte[]{4, 67, 86, 85}, "b198d617a3e08158", false));
        Intrinsics.checkNotNullParameter(obj2, C0000.decode(new byte[]{71, 92, 22, 15, 93}, "22bf17", 3));
        return C0000.decode(new byte[]{101, 89, 15, 2, 86, 11, 23, 74, 0, 8, 94, 3, 23, 81, 18, 70, 92, 11, 71, 76, 24, 92, 25, Base64.padSymbol}, "78af9f") + obj + C0000.decode(new byte[]{26, 24}, "68752ab284c6ab", true) + obj2 + C0000.decode(new byte[]{26, 77}, "3caa2fbebd69c5", 0.0f);
    }

    public static final int nextInt(Random random, IntRange intRange) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{93, 64, 95, 15, 17, 12}, "a47fb29356e75b", true));
        Intrinsics.checkNotNullParameter(intRange, C0000.decode(new byte[]{16, 86, 87, 85, 83}, "b7926e47542f"));
        if (intRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{38, 82, 13, 12, 91, 77, 18, 1, 83, 18, 21, 23, 87, 12, 5, 89, 8, 19, 10, 12, 20, 92, 95, 22, 66, 31, 21, 23, 87, 12, 6, 83, 95, 19}, "e3cb492f6f5e6ba6", false) + intRange);
        }
        if (intRange.getLast() < Integer.MAX_VALUE) {
            return random.nextInt(intRange.getFirst(), intRange.getLast() + 1);
        }
        return intRange.getFirst() > Integer.MIN_VALUE ? random.nextInt(intRange.getFirst() - 1, intRange.getLast()) + 1 : random.nextInt();
    }

    public static final long nextLong(Random random, LongRange longRange) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{14, 16, 91, 94, 69, 15}, "2d3761"));
        Intrinsics.checkNotNullParameter(longRange, C0000.decode(new byte[]{75, 89, 10, 82, 87}, "98d52eef187e", 0.0f));
        if (longRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{38, 88, 94, 88, 88, 64, 16, 85, 83, 77, 68, 70, 89, 8, 1, 86, 93, 22, 94, 90, 16, 87, 91, 73, 16, 77, 24, 20, 4, 87, 87, 83, 13, 20}, "e906740269d48f", 0.0f) + longRange);
        }
        if (longRange.getLast() < LongCompanionObject.MAX_VALUE) {
            return random.nextLong(longRange.getFirst(), longRange.getLast() + 1);
        }
        return longRange.getFirst() > Long.MIN_VALUE ? random.nextLong(longRange.getFirst() - 1, longRange.getLast()) + 1 : random.nextLong();
    }

    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final Random Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d, double d2) {
        if (d2 <= d) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }
}
