package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B>\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0015\u0010\u001b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010 J\u0015\u0010,\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R&\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010$¨\u0006-"}, d2 = {"Lkotlin/collections/MapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MapWithDefault;", "map", "", "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getMap", "()Ljava/util/Map;", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "keys", "", "getKeys", "()Ljava/util/Set;", "values", "", "getValues", "()Ljava/util/Collection;", "entries", "", "getEntries", "getOrImplicitDefault", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MapWithDefaultImpl<K, V> implements MapWithDefault<K, V> {
    private final Function1<K, V> default;
    private final Map<K, V> map;

    /* JADX WARN: Multi-variable type inference failed */
    public MapWithDefaultImpl(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{91, 81, 73}, "6094a4854518", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{85, 80, 82, 83, 77, 90, 64}, "15428642182e", 0.0f));
        this.map = map;
        this.default = function1;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 21, 85, 75, 85, 21, 12, 87, 93, 17, 88, 69, 17, 92, 89, 66, 16, 22, 69, 73, 68, 14, 23, 76, 86, 85, 17, 80, 94, 64, 22, 68, 85, 4, 84, 20, 91, 15, 9, 65, 19, 82, 94, 90, 93, 87, 85, 66, 89, 10, 94}, "0e094ae831161266", false));
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 18, 80, 69, 84, 21, 88, 10, 88, 66, 92, 68, 21, 15, 94, 17, 22, 17, 64, 71, 69, 14, 67, 17, 83, 6, 21, 81, 90, 19, 17, 23, 83, 3, 81, 26, 90, 15, 93, 28, 22, 1, 90, 91, 89, 4, 82, 17, 95, 13, 91}, "6b575a1e"));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 18, 82, 66, 83, 69, 12, 9, 10, 68, 93, 17, 23, 94, 93, 69, 69, 21, 17, 20, 68, 13, 69, 68, 87, 85, 69, 0, 11, 22, 20, 16, 82, 81, 86, 28, 10, 8, 8, 29, 20, 1, 88, 92, 94, 84, 6, 18, 13, 11, 90}, "4b7021efdd", false));
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{44, 22, 87, 16, 83, 71, 92, 9, 13, 70, 91, 17, 18, 93, 90, 18, 67, 21, 71, 18, 66, 92, 71, 18, 6, 2, 18, 4, 93, 65, 21, 20, 6, 7, 86, 79, 93, 93, 89, 31, 67, 5, 93, 14, 94, 86, 86, 18, 10, 9, 92}, "cf2b235f", 0.0f));
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // kotlin.collections.MapWithDefault
    public Map<K, V> getMap() {
        return this.map;
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

    @Override // java.util.Map
    public boolean equals(Object other) {
        return getMap().equals(other);
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    public String toString() {
        return getMap().toString();
    }

    public int getSize() {
        return getMap().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return getMap().containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return getMap().containsValue(value);
    }

    @Override // java.util.Map
    public V get(Object key) {
        return getMap().get(key);
    }

    public Set<K> getKeys() {
        return getMap().keySet();
    }

    public Collection<V> getValues() {
        return getMap().values();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    @Override // kotlin.collections.MapWithDefault
    public V getOrImplicitDefault(K key) {
        Map<K, V> map = getMap();
        V v = map.get(key);
        return (v != null || map.containsKey(key)) ? v : this.default.invoke(key);
    }
}
