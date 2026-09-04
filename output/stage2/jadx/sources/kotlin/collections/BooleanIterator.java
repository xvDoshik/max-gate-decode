package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/BooleanIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Boolean;", "nextBoolean", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BooleanIterator implements Iterator<Boolean>, KMappedMarker {
    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 72, 87, 74, 86, 17, 80, 11, 90, 22, 8, 75, 18, 86, 88, 17, 25, 23, 65, 70, 17, 87, 64, 76, 82, 1, 25, 2, 91, 68, 65, 74, 87, 89, 83, 72, 86, 10, 88, 79, 65, 91, 93, 84, 91, 0, 90, 16, 93, 89, 15}, "a8287e9d46", false));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
