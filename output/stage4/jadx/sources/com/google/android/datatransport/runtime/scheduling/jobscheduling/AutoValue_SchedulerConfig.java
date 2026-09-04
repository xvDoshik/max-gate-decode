package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_SchedulerConfig {
    public final Clock clock;
    public final HashMap values;

    public AutoValue_SchedulerConfig(Clock clock, HashMap map) {
        this.clock = clock;
        this.values = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SchedulerConfig)) {
            return false;
        }
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) obj;
        return this.clock.equals(autoValue_SchedulerConfig.clock) && this.values.equals(autoValue_SchedulerConfig.values);
    }

    public final long getScheduleDelay(Priority priority, long j, int i) {
        long time = j - this.clock.getTime();
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) this.values.get(priority);
        long j2 = autoValue_SchedulerConfig_ConfigValue.delta;
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2) * j2 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j2 > 1 ? j2 : 2L) * ((long) i2)))), time), autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay);
    }

    public final int hashCode() {
        return ((this.clock.hashCode() ^ 1000003) * 1000003) ^ this.values.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{106, 82, 12, 92, 0, 19, 88, 4, 74, 122, 91, 13, 95, 88, 3, 66, 7, 10, 91, 2, 83, 4}, "91d9df4a894c", true));
        sb.append(this.clock);
        sb.append(C0000.decode(new byte[]{77, 18, 19, 85, 93, 65, 87, 65, 12}, "a2e414221a", true));
        sb.append(this.values);
        sb.append(C0000.decode(new byte[]{76}, "10f2489b", 7));
        return sb.toString();
    }
}
