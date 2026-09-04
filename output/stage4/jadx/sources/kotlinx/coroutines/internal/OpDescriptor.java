package kotlinx.coroutines.internal;

import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class OpDescriptor {
    public abstract Object perform(Object obj);

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }
}
