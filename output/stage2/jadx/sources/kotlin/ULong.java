package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: compiled from: ULong.kt */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b \u0010\u0018J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b!\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\"\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u001eJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b%\u0010\u0018J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b&\u0010\u001aJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b'\u0010\u001cJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u001eJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b*\u0010\u0018J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b+\u0010\u001aJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b,\u0010\u001cJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u001eJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b/\u0010\u0018J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b0\u0010\u001aJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b1\u0010\u001cJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b2\u0010\u001eJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b4\u0010\u0018J\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b5\u0010\u001aJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b6\u0010\u001cJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b7\u0010\u001eJ\u0018\u00108\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b9\u0010:J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b;\u0010<J\u0018\u00108\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b=\u0010\u0013J\u0018\u00108\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b>\u0010\u001eJ\u0010\u0010?\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b@\u0010\u0005J\u0010\u0010A\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010\u0005J\u0018\u0010C\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010FJ\u0018\u0010G\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bH\u0010FJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f¢\u0006\u0004\bK\u0010\u001cJ\u0018\u0010L\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f¢\u0006\u0004\bM\u0010\u001cJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bO\u0010\u001eJ\u0018\u0010P\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bQ\u0010\u001eJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bS\u0010\u001eJ\u0010\u0010T\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\tH\u0087\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\bd\u0010YJ\u0010\u0010e\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bf\u0010]J\u0010\u0010g\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\bh\u0010`J\u0010\u0010i\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bj\u0010\u0005J\u0010\u0010k\u001a\u00020lH\u0087\b¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020pH\u0087\b¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020tH\u0016¢\u0006\u0004\bu\u0010vJ\u0013\u0010w\u001a\u00020x2\b\u0010\n\u001a\u0004\u0018\u00010yHÖ\u0003J\t\u0010z\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006|"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", "", "toByte-impl", "(J)B", "toShort", "", "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(J)F", "toDouble", "", "toDouble-impl", "(J)D", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class ULong implements Comparable<ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* JADX INFO: renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m193andVKZWuLQ(long j, long j2) {
        return m200constructorimpl(j & j2);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m194boximpl(long j) {
        return new ULong(j);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m195compareTo7apg3OU(long j, byte b) {
        return Long.compareUnsigned(j, m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m196compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(getData(), j);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m198compareToWZ4Q5Ns(long j, int i) {
        return Long.compareUnsigned(j, m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m199compareToxj2QHRw(long j, short s) {
        return Long.compareUnsigned(j, m200constructorimpl(((long) s) & 65535));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m200constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m201decsVKNKU(long j) {
        return m200constructorimpl(j - 1);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m202div7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m204divWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m205divxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m200constructorimpl(((long) s) & 65535));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m206equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).getData();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m207equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m208floorDiv7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m210floorDivWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m211floorDivxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m200constructorimpl(((long) s) & 65535));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m212hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m213incsVKNKU(long j) {
        return m200constructorimpl(j + 1);
    }

    /* JADX INFO: renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m214invsVKNKU(long j) {
        return m200constructorimpl(~j);
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m215minus7apg3OU(long j, byte b) {
        return m200constructorimpl(j - m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m216minusVKZWuLQ(long j, long j2) {
        return m200constructorimpl(j - j2);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m217minusWZ4Q5Ns(long j, int i) {
        return m200constructorimpl(j - m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m218minusxj2QHRw(long j, short s) {
        return m200constructorimpl(j - m200constructorimpl(((long) s) & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m219mod7apg3OU(long j, byte b) {
        return UByte.m44constructorimpl((byte) Long.remainderUnsigned(j, m200constructorimpl(((long) b) & 255)));
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m221modWZ4Q5Ns(long j, int i) {
        return UInt.m121constructorimpl((int) Long.remainderUnsigned(j, m200constructorimpl(((long) i) & 4294967295L)));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m222modxj2QHRw(long j, short s) {
        return UShort.m307constructorimpl((short) Long.remainderUnsigned(j, m200constructorimpl(((long) s) & 65535)));
    }

    /* JADX INFO: renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m223orVKZWuLQ(long j, long j2) {
        return m200constructorimpl(j | j2);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m224plus7apg3OU(long j, byte b) {
        return m200constructorimpl(j + m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m225plusVKZWuLQ(long j, long j2) {
        return m200constructorimpl(j + j2);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m226plusWZ4Q5Ns(long j, int i) {
        return m200constructorimpl(j + m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m227plusxj2QHRw(long j, short s) {
        return m200constructorimpl(j + m200constructorimpl(((long) s) & 65535));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m230rem7apg3OU(long j, byte b) {
        return Long.remainderUnsigned(j, m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m232remWZ4Q5Ns(long j, int i) {
        return Long.remainderUnsigned(j, m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m233remxj2QHRw(long j, short s) {
        return Long.remainderUnsigned(j, m200constructorimpl(((long) s) & 65535));
    }

    /* JADX INFO: renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m234shlsVKNKU(long j, int i) {
        return m200constructorimpl(j << i);
    }

    /* JADX INFO: renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m235shrsVKNKU(long j, int i) {
        return m200constructorimpl(j >>> i);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m236times7apg3OU(long j, byte b) {
        return m200constructorimpl(j * m200constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m237timesVKZWuLQ(long j, long j2) {
        return m200constructorimpl(j * j2);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m238timesWZ4Q5Ns(long j, int i) {
        return m200constructorimpl(j * m200constructorimpl(((long) i) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m239timesxj2QHRw(long j, short s) {
        return m200constructorimpl(j * m200constructorimpl(((long) s) & 65535));
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m240toByteimpl(long j) {
        return (byte) j;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m243toIntimpl(long j) {
        return (int) j;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m244toLongimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m245toShortimpl(long j) {
        return (short) j;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m246toStringimpl(long j) {
        return UnsignedKt.ulongToString(j, 10);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m247toUBytew2LRezQ(long j) {
        return UByte.m44constructorimpl((byte) j);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m248toUIntpVg5ArA(long j) {
        return UInt.m121constructorimpl((int) j);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m249toULongsVKNKU(long j) {
        return j;
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m250toUShortMh2AYeg(long j) {
        return UShort.m307constructorimpl((short) j);
    }

    /* JADX INFO: renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m251xorVKZWuLQ(long j, long j2) {
        return m200constructorimpl(j ^ j2);
    }

    public boolean equals(Object other) {
        return m206equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m212hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(getData(), uLong.getData());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m197compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m203divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m379ulongDivideeb3DHEI(j, j2);
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m231remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m380ulongRemaindereb3DHEI(j, j2);
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m209floorDivVKZWuLQ(long j, long j2) {
        return Long.divideUnsigned(j, j2);
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m220modVKZWuLQ(long j, long j2) {
        return Long.remainderUnsigned(j, j2);
    }

    /* JADX INFO: renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m228rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* JADX INFO: renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m229rangeUntilVKZWuLQ(long j, long j2) {
        return URangesKt.m1304untileb3DHEI(j, j2);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m242toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m241toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    public String toString() {
        return m246toStringimpl(this.data);
    }
}
