package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemIdInfo {
    public final int generation;
    public final int systemId;
    public final String workSpecId;

    public SystemIdInfo(String str, int i, int i2) {
        this.workSpecId = str;
        this.generation = i;
        this.systemId = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return Intrinsics.areEqual(this.workSpecId, systemIdInfo.workSpecId) && this.generation == systemIdInfo.generation && this.systemId == systemIdInfo.systemId;
    }

    public final int hashCode() {
        return Integer.hashCode(this.systemId) + ((Integer.hashCode(this.generation) + (this.workSpecId.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{103, 31, 16, 71, 85, 15, 126, 86, 124, 94, 82, 9, 75, 68, 95, 16, 92, 97, 69, 85, 87, 47, 7, 14}, "4fc30b7250", 0));
        sb.append(this.workSpecId);
        sb.append(C0000.decode(new byte[]{26, 22, 86, 81, 8, 81, 23, 83, 70, 11, 86, 86, 4}, "6614f4e22b989f", false));
        sb.append(this.generation);
        sb.append(C0000.decode(new byte[]{29, 22, 16, 74, 18, 67, 82, 91, 44, 84, 13}, "16c3a776e002b71e", false));
        sb.append(this.systemId);
        sb.append(')');
        return sb.toString();
    }
}
