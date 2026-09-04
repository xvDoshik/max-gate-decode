package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.List;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Metadata {
    public String appVersionCode;
    public String appVersionName;
    public final Context context;
    public int gmsVersionCode;
    public int iidImplementation = 0;

    public Metadata(Context context) {
        this.context = context;
    }

    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
        firebaseApp.checkNotDeleted();
        FirebaseOptions firebaseOptions = firebaseApp.options;
        String str = firebaseOptions.gcmSenderId;
        if (str != null) {
            return str;
        }
        firebaseApp.checkNotDeleted();
        String str2 = firebaseOptions.applicationId;
        if (!str2.startsWith(C0000.decode(new byte[]{5, 94}, "4d1be4fca8c65ac6"))) {
            return str2;
        }
        String[] strArrSplit = str2.split(C0000.decode(new byte[]{14}, "430d2250755adbb1", false));
        if (strArrSplit.length < 2) {
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public final synchronized String getAppVersionCode() {
        try {
            if (this.appVersionCode == null) {
                populateAppVersionInfo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.appVersionCode;
    }

    public final boolean isGmscorePresent() {
        int i;
        synchronized (this) {
            i = this.iidImplementation;
            if (i == 0) {
                PackageManager packageManager = this.context.getPackageManager();
                if (packageManager.checkPermission(C0000.decode(new byte[]{82, 14, 85, 23, 84, 13, 9, 83, 89, 93, 76, 81, 95, 6, 69, 12, 88, 5, 22, 90, 1, 6, 11, 26, 69, 93, 16, 93, 88, 17, 68, 10, 94, 15, 22, 106, 118, 44, 34}, "1a893bf458b01b7c", 3), C0000.decode(new byte[]{90, 14, 15, 28, 4, 9, 88, 85, 8, 86, 23, 0, 12, 86, 17, 9, 94, 86, 74, 84, 84, 18}, "9ab2cf72d3", true)) == -1) {
                    i = 0;
                } else {
                    Intent intent = new Intent(C0000.decode(new byte[]{85, 11, 94, 25, 94, 88, 13, 4, 90, 4, 24, 81, 95, 86, 75, 48, 121, 47, 118, 121, 102, 101, 39, 50, 99, 36, 101, 108}, "6d3797bc6a6862ed"));
                    intent.setPackage(C0000.decode(new byte[]{87, 87, 89, 27, 95, 9, 12, 87, 88, 93, 26, 84, 86, 2, 17, 95, 93, 92, 26, 82, 85, 21}, "48458fc0", 4));
                    List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
                    if (listQueryBroadcastReceivers == null || listQueryBroadcastReceivers.size() <= 0) {
                        this.iidImplementation = 2;
                    } else {
                        this.iidImplementation = 2;
                    }
                    i = 2;
                }
            }
        }
        return i != 0;
    }

    public final synchronized void populateAppVersionInfo() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.toString();
            packageInfo = null;
        }
        if (packageInfo != null) {
            this.appVersionCode = Integer.toString(packageInfo.versionCode);
            this.appVersionName = packageInfo.versionName;
        }
    }
}
