package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import java.io.Closeable;
import javax.inject.Provider;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DaggerTransportRuntimeComponent implements Closeable {
    public Provider executorProvider;
    public Provider metadataBackendRegistryProvider;
    public Provider sQLiteEventStoreProvider;
    public SchemaManager_Factory schemaManagerProvider;
    public ConnectionPool setApplicationContextProvider;
    public Provider transportRuntimeProvider;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((SQLiteEventStore) ((EventStore) this.sQLiteEventStoreProvider.get())).close();
    }
}
