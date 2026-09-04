package androidx.core.app;

import android.app.Notification;
import android.app.Person;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NotificationCompatBuilder$Api28Impl {
    public static Notification.Builder addPerson(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int i) {
        return builder.setSemanticAction(i);
    }
}
