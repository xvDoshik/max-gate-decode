package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    public final Feature zza;

    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return C0000.decode(new byte[]{117, 11, 70, 21, 91, 86, 80, 25}, "8b5f287989bc0e85").concat(String.valueOf(this.zza));
    }
}
