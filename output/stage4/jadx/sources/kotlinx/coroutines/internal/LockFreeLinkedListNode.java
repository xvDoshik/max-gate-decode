package kotlinx.coroutines.internal;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlinx.coroutines.BuildersKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class LockFreeLinkedListNode {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, C0000.decode(new byte[]{111, 15, 86, 29, 67}, "0a3e78", 6));
    public static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, C0000.decode(new byte[]{57, 64, 17, 81, 70}, "f0c40c1a61b2ca", 0));
    public static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, C0000.decode(new byte[]{57, 71, 82, 85, 88, 19, 93, 0, 100, 1, 81}, "f5787e8d6d7b746a", 0.0f));
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends CallableReference implements Function0, KCallable {
        public final boolean syntheticJavaProperty;

        public AnonymousClass1(LockFreeLinkedListNode lockFreeLinkedListNode) {
            super(lockFreeLinkedListNode, BuildersKt.class, C0000.decode(new byte[]{87, 90, 7, 21, 70, 100, 81, 84, 68, 90, 3, 40, 84, 90, 93}, "46ff5789", false), C0000.decode(new byte[]{84, 87, 23, 123, 95, 86, 74, 74, 48, 80, 92, 20, 95, 87, 45, 89, 94, 82, 17, 117, 9, 88, 71, 5, 28, 94, 2, 86, 84, 24, 118, 91, 9, 92, 82, 16, 8, 27, 47, 82, 82, 65, 88, 22, 15, 88, 95, 3, 28, 97, 23, 74, 90, 89, 94, 2}, "32c83799c91d"), true);
            this.syntheticJavaProperty = false;
        }

        public final KCallable compute() {
            if (this.syntheticJavaProperty) {
                return this;
            }
            KCallable kCallable = this.reflected;
            if (kCallable != null) {
                return kCallable;
            }
            Reflection.factory.getClass();
            this.reflected = this;
            return this;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AnonymousClass1) {
                AnonymousClass1 anonymousClass1 = (AnonymousClass1) obj;
                return getOwner().equals(anonymousClass1.getOwner()) && this.name.equals(anonymousClass1.name) && this.signature.equals(anonymousClass1.signature) && this.receiver.equals(anonymousClass1.receiver);
            }
            if (obj instanceof AnonymousClass1) {
                return obj.equals(compute());
            }
            return false;
        }

        public final int hashCode() {
            return this.signature.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.name, getOwner().hashCode() * 31, 31);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.receiver.getClass().getSimpleName();
        }

        public final String toString() {
            KCallable kCallableCompute = compute();
            return kCallableCompute != this ? kCallableCompute.toString() : FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(C0000.decode(new byte[]{21, 23, 13, 73, 7, 70, 23, 79, 67}, "eeb9b4c6c08eb9")), this.name, C0000.decode(new byte[]{20, 29, 126, 11, 17, 91, 90, 11, 20, 71, 80, 2, 9, 82, 80, 17, 93, 90, 91, 68, 12, 68, 19, 11, 91, 65, 21, 5, 19, 86, 90, 9, 85, 87, 89, 1, 76}, "455de73e", 3));
        }
    }

    public final LockFreeLinkedListNode correctPrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _prev$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater2.get(this);
            lockFreeLinkedListNode = lockFreeLinkedListNode2;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = _next$FU;
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                    if (obj == this) {
                        if (lockFreeLinkedListNode2 != lockFreeLinkedListNode) {
                            while (!atomicReferenceFieldUpdater2.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
                                if (atomicReferenceFieldUpdater2.get(this) != lockFreeLinkedListNode2) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        break;
                    }
                    if (isRemoved()) {
                        return null;
                    }
                    if (obj == null) {
                        break loop0;
                    }
                    if (obj instanceof OpDescriptor) {
                        ((OpDescriptor) obj).perform(lockFreeLinkedListNode);
                        break;
                    }
                    if (!(obj instanceof Removed)) {
                        lockFreeLinkedListNode3 = lockFreeLinkedListNode;
                        lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    } else {
                        if (lockFreeLinkedListNode3 != null) {
                            break;
                        }
                        lockFreeLinkedListNode = (LockFreeLinkedListNode) atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode);
                    }
                }
                LockFreeLinkedListNode lockFreeLinkedListNode4 = ((Removed) obj).ref;
                while (!atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode3, lockFreeLinkedListNode, lockFreeLinkedListNode4)) {
                    if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode3) != lockFreeLinkedListNode) {
                        break;
                    }
                }
                lockFreeLinkedListNode = lockFreeLinkedListNode3;
            }
        }
        return lockFreeLinkedListNode;
    }

    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                    if (isRemoved()) {
                        lockFreeLinkedListNode.correctPrev();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) == lockFreeLinkedListNode2);
        }
    }

    public final Object getNext() {
        while (true) {
            Object obj = _next$FU.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object next = getNext();
        Removed removed = next instanceof Removed ? (Removed) next : null;
        return (removed == null || (lockFreeLinkedListNode = removed.ref) == null) ? (LockFreeLinkedListNode) next : lockFreeLinkedListNode;
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(new AnonymousClass1(this));
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }
}
