package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GetIdListener implements StateListener {
    public final TaskCompletionSource taskCompletionSource;

    public GetIdListener(TaskCompletionSource taskCompletionSource) {
        this.taskCompletionSource = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onException(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        int i = autoValue_PersistedInstallationEntry.registrationStatus;
        if (i != 3 && i != 4 && i != 5) {
            return false;
        }
        this.taskCompletionSource.trySetResult(autoValue_PersistedInstallationEntry.firebaseInstallationId);
        return true;
    }
}
