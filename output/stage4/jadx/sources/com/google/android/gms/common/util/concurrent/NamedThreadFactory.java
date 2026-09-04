package com.google.android.gms.common.util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NamedThreadFactory implements ThreadFactory {
    public final String zza;
    public final ThreadFactory zzb = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zzb.newThread(new zza(runnable, 0));
        threadNewThread.setName(this.zza);
        return threadNewThread;
    }
}
