package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a5\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b¨\u0006\u000e"}, d2 = {"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", "source", "", "startIndex", "", "endIndex", "platformEncodeToString", "", "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Base64JVMKt {
    private static final byte[] platformCharsToBytes(Base64 base64, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(base64, C0000.decode(new byte[]{95, 66, 80, 89, 22, 95}, "c680ea014005b86b", 0.0f));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{67, 91, 64, 71, 2, 85}, "0455a06d6a40", true));
        if (!(charSequence instanceof String)) {
            return base64.charsToBytesImpl$kotlin_stdlib(charSequence, i, i2);
        }
        String str = (String) charSequence;
        base64.checkSourceBounds$kotlin_stdlib(str.length(), i, i2);
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{21, 23, 3, 22, 67, 74, 15, 12, 6, 77, 25, 22, 72, 75}, "fbae78", true));
        Charset charset = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{93, 69, 89, 90, 21, 85, 88, 13, 86, 11, 68, 16, 86, 86, 69, 6, 82, 67, 65, 22, 65, 89, 25, 13, 87, 10, 29, 94, 65, 95, 9, 69, 71, 73, 69, 83, 21, 92, 88, 21, 89, 74, 92, 81, 90, 84, 75, 54, 71, 66, 92, 88, 82}, "3056569c8d0043ee", 6));
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{80, 82, 65, 36, 28, 77, 85, 66, 24, 23, 74, 22, 31}, "775fe90109d86d52", 0.0f));
        return bytes;
    }

    private static final int platformEncodeIntoByteArray(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(base64, C0000.decode(new byte[]{8, 65, 12, 81, 70, 88}, "45d85fd99d5dc9", true));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{69, 93, 68, 64, 6, 80}, "6212e55b86", true));
        Intrinsics.checkNotNullParameter(bArr2, C0000.decode(new byte[]{2, 93, 69, 65, 8, 11, 2, 16, 13, 87, 10}, "f865aecdd8d57cac", true));
        return base64.encodeIntoByteArrayImpl$kotlin_stdlib(bArr, bArr2, i, i2, i3);
    }

    private static final byte[] platformEncodeToByteArray(Base64 base64, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(base64, C0000.decode(new byte[]{8, 21, 88, 92, 71, 12}, "4a0542", 3));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{22, 92, 77, 64, 84, 82}, "e38277", 0.0f));
        return base64.encodeToByteArrayImpl$kotlin_stdlib(bArr, i, i2);
    }

    private static final String platformEncodeToString(Base64 base64, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(base64, C0000.decode(new byte[]{93, 66, 10, 93, 17, 92}, "a6b4bbf7"));
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{74, 9, 69, 65, 84, 7}, "9f037b3c88ea", true));
        return new String(base64.encodeToByteArrayImpl$kotlin_stdlib(bArr, i, i2), Charsets.ISO_8859_1);
    }
}
