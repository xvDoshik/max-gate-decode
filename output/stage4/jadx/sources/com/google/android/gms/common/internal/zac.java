package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat$Api24Impl;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zac {
    public static final SimpleArrayMap zaa = new SimpleArrayMap();
    public static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = Wrappers.packageManager(context).zza;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zad(Context context, int i) {
        Resources resources = context.getResources();
        String strZaa = zaa(context);
        if (i == 1) {
            return resources.getString(2131427341, strZaa);
        }
        if (i == 2) {
            return Hex.isWearableWithoutPlayStore(context) ? resources.getString(2131427351) : resources.getString(2131427348, strZaa);
        }
        if (i == 3) {
            return resources.getString(2131427338, strZaa);
        }
        if (i == 5) {
            return zah(context, C0000.decode(new byte[]{80, 88, 12, 11, 92, 11, 107, 85, 92, 88, 6, 10, 86, 58, 68, 94, 82, 78, 62, 21, 86, 23, 66, 91, 80, 82, 18, 57, 90, 11, 66, 83, 95, 94, 5, 57, 82, 6, 87, 93, 70, 89, 21, 57, 71, 0, 76, 70}, "37af3e42", false), strZaa);
        }
        if (i == 7) {
            return zah(context, C0000.decode(new byte[]{87, 14, 90, 91, 89, 12, 62, 85, 91, 14, 80, 90, 83, 61, 17, 94, 85, 24, 104, 69, 83, 16, 23, 91, 87, 4, 68, 105, 88, 7, 21, 69, 91, 19, 92, 105, 83, 16, 19, 93, 70, 62, 67, 83, 78, 22}, "4a766ba2", 0.0f), strZaa);
        }
        if (i == 9) {
            return resources.getString(2131427346, strZaa);
        }
        if (i == 20) {
            return zah(context, C0000.decode(new byte[]{90, 14, 85, 95, 10, 86, 61, 94, 90, 11, 85, 93, 3, 57, 73, 13, 89, 75, 58, 75, 7, 75, 67, 13, 81, 84, 21, 57, 75, 4, 75, 70, 23, 81, 1, 77, 80, 0, 109, 65, 20, 9, 95, 8, 84, 87, 58, 76, 7, 65, 65}, "9a82e8b95d21ff", 0.0f), strZaa);
        }
        switch (i) {
            case 16:
                return zah(context, C0000.decode(new byte[]{7, 95, 90, 92, 89, 94, 103, 84, 94, 93, 1, 85, 3, 59, 71, 94, 5, 73, 104, 66, 83, 66, 78, 90, 82, 87, 21, 102, 7, 20, 94, 109, 17, 94, 86, 71, 87, 89, 84, 82, 83, 94, 3, 102, 18, 1, 79, 70}, "d071608312f9fd72", 2), strZaa);
            case 17:
                return zah(context, C0000.decode(new byte[]{82, 86, 91, 84, 87, 10, 60, 87, 89, 92, 5, 92, 84, 102, 70, 85, 89, 29, 60, 67, 83, 65, 20, 89, 82, 92, 69, 102, 75, 13, 4, 94, 105, 90, 12, 111, 87, 88, 95, 85, 93, 0, 60, 68, 83, 75, 22}, "19698dc063b0", 0.0f), strZaa);
            case 18:
                return resources.getString(2131427350, strZaa);
            default:
                return resources.getString(2131427345, strZaa);
        }
    }

    public static String zag(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(2131427342);
        }
        if (i == 2) {
            return resources.getString(2131427349);
        }
        if (i == 3) {
            return resources.getString(2131427339);
        }
        if (i == 5) {
            return zai(context, C0000.decode(new byte[]{87, 12, 94, 94, 10, 88, 102, 3, 10, 89, 1, 85, 87, 60, 68, 15, 82, 74, 58, 69, 92, 22, 19, 95, 5, 92, 65, 60, 93, 13, 69, 82, 9, 95, 93, 59, 4, 85, 5, 86, 71, 13, 64, 60, 71, 90, 17, 90, 92}, "4c33e69de6f92c", 1));
        }
        if (i == 7) {
            return zai(context, C0000.decode(new byte[]{87, 93, 14, 90, 14, 87, 108, 5, 12, 12, 80, 94, 86, 110, 70, 10, 85, 75, 60, 68, 4, 75, 69, 11, 0, 6, 68, 109, 93, 84, 66, 17, 91, 64, 8, 104, 4, 75, 65, 13, 17, 60, 67, 91, 71, 93, 83}, "42c7a93bcc72316f", 5));
        }
        if (i == 17) {
            return zai(context, C0000.decode(new byte[]{6, 95, 94, 94, 91, 88, 58, 87, 92, 92, 83, 90, 0, 111, 67, 95, 85, 79, 58, 67, 86, 65, 66, 95, 6, 85, 64, 108, 71, 95, 2, 94, 108, 90, 90, 105, 3, 81, 90, 95, 81, 82, 58, 68, 90, 71, 88, 83}, "e03346", true));
        }
        if (i != 20) {
            return null;
        }
        return zai(context, C0000.decode(new byte[]{6, 9, 94, 84, 11, 87, 105, 5, 14, 92, 2, 92, 86, 57, 71, 85, 4, 31, 108, 74, 1, 75, 64, 11, 2, 86, 22, 111, 65, 3, 68, 77, 23, 15, 80, 77, 1, 93, 105, 18, 19, 92, 3, 89, 95, 3, 104, 77, 12, 18, 95, 92}, "ef39d96ba3e03f79"));
    }

    public static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strZai = zai(context, str);
        if (strZai == null) {
            strZai = resources.getString(2131427345);
        }
        return String.format(resources.getConfiguration().locale, strZai, str2);
    }

    public static String zai(Context context, String str) {
        Resources resourcesForApplication;
        SimpleArrayMap simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            try {
                Locale locale = ConfigurationCompat$Api24Impl.getLocales(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(zab)) {
                    simpleArrayMap.clear();
                    zab = locale;
                }
                String str2 = (String) simpleArrayMap.get(str);
                if (str2 != null) {
                    return str2;
                }
                AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(C0000.decode(new byte[]{5, 9, 12, 25, 3, 94, 11, 86, 94, 0, 72, 7, 15, 83, 22, 94, 13, 85, 28, 2, 11, 21}, "ffa7d1d12e", 0.0f));
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication != null) {
                    int identifier = resourcesForApplication.getIdentifier(str, C0000.decode(new byte[]{70, 16, 66, 88, 87, 83}, "5d019491c01e8b0e", 0.0f), C0000.decode(new byte[]{2, 9, 84, 76, 81, 92, 89, 5, 13, 1, 76, 5, 91, 0, 67, 86, 8, 2, 23, 5, 91, 64}, "af9b636badbd5d19", false));
                    if (identifier == 0) {
                        String strDecode = C0000.decode(new byte[]{117, 92, 17, 67, 95, 10, 82, 22, 74, 81, 74, 9, 23, 71, 91, 80, 88, 16}, "85b06d56849fb5", false);
                        if (str.length() != 0) {
                            strDecode.concat(str);
                        }
                    } else {
                        String string = resourcesForApplication.getString(identifier);
                        if (!TextUtils.isEmpty(string)) {
                            zaa.put(str, string);
                            return string;
                        }
                        String strDecode2 = C0000.decode(new byte[]{115, 14, 17, 20, 6, 92, 65, 17, 76, 16, 65, 7, 23, 10, 70, 69, 87, 4, 95, 20}, "4ae4c11e503bde37", 4);
                        if (str.length() != 0) {
                            strDecode2.concat(str);
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
