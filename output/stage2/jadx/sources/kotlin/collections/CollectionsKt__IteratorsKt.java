package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a\"\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a0\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"iterator", "", "T", "withIndex", "Lkotlin/collections/IndexedValue;", "forEach", "", "operation", "Lkotlin/Function1;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    public static final <T> void forEach(Iterator<? extends T> it, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(it, C0000.decode(new byte[]{11, 77, 92, 90, 22, 13}, "7943e3ad6b6913", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{88, 22, 92, 67, 0, 77, 8, 13, 89}, "7f91a9ab7d54", true));
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterator<T> iterator(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, C0000.decode(new byte[]{95, 67, 90, 8, 21, 14}, "c72af0d4b1", 1));
        return it;
    }

    public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, C0000.decode(new byte[]{15, 23, 92, 8, 18, 13}, "3c4aa385905d"));
        return new IndexingIterator(it);
    }
}
