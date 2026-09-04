package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.BuildersKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j, TaskContextImpl taskContextImpl) {
        super(j, taskContextImpl);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{103, 88, 16, 14, 63}, "39ceddf127f480", 0.0f));
        Runnable runnable = this.block;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(runnable));
        String strDecode = C0000.decode(new byte[]{27, 23}, "77c4916bbfb5b8", false);
        sb.append(strDecode);
        sb.append(this.submissionTime);
        sb.append(strDecode);
        sb.append(this.taskContext);
        sb.append(']');
        return sb.toString();
    }
}
