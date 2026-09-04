package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a/\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH\u0007¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0000¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"nextUInt", "Lkotlin/UInt;", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)I", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lkotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "size", "", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class URandomKt {
    public static final byte[] nextUBytes(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{12, 17, 95, 15, 64, 7}, "0e7f397f", 0.0f));
        return UByteArray.m97constructorimpl(random.nextBytes(i));
    }

    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m1250nextUBytesEVgfTAA(Random random, byte[] bArr) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{22, 71, 93, 80, 23, 22, 13, 87, 79, 22, 103, 113, 76, 77, 1, 65}, "2359d2c27b"));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{85, 66, 20, 86, 64}, "40f79c"));
        random.nextBytes(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m1251nextUBytesWvrt4B4(Random random, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{23, 64, 81, 15, 16, 21, 92, 86, 25, 66, 54, 112, 74, 64, 92, 21}, "349fc123a6c2", 0.0f));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{89, 65, 70, 86, 75}, "83472794c5", false));
        random.nextBytes(bArr, i, i2);
        return bArr;
    }

    public static final int nextUInt(Random random) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{12, 22, 11, 88, 65, 90}, "0bc12d", 6));
        return UInt.m121constructorimpl(random.nextInt());
    }

    public static final int nextUInt(Random random, UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{95, 69, 94, 12, 18, 88}, "c16eaf7d38350c0c", 2));
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{23, 88, 10, 95, 1}, "e9d8d73366", 0.0f));
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{32, 85, 13, 94, 14, 71, 22, 2, 83, 17, 67, 70, 2, 94, 5, 92, 91, 69, 95, 11, 67, 81, 14, 64, 21, 74, 22, 23, 87, 11, 4, 81, 89, 16}, "c4c0a36e6e", 5) + uIntRange);
        }
        if (Integer.compareUnsigned(uIntRange.getLast(), -1) < 0) {
            return m1253nextUInta8DCA5k(random, uIntRange.getFirst(), UInt.m121constructorimpl(uIntRange.getLast() + 1));
        }
        return Integer.compareUnsigned(uIntRange.getFirst(), 0) > 0 ? UInt.m121constructorimpl(m1253nextUInta8DCA5k(random, UInt.m121constructorimpl(uIntRange.getFirst() - 1), uIntRange.getLast()) + 1) : nextUInt(random);
    }

    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m1253nextUInta8DCA5k(Random random, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{17, 68, 10, 15, 22, 29, 86, 92, 77, 68, 55, 47, 11, 77}, "50bfe989", false));
        m1248checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m121constructorimpl(random.nextInt(i ^ IntCompanionObject.MIN_VALUE, i2 ^ IntCompanionObject.MIN_VALUE) ^ IntCompanionObject.MIN_VALUE);
    }

    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m1254nextUIntqCasIEU(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{29, 67, 12, 93, 21, 28, 89, 93, 25, 17, 52, 121, 87, 22}, "97d4f878aea09b"));
        return m1253nextUInta8DCA5k(random, 0, i);
    }

    public static final long nextULong(Random random) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{89, 17, 92, 95, 16, 9}, "ee46c71252cb", 0));
        return ULong.m200constructorimpl(random.nextLong());
    }

    public static final long nextULong(Random random, ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{88, 17, 88, 90, 71, 13}, "de03437d3d6d"));
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{22, 83, 12, 94, 0}, "d2b9e20fdd661cf6"));
        if (uLongRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{114, 5, 10, 91, 12, 21, 22, 1, 93, 65, 66, 74, 0, 90, 85, 11, 9, 21, 10, 15, 22, 3, 85, 69, 22, 65, 65, 70, 80, 10, 3, 80, 89, 65}, "1dd5ca6f85b8a4", false) + uLongRange);
        }
        if (Long.compareUnsigned(uLongRange.getLast(), -1L) < 0) {
            return m1256nextULongjmpaWc(random, uLongRange.getFirst(), ULong.m200constructorimpl(uLongRange.getLast() + ULong.m200constructorimpl(((long) 1) & 4294967295L)));
        }
        if (Long.compareUnsigned(uLongRange.getFirst(), 0L) <= 0) {
            return nextULong(random);
        }
        long j = ((long) 1) & 4294967295L;
        return ULong.m200constructorimpl(m1256nextULongjmpaWc(random, ULong.m200constructorimpl(uLongRange.getFirst() - ULong.m200constructorimpl(j)), uLongRange.getLast()) + ULong.m200constructorimpl(j));
    }

    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m1255nextULongV1Xi4fY(Random random, long j) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{22, 69, 11, 10, 74, 64, 8, 80, 65, 18, 99, 47, 93, 95, 4}, "21cc9df59f6c", 0.0f));
        return m1256nextULongjmpaWc(random, 0L, j);
    }

    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m1256nextULongjmpaWc(Random random, long j, long j2) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{22, 66, 14, 15, 75, 65, 12, 1, 30, 17, 103, 122, 9, 8, 95}, "26ff8ebdfe", 0.0f));
        m1249checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m200constructorimpl(random.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m1252nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m103getSizeimpl(bArr);
        }
        return m1251nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    /* JADX INFO: renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m1248checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (Integer.compareUnsigned(i2, i) <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m115boximpl(i), UInt.m115boximpl(i2)).toString());
        }
    }

    /* JADX INFO: renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m1249checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (Long.compareUnsigned(j2, j) <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m194boximpl(j), ULong.m194boximpl(j2)).toString());
        }
    }
}
