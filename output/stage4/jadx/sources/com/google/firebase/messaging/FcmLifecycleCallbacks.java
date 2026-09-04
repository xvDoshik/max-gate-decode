package com.google.firebase.messaging;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.text.CharsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FcmLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public final Set seenIntents = Collections.newSetFromMap(new WeakHashMap());

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intent intent = activity.getIntent();
        if (intent == null || !this.seenIntents.add(intent)) {
            return;
        }
        Bundle bundle2 = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                bundle2 = extras.getBundle(C0000.decode(new byte[]{84, 0, 90, 30, 91, 79, 86, 91, 86, 8, 74, 64, 12, 2, 64, 60, 83, 81, 65, 0}, "3c705a757d34ea", 6));
            }
        } catch (RuntimeException unused) {
        }
        String strDecode = C0000.decode(new byte[]{87}, "f5928d24ca");
        if (bundle2 == null ? false : strDecode.equals(bundle2.getString(C0000.decode(new byte[]{85, 92, 87, 81, 14, 85, 26, 81, 25, 89, 74, 0}, "2386b04278de", 0.0f)))) {
            if (bundle2 != null && strDecode.equals(bundle2.getString(C0000.decode(new byte[]{82, 9, 88, 2, 15, 84, 75, 5, 27, 7, 25, 17, 0}, "5f7ec1ef", 0.0f)))) {
                FirebaseApp firebaseApp = FirebaseApp.getInstance();
                firebaseApp.checkNotDeleted();
                if (firebaseApp.componentRuntime.get(AnalyticsConnector.class) != null) {
                    throw new ClassCastException();
                }
            }
            CharsKt.logToScion(C0000.decode(new byte[]{60, 91, 14}, "c5ae1be78c3e", 7), bundle2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            this.seenIntents.remove(activity.getIntent());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
