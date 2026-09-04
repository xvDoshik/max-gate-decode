package kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlin/collections/AbstractMap$values$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbstractMap$values$1$iterator$1<V> implements Iterator<V>, KMappedMarker {
    final /* synthetic */ Iterator<Map.Entry<K, V>> $entryIterator;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 22, 92, 69, 89, 17, 92, 87, 15, 67, 90, 67, 17, 8, 86, 67, 24, 22, 64, 72, 17, 12, 65, 68, 84, 2, 25, 81, 87, 23, 21, 74, 4, 2, 87, 29, 94, 8, 85, 78, 24, 6, 90, 84, 13, 6, 80, 68, 88, 9, 87}, "1f978e58ac30", false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    AbstractMap$values$1$iterator$1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.$entryIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.$entryIterator.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((Map.Entry) this.$entryIterator.next()).getValue();
    }
}
