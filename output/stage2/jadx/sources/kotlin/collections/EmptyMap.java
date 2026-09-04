package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010%\u001a\u00020\u0002H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u001a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "containsKey", "key", "containsValue", "value", "get", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "readResolve", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EmptyMap implements Map, Serializable, KMappedMarker {
    public static final EmptyMap INSTANCE = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{124, 20, 86, 16, 88, 64, 10, 10, 95, 18, 81, 74, 19, 10, 92, 22, 25, 71, 22, 21, 65, 93, 74, 77, 86, 0, 19, 4, 86, 70, 67, 23, 84, 83, 92, 20, 92, 10, 95, 27, 25, 87, 12, 9, 93, 87, 91, 77, 90, 11, 93}, "3d3b94ce1289", 0.0f));
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Void value) {
        Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{78, 4, 13, 70, 92}, "8ea390", 0.0f));
        return false;
    }

    @Override // java.util.Map
    public Void get(Object key) {
        return null;
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 21, 3, 20, 86, 18, 89, 86, 89, 25, 8, 22, 70, 8, 88, 18, 16, 74, 66, 73, 17, 10, 20, 18, 82, 2, 16, 95, 88, 75, 65, 23, 3, 7, 83, 75, 95, 87, 91, 64, 65, 6, 9, 10, 91, 3, 83, 77, 94, 86, 15}, "aeff7f0979", true));
    }

    public Void put(Object obj, Void r5) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 69, 1, 20, 7, 77, 95, 9, 95, 18, 88, 70, 68, 8, 9, 77, 22, 21, 68, 66, 65, 90, 22, 18, 3, 93, 22, 0, 94, 64, 17, 71, 1, 7, 2, 20, 89, 8, 93, 75, 17, 86, 11, 10, 10, 92, 85, 18, 88, 93, 95}, "15dff96f12"));
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 19, 82, 75, 86, 17, 95, 10, 15, 19, 12, 71, 18, 13, 88, 77, 23, 22, 67, 21, 17, 92, 23, 64, 87, 7, 23, 95, 88, 23, 22, 23, 4, 82, 1, 25, 93, 13, 91, 64, 23, 6, 89, 9, 13, 86, 6, 64, 91, 12, 89}, "2c797e6ea3e4"));
    }

    @Override // java.util.Map
    public Void remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 70, 84, 71, 81, 71, 94, 91, 95, 66, 10, 70, 21, 88, 94, 65, 16, 64, 66, 68, 65, 13, 17, 65, 80, 82, 17, 83, 95, 65, 23, 70, 84, 3, 7, 24, 90, 88, 93, 76, 16, 80, 88, 88, 93, 7, 0, 65, 92, 89, 95}, "561503741bc5", 6));
    }

    public String toString() {
        return C0000.decode(new byte[]{24, 79}, "c2c014", 0.0f);
    }

    private EmptyMap() {
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return containsValue((Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return (other instanceof Map) && ((Map) other).isEmpty();
    }

    public Set<Map.Entry> getEntries() {
        return EmptySet.INSTANCE;
    }

    public Set<Object> getKeys() {
        return EmptySet.INSTANCE;
    }

    public Collection getValues() {
        return EmptyList.INSTANCE;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
