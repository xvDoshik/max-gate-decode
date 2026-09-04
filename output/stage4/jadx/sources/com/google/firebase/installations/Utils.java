package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.profileinstaller.ProfileInstaller$2;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Utils {
    public static Utils singleton;
    public final ProfileInstaller$2 clock;
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);
    public static final Pattern API_KEY_FORMAT = Pattern.compile(C0000.decode(new byte[]{100, 112, 121, 110, 110, 66, 21, 108, 67, 6, 10, 72, 100, 75}, "818525", false));

    public Utils(ProfileInstaller$2 profileInstaller$2) {
        this.clock = profileInstaller$2;
    }

    public final boolean isAuthTokenExpired(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        if (TextUtils.isEmpty(autoValue_PersistedInstallationEntry.authToken)) {
            return true;
        }
        long j = autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs + autoValue_PersistedInstallationEntry.expiresInSecs;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.clock.getClass();
        return j < timeUnit.toSeconds(System.currentTimeMillis()) + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
    }
}
