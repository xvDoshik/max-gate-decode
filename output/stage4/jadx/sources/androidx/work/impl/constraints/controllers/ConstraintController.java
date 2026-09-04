package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConstraintController {
    public final ConstraintTracker tracker;

    public ConstraintController(ConstraintTracker constraintTracker) {
        this.tracker = constraintTracker;
    }

    public abstract int getReason();

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public abstract boolean isConstrained(Object obj);
}
