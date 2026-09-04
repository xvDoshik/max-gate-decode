package okhttp3;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = str.charAt(i);
            char cCharAt2 = str2.charAt(i);
            if (cCharAt != cCharAt2) {
                return Intrinsics.compare(cCharAt, cCharAt2) < 0 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
