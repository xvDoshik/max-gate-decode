package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static void addAll(ArrayList arrayList, Iterable iterable) {
        if (iterable instanceof Collection) {
            arrayList.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
    }
}
