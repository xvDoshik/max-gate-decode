package com.google.android.gms.signin;

import com.google.android.gms.common.internal.zzag;
import java.util.Arrays;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SignInOptions {
    public static final SignInOptions zaa = new SignInOptions();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SignInOptions) && zzag.equal(null, null) && zzag.equal(null, null) && zzag.equal(null, null) && zzag.equal(null, null) && zzag.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
