package com.google.firebase.components;

import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OptionalProvider implements Provider {
    public volatile Provider delegate;
    public TransportImpl$$ExternalSyntheticLambda0 handler;
    public static final TransportImpl$$ExternalSyntheticLambda0 NOOP_HANDLER = new TransportImpl$$ExternalSyntheticLambda0(6);
    public static final ComponentRuntime$$ExternalSyntheticLambda0 EMPTY_PROVIDER = new ComponentRuntime$$ExternalSyntheticLambda0(1);

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.delegate.get();
    }
}
