package com.google.firebase.concurrent;

import androidx.work.Worker;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.concurrent.zza;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SequentialExecutor implements Executor {
    public static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    public final Executor executor;
    public final ArrayDeque queue = new ArrayDeque();
    public int workerRunningState = 1;
    public long workerRunCount = 0;
    public final Worker.AnonymousClass2 worker = new Worker.AnonymousClass2(this);

    public SequentialExecutor(Executor executor) {
        zzag.checkNotNull(executor);
        this.executor = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zzag.checkNotNull(runnable);
        synchronized (this.queue) {
            int i = this.workerRunningState;
            if (i != 4 && i != 3) {
                long j = this.workerRunCount;
                zza zzaVar = new zza(runnable, 2);
                this.queue.add(zzaVar);
                this.workerRunningState = 2;
                try {
                    this.executor.execute(this.worker);
                    if (this.workerRunningState != 2) {
                        return;
                    }
                    synchronized (this.queue) {
                        try {
                            if (this.workerRunCount == j && this.workerRunningState == 2) {
                                this.workerRunningState = 3;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.queue) {
                        try {
                            int i2 = this.workerRunningState;
                            boolean z = true;
                            if ((i2 != 1 && i2 != 2) || !this.queue.removeLastOccurrence(zzaVar)) {
                                z = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z) {
                                throw e;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
            }
            this.queue.add(runnable);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{55, 0, 72, 23, 3, 13, 71, 8, 5, 9, 124, 26, 3, 0, 70, 21, 11, 23, 121}, "de9bfc3a", true));
        sb.append(System.identityHashCode(this));
        sb.append(C0000.decode(new byte[]{72}, "31e4c5"));
        sb.append(this.executor);
        sb.append(C0000.decode(new byte[]{24}, "e249b464a9", 0.0f));
        return sb.toString();
    }
}
