package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, d2 = {"shortName", "", "Lkotlin/time/DurationUnit;", "durationUnitByShortName", "durationUnitByIsoChar", "isoChar", "", "isTimeComponent", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    /* JADX INFO: compiled from: DurationUnit.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DurationUnit durationUnitByIsoChar(char c, boolean z) {
        if (!z) {
            if (c == 'D') {
                return DurationUnit.DAYS;
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{112, 91, 19, 83, 84, 93, 2, 23, 9, 74, 25, 64, 11, 65, 77, 68, 22, 88, 20, 76, 92, 81, 69, 86, 77, 70, 7, 67, 15, 87, 87, 21, 44, 97, 119, 20, 8, 88, 8, 21, 77, 92, 8, 87, 24, 65, 8, 94, 18, 2, 25}, "95e284f7f8", true) + c);
        }
        if (c == 'H') {
            return DurationUnit.HOURS;
        }
        if (c == 'M') {
            return DurationUnit.MINUTES;
        }
        if (c == 'S') {
            return DurationUnit.SECONDS;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{40, 94, 21, 2, 91, 92, 82, 20, 2, 67, 71, 0, 67, 95, 13, 87, 65, 121, 48, 44, 23, 65, 95, 89, 3, 22, 64, 15, 94, 66, 88, 25}, "a0cc7564f65a76b9", 7) + c);
    }

    public static final DurationUnit durationUnitByShortName(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{64, 89, 9, 66, 21, 47, 88, 94, 87}, "31f0aa932ffb6eec", true));
        int iHashCode = str.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && str.equals(C0000.decode(new byte[]{69, 23}, "0d87a66f", 0))) {
                                    return DurationUnit.MICROSECONDS;
                                }
                            } else if (str.equals(C0000.decode(new byte[]{8, 18}, "fa61d4f337e011"))) {
                                return DurationUnit.NANOSECONDS;
                            }
                        } else if (str.equals(C0000.decode(new byte[]{12, 71}, "a4d9217046", 7))) {
                            return DurationUnit.MILLISECONDS;
                        }
                    } else if (str.equals(C0000.decode(new byte[]{70}, "5138bd7a791369", true))) {
                        return DurationUnit.SECONDS;
                    }
                } else if (str.equals(C0000.decode(new byte[]{93}, "01733fcd61", 4))) {
                    return DurationUnit.MINUTES;
                }
            } else if (str.equals(C0000.decode(new byte[]{14}, "f47de3b101"))) {
                return DurationUnit.HOURS;
            }
        } else if (str.equals(C0000.decode(new byte[]{5}, "a8ee5186c4", 0.0f))) {
            return DurationUnit.DAYS;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{54, 90, 10, 90, 93, 70, 13, 18, 2, 19, 17, 85, 21, 93, 93, 95, 67, 71, 8, 15, 23, 20, 18, 92, 93, 67, 23, 18, 8, 7, 14, 81, 91, 20}, "c4a421c2ff", 4) + str);
    }

    public static final String shortName(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{90, 66, 14, 12, 22, 93}, "f6feec", false));
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return C0000.decode(new byte[]{90, 74}, "4955eadb8eb9", 5);
            case 2:
                return C0000.decode(new byte[]{71, 69}, "266536ac3e");
            case 3:
                return C0000.decode(new byte[]{15, 65}, "b28e1e26", 0.0f);
            case 4:
                return C0000.decode(new byte[]{74}, "987803");
            case 5:
                return C0000.decode(new byte[]{85}, "8770b7f8", false);
            case 6:
                return C0000.decode(new byte[]{13}, "e54ad1bead");
            case 7:
                return C0000.decode(new byte[]{81}, "53aecb", 0.0f);
            default:
                throw new IllegalStateException((C0000.decode(new byte[]{109, 93, 90, 11, 14, 68, 95, 67, 77, 93, 88, 17, 91, 19}, "831ea31c", 0) + durationUnit).toString());
        }
    }
}
