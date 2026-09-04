package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class JobImpl extends JobSupport {
    public final boolean handlesException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    public JobImpl() {
        super(true);
        boolean z = true;
        initParentJob(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._parentHandle$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        ChildHandleNode childHandleNode = childHandle instanceof ChildHandleNode ? (ChildHandleNode) childHandle : null;
        if (childHandleNode == null) {
            z = false;
            break;
        }
        JobSupport jobSupport = childHandleNode.job;
        jobSupport = jobSupport == null ? null : jobSupport;
        if (jobSupport == null) {
            z = false;
            break;
        }
        while (!jobSupport.getHandlesException$kotlinx_coroutines_core()) {
            ChildHandle childHandle2 = (ChildHandle) atomicReferenceFieldUpdater.get(jobSupport);
            ChildHandleNode childHandleNode2 = childHandle2 instanceof ChildHandleNode ? (ChildHandleNode) childHandle2 : null;
            if (childHandleNode2 != null) {
                jobSupport = childHandleNode2.job;
                if (jobSupport == null) {
                    jobSupport = null;
                }
                if (jobSupport == null) {
                }
            }
            z = false;
        }
        this.handlesException = z;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }
}
