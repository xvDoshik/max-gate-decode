package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TransportFactoryImpl implements TransportFactory {
    public final Set supportedPayloadEncodings;
    public final AutoValue_TransportContext transportContext;
    public final TransportRuntime transportInternal;

    public TransportFactoryImpl(Set set, AutoValue_TransportContext autoValue_TransportContext, TransportRuntime transportRuntime) {
        this.supportedPayloadEncodings = set;
        this.transportContext = autoValue_TransportContext;
        this.transportInternal = transportRuntime;
    }
}
