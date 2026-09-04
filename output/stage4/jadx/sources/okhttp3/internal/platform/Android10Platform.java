package okhttp3.internal.platform;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import androidx.work.impl.AutoMigration_14_15;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.CharsKt;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Android10Platform extends Platform {
    public static final boolean isSupported;
    public final ArrayList socketAdapters;

    static {
        isSupported = AutoMigration_14_15.isAndroid() && Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        int i = 0;
        ArrayList arrayListListOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((!AutoMigration_14_15.isAndroid() || Build.VERSION.SDK_INT < 29) ? null : new Android10SocketAdapter(), new DeferredSocketAdapter(AndroidSocketAdapter.playProviderFactory), new DeferredSocketAdapter(ConscryptSocketAdapter.factory), new DeferredSocketAdapter(BouncyCastleSocketAdapter.factory));
        ArrayList arrayList = new ArrayList();
        int size = arrayListListOfNotNull.size();
        while (i < size) {
            Object obj = arrayListListOfNotNull.get(i);
            i++;
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // okhttp3.internal.platform.Platform
    public final CharsKt buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions) : null;
        return androidCertificateChainCleaner != null ? androidCertificateChainCleaner : super.buildCertificateChainCleaner(x509TrustManager);
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        ArrayList arrayList = this.socketAdapters;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            } else {
                obj = arrayList.get(i);
                i++;
            }
        } while (!((SocketAdapter) obj).matchesSocket(sSLSocket));
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sSLSocket, str, list);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.socketAdapters;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
        } while (!((SocketAdapter) obj).matchesSocket(sSLSocket));
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            return socketAdapter.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final boolean isCleartextTrafficPermitted(String str) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
