package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002¢\u0006\u0002\u0010\t\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a$\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\rj\b\u0012\u0004\u0012\u0002H\u0002`\u000e\"\u0004\b\u0000\u0010\u0002H\u0087\b¢\u0006\u0002\u0010\u000f\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002¢\u0006\u0002\u0010\t\u001a5\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\rj\b\u0012\u0004\u0012\u0002H\u0002`\u000e\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00122\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\t\u001aC\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\bø\u0001\u0000\u001aC\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\bø\u0001\u0000\u001aF\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0006\"\u0004\b\u0000\u0010\u001f2\u001f\b\u0001\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u000b\u0012\u0004\u0012\u00020!0\u0019¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0006\"\u0004\b\u0000\u0010\u001f2\u0006\u0010#\u001a\u00020\u00172\u001f\b\u0001\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u000b\u0012\u0004\u0012\u00020!0\u0019¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0019\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\b\u001a,\u0010-\u001a\u00020,\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a!\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a!\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0006H\u0087\b\u001aH\u0010/\u001a\u0002H0\"\u0010\b\u0000\u00101*\u0006\u0012\u0002\b\u00030\u0001*\u0002H0\"\u0004\b\u0001\u00100*\u0002H12\f\u00102\u001a\b\u0012\u0004\u0012\u0002H003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u00104\u001a,\u00105\u001a\u00020,\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b6*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\b\u001a&\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u0002082\u0006\u00109\u001a\u00020:H\u0007\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001aE\u0010<\u001a\u00020\u0017\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020=*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u0017¢\u0006\u0002\u0010@\u001aS\u0010<\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0013\u001a\u0002H\u00022\u001a\u0010A\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020Bj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`C2\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u0017¢\u0006\u0002\u0010D\u001ag\u0010E\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010F*\b\u0012\u0004\u0012\u0002HF0=*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\u0010G\u001a\u0004\u0018\u0001HF2\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u00172\u0016\b\u0004\u0010H\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001HF0\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010I\u001a>\u0010<\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u00172\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00170\u0019\u001a%\u0010K\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0017H\u0002¢\u0006\u0002\bL\u001a\b\u0010M\u001a\u00020!H\u0001\u001a\b\u0010N\u001a\u00020!H\u0001\u001a!\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00032\n\u0010P\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0002\u0010Q\u001a3\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\n\u0010P\u001a\u0006\u0012\u0002\b\u00030\u00012\f\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010S\"\u0019\u0010$\u001a\u00020%*\u0006\u0012\u0002\b\u00030\u00018F¢\u0006\u0006\u001a\u0004\b&\u0010'\"!\u0010(\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006T"}, d2 = {"asCollection", "", "T", "", "([Ljava/lang/Object;)Ljava/util/Collection;", "emptyList", "", "listOf", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()Ljava/util/ArrayList;", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "List", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "buildList", "E", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "capacity", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/util/List;)I", "isNotEmpty", "", "isNullOrEmpty", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "containsAll", "Lkotlin/internal/OnlyInputTypes;", "shuffled", "", "random", "Lkotlin/random/Random;", "optimizeReadOnlyList", "binarySearch", "", "fromIndex", "toIndex", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", "rangeCheck", "rangeCheck$CollectionsKt__CollectionsKt", "throwIndexOverflow", "throwCountOverflow", "collectionToArrayCommonImpl", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    private static final <T> List<T> List(int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{94, 11, 13, 70}, "7ed24e379d0ccd", 2));
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(function1.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    private static final <T> List<T> MutableList(int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{81, 13, 95, 77}, "8c6945", true));
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(function1.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{92, 84, 80, 8, 87, 8, 76, 21}, "985e2f8fd5cb", 7));
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(tArr, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{94, 21, 9, 89, 66, 7}, "baa0191806ca", true));
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T> int binarySearch(List<? extends T> list, int i, int i2, Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{14, 23, 89, 8, 18, 13}, "2c1aa3b7", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{80, 92, 9, 72, 3, 19, 95, 75, 10, 13}, "33d8ba68ec5ca747"));
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iIntValue = function1.invoke(list.get(i4)).intValue();
            if (iIntValue < 0) {
                i = i4 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{15, 18, 80, 10, 70, 10}, "3f8c546a9a7d8d"));
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iCompareValues = ComparisonsKt.compareValues(list.get(i4), t);
            if (iCompareValues < 0) {
                i = i4 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final <T> int binarySearch(List<? extends T> list, T t, Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{13, 69, 9, 11, 64, 92}, "11ab3b", 3));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{83, 95, 84, 66, 85, 74, 85, 69, 94, 69}, "0092484117", true));
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iCompare = comparator.compare(list.get(i4), t);
            if (iCompare < 0) {
                i = i4 + 1;
            } else {
                if (iCompare <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k, int i, int i2, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{12, 16, 93, 92, 71, 95}, "0d554a19f3b894f1", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{67, 4, 85, 93, 7, 16, 11, 70}, "0a98ddd4da0e9a", 0.0f));
        return CollectionsKt.binarySearch(list, i, i2, new AnonymousClass1(function1, k));
    }

    public static /* synthetic */ int binarySearchBy$default(List list, Comparable comparable, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{93, 77, 90, 95, 70, 15}, "a92651db64ba"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{69, 84, 9, 85, 86, 17, 12, 69}, "61e05ec7", 6));
        return CollectionsKt.binarySearch(list, i, i2, new AnonymousClass1(function1, comparable));
    }

    private static final <E> List<E> buildList(int i, Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 23, 8, 85, 82, 80, 70, 112, 5, 22, 8, 86, 88}, "fba96541", true));
        List listCreateListBuilder = CollectionsKt.createListBuilder(i);
        function1.invoke(listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{83, 16, 91, 94, 93, 83, 71, 113, 82, 67, 13, 91, 8}, "1e22965017d4f7d0"));
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        function1.invoke(listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{0, 91, 15, 94, 81, 81, 68, 12, 13, 87}, "c4c2420eb9dd", 0.0f));
        int i = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> collection, T[] tArr) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{85, 93, 13, 91, 80, 86, 68, 15, 93, 94}, "62a7550f20b8", 0.0f));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{82, 16, 23, 0, 74}, "3bea32c060e689", false));
        int i = 0;
        if (collection.isEmpty()) {
            return (T[]) CollectionsKt.terminateCollectionToArray(0, tArr);
        }
        if (tArr.length < collection.size()) {
            objArr = tArr;
            objArr = (T[]) ArraysKt.arrayOfNulls(tArr, collection.size());
        }
        objArr = tArr;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(collection.size(), objArr);
    }

    private static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{93, 68, 94, 88, 67, 9}, "a061078c530aeb63"));
        Intrinsics.checkNotNullParameter(collection2, C0000.decode(new byte[]{85, 93, 6, 84, 84, 12, 71, 75}, "01c91b38", true));
        return collection.containsAll(collection2);
    }

    public static final IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{89, 77, 88, 95, 65, 6}, "e90628"));
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{90, 66, 14, 15, 18, 11}, "f6ffa59bb98d"));
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Collection collection, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{7, 6, 87, 85, 19, 95, 23, 111, 81, 94, 16, 83}, "cc14f3c902e6", 6));
        return collection.isEmpty() ? function0.invoke() : collection;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{88, 22, 92, 13, 17, 13}, "db4db3", 6));
        return !collection.isEmpty();
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{1, 8, 1, 94, 4, 91, 18, 23}, "ddd3a5fdbd", 0));
        return tArr.length > 0 ? ArraysKt.asList(tArr) : CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{3, 15, 3, 11, 84, 10, 18, 23}, "fcff1dfd2e1e9d", 5));
        return ArraysKt.filterNotNull(tArr);
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{84, 91, 83, 88, 1, 92, 68, 66}, "1765d2016a9223c0", 0.0f));
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{89, 64, 93, 88, 74, 93}, "e4519cc2", false));
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : CollectionsKt.listOf(list.get(0));
        }
        return CollectionsKt.emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i2, int i3) {
        String strDecode = C0000.decode(new byte[]{76, 74}, "edbfd39543d6", 0.0f);
        String strDecode2 = C0000.decode(new byte[]{4, 75, 11, 88, 112, 87, 81, 82, 30, 16, 30}, "b9d59957f061d6", 0.0f);
        if (i2 > i3) {
            throw new IllegalArgumentException(strDecode2 + i2 + C0000.decode(new byte[]{28, 24, 15, 71, 23, 83, 23, 83, 84, 76, 3, 70, 23, 64, 13, 87, 91, 24, 18, 91, 126, 90, 1, 83, 77, 24, 78}, "58f474e6", 0) + i3 + strDecode);
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(strDecode2 + i2 + C0000.decode(new byte[]{28, 21, 88, 69, 69, 15, 80, 70, 66, 22, 17, 11, 84, 91, 17, 76, 0, 17, 90, 27}, "5516ec", 4));
        }
        if (i3 > i) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{18, 92, 124, 8, 81, 6, 27, 22, 24}, "f35f5cc601", 0) + i3 + C0000.decode(new byte[]{27, 20, 88, 75, 25, 84, 69, 81, 0, 64, 87, 70, 17, 76, 81, 82, 89, 20, 18, 93, 72, 81, 17, 16}, "24189374a4") + i + strDecode);
        }
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{88, 23, 91, 88, 74, 92}, "dc319b9a73db7cf2", false));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{19, 84, 89, 81, 10, 15}, "a575ebdd81075315", 6));
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException(C0000.decode(new byte[]{32, 92, 71, 15, 77, 16, 11, 68, 86, 67, 81, 90, 94, 65, 67, 91, 83, 18, 25, 88, 5, 66, 67, 84, 89, 83, 85, 24}, "c32a90d2317616", true));
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException(C0000.decode(new byte[]{122, 12, 92, 81, 30, 65, 92, 20, 93, 70, 0, 13, 92, 21, 24, 92, 7, 18, 19, 10, 89, 68, 22, 4, 93, 7, 92, 26}, "3b84fa", 0.0f));
    }

    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsKt.listOf(t) : CollectionsKt.emptyList();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection == 0 ? CollectionsKt.emptyList() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> orEmpty(List<? extends T> list) {
        return list == 0 ? CollectionsKt.emptyList() : list;
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch((List<? extends Comparable>) list, comparable, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, obj, comparator, i, i2);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1, reason: invalid class name */
    /* JADX INFO: compiled from: Collections.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Function1<T, Integer> {

        /* JADX INFO: Incorrect field signature: TK; */
        final /* synthetic */ Comparable $key;
        final /* synthetic */ Function1<T, K> $selector;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
        public AnonymousClass1(Function1 function1, Comparable comparable) {
            this.$selector = function1;
            this.$key = comparable;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(T t) {
            return Integer.valueOf(ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t), this.$key));
        }
    }

    public static /* synthetic */ int binarySearch$default(List list, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, i, i2, function1);
    }
}
