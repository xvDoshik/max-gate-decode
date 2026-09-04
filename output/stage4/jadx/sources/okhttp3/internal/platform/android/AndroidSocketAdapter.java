package okhttp3.internal.platform.android;

import androidx.work.impl.AutoMigration_14_15;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class AndroidSocketAdapter implements SocketAdapter {
    public static final AndroidSocketAdapter$Companion$factory$1 playProviderFactory = new AndroidSocketAdapter$Companion$factory$1();
    public final Method getAlpnSelectedProtocol;
    public final Method setAlpnProtocols;
    public final Method setHostname;
    public final Method setUseSessionTickets;
    public final Class sslSocketClass;

    public AndroidSocketAdapter(Class cls) {
        this.sslSocketClass = cls;
        this.setUseSessionTickets = cls.getDeclaredMethod(C0000.decode(new byte[]{68, 82, 70, 96, 69, 80, 101, 92, 68, 23, 94, 88, 92, 97, 95, 86, 93, 92, 67, 23}, "772565697d", true), Boolean.TYPE);
        this.setHostname = cls.getMethod(C0000.decode(new byte[]{69, 83, 69, 113, 12, 23, 17, 90, 88, 12, 85}, "6619cde49a01", 2), String.class);
        this.getAlpnSelectedProtocol = cls.getMethod(C0000.decode(new byte[]{94, 93, 77, 113, 15, 68, 88, 97, 80, 90, 82, 84, 23, 0, 0, 103, 75, 87, 77, 95, 0, 91, 90}, "9890c4625677ced7", 0.0f), null);
        this.setAlpnProtocols = cls.getMethod(C0000.decode(new byte[]{65, 80, 70, 114, 84, 71, 8, 105, 68, 87, 70, 90, 81, 92, 84, 68}, "252387f968"), byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.setHostname.invoke(sSLSocket, str);
                }
                Method method = this.setAlpnProtocols;
                Platform platform = Platform.platform;
                method.invoke(sSLSocket, AutoMigration_14_15.concatLengthPrefixed(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, Charsets.UTF_8);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof NullPointerException) || !Intrinsics.areEqual(((NullPointerException) cause).getMessage(), C0000.decode(new byte[]{67, 71, 90, 24, 11, 92, 19, 8, 65, 91, 94}, "04686a3f4728", false))) {
                    throw new AssertionError(e2);
                }
            }
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        boolean z = AndroidPlatform.isSupported;
        return AndroidPlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return this.sslSocketClass.isInstance(sSLSocket);
    }
}
