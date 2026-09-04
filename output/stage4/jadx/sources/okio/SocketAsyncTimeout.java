package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {
    public final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        this.socket = socket;
    }

    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(C0000.decode(new byte[]{66, 80, 84, 84, 95, 23, 70}, "69910b2dc16d", 6));
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public final void timedOut() {
        String strDecode = C0000.decode(new byte[]{127, 83, 15, 15, 0, 0, 65, 23, 86, 18, 5, 15, 10, 23, 4, 67, 77, 91, 11, 6, 1, 68, 14, 22, 77, 18, 21, 12, 6, 15, 4, 23, 25}, "92fcedac", false);
        Socket socket = this.socket;
        try {
            socket.close();
        } catch (AssertionError e) {
            Logger logger = Okio__JvmOkioKt.logger;
            boolean z = false;
            if (e.getCause() != null) {
                String message = e.getMessage();
                if (message != null ? StringsKt.contains$default(message, C0000.decode(new byte[]{94, 85, 18, 16, 92, 86, 93, 15, 85, 8, 92, 16, 0, 2, 90, 89, 83, 5}, "90fc356a4e")) : false) {
                    z = true;
                }
            }
            if (!z) {
                throw e;
            }
            Okio__JvmOkioKt.logger.log(Level.WARNING, strDecode + socket, (Throwable) e);
        } catch (Exception e2) {
            Okio__JvmOkioKt.logger.log(Level.WARNING, strDecode + socket, (Throwable) e2);
        }
    }
}
