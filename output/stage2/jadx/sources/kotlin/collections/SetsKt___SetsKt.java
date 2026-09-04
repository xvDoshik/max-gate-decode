package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{89, 16, 9, 95, 66, 13}, "eda613ed916d", 0.0f));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{7, 14, 87, 90, 81, 90, 67, 68}, "bb27447753049e", true));
        Collection<?> collectionConvertToListIfNotCollection = CollectionsKt.convertToListIfNotCollection(iterable);
        if (collectionConvertToListIfNotCollection.isEmpty()) {
            return CollectionsKt.toSet(set);
        }
        if (!(collectionConvertToListIfNotCollection instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionConvertToListIfNotCollection);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t : set) {
            if (!((Set) collectionConvertToListIfNotCollection).contains(t)) {
                linkedHashSet2.add(t);
            }
        }
        return linkedHashSet2;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{93, 65, 11, 94, 75, 9}, "a5c7870a695a", 0.0f));
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{12, 16, 91, 89, 66, 9}, "0d3017", false));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{4, 94, 82, 12, 85, 10, 71, 70}, "a27a0d355fc198", 5));
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt.removeAll(linkedHashSet, sequence);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, T[] tArr) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{12, 68, 80, 81, 65, 93}, "00882c7270", 3));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{93, 92, 82, 92, 84, 11, 66, 23}, "80711e6d", 4));
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt.removeAll(linkedHashSet, tArr);
        return linkedHashSet;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{13, 22, 12, 95, 21, 6}, "1bd6f877897b55f7", 4));
        return SetsKt.minus(set, t);
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> iterable) {
        int size;
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{5, 65, 9, 12, 64, 91}, "95ae3efcaa", 0));
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{87, 94, 81, 90, 7, 87, 66, 75}, "2247b96882711d37"));
        Integer numCollectionSizeOrNull = CollectionsKt.collectionSizeOrNull(iterable);
        if (numCollectionSizeOrNull != null) {
            size = set.size() + numCollectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{9, 18, 11, 93, 23, 13}, "5fc4d3e22c586c", 0.0f));
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{15, 68, 91, 80, 68, 90}, "30397d14db4d", false));
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{86, 91, 7, 9, 84, 93, 21, 17}, "37bd13abea", true));
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size() * 2));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, sequence);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T[] tArr) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{94, 64, 81, 94, 69, 7}, "b49769", false));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{81, 95, 1, 85, 81, 15, 68, 68}, "43d84a07d093f3", 0.0f));
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, tArr);
        return linkedHashSet;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{14, 67, 95, 13, 69, 9}, "277d675bc0e9"));
        return SetsKt.plus(set, t);
    }
}
