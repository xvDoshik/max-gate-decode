package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0087\b¢\u0006\u0002\u0010\f\u001a\u0012\u0010\n\u001a\u00020\u0004*\u00020\rH\u0087\b¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\n\u001a\u00020\u0004*\u00020\r2\u0006\u0010\n\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000bH\u0087\b\u001a\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\rH\u0087\b\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000fH\u0007\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\r2\u0006\u0010\n\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0087\n¢\u0006\u0002\b\u0016\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0087\n¢\u0006\u0002\b\u0017\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b \u0010!\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010'\u001a\u00020\u0002*\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0087\u0004¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010'\u001a\u00020\u0002*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010'\u001a\u00020\u0005*\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0087\u0004¢\u0006\u0004\b-\u0010.\u001a\u001c\u0010'\u001a\u00020\u0002*\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0087\u0004¢\u0006\u0004\b/\u00100\u001a\f\u00101\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\f\u00101\u001a\u00020\u0005*\u00020\u0005H\u0007\u001a\u0015\u00102\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u000203H\u0087\u0004\u001a\u0015\u00102\u001a\u00020\u0005*\u00020\u00052\u0006\u00102\u001a\u000204H\u0087\u0004\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0087\u0004¢\u0006\u0004\b6\u00107\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\b8\u00109\u001a\u001c\u00105\u001a\u00020\r*\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0087\u0004¢\u0006\u0004\b:\u0010;\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0087\u0004¢\u0006\u0004\b<\u0010=\u001a\u001b\u0010>\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020\u0001H\u0007¢\u0006\u0004\b@\u0010A\u001a\u001b\u0010>\u001a\u00020\u0004*\u00020\u00042\u0006\u0010?\u001a\u00020\u0004H\u0007¢\u0006\u0004\bB\u0010C\u001a\u001b\u0010>\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u00020\u0019H\u0007¢\u0006\u0004\bD\u0010E\u001a\u001b\u0010>\u001a\u00020\"*\u00020\"2\u0006\u0010?\u001a\u00020\"H\u0007¢\u0006\u0004\bF\u0010G\u001a\u001b\u0010H\u001a\u00020\u0001*\u00020\u00012\u0006\u0010I\u001a\u00020\u0001H\u0007¢\u0006\u0004\bJ\u0010A\u001a\u001b\u0010H\u001a\u00020\u0004*\u00020\u00042\u0006\u0010I\u001a\u00020\u0004H\u0007¢\u0006\u0004\bK\u0010C\u001a\u001b\u0010H\u001a\u00020\u0019*\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0007¢\u0006\u0004\bL\u0010E\u001a\u001b\u0010H\u001a\u00020\"*\u00020\"2\u0006\u0010I\u001a\u00020\"H\u0007¢\u0006\u0004\bM\u0010G\u001a#\u0010N\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010I\u001a\u00020\u0001H\u0007¢\u0006\u0004\bO\u0010P\u001a#\u0010N\u001a\u00020\u0004*\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0004H\u0007¢\u0006\u0004\bQ\u0010R\u001a#\u0010N\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0007¢\u0006\u0004\bS\u0010T\u001a#\u0010N\u001a\u00020\"*\u00020\"2\u0006\u0010?\u001a\u00020\"2\u0006\u0010I\u001a\u00020\"H\u0007¢\u0006\u0004\bU\u0010V\u001a!\u0010N\u001a\u00020\u0001*\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00010XH\u0007¢\u0006\u0004\bY\u0010Z\u001a!\u0010N\u001a\u00020\u0004*\u00020\u00042\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00040XH\u0007¢\u0006\u0004\b[\u0010\\¨\u0006]"}, d2 = {"first", "Lkotlin/UInt;", "Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/ULong;", "Lkotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lkotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", "", "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lkotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
public class URangesKt___URangesKt {
    /* JADX INFO: renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m1283coerceInJPwROB0(long j, ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{75, 87, 93, 82, 82}, "96357045534f92", false));
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m194boximpl(j), (ClosedFloatingPointRange<ULong>) closedRange)).getData();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{115, 89, 91, 88, 91, 71, 16, 91, 90, 83, 70, 80, 85, 24, 67, 87, 88, 70, 85, 24, 65, 89, 20, 82, 94, 24, 80, 91, 68, 71, 73, 24, 71, 87, 90, 84, 85, 2, 21}, "085643", 2) + closedRange + '.');
        }
        if (Long.compareUnsigned(j, ((ULong) closedRange.getStart()).getData()) < 0) {
            return ((ULong) closedRange.getStart()).getData();
        }
        return Long.compareUnsigned(j, ((ULong) closedRange.getEndInclusive()).getData()) > 0 ? ((ULong) closedRange.getEndInclusive()).getData() : j;
    }

    /* JADX INFO: renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m1284coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) > 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{32, 83, 11, 94, 9, 16, 69, 1, 89, 84, 69, 5, 87, 24, 21, 83, 9, 69, 3, 68, 17, 13, 22, 80, 89, 70, 87, 85, 19, 70, 28, 16, 20, 5, 11, 5, 83, 11, 23, 11, 83, 64, 10, 95, 16, 93, 70}, "c2e0fdeb617f28", 0) + ((Object) UShort.m351toStringimpl(s3)) + C0000.decode(new byte[]{22, 95, 71, 20, 13, 92, 21, 17, 19, 64, 91, 7, 88, 22, 89, 93, 15, 80, 11, 23, 94, 20}, "6644a9fb343f", 0.0f) + ((Object) UShort.m351toStringimpl(s2)) + '.');
        }
        int i3 = 65535 & s;
        if (Intrinsics.compare(i3, i) < 0) {
            return s2;
        }
        return Intrinsics.compare(i3, i2) > 0 ? s3 : s;
    }

    /* JADX INFO: renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m1285coerceInWZ9TVnA(int i, int i2, int i3) {
        if (Integer.compareUnsigned(i2, i3) > 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{32, 82, 88, 10, 94, 22, 67, 87, 93, 82, 19, 90, 6, 19, 64, 5, 93, 23, 6, 20, 70, 88, 65, 88, 13, 19, 83, 9, 65, 22, 26, 20, 64, 86, 15, 94, 6, 9, 22, 9, 80, 26, 10, 89, 71, 90, 65}, "c36d1bc427a9", 0.0f) + ((Object) UInt.m167toStringimpl(i3)) + C0000.decode(new byte[]{16, 89, 75, 25, 13, 86, 17, 75, 16, 68, 80, 88, 15, 19, 15, 81, 94, 89, 85, 76, 12, 19}, "0089a3b8", 5) + ((Object) UInt.m167toStringimpl(i2)) + '.');
        }
        if (Integer.compareUnsigned(i, i2) < 0) {
            return i2;
        }
        return Integer.compareUnsigned(i, i3) > 0 ? i3 : i;
    }

    /* JADX INFO: renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m1286coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & UByte.MAX_VALUE;
        int i2 = b3 & UByte.MAX_VALUE;
        if (Intrinsics.compare(i, i2) > 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{114, 82, 13, 12, 94, 69, 17, 80, 12, 7, 67, 82, 84, 19, 21, 3, 93, 68, 84, 19, 23, 13, 17, 80, 95, 19, 6, 15, 65, 69, 72, 19, 17, 3, 95, 86, 84, 9, 67, 15, 80, 73, 88, 94, 22, 15, 17}, "13cb11", 0.0f) + ((Object) UByte.m88toStringimpl(b3)) + C0000.decode(new byte[]{25, 94, 69, 18, 90, 85, 17, 74, 21, 77, 81, 86, 88, 18, 91, 89, 12, 80, 88, 76, 84, 23}, "976260b959") + ((Object) UByte.m88toStringimpl(b2)) + '.');
        }
        int i3 = b & UByte.MAX_VALUE;
        if (Intrinsics.compare(i3, i) < 0) {
            return b2;
        }
        return Intrinsics.compare(i3, i2) > 0 ? b3 : b;
    }

    /* JADX INFO: renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m1287coerceInsambcqE(long j, long j2, long j3) {
        if (Long.compareUnsigned(j2, j3) > 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{118, 5, 15, 91, 11, 21, 68, 2, 87, 85, 17, 7, 4, 69, 69, 0, 89, 17, 4, 21, 16, 14, 68, 0, 86, 16, 6, 9, 17, 17, 74, 65, 71, 5, 15, 82, 1, 91, 68, 12, 89, 72, 10, 9, 20, 8, 19}, "5da5dada80cdae3a", 0.0f) + ((Object) ULong.m246toStringimpl(j3)) + C0000.decode(new byte[]{67, 15, 75, 16, 84, 6, 65, 70, 67, 18, 80, 81, 86, 67, 95, 92, 13, 15, 85, 69, 85, 67}, "cf808c25", 0.0f) + ((Object) ULong.m246toStringimpl(j2)) + '.');
        }
        if (Long.compareUnsigned(j, j2) < 0) {
            return j2;
        }
        return Long.compareUnsigned(j, j3) > 0 ? j3 : j;
    }

    /* JADX INFO: renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m1288coerceInwuiCnnA(int i, ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, C0000.decode(new byte[]{66, 83, 12, 3, 86}, "02bd3765", 6));
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m115boximpl(i), (ClosedFloatingPointRange<UInt>) closedRange)).getData();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{115, 85, 89, 15, 93, 68, 25, 87, 9, 84, 75, 1, 86, 25, 70, 85, 91, 20, 87, 16, 77, 91, 70, 80, 87, 66, 86, 84, 64, 64, 78, 65, 64, 81, 87, 83, 3, 11, 25}, "047a2094f19b39", 0) + closedRange + '.');
        }
        if (Integer.compareUnsigned(i, ((UInt) closedRange.getStart()).getData()) < 0) {
            return ((UInt) closedRange.getStart()).getData();
        }
        return Integer.compareUnsigned(i, ((UInt) closedRange.getEndInclusive()).getData()) > 0 ? ((UInt) closedRange.getEndInclusive()).getData() : i;
    }

    /* JADX INFO: renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m1289contains68kG9v0(UIntRange uIntRange, byte b) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{21, 16, 81, 88, 69, 29, 7, 94, 89, 77, 80, 13, 87, 66}, "1d9169d179", 0.0f));
        return uIntRange.m1262containsWZ4Q5Ns(UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m1290containsGYNo2lE(ULongRange uLongRange, ULong uLong) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{22, 70, 90, 90, 21, 20, 1, 93, 92, 70, 83, 90, 8, 67}, "2223f0b2", 0.0f));
        return uLong != null && uLongRange.m1271containsVKZWuLQ(uLong.getData());
    }

    /* JADX INFO: renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m1291containsGab390E(ULongRange uLongRange, int i) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{28, 70, 11, 10, 18, 70, 5, 89, 87, 69, 89, 91, 13, 16}, "82ccabf691", false));
        return uLongRange.m1271containsVKZWuLQ(ULong.m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m1292containsULbyJY(ULongRange uLongRange, byte b) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{29, 64, 11, 92, 16, 20, 2, 89, 87, 64, 2, 92, 13, 67}, "94c5c0a6", 6));
        return uLongRange.m1271containsVKZWuLQ(ULong.m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m1293containsZsK3CEQ(UIntRange uIntRange, short s) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{69, 68, 11, 88, 74, 16, 2, 87, 15, 68, 2, 88, 87, 71}, "a0c194a8", true));
        return uIntRange.m1262containsWZ4Q5Ns(UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m1294containsbiwQdVI(UIntRange uIntRange, UInt uInt) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{17, 23, 80, 81, 74, 70, 2, 9, 95, 69, 84, 10, 86, 75}, "5c889baf11", false));
        return uInt != null && uIntRange.m1262containsWZ4Q5Ns(uInt.getData());
    }

    /* JADX INFO: renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m1295containsfz5IDCE(UIntRange uIntRange, long j) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{29, 17, 14, 80, 70, 16, 7, 95, 91, 69, 84, 13, 87, 22}, "9ef954d0515d", 3));
        return ULong.m200constructorimpl(j >>> 32) == 0 && uIntRange.m1262containsWZ4Q5Ns(UInt.m121constructorimpl((int) j));
    }

    /* JADX INFO: renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m1296containsuhHAxoY(ULongRange uLongRange, short s) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{16, 77, 12, 15, 16, 29, 7, 87, 88, 70, 7, 93, 87, 22}, "49dfc9d862f49e"));
        return uLongRange.m1271containsVKZWuLQ(ULong.m200constructorimpl(((long) s) & 65535));
    }

    public static final int first(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, C0000.decode(new byte[]{94, 69, 89, 92, 64, 10}, "b115343029", false));
        if (uIntProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{101, 75, 9, 84, 19, 0, 65, 22, 90, 86, 91, 25}, "59f3ae2e39", 7) + uIntProgression + C0000.decode(new byte[]{16, 12, 65, 67, 81, 9, 69, 68, 75, 23}, "0e2c4d5029", 0.0f));
        }
        return uIntProgression.getFirst();
    }

    public static final long first(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, C0000.decode(new byte[]{10, 69, 13, 11, 23, 7}, "61ebd9", 1));
        if (uLongProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{104, 69, 88, 81, 16, 81, 16, 71, 91, 93, 90, 16}, "8776b4c422406c", false) + uLongProgression + C0000.decode(new byte[]{65, 89, 75, 67, 4, 15, 21, 23, 76, 29}, "a08cabec53"));
        }
        return uLongProgression.getFirst();
    }

    public static final UInt firstOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, C0000.decode(new byte[]{13, 16, 13, 80, 17, 14}, "1de9b032cb5abd20"));
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m115boximpl(uIntProgression.getFirst());
    }

    public static final ULong firstOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, C0000.decode(new byte[]{88, 65, 93, 80, 21, 92}, "d559fb91a568", 6));
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m194boximpl(uLongProgression.getFirst());
    }

    public static final int last(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, C0000.decode(new byte[]{14, 65, 95, 81, 69, 7}, "257869254f92b519", true));
        if (uIntProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{53, 19, 94, 3, 23, 3, 75, 71, 12, 14, 95, 68}, "ea1def84", true) + uIntProgression + C0000.decode(new byte[]{24, 81, 22, 68, 84, 93, 66, 18, 78, 27}, "88ed102f75"));
        }
        return uIntProgression.getLast();
    }

    public static final long last(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, C0000.decode(new byte[]{4, 67, 81, 15, 69, 8}, "879f6617", 6));
        if (uLongProgression.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{104, 19, 95, 81, 20, 86, 23, 71, 92, 86, 86, 65}, "8a06f3d459", 0.0f) + uLongProgression + C0000.decode(new byte[]{65, 15, 71, 18, 81, 11, 64, 21, 77, 79}, "af424f0a4a"));
        }
        return uLongProgression.getLast();
    }

    public static final UInt lastOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, C0000.decode(new byte[]{8, 16, 88, 11, 21, 13}, "4d0bf3779b", 0.0f));
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m115boximpl(uIntProgression.getLast());
    }

    public static final ULong lastOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, C0000.decode(new byte[]{89, 18, 90, 90, 66, 8}, "ef2316a4922465", 0.0f));
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m194boximpl(uLongProgression.getLast());
    }

    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{14, 22, 93, 89, 23, 91}, "2b50de4dbad3"));
        return URangesKt.random(uIntRange, Random.INSTANCE);
    }

    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{4, 64, 12, 15, 66, 95}, "84df1a3c7d2c1d", 5));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{19, 81, 95, 1, 93, 92}, "a01e2146"));
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{93, 69, 14, 95, 65, 6}, "a1f62824958f36"));
        return URangesKt.random(uLongRange, Random.INSTANCE);
    }

    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{12, 68, 10, 81, 75, 14}, "00b8809a0f24", 0.0f));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{64, 4, 15, 81, 12, 89}, "2ea5c4e2cd3f3893", 0.0f));
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{13, 64, 12, 15, 68, 9}, "14df7721a422"));
        return URangesKt.randomOrNull(uIntRange, Random.INSTANCE);
    }

    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, C0000.decode(new byte[]{95, 68, 88, 8, 75, 93}, "c00a8c", false));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{71, 0, 93, 87, 88, 95}, "5a337285eb36", 0.0f));
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m115boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{9, 16, 13, 12, 69, 92}, "5dee6b", false));
        return URangesKt.randomOrNull(uLongRange, Random.INSTANCE);
    }

    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, C0000.decode(new byte[]{15, 71, 90, 10, 16, 91}, "332cce617fba93", 0.0f));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{71, 85, 94, 2, 88, 85}, "540f78552613dd", 0.0f));
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m194boximpl(URandomKt.nextULong(random, uLongRange));
    }

    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, C0000.decode(new byte[]{5, 21, 94, 13, 64, 8}, "9a6d360581eb6fa0"));
        return UIntProgression.INSTANCE.m1259fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, C0000.decode(new byte[]{93, 67, 89, 94, 16, 93}, "a717ccf883"));
        return ULongProgression.INSTANCE.m1268fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, C0000.decode(new byte[]{5, 64, 13, 11, 66, 90}, "94eb1d46415d71", 2));
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int iM1257getFirstpVg5ArA = uIntProgression.getFirst();
        int iM1258getLastpVg5ArA = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m1259fromClosedRangeNkh28Cs(iM1257getFirstpVg5ArA, iM1258getLastpVg5ArA, i);
    }

    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, C0000.decode(new byte[]{10, 16, 91, 95, 16, 92}, "6d36cbb0"));
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long jM1266getFirstsVKNKU = uLongProgression.getFirst();
        long jM1267getLastsVKNKU = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m1268fromClosedRange7ftBX0g(jM1266getFirstsVKNKU, jM1267getLastsVKNKU, j);
    }

    /* JADX INFO: renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m1299downToKr8caGY(byte b, byte b2) {
        return UIntProgression.INSTANCE.m1259fromClosedRangeNkh28Cs(UInt.m121constructorimpl(b & UByte.MAX_VALUE), UInt.m121constructorimpl(b2 & UByte.MAX_VALUE), -1);
    }

    /* JADX INFO: renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m1298downToJ1ME1BU(int i, int i2) {
        return UIntProgression.INSTANCE.m1259fromClosedRangeNkh28Cs(i, i2, -1);
    }

    /* JADX INFO: renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m1300downToeb3DHEI(long j, long j2) {
        return ULongProgression.INSTANCE.m1268fromClosedRange7ftBX0g(j, j2, -1L);
    }

    /* JADX INFO: renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m1297downTo5PvTz6A(short s, short s2) {
        return UIntProgression.INSTANCE.m1259fromClosedRangeNkh28Cs(UInt.m121constructorimpl(s & UShort.MAX_VALUE), UInt.m121constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    /* JADX INFO: renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m1303untilKr8caGY(byte b, byte b2) {
        int i = b2 & UByte.MAX_VALUE;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m121constructorimpl(b & UByte.MAX_VALUE), UInt.m121constructorimpl(UInt.m121constructorimpl(i) - 1), null);
    }

    /* JADX INFO: renamed from: until-J1ME1BU, reason: not valid java name */
    public static final UIntRange m1302untilJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i2, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(i, UInt.m121constructorimpl(i2 - 1), null);
    }

    /* JADX INFO: renamed from: until-eb3DHEI, reason: not valid java name */
    public static final ULongRange m1304untileb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j2, 0L) <= 0 ? ULongRange.INSTANCE.getEMPTY() : new ULongRange(j, ULong.m200constructorimpl(j2 - ULong.m200constructorimpl(((long) 1) & 4294967295L)), null);
    }

    /* JADX INFO: renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m1301until5PvTz6A(short s, short s2) {
        int i = s2 & UShort.MAX_VALUE;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m121constructorimpl(s & UShort.MAX_VALUE), UInt.m121constructorimpl(UInt.m121constructorimpl(i) - 1), null);
    }

    /* JADX INFO: renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m1276coerceAtLeastJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) < 0 ? i2 : i;
    }

    /* JADX INFO: renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m1278coerceAtLeasteb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) < 0 ? j2 : j;
    }

    /* JADX INFO: renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m1277coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) < 0 ? b2 : b;
    }

    /* JADX INFO: renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m1275coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    /* JADX INFO: renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m1280coerceAtMostJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) > 0 ? i2 : i;
    }

    /* JADX INFO: renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m1282coerceAtMosteb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) > 0 ? j2 : j;
    }

    /* JADX INFO: renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m1281coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) > 0 ? b2 : b;
    }

    /* JADX INFO: renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m1279coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }
}
