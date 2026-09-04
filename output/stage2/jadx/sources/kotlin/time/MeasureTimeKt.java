package kotlin.time;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001a3\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MeasureTimeKt {
    public static final long measureTime(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{3, 14, 90, 82, 93}, "ab51643e0a", false));
        long jM1486markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1486markNowz9LOYto();
        function0.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m1491elapsedNowUwyO8pc(jM1486markNowz9LOYto);
    }

    public static final long measureTime(TimeSource.Monotonic monotonic, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(monotonic, C0000.decode(new byte[]{90, 76, 14, 8, 18, 14}, "f8faa0", false));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{80, 84, 95, 80, 13}, "2803f4137731", 6));
        long jM1486markNowz9LOYto = monotonic.m1486markNowz9LOYto();
        function0.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m1491elapsedNowUwyO8pc(jM1486markNowz9LOYto);
    }

    public static final long measureTime(TimeSource timeSource, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeSource, C0000.decode(new byte[]{13, 64, 90, 12, 23, 91}, "142ede043a297b", true));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{4, 88, 90, 87, 82}, "f4549b4de964"));
        TimeMark timeMarkMarkNow = timeSource.markNow();
        function0.invoke();
        return timeMarkMarkNow.mo1361elapsedNowUwyO8pc();
    }

    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{91, 93, 10, 1, 13}, "91ebfbf3"));
        return new TimedValue<>(function0.invoke(), TimeSource.Monotonic.ValueTimeMark.m1491elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1486markNowz9LOYto()), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource.Monotonic monotonic, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(monotonic, C0000.decode(new byte[]{15, 71, 91, 94, 66, 6}, "333718765c99f703", 7));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{90, 8, 91, 86, 91}, "8d45055e00f809", 0.0f));
        return new TimedValue<>(function0.invoke(), TimeSource.Monotonic.ValueTimeMark.m1491elapsedNowUwyO8pc(monotonic.m1486markNowz9LOYto()), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource timeSource, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(timeSource, C0000.decode(new byte[]{10, 21, 10, 81, 16, 95}, "6ab8cadebb"));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{7, 91, 92, 82, 82}, "e73198", true));
        return new TimedValue<>(function0.invoke(), timeSource.markNow().mo1361elapsedNowUwyO8pc(), null);
    }
}
