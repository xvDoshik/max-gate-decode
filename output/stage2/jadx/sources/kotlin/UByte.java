package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: compiled from: UByte.kt */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0017\u0010\fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u0018\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0019\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001d\u0010\fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001e\u0010\u000fJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001f\u0010\u0012J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b \u0010\u001bJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\"\u0010\fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b$\u0010\u0012J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u001bJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b'\u0010\fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b(\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b)\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b*\u0010\u001bJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b,\u0010\fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\n¢\u0006\u0004\b-\u0010\u000fJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b.\u0010\u0012J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b/\u0010\u001bJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b1\u0010\fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\b¢\u0006\u0004\b2\u0010\u000fJ\u0018\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b3\u0010\u0012J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b4\u0010\u001bJ\u0018\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b6\u00107J\u0018\u00105\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b:\u0010\u0012J\u0018\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b;\u0010\u001bJ\u0010\u0010<\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b=\u0010\u0005J\u0010\u0010>\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u0005J\u0018\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010CJ\u0018\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bG\u00107J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bI\u00107J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u00107J\u0010\u0010L\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bM\u0010\u0005J\u0010\u0010N\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bO\u0010\u0005J\u0010\u0010P\u001a\u00020QH\u0087\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\tH\u0087\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\\\u0010\u0005J\u0010\u0010]\u001a\u00020\rH\u0087\b¢\u0006\u0004\b^\u0010SJ\u0010\u0010_\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b`\u0010VJ\u0010\u0010a\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\bb\u0010ZJ\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0013\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "compareTo", "", "other", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", "", "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(B)F", "toDouble", "", "toDouble-impl", "(B)D", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* JADX INFO: renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m37and7apg3OU(byte b, byte b2) {
        return m44constructorimpl((byte) (b & b2));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m38boximpl(byte b) {
        return new UByte(b);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m39compareTo7apg3OU(byte b) {
        return Intrinsics.compare(getData() & MAX_VALUE, b & MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m40compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & MAX_VALUE, b2 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m41compareToVKZWuLQ(byte b, long j) {
        return Long.compareUnsigned(ULong.m200constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m42compareToWZ4Q5Ns(byte b, int i) {
        return Integer.compareUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m43compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & MAX_VALUE, s & UShort.MAX_VALUE);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m44constructorimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m45decw2LRezQ(byte b) {
        return m44constructorimpl((byte) (b - 1));
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m46div7apg3OU(byte b, byte b2) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m47divVKZWuLQ(byte b, long j) {
        return Long.divideUnsigned(ULong.m200constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m48divWZ4Q5Ns(byte b, int i) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m49divxj2QHRw(byte b, short s) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m50equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).getData();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m51equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m52floorDiv7apg3OU(byte b, byte b2) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m53floorDivVKZWuLQ(byte b, long j) {
        return Long.divideUnsigned(ULong.m200constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m54floorDivWZ4Q5Ns(byte b, int i) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m55floorDivxj2QHRw(byte b, short s) {
        return Integer.divideUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m56hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    /* JADX INFO: renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m57incw2LRezQ(byte b) {
        return m44constructorimpl((byte) (b + 1));
    }

    /* JADX INFO: renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m58invw2LRezQ(byte b) {
        return m44constructorimpl((byte) (~b));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m59minus7apg3OU(byte b, byte b2) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) - UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m60minusVKZWuLQ(byte b, long j) {
        return ULong.m200constructorimpl(ULong.m200constructorimpl(((long) b) & 255) - j);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m61minusWZ4Q5Ns(byte b, int i) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) - i);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m62minusxj2QHRw(byte b, short s) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) - UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m63mod7apg3OU(byte b, byte b2) {
        return m44constructorimpl((byte) Integer.remainderUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(b2 & MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m64modVKZWuLQ(byte b, long j) {
        return Long.remainderUnsigned(ULong.m200constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m65modWZ4Q5Ns(byte b, int i) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m66modxj2QHRw(byte b, short s) {
        return UShort.m307constructorimpl((short) Integer.remainderUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* JADX INFO: renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m67or7apg3OU(byte b, byte b2) {
        return m44constructorimpl((byte) (b | b2));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m68plus7apg3OU(byte b, byte b2) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) + UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m69plusVKZWuLQ(byte b, long j) {
        return ULong.m200constructorimpl(ULong.m200constructorimpl(((long) b) & 255) + j);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m70plusWZ4Q5Ns(byte b, int i) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) + i);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m71plusxj2QHRw(byte b, short s) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) + UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m73rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m1302untilJ1ME1BU(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m74rem7apg3OU(byte b, byte b2) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m75remVKZWuLQ(byte b, long j) {
        return Long.remainderUnsigned(ULong.m200constructorimpl(((long) b) & 255), j);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m76remWZ4Q5Ns(byte b, int i) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), i);
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m77remxj2QHRw(byte b, short s) {
        return Integer.remainderUnsigned(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m78times7apg3OU(byte b, byte b2) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) * UInt.m121constructorimpl(b2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m79timesVKZWuLQ(byte b, long j) {
        return ULong.m200constructorimpl(ULong.m200constructorimpl(((long) b) & 255) * j);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m80timesWZ4Q5Ns(byte b, int i) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) * i);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m81timesxj2QHRw(byte b, short s) {
        return UInt.m121constructorimpl(UInt.m121constructorimpl(b & MAX_VALUE) * UInt.m121constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m82toByteimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m83toDoubleimpl(byte b) {
        return UnsignedKt.uintToDouble(b & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m84toFloatimpl(byte b) {
        return (float) UnsignedKt.uintToDouble(b & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m85toIntimpl(byte b) {
        return b & MAX_VALUE;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m86toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m87toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m88toStringimpl(byte b) {
        return String.valueOf(b & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m89toUBytew2LRezQ(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m90toUIntpVg5ArA(byte b) {
        return UInt.m121constructorimpl(b & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m91toULongsVKNKU(byte b) {
        return ULong.m200constructorimpl(((long) b) & 255);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m92toUShortMh2AYeg(byte b) {
        return UShort.m307constructorimpl((short) (b & 255));
    }

    /* JADX INFO: renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m93xor7apg3OU(byte b, byte b2) {
        return m44constructorimpl((byte) (b ^ b2));
    }

    public boolean equals(Object other) {
        return m50equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m56hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(getData() & MAX_VALUE, uByte.getData() & MAX_VALUE);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* JADX INFO: renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m72rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m121constructorimpl(b & MAX_VALUE), UInt.m121constructorimpl(b2 & MAX_VALUE), null);
    }

    public String toString() {
        return m88toStringimpl(this.data);
    }
}
