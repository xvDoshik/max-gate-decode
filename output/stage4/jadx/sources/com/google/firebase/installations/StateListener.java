package com.google.firebase.installations;

import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface StateListener {
    boolean onException(Exception exc);

    boolean onStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry);
}
