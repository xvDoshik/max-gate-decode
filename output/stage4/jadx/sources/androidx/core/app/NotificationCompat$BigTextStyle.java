package androidx.core.app;

import android.app.Notification;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NotificationCompat$BigTextStyle extends NotificationCompat$Style {
    public CharSequence mBigText;

    public abstract class Api16Impl {
        public static Notification.BigTextStyle bigText(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
            return bigTextStyle.bigText(charSequence);
        }

        public static Notification.BigTextStyle createBigTextStyle(Notification.Builder builder) {
            return new Notification.BigTextStyle(builder);
        }

        public static Notification.BigTextStyle setBigContentTitle(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
            return bigTextStyle.setBigContentTitle(charSequence);
        }

        public static Notification.BigTextStyle setSummaryText(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
            return bigTextStyle.setSummaryText(charSequence);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(Dispatcher dispatcher) {
        Api16Impl.bigText(Api16Impl.setBigContentTitle(Api16Impl.createBigTextStyle((Notification.Builder) dispatcher.readyAsyncCalls), null), this.mBigText);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return C0000.decode(new byte[]{84, 88, 2, 75, 14, 15, 6, 29, 24, 5, 13, 71, 92, 23, 84, 70, 22, 23, 47, 9, 22, 12, 80, 15, 1, 84, 77, 80, 90, 88, 37, 86, 12, 22, 3, 17, 18, 36, 11, 82, 109, 92, 77, 66, 53, 77, 24, 10, 7}, "56f9afbe6fb599", 7);
    }
}
