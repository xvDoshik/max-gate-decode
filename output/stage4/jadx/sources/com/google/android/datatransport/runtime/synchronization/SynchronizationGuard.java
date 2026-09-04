package com.google.android.datatransport.runtime.synchronization;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface SynchronizationGuard {

    public interface CriticalSection {
        Object execute();
    }
}
