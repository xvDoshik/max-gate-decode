package kotlinx.coroutines;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.startup.StartupException;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.AtomicKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractCoroutine extends JobSupport implements Continuation, CoroutineScope {
    public final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        initParentJob((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.context = coroutineContext.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String cancellationExceptionMessage() {
        return getClass().getSimpleName().concat(C0000.decode(new byte[]{69, 17, 85, 69, 70, 86, 81, 93, 85, 93, 93, 89, 83, 0}, "ef46f50368156d25", 0.0f));
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(StartupException startupException) {
        BuildersKt.handleCoroutineException(this.context, startupException);
    }

    public void onCancelled(Throwable th, boolean z) {
    }

    public void onCompleted(Object obj) {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            onCompleted(obj);
        } else {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, CompletedExceptionally._handled$FU.get(completedExceptionally) != 0);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thM12exceptionOrNullimpl = Result.m12exceptionOrNullimpl(obj);
        if (thM12exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(thM12exceptionOrNullimpl, false);
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(obj);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == BuildersKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void start(int i, AbstractCoroutine abstractCoroutine, Function2 function2) {
        int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(i);
        Unit unit = Unit.INSTANCE;
        if (iOrdinal == 0) {
            try {
                AtomicKt.resumeCancellableWith(unit, Headers.Companion.intercepted(((ContinuationImpl) function2).create(abstractCoroutine, this)));
                return;
            } catch (Throwable th) {
                resumeWith(new Result.Failure(th));
                throw th;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                Headers.Companion.intercepted(((ContinuationImpl) function2).create(abstractCoroutine, this)).resumeWith(unit);
                return;
            }
            if (iOrdinal != 3) {
                throw new StartupException();
            }
            try {
                CoroutineContext coroutineContext = this.context;
                Object objUpdateThreadContext = AtomicKt.updateThreadContext(coroutineContext, null);
                try {
                    Intrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                    Object objInvoke = function2.invoke(abstractCoroutine, this);
                    AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    if (objInvoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th2) {
                    AtomicKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    throw th2;
                }
            } catch (Throwable th3) {
                resumeWith(new Result.Failure(th3));
            }
        }
    }
}
