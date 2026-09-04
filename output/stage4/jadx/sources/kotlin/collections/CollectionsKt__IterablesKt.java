package kotlin.collections;

import java.util.Collection;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    public static int collectionSizeOrDefault(Iterable iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
