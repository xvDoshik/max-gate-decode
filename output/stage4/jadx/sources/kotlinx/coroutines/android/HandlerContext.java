package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class HandlerContext extends CoroutineDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    public final Handler handler;
    public final HandlerContext immediate;
    public final boolean invokeImmediately;

    public HandlerContext(Handler handler, boolean z) {
        this.handler = handler;
        this.invokeImmediately = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, true);
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.handler.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException(C0000.decode(new byte[]{108, 13, 82, 23, 66, 5, 65, 9, 18, 68, 82, 64, 22, 64, 1, 92, 93, 6, 67, 82, 82, 72, 18, 22, 90, 86, 19, 91, 87, 92, 0, 90, 93, 23, 23, 66, 88, 0, 87, 16, 94, 74, 90, 93, 81, 18, 16, 94, 93, 69, 83, 94, 69, 20, 83, 22, 81, 91, 86, 65, 22, 21}, "8e776d2b233362d6", 0) + this + C0000.decode(new byte[]{18, 70, 17, 0, 67, 68, 85, 93, 90, 21, 3, 5}, "5ffa0d61", 6));
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
        Dispatchers.IO.dispatch(coroutineContext, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).handler == this.handler;
    }

    public final int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded() {
        return (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        HandlerContext handlerContext;
        String strDecode;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
        if (this == handlerContext2) {
            strDecode = C0000.decode(new byte[]{39, 88, 64, 17, 4, 66, 86, 89, 6, 67, 64, 79, 40, 87, 92, 95}, "c13ae651", true);
        } else {
            try {
                handlerContext = handlerContext2.immediate;
            } catch (UnsupportedOperationException unused) {
                handlerContext = null;
            }
            strDecode = this == handlerContext ? C0000.decode(new byte[]{125, 94, 74, 66, 89, 64, 85, 80, 92, 69, 74, 28, 117, 85, 95, 86, 23, 94, 84, 95, 93, 80, 95, 89, 77, 82}, "97928468") : null;
        }
        if (strDecode != null) {
            return strDecode;
        }
        String string = this.handler.toString();
        if (!this.invokeImmediately) {
            return string;
        }
        return string + C0000.decode(new byte[]{76, 95, 85, 8, 81, 1, 95, 4, 65, 0}, "b68e4e6e5e");
    }
}
