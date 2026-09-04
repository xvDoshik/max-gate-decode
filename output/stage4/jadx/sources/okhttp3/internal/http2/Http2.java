package okhttp3.internal.http2;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import java.nio.charset.Charset;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Http2 {
    public static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE;
    public static final String[] FLAGS;
    public static final String[] FRAME_NAMES;

    static {
        Charset charset = Charsets.UTF_8;
        String strDecode = C0000.decode(new byte[]{102, 102, 44, 25, 24, 68, 124, 49, 98, 104, 28, 0, 72, 7, 59, 62, 104, 51, 97, 41, 57, 111, 59, 50}, "64e92d4e6832f7", 0.0f);
        ByteString byteString = new ByteString(strDecode.getBytes(charset));
        byteString.utf8 = strDecode;
        CONNECTION_PREFACE = byteString;
        FRAME_NAMES = new String[]{C0000.decode(new byte[]{115, 115, 98, 112}, "7261fa8f23d4ac9a", false), C0000.decode(new byte[]{43, 115, 121, 38, 33, 49, 106}, "c68bdc9cf8"), C0000.decode(new byte[]{100, 106, 120, 121, 102, 40, 49, 111}, "48164ae6296d"), C0000.decode(new byte[]{100, 55, 102, 61, 101, 103, 55, 119, 35, 116}, "6d2b63e2b9fccb", 0.0f), C0000.decode(new byte[]{49, 36, 97, 49, 125, 40, 117, 100}, "ba5e4f27"), C0000.decode(new byte[]{105, 98, 54, 44, 105, 104, 96, 122, 43, 124, 99, 115}, "97ed6825f506", true), C0000.decode(new byte[]{98, 112, 122, 38}, "294ae8354328"), C0000.decode(new byte[]{114, 120, 117, 52, 120, 110}, "574c97905214c543", true), C0000.decode(new byte[]{54, 113, 122, 33, 43, 52, 111, 55, 102, 112, 34, 103, 32}, "a84edc0b64c3ec"), C0000.decode(new byte[]{38, 121, 123, 101, 126, 45, 48, 119, 97, 120, 120, 45}, "e6517c", 0.0f)};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            strArr[i] = Util.format(C0000.decode(new byte[]{64, 14, 71}, "e64facc728c5"), Integer.toBinaryString(i)).replace(' ', '0');
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = C0000.decode(new byte[]{33, 44, 114, 102, 107, 103, 97, 32, 116, 117}, "db69833e58ef1c0b", 5);
        int[] iArr = {1};
        strArr2[8] = C0000.decode(new byte[]{104, 114, 125, 37, 38, 33}, "839acea2", true);
        int i2 = iArr[0];
        int i3 = i2 | 8;
        StringBuilder sb = new StringBuilder();
        String str = strArr2[i2];
        String strDecode2 = C0000.decode(new byte[]{69, 101, 120, 119, 125, 33, 125}, "95939d", 0.0f);
        strArr2[i3] = FileSectionType$EnumUnboxingLocalUtility.m(sb, str, strDecode2);
        strArr2[4] = C0000.decode(new byte[]{116, 43, 117, 107, 41, 113, 113, 116, 114, 103, 99}, "1e14a400750406", 0.0f);
        strArr2[32] = C0000.decode(new byte[]{101, 106, 47, 122, 107, 44, 100, 59}, "58f59e0b865beac7", false);
        strArr2[36] = C0000.decode(new byte[]{119, 44, 125, 105, 125, 114, 115, 116, 118, 51, 98, 31, 104, 49, 123, 45, 107, 127, 97, 110}, "2b9657203a1c8c", true);
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            String[] strArr3 = FLAGS;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i6]);
            sb2.append('|');
            strArr3[i7 | 8] = FileSectionType$EnumUnboxingLocalUtility.m(sb2, strArr3[i5], strDecode2);
        }
        int length = FLAGS.length;
        for (int i8 = 0; i8 < length; i8++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i8] == null) {
                strArr4[i8] = BINARY[i8];
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bc  */
    public static String frameLog(boolean z, int i, int i2, int i3, int i4) {
        String str;
        String strDecode;
        String[] strArr = FRAME_NAMES;
        if (i3 < strArr.length) {
            str = strArr[i3];
        } else {
            str = Util.format(C0000.decode(new byte[]{83, 27, 71, 0, 81, 30}, "ccb0cf75dc97f0", 0.0f), Integer.valueOf(i3));
        }
        if (i4 == 0) {
            strDecode = "";
        } else {
            String[] strArr2 = BINARY;
            if (i3 == 2 || i3 == 3) {
                strDecode = strArr2[i4];
            } else if (i3 == 4 || i3 == 6) {
                strDecode = i4 == 1 ? C0000.decode(new byte[]{32, 123, 124}, "a873f38d0e8b") : strArr2[i4];
            } else if (i3 == 7 || i3 == 8) {
                strDecode = strArr2[i4];
            } else {
                String[] strArr3 = FLAGS;
                String str2 = i4 < strArr3.length ? strArr3[i4] : strArr2[i4];
                if (i3 != 5 || (i4 & 4) == 0) {
                    strDecode = (i3 != 0 || (i4 & 32) == 0) ? str2 : StringsKt__StringsJVMKt.replace$default(str2, C0000.decode(new byte[]{96, 48, 125, 125, 100, 47, 96, 106}, "0b426f4345"), C0000.decode(new byte[]{115, 43, 120, 53, 101, 39, 54, 100, 114, 114}, "0d5e7be776", 0.0f));
                } else {
                    strDecode = StringsKt__StringsJVMKt.replace$default(str2, C0000.decode(new byte[]{123, 124, 39, 32, 112, 96, 100}, "39fd5278f228dd23", true), C0000.decode(new byte[]{49, 55, 53, 124, 111, 99, 96, 118, 41, 42, 50, 39}, "abf40329dc", 0.0f));
                }
            }
        }
        return Util.format(C0000.decode(new byte[]{19, 17, 19, 1, 72, 65, 81, 92, 65, 18, 23, 81, 93, 68, 19, 79, 2, 2, 67, 68, 68, 23}, "6b310dad922d9d", 0.0f), z ? C0000.decode(new byte[]{10, 13}, "61fe747b4395a5", 7) : C0000.decode(new byte[]{88, 12}, "f2b1a794bec5a5", 0.0f), Integer.valueOf(i), Integer.valueOf(i2), str, strDecode);
    }
}
