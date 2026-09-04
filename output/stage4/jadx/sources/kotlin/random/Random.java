package kotlin.random;

import java.io.Serializable;
import kotlin.internal.jdk8.JDK8PlatformImplementations$ReflectSdkVersion;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Random {
    public static final AbstractPlatformRandom defaultRandom;

    static {
        Integer num = JDK8PlatformImplementations$ReflectSdkVersion.sdkVersion;
        defaultRandom = (num == null || num.intValue() >= 34) ? new PlatformThreadLocalRandom() : new FallbackThreadLocalRandom();
    }

    public abstract int nextBits(int i);

    public abstract int nextInt();

    public abstract long nextLong();

    public long nextLong(long j, long j2) {
        long jNextLong;
        long j3;
        long jNextBits;
        int iNextInt;
        if (j2 <= j) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{51, 89, 88, 82, 88, 11, 65, 74, 87, 88, 80, 3, 65, 81, 69, 22, 82, 11, 17, 76, 79, 12, 23, 61}, "a8667f") + Long.valueOf(j) + C0000.decode(new byte[]{25, 70}, "5f417828afda6165") + Long.valueOf(j2) + C0000.decode(new byte[]{77, 28}, "d2b46829")).toString());
        }
        long j4 = j2 - j;
        if (j4 > 0) {
            if (((-j4) & j4) == j4) {
                int i = (int) j4;
                int i2 = (int) (j4 >>> 32);
                if (i != 0) {
                    iNextInt = nextBits(31 - Integer.numberOfLeadingZeros(i));
                } else if (i2 == 1) {
                    iNextInt = nextInt();
                } else {
                    jNextBits = (((long) nextBits(31 - Integer.numberOfLeadingZeros(i2))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                jNextBits = ((long) iNextInt) & 4294967295L;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j3 = jNextLong % j4;
                } while ((j4 - 1) + (jNextLong - j3) < 0);
                jNextBits = j3;
            }
            return j + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (j <= jNextLong2 && jNextLong2 < j2) {
                return jNextLong2;
            }
        }
    }

    public final class Default extends Random implements Serializable {
        @Override // kotlin.random.Random
        public final int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public final int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public final long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public final long nextLong(long j, long j2) {
            return Random.defaultRandom.nextLong(j, j2);
        }
    }
}
