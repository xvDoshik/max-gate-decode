package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\b\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0002\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u000b\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0007¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"reverseElementIndex", "", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "reverseIteratorIndex", "reverseIteratorIndex$CollectionsKt__ReversedViewsKt", "asReversed", "T", "", "asReversedMutable", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final <T> List<T> asReversed(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{10, 22, 9, 93, 67, 14}, "6ba40091a3", 0.0f));
        return new ReversedListReadOnly(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{93, 67, 91, 8, 70, 14}, "a73a50d061621f", true));
        return new ReversedList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        if (i < 0 || i > CollectionsKt.getLastIndex(list)) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{39, 90, 7, 95, 0, 91, 77, 25, 11, 91, 87, 82, 78, 24}, "b6b2e599b53768", 0.0f) + i + C0000.decode(new byte[]{20, 88, 23, 67, 69, 65, 86, 80, 66, 89, 95, 65, 70, 84, 12, 87, 84, 65, 111}, "45b01a", 0.0f) + new IntRange(0, CollectionsKt.getLastIndex(list)) + C0000.decode(new byte[]{62, 24}, "c62d9a5d8f58a2a5", false));
        }
        return CollectionsKt.getLastIndex(list) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        if (i < 0 || i > list.size()) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{104, 93, 70, 12, 68, 10, 91, 91, 21, 11, 95, 5, 6, 28, 69}, "825e0c455b1acde0", 0.0f) + i + C0000.decode(new byte[]{22, 84, 65, 23, 66, 67, 84, 92, 20, 13, 88, 67, 68, 88, 90, 3, 83, 67, 109}, "694d6c") + new IntRange(0, list.size()) + C0000.decode(new byte[]{109, 72}, "0f100449fb", 3));
        }
        return list.size() - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        return CollectionsKt.getLastIndex(list) - i;
    }
}
