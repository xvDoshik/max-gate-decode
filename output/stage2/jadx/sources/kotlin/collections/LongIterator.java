package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/LongIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Long;", "nextLong", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LongIterator implements Iterator<Long>, KMappedMarker {
    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 69, 83, 20, 88, 77, 13, 12, 88, 66, 91, 16, 25, 8, 9, 77, 68, 70, 67, 22, 73, 86, 22, 23, 83, 6, 18, 5, 86, 20, 70, 75, 1, 84, 82, 75, 86, 87, 8, 26, 22, 1, 93, 15, 85, 3, 5, 77, 13, 90, 88}, "d56f99dc6b2c9ff9", 0));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
