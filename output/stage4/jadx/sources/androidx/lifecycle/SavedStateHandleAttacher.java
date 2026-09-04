package androidx.lifecycle;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    public final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        this.provider = savedStateHandlesProvider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_CREATE) {
            throw new IllegalStateException((C0000.decode(new byte[]{43, 7, 78, 64, 19, 6, 64, 87, 11, 22, 22, 89, 70, 16, 66, 18, 7, 7, 22, 123, 125, 60, 117, 96, 32, 35, 98, 113, 31, 67, 95, 70, 69, 21, 87, 71, 19}, "eb643c62", true) + lifecycle$Event).toString());
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        SavedStateHandlesProvider savedStateHandlesProvider = this.provider;
        if (savedStateHandlesProvider.restored) {
            return;
        }
        savedStateHandlesProvider.restoredState = savedStateHandlesProvider.savedStateRegistry.consumeRestoredStateForKey(C0000.decode(new byte[]{88, 87, 5, 16, 86, 8, 92, 79, 72, 8, 88, 80, 92, 90, 24, 1, 85, 4, 22, 94, 8, 16, 84, 68, 87, 88, 13, 76, 106, 0, 78, 82, 2, 55, 69, 87, 77, 92, 41, 3, 87, 5, 84, 82, 21, 52, 67, 89, 79, 80, 5, 7, 75}, "99ab9a87fd16", 3));
        savedStateHandlesProvider.restored = true;
    }
}
