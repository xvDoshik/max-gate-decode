package androidx.lifecycle;

import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Lifecycle$Event {
    private static final /* synthetic */ Lifecycle$Event[] $VALUES;
    public static final Companion Companion;
    public static final Lifecycle$Event ON_ANY;
    public static final Lifecycle$Event ON_CREATE;
    public static final Lifecycle$Event ON_DESTROY;
    public static final Lifecycle$Event ON_PAUSE;
    public static final Lifecycle$Event ON_RESUME;
    public static final Lifecycle$Event ON_START;
    public static final Lifecycle$Event ON_STOP;

    public final class Companion {
    }

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle$Event.values().length];
            try {
                iArr[Lifecycle$Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle$Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle$Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle$Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle$Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle$Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle$Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Lifecycle$Event lifecycle$Event = new Lifecycle$Event(C0000.decode(new byte[]{119, 118, 103, 113, 98, 32, 32, 55, 35}, "88820eacf3119840", true), 0);
        ON_CREATE = lifecycle$Event;
        Lifecycle$Event lifecycle$Event2 = new Lifecycle$Event(C0000.decode(new byte[]{122, 120, 103, 50, 54, 112, 96, 103}, "568ab123e795"), 1);
        ON_START = lifecycle$Event2;
        Lifecycle$Event lifecycle$Event3 = new Lifecycle$Event(C0000.decode(new byte[]{127, 47, 104, 55, 117, 103, 99, 117, 116}, "0a7e0468181f669f", 0.0f), 2);
        ON_RESUME = lifecycle$Event3;
        Lifecycle$Event lifecycle$Event4 = new Lifecycle$Event(C0000.decode(new byte[]{126, 119, 61, 99, 120, 96, 106, 124}, "19b39599", true), 3);
        ON_PAUSE = lifecycle$Event4;
        Lifecycle$Event lifecycle$Event5 = new Lifecycle$Event(C0000.decode(new byte[]{124, 44, 60, 102, 98, 120, 49}, "3bc567ac20ba", true), 4);
        ON_STOP = lifecycle$Event5;
        Lifecycle$Event lifecycle$Event6 = new Lifecycle$Event(C0000.decode(new byte[]{122, 43, 60, 39, 118, 50, 108, 99, 122, 60}, "5ecc3a81", false), 5);
        ON_DESTROY = lifecycle$Event6;
        Lifecycle$Event lifecycle$Event7 = new Lifecycle$Event(C0000.decode(new byte[]{127, 44, 58, 119, 43, 111}, "0be6e6", true), 6);
        ON_ANY = lifecycle$Event7;
        $VALUES = new Lifecycle$Event[]{lifecycle$Event, lifecycle$Event2, lifecycle$Event3, lifecycle$Event4, lifecycle$Event5, lifecycle$Event6, lifecycle$Event7};
        Companion = new Companion();
    }

    public static Lifecycle$Event valueOf(String str) {
        return (Lifecycle$Event) Enum.valueOf(Lifecycle$Event.class, str);
    }

    public static Lifecycle$Event[] values() {
        return (Lifecycle$Event[]) $VALUES.clone();
    }

    public final Lifecycle$State getTargetState() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return Lifecycle$State.CREATED;
            case 3:
            case 4:
                return Lifecycle$State.STARTED;
            case 5:
                return Lifecycle$State.RESUMED;
            case 6:
                return Lifecycle$State.DESTROYED;
            default:
                throw new IllegalArgumentException(this + C0000.decode(new byte[]{21, 94, 84, 65, 69, 12, 9, 21, 76, 80, 65, 4, 80, 66, 21, 65, 17, 3, 18, 80}, "5652ebf5813c", 6));
        }
    }
}
