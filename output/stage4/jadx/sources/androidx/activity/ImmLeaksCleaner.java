package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static int sReflectedFieldsInitialized;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_DESTROY) {
            return;
        }
        if (sReflectedFieldsInitialized == 0) {
            try {
                sReflectedFieldsInitialized = 2;
                InputMethodManager.class.getDeclaredField(C0000.decode(new byte[]{8, 103, 3, 67, 18, 81, 7, 52, 80, 0, 69}, "e4f1d4cb9e274efe", 0.0f)).setAccessible(true);
                InputMethodManager.class.getDeclaredField(C0000.decode(new byte[]{84, 124, 84, 64, 76, 49, 92, 64, 71, 93, 92, 52, 80, 87, 70}, "92188b")).setAccessible(true);
                InputMethodManager.class.getDeclaredField(C0000.decode(new byte[]{8, 125}, "e573cd", true)).setAccessible(true);
                sReflectedFieldsInitialized = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (sReflectedFieldsInitialized == 1) {
            throw null;
        }
    }
}
