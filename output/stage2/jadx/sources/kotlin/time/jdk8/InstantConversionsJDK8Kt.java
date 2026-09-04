package kotlin.time.jdk8;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004"}, d2 = {"toJavaInstant", "Ljava/time/Instant;", "Lkotlin/time/Instant;", "toKotlinInstant", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 1, 0}, pn = "kotlin.time", xi = 48)
public final class InstantConversionsJDK8Kt {
    public static final Instant toJavaInstant(kotlin.time.Instant instant) {
        Intrinsics.checkNotNullParameter(instant, C0000.decode(new byte[]{5, 67, 95, 80, 71, 14}, "9779409bbeed80f9"));
        Instant instantOfEpochSecond = Instant.ofEpochSecond(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, C0000.decode(new byte[]{9, 80, 114, 17, 14, 85, 81, 98, 85, 2, 87, 10, 7, 75, 75, 79, 72, 31}, "f67aa6910a8dccea", false));
        return instantOfEpochSecond;
    }

    public static final kotlin.time.Instant toKotlinInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, C0000.decode(new byte[]{89, 69, 88, 81, 67, 88}, "e1080ff2b1", 2));
        return kotlin.time.Instant.INSTANCE.fromEpochSeconds(instant.getEpochSecond(), instant.getNano());
    }
}
