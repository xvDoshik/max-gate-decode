package kotlinx.coroutines.channels;

import androidx.work.JobListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1;
import kotlinx.coroutines.internal.Symbol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProducerCoroutine extends AbstractCoroutine implements ProducerScope, Channel {
    public final BufferedChannel _channel;

    public ProducerCoroutine(CoroutineContext coroutineContext, BufferedChannel bufferedChannel) {
        super(coroutineContext, true);
        this._channel = bufferedChannel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return;
        }
        if ((state$kotlinx_coroutines_core instanceof JobSupport.Finishing) && ((JobSupport.Finishing) state$kotlinx_coroutines_core).isCancelling()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void cancelInternal(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        this._channel.closeOrCancelImpl(cancellationException, true);
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public final void invokeOnClose(JobListenableFuture.AnonymousClass1 anonymousClass1) {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.closeHandler$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, null, anonymousClass1)) {
            if (atomicReferenceFieldUpdater.get(bufferedChannel) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(bufferedChannel);
                    Symbol symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
                    if (obj != symbol) {
                        if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                            throw new IllegalStateException(C0000.decode(new byte[]{115, 13, 95, 23, 93, 92, 17, 22, 90, 2, 94, 7, 89, 92, 17, 22, 69, 2, 67, 67, 84, 85, 17, 83, 83, 7, 73, 67, 71, 92, 4, 95, 65, 23, 85, 17, 80, 93, 67, 87, 92, 7, 16, 16, 64, 90, 0, 83, 65, 16, 86, 22, 89, 85, 26, 22, 91, 13, 70, 12, 94, 92, 7}, "2c0c59c6", 0.0f));
                        }
                        throw new IllegalStateException((C0000.decode(new byte[]{113, 94, 87, 71, 91, 0, 66, 16, 88, 81, 86, 87, 95, 0, 66, 16, 89, 67, 24, 82, 95, 23, 85, 81, 84, 73, 24, 65, 86, 2, 89, 67, 68, 85, 74, 86, 87, 95, 16}, "00833e00", 0) + obj).toString());
                    }
                    Symbol symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, symbol, symbol2)) {
                            anonymousClass1.invoke(bufferedChannel.getCloseCause());
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(bufferedChannel) == symbol);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        if (this._channel.closeOrCancelImpl(th, false) || z) {
            return;
        }
        BuildersKt.handleCoroutineException(this.context, th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Object obj) {
        this._channel.closeOrCancelImpl(null, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo14receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2) {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        return BufferedChannel.m13receiveCatchingJP2dKIU$suspendImpl(bufferedChannel, combineKt$combineInternal$2);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(IndexedValue indexedValue, CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1) {
        return this._channel.send(indexedValue, combineKt$combineInternal$2$1$1$emit$1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo16tryReceivePtdJZtk() {
        return this._channel.mo16tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo17trySendJP2dKIU(Object obj) {
        return this._channel.mo17trySendJP2dKIU(obj);
    }
}
