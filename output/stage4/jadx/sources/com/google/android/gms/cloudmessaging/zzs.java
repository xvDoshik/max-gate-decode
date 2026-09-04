package com.google.android.gms.cloudmessaging;

import com.google.android.gms.common.api.Status;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class zzs extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzs(Status status) {
        int i = status.zzc;
        String str = status.zzd;
        super(i + C0000.decode(new byte[]{88, 19}, "b31dfd02") + (str == null ? "" : str));
    }
}
