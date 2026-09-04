package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\f\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\f\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0010H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0013H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0087\b\u001a!\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b¨\u0006\u0019"}, d2 = {"plus", "Ljava/math/BigInteger;", "other", "minus", "times", "div", "rem", "unaryMinus", "inc", "dec", "inv", "and", "or", "xor", "shl", "n", "", "shr", "toBigInteger", "", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    private static final BigInteger and(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{89, 69, 90, 81, 74, 93}, "e1289c48"));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{9, 69, 89, 85, 22}, "f110dbd9", true));
        BigInteger bigIntegerAnd = bigInteger.and(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAnd, C0000.decode(new byte[]{80, 93, 80, 26, 76, 23, 31, 26}, "1342b9"));
        return bigIntegerAnd;
    }

    private static final BigInteger dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{89, 21, 11, 92, 18, 93}, "eac5ac53", 0.0f));
        BigInteger bigIntegerSubtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, C0000.decode(new byte[]{68, 16, 83, 18, 69, 88, 87, 18, 17, 27, 25, 75, 24}, "7e1f794f95", 4));
        return bigIntegerSubtract;
    }

    private static final BigInteger div(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{95, 65, 89, 95, 21, 95}, "c516fa", 0.0f));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{87, 18, 14, 6, 19}, "8ffca864", 6));
        BigInteger bigIntegerDivide = bigInteger.divide(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerDivide, C0000.decode(new byte[]{80, 93, 65, 8, 1, 6, 28, 26, 25, 79, 76}, "447aec", 0.0f));
        return bigIntegerDivide;
    }

    private static final BigInteger inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{93, 16, 93, 92, 22, 95}, "ad55ea24bbcc", 1));
        BigInteger bigIntegerAdd = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, C0000.decode(new byte[]{81, 83, 5, 16, 74, 28, 30, 30}, "07a8d2", false));
        return bigIntegerAdd;
    }

    private static final BigInteger inv(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{4, 67, 89, 95, 69, 91}, "87166e", 0.0f));
        BigInteger bigIntegerNot = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(bigIntegerNot, C0000.decode(new byte[]{89, 9, 70, 28, 23, 23, 76, 26}, "7f2499b34ac65f34"));
        return bigIntegerNot;
    }

    private static final BigInteger minus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{4, 17, 14, 90, 18, 6}, "8ef3a825a0fe", true));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{87, 17, 93, 3, 65}, "8e5f3a58e130c77d", 0.0f));
        BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, C0000.decode(new byte[]{69, 66, 85, 71, 64, 7, 85, 67, 31, 29, 28, 72, 31}, "67732f", true));
        return bigIntegerSubtract;
    }

    private static final BigInteger or(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{4, 70, 14, 11, 22, 13}, "82fbe3e4405e13", 0.0f));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{94, 66, 9, 3, 20}, "16aff1c9", 0.0f));
        BigInteger bigIntegerOr = bigInteger.or(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerOr, C0000.decode(new byte[]{91, 69, 77, 22, 79, 30, 31}, "47e8a06e8684", 3));
        return bigIntegerOr;
    }

    private static final BigInteger plus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{15, 69, 10, 13, 16, 10}, "31bdc4f60482db"));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{94, 21, 11, 3, 66}, "1acf0db2912c774f"));
        BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, C0000.decode(new byte[]{2, 0, 82, 75, 74, 75, 77, 16}, "cd6cdec9"));
        return bigIntegerAdd;
    }

    private static final BigInteger rem(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{93, 64, 13, 95, 64, 11}, "a4e635058d908945", true));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{87, 67, 12, 7, 65}, "87db3d1c027ce247"));
        BigInteger bigIntegerRemainder = bigInteger.remainder(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerRemainder, C0000.decode(new byte[]{68, 6, 89, 7, 81, 12, 87, 0, 69, 76, 24, 77, 26, 79}, "6c4f8b3e7d", 0));
        return bigIntegerRemainder;
    }

    private static final BigInteger shl(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{12, 71, 92, 8, 75, 95}, "034a8a2836d6372e", 1));
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i);
        Intrinsics.checkNotNullExpressionValue(bigIntegerShiftLeft, C0000.decode(new byte[]{18, 89, 94, 86, 65, ByteCompanionObject.MAX_VALUE, 87, 0, 68, 74, 31, 28, 79, 24}, "a170532f0b12", true));
        return bigIntegerShiftLeft;
    }

    private static final BigInteger shr(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{89, 17, 81, 92, 69, 92}, "ee956b"));
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i);
        Intrinsics.checkNotNullExpressionValue(bigIntegerShiftRight, C0000.decode(new byte[]{75, 91, 90, 82, 68, 52, 10, 85, 88, 77, 26, 72, 74, 31, 17}, "83340fc2092fd1", 0.0f));
        return bigIntegerShiftRight;
    }

    private static final BigInteger times(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{5, 23, 9, 94, 67, 88}, "9ca70ff4", 0.0f));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{86, 18, 95, 4, 22}, "9f7adc21", false));
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerMultiply, C0000.decode(new byte[]{91, 69, 85, 18, 89, 73, 93, 27, 25, 27, 28, 23, 74}, "609f091b1529c487"));
        return bigIntegerMultiply;
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{12, 17, 95, 80, 67, 12}, "0e79023c000023"));
        return new BigDecimal(bigInteger);
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger, int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{13, 68, 93, 8, 74, 15}, "105a91", 0.0f));
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{94, 2, 18, 88, 34, 86, 91, 68, 3, 65, 71}, "3cf0a950f9", 0.0f));
        return new BigDecimal(bigInteger, i, mathContext);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
        }
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{14, 66, 90, 95, 66, 92}, "26261b3ec5"));
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{95, 81, 71, 91, 114, 14, 12, 18, 83, 72, 22}, "20331abf60b0", 0.0f));
        return new BigDecimal(bigInteger, i, mathContext);
    }

    private static final BigInteger toBigInteger(int i) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{69, 88, 95, 77, 4, 46, 85, 17, 29, 22, 79, 72}, "3938aa"));
        return bigIntegerValueOf;
    }

    private static final BigInteger toBigInteger(long j) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{16, 0, 13, 20, 92, 120, 2, 31, 72, 79, 79, 72}, "faaa97d7", true));
        return bigIntegerValueOf;
    }

    private static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{88, 64, 94, 88, 22, 9}, "d461e7c8b5b9", 4));
        BigInteger bigIntegerNegate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(bigIntegerNegate, C0000.decode(new byte[]{92, 80, 84, 86, 68, 1, 26, 26, 28, 27, 26}, "25370d24", false));
        return bigIntegerNegate;
    }

    private static final BigInteger xor(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, C0000.decode(new byte[]{94, 67, 10, 92, 64, 91}, "b7b53e1575", 0.0f));
        Intrinsics.checkNotNullParameter(bigInteger2, C0000.decode(new byte[]{86, 69, 81, 87, 67}, "9192193c7269", 0.0f));
        BigInteger bigIntegerXor = bigInteger.xor(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerXor, C0000.decode(new byte[]{26, 87, 70, 24, 26, 75, 29, 31}, "b8404e36e505", 3));
        return bigIntegerXor;
    }
}
