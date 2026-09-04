package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ChannelSegment extends Segment {
    public final BufferedChannel _channel;
    public final AtomicReferenceArray data;

    public ChannelSegment(long j, ChannelSegment channelSegment, BufferedChannel bufferedChannel, int i) {
        super(j, channelSegment, i);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(Object obj, int i, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i2 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.data;
            if (atomicReferenceArray.compareAndSet(i2, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i2) == obj);
        return false;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final Object getState$kotlinx_coroutines_core(int i) {
        return this.data.get((i * 2) + 1);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final void onCancellation(int i, CoroutineContext coroutineContext) {
        BufferedChannel bufferedChannel;
        int i2 = BufferedChannelKt.SEGMENT_SIZE;
        boolean z = i >= i2;
        if (z) {
            i -= i2;
        }
        this.data.get(i * 2);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core(i);
            boolean z2 = state$kotlinx_coroutines_core instanceof Waiter;
            bufferedChannel = this._channel;
            if (z2 || (state$kotlinx_coroutines_core instanceof WaiterEB)) {
                if (casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i, z ? BufferedChannelKt.INTERRUPTED_SEND : BufferedChannelKt.INTERRUPTED_RCV)) {
                    setElementLazy(i, null);
                    onCancelledRequest(i, !z);
                    if (z) {
                        bufferedChannel.getClass();
                        return;
                    }
                    return;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                    break;
                }
                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED) {
                        return;
                    }
                    throw new IllegalStateException((C0000.decode(new byte[]{66, 8, 87, 27, 68, 3, 86, 66, 0, 1, 18, 66, 23, 0, 18, 6, 13, 70}, "7f2c4f56ee21cafc", 6) + state$kotlinx_coroutines_core).toString());
                }
            }
        }
        setElementLazy(i, null);
        if (z) {
            bufferedChannel.getClass();
        }
    }

    public final void onCancelledRequest(int i, boolean z) {
        if (z) {
            this._channel.waitExpandBufferCompletion$kotlinx_coroutines_core((this.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i));
        }
        onSlotCleaned();
    }

    public final void setElementLazy(int i, Object obj) {
        this.data.lazySet(i * 2, obj);
    }

    public final void setState$kotlinx_coroutines_core(int i, Object obj) {
        this.data.set((i * 2) + 1, obj);
    }
}
