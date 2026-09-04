package androidx.work.impl.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.SystemClock;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StartWorkRunnable implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object processor;
    public final Object runtimeExtras;
    public final Object startStopToken;

    public /* synthetic */ StartWorkRunnable(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.processor = obj;
        this.startStopToken = obj2;
        this.runtimeExtras = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.processor;
        Object obj2 = this.startStopToken;
        Object obj3 = this.runtimeExtras;
        switch (i) {
            case 0:
                ((Processor) obj).startWork((StartStopToken) obj2, (SystemClock) obj3);
                return;
            default:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) obj3;
                Context context = (Context) obj2;
                Intent intent = (Intent) obj;
                try {
                    boolean booleanExtra = intent.getBooleanExtra(C0000.decode(new byte[]{126, 116, 106, 57, 112, 115, 53, 54, 112, 99, 106, 57, 124, 125, 53, 61, 121, 126, 100, 57, 98, 96, 46, 58, 108, 110, 118, 40, 115, 112, 45, 39, 113}, "513f22ab", 1), false);
                    boolean booleanExtra2 = intent.getBooleanExtra(C0000.decode(new byte[]{126, 38, 107, 61, 39, 34, 101, 100, 114, 101, 105, 106, 118, 43, 115, 48, 34, 42, 127, 119, 104, 103, 98, 122, 109, 58, 109, 39, 43, 34, 115, 124, 114, 115}, "5c2bec107705"), false);
                    boolean booleanExtra3 = intent.getBooleanExtra(C0000.decode(new byte[]{125, 36, 61, 58, 96, 102, 44, 99, 32, 35, 39, 57, 127, 46, 55, 57, 122, 46, 51, 58, 99, 96, 44, 105, 56, 59, 39, 40, 112, 35, 47, 35, 114}, "6ade32c1adbf1acf", 0.0f), false);
                    boolean booleanExtra4 = intent.getBooleanExtra(C0000.decode(new byte[]{127, 118, 61, 57, 47, 119, 96, 100, 43, 52, 42, 109, 103, 103, 37, 50, 36, 109, 100, 97, 43, 62, 56, 109, 113, 125, 37, 36, 45, 119, 112}, "43dfa2", true), false);
                    SystemClock systemClock = SystemClock.get();
                    int i2 = ConstraintProxyUpdateReceiver.$r8$clinit;
                    systemClock.getClass();
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
        }
    }
}
