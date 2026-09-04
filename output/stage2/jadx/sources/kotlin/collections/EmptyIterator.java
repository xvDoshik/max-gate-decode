package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lkotlin/collections/EmptyIterator;", "", "", "<init>", "()V", "hasNext", "", "hasPrevious", "nextIndex", "", "previousIndex", "next", "previous", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyIterator implements ListIterator, KMappedMarker {
    public static final EmptyIterator INSTANCE = new EmptyIterator();

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 67, 87, 20, 83, 16, 11, 90, 11, 16, 81, 21, 17, 15, 10, 65, 21, 64, 71, 22, 66, 11, 16, 65, 0, 84, 24, 0, 94, 19, 69, 71, 80, 82, 86, 75, 93, 10, 14, 76, 69, 83, 87, 10, 93, 4, 6, 65, 92, 92, 92}, "532f2db5e08f1ae5", 6));
    }

    public void add(Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 70, 1, 22, 84, 21, 13, 89, 10, 22, 13, 23, 21, 15, 11, 66, 68, 69, 17, 20, 69, 14, 22, 66, 1, 82, 68, 2, 90, 19, 68, 68, 1, 87, 0, 73, 90, 15, 8, 79, 68, 85, 11, 8, 89, 4, 7, 66, 13, 89, 10}, "d6dd5ad6", 0.0f));
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 72, 0, 64, 0, 65, 8, 95, 95, 23, 89, 71, 67, 90, 9, 76, 69, 65, 20, 69, 17, 95, 67, 67, 85, 80, 67, 82, 9, 74, 69, 64, 4, 84, 5, 29, 94, 89, 92, 77, 67, 87, 9, 84, 9, 87, 2, 65, 8, 95, 95}, "f8e2a5a01704c4", 0.0f));
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 70, 86, 67, 87, 17, 95, 11, 87, 19, 11, 66, 23, 10, 89, 77, 21, 69, 70, 65, 70, 10, 68, 16, 92, 87, 66, 87, 88, 22, 22, 75, 80, 87, 87, 28, 89, 11, 90, 29, 25, 80, 13, 93, 91, 1, 85, 77, 92, 89, 93}, "56316e6d93b17d69", 2));
    }

    public void set(Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 64, 93, 74, 83, 66, 88, 89, 11, 23, 91, 67, 24, 86, 93, 66, 17, 69, 16, 71, 66, 95, 74, 76, 87, 82, 17, 80, 10, 69, 18, 66, 93, 89, 86, 27, 94, 88, 9, 78, 18, 83, 87, 84, 94, 83, 82, 66, 12, 88, 92}, "20882616e7", false));
    }

    private EmptyIterator() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public Void previous() {
        throw new NoSuchElementException();
    }
}
