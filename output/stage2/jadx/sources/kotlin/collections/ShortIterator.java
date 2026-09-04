package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\n\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/ShortIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Short;", "nextShort", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ShortIterator implements Iterator<Short>, KMappedMarker {
    public abstract short nextShort();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 71, 1, 69, 0, 69, 92, 89, 88, 21, 92, 21, 18, 93, 87, 71, 23, 68, 17, 71, 17, 94, 71, 66, 83, 81, 21, 0, 93, 65, 24, 65, 82, 86, 0, 26, 14, 95, 89, 79, 22, 86, 90, 10, 94, 86, 91, 71, 94, 88, 10}, "77d7a156655f2383"));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(nextShort());
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
    public final Short next2() {
        return Short.valueOf(nextShort());
    }
}
