package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1;
import kotlinx.coroutines.internal.Symbol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class BufferedChannelKt {
    public static final ChannelSegment NULL_SEGMENT = new ChannelSegment(-1, null, null, 0);
    public static final int SEGMENT_SIZE = AtomicKt.systemProp$default(C0000.decode(new byte[]{89, 13, 66, 10, 10, 87, 78, 22, 2, 11, 67, 89, 71, 22, 95, 8, 6, 74, 24, 90, 20, 2, 87, 83, 64, 7, 82, 37, 11, 88, 88, 86, 4, 8, 31, 69, 87, 5, 91, 3, 13, 77, 101, 81, 27, 1}, "2b6fc968ad16"), 32, 12);
    public static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = AtomicKt.systemProp$default(C0000.decode(new byte[]{13, 88, 22, 89, 10, 90, 30, 25, 1, 90, 17, 91, 19, 67, 11, 91, 6, 71, 72, 85, 23, 83, 5, 81, 20, 82, 6, 118, 11, 85, 8, 89, 7, 89, 77, 81, 30, 71, 3, 91, 7, 118, 19, 81, 4, 80, 17, 119, 9, 90, 18, 89, 6, 64, 15, 88, 12, 98, 2, 93, 18, 126, 22, 80, 17, 85, 18, 94, 13, 91, 16}, "f7b5c4", 3), 10000, 12);
    public static final Symbol BUFFERED = new Symbol(C0000.decode(new byte[]{35, 108, 34, 115, 115, 98, 124, 32}, "a9d5609d6d3160", 0.0f), 0);
    public static final Symbol IN_BUFFER = new Symbol(C0000.decode(new byte[]{49, 41, 122, 103, 45, 119, 111, 112, 96, 114, 36, 36, 103}, "ba52a30254", 0.0f), 0);
    public static final Symbol RESUMING_BY_RCV = new Symbol(C0000.decode(new byte[]{106, 60, 98, 113, 50, 109, 125, 113, 119, 36, 111, 118, 56, 103, 98, 123, 111}, "9c04a808", false), 0);
    public static final Symbol RESUMING_BY_EB = new Symbol(C0000.decode(new byte[]{107, 116, 49, 96, 47, 47, 45, 33, 106, 116, 63, 59, 124, 115}, "91b5bfcf56fd", false), 0);
    public static final Symbol POISONED = new Symbol(C0000.decode(new byte[]{105, 46, 120, 49, 118, 123, 116, 34}, "9a1b951fa4878a15", 6), 0);
    public static final Symbol DONE_RCV = new Symbol(C0000.decode(new byte[]{113, 118, 125, 33, 60, 99, 118, 98}, "593dc154aa36"), 0);
    public static final Symbol INTERRUPTED_SEND = new Symbol(C0000.decode(new byte[]{112, 121, 102, 116, 51, 51, 51, 51, 48, 33, 39, 57, 106, 114, 124, 117}, "9721aafcddcf", 0.0f), 0);
    public static final Symbol INTERRUPTED_RCV = new Symbol(C0000.decode(new byte[]{120, 124, 100, 112, 103, 96, 48, 100, 101, 119, 116, 106, 103, 113, 51}, "120552e4", 2), 0);
    public static final Symbol CHANNEL_CLOSED = new Symbol(C0000.decode(new byte[]{117, 113, 37, 44, 40, 119, 121, 108, 117, 117, 43, 49, 35, 118}, "69dbf253", 0.0f), 0);
    public static final Symbol SUSPEND = new Symbol(C0000.decode(new byte[]{50, 48, 106, 99, 115, 43, 39}, "ae936ec953", 4), 0);
    public static final Symbol SUSPEND_NO_WAITER = new Symbol(C0000.decode(new byte[]{98, 97, 55, 99, 35, 119, 119, 59, 126, 121, 107, 99, 119, 113, 101, 113, 54}, "14d3f93d064468"), 0);
    public static final Symbol FAILED = new Symbol(C0000.decode(new byte[]{126, 119, 122, 117, 36, 38}, "8639abcc"), 0);
    public static final Symbol NO_RECEIVE_RESULT = new Symbol(C0000.decode(new byte[]{40, 126, 107, 99, 118, 37, 118, 121, 55, 114, 109, 52, 35, 97, 102, 122, 50}, "f1413f30a72ff236"), 0);
    public static final Symbol CLOSE_HANDLER_CLOSED = new Symbol(C0000.decode(new byte[]{114, 46, 120, 107, 114, 62, 121, 35, 121, 124, 123, 36, 99, 61, 116, 116, 120, 50, 116, 38}, "1b787a", true), 0);
    public static final Symbol CLOSE_HANDLER_INVOKED = new Symbol(C0000.decode(new byte[]{112, 46, 122, 49, 114, 59, 123, 117, 120, 117, 125, 39, 49, 111, 112, 125, 101, 45, 126, 39, 115}, "3b5b7d34611bc093"), 0);
    public static final Symbol NO_CLOSE_CAUSE = new Symbol(C0000.decode(new byte[]{42, 122, 61, 123, 46, 119, 55, 112, 61, 123, 35, 109, 55, 112}, "d5b8b8"), 0);

    public static final boolean tryResume0(CancellableContinuation cancellableContinuation, Object obj, OnUndeliveredElementKt$bindCancellationFun$1 onUndeliveredElementKt$bindCancellationFun$1) {
        CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) cancellableContinuation;
        cancellableContinuationImpl.getClass();
        Symbol symbol = BuildersKt.RESUME_TOKEN;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = CancellableContinuationImpl._state$FU;
        loop0: while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(cancellableContinuationImpl);
            if (!(obj2 instanceof NotCompleted)) {
                symbol = null;
                break;
            }
            int i = cancellableContinuationImpl.resumeMode;
            if (!(obj instanceof CompletedExceptionally) && i != 1) {
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(cancellableContinuationImpl, obj2, obj)) {
                    if (!cancellableContinuationImpl.isReusable()) {
                        cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
                        break loop0;
                    }
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater.get(cancellableContinuationImpl) == obj2);
        }
        if (symbol == null) {
            return false;
        }
        cancellableContinuationImpl.dispatchResume(cancellableContinuationImpl.resumeMode);
        return true;
    }
}
