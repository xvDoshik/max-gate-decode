package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0006\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/DoubleIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Double;", "nextDouble", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoubleIterator implements Iterator<Double>, KMappedMarker {
    public abstract double nextDouble();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 19, 6, 23, 5, 18, 88, 12, 13, 69, 13, 21, 17, 13, 12, 17, 68, 21, 68, 19, 19, 10, 22, 18, 84, 7, 67, 3, 11, 20, 17, 17, 6, 4, 0, 75, 94, 13, 15, 28, 68, 5, 94, 15, 15, 0, 7, 18, 88, 12, 13}, "1ccedf", 0.0f));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Double next() {
        return Double.valueOf(nextDouble());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Double next() {
        return Double.valueOf(nextDouble());
    }
}
