package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean isBlank(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            Iterable intRange = new IntRange(0, charSequence.length() - 1, 1);
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it = intRange.iterator();
                while (it.hasNext()) {
                    if (!CharsKt.isWhitespace(charSequence.charAt(((IntProgressionIterator) it).nextInt()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String replace$default(String str, String str2, String str3) {
        int iIndexOf = StringsKt.indexOf(str, str2, 0, false);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i2 = 0;
        do {
            sb.append((CharSequence) str, i2, iIndexOf);
            sb.append(str3);
            i2 = iIndexOf + length;
            if (iIndexOf >= str.length()) {
                break;
            }
            iIndexOf = StringsKt.indexOf(str, str2, iIndexOf + i, false);
        } while (iIndexOf > 0);
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }
}
