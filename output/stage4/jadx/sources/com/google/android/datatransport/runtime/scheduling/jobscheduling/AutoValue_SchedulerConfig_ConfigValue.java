package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_SchedulerConfig_ConfigValue {
    public final long delta;
    public final Set flags;
    public final long maxAllowedDelay;

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_SchedulerConfig_ConfigValue) {
            AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) obj;
            if (this.delta == autoValue_SchedulerConfig_ConfigValue.delta && this.maxAllowedDelay == autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay && this.flags.equals(autoValue_SchedulerConfig_ConfigValue.flags)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.delta;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.maxAllowedDelay;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.flags.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{117, 9, 94, 2, 95, 87, 98, 81, 89, 20, 7, 79, 84, 92, 90, 18, 81, 89}, "6f0d60405ab409", false));
        sb.append(this.delta);
        sb.append(C0000.decode(new byte[]{21, 24, 89, 82, 75, 114, 93, 90, 94, 20, 92, 92, 112, 86, 95, 82, 72, 11}, "984333161c", 1));
        sb.append(this.maxAllowedDelay);
        sb.append(C0000.decode(new byte[]{28, 68, 87, 9, 0, 1, 22, 12}, "0d1eafe1db89c8bf", false));
        sb.append(this.flags);
        sb.append(C0000.decode(new byte[]{78}, "303579", 0.0f));
        return sb.toString();
    }
}
