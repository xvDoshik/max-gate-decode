package androidx.lifecycle;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver {
    public boolean isAttached;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            this.isAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
