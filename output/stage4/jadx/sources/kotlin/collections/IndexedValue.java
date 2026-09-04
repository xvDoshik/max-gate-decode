package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class IndexedValue {
    public final int index;
    public final Object value;

    public IndexedValue(int i, Object obj) {
        this.index = i;
        this.value = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.index == indexedValue.index && Intrinsics.areEqual(this.value, indexedValue.value);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.index) * 31;
        Object obj = this.value;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{43, 89, 87, 84, 26, 6, 82, 99, 81, 89, 65, 3, 26, 91, 12, 0, 7, 79, 14}, "b731bc65054f22bd", 0.0f));
        sb.append(this.index);
        sb.append(C0000.decode(new byte[]{24, 17, 78, 88, 91, 70, 86, 10}, "418973370bfd172f", 0.0f));
        sb.append(this.value);
        sb.append(')');
        return sb.toString();
    }
}
