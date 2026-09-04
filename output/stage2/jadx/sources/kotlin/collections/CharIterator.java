package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\f\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lkotlin/collections/CharIterator;", "", "", "<init>", "()V", "next", "()Ljava/lang/Character;", "nextChar", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CharIterator implements Iterator<Character>, KMappedMarker {
    public abstract char nextChar();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 68, 1, 17, 2, 66, 94, 90, 13, 65, 88, 68, 20, 12, 10, 64, 68, 16, 22, 70, 71, 90, 17, 21, 84, 83, 20, 4, 10, 70, 68, 17, 6, 87, 83, 24, 12, 15, 93, 78, 20, 1, 10, 88, 8, 6, 0, 66, 94, 90, 13}, "e4dcc675ca174b", true));
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(nextChar());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Character next() {
        return Character.valueOf(nextChar());
    }
}
