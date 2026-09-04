package okhttp3.internal.platform;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__IterablesKt;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConscryptPlatform extends Platform {
    public static final boolean isSupported;
    public final Provider provider = Conscrypt.newProvider();

    public abstract class Companion {
        public static boolean atLeastVersion() {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != 2) {
                if (version.major() <= 2) {
                    return false;
                }
            } else if (version.minor() != 1) {
                if (version.minor() <= 1) {
                    return false;
                }
            } else if (version.patch() < 0) {
                return false;
            }
            return true;
        }
    }

    public final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = new DisabledHostnameVerifier();
    }

    static {
        boolean z = false;
        try {
            Class.forName(C0000.decode(new byte[]{9, 70, 94, 30, 7, 88, 15, 64, 90, 75, 31, 20, 18, 31, 37, 91, 87, 67, 7, 69, 24, 67, 77, 29, 48, 1, 20, 66, 15, 91, 87}, "f490d7a399fdf1", 2), false, Companion.class.getClassLoader());
            if (Conscrypt.isAvailable() && Companion.atLeastVersion()) {
                z = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        isSupported = z;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList));
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                arrayList2.add(((Protocol) obj2).protocol);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) arrayList2.toArray(new String[0]));
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext newSSLContext() {
        return SSLContext.getInstance(C0000.decode(new byte[]{54, 126, 99}, "b203efc1d1b463", 0.0f), this.provider);
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) throws KeyManagementException {
        SSLContext sSLContextNewSSLContext = newSSLContext();
        TrustManager[] trustManagerArr = new TrustManager[1];
        trustManagerArr[0] = x509TrustManager;
        sSLContextNewSSLContext.init(null, trustManagerArr, null);
        return sSLContextNewSSLContext.getSocketFactory();
    }

    @Override // okhttp3.internal.platform.Platform
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, DisabledHostnameVerifier.INSTANCE);
                return x509TrustManager;
            }
        }
        throw new IllegalStateException(C0000.decode(new byte[]{98, 87, 87, 76, 65, 0, 80, 71, 81, 84, 17, 85, 81, 85, 86, 76, 94, 64, 17, 17, 65, 70, 71, 68, 17, 92, 85, 93, 86, 94, 87, 70, 66, 95, 19}, "79241e33401143", true).concat(Arrays.toString(trustManagers)).toString());
    }
}
