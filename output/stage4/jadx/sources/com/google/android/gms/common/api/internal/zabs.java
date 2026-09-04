package com.google.android.gms.common.api.internal;

import androidx.work.impl.OperationImpl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zzag;
import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zabs {
    public final ApiKey zaa;
    public final Feature zab;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (zzag.equal(this.zaa, zabsVar.zaa) && zzag.equal(this.zab, zabsVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        OperationImpl operationImpl = new OperationImpl(this);
        operationImpl.add(this.zaa, C0000.decode(new byte[]{88, 1, 72}, "3d169c803fc2", 0.0f));
        operationImpl.add(this.zab, C0000.decode(new byte[]{7, 80, 84, 22, 17, 67, 4}, "a55bd1"));
        return operationImpl.toString();
    }
}
