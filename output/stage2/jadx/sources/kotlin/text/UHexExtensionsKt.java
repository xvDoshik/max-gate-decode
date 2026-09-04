package kotlin.text;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\r\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0012\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00182\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u001d2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001d*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"toHexString", "", "Lkotlin/UByteArray;", "format", "Lkotlin/text/HexFormat;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByteArray", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lkotlin/UByte;", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByte", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lkotlin/UShort;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUShort", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lkotlin/UInt;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUInt", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lkotlin/ULong;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToULong", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UHexExtensionsKt {
    private static final byte hexToUByte(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 68, 90, 12, 18, 13}, "002ea3d6a1def979", false));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 14, 65, 94, 89, 77}, "da3389", 1));
        return UByte.m44constructorimpl(HexExtensionsKt.hexToByte(str, hexFormat));
    }

    static /* synthetic */ byte hexToUByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 70, 88, 81, 70, 92}, "82085b0986", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{94, 11, 74, 84, 89, 70}, "8d898252168e", 0.0f));
        return UByte.m44constructorimpl(HexExtensionsKt.hexToByte(str, hexFormat));
    }

    private static final byte[] hexToUByteArray(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 76, 14, 90, 75, 15}, "88f38102370111", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{94, 12, 16, 84, 2, 16}, "8cb9cd75c58e6809", true));
        return UByteArray.m97constructorimpl(HexExtensionsKt.hexToByteArray(str, hexFormat));
    }

    static /* synthetic */ byte[] hexToUByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 77, 92, 91, 69, 15}, "694261efb27caf", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{87, 13, 19, 88, 84, 23}, "1ba55c8ed6b0"));
        return UByteArray.m97constructorimpl(HexExtensionsKt.hexToByteArray(str, hexFormat));
    }

    private static final int hexToUInt(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 67, 92, 81, 22, 88}, "1748efff8b", false));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{3, 9, 64, 91, 7, 64}, "ef26f47d5a189a"));
        return UInt.m121constructorimpl(HexExtensionsKt.hexToInt(str, hexFormat));
    }

    static /* synthetic */ int hexToUInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 64, 81, 91, 67, 15}, "349201eb086e1b", false));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{84, 89, 66, 94, 4, 70}, "2603e20e419cf8", true));
        return UInt.m121constructorimpl(HexExtensionsKt.hexToInt(str, hexFormat));
    }

    private static final long hexToULong(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 22, 91, 81, 68, 93}, "7b387c", 0));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 91, 70, 88, 7, 71}, "d445f312", true));
        return ULong.m200constructorimpl(HexExtensionsKt.hexToLong(str, hexFormat));
    }

    static /* synthetic */ long hexToULong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 22, 93, 92, 22, 9}, "db55e702b2924d41", 1));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{86, 88, 74, 90, 89, 17}, "07878e"));
        return ULong.m200constructorimpl(HexExtensionsKt.hexToLong(str, hexFormat));
    }

    private static final short hexToUShort(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 67, 11, 12, 69, 93}, "57ce6c3a3f2df9", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{0, 10, 70, 85, 84, 71}, "fe48530c62792ddb", 0.0f));
        return UShort.m307constructorimpl(HexExtensionsKt.hexToShort(str, hexFormat));
    }

    static /* synthetic */ short hexToUShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 70, 90, 90, 68, 90}, "82237dc95fc12e"));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 91, 70, 93, 4, 68}, "d440e0e7", 0.0f));
        return UShort.m307constructorimpl(HexExtensionsKt.hexToShort(str, hexFormat));
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw, reason: not valid java name */
    private static final String m1345toHexString8M7LxHw(int i, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{86, 9, 20, 88, 80, 69}, "0ff511dd0e164e", 1));
        return HexExtensionsKt.toHexString(i, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw$default, reason: not valid java name */
    static /* synthetic */ String m1346toHexString8M7LxHw$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{84, 12, 67, 94, 3, 70}, "2c13b2a4"));
        return HexExtensionsKt.toHexString(i, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I, reason: not valid java name */
    private static final String m1347toHexString8UJCmI(long j, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{83, 90, 65, 94, 89, 76}, "55338830a9", 5));
        return HexExtensionsKt.toHexString(j, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I$default, reason: not valid java name */
    static /* synthetic */ String m1348toHexString8UJCmI$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{3, 89, 71, 90, 83, 17}, "e6572ee21d", 7));
        return HexExtensionsKt.toHexString(j, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00, reason: not valid java name */
    private static final String m1349toHexStringZQbaR00(byte b, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{85, 92, 17, 91, 86, 21}, "33c67ab677f4e3", 4));
        return HexExtensionsKt.toHexString(b, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00$default, reason: not valid java name */
    static /* synthetic */ String m1350toHexStringZQbaR00$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{4, 94, 68, 90, 84, 69}, "b16751d1f3b6a84f", 0.0f));
        return HexExtensionsKt.toHexString(b, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA, reason: not valid java name */
    private static final String m1351toHexStringlZCiFrA(byte[] bArr, int i, int i2, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{21, 66, 80, 15, 16, 65, 17, 13, 125, 86, 28, 107, 69, 68, 81, 8, 4}, "168fceeb53d8"));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{81, 92, 75, 14, 84, 18}, "739c5f697312e9b3", 0.0f));
        return HexExtensionsKt.toHexString(bArr, i, i2, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA$default, reason: not valid java name */
    static /* synthetic */ String m1352toHexStringlZCiFrA$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m103getSizeimpl(bArr);
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{20, 66, 12, 94, 16, 69, 18, 14, 122, 83, 77, 54, 66, 69, 10, 89, 87}, "06d7cafa265e67c7", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{87, 94, 75, 85, 83, 17}, "11982e87cfe09a8c", 4));
        return HexExtensionsKt.toHexString(bArr, i, i2, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0, reason: not valid java name */
    private static final String m1353toHexStringr3ox_E0(short s, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{0, 86, 20, 95, 3, 77}, "f9f2b99e0490f8", 0));
        return HexExtensionsKt.toHexString(s, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0$default, reason: not valid java name */
    static /* synthetic */ String m1354toHexStringr3ox_E0$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 95, 23, 85, 84, 65}, "d0e855b19a836bc5", true));
        return HexExtensionsKt.toHexString(s, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU, reason: not valid java name */
    private static final String m1355toHexStringzHuV2wU(byte[] bArr, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{20, 23, 14, 93, 64, 17, 68, 11, 124, 0, 72, 48, 18, 70, 90, 91, 87}, "0cf4350d4e", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 9, 19, 11, 88, 22}, "dfaf9b", 2));
        return HexExtensionsKt.toHexString(bArr, hexFormat);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU$default, reason: not valid java name */
    static /* synthetic */ String m1356toHexStringzHuV2wU$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{64, 69, 9, 15, 65, 16, 16, 94, 41, 3, 74, 103, 16, 67, 8, 8, 85}, "d1af24"));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{83, 90, 71, 90, 4, 70}, "5557e2fe3fd3e27d"));
        return HexExtensionsKt.toHexString(bArr, hexFormat);
    }
}
