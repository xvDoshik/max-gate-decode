package androidx.work.impl.constraints.controllers;

import androidx.work.SystemClock;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.model.WorkSpec;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NetworkNotRoamingController extends ConstraintController {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{123, 86, 76, 65, 12, 75, 91, 119, 89, 70, 48, 10, 84, 94, 81, 88, 4, 122, 68, 75, 90, 64}, "5386c90962be", 4));
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final int getReason() {
        return 7;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.requiredNetworkType == 4;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Object obj) {
        NetworkState networkState = (NetworkState) obj;
        return (networkState.isConnected && networkState.isNotRoaming) ? false : true;
    }
}
