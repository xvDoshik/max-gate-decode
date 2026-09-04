package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0015¢\u0006\u0002\u0010\u0017J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015H\u0014¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lkotlin/collections/AbstractCollection;", "E", "", "<init>", "()V", "size", "", "getSize", "()I", "iterator", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "toString", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$2(AbstractCollection abstractCollection, Object obj) {
        return obj == abstractCollection ? C0000.decode(new byte[]{74, 67, 95, 15, 69, 24, 39, 13, 91, 95, 92, 82, 76, 15, 13, 89, 30}, "b77f68db73918f", true) : String.valueOf(obj);
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 67, 83, 22, 81, 76, 88, 9, 94, 18, 11, 65, 21, 86, 94, 71, 22, 23, 69, 72, 65, 9, 66, 70, 7, 86, 21, 94, 94, 65, 22, 22, 85, 89, 85, 75, 95, 92, 14, 75, 21, 91, 94, 95, 90, 1, 83, 76, 88, 9, 94}, "136d081f02b258"));
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 72, 3, 66, 84, 16, 10, 9, 12, 21, 81, 22, 17, 91, 90, 64, 65, 75, 19, 64, 69, 11, 17, 18, 7, 81, 24, 3, 94, 71, 21, 70, 4, 89, 2, 29, 90, 10, 15, 31, 66, 86, 87, 9, 93, 80, 86, 64, 8, 87, 8}, "a8f05dcfb58e1554", 0.0f));
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 17, 1, 19, 3, 70, 94, 10, 13, 68, 89, 71, 66, 15, 11, 21, 66, 65, 66, 21, 19, 11, 66, 64, 7, 5, 68, 7, 13, 64, 23, 23, 6, 5, 84, 25, 13, 15, 8, 24, 66, 81, 88, 9, 15, 1, 83, 64, 11, 14, 10}, "badab27ecd04", false));
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{83, 89, 4, 14, 6, 88, 66, 70}, "65acc6", true));
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

    /* JADX INFO: renamed from: getSize */
    public abstract int get_size();

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 22, 1, 66, 4, 17, 91, 91, 15, 66, 94, 69, 69, 13, 13, 68, 21, 21, 17, 64, 21, 10, 64, 64, 4, 6, 23, 80, 10, 17, 66, 66, 80, 7, 0, 29, 10, 11, 94, 77, 65, 1, 88, 90, 9, 6, 1, 68, 92, 9, 10}, "5fd0ee24ab76ecb0", 0.0f));
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 67, 82, 70, 85, 66, 88, 94, 15, 17, 81, 66, 16, 15, 13, 67, 65, 64, 66, 68, 68, 89, 67, 69, 4, 85, 24, 87, 95, 19, 66, 69, 4, 82, 83, 25, 91, 88, 93, 72, 65, 82, 87, 93, 92, 4, 1, 67, 8, 92, 89}, "a3744611a1810ab7", 0.0f));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 70, 93, 71, 7, 67, 11, 89, 86, 21, 15, 68, 66, 88, 87, 65, 70, 68, 23, 70, 72, 90, 20, 67, 7, 82, 24, 83, 9, 69, 66, 68, 93, 84, 2, 26, 13, 88, 84, 76, 70, 84, 13, 90, 84, 80, 5, 67, 11, 89, 86}, "b685f7"));
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, C0000.decode(new byte[]{89, 75, 75, 7, 29}, "899fd77a", false));
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this, C0000.decode(new byte[]{77, 68}, "adfdc8", 4), C0000.decode(new byte[]{104}, "3924cff2", false), C0000.decode(new byte[]{101}, "826fb47a8d95", true), 0, null, new Function1() { // from class: kotlin.collections.AbstractCollection$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AbstractCollection.toString$lambda$2(this.f$0, obj);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return get_size();
    }

    protected AbstractCollection() {
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        AbstractCollection<E> abstractCollection = this;
        if ((abstractCollection instanceof Collection) && abstractCollection.isEmpty()) {
            return false;
        }
        Iterator<E> it = abstractCollection.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), element)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }
}
