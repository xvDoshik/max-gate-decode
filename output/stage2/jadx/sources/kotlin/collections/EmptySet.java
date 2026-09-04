package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "contains", "element", "containsAll", "elements", "", "iterator", "", "readResolve", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptySet implements Set, Serializable, KMappedMarker {
    public static final EmptySet INSTANCE = new EmptySet();
    private static final long serialVersionUID = 3406603774387020532L;

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 19, 82, 70, 87, 17, 94, 86, 92, 19, 15, 67, 68, 10, 90, 23, 23, 71, 67, 21, 71, 86, 64, 71, 3, 84, 68, 2, 90, 17, 23, 70, 83, 4, 83, 20, 93, 93, 10, 73, 68, 7, 90, 15, 91, 81, 85, 17, 94, 86, 92}, "5c746e7923f0dd", 0.0f));
    }

    public boolean add(Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 19, 87, 74, 84, 66, 8, 12, 92, 24, 92, 69, 65, 13, 93, 76, 21, 69, 20, 19, 66, 87, 71, 66, 4, 7, 18, 94, 90, 68, 65, 17, 87, 89, 81, 27, 14, 13, 94, 65, 21, 85, 14, 15, 94, 93, 86, 66, 8, 12, 92}, "ac2856"));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 21, 7, 69, 88, 21, 91, 90, 11, 25, 94, 23, 70, 91, 95, 69, 65, 22, 23, 71, 73, 14, 64, 65, 0, 93, 23, 2, 9, 71, 16, 67, 4, 4, 6, 26, 86, 15, 94, 76, 69, 90, 88, 8, 10, 80, 83, 69, 8, 10, 12}, "aeb79a25e97df501", 0.0f));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 67, 3, 20, 2, 65, 88, 88, 11, 16, 15, 64, 70, 8, 12, 65, 17, 68, 16, 64, 22, 92, 20, 18, 6, 81, 17, 81, 10, 66, 70, 65, 3, 7, 7, 24, 94, 89, 9, 73, 70, 80, 9, 10, 15, 80, 82, 67, 12, 95, 8}, "f3ffc517e0", true));
    }

    public boolean contains(Void element) {
        Intrinsics.checkNotNullParameter(element, C0000.decode(new byte[]{84, 15, 87, 11, 1, 87, 77}, "1c2fd9928260", 4));
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{81, 9, 0, 95, 93, 93, 64, 22}, "4ee283"));
        return elements.isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{118, 65, 86, 69, 2, 22, 91, 92, 87, 17, 90, 68, 67, 12, 93, 71, 25, 66, 70, 71, 19, 13, 64, 71, 92, 85, 19, 81, 12, 16, 18, 65, 92, 80, 87, 26, 12, 12, 94, 74, 25, 82, 92, 91, 15, 7, 81, 71, 80, 94, 93}, "9137cb23", 7));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 66, 82, 67, 2, 22, 15, 11, 95, 22, 81, 67, 66, 12, 12, 66, 23, 65, 66, 65, 19, 13, 20, 16, 84, 82, 24, 86, 13, 16, 67, 68, 82, 83, 83, 28, 12, 12, 10, 29, 17, 85, 87, 92, 14, 7, 0, 66, 94, 93, 89}, "7271cbfd1680bbc6"));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 20, 81, 19, 83, 23, 80, 89, 91, 22, 12, 23, 69, 10, 91, 21, 18, 16, 76, 70, 69, 89, 23, 16, 0, 0, 20, 7, 93, 17, 25, 68, 80, 87, 1, 73, 10, 10, 88, 24, 18, 0, 86, 90, 89, 83, 6, 16, 12, 11, 90}, "ed4a2c9656ed", 0.0f));
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{89, 17, 16, 83, 64}, "8cb29da6cd8d07ed", true));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return C0000.decode(new byte[]{58, 104}, "a549085dab2a30", false);
    }

    private EmptySet() {
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object other) {
        return (other instanceof Set) && ((Set) other).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
