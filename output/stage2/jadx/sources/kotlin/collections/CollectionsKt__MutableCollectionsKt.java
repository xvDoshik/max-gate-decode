package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0006\u001a.\u0010\u0007\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0087\b\u001a.\u0010\n\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0087\b\u001a(\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\r\u001a)\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000eH\u0087\n\u001a.\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0087\n¢\u0006\u0002\u0010\u0010\u001a)\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\n\u001a(\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\r\u001a)\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000eH\u0087\n\u001a.\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0087\n¢\u0006\u0002\u0010\u0010\u001a)\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\n\u001a&\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\u001a&\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\u001a-\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000f¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000eH\u0000\u001a&\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\u001a&\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\u001a-\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000f¢\u0006\u0002\u0010\u0014\u001a&\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\u001a-\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000f¢\u0006\u0002\u0010\u0014\u001a&\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0002\b\u0017\u001a*\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001a\u001a*\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001a\u001a9\u0010\u001b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u001d\u001a&\u0010\u0000\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0087\b¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0007¢\u0006\u0002\u0010#\u001a\u001f\u0010$\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0007¢\u0006\u0002\u0010#\u001a\u001d\u0010%\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0007¢\u0006\u0002\u0010#\u001a\u001f\u0010&\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0007¢\u0006\u0002\u0010#\u001a*\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001a\u001a*\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001a\u001a9\u0010\u001b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u001d¨\u0006'"}, d2 = {"remove", "", "T", "Lkotlin/internal/OnlyInputTypes;", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "removeAll", "elements", "", "retainAll", "plusAssign", "", "(Ljava/util/Collection;Ljava/lang/Object;)V", "", "", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/Sequence;", "minusAssign", "addAll", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "convertToListIfNotCollection", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "", "predicate", "Lkotlin/Function1;", "filterInPlace", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{15, 22, 14, 92, 69, 14}, "3bf56059776b8ec6", 1));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{81, 95, 82, 89, 84, 89, 68, 16}, "4374170c85ceb17d"));
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{89, 65, 10, 81, 75, 11}, "e5b885c2", 5));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{80, 95, 93, 84, 4, 93, 18, 69}, "5389a3f6d6d4", true));
        Iterator<? extends T> it = sequence.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{89, 66, 12, 8, 67, 13}, "e6da03fa", false));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{85, 88, 3, 93, 86, 88, 68, 71}, "04f036"));
        return collection.addAll(ArraysKt.asList(tArr));
    }

    public static final <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{89, 23, 91, 91, 66, 90}, "ec321dd475"));
        return iterable instanceof Collection ? (Collection) iterable : CollectionsKt.toList(iterable);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            Intrinsics.checkNotNull(list, C0000.decode(new byte[]{94, 67, 9, 95, 24, 6, 83, 91, 13, 14, 77, 16, 82, 83, 69, 80, 89, 22, 70, 21, 23, 14, 25, 94, 95, 88, 72, 93, 77, 9, 94, 21, 23, 24, 73, 85, 16, 93, 10, 71, 84, 12, 92, 27, 0, 14, 85, 92, 85, 85, 17, 90, 87, 11, 65, 27, 46, 20, 77, 81, 82, 90, 0, 122, 76, 0, 64, 84, 1, 13, 92, 12, 100, 22, 10, 85, 24, 14, 93, 65, 15, 8, 87, 30, 83, 89, 9, 95, 93, 6, 70, 92, 12, 15, 74, 30, 115, 89, 9, 95, 93, 6, 70, 92, 12, 15, 74, 123, 68, 105, 58, 126, 77, 17, 83, 87, 15, 4, 122, 95, 92, 90, 0, 80, 76, 12, 93, 91, 16, 42, 77, 30, 86, 95, 9, 71, 93, 23, 123, 91, 51, 13, 88, 83, 85, 8}, "06e38e25ca90", 0.0f));
            return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, z);
        }
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                T t = list.get(i2);
                if (function1.invoke(t).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, t);
                    }
                    i++;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex2 = CollectionsKt.getLastIndex(list);
        if (i > lastIndex2) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i) {
                return true;
            }
            lastIndex2--;
        }
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{15, 76, 81, 89, 74, 90}, "38909d38921458", false));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{0, 90, 83, 93, 92, 12, 65, 75}, "e6609b58"));
        CollectionsKt.removeAll(collection, iterable);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{90, 65, 13, 10, 68, 15}, "f5ec719b", false));
        collection.remove(t);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{4, 21, 9, 89, 18, 13}, "8aa0a33a41", 0.0f));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{1, 93, 93, 91, 93, 8, 64, 16}, "d1868f4c", true));
        CollectionsKt.removeAll(collection, sequence);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{10, 77, 14, 15, 65, 10}, "69ff246fe3b3", false));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{4, 93, 7, 90, 93, 86, 77, 65}, "a1b7889204", false));
        CollectionsKt.removeAll(collection, tArr);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{95, 22, 11, 91, 66, 90}, "cbc21da455a9", false));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{81, 93, 3, 89, 87, 89, 65, 71}, "41f42754d01ecf", 1));
        CollectionsKt.addAll(collection, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void plusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{11, 68, 80, 12, 75, 92}, "708e8b31b6c22b65", 0.0f));
        collection.add(t);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{15, 22, 80, 12, 69, 88}, "3b8e6f", 3));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{6, 10, 6, 84, 80, 8, 23, 21}, "cfc95f"));
        CollectionsKt.addAll(collection, sequence);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{13, 70, 13, 90, 18, 11}, "12e3a5e6cb26", false));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{82, 10, 7, 92, 84, 93, 21, 74}, "7fb113a9401096", 0.0f));
        CollectionsKt.addAll(collection, tArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    private static final <T> T remove(List<T> list, int i) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{12, 16, 91, 10, 75, 11}, "0d3c85", true));
        return list.remove(i);
    }

    private static final <T> boolean remove(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{14, 16, 95, 11, 68, 93}, "2d7b7ca8802a"));
        return TypeIntrinsics.asMutableCollection(collection).remove(t);
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{8, 76, 80, 90, 22, 92}, "4883eb"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{68, 20, 84, 5, 80, 83, 82, 70, 81}, "4f1a903248ff7eee", 0.0f));
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) function1, true);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{8, 76, 91, 93, 70, 12}, "483452e7f51e", true));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{4, 94, 7, 89, 81, 8, 76, 74}, "a2b44f89b6", 0.0f));
        return collection.removeAll(CollectionsKt.convertToListIfNotCollection(iterable));
    }

    private static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{8, 68, 88, 15, 16, 10}, "400fc4dd96001d75", true));
        Intrinsics.checkNotNullParameter(collection2, C0000.decode(new byte[]{7, 84, 82, 15, 86, 91, 16, 64}, "b87b35d3904e", 1));
        return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{90, 70, 90, 81, 71, 10}, "f22844d197", false));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{93, 15, 81, 84, 4, 10, 77, 22}, "8c49ad9e7d9f", 0.0f));
        List list = SequencesKt.toList(sequence);
        return !list.isEmpty() && collection.removeAll(list);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{93, 68, 90, 88, 66, 12}, "a02112d390af86d3", 2));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{84, 88, 87, 8, 7, 92, 67, 74}, "142eb279b903"));
        return !(tArr.length == 0) && collection.removeAll(ArraysKt.asList(tArr));
    }

    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{94, 68, 11, 10, 22, 12}, "b0cce2fc455527", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{67, 75, 87, 82, 92, 2, 89, 66, 86}, "39265a86", false));
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) function1, true);
    }

    public static final <T> T removeFirst(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{94, 23, 95, 89, 65, 10}, "bc7024e5443f", false));
        if (list.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{41, 8, 69, 66, 16, 8, 66, 24, 0, 92, 71, 16, 28, 79}, "ea660a18e17d", 0.0f));
        }
        return list.remove(0);
    }

    public static final <T> T removeFirstOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{13, 22, 12, 92, 23, 8}, "1bd5d6cf0bfa372b", 5));
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static final <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{93, 67, 81, 11, 18, 7}, "a79ba9ba2c1a"));
        if (list.isEmpty()) {
            throw new NoSuchElementException(C0000.decode(new byte[]{116, 80, 75, 66, 25, 95, 70, 68, 0, 89, 68, 76, 73, 26}, "8986965de44804", true));
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    public static final <T> T removeLastOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{12, 23, 94, 13, 68, 91}, "0c6d7e7da5", 2));
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    public static final <T> boolean retainAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{4, 65, 13, 81, 65, 9}, "85e82738a5", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{72, 69, 85, 93, 91, 81, 86, 66, 93}, "870922768a1dd48a"));
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) function1, false);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{5, 21, 13, 93, 74, 14}, "9ae490", 3));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{93, 92, 85, 11, 0, 90, 66, 18}, "800fe46a", 0.0f));
        return collection.retainAll(CollectionsKt.convertToListIfNotCollection(iterable));
    }

    private static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{95, 16, 95, 15, 66, 7}, "cd7f19b5", 7));
        Intrinsics.checkNotNullParameter(collection2, C0000.decode(new byte[]{86, 92, 1, 8, 83, 90, 64, 22}, "30de644ef84137a4", 0.0f));
        return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{5, 21, 80, 88, 66, 88}, "9a811fc872c8258e", 0.0f));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{80, 91, 7, 95, 81, 95, 65, 65}, "57b24152699e6f", true));
        List list = SequencesKt.toList(sequence);
        return !list.isEmpty() ? collection.retainAll(list) : retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{12, 17, 89, 91, 75, 9}, "0e1287a31c4241"));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{86, 92, 83, 93, 6, 87, 71, 67}, "3060c9", 0.0f));
        return !(tArr.length == 0) ? collection.retainAll(ArraysKt.asList(tArr)) : retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    public static final <T> boolean retainAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{5, 69, 94, 93, 71, 11}, "9164452a26b101", 3));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{68, 69, 7, 6, 93, 0, 86, 64, 0}, "47bb4c74e15a", true));
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) function1, false);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }
}
