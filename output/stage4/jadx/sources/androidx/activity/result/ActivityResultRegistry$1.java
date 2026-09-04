package androidx.activity.result;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
class ActivityResultRegistry$1 implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        if (Lifecycle$Event.ON_START.equals(lifecycle$Event) || Lifecycle$Event.ON_STOP.equals(lifecycle$Event) || Lifecycle$Event.ON_DESTROY.equals(lifecycle$Event)) {
            throw null;
        }
    }
}
