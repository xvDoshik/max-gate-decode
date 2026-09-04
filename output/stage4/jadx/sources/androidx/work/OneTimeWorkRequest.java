package androidx.work;

import androidx.work.impl.model.WorkSpec;
import com.base.template.workers.PingWorker;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    public final class Builder extends WorkRequest.Builder {
        public final /* synthetic */ int $r8$classId = 1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder() {
            super(PingWorker.class);
            TimeUnit timeUnit = TimeUnit.MINUTES;
            WorkSpec workSpec = (WorkSpec) this.workSpec;
            long millis = timeUnit.toMillis(15L);
            long millis2 = timeUnit.toMillis(5L);
            workSpec.getClass();
            if (millis < 900000) {
                SystemClock.get().getClass();
            }
            workSpec.intervalDuration = millis < 900000 ? 900000L : millis;
            if (millis2 < 300000) {
                SystemClock.get().getClass();
            }
            if (millis2 > workSpec.intervalDuration) {
                SystemClock.get().getClass();
            }
            long j = workSpec.intervalDuration;
            if (300000 > j) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{37, 85, 92, 89, 11, 70, 20, 86, 9, 81, 64, 84, 1, 18, 66, 84, 10, 65, 87, 23, 16, 93, 20, 84, 8, 20, 87, 90, 20, 70, 77, 21, 20, 85, 92, 80, 1, 8, 20, 88, 7, 76, 91, 90, 17, 95, 20}, "f427d245") + j + C0000.decode(new byte[]{65, 93, 75, 68, 84, 80, 66, 70, 20, 68, 11, 85, 92, 68, 14, 80, 15, 93, 85, 17, 85, 21, 2, 5, 4, 0, 83, 4, 28}, "a48d851540c42dc9", 0.0f));
            }
            if (millis2 < 300000) {
                millis2 = 300000;
            } else if (millis2 > j) {
                millis2 = j;
            }
            workSpec.flexDuration = millis2;
        }

        public /* synthetic */ Builder(Class cls) {
            super(cls);
        }

        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest buildInternal$work_runtime_release() {
            switch (this.$r8$classId) {
                case 0:
                    return new OneTimeWorkRequest((UUID) this.id, (WorkSpec) this.workSpec, (LinkedHashSet) this.tags);
                default:
                    WorkSpec workSpec = (WorkSpec) this.workSpec;
                    if (workSpec.expedited) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{54, 6, 69, 88, 12, 81, 88, 2, 51, 13, 20, 8, 101, 84, 18, 64, 84, 18, 16, 17, 70, 0, 86, 95, 13, 90, 69, 65, 6, 7, 70, 6, 79, 65, 6, 81, 88, 21, 1, 6}, "fc71c51adb", 2));
                    }
                    return new PeriodicWorkRequest((UUID) this.id, workSpec, (LinkedHashSet) this.tags);
            }
        }
    }
}
