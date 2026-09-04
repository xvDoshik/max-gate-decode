package androidx.lifecycle;

import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Lifecycle$State {
    public static final /* synthetic */ Lifecycle$State[] $VALUES;
    public static final Lifecycle$State CREATED;
    public static final Lifecycle$State DESTROYED;
    public static final Lifecycle$State INITIALIZED;
    public static final Lifecycle$State RESUMED;
    public static final Lifecycle$State STARTED;

    static {
        Lifecycle$State lifecycle$State = new Lifecycle$State(C0000.decode(new byte[]{39, 35, 103, 108, 107, 119, 96, 124, 124}, "cf48989988d14b91", 0.0f), 0);
        DESTROYED = lifecycle$State;
        Lifecycle$State lifecycle$State2 = new Lifecycle$State(C0000.decode(new byte[]{125, 121, 127, 54, 112, 118, 41, 47, 98, 36, 112}, "476b97ef8a", 0.0f), 1);
        INITIALIZED = lifecycle$State2;
        Lifecycle$State lifecycle$State3 = new Lifecycle$State(C0000.decode(new byte[]{114, 100, 124, 117, 97, 38, 125}, "16945c9d375f1e"), 2);
        CREATED = lifecycle$State3;
        Lifecycle$State lifecycle$State4 = new Lifecycle$State(C0000.decode(new byte[]{54, 97, 112, 52, 97, 112, 32}, "e51f55d82e"), 3);
        STARTED = lifecycle$State4;
        Lifecycle$State lifecycle$State5 = new Lifecycle$State(C0000.decode(new byte[]{52, 119, 48, 98, 126, 115, 115}, "f2c73673ac589c15", false), 4);
        RESUMED = lifecycle$State5;
        $VALUES = new Lifecycle$State[]{lifecycle$State, lifecycle$State2, lifecycle$State3, lifecycle$State4, lifecycle$State5};
    }

    public static Lifecycle$State valueOf(String str) {
        return (Lifecycle$State) Enum.valueOf(Lifecycle$State.class, str);
    }

    public static Lifecycle$State[] values() {
        return (Lifecycle$State[]) $VALUES.clone();
    }
}
