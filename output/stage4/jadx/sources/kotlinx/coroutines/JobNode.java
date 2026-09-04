package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Removed;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class JobNode extends LockFreeLinkedListNode implements DisposableHandle, Incomplete, Function1 {
    public JobSupport job;

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        JobSupport jobSupport = this.job;
        if (jobSupport == null) {
            jobSupport = null;
        }
        while (true) {
            Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof JobNode) {
                if (state$kotlinx_coroutines_core != this) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = JobSupport._state$FU;
                Empty empty = BuildersKt.EMPTY_ACTIVE;
                while (!atomicReferenceFieldUpdater2.compareAndSet(jobSupport, state$kotlinx_coroutines_core, empty)) {
                    if (atomicReferenceFieldUpdater2.get(jobSupport) != state$kotlinx_coroutines_core) {
                    }
                }
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                return;
            }
            while (true) {
                Object next = getNext();
                if (next instanceof Removed) {
                    return;
                }
                if (next == this) {
                    return;
                }
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = LockFreeLinkedListNode._removedRef$FU;
                Removed removed = (Removed) atomicReferenceFieldUpdater3.get(lockFreeLinkedListNode);
                if (removed == null) {
                    removed = new Removed(lockFreeLinkedListNode);
                    atomicReferenceFieldUpdater3.lazySet(lockFreeLinkedListNode, removed);
                }
                do {
                    atomicReferenceFieldUpdater = LockFreeLinkedListNode._next$FU;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, next, removed)) {
                        lockFreeLinkedListNode.correctPrev();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == next);
            }
        }
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    public abstract void invoke(Throwable th);

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(this));
        sb.append(C0000.decode(new byte[]{108, 83, 10, 1, 36}, "79ecd49c", false));
        JobSupport jobSupport = this.job;
        if (jobSupport == null) {
            jobSupport = null;
        }
        sb.append(BuildersKt.getHexAddress(jobSupport));
        sb.append(']');
        return sb.toString();
    }
}
