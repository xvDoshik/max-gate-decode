package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class StringsKt__IndentKt extends CloseableKt {
    /* JADX WARN: Code duplicated, block: B:14:0x004c A[PHI: r8
      0x004c: PHI (r8v1 java.lang.String) = (r8v0 java.lang.String), (r8v2 java.lang.String) binds: [B:13:0x004a, B:28:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    public static String trimMargin$default(String str) {
        String strDecode = C0000.decode(new byte[]{78}, "2dbb520404ba4f", 4);
        if (StringsKt__StringsJVMKt.isBlank(strDecode)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{95, 83, 22, 1, 81, 87, 105, 22, 7, 4, 91, 74, 68, 11, 77, 74, 77, 68, 0, 7, 18, 92, 11, 8, 21, 91, 85, 5, 12, 9, 18, 65, 16, 20, 81, 87, 94, 74}, "22df899dbb", 2));
        }
        List listLines = StringsKt.lines(str);
        int length = str.length();
        listLines.size();
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listLines) {
            int i2 = i + 1;
            if (i < 0) {
                throw new ArithmeticException(C0000.decode(new byte[]{120, 15, 1, 86, 79, 68, 86, 71, 84, 66, 87, 13, 10, 68, 23, 12, 88, 66, 17, 88, 80, 17, 21, 86, 89, 1, 93, 31}, "1ae37d9110", 7));
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i == 0 || i == lastIndex) && StringsKt__StringsJVMKt.isBlank(str2)) {
                str2 = strSubstring;
            } else {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!CharsKt.isWhitespace(str2.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1 && str2.startsWith(strDecode, i3)) {
                    strSubstring = str2.substring(strDecode.length() + i3);
                }
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        CollectionsKt.joinTo(arrayList, sb, C0000.decode(new byte[]{59}, "1f94a7", 3), "", "", null);
        return sb.toString();
    }
}
