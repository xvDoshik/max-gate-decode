package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;
import kotlin.Unit;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {
    public final JobSupport childJob;

    public ChildHandleNode(JobSupport jobSupport) {
        this.childJob = jobSupport;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        JobSupport jobSupport = this.job;
        if (jobSupport == null) {
            jobSupport = null;
        }
        return jobSupport.childCancelled(th);
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) throws IllegalAccessException, InvocationTargetException {
        JobSupport jobSupport = this.job;
        if (jobSupport == null) {
            jobSupport = null;
        }
        this.childJob.cancelImpl$kotlinx_coroutines_core(jobSupport);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }
}
