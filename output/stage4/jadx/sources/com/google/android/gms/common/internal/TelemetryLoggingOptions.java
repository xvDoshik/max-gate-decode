package com.google.android.gms.common.internal;

import java.util.Arrays;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TelemetryLoggingOptions {
    public static final TelemetryLoggingOptions zaa = new TelemetryLoggingOptions();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TelemetryLoggingOptions) {
            return zzag.equal(null, null);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null});
    }
}
