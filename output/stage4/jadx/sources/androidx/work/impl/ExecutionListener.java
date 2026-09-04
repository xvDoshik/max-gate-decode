package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface ExecutionListener {
    void onExecuted(WorkGenerationalId workGenerationalId, boolean z);
}
