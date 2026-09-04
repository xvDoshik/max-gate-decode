package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\u0010\u0013\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\r\u001a!\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0087\b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0087\b\u001a!\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000f\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\n\u0010\u000e\u001a\u00020\u0011\"\u00020\u0006H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\n\u0010\u000e\u001a\u00020\u0012\"\u00020\u0007H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\n\u0010\u000e\u001a\u00020\u0013\"\u00020\bH\u0007\u001a\u001c\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\n\u0010\u000e\u001a\u00020\u0014\"\u00020\tH\u0007\u001a\u001c\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\n\u0010\u000e\u001a\u00020\u0015\"\u00020\nH\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00020\u0016\"\u00020\u000bH\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\r\u001a!\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0087\b\u001a!\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0087\b\u001a!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000f\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\n\u0010\u000e\u001a\u00020\u0011\"\u00020\u0006H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\n\u0010\u000e\u001a\u00020\u0012\"\u00020\u0007H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\n\u0010\u000e\u001a\u00020\u0013\"\u00020\bH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\n\u0010\u000e\u001a\u00020\u0014\"\u00020\tH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\n\u0010\u000e\u001a\u00020\u0015\"\u00020\nH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00020\u0016\"\u00020\u000bH\u0007¨\u0006\u0018"}, d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
public class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public static final byte maxOf(byte b, byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{90, 64, 81, 3, 67}, "549f1fe2b9b7", 0.0f));
        for (byte b2 : bArr) {
            b = (byte) Math.max((int) b, (int) b2);
        }
        return b;
    }

    public static final double maxOf(double d, double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, C0000.decode(new byte[]{93, 69, 95, 6, 69}, "217c72", 4));
        for (double d2 : dArr) {
            d = Math.max(d, d2);
        }
        return d;
    }

    public static final float maxOf(float f, float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, C0000.decode(new byte[]{91, 65, 89, 81, 19}, "4514aa0665", 5));
        for (float f2 : fArr) {
            f = Math.max(f, f2);
        }
        return f;
    }

    public static final int maxOf(int i, int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{89, 18, 91, 1, 75}, "6f3d93d9", true));
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    public static final long maxOf(long j, long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{88, 76, 92, 82, 23}, "7847e0", 1));
        for (long j2 : jArr) {
            j = Math.max(j, j2);
        }
        return j;
    }

    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{88}, "96d0aa1c25"));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{6}, "db41869dfc4a5f", 0.0f));
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{85}, "48603efed136a0", true));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{91}, "9dbf5641aaf846", 6));
        Intrinsics.checkNotNullParameter(t3, C0000.decode(new byte[]{85}, "6cc0b1dbe4", true));
        return (T) ComparisonsKt.maxOf(t, ComparisonsKt.maxOf(t2, t3));
    }

    public static final <T extends Comparable<? super T>> T maxOf(T t, T... tArr) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{86}, "79f3540283d5", 0.0f));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{10, 76, 93, 87, 65}, "e8523390"));
        for (T t2 : tArr) {
            t = (T) ComparisonsKt.maxOf(t, t2);
        }
        return t;
    }

    public static final short maxOf(short s, short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{14, 65, 88, 4, 75}, "a50a9941c14f5f", false));
        for (short s2 : sArr) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    public static final byte minOf(byte b, byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{91, 21, 91, 81, 71}, "4a345a3729ab15eb", true));
        for (byte b2 : bArr) {
            b = (byte) Math.min((int) b, (int) b2);
        }
        return b;
    }

    public static final double minOf(double d, double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, C0000.decode(new byte[]{90, 77, 9, 93, 75}, "59a89b4360f6"));
        for (double d2 : dArr) {
            d = Math.min(d, d2);
        }
        return d;
    }

    public static final float minOf(float f, float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, C0000.decode(new byte[]{14, 66, 89, 93, 68}, "a618630490", 0.0f));
        for (float f2 : fArr) {
            f = Math.min(f, f2);
        }
        return f;
    }

    public static final int minOf(int i, int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{92, 22, 10, 93, 75}, "3bb89856a5b19175"));
        for (int i2 : iArr) {
            i = Math.min(i, i2);
        }
        return i;
    }

    public static final long minOf(long j, long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{94, 16, 93, 4, 66}, "1d5a0b74", 0.0f));
        for (long j2 : jArr) {
            j = Math.min(j, j2);
        }
        return j;
    }

    public static final <T extends Comparable<? super T>> T minOf(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{82}, "3d2b5f6af4", false));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{6}, "d3a96a073f623f50", true));
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    public static final <T extends Comparable<? super T>> T minOf(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{88}, "975a9c721488b9", 0.0f));
        Intrinsics.checkNotNullParameter(t2, C0000.decode(new byte[]{1}, "c29ef58b8150"));
        Intrinsics.checkNotNullParameter(t3, C0000.decode(new byte[]{7}, "d6ea54afbc63f646", true));
        return (T) ComparisonsKt.minOf(t, ComparisonsKt.minOf(t2, t3));
    }

    public static final <T extends Comparable<? super T>> T minOf(T t, T... tArr) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{89}, "841d2045", 2));
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{88, 77, 81, 85, 67}, "79901752da946c"));
        for (T t2 : tArr) {
            t = (T) ComparisonsKt.minOf(t, t2);
        }
        return t;
    }

    public static final short minOf(short s, short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{13, 70, 89, 6, 74}, "b21c88fc14a456", 4));
        for (short s2 : sArr) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    private static final byte maxOf(byte b, byte b2) {
        return (byte) Math.max((int) b, (int) b2);
    }

    private static final short maxOf(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    private static final int maxOf(int i, int i2) {
        return Math.max(i, i2);
    }

    private static final long maxOf(long j, long j2) {
        return Math.max(j, j2);
    }

    private static final float maxOf(float f, float f2) {
        return Math.max(f, f2);
    }

    private static final double maxOf(double d, double d2) {
        return Math.max(d, d2);
    }

    private static final byte maxOf(byte b, byte b2, byte b3) {
        return (byte) Math.max((int) b, Math.max((int) b2, (int) b3));
    }

    private static final short maxOf(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    private static final int maxOf(int i, int i2, int i3) {
        return Math.max(i, Math.max(i2, i3));
    }

    private static final long maxOf(long j, long j2, long j3) {
        return Math.max(j, Math.max(j2, j3));
    }

    private static final float maxOf(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    private static final double maxOf(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    private static final byte minOf(byte b, byte b2) {
        return (byte) Math.min((int) b, (int) b2);
    }

    private static final short minOf(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    private static final int minOf(int i, int i2) {
        return Math.min(i, i2);
    }

    private static final long minOf(long j, long j2) {
        return Math.min(j, j2);
    }

    private static final float minOf(float f, float f2) {
        return Math.min(f, f2);
    }

    private static final double minOf(double d, double d2) {
        return Math.min(d, d2);
    }

    private static final byte minOf(byte b, byte b2, byte b3) {
        return (byte) Math.min((int) b, Math.min((int) b2, (int) b3));
    }

    private static final short minOf(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    private static final int minOf(int i, int i2, int i3) {
        return Math.min(i, Math.min(i2, i3));
    }

    private static final long minOf(long j, long j2, long j3) {
        return Math.min(j, Math.min(j2, j3));
    }

    private static final float minOf(float f, float f2, float f3) {
        return Math.min(f, Math.min(f2, f3));
    }

    private static final double minOf(double d, double d2, double d3) {
        return Math.min(d, Math.min(d2, d3));
    }
}
