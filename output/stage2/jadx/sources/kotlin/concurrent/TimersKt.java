package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001aO\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aM\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aO\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aM\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a'\u0010\u0015\u001a\u00020\u00012\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"schedule", "Ljava/util/TimerTask;", "Ljava/util/Timer;", "delay", "", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "time", "Ljava/util/Date;", "period", "scheduleAtFixedRate", "timer", "name", "", "daemon", "", "initialDelay", "startAt", "fixedRateTimer", "timerTask", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TimersKt {
    private static final Timer fixedRateTimer(String str, boolean z, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{83, 87, 65, 92, 87, 11}, "24558e81905189", 7));
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new AnonymousClass1(function1), j, j2);
        return timer;
    }

    private static final Timer fixedRateTimer(String str, boolean z, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{66, 66, 89, 19, 67, 121, 67}, "168a78756270", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{7, 86, 16, 80, 91, 13}, "f5d94cb79f89b78c", 7));
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new AnonymousClass1(function1), date, j);
        return timer;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, long j, long j2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{87, 7, 69, 12, 91, 89}, "6d1e470e3c86f750"));
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new AnonymousClass1(function1), j, j2);
        return timer;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, Date date, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{18, 16, 85, 23, 76, 121, 67}, "ad4e887bee20", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{88, 90, 70, 93, 9, 11}, "9924fef944", false));
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new AnonymousClass1(function1), date, j);
        return timer;
    }

    private static final TimerTask schedule(Timer timer, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(timer, C0000.decode(new byte[]{89, 71, 90, 15, 18, 93}, "e32fac5eb0", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{80, 82, 66, 89, 13, 15}, "1160ba18", 0.0f));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function1);
        timer.schedule(anonymousClass1, j, j2);
        return anonymousClass1;
    }

    private static final TimerTask schedule(Timer timer, long j, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(timer, C0000.decode(new byte[]{4, 70, 11, 88, 22, 88}, "82c1efab163e", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 81, 22, 90, 87, 93}, "e2b3831635d90a", 1));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function1);
        timer.schedule(anonymousClass1, j);
        return anonymousClass1;
    }

    private static final TimerTask schedule(Timer timer, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(timer, C0000.decode(new byte[]{9, 76, 94, 95, 74, 11}, "586695", 6));
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{68, 90, 91, 93}, "0368b5c8b0b3ab64", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{88, 90, 17, 11, 11, 13}, "99ebdc929e", 3));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function1);
        timer.schedule(anonymousClass1, date, j);
        return anonymousClass1;
    }

    private static final TimerTask schedule(Timer timer, Date date, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(timer, C0000.decode(new byte[]{93, 22, 93, 15, 66, 13}, "ab5f132a689f54", 0.0f));
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{69, 8, 89, 85}, "1a409898e3b2d6", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{86, 91, 65, 95, 92, 15}, "78563aafd2"));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function1);
        timer.schedule(anonymousClass1, date);
        return anonymousClass1;
    }

    private static final TimerTask scheduleAtFixedRate(Timer timer, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(timer, C0000.decode(new byte[]{93, 18, 88, 11, 66, 15}, "af0b11"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{83, 81, 16, 94, 11, 11}, "22d7de220910"));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function1);
        timer.scheduleAtFixedRate(anonymousClass1, j, j2);
        return anonymousClass1;
    }

    private static final TimerTask scheduleAtFixedRate(Timer timer, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(timer, C0000.decode(new byte[]{9, 76, 14, 15, 69, 6}, "58ff68"));
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{70, 91, 84, 87}, "2292d56095b3"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{84, 5, 18, 11, 92, 8}, "5ffb3fd0d22b"));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function1);
        timer.scheduleAtFixedRate(anonymousClass1, date, j);
        return anonymousClass1;
    }

    private static final Timer timer(String str, boolean z, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{84, 84, 66, 93, 88, 95}, "57647128", false));
        Timer timer = timer(str, z);
        timer.schedule(new AnonymousClass1(function1), j, j2);
        return timer;
    }

    private static final Timer timer(String str, boolean z, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{74, 22, 5, 23, 69, 115, 71}, "9bde123ed299", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{5, 91, 76, 91, 13, 10}, "d882bd4648e131f9", 3));
        Timer timer = timer(str, z);
        timer.schedule(new AnonymousClass1(function1), date, j);
        return timer;
    }

    static /* synthetic */ Timer timer$default(String str, boolean z, long j, long j2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{85, 7, 23, 12, 95, 92}, "4dce0227a3b9"));
        Timer timer = timer(str, z);
        timer.schedule(new AnonymousClass1(function1), j, j2);
        return timer;
    }

    static /* synthetic */ Timer timer$default(String str, boolean z, Date date, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(date, C0000.decode(new byte[]{66, 17, 86, 22, 22, 120, 69}, "1e7db9", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{88, 90, 21, 91, 92, 88}, "99a236302e7d7654"));
        Timer timer = timer(str, z);
        timer.schedule(new AnonymousClass1(function1), date, j);
        return timer;
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 82, 16, 81, 91, 95}, "e1d841"));
        return new AnonymousClass1(function1);
    }

    public static final Timer timer(String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: Timer.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super TimerTask, Unit> function1) {
            this.$action = function1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$action.invoke(this);
        }
    }
}
