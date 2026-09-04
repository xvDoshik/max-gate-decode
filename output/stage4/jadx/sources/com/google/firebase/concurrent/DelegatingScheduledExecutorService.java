package com.google.firebase.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DelegatingScheduledExecutorService implements ScheduledExecutorService {
    public final ExecutorService delegate;
    public final ScheduledExecutorService scheduler;

    public DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.delegate = executorService;
        this.scheduler = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection) {
        return this.delegate.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection) {
        return this.delegate.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(this, runnable, j, timeUnit, 0));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda1(this, runnable, j, j2, timeUnit, 0));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda1(this, runnable, j, j2, timeUnit, 1));
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{107, 95, 20, 22, 76, 80, 8, 95, 24, 83, 14, 21, 86, 25, 15, 75, 24, 89, 14, 22, 24, 88, 10, 84, 87, 64, 4, 6, 22}, "87ab89f8", 2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{96, 90, 16, 66, 22, 95, 8, 1, 65, 0, 9, 78, 94, 17, 90, 65, 69, 88, 13, 66, 70, 7, 13, 8, 9, 78, 85, 85, 29}, "32e6b6ffadf901", 0.0f));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Callable callable) {
        return this.delegate.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.delegate.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(this, callable, j, timeUnit, 2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable, Object obj) {
        return this.delegate.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }
}
