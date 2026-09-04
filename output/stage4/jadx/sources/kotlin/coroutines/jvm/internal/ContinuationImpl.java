package kotlin.coroutines.jvm.internal;

import androidx.work.impl.model.WorkTagDao_Impl;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ContinuationImpl implements Continuation, CoroutineStackFrame, Serializable {
    public final CoroutineContext _context;
    public final Continuation completion;
    public transient Continuation intercepted;

    public ContinuationImpl(Continuation continuation) {
        CoroutineContext context = continuation != null ? continuation.getContext() : null;
        this.completion = continuation;
        this._context = context;
    }

    public Continuation create(Object obj, Continuation continuation) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{80, 70, 7, 7, 69, 6, 31, 39, 93, 77, 93, 93, 114, 12, 89, 18, 90, 90, 23, 7, 69, 10, 88, 8, 26, 20, 10, 7, 66, 67, 89, 9, 71, 20, 0, 3, 84, 13, 23, 9, 69, 81, 16, 20, 88, 7, 83, 3, 93}, "34bf1c7f"));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this._context;
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Continuation continuation = this;
        while (true) {
            ContinuationImpl continuationImpl = (ContinuationImpl) continuation;
            Continuation continuation2 = continuationImpl.completion;
            try {
                obj = continuationImpl.invokeSuspend(obj);
                if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return;
                }
            } catch (Throwable th) {
                obj = new Result.Failure(th);
            }
            Continuation continuation3 = continuationImpl.intercepted;
            if (continuation3 != null && continuation3 != continuationImpl) {
                ((CoroutineDispatcher) continuationImpl._context.get(ContinuationInterceptor$Key.$$INSTANCE)).getClass();
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation3;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$FU;
                while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == AtomicKt.REUSABLE_CLAIMED) {
                }
                Object obj2 = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                CancellableContinuationImpl cancellableContinuationImpl = obj2 instanceof CancellableContinuationImpl ? (CancellableContinuationImpl) obj2 : null;
                if (cancellableContinuationImpl != null) {
                    cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
                }
            }
            continuationImpl.intercepted = CompletedContinuation.INSTANCE;
            if (!(continuation2 instanceof ContinuationImpl)) {
                continuation2.resumeWith(obj);
                return;
            }
            continuation = continuation2;
        }
    }

    public String toString() {
        int iIntValue;
        String strC;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{116, 14, 8, 65, 88, 94, 68, 86, 18, 15, 88, 15, 70, 84, 69, 16}, "7af51017ff", 5));
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        if (debugMetadata != null) {
            int iV = debugMetadata.v();
            if (iV > 1) {
                throw new IllegalStateException((C0000.decode(new byte[]{37, 93, 3, 67, 82, 66, 12, 93, 21, 87, 81, 3, 21, 89, 65, 64, 80, 16, 18, 81, 14, 88, 21, 15, 8, 75, 12, 87, 65, 1, 9, 22, 65, 115, 77, 18, 4, 91, 21, 83, 81, 88, 65, 9, 77, 22, 82, 13, 21, 24}, "a8a65b", 0.0f) + iV + C0000.decode(new byte[]{22, 23, 51, 8, 82, 3, 22, 87, 18, 67, 70, 1, 87, 69, 3, 21, 76, 95, 6, 68, 124, 13, 17, 94, 91, 88, 22, 22, 66, 80, 8, 81, 89, 69, 7, 68, 91, 11, 7, 64, 83, 68, 79, 75}, "87cd7be2266e61f5", 0.0f)).toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField(C0000.decode(new byte[]{93, 83, 86, 7, 92}, "124b0828076590", false));
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
            WorkTagDao_Impl workTagDao_Impl = ModuleNameRetriever.cache;
            WorkTagDao_Impl workTagDao_Impl2 = ModuleNameRetriever.notOnJava9;
            if (workTagDao_Impl == null) {
                try {
                    WorkTagDao_Impl workTagDao_Impl3 = new WorkTagDao_Impl(Class.class.getDeclaredMethod(C0000.decode(new byte[]{5, 93, 69, 122, 88, 5, 64, 84, 1}, "b8177a58d4"), null), getClass().getClassLoader().loadClass(C0000.decode(new byte[]{94, 82, 70, 84, 74, 9, 85, 93, 87, 27, 41, 10, 80, 70, 92, 80}, "4305de")).getDeclaredMethod(C0000.decode(new byte[]{94, 93, 23, 37, 81, 70, 80, 75, 80, 72, 23, 14, 70}, "98ca4539", 0.0f), null), getClass().getClassLoader().loadClass(C0000.decode(new byte[]{95, 89, 65, 83, 77, 93, 81, 92, 5, 27, 88, 87, 83, 71, 15, 84, 30, 127, 13, 81, 64, 84, 82, 118, 6, 66, 83, 64, 11, 69, 65, 87, 69}, "5872c102b5")).getDeclaredMethod(C0000.decode(new byte[]{12, 82, 92, 86}, "b31322", 0.0f), null));
                    ModuleNameRetriever.cache = workTagDao_Impl3;
                    workTagDao_Impl = workTagDao_Impl3;
                } catch (Exception unused2) {
                    ModuleNameRetriever.cache = workTagDao_Impl2;
                    workTagDao_Impl = workTagDao_Impl2;
                }
            }
            if (workTagDao_Impl != workTagDao_Impl2) {
                Method method = (Method) workTagDao_Impl.__db;
                Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
                if (objInvoke != null) {
                    Method method2 = (Method) workTagDao_Impl.__insertionAdapterOfWorkTag;
                    Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                    if (objInvoke2 != null) {
                        Method method3 = (Method) workTagDao_Impl.__preparedStmtOfDeleteByWorkSpecId;
                        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                        if (objInvoke3 instanceof String) {
                            str = (String) objInvoke3;
                        }
                    }
                }
            }
            if (str == null) {
                strC = debugMetadata.c();
            } else {
                strC = str + '/' + debugMetadata.c();
            }
            name = new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }
}
