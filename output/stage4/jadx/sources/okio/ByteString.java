package okio;

import android.os.SystemClock;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import com.google.android.datatransport.runtime.time.Clock;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ByteString implements Serializable, Comparable {
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    public final class Companion implements ProfileInstaller$DiagnosticsCallback, Clock {
        public static Companion zza;

        public static ByteString decodeHex(String str) {
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{48, 87, 6, 29, 71, 6, 81, 16, 92, 2, 17, 88, 0, 65, 67, 22, 67, 17, 91, 10, 94, 92, 17}, "e9ce7c2d9f10").concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (okio.internal.ByteString.access$decodeHexDigit(str.charAt(i2 + 1)) + (okio.internal.ByteString.access$decodeHexDigit(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }

        public static ByteString encodeUtf8(String str) {
            ByteString byteString = new ByteString(str.getBytes(Charsets.UTF_8));
            byteString.utf8 = str;
            return byteString;
        }

        public static ByteString of$default(byte[] bArr) {
            int length = bArr.length;
            Options.Companion.checkOffsetAndCount(bArr.length, 0, length);
            Headers.Companion.copyOfRangeToIndexCheck(length, bArr.length);
            return new ByteString(Arrays.copyOfRange(bArr, 0, length));
        }

        @Override // com.google.android.datatransport.runtime.time.Clock
        public long getTime() {
            return SystemClock.elapsedRealtime();
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
        }
    }

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public String base64() {
        byte[] bArr = Base64.BASE64;
        byte[] bArr2 = this.data;
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr2[i];
            int i3 = i + 2;
            byte b2 = bArr2[i + 1];
            i += 3;
            byte b3 = bArr2[i3];
            bArr3[i2] = bArr[(b & 255) >> 2];
            bArr3[i2 + 1] = bArr[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr3[i2 + 2] = bArr[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr3[i4] = bArr[b3 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b4 = bArr2[i];
            bArr3[i2] = bArr[(b4 & 255) >> 2];
            bArr3[i2 + 1] = bArr[(b4 & 3) << 4];
            bArr3[i2 + 2] = 61;
            bArr3[i2 + 3] = 61;
        } else if (length2 == 2) {
            int i5 = i + 1;
            byte b5 = bArr2[i];
            byte b6 = bArr2[i5];
            bArr3[i2] = bArr[(b5 & 255) >> 2];
            bArr3[i2 + 1] = bArr[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            bArr3[i2 + 2] = bArr[(b6 & 15) << 2];
            bArr3[i2 + 3] = 61;
        }
        return new String(bArr3, Charsets.UTF_8);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ByteString byteString = (ByteString) obj;
        int size$okio = getSize$okio();
        int size$okio2 = byteString.getSize$okio();
        int iMin = Math.min(size$okio, size$okio2);
        for (int i = 0; i < iMin; i++) {
            int iInternalGet$okio = internalGet$okio(i) & 255;
            int iInternalGet$okio2 = byteString.internalGet$okio(i) & 255;
            if (iInternalGet$okio != iInternalGet$okio2) {
                return iInternalGet$okio < iInternalGet$okio2 ? -1 : 1;
            }
        }
        if (size$okio == size$okio2) {
            return 0;
        }
        return size$okio < size$okio2 ? -1 : 1;
    }

    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, getSize$okio());
        return new ByteString(messageDigest.digest());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size$okio = byteString.getSize$okio();
            byte[] bArr = this.data;
            if (size$okio == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int getSize$okio() {
        return this.data.length;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = okio.internal.ByteString.HEX_DIGIT_CHARS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public byte[] internalArray$okio() {
        return this.data;
    }

    public byte internalGet$okio(int i) {
        return this.data[i];
    }

    public boolean rangeEquals(int i, ByteString byteString) {
        return byteString.rangeEquals(0, this.data, 0, i);
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:179:0x01c7 A[EDGE_INSN: B:179:0x01c7->B:180:0x01c8 BREAK  A[LOOP:0: B:7:0x001f->B:241:0x001f]] */
    public String toString() {
        ByteString byteString;
        byte b;
        int i;
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return C0000.decode(new byte[]{110, 23, 11, 72, 93, 5, 7, 111}, "5db28872057c7e8b", 0.0f);
        }
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i2 < length) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if ((b2 >> 5) != -2) {
                    if ((b2 >> 4) != -2) {
                        if ((b2 >> 3) != -2) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i5 = i2 + 3;
                        if (length > i5) {
                            byte b3 = bArr[i2 + 1];
                            if ((b3 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b4 = bArr[i2 + 2];
                            if ((b4 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b5 = bArr[i5];
                            if ((b5 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
                            if (i6 <= 1114111) {
                                if (55296 <= i6 && i6 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                if (i6 >= 65536) {
                                    i = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    if ((i6 != 10 && i6 != 13 && ((i6 >= 0 && i6 < 32) || (127 <= i6 && i6 < 160))) || i6 == 65533) {
                                        i3 = -1;
                                        break;
                                    }
                                    i3 += i6 < 65536 ? 1 : 2;
                                    i2 += 4;
                                    i4 = i;
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        int i7 = i2 + 2;
                        if (length > i7) {
                            byte b6 = bArr[i2 + 1];
                            if ((b6 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b7 = bArr[i7];
                            if ((b7 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i8 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b2 << 12);
                            if (i8 >= 2048) {
                                if (55296 <= i8 && i8 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                i = i4 + 1;
                                if (i4 == 64) {
                                    break;
                                }
                                if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                                    i3 = -1;
                                    break;
                                }
                                i3 += i8 < 65536 ? 1 : 2;
                                i2 += 3;
                                i4 = i;
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    }
                } else {
                    int i9 = i2 + 1;
                    if (length > i9) {
                        byte b8 = bArr[i9];
                        if ((b8 & 192) != 128) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i10 = (b8 ^ 3968) ^ (b2 << 6);
                        if (i10 >= 128) {
                            i = i4 + 1;
                            if (i4 == 64) {
                                break;
                            }
                            if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                i3 = -1;
                                break;
                            }
                            i3 += i10 < 65536 ? 1 : 2;
                            i2 += 2;
                            i4 = i;
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        if (i4 == 64) {
                            break;
                        }
                        i3 = -1;
                        break;
                    }
                }
            } else {
                int i11 = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if ((b2 == 10 || b2 == 13 || ((b2 < 0 || b2 >= 32) && (127 > b2 || b2 >= 160))) && b2 != 65533) {
                    i3 += b2 < 65536 ? 1 : 2;
                    i2++;
                    while (true) {
                        i4 = i11;
                        if (i2 < length && (b = bArr[i2]) >= 0) {
                            i2++;
                            i11 = i4 + 1;
                            if (i4 == 64) {
                                break loop0;
                            }
                            if ((b == 10 || b == 13 || ((b < 0 || b >= 32) && (127 > b || b >= 160))) && b != 65533) {
                                i3 += b < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i3 = -1;
                break;
            }
        }
        String strDecode = C0000.decode(new byte[]{-46, -29, -64, 104}, "0cf5d23daa", 0.0f);
        String strDecode2 = C0000.decode(new byte[]{109, 21, 15, 67, 84, 9}, "6ff914cad716cee5", 2);
        if (i3 != -1) {
            String strUtf8 = utf8();
            String strReplace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(strUtf8.substring(0, i3), C0000.decode(new byte[]{109}, "1937b97afff62e", 5), C0000.decode(new byte[]{107, 61}, "7afd4438b6f9e1", 0.0f)), C0000.decode(new byte[]{107}, "a33222", false), C0000.decode(new byte[]{105, 15}, "5ac2cd98f6", 0.0f)), C0000.decode(new byte[]{111}, "bfe84e0e"), C0000.decode(new byte[]{107, 67}, "713611f30cc721", true));
            if (i3 >= strUtf8.length()) {
                return C0000.decode(new byte[]{106, 77, 84, 73, 64, 88}, "19114e", true) + strReplace$default + ']';
            }
            return strDecode2 + bArr.length + C0000.decode(new byte[]{23, 17, 4, 74, 21, 8}, "7ea2a5b85d36") + strReplace$default + strDecode;
        }
        if (bArr.length <= 64) {
            return C0000.decode(new byte[]{104, 12, 85, 75, 10}, "3d037c2ff5bd65", 2) + hex() + ']';
        }
        StringBuilder sb = new StringBuilder(strDecode2);
        sb.append(bArr.length);
        sb.append(C0000.decode(new byte[]{24, 88, 81, 74, 88}, "8042e8"));
        if (64 > bArr.length) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{87, 87, 92, 47, 92, 83, 1, 79, 17, 8, 25, 94, 87, 87, 95, 18, 90, 31}, "298f27d71692", 0.0f) + bArr.length + ')').toString());
        }
        if (64 == bArr.length) {
            byteString = this;
        } else {
            Headers.Companion.copyOfRangeToIndexCheck(64, bArr.length);
            byteString = new ByteString(Arrays.copyOfRange(bArr, 0, 64));
        }
        sb.append(byteString.hex());
        sb.append(strDecode);
        return sb.toString();
    }

    public final String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(internalArray$okio(), Charsets.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write$okio(Buffer buffer, int i) {
        buffer.write(i, this.data);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.data;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (bArr2[i4 + i] == bArr[i4 + i2]) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
