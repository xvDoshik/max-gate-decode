package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BouncyCastlePlatform extends Platform {
    public static final boolean isSupported;
    public final Provider provider = new BouncyCastleJsseProvider();

    static {
        boolean z = false;
        try {
            Class.forName(C0000.decode(new byte[]{9, 64, 4, 26, 4, 92, 19, 92, 0, 77, 5, 82, 21, 70, 15, 81, 72, 89, 21, 65, 6, 26, 22, 65, 9, 68, 10, 80, 3, 65, 72, 112, 12, 65, 8, 80, 31, 113, 2, 71, 18, 95, 3, 120, 16, 71, 3, 99, 20, 93, 21, 93, 2, 86, 20}, "f2c4f3", true), false, Headers.Companion.class.getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext newSSLContext() {
        return SSLContext.getInstance(C0000.decode(new byte[]{97, 121, 98}, "551d336b", 0.0f), this.provider);
    }

    @Override // okhttp3.internal.platform.Platform
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(C0000.decode(new byte[]{49, 45, 121, 110}, "af063503efafd443", 0.0f), C0000.decode(new byte[]{32, 37, 46, 49, 50, 114}, "bfdba754"));
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException(C0000.decode(new byte[]{108, 15, 6, 74, 73, 3, 80, 17, 92, 5, 67, 86, 92, 0, 82, 16, 85, 21, 67, 70, 75, 19, 64, 17, 25, 12, 2, 92, 88, 1, 86, 23, 74, 91, 67}, "9ac29f3e", 1).concat(Arrays.toString(trustManagers)).toString());
    }
}
