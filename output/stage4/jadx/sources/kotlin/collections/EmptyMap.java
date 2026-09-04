package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EmptyMap implements Map, Serializable {
    public static final EmptyMap INSTANCE = new EmptyMap();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{44, 66, 0, 64, 80, 64, 80, 10, 93, 25, 81, 64, 65, 10, 12, 70, 69, 65, 68, 68, 73, 10, 65, 77, 93, 87, 65, 2, 12, 64, 69, 64, 84, 85, 93, 72, 92, 87, 84, 74, 65, 7, 12, 94, 9, 87, 82, 64, 80, 10, 93}, "c2e2149e3983ad"));
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return EmptySet.INSTANCE;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return EmptySet.INSTANCE;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 17, 0, 19, 7, 18, 13, 14, 11, 65, 15, 21, 68, 15, 10, 21, 70, 21, 17, 17, 21, 14, 20, 18, 1, 5, 69, 7, 9, 20, 68, 19, 0, 0, 2, 75, 11, 15, 9, 24, 70, 5, 11, 13, 9, 4, 5, 18, 13, 14, 11}, "daeaff"));
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 71, 81, 74, 3, 23, 10, 92, 89, 23, 90, 23, 68, 12, 14, 65, 18, 68, 65, 72, 18, 12, 17, 71, 82, 83, 19, 2, 11, 16, 65, 71, 87, 86, 80, 21, 13, 13, 15, 74, 23, 84, 92, 8, 8, 7, 2, 65, 91, 88, 90}, "2748bcc3773ddba5", 0.0f));
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 73, 85, 71, 82, 70, 89, 11, 11, 25, 89, 70, 19, 92, 95, 16, 69, 74, 69, 69, 67, 93, 66, 16, 0, 93, 16, 83, 92, 64, 16, 22, 0, 88, 84, 24, 92, 92, 92, 29, 69, 90, 95, 89, 95, 87, 83, 16, 12, 86, 94}, "e905320d"));
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return C0000.decode(new byte[]{75, 28}, "0a07e5b175b323", false);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return EmptyList.INSTANCE;
    }
}
