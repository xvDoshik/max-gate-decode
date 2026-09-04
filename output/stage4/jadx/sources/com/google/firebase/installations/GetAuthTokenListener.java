package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GetAuthTokenListener implements StateListener {
    public final TaskCompletionSource resultTaskCompletionSource;
    public final Utils utils;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource taskCompletionSource) {
        this.utils = utils;
        this.resultTaskCompletionSource = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onException(Exception exc) {
        this.resultTaskCompletionSource.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        if (autoValue_PersistedInstallationEntry.registrationStatus != 4 || this.utils.isAuthTokenExpired(autoValue_PersistedInstallationEntry)) {
            return false;
        }
        String str = autoValue_PersistedInstallationEntry.authToken;
        if (str == null) {
            throw new NullPointerException(C0000.decode(new byte[]{123, 17, 90, 94, 17, 64, 13, 88, 4, 11}, "5d6214b3aec37552"));
        }
        this.resultTaskCompletionSource.setResult(new AutoValue_InstallationTokenResult(str, autoValue_PersistedInstallationEntry.expiresInSecs, autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs));
        return true;
    }
}
