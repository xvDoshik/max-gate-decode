package okhttp3;

import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Interceptor {
    Response intercept(RealInterceptorChain realInterceptorChain);
}
