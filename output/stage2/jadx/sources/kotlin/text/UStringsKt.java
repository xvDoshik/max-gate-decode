package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0019\u0010\u0013\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0019\u0010\u0016\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0011\u0010\u0019\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u0019\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001e\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toUByteOrNull", "toUShortOrNull", "toUIntOrNull", "toULongOrNull", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UStringsKt {
    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m1358toStringLxnNnR4(byte b, int i) {
        String string = Integer.toString(b & UByte.MAX_VALUE, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{71, 94, 49, 21, 23, 10, 12, 1, 24, 75, 25, 27, 26}, "31baecbf0e75", 5));
        return string;
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m1360toStringolVBNx4(short s, int i) {
        String string = Integer.toString(s & UShort.MAX_VALUE, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{77, 92, 55, 16, 22, 80, 11, 80, 24, 22, 27, 72, 25}, "93ddd9e7085f0c", 0.0f));
        return string;
    }

    public static final byte toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 18, 12, 90, 23, 90}, "cfd3dda77f", 3));
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final byte toUByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 21, 81, 11, 65, 6}, "8a9b289b36fd", 3));
        UByte uByteOrNull = toUByteOrNull(str, i);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 71, 95, 90, 18, 6}, "4373a8", 3));
        return toUByteOrNull(str, 10);
    }

    public static final UByte toUByteOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 22, 10, 13, 71, 88}, "3bbd4f2b4aeba9", true));
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compareUnsigned(data, UInt.m121constructorimpl(KotlinVersion.MAX_COMPONENT_VALUE)) > 0) {
            return null;
        }
        return UByte.m38boximpl(UByte.m44constructorimpl((byte) data));
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{14, 69, 94, 88, 75, 7}, "216189f25e39"));
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 68, 89, 93, 70, 9}, "b014571d0991dfaf", 5));
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 21, 80, 90, 75, 93}, "7a838cf059e805", 7));
        return toUIntOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 18, 14, 13, 74, 95}, "7ffd9a724eb49aef", 5));
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iM121constructorimpl = UInt.m121constructorimpl(i);
        int iDivideUnsigned = 119304647;
        while (i2 < length) {
            int iDigitOf = CharsKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i3, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, iM121constructorimpl);
                    if (Integer.compareUnsigned(i3, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int iM121constructorimpl2 = UInt.m121constructorimpl(i3 * iM121constructorimpl);
            int iM121constructorimpl3 = UInt.m121constructorimpl(UInt.m121constructorimpl(iDigitOf) + iM121constructorimpl2);
            if (Integer.compareUnsigned(iM121constructorimpl3, iM121constructorimpl2) < 0) {
                return null;
            }
            i2++;
            i3 = iM121constructorimpl3;
        }
        return UInt.m115boximpl(i3);
    }

    public static final long toULong(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 70, 90, 11, 68, 15}, "622b71", 0.0f));
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 76, 91, 10, 65, 91}, "183c2e1f96"));
        ULong uLongOrNull = toULongOrNull(str, i);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 69, 90, 88, 68, 12}, "112172ab25", false));
        return toULongOrNull(str, 10);
    }

    public static final ULong toULongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 66, 14, 88, 74, 7}, "06f199", 0.0f));
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jM200constructorimpl = ULong.m200constructorimpl(i);
        long j = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i2 < length) {
            int iDigitOf = CharsKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (Long.compareUnsigned(j, jDivideUnsigned) > 0) {
                if (jDivideUnsigned == 512409557603043100L) {
                    jDivideUnsigned = Long.divideUnsigned(-1L, jM200constructorimpl);
                    if (Long.compareUnsigned(j, jDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            long jM200constructorimpl2 = ULong.m200constructorimpl(j * jM200constructorimpl);
            long jM200constructorimpl3 = ULong.m200constructorimpl(ULong.m200constructorimpl(((long) UInt.m121constructorimpl(iDigitOf)) & 4294967295L) + jM200constructorimpl2);
            if (Long.compareUnsigned(jM200constructorimpl3, jM200constructorimpl2) < 0) {
                return null;
            }
            i2++;
            j = jM200constructorimpl3;
        }
        return ULong.m194boximpl(j);
    }

    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 22, 88, 92, 16, 11}, "cb05c5", 0.0f));
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 21, 89, 8, 17, 11}, "5a1ab5"));
        UShort uShortOrNull = toUShortOrNull(str, i);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 68, 91, 93, 17, 91}, "d034be35a68c96fd", false));
        return toUShortOrNull(str, 10);
    }

    public static final UShort toUShortOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 16, 13, 91, 67, 8}, "ade206b0ddf2", true));
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compareUnsigned(data, UInt.m121constructorimpl(65535)) > 0) {
            return null;
        }
        return UShort.m301boximpl(UShort.m307constructorimpl((short) data));
    }

    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m1359toStringV7xB4Y4(int i, int i2) {
        return UnsignedKt.ulongToString(((long) i) & 4294967295L, CharsKt.checkRadix(i2));
    }

    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m1357toStringJSWoG40(long j, int i) {
        return UnsignedKt.ulongToString(j, CharsKt.checkRadix(i));
    }
}
