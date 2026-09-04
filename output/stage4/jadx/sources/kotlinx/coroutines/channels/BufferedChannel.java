package kotlinx.coroutines.channels;

import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class BufferedChannel implements Channel {
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    public final int capacity;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;
    public static final AtomicLongFieldUpdater sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, C0000.decode(new byte[]{69, 0, 10, 5, 82, 64, 69, 36, 10, 5, 116, 94, 89, 22, 1, 50, 67, 83, 66, 16, 23}, "6eda72", false));
    public static final AtomicLongFieldUpdater receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, C0000.decode(new byte[]{64, 0, 1, 0, 92, 79, 87, 23, 17}, "2ebe59"));
    public static final AtomicLongFieldUpdater bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, C0000.decode(new byte[]{6, 71, 4, 81, 83, 23, 39, 8, 82}, "d2b76ebf6da275", 1));
    public static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, C0000.decode(new byte[]{83, 91, 14, 69, 84, 82, 70, 7, 5, 119, 79, 66, 4, 8, 84, 118, 22, 83, 94, 82, 64, 17, 32, 92, 83, 98, 4, 19, 67, 81, 37, 89, 89, 80}, "04c5872ba272ef", true));
    public static final AtomicReferenceFieldUpdater sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, C0000.decode(new byte[]{21, 3, 93, 84, 97, 6, 83, 8, 83, 95, 77}, "ff302c4e61932b", 1));
    public static final AtomicReferenceFieldUpdater receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, C0000.decode(new byte[]{69, 3, 1, 93, 95, 70, 93, 101, 3, 1, 14, 81, 89, 18}, "7fb86086ffc4", 2));
    public static final AtomicReferenceFieldUpdater bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, C0000.decode(new byte[]{85, 20, 84, 0, 84, 67, 125, 89, 5, 96, 82, 6, 95, 3, 95, 69}, "7a2f1187a3", 0.0f));
    public static final AtomicReferenceFieldUpdater _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, C0000.decode(new byte[]{108, 6, 93, 12, 21, 0, 114, 81, 19, 18, 86}, "3e1cfe10fa", 6));
    public static final AtomicReferenceFieldUpdater closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, C0000.decode(new byte[]{82, 89, 91, 21, 85, 45, 80, 91, 80, 10, 85, 23}, "154f0e", 5));

    public final class BufferedChannelIterator implements Waiter {
        public CancellableContinuationImpl continuation;
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        public final Object hasNext(FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1) throws Throwable {
            ChannelSegment channelSegmentFindSegmentReceive;
            Boolean bool;
            ChannelSegment channelSegmentFindSegmentReceive2;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.receiveSegment$FU;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
            while (!bufferedChannel.isClosed(BufferedChannel.sendersAndCloseStatus$FU.get(bufferedChannel), true)) {
                long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                long j = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = andIncrement / j;
                int i = (int) (andIncrement % j);
                if (channelSegment.id != j2) {
                    channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    }
                } else {
                    channelSegmentFindSegmentReceive = channelSegment;
                }
                Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i, andIncrement, null);
                Symbol symbol = BufferedChannelKt.SUSPEND;
                if (objUpdateCellReceive == symbol) {
                    throw new IllegalStateException(C0000.decode(new byte[]{65, 11, 64, 84, 89, 84, 90, 0, 81, 10, 85}, "4e21872a3f0b"));
                }
                Symbol symbol2 = BufferedChannelKt.FAILED;
                if (objUpdateCellReceive == symbol2) {
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegmentFindSegmentReceive.cleanPrev();
                    }
                    channelSegment = channelSegmentFindSegmentReceive;
                } else {
                    if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                        channelSegmentFindSegmentReceive.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                        return Boolean.TRUE;
                    }
                    CancellableContinuationImpl orCreateCancellableContinuation = BuildersKt.getOrCreateCancellableContinuation(Headers.Companion.intercepted(flowKt__ChannelsKt$emitAllImpl$1));
                    try {
                        this.continuation = orCreateCancellableContinuation;
                        try {
                            Object objUpdateCellReceive2 = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i, andIncrement, this);
                            if (objUpdateCellReceive2 == symbol) {
                                invokeOnCancellation(channelSegmentFindSegmentReceive, i);
                            } else {
                                if (objUpdateCellReceive2 == symbol2) {
                                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegmentFindSegmentReceive.cleanPrev();
                                    }
                                    ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel);
                                    while (true) {
                                        if (bufferedChannel.isClosed(BufferedChannel.sendersAndCloseStatus$FU.get(bufferedChannel), true)) {
                                            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
                                            this.continuation = null;
                                            this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                                            Throwable closeCause = bufferedChannel.getCloseCause();
                                            if (closeCause == null) {
                                                cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                                            } else {
                                                cancellableContinuationImpl.resumeWith(new Result.Failure(closeCause));
                                            }
                                        } else {
                                            long andIncrement2 = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                                            long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                            long j4 = andIncrement2 / j3;
                                            int i2 = (int) (andIncrement2 % j3);
                                            if (channelSegment2.id != j4) {
                                                channelSegmentFindSegmentReceive2 = bufferedChannel.findSegmentReceive(j4, channelSegment2);
                                                if (channelSegmentFindSegmentReceive2 == null) {
                                                }
                                            } else {
                                                channelSegmentFindSegmentReceive2 = channelSegment2;
                                            }
                                            Object objUpdateCellReceive3 = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive2, i2, andIncrement2, this);
                                            if (objUpdateCellReceive3 == BufferedChannelKt.SUSPEND) {
                                                invokeOnCancellation(channelSegmentFindSegmentReceive2, i2);
                                            } else {
                                                if (objUpdateCellReceive3 != BufferedChannelKt.FAILED) {
                                                    if (objUpdateCellReceive3 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                                        throw new IllegalStateException(C0000.decode(new byte[]{23, 88, 80, 76, 69, 85, 1, 66, 80, 80}, "b65450"));
                                                    }
                                                    channelSegmentFindSegmentReceive2.cleanPrev();
                                                    this.receiveResult = objUpdateCellReceive3;
                                                    this.continuation = null;
                                                    bool = Boolean.TRUE;
                                                    break;
                                                }
                                                if (andIncrement2 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                                    channelSegmentFindSegmentReceive2.cleanPrev();
                                                }
                                                channelSegment2 = channelSegmentFindSegmentReceive2;
                                            }
                                        }
                                    }
                                } else {
                                    channelSegmentFindSegmentReceive.cleanPrev();
                                    this.receiveResult = objUpdateCellReceive2;
                                    this.continuation = null;
                                    bool = Boolean.TRUE;
                                }
                                orCreateCancellableContinuation.resumeImpl(bool, orCreateCancellableContinuation.resumeMode, null);
                            }
                            return orCreateCancellableContinuation.getResult();
                        } catch (Throwable th) {
                            th = th;
                            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
            Throwable closeCause2 = bufferedChannel.getCloseCause();
            if (closeCause2 == null) {
                return Boolean.FALSE;
            }
            int i3 = StackTraceRecoveryKt.$r8$clinit;
            throw closeCause2;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment segment, int i) {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }
    }

    public BufferedChannel(int i) {
        long j;
        this.capacity = i;
        if (i < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{40, 89, 21, 89, 10, 92, 6, 66, 90, 93, 0, 89, 13, 93, 10, 21, 1, 3, 73, 84, 2, 94, 23, 65, 92, 21}, "a7c8f5bb95", true), C0000.decode(new byte[]{30, 19, 69, 92, 9, 17, 95, 93, 67, 0, 93, 68, 93, 91, 2}, "2364fd39cb8dcf", 0.0f), i).toString());
        }
        ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
        if (i != 0) {
            j = i != Integer.MAX_VALUE ? i : Long.MAX_VALUE;
        } else {
            j = 0;
        }
        this.bufferEnd = j;
        this.completedExpandBuffersAndPauseFlag = bufferEnd$FU.get(this);
        ChannelSegment channelSegment2 = new ChannelSegment(0L, null, this, 3);
        this.sendSegment = channelSegment2;
        this.receiveSegment = channelSegment2;
        this.bufferEndSegment = isRendezvousOrUnlimited() ? BufferedChannelKt.NULL_SEGMENT : channelSegment2;
        this._closeCause = BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    public static final ChannelSegment access$findSegmentSend(BufferedChannel bufferedChannel, long j, ChannelSegment channelSegment) {
        Object objFindSegmentInternal;
        BufferedChannel bufferedChannel2;
        ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = AtomicKt.findSegmentInternal(j, channelSegment);
            if (!AtomicKt.m20isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM19getSegmentimpl = AtomicKt.m19getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(bufferedChannel);
                    if (segment.id >= segmentM19getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM19getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, segmentM19getSegmentimpl)) {
                            if (!segment.decPointers$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            segment.remove();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(bufferedChannel) == segment);
                    if (segmentM19getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM19getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        boolean zM20isClosedimpl = AtomicKt.m20isClosedimpl(objFindSegmentInternal);
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        if (zM20isClosedimpl) {
            bufferedChannel.isClosedForSend();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < atomicLongFieldUpdater.get(bufferedChannel)) {
                channelSegment.cleanPrev();
                return null;
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) AtomicKt.m19getSegmentimpl(objFindSegmentInternal);
            long j2 = channelSegment3.id;
            if (j2 <= j) {
                return channelSegment3;
            }
            long j3 = ((long) BufferedChannelKt.SEGMENT_SIZE) * j2;
            while (true) {
                long j4 = sendersAndCloseStatus$FU.get(bufferedChannel);
                long j5 = 1152921504606846975L & j4;
                if (j5 >= j3) {
                    bufferedChannel2 = bufferedChannel;
                    break;
                }
                bufferedChannel2 = bufferedChannel;
                if (sendersAndCloseStatus$FU.compareAndSet(bufferedChannel2, j4, (((long) ((int) (j4 >> 60))) << 60) + j5)) {
                    break;
                }
                bufferedChannel = bufferedChannel2;
            }
            if (j2 * ((long) BufferedChannelKt.SEGMENT_SIZE) < atomicLongFieldUpdater.get(bufferedChannel2)) {
                channelSegment3.cleanPrev();
            }
        }
        return null;
    }

    public static final void access$onClosedSendOnNoWaiterSuspend(BufferedChannel bufferedChannel, IndexedValue indexedValue, CancellableContinuationImpl cancellableContinuationImpl) {
        cancellableContinuationImpl.resumeWith(new Result.Failure(bufferedChannel.getSendException()));
    }

    public static final int access$updateCellSend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        channelSegment.setElementLazy(i, obj);
        if (z) {
            return bufferedChannel.updateCellSendSlow(channelSegment, i, obj, j, obj2, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferedChannel.bufferOrRendezvousSend(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(null, i, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(null, i, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.setElementLazy(i, null);
            if (bufferedChannel.tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                return 0;
            }
            Symbol symbol = BufferedChannelKt.INTERRUPTED_RCV;
            if (channelSegment.data.getAndSet((i * 2) + 1, symbol) == symbol) {
                return 5;
            }
            channelSegment.onCancelledRequest(i, true);
            return 5;
        }
        return bufferedChannel.updateCellSendSlow(channelSegment, i, obj, j, obj2, z);
    }

    public static void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
        if ((atomicLongFieldUpdater.addAndGet(bufferedChannel, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(bufferedChannel) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    public static Object m13receiveCatchingJP2dKIU$suspendImpl(BufferedChannel bufferedChannel, ContinuationImpl continuationImpl) throws Throwable {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        ChannelSegment channelSegment;
        if (continuationImpl instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuationImpl;
            int i = bufferedChannel$receiveCatching$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label = i - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuationImpl);
            }
        } else {
            bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuationImpl);
        }
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$2 = bufferedChannel$receiveCatching$1;
        Object obj = bufferedChannel$receiveCatching$2.result;
        int i2 = bufferedChannel$receiveCatching$2.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException(C0000.decode(new byte[]{87, 81, 85, 85, 21, 16, 91, 65, 65, 16, 6, 21, 77, 9, 3, 16, 20, 82, 92, 95, 90, 22, 81, 65, 65, 11, 13, 16, 87, 15, 3, 16, 20, 71, 80, 77, 93, 68, 87, 14, 20, 13, 22, 18, 81, 10, 3}, "40995d4afbcf8df7"));
            }
            ResultKt.throwOnFailure(obj);
            return ((ChannelResult) obj).holder;
        }
        ResultKt.throwOnFailure(obj);
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(bufferedChannel);
        while (!bufferedChannel.isClosed(sendersAndCloseStatus$FU.get(bufferedChannel), true)) {
            long andIncrement = receivers$FU.getAndIncrement(bufferedChannel);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i3 = (int) (andIncrement % j);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel2 = bufferedChannel;
            Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i3, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException(C0000.decode(new byte[]{71, 93, 87, 75, 68, 82, 83, 71, 92, 81}, "2323470395379e73"));
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment.cleanPrev();
                    return objUpdateCellReceive;
                }
                bufferedChannel$receiveCatching$2.label = 1;
                Object objM15receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel2.m15receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i3, andIncrement, bufferedChannel$receiveCatching$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objM15receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutineSingletons ? coroutineSingletons : objM15receiveCatchingOnNoWaiterSuspendGKJJFZk;
            }
            if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
            bufferedChannel = bufferedChannel2;
        }
        return new ChannelResult.Closed(bufferedChannel.getCloseCause());
    }

    public static boolean tryResumeSender(Object obj) {
        if (obj instanceof CancellableContinuation) {
            return BufferedChannelKt.tryResume0((CancellableContinuation) obj, Unit.INSTANCE, null);
        }
        throw new IllegalStateException((C0000.decode(new byte[]{98, 90, 84, 29, 72, 93, 85, 68, 0, 5, 67, 21, 88, 12, 77, 92, 69, 14, 17}, "741e8860eacb9e99", 1) + obj).toString());
    }

    public final boolean bufferOrRendezvousSend(long j) {
        return j < bufferEnd$FU.get(this) || j < receivers$FU.get(this) + ((long) this.capacity);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(C0000.decode(new byte[]{33, 11, 0, 11, 13, 80, 84, 65, 79, 5, 70, 24, 1, 2, 15, 6, 6, 89, 84, 4, 92}, "bcaec58a8d58"));
        }
        closeOrCancelImpl(cancellationException, true);
    }

    public final boolean closeOrCancelImpl(Throwable th, boolean z) {
        BufferedChannel bufferedChannel;
        boolean z2;
        long j;
        long j2;
        long j3;
        Object obj;
        long j4;
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        if (!z) {
            bufferedChannel = this;
            break;
        }
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                bufferedChannel = this;
                break;
            }
            ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
            bufferedChannel = this;
        } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j5, (j5 & 1152921504606846975L) + (((long) 1) << 60)));
        Symbol symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, th)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != symbol) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                j4 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j4, (((long) 3) << 60) + (j4 & 1152921504606846975L)));
        } else {
            do {
                j = atomicLongFieldUpdater.get(this);
                int i = (int) (j >> 60);
                if (i == 0) {
                    j2 = j & 1152921504606846975L;
                    j3 = 2;
                } else {
                    if (i != 1) {
                        break;
                    }
                    j2 = j & 1152921504606846975L;
                    j3 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j, (j3 << 60) + j2));
        }
        isClosedForSend();
        if (z2) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$FU;
                obj = atomicReferenceFieldUpdater2.get(this);
                Symbol symbol2 = obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, symbol2)) {
                        break loop3;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == obj);
            }
            if (obj != null) {
                Intrinsics.beforeCheckcastToFunctionOfArity(1, obj);
                ((Function1) obj).invoke(getCloseCause());
                return z2;
            }
        }
        return z2;
    }

    public final ChannelSegment completeClose(long j) {
        Object objM21plusFjFbRPM;
        long j2;
        Object obj = bufferEndSegment$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$FU.get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        ConcurrentLinkedListNode concurrentLinkedListNode = (ConcurrentLinkedListNode) obj;
        loop0: while (true) {
            concurrentLinkedListNode.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ConcurrentLinkedListNode._next$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(concurrentLinkedListNode);
            Symbol symbol = AtomicKt.CLOSED;
            objM21plusFjFbRPM = null;
            if (obj2 == symbol) {
                break;
            }
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) obj2;
            if (concurrentLinkedListNode2 == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(concurrentLinkedListNode, null, symbol)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(concurrentLinkedListNode) == null);
            } else {
                concurrentLinkedListNode = concurrentLinkedListNode2;
            }
        }
        ChannelSegment channelSegment3 = (ChannelSegment) concurrentLinkedListNode;
        if (isConflatedDropOldest()) {
            ChannelSegment channelSegment4 = channelSegment3;
            loop2: while (true) {
                int i = BufferedChannelKt.SEGMENT_SIZE - 1;
                while (true) {
                    if (-1 < i) {
                        j2 = (channelSegment4.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                        if (j2 >= receivers$FU.get(this)) {
                            while (true) {
                                Object state$kotlinx_coroutines_core = channelSegment4.getState$kotlinx_coroutines_core(i);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                                        break;
                                    }
                                    break loop2;
                                }
                                if (channelSegment4.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i, BufferedChannelKt.CHANNEL_CLOSED)) {
                                    channelSegment4.onSlotCleaned();
                                    break;
                                }
                            }
                            i--;
                        }
                    } else {
                        channelSegment4 = (ChannelSegment) ((ConcurrentLinkedListNode) ConcurrentLinkedListNode._prev$FU.get(channelSegment4));
                        if (channelSegment4 == null) {
                        }
                    }
                    j2 = -1;
                    break;
                }
            }
            if (j2 != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(j2);
            }
        }
        loop5: for (ChannelSegment channelSegment5 = channelSegment3; channelSegment5 != null; channelSegment5 = (ChannelSegment) ((ConcurrentLinkedListNode) ConcurrentLinkedListNode._prev$FU.get(channelSegment5))) {
            for (int i2 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i2; i2--) {
                if ((channelSegment5.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i2) < j) {
                    break loop5;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment5.getState$kotlinx_coroutines_core(i2);
                    if (state$kotlinx_coroutines_core2 != null && state$kotlinx_coroutines_core2 != BufferedChannelKt.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core2 instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core2 instanceof Waiter)) {
                                break;
                            }
                            if (channelSegment5.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                objM21plusFjFbRPM = AtomicKt.m21plusFjFbRPM(objM21plusFjFbRPM, state$kotlinx_coroutines_core2);
                                channelSegment5.onCancelledRequest(i2, true);
                                break;
                            }
                        } else {
                            if (channelSegment5.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                objM21plusFjFbRPM = AtomicKt.m21plusFjFbRPM(objM21plusFjFbRPM, ((WaiterEB) state$kotlinx_coroutines_core2).waiter);
                                channelSegment5.onCancelledRequest(i2, true);
                                break;
                            }
                        }
                    } else {
                        if (channelSegment5.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i2, BufferedChannelKt.CHANNEL_CLOSED)) {
                            channelSegment5.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
        }
        if (objM21plusFjFbRPM != null) {
            if (!(objM21plusFjFbRPM instanceof ArrayList)) {
                resumeWaiterOnClosedChannel((Waiter) objM21plusFjFbRPM, true);
                return channelSegment3;
            }
            ArrayList arrayList = (ArrayList) objM21plusFjFbRPM;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeWaiterOnClosedChannel((Waiter) arrayList.get(size), true);
            }
        }
        return channelSegment3;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
            long j2 = atomicLongFieldUpdater.get(this);
            if (j < Math.max(((long) this.capacity) + j2, bufferEnd$FU.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j2, 1 + j2)) {
                long j3 = BufferedChannelKt.SEGMENT_SIZE;
                long j4 = j2 / j3;
                int i = (int) (j2 % j3);
                if (channelSegment.id != j4) {
                    ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j4, channelSegment);
                    if (channelSegmentFindSegmentReceive != null) {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                }
                ChannelSegment channelSegment2 = channelSegment;
                if (updateCellReceive(channelSegment2, i, j2, null) != BufferedChannelKt.FAILED || j2 < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                channelSegment = channelSegment2;
            }
        }
    }

    public final void expandBuffer() {
        Object objFindSegmentInternal;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
        ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        while (true) {
            long andIncrement = bufferEnd$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.getNext() != null) {
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this);
                return;
            }
            if (channelSegment.id != j) {
                BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
                while (true) {
                    objFindSegmentInternal = AtomicKt.findSegmentInternal(j, channelSegment);
                    if (!AtomicKt.m20isClosedimpl(objFindSegmentInternal)) {
                        Segment segmentM19getSegmentimpl = AtomicKt.m19getSegmentimpl(objFindSegmentInternal);
                        while (true) {
                            Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                            if (segment.id >= segmentM19getSegmentimpl.id) {
                                break;
                            }
                            if (!segmentM19getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                                break;
                            }
                            do {
                                if (atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM19getSegmentimpl)) {
                                    if (!segment.decPointers$kotlinx_coroutines_core()) {
                                        break;
                                    }
                                    segment.remove();
                                    break;
                                }
                            } while (atomicReferenceFieldUpdater.get(this) == segment);
                            if (segmentM19getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM19getSegmentimpl.remove();
                            }
                        }
                    } else {
                        break;
                    }
                }
                ChannelSegment channelSegment2 = null;
                if (AtomicKt.m20isClosedimpl(objFindSegmentInternal)) {
                    isClosedForSend();
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                    incCompletedExpandBufferAttempts$default(this);
                } else {
                    ChannelSegment channelSegment3 = (ChannelSegment) AtomicKt.m19getSegmentimpl(objFindSegmentInternal);
                    long j2 = channelSegment3.id;
                    if (j2 > j) {
                        long j3 = j2 * ((long) BufferedChannelKt.SEGMENT_SIZE);
                        if (bufferEnd$FU.compareAndSet(this, 1 + andIncrement, j3)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
                            if ((atomicLongFieldUpdater.addAndGet(this, j3 - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            incCompletedExpandBufferAttempts$default(this);
                        }
                    } else {
                        channelSegment2 = channelSegment3;
                    }
                }
                if (channelSegment2 == null) {
                    continue;
                } else {
                    channelSegment = channelSegment2;
                }
            }
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            boolean z = state$kotlinx_coroutines_core instanceof Waiter;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = receivers$FU;
            if (!z || andIncrement < atomicLongFieldUpdater2.get(this) || !channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i, BufferedChannelKt.RESUMING_BY_EB)) {
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core2 instanceof Waiter) {
                        if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                            if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, new WaiterEB((Waiter) state$kotlinx_coroutines_core2))) {
                                incCompletedExpandBufferAttempts$default(this);
                                return;
                            }
                        } else if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, BufferedChannelKt.RESUMING_BY_EB)) {
                            if (!tryResumeSender(state$kotlinx_coroutines_core2)) {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                                channelSegment.onSlotCleaned();
                                break;
                            } else {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                                incCompletedExpandBufferAttempts$default(this);
                                return;
                            }
                        }
                    } else {
                        if (state$kotlinx_coroutines_core2 == BufferedChannelKt.INTERRUPTED_SEND) {
                            break;
                        }
                        if (state$kotlinx_coroutines_core2 == null) {
                            if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, BufferedChannelKt.IN_BUFFER)) {
                                incCompletedExpandBufferAttempts$default(this);
                                return;
                            }
                        } else if (state$kotlinx_coroutines_core2 == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core2 == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core2 == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core2 == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                            incCompletedExpandBufferAttempts$default(this);
                            return;
                        } else if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_RCV) {
                            throw new IllegalStateException((C0000.decode(new byte[]{54, 86, 80, 65, 17, 3, 83, 70, 0, 85, 19, 90, 6, 84, 89, 25, 18, 18, 81, 70, 0, 11, 19}, "c859af02e139") + state$kotlinx_coroutines_core2).toString());
                        }
                    }
                }
                incCompletedExpandBufferAttempts$default(this);
            } else if (tryResumeSender(state$kotlinx_coroutines_core)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                incCompletedExpandBufferAttempts$default(this);
                return;
            } else {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                channelSegment.onSlotCleaned();
                incCompletedExpandBufferAttempts$default(this);
            }
        }
    }

    public final ChannelSegment findSegmentReceive(long j, ChannelSegment channelSegment) {
        Object objFindSegmentInternal;
        long j2;
        ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = AtomicKt.findSegmentInternal(j, channelSegment);
            if (!AtomicKt.m20isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM19getSegmentimpl = AtomicKt.m19getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM19getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM19getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM19getSegmentimpl)) {
                            if (!segment.decPointers$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            segment.remove();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == segment);
                    if (segmentM19getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM19getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (AtomicKt.m20isClosedimpl(objFindSegmentInternal)) {
            isClosedForSend();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
                return null;
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) AtomicKt.m19getSegmentimpl(objFindSegmentInternal);
            long j3 = channelSegment3.id;
            if (!isRendezvousOrUnlimited() && j <= bufferEnd$FU.get(this) / ((long) BufferedChannelKt.SEGMENT_SIZE)) {
                loop3: while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$FU;
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                    if (segment2.id >= j3 || !channelSegment3.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment3)) {
                            if (!segment2.decPointers$kotlinx_coroutines_core()) {
                                break loop3;
                            }
                            segment2.remove();
                            break loop3;
                        }
                    } while (atomicReferenceFieldUpdater2.get(this) == segment2);
                    if (channelSegment3.decPointers$kotlinx_coroutines_core()) {
                        channelSegment3.remove();
                    }
                }
            }
            if (j3 <= j) {
                return channelSegment3;
            }
            long j4 = j3 * ((long) BufferedChannelKt.SEGMENT_SIZE);
            do {
                j2 = receivers$FU.get(this);
                if (j2 >= j4) {
                    break;
                }
            } while (!receivers$FU.compareAndSet(this, j2, j4));
            if (j3 * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment3.cleanPrev();
            }
        }
        return null;
    }

    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$FU.get(this);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(C0000.decode(new byte[]{123, 81, 84, 95, 95, 86, 84, 25, 66, 80, 66, 19, 91, 85, 90, 66, 84, 87}, "895113")) : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 1152921504606846975L;
    }

    public final boolean isClosed(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i != 0 && i != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
            if (i == 2) {
                completeClose(1152921504606846975L & j);
                if (z) {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
                        ChannelSegment channelSegmentFindSegmentReceive = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
                        long j2 = atomicLongFieldUpdater.get(this);
                        if (getSendersCounter$kotlinx_coroutines_core() <= j2) {
                            break;
                        }
                        long j3 = BufferedChannelKt.SEGMENT_SIZE;
                        long j4 = j2 / j3;
                        if (channelSegmentFindSegmentReceive.id != j4 && (channelSegmentFindSegmentReceive = findSegmentReceive(j4, channelSegmentFindSegmentReceive)) == null) {
                            if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id < j4) {
                                break;
                            }
                        } else {
                            channelSegmentFindSegmentReceive.cleanPrev();
                            int i2 = (int) (j2 % j3);
                            while (true) {
                                Object state$kotlinx_coroutines_core = channelSegmentFindSegmentReceive.getState$kotlinx_coroutines_core(i2);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED && (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_RCV || j2 != atomicLongFieldUpdater.get(this))))) {
                                        break;
                                        break;
                                        break;
                                        break;
                                        break;
                                        break;
                                    }
                                } else if (channelSegmentFindSegmentReceive.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i2, BufferedChannelKt.POISONED)) {
                                    expandBuffer();
                                    break;
                                }
                            }
                            receivers$FU.compareAndSet(this, j2, j2 + 1);
                        }
                    }
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException(NetworkType$EnumUnboxingLocalUtility.m("unexpected close status: ", i).toString());
                }
                ChannelSegment channelSegmentCompleteClose = completeClose(1152921504606846975L & j);
                Object objM21plusFjFbRPM = null;
                loop0: do {
                    for (int i3 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i3; i3--) {
                        long j5 = (channelSegmentCompleteClose.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i3);
                        while (true) {
                            Object state$kotlinx_coroutines_core2 = channelSegmentCompleteClose.getState$kotlinx_coroutines_core(i3);
                            if (state$kotlinx_coroutines_core2 == BufferedChannelKt.DONE_RCV) {
                                break loop0;
                            }
                            if (state$kotlinx_coroutines_core2 != BufferedChannelKt.BUFFERED) {
                                if (state$kotlinx_coroutines_core2 != BufferedChannelKt.IN_BUFFER && state$kotlinx_coroutines_core2 != null) {
                                    if (!(state$kotlinx_coroutines_core2 instanceof Waiter) && !(state$kotlinx_coroutines_core2 instanceof WaiterEB)) {
                                        Symbol symbol = BufferedChannelKt.RESUMING_BY_EB;
                                        if (state$kotlinx_coroutines_core2 == symbol || state$kotlinx_coroutines_core2 == BufferedChannelKt.RESUMING_BY_RCV) {
                                            break loop0;
                                        }
                                        if (state$kotlinx_coroutines_core2 != symbol) {
                                            break;
                                        }
                                    } else {
                                        if (j5 < atomicLongFieldUpdater.get(this)) {
                                            break loop0;
                                        }
                                        Waiter waiter = state$kotlinx_coroutines_core2 instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core2).waiter : (Waiter) state$kotlinx_coroutines_core2;
                                        if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i3, BufferedChannelKt.CHANNEL_CLOSED)) {
                                            objM21plusFjFbRPM = AtomicKt.m21plusFjFbRPM(objM21plusFjFbRPM, waiter);
                                            channelSegmentCompleteClose.setElementLazy(i3, null);
                                            channelSegmentCompleteClose.onSlotCleaned();
                                            break;
                                        }
                                    }
                                } else {
                                    if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i3, BufferedChannelKt.CHANNEL_CLOSED)) {
                                        channelSegmentCompleteClose.onSlotCleaned();
                                        break;
                                    }
                                }
                            } else {
                                if (j5 < atomicLongFieldUpdater.get(this)) {
                                    break loop0;
                                }
                                if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i3, BufferedChannelKt.CHANNEL_CLOSED)) {
                                    channelSegmentCompleteClose.setElementLazy(i3, null);
                                    channelSegmentCompleteClose.onSlotCleaned();
                                    break;
                                }
                            }
                        }
                    }
                    channelSegmentCompleteClose = (ChannelSegment) ((ConcurrentLinkedListNode) ConcurrentLinkedListNode._prev$FU.get(channelSegmentCompleteClose));
                } while (channelSegmentCompleteClose != null);
                if (objM21plusFjFbRPM != null) {
                    if (objM21plusFjFbRPM instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) objM21plusFjFbRPM;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            resumeWaiterOnClosedChannel((Waiter) arrayList.get(size), false);
                        }
                    } else {
                        resumeWaiterOnClosedChannel((Waiter) objM21plusFjFbRPM, false);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final boolean isClosedForSend() {
        return isClosed(sendersAndCloseStatus$FU.get(this), false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    public final boolean isRendezvousOrUnlimited() {
        long j = bufferEnd$FU.get(this);
        return j == 0 || j == Long.MAX_VALUE;
    }

    public final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment channelSegment) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.isRemoved() || (channelSegment2 = (ChannelSegment) channelSegment.getNext()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= channelSegment.id) {
                        return;
                    }
                    if (!channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, segment, channelSegment)) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                                return;
                            }
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == segment);
                    if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                        channelSegment.remove();
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
        }
    }

    public final Object onClosedSend(IndexedValue indexedValue, CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Headers.Companion.intercepted(combineKt$combineInternal$2$1$1$emit$1));
        DisposableHandle disposableHandleInstallParentHandle = cancellableContinuationImpl.installParentHandle();
        if (disposableHandleInstallParentHandle != null && !(CancellableContinuationImpl._state$FU.get(cancellableContinuationImpl) instanceof NotCompleted)) {
            disposableHandleInstallParentHandle.dispose();
            CancellableContinuationImpl._parentHandle$FU.set(cancellableContinuationImpl, NonDisposableHandle.INSTANCE);
        }
        cancellableContinuationImpl.resumeWith(new Result.Failure(getSendException()));
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public final Object mo14receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2) {
        return m13receiveCatchingJP2dKIU$suspendImpl(this, combineKt$combineInternal$2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    public final Object m15receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment channelSegment, int i, long j, ContinuationImpl continuationImpl) throws Throwable {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        ChannelResult channelResult;
        ChannelSegment channelSegment2;
        if (continuationImpl instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuationImpl;
            int i2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = i2 - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuationImpl);
            }
        } else {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuationImpl);
        }
        Object result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        int i3 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(result);
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
            CancellableContinuationImpl orCreateCancellableContinuation = BuildersKt.getOrCreateCancellableContinuation(Headers.Companion.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
            try {
                ReceiveCatching receiveCatching = new ReceiveCatching(orCreateCancellableContinuation);
                BufferedChannel bufferedChannel = this;
                Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, j, receiveCatching);
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                    receiveCatching.invokeOnCancellation(channelSegment, i);
                } else {
                    if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                        if (j < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment3 = (ChannelSegment) receiveSegment$FU.get(this);
                        while (true) {
                            if (isClosed(sendersAndCloseStatus$FU.get(this), true)) {
                                orCreateCancellableContinuation.resumeWith(new ChannelResult(new ChannelResult.Closed(getCloseCause())));
                            } else {
                                long andIncrement = receivers$FU.getAndIncrement(this);
                                long j2 = BufferedChannelKt.SEGMENT_SIZE;
                                long j3 = andIncrement / j2;
                                int i4 = (int) (andIncrement % j2);
                                if (channelSegment3.id != j3) {
                                    ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j3, channelSegment3);
                                    if (channelSegmentFindSegmentReceive != null) {
                                        channelSegment2 = channelSegmentFindSegmentReceive;
                                    }
                                } else {
                                    channelSegment2 = channelSegment3;
                                }
                                Object objUpdateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment2, i4, andIncrement, receiveCatching);
                                ChannelSegment channelSegment4 = channelSegment2;
                                if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND) {
                                    receiveCatching.invokeOnCancellation(channelSegment4, i4);
                                } else if (objUpdateCellReceive2 == BufferedChannelKt.FAILED) {
                                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment4.cleanPrev();
                                    }
                                    bufferedChannel = this;
                                    channelSegment3 = channelSegment4;
                                } else {
                                    if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                        throw new IllegalStateException(C0000.decode(new byte[]{22, 93, 0, 30, 65, 83, 0, 71, 0, 2}, "c3ef16"));
                                    }
                                    channelSegment4.cleanPrev();
                                    channelResult = new ChannelResult(objUpdateCellReceive2);
                                }
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        channelResult = new ChannelResult(objUpdateCellReceive);
                    }
                    orCreateCancellableContinuation.resumeImpl(channelResult, orCreateCancellableContinuation.resumeMode, null);
                }
                result = orCreateCancellableContinuation.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (result == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException(C0000.decode(new byte[]{87, 86, 93, 93, 23, 21, 87, 22, 19, 69, 84, 66, 66, 12, 93, 17, 20, 85, 84, 87, 88, 19, 93, 22, 19, 94, 95, 71, 88, 10, 93, 17, 20, 64, 88, 69, 95, 65, 91, 89, 70, 88, 68, 69, 94, 15, 93}, "47117a86"));
            }
            ResultKt.throwOnFailure(result);
        }
        return ((ChannelResult) result).holder;
    }

    public final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        Throwable sendException;
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            if (z) {
                sendException = getCloseCause();
                if (sendException == null) {
                    sendException = new ClosedReceiveChannelException(C0000.decode(new byte[]{39, 90, 4, 12, 88, 85, 85, 67, 19, 0, 71, 16, 80, 95, 94, 64, 1, 86}, "d2eb609cda403313", 3));
                }
            } else {
                sendException = getSendException();
            }
            continuation.resumeWith(new Result.Failure(sendException));
            return;
        }
        if (waiter instanceof ReceiveCatching) {
            ((ReceiveCatching) waiter).cont.resumeWith(new ChannelResult(new ChannelResult.Closed(getCloseCause())));
            return;
        }
        if (!(waiter instanceof BufferedChannelIterator)) {
            throw new IllegalStateException((C0000.decode(new byte[]{96, 11, 87, 29, 22, 4, 82, 67, 82, 1, 25, 67, 84, 12, 70, 0, 20, 91, 17}, "5e2efa177e94") + waiter).toString());
        }
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) waiter;
        CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.continuation;
        bufferedChannelIterator.continuation = null;
        bufferedChannelIterator.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
        Throwable closeCause = BufferedChannel.this.getCloseCause();
        if (closeCause == null) {
            cancellableContinuationImpl.resumeWith(Boolean.FALSE);
        } else {
            cancellableContinuationImpl.resumeWith(new Result.Failure(closeCause));
        }
    }

    /* JADX WARN: Code duplicated, block: B:93:0x0173  */
    /* JADX WARN: Code duplicated, block: B:95:0x0176 A[RETURN] */
    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(IndexedValue indexedValue, CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1) throws Throwable {
        Unit unit;
        Object result;
        IndexedValue indexedValue2;
        BufferedChannel bufferedChannel;
        ChannelSegment channelSegment;
        int i;
        BufferedChannel bufferedChannel2 = this;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
        ChannelSegment channelSegment2 = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel2);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(bufferedChannel2);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosed = bufferedChannel2.isClosed(andIncrement, false);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = i2;
            long j3 = j / j2;
            int i3 = (int) (j % j2);
            long j4 = channelSegment2.id;
            unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (j4 != j3) {
                ChannelSegment channelSegmentAccess$findSegmentSend = access$findSegmentSend(bufferedChannel2, j3, channelSegment2);
                if (channelSegmentAccess$findSegmentSend != null) {
                    channelSegment2 = channelSegmentAccess$findSegmentSend;
                } else if (zIsClosed) {
                    Object objOnClosedSend = onClosedSend(indexedValue, combineKt$combineInternal$2$1$1$emit$1);
                    if (objOnClosedSend != coroutineSingletons) {
                        break;
                    }
                    return objOnClosedSend;
                }
            }
            int iAccess$updateCellSend = access$updateCellSend(bufferedChannel2, channelSegment2, i3, indexedValue, j, null, zIsClosed);
            if (iAccess$updateCellSend == 0) {
                channelSegment2.cleanPrev();
                return unit;
            }
            if (iAccess$updateCellSend == 1) {
                break;
            }
            if (iAccess$updateCellSend != 2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = receivers$FU;
                if (iAccess$updateCellSend == 3) {
                    CancellableContinuationImpl orCreateCancellableContinuation = BuildersKt.getOrCreateCancellableContinuation(Headers.Companion.intercepted(combineKt$combineInternal$2$1$1$emit$1));
                    IndexedValue indexedValue3 = indexedValue;
                    try {
                        int iAccess$updateCellSend2 = access$updateCellSend(bufferedChannel2, channelSegment2, i3, indexedValue3, j, orCreateCancellableContinuation, false);
                        try {
                            if (iAccess$updateCellSend2 != 0) {
                                if (iAccess$updateCellSend2 == 1) {
                                    orCreateCancellableContinuation.resumeWith(unit);
                                } else if (iAccess$updateCellSend2 != 2) {
                                    if (iAccess$updateCellSend2 != 4) {
                                        String strDecode = C0000.decode(new byte[]{77, 15, 92, 78, 64, 81, 91, 21, 92, 82}, "8a9604", 6);
                                        if (iAccess$updateCellSend2 != 5) {
                                            throw new IllegalStateException(strDecode);
                                        }
                                        channelSegment2.cleanPrev();
                                        ChannelSegment channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel2);
                                        while (true) {
                                            long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(bufferedChannel2);
                                            long j5 = andIncrement2 & 1152921504606846975L;
                                            boolean zIsClosed2 = bufferedChannel2.isClosed(andIncrement2, false);
                                            int i4 = BufferedChannelKt.SEGMENT_SIZE;
                                            long j6 = i4;
                                            strDecode = strDecode;
                                            long j7 = j5 / j6;
                                            int i5 = (int) (j5 % j6);
                                            if (channelSegment3.id != j7) {
                                                ChannelSegment channelSegmentAccess$findSegmentSend2 = access$findSegmentSend(bufferedChannel2, j7, channelSegment3);
                                                if (channelSegmentAccess$findSegmentSend2 != null) {
                                                    i = i4;
                                                    channelSegment = channelSegmentAccess$findSegmentSend2;
                                                } else if (zIsClosed2) {
                                                    access$onClosedSendOnNoWaiterSuspend(bufferedChannel2, indexedValue3, orCreateCancellableContinuation);
                                                    break;
                                                }
                                            } else {
                                                channelSegment = channelSegment3;
                                                i = i4;
                                            }
                                            int iAccess$updateCellSend3 = access$updateCellSend(bufferedChannel2, channelSegment, i5, indexedValue3, j5, orCreateCancellableContinuation, zIsClosed2);
                                            IndexedValue indexedValue4 = indexedValue3;
                                            bufferedChannel = bufferedChannel2;
                                            ChannelSegment channelSegment4 = channelSegment;
                                            indexedValue2 = indexedValue4;
                                            if (iAccess$updateCellSend3 == 0) {
                                                channelSegment4.cleanPrev();
                                            } else if (iAccess$updateCellSend3 != 1) {
                                                if (iAccess$updateCellSend3 == 2) {
                                                    if (!zIsClosed2) {
                                                        orCreateCancellableContinuation.invokeOnCancellation(channelSegment4, i5 + i);
                                                        break;
                                                    }
                                                    channelSegment4.onSlotCleaned();
                                                } else {
                                                    if (iAccess$updateCellSend3 == 3) {
                                                        throw new IllegalStateException(strDecode);
                                                    }
                                                    if (iAccess$updateCellSend3 != 4) {
                                                        if (iAccess$updateCellSend3 == 5) {
                                                            channelSegment4.cleanPrev();
                                                        }
                                                        channelSegment3 = channelSegment4;
                                                        bufferedChannel2 = bufferedChannel;
                                                        indexedValue3 = indexedValue2;
                                                    } else if (j5 < atomicLongFieldUpdater2.get(bufferedChannel)) {
                                                        channelSegment4.cleanPrev();
                                                    }
                                                }
                                            }
                                        }
                                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                        throw th;
                                    }
                                    indexedValue2 = indexedValue3;
                                    bufferedChannel = bufferedChannel2;
                                    if (j < atomicLongFieldUpdater2.get(bufferedChannel)) {
                                        channelSegment2.cleanPrev();
                                    }
                                    access$onClosedSendOnNoWaiterSuspend(bufferedChannel, indexedValue2, orCreateCancellableContinuation);
                                    break;
                                } else {
                                    orCreateCancellableContinuation.invokeOnCancellation(channelSegment2, i3 + i2);
                                }
                                result = orCreateCancellableContinuation.getResult();
                                if (result != coroutineSingletons) {
                                    result = unit;
                                }
                                if (result == coroutineSingletons) {
                                    return result;
                                }
                            } else {
                                channelSegment2.cleanPrev();
                            }
                            orCreateCancellableContinuation.resumeWith(unit);
                            result = orCreateCancellableContinuation.getResult();
                            if (result != coroutineSingletons) {
                                result = unit;
                            }
                            if (result == coroutineSingletons) {
                                return result;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    if (iAccess$updateCellSend == 4) {
                        if (j < atomicLongFieldUpdater2.get(bufferedChannel2)) {
                            channelSegment2.cleanPrev();
                        }
                        Object objOnClosedSend2 = onClosedSend(indexedValue, combineKt$combineInternal$2$1$1$emit$1);
                        if (objOnClosedSend2 != coroutineSingletons) {
                            break;
                        }
                        return objOnClosedSend2;
                    }
                    if (iAccess$updateCellSend == 5) {
                        channelSegment2.cleanPrev();
                    }
                }
            } else if (zIsClosed) {
                channelSegment2.onSlotCleaned();
                Object objOnClosedSend3 = onClosedSend(indexedValue, combineKt$combineInternal$2$1$1$emit$1);
                if (objOnClosedSend3 == coroutineSingletons) {
                    return objOnClosedSend3;
                }
            }
            return unit;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        int i = (int) (sendersAndCloseStatus$FU.get(this) >> 60);
        if (i == 2) {
            sb.append(C0000.decode(new byte[]{0, 92, 13, 66, 0, 2, 79}, "c0b1ef", 0.0f));
        } else if (i == 3) {
            sb.append(C0000.decode(new byte[]{84, 86, 91, 82, 84, 93, 91, 82, 81, 29}, "775111", 0.0f));
        }
        sb.append(C0000.decode(new byte[]{80, 0, 68, 7, 85, 90, 71, 24, 9}, "3a4f63", false) + this.capacity + ',');
        sb.append(C0000.decode(new byte[]{1, 83, 76, 86, 89, 110}, "e287d5", false));
        int i2 = 0;
        boolean z = true;
        List listListOf = CollectionsKt__CollectionsKt.listOf(receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        long j3 = receivers$FU.get(this);
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: while (true) {
            int i3 = BufferedChannelKt.SEGMENT_SIZE;
            int i4 = i2;
            while (i4 < i3) {
                long j4 = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i4);
                if (j4 >= sendersCounter$kotlinx_coroutines_core && j4 >= j3) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i4);
                boolean z2 = z;
                Object obj2 = channelSegment.data.get(i4 * 2);
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    string = (j4 >= j3 || j4 < sendersCounter$kotlinx_coroutines_core) ? (j4 >= sendersCounter$kotlinx_coroutines_core || j4 < j3) ? C0000.decode(new byte[]{81, 13, 88, 21}, "2b6a31e6a58b") : C0000.decode(new byte[]{64, 4, 10, 80}, "3ad4ffc0", 0.0f) : C0000.decode(new byte[]{66, 1, 90, 87, 92, 79, 81}, "0d9259426ccb6f", 0.0f);
                } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    string = C0000.decode(new byte[]{70, 6, 86, 80, 8, 20, 86, 117, 2, 22, 87, 11, 92, 91, 6}, "4c55ab36cb", 0);
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    string = C0000.decode(new byte[]{113, 122, 24}, "4802216d", 7) + state$kotlinx_coroutines_core + ')';
                } else if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV) ? z2 : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    string = C0000.decode(new byte[]{65, 84, 16, 77, 92, 92, 92, 81, 106, 68, 3, 87, 87, 84, 17}, "31c8152657f9");
                } else {
                    if (!(state$kotlinx_coroutines_core == null ? z2 : state$kotlinx_coroutines_core.equals(BufferedChannelKt.IN_BUFFER) ? z2 : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV) ? z2 : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.POISONED) ? z2 : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_RCV) ? z2 : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_SEND) ? z2 : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.CHANNEL_CLOSED))) {
                        string = state$kotlinx_coroutines_core.toString();
                    }
                    i4++;
                    z = z2;
                }
                if (obj2 != null) {
                    sb.append(C0000.decode(new byte[]{74}, "bfb4477b1736", 0.0f) + string + ',' + obj2 + C0000.decode(new byte[]{74, 31}, "c3b06c05", 0.0f));
                } else {
                    sb.append(string + ',');
                }
                i4++;
                z = z2;
            }
            boolean z3 = z;
            channelSegment = (ChannelSegment) channelSegment.getNext();
            if (channelSegment == null) {
                break;
            }
            z = z3;
            i2 = 0;
        }
        if (sb.length() == 0) {
            throw new NoSuchElementException(C0000.decode(new byte[]{39, 80, 0, 70, 21, 66, 1, 73, 20, 81, 91, 82, 1, 24, 8, 71, 21, 84, 9, 72, 21, 77, 27}, "d8a451", true));
        }
        if (sb.charAt(StringsKt.getLastIndex(sb)) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(C0000.decode(new byte[]{111}, "2a832ef35d29", true));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo16tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        long j = atomicLongFieldUpdater.get(this);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = sendersAndCloseStatus$FU;
        long j2 = atomicLongFieldUpdater2.get(this);
        if (isClosed(j2, true)) {
            return new ChannelResult.Closed(getCloseCause());
        }
        long j3 = j2 & 1152921504606846975L;
        ChannelResult.Failed failed = ChannelResult.failed;
        if (j >= j3) {
            return failed;
        }
        Object obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosed(atomicLongFieldUpdater2.get(this), true)) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = andIncrement / j4;
            int i = (int) (andIncrement % j4);
            if (channelSegment2.id != j5) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j5, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i, andIncrement, obj);
            ChannelSegment channelSegment3 = channelSegment;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment3, i);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment3.onSlotCleaned();
                return failed;
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException(C0000.decode(new byte[]{23, 92, 92, 77, 69, 92, 1, 70, 92, 81}, "b29559"));
                }
                channelSegment3.cleanPrev();
                return objUpdateCellReceive;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment3.cleanPrev();
            }
            channelSegment2 = channelSegment3;
        }
        return new ChannelResult.Closed(getCloseCause());
    }

    public final boolean tryResumeReceiver(Object obj, Object obj2) {
        if (obj instanceof ReceiveCatching) {
            return BufferedChannelKt.tryResume0(((ReceiveCatching) obj).cont, new ChannelResult(obj2), null);
        }
        if (obj instanceof BufferedChannelIterator) {
            BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) obj;
            CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.continuation;
            bufferedChannelIterator.continuation = null;
            bufferedChannelIterator.receiveResult = obj2;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, Boolean.TRUE, null);
        }
        if (obj instanceof CancellableContinuation) {
            return BufferedChannelKt.tryResume0((CancellableContinuation) obj, obj2, null);
        }
        throw new IllegalStateException((C0000.decode(new byte[]{100, 88, 1, 79, 21, 0, 82, 66, 1, 83, 69, 23, 84, 85, 1, 94, 19, 0, 67, 22, 16, 78, 21, 0, 11, 22}, "16d7ee") + obj).toString());
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x006e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:33:0x0078  */
    /* JADX WARN: Code duplicated, block: B:37:0x0087  */
    /* JADX WARN: Code duplicated, block: B:43:0x009e  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x009c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x007d A[SYNTHETIC] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo17trySendJP2dKIU(Object obj) {
        int iAccess$updateCellSend;
        Unit unit;
        Waiter waiter;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        long j = atomicLongFieldUpdater.get(this);
        boolean z = false;
        long j2 = 1152921504606846975L;
        boolean z2 = isClosed(j, false) ? false : !bufferOrRendezvousSend(j & 1152921504606846975L);
        ChannelResult.Failed failed = ChannelResult.failed;
        if (z2) {
            return failed;
        }
        SupportSQLiteQuery supportSQLiteQuery = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$FU.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j3 = andIncrement & j2;
            boolean zIsClosed = isClosed(andIncrement, z);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j4 = i;
            long j5 = j3 / j4;
            int i2 = (int) (j3 % j4);
            if (channelSegment.id == j5) {
                iAccess$updateCellSend = access$updateCellSend(this, channelSegment, i2, obj, j3, supportSQLiteQuery, zIsClosed);
                unit = Unit.INSTANCE;
                if (iAccess$updateCellSend != 0) {
                    channelSegment.cleanPrev();
                    return unit;
                }
                if (iAccess$updateCellSend != 1) {
                    return unit;
                }
                if (iAccess$updateCellSend != 2) {
                    if (zIsClosed) {
                        channelSegment.onSlotCleaned();
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (supportSQLiteQuery instanceof Waiter) {
                        waiter = (Waiter) supportSQLiteQuery;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        waiter.invokeOnCancellation(channelSegment, i2 + i);
                    }
                    channelSegment.onSlotCleaned();
                    return failed;
                }
                if (iAccess$updateCellSend != 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iAccess$updateCellSend != 4) {
                    if (j3 < receivers$FU.get(this)) {
                        channelSegment.cleanPrev();
                    }
                    return new ChannelResult.Closed(getSendException());
                }
                if (iAccess$updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
                z = false;
            } else {
                ChannelSegment channelSegmentAccess$findSegmentSend = access$findSegmentSend(this, j5, channelSegment);
                if (channelSegmentAccess$findSegmentSend != null) {
                    channelSegment = channelSegmentAccess$findSegmentSend;
                    iAccess$updateCellSend = access$updateCellSend(this, channelSegment, i2, obj, j3, supportSQLiteQuery, zIsClosed);
                    unit = Unit.INSTANCE;
                    if (iAccess$updateCellSend != 0) {
                        channelSegment.cleanPrev();
                        return unit;
                    }
                    if (iAccess$updateCellSend != 1) {
                        return unit;
                    }
                    if (iAccess$updateCellSend != 2) {
                        if (zIsClosed) {
                            channelSegment.onSlotCleaned();
                            return new ChannelResult.Closed(getSendException());
                        }
                        if (supportSQLiteQuery instanceof Waiter) {
                            waiter = (Waiter) supportSQLiteQuery;
                        } else {
                            waiter = null;
                        }
                        if (waiter != null) {
                            waiter.invokeOnCancellation(channelSegment, i2 + i);
                        }
                        channelSegment.onSlotCleaned();
                        return failed;
                    }
                    if (iAccess$updateCellSend != 3) {
                        throw new IllegalStateException("unexpected");
                    }
                    if (iAccess$updateCellSend != 4) {
                        if (j3 < receivers$FU.get(this)) {
                            channelSegment.cleanPrev();
                        }
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (iAccess$updateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    z = false;
                } else {
                    if (zIsClosed) {
                        return new ChannelResult.Closed(getSendException());
                    }
                    z = false;
                }
            }
            j2 = 1152921504606846975L;
        }
    }

    public final Object updateCellReceive(ChannelSegment channelSegment, int i, long j, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        AtomicReferenceArray atomicReferenceArray = channelSegment.data;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            Object obj2 = atomicReferenceArray.get(i * 2);
            channelSegment.setElementLazy(i, null);
            return obj2;
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core2 == null || state$kotlinx_coroutines_core2 == BufferedChannelKt.IN_BUFFER) {
                if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core2 != BufferedChannelKt.BUFFERED) {
                    Symbol symbol = BufferedChannelKt.INTERRUPTED_SEND;
                    if (state$kotlinx_coroutines_core2 != symbol && state$kotlinx_coroutines_core2 != BufferedChannelKt.POISONED) {
                        if (state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                            expandBuffer();
                            return BufferedChannelKt.FAILED;
                        }
                        if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, BufferedChannelKt.RESUMING_BY_RCV)) {
                            boolean z = state$kotlinx_coroutines_core2 instanceof WaiterEB;
                            if (z) {
                                state$kotlinx_coroutines_core2 = ((WaiterEB) state$kotlinx_coroutines_core2).waiter;
                            }
                            if (tryResumeSender(state$kotlinx_coroutines_core2)) {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                                expandBuffer();
                                Object obj3 = atomicReferenceArray.get(i * 2);
                                channelSegment.setElementLazy(i, null);
                                return obj3;
                            }
                            channelSegment.setState$kotlinx_coroutines_core(i, symbol);
                            channelSegment.onSlotCleaned();
                            if (z) {
                                expandBuffer();
                            }
                            return BufferedChannelKt.FAILED;
                        }
                    }
                    return BufferedChannelKt.FAILED;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, i, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    Object obj4 = atomicReferenceArray.get(i * 2);
                    channelSegment.setElementLazy(i, null);
                    return obj4;
                }
            }
        }
    }

    public final int updateCellSendSlow(ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(null, i, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onSlotCleaned();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (channelSegment.casState$kotlinx_coroutines_core(null, i, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(null, i, BufferedChannelKt.BUFFERED)) {
                    break;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                    Symbol symbol = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core == symbol) {
                        channelSegment.setElementLazy(i, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                        channelSegment.setElementLazy(i, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED) {
                        channelSegment.setElementLazy(i, null);
                        isClosedForSend();
                        return 4;
                    }
                    channelSegment.setElementLazy(i, null);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        return 0;
                    }
                    if (channelSegment.data.getAndSet((i * 2) + 1, symbol) != symbol) {
                        channelSegment.onCancelledRequest(i, true);
                    }
                    return 5;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, i, BufferedChannelKt.BUFFERED)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        BufferedChannel bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = bufferEnd$FU;
            if (atomicLongFieldUpdater.get(bufferedChannel) > j) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        int i = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        int i2 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$FU;
            if (i2 < i) {
                long j2 = atomicLongFieldUpdater.get(bufferedChannel);
                if (j2 == (4611686018427387903L & atomicLongFieldUpdater2.get(bufferedChannel)) && j2 == atomicLongFieldUpdater.get(bufferedChannel)) {
                    return;
                } else {
                    i2++;
                }
            } else {
                while (true) {
                    long j3 = atomicLongFieldUpdater2.get(bufferedChannel);
                    if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j3, (j3 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        bufferedChannel = this;
                    }
                }
                while (true) {
                    long j4 = atomicLongFieldUpdater.get(bufferedChannel);
                    long j5 = atomicLongFieldUpdater2.get(bufferedChannel);
                    long j6 = j5 & 4611686018427387903L;
                    boolean z = (j5 & 4611686018427387904L) != 0;
                    if (j4 == j6 && j4 == atomicLongFieldUpdater.get(bufferedChannel)) {
                        break;
                    }
                    if (z) {
                        bufferedChannel = this;
                    } else {
                        bufferedChannel = this;
                        atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j5, 4611686018427387904L + j6);
                    }
                }
                while (true) {
                    long j7 = atomicLongFieldUpdater2.get(bufferedChannel);
                    if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j7, j7 & 4611686018427387903L)) {
                        return;
                    } else {
                        bufferedChannel = this;
                    }
                }
            }
        }
    }
}
