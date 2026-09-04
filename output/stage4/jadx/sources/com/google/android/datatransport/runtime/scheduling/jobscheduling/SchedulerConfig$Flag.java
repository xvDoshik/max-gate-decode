package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SchedulerConfig$Flag {
    public static final /* synthetic */ SchedulerConfig$Flag[] $VALUES;
    public static final SchedulerConfig$Flag DEVICE_CHARGING;
    public static final SchedulerConfig$Flag DEVICE_IDLE;
    public static final SchedulerConfig$Flag NETWORK_UNMETERED;

    static {
        SchedulerConfig$Flag schedulerConfig$Flag = new SchedulerConfig$Flag(C0000.decode(new byte[]{127, 119, 109, 51, 125, 52, 45, 61, 101, 45, 127, 32, 49, 113, 99, 119, 125}, "129d2ffb0c2ee4", 0.0f), 0);
        NETWORK_UNMETERED = schedulerConfig$Flag;
        SchedulerConfig$Flag schedulerConfig$Flag2 = new SchedulerConfig$Flag(C0000.decode(new byte[]{125, 114, 111, 45, 34, 115, 62, 45, 113, 124, 125}, "979da6ad508f8e", true), 1);
        DEVICE_IDLE = schedulerConfig$Flag2;
        SchedulerConfig$Flag schedulerConfig$Flag3 = new SchedulerConfig$Flag(C0000.decode(new byte[]{39, 112, 50, 120, 112, 115, 110, 37, 121, 35, 49, 114, 45, 127, 116}, "c5d1361f1b", 0.0f), 2);
        DEVICE_CHARGING = schedulerConfig$Flag3;
        $VALUES = new SchedulerConfig$Flag[]{schedulerConfig$Flag, schedulerConfig$Flag2, schedulerConfig$Flag3};
    }

    public static SchedulerConfig$Flag valueOf(String str) {
        return (SchedulerConfig$Flag) Enum.valueOf(SchedulerConfig$Flag.class, str);
    }

    public static SchedulerConfig$Flag[] values() {
        return (SchedulerConfig$Flag[]) $VALUES.clone();
    }
}
