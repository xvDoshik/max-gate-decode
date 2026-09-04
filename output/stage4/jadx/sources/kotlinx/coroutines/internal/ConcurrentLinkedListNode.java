package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.ChannelSegment;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConcurrentLinkedListNode {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, C0000.decode(new byte[]{104, 11, 0, 25, 66}, "7eea66e4e39e49", 0.0f));
    public static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, C0000.decode(new byte[]{108, 17, 68, 87, 65}, "3a627cb3b65c92ba", true));
    private volatile Object _next;
    private volatile Object _prev;

    public ConcurrentLinkedListNode(ChannelSegment channelSegment) {
        this._prev = channelSegment;
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final ConcurrentLinkedListNode getNext() {
        Object obj = _next$FU.get(this);
        if (obj == AtomicKt.CLOSED) {
            return null;
        }
        return (ConcurrentLinkedListNode) obj;
    }

    public abstract boolean isRemoved();

    public final void remove() {
        ConcurrentLinkedListNode next;
        if (getNext() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            ConcurrentLinkedListNode concurrentLinkedListNode = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(this);
            while (concurrentLinkedListNode != null && concurrentLinkedListNode.isRemoved()) {
                concurrentLinkedListNode = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(concurrentLinkedListNode);
            }
            ConcurrentLinkedListNode next2 = getNext();
            while (next2.isRemoved() && (next = next2.getNext()) != null) {
                next2 = next;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(next2);
                ConcurrentLinkedListNode concurrentLinkedListNode2 = ((ConcurrentLinkedListNode) obj) == null ? null : concurrentLinkedListNode;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(next2, obj, concurrentLinkedListNode2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(next2) != obj) {
                    }
                }
            }
            if (concurrentLinkedListNode != null) {
                _next$FU.set(concurrentLinkedListNode, next2);
            }
            if (!next2.isRemoved() || next2.getNext() == null) {
                if (concurrentLinkedListNode == null || !concurrentLinkedListNode.isRemoved()) {
                    return;
                }
            }
        }
    }
}
