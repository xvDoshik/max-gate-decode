package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements Function2 {
    public final /* synthetic */ Object $delimiters;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StringsKt__StringsKt$rangesDelimitedBy$1(int i, Object obj) {
        super(2);
        this.$r8$classId = i;
        this.$delimiters = obj;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b8 A[LOOP:0: B:26:0x0088->B:37:0x00b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f2 A[LOOP:2: B:43:0x00c3->B:54:0x00f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00f4 A[SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Object next;
        String str;
        Pair pair;
        String str2;
        Object next2;
        String str3;
        String str4;
        switch (this.$r8$classId) {
            case 0:
                int iIndexOfAny = StringsKt.indexOfAny((CharSequence) obj, (char[]) this.$delimiters, ((Number) obj2).intValue(), false);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iIndexOfAny), 1);
            default:
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue = ((Number) obj2).intValue();
                List list = (List) this.$delimiters;
                if (list.size() == 1) {
                    int size = list.size();
                    if (size == 0) {
                        throw new NoSuchElementException(C0000.decode(new byte[]{46, 13, 69, 71, 18, 89, 69, 16, 80, 8, 19, 67, 72, 72}, "bd6320605ec71f6d", 1));
                    }
                    if (size != 1) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{47, 88, 17, 17, 66, 14, 86, 75, 20, 84, 10, 20, 85, 22, 23, 89, 3, 11, 66, 9, 89, 93, 20, 92, 9, 3, 93, 83, 13, 69, 76}, "c1bebf7849ef06"));
                    }
                    String str5 = (String) list.get(0);
                    int iIndexOf$default = StringsKt.indexOf$default(charSequence, str5, iIntValue, 4);
                    if (iIndexOf$default < 0) {
                        pair = null;
                    } else {
                        pair = new Pair(Integer.valueOf(iIndexOf$default), str5);
                    }
                } else {
                    if (iIntValue < 0) {
                        iIntValue = 0;
                    }
                    IntRange intRange = new IntRange(iIntValue, charSequence.length(), 1);
                    boolean z = charSequence instanceof String;
                    int i = intRange.step;
                    int i2 = intRange.last;
                    if (z) {
                        if ((i <= 0 || iIntValue > i2) && (i >= 0 || i2 > iIntValue)) {
                            pair = null;
                        } else {
                            while (true) {
                                Iterator it = list.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        str4 = (String) next2;
                                    } else {
                                        next2 = null;
                                    }
                                    str3 = (String) next2;
                                    if (str3 != null) {
                                        pair = new Pair(Integer.valueOf(iIntValue), str3);
                                    } else if (iIntValue != i2) {
                                        iIntValue += i;
                                    } else {
                                        pair = null;
                                    }
                                } while (!str4.regionMatches(0, (String) charSequence, iIntValue, str4.length()));
                                str3 = (String) next2;
                                if (str3 != null) {
                                    pair = new Pair(Integer.valueOf(iIntValue), str3);
                                } else if (iIntValue != i2) {
                                    iIntValue += i;
                                } else {
                                    pair = null;
                                }
                            }
                        }
                    } else if ((i <= 0 || iIntValue > i2) && (i >= 0 || i2 > iIntValue)) {
                        pair = null;
                    } else {
                        int i3 = iIntValue;
                        while (true) {
                            Iterator it2 = list.iterator();
                            do {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    str2 = (String) next;
                                } else {
                                    next = null;
                                }
                                str = (String) next;
                                if (str != null) {
                                    pair = new Pair(Integer.valueOf(i3), str);
                                } else if (i3 != i2) {
                                    i3 += i;
                                } else {
                                    pair = null;
                                }
                            } while (!StringsKt.regionMatchesImpl(str2, 0, charSequence, i3, str2.length(), false));
                            str = (String) next;
                            if (str != null) {
                                pair = new Pair(Integer.valueOf(i3), str);
                            } else if (i3 != i2) {
                                i3 += i;
                            } else {
                                pair = null;
                            }
                        }
                    }
                }
                if (pair != null) {
                    return new Pair(pair.first, Integer.valueOf(((String) pair.second).length()));
                }
                return null;
        }
    }
}
