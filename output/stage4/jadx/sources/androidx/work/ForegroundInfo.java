package androidx.work;

import android.app.Notification;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ForegroundInfo {
    public final int mForegroundServiceType;
    public final Notification mNotification;
    public final int mNotificationId;

    public ForegroundInfo(int i, Notification notification, int i2) {
        this.mNotificationId = i;
        this.mNotification = notification;
        this.mForegroundServiceType = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.mNotificationId == foregroundInfo.mNotificationId && this.mForegroundServiceType == foregroundInfo.mForegroundServiceType) {
            return this.mNotification.equals(foregroundInfo.mNotification);
        }
        return false;
    }

    public final int hashCode() {
        return this.mNotification.hashCode() + (((this.mNotificationId * 31) + this.mForegroundServiceType) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{36, 92, 65, 81, 82, 64, 10, 66, 89, 87, 44, 94, 80, 93, 30, 89, 44, 92, 71, 93, 83, 91, 6, 86, 67, 90, 10, 94, 127, 86, 88}, "b33452e773e062e4", 0));
        sb.append(this.mNotificationId);
        sb.append(C0000.decode(new byte[]{77, 66, 9, 116, 10, 22, 0, 4, 23, 12, 64, 13, 5, 49, 1, 64, 19, 13, 6, 6, 49, 26, 69, 6, 92}, "abd2edecec5c", true));
        sb.append(this.mForegroundServiceType);
        sb.append(C0000.decode(new byte[]{73, 66, 92, 47, 87, 67, 93, 3, 12, 1, 80, 21, 81, 88, 90, 88}, "eb1a874e", 6));
        sb.append(this.mNotification);
        sb.append('}');
        return sb.toString();
    }
}
