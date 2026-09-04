package androidx.collection;

import androidx.work.WorkRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MapCollections$KeySet implements Set {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ WorkRequest.Builder this$0;

    public /* synthetic */ MapCollections$KeySet(WorkRequest.Builder builder, int i) {
        this.$r8$classId = i;
        this.this$0 = builder;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                WorkRequest.Builder builder = this.this$0;
                int iColGetSize = builder.colGetSize();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    builder.colPut(entry.getKey(), entry.getValue());
                }
                return iColGetSize != builder.colGetSize();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                this.this$0.colClear();
                break;
            default:
                this.this$0.colClear();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return this.this$0.colIndexOfKey(obj) >= 0;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                WorkRequest.Builder builder = this.this$0;
                int iColIndexOfKey = builder.colIndexOfKey(key);
                if (iColIndexOfKey < 0) {
                    return false;
                }
                Object objColGetEntry = builder.colGetEntry(iColIndexOfKey, 1);
                Object value = entry.getValue();
                return objColGetEntry == value || (objColGetEntry != null && objColGetEntry.equals(value));
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                Map mapColGetMap = this.this$0.colGetMap();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!mapColGetMap.containsKey(it.next())) {
                        return false;
                    }
                }
                return true;
            default:
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!contains(it2.next())) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return WorkRequest.Builder.equalsSetHelper(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.$r8$classId) {
            case 0:
                WorkRequest.Builder builder = this.this$0;
                int iHashCode = 0;
                for (int iColGetSize = builder.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                    Object objColGetEntry = builder.colGetEntry(iColGetSize, 0);
                    iHashCode += objColGetEntry == null ? 0 : objColGetEntry.hashCode();
                }
                return iHashCode;
            default:
                WorkRequest.Builder builder2 = this.this$0;
                int iHashCode2 = 0;
                for (int iColGetSize2 = builder2.colGetSize() - 1; iColGetSize2 >= 0; iColGetSize2--) {
                    Object objColGetEntry2 = builder2.colGetEntry(iColGetSize2, 0);
                    Object objColGetEntry3 = builder2.colGetEntry(iColGetSize2, 1);
                    iHashCode2 += (objColGetEntry2 == null ? 0 : objColGetEntry2.hashCode()) ^ (objColGetEntry3 == null ? 0 : objColGetEntry3.hashCode());
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return this.this$0.colGetSize() == 0;
            default:
                return this.this$0.colGetSize() == 0;
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new MapCollections$ArrayIterator(this.this$0, 0);
            default:
                return new MapCollections$MapIterator(this.this$0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                WorkRequest.Builder builder = this.this$0;
                int iColIndexOfKey = builder.colIndexOfKey(obj);
                if (iColIndexOfKey < 0) {
                    return false;
                }
                builder.colRemoveAt(iColIndexOfKey);
                return true;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                Map mapColGetMap = this.this$0.colGetMap();
                int size = mapColGetMap.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    mapColGetMap.remove(it.next());
                }
                return size != mapColGetMap.size();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                Map mapColGetMap = this.this$0.colGetMap();
                int size = mapColGetMap.size();
                Iterator it = mapColGetMap.keySet().iterator();
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                    }
                }
                return size != mapColGetMap.size();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.this$0.colGetSize();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.$r8$classId) {
            case 0:
                WorkRequest.Builder builder = this.this$0;
                int iColGetSize = builder.colGetSize();
                Object[] objArr = new Object[iColGetSize];
                for (int i = 0; i < iColGetSize; i++) {
                    objArr[i] = builder.colGetEntry(i, 0);
                }
                return objArr;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.$r8$classId) {
            case 0:
                return this.this$0.toArrayHelper(objArr, 0);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
