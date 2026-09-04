package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "impl", "Lkotlin/random/Random;", "<init>", "(Lkotlin/random/Random;)V", "getImpl", "()Lkotlin/random/Random;", "next", "", "bits", "nextInt", "bound", "nextBoolean", "", "nextLong", "", "nextFloat", "", "nextDouble", "", "nextBytes", "", "bytes", "", "seedInitialized", "setSeed", "seed", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class KotlinRandom extends java.util.Random {
    private static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    public KotlinRandom(Random random) {
        Intrinsics.checkNotNullParameter(random, C0000.decode(new byte[]{81, 95, 18, 15}, "82bcd02268d77101", 0));
        this.impl = random;
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, C0000.decode(new byte[]{80, 78, 65, 85, 22}, "2750eb57", 7));
        this.impl.nextBytes(bytes);
    }

    @Override // java.util.Random
    public void setSeed(long seed) {
        if (this.seedInitialized) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{99, 0, 77, 17, 80, 15, 4, 18, 21, 1, 85, 7, 16, 12, 74, 69, 87, 14, 23, 18, 21, 17, 64, 19, 95, 23, 77, 0, 93, 79}, "0e9e9ac2fd0c", true));
        }
        this.seedInitialized = true;
    }

    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int bits) {
        return this.impl.nextBits(bits);
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public int nextInt(int bound) {
        return this.impl.nextInt(bound);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    /* JADX INFO: compiled from: PlatformRandom.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/random/KotlinRandom$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
