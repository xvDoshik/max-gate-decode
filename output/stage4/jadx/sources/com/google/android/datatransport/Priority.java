package com.google.android.datatransport;

import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Priority {
    public static final /* synthetic */ Priority[] $VALUES;
    public static final Priority DEFAULT;
    public static final Priority HIGHEST;
    public static final Priority VERY_LOW;

    static {
        Priority priority = new Priority(C0000.decode(new byte[]{37, 35, 36, 116, 102, 41, 53}, "afb53e", 0.0f), 0);
        DEFAULT = priority;
        Priority priority2 = new Priority(C0000.decode(new byte[]{110, 124, 51, 105, 58, 127, 127, 50}, "89a0e30e16", 1), 1);
        VERY_LOW = priority2;
        Priority priority3 = new Priority(C0000.decode(new byte[]{43, 126, 34, 123, 125, 97, 49}, "c7e382ec", 0.0f), 2);
        HIGHEST = priority3;
        $VALUES = new Priority[]{priority, priority2, priority3};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }
}
