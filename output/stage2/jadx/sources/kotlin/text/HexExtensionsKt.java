package kotlin.text;

import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0000\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010\r\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a,\u0010\u0014\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u0019\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u001a\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a<\u0010\u001b\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a,\u0010\u001b\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a(\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0002\u001a@\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0000\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u0016\u0010-\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010-\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a&\u0010.\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a&\u0010/\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a&\u00100\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a$\u00101\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a\u0014\u00102\u001a\u000203*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0002\u001a@\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0000\u001a \u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0002\u001a \u0010:\u001a\u00020,2\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002\u001a\u001c\u0010;\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u0016\u0010\r\u001a\u00020\u0001*\u0002032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010<\u001a\u000203*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010<\u001a\u000203*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020=2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010>\u001a\u00020=*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010>\u001a\u00020=*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010?\u001a\u00020\u0012*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010?\u001a\u00020\u0012*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020,2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010@\u001a\u00020,*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010@\u001a\u00020,*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001\u001a$\u0010A\u001a\u00020\u0001*\u00020,2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0012H\u0003\u001a\u001c\u0010F\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a,\u0010G\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0003\u001a,\u0010I\u001a\u00020,*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0003\u001a<\u0010J\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010H\u001a\u00020\u0012H\u0002\u001a$\u0010P\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0012H\u0002\u001a\u001c\u0010Q\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u001c\u0010R\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u001c\u0010S\u001a\u00020,*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a5\u0010T\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010V\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010W\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0082\b\u001a\u0015\u0010X\u001a\u00020,*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0082\b\u001a,\u0010Y\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\u0012H\u0002\u001a,\u0010\\\u001a\u00020K*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u0001H\u0002\u001a,\u0010]\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0001H\u0002\u001a\u0014\u0010^\u001a\u00020_*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations", "()V", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", "index", "bytePrefix", "byteSuffix", "destination", "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", "suffix", "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;
    private static final String LOWER_CASE_HEX_DIGITS = C0000.decode(new byte[]{83, 84, 4, 82, 0, 12, 3, 82, 13, 90, 84, 82, 0, 1, 83, 7}, "ce6a495e5c50", false);
    private static final String UPPER_CASE_HEX_DIGITS = C0000.decode(new byte[]{9, 6, 81, 87, 7, 2, 3, 85, 13, 93, 119, 113, 122, 115, 38, 34}, "97cd375b5d63", 7);

    static {
        String strDecode;
        String strDecode2;
        int[] iArr = new int[256];
        int i = 0;
        int i2 = 0;
        while (true) {
            strDecode = C0000.decode(new byte[]{5, 9, 11, 3, 0, 87, 82, 2, 90, 12, 86, 6, 86, 92, 92, 86}, "58904bd5b57d", 0.0f);
            if (i2 >= 256) {
                break;
            }
            iArr[i2] = strDecode.charAt(i2 & 15) | (strDecode.charAt(i2 >> 4) << '\b');
            i2++;
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        int i3 = 0;
        while (true) {
            strDecode2 = C0000.decode(new byte[]{6, 87, 7, 2, 5, 12, 82, 1, 1, 90, 37, 119, 117, 34, 112, 119}, "6f5119d69cd5", 4);
            if (i3 >= 256) {
                break;
            }
            iArr2[i3] = strDecode2.charAt(i3 & 15) | (strDecode2.charAt(i3 >> 4) << '\b');
            i3++;
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        String str = strDecode;
        int i5 = 0;
        int i6 = 0;
        while (i5 < str.length()) {
            iArr3[str.charAt(i5)] = i6;
            i5++;
            i6++;
        }
        String str2 = strDecode2;
        int i7 = 0;
        int i8 = 0;
        while (i7 < str2.length()) {
            iArr3[str2.charAt(i7)] = i8;
            i7++;
            i8++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        String str3 = strDecode;
        int i10 = 0;
        int i11 = 0;
        while (i10 < str3.length()) {
            jArr[str3.charAt(i10)] = i11;
            i10++;
            i11++;
        }
        String str4 = strDecode2;
        int i12 = 0;
        while (i < str4.length()) {
            jArr[str4.charAt(i)] = i12;
            i++;
            i12++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    private static final long charsPerSet(long j, int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{37, 4, 93, 85, 81, 2, 18, 64, 86, 65, 16, 15, 68, 1, 85, 82, 13, 17, 26}, "ce494f2230ef6d87", false).toString());
        }
        long j2 = i;
        return (j * j2) + (((long) i2) * (j2 - 1));
    }

    private static final int checkFormatLength(long j) {
        if (0 > j || j > 2147483647L) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{49, 94, 84, 17, 67, 83, 74, 64, 15, 69, 95, 12, 83, 18, 68, 76, 23, 95, 95, 86, 17, 90, 92, 91, 4, 69, 94, 66, 93, 65, 23, 76, 10, 89, 17, 83, 88, 81, 3, 21}, "e6111695c16b4278", 0.0f) + ((Object) ULong.m246toStringimpl(ULong.m200constructorimpl(j))));
        }
        return (int) j;
    }

    private static final int checkNewLineAt(String str, int i, int i2) {
        if (str.charAt(i) == '\r') {
            int i3 = i + 1;
            return (i3 >= i2 || str.charAt(i3) != '\n') ? i3 : i + 2;
        }
        if (str.charAt(i) == '\n') {
            return i + 1;
        }
        throw new NumberFormatException(C0000.decode(new byte[]{114, 73, 21, 0, 91, 70, 84, 93, 23, 80, 69, 11, 93, 69, 17, 85, 94, 95, 0, 69, 89, 70, 17, 80, 89, 85, 0, 29, 24}, "71ee8219", false) + i + C0000.decode(new byte[]{21, 18, 84, 64, 17, 21, 78, 83, 69, 21}, "9265e5", 0.0f) + str.charAt(i));
    }

    private static final void checkNumberOfDigits(String str, int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i4 < 1) {
            throwInvalidNumberOfDigits(str, i, i2, C0000.decode(new byte[]{7, 66, 19, 90, 84, 83, 16, 64}, "f63612c4f5", false), 1);
        } else if (i4 > i3) {
            checkZeroDigits(str, i, (i4 + i) - i3);
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String str, int i, int i2, String str2, String str3, boolean z, int i3) {
        if ((i2 - i) - str2.length() <= str3.length()) {
            throwInvalidPrefixSuffix(str, i, i2, str2, str3);
        }
        String str4 = str2;
        if (str4.length() != 0) {
            int length = str4.length();
            for (int i4 = 0; i4 < length; i4++) {
                if (!CharsKt.equals(str2.charAt(i4), str.charAt(i + i4), z)) {
                    throwNotContainedAt(str, i, i2, str2, C0000.decode(new byte[]{69, 19, 80, 7, 93, 77}, "5a5a459cfe"));
                }
            }
            i += str2.length();
        }
        int length2 = i2 - str3.length();
        String str5 = str3;
        if (str5.length() != 0) {
            int length3 = str5.length();
            for (int i5 = 0; i5 < length3; i5++) {
                if (!CharsKt.equals(str3.charAt(i5), str.charAt(length2 + i5), z)) {
                    throwNotContainedAt(str, length2, i2, str3, C0000.decode(new byte[]{22, 77, 87, 80, 94, 65}, "e816791c24", 0));
                }
            }
            str3.length();
        }
        checkNumberOfDigits(str, i, length2, i3);
    }

    private static final void checkZeroDigits(String str, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) != '0') {
                throw new NumberFormatException(C0000.decode(new byte[]{39, 78, 69, 7, 6, 66, 80, 6, 25, 70, 14, 93, 21, 89, 80, 75, 3, 82, 80, 1, 12, 91, 84, 14, 25, 86, 15, 95, 92, 69, 21, 20, 82, 17, 21, 3, 17, 22, 92, 12, 93, 87, 30, 24}, "b65be65b92f85153", false) + i + C0000.decode(new byte[]{77, 25, 7, 77, 64, 17, 17, 5, 23, 69, 21}, "a9e841fdde2a6e6d", false) + str.charAt(i) + C0000.decode(new byte[]{69, 77, Base64.padSymbol, 103, 13, 3, 66, 17, 82, 64, 16, 10, 22, 67, 64, 92, 11, 65, 22, 67, 81, 90, 17, 70, 22, 11, 82, 19, 17, 31, 18, 6, 23, 81, 0, 15, 12, 4, 23, 67, 4, 20, 17, 6, 83, 29}, "bc73ef"));
            }
            i++;
        }
    }

    private static final int formattedStringLength(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{112, 83, 11, 84, 85, 92, 68, 70, 81, 19, 67, 91, 16, 93, 93, 93, 10, 64, 26}, "62b808d44b", 5).toString());
        }
        long j = i2;
        return checkFormatLength((((long) i) * (((((long) i3) + 2) + ((long) i4)) + j)) - j);
    }

    public static final int formattedStringLength(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i <= 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{116, 5, 80, 91, 83, 5, 65, 64, 87, 21, 76, 94, 68, 4, 12, 87, 92, 16, 23}, "2d976aa2", 3).toString());
        }
        int i8 = i - 1;
        int i9 = i8 / i2;
        int i10 = (i2 - 1) / i3;
        int i11 = i % i2;
        if (i11 != 0) {
            i2 = i11;
        }
        int i12 = (i10 * i9) + ((i2 - 1) / i3);
        return checkFormatLength(((long) i9) + (((long) i12) * ((long) i4)) + (((long) ((i8 - i9) - i12)) * ((long) i5)) + (((long) i) * (((long) i6) + 2 + ((long) i7))));
    }

    public static /* synthetic */ void getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations() {
    }

    private static final byte hexToByte(String str, int i, int i2, HexFormat hexFormat) {
        return (byte) hexToIntImpl(str, i, i2, hexFormat, 2);
    }

    public static final byte hexToByte(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 18, 95, 80, 17, 88}, "af79bfacd1918f99"));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{7, 14, 19, 15, 0, 16}, "aaabad4a", false));
        return hexToByte(str, 0, str.length(), hexFormat);
    }

    public static final byte[] hexToByteArray(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 21, 9, 8, 22, 8}, "1aaae6", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{95, 94, 75, 14, 2, 17}, "919cce6f", false));
        return hexToByteArray(str, 0, str.length(), hexFormat);
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{119, 87, 94, 89, 83, 87, 25, 20, 84, 71, 66, 92, 68, 86, 84, 3, 95, 66, 25}, "1675639f").toString());
        }
        int i3 = i2 - i;
        int i4 = 2;
        if (length == 0) {
            if ((i3 & 1) != 0) {
                return null;
            }
            int i5 = i3 >> 1;
            byte[] bArr = new byte[i5];
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i7] = parseByteAt(str, i6);
                i6 += 2;
            }
            return bArr;
        }
        if (i3 % 3 != 2) {
            return null;
        }
        int i8 = (i3 / 3) + 1;
        byte[] bArr2 = new byte[i8];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        bArr2[0] = parseByteAt(str, 0);
        for (int i9 = 1; i9 < i8; i9++) {
            if (str.charAt(i4) != cCharAt) {
                String byteSeparator = bytesHexFormat.getByteSeparator();
                boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
                String str2 = byteSeparator;
                if (str2.length() != 0) {
                    int length2 = str2.length();
                    for (int i10 = 0; i10 < length2; i10++) {
                        if (!CharsKt.equals(byteSeparator.charAt(i10), str.charAt(i4 + i10), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, i4, i2, byteSeparator, C0000.decode(new byte[]{86, 64, 67, 82, 67, 16, 81, 73, 86, 69, 2, 23, 91, 75}, "4977cc"));
                        }
                    }
                    byteSeparator.length();
                }
            }
            bArr2[i9] = parseByteAt(str, i4 + 1);
            i4 += 3;
        }
        return bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:35:0x0102  */
    /* JADX WARN: Code duplicated, block: B:37:0x0114  */
    /* JADX WARN: Code duplicated, block: B:42:0x0138  */
    /* JADX WARN: Code duplicated, block: B:45:0x0164  */
    /* JADX WARN: Code duplicated, block: B:46:0x0167  */
    /* JADX WARN: Code duplicated, block: B:48:0x016e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0181  */
    /* JADX WARN: Code duplicated, block: B:63:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0198 A[SYNTHETIC] */
    private static final byte[] hexToByteArraySlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int i3;
        int i4;
        String str2;
        int i5;
        String str3;
        int length;
        int i6;
        int i7;
        int length2;
        int i8;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        int i9 = parsedByteArrayMaxSize(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[i9];
        int length3 = i;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (length3 < i2) {
            if (i11 == bytesPerLine) {
                length3 = checkNewLineAt(str, length3, i2);
                i3 = bytesPerLine;
                i4 = bytesPerGroup;
                i11 = 0;
            } else {
                if (i12 == bytesPerGroup) {
                    String str4 = groupSeparator;
                    if (str4.length() == 0) {
                        i3 = bytesPerLine;
                        i4 = bytesPerGroup;
                    } else {
                        int length4 = str4.length();
                        int i13 = 0;
                        while (i13 < length4) {
                            int i14 = bytesPerLine;
                            int i15 = bytesPerGroup;
                            if (!CharsKt.equals(groupSeparator.charAt(i13), str.charAt(length3 + i13), ignoreCase$kotlin_stdlib)) {
                                throwNotContainedAt(str, length3, i2, groupSeparator, C0000.decode(new byte[]{82, 75, 12, 23, 18, 16, 17, 1, 17, 0, 71, 88, 23, 13, 16}, "59cbb0bdaa", 1));
                            }
                            i13++;
                            bytesPerLine = i14;
                            bytesPerGroup = i15;
                        }
                        i3 = bytesPerLine;
                        i4 = bytesPerGroup;
                        length3 += groupSeparator.length();
                    }
                } else {
                    i3 = bytesPerLine;
                    i4 = bytesPerGroup;
                    if (i12 != 0) {
                        String str5 = byteSeparator;
                        if (str5.length() != 0) {
                            int length5 = str5.length();
                            int i16 = 0;
                            while (i16 < length5) {
                                int i17 = length5;
                                if (!CharsKt.equals(byteSeparator.charAt(i16), str.charAt(length3 + i16), ignoreCase$kotlin_stdlib)) {
                                    throwNotContainedAt(str, length3, i2, byteSeparator, C0000.decode(new byte[]{85, 75, 18, 80, 65, 67, 4, 72, 86, 64, 7, 65, 14, 66}, "72f5a0a8", 1));
                                }
                                i16++;
                                length5 = i17;
                            }
                            length3 += byteSeparator.length();
                        }
                    }
                }
                i11++;
                i12++;
                str2 = bytePrefix;
                if (str2.length() != 0) {
                    length2 = str2.length();
                    i8 = 0;
                    while (i8 < length2) {
                        int i18 = length2;
                        if (!CharsKt.equals(bytePrefix.charAt(i8), str.charAt(length3 + i8), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length3, i2, bytePrefix, C0000.decode(new byte[]{90, 73, 17, 7, 24, 70, 22, 92, 95, 94, 25}, "80eb86d997a65094", true));
                        }
                        i8++;
                        length2 = i18;
                    }
                    length3 += bytePrefix.length();
                }
                if (i2 - 2 < length3) {
                    throwInvalidNumberOfDigits(str, length3, i2, C0000.decode(new byte[]{80, 77, 2, 2, 77, 9, 79}, "55ca9e61", 1), 2);
                }
                i5 = i10 + 1;
                bArr[i10] = parseByteAt(str, length3);
                length3 += 2;
                str3 = byteSuffix;
                if (str3.length() == 0) {
                    i7 = i5;
                } else {
                    length = str3.length();
                    i6 = 0;
                    while (i6 < length) {
                        int i19 = i5;
                        if (!CharsKt.equals(byteSuffix.charAt(i6), str.charAt(length3 + i6), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length3, i2, byteSuffix, C0000.decode(new byte[]{4, 27, 65, 3, 70, 21, 76, 86, 94, 13, 78}, "fb5fff908d6af89b", false));
                        }
                        i6++;
                        i5 = i19;
                    }
                    i7 = i5;
                    length3 += byteSuffix.length();
                }
                i10 = i7;
                bytesPerLine = i3;
                bytesPerGroup = i4;
            }
            i12 = 0;
            i11++;
            i12++;
            str2 = bytePrefix;
            if (str2.length() != 0) {
                length2 = str2.length();
                i8 = 0;
                while (i8 < length2) {
                    int i110 = length2;
                    if (!CharsKt.equals(bytePrefix.charAt(i8), str.charAt(length3 + i8), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, length3, i2, bytePrefix, C0000.decode(new byte[]{90, 73, 17, 7, 24, 70, 22, 92, 95, 94, 25}, "80eb86d997a65094", true));
                    }
                    i8++;
                    length2 = i110;
                }
                length3 += bytePrefix.length();
            }
            if (i2 - 2 < length3) {
                throwInvalidNumberOfDigits(str, length3, i2, C0000.decode(new byte[]{80, 77, 2, 2, 77, 9, 79}, "55ca9e61", 1), 2);
            }
            i5 = i10 + 1;
            bArr[i10] = parseByteAt(str, length3);
            length3 += 2;
            str3 = byteSuffix;
            if (str3.length() == 0) {
                i7 = i5;
            } else {
                length = str3.length();
                i6 = 0;
                while (i6 < length) {
                    int i111 = i5;
                    if (!CharsKt.equals(byteSuffix.charAt(i6), str.charAt(length3 + i6), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, length3, i2, byteSuffix, C0000.decode(new byte[]{4, 27, 65, 3, 70, 21, 76, 86, 94, 13, 78}, "fb5fff908d6af89b", false));
                    }
                    i6++;
                    i5 = i111;
                }
                i7 = i5;
                length3 += byteSuffix.length();
            }
            i10 = i7;
            bytesPerLine = i3;
            bytesPerGroup = i4;
        }
        if (i10 == i9) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, C0000.decode(new byte[]{82, 93, 73, 27, 43, 7, 25, 28, 23, 76, 77}, "129bda", 1));
        return bArrCopyOf;
    }

    public static final int hexToInt(String str, int i, int i2, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 66, 13, 12, 74, 9}, "66ee9768c6", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{85, 87, 66, 12, 7, 69}, "380af1", 4));
        return hexToIntImpl(str, i, i2, hexFormat, 8);
    }

    public static final int hexToInt(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 67, 11, 8, 17, 10}, "a7cab458dd5c", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{80, 87, 69, 12, 0, 17}, "687aae2a", 3));
        return hexToInt(str, 0, str.length(), hexFormat);
    }

    public static final long hexToLong(String str, int i, int i2, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 64, 90, 81, 17, 14}, "1428b0507a25af0f", 0));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{94, 13, 20, 92, 87, 77}, "8bf169"));
        return hexToLongImpl(str, i, i2, hexFormat, 16);
    }

    public static final long hexToLong(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 22, 92, 80, 23, 90}, "ab49dd84"));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{83, 11, 17, 91, 86, 71}, "5dc67346efb7fc00"));
        return hexToLong(str, 0, str.length(), hexFormat);
    }

    private static final short hexToShort(String str, int i, int i2, HexFormat hexFormat) {
        return (short) hexToIntImpl(str, i, i2, hexFormat, 4);
    }

    public static final short hexToShort(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 67, 81, 11, 75, 6}, "e79b887d", 0.0f));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{3, 88, 71, 9, 80, 67}, "e75d17", 5));
        return hexToShort(str, 0, str.length(), hexFormat);
    }

    public static final int parsedByteArrayMaxSize(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long jCharsPerSet;
        if (i <= 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{119, 82, 94, 84, 87, 87, 19, 68, 84, 71, 17, 12, 75, 4, 93, 87, 95, 71, 25}, "1378233616de9a02").toString());
        }
        long j = ((long) i6) + 2 + ((long) i7);
        long jCharsPerSet2 = charsPerSet(j, i3, i5);
        if (i2 <= i3) {
            jCharsPerSet = charsPerSet(j, i2, i5);
        } else {
            jCharsPerSet = charsPerSet(jCharsPerSet2, i2 / i3, i4);
            int i8 = i2 % i3;
            if (i8 != 0) {
                jCharsPerSet = jCharsPerSet + ((long) i4) + charsPerSet(j, i8, i5);
            }
        }
        long j2 = i;
        long jWholeElementsPerSet = wholeElementsPerSet(j2, jCharsPerSet, 1);
        long j3 = j2 - ((jCharsPerSet + 1) * jWholeElementsPerSet);
        long jWholeElementsPerSet2 = wholeElementsPerSet(j3, jCharsPerSet2, i4);
        long j4 = j3 - ((jCharsPerSet2 + ((long) i4)) * jWholeElementsPerSet2);
        long jWholeElementsPerSet3 = wholeElementsPerSet(j4, j, i5);
        return (int) ((jWholeElementsPerSet * ((long) i2)) + (jWholeElementsPerSet2 * ((long) i3)) + jWholeElementsPerSet3 + ((long) (j4 - ((j + ((long) i5)) * jWholeElementsPerSet3) > 0 ? 1 : 0)));
    }

    private static final Void throwInvalidDigitAt(String str, int i) {
        throw new NumberFormatException(C0000.decode(new byte[]{112, 28, 18, 93, 2, 64, 87, 0, 21, 5, 66, 80, 4, 76, 83, 0, 80, 7, 11, 85, 0, 88, 18, 0, 92, 3, 11, 76, 65, 85, 70, 68, 92, 10, 6, 93, 25, 20}, "5db8a42d", false) + i + C0000.decode(new byte[]{25, 21, 0, 20, 18, 21, 65, 5, 71, 24}, "55baf56d4804ac") + str.charAt(i));
    }

    private static final void throwInvalidNumberOfDigits(String str, int i, int i2, String str2, int i3) {
        Intrinsics.checkNotNull(str, C0000.decode(new byte[]{86, 71, 91, 95, 65, 90, 83, 95, 90, 92, 76, 18, 85, 86, 65, 90, 83, 66, 64, 19, 76, 93, 23, 93, 14, 87, 31, 95, 65, 95, 84, 18, 67, 74, 17, 92, 18, 91, 85, 69, 89, 28, 91, 82, 15, 94, 28, 98, 64, 65, 81, 92, 80}, "8273a92143"));
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{64, 19, 3, 16, 17, 64, 95, 94, 1, 74, 29, 72, 79, 74}, "3face260fb", 0));
        throw new NumberFormatException(C0000.decode(new byte[]{119, 76, 64, 86, 91, 23, 85, 93, 20}, "24038c0940db", 2) + str2 + ' ' + i3 + C0000.decode(new byte[]{23, 9, 87, 78, 86, 7, 3, 0, 90, 9, 89, 92, 23, 5, 91, 81, 94, 23, 21, 67, 82, 16, 24, 89, 89, 5, 87, 78, 23}, "7a267cfc3d80", false) + i + C0000.decode(new byte[]{30, 65, 0, 65, 66, 69, 79, 0, 65, 65, 64}, "2ab46e8a", 0.0f) + strSubstring + C0000.decode(new byte[]{70, 21, 95, 4, 19, 88, 7, 94, 3, 65, 88, 66}, "d50b34b0", true) + (i2 - i));
    }

    private static final void throwInvalidPrefixSuffix(String str, int i, int i2, String str2, String str3) {
        Intrinsics.checkNotNull(str, C0000.decode(new byte[]{87, 70, 91, 8, 19, 85, 81, 8, 87, 92, 67, 68, 81, 83, 16, 5, 88, 64, 67, 68, 71, 89, 16, 8, 86, 93, 26, 10, 70, 90, 92, 70, 77, 74, 71, 1, 19, 92, 81, 16, 88, 29, 91, 5, 93, 81, 30, 53, 77, 65, 94, 10, 84}, "937d360f", false));
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{75, 19, 90, 22, 21, 69, 81, 93, 85, 17, 27, 25, 77, 27}, "8f8ea7832957c218", true));
        throw new NumberFormatException(C0000.decode(new byte[]{125, 78, 68, 81, 7, 65, 3, 87, 16, 87, 19, 92, 80, 64, 89, 82, 81, 87, 13, 88, 7, 95, 16, 88, 70, 89, 87, 93, 74, 22, 67, 93, 16, 93, 70, 67, 66, 83, 85, 93, 77, 24, 26}, "8644d5f3063458", 0.0f) + str2 + C0000.decode(new byte[]{70, 24, 88, 8, 7, 16, 69, 68, 2, 5, 13, 64, 25, 68}, "d89fc061dc") + str3 + C0000.decode(new byte[]{67, 77, 65, 6, 71, 22, 66, 65, 0, 23, 67}, "aaad2bb6adc07b", true) + strSubstring);
    }

    private static final void throwNotContainedAt(String str, int i, int i2, String str2, String str3) {
        int iCoerceAtMost = RangesKt.coerceAtMost(str2.length() + i, i2);
        Intrinsics.checkNotNull(str, C0000.decode(new byte[]{12, 17, 93, 94, 22, 90, 3, 10, 95, 93, 66, 25, 0, 1, 17, 81, 87, 74, 22, 68, 69, 93, 22, 87, 13, 10, 28, 92, 67, 85, 14, 68, 69, 75, 70, 92, 66, 14, 80, 68, 87, 23, 14, 5, 95, 85, 24, 106, 22, 22, 88, 92, 81}, "bd1269", 0.0f));
        String strSubstring = str.substring(i, iCoerceAtMost);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{71, 67, 82, 74, 68, 71, 93, 88, 87, 17, 30, 27, 26, 31}, "460905", 0));
        throw new NumberFormatException(C0000.decode(new byte[]{115, 29, 73, 6, 0, 16, 4, 7, 25}, "6e9ccdac9f163054", 7) + str3 + C0000.decode(new byte[]{22, 23}, "656924fdd39b40bb", 0.0f) + str2 + C0000.decode(new byte[]{23, 23, 80, 66, 70, 11, 91, 83, 84, 78, 70}, "5716fb", 1) + i + C0000.decode(new byte[]{21, 17, 84, 16, 65, 67, 71, 82, 22, 68}, "916e5c03ed0640", 0.0f) + strSubstring);
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, C0000.decode(new byte[]{88, 23, 8, 14, 67, 1, 80, 12, 88, 13, 16, 66, 1, 7, 17, 1, 87, 17, 16, 66, 23, 13, 17, 12, 89, 12, 73, 12, 22, 14, 93, 66, 66, 27, 20, 7, 67, 8, 80, 20, 87, 76, 8, 3, 13, 5, 31, 49, 66, 16, 13, 12, 4}, "6bdbcb1b", 7));
                str.getChars(0, length2, cArr, i);
            } else {
                cArr[i] = str.charAt(0);
            }
        }
        return i + str.length();
    }

    public static final String toHexString(byte b, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 9, 68, 85, 4, 68}, "df68e0"));
        String strDecode = hexFormat.getUpperCase() ? C0000.decode(new byte[]{3, 2, 4, 7, 6, 84, 83, 1, 11, 10, 119, 118, 113, 37, 32, 112}, "33642ae6", true) : C0000.decode(new byte[]{9, 82, 84, 7, 1, 3, 80, 82, 1, 90, 7, 86, 86, 82, 3, 3}, "9cf456fe", 0.0f);
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(b, number, strDecode, 8);
        }
        char[] cArr = {strDecode.charAt((b >> 4) & 15), strDecode.charAt(b & 15)};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(b & UByte.MAX_VALUE) - 24) >> 2, 1), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(int i, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{94, 91, 68, 12, 86, 71}, "846a73d9949ccd", 0.0f));
        String strDecode = hexFormat.getUpperCase() ? C0000.decode(new byte[]{3, 87, 6, 6, 12, 4, 3, 6, 11, 95, 117, 119, 123, 117, 112, 119}, "3f458151", 3) : C0000.decode(new byte[]{85, 7, 84, 5, 81, 13, 2, 7, 0, 95, 4, 84, 5, 82, 0, 94}, "e6f6e8408f", true);
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(i, number, strDecode, 32);
        }
        char[] cArr = {strDecode.charAt((i >> 28) & 15), strDecode.charAt((i >> 24) & 15), strDecode.charAt((i >> 20) & 15), strDecode.charAt((i >> 16) & 15), strDecode.charAt((i >> 12) & 15), strDecode.charAt((i >> 8) & 15), strDecode.charAt((i >> 4) & 15), strDecode.charAt(i & 15)};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i) >> 2, 7), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(long j, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{84, 88, 17, 9, 5, 70}, "27cdd2104a4bbfec"));
        String strDecode = hexFormat.getUpperCase() ? C0000.decode(new byte[]{83, 84, 11, 4, 2, 83, 83, 1, 92, 9, 117, 113, 32, 33, 124, 113}, "ce976fe6d043", 0.0f) : C0000.decode(new byte[]{5, 84, 81, 80, 86, 2, 4, 0, 1, 91, 7, 91, 86, 1, 6, 5}, "5eccb7279bf9", 0.0f);
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(j, number, strDecode, 64);
        }
        char[] cArr = {strDecode.charAt((int) ((j >> 60) & 15)), strDecode.charAt((int) ((j >> 56) & 15)), strDecode.charAt((int) ((j >> 52) & 15)), strDecode.charAt((int) ((j >> 48) & 15)), strDecode.charAt((int) ((j >> 44) & 15)), strDecode.charAt((int) ((j >> 40) & 15)), strDecode.charAt((int) ((j >> 36) & 15)), strDecode.charAt((int) ((j >> 32) & 15)), strDecode.charAt((int) ((j >> 28) & 15)), strDecode.charAt((int) ((j >> 24) & 15)), strDecode.charAt((int) ((j >> 20) & 15)), strDecode.charAt((int) ((j >> 16) & 15)), strDecode.charAt((int) ((j >> 12) & 15)), strDecode.charAt((int) ((j >> 8) & 15)), strDecode.charAt((int) ((j >> 4) & 15)), strDecode.charAt((int) (j & 15))};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(j) >> 2, 15), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(short s, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{84, 89, 74, 85, 80, 66}, "2688166e", true));
        String strDecode = hexFormat.getUpperCase() ? C0000.decode(new byte[]{2, 7, 2, 11, 2, 0, 0, 86, 10, 12, 121, 122, 116, 38, 119, 112}, "2608656a25887b", true) : C0000.decode(new byte[]{85, 7, 4, 10, 5, 80, 82, 85, 93, 15, 87, 91, 82, 1, 1, 4}, "e6691edb", 6);
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(s, number, strDecode, 16);
        }
        char[] cArr = {strDecode.charAt((s >> 12) & 15), strDecode.charAt((s >> 8) & 15), strDecode.charAt((s >> 4) & 15), strDecode.charAt(s & 15)};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(byte[] bArr, int i, int i2, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{12, 64, 9, 81, 17, 11}, "04a8b532", 0));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{0, 9, 69, 14, 4, 65}, "ff7ce529", false));
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (i == i2) {
            return "";
        }
        int[] iArr = hexFormat.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return bytes.getNoLineAndGroupSeparator() ? toHexStringNoLineAndGroupSeparator(bArr, i, i2, bytes, iArr) : toHexStringSlowPath(bArr, i, i2, bytes, iArr);
    }

    public static final String toHexString(byte[] bArr, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{13, 76, 14, 8, 18, 11}, "18faa532", 2));
        Intrinsics.checkNotNullParameter(hexFormat, C0000.decode(new byte[]{2, 90, 70, 91, 88, 66}, "d54696ece7"));
        return toHexString(bArr, 0, bArr.length, hexFormat);
    }

    private static final String toHexStringImpl(long j, HexFormat.NumberHexFormat numberHexFormat, String str, int i) {
        if ((i & 3) != 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{118, 7, 80, 94, 1, 86, 65, 75, 1, 70, 69, 15, 75, 87, 9, 87, 15, 77, 74}, "0f92d2a9d7", 0).toString());
        }
        int i2 = i >> 2;
        int minLength = numberHexFormat.getMinLength();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(minLength - i2, 0);
        String prefix = numberHexFormat.getPrefix();
        String suffix = numberHexFormat.getSuffix();
        boolean removeLeadingZeros = numberHexFormat.getRemoveLeadingZeros();
        int iCheckFormatLength = checkFormatLength(((long) prefix.length()) + ((long) iCoerceAtLeast) + ((long) i2) + ((long) suffix.length()));
        char[] cArr = new char[iCheckFormatLength];
        int charArrayIfNotEmpty = toCharArrayIfNotEmpty(prefix, cArr, 0);
        if (iCoerceAtLeast > 0) {
            int i3 = iCoerceAtLeast + charArrayIfNotEmpty;
            ArraysKt.fill(cArr, str.charAt(0), charArrayIfNotEmpty, i3);
            charArrayIfNotEmpty = i3;
        }
        int i4 = i;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 -= 4;
            int i6 = (int) ((j >> i4) & 15);
            removeLeadingZeros = removeLeadingZeros && i6 == 0 && (i4 >> 2) >= minLength;
            if (!removeLeadingZeros) {
                cArr[charArrayIfNotEmpty] = str.charAt(i6);
                charArrayIfNotEmpty++;
            }
        }
        int charArrayIfNotEmpty2 = toCharArrayIfNotEmpty(suffix, cArr, charArrayIfNotEmpty);
        return charArrayIfNotEmpty2 == iCheckFormatLength ? StringsKt.concatToString(cArr) : StringsKt.concatToString$default(cArr, 0, charArrayIfNotEmpty2, 1, null);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{118, 7, 80, 93, 0, 93, 23, 65, 85, 23, 76, 88, 23, 92, 90, 86, 94, 18, 23}, "0f91e973", 0.0f).toString());
        }
        int i3 = i2 - i;
        int byteAt = 0;
        if (length == 0) {
            char[] cArr = new char[checkFormatLength(((long) i3) * 2)];
            while (i < i2) {
                byteAt = formatByteAt(bArr, i, iArr, cArr, byteAt);
                i++;
            }
            return StringsKt.concatToString(cArr);
        }
        char[] cArr2 = new char[checkFormatLength((((long) i3) * 3) - 1)];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        int byteAt2 = formatByteAt(bArr, i, iArr, cArr2, 0);
        for (int i4 = i + 1; i4 < i2; i4++) {
            cArr2[byteAt2] = cCharAt;
            byteAt2 = formatByteAt(bArr, i4, iArr, cArr2, byteAt2 + 1);
        }
        return StringsKt.concatToString(cArr2);
    }

    private static final String toHexStringSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i3;
        int i4;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int i5 = formattedStringLength(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] cArr = new char[i5];
        int i6 = i;
        int charArrayIfNotEmpty = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i2) {
            if (i7 == bytesPerLine) {
                cArr[charArrayIfNotEmpty] = '\n';
                charArrayIfNotEmpty++;
                i3 = 0;
                i4 = 0;
            } else if (i8 == bytesPerGroup) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(groupSeparator, cArr, charArrayIfNotEmpty);
                i3 = i7;
                i4 = 0;
            } else {
                i3 = i7;
                i4 = i8;
            }
            if (i4 != 0) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(byteSeparator, cArr, charArrayIfNotEmpty);
            }
            String str = bytePrefix;
            int byteAt = formatByteAt(bArr, i6, str, byteSuffix, iArr, cArr, charArrayIfNotEmpty);
            i6++;
            i8 = i4 + 1;
            charArrayIfNotEmpty = byteAt;
            bytePrefix = str;
            i7 = i3 + 1;
        }
        if (charArrayIfNotEmpty == i5) {
            return StringsKt.concatToString(cArr);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{38, 9, 82, 5, 15, 20, 85, 5, 91, 92, 0, 5, 25}, "ea7fd43d20", 2));
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i, i2, hexFormat);
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix()) {
            return toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i, i2, bytesHexFormat, iArr);
        }
        return toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i, i2, bytesHexFormat, iArr);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i2 - i, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int byteAt = formatByteAt(bArr, i, bytePrefix, byteSuffix, iArr, cArr, 0);
        for (int i3 = i + 1; i3 < i2; i3++) {
            byteAt = formatByteAt(bArr, i3, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, byteAt));
        }
        return StringsKt.concatToString(cArr);
    }

    private static final int formatByteAt(byte[] bArr, int i, String str, String str2, int[] iArr, char[] cArr, int i2) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i2)));
    }

    private static final int formatByteAt(byte[] bArr, int i, int[] iArr, char[] cArr, int i2) {
        int i3 = iArr[bArr[i] & UByte.MAX_VALUE];
        cArr[i2] = (char) (i3 >> 8);
        cArr[i2 + 1] = (char) (i3 & KotlinVersion.MAX_COMPONENT_VALUE);
        return i2 + 2;
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i, i2, hexFormat);
    }

    private static final byte[] hexToByteArray(String str, int i, int i2, HexFormat hexFormat) {
        byte[] bArrHexToByteArrayNoLineAndGroupSeparator;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (i == i2) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return (!bytes.getNoLineAndGroupSeparator() || (bArrHexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i, i2, bytes)) == null) ? hexToByteArraySlowPath(str, i, i2, bytes) : bArrHexToByteArrayNoLineAndGroupSeparator;
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix()) {
            return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i, i2, bytesHexFormat);
        }
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i, i2, bytesHexFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        long length = byteSeparator.length();
        long length2 = ((long) bytePrefix.length()) + 2 + ((long) byteSuffix.length()) + length;
        long j = i2 - i;
        int i3 = (int) ((j + length) / length2);
        if ((((long) i3) * length2) - length != j) {
            return null;
        }
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        byte[] bArr = new byte[i3];
        String str2 = bytePrefix;
        if (str2.length() != 0) {
            int length3 = str2.length();
            for (int i4 = 0; i4 < length3; i4++) {
                if (!CharsKt.equals(bytePrefix.charAt(i4), str.charAt(i + i4), ignoreCase$kotlin_stdlib)) {
                    throwNotContainedAt(str, i, i2, bytePrefix, "byte prefix");
                }
            }
            i += bytePrefix.length();
        }
        String str3 = byteSuffix + byteSeparator + bytePrefix;
        int i5 = i3 - 1;
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = parseByteAt(str, i);
            i += 2;
            String str4 = str3;
            if (str4.length() != 0) {
                int length4 = str4.length();
                for (int i7 = 0; i7 < length4; i7++) {
                    if (!CharsKt.equals(str3.charAt(i7), str.charAt(i + i7), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, i, i2, str3, "byte suffix + byte separator + byte prefix");
                    }
                }
                i += str3.length();
            }
        }
        bArr[i5] = parseByteAt(str, i);
        int i8 = i + 2;
        String str5 = byteSuffix;
        if (str5.length() == 0) {
            return bArr;
        }
        int length5 = str5.length();
        for (int i9 = 0; i9 < length5; i9++) {
            if (!CharsKt.equals(byteSuffix.charAt(i9), str.charAt(i8 + i9), ignoreCase$kotlin_stdlib)) {
                throwNotContainedAt(str, i8, i2, byteSuffix, "byte suffix");
            }
        }
        byteSuffix.length();
        return bArr;
    }

    private static final long wholeElementsPerSet(long j, long j2, int i) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        long j3 = i;
        return (j + j3) / (j2 + j3);
    }

    public static /* synthetic */ String toHexString$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b, hexFormat);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    static /* synthetic */ byte hexToByte$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i, i2, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s, hexFormat);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    static /* synthetic */ short hexToShort$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i, i2, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i, i2, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i, i2, hexFormat);
    }

    private static final int hexToIntImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i, i2, i3);
            return parseInt(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i3);
        return parseInt(str, i + prefix.length(), i2 - suffix.length());
    }

    private static final long hexToLongImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i, i2, i3);
            return parseLong(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i3);
        return parseLong(str, i + prefix.length(), i2 - suffix.length());
    }

    private static final int checkContainsAt(String str, int i, int i2, String str2, boolean z, String str3) {
        String str4 = str2;
        if (str4.length() == 0) {
            return i;
        }
        int length = str4.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!CharsKt.equals(str2.charAt(i3), str.charAt(i + i3), z)) {
                throwNotContainedAt(str, i, i2, str2, str3);
            }
        }
        return i + str2.length();
    }

    private static final int decimalFromHexDigitAt(String str, int i) {
        int i2;
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') == 0 && (i2 = HEX_DIGITS_TO_DECIMAL[cCharAt]) >= 0) {
            return i2;
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final long longDecimalFromHexDigitAt(String str, int i) {
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') == 0) {
            long j = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
            if (j >= 0) {
                return j;
            }
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String str, int i) {
        int[] iArr;
        int i2;
        int i3;
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') != 0 || (i2 = (iArr = HEX_DIGITS_TO_DECIMAL)[cCharAt]) < 0) {
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        int i4 = i + 1;
        char cCharAt2 = str.charAt(i4);
        if ((cCharAt2 >>> '\b') == 0 && (i3 = iArr[cCharAt2]) >= 0) {
            return (byte) ((i2 << 4) | i3);
        }
        throwInvalidDigitAt(str, i4);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        while (i < i2) {
            int i5 = i4 << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') != 0 || (i3 = HEX_DIGITS_TO_DECIMAL[cCharAt]) < 0) {
                throwInvalidDigitAt(str, i);
                throw new KotlinNothingValueException();
            }
            i4 = i5 | i3;
            i++;
        }
        return i4;
    }

    private static final long parseLong(String str, int i, int i2) {
        long j = 0;
        while (i < i2) {
            long j2 = j << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') == 0) {
                long j3 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                if (j3 >= 0) {
                    j = j2 | j3;
                    i++;
                }
            }
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        return j;
    }
}
