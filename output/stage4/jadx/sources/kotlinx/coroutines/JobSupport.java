package kotlinx.coroutines;

import androidx.startup.StartupException;
import androidx.tracing.Trace;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class JobSupport implements Job, ParentJob {
    private volatile Object _parentHandle;
    private volatile Object _state;
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, C0000.decode(new byte[]{58, 16, 23, 85, 64, 85}, "ecc440c1300f54f7", 1));
    public static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, C0000.decode(new byte[]{57, 17, 0, 66, 80, 15, 76, 43, 7, 15, 5, 92, 80}, "faa05a8c"));

    public final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting = 0;
        private volatile Object _rootCause;
        public final NodeList list;
        public static final AtomicIntegerFieldUpdater _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, C0000.decode(new byte[]{62, 88, 75, 37, 95, 8, 22, 15, 4, 69, 81, 8, 87}, "a18f0efc", false));
        public static final AtomicReferenceFieldUpdater _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, C0000.decode(new byte[]{59, 20, 93, 94, 65, 32, 7, 76, 17, 92}, "df215cf9b9", 0.0f));
        public static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, C0000.decode(new byte[]{106, 92, 65, 6, 85, 17, 68, 15, 90, 87, 74, 45, 95, 13, 84, 3, 71}, "599e0a0f"));

        public Finishing(NodeList nodeList, Throwable th) {
            this.list = nodeList;
            this._rootCause = th;
        }

        public final void addExceptionLocked(Throwable th) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                _rootCause$FU.set(this, th);
                return;
            }
            if (th == rootCause) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    return;
                } else {
                    throw new IllegalStateException((C0000.decode(new byte[]{55, 70, 84, 18, 93, 18, 15, 17, 21}, "d25f82fb56ddad08", 0.0f) + obj).toString());
                }
            }
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$FU.get(this);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final boolean isCompleting() {
            return _isCompleting$FU.get(this) != 0;
        }

        public final ArrayList sealLocked(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException((C0000.decode(new byte[]{100, 22, 86, 21, 82, 25, 80, 23, 23}, "7b7a799d", 0.0f) + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th != null && !th.equals(rootCause)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, BuildersKt.SEALED);
            return arrayList;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{37, 8, 15, 10, 22, 14, 88, 15, 87, 98, 80, 85, 89, 2, 6, 13, 13, 10, 11, 1, 12}, "caacef1a09347a", true));
            sb.append(isCancelling());
            sb.append(C0000.decode(new byte[]{31, 70, 0, 93, 94, 20, 14, 3, 18, 90, 13, 2, 11}, "3fc23dbff3ce6ce3", true));
            sb.append(isCompleting());
            sb.append(C0000.decode(new byte[]{79, 22, 66, 9, 87, 18, 38, 89, 69, 74, 6, 11}, "c60f8fe809", 7));
            sb.append(getRootCause());
            sb.append(C0000.decode(new byte[]{26, 21, 81, 75, 2, 3, 67, 23, 94, 95, 12, 18, 91}, "6543af3c70bafd", 7));
            sb.append(_exceptionsHolder$FU.get(this));
            sb.append(C0000.decode(new byte[]{78, 19, 9, 11, 66, 65, 95}, "b3eb15", 2));
            sb.append(this.list);
            sb.append(']');
            return sb.toString();
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? BuildersKt.EMPTY_ACTIVE : BuildersKt.EMPTY_NEW;
    }

    public static ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._prev$FU;
            LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev = lockFreeLinkedListNode.correctPrev();
            if (lockFreeLinkedListNodeCorrectPrev == null) {
                Object obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                while (true) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNode.isRemoved()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                }
            } else {
                lockFreeLinkedListNode = lockFreeLinkedListNodeCorrectPrev;
            }
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String stateString(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.isCancelling()) {
                return C0000.decode(new byte[]{122, 86, 93, 86, 6, 15, 8, 80, 87, 80}, "9735ccd9", 2);
            }
            if (finishing.isCompleting()) {
                return C0000.decode(new byte[]{113, 92, 92, 70, 92, 1, 64, 13, 11, 6}, "23160d4dea", 5);
            }
        } else {
            if (!(obj instanceof Incomplete)) {
                return obj instanceof CompletedExceptionally ? C0000.decode(new byte[]{34, 86, 10, 91, 85, 85, 85, 4, 2}, "a7d8099afabc6a9d", 6) : C0000.decode(new byte[]{38, 95, 90, 20, 10, 82, 23, 85, 7}, "e07df7c0ca8131", 0.0f);
            }
            if (!((Incomplete) obj).isActive()) {
                return C0000.decode(new byte[]{45, 82, 20}, "c7cc40", 0.0f);
            }
        }
        return C0000.decode(new byte[]{116, 6, 68, 11, 68, 85}, "5e0b20656e2d", false);
    }

    public final boolean addLastAtomic(Incomplete incomplete, NodeList nodeList, JobNode jobNode) {
        LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, this, incomplete);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._prev$FU;
            lockFreeLinkedListNodeCorrectPrev = nodeList.correctPrev();
            if (lockFreeLinkedListNodeCorrectPrev == null) {
                Object obj = atomicReferenceFieldUpdater.get(nodeList);
                while (true) {
                    lockFreeLinkedListNodeCorrectPrev = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNodeCorrectPrev.isRemoved()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNodeCorrectPrev);
                }
            }
            LockFreeLinkedListNode._prev$FU.lazySet(jobNode, lockFreeLinkedListNodeCorrectPrev);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$FU;
            atomicReferenceFieldUpdater2.lazySet(jobNode, nodeList);
            jobSupport$addLastAtomic$$inlined$addLastIf$1.oldNext = nodeList;
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(lockFreeLinkedListNodeCorrectPrev, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1)) {
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(lockFreeLinkedListNodeCorrectPrev) == nodeList);
        }
        return jobSupport$addLastAtomic$$inlined$addLastIf$1.perform(lockFreeLinkedListNodeCorrectPrev) == null;
    }

    public void afterCompletion(Object obj) {
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x003e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[LOOP:2: B:59:0x00b2->B:101:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0038 A[PHI: r0
      0x0038: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x0006, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x0047, B:29:0x0059, B:34:0x0061, B:40:0x0078, B:38:0x006e, B:39:0x0072), top: B:84:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0061 A[Catch: all -> 0x005f, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x0047, B:29:0x0059, B:34:0x0061, B:40:0x0078, B:38:0x006e, B:39:0x0072), top: B:84:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x006e A[Catch: all -> 0x005f, TryCatch #0 {, blocks: (B:24:0x0047, B:29:0x0059, B:34:0x0061, B:40:0x0078, B:38:0x006e, B:39:0x0072), top: B:84:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0113  */
    /* JADX WARN: Code duplicated, block: B:84:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x003e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x003e A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x003c, please report this as an issue */
    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thCreateCauseException;
        Object state$kotlinx_coroutines_core;
        boolean z;
        Throwable rootCause;
        Symbol symbol;
        Incomplete incomplete;
        NodeList orPromoteCancellingList;
        Finishing finishing;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object objTryMakeCompleting;
        Object objTryMakeCompleting2 = BuildersKt.COMPLETING_ALREADY;
        if (this instanceof JobImpl) {
            do {
                Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                if (!(state$kotlinx_coroutines_core2 instanceof Incomplete) || ((state$kotlinx_coroutines_core2 instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core2).isCompleting())) {
                    objTryMakeCompleting2 = BuildersKt.COMPLETING_ALREADY;
                    break;
                }
                objTryMakeCompleting2 = tryMakeCompleting(state$kotlinx_coroutines_core2, new CompletedExceptionally(createCauseException(obj), false));
            } while (objTryMakeCompleting2 == BuildersKt.COMPLETING_RETRY);
            if (objTryMakeCompleting2 != BuildersKt.COMPLETING_WAITING_CHILDREN) {
                if (objTryMakeCompleting2 == BuildersKt.COMPLETING_ALREADY) {
                    thCreateCauseException = null;
                    loop1: while (true) {
                        state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                        if (state$kotlinx_coroutines_core instanceof Finishing) {
                            synchronized (state$kotlinx_coroutines_core) {
                                if (Finishing._exceptionsHolder$FU.get((Finishing) state$kotlinx_coroutines_core) == BuildersKt.SEALED) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    symbol = BuildersKt.TOO_LATE_TO_CANCEL;
                                } else {
                                    boolean zIsCancelling = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                                    if (obj == null || !zIsCancelling) {
                                        if (thCreateCauseException == null) {
                                            thCreateCauseException = createCauseException(obj);
                                        }
                                        ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                                    }
                                    rootCause = zIsCancelling ? null : ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                    if (rootCause != null) {
                                        notifyCancelling(((Finishing) state$kotlinx_coroutines_core).list, rootCause);
                                    }
                                    symbol = BuildersKt.COMPLETING_ALREADY;
                                }
                            }
                        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                            if (thCreateCauseException == null) {
                                thCreateCauseException = createCauseException(obj);
                            }
                            incomplete = (Incomplete) state$kotlinx_coroutines_core;
                            if (incomplete.isActive()) {
                                orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                                if (orPromoteCancellingList == null) {
                                    continue;
                                } else {
                                    finishing = new Finishing(orPromoteCancellingList, thCreateCauseException);
                                    atomicReferenceFieldUpdater = _state$FU;
                                    while (true) {
                                        if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, finishing)) {
                                            notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                            symbol = BuildersKt.COMPLETING_ALREADY;
                                        } else if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                                        }
                                    }
                                }
                            } else {
                                objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(thCreateCauseException, false));
                                if (objTryMakeCompleting != BuildersKt.COMPLETING_ALREADY) {
                                    throw new IllegalStateException((C0000.decode(new byte[]{116, 0, 93, 87, 92, 16, 69, 12, 88, 64, 67, 84, 95, 68, 94, 15, 19}, "7a393ded90311d", true) + state$kotlinx_coroutines_core).toString());
                                }
                                if (objTryMakeCompleting != BuildersKt.COMPLETING_RETRY) {
                                    objTryMakeCompleting2 = objTryMakeCompleting;
                                    break;
                                }
                            }
                        } else {
                            symbol = BuildersKt.TOO_LATE_TO_CANCEL;
                        }
                        objTryMakeCompleting2 = symbol;
                        break;
                    }
                }
                if (objTryMakeCompleting2 != BuildersKt.COMPLETING_ALREADY && objTryMakeCompleting2 != BuildersKt.COMPLETING_WAITING_CHILDREN) {
                    if (objTryMakeCompleting2 == BuildersKt.TOO_LATE_TO_CANCEL) {
                        return false;
                    }
                    afterCompletion(objTryMakeCompleting2);
                    return true;
                }
            }
        } else {
            if (objTryMakeCompleting2 == BuildersKt.COMPLETING_ALREADY) {
                thCreateCauseException = null;
                loop1: while (true) {
                    state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core instanceof Finishing) {
                        synchronized (state$kotlinx_coroutines_core) {
                            if (Finishing._exceptionsHolder$FU.get((Finishing) state$kotlinx_coroutines_core) == BuildersKt.SEALED) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                symbol = BuildersKt.TOO_LATE_TO_CANCEL;
                            } else {
                                boolean zIsCancelling2 = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                                if (obj == null) {
                                    if (thCreateCauseException == null) {
                                        thCreateCauseException = createCauseException(obj);
                                    }
                                    ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                                } else {
                                    if (thCreateCauseException == null) {
                                        thCreateCauseException = createCauseException(obj);
                                    }
                                    ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                                }
                                if (zIsCancelling2) {
                                }
                                if (rootCause != null) {
                                    notifyCancelling(((Finishing) state$kotlinx_coroutines_core).list, rootCause);
                                }
                                symbol = BuildersKt.COMPLETING_ALREADY;
                            }
                        }
                    } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                        if (thCreateCauseException == null) {
                            thCreateCauseException = createCauseException(obj);
                        }
                        incomplete = (Incomplete) state$kotlinx_coroutines_core;
                        if (incomplete.isActive()) {
                            orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                            if (orPromoteCancellingList == null) {
                                continue;
                            } else {
                                finishing = new Finishing(orPromoteCancellingList, thCreateCauseException);
                                atomicReferenceFieldUpdater = _state$FU;
                                while (true) {
                                    if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, finishing)) {
                                        notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                        symbol = BuildersKt.COMPLETING_ALREADY;
                                    } else if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                                    }
                                }
                            }
                        } else {
                            objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(thCreateCauseException, false));
                            if (objTryMakeCompleting != BuildersKt.COMPLETING_ALREADY) {
                                throw new IllegalStateException((C0000.decode(new byte[]{116, 0, 93, 87, 92, 16, 69, 12, 88, 64, 67, 84, 95, 68, 94, 15, 19}, "7a393ded90311d", true) + state$kotlinx_coroutines_core).toString());
                            }
                            if (objTryMakeCompleting != BuildersKt.COMPLETING_RETRY) {
                                objTryMakeCompleting2 = objTryMakeCompleting;
                                break;
                            }
                        }
                    } else {
                        symbol = BuildersKt.TOO_LATE_TO_CANCEL;
                    }
                    objTryMakeCompleting2 = symbol;
                    break;
                }
            }
            if (objTryMakeCompleting2 != BuildersKt.COMPLETING_ALREADY) {
                if (objTryMakeCompleting2 == BuildersKt.TOO_LATE_TO_CANCEL) {
                    return false;
                }
                afterCompletion(objTryMakeCompleting2);
                return true;
            }
        }
        return true;
    }

    public void cancelInternal(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) _parentHandle$FU.get(this);
        if (childHandle == null || childHandle == NonDisposableHandle.INSTANCE) {
            return z;
        }
        return childHandle.childCancelled(th) || z;
    }

    public String cancellationExceptionMessage() {
        return C0000.decode(new byte[]{125, 86, 84, 68, 68, 5, 17, 25, 84, 88, 88, 7, 86, 8, 14, 92, 83}, "796d3db9", false);
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th) && getHandlesException$kotlinx_coroutines_core();
    }

    public final void completeStateFinalization(Incomplete incomplete, Object obj) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
        }
        StartupException startupException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        boolean z = incomplete instanceof JobNode;
        String strDecode = C0000.decode(new byte[]{21, 0, 93, 69, 24}, "5f2784dcaca8c0", 0.0f);
        String strDecode2 = C0000.decode(new byte[]{114, 30, 91, 92, 65, 18, 94, 95, 89, 70, 81, 87, 17, 5, 88, 93, 71, 10, 93, 77, 88, 9, 89, 16, 95, 7, 86, 93, 93, 3, 69, 16}, "7f891f70", 0.0f);
        if (z) {
            try {
                ((JobNode) incomplete).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new StartupException(strDecode2 + incomplete + strDecode + this, th2));
                return;
            }
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) list.getNext(); !nextNode.equals(list); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) nextNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (startupException != null) {
                            ExceptionsKt.addSuppressed(startupException, th3);
                        } else {
                            startupException = new StartupException(strDecode2 + jobNode + strDecode + this, th3);
                        }
                    }
                }
            }
            if (startupException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(startupException);
            }
        }
    }

    public final Throwable createCauseException(Object obj) {
        Throwable rootCause;
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th;
        }
        JobSupport jobSupport = (JobSupport) ((ParentJob) obj);
        Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException((C0000.decode(new byte[]{112, 0, 92, 95, 89, 17, 19, 7, 92, 17, 80, 0, 92, 82, 83, 9, 95, 12, 87, 86, 19, 2, 90, 88, 90, 1, 19, 12, 87, 17, 71, 9, 91, 66, 22, 22, 71, 4, 77, 84, 9, 65}, "3a216e3e91", 0.0f) + state$kotlinx_coroutines_core).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        if (cancellationException == null) {
            return new JobCancellationException(C0000.decode(new byte[]{51, 87, 69, 87, 92, 69, 22, 14, 86, 4, 67, 90, 16, 22}, "c672216d9fc3", true).concat(stateString(state$kotlinx_coroutines_core)), rootCause, jobSupport);
        }
        return cancellationException;
    }

    public final Object finalizeFinishingState(Finishing finishing, Object obj) throws IllegalAccessException, InvocationTargetException {
        Object obj2 = null;
        Throwable jobCancellationException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (finishing) {
            finishing.isCancelling();
            ArrayList arrayListSealLocked = finishing.sealLocked(th);
            if (!arrayListSealLocked.isEmpty()) {
                int size = arrayListSealLocked.size();
                int i = 0;
                while (i < size) {
                    Object obj3 = arrayListSealLocked.get(i);
                    i++;
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                jobCancellationException = (Throwable) obj2;
                if (jobCancellationException == null) {
                    jobCancellationException = (Throwable) arrayListSealLocked.get(0);
                }
            } else if (finishing.isCancelling()) {
                jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            if (jobCancellationException != null && arrayListSealLocked.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListSealLocked.size()));
                int size2 = arrayListSealLocked.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj4 = arrayListSealLocked.get(i2);
                    i2++;
                    Throwable th2 = (Throwable) obj4;
                    if (th2 != jobCancellationException && th2 != jobCancellationException && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        ExceptionsKt.addSuppressed(jobCancellationException, th2);
                    }
                }
            }
        }
        if (jobCancellationException != null && jobCancellationException != th) {
            obj = new CompletedExceptionally(jobCancellationException, false);
        }
        if (jobCancellationException != null && (cancelParent(jobCancellationException) || handleJobException(jobCancellationException))) {
            CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) obj;
            completedExceptionally2.getClass();
            CompletedExceptionally._handled$FU.compareAndSet(completedExceptionally2, 0, 1);
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        Object incompleteStateBox = obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, finishing, incompleteStateBox) && atomicReferenceFieldUpdater.get(this) == finishing) {
        }
        completeStateFinalization(finishing, obj);
        return obj;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        if (Intrinsics.areEqual(Job.Key.$$INSTANCE, key)) {
            return this;
        }
        return null;
    }

    public final CancellationException getCancellationException() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        boolean z = state$kotlinx_coroutines_core instanceof Finishing;
        String strDecode = C0000.decode(new byte[]{43, 89, 7, 25, 92, 66, 21, 21, 71, 81, 13, 90, 69, 87, 80, 70, 21, 9, 65, 24, 0, 85, 17, 80, 67, 84, 15, 70}, "a6e9515f38", 0.0f);
        if (!z) {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException((strDecode + this).toString());
            }
            if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return new JobCancellationException(getClass().getSimpleName().concat(C0000.decode(new byte[]{19, 9, 84, 64, 18, 82, 10, 84, 17, 92, 84, 23, 7, 1, 19, 15, 90, 65, 95, 80, 9, 85, 24}, "3a5321e9a01cbe", 7)), null, this);
            }
            Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new JobCancellationException(cancellationExceptionMessage(), th, this) : cancellationException;
        }
        Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        if (rootCause == null) {
            throw new IllegalStateException((strDecode + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(C0000.decode(new byte[]{18, 89, 68, 17, 87, 0, 91, 81, 84, 91, 88, 8, 12, 86}, "20714a52174ab1", false));
        cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = cancellationExceptionMessage();
        }
        return new JobCancellationException(strConcat, rootCause, this);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.$$INSTANCE;
    }

    public final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException((C0000.decode(new byte[]{102, 67, 2, 65, 0, 23, 21, 13, 93, 77, 88, 1, 18, 89, 3, 20, 80, 23, 15, 92, 22, 67, 92, 69}, "57c5e7fe284e21bb", true) + incomplete).toString());
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = _state$FU.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public boolean handleJobException(Throwable th) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(StartupException startupException) {
        throw startupException;
    }

    public final void initParentJob(Job job) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
            return;
        }
        JobSupport jobSupport = (JobSupport) job;
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
            boolean z = state$kotlinx_coroutines_core instanceof Empty;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
            if (!z) {
                if (!(state$kotlinx_coroutines_core instanceof InactiveNodeList)) {
                    break;
                }
                NodeList nodeList = ((InactiveNodeList) state$kotlinx_coroutines_core).list;
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(jobSupport, state$kotlinx_coroutines_core, nodeList)) {
                        jobSupport.getClass();
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater2.get(jobSupport) == state$kotlinx_coroutines_core);
            } else {
                if (((Empty) state$kotlinx_coroutines_core).isActive) {
                    break;
                }
                Empty empty = BuildersKt.EMPTY_ACTIVE;
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(jobSupport, state$kotlinx_coroutines_core, empty)) {
                        jobSupport.getClass();
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater2.get(jobSupport) == state$kotlinx_coroutines_core);
            }
        }
        ChildHandle childHandle = (ChildHandle) jobSupport.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new ChildHandleNode(this));
        atomicReferenceFieldUpdater.set(this, childHandle);
        if (getState$kotlinx_coroutines_core() instanceof Incomplete) {
            return;
        }
        childHandle.dispose();
        atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:98:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00bf A[EDGE_INSN: B:99:0x00bf->B:78:0x00bf BREAK  A[LOOP:0: B:18:0x0027->B:108:0x0027], SYNTHETIC] */
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1 function1) {
        JobNode invokeOnCompletion;
        Throwable rootCause;
        if (z) {
            invokeOnCompletion = function1 instanceof JobCancellingNode ? (JobCancellingNode) function1 : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCancelling(function1);
            }
        } else {
            invokeOnCompletion = function1 instanceof JobNode ? (JobNode) function1 : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCompletion(function1);
            }
        }
        invokeOnCompletion.job = this;
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, invokeOnCompletion)) {
                        if (atomicReferenceFieldUpdater.get(this) != state$kotlinx_coroutines_core) {
                        }
                    }
                    break loop0;
                }
                NodeList nodeList = new NodeList();
                Incomplete inactiveNodeList = empty.isActive ? nodeList : new InactiveNodeList(nodeList);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, empty, inactiveNodeList) && atomicReferenceFieldUpdater2.get(this) == empty) {
                }
            } else {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (z2) {
                        CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                        function1.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    }
                    return NonDisposableHandle.INSTANCE;
                }
                Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                NodeList list = incomplete.getList();
                if (list == null) {
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                    if (z && (state$kotlinx_coroutines_core instanceof Finishing)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            try {
                                rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                if (rootCause == null || ((function1 instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                    if (addLastAtomic((Incomplete) state$kotlinx_coroutines_core, list, invokeOnCompletion)) {
                                        if (rootCause == null) {
                                            return invokeOnCompletion;
                                        }
                                        disposableHandle = invokeOnCompletion;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (rootCause != null) {
                            if (z2) {
                                function1.invoke(rootCause);
                            }
                            return disposableHandle;
                        }
                        if (addLastAtomic(incomplete, list, invokeOnCompletion)) {
                            break;
                            break;
                        }
                    } else {
                        rootCause = null;
                        if (rootCause != null) {
                            if (z2) {
                                function1.invoke(rootCause);
                            }
                            return disposableHandle;
                        }
                        if (addLastAtomic(incomplete, list, invokeOnCompletion)) {
                            break;
                        }
                    }
                }
            }
        }
        return invokeOnCompletion;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (objTryMakeCompleting == BuildersKt.COMPLETING_ALREADY) {
                String str = C0000.decode(new byte[]{120, 86, 84, 65}, "296a845f8c769964", 1) + this + C0000.decode(new byte[]{68, 91, 70, 22, 86, 91, 22, 87, 84, 82, 78, 23, 7, 93, 88, 70, 91, 82, 16, 87, 21, 89, 69, 23, 7, 93, 88, 70, 91, 82, 16, 91, 91, 81, 27, 23, 6, 71, 65, 22, 94, 68, 68, 80, 80, 95, 89, 80, 68, 81, 90, 91, 71, 91, 1, 70, 80, 82, 23, 64, 13, 70, 93, 22}, "d25677", 0.0f) + obj;
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                throw new IllegalStateException(str, completedExceptionally != null ? completedExceptionally.cause : null);
            }
        } while (objTryMakeCompleting == BuildersKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return Intrinsics.areEqual(Job.Key.$$INSTANCE, key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    public final void notifyCancelling(NodeList nodeList, Throwable th) throws IllegalAccessException, InvocationTargetException {
        StartupException startupException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) nodeList.getNext(); !nextNode.equals(nodeList); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) nextNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    if (startupException != null) {
                        ExceptionsKt.addSuppressed(startupException, th2);
                    } else {
                        startupException = new StartupException(C0000.decode(new byte[]{125, 27, 7, 87, 21, 66, 89, 88, 95, 65, 8, 89, 70, 90, 87, 14, 20, 94, 0, 66, 89, 88, 95, 65, 9, 86, 8, 93, 84, 6, 22, 18}, "8cd2e6071aa7f9", 0.0f) + jobNode + C0000.decode(new byte[]{24, 86, 93, 66, 66}, "8020b90efa") + this, th2);
                    }
                }
            }
        }
        if (startupException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(startupException);
        }
        cancelParent(th);
    }

    public void onCompletionInternal(Object obj) {
    }

    public void onStart$1() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return Trace.plus(this, coroutineContext);
    }

    public final void promoteSingleToNodeList(JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NodeList nodeList = new NodeList();
        jobNode.getClass();
        LockFreeLinkedListNode._prev$FU.lazySet(nodeList, jobNode);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$FU;
        atomicReferenceFieldUpdater2.lazySet(nodeList, jobNode);
        loop0: while (jobNode.getNext() == jobNode) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(jobNode, jobNode, nodeList)) {
                    nodeList.finishAdd(jobNode);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(jobNode) == jobNode);
        }
        LockFreeLinkedListNode nextNode = jobNode.getNextNode();
        do {
            atomicReferenceFieldUpdater = _state$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, nextNode)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == jobNode);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('{');
        sb2.append(stateString(getState$kotlinx_coroutines_core()));
        sb2.append('}');
        sb.append(sb2.toString());
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }

    public final Object tryMakeCompleting(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (!(obj instanceof Incomplete)) {
            return BuildersKt.COMPLETING_ALREADY;
        }
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object incompleteStateBox = obj2 instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, incomplete, incompleteStateBox)) {
                if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                    return BuildersKt.COMPLETING_RETRY;
                }
            }
            onCompletionInternal(obj2);
            completeStateFinalization(incomplete, obj2);
            return obj2;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete2);
        if (orPromoteCancellingList == null) {
            return BuildersKt.COMPLETING_RETRY;
        }
        ChildHandleNode childHandleNodeNextChild = null;
        Finishing finishing = incomplete2 instanceof Finishing ? (Finishing) incomplete2 : null;
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, null);
        }
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                return BuildersKt.COMPLETING_ALREADY;
            }
            Finishing._isCompleting$FU.set(finishing, 1);
            if (finishing != incomplete2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, finishing)) {
                    if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                        return BuildersKt.COMPLETING_RETRY;
                    }
                }
            }
            boolean zIsCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            Throwable rootCause = finishing.getRootCause();
            if (zIsCancelling) {
                rootCause = null;
            }
            if (rootCause != null) {
                notifyCancelling(orPromoteCancellingList, rootCause);
            }
            ChildHandleNode childHandleNode = incomplete2 instanceof ChildHandleNode ? (ChildHandleNode) incomplete2 : null;
            if (childHandleNode == null) {
                NodeList list = incomplete2.getList();
                if (list != null) {
                    childHandleNodeNextChild = nextChild(list);
                }
            } else {
                childHandleNodeNextChild = childHandleNode;
            }
            if (childHandleNodeNextChild != null) {
                while (childHandleNodeNextChild.childJob.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new ChildCompletion(this, finishing, childHandleNodeNextChild, obj2)) == NonDisposableHandle.INSTANCE) {
                    childHandleNodeNextChild = nextChild(childHandleNodeNextChild);
                    if (childHandleNodeNextChild == null) {
                    }
                }
                return BuildersKt.COMPLETING_WAITING_CHILDREN;
            }
            return finalizeFinishingState(finishing, obj2);
        }
    }

    public final class ChildCompletion extends JobNode {
        public final ChildHandleNode child;
        public final JobSupport parent;
        public final Object proposedUpdate;
        public final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void invoke(Throwable th) {
            ChildHandleNode childHandleNodeNextChild = JobSupport.nextChild(this.child);
            JobSupport jobSupport = this.parent;
            Finishing finishing = this.state;
            Object obj = this.proposedUpdate;
            if (childHandleNodeNextChild != null) {
                while (childHandleNodeNextChild.childJob.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new ChildCompletion(jobSupport, finishing, childHandleNodeNextChild, obj)) == NonDisposableHandle.INSTANCE) {
                    childHandleNodeNextChild = JobSupport.nextChild(childHandleNodeNextChild);
                    if (childHandleNodeNextChild == null) {
                    }
                }
                return;
            }
            jobSupport.afterCompletion(jobSupport.finalizeFinishingState(finishing, obj));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }
    }
}
