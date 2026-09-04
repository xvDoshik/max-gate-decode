package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Scheduler {
    void cancel(String str);

    boolean hasLimitedSchedulingSlots();

    void schedule(WorkSpec... workSpecArr);
}
