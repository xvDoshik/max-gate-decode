package com.google.firebase.installations.remote;

import androidx.profileinstaller.ProfileInstaller$2;
import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RequestLimiter {
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    public int attemptCount;
    public long nextRequestTime;
    public final Utils utils;

    public RequestLimiter() {
        if (ProfileInstaller$2.singleton == null) {
            Pattern pattern = Utils.API_KEY_FORMAT;
            ProfileInstaller$2.singleton = new ProfileInstaller$2();
        }
        ProfileInstaller$2 profileInstaller$2 = ProfileInstaller$2.singleton;
        if (Utils.singleton == null) {
            Utils.singleton = new Utils(profileInstaller$2);
        }
        this.utils = Utils.singleton;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001b  */
    public final synchronized boolean isRequestAllowed() {
        boolean z;
        if (this.attemptCount != 0) {
            this.utils.clock.getClass();
            if (System.currentTimeMillis() > this.nextRequestTime) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized void setNextRequestTime(int i) {
        long jMin;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.attemptCount = 0;
            }
            return;
        }
        this.attemptCount++;
        synchronized (this) {
            try {
                if (i == 429 || (i >= 500 && i < 600)) {
                    double dPow = Math.pow(2.0d, this.attemptCount);
                    this.utils.getClass();
                    jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
                } else {
                    jMin = MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
                }
                this.utils.clock.getClass();
                this.nextRequestTime = System.currentTimeMillis() + jMin;
            } catch (Throwable th) {
                throw th;
            }
        }
        return;
        throw th;
    }
}
