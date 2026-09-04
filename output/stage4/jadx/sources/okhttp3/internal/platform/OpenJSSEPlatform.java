package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.text.CharsKt;
import org.openjsse.net.ssl.OpenJSSE;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OpenJSSEPlatform extends Platform {
    public static final boolean isSupported;
    public final Provider provider = new OpenJSSE();

    static {
        boolean z = false;
        try {
            Class.forName(C0000.decode(new byte[]{9, 20, 85, 72, 94, 72, 84, 15, 15, 67, 71, 84, 76, 95, 3, 18, 28, 21, 66, 84, 31, 46, 21, 85, 90, 123, 49, 98, 35}, "ff2f181ae041b1"), false, CharsKt.class.getClassLoader());
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
        return SSLContext.getInstance(C0000.decode(new byte[]{54, 40, 102, 66, 82, 77, 7}, "bd54cc4cd5", 0.0f), this.provider);
    }

    @Override // okhttp3.internal.platform.Platform
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException(C0000.decode(new byte[]{99, 92, 80, 30, 19, 83, 84, 66, 80, 92, 68, 6, 93, 80, 7, 76, 90, 70, 21, 18, 17, 67, 68, 66, 21, 85, 5, 12, 89, 81, 3, 75, 69, 8, 21}, "625fc67658db86f9", 7).concat(Arrays.toString(trustManagers)).toString());
    }
}
