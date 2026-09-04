package com.google.android.datatransport.runtime.scheduling;

import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final MetadataBackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final WorkTagDao_Impl workScheduler;

    public DefaultScheduler(Executor executor, MetadataBackendRegistry metadataBackendRegistry, WorkTagDao_Impl workTagDao_Impl, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = metadataBackendRegistry;
        this.workScheduler = workTagDao_Impl;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }
}
