package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.google.android.gms.tasks.zzu;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConstraintTracker {
    public final Context appContext;
    public Object currentState;
    public final Dispatcher taskExecutor;
    public final Object lock = new Object();
    public final LinkedHashSet listeners = new LinkedHashSet();

    public ConstraintTracker(Context context, Dispatcher dispatcher) {
        this.taskExecutor = dispatcher;
        this.appContext = context.getApplicationContext();
    }

    public abstract Object readSystemState();

    public final void setState(Object obj) {
        synchronized (this.lock) {
            Object obj2 = this.currentState;
            if (obj2 == null || !obj2.equals(obj)) {
                this.currentState = obj;
                ((zzu) this.taskExecutor.runningSyncCalls).execute(new Processor$$ExternalSyntheticLambda2(CollectionsKt.toList(this.listeners), 3, this));
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
