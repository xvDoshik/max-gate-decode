package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\t\u001aX\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0007¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{9, 66, 13, 12, 75, 90}, "56ee8d4be2ed", 1));
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException(C0000.decode(new byte[]{122, 84, 27, 65}, "11baa1605f98", true) + k + C0000.decode(new byte[]{24, 90, 64, 23, 95, 8, 16, 66, 81, 93, 84, 23, 91, 15, 67, 69, 80, 86, 19, 90, 83, 17, 77}, "83372ac1", 3));
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{88, 22, 92, 92, 22, 12}, "db45e285", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{1, 83, 80, 82, 64, 10, 21, 98, 80, 14, 19, 85}, "e6635fa41bf05189", 0.0f));
        return map instanceof MapWithDefault ? MapsKt.withDefault(((MapWithDefault) map).getMap(), function1) : new MapWithDefaultImpl(map, function1);
    }

    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{12, 71, 13, 91, 70, 9}, "03e257f623", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{93, 81, 7, 82, 77, 94, 77, 98, 0, 95, 77, 87}, "94a382", 0));
        return map instanceof MutableMapWithDefault ? MapsKt.withDefaultMutable(((MutableMapWithDefault) map).getMap(), function1) : new MutableMapWithDefaultImpl(map, function1);
    }
}
