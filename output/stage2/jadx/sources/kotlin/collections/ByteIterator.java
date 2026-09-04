package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0005\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/ByteIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Byte;", "nextByte", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ByteIterator implements Iterator<Byte>, KMappedMarker {
    public abstract byte nextByte();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 68, 82, 17, 88, 16, 13, 14, 87, 17, 95, 75, 22, 13, 11, 68, 70, 71, 66, 19, 73, 11, 22, 21, 92, 85, 22, 94, 89, 17, 68, 66, 3, 85, 83, 78, 86, 10, 8, 24, 25, 82, 89, 84, 90, 6, 7, 68, 15, 91, 89}, "f47c9dda91686cd0", 3));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }
}
