package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.BouncyCastlePlatform;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BouncyCastleSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final SocketAdapter create(SSLSocket sSLSocket) {
        return new BouncyCastleSocketAdapter();
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        boolean z = BouncyCastlePlatform.isSupported;
        return false;
    }
}
