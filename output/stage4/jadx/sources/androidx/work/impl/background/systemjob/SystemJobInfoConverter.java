package androidx.work.impl.background.systemjob;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.SystemClock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemJobInfoConverter {
    public final SystemClock mClock;
    public final ComponentName mWorkServiceComponent;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{107, 26, 75, 69, 80, 15, 40, 12, 1, 120, 86, 5, 87, 114, 90, 12, 20, 6, 17, 69, 93, 17}, "8c815bbcc1", 0.0f));
    }

    public SystemJobInfoConverter(Context context, SystemClock systemClock) {
        this.mClock = systemClock;
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
