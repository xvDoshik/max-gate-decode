package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MetadataBackendRegistry {
    public final OperationImpl backendFactoryProvider;
    public final HashMap backends;
    public final WorkTagDao_Impl creationContextFactory;

    public MetadataBackendRegistry(Context context, WorkTagDao_Impl workTagDao_Impl) {
        OperationImpl operationImpl = new OperationImpl(context);
        this.backends = new HashMap();
        this.backendFactoryProvider = operationImpl;
        this.creationContextFactory = workTagDao_Impl;
    }

    public final synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return (TransportBackend) this.backends.get(str);
        }
        CctBackendFactory cctBackendFactory = this.backendFactoryProvider.get(str);
        if (cctBackendFactory == null) {
            return null;
        }
        WorkTagDao_Impl workTagDao_Impl = this.creationContextFactory;
        TransportBackend transportBackendCreate = cctBackendFactory.create(new AutoValue_CreationContext((Context) workTagDao_Impl.__db, (Clock) workTagDao_Impl.__insertionAdapterOfWorkTag, (Clock) workTagDao_Impl.__preparedStmtOfDeleteByWorkSpecId, str));
        this.backends.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
