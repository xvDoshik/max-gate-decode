package okhttp3.internal.platform;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import androidx.work.impl.AutoMigration_14_15;
import com.google.android.gms.cloudmessaging.zzac;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.TrustRootIndex;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AndroidPlatform extends Platform {
    public static final boolean isSupported;
    public final zzac closeGuard;
    public final ArrayList socketAdapters;

    public final class CustomTrustRootIndex implements TrustRootIndex {
        public final Method findByIssuerAndSignatureMethod;
        public final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return Intrinsics.areEqual(this.trustManager, customTrustRootIndex.trustManager) && Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public final X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                return ((TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate)).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError(C0000.decode(new byte[]{66, 86, 84, 1, 15, 86, 17, 21, 86, 17, 80, 93, 65, 67, 10, 64, 66, 20, 92, 66, 23, 89, 91, 7, 67, 64, 88, 6, 87, 80, 67, 77, 71, 6}, "785cc31a91"), e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public final int hashCode() {
            return this.findByIssuerAndSignatureMethod.hashCode() + (this.trustManager.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{115, 22, 21, 66, 12, 84, 98, 68, 23, 74, 68, 49, 9, 89, 23, 112, 88, 82, 7, 65, 24, 23, 20, 67, 16, 77, 123, 87, 12, 88, 87, 6, 20, 11}, "0cf6c966b9", 0.0f));
            sb.append(this.trustManager);
            sb.append(C0000.decode(new byte[]{28, 65, 86, 94, 89, 92, 114, 24, 121, 68, 68, 77, 85, 19, 113, 89, 83, 107, 89, 6, 94, 86, 67, 77, 66, 4, 125, 82, 67, 80, 95, 5, 13}, "0a0778", 6));
            sb.append(this.findByIssuerAndSignatureMethod);
            sb.append(')');
            return sb.toString();
        }
    }

    static {
        boolean z = false;
        if (AutoMigration_14_15.isAndroid() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        isSupported = z;
    }

    public AndroidPlatform() throws NoSuchMethodException {
        StandardAndroidSocketAdapter standardAndroidSocketAdapter;
        Method method;
        Method method2;
        String strDecode = C0000.decode(new byte[]{84, 13, 11, 75, 86, 12, 80, 70, 93, 81, 83, 76, 9, 23, 80, 76, 87, 91, 92, 75, 84, 16, 31, 21, 67}, "7bfe7b4428", 5);
        String strDecode2 = C0000.decode(new byte[]{25, 107, 101, 47, 105, 86, 69, 89, 91, 6, 77, 82, 69, 75, 127, 14, 73, 91}, "786c97", true);
        String strDecode3 = C0000.decode(new byte[]{26, 118, 20, 86, 92, 50, 101, 42, 103, 13, 7, 8, 1, 71, 37, 80, 87, 77, 11, 65, 75, 40, 91, 22, 88}, "49d32a6f4bdcd3c1", 7);
        Method method3 = null;
        try {
            Class<?> cls = Class.forName(strDecode.concat(C0000.decode(new byte[]{76, 122, 22, 93, 94, 106, 103, 46, 107, 92, 90, 91, 4, 65, 43, 88, 22, 84}, "b5f8094b8390a5", false)));
            Class.forName(strDecode.concat(strDecode3));
            Class.forName(strDecode.concat(strDecode2));
            standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(cls);
        } catch (Exception e) {
            Platform.platform.getClass();
            Platform.log(C0000.decode(new byte[]{23, 92, 5, 83, 91, 82, 20, 16, 14, 16, 89, 88, 0, 83, 66, 83, 10, 85, 69, 88, 93, 0, 65, 67, 90, 84, 10, 82, 22, 18, 7, 93, 86, 68, 71, 1, 18}, "b2d1774da057a7", 0.0f), 5, e);
            standardAndroidSocketAdapter = null;
        }
        int i = 0;
        ArrayList arrayListListOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(standardAndroidSocketAdapter, new DeferredSocketAdapter(AndroidSocketAdapter.playProviderFactory), new DeferredSocketAdapter(ConscryptSocketAdapter.factory), new DeferredSocketAdapter(BouncyCastleSocketAdapter.factory));
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
        try {
            Class<?> cls2 = Class.forName(C0000.decode(new byte[]{85, 87, 92, 68, 92, 13, 77, 64, 79, 65, 69, 83, 93, 28, 118, 10, 12, 64, 83, 117, 68, 87, 66, 86}, "16025fc362", 0.0f));
            Method method4 = cls2.getMethod(C0000.decode(new byte[]{1, 84, 22}, "f1bbfc0ac1"), null);
            method2 = cls2.getMethod(C0000.decode(new byte[]{10, 21, 92, 89}, "ee975e06b872"), String.class);
            method = cls2.getMethod(C0000.decode(new byte[]{21, 89, 22, 89, 47, 86, 45, 72, 1, 89}, "b8d7f0", 5), null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.closeGuard = new zzac(method3, method2, method, 8);
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
    public final TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod(C0000.decode(new byte[]{83, 88, 11, 92, 98, 71, 64, 66, 17, 121, 88, 86, 93, 94, 23, 122, 79, 124, 70, 66, 16, 93, 68, 116, 91, 85, 54, 81, 81, 91, 84, 69, 16, 74, 83}, "51e865", 0.0f), X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
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
    public final void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException(C0000.decode(new byte[]{32, 65, 7, 93, 17, 76, 10, 93, 10, 67, 8, 93, 23, 82, 10, 87, 10, 93, 2, 76}, "e9d8a8c2dca371", 4), e);
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
    public final Object getStackTraceForCloseable() {
        String strDecode = C0000.decode(new byte[]{64, 0, 67, 68, 94, 15, 75, 81, 74, 82, 93, 81, 76, 76, 27, 75, 83, 88, 94, 18, 93, 28, 77}, "2e041a84d0255d", true);
        zzac zzacVar = this.closeGuard;
        Method method = (Method) zzacVar.zza;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                ((Method) zzacVar.zzb).invoke(objInvoke, strDecode);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final boolean isCleartextTrafficPermitted(String str) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public final void logCloseableLeak(Object obj, String str) {
        zzac zzacVar = this.closeGuard;
        zzacVar.getClass();
        if (obj != null) {
            try {
                ((Method) zzacVar.zzc).invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        Platform.log(str, 5, null);
    }
}
