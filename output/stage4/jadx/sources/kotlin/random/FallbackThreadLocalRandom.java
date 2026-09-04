package kotlin.random;

import okhttp3.internal.http.DatesKt$STANDARD_DATE_FORMAT$1;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final DatesKt$STANDARD_DATE_FORMAT$1 implStorage = new DatesKt$STANDARD_DATE_FORMAT$1(1);

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random getImpl() {
        return (java.util.Random) this.implStorage.get();
    }
}
