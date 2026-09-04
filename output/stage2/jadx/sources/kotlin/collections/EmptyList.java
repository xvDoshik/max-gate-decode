package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0011\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\u0011\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0096\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0096\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u000eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "contains", "element", "containsAll", "elements", "", "get", "index", "indexOf", "lastIndexOf", "iterator", "", "listIterator", "", "subList", "fromIndex", "toIndex", "readResolve", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyList implements List, Serializable, RandomAccess, KMappedMarker {
    public static final EmptyList INSTANCE = new EmptyList();
    private static final long serialVersionUID = -7390468764508069838L;

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 65, 0, 75, 84, 76, 95, 86, 15, 16, 10, 18, 24, 8, 90, 76, 21, 66, 16, 73, 69, 87, 68, 77, 4, 84, 67, 7, 87, 20, 21, 74, 80, 80, 1, 20, 90, 86, 90, 64, 65, 83, 12, 13, 84, 3, 86, 76, 92, 94, 11}, "51e95869a0ca8f58", false));
    }

    public void add(int i, Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 71, 4, 70, 85, 64, 94, 13, 10, 68, 80, 18, 18, 91, 95, 67, 65, 71, 65, 68, 71, 13, 22, 16, 92, 5, 18, 83, 95, 69, 65, 70, 81, 85, 83, 79, 11, 10, 85, 24, 18, 86, 95, 91, 13, 81, 87, 64, 94, 13, 10}, "07a4447bdd9a25", 6));
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 17, 0, 71, 89, 23, 12, 94, 90, 16, 88, 23, 70, 8, 13, 21, 69, 70, 77, 19, 21, 94, 70, 68, 84, 0, 70, 0, 13, 19, 69, 71, 93, 2, 1, 28, 91, 94, 93, 29, 70, 5, 13, 13, 9, 80, 91, 23, 12, 94, 90}, "bae58ce1401dff", 0.0f));
    }

    public boolean add(Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 21, 7, 65, 85, 65, 15, 93, 94, 69, 11, 64, 20, 91, 9, 70, 16, 22, 23, 67, 68, 90, 20, 70, 85, 1, 66, 85, 91, 71, 70, 64, 85, 4, 6, 30, 91, 91, 10, 75, 16, 6, 13, 95, 88, 80, 5, 70, 89, 10, 12}, "0eb345f2", 0.0f));
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 67, 6, 66, 84, 16, 89, 88, 87, 17, 92, 64, 67, 94, 90, 16, 16, 68, 76, 65, 69, 92, 17, 68, 80, 0, 16, 81, 86, 67, 21, 65, 6, 81, 81, 73, 95, 89, 85, 72, 21, 80, 12, 92, 89, 1, 83, 67, 80, 94, 91}, "53c05d0791", 0.0f));
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 72, 7, 20, 5, 22, 10, 95, 95, 19, 13, 71, 20, 86, 13, 18, 68, 17, 22, 64, 65, 92, 22, 64, 81, 92, 66, 0, 11, 16, 67, 66, 84, 82, 0, 25, 91, 86, 14, 31, 68, 1, 12, 92, 93, 86, 7, 64, 93, 87, 12}, "48bfdbc013d4", 7));
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 20, 4, 65, 83, 68, 95, 95, 12, 68, 95, 23, 65, 93, 93, 68, 22, 67, 23, 20, 70, 11, 19, 71, 87, 84, 22, 86, 13, 22, 22, 22, 4, 82, 86, 29, 89, 94, 14, 29, 22, 7, 14, 95, 94, 85, 85, 68, 11, 11, 88}, "6da32060bd", true));
    }

    public boolean contains(Void element) {
        Intrinsics.checkNotNullParameter(element, C0000.decode(new byte[]{0, 89, 3, 88, 6, 95, 21}, "e5f5c1abbeb6", 3));
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{4, 8, 6, 93, 1, 94, 71, 67}, "adc0d030bf5f", 0.0f));
        return elements.isEmpty();
    }

    @Override // java.util.List
    public Void get(int index) {
        throw new IndexOutOfBoundsException(C0000.decode(new byte[]{125, 8, 67, 21, 79, 21, 84, 12, 64, 21, 22, 81, 87, 0, 64, 15, 17, 65, 24, 6, 92, 15, 66, 84, 81, 11, 19, 4, 90, 80, 85, 0, 93, 21, 22, 84, 76, 69, 90, 15, 82, 80, 64, 69}, "8e3a65", 1) + index + '.');
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    public int indexOf(Void element) {
        Intrinsics.checkNotNullParameter(element, C0000.decode(new byte[]{92, 13, 80, 11, 93, 15, 21}, "9a5f8aac"));
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    public int lastIndexOf(Void element) {
        Intrinsics.checkNotNullParameter(element, C0000.decode(new byte[]{1, 95, 83, 15, 1, 91, 16}, "d36bd5", 2));
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator(int index) {
        if (index == 0) {
            return EmptyIterator.INSTANCE;
        }
        throw new IndexOutOfBoundsException(C0000.decode(new byte[]{44, 90, 92, 87, 75, 88, 24}, "e4823b863751", 6) + index);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 70, 3, 68, 85, 65, 15, 9, 15, 17, 93, 22, 16, 93, 86, 16, 16, 69, 19, 70, 68, 90, 20, 18, 4, 85, 20, 3, 95, 65, 25, 22, 85, 87, 2, 27, 91, 91, 10, 31, 65, 82, 91, 9, 92, 86, 90, 16, 89, 89, 8}, "06f645ffa14e039d", 0.0f));
    }

    @Override // java.util.List
    public Void remove(int i) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 20, 4, 68, 4, 69, 92, 11, 15, 22, 12, 66, 21, 10, 14, 66, 69, 66, 64, 20, 17, 89, 23, 69, 80, 0, 65, 80, 10, 67, 21, 22, 4, 87, 1, 28, 90, 10, 13, 79, 69, 82, 90, 8, 13, 83, 6, 69, 92, 11, 15}, "5da6e1", false));
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 67, 3, 23, 7, 69, 15, 92, 8, 69, 15, 66, 70, 93, 9, 17, 70, 66, 19, 67, 22, 10, 20, 69, 3, 87, 70, 3, 9, 67, 70, 65, 3, 4, 2, 28, 9, 93, 10, 28, 70, 82, 9, 95, 10, 0, 5, 69, 15, 92, 8}, "f3fef1", true));
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 70, 81, 69, 88, 22, 81, 13, 88, 22, 10, 21, 25, 89, 11, 66, 20, 68, 76, 18, 72, 13, 68, 66, 6, 2, 25, 81, 11, 68, 20, 69, 92, 3, 92, 79, 89, 88, 15, 31, 25, 84, 11, 90, 88, 82, 90, 22, 81, 13, 88}, "d6479b8b66cf97"));
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 73, 80, 20, 82, 71, 90, 91, 12, 16, 94, 74, 21, 8, 92, 71, 19, 71, 23, 64, 71, 86, 71, 18, 86, 87, 19, 82, 13, 66, 23, 75, 80, 7, 87, 30, 92, 90, 14, 73, 23, 90, 90, 10, 95, 86, 80, 64, 11, 95, 89}, "795f3334b0", 0.0f));
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 64, 84, 68, 88, 70, 95, 92, 87, 25, 15, 66, 25, 92, 9, 68, 17, 69, 76, 66, 70, 92, 75, 77, 3, 85, 25, 84, 9, 66, 17, 68, 92, 83, 82, 30, 86, 87, 10, 72, 25, 81, 9, 92, 93, 83, 90, 70, 95, 92, 87}, "f016926399f192", 4));
    }

    public Void set(int i, Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 17, 92, 22, 81, 66, 15, 93, 11, 65, 80, 23, 16, 88, 9, 70, 69, 18, 76, 20, 64, 89, 20, 70, 0, 5, 25, 2, 95, 68, 70, 64, 0, 0, 93, 73, 95, 88, 10, 75, 69, 2, 86, 8, 92, 83, 5, 70, 12, 14, 87}, "ea9d06f2", 0.0f));
    }

    @Override // java.util.List
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex == 0 && toIndex == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(C0000.decode(new byte[]{82, 75, 12, 8, 124, 89, 80, 92, 27, 95, 21}, "49ce57") + fromIndex + C0000.decode(new byte[]{26, 16, 68, 89, 113, 13, 86, 92, 78, 10, 16}, "60068c29", 1) + toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{89, 69, 65, 83, 64}, "87329d", 0));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return C0000.decode(new byte[]{105, 104}, "25d905", true);
    }

    private EmptyList() {
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        return (other instanceof List) && ((List) other).isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
