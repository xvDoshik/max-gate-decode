package kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlin/collections/AbstractMap$keys$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbstractMap$keys$1$iterator$1<K> implements Iterator<K>, KMappedMarker {
    final /* synthetic */ Iterator<Map.Entry<K, V>> $entryIterator;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{124, 21, 83, 23, 3, 16, 90, 10, 88, 69, 11, 23, 19, 11, 89, 17, 66, 23, 70, 21, 70, 10, 16, 16, 86, 1, 22, 3, 13, 22, 19, 23, 83, 4, 6, 73, 92, 11, 90, 28, 66, 7, 92, 9, 90, 0, 1, 16, 90, 10, 88}, "3e6ebd", 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    AbstractMap$keys$1$iterator$1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.$entryIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.$entryIterator.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        return (K) ((Map.Entry) this.$entryIterator.next()).getKey();
    }
}
