package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface OnConstraintsStateChangedListener {
    void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState);
}
