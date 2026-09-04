package okhttp3.internal.connection;

import androidx.work.Configuration;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        RealCall realCall = realInterceptorChain.call;
        synchronized (realCall) {
            try {
                if (!realCall.expectMoreExchanges) {
                    throw new IllegalStateException(C0000.decode(new byte[]{70, 86, 8, 92, 89, 71, 81, 87}, "43d984", 4));
                }
                if (realCall.responseBodyOpen) {
                    throw new IllegalStateException(C0000.decode(new byte[]{116, 90, 84, 2, 14, 16, 81, 83, 88, 13, 0, 84, 25}, "721ae0", 0.0f));
                }
                if (realCall.requestBodyOpen) {
                    throw new IllegalStateException(C0000.decode(new byte[]{118, 11, 3, 83, 91, 65, 80, 4, 11, 91, 87, 2, 28}, "5cf00a6eb72f2b", 5));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Configuration configuration = realCall.exchangeFinder;
        OkHttpClient okHttpClient = realCall.client;
        configuration.getClass();
        try {
            Exchange exchange = new Exchange(realCall, configuration, configuration.findHealthyConnection(realInterceptorChain.connectTimeoutMillis, realInterceptorChain.readTimeoutMillis, realInterceptorChain.writeTimeoutMillis, okHttpClient.retryOnConnectionFailure, !Intrinsics.areEqual((String) realInterceptorChain.request.method, C0000.decode(new byte[]{38, 36, 102}, "aa2a85", false))).newCodec$okhttp(okHttpClient, realInterceptorChain));
            realCall.interceptorScopedExchange = exchange;
            realCall.exchange = exchange;
            synchronized (realCall) {
                realCall.requestBodyOpen = true;
                realCall.responseBodyOpen = true;
            }
            if (realCall.canceled) {
                throw new IOException(C0000.decode(new byte[]{37, 85, 88, 87, 3, 15, 87, 87}, "f464fc236a55a7f6"));
            }
            return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, exchange, null, 61).proceed(realInterceptorChain.request);
        } catch (IOException e) {
            configuration.trackFailure(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            configuration.trackFailure(e2.lastConnectException);
            throw e2;
        }
    }
}
