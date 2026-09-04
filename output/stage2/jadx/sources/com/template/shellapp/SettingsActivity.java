package com.template.shellapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class SettingsActivity extends Activity {
    private SharedPreferences prefs;

    private void addSection(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor(C0000.decode(new byte[]{17, 6, 35, 89, 117, 124, 117}, "23aa1931a7f648", true)));
        textView.setPadding(dp(4), dp(16), 0, dp(8));
        linearLayout.addView(textView);
    }

    private void addToggle(LinearLayout linearLayout, String str, final String str2, boolean z) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(dp(12), dp(14), dp(12), dp(14));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(dp(12));
        linearLayout2.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dp(8);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(Color.parseColor(C0000.decode(new byte[]{17, 2, 0, 11, 2, 2, 3}, "2138110c8d56c9c0")));
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        Switch r12 = new Switch(this);
        r12.setChecked(this.prefs.getBoolean(str2, z));
        r12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.template.shellapp.SettingsActivity$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.m21lambda$addToggle$0$comtemplateshellappSettingsActivity(str2, compoundButton, z2);
            }
        });
        linearLayout2.addView(r12);
        linearLayout.addView(linearLayout2, layoutParams);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private boolean isRu() {
        return Locale.getDefault().getLanguage().equals(C0000.decode(new byte[]{65, 70}, "331ce1cf", false));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.prefs = getSharedPreferences(C0000.decode(new byte[]{18, 7, 68, 67, 89, 10, 6, 17}, "ab070d", true), 0);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.parseColor(C0000.decode(new byte[]{69, 113, 1, 118, 1, 118, 7}, "f740402ec2b5", false)));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dp(16), dp(16), dp(16), dp(16));
        TextView textView = new TextView(this);
        textView.setText(isRu() ? C0000.decode(new byte[]{-75, -5, -29, -123, -73, -72, -76, -75, -25, -72, -74, -114, -77, -118, -23, -116, -75, -34}, "ef35f9e768f0c396") : C0000.decode(new byte[]{98, 4, 64, 66, 13, 92, 6, 18}, "1a46d2aae4ae", 0.0f));
        textView.setTextSize(2, 22.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor(C0000.decode(new byte[]{21, 84, 112, 0, 39, 5, 37}, "6e11f4d7fab756ae", 5)));
        textView.setPadding(0, dp(8), 0, dp(24));
        linearLayout.addView(textView);
        addSection(linearLayout, isRu() ? C0000.decode(new byte[]{-27, -59, -76, -121, -30, -125, -76, -126, -74, -121, -25, -117, -75, -38, -76, -121, -27, -37, -76, -115, -29, -71}, "5fd526d6f977ead2", false) : C0000.decode(new byte[]{123, 94, 18, 15, 81, 8, 84, 3, 64, 88, 12, 95, 70}, "51ff7a7b41c152", true));
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-30, -88, -24, -116, -30, -116, -30, -121, -24, -123, -29, -67, -30, -123, -24, -126, -29, -76, -29, -69, 24, -29, -79, -26, ByteCompanionObject.MIN_VALUE, -25, -115, -30, -122, -26, -116, -25, -124, -30, -119, -26, -121, -25, -123, -30, -118, -25, -67}, "278226", 1) : C0000.decode(new byte[]{53, 94, 90, 64, 20, 92, 94, 18, 92, 2, 10, 1, 7, 66, 92, 88, 90, 65}, "f657421f5dcb"), C0000.decode(new byte[]{8, 12, 21, 15, 94, 94, 81, 80, 70, 90, 11, 11, 70, 107, 87, 92, 7, 1, 13, 3, 92}, "fcaf872123de5422", 0.0f), true);
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-30, -11, -26, -124, -23, -25, -77, -34, 65, -29, -27, -28, -42, -75, -121, -78, -126, -26, -122, -76, -33, -76, -38, -30, -45, -28, -39, -75, -118, -78, -113}, "2b668dcda2f4de", false) : C0000.decode(new byte[]{40, 91, 23, 13, 94, 91, 6, 2, 69, 80, 9, 90, 67, 23, 87, 71, 11, 7}, "f4cd82ec19"), C0000.decode(new byte[]{86, 95, 65, 93, 7, 10, 85, 85, 21, 89, 87, 94, 106, 71, 14, 22, 88, 80}, "8054ac64a0", true), true);
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-24, -86, -29, ByteCompanionObject.MIN_VALUE, -75, -124, -31, -27, -24, -120, -77, -25, -78, -115, -23, -73}, "8838e50e88bab5", 4) : C0000.decode(new byte[]{55, 90, 85, 19, 3, 76, 93, 92, 89}, "a37ab843739d", 0.0f), C0000.decode(new byte[]{69, 12, 4, 66, 4, 22, 13, 9, 92, 58, 3, 91, 82, 7, 10, 85, 1}, "3ef0ebdf2ef5"), false);
        addSection(linearLayout, isRu() ? C0000.decode(new byte[]{-30, -5, -79, -125, -25, -40, -76, -120, -27, -41, -32, -35, -74, -47, -30, -40, -79, -118, -26, -22}, "2ea27ed65e0ffd", true) : C0000.decode(new byte[]{101, 70, 87, 2, 21, 84, 22}, "063ca1e4", false));
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-31, -91, -74, -121, -23, -79, -79, -120, -28, -39, -31, -123, -73, -73, -24, -117, -80, -79, -28, -48, -32, -76, -74, -113, -24, -117, -79, -125, 20, -75, -113, -27, -41, -27, -123, -29, -33, -26, -122, -75, -118, -27, -45, -27, -123, -29, -39, -25, -69}, "15f583a64e", 0.0f) : C0000.decode(new byte[]{114, 66, 22, 10, 14, 88, 69, 13, 80, 23, 23, 21, 7, 88, 69, 1, 64}, "37bec91d"), C0000.decode(new byte[]{80, 65, 23, 91, 107, 70, 65, 80, 2, 64, 81}, "14c443", 5), true);
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-32, -87, -76, -124, -31, -39, -78, -117, -30, -124, -24, -40, -32, -126, -76, -120, -31, -36, -77, -70, 18, -26, -121, -77, -114, 23, 51, 92, 28, 34, 11}, "07d51db5268c", 3) : C0000.decode(new byte[]{98, 22, 81, 85, 64, 80, 23, 9, 67, 81, 70, 21, 96, 15, 24, 114, 93, 21, 88, 8, 89, 77}, "7f5445"), C0000.decode(new byte[]{65, 93, 7, 13, 105, 13, 88, 14, 29}, "64ad6b6bd07a8d9e", true), true);
        addSection(linearLayout, isRu() ? C0000.decode(new byte[]{-30, -95, -32, -46, -25, -124, -30, -39, -32, -24, -31, -126}, "250b792d1c1764") : C0000.decode(new byte[]{124, 0, 65, 81}, "8a50d7188bf1fede", 0.0f));
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-26, -49, -78, -39, -75, -115, -25, -34, -32, -118, -27, -34, -25, -36, -25, -19, 66, -78, -25, -30, -73, -77, ByteCompanionObject.MIN_VALUE, -27, -79, -78, -113, -76, -116, -78, -46}, "6bbce37c045b7d", 0.0f) : C0000.decode(new byte[]{114, 0, 17, 2, 66, 64, 87, 23, 0, 17}, "6aecb3"), C0000.decode(new byte[]{92, 2, 64, 3, 60, 64, 89, 21, 81, 16}, "8c4bc3", false), false);
        addToggle(linearLayout, isRu() ? C0000.decode(new byte[]{-77, -8, -79, -116, -26, -79, -79, -119, -29, -75, -27, -118, -77, -48, -79, -119, -25, -124, -79, -119, -30, ByteCompanionObject.MIN_VALUE, 21, -28, -41, -78, -47, -23, -118, -23, -36, -32, -71, -28, -80}, "cba979a12554", 0.0f) : C0000.decode(new byte[]{118, 3, 5, 13, 93, 16, 5, 83, 17, 7}, "5bfe80a2ef8f", 3), C0000.decode(new byte[]{83, 4, 90, 12, 83, 111, 0, 8, 81, 90, 13, 83, 84}, "0e9d60ef08a6"), true);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }

    /* JADX INFO: renamed from: lambda$addToggle$0$com-template-shellapp-SettingsActivity, reason: not valid java name */
    /* synthetic */ void m21lambda$addToggle$0$comtemplateshellappSettingsActivity(String str, CompoundButton compoundButton, boolean z) {
        this.prefs.edit().putBoolean(str, z).apply();
    }
}
