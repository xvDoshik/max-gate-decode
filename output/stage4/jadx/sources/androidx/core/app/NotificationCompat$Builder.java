package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NotificationCompat$Builder {
    public final boolean mAllowSystemGeneratedContextualActions;
    public String mCategory;
    public String mChannelId;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public final Context mContext;
    public Bundle mExtras;
    public PendingIntent mFullScreenIntent;
    public IconCompat mLargeIcon;
    public final Notification mNotification;
    public int mNumber;
    public final ArrayList mPeople;
    public int mPriority;
    public boolean mSilent;
    public NotificationCompat$Style mStyle;
    public final ArrayList mActions = new ArrayList();
    public final ArrayList mPersonList = new ArrayList();
    public final ArrayList mInvisibleActions = new ArrayList();
    public boolean mShowWhen = true;
    public boolean mLocalOnly = false;
    public int mColor = 0;
    public int mVisibility = 0;

    public abstract class Api21Impl {
        public static AudioAttributes build(AudioAttributes.Builder builder) {
            return builder.build();
        }

        public static AudioAttributes.Builder createBuilder() {
            return new AudioAttributes.Builder();
        }

        public static AudioAttributes.Builder setContentType(AudioAttributes.Builder builder, int i) {
            return builder.setContentType(i);
        }

        public static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder builder, int i) {
            return builder.setLegacyStreamType(i);
        }

        public static AudioAttributes.Builder setUsage(AudioAttributes.Builder builder, int i) {
            return builder.setUsage(i);
        }
    }

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification build() {
        Bundle bundle;
        Dispatcher dispatcher = new Dispatcher(this);
        NotificationCompat$Builder notificationCompat$Builder = (NotificationCompat$Builder) dispatcher.runningAsyncCalls;
        NotificationCompat$Style notificationCompat$Style = notificationCompat$Builder.mStyle;
        if (notificationCompat$Style != null) {
            notificationCompat$Style.apply(dispatcher);
        }
        Notification notificationBuild = NotificationCompatBuilder$Api16Impl.build((Notification.Builder) dispatcher.readyAsyncCalls);
        if (notificationCompat$Style != null) {
            notificationCompat$Builder.mStyle.getClass();
        }
        if (notificationCompat$Style != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString(C0000.decode(new byte[]{88, 94, 7, 70, 94, 92, 86, 79, 22, 2, 86, 66, 6, 26, 80, 69, 66, 25, 93, 25, 77, 66, 2, 26, 114, 122, 127, 103, 121, 53, 102, 100, 38, 121, 97, 121, 115, 99, 125}, "90c415278a", true), notificationCompat$Style.getClassName());
        }
        return notificationBuild;
    }

    public final void setFlag(int i, boolean z) {
        Notification notification = this.mNotification;
        if (z) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void setLargeIcon(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(2130968582);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(2130968581);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.mObj1 = bitmap;
            iconCompat = iconCompat2;
        }
        this.mLargeIcon = iconCompat;
    }

    public final void setStyle(NotificationCompat$Style notificationCompat$Style) {
        if (this.mStyle != notificationCompat$Style) {
            this.mStyle = notificationCompat$Style;
            if (((NotificationCompat$Builder) notificationCompat$Style.mBuilder) != this) {
                notificationCompat$Style.mBuilder = this;
                setStyle(notificationCompat$Style);
            }
        }
    }
}
