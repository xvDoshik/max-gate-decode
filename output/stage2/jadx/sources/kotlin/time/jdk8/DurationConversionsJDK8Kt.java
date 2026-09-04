package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"toKotlinDuration", "Lkotlin/time/Duration;", "Ljava/time/Duration;", "(Ljava/time/Duration;)J", "toJavaDuration", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 1, 0}, pn = "kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    /* JADX INFO: renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m1509toJavaDurationLRDsOJo(long j) {
        Duration durationOfSeconds = Duration.ofSeconds(kotlin.time.Duration.m1385getInWholeSecondsimpl(j), kotlin.time.Duration.m1387getNanosecondsComponentimpl(j));
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, C0000.decode(new byte[]{71, 90, 123, 12, 8, 17, 92, 95, 81, 8, 71, 70, 21, 10, 8, 17, 95, 25, 26, 72, 29, 28}, "358cea314f"));
        return durationOfSeconds;
    }

    private static final long toKotlinDuration(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, C0000.decode(new byte[]{94, 64, 9, 88, 68, 95}, "b4a17a5897427c0d", 7));
        return kotlin.time.Duration.m1400plusLRDsOJo(DurationKt.toDuration(duration.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(duration.getNano(), DurationUnit.NANOSECONDS));
    }
}
