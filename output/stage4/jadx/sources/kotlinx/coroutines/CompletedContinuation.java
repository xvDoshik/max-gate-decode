package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CompletedContinuation {
    public final Throwable cancelCause;
    public final Object idempotentResume;
    public final Function1 onCancellation;
    public final Object result;

    public CompletedContinuation(Object obj, Function1 function1, Object obj2, Throwable th) {
        this.result = obj;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static CompletedContinuation copy$default(CompletedContinuation completedContinuation, CancellationException cancellationException, int i) {
        Object obj = completedContinuation.result;
        Function1 function1 = completedContinuation.onCancellation;
        Object obj2 = completedContinuation.idempotentResume;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return new CompletedContinuation(obj, function1, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
    }

    public final int hashCode() {
        Object obj = this.result;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 961;
        Function1 function1 = this.onCancellation;
        int iHashCode2 = (iHashCode + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int iHashCode3 = (iHashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode3 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{118, 94, 12, 20, 9, 92, 18, 7, 5, 115, 90, 95, 21, 13, 11, 76, 7, 22, 8, 95, 91, 25, 19, 1, 22, 76, 10, 22, 92}, "51ade9fba0", 7));
        sb.append(this.result);
        sb.append(C0000.decode(new byte[]{73, 66, 2, 2, 94, 84, 82, 85, 127, 5, 95, 1, 92, 85, 23, 95, 15, 22, 92, 91, 27, 25, 88, 10, 114, 4, 94, 83, 0, 14, 13, 2, 68, 94, 88, 87, 10}, "ebac07797d1e00"));
        sb.append(this.onCancellation);
        sb.append(C0000.decode(new byte[]{30, 17, 81, 0, 81, 89, 70, 95, 70, 84, 86, 16, 102, 81, 69, 69, 95, 84, 5}, "218d4460", 1));
        sb.append(this.idempotentResume);
        sb.append(C0000.decode(new byte[]{74, 67, 0, 5, 91, 83, 80, 84, 117, 88, 19, 16, 6, 89}, "fccd505869", false));
        sb.append(this.cancelCause);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ CompletedContinuation(Object obj, Function1 function1, CancellationException cancellationException, int i) {
        this(obj, (i & 4) != 0 ? null : function1, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
