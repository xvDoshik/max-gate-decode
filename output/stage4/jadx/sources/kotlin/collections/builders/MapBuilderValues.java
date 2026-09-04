package kotlin.collections.builders;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MapBuilderValues extends AbstractCollection implements Collection {
    public final MapBuilder backing;

    public MapBuilderValues(MapBuilder mapBuilder) {
        this.backing = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.backing.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        MapBuilder mapBuilder = this.backing;
        mapBuilder.getClass();
        return new MapBuilder.KeysItr(mapBuilder, 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        MapBuilder mapBuilder = this.backing;
        mapBuilder.checkIsMutable$kotlin_stdlib();
        int i2 = mapBuilder.length;
        while (true) {
            i = -1;
            i2--;
            if (i2 >= 0) {
                if (mapBuilder.presenceArray[i2] >= 0 && Intrinsics.areEqual(mapBuilder.valuesArray[i2], obj)) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        if (i < 0) {
            return false;
        }
        mapBuilder.removeKeyAt(i);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.backing.size;
    }
}
