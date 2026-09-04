package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001a\u00020\r2\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u0006H\u0001\u001a\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001a\u00020\rH\u0001\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0001\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u00022\u001a\u0010\u0016\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0017j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00182\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"setOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "buildSetInternal", "E", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "createSetBuilder", "build", "builder", "sortedSetOf", "Ljava/util/TreeSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
public class SetsKt__SetsJVMKt {
    public static final <E> Set<E> build(Set<E> set) {
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{80, 17, 10, 9, 81, 6, 69}, "2dce5c765d08cd52", false));
        return ((SetBuilder) set).build();
    }

    private static final <E> Set<E> buildSetInternal(int i, Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{82, 77, 91, 14, 85, 86, 65, 121, 7, 67, 92, 94, 87}, "082b1338d75190", 5));
        Set setCreateSetBuilder = SetsKt.createSetBuilder(i);
        function1.invoke(setCreateSetBuilder);
        return SetsKt.build(setCreateSetBuilder);
    }

    private static final <E> Set<E> buildSetInternal(Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 70, 88, 15, 6, 92, 17, 115, 87, 17, 91, 87, 8}, "f31cb9c24e28"));
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        function1.invoke(setCreateSetBuilder);
        return SetsKt.build(setCreateSetBuilder);
    }

    public static final <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(setSingleton, C0000.decode(new byte[]{22, 90, 94, 1, 14, 3, 71, 10, 94, 25, 27, 79, 75, 26}, "e30fbf3e015a", 6));
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{90, 89, 91, 18, 85, 68, 0, 68, 14, 69}, "966b46a0a786b282", 1));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{83, 95, 81, 91, 87, 15, 67, 18}, "63462a7a48fd2d", 1));
        return (TreeSet) ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }

    public static final <T> TreeSet<T> sortedSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{86, 13, 82, 85, 3, 90, 67, 67}, "3a78f470f6b236", 1));
        return (TreeSet) ArraysKt.toCollection(tArr, new TreeSet());
    }

    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static final <E> Set<E> createSetBuilder(int i) {
        return new SetBuilder(i);
    }
}
