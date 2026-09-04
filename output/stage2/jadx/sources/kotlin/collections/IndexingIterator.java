package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0086\u0002J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "<init>", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
    private int index;
    private final Iterator<T> iterator;

    /* JADX WARN: Multi-variable type inference failed */
    public IndexingIterator(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, C0000.decode(new byte[]{15, 68, 80, 70, 80, 64, 14, 74}, "f05414a8860d", 2));
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{44, 21, 82, 74, 5, 68, 81, 88, 13, 69, 94, 75, 68, 94, 87, 67, 67, 22, 66, 72, 20, 95, 74, 67, 6, 1, 23, 94, 11, 66, 24, 69, 6, 4, 83, 21, 11, 94, 84, 78, 67, 6, 88, 84, 8, 85, 91, 67, 10, 10, 89}, "ce78d087", 0.0f));
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public final IndexedValue<T> next() {
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            CollectionsKt.throwIndexOverflow();
        }
        return new IndexedValue<>(i, this.iterator.next());
    }
}
