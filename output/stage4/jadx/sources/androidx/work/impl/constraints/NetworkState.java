package androidx.work.impl.constraints;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NetworkState {
    public final boolean isConnected;
    public final boolean isMetered;
    public final boolean isNotRoaming;
    public final boolean isValidated;

    public NetworkState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isConnected = z;
        this.isValidated = z2;
        this.isMetered = z3;
        this.isNotRoaming = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.isConnected == networkState.isConnected && this.isValidated == networkState.isValidated && this.isMetered == networkState.isMetered && this.isNotRoaming == networkState.isNotRoaming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        boolean z = this.isConnected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = r1 * 31;
        boolean z2 = this.isValidated;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.isMetered;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z4 = this.isNotRoaming;
        return i3 + (z4 ? 1 : z4);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{123, 86, 23, 18, 12, 65, 83, 97, 67, 82, 16, 4, 17, 80, 70, 112, 12, 11, 13, 86, 91, 70, 82, 87, 89}, "53cec38273da99", 4));
        sb.append(this.isConnected);
        sb.append(C0000.decode(new byte[]{20, 68, 95, 23, 98, 80, 13, 91, 92, 5, 66, 1, 80, 12}, "8d6d41a2", 3));
        sb.append(this.isValidated);
        sb.append(C0000.decode(new byte[]{27, 25, 94, 69, 40, 81, 76, 4, 69, 92, 83, 11}, "7976e48a", 4));
        sb.append(this.isMetered);
        sb.append(C0000.decode(new byte[]{20, 67, 94, 65, 122, 88, 21, 96, 95, 7, 89, 91, 13, 95, 5}, "8c7247a20f42c8", 0.0f));
        sb.append(this.isNotRoaming);
        sb.append(')');
        return sb.toString();
    }
}
