package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import java.io.File;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (C0000.decode(new byte[]{86, 95, 81, 22, 88, 88, 80, 65, 25, 65, 71, 11, 81, 88, 88, 92, 94, 95, 70, 16, 86, 93, 88, 92, 69, 31, 84, 7, 67, 88, 91, 87, 25, 120, 123, 55, 99, 112, 120, 117, 104, 97, 103, 43, 113, 120, 120, 124}, "715d7149").equals(action)) {
            Encoding.writeProfile(context, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ConnectionPool(4, this), true);
            return;
        }
        if (C0000.decode(new byte[]{81, 15, 1, 69, 13, 94, 5, 29, 30, 17, 23, 88, 4, 94, 13, 0, 89, 15, 22, 67, 3, 91, 13, 0, 66, 79, 4, 84, 22, 94, 14, 11, 30, 50, 46, 126, 50, 104, 39, 44, 124, 36}, "0ae7b7ae").equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString(C0000.decode(new byte[]{32, 110, 96, 48, 119, 102, 101, 120, 112, 98, 58, 112, 125, 46, 115, 102, 121, 99, 124, 96, 36, 98, 125, 45, 120}, "e64b696392"));
                if (C0000.decode(new byte[]{49, 99, 40, 48, 119, 57, 107, 121, 47, 97, 62, 34, 123, 42, 125}, "f1ad2f82", 0.0f).equals(string)) {
                    try {
                        Encoding.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                        setResultCode(10);
                        return;
                    } catch (PackageManager.NameNotFoundException unused) {
                        setResultCode(7);
                        return;
                    }
                }
                if (C0000.decode(new byte[]{34, 116, 126, 119, 101, 116, 62, 49, 114, 123, 99, 60, 118, 127, 42, 116}, "f12211ab923c06", 0.0f).equals(string)) {
                    new File(context.getFilesDir(), C0000.decode(new byte[]{67, 19, 88, 7, 91, 95, 82, 13, 87, 17, 76, 86, 89, 15, 84, 17, 108, 17, 69, 14, 84, 90, 91, 1, 110, 16, 81, 67, 65, 6, 95, 37, 92, 19, 104, 13, 83, 64, 67, 49, 73, 6, 89, 67, 80, 55, 88, 14, 86, 79, 83, 0, 70}, "3a7a237d9b875c1c", false)).delete();
                    setResultCode(11);
                    return;
                }
                return;
            }
            return;
        }
        if (C0000.decode(new byte[]{7, 93, 5, 16, 95, 80, 80, 74, 72, 67, 19, 13, 86, 80, 88, 87, 15, 93, 18, 22, 81, 85, 88, 87, 20, 29, 0, 1, 68, 80, 91, 92, 72, 96, 32, 52, 117, 102, 100, 96, 41, 117, 40, 46, 117}, "f3ab0942", 3).equals(action)) {
            Process.sendSignal(Process.myPid(), 10);
            setResultCode(12);
        } else {
            if (!C0000.decode(new byte[]{7, 90, 87, 16, 95, 10, 2, 26, 72, 68, 65, 13, 86, 10, 10, 7, 15, 90, 64, 22, 81, 15, 10, 7, 20, 26, 82, 1, 68, 10, 9, 12, 72, 118, 118, 44, 115, 43, 43, 35, 52, 127, 108, 45, 96, 38, 52, 35, 50, 125, 124, 44}, "f43b0cfb", 0.0f).equals(action) || (extras = intent.getExtras()) == null) {
                return;
            }
            if (!C0000.decode(new byte[]{39, 52, 44, 100, 105, 100, 122, 39, 124, 113, 97, 109, 32, 39, 32, 124, 115}, "cfc4672f8432", 5).equals(extras.getString(C0000.decode(new byte[]{112, 109, 103, 99, 113, 102, 123, 124, 123, 118, 123, 124, 113, 107, 114, 102, 122, 101, 118, 99, 113, 109, 112, 118, 123}, "55310999", false)))) {
                setResultCode(16);
            } else if (Encoding.deleteFilesRecursively(context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
                setResultCode(14);
            } else {
                setResultCode(15);
            }
        }
    }
}
