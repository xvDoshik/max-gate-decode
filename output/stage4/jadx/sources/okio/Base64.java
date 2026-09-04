package okio;

import java.nio.charset.Charset;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Base64 {
    public static final byte[] BASE64;

    static {
        Charset charset = Charsets.UTF_8;
        String strDecode = C0000.decode(new byte[]{32, 118, 112, 32, 32, 115, 126, 126, 123, 125, 121, 120, 117, 40, 46, 100, 98, 54, 54, 97, 108, 96, 101, 111, 107, 110, 89, 4, 2, 80, 86, 2, 2, 93, 80, 92, 89, 91, 95, 90, 87, 22, 16, 70, 64, 16, 16, 67, 78, 78, 75, 77, 2, 5, 10, 85, 85, 1, 5, 83, 93, 12, 18, 25}, "a43de59627248f", 0.0f);
        ByteString byteString = new ByteString(strDecode.getBytes(charset));
        byteString.utf8 = strDecode;
        BASE64 = byteString.data;
        C0000.decode(new byte[]{37, 33, 115, 113, 114, 127, 118, 125, 42, 40, 125, 124, 122, 121, 43, 51, 97, 103, 100, 109, 100, 99, 52, 58, 111, 106, 86, 85, 7, 7, 85, 83, 80, 81, 88, 95, 8, 14, 91, 94, 88, 71, 21, 17, 67, 65, 66, 79, 70, 77, 26, 24, 6, 1, 5, 4, 80, 86, 6, 2, 15, 0, 28, 106}, "dc057915cb6077").getBytes(Charsets.UTF_8);
    }
}
