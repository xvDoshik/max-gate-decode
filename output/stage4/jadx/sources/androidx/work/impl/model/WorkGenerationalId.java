package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkGenerationalId {
    public final int generation;
    public final String workSpecId;

    public WorkGenerationalId(String str, int i) {
        this.workSpecId = str;
        this.generation = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return Intrinsics.areEqual(this.workSpecId, workGenerationalId.workSpecId) && this.generation == workGenerationalId.generation;
    }

    public final int hashCode() {
        return Integer.hashCode(this.generation) + (this.workSpecId.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{52, 95, 65, 93, 119, 7, 88, 87, 17, 81, 71, 95, 95, 12, 87, 94, 42, 84, 27, 65, 95, 16, 93, 97, 19, 85, 80, 127, 84, 95}, "c0360b62", 0.0f));
        sb.append(this.workSpecId);
        sb.append(C0000.decode(new byte[]{24, 66, 87, 93, 94, 93, 20, 82, 77, 91, 14, 92, 13}, "4b0808f392a208d7"));
        sb.append(this.generation);
        sb.append(')');
        return sb.toString();
    }
}
