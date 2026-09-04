package androidx.core.app;

import android.app.Notification;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NotificationCompatBuilder$Api16Impl {
    public static Notification build(Notification.Builder builder) {
        return builder.build();
    }

    public static Notification.Builder setPriority(Notification.Builder builder, int i) {
        return builder.setPriority(i);
    }

    public static Notification.Builder setSubText(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSubText(charSequence);
    }

    public static Notification.Builder setUsesChronometer(Notification.Builder builder, boolean z) {
        return builder.setUsesChronometer(z);
    }
}
