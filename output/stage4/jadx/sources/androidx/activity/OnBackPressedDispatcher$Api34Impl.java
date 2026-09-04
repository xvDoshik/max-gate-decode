package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OnBackPressedDispatcher$Api34Impl {
    public static final OnBackPressedDispatcher$Api34Impl INSTANCE = new OnBackPressedDispatcher$Api34Impl();

    public final OnBackInvokedCallback createOnBackAnimationCallback(final Function1 function1, final Function1 function2, final Function0 function0, final Function0 function3) {
        return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
            public final void onBackCancelled() {
                function3.invoke();
            }

            public final void onBackInvoked() {
                function0.invoke();
            }

            public final void onBackProgressed(BackEvent backEvent) {
                function2.invoke(new BackEventCompat(backEvent));
            }

            public final void onBackStarted(BackEvent backEvent) {
                function1.invoke(new BackEventCompat(backEvent));
            }
        };
    }
}
