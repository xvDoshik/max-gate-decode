package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/IntIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Integer;", "nextInt", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IntIterator implements Iterator<Integer>, KMappedMarker {
    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 22, 83, 65, 7, 68, 10, 92, 87, 21, 90, 18, 22, 11, 95, 18, 22, 64, 19, 64, 19, 92, 75, 65, 86, 5, 22, 3, 95, 20, 22, 65, 3, 81, 7, 30, 86, 91, 95, 24, 22, 6, 95, 10, 90, 86, 5, 68, 10, 92, 87}, "0f63f0c3953a6e", 3));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
