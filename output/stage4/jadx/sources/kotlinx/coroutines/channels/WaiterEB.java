package kotlinx.coroutines.channels;

import kotlinx.coroutines.Waiter;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WaiterEB {
    public final Waiter waiter;

    public WaiterEB(Waiter waiter) {
        this.waiter = waiter;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{110, 4, 88, 18, 6, 68, 36, 117, 16}, "9e1fc6a789f4b3"));
        sb.append(this.waiter);
        sb.append(')');
        return sb.toString();
    }
}
