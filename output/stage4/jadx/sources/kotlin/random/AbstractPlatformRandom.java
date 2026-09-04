package kotlin.random;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractPlatformRandom extends Random {
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public final int nextBits(int i) {
        return ((-i) >> 31) & (getImpl().nextInt() >>> (32 - i));
    }

    @Override // kotlin.random.Random
    public final int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public final long nextLong() {
        return getImpl().nextLong();
    }
}
