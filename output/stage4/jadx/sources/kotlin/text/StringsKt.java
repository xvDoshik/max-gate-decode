package kotlin.text;

import androidx.work.JobListenableFuture;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.DelimitedRangesSequence.AnonymousClass1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class StringsKt extends StringsKt__StringsJVMKt {
    public static boolean contains$default(CharSequence charSequence, String str) {
        if (str != null) {
            if (indexOf$default(charSequence, str, 0, 2) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt(charSequence, str, 0, charSequence.length(), false, false) >= 0) {
            return true;
        }
        return false;
    }

    public static final int getLastIndex(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt(charSequence, str, i, charSequence.length(), z, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        CharSequence charSequence3 = charSequence2;
        int i3 = i;
        int i4 = i2;
        if (z2) {
            int lastIndex = getLastIndex(charSequence);
            if (i3 > lastIndex) {
                i3 = lastIndex;
            }
            if (i4 < 0) {
                i4 = 0;
            }
            intProgression = new IntProgression(i3, i4, -1);
        } else {
            if (i3 < 0) {
                i3 = 0;
            }
            int length = charSequence.length();
            if (i4 > length) {
                i4 = length;
            }
            intProgression = new IntRange(i3, i4, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i5 = intProgression.step;
        int i6 = intProgression.last;
        int i7 = intProgression.first;
        if (z3 && (charSequence3 instanceof String)) {
            if ((i5 > 0 && i7 <= i6) || (i5 < 0 && i6 <= i7)) {
                int i8 = i7;
                while (true) {
                    String str = (String) charSequence3;
                    String str2 = (String) charSequence;
                    int length2 = str.length();
                    if (!(!z ? str.regionMatches(0, str2, i8, length2) : str.regionMatches(z, 0, str2, i8, length2))) {
                        if (i8 == i6) {
                            break;
                        }
                        i8 += i5;
                    } else {
                        return i8;
                    }
                }
            }
        } else if ((i5 > 0 && i7 <= i6) || (i5 < 0 && i6 <= i7)) {
            int i9 = i7;
            while (!regionMatchesImpl(charSequence3, 0, charSequence, i9, charSequence3.length(), z)) {
                if (i9 != i6) {
                    i9 += i5;
                    charSequence3 = charSequence2;
                }
            }
            return i9;
        }
        return -1;
    }

    public static int indexOf$default(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return !(charSequence instanceof String) ? indexOfAny(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        int i2;
        boolean z2 = true;
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException(C0000.decode(new byte[]{117, 65, 69, 89, 76, 25, 94, 22, 17, 1, 12, 19, 17, 73, 74}, "4378597e1dace0d4", 0.0f));
            }
            if (length != 1) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{37, 16, 74, 82, 29, 16, 95, 2, 65, 68, 90, 91, 20, 4, 68, 22, 80, 82, 10, 16, 88, 13, 87, 68, 82, 88, 3, 12, 1, 12, 76, 29}, "db83d07c2d74fa", 5));
            }
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        IntRange intRange = new IntRange(i, getLastIndex(charSequence), 1);
        int i3 = intRange.last;
        int i4 = intRange.step;
        if (i4 <= 0 ? i < i3 : i > i3) {
            z2 = false;
        }
        if (!z2) {
            i = i3;
        }
        while (z2) {
            if (i != i3) {
                i2 = i + i4;
            } else {
                if (!z2) {
                    throw new NoSuchElementException();
                }
                i2 = i;
                z2 = false;
            }
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (CharsKt.equals(c, cCharAt, z)) {
                    return i;
                }
            }
            i = i2;
        }
        return -1;
    }

    public static int lastIndexOf$default(String str, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(str);
        }
        if (str != null) {
            return str.lastIndexOf(c, i);
        }
        char[] cArr = {c};
        if (str != null) {
            return str.lastIndexOf(cArr[0], i);
        }
        int lastIndex = getLastIndex(str);
        if (i > lastIndex) {
            i = lastIndex;
        }
        while (-1 < i) {
            if (CharsKt.equals(cArr[0], str.charAt(i), false)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static final List lines(String str) {
        return SequencesKt.toList(new DelimitedRangesSequence(new DelimitedRangesSequence(str, new StringsKt__StringsKt$rangesDelimitedBy$1(1, Arrays.asList(C0000.decode(new byte[]{58, 60}, "765ef0a4c806"), C0000.decode(new byte[]{63}, "515de1733862e046", 6), C0000.decode(new byte[]{62}, "3a594342", 0)))), new JobListenableFuture.AnonymousClass1(4, str)));
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static List split$default(String str, char[] cArr) {
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            int iIndexOf = indexOf(str, strValueOf, 0, false);
            if (iIndexOf == -1) {
                return Collections.singletonList(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iIndexOf).toString());
                length = strValueOf.length() + iIndexOf;
                iIndexOf = indexOf(str, strValueOf, length, false);
            } while (iIndexOf != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        final DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(str, new StringsKt__StringsKt$rangesDelimitedBy$1(0, cArr));
        Iterable iterable = new Iterable() { // from class: kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return delimitedRangesSequence.new AnonymousClass1();
            }
        };
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable));
        Iterator it = iterable.iterator();
        while (true) {
            DelimitedRangesSequence.AnonymousClass1 anonymousClass1 = (DelimitedRangesSequence.AnonymousClass1) it;
            if (!anonymousClass1.hasNext()) {
                return arrayList2;
            }
            IntRange intRange = (IntRange) anonymousClass1.next();
            arrayList2.add(str.subSequence(intRange.first, intRange.last + 1).toString());
        }
    }

    public static String substringAfter$default(String str, String str2) {
        int iIndexOf$default = indexOf$default(str, str2, 0, 6);
        return iIndexOf$default == -1 ? str : str.substring(str2.length() + iIndexOf$default, str.length());
    }

    public static String substringAfterLast$default(String str) {
        int iLastIndexOf$default = lastIndexOf$default(str, '.', 0, 6);
        return iLastIndexOf$default == -1 ? str : str.substring(iLastIndexOf$default + 1, str.length());
    }

    public static String take(String str, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{96, 1, 68, 19, 83, 16, 68, 83, 86, 68, 86, 14, 87, 17, 81, 85, 70, 1, 71, 70, 85, 12, 69, 88, 70, 68}, "2d5f6c06", 3), C0000.decode(new byte[]{19, 11, 23, 23, 9, 84, 22, 21, 17, 17, 88, 84, 93, 66, 30, 82, 23, 94, 75}, "3bd7e1ef1e05", 0), i).toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(0, i);
    }

    public static CharSequence trim(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt.isWhitespace(str.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }

    public static boolean contains$default(CharSequence charSequence, char c) {
        return indexOf$default(charSequence, c, 0, 2) >= 0;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOf(charSequence, str, i, false);
    }
}
