package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0001\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0001\u001a \u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0001¨\u0006\u000b"}, d2 = {"toTimeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDurationUnit", "convertDurationUnit", "", "value", "sourceUnit", "targetUnit", "convertDurationUnitOverflow", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt {

    /* JADX INFO: compiled from: DurationUnitJvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final double convertDurationUnit(double d, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{18, 10, 77, 70, 6, 87, 55, 92, 91, 18}, "ae84e2b22f74"));
        Intrinsics.checkNotNullParameter(durationUnit2, C0000.decode(new byte[]{76, 4, 70, 80, 3, 67, 97, 10, 88, 71}, "8e47f74d1385", true));
        long jConvert = durationUnit2.getTimeUnit().convert(1L, durationUnit.getTimeUnit());
        return jConvert > 0 ? d * jConvert : d / durationUnit.getTimeUnit().convert(1L, durationUnit2.getTimeUnit());
    }

    public static final long convertDurationUnit(long j, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{22, 94, 19, 67, 1, 85, 100, 88, 94, 77}, "e1f1b016793a", false));
        Intrinsics.checkNotNullParameter(durationUnit2, C0000.decode(new byte[]{65, 83, 70, 80, 80, 21, 96, 92, 93, 67}, "52475a"));
        return durationUnit2.getTimeUnit().convert(j, durationUnit.getTimeUnit());
    }

    public static final long convertDurationUnitOverflow(long j, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{22, 13, 16, 64, 7, 6, 108, 88, 89, 76}, "ebe2dc960812f6"));
        Intrinsics.checkNotNullParameter(durationUnit2, C0000.decode(new byte[]{68, 88, 66, 82, 6, 70, 54, 86, 93, 16}, "0905c2c84d", false));
        return durationUnit2.getTimeUnit().convert(j, durationUnit.getTimeUnit());
    }

    public static final DurationUnit toDurationUnit(TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, C0000.decode(new byte[]{9, 22, 9, 88, 68, 90}, "5ba17da8ac8409"));
        switch (WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TimeUnit toTimeUnit(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, C0000.decode(new byte[]{13, 23, 12, 8, 66, 91}, "1cda1e9aaf", 1));
        return durationUnit.getTimeUnit();
    }
}
