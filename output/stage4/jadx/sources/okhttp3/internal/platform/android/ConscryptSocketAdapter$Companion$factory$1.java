package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.ConscryptPlatform;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConscryptSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final SocketAdapter create(SSLSocket sSLSocket) {
        return new ConscryptSocketAdapter();
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return ConscryptPlatform.isSupported && Conscrypt.isConscrypt(sSLSocket);
    }
}
