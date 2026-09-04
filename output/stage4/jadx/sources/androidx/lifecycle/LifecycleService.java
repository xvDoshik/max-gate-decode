package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.cloudmessaging.zzac;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {
    public final zzac dispatcher = new zzac(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public final LifecycleRegistry getLifecycle() {
        return (LifecycleRegistry) this.dispatcher.zza;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        this.dispatcher.postDispatchRunnable(Lifecycle$Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.dispatcher.postDispatchRunnable(Lifecycle$Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
        zzac zzacVar = this.dispatcher;
        zzacVar.postDispatchRunnable(lifecycle$Event);
        zzacVar.postDispatchRunnable(Lifecycle$Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        this.dispatcher.postDispatchRunnable(Lifecycle$Event.ON_START);
        super.onStart(intent, i);
    }
}
