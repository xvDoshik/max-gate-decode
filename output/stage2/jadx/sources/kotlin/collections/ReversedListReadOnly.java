package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0000\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", "", "<init>", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "iterator", "", "listIterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
class ReversedListReadOnly<T> extends AbstractList<T> {
    private final List<T> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public ReversedListReadOnly(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, C0000.decode(new byte[]{85, 81, 13, 3, 82, 4, 77, 83}, "14af5e96"));
        this.delegate = list;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* JADX INFO: renamed from: getSize */
    public int get_size() {
        return this.delegate.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        return this.delegate.get(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index));
    }

    /* JADX INFO: renamed from: kotlin.collections.ReversedListReadOnly$listIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\r\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"kotlin/collections/ReversedListReadOnly$listIterator$1", "", "delegateIterator", "getDelegateIterator", "()Ljava/util/ListIterator;", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements ListIterator<T>, KMappedMarker {
        private final ListIterator<T> delegateIterator;
        final /* synthetic */ ReversedListReadOnly<T> this$0;

        @Override // java.util.ListIterator
        public void add(T t) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 21, 85, 16, 7, 22, 15, 10, 94, 66, 15, 17, 70, 11, 95, 22, 70, 17, 19, 21, 64, 13, 20, 22, 3, 1, 16, 4, 9, 16, 70, 23, 85, 3, 2, 79, 9, 11, 92, 27, 70, 1, 9, 9, 92, 7, 5, 22, 15, 10, 94}, "fe0bfb", 0.0f));
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 64, 0, 65, 87, 67, 90, 86, 92, 24, 11, 67, 69, 93, 89, 67, 19, 74, 71, 72, 18, 95, 23, 71, 83, 83, 19, 95, 93, 74, 66, 66, 0, 82, 82, 26, 92, 87, 94, 65, 66, 83, 10, 95, 90, 82, 80, 77, 91, 87, 12}, "b0e3673928", 0.0f));
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 65, 84, 20, 83, 16, 8, 13, 90, 17, 88, 21, 18, 10, 14, 22, 20, 66, 68, 22, 66, 11, 19, 22, 81, 85, 17, 0, 93, 22, 65, 16, 81, 80, 85, 75, 93, 10, 13, 27, 20, 82, 94, 10, 94, 1, 2, 22, 93, 94, 95}, "411f2dab"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ReversedListReadOnly<? extends T> reversedListReadOnly, int i) {
            this.this$0 = reversedListReadOnly;
            this.delegateIterator = ((ReversedListReadOnly) reversedListReadOnly).delegate.listIterator(CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(reversedListReadOnly, i));
        }

        public final ListIterator<T> getDelegateIterator() {
            return this.delegateIterator;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.delegateIterator.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.delegateIterator.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.delegateIterator.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.this$0, this.delegateIterator.previousIndex());
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.delegateIterator.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.this$0, this.delegateIterator.nextIndex());
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<T> listIterator(int index) {
        return new AnonymousClass1(this, index);
    }
}
