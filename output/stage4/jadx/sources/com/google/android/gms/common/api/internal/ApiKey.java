package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zzag;
import java.util.Arrays;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ApiKey {
    public final int zaa;
    public final Api zab;
    public final String zad;

    public ApiKey(Api api, String str) {
        this.zab = api;
        this.zad = str;
        this.zaa = Arrays.hashCode(new Object[]{api, TelemetryLoggingOptions.zaa, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!zzag.equal(this.zab, apiKey.zab)) {
            return false;
        }
        TelemetryLoggingOptions telemetryLoggingOptions = TelemetryLoggingOptions.zaa;
        return zzag.equal(telemetryLoggingOptions, telemetryLoggingOptions) && zzag.equal(this.zad, apiKey.zad);
    }

    public final int hashCode() {
        return this.zaa;
    }
}
