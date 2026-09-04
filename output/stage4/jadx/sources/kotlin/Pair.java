package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Pair implements Serializable {
    public final Object first;
    public final Object second;

    public Pair(Object obj, Serializable serializable) {
        this.first = obj;
        this.second = serializable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.areEqual(this.first, pair.first) && Intrinsics.areEqual(this.second, pair.second);
    }

    public final int hashCode() {
        Object obj = this.first;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.second;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{74}, "b61fdf", true));
        sb.append(this.first);
        sb.append(C0000.decode(new byte[]{21, 23}, "971091", 5));
        sb.append(this.second);
        sb.append(')');
        return sb.toString();
    }
}
