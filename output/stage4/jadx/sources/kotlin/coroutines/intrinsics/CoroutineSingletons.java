package kotlin.coroutines.intrinsics;

import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CoroutineSingletons {
    public static final /* synthetic */ CoroutineSingletons[] $VALUES;
    public static final CoroutineSingletons COROUTINE_SUSPENDED;

    static {
        CoroutineSingletons coroutineSingletons = new CoroutineSingletons(C0000.decode(new byte[]{118, 46, 103, 125, 48, 108, 121, 42, 112, 62, 102, 103, 54, 104, 117, 42, 113, 36, 113}, "5a52e80d", true), 0);
        COROUTINE_SUSPENDED = coroutineSingletons;
        $VALUES = new CoroutineSingletons[]{coroutineSingletons, new CoroutineSingletons(C0000.decode(new byte[]{103, 40, 39, 112, 119, 113, 34, 112, 116}, "2fc548f50c0522", 0.0f), 1), new CoroutineSingletons(C0000.decode(new byte[]{48, 118, 97, 102, 124, 39, 117}, "b3231b1c992ab5", 6), 2)};
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) $VALUES.clone();
    }
}
