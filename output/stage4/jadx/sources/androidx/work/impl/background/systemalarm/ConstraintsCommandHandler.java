package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.SystemClock;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConstraintsCommandHandler {
    public final SystemClock mClock;
    public final int mStartId;
    public final ConnectionPool mWorkConstraintsTracker;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{115, 87, 11, 65, 21, 68, 88, 10, 12, 23, 68, 33, 92, 7, 123, 82, 94, 92, 9, 87, 19}, "08e2a69cbc7b1c33", 0.0f));
    }

    public ConstraintsCommandHandler(Context context, SystemClock systemClock, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mClock = systemClock;
        this.mStartId = i;
        this.mWorkConstraintsTracker = new ConnectionPool(systemAlarmDispatcher.mWorkManager.mTrackers);
    }
}
