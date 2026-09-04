package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.SystemClock;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BatteryNotLowTracker extends ConstraintTracker {
    public final /* synthetic */ int $r8$classId;
    public final BroadcastReceiverConstraintTracker$broadcastReceiver$1 broadcastReceiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1] */
    public BatteryNotLowTracker(Context context, Dispatcher dispatcher, int i) {
        super(context, dispatcher);
        this.$r8$classId = i;
        this.broadcastReceiver = new BroadcastReceiver() { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                BatteryNotLowTracker batteryNotLowTracker = this.this$0;
                switch (batteryNotLowTracker.$r8$classId) {
                    case 0:
                        if (intent.getAction() != null) {
                            SystemClock systemClock = SystemClock.get();
                            int i2 = BatteryNotLowTrackerKt.$r8$clinit;
                            intent.getAction();
                            systemClock.getClass();
                            String action = intent.getAction();
                            if (action != null) {
                                int iHashCode = action.hashCode();
                                if (iHashCode != -1980154005) {
                                    if (iHashCode == 490310653 && action.equals(C0000.decode(new byte[]{88, 94, 87, 68, 14, 95, 92, 77, 80, 94, 71, 83, 15, 66, 22, 2, 90, 68, 90, 89, 15, 24, 122, 34, 109, 100, 118, 100, 56, 105, 116, 44, 110}, "9036a68c", 0.0f))) {
                                        batteryNotLowTracker.setState(Boolean.FALSE);
                                    }
                                    break;
                                } else if (action.equals(C0000.decode(new byte[]{88, 92, 93, 75, 92, 10, 0, 74, 91, 88, 64, 92, 89, 65, 25, 87, 90, 70, 80, 86, 93, 77, 38, 37, 102, 98, 113, 107, 110, 106, 120, 125, 120, 107}, "92993cdd26497576", 2))) {
                                    batteryNotLowTracker.setState(Boolean.TRUE);
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        String action2 = intent.getAction();
                        if (action2 != null) {
                            SystemClock systemClock2 = SystemClock.get();
                            int i3 = BatteryChargingTrackerKt.$r8$clinit;
                            systemClock2.getClass();
                            switch (action2.hashCode()) {
                                case -1886648615:
                                    if (action2.equals(C0000.decode(new byte[]{84, 12, 0, 68, 92, 94, 0, 28, 88, 15, 65, 6, 10, 68, 27, 3, 7, 66, 90, 88, 10, 28, 112, 34, 97, 42, 43, 126, 106, 50, 43, 97, 118, 101, 59, 118, 120, 50, 118, 44, 42, 126, 112, 33, 48, 115, 119}, "5bd637d21a5cd0", 0))) {
                                        batteryNotLowTracker.setState(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case -54942926:
                                    if (action2.equals(C0000.decode(new byte[]{87, 11, 7, 20, 88, 8, 81, 29, 94, 17, 25, 87, 6, 67, 95, 10, 13, 72, 115, 40, 102, 112, 121, 35, 101, 113, 44, 121, 113}, "6ecf7a531b76e7", false))) {
                                        batteryNotLowTracker.setState(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case 948344062:
                                    if (action2.equals(C0000.decode(new byte[]{5, 87, 6, 71, 93, 11, 0, 23, 13, 70, 28, 3, 7, 77, 11, 90, 92, 76, 39, 113, 35, 103, 117, 43, 42, 126}, "d9b52b", 3))) {
                                        batteryNotLowTracker.setState(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                                case 1019184907:
                                    if (action2.equals(C0000.decode(new byte[]{4, 13, 93, 65, 13, 15, 5, 25, 11, 86, 69, 87, 86, 23, 75, 2, 90, 71, 11, 9, 15, 25, 35, 123, 101, 123, 119, 45, 58, 51, 118, 100, 39, 52, 62, 116, 45, 118, 127, 119, 123, 55, 32, 39}, "ec93bfa7b8128c", 0.0f))) {
                                        batteryNotLowTracker.setState(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                    default:
                        if (intent.getAction() != null) {
                            SystemClock systemClock3 = SystemClock.get();
                            int i4 = StorageNotLowTrackerKt.$r8$clinit;
                            intent.getAction();
                            systemClock3.getClass();
                            String action3 = intent.getAction();
                            if (action3 != null) {
                                int iHashCode2 = action3.hashCode();
                                if (iHashCode2 != -1181163412) {
                                    if (iHashCode2 == -730838620 && action3.equals(C0000.decode(new byte[]{88, 86, 82, 20, 94, 11, 93, 27, 80, 86, 66, 3, 95, 22, 23, 84, 90, 76, 95, 9, 95, 76, 125, 112, 111, 113, 117, 35, 110, 49, 109, 122, 107, 121, 113, 35, 110, 45, 114}, "986f1b95", 6))) {
                                        batteryNotLowTracker.setState(Boolean.TRUE);
                                    }
                                    break;
                                } else if (action3.equals(C0000.decode(new byte[]{3, 12, 83, 68, 87, 10, 83, 27, 93, 15, 66, 80, 8, 76, 74, 84, 1, 22, 94, 89, 86, 77, 115, 112, 98, 40, 117, 112, 57, 107, 48, 122, 48, 35, 112, 115, 103, 47, 120, 98}, "bb768c754a65f8d5"))) {
                                    batteryNotLowTracker.setState(Boolean.FALSE);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        };
    }

    public final IntentFilter getIntentFilter() {
        switch (this.$r8$classId) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(C0000.decode(new byte[]{85, 91, 93, 69, 86, 11, 86, 79, 11, 91, 18, 7, 90, 65, 23, 86, 90, 22, 91, 14, 12, 27, 36, 35, 96, 97, 124, 101, 96, 61, 125, 42, 35, 108}, "45979b2ab5fb", true));
                intentFilter.addAction(C0000.decode(new byte[]{2, 10, 82, 67, 10, 80, 0, 25, 92, 86, 23, 1, 88, 69, 75, 88, 7, 67, 92, 87, 13, 74, 116, 112, 49, 109, 33, 101, 108, 103, 47, 43, 97}, "cd61e9d758", 1));
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction(C0000.decode(new byte[]{84, 86, 87, 66, 88, 88, 81, 25, 12, 66, 25, 81, 6, 69, 92, 87, 93, 30, 116, 121, 116, 101, 36, 120, 121, 119}, "58307157c170e1", true));
                intentFilter2.addAction(C0000.decode(new byte[]{87, 11, 80, 71, 94, 10, 6, 26, 12, 68, 24, 4, 87, 65, 88, 12, 12, 26, 39, 126, 101, 38, 124, 116, 99, 36, 43, 122, 36}, "6e451cb4c7", 6));
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction(C0000.decode(new byte[]{4, 13, 92, 20, 87, 12, 84, 27, 80, 86, 67, 83, 8, 22, 75, 2, 91, 18, 81, 10, 94, 27, 125, 125, 97, 127, 37, 39, 58, 48, 108, 41, 106, 36, 119, 112, 102, 119, 124}, "ec8f8e059876fb", 0.0f));
                intentFilter3.addAction(C0000.decode(new byte[]{81, 92, 5, 20, 90, 11, 2, 23, 8, 88, 65, 87, 94, 70, 79, 7, 86, 22, 15, 86, 15, 24, 113, 119, 102, 123, 34, 35, 106, 49, 50, 118, 51, 119, 114, 119, 111, 126, 46, 49}, "02af5bf9a652", 0.0f));
                return intentFilter3;
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object readSystemState() {
        int i = this.$r8$classId;
        String strDecode = C0000.decode(new byte[]{65, 64, 87, 67, 68, 71}, "246714f639e0031b", 7);
        String strDecode2 = C0000.decode(new byte[]{83, 92, 86, 17, 89, 90, 86, 28, 91, 13, 66, 86, 92, 70, 28, 2, 85, 71, 91, 93, 92, 77, 116, 114, 102, 102, 119, 49, 111, 108, 113, 122, 115, 45, 113, 118, 118}, "222c63", 0.0f);
        Context context = this.appContext;
        boolean z = true;
        switch (i) {
            case 0:
                Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter(strDecode2));
                if (intentRegisterReceiver == null) {
                    SystemClock systemClock = SystemClock.get();
                    int i2 = BatteryNotLowTrackerKt.$r8$clinit;
                    systemClock.getClass();
                    return Boolean.FALSE;
                }
                int intExtra = intentRegisterReceiver.getIntExtra(strDecode, -1);
                float intExtra2 = intentRegisterReceiver.getIntExtra(C0000.decode(new byte[]{95, 6, 71, 84, 85}, "3c119a0d1ee7ba62", 6), -1) / intentRegisterReceiver.getIntExtra(C0000.decode(new byte[]{70, 2, 0, 90, 81}, "5aa649c98d3d4fad", 0.0f), -1);
                if (intExtra != 1 && intExtra2 <= 0.15f) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                Intent intentRegisterReceiver2 = context.registerReceiver(null, new IntentFilter(strDecode2));
                if (intentRegisterReceiver2 == null) {
                    SystemClock systemClock2 = SystemClock.get();
                    int i3 = BatteryChargingTrackerKt.$r8$clinit;
                    systemClock2.getClass();
                    return Boolean.FALSE;
                }
                int intExtra3 = intentRegisterReceiver2.getIntExtra(strDecode, -1);
                if (intExtra3 != 2 && intExtra3 != 5) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                Intent intentRegisterReceiver3 = context.registerReceiver(null, getIntentFilter());
                if (intentRegisterReceiver3 != null && intentRegisterReceiver3.getAction() != null) {
                    String action = intentRegisterReceiver3.getAction();
                    if (action == null) {
                        z = false;
                    } else {
                        int iHashCode = action.hashCode();
                        if (iHashCode == -1181163412) {
                            action.equals(C0000.decode(new byte[]{4, 95, 5, 71, 89, 92, 86, 25, 95, 11, 17, 83, 91, 77, 75, 80, 2, 65, 95, 90, 92, 25, 114, 32, 51, 127, 118, 124, 58, 98, 53, 122, 100, 116, 117, 114, 105, 41, 42, 97}, "e1a565276ee659"));
                        } else if (iHashCode != -730838620 || !action.equals(C0000.decode(new byte[]{3, 94, 81, 68, 89, 80, 6, 30, 92, 88, 66, 92, 12, 68, 27, 87, 85, 77, 11, 95, 91, 24, 114, 124, 52, 121, 118, 115, 105, 106, 54, 127, 103, 119, 113, 124, 61, 127, 126}, "b05669", 0.0f))) {
                        }
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void startTracking() {
        SystemClock systemClock = SystemClock.get();
        int i = BroadcastReceiverConstraintTrackerKt.$r8$clinit;
        systemClock.getClass();
        this.appContext.registerReceiver(this.broadcastReceiver, getIntentFilter());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void stopTracking() {
        SystemClock systemClock = SystemClock.get();
        int i = BroadcastReceiverConstraintTrackerKt.$r8$clinit;
        systemClock.getClass();
        this.appContext.unregisterReceiver(this.broadcastReceiver);
    }
}
