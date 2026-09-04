package androidx.work.impl.constraints;

import androidx.tracing.Trace;
import androidx.work.CoroutineWorker;
import androidx.work.SystemClock;
import androidx.work.impl.model.WorkSpec;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobImpl;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class WorkConstraintsTrackerKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{53, 92, 17, 89, 113, 89, 12, 64, 23, 64, 83, 95, 12, 71, 16, 102, 64, 87, 1, 88, 6, 64}, "b3c226", 6));
    }

    public static final JobImpl listen(ConnectionPool connectionPool, WorkSpec workSpec, ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        JobImpl jobImpl = new JobImpl();
        BuildersKt.launch$default(BuildersKt.CoroutineScope(Trace.plus(executorCoroutineDispatcherImpl, jobImpl)), new CoroutineWorker.AnonymousClass1(connectionPool, workSpec, onConstraintsStateChangedListener, (Continuation) null));
        return jobImpl;
    }
}
