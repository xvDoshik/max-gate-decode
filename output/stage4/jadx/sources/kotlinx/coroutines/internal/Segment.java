package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelSegment;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Segment extends ConcurrentLinkedListNode implements NotCompleted {
    public static final AtomicIntegerFieldUpdater cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, C0000.decode(new byte[]{84, 93, 83, 4, 87, 85, 93, 114, 10, 80, 51, 9, 8, 11, 67, 84, 68, 22}, "716e9093d4cfae", 0.0f));
    private volatile int cleanedAndPointers;
    public final long id;

    public Segment(long j, ChannelSegment channelSegment, int i) {
        super(channelSegment);
        this.id = j;
        this.cleanedAndPointers = i << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return cleanedAndPointers$FU.addAndGet(this, -65536) == getNumberOfSlots() && getNext() != null;
    }

    public abstract int getNumberOfSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public final boolean isRemoved() {
        return cleanedAndPointers$FU.get(this) == getNumberOfSlots() && getNext() != null;
    }

    public abstract void onCancellation(int i, CoroutineContext coroutineContext);

    public final void onSlotCleaned() {
        if (cleanedAndPointers$FU.incrementAndGet(this) == BufferedChannelKt.SEGMENT_SIZE) {
            remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = cleanedAndPointers$FU;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == getNumberOfSlots() && getNext() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
