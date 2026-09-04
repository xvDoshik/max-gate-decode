package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001a\u00020\r2\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u0006H\u0001\u001a\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001a\u00020\rH\u0001\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0001\u001a\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0012H\u0087\b\u001a\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0007\u001a&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0081\b¢\u0006\u0002\u0010\u001c\u001a4\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u00022\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0081\b¢\u0006\u0002\u0010\u001e\u001a/\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u00022\u0006\u0010 \u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0000¢\u0006\u0002\u0010!\u001a1\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\u0010%\u001a\u0011\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0081\b\u001a\u0011\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0081\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"listOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/List;", "buildListInternal", "E", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "createListBuilder", "build", "builder", "toList", "Ljava/util/Enumeration;", "shuffled", "", "random", "Ljava/util/Random;", "collectionToArray", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "checkIndexOverflow", "index", "checkCountOverflow", "count", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsJVMKt {
    public static final <E> List<E> build(List<E> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{7, 69, 12, 15, 82, 6, 66}, "e0ec6c082c", 0.0f));
        return ((ListBuilder) list).build();
    }

    private static final <E> List<E> buildListInternal(int i, Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{80, 20, 13, 84, 80, 4, 70, 37, 6, 16, 91, 14, 89}, "2ad84a4ded2a70", 0.0f));
        List listCreateListBuilder = CollectionsKt.createListBuilder(i);
        function1.invoke(listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 76, 92, 88, 87, 81, 23, 117, 1, 77, 95, 95, 10}, "f95434e4b960d9a4", 0.0f));
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        function1.invoke(listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final Object[] collectionToArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{87, 13, 93, 14, 0, 87, 16, 80, 90, 92}, "4b1be4d95260b2", false));
        return CollectionToArray.toArray(collection);
    }

    private static final <T> T[] collectionToArray(Collection<?> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{87, 94, 10, 88, 6, 84, 65, 13, 89, 90}, "41f4c75d64a6daac"));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{88, 20, 67, 86, 75}, "9f172055aa72ca94", 2));
        return (T[]) CollectionToArray.toArray(collection, tArr);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{15, 69, 91, 95, 65, 6}, "313628c5ac79", 6));
        if (z && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, C0000.decode(new byte[]{82, 12, 72, 28, 42, 86, 73, 75, 26, 76, 24}, "1c8ee0ae4b1e", 0.0f));
        return objArrCopyOf;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, C0000.decode(new byte[]{70, 15, 10, 83, 88, 81, 65, 9, 10, 120, 93, 71, 65, 78, 74, 26, 26, 29}, "5fd444"));
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{5, 68, 94, 81, 64, 9}, "9068379424b13ed2"));
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{4, 69, 81, 12, 22, 7}, "819ee9d778843063", false));
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{66, 3, 91, 80, 14, 88}, "0b54a550870b4e", 0.0f));
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }

    public static final <T> T[] terminateCollectionToArray(int i, T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{84, 74, 19, 0, 31}, "58aafe6133e922f0", true));
        if (i < tArr.length) {
            tArr[i] = null;
        }
        return tArr;
    }

    private static final <T> List<T> toList(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, C0000.decode(new byte[]{95, 21, 91, 89, 18, 6}, "ca30a8279d0553", false));
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkNotNullExpressionValue(list, C0000.decode(new byte[]{95, 80, 22, 18, 31, 23, 29, 74, 31}, "39ef793d698b85", true));
        return list;
    }

    public static final <E> List<E> createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    public static final <E> List<E> createListBuilder(int i) {
        return new ListBuilder(i);
    }

    private static final int checkIndexOverflow(int i) {
        if (i < 0) {
            CollectionsKt.throwIndexOverflow();
        }
        return i;
    }

    private static final int checkCountOverflow(int i) {
        if (i < 0) {
            CollectionsKt.throwCountOverflow();
        }
        return i;
    }
}
