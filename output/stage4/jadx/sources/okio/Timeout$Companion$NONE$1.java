package okio;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Timeout$Companion$NONE$1 extends Timeout {
    @Override // okio.Timeout
    public final Timeout deadlineNanoTime(long j) {
        return this;
    }

    @Override // okio.Timeout
    public final void throwIfReached() {
    }

    @Override // okio.Timeout
    public final Timeout timeout(long j, TimeUnit timeUnit) {
        return this;
    }
}
