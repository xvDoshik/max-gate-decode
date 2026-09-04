package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m493sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{83, 20, 23, 86, 72}, "2fe7122c07", 5));
        m489quickSortnroSd4(jArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m494sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{82, 65, 71, 2, 74}, "335c3b444fe16c2b", 3));
        m490quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m495sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{5, 22, 64, 5, 28}, "dd2ded773b43", 2));
        m491quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m496sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{80, 70, 74, 0, 27}, "148abb", 3));
        m492quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m486partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM102getw2LRezQ = UByteArray.m102getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM102getw2LRezQ = UByteArray.m102getw2LRezQ(bArr, i) & UByte.MAX_VALUE;
                i3 = bM102getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(iM102getw2LRezQ, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m102getw2LRezQ(bArr, i2) & UByte.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM102getw2LRezQ2 = UByteArray.m102getw2LRezQ(bArr, i);
                UByteArray.m107setVurrAj0(bArr, i, UByteArray.m102getw2LRezQ(bArr, i2));
                UByteArray.m107setVurrAj0(bArr, i2, bM102getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m490quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM486partition4UcCI2c = m486partition4UcCI2c(bArr, i, i2);
        int i3 = iM486partition4UcCI2c - 1;
        if (i < i3) {
            m490quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM486partition4UcCI2c < i2) {
            m490quickSort4UcCI2c(bArr, iM486partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m487partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM365getMh2AYeg = UShortArray.m365getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM365getMh2AYeg = UShortArray.m365getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM365getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM365getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m365getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM365getMh2AYeg2 = UShortArray.m365getMh2AYeg(sArr, i);
                UShortArray.m370set01HTLdE(sArr, i, UShortArray.m365getMh2AYeg(sArr, i2));
                UShortArray.m370set01HTLdE(sArr, i2, sM365getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m491quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM487partitionAa5vz7o = m487partitionAa5vz7o(sArr, i, i2);
        int i3 = iM487partitionAa5vz7o - 1;
        if (i < i3) {
            m491quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM487partitionAa5vz7o < i2) {
            m491quickSortAa5vz7o(sArr, iM487partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m488partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM181getpVg5ArA = UIntArray.m181getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m181getpVg5ArA(iArr, i), iM181getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m181getpVg5ArA(iArr, i2), iM181getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM181getpVg5ArA2 = UIntArray.m181getpVg5ArA(iArr, i);
                UIntArray.m186setVXSXFK8(iArr, i, UIntArray.m181getpVg5ArA(iArr, i2));
                UIntArray.m186setVXSXFK8(iArr, i2, iM181getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m492quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM488partitionoBK06Vg = m488partitionoBK06Vg(iArr, i, i2);
        int i3 = iM488partitionoBK06Vg - 1;
        if (i < i3) {
            m492quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM488partitionoBK06Vg < i2) {
            m492quickSortoBK06Vg(iArr, iM488partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m485partitionnroSd4(long[] jArr, int i, int i2) {
        long jM260getsVKNKU = ULongArray.m260getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m260getsVKNKU(jArr, i), jM260getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m260getsVKNKU(jArr, i2), jM260getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM260getsVKNKU2 = ULongArray.m260getsVKNKU(jArr, i);
                ULongArray.m265setk8EXiF4(jArr, i, ULongArray.m260getsVKNKU(jArr, i2));
                ULongArray.m265setk8EXiF4(jArr, i2, jM260getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m489quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM485partitionnroSd4 = m485partitionnroSd4(jArr, i, i2);
        int i3 = iM485partitionnroSd4 - 1;
        if (i < i3) {
            m489quickSortnroSd4(jArr, i, i3);
        }
        if (iM485partitionnroSd4 < i2) {
            m489quickSortnroSd4(jArr, iM485partitionnroSd4, i2);
        }
    }
}
