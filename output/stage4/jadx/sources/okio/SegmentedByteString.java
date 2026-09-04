package okio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SegmentedByteString extends ByteString {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.data);
        this.segments = bArr;
        this.directory = iArr;
    }

    @Override // okio.ByteString
    public final String base64() {
        throw null;
    }

    @Override // okio.ByteString
    public final ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(bArr[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        return new ByteString(messageDigest.digest());
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        return byteString.getSize$okio() == getSize$okio() && rangeEquals(getSize$okio(), byteString);
    }

    @Override // okio.ByteString
    public final int getSize$okio() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public final String hex() {
        byte[] byteArray = toByteArray();
        char[] cArr = new char[byteArray.length * 2];
        int i = 0;
        for (byte b : byteArray) {
            int i2 = i + 1;
            char[] cArr2 = okio.internal.ByteString.HEX_DIGIT_CHARS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    @Override // okio.ByteString
    public final byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public final byte internalGet$okio(int i) {
        byte[][] bArr = this.segments;
        int length = bArr.length - 1;
        int[] iArr = this.directory;
        Options.Companion.checkOffsetAndCount(iArr[length], i, 1L);
        int iSegment = okio.internal.ByteString.segment(this, i);
        return bArr[iSegment][(i - (iSegment == 0 ? 0 : iArr[iSegment - 1])) + iArr[bArr.length + iSegment]];
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, ByteString byteString) {
        if (getSize$okio() - i >= 0) {
            int iSegment = okio.internal.ByteString.segment(this, 0);
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int[] iArr = this.directory;
                int i4 = iSegment == 0 ? 0 : iArr[iSegment - 1];
                int i5 = iArr[iSegment] - i4;
                byte[][] bArr = this.segments;
                int i6 = iArr[bArr.length + iSegment];
                int iMin = Math.min(i, i5 + i4) - i2;
                if (byteString.rangeEquals(i3, bArr[iSegment], (i2 - i4) + i6, iMin)) {
                    i3 += iMin;
                    i2 += iMin;
                    iSegment++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.ByteString
    public final ByteString toAsciiLowercase() {
        return new ByteString(toByteArray()).toAsciiLowercase();
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[getSize$okio()];
        byte[][] bArr2 = this.segments;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            System.arraycopy(bArr2[i], i4, bArr, i3, (i4 + i6) - i4);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public final String toString() {
        return new ByteString(toByteArray()).toString();
    }

    @Override // okio.ByteString
    public final void write$okio(Buffer buffer, int i) {
        int iSegment = okio.internal.ByteString.segment(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.directory;
            int i3 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i4 = iArr[iSegment] - i3;
            byte[][] bArr = this.segments;
            int i5 = iArr[bArr.length + iSegment];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            Segment segment = new Segment(bArr[iSegment], i6, i6 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i2 += iMin;
            iSegment++;
        }
        buffer.size += (long) i;
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= getSize$okio() - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
            int i4 = i3 + i;
            int iSegment = okio.internal.ByteString.segment(this, i);
            while (i < i4) {
                int[] iArr = this.directory;
                int i5 = iSegment == 0 ? 0 : iArr[iSegment - 1];
                int i6 = iArr[iSegment] - i5;
                byte[][] bArr2 = this.segments;
                int i7 = iArr[bArr2.length + iSegment];
                int iMin = Math.min(i4, i6 + i5) - i;
                int i8 = (i - i5) + i7;
                byte[] bArr3 = bArr2[iSegment];
                for (int i9 = 0; i9 < iMin; i9++) {
                    if (bArr3[i9 + i8] == bArr[i9 + i2]) {
                    }
                }
                i2 += iMin;
                i += iMin;
                iSegment++;
            }
            return true;
        }
        return false;
    }
}
