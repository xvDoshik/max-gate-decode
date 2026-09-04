package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class JobCancellationException extends CancellationException {
    public final transient Job job;

    public JobCancellationException(String str, Throwable th, JobSupport jobSupport) {
        super(str);
        this.job = jobSupport;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JobCancellationException)) {
            return false;
        }
        JobCancellationException jobCancellationException = (JobCancellationException) obj;
        return Intrinsics.areEqual(jobCancellationException.getMessage(), getMessage()) && Intrinsics.areEqual(jobCancellationException.job, this.job) && Intrinsics.areEqual(jobCancellationException.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int iHashCode = (this.job.hashCode() + (getMessage().hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(C0000.decode(new byte[]{90, 23, 9, 86, 82, 13}, "a7c900d6951e5a9c", false));
        sb.append(this.job);
        return sb.toString();
    }
}
