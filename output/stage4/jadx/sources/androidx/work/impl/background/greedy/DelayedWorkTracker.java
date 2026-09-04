package androidx.work.impl.background.greedy;

import androidx.work.SystemClock;
import java.util.HashMap;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DelayedWorkTracker {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SystemClock mClock;
    public final GreedyScheduler mImmediateScheduler;
    public final ConnectionPool mRunnableScheduler;
    public final HashMap mRunnables = new HashMap();

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{118, 85, 85, 83, 74, 4, 85, 52, 89, 70, 89, 100, 75, 83, 80, 10, 84, 17}, "20923a1c64", false));
    }

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, ConnectionPool connectionPool, SystemClock systemClock) {
        this.mImmediateScheduler = greedyScheduler;
        this.mRunnableScheduler = connectionPool;
        this.mClock = systemClock;
    }
}
