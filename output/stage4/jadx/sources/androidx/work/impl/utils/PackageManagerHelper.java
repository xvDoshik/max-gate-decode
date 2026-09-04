package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.SystemClock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class PackageManagerHelper {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{96, 85, 90, 95, 0, 87, 85, 121, 88, 90, 0, 87, 85, 70, 113, 81, 13, 64, 85, 70}, "0494a0"));
    }

    public static void setComponentEnabled(Context context, Class cls, boolean z) {
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z2 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z2 = true;
            }
            if (z == z2) {
                SystemClock.get().getClass();
            } else {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
                SystemClock.get().getClass();
            }
        } catch (Exception unused) {
            SystemClock.get().getClass();
        }
    }
}
