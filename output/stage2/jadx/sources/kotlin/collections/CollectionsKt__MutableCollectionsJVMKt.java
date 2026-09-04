package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0087\b\u001a6\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\bH\u0087\bø\u0001\u0000\u001a \u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a2\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006\u001a&\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\r\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a!\u0010\u000f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"sort", "", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparison", "Lkotlin/Function2;", "", "", "sortWith", "fill", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    private static final <T> void fill(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{13, 70, 81, 93, 65, 88}, "12942fa5", 6));
        Collections.fill(list, t);
    }

    private static final <T> void shuffle(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{88, 21, 95, 89, 17, 90}, "da70bdf749", 0.0f));
        Collections.shuffle(list);
    }

    private static final <T> void shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{8, 22, 81, 8, 71, 15}, "4b9a418c", true));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{74, 87, 88, 85, 11, 95}, "8661d2"));
        Collections.shuffle(list, random);
    }

    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{15, 76, 12, 81, 68, 92}, "38d87bad568931", true));
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    private static final <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{9, 77, 9, 93, 67, 10}, "59a404", 2));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{90, 94, 89, 68, 2, 20, 7, 64, 86, 67}, "9144cff4", 0));
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    private static final <T> void sort(List<T> list, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{13, 69, 10, 89, 66, 9}, "11b0175de59a9f", 5));
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{83, 10, 93, 73, 5, 22, 93, 64, 89, 15}, "0e09dd436ab9c0", true));
        throw new NotImplementedError(null, 1, null);
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{15, 65, 12, 90, 65, 90}, "35d32da3"));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{85, 9, 95, 71, 88, 70, 0, 21, 14, 19}, "6f2794aaaa0740", 0.0f));
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
