package kotlin.collections;

import kotlin.jvm.functions.Function1;
import okhttp3.Headers;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ArraysKt extends Headers.Companion {
    public static void copyInto(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static void copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        System.arraycopy(objArr, i, objArr2, 0, i2 - i);
    }

    public static String joinToString$default(byte[] bArr, Function1 function1) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (byte b : bArr) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) "");
            }
            sb.append((CharSequence) function1.invoke(Byte.valueOf(b)));
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }
}
