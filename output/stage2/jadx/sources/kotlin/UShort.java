package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: compiled from: UShort.kt */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u0017\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0018\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0019\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u001d\u0010\rJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u000fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001f\u0010\u0012J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b \u0010\u001bJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\"\u0010\rJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b$\u0010\u0012J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u001bJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b'\u0010\rJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b)\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b*\u0010\u001bJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b,\u0010\rJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u000fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b.\u0010\u0012J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b/\u0010\u001bJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b1\u0010\rJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u000fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b3\u0010\u0012J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b4\u0010\u001bJ\u0018\u00105\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b6\u00107J\u0018\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b:\u0010\u0012J\u0018\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b;\u0010\u001bJ\u0010\u0010<\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b=\u0010\u0005J\u0010\u0010>\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u0005J\u0018\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010CJ\u0018\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bG\u00109J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bI\u00109J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u00109J\u0010\u0010L\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bM\u0010\u0005J\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020\tH\u0087\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\\\u0010QJ\u0010\u0010]\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b^\u0010\u0005J\u0010\u0010_\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b`\u0010VJ\u0010\u0010a\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\bb\u0010ZJ\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(S)F", "toDouble", "", "toDouble-impl", "(S)D", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* JADX INFO: renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m300andxj2QHRw(short s, short s2) {
        return m307constructorimpl((short) (s & s2));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m301boximpl(short s) {
        return new UShort(s);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m302compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & UByte.MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m303compareToVKZWuLQ(short s, long j) {
        return Long.compareUnsigned(ULong.m200constructorimpl(((long) s) & 65535), j);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m304compareToWZ4Q5Ns(short s, int i) {
        return Integer.compareUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m305compareToxj2QHRw(short s) {
        return Intrinsics.compare(getData() & MAX_VALUE, s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m306compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m307constructorimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m308decMh2AYeg(short s) {
        return m307constructorimpl((short) (s - 1));
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m309div7apg3OU(short s, byte b) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m310divVKZWuLQ(short s, long j) {
        return Long.divideUnsigned(ULong.m200constructorimpl(((long) s) & 65535), j);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m311divWZ4Q5Ns(short s, int i) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m312divxj2QHRw(short s, short s2) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m313equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m314equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m315floorDiv7apg3OU(short s, byte b) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m316floorDivVKZWuLQ(short s, long j) {
        return Long.divideUnsigned(ULong.m200constructorimpl(((long) s) & 65535), j);
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m317floorDivWZ4Q5Ns(short s, int i) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m318floorDivxj2QHRw(short s, short s2) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m319hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* JADX INFO: renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m320incMh2AYeg(short s) {
        return m307constructorimpl((short) (s + 1));
    }

    /* JADX INFO: renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m321invMh2AYeg(short s) {
        return m307constructorimpl((short) (~s));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m322minus7apg3OU(short s, byte b) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) - UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m323minusVKZWuLQ(short s, long j) {
        return ULong.m200constructorimpl(ULong.m200constructorimpl(((long) s) & 65535) - j);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m324minusWZ4Q5Ns(short s, int i) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) - i);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m325minusxj2QHRw(short s, short s2) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) - UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m326mod7apg3OU(short s, byte b) {
        return UByte.m44constructorimpl((byte) Integer.remainderUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(b & UByte.MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m327modVKZWuLQ(short s, long j) {
        return Long.remainderUnsigned(ULong.m200constructorimpl(((long) s) & 65535), j);
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m328modWZ4Q5Ns(short s, int i) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m329modxj2QHRw(short s, short s2) {
        return m307constructorimpl((short) Integer.remainderUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(s2 & MAX_VALUE)));
    }

    /* JADX INFO: renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m330orxj2QHRw(short s, short s2) {
        return m307constructorimpl((short) (s | s2));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m331plus7apg3OU(short s, byte b) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) + UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m332plusVKZWuLQ(short s, long j) {
        return ULong.m200constructorimpl(ULong.m200constructorimpl(((long) s) & 65535) + j);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m333plusWZ4Q5Ns(short s, int i) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) + i);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m334plusxj2QHRw(short s, short s2) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) + UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m336rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt.m1302untilJ1ME1BU(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m337rem7apg3OU(short s, byte b) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m338remVKZWuLQ(short s, long j) {
        return Long.remainderUnsigned(ULong.m200constructorimpl(((long) s) & 65535), j);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m339remWZ4Q5Ns(short s, int i) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m340remxj2QHRw(short s, short s2) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m341times7apg3OU(short s, byte b) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) * UInt.m121constructorimpl(b & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m342timesVKZWuLQ(short s, long j) {
        return ULong.m200constructorimpl(ULong.m200constructorimpl(((long) s) & 65535) * j);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m343timesWZ4Q5Ns(short s, int i) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) * i);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m344timesxj2QHRw(short s, short s2) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(s & MAX_VALUE) * UInt.m121constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m345toByteimpl(short s) {
        return (byte) s;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m346toDoubleimpl(short s) {
        return UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m347toFloatimpl(short s) {
        return (float) UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m348toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m349toLongimpl(short s) {
        return ((long) s) & 65535;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m350toShortimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m351toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m352toUBytew2LRezQ(short s) {
        return UByte.m44constructorimpl((byte) s);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m353toUIntpVg5ArA(short s) {
        return UInt.m121constructorimpl(s & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m354toULongsVKNKU(short s) {
        return ULong.m200constructorimpl(((long) s) & 65535);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m355toUShortMh2AYeg(short s) {
        return s;
    }

    /* JADX INFO: renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m356xorxj2QHRw(short s, short s2) {
        return m307constructorimpl((short) (s ^ s2));
    }

    public boolean equals(Object other) {
        return m313equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m319hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(getData() & MAX_VALUE, uShort.getData() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* JADX INFO: renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m335rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m121constructorimpl(s & MAX_VALUE), UInt.m121constructorimpl(s2 & MAX_VALUE), null);
    }

    public String toString() {
        return m351toStringimpl(this.data);
    }
}
