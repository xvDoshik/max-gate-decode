package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AtomicOp extends OpDescriptor {
    public static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, C0000.decode(new byte[]{110, 83, 89, 91, 67, 85, 94, 67, 64, 16}, "106500005cc740", 0.0f));
    private volatile Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(Object obj, Object obj2);

    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _consensus$FU;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Symbol symbol = AtomicKt.NO_DECISION;
        if (obj2 == symbol) {
            Symbol symbolPrepare = prepare(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == symbol) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, symbol, symbolPrepare)) {
                    if (atomicReferenceFieldUpdater.get(this) != symbol) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                    }
                }
                obj2 = symbolPrepare;
            }
        }
        complete(obj, obj2);
        return obj2;
    }

    public abstract Symbol prepare(Object obj);
}
