package kotlin.io.encoding;

import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\t\b\u0017\u0018\u0000 >2\u00020\u0001:\u0002=>B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J4\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J=\u0010\u001b\u001a\u0002H\u001c\"\f\b\u0000\u0010\u001c*\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u0002H\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J4\u0010!\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\"\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J4\u0010!\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J%\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0002\b$J5\u0010%\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u0003H\u0002J0\u0010+\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J%\u0010,\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0002\b-J%\u0010.\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b1J(\u00102\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00103\u001a\u00020\u0014H\u0002J \u00107\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J%\u00108\u001a\u0002062\u0006\u0010(\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0002\b9J \u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006?"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "paddingOption", "Lkotlin/io/encoding/Base64$PaddingOption;", "<init>", "(ZZLkotlin/io/encoding/Base64$PaddingOption;)V", "isUrlSafe$kotlin_stdlib", "()Z", "isMimeScheme$kotlin_stdlib", "getPaddingOption$kotlin_stdlib", "()Lkotlin/io/encoding/Base64$PaddingOption;", "withPadding", "option", "encodeToByteArray", "", "source", "startIndex", "", "endIndex", "encodeIntoByteArray", "destination", "destinationOffset", "encode", "", "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "decode", "decodeIntoByteArray", "", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "sourceSize", "encodeSize$kotlin_stdlib", "shouldPadOnEncode", "decodeImpl", "decodeSize", "decodeSize$kotlin_stdlib", "charsToBytesImpl", "charsToBytesImpl$kotlin_stdlib", "bytesToStringImpl", "bytesToStringImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "checkPaddingIsAllowed", "", "skipIllegalSymbolsIfMime", "checkSourceBounds", "checkSourceBounds$kotlin_stdlib", "checkDestinationBounds", "destinationSize", "capacityNeeded", "PaddingOption", "Default", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Base64 {
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private final PaddingOption paddingOption;

    /* JADX INFO: renamed from: Default, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] mimeLineSeparatorSymbols = {13, 10};
    private static final Base64 UrlSafe = new Base64(true, false, PaddingOption.PRESENT);
    private static final Base64 Mime = new Base64(false, true, PaddingOption.PRESENT);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlin/io/encoding/Base64$PaddingOption;", "", "<init>", "(Ljava/lang/String;I)V", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum PaddingOption {
        PRESENT,
        ABSENT,
        PRESENT_OPTIONAL,
        ABSENT_OPTIONAL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<PaddingOption> getEntries() {
            return $ENTRIES;
        }
    }

    private Base64(boolean z, boolean z2, PaddingOption paddingOption) {
        this.isUrlSafe = z;
        this.isMimeScheme = z2;
        this.paddingOption = paddingOption;
        if (z && z2) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{114, 88, 8, 15, 82, 5, 16, 20, 84, 19, 16, 8, 70, 92, 12, 6, 89, 21, 30}, "49ac7a0f1bea", true).toString());
        }
    }

    public /* synthetic */ Base64(boolean z, boolean z2, PaddingOption paddingOption, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, paddingOption);
    }

    private final void checkDestinationBounds(int destinationSize, int destinationOffset, int capacityNeeded) {
        String strDecode = C0000.decode(new byte[]{28, 24, 80, 82, 18, 69, 93, 90, 81, 69, 93, 86, 91, 69, 18, 11, 74, 93, 14, 23}, "0847a14401495eab", 4);
        if (destinationOffset < 0 || destinationOffset > destinationSize) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{85, 4, 75, 76, 11, 88, 85, 23, 91, 10, 88, 24, 91, 2, 95, 16, 84, 21, 2, 24}, "1a88b64c2e684d9c", 0.0f) + destinationOffset + strDecode + destinationSize);
        }
        int i = destinationOffset + capacityNeeded;
        if (i < 0 || i > destinationSize) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{53, 10, 0, 68, 80, 87, 71, 70, 11, 12, 0, 22, 12, 11, 90, 18, 85, 64, 16, 3, 24, 66, 1, 11, 81, 65, 20, 92, 13, 22, 65, 10, 4, 18, 81, 18, 81, 92, 13, 23, 6, 10, 69, 7, 85, 66, 85, 81, 11, 22, 24, 78, 69, 0, 81, 65, 64, 91, 12, 3, 21, 11, 10, 10, 20, 93, 82, 84, 17, 7, 21, 88, 69}, "abed4242bb", 3) + destinationOffset + strDecode + destinationSize + C0000.decode(new byte[]{20, 21, 0, 85, 21, 3, 7, 90, 66, 26, 19, 8, 4, 87, 92, 80, 7, 14, 69}, "85c4ebd36c3fa2", 0) + capacityNeeded);
        }
    }

    private final void checkPaddingIsAllowed(int padIndex) {
        if (this.paddingOption == PaddingOption.ABSENT) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{50, 12, 3, 24, 69, 86, 92, 86, 8, 12, 1, 68, 9, 72, 65, 94, 87, 92, 65, 11, 21, 68, 21, 93, 65, 23, 76, 93, 65, 35, 36, 55, 35, 118, 97, 27, 24, 80, 20, 22, 70, 16, 14, 93, 21, 94, 86, 66, 20, 22, 70, 12, 7, 75, 21, 86, 24, 66, 0, 6, 70, 7, 14, 89, 71, 86, 91, 70, 4, 16, 70, 5, 18, 24, 92, 89, 92, 87, 25, 66}, "fdf85782ab") + padIndex);
        }
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{54, 16, 19, 80, 66, 69, 81, 89, 84, 92, 64, 66, 19, 88, 16, 93, 69, 1, 6, 83, 81, 16, 94, 76, 24, 81, 65, 5, 17, 92, 1, 91, 17, 22, 67, 91, 95, 17, 18, 75, 77, 64, 67, 13, 22, 69, 1, 81, 69, 12, 13, 21, 68, 13, 91, 75, 24, 68, 82, 16, 3, 84, 16, 25, 69, 3, 22, 91, 83, 17, 91, 87, 86, 10, 19, 6, 1, 82, 11, 81, 0}, "eec50e28803bd1d5", false));
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return base64.decode(charSequence, i, i2);
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{103, 17, 19, 92, 68, 25, 7, 85, 91, 15, 71, 68, 20, 80, 66, 81, 68, 80, 82, 5, 85, 17, 15, 77, 22, 88, 22, 83, 66, 14, 81, 10, 23, 74, 22, 87, 11, 64, 23, 16, 65, 20, 19, 86, 68, 77, 1, 80, 23, 10, 90, 68, 23, 81, 95, 74, 68, 64, 86, 17, 83, 1, 23, 21, 22, 95, 17, 90, 84, 23, 93, 11, 13, 3, 22, 93, 1, 87, 88, 7, 81}, "4dc969d47c", 4));
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.decode(bArr, i, i2);
    }

    private final int decodeImpl(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        String strDecode;
        String strDecode2;
        String strDecode3;
        int i;
        int i2;
        int i3;
        int[] iArr = this.isUrlSafe ? Base64Kt.base64UrlDecodeMap : Base64Kt.base64DecodeMap;
        int i4 = -8;
        int i5 = destinationOffset;
        int iHandlePaddingSymbol = startIndex;
        int i6 = -8;
        int i7 = 0;
        while (true) {
            strDecode = C0000.decode(new byte[]{74, 24, 87, 22, 70, 94, 13, 92, 83, 26, 70}, "c86bf7", 7);
            strDecode2 = C0000.decode(new byte[]{68, 9, 97, 69, 64, 15, 94, 1, 26, 31, 28, 72, 25}, "0f212f", 5);
            strDecode3 = C0000.decode(new byte[]{18, 78}, "5fd47eeb", false);
            if (iHandlePaddingSymbol >= endIndex) {
                i = 8;
                i2 = 0;
                break;
            }
            if (i6 != i4 || iHandlePaddingSymbol + 3 >= endIndex) {
                i = 8;
                i3 = 1;
            } else {
                i = 8;
                i3 = 1;
                int i8 = iHandlePaddingSymbol + 4;
                int i9 = (iArr[source[iHandlePaddingSymbol + 1] & UByte.MAX_VALUE] << 12) | (iArr[source[iHandlePaddingSymbol] & UByte.MAX_VALUE] << 18) | (iArr[source[iHandlePaddingSymbol + 2] & UByte.MAX_VALUE] << bitsPerSymbol) | iArr[source[iHandlePaddingSymbol + 3] & UByte.MAX_VALUE];
                if (i9 >= 0) {
                    destination[i5] = (byte) (i9 >> 16);
                    int i10 = i5 + 2;
                    destination[i5 + 1] = (byte) (i9 >> 8);
                    i5 += 3;
                    destination[i10] = (byte) i9;
                    iHandlePaddingSymbol = i8;
                }
                i4 = -8;
            }
            int i11 = source[iHandlePaddingSymbol] & UByte.MAX_VALUE;
            int i12 = iArr[i11];
            if (i12 >= 0) {
                iHandlePaddingSymbol++;
                i7 = (i7 << bitsPerSymbol) | i12;
                int i13 = i6 + bitsPerSymbol;
                if (i13 >= 0) {
                    destination[i5] = (byte) (i7 >>> i13);
                    i7 &= (i3 << i13) - 1;
                    i6 -= 2;
                    i5++;
                } else {
                    i6 = i13;
                }
            } else {
                if (i12 == -2) {
                    iHandlePaddingSymbol = handlePaddingSymbol(source, iHandlePaddingSymbol, endIndex, i6);
                    i2 = i3;
                    break;
                }
                if (!this.isMimeScheme) {
                    StringBuilder sbAppend = new StringBuilder(C0000.decode(new byte[]{43, 15, 79, 81, 14, 81, 6, 65, 74, 73, 15, 90, 13, 13, 25, 23}, "ba90b8", 3)).append((char) i11).append(strDecode3);
                    String string = Integer.toString(i11, CharsKt.checkRadix(i));
                    Intrinsics.checkNotNullExpressionValue(string, strDecode2);
                    throw new IllegalArgumentException(sbAppend.append(string).append(strDecode).append(iHandlePaddingSymbol).toString());
                }
                iHandlePaddingSymbol++;
            }
            i4 = -8;
        }
        if (i6 == -2) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{103, 10, 6, 20, 13, 85, 64, 22, 67, 65, 15, 93, 71, 66, 12, 82, 65, 93, 93, 18, 22, 64, 65, 80, 92, 7, 16, 20, 15, 91, 71, 66, 11, 85, 23, 81, 19, 7, 13, 91, 20, 83, 91, 66, 1, 93, 21, 71}, "3bc4a4", false));
        }
        if (i6 != -8 && i2 == 0 && this.paddingOption == PaddingOption.PRESENT) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{108, 80, 7, 23, 18, 84, 81, 87, 8, 8, 95, 24, 13, 71, 22, 92, 90, 93, 65, 15, 75, 24, 17, 82, 22, 21, 65, 92, 65, 54, 106, 125, 49, 114, 44, 97, 25, 19, 3, 19, 76, 24, 22, 95, 7, 21, 92, 93, 17, 19, 76, 24, 11, 68, 66, 91, 90, 71, 65, 22, 74, 87, 18, 82, 16, 89, 76, 19, 17, 7, 92, 92, 7, 83}, "88b7b553af", 0.0f));
        }
        if (i7 != 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{49, 14, 6, 19, 18, 4, 80, 21, 82, 88, 21, 64, 69, 11, 22, 64, 22, 69, 86, 80, 16, 75, 4, 65, 10, 21}, "efc3be4501a3", 0.0f));
        }
        int iSkipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(source, iHandlePaddingSymbol, endIndex);
        if (iSkipIllegalSymbolsIfMime >= endIndex) {
            return i5 - destinationOffset;
        }
        int i14 = source[iSkipIllegalSymbolsIfMime] & UByte.MAX_VALUE;
        StringBuilder sbAppend2 = new StringBuilder(C0000.decode(new byte[]{101, 29, 92, 3, 13, 85, 25, 69}, "6d1ab99b")).append((char) i14).append(strDecode3);
        String string2 = Integer.toString(i14, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string2, strDecode2);
        throw new IllegalArgumentException(sbAppend2.append(string2).append(strDecode).append(iSkipIllegalSymbolsIfMime - 1).append(C0000.decode(new byte[]{69, 95, 67, 24, 21, 16, 91, 94, 12, 84, 89, 76, 0, 6, 20, 87, 3, 66, 85, 74, 69, 22, 92, 83, 69, 70, 81, 92, 69, 1, 92, 87, 23, 87, 83, 76, 0, 16}, "e608eb46")).toString());
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{50, 20, 64, 85, 65, 17, 80, 80, 10, 92, 22, 21, 68, 92, 21, 9, 16, 84, 86, 87, 82, 68, 10, 68, 69, 84, 65, 82, 20, 12, 85, 94, 71, 66, 19, 95, 9, 68, 69, 70, 70, 69, 17, 14, 66, 68, 86, 85, 19, 88, 8, 16, 17, 93, 90, 70, 65, 21, 81, 66, 84, 84, 71, 29, 70, 86, 16, 91, 80, 65, 8, 14, 94, 10, 19, 85, 86, 82, 9, 84, 0, 124, 93, 65, 14, 35, 73, 68, 86, 112, 65, 67, 7, 73}, "aa003131f0e535", 0.0f));
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = charSequence.length();
        }
        return base64.decodeIntoByteArray(charSequence, bArr, i, i2, i3);
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{55, 67, 66, 81, 67, 25, 83, 86, 8, 90, 65, 20, 70, 80, 68, 95, 68, 82, 87, 82, 80, 76, 92, 67, 68, 87, 64, 83, 68, 84, 85, 89, 16, 69, 18, 90, 94, 77, 16, 68, 17, 70, 66, 91, 67, 77, 85, 83, 68, 95, 92, 20, 69, 81, 89, 68, 68, 66, 83, 70, 86, 92, 68, 27, 68, 80, 71, 90, 82, 77, 89, 88, 10, 12, 18, 80, 84, 90, 95, 83, 1, ByteCompanionObject.MAX_VALUE, 92, 64, 94, 123, 73, 67, 1, 119, 64, 70, 80, 64}, "d6241907", 4));
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.decodeIntoByteArray(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ String encode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{48, 69, 64, 6, 19, 16, 6, 5, 14, 10, 23, 25, 20, 89, 68, 11, 65, 84, 0, 2, 3, 19, 8, 77, 67, 81, 66, 4, 20, 93, 0, 10, 22, 21, 68, 87, 12, 68, 16, 16, 20, 64, 21, 11, 16, 18, 1, 93, 67, 89, 94, 67, 21, 88, 12, 23, 66, 18, 5, 75, 4, 85, 68, 79, 65, 86, 16, 10, 1, 18, 13, 86, 13, 10, 16, 6, 15, 83, 10, 0, 7}, "c00ca0edbfd9", false));
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.encode(bArr, i, i2);
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{48, 77, 64, 0, 65, 16, 0, 89, 92, 9, 64, 16, 20, 81, 68, 13, 19, 84, 6, 94, 81, 16, 95, 68, 67, 89, 66, 2, 70, 93, 6, 86, 68, 22, 19, 94, 12, 76, 16, 22, 70, 64, 19, 87, 66, 17, 86, 84, 67, 81, 94, 69, 71, 88, 10, 75, 16, 17, 82, 66, 4, 93, 68, 73, 19, 86, 22, 86, 83, 17, 90, 95, 13, 2, 16, 0, 93, 83, 12, 92, 85, 44, 93, 68, 12, 122, 73, 17, 86, 113, 17, 74, 81, 28}, "c80e30"));
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.encodeIntoByteArray(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 base64, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{101, 70, 64, 87, 16, 21, 1, 85, 13, 88, 69, 19, 71, 91, 22, 93, 66, 80, 4, 82, 87, 70, 92, 70, 66, 84, 16, 83, 20, 89, 83, 93, 68, 65, 66, 91, 13, 64, 65, 71, 67, 67, 64, 93, 16, 65, 7, 80, 65, 93, 88, 19, 68, 90, 11, 70, 66, 64, 0, 70, 81, 86, 68, 30, 66, 83, 23, 90, 2, 64, 95, 92, 94, 8, 66, 80, 12, 87, 14, 80, 83, 103, 95, 115, 18, 69, 7, 90, 5, 85, 84, 95, 85}, "6302b5b4a4"));
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        return base64.encodeToAppendable(bArr, appendable, i, i2);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{96, 76, 68, 81, 68, 19, 87, 83, 8, 94, 18, 22, 71, 10, 71, 81, 20, 80, 83, 85, 85, 71, 8, 70, 65, 87, 66, 4, 70, 84, 81, 90, 66, 64, 20, 92, 11, 70, 65, 69, 69, 19, 67, 86, 70, 64, 83, 87, 20, 91, 10, 18, 21, 94, 89, 16, 19, 77, 85, 70, 81, 86, 64, 30, 68, 84, 20, 88, 83, 23, 90, 86, 90, 14, 22, 86, 90, 81, 11, 86, 4, 98, 95, 33, 74, 77, 81, 117, 68, 65, 85, 75}, "39446342d2a60c", 0.0f));
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.encodeToByteArray(bArr, i, i2);
    }

    private final int handlePaddingSymbol(byte[] source, int padIndex, int endIndex, int byteStart) {
        if (byteStart == -8) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{101, 80, 82, 19, 10, 92, 85, 94, 17, 23, 71, 83, 1, 70, 84, 93, 87, 20, 5, 91, 64, 85, 23, 23, 86, 70, 69, 15, 89, 81, 83, 30, 68}, "756fd840e772ef", 2) + padIndex);
        }
        if (byteStart == -6) {
            checkPaddingIsAllowed(padIndex);
            return padIndex + 1;
        }
        if (byteStart != -4) {
            if (byteStart == -2) {
                return padIndex + 1;
            }
            throw new IllegalStateException(C0000.decode(new byte[]{103, 86, 65, 93, 2, 5, 90, 89, 81, 84, 6}, "2838cf").toString());
        }
        checkPaddingIsAllowed(padIndex);
        int iSkipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(source, padIndex + 1, endIndex);
        if (iSkipIllegalSymbolsIfMime == endIndex || source[iSkipIllegalSymbolsIfMime] != 61) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{117, 8, 17, 18, 80, 95, 6, 23, 95, 11, 7, 24, 18, 81, 85, 69, 91, 9, 3, 19, 88, 82, 21, 82, 66, 69, 3, 76, 66, 89, 95, 1, 93, 25, 66}, "8aba91a70eb8b01e", false) + iSkipIllegalSymbolsIfMime);
        }
        return iSkipIllegalSymbolsIfMime + 1;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] source) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{74, 10, 77, 75, 81, 83}, "9e8926b2f1a2", false));
        StringBuilder sb = new StringBuilder(source.length);
        for (byte b : source) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{67, 92, 23, 71, 1, 84}, "03b5b1", true));
        checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
        byte[] bArr = new byte[endIndex - startIndex];
        int i = 0;
        while (startIndex < endIndex) {
            char cCharAt = source.charAt(startIndex);
            if (cCharAt <= 255) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else {
                bArr[i] = 63;
                i++;
            }
            startIndex++;
        }
        return bArr;
    }

    public final byte[] decode(CharSequence source, int startIndex, int endIndex) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{69, 94, 17, 74, 86, 92}, "61d859446e65"));
        if (source instanceof String) {
            String str = (String) source;
            checkSourceBounds$kotlin_stdlib(str.length(), startIndex, endIndex);
            String strSubstring = str.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{71, 66, 3, 16, 23, 70, 13, 90, 83, 31, 79, 77, 77, 29}, "47acc4d4", 0.0f));
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{91, 76, 88, 88, 66, 85, 89, 91, 15, 12, 65, 25, 86, 81, 66, 85, 89, 70, 21, 67, 65, 86, 20, 90, 13, 88, 21, 91, 20, 15, 89, 25, 64, 77, 18, 83, 24, 95, 0, 21, 84, 23, 88, 85, 12, 81, 22, 102, 21, 17, 92, 87, 83}, "5944b685ac", 2));
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, C0000.decode(new byte[]{86, 92, 23, 32, 24, 22, 82, 75, 29, 31, 74, 26, 25}, "19cbab7851d4059c"));
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return decode$default(this, bArrCharsToBytesImpl$kotlin_stdlib, 0, 0, bitsPerSymbol, (Object) null);
    }

    public final byte[] decode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{18, 87, 19, 19, 87, 93}, "a8fa482106ca", false));
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        int iDecodeSize$kotlin_stdlib = decodeSize$kotlin_stdlib(source, startIndex, endIndex);
        byte[] bArr = new byte[iDecodeSize$kotlin_stdlib];
        if (decodeImpl(source, bArr, 0, startIndex, endIndex) == iDecodeSize$kotlin_stdlib) {
            return bArr;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{37, 89, 7, 1, 95, 67, 81, 4, 13, 85, 3, 85, 76}, "f1bb4c7ed9", true));
    }

    public final int decodeIntoByteArray(CharSequence source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{18, 87, 76, 17, 90, 85}, "a89c900360"));
        Intrinsics.checkNotNullParameter(destination, C0000.decode(new byte[]{92, 83, 71, 22, 8, 8, 84, 18, 81, 89, 90}, "864baf5f"));
        if (source instanceof String) {
            String str = (String) source;
            checkSourceBounds$kotlin_stdlib(str.length(), startIndex, endIndex);
            String strSubstring = str.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{74, 64, 3, 67, 76, 68, 80, 91, 6, 24, 22, 24, 23, 28}, "95a086"));
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{91, 70, 89, 92, 68, 0, 5, 10, 91, 87, 23, 16, 82, 85, 25, 2, 84, 64, 65, 16, 16, 12, 68, 10, 90, 86, 78, 94, 69, 92, 85, 65, 65, 74, 69, 85, 68, 9, 5, 18, 84, 22, 15, 81, 94, 87, 23, 50, 65, 65, 92, 94, 3}, "5350dcdd58c0009a"));
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, C0000.decode(new byte[]{3, 3, 70, 115, 78, 16, 0, 71, 76, 31, 74, 72, 27}, "df217de4d1"));
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return decodeIntoByteArray$default(this, bArrCharsToBytesImpl$kotlin_stdlib, destination, destinationOffset, 0, 0, 24, (Object) null);
    }

    public final int decodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{21, 87, 16, 69, 6, 82}, "f8e7e7f65d4f793b", 3));
        Intrinsics.checkNotNullParameter(destination, C0000.decode(new byte[]{2, 7, 22, 67, 93, 11, 3, 70, 90, 89, 12}, "fbe74eb236b23f42", true));
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, decodeSize$kotlin_stdlib(source, startIndex, endIndex));
        return decodeImpl(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int decodeSize$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{64, 94, 66, 17, 83, 82}, "317c076f4e", true));
        int i = endIndex - startIndex;
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{40, 15, 71, 77, 71, 67, 65, 92, 87, 19, 93, 81, 65, 9, 86, 78, 86, 67, 83, 64, 24, 10, 84, 84, 18, 21, 23, 10, 19, 16, 75, 89, 90, 9, 93, 70, 65, 7, 88, 74, 19, 33, 83, 71, 93, 80, 5, 21, 5, 4, 84, 87, 87, 10, 92, 83, 20, 70, 66, 65, 0, 19, 67, 113, 93, 7, 87, 76, 2, 70}, "aa783c248f15", 5) + startIndex + C0000.decode(new byte[]{28, 16, 0, 11, 92, 125, 92, 80, 92, 79, 91, 20}, "00ee842497a4", bitsPerSymbol) + endIndex);
        }
        if (this.isMimeScheme) {
            while (startIndex < endIndex) {
                int i2 = Base64Kt.base64DecodeMap[source[startIndex] & UByte.MAX_VALUE];
                if (i2 < 0) {
                    if (i2 == -2) {
                        i -= endIndex - startIndex;
                        break;
                    }
                    i--;
                }
                startIndex++;
            }
        } else if (source[endIndex - 1] == 61) {
            i = source[endIndex + (-2)] == 61 ? i - 2 : i - 1;
        }
        return (int) ((((long) i) * ((long) bitsPerSymbol)) / ((long) 8));
    }

    public final String encode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{23, 14, 20, 23, 82, 7}, "daae1bdb", 0));
        return new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
    }

    public final int encodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{75, 87, 23, 19, 2, 86}, "88baa3f675e226", 3));
        Intrinsics.checkNotNullParameter(destination, C0000.decode(new byte[]{0, 3, 64, 66, 90, 8, 81, 67, 95, 92, 13}, "df363f0763cd", 0.0f));
        return encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        int i = startIndex;
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{66, 91, 76, 17, 0, 1}, "149ccd2ced", true));
        Intrinsics.checkNotNullParameter(destination, C0000.decode(new byte[]{92, 85, 65, 67, 8, 86, 2, 65, 81, 11, 86}, "8027a8c58d", true));
        checkSourceBounds$kotlin_stdlib(source.length, i, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, encodeSize$kotlin_stdlib(endIndex - i));
        byte[] bArr = this.isUrlSafe ? Base64Kt.base64UrlEncodeMap : Base64Kt.base64EncodeMap;
        int i2 = this.isMimeScheme ? mimeGroupsPerLine : IntCompanionObject.MAX_VALUE;
        int i3 = destinationOffset;
        while (i + 2 < endIndex) {
            int iMin = Math.min((endIndex - i) / 3, i2);
            for (int i4 = 0; i4 < iMin; i4++) {
                int i5 = source[i] & UByte.MAX_VALUE;
                int i6 = i + 2;
                int i7 = source[i + 1] & UByte.MAX_VALUE;
                i += 3;
                int i8 = (i7 << 8) | (i5 << 16) | (source[i6] & UByte.MAX_VALUE);
                destination[i3] = bArr[i8 >>> 18];
                destination[i3 + 1] = bArr[(i8 >>> 12) & 63];
                int i9 = i3 + 3;
                destination[i3 + 2] = bArr[(i8 >>> bitsPerSymbol) & 63];
                i3 += 4;
                destination[i9] = bArr[i8 & 63];
            }
            if (iMin == i2 && i != endIndex) {
                int i10 = i3 + 1;
                byte[] bArr2 = mimeLineSeparatorSymbols;
                destination[i3] = bArr2[0];
                i3 += 2;
                destination[i10] = bArr2[1];
            }
        }
        int i11 = endIndex - i;
        if (i11 == 1) {
            int i12 = i + 1;
            int i13 = (source[i] & UByte.MAX_VALUE) << 4;
            destination[i3] = bArr[i13 >>> bitsPerSymbol];
            int i14 = i3 + 2;
            destination[i3 + 1] = bArr[i13 & 63];
            if (shouldPadOnEncode()) {
                int i15 = i3 + 3;
                destination[i14] = padSymbol;
                i3 += 4;
                destination[i15] = padSymbol;
                i = i12;
            } else {
                i = i12;
                i3 = i14;
            }
        } else if (i11 == 2) {
            int i16 = i + 1;
            int i17 = source[i] & UByte.MAX_VALUE;
            i += 2;
            int i18 = ((source[i16] & UByte.MAX_VALUE) << 2) | (i17 << 10);
            destination[i3] = bArr[i18 >>> 12];
            destination[i3 + 1] = bArr[(i18 >>> bitsPerSymbol) & 63];
            int i19 = i3 + 3;
            destination[i3 + 2] = bArr[i18 & 63];
            if (shouldPadOnEncode()) {
                i3 += 4;
                destination[i19] = padSymbol;
            } else {
                i3 = i19;
            }
        }
        if (i == endIndex) {
            return i3 - destinationOffset;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{38, 88, 87, 5, 90, 69, 83, 7, 12, 92, 87, 2, 31}, "e02f1e5f"));
    }

    public final int encodeSize$kotlin_stdlib(int sourceSize) {
        int i = sourceSize / 3;
        int i2 = sourceSize % 3;
        int i3 = i * 4;
        if (i2 != 0) {
            i3 += shouldPadOnEncode() ? 4 : i2 + 1;
        }
        if (this.isMimeScheme) {
            i3 += ((i3 - 1) / 76) * 2;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{125, 12, 18, 23, 67, 17, 89, 75, 16, 21, 92, 9, 17, 87, 93, 5}, "4bbb71080a3f15", 7));
    }

    public final <A extends Appendable> A encodeToAppendable(byte[] source, A destination, int startIndex, int endIndex) throws IOException {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{22, 94, 71, 17, 2, 83}, "e12ca620143caf17", false));
        Intrinsics.checkNotNullParameter(destination, C0000.decode(new byte[]{82, 83, 74, 68, 80, 8, 88, 18, 93, 86, 88}, "66909f9f49"));
        destination.append(new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1));
        return destination;
    }

    public final byte[] encodeToByteArray(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{64, 88, 65, 74, 86, 0}, "37485ee488c4"));
        return encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, C0000.decode(new byte[]{71, 12, 76, 70, 84, 85}, "4c94700ab9", bitsPerSymbol));
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        byte[] bArr = new byte[encodeSize$kotlin_stdlib(endIndex - startIndex)];
        encodeIntoByteArrayImpl$kotlin_stdlib(source, bArr, 0, startIndex, endIndex);
        return bArr;
    }

    public final Base64 withPadding(PaddingOption option) {
        Intrinsics.checkNotNullParameter(option, C0000.decode(new byte[]{95, 68, 22, 8, 95, 10}, "04ba0d5a3d", bitsPerSymbol));
        return this.paddingOption == option ? this : new Base64(this.isUrlSafe, this.isMimeScheme, option);
    }

    /* JADX INFO: renamed from: isUrlSafe$kotlin_stdlib, reason: from getter */
    public final boolean getIsUrlSafe() {
        return this.isUrlSafe;
    }

    /* JADX INFO: renamed from: isMimeScheme$kotlin_stdlib, reason: from getter */
    public final boolean getIsMimeScheme() {
        return this.isMimeScheme;
    }

    /* JADX INFO: renamed from: getPaddingOption$kotlin_stdlib, reason: from getter */
    public final PaddingOption getPaddingOption() {
        return this.paddingOption;
    }

    private final boolean shouldPadOnEncode() {
        return this.paddingOption == PaddingOption.PRESENT || this.paddingOption == PaddingOption.PRESENT_OPTIONAL;
    }

    private final int skipIllegalSymbolsIfMime(byte[] source, int startIndex, int endIndex) {
        if (!this.isMimeScheme) {
            return startIndex;
        }
        while (startIndex < endIndex) {
            if (Base64Kt.base64DecodeMap[source[startIndex] & UByte.MAX_VALUE] != -1) {
                break;
            }
            startIndex++;
        }
        return startIndex;
    }

    public final void checkSourceBounds$kotlin_stdlib(int sourceSize, int startIndex, int endIndex) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, sourceSize);
    }

    /* JADX INFO: renamed from: kotlin.io.encoding.Base64$Default, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Base64.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "<init>", "()V", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "symbolsPerGroup", "padSymbol", "", "mimeLineLength", "mimeGroupsPerLine", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "UrlSafe", "getUrlSafe", "()Lkotlin/io/encoding/Base64;", "Mime", "getMime", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion extends Base64 {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Companion() {
            boolean z = false;
            super(z, z, PaddingOption.PRESENT, null);
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.mimeLineSeparatorSymbols;
        }

        public final Base64 getUrlSafe() {
            return Base64.UrlSafe;
        }

        public final Base64 getMime() {
            return Base64.Mime;
        }
    }
}
