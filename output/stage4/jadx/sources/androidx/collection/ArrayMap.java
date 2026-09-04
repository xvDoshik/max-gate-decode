package androidx.collection;

import androidx.work.WorkRequest;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ArrayMap extends SimpleArrayMap implements Map {
    public AnonymousClass1 mCollections;

    /* JADX INFO: renamed from: androidx.collection.ArrayMap$1, reason: invalid class name */
    public final class AnonymousClass1 extends WorkRequest.Builder {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.work.WorkRequest.Builder
        public final void colClear() {
            switch (this.$r8$classId) {
                case 0:
                    ((ArrayMap) this.this$0).clear();
                    break;
                default:
                    ((ArraySet) this.this$0).clear();
                    break;
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final Object colGetEntry(int i, int i2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).mArray[(i << 1) + i2];
                default:
                    return ((ArraySet) this.this$0).mArray[i];
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final Map colGetMap() {
            switch (this.$r8$classId) {
                case 0:
                    return (ArrayMap) this.this$0;
                default:
                    throw new UnsupportedOperationException(C0000.decode(new byte[]{92, 9, 18, 68, 87, 23, 11, 0, 22}, "2ffd67faf1917f", 3));
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final int colGetSize() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).mSize;
                default:
                    return ((ArraySet) this.this$0).mSize;
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final int colIndexOfKey(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ArrayMap arrayMap = (ArrayMap) this.this$0;
                    return obj == null ? arrayMap.indexOfNull() : arrayMap.indexOf(obj.hashCode(), obj);
                default:
                    ArraySet arraySet = (ArraySet) this.this$0;
                    return obj == null ? arraySet.indexOfNull() : arraySet.indexOf(obj.hashCode(), obj);
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final int colIndexOfValue(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).indexOfValue(obj);
                default:
                    ArraySet arraySet = (ArraySet) this.this$0;
                    return obj == null ? arraySet.indexOfNull() : arraySet.indexOf(obj.hashCode(), obj);
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final void colPut(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    ((ArrayMap) this.this$0).put(obj, obj2);
                    break;
                default:
                    ((ArraySet) this.this$0).add(obj);
                    break;
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final void colRemoveAt(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ((ArrayMap) this.this$0).removeAt(i);
                    break;
                default:
                    ((ArraySet) this.this$0).removeAt(i);
                    break;
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final Object colSetValue(int i, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i2 = (i << 1) + 1;
                    Object[] objArr = ((ArrayMap) this.this$0).mArray;
                    Object obj2 = objArr[i2];
                    objArr[i2] = obj;
                    return obj2;
                default:
                    throw new UnsupportedOperationException(C0000.decode(new byte[]{10, 91, 66, 65, 3, 19, 88, 88, 68}, "d46ab3594c9b", 3));
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1(0, this);
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (((MapCollections$KeySet) anonymousClass1.id) == null) {
            anonymousClass1.id = new MapCollections$KeySet(anonymousClass1, 1);
        }
        return (MapCollections$KeySet) anonymousClass1.id;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1(0, this);
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (((MapCollections$KeySet) anonymousClass1.workSpec) == null) {
            anonymousClass1.workSpec = new MapCollections$KeySet(anonymousClass1, 0);
        }
        return (MapCollections$KeySet) anonymousClass1.workSpec;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.mSize;
        int i = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < size) {
            Object[] objArr = this.mArray;
            allocArrays(size);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i);
                System.arraycopy(objArr, 0, this.mArray, 0, i << 1);
            }
            SimpleArrayMap.freeArrays(iArr, objArr, i);
        }
        if (this.mSize != i) {
            throw new ConcurrentModificationException();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1(0, this);
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (((MapCollections$ValuesCollection) anonymousClass1.tags) == null) {
            anonymousClass1.tags = new MapCollections$ValuesCollection(anonymousClass1);
        }
        return (MapCollections$ValuesCollection) anonymousClass1.tags;
    }
}
