package kotlinx.coroutines.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1;
import kotlinx.coroutines.channels.ChannelSegment;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AtomicKt {
    public static final Symbol NO_DECISION = new Symbol(C0000.decode(new byte[]{122, 42, 62, 33, 114, 112, 43, 100, 125, 42, 47}, "4eae73b7", false), 0);
    public static final Symbol CLOSED = new Symbol(C0000.decode(new byte[]{32, 123, 126, 49, 39, 119}, "c71bb345", 0.0f), 0);
    public static final Symbol UNDEFINED = new Symbol(C0000.decode(new byte[]{97, 40, 113, 113, 37, 43, 122, 125, 39}, "4f54cb48c0", 0.0f), 0);
    public static final Symbol REUSABLE_CLAIMED = new Symbol(C0000.decode(new byte[]{97, 38, 97, 48, 113, 112, 46, 39, 108, 32, 120, 34, 121, 127, 39, 38}, "3c4c02bb", 0.0f), 0);
    public static final Symbol CONDITION_FALSE = new Symbol(C0000.decode(new byte[]{117, 122, 44, 119, 40, 50, 122, 118, 126, 105, 36, 32, 122, 102, 39}, "65b3af3906ba", false), 0);
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol(C0000.decode(new byte[]{43, 43, 60, 102, 46, 99, 117, 116, 114, 104, 112, 126, 114, 123, 112, 124, 49, 55}, "edc2f10567527652", 0.0f), 0);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlinx.coroutines.channels.ChannelSegment] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, kotlinx.coroutines.internal.ConcurrentLinkedListNode, kotlinx.coroutines.internal.Segment] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object findSegmentInternal(long j, ChannelSegment channelSegment) {
        ?? r0 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        while (true) {
            long j2 = channelSegment.id;
            if (j2 >= j && !channelSegment.isRemoved()) {
                return channelSegment;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ConcurrentLinkedListNode._next$FU;
            Object obj = atomicReferenceFieldUpdater.get(channelSegment);
            Symbol symbol = CLOSED;
            if (obj == symbol) {
                return symbol;
            }
            Segment segment = (Segment) ((ConcurrentLinkedListNode) obj);
            if (segment != null) {
                channelSegment = segment;
            } else {
                Segment segment2 = (Segment) r0.invoke(Long.valueOf(j2 + 1), channelSegment);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(channelSegment, null, segment2)) {
                        if (channelSegment.isRemoved()) {
                            channelSegment.remove();
                        }
                        channelSegment = segment2;
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(channelSegment) == null);
            }
        }
    }

    /* JADX INFO: renamed from: getSegment-impl, reason: not valid java name */
    public static final Segment m19getSegmentimpl(Object obj) {
        if (obj != CLOSED) {
            return (Segment) obj;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{112, 10, 86, 66, 69, 95, 94, 23, 20, 6, 92, 95, 17, 80, 88, 13, 20, 22, 86, 86, 8, 84, 95, 23}, "4e31e11c", 0.0f));
    }

    public static final void handleUncaughtCoroutineException(CoroutineContext coroutineContext, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Throwable runtimeException;
        Iterator it = CoroutineExceptionHandlerImplKt.platformExceptionHandlers.iterator();
        while (it.hasNext()) {
            try {
                ((AndroidExceptionPreHandler) it.next()).handleException(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException(C0000.decode(new byte[]{114, 30, 80, 93, 21, 76, 15, 94, 10, 19, 64, 14, 90, 84, 0, 24, 18, 67, 29, 90, 89, 1, 19, 76, 10, 24, 14, 80, 10, 87, 91, 3, 19, 91, 10, 74, 9, 68, 16, 90, 89, 3, 19, 93, 29, 91, 3, 65, 16, 90, 88, 8}, "7f38e8f1d3", 0.0f), th2);
                    ExceptionsKt.addSuppressed(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ExceptionsKt.addSuppressed(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    /* JADX INFO: renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m20isClosedimpl(Object obj) {
        return obj == CLOSED;
    }

    /* JADX INFO: renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m21plusFjFbRPM(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (!(obj instanceof ThreadState)) {
            coroutineContext.fold(null, ThreadContextKt$findOne$1.INSTANCE);
            throw new ClassCastException();
        }
        ThreadState threadState = (ThreadState) obj;
        ThreadContextElement[] threadContextElementArr = threadState.elements;
        int length = threadContextElementArr.length - 1;
        if (length < 0) {
            return;
        }
        ThreadContextElement threadContextElement = threadContextElementArr[length];
        Object obj2 = threadState.values[length];
        throw null;
    }

    public static final void resumeCancellableWith(Object obj, Continuation continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        Throwable thM12exceptionOrNullimpl = Result.m12exceptionOrNullimpl(obj);
        Object completedExceptionally = thM12exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM12exceptionOrNullimpl, false);
        continuationImpl.getClass();
        CoroutineContext coroutineContext = continuationImpl._context;
        if (coroutineDispatcher.isDispatchNeeded()) {
            dispatchedContinuation._state = completedExceptionally;
            dispatchedContinuation.resumeMode = 1;
            coroutineDispatcher.dispatch(coroutineContext, dispatchedContinuation);
            return;
        }
        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
            dispatchedContinuation._state = completedExceptionally;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
            if (job == null || job.isActive()) {
                Object objUpdateThreadContext = updateThreadContext(coroutineContext, dispatchedContinuation.countOrElement);
                if (objUpdateThreadContext != NO_THREAD_ELEMENTS) {
                    BuildersKt.updateUndispatchedCompletion(continuationImpl, coroutineContext);
                }
                try {
                    continuationImpl.resumeWith(obj);
                    restoreThreadContext(coroutineContext, objUpdateThreadContext);
                } catch (Throwable th) {
                    restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    throw th;
                }
            } else {
                CancellationException cancellationException = ((JobSupport) job).getCancellationException();
                dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(completedExceptionally, cancellationException);
                dispatchedContinuation.resumeWith(new Result.Failure(cancellationException));
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } catch (Throwable th2) {
            try {
                dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th2, null);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount();
            }
        }
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        String property;
        boolean z;
        String str2;
        Long lValueOf;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        CharsKt.checkRadix(10);
        int length = property.length();
        if (length == 0) {
            str2 = property;
            lValueOf = null;
        } else {
            int i2 = 0;
            char cCharAt = property.charAt(0);
            long j4 = -9223372036854775807L;
            if (Intrinsics.compare(cCharAt, 48) < 0) {
                z = true;
                if (length != 1) {
                    if (cCharAt == '-') {
                        j4 = Long.MIN_VALUE;
                        i2 = 1;
                    } else {
                        if (cCharAt == '+') {
                            z = false;
                            i2 = 1;
                        }
                        lValueOf = null;
                    }
                }
                str2 = property;
                lValueOf = null;
            } else {
                z = false;
            }
            long j5 = 0;
            long j6 = -256204778801521550L;
            while (true) {
                if (i2 >= length) {
                    str2 = property;
                    lValueOf = z ? Long.valueOf(j5) : Long.valueOf(-j5);
                } else {
                    int iDigit = Character.digit((int) property.charAt(i2), 10);
                    if (iDigit >= 0) {
                        if (j5 < j6) {
                            if (j6 == -256204778801521550L) {
                                str2 = property;
                                j6 = j4 / ((long) 10);
                                if (j5 < j6) {
                                }
                            }
                            lValueOf = null;
                        } else {
                            str2 = property;
                        }
                        long j7 = j5 * ((long) 10);
                        long j8 = iDigit;
                        if (j7 < j4 + j8) {
                            lValueOf = null;
                        } else {
                            j5 = j7 - j8;
                            i2++;
                            property = str2;
                        }
                    }
                    str2 = property;
                    lValueOf = null;
                }
            }
        }
        String strDecode = C0000.decode(new byte[]{101, 73, 17, 77, 7, 93, 22, 64, 16, 86, 18, 85, 68, 68, 27, 25, 69}, "60b9b0", 0.0f);
        if (lValueOf == null) {
            throw new IllegalStateException((strDecode + str + C0000.decode(new byte[]{69, 18, 91, 7, 17, 70, 23, 92, 65, 3, 1, 9, 5, 92, 90, 28, 7, 2, 66, 68, 82, 10, 23, 3, 66, 21}, "b23fbf", 0.0f) + str2 + '\'').toString());
        }
        long jLongValue = lValueOf.longValue();
        if (j2 <= jLongValue && jLongValue <= j3) {
            return jLongValue;
        }
        throw new IllegalStateException((strDecode + str + C0000.decode(new byte[]{31, 17, 68, 95, 91, 68, 84, 85, 23, 85, 81, 17, 81, 95, 23, 69, 85, 95, 95, 84, 23}, "817741", true) + j2 + C0000.decode(new byte[]{30, 75}, "0eb67f2177c5", 0.0f) + j3 + C0000.decode(new byte[]{24, 25, 0, 65, 23, 23, 94, 18, 70, 31}, "49b4c77af87ed49a") + jLongValue + '\'').toString());
    }

    public static int systemProp$default(String str, int i, int i2) {
        return (int) systemProp(str, i, 1, (i2 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, ThreadContextKt$findOne$1.INSTANCE$1);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(((Number) obj).intValue(), coroutineContext), ThreadContextKt$findOne$1.INSTANCE$2);
        }
        throw new ClassCastException();
    }
}
