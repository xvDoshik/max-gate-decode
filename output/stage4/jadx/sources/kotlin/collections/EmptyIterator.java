package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EmptyIterator implements ListIterator {
    public static final EmptyIterator INSTANCE = new EmptyIterator();

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{44, 17, 83, 75, 83, 23, 10, 14, 88, 25, 91, 16, 67, 15, 89, 77, 18, 16, 22, 17, 70, 86, 64, 23, 6, 5, 22, 95, 93, 17, 67, 19, 83, 88, 86, 78, 12, 15, 90, 64, 18, 0, 12, 13, 90, 92, 81, 23, 10, 14, 88}, "ca692c", 0.0f));
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 70, 81, 74, 4, 17, 10, 86, 86, 19, 11, 23, 70, 13, 9, 23, 65, 69, 65, 72, 21, 10, 17, 77, 93, 87, 66, 2, 9, 17, 70, 17, 4, 87, 80, 21, 10, 11, 15, 64, 24, 80, 13, 8, 10, 6, 5, 23, 8, 89, 90}, "a648eec983bdfcfc", true));
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{124, 21, 4, 68, 85, 66, 81, 95, 93, 16, 95, 18, 66, 10, 88, 76, 19, 22, 20, 70, 68, 89, 74, 68, 86, 84, 22, 7, 13, 22, 23, 74, 86, 4, 5, 27, 91, 88, 84, 73, 19, 83, 89, 13, 14, 1, 84, 76, 90, 10, 15}, "3ea64680306abd78", 0));
    }
}
