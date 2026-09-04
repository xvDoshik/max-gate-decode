package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class Timeout {
    public static final Timeout$Companion$NONE$1 NONE = new Timeout$Companion$NONE$1();
    public long deadlineNanoTime;
    public boolean hasDeadline;
    public long timeoutNanos;

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{45, 10, 20, 92, 93, 2, 6, 89, 89, 15, 6}, "ce488cb50a"));
    }

    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException(C0000.decode(new byte[]{93, 95, 65, 4, 17, 65, 64, 20, 16, 93, 82}, "415ac35dd8643d", true));
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException(C0000.decode(new byte[]{86, 0, 86, 6, 13, 81, 86, 80, 16, 74, 87, 88, 81, 13, 82, 6}, "2e7ba8850829", false));
        }
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException((C0000.decode(new byte[]{16, 12, 84, 84, 86, 67, 16, 69, 5, 17, 9, 12, 68}, "de9196", 0) + j).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }
}
