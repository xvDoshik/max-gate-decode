package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MediaType {
    public final String mediaType;
    public final String[] parameterNamesAndValues;
    public static final Pattern TYPE_SUBTYPE = Pattern.compile(C0000.decode(new byte[]{28, 63, 82, 21, 72, 119, 24, 62, 1, 24, 12, 75, 21, 71, 23, 29, 20, 17, 31, 79, 31, 107, 106, 6, 79, 24, 78, 70, 111, 29, 28, 75, 25, 110, 84, 75, 78, 37, 30, 98, 2, 27, 12, 73, 16, 22, 17, 67, 18, 67, 25, 19, 28, 104, 106, 4, 74, 73, 72, 24, 105, 79, 26}, "4d38265d155f", 4));
    public static final Pattern PARAMETER = Pattern.compile(C0000.decode(new byte[]{95, 108, 69, 25, 28, 9, 89, 74, 63, 81, 27, 73, 117, 27, 57, 82, 73, 9, 27, 18, 23, 18, 70, 68, 67, 26, 29, 29, 106, 105, 3, 25, 24, 77, 72, 110, 31, 31, 94, 74, 91, 10, 30, 104, 85, 27, 25, 35, 73, 106, 6, 30, 13, 27, 66, 65, 64, 21, 16, 20, 30, 29, 77, 60, 59, 80, 77, 79, 73, 72, 62, 73, 77, 76, 20, 27, 111, 104, 65, 63, 78, 25, 20, 26, 29, 9}, "d06346cb"));

    public MediaType(String str, String[] strArr) {
        this.mediaType = str;
        this.parameterNamesAndValues = strArr;
    }

    public final Charset charset(Charset charset) {
        String str;
        String[] strArr = this.parameterNamesAndValues;
        int i = 0;
        int progressionLastElement = CharsKt.getProgressionLastElement(0, strArr.length - 1, 2);
        if (progressionLastElement < 0) {
            str = null;
            break;
        }
        while (true) {
            if (!StringsKt__StringsJVMKt.equals(strArr[i], C0000.decode(new byte[]{82, 11, 87, 20, 68, 3, 64}, "1c6f7f400f74"))) {
                if (i == progressionLastElement) {
                    str = null;
                    break;
                }
                i += 2;
            } else {
                str = strArr[i + 1];
                break;
            }
        }
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType);
    }

    public final int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String toString() {
        return this.mediaType;
    }
}
