package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.AutoValue_CreationContext;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Keep
public class CctBackendFactory {
    public TransportBackend create(CreationContext creationContext) {
        AutoValue_CreationContext autoValue_CreationContext = (AutoValue_CreationContext) creationContext;
        return new CctTransportBackend(autoValue_CreationContext.applicationContext, autoValue_CreationContext.wallClock, autoValue_CreationContext.monotonicClock);
    }
}
