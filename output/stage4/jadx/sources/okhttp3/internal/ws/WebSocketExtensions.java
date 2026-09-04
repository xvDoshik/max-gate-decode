package okhttp3.internal.ws;

import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WebSocketExtensions {
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final int hashCode() {
        boolean z = this.perMessageDeflate;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = r1 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.clientNoContextTakeover;
        ?? r3 = z2;
        if (z2) {
            r3 = 1;
        }
        int i2 = (iHashCode + r3) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.serverNoContextTakeover;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i3 = (iHashCode2 + r2) * 31;
        boolean z4 = this.unknownValues;
        return i3 + (z4 ? 1 : z4);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{52, 84, 82, 107, 95, 6, 94, 86, 66, 119, 65, 22, 6, 95, 67, 81, 95, 11, 70, 27, 70, 87, 75, 47, 6, 66, 67, 89, 87, 0, 113, 86, 80, 94, 88, 22, 6, 12}, "c1080e53629b"));
        sb.append(this.perMessageDeflate);
        sb.append(C0000.decode(new byte[]{79, 21, 0, 95, 12, 84, 10, 66, 125, 5, 29, 100, 10, 91, 7, 92, 18, 115, 13, 66, 67, 89}, "c5c3e1d60de3", 0.0f));
        sb.append(this.clientMaxWindowBits);
        sb.append(C0000.decode(new byte[]{73, 66, 2, 13, 10, 82, 15, 21, 124, 13, 38, 13, 15, 21, 6, 79, 21, 53, 83, 9, 0, 13, 23, 4, 17, 10}, "ebaac7aa2b", true));
        sb.append(this.clientNoContextTakeover);
        sb.append(C0000.decode(new byte[]{72, 65, 75, 7, 67, 65, 81, 17, 41, 0, 64, 53, 88, 89, 80, 12, 19, 35, 81, 22, 66, 10}, "da8b174c"));
        sb.append(this.serverMaxWindowBits);
        sb.append(C0000.decode(new byte[]{26, 23, 18, 4, 75, 69, 7, 17, 121, 90, 37, 91, 89, 23, 0, 75, 66, 99, 0, 10, 92, 92, 20, 6, 69, 8}, "67aa93bc75f47ce3", true));
        sb.append(this.serverNoContextTakeover);
        sb.append(C0000.decode(new byte[]{20, 25, 77, 90, 95, 95, 87, 78, 86, 98, 85, 93, 77, 92, 75, 9}, "898441"));
        sb.append(this.unknownValues);
        sb.append(')');
        return sb.toString();
    }
}
