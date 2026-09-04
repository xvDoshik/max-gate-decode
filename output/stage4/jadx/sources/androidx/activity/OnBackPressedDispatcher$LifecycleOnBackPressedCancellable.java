package androidx.activity;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_START || lifecycle$Event == Lifecycle$Event.ON_STOP || lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            throw null;
        }
    }
}
