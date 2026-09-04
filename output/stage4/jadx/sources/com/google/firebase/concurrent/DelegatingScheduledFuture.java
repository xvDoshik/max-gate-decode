package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DelegatingScheduledFuture extends AbstractResolvableFuture implements ScheduledFuture {
    public final ScheduledFuture upstreamFuture;

    public interface Resolver {
        ScheduledFuture addCompleter(ConnectionPool connectionPool);
    }

    public DelegatingScheduledFuture(Resolver resolver) {
        this.upstreamFuture = resolver.addCompleter(new ConnectionPool(19, this));
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final void afterDone() {
        ScheduledFuture scheduledFuture = this.upstreamFuture;
        Object obj = this.value;
        scheduledFuture.cancel((obj instanceof AbstractResolvableFuture.Cancellation) && ((AbstractResolvableFuture.Cancellation) obj).wasInterrupted);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.upstreamFuture.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.upstreamFuture.getDelay(timeUnit);
    }
}
