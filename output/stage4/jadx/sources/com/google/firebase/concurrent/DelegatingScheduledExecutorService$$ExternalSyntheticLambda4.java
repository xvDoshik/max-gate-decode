package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.ExecutorService;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class DelegatingScheduledExecutorService$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DelegatingScheduledExecutorService f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ ConnectionPool f$2;

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda4(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, ConnectionPool connectionPool, int i) {
        this.$r8$classId = i;
        this.f$0 = delegatingScheduledExecutorService;
        this.f$1 = runnable;
        this.f$2 = connectionPool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ExecutorService executorService = this.f$0.delegate;
                final int i = 1;
                final Runnable runnable = this.f$1;
                final ConnectionPool connectionPool = this.f$2;
                executorService.execute(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i) {
                            case 0:
                                Runnable runnable2 = runnable;
                                ConnectionPool connectionPool2 = connectionPool;
                                try {
                                    runnable2.run();
                                    DelegatingScheduledFuture delegatingScheduledFuture = (DelegatingScheduledFuture) connectionPool2.delegate;
                                    if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, AbstractResolvableFuture.NULL)) {
                                        AbstractResolvableFuture.complete(delegatingScheduledFuture);
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    connectionPool2.setException(e);
                                    return;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e2) {
                                    connectionPool.setException(e2);
                                    throw e2;
                                }
                            default:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e3) {
                                    connectionPool.setException(e3);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                ExecutorService executorService2 = this.f$0.delegate;
                final int i2 = 0;
                final Runnable runnable2 = this.f$1;
                final ConnectionPool connectionPool2 = this.f$2;
                executorService2.execute(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i2) {
                            case 0:
                                Runnable runnable3 = runnable2;
                                ConnectionPool connectionPool3 = connectionPool2;
                                try {
                                    runnable3.run();
                                    DelegatingScheduledFuture delegatingScheduledFuture = (DelegatingScheduledFuture) connectionPool3.delegate;
                                    if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, AbstractResolvableFuture.NULL)) {
                                        AbstractResolvableFuture.complete(delegatingScheduledFuture);
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    connectionPool3.setException(e);
                                    return;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e2) {
                                    connectionPool2.setException(e2);
                                    throw e2;
                                }
                            default:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e3) {
                                    connectionPool2.setException(e3);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                ExecutorService executorService3 = this.f$0.delegate;
                final int i3 = 2;
                final Runnable runnable3 = this.f$1;
                final ConnectionPool connectionPool3 = this.f$2;
                executorService3.execute(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i3) {
                            case 0:
                                Runnable runnable4 = runnable3;
                                ConnectionPool connectionPool4 = connectionPool3;
                                try {
                                    runnable4.run();
                                    DelegatingScheduledFuture delegatingScheduledFuture = (DelegatingScheduledFuture) connectionPool4.delegate;
                                    if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, AbstractResolvableFuture.NULL)) {
                                        AbstractResolvableFuture.complete(delegatingScheduledFuture);
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    connectionPool4.setException(e);
                                    return;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e2) {
                                    connectionPool3.setException(e2);
                                    throw e2;
                                }
                            default:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e3) {
                                    connectionPool3.setException(e3);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
