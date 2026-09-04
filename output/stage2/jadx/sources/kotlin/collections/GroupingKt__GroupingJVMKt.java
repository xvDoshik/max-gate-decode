package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> grouping) {
        Intrinsics.checkNotNullParameter(grouping, C0000.decode(new byte[]{94, 65, 9, 12, 70, 15}, "b5ae51", 6));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            K kKeyOf = grouping.keyOf(itSourceIterator.next());
            Object intRef = linkedHashMap.get(kKeyOf);
            if (intRef == null && !linkedHashMap.containsKey(kKeyOf)) {
                intRef = new Ref.IntRef();
            }
            Ref.IntRef intRef2 = (Ref.IntRef) intRef;
            intRef2.element++;
            linkedHashMap.put(kKeyOf, intRef2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Intrinsics.checkNotNull(entry, C0000.decode(new byte[]{93, 22, 93, 15, 17, 87, 5, 93, 88, 92, 71, 67, 83, 6, 17, 87, 5, 64, 66, 19, 71, 12, 17, 13, 94, 90, 73, 93, 67, 95, 95, 67, 69, 26, 65, 81, 68, 88, 89, 71, 95, 10, 95, 77, 82, 91, 8, 95, 83, 80, 71, 10, 94, 13, 66, 26, 41, 70, 66, 82, 81, 15, 84, 46, 80, 68, 74, 126, 67, 71, 82, 1, 93, 6, 116, 90, 16, 65, 79, 15, 120, 67, 94, 5, 17, 95, 11, 71, 90, 90, 93, 77, 82, 12, 93, 88, 1, 80, 66, 90, 92, 13, 66, 77, 118, 70, 11, 70, 70, 90, 93, 4, 122, 23, 110, 107, 35, 65, 89, 70, 67, 10, 95, 4, 123, 98, 41, 120, 66, 29, 94, 2, 65, 53, 80, 88, 17, 86, 69, 122, 93, 51, 93, 2, 82, 81, 72, 19, 100, 19, 92, 5, 17, 8, 94, 64, 8, 90, 88, 29, 80, 12, 93, 15, 84, 87, 16, 90, 89, 93, 64, 77, 118, 17, 94, 65, 20, 90, 88, 84, 120, 23, 110, 60, 118, 70, 11, 70, 70, 90, 93, 4, 123, 53, 124, ByteCompanionObject.MAX_VALUE, 16, 29, 91, 82, 67, 53, 80, 15, 68, 81, 23, 122, 88, 99, 95, 2, 82, 6, 15}, "3c1c14d363", 0.0f));
            TypeIntrinsics.asMutableMapEntry(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return TypeIntrinsics.asMutableMap(linkedHashMap);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{4, 76, 88, 89, 17, 93}, "8800bc1ee877ad7d", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{81}, "7d830c", 0.0f));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Intrinsics.checkNotNull(entry, C0000.decode(new byte[]{91, 16, 95, 88, 19, 2, 5, 93, 13, 12, 69, 25, 87, 0, 19, 87, 82, 18, 16, 19, 23, 12, 17, 87, 90, 11, 30, 90, 70, 13, 8, 19, 23, 26, 65, 92, 21, 14, 92, 64, 95, 8, 10, 29, 0, 12, 93, 85, 80, 6, 71, 93, 92, 15, 23, 29, 46, 22, 69, 88, 87, 9, 86, 121, 82, 17, 74, 126, 22, 23, 80, 91, 89, 0, 118, 90, 71, 19, 29, 15, 40, 67, 94, 95, 21, 14, 92, 64, 95, 8, 10, 29, 0, 12, 93, 85, 80, 6, 71, 93, 92, 15, 23, 29, 36, 17, 94, 76, 69, 12, 93, 83, 120, 21, 59, 108, 36, 17, 94, 76, 69, 12, 93, 83, 121, 55, 41, 120, 23, 77, 92, 88, 69, 51, 82, 88, 70, 4, 23, 122, 13, 51, 93, 88, 86, 0, 31, 20, 97, 65, 11, 85, 67, 8, 94, 77, 89, 12, 93, 26, 80, 14, 8, 95, 6, 0, 69, 80, 90, 11, 64, 26, 116, 19, 11, 70, 19, 10, 95, 94, 126, 17, 108, 107, 116, 19, 11, 70, 19, 10, 95, 94, ByteCompanionObject.MAX_VALUE, 51, 126, ByteCompanionObject.MAX_VALUE, 71, 79, 9, 82, 19, 53, 80, 85, 64, 0, 64, 125, 93, 49, 8, 82, 0, 6, 15}, "5e343ad3cc19"));
            TypeIntrinsics.asMutableMapEntry(entry).setValue(function1.invoke(entry));
        }
        return TypeIntrinsics.asMutableMap(map);
    }
}
