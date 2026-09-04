package kotlin.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ah\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u00040\bH\u0087\bø\u0001\u0000\u001ai\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000622\u0010\n\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u000bj\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001`\fH\u0087\b\u001ah\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u00040\bH\u0087\bø\u0001\u0000\u001ah\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000622\u0010\n\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u000bj\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001`\fH\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"maxBy", "", "K", "V", "R", "", "", "selector", "Lkotlin/Function1;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "minBy", "minWith", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt___MapsJvmKt extends MapsKt__MapsKt {
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Map.Entry<K, V> entry;
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{4, 17, 11, 94, 70, 9}, "8ec75739dcddb7"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{16, 86, 95, 93, 84, 66, 89, 64}, "c338766246163c55", true));
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = function1.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rInvoke2 = function1.invoke(entry3);
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        entry2 = entry3;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    private static final /* synthetic */ <K, V> Map.Entry<K, V> maxWith(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{5, 18, 81, 10, 16, 8}, "9f9cc61377c6f2f2", 0.0f));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{6, 92, 11, 21, 82, 23, 84, 23, 10, 65}, "e3fe3e5c"));
        return (Map.Entry) CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Map.Entry<K, V> entry;
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{4, 17, 94, 8, 67, 13}, "8e6a034d21ad8135", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{65, 7, 85, 1, 90, 18, 90, 22}, "2b9d9f5d", 7));
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = function1.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rInvoke2 = function1.invoke(entry3);
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        entry2 = entry3;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Map.Entry minWith(Map map, Comparator comparator) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{94, 23, 89, 80, 65, 8}, "bc192629", true));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{6, 90, 8, 65, 89, 71, 87, 66, 12, 68}, "e5e18566c6cde8", 6));
        return (Map.Entry) CollectionsKt.minWithOrNull(map.entrySet(), comparator);
    }
}
