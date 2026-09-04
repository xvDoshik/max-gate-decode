package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater _handled$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, C0000.decode(new byte[]{60, 12, 81, 94, 87, 13, 6, 0}, "cd003a"));
    private volatile int _handled;
    public final Throwable cause;

    public CompletedExceptionally(Throwable th, boolean z) {
        this.cause = th;
        this._handled = z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append(this.cause);
        sb.append(']');
        return sb.toString();
    }
}
