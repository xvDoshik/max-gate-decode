package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OnBackPressedDispatcher$Api33Impl {
    public static final OnBackPressedDispatcher$Api33Impl INSTANCE = new OnBackPressedDispatcher$Api33Impl();

    public final OnBackInvokedCallback createOnBackInvokedCallback(final Function0 function0) {
        return new OnBackInvokedCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0
            public final void onBackInvoked() {
                function0.invoke();
            }
        };
    }

    public final void registerOnBackInvokedCallback(Object obj, int i, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
    }

    public final void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
