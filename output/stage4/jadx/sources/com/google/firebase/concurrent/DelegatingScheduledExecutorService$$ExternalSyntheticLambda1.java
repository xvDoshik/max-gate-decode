package com.google.firebase.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class DelegatingScheduledExecutorService$$ExternalSyntheticLambda1 implements DelegatingScheduledFuture.Resolver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DelegatingScheduledExecutorService f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ TimeUnit f$4;

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda1(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j, long j2, TimeUnit timeUnit, int i) {
        this.$r8$classId = i;
        this.f$0 = delegatingScheduledExecutorService;
        this.f$1 = runnable;
        this.f$2 = j;
        this.f$3 = j2;
        this.f$4 = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(ConnectionPool connectionPool) {
        switch (this.$r8$classId) {
            case 0:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f$0;
                return delegatingScheduledExecutorService.scheduler.scheduleAtFixedRate(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda4(delegatingScheduledExecutorService, this.f$1, connectionPool, 0), this.f$2, this.f$3, this.f$4);
            default:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = this.f$0;
                return delegatingScheduledExecutorService2.scheduler.scheduleWithFixedDelay(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda4(delegatingScheduledExecutorService2, this.f$1, connectionPool, 2), this.f$2, this.f$3, this.f$4);
        }
    }
}
