package kotlinx.coroutines;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {
    public static final NonDisposableHandle INSTANCE = new NonDisposableHandle();

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
    }

    public final String toString() {
        return C0000.decode(new byte[]{125, 94, 10, 32, 13, 21, 19, 87, 22, 82, 91, 85, 86, 121, 5, 10, 0, 10, 6}, "31dddfc8e399");
    }
}
