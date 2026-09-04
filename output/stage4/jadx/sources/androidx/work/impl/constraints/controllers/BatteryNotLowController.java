package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BatteryNotLowController extends ConstraintController {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BatteryNotLowController(ConstraintTracker constraintTracker, int i) {
        super(constraintTracker);
        this.$r8$classId = i;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final int getReason() {
        switch (this.$r8$classId) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 7;
            default:
                return 9;
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        switch (this.$r8$classId) {
            case 0:
                return workSpec.constraints.requiresBatteryNotLow;
            case 1:
                return workSpec.constraints.requiresCharging;
            case 2:
                return workSpec.constraints.requiredNetworkType == 2;
            case 3:
                int i = workSpec.constraints.requiredNetworkType;
                return i == 3 || (Build.VERSION.SDK_INT >= 30 && i == 6);
            default:
                return workSpec.constraints.requiresStorageNotLow;
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Object obj) {
        boolean zBooleanValue;
        switch (this.$r8$classId) {
            case 0:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 1:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 2:
                NetworkState networkState = (NetworkState) obj;
                return (networkState.isConnected && networkState.isValidated) ? false : true;
            case 3:
                NetworkState networkState2 = (NetworkState) obj;
                return !networkState2.isConnected || networkState2.isMetered;
            default:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
        }
        return !zBooleanValue;
    }
}
