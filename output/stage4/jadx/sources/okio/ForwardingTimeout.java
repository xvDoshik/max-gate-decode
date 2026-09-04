package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ForwardingTimeout extends Timeout {
    public Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public final Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    public final Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public final long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public final boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    @Override // okio.Timeout
    public final void throwIfReached() throws InterruptedIOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    public final Timeout timeout(long j, TimeUnit timeUnit) {
        return this.delegate.timeout(j, timeUnit);
    }

    @Override // okio.Timeout
    public final long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    public final Timeout deadlineNanoTime(long j) {
        return this.delegate.deadlineNanoTime(j);
    }
}
