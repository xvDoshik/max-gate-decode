package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface ListenableFuture extends Future {
    void addListener(Runnable runnable, Executor executor);
}
