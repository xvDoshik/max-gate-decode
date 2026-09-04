package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MapBuilder implements Map, Serializable {
    public static final MapBuilder Empty;
    public MapBuilderKeys entriesView;
    public int[] hashArray;
    public int hashShift;
    public boolean isReadOnly;
    public Object[] keysArray;
    public MapBuilderKeys keysView;
    public int length;
    public int maxProbeDistance;
    public int[] presenceArray;
    public int size;
    public Object[] valuesArray;
    public MapBuilderValues valuesView;

    public final class EntryRef implements Map.Entry {
        public final int index;
        public final MapBuilder map;

        public EntryRef(MapBuilder mapBuilder, int i) {
            this.map = mapBuilder;
            this.index = i;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.map.keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.map.valuesArray[this.index];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            MapBuilder mapBuilder = this.map;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            Object[] objArr = mapBuilder.valuesArray;
            if (objArr == null) {
                int length = mapBuilder.keysArray.length;
                if (length < 0) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{80, 3, 73, 5, 80, 10, 66, 75, 21, 95, 70, 17, 77, 68, 81, 6, 22, 92, 90, 92, 30, 12, 92, 3, 82, 23, 95, 68, 80, 28}, "3b9d3c6252", 5));
                }
                objArr = new Object[length];
                mapBuilder.valuesArray = objArr;
            }
            int i = this.index;
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    public final class KeysItr implements Iterator {
        public final /* synthetic */ int $r8$classId;
        public int index;
        public int lastIndex = -1;
        public final MapBuilder map;

        public KeysItr(MapBuilder mapBuilder, int i) {
            this.$r8$classId = i;
            this.map = mapBuilder;
            initNext$kotlin_stdlib();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.map.length;
        }

        public final void initNext$kotlin_stdlib() {
            while (true) {
                int i = this.index;
                MapBuilder mapBuilder = this.map;
                if (i >= mapBuilder.length || mapBuilder.presenceArray[i] >= 0) {
                    return;
                } else {
                    this.index = i + 1;
                }
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.index;
                    MapBuilder mapBuilder = this.map;
                    if (i >= mapBuilder.length) {
                        throw new NoSuchElementException();
                    }
                    this.index = i + 1;
                    this.lastIndex = i;
                    Object obj = mapBuilder.keysArray[i];
                    initNext$kotlin_stdlib();
                    return obj;
                case 1:
                    int i2 = this.index;
                    MapBuilder mapBuilder2 = this.map;
                    if (i2 >= mapBuilder2.length) {
                        throw new NoSuchElementException();
                    }
                    this.index = i2 + 1;
                    this.lastIndex = i2;
                    EntryRef entryRef = new EntryRef(mapBuilder2, i2);
                    initNext$kotlin_stdlib();
                    return entryRef;
                default:
                    int i3 = this.index;
                    MapBuilder mapBuilder3 = this.map;
                    if (i3 >= mapBuilder3.length) {
                        throw new NoSuchElementException();
                    }
                    this.index = i3 + 1;
                    this.lastIndex = i3;
                    Object obj2 = mapBuilder3.valuesArray[i3];
                    initNext$kotlin_stdlib();
                    return obj2;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.lastIndex == -1) {
                throw new IllegalStateException(C0000.decode(new byte[]{32, 85, 13, 14, 17, 86, 0, 64, 65, 76, 74, 20, 3, 7, 87, 87, 23, 93, 21, 22, 6, 89, 14, 20, 88, 86, 2, 24, 80, 8, 6, 89, 4, 12, 69, 24, 3, 74, 90, 9, 67, 64, 9, 7, 17, 81, 17, 93, 71, 5, 23, 91, 19, 76}, "c4ab18e85d", true));
            }
            MapBuilder mapBuilder = this.map;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            mapBuilder.removeKeyAt(this.lastIndex);
            this.lastIndex = -1;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{91, 88, 17, 81, 87, 10, 76, 27, 68, 9, 68, 64, 76, 25, 3, 85, 20, 13, 87, 12, 73, 10, 84, 84, 89, 77, 8, 70, 81, 77}, "89a04c8bdd13", 0.0f));
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.keysArray = objArr;
        this.valuesArray = null;
        this.presenceArray = iArr;
        this.hashArray = new int[iHighestOneBit];
        this.maxProbeDistance = 2;
        this.length = 0;
        this.hashShift = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int addKey$kotlin_stdlib(Object obj) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iHash = hash(obj);
            int i = this.maxProbeDistance * 2;
            int length = this.hashArray.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.hashArray;
                int i3 = iArr[iHash];
                if (i3 <= 0) {
                    int i4 = this.length;
                    Object[] objArr = this.keysArray;
                    if (i4 >= objArr.length) {
                        ensureExtraCapacity(1);
                        break;
                    }
                    int i5 = i4 + 1;
                    this.length = i5;
                    objArr[i4] = obj;
                    this.presenceArray[i4] = iHash;
                    iArr[iHash] = i5;
                    this.size++;
                    if (i2 > this.maxProbeDistance) {
                        this.maxProbeDistance = i2;
                    }
                    return i4;
                }
                if (Intrinsics.areEqual(this.keysArray[i3 - 1], obj)) {
                    return -i3;
                }
                i2++;
                if (i2 > i) {
                    rehash(this.hashArray.length * 2);
                    break;
                }
                iHash = iHash == 0 ? this.hashArray.length - 1 : iHash - 1;
            }
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        int i;
        checkIsMutable$kotlin_stdlib();
        boolean z = true;
        IntRange intRange = new IntRange(0, this.length - 1, 1);
        int i2 = intRange.last;
        int i3 = intRange.step;
        if (i3 <= 0 ? i2 > 0 : i2 < 0) {
            z = false;
        }
        int i4 = z ? 0 : i2;
        while (z) {
            if (i4 != i2) {
                i = i4 + i3;
            } else {
                if (!z) {
                    throw new NoSuchElementException();
                }
                z = false;
                i = i4;
            }
            int[] iArr = this.presenceArray;
            int i5 = iArr[i4];
            if (i5 >= 0) {
                this.hashArray[i5] = 0;
                iArr[i4] = -1;
            }
            i4 = i;
        }
        ResultKt.resetRange(this.keysArray, 0, this.length);
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            ResultKt.resetRange(objArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        int i;
        int i2 = this.length;
        while (true) {
            i = -1;
            i2--;
            if (i2 >= 0) {
                if (this.presenceArray[i2] >= 0 && Intrinsics.areEqual(this.valuesArray[i2], obj)) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        return i >= 0;
    }

    public final void ensureExtraCapacity(int i) {
        Object[] objArr = this.keysArray;
        int length = objArr.length;
        int i2 = this.length;
        int i3 = length - i2;
        int i4 = i2 - this.size;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            rehash(this.hashArray.length);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = (objArr.length * 3) / 2;
            if (i5 <= length2) {
                i5 = length2;
            }
            this.keysArray = Arrays.copyOf(objArr, i5);
            Object[] objArr2 = this.valuesArray;
            this.valuesArray = objArr2 != null ? Arrays.copyOf(objArr2, i5) : null;
            this.presenceArray = Arrays.copyOf(this.presenceArray, i5);
            if (i5 < 1) {
                i5 = 1;
            }
            int iHighestOneBit = Integer.highestOneBit(i5 * 3);
            if (iHighestOneBit > this.hashArray.length) {
                rehash(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        MapBuilderKeys mapBuilderKeys = this.entriesView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this, 1);
        this.entriesView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        Map.Entry entry;
        int iFindKey;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.size == map.size()) {
                    Iterator it = map.entrySet().iterator();
                    do {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (next == null) {
                                break;
                            }
                            try {
                                entry = (Map.Entry) next;
                                iFindKey = findKey(entry.getKey());
                            } catch (ClassCastException unused) {
                            }
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                    } while (iFindKey < 0 ? false : Intrinsics.areEqual(this.valuesArray[iFindKey], entry.getValue()));
                    z = false;
                    if (z) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int findKey(Object obj) {
        int iHash = hash(obj);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[iHash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual(this.keysArray[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iHash = iHash == 0 ? this.hashArray.length - 1 : iHash - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        return this.valuesArray[iFindKey];
    }

    public final int hash(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    @Override // java.util.Map
    public final int hashCode() {
        KeysItr keysItr = new KeysItr(this, 1);
        int i = 0;
        while (keysItr.hasNext()) {
            int i2 = keysItr.index;
            MapBuilder mapBuilder = keysItr.map;
            if (i2 >= mapBuilder.length) {
                throw new NoSuchElementException();
            }
            keysItr.index = i2 + 1;
            keysItr.lastIndex = i2;
            Object obj = mapBuilder.keysArray[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object obj2 = mapBuilder.valuesArray[keysItr.lastIndex];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            keysItr.initNext$kotlin_stdlib();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        MapBuilderKeys mapBuilderKeys = this.keysView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this, 0);
        this.keysView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(obj);
        Object[] objArr = this.valuesArray;
        if (objArr == null) {
            int length = this.keysArray.length;
            if (length < 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{2, 83, 20, 83, 1, 15, 23, 77, 21, 8, 64, 66, 21, 18, 6, 87, 66, 8, 12, 90, 24, 11, 80, 86, 0, 70, 13, 68, 7, 72}, "a2d2bfc45e51", 4));
            }
            objArr = new Object[length];
            this.valuesArray = objArr;
        }
        if (iAddKey$kotlin_stdlib >= 0) {
            objArr[iAddKey$kotlin_stdlib] = obj2;
            return null;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        ensureExtraCapacity(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
            Object[] objArr = this.valuesArray;
            if (objArr == null) {
                int length = this.keysArray.length;
                if (length < 0) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{5, 85, 71, 88, 91, 90, 77, 77, 25, 9, 65, 71, 18, 20, 85, 92, 24, 93, 86, 90, 20, 10, 81, 83, 7, 64, 94, 79, 93, 29}, "f47983949d44", true));
                }
                objArr = new Object[length];
                this.valuesArray = objArr;
            }
            if (iAddKey$kotlin_stdlib >= 0) {
                objArr[iAddKey$kotlin_stdlib] = entry.getValue();
            } else {
                int i = (-iAddKey$kotlin_stdlib) - 1;
                if (!Intrinsics.areEqual(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    public final void rehash(int i) {
        int[] iArr;
        int i2;
        int i3 = 0;
        if (this.length > this.size) {
            Object[] objArr = this.valuesArray;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i2 = this.length;
                if (i4 >= i2) {
                    break;
                }
                if (this.presenceArray[i4] >= 0) {
                    Object[] objArr2 = this.keysArray;
                    objArr2[i5] = objArr2[i4];
                    if (objArr != null) {
                        objArr[i5] = objArr[i4];
                    }
                    i5++;
                }
                i4++;
            }
            ResultKt.resetRange(this.keysArray, i5, i2);
            if (objArr != null) {
                ResultKt.resetRange(objArr, i5, this.length);
            }
            this.length = i5;
        }
        int[] iArr2 = this.hashArray;
        if (i != iArr2.length) {
            this.hashArray = new int[i];
            this.hashShift = Integer.numberOfLeadingZeros(i) + 1;
        } else {
            Arrays.fill(iArr2, 0, iArr2.length, 0);
        }
        while (i3 < this.length) {
            int i6 = i3 + 1;
            int iHash = hash(this.keysArray[i3]);
            int i7 = this.maxProbeDistance;
            while (true) {
                iArr = this.hashArray;
                if (iArr[iHash] == 0) {
                    break;
                }
                i7--;
                if (i7 < 0) {
                    throw new IllegalStateException(C0000.decode(new byte[]{53, 90, 95, 21, 25, 87, 88, 90, 15, 93, 66, 70, 81, 85, 73, 68, 4, 92, 22, 17, 80, 64, 81, 20, 7, 91, 78, 3, 93, 20, 84, 85, 6, 91, 85, 70, 84, 65, 85, 64, 8, 66, 90, 15, 92, 70, 25, 85, 15, 86, 22, 1, 75, 91, 78, 25, 14, 92, 90, 31, 25, 92, 88, 71, 9, 18, 87, 20, 75, 85, 64, 26, 65, 122, 87, 16, 92, 20, 86, 86, 11, 87, 85, 18, 25, 92, 88, 71, 9, 113, 89, 2, 92, 71, 25, 87, 9, 83, 88, 1, 92, 80, 6}, "a26f9494"));
                }
                iHash = iHash == 0 ? iArr.length - 1 : iHash - 1;
            }
            iArr[iHash] = i6;
            this.presenceArray[i3] = iHash;
            i3 = i6;
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            iFindKey = -1;
        } else {
            removeKeyAt(iFindKey);
        }
        if (iFindKey < 0) {
            return null;
        }
        Object[] objArr = this.valuesArray;
        Object obj2 = objArr[iFindKey];
        objArr[iFindKey] = null;
        return obj2;
    }

    public final void removeKeyAt(int i) {
        this.keysArray[i] = null;
        int length = this.presenceArray[i];
        int i2 = this.maxProbeDistance * 2;
        int length2 = this.hashArray.length / 2;
        if (i2 > length2) {
            i2 = length2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = length;
        do {
            length = length == 0 ? this.hashArray.length - 1 : length - 1;
            i4++;
            if (i4 > this.maxProbeDistance) {
                this.hashArray[i5] = 0;
            } else {
                int[] iArr = this.hashArray;
                int i6 = iArr[length];
                if (i6 == 0) {
                    iArr[i5] = 0;
                } else {
                    if (i6 < 0) {
                        iArr[i5] = -1;
                    } else {
                        int i7 = i6 - 1;
                        int iHash = hash(this.keysArray[i7]) - length;
                        int[] iArr2 = this.hashArray;
                        if ((iHash & (iArr2.length - 1)) >= i4) {
                            iArr2[i5] = i6;
                            this.presenceArray[i7] = i5;
                        }
                        i3--;
                    }
                    i5 = length;
                    i4 = 0;
                    i3--;
                }
            }
            this.presenceArray[i] = -1;
            this.size--;
        } while (i3 >= 0);
        this.hashArray[i5] = -1;
        this.presenceArray[i] = -1;
        this.size--;
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.size * 3) + 2);
        sb.append(C0000.decode(new byte[]{72}, "3bcafa7bdc", 0.0f));
        KeysItr keysItr = new KeysItr(this, 1);
        int i = 0;
        while (keysItr.hasNext()) {
            if (i > 0) {
                sb.append(C0000.decode(new byte[]{29, 69}, "1e7428bb10c1"));
            }
            int i2 = keysItr.index;
            MapBuilder mapBuilder = keysItr.map;
            if (i2 >= mapBuilder.length) {
                throw new NoSuchElementException();
            }
            keysItr.index = i2 + 1;
            keysItr.lastIndex = i2;
            Object obj = mapBuilder.keysArray[i2];
            boolean zAreEqual = Intrinsics.areEqual(obj, mapBuilder);
            String strDecode = C0000.decode(new byte[]{78, 77, 89, 90, 21, 24, 127, 3, 66, 30}, "f913f82b27ef010f", false);
            if (zAreEqual) {
                sb.append(strDecode);
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object obj2 = mapBuilder.valuesArray[keysItr.lastIndex];
            if (Intrinsics.areEqual(obj2, mapBuilder)) {
                sb.append(strDecode);
            } else {
                sb.append(obj2);
            }
            keysItr.initNext$kotlin_stdlib();
            i++;
        }
        sb.append(C0000.decode(new byte[]{24}, "efa2a7", 7));
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        MapBuilderValues mapBuilderValues = this.valuesView;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues mapBuilderValues2 = new MapBuilderValues(this);
        this.valuesView = mapBuilderValues2;
        return mapBuilderValues2;
    }
}
