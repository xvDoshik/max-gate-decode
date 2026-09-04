package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AndroidSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final SocketAdapter create(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals(C0000.decode(new byte[]{121, 70, 86, 13, 97, 97, 117, 96, 89, 84, 89, 82, 64, 112, 14, 72, 90}, "663c2293672749c8", 2))) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError(C0000.decode(new byte[]{119, 93, 19, 118, 69, 81, 8, 100, 103, 47, 97, 12, 90, 89, 86, 77, 124, 89, 22, 91, 20, 16, 71, 19, 92, 64, 80, 85, 84, 71, 21, 23, 91, 5, 18, 16, 86, 81, 88, 92, 65, 20, 9, 81, 20, 23, 75, 19, 92, 18}, "923954f74c2c", 0.0f) + cls);
            }
        }
        return new AndroidSocketAdapter(superclass);
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return sSLSocket.getClass().getName().startsWith(C0000.decode(new byte[]{87, 10, 9, 75, 2, 13, 93, 5, 88, 82, 26, 4, 10, 1, 23, 13, 91, 6, 26, 80, 89, 22, 74, 10, 23, 5, 28, 1, 91, 89, 71, 6, 22, 28, 21, 22, 28}, "4edeeb2b47", 2));
    }
}
