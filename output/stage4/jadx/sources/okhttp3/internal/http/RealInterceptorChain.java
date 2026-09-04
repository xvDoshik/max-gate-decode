package okhttp3.internal.http;

import androidx.work.Configuration;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealInterceptorChain {
    public final RealCall call;
    public int calls;
    public final int connectTimeoutMillis;
    public final Exchange exchange;
    public final int index;
    public final ArrayList interceptors;
    public final int readTimeoutMillis;
    public final Request request;
    public final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall realCall, ArrayList arrayList, int i, Exchange exchange, Request request, int i2, int i3, int i4) {
        this.call = realCall;
        this.interceptors = arrayList;
        this.index = i;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
    }

    public static RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i, Exchange exchange, Request request, int i2) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        int i3 = i;
        if ((i2 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((i2 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        int i4 = realInterceptorChain.connectTimeoutMillis;
        int i5 = realInterceptorChain.readTimeoutMillis;
        int i6 = realInterceptorChain.writeTimeoutMillis;
        return new RealInterceptorChain(realInterceptorChain.call, realInterceptorChain.interceptors, i3, exchange2, request, i4, i5, i6);
    }

    public final Response proceed(Request request) {
        ArrayList arrayList = this.interceptors;
        int size = arrayList.size();
        int i = this.index;
        if (i >= size) {
            throw new IllegalStateException(C0000.decode(new byte[]{33, 88, 82, 85, 93, 22, 81, 7, 93, 90, 82, 81, 29}, "b076667f4675356d", 0.0f));
        }
        this.calls++;
        String strDecode = C0000.decode(new byte[]{66, 90, 16, 68, 64, 21, 87, 82, 85, 9, 17, 67, 16, 88, 6, 82, 81, 81, 28, 26, 25, 0, 73, 82, 1, 67, 9, 78, 20, 90, 90, 80, 92}, "b7e745439e13", 4);
        Exchange exchange = this.exchange;
        String strDecode2 = C0000.decode(new byte[]{94, 7, 65, 68, 11, 69, 93, 67, 89, 12, 65, 86, 22, 84, 83, 19, 68, 13, 71, 19}, "0b53d76c", 0.0f);
        if (exchange != null) {
            Configuration configuration = (Configuration) exchange.finder;
            HttpUrl httpUrl = (HttpUrl) request.url;
            HttpUrl httpUrl2 = ((Address) configuration.taskExecutor).url;
            if (httpUrl.port != httpUrl2.port || !Intrinsics.areEqual(httpUrl.host, httpUrl2.host)) {
                throw new IllegalStateException((strDecode2 + arrayList.get(i - 1) + C0000.decode(new byte[]{69, 84, 22, 68, 22, 17, 74, 84, 66, 85, 10, 15, 66, 65, 13, 82, 69, 74, 2, 90, 7, 17, 80, 94, 69, 64, 67, 0, 12, 81, 69, 71, 10, 75, 23}, "e9c7b18164cab5e7", 0.0f)).toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException((strDecode2 + arrayList.get(i - 1) + strDecode).toString());
            }
        }
        int i2 = i + 1;
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, i2, null, request, 58);
        Interceptor interceptor = (Interceptor) arrayList.get(i);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        String strDecode3 = C0000.decode(new byte[]{11, 93, 21, 4, 22, 2, 87, 18, 65, 87, 69, 18}, "b3aada2b5872");
        if (responseIntercept == null) {
            throw new NullPointerException(strDecode3 + interceptor + C0000.decode(new byte[]{17, 19, 92, 71, 64, 16, 95, 4, 93, 19, 91, 23, 93, 13}, "1a935b", 0));
        }
        if (exchange != null && i2 < arrayList.size() && realInterceptorChainCopy$okhttp$default.calls != 1) {
            throw new IllegalStateException((strDecode2 + interceptor + strDecode).toString());
        }
        if (responseIntercept.body != null) {
            return responseIntercept;
        }
        throw new IllegalStateException((strDecode3 + interceptor + C0000.decode(new byte[]{22, 68, 86, 16, 68, 16, 94, 4, 85, 67, 87, 22, 65, 1, 66, 18, 95, 15, 66, 6, 22, 65, 90, 16, 89, 66, 94, 14, 17, 1, 89, 82, 74}, "663d1b0a1c")).toString());
    }
}
