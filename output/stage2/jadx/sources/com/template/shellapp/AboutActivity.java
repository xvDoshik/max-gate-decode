package com.template.shellapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class AboutActivity extends Activity {
    private void addInfoRow(LinearLayout linearLayout, String str, String str2) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(0, dp(10), 0, dp(10));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor(C0000.decode(new byte[]{65, 1, 12, 91, 0, 94, 89}, "b94c8fa5ee552a", 1)));
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(Color.parseColor(C0000.decode(new byte[]{65, 10, 10, 11, 85, 5, 3}, "b998f6090f", 0.0f)));
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private boolean isRu() {
        return Locale.getDefault().getLanguage().equals(C0000.decode(new byte[]{16, 69}, "b0b9c7936d"));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String strDecode;
        super.onCreate(bundle);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.parseColor(C0000.decode(new byte[]{70, 35, 12, 117, 1, 116, 4}, "ee9342114d00", 5)));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(24), dp(24), dp(24), dp(24));
        linearLayout.setGravity(1);
        TextView textView = new TextView(this);
        textView.setText(getString(R.string.app_name));
        textView.setTextSize(2, 24.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor(C0000.decode(new byte[]{16, 87, 112, 0, 37, 4, 119}, "3f11d5696f")));
        textView.setGravity(17);
        textView.setPadding(0, dp(32), 0, dp(8));
        linearLayout.addView(textView);
        try {
            strDecode = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception unused) {
            strDecode = C0000.decode(new byte[]{7, 30, 4}, "604496ac4e7586", 1);
        }
        TextView textView2 = new TextView(this);
        textView2.setText((isRu() ? C0000.decode(new byte[]{-23, -96, -31, -47, -80, -76, -28, -72, -74, ByteCompanionObject.MIN_VALUE, -32, -67, 25}, "921da459f812") : C0000.decode(new byte[]{48, 4, 69, 64, 11, 11, 92, 23}, "fa73bd27ac7a41", true)) + strDecode);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(Color.parseColor(C0000.decode(new byte[]{17, 15, 15, 90, 89, 0, 1}, "277ba896f636c46a", 0.0f)));
        textView2.setGravity(17);
        textView2.setPadding(0, 0, 0, dp(32));
        linearLayout.addView(textView2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(dp(20), dp(16), dp(20), dp(16));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(dp(16));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setElevation(dp(4));
        addInfoRow(linearLayout2, isRu() ? C0000.decode(new byte[]{-26, -62, -23, -77, -32, -32, -77, -78, -26, -33, -24, -117, -32, -29, -77, -80, -26, -45, -24, -116}, "6a821bb2") : C0000.decode(new byte[]{124, 83, 67, 81, 80, 85}, "865830121291"), Build.MANUFACTURER + C0000.decode(new byte[]{69}, "e083b334", 4) + Build.MODEL);
        addInfoRow(linearLayout2, C0000.decode(new byte[]{119, 93, 86, 69, 9, 11, 84}, "6327fb0543", true), Build.VERSION.RELEASE);
        addInfoRow(linearLayout2, C0000.decode(new byte[]{96, 39, 123}, "3c07561c7d", true), String.valueOf(Build.VERSION.SDK_INT));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}
