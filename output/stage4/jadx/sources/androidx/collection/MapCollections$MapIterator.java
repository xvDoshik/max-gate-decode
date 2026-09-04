package androidx.collection;

import androidx.work.WorkRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MapCollections$MapIterator implements Iterator, Map.Entry {
    public int mEnd;
    public boolean mEntryValid = false;
    public int mIndex = -1;
    public final /* synthetic */ WorkRequest.Builder this$0;

    public MapCollections$MapIterator(WorkRequest.Builder builder) {
        this.this$0 = builder;
        this.mEnd = builder.colGetSize() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.mEntryValid) {
            throw new IllegalStateException(C0000.decode(new byte[]{101, 13, 93, 21, 68, 1, 12, 94, 21, 81, 88, 11, 81, 20, 68, 6, 12, 85, 18, 16, 95, 10, 64, 70, 23, 23, 19, 64, 14, 66, 69, 69, 70, 3, 16, 3, 10, 94, 8, 94, 86, 69, 121, 7, 20, 76, 38, 94, 21, 66, 72, 69, 91, 4, 14, 7, 0, 68, 18}, "1e4fdbc0a0", 0.0f));
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.mIndex;
        WorkRequest.Builder builder = this.this$0;
        Object objColGetEntry = builder.colGetEntry(i, 0);
        if (key != objColGetEntry && (key == null || !key.equals(objColGetEntry))) {
            return false;
        }
        Object value = entry.getValue();
        Object objColGetEntry2 = builder.colGetEntry(this.mIndex, 1);
        return value == objColGetEntry2 || (value != null && value.equals(objColGetEntry2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.mEntryValid) {
            throw new IllegalStateException(C0000.decode(new byte[]{48, 92, 13, 71, 17, 0, 89, 10, 21, 5, 92, 86, 0, 19, 68, 80, 11, 81, 66, 67, 88, 11, 21, 68, 70, 77, 21, 17, 11, 70, 16, 20, 67, 6, 66, 5, 8, 10, 92, 86, 2, 65, 41, 85, 20, 26, 116, 13, 66, 22, 24, 68, 90, 90, 15, 4, 7, 64, 23}, "d4d41c6dad58ea", 0.0f));
        }
        return this.this$0.colGetEntry(this.mIndex, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.mEntryValid) {
            throw new IllegalStateException(C0000.decode(new byte[]{54, 88, 89, 67, 17, 80, 90, 87, 23, 88, 89, 15, 92, 19, 66, 84, 95, 85, 66, 19, 91, 86, 23, 25, 67, 20, 73, 17, 13, 66, 68, 16, 67, 86, 65, 88, 10, 87, 89, 15, 94, 65, 47, 81, 64, 30, 116, 93, 65, 75, 26, 25, 95, 3, 83, 4, 1, 68, 67}, "b0001359c90a9a", 0.0f));
        }
        return this.this$0.colGetEntry(this.mIndex, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.mIndex < this.mEnd;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.mEntryValid) {
            throw new IllegalStateException(C0000.decode(new byte[]{100, 80, 13, 17, 22, 82, 12, 15, 69, 2, 13, 90, 85, 74, 68, 6, 89, 84, 16, 65, 95, 12, 16, 20, 67, 77, 20, 18, 89, 67, 23, 65, 67, 6, 16, 85, 89, 86, 13, 12, 81, 17, 46, 0, 65, 77, 33, 90, 68, 74, 29, 66, 89, 83, 9, 4, 82, 23, 23}, "08db61ca1cd4"));
        }
        int i = this.mIndex;
        WorkRequest.Builder builder = this.this$0;
        Object objColGetEntry = builder.colGetEntry(i, 0);
        Object objColGetEntry2 = builder.colGetEntry(this.mIndex, 1);
        return (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 != null ? objColGetEntry2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.mIndex++;
        this.mEntryValid = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.mEntryValid) {
            throw new IllegalStateException();
        }
        this.this$0.colRemoveAt(this.mIndex);
        this.mIndex--;
        this.mEnd--;
        this.mEntryValid = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.mEntryValid) {
            return this.this$0.colSetValue(this.mIndex, obj);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{54, 93, 8, 75, 67, 2, 9, 10, 22, 84, 8, 86, 6, 19, 70, 0, 13, 80, 18, 24, 13, 14, 18, 68, 17, 64, 17, 72, 12, 19, 18, 68, 16, 80, 21, 89, 10, 15, 15, 10, 5, 21, 44, 89, 19, 79, 35, 10, 22, 71, 24, 24, 12, 3, 12, 1, 1, 65, 18}, "b5a8cafd", 0.0f));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(C0000.decode(new byte[]{89}, "d5544c9ddb"));
        sb.append(getValue());
        return sb.toString();
    }
}
