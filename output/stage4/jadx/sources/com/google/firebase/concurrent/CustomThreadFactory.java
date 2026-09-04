package com.google.firebase.concurrent;

import android.os.StrictMode;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CustomThreadFactory implements ThreadFactory {
    public static final ThreadFactory DEFAULT = Executors.defaultThreadFactory();
    public final String namePrefix;
    public final StrictMode.ThreadPolicy policy;
    public final int priority;
    public final AtomicLong threadCount = new AtomicLong();

    public CustomThreadFactory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.namePrefix = str;
        this.priority = i;
        this.policy = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = DEFAULT.newThread(new Processor$$ExternalSyntheticLambda2(this, 15, runnable));
        Locale locale = Locale.ROOT;
        long andIncrement = this.threadCount.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        sb.append(this.namePrefix);
        sb.append(C0000.decode(new byte[]{67, 97, 12, 75, 0, 84, 6, 68, 23}, "c5d9e5bd4e441e", false));
        sb.append(andIncrement);
        threadNewThread.setName(sb.toString());
        return threadNewThread;
    }
}
