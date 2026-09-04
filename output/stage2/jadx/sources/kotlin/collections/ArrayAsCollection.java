package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0002J\u0015\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a0\u0004¢\u0006\u0002\u0010\nR\u001b\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "<init>", "([Ljava/lang/Object;Z)V", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "()Z", "size", "", "getSize", "()I", "isEmpty", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "iterator", "", "toArray", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ArrayAsCollection<T> implements Collection<T>, KMappedMarker {
    private final boolean isVarargs;
    private final T[] values;

    public ArrayAsCollection(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{79, 5, 94, 71, 86, 74}, "9d223968b5", 1));
        this.values = tArr;
        this.isVarargs = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 73, 3, 19, 4, 67, 11, 11, 13, 19, 15, 74, 70, 15, 10, 67, 66, 23, 22, 67, 22, 86, 20, 21, 0, 83, 66, 2, 12, 65, 70, 75, 3, 0, 1, 26, 13, 10, 15, 74, 70, 90, 9, 13, 9, 82, 1, 16, 10, 92, 8}, "f9fae7bdc3", false));
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{118, 67, 93, 75, 85, 23, 91, 88, 88, 22, 92, 66, 25, 93, 87, 77, 20, 16, 71, 71, 70, 89, 71, 69, 92, 87, 24, 95, 91, 17, 18, 69, 83, 87, 81, 28, 86, 93, 84, 64, 20, 0, 93, 91, 90, 83, 86, 69, 80, 92, 86}, "93894c276651", 6));
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{118, 19, 6, 67, 85, 22, 80, 12, 13, 17, 93, 17, 25, 13, 12, 69, 20, 17, 76, 19, 19, 94, 70, 22, 92, 7, 67, 87, 91, 16, 25, 17, 6, 80, 80, 79, 86, 13, 15, 72, 20, 1, 86, 15, 15, 84, 87, 22, 80, 12, 13}, "9cc14b", true));
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{0, 89, 92, 11, 6, 95, 17, 70}, "e59fc1"));
        Collection<?> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 66, 87, 66, 5, 68, 15, 89, 86, 18, 91, 67, 68, 94, 9, 66, 24, 65, 71, 64, 20, 95, 20, 66, 93, 86, 18, 86, 11, 66, 70, 68, 93, 83, 86, 29, 11, 94, 10, 79, 24, 81, 93, 92, 8, 85, 5, 66, 81, 93, 92}, "8220d0f6", true));
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 68, 4, 66, 83, 77, 15, 13, 11, 25, 13, 71, 70, 90, 14, 68, 18, 74, 19, 18, 21, 86, 22, 64, 3, 80, 65, 86, 93, 75, 70, 16, 0, 88, 0, 25, 9, 90, 13, 73, 18, 90, 9, 14, 9, 92, 7, 64, 15, 91, 15}, "f4a029fbe9d4"));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{120, 68, 4, 65, 88, 16, 94, 11, 13, 24, 94, 71, 65, 93, 86, 16, 23, 23, 22, 72, 71, 91, 19, 71, 92, 0, 23, 2, 12, 74, 23, 70, 4, 82, 93, 73, 88, 10, 15, 65, 23, 87, 14, 95, 85, 1, 84, 16, 10, 87, 89}, "74a39d7dc8", 5));
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{7, 65, 74, 82, 64}, "f3839a785315fbd7"));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public final T[] getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: isVarargs, reason: from getter */
    public final boolean getIsVarargs() {
        return this.isVarargs;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.values.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.values.length == 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        return ArraysKt.contains(this.values, element);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return ArrayIteratorKt.iterator(this.values);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionsKt.copyToArrayOfAny(this.values, this.isVarargs);
    }
}
