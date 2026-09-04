package com.base.template.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AuthenticatorService extends Service {
    public StubAuthenticator authenticator;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        StubAuthenticator stubAuthenticator = this.authenticator;
        if (stubAuthenticator == null) {
            stubAuthenticator = null;
        }
        return stubAuthenticator.getIBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.authenticator = new StubAuthenticator(this);
    }
}
