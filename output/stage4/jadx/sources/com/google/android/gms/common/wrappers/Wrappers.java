package com.google.android.gms.common.wrappers;

import android.content.Context;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Wrappers {
    public static final Wrappers zza;
    public PackageManagerWrapper zzb;

    static {
        Wrappers wrappers = new Wrappers();
        wrappers.zzb = null;
        zza = wrappers;
    }

    public static PackageManagerWrapper packageManager(Context context) {
        PackageManagerWrapper packageManagerWrapper;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            try {
                if (wrappers.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    PackageManagerWrapper packageManagerWrapper2 = new PackageManagerWrapper();
                    packageManagerWrapper2.zza = context;
                    wrappers.zzb = packageManagerWrapper2;
                }
                packageManagerWrapper = wrappers.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return packageManagerWrapper;
    }
}
