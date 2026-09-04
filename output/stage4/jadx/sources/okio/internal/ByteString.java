package okio.internal;

import okio.SegmentedByteString;
import p000.C0000;

/* JADX INFO: renamed from: okio.internal.-ByteString, reason: invalid class name */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ByteString {
    public static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int access$decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{108, 90, 86, 64, 21, 1, 2, 22, 80, 7, 23, 90, 3, 74, 17, 83, 80, 83, 90, 76, 95, 68}, "9438edab5c72f217", false) + c);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    public static final int segment(SegmentedByteString segmentedByteString, int i) {
        int i2;
        int[] iArr = segmentedByteString.directory;
        int i3 = i + 1;
        int length = segmentedByteString.segments.length - 1;
        int i4 = 0;
        while (i4 <= length) {
            i2 = (i4 + length) >>> 1;
            int i5 = iArr[i2];
            if (i5 < i3) {
                i4 = i2 + 1;
            } else {
                if (i5 <= i3) {
                    if (i2 >= 0) {
                        return i2;
                    }
                    return ~i2;
                }
                length = i2 - 1;
            }
        }
        i2 = (-i4) - 1;
        if (i2 >= 0) {
            return i2;
        }
        return ~i2;
    }
}
