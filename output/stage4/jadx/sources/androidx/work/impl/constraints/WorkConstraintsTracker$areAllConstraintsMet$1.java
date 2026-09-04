package androidx.work.impl.constraints;

import androidx.work.impl.constraints.controllers.ConstraintController;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkConstraintsTracker$areAllConstraintsMet$1 extends Lambda implements Function1 {
    public static final WorkConstraintsTracker$areAllConstraintsMet$1 INSTANCE = new WorkConstraintsTracker$areAllConstraintsMet$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ConstraintController) obj).getClass().getSimpleName();
    }
}
