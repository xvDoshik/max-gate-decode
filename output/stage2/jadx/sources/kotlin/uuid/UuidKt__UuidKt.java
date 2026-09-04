package kotlin.uuid;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a,\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0001\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000fH\u0001\u001a\u0019\u0010\u0016\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0018\u001a\u0019\u0010\u0016\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0018¨\u0006\u001a"}, d2 = {"uuidFromRandomBytes", "Lkotlin/uuid/Uuid;", "randomBytes", "", "getLongAtCommonImpl", "", "index", "", "formatBytesIntoCommonImpl", "", "dst", "dstOffset", "startIndex", "endIndex", "checkHyphenAt", "", "setLongAtCommonImpl", "value", "uuidParseHexDashCommonImpl", "hexDashString", "uuidParseHexCommonImpl", "hexString", "truncateForErrorMessage", "maxLength", "truncateForErrorMessage$UuidKt__UuidKt", "maxSize", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    public static final void checkHyphenAt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 67, 91, 89, 23, 15}, "7730d11fe393", true));
        if (str.charAt(i) != '-') {
            throw new IllegalArgumentException((C0000.decode(new byte[]{38, 72, 18, 81, 83, 67, 4, 92, 18, 18, 78, 23, 66, 28, 88, 78, 17, 80, 87, 91, 74, 16, 3, 64, 16, 94, 15, 92, 87, 77, 67}, "c0b407a825", 2) + i + C0000.decode(new byte[]{29, 16, 80, 16, 67, 69, 21, 7, 65, 68, 22}, "102e7ebf2d") + str.charAt(i) + '\'').toString());
        }
    }

    public static final void formatBytesIntoCommonImpl(long j, byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{84, 65, 64}, "024f3231", false));
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            bArr[i] = (byte) (i6 >> 8);
            i += 2;
            bArr[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    public static final long getLongAtCommonImpl(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{93, 66, 11, 15, 66, 7}, "a6cf197e6dda0361", 6));
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    public static final void setLongAtCommonImpl(byte[] bArr, int i, long j) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{93, 67, 81, 10, 66, 9}, "a79c177971", 0));
        int i2 = 7;
        while (-1 < i2) {
            bArr[i] = (byte) (j >> (i2 << 3));
            i2--;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String truncateForErrorMessage$UuidKt__UuidKt(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(str, C0000.decode(new byte[]{13, 71, 84, 91, 65, 80, 88, 86, 89, 11, 68, 20, 82, 86, 21, 5, 2, 65, 76, 23, 21, 92, 25, 86, 88, 10, 29, 90, 69, 95, 89, 70, 23, 75, 72, 82, 65, 89, 88, 78, 86, 74, 92, 85, 94, 84, 27, 53, 23, 64, 81, 89, 6}, "c287a3987d04035f", true));
        String strSubstring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{70, 17, 86, 68, 66, 68, 15, 94, 82, 76, 26, 25, 24, 31}, "5d4766f0", 3));
        return sb.append(strSubstring).append(C0000.decode(new byte[]{29, 29, 22}, "338daf9df68b")).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String truncateForErrorMessage$UuidKt__UuidKt(byte[] bArr, int i) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) null, (CharSequence) C0000.decode(new byte[]{110}, "542703c421da", true), (CharSequence) C0000.decode(new byte[]{57}, "de043bbd2c8b73", 6), i, (CharSequence) null, (Function1) null, 49, (Object) null);
    }

    public static final Uuid uuidFromRandomBytes(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{22, 80, 94, 87, 10, 9, 36, 77, 65, 87, 18}, "d103edf452a1ec", 0.0f));
        byte b = (byte) (bArr[6] & 15);
        bArr[6] = b;
        bArr[6] = (byte) (b | 64);
        byte b2 = (byte) (bArr[8] & 63);
        bArr[8] = b2;
        bArr[8] = (byte) (b2 | ByteCompanionObject.MIN_VALUE);
        return Uuid.INSTANCE.fromByteArray(bArr);
    }

    public static final Uuid uuidParseHexCommonImpl(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 83, 29, 96, 76, 69, 88, 91, 80}, "c6e387157a61fa26", 6));
        return Uuid.INSTANCE.fromLongs(HexExtensionsKt.hexToLong$default(str, 0, 16, null, 4, null), HexExtensionsKt.hexToLong$default(str, 16, 32, null, 4, null));
    }

    public static final Uuid uuidParseHexDashCommonImpl(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{91, 87, 28, 113, 89, 21, 91, 97, 16, 71, 81, 8, 84}, "32d58f"));
        long jHexToLong$default = HexExtensionsKt.hexToLong$default(str, 0, 8, null, 4, null);
        UuidKt.checkHyphenAt(str, 8);
        long jHexToLong$default2 = HexExtensionsKt.hexToLong$default(str, 9, 13, null, 4, null);
        UuidKt.checkHyphenAt(str, 13);
        long jHexToLong$default3 = HexExtensionsKt.hexToLong$default(str, 14, 18, null, 4, null);
        UuidKt.checkHyphenAt(str, 18);
        long jHexToLong$default4 = HexExtensionsKt.hexToLong$default(str, 19, 23, null, 4, null);
        UuidKt.checkHyphenAt(str, 23);
        return Uuid.INSTANCE.fromLongs((jHexToLong$default2 << 16) | (jHexToLong$default << 32) | jHexToLong$default3, (jHexToLong$default4 << 48) | HexExtensionsKt.hexToLong$default(str, 24, 36, null, 4, null));
    }
}
