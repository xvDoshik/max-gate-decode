package androidx.core.content;

import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat$Api23Impl;
import androidx.core.app.AppOpsManagerCompat$Api29Impl;
import androidx.core.util.ObjectsCompat$Api19Impl;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ContextCompat$Api26Impl {
    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        int iNoteProxyOpNoThrow;
        if ((i & 4) == 0 || str != null) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1);
        }
        String str2 = context.getPackageName() + C0000.decode(new byte[]{27, 118, 60, 40, 120, 41, 124, 117, 57, 48, 124, 38, 35, 40, 96, 33, 103, 109, 43, 41, 109, 59, 112, 110, 54, 45, 107, 49, 35, 37, 105, 52, 112, 96, 40, 47, 106, 55, 124, 121, 40}, "52ef9d56fb9efa6d", 6);
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        byte b = -1;
        if (context.checkPermission(str2, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManagerCompat$Api23Impl.permissionToOp(str2);
            if (strPermissionToOp == null) {
                b = 0;
            } else if (packageName != null) {
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid || !ObjectsCompat$Api19Impl.equals(packageName2, packageName) || Build.VERSION.SDK_INT < 29) {
                    iNoteProxyOpNoThrow = AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), strPermissionToOp, packageName);
                } else {
                    AppOpsManager systemService = AppOpsManagerCompat$Api29Impl.getSystemService(context);
                    iNoteProxyOpNoThrow = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, strPermissionToOp, iMyUid, AppOpsManagerCompat$Api29Impl.getOpPackageName(context));
                    }
                }
                if (iNoteProxyOpNoThrow == 0) {
                    b = 0;
                } else {
                    b = -2;
                }
            } else {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                if (packagesForUid != null && packagesForUid.length > 0) {
                    packageName = packagesForUid[0];
                    int iMyUid3 = Process.myUid();
                    String packageName3 = context.getPackageName();
                    iNoteProxyOpNoThrow = iMyUid3 == iMyUid ? AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), strPermissionToOp, packageName) : AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), strPermissionToOp, packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        b = 0;
                    } else {
                        b = -2;
                    }
                }
            }
        }
        if (b == 0) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str2, handler);
        }
        throw new RuntimeException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{104, 7, 16, 88, 10, 67, 22, 81, 87, 12, 66}, "8bb5c0e8"), str2, C0000.decode(new byte[]{65, 11, 66, 19, 68, 93, 71, 67, 11, 70, 80, 80, 68, 83, 79, 68, 24, 13, 68, 65, 22, 89, 70, 70, 14, 93, 86, 85, 16, 88, 89, 10, 65, 22, 94, 19, 68, 93, 85, 83, 11, 66, 80, 20, 6, 67, 89, 5, 5, 1, 80, 64, 66, 75, 26, 22, 18, 88, 80, 85, 23, 84, 22, 5, 5, 6, 17, 90, 66, 24, 66, 89, 66, 77, 90, 65, 22, 17, 91, 5, 15, 11, 87, 86, 69, 76}, "ab136866b454d16d", true)));
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }
}
