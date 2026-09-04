package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class GoogleApiAvailabilityLight {
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;

    static {
        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
        GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    }

    public Intent getErrorResolutionIntent(Context context, String str, int i) {
        String strDecode = C0000.decode(new byte[]{0, 87, 85, 76, 83, 13, 90, 81, 8, 80, 79, 80, 13, 85, 68, 89, 10, 92, 22, 5, 89, 17}, "c88b4b56d5a1c166", true);
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            int i2 = zzt.$r8$clinit;
            Uri uriFromParts = Uri.fromParts(C0000.decode(new byte[]{70, 88, 91, 88, 3, 95, 80}, "6983b8582b10", 1), strDecode, null);
            Intent intent = new Intent(C0000.decode(new byte[]{0, 93, 93, 67, 13, 88, 86, 72, 71, 7, 21, 71, 80, 95, 5, 66, 28, 39, 100, 50, 45, 122, 122, 112, 54, 120, 125, 40, 107, 38, 36, 103, 120, 120, 46, 98, 109, 53, 113, 54, 53, 122, 119, 118, 49}, "a391b12f4b", 0.0f));
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && Hex.isWearableWithoutPlayStore(context)) {
            int i3 = zzt.$r8$clinit;
            Intent intent2 = new Intent(C0000.decode(new byte[]{91, 94, 12, 72, 3, 88, 87, 86, 13, 3, 74, 86, 86, 85, 19, 9, 13, 83, 22, 82, 13, 9, 7, 92, 79, 94, 19, 13, 74, 95, 87, 92, 4, 72, 49, 103, 124, 112, 53, 35, 59, 118, 118, 117, 51, 41, 45, 115, 103, 102, 36, 39, 54, 104, 121, 114, 53, 47, 43, 121}, "81afd7"));
            intent2.setPackage(C0000.decode(new byte[]{91, 9, 92, 22, 83, 89, 90, 2, 95, 86, 22, 7, 95, 92, 70, 89, 92, 1, 29, 68, 93, 7, 67, 89, 86, 90, 80, 75, 82, 67, 72}, "8f18465e33", true));
            return intent2;
        }
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{4, 91, 89, 74, 85, 57}, "c8680f627b5ba963"));
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        String strDecode2 = C0000.decode(new byte[]{28}, "118cbd4056d8ee", 3);
        sb.append(strDecode2);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(strDecode2);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(strDecode2);
        if (context != null) {
            try {
                PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(context);
                sb.append(packageManagerWrapperPackageManager.zza.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        int i4 = zzt.$r8$clinit;
        Intent intent3 = new Intent(C0000.decode(new byte[]{4, 89, 83, 70, 86, 89, 82, 74, 12, 89, 67, 81, 87, 68, 24, 5, 6, 67, 94, 91, 87, 30, 96, 45, 32, 96}, "e774906d"));
        Uri.Builder builderAppendQueryParameter = Uri.parse(C0000.decode(new byte[]{89, 82, 20, 89, 0, 64, 91, 75, 27, 93, 81, 71, 7, 91, 9, 71}, "43f2e4ad49", false)).buildUpon().appendQueryParameter(C0000.decode(new byte[]{94, 81}, "752759", 0.0f), strDecode);
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter(C0000.decode(new byte[]{64, 87, 7, 85, 64, 5, 13, 2, 95, 90, 85}, "04f80dde131cda56"), string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage(C0000.decode(new byte[]{2, 14, 95, 30, 85, 87, 83, 64, 95, 88, 87, 22, 18, 86, 15, 5, 91, 94, 83}, "aa2049720138d3", true));
        intent3.addFlags(524288);
        return intent3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:53:0x0143
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    public int isGooglePlayServicesAvailable(android.content.Context r14, int r15) {
        /*
            Method dump skipped, instruction units count: 1271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleApiAvailabilityLight.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
