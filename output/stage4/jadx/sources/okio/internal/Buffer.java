package okio.internal;

import java.io.EOFException;
import kotlin.text.Charsets;
import okio.Options;
import okio.Segment;
import p000.C0000;

/* JADX INFO: renamed from: okio.internal.-Buffer, reason: invalid class name */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Buffer {
    public static final byte[] HEX_DIGIT_BYTES = C0000.decode(new byte[]{82, 6, 86, 4, 3, 3, 0, 83, 91, 15, 7, 0, 0, 81, 6, 81}, "b7d7766dc6fbc5c7", 0.0f).getBytes(Charsets.UTF_8);

    public static final String readUtf8Line(long j, okio.Buffer buffer) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == 13) {
                String string = buffer.readString(j2, Charsets.UTF_8);
                buffer.skip(2L);
                return string;
            }
        }
        String string2 = buffer.readString(j, Charsets.UTF_8);
        buffer.skip(1L);
        return string2;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0095 A[LOOP:0: B:8:0x0019->B:49:0x0095, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x0094 A[SYNTHETIC] */
    public static final int selectPrefix(okio.Buffer buffer, Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i5 = segment2.pos;
        int i6 = segment2.limit;
        int[] iArr = options.trie;
        Segment segment3 = segment2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            int i11 = i8 + 2;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (segment3 == null) {
                break;
            }
            if (i10 >= 0) {
                int i13 = i5 + 1;
                int i14 = bArr[i5] & 255;
                int i15 = i11 + i10;
                while (i11 != i15) {
                    if (i14 == iArr[i11]) {
                        i = iArr[i11 + i10];
                        if (i13 == i6) {
                            segment3 = segment3.next;
                            int i16 = segment3.pos;
                            byte[] bArr2 = segment3.data;
                            i2 = segment3.limit;
                            if (segment3 == segment2) {
                                i3 = i16;
                                bArr = bArr2;
                                segment3 = null;
                            } else {
                                i3 = i16;
                                bArr = bArr2;
                            }
                        } else {
                            i2 = i6;
                            i3 = i13;
                        }
                        if (i >= 0) {
                            return i;
                        }
                        int i17 = i2;
                        i8 = -i;
                        i5 = i3;
                        i6 = i17;
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i18 = (i10 * (-1)) + i11;
            while (true) {
                int i19 = i5 + 1;
                int i20 = i11 + 1;
                if ((bArr[i5] & 255) == iArr[i11]) {
                    boolean z2 = i20 == i18;
                    if (i19 == i6) {
                        Segment segment4 = segment3.next;
                        i3 = segment4.pos;
                        byte[] bArr3 = segment4.data;
                        i4 = segment4.limit;
                        if (segment4 != segment2) {
                            segment = segment4;
                            bArr = bArr3;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr3;
                            segment = null;
                        }
                    } else {
                        segment = segment3;
                        i4 = i6;
                        i3 = i19;
                    }
                    if (z2) {
                        i = iArr[i20];
                        int i21 = i4;
                        segment3 = segment;
                        i2 = i21;
                        break;
                    }
                    i5 = i3;
                    i6 = i4;
                    segment3 = segment;
                    i11 = i20;
                }
                return i7;
            }
            if (i >= 0) {
                return i;
            }
            int i110 = i2;
            i8 = -i;
            i5 = i3;
            i6 = i110;
        }
        if (z) {
            return -2;
        }
        return i7;
    }
}
