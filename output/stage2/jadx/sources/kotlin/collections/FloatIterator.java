package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/FloatIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Float;", "nextFloat", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FloatIterator implements Iterator<Float>, KMappedMarker {
    public abstract float nextFloat();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 17, 1, 68, 82, 18, 12, 14, 88, 24, 81, 75, 24, 15, 11, 66, 19, 21, 16, 17, 70, 87, 74, 76, 93, 5, 68, 80, 92, 20, 69, 19, 83, 89, 92, 21, 87, 15, 8, 79, 19, 5, 10, 13, 90, 93, 91, 76, 81, 14, 10}, "8ad63fea6888", true));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Float next() {
        return Float.valueOf(nextFloat());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Float next() {
        return Float.valueOf(nextFloat());
    }
}
