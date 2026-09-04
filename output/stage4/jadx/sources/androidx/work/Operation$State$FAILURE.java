package androidx.work;

import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Operation$State$FAILURE extends Headers.Companion {
    public final Throwable mThrowable;

    public Operation$State$FAILURE(Throwable th) {
        this.mThrowable = th;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{36, 120, 47, 47, 103, 52, 125, 68, 74}, "b9fc2f8d"));
        sb.append(this.mThrowable.getMessage());
        sb.append(C0000.decode(new byte[]{72}, "a38cb699", 6));
        return sb.toString();
    }
}
