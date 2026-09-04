package kotlin.concurrent.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public final /* synthetic */ class AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean m(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
