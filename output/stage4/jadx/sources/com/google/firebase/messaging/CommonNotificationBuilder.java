package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CommonNotificationBuilder {
    public static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static boolean isValidIcon(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            return !(resources.getDrawable(i, null) instanceof AdaptiveIconDrawable);
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }
}
