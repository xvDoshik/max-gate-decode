package androidx.work.impl.model;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.OverwritingInputMerger;
import androidx.work.SystemClock;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkSpec {
    public final long backoffDelayDuration;
    public final int backoffPolicy;
    public final Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    public final int generation;
    public final String id;
    public final long initialDelay;
    public final Data input;
    public final String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public final long minimumRetentionDuration;
    public long nextScheduleTimeOverride;
    public int nextScheduleTimeOverrideGeneration;
    public final int outOfQuotaPolicy;
    public final Data output;
    public final int periodCount;
    public final int runAttemptCount;
    public final long scheduleRequestedAt;
    public int state;
    public final int stopReason;
    public final String workerClassName;

    public final class IdAndState {
        public String id;
        public int state;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return Intrinsics.areEqual(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public final int hashCode() {
            return FileSectionType$EnumUnboxingLocalUtility.ordinal(this.state) + (this.id.hashCode() * 31);
        }

        public final String toString() {
            String strDecode;
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{124, 6, 36, 91, 80, 99, 65, 3, 17, 80, 28, 89, 81, 95}, "5be540", 0.0f));
            sb.append(this.id);
            sb.append(C0000.decode(new byte[]{72, 19, 68, 76, 83, 21, 93, 92}, "d3782a8add", true));
            switch (this.state) {
                case 1:
                    strDecode = C0000.decode(new byte[]{39, 123, 55, 96, 38, 100, 117, 113}, "b5f5c1056713");
                    break;
                case 2:
                    strDecode = C0000.decode(new byte[]{98, 109, 120, 118, 113, 119, 114}, "0868895d", false);
                    break;
                case 3:
                    strDecode = C0000.decode(new byte[]{50, 99, 122, 117, 113, 33, 113, 114, 37}, "a6964d57a6ccb0", 4);
                    break;
                case 4:
                    strDecode = C0000.decode(new byte[]{119, 121, 42, 40, 36, 38}, "18cdabab");
                    break;
                case 5:
                    strDecode = C0000.decode(new byte[]{32, 47, 45, 118, 121, 113, 125}, "bcb524945a", 0.0f);
                    break;
                case 6:
                    strDecode = C0000.decode(new byte[]{34, 34, 127, 122, 114, 47, 116, 116, 39}, "ac197c81c36d7a", false);
                    break;
                default:
                    strDecode = C0000.decode(new byte[]{10, 17, 15, 13}, "ddcaaab535", false);
                    break;
            }
            sb.append(strDecode);
            sb.append(')');
            return sb.toString();
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{99, 93, 20, 94, 101, 70, 83, 83}, "42f566601a48e046"));
    }

    public WorkSpec(String str, int i, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i2, int i3, long j4, long j5, long j6, long j7, boolean z, int i4, int i5, int i6, long j8, int i7, int i8) {
        this.id = str;
        this.state = i;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data;
        this.output = data2;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints;
        this.runAttemptCount = i2;
        this.backoffPolicy = i3;
        this.backoffDelayDuration = j4;
        this.lastEnqueueTime = j5;
        this.minimumRetentionDuration = j6;
        this.scheduleRequestedAt = j7;
        this.expedited = z;
        this.outOfQuotaPolicy = i4;
        this.periodCount = i5;
        this.generation = i6;
        this.nextScheduleTimeOverride = j8;
        this.nextScheduleTimeOverrideGeneration = i7;
        this.stopReason = i8;
    }

    public static WorkSpec copy$default(WorkSpec workSpec, String str, int i, String str2, Data data, int i2, long j, int i3, int i4, long j2, int i5, int i6) {
        String str3 = (i6 & 1) != 0 ? workSpec.id : str;
        int i7 = (i6 & 2) != 0 ? workSpec.state : i;
        String str4 = (i6 & 4) != 0 ? workSpec.workerClassName : str2;
        String str5 = workSpec.inputMergerClassName;
        Data data2 = (i6 & 16) != 0 ? workSpec.input : data;
        Data data3 = workSpec.output;
        long j3 = workSpec.initialDelay;
        long j4 = workSpec.intervalDuration;
        long j5 = workSpec.flexDuration;
        Constraints constraints = workSpec.constraints;
        int i8 = (i6 & 1024) != 0 ? workSpec.runAttemptCount : i2;
        int i9 = workSpec.backoffPolicy;
        long j6 = workSpec.backoffDelayDuration;
        long j7 = (i6 & 8192) != 0 ? workSpec.lastEnqueueTime : j;
        long j8 = workSpec.minimumRetentionDuration;
        long j9 = workSpec.scheduleRequestedAt;
        boolean z = workSpec.expedited;
        int i10 = workSpec.outOfQuotaPolicy;
        int i11 = (i6 & 262144) != 0 ? workSpec.periodCount : i3;
        int i12 = (i6 & 524288) != 0 ? workSpec.generation : i4;
        long j10 = (i6 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j2;
        int i13 = (i6 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i5;
        int i14 = workSpec.stopReason;
        workSpec.getClass();
        return new WorkSpec(str3, i7, str4, str5, data2, data3, j3, j4, j5, constraints, i8, i9, j6, j7, j8, j9, z, i10, i11, i12, j10, i13, i14);
    }

    public final long calculateNextRunTime() {
        int i = this.state;
        int i2 = this.runAttemptCount;
        boolean z = i == 1 && i2 > 0;
        long j = this.lastEnqueueTime;
        boolean zIsPeriodic = isPeriodic();
        long j2 = this.flexDuration;
        long j3 = this.intervalDuration;
        long j4 = this.nextScheduleTimeOverride;
        int i3 = this.periodCount;
        if (j4 != Long.MAX_VALUE && zIsPeriodic) {
            if (i3 != 0) {
                long j5 = j + 900000;
                if (j4 < j5) {
                    return j5;
                }
            }
            return j4;
        }
        if (z) {
            int i4 = this.backoffPolicy;
            long j6 = this.backoffDelayDuration;
            long jScalb = i4 == 2 ? j6 * ((long) i2) : (long) Math.scalb(j6, i2 - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j + jScalb;
        }
        long j7 = this.initialDelay;
        if (zIsPeriodic) {
            long j8 = i3 == 0 ? j + j7 : j + j3;
            return (j2 == j3 || i3 != 0) ? j8 : (j3 - j2) + j8;
        }
        if (j == -1) {
            return Long.MAX_VALUE;
        }
        return j + j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return Intrinsics.areEqual(this.id, workSpec.id) && this.state == workSpec.state && Intrinsics.areEqual(this.workerClassName, workSpec.workerClassName) && Intrinsics.areEqual(this.inputMergerClassName, workSpec.inputMergerClassName) && Intrinsics.areEqual(this.input, workSpec.input) && Intrinsics.areEqual(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && Intrinsics.areEqual(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    public final boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    public final int hashCode() {
        int iHashCode = (Long.hashCode(this.scheduleRequestedAt) + ((Long.hashCode(this.minimumRetentionDuration) + ((Long.hashCode(this.lastEnqueueTime) + ((Long.hashCode(this.backoffDelayDuration) + ((FileSectionType$EnumUnboxingLocalUtility.ordinal(this.backoffPolicy) + ((Integer.hashCode(this.runAttemptCount) + ((this.constraints.hashCode() + ((Long.hashCode(this.flexDuration) + ((Long.hashCode(this.intervalDuration) + ((Long.hashCode(this.initialDelay) + ((this.output.hashCode() + ((this.input.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.inputMergerClassName, NetworkType$EnumUnboxingLocalUtility.m(this.workerClassName, (FileSectionType$EnumUnboxingLocalUtility.ordinal(this.state) + (this.id.hashCode() * 31)) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.expedited;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        return Integer.hashCode(this.stopReason) + ((Integer.hashCode(this.nextScheduleTimeOverrideGeneration) + ((Long.hashCode(this.nextScheduleTimeOverride) + ((Integer.hashCode(this.generation) + ((Integer.hashCode(this.periodCount) + ((FileSectionType$EnumUnboxingLocalUtility.ordinal(this.outOfQuotaPolicy) + ((iHashCode + r2) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{73, 54, 10, 74, 93, 53, 20, 81, 0, 91, 18}, "2ae86fd4ca"));
        sb.append(this.id);
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ WorkSpec(String str, int i, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i2, int i3, long j4, long j5, long j6, long j7, boolean z, int i4, int i5, long j8, int i6, int i7, int i8) {
        this(str, (i8 & 2) != 0 ? 1 : i, str2, (i8 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3, (i8 & 16) != 0 ? Data.EMPTY : data, (i8 & 32) != 0 ? Data.EMPTY : data2, (i8 & 64) != 0 ? 0L : j, (i8 & 128) != 0 ? 0L : j2, (i8 & 256) != 0 ? 0L : j3, (i8 & 512) != 0 ? Constraints.NONE : constraints, (i8 & 1024) != 0 ? 0 : i2, (i8 & 2048) != 0 ? 1 : i3, (i8 & 4096) != 0 ? 30000L : j4, (i8 & 8192) != 0 ? -1L : j5, (i8 & 16384) == 0 ? j6 : 0L, (32768 & i8) != 0 ? -1L : j7, (65536 & i8) != 0 ? false : z, (131072 & i8) != 0 ? 1 : i4, (262144 & i8) != 0 ? 0 : i5, 0, (1048576 & i8) != 0 ? Long.MAX_VALUE : j8, (2097152 & i8) != 0 ? 0 : i6, (i8 & 4194304) != 0 ? -256 : i7);
    }
}
