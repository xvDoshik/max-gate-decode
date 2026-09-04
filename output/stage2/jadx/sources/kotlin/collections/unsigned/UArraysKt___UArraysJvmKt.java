package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0000\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014*\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014*\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014*\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014*\u00020\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\"\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b#\u0010$\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010&\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0007¢\u0006\u0004\b,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0007¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0007¢\u0006\u0004\b0\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0007¢\u0006\u0004\bC\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0007¢\u0006\u0004\bE\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000b`BH\u0007¢\u0006\u0004\bG\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`BH\u0007¢\u0006\u0004\bI\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0004\bL\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0007¢\u0006\u0004\bM\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0007¢\u0006\u0004\bN\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0007¢\u0006\u0004\bO\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0007¢\u0006\u0004\bV\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0007¢\u0006\u0004\bW\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000b`BH\u0007¢\u0006\u0004\bX\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`BH\u0007¢\u0006\u0004\bY\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a+\u0010Z\u001a\u00020[*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010^\u001a+\u0010Z\u001a\u00020[*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010_\u001a+\u0010Z\u001a\u00020[*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010`\u001a+\u0010Z\u001a\u00020a*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a+\u0010Z\u001a\u00020a*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010d\u001a+\u0010Z\u001a\u00020a*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010e\u001a+\u0010Z\u001a\u00020a*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2 = {"elementAt", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "index", "", "elementAt-qFRl0hI", "([II)I", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<UInt> m498asListajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{18, 67, 11, 88, 65, 21, 85, 68, ByteCompanionObject.MAX_VALUE, 89, 17, 23}, "67c1214730bcc421", 4));
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m499asListGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{17, 67, 12, 11, 74, 22, 81, 64, 121, 94, 23, 22}, "57db9203", true));
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m500asListQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{18, 69, 81, 91, 64, 64, 3, 69, 122, 88, 74, 70}, "61923db6", 4));
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m501asListrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{69, 17, 81, 89, 74, 19, 81, 21, 123, 93, 18, 17}, "ae90970f74", true));
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m502binarySearch2fe2U9s(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{21, 21, 93, 90, 70, 18, 85, 12, 11, 7, 69, 29, 53, 92, 80, 19, 86, 91}, "1a53567eef7df9", 1));
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m182getSizeimpl(iArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iUintCompare = UnsignedKt.uintCompare(iArr[i5], i);
            if (iUintCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m504binarySearchEtDCXyQ(short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{17, 16, 95, 89, 64, 16, 81, 90, 94, 4, 20, 64, 48, 3, 0, 74, 86, 12}, "5d7034330ef9cfa8", 0.0f));
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m366getSizeimpl(sArr));
        int i3 = s & UShort.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int iUintCompare = UnsignedKt.uintCompare(sArr[i5], i3);
            if (iUintCompare < 0) {
                i = i5 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m506binarySearchK6DWlUc(long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{69, 65, 92, 10, 64, 65, 0, 8, 15, 84, 70, 26, 96, 0, 3, 19, 2, 93}, "a54c3eba", 0.0f));
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m261getSizeimpl(jArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iUlongCompare = UnsignedKt.ulongCompare(jArr[i4], j);
            if (iUlongCompare < 0) {
                i = i4 + 1;
            } else {
                if (iUlongCompare <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m508binarySearchWpHrYlw(byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{28, 16, 95, 88, 75, 64, 90, 13, 89, 80, 74, 29, 107, 1, 86, 67, 91, 12}, "8d718d", 0.0f));
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m103getSizeimpl(bArr));
        int i3 = b & UByte.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int iUintCompare = UnsignedKt.uintCompare(bArr[i5], i3);
            if (iUintCompare < 0) {
                i = i5 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m510elementAtPpDY95g(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{64, 76, 9, 93, 74, 22, 3, 14, 1, 85, 4, 90, 77, 115, 18}, "d8a492fb", 5));
        return UByteArray.m102getw2LRezQ(bArr, i);
    }

    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m511elementAtnggk6HY(short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{22, 70, 10, 8, 23, 71, 87, 94, 7, 12, 1, 13, 70, 115, 22}, "22badc", 0.0f));
        return UShortArray.m365getMh2AYeg(sArr, i);
    }

    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m512elementAtqFRl0hI(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{18, 69, 13, 91, 68, 65, 93, 92, 84, 95, 83, 95, 17, 115, 67}, "61e27e8012", false));
        return UIntArray.m181getpVg5ArA(iArr, i);
    }

    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m513elementAtr7IrZao(long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{18, 23, 90, 11, 16, 65, 83, 15, 87, 15, 6, 11, 66, 34, 70}, "6c2bce"));
        return ULongArray.m260getsVKNKU(jArr, i);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m514maxajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{71, 21, 81, 15, 23, 28, 9, 3, 27}, "ca9fd8db"));
        return UArraysKt.m883maxOrNullajY9A(iArr);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m515maxGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{29, 71, 10, 95, 17, 19, 93, 87, 29}, "93b6b706e6d3", 7));
        return UArraysKt.m884maxOrNullGBYM_sE(bArr);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m516maxQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{18, 64, 91, 13, 22, 66, 11, 5, 78}, "643deffd6f342570"));
        return UArraysKt.m885maxOrNullQwZRm1k(jArr);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m517maxrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{18, 17, 91, 80, 66, 71, 85, 81, 78}, "6e391c806be6", 0.0f));
        return UArraysKt.m886maxOrNullrL5Bavg(sArr);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m518maxByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{18, 17, 10, 95, 75, 19, 95, 3, 78, 39, 27}, "6eb6872b"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{21, 92, 85, 0, 85, 16, 91, 67}, "f99e6d4162", 0.0f));
        if (UByteArray.m105isEmptyimpl(bArr)) {
            return null;
        }
        byte bM102getw2LRezQ = UByteArray.m102getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return UByte.m38boximpl(bM102getw2LRezQ);
        }
        R rInvoke = function1.invoke(UByte.m38boximpl(bM102getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM102getw2LRezQ2 = UByteArray.m102getw2LRezQ(bArr, i);
                R rInvoke2 = function1.invoke(UByte.m38boximpl(bM102getw2LRezQ2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    bM102getw2LRezQ = bM102getw2LRezQ2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m38boximpl(bM102getw2LRezQ);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m519maxByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{21, 68, 89, 11, 22, 19, 12, 88, 30, 35, 78}, "101be7a9fa757e"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{68, 1, 92, 86, 1, 69, 88, 22}, "7d03b1", 6));
        if (ULongArray.m263isEmptyimpl(jArr)) {
            return null;
        }
        long jM260getsVKNKU = ULongArray.m260getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return ULong.m194boximpl(jM260getsVKNKU);
        }
        R rInvoke = function1.invoke(ULong.m194boximpl(jM260getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM260getsVKNKU2 = ULongArray.m260getsVKNKU(jArr, i);
                R rInvoke2 = function1.invoke(ULong.m194boximpl(jM260getsVKNKU2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    jM260getsVKNKU = jM260getsVKNKU2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m194boximpl(jM260getsVKNKU);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m520maxByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{22, 71, 14, 92, 22, 70, 90, 2, 78, 39, 75}, "23f5eb7c6e", 1));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{22, 85, 9, 83, 80, 23, 89, 16}, "e0e63c6b9503", 0.0f));
        if (UIntArray.m184isEmptyimpl(iArr)) {
            return null;
        }
        int iM181getpVg5ArA = UIntArray.m181getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return UInt.m115boximpl(iM181getpVg5ArA);
        }
        R rInvoke = function1.invoke(UInt.m115boximpl(iM181getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM181getpVg5ArA2 = UIntArray.m181getpVg5ArA(iArr, i);
                R rInvoke2 = function1.invoke(UInt.m115boximpl(iM181getpVg5ArA2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    iM181getpVg5ArA = iM181getpVg5ArA2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m115boximpl(iM181getpVg5ArA);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m521maxByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{66, 76, 93, 8, 18, 66, 14, 86, 76, 39, 26}, "f85aafc74ecb95dd", 7));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{18, 7, 85, 86, 90, 76, 90, 16}, "ab93985b"));
        if (UShortArray.m368isEmptyimpl(sArr)) {
            return null;
        }
        short sM365getMh2AYeg = UShortArray.m365getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return UShort.m301boximpl(sM365getMh2AYeg);
        }
        R rInvoke = function1.invoke(UShort.m301boximpl(sM365getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM365getMh2AYeg2 = UShortArray.m365getMh2AYeg(sArr, i);
                R rInvoke2 = function1.invoke(UShort.m301boximpl(sM365getMh2AYeg2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    sM365getMh2AYeg = sM365getMh2AYeg2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m301boximpl(sM365getMh2AYeg);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m522maxWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{70, 17, 11, 89, 18, 69, 11, 83, 73, 100, 94, 71, 94}, "bec0aaf213736e", false));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{91, 11, 15, 69, 2, 75, 4, 76, 12, 16}, "8db5c9e8cb0d73"));
        return UArraysKt.m891maxWithOrNullXMRcp5o(bArr, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m523maxWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{18, 77, 92, 8, 66, 64, 91, 88, 76, 54, 88, 16, 94}, "694a1d"));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{2, 12, 92, 73, 5, 68, 2, 69, 9, 70}, "ac19d6c1f4", false));
        return UArraysKt.m892maxWithOrNullYmdZ_VM(iArr, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m524maxWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{28, 21, 88, 95, 17, 17, 89, 89, 64, 54, 89, 66, 10}, "8a06b548", 5));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{5, 12, 14, 64, 88, 70, 5, 21, 9, 70}, "fcc094daf4", 1));
        return UArraysKt.m893maxWithOrNulleOHTfZs(sArr, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m525maxWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{69, 21, 81, 12, 64, 29, 8, 82, 78, 96, 89, 70, 9}, "aa9e39e36702"));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{85, 13, 90, 69, 81, 69, 3, 67, 86, 23}, "6b7507b79ed5", 0.0f));
        return UArraysKt.m894maxWithOrNullzrEWJaI(jArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ UInt m526minajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{22, 22, 9, 94, 16, 70, 89, 94, 88}, "2ba7cb476ad8fe", false));
        return UArraysKt.m939minOrNullajY9A(iArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ UByte m527minGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{20, 67, 14, 92, 64, 28, 93, 94, 8}, "07f538", 1));
        return UArraysKt.m940minOrNullGBYM_sE(bArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ ULong m528minQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{71, 71, 12, 15, 16, 70, 84, 12, 12}, "c3dfcb9ebc89", 6));
        return UArraysKt.m941minOrNullQwZRm1k(jArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ UShort m529minrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{17, 21, 9, 90, 71, 66, 8, 13, 15}, "5aa34fedaf93"));
        return UArraysKt.m942minOrNullrL5Bavg(sArr);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m530minByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{22, 23, 9, 93, 18, 22, 91, 81, 95, 113, 65}, "2ca4a26813865f", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{74, 84, 94, 4, 5, 22, 95, 23}, "912afb0eb350cbab", false));
        if (UByteArray.m105isEmptyimpl(bArr)) {
            return null;
        }
        byte bM102getw2LRezQ = UByteArray.m102getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return UByte.m38boximpl(bM102getw2LRezQ);
        }
        R rInvoke = function1.invoke(UByte.m38boximpl(bM102getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM102getw2LRezQ2 = UByteArray.m102getw2LRezQ(bArr, i);
                R rInvoke2 = function1.invoke(UByte.m38boximpl(bM102getw2LRezQ2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    bM102getw2LRezQ = bM102getw2LRezQ2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m38boximpl(bM102getw2LRezQ);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m531minByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{65, 67, 94, 90, 64, 20, 95, 13, 10, 116, 74}, "e763302dd635"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{22, 1, 94, 3, 1, 17, 86, 74}, "ed2fbe98e3611e"));
        if (ULongArray.m263isEmptyimpl(jArr)) {
            return null;
        }
        long jM260getsVKNKU = ULongArray.m260getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return ULong.m194boximpl(jM260getsVKNKU);
        }
        R rInvoke = function1.invoke(ULong.m194boximpl(jM260getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM260getsVKNKU2 = ULongArray.m260getsVKNKU(jArr, i);
                R rInvoke2 = function1.invoke(ULong.m194boximpl(jM260getsVKNKU2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    jM260getsVKNKU = jM260getsVKNKU2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m194boximpl(jM260getsVKNKU);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m532minByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{23, 16, 9, 81, 16, 19, 9, 11, 92, 39, 74}, "3da8c7db2e", 4));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{70, 80, 94, 1, 91, 23, 14, 68}, "552d8ca6bf", 1));
        if (UIntArray.m184isEmptyimpl(iArr)) {
            return null;
        }
        int iM181getpVg5ArA = UIntArray.m181getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return UInt.m115boximpl(iM181getpVg5ArA);
        }
        R rInvoke = function1.invoke(UInt.m115boximpl(iM181getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM181getpVg5ArA2 = UIntArray.m181getpVg5ArA(iArr, i);
                R rInvoke2 = function1.invoke(UInt.m115boximpl(iM181getpVg5ArA2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    iM181getpVg5ArA = iM181getpVg5ArA2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m115boximpl(iM181getpVg5ArA);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m533minByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{21, 69, 88, 94, 70, 64, 92, 88, 94, 117, 76}, "11075d", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{71, 7, 89, 87, 90, 64, 93, 71}, "4b529425"));
        if (UShortArray.m368isEmptyimpl(sArr)) {
            return null;
        }
        short sM365getMh2AYeg = UShortArray.m365getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return UShort.m301boximpl(sM365getMh2AYeg);
        }
        R rInvoke = function1.invoke(UShort.m301boximpl(sM365getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM365getMh2AYeg2 = UShortArray.m365getMh2AYeg(sArr, i);
                R rInvoke2 = function1.invoke(UShort.m301boximpl(sM365getMh2AYeg2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    sM365getMh2AYeg = sM365getMh2AYeg2;
                    rInvoke = rInvoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m301boximpl(sM365getMh2AYeg);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ UByte m534minWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{65, 68, 11, 93, 70, 17, 15, 89, 89, 103, 15, 23, 13}, "e0c455b070fc"));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{81, 11, 15, 72, 83, 69, 7, 22, 95, 75}, "2db827fb098f", 0.0f));
        return UArraysKt.m947minWithOrNullXMRcp5o(bArr, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ UInt m535minWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{71, 21, 89, 93, 69, 66, 88, 91, 13, 54, 80, 65, 92}, "ca146f52ca9542"));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{83, 12, 84, 19, 84, 68, 88, 65, 93, 23}, "0c9c56952ec86a39", 0));
        return UArraysKt.m948minWithOrNullYmdZ_VM(iArr, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ UShort m536minWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{69, 70, 12, 95, 70, 17, 85, 95, 92, 52, 88, 66, 89}, "a2d655862c1612"));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{82, 14, 9, 64, 86, 75, 85, 70, 87, 17}, "1ad079428cf7", 6));
        return UArraysKt.m949minWithOrNulleOHTfZs(sArr, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ ULong m537minWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{18, 21, 14, 90, 68, 64, 85, 10, 15, 99, 13, 67, 94}, "6af37d8ca4d7", 1));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{5, 89, 90, 68, 83, 65, 86, 76, 9, 68}, "f6742378", 1));
        return UArraysKt.m950minWithOrNullzrEWJaI(jArr, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{28, 21, 81, 11, 17, 19, 21, 71, 8, ByteCompanionObject.MAX_VALUE, 87}, "8a9bb7f2e01b", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{65, 93, 95, 3, 86, 22, 9, 70}, "283f5bf4a72bcd3c", 0.0f));
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{68, 3, 9, 20, 86, 118, 94, 16, 22, 23, 31, 76}, "2bea3988891e7858", 7));
        int iM103getSizeimpl = UByteArray.m103getSizeimpl(bArr);
        for (int i = 0; i < iM103getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(function1.invoke(UByte.m38boximpl(UByteArray.m102getw2LRezQ(bArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{81, 0, 1, 25, 24, 76, 31, 16}, "0de16b194ddd40", 7));
        }
        return bigDecimalValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{18, 69, 93, 12, 71, 20, 17, 19, 93, 123, 80}, "615e40bf04"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{17, 87, 94, 80, 81, 66, 89, 20}, "b225266f", true));
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{79, 88, 15, 64, 0, 45, 80, 78, 26, 79, 23, 26}, "99c5eb6f4a93fa52", true));
        int iM182getSizeimpl = UIntArray.m182getSizeimpl(iArr);
        for (int i = 0; i < iM182getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(function1.invoke(UInt.m115boximpl(UIntArray.m181getpVg5ArA(iArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{3, 81, 87, 30, 29, 25, 25, 29}, "b53637743d48", 2));
        }
        return bigDecimalValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{66, 23, 95, 10, 21, 69, 23, 66, 95, 118, 84}, "fc7cfad72922"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{69, 80, 84, 7, 80, 76, 86, 68}, "658b389652"));
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{65, 5, 89, 19, 84, 45, 81, 76, 27, 72, 31, 75}, "7d5f1b", false));
        int iM261getSizeimpl = ULongArray.m261getSizeimpl(jArr);
        for (int i = 0; i < iM261getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(function1.invoke(ULong.m194boximpl(ULongArray.m260getsVKNKU(jArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{85, 84, 82, 17, 72, 72, 26, 25}, "4069ff", true));
        }
        return bigDecimalValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{71, 22, 13, 90, 16, 28, 16, 76, 84, 45, 5}, "cbe3c8c99b", 7));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{74, 83, 90, 86, 2, 70, 90, 64}, "9663a252ee588210", 3));
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{19, 3, 9, 20, 83, 123, 84, 31, 22, 25, 75, 75}, "ebea642787", 1));
        int iM366getSizeimpl = UShortArray.m366getSizeimpl(sArr);
        for (int i = 0; i < iM366getSizeimpl; i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(function1.invoke(UShort.m301boximpl(UShortArray.m365getMh2AYeg(sArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{84, 93, 5, 74, 24, 77, 22, 31}, "59ab6c8621a7157b", 1));
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{65, 22, 92, 89, 74, 17, 21, 69, 95, 45, 3}, "eb4095f02b", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{67, 1, 85, 7, 1, 69, 88, 65}, "0d9bb1738b1d"));
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{16, 2, 92, 64, 82, 120, 0, 76, 76, 75, 77, 76}, "fc0577fdbecebd", 4));
        int iM103getSizeimpl = UByteArray.m103getSizeimpl(bArr);
        for (int i = 0; i < iM103getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(function1.invoke(UByte.m38boximpl(UByteArray.m102getw2LRezQ(bArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{88, 85, 83, 27, 26, 79, 25, 17}, "91734a78", 7));
        }
        return bigIntegerValueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{29, 66, 91, 15, 64, 16, 74, 67, 94, 41, 85}, "963f34", 1));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{21, 83, 9, 85, 7, 16, 13, 67}, "f6e0ddb10e17d4", 4));
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{18, 5, 92, 69, 82, 121, 7, 30, 24, 22, 24, 75}, "dd0076a6686b1e93", 0.0f));
        int iM182getSizeimpl = UIntArray.m182getSizeimpl(iArr);
        for (int i = 0; i < iM182getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(function1.invoke(UInt.m115boximpl(UIntArray.m181getpVg5ArA(iArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{87, 80, 84, 16, 79, 29, 31, 30}, "6408a317", false));
        }
        return bigIntegerValueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{22, 76, 81, 91, 18, 23, 65, 19, 91, 124, 84}, "2892a32f63", 7));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{18, 84, 94, 81, 83, 17, 86, 75}, "a1240e99", 1));
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{68, 5, 92, 16, 83, ByteCompanionObject.MAX_VALUE, 85, 73, 77, 26, 76, 30}, "2d0e603ac4b7fb", 0));
        int iM261getSizeimpl = ULongArray.m261getSizeimpl(jArr);
        for (int i = 0; i < iM261getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(function1.invoke(ULong.m194boximpl(ULongArray.m260getsVKNKU(jArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{83, 5, 81, 24, 28, 79, 22, 27}, "2a502a82cbf2", true));
        }
        return bigIntegerValueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{70, 70, 92, 95, 64, 18, 23, 64, 95, 118, 94}, "b24636d529813a", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{75, 7, 90, 86, 2, 17, 91, 71}, "8b63ae45", 0.0f));
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{68, 7, 14, 69, 7, 46, 4, 16, 26, 29, 24, 79}, "2fb0bab8436fd8", 0.0f));
        int iM366getSizeimpl = UShortArray.m366getSizeimpl(sArr);
        for (int i = 0; i < iM366getSizeimpl; i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(function1.invoke(UShort.m301boximpl(UShortArray.m365getMh2AYeg(sArr, i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{86, 83, 6, 77, 72, 24, 77, 74}, "77bef6ccc557", false));
        }
        return bigIntegerValueOf;
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m503binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m182getSizeimpl(iArr);
        }
        return UArraysKt.m502binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m507binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m261getSizeimpl(jArr);
        }
        return UArraysKt.m506binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m509binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m103getSizeimpl(bArr);
        }
        return UArraysKt.m508binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m505binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m366getSizeimpl(sArr);
        }
        return UArraysKt.m504binarySearchEtDCXyQ(sArr, s, i, i2);
    }
}
