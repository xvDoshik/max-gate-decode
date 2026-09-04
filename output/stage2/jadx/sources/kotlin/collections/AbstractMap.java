package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\b'\u0018\u0000 **\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001*B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020!H\u0016J\u001c\u0010 \u001a\u00020!2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002J#\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010)R\u0014\u0010\u0018\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lkotlin/collections/AbstractMap;", "K", "V", "", "<init>", "()V", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "", "isEmpty", "size", "getSize", "()I", "keys", "", "getKeys", "()Ljava/util/Set;", "_keys", "toString", "", "o", "values", "", "getValues", "()Ljava/util/Collection;", "_values", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    private final String toString(Object o) {
        return o == this ? C0000.decode(new byte[]{74, 22, 95, 91, 18, 65, 123, 5, 21, 25}, "bb72aa6de017", 0.0f) : String.valueOf(o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$2(AbstractMap abstractMap, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, C0000.decode(new byte[]{15, 76}, "f8e6fcab5da7a914", false));
        return abstractMap.toString(entry);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 72, 81, 17, 87, 18, 8, 13, 90, 23, 80, 21, 21, 12, 92, 71, 21, 75, 65, 19, 70, 9, 19, 22, 81, 83, 25, 0, 90, 16, 19, 65, 80, 89, 80, 78, 89, 8, 13, 27, 20, 84, 86, 10, 89, 7, 80, 71, 92, 87, 90}, "584c6fab479f5b33", false));
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        AbstractMap<K, V> abstractMap = this;
        Intrinsics.checkNotNull(abstractMap, C0000.decode(new byte[]{10, 64, 88, 94, 16, 91, 87, 91, 13, 89, 71, 68, 87, 93, 68, 86, 85, 65, 68, 24, 66, 90, 67, 88, 92, 10, 24, 86, 17, 89, 88, 18, 68, 65, 70, 80, 67, 93, 92, 16, 89, 81, 10, 27, 87, 93, 92, 84, 83, 86, 23, 95, 92, 10, 70, 22, 41, 84, 68, 14, 123, 24, 89, 83, 67, 93, 92, 16, 89, 81, 10, 27, 87, 93, 92, 84, 83, 86, 23, 95, 92, 10, 70, 22, 41, 84, 68, 65, 123, 76, 105, 106, 46, 87, 67, 23, 126, 76, 74, 82, 81, 70, 28, 24, 96, 21, 12, 80, 19, 15, 90, 76, 8, 92, 90, 28, 83, 87, 90, 89, 6, 85, 71, 13, 90, 86, 23, 27, 121, 83, 64, 75, 125, 65, 60, 105, 126, 5, 69, 75, 47, 65, 26, 85, 85, 76, 8}, "d5420865c63d58"));
        V v = abstractMap.get(key);
        if (!Intrinsics.areEqual(value, v)) {
            return false;
        }
        if (v != null) {
            return true;
        }
        Intrinsics.checkNotNull(abstractMap, C0000.decode(new byte[]{15, 69, 85, 88, 69, 83, 3, 92, 87, 9, 21, 16, 91, 81, 69, 83, 3, 65, 77, 70, 21, 95, 25, 90, 10, 94, 79, 92, 76, 10, 13, 16, 77, 77, 21, 85, 66, 89, 86, 18, 13, 89, 87, 26, 6, 95, 14, 94, 92, 5, 21, 89, 86, 90, 22, 30, 47, 83, 73, 90, 42, 16, 86, 82, 69, 91, 13, 70, 85, 15, 15, 30, 90, 91, 9, 92, 7, 81, 77, 15, 14, 94, 74, 26, 40, 81, 18, 65, 114, 18, 62, 111, 116, 85, 21, 67, 41, 70, 23, 5, 14, 94, 77, 85, 12, 94, 17, 121, 92, 31, 77, 16, 19, 10}, "a094e0b29f"));
        return abstractMap.containsKey(key);
    }

    public abstract Set<Map.Entry<K, V>> getEntries();

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 69, 0, 22, 7, 18, 8, 11, 90, 20, 15, 68, 17, 94, 90, 67, 17, 70, 16, 20, 22, 9, 19, 16, 81, 80, 70, 81, 94, 66, 21, 69, 84, 84, 1, 73, 9, 8, 13, 29, 20, 87, 9, 91, 93, 85, 86, 67, 88, 90, 11}, "15edffad44f71057", 4));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 64, 85, 22, 0, 66, 92, 93, 10, 24, 90, 67, 22, 13, 93, 22, 24, 67, 69, 20, 17, 89, 71, 70, 1, 92, 19, 86, 89, 17, 18, 16, 93, 81, 84, 73, 14, 88, 89, 75, 68, 91, 92, 92, 90, 6, 81, 22, 81, 95, 94}, "800da652d8306c2b", 7));
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 64, 86, 66, 3, 69, 10, 86, 90, 65, 10, 16, 67, 90, 94, 18, 17, 67, 70, 64, 18, 94, 17, 77, 81, 5, 67, 5, 12, 70, 17, 20, 84, 81, 87, 29, 13, 95, 15, 64, 20, 2, 12, 15, 15, 81, 82, 18, 88, 95, 93}, "1030b1c94accc41f", 0.0f));
    }

    public String toString() {
        return CollectionsKt.joinToString$default(entrySet(), C0000.decode(new byte[]{31, 68}, "3d25f4"), C0000.decode(new byte[]{75}, "062e582c44", 0), C0000.decode(new byte[]{69}, "86a4f2eac295", 0.0f), 0, null, new Function1() { // from class: kotlin.collections.AbstractMap$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AbstractMap.toString$lambda$2(this.f$0, (Map.Entry) obj);
            }
        }, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    protected AbstractMap() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return implFindEntry(key) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        Set<Map.Entry<K, V>> setEntrySet = entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((Map.Entry) it.next()).getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Map)) {
            return false;
        }
        Map map = (Map) other;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (!containsEntry$kotlin_stdlib((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        Map.Entry<K, V> entryImplFindEntry = implFindEntry(key);
        if (entryImplFindEntry != null) {
            return entryImplFindEntry.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public int getSize() {
        return entrySet().size();
    }

    public Set<K> getKeys() {
        if (this._keys == null) {
            this._keys = new AbstractSet<K>(this) { // from class: kotlin.collections.AbstractMap$keys$1
                final /* synthetic */ AbstractMap<K, V> this$0;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.this$0 = this;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public boolean contains(Object element) {
                    return this.this$0.containsKey(element);
                }

                @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<K> iterator() {
                    return new AbstractMap$keys$1$iterator$1(this.this$0.entrySet().iterator());
                }

                @Override // kotlin.collections.AbstractCollection
                /* JADX INFO: renamed from: getSize */
                public int get_size() {
                    return this.this$0.size();
                }
            };
        }
        Set<? extends K> set = this._keys;
        Intrinsics.checkNotNull(set);
        return set;
    }

    private final String toString(Map.Entry<? extends K, ? extends V> entry) {
        return toString(entry.getKey()) + '=' + toString(entry.getValue());
    }

    public Collection<V> getValues() {
        if (this._values == null) {
            this._values = new AbstractCollection<V>(this) { // from class: kotlin.collections.AbstractMap.values.1
                final /* synthetic */ AbstractMap<K, V> this$0;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.this$0 = this;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public boolean contains(Object element) {
                    return this.this$0.containsValue(element);
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<V> iterator() {
                    return new AbstractMap$values$1$iterator$1(this.this$0.entrySet().iterator());
                }

                @Override // kotlin.collections.AbstractCollection
                /* JADX INFO: renamed from: getSize */
                public int get_size() {
                    return this.this$0.size();
                }
            };
        }
        Collection<? extends V> collection = this._values;
        Intrinsics.checkNotNull(collection);
        return collection;
    }

    private final Map.Entry<K, V> implFindEntry(K key) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Map.Entry) next).getKey(), key)) {
                return (Map.Entry) next;
            }
        }
        next = null;
        return (Map.Entry) next;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0000¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0000¢\u0006\u0002\b\u000bJ'\u0010\f\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "<init>", "()V", "entryHashCode", "", "e", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "entryEquals", "", "other", "entryEquals$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> e, Object other) {
            Intrinsics.checkNotNullParameter(e, C0000.decode(new byte[]{6}, "c4a9b318", false));
            if (!(other instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) other;
            return Intrinsics.areEqual(e.getKey(), entry.getKey()) && Intrinsics.areEqual(e.getValue(), entry.getValue());
        }

        public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> e) {
            Intrinsics.checkNotNullParameter(e, C0000.decode(new byte[]{7}, "b2d142e4cc"));
            Object key = e.getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = e.getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> e) {
            Intrinsics.checkNotNullParameter(e, C0000.decode(new byte[]{83}, "699c52", 4));
            return new StringBuilder().append(e.getKey()).append('=').append(e.getValue()).toString();
        }

        private Companion() {
        }
    }
}
