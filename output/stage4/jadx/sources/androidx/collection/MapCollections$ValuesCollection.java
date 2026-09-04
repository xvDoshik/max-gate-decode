package androidx.collection;

import androidx.work.WorkRequest;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MapCollections$ValuesCollection implements Collection {
    public final /* synthetic */ WorkRequest.Builder this$0;

    public MapCollections$ValuesCollection(WorkRequest.Builder builder) {
        this.this$0 = builder;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.this$0.colClear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.this$0.colIndexOfValue(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.this$0.colGetSize() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new MapCollections$ArrayIterator(this.this$0, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        WorkRequest.Builder builder = this.this$0;
        int iColIndexOfValue = builder.colIndexOfValue(obj);
        if (iColIndexOfValue < 0) {
            return false;
        }
        builder.colRemoveAt(iColIndexOfValue);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        WorkRequest.Builder builder = this.this$0;
        int iColGetSize = builder.colGetSize();
        int i = 0;
        boolean z = false;
        while (i < iColGetSize) {
            if (collection.contains(builder.colGetEntry(i, 1))) {
                builder.colRemoveAt(i);
                i--;
                iColGetSize--;
                z = true;
            }
            i++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        WorkRequest.Builder builder = this.this$0;
        int iColGetSize = builder.colGetSize();
        int i = 0;
        boolean z = false;
        while (i < iColGetSize) {
            if (!collection.contains(builder.colGetEntry(i, 1))) {
                builder.colRemoveAt(i);
                i--;
                iColGetSize--;
                z = true;
            }
            i++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.this$0.colGetSize();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.this$0.toArrayHelper(objArr, 1);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        WorkRequest.Builder builder = this.this$0;
        int iColGetSize = builder.colGetSize();
        Object[] objArr = new Object[iColGetSize];
        for (int i = 0; i < iColGetSize; i++) {
            objArr[i] = builder.colGetEntry(i, 1);
        }
        return objArr;
    }
}
