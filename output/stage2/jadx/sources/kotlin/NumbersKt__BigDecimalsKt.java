package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0010H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0087\b¨\u0006\u0011"}, d2 = {"plus", "Ljava/math/BigDecimal;", "other", "minus", "times", "div", "rem", "unaryMinus", "inc", "dec", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt {
    private static final BigDecimal dec(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{94, 64, 94, 8, 23, 90}, "b46add72724398"));
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, C0000.decode(new byte[]{70, 76, 7, 70, 19, 3, 86, 77, 77, 28, 79, 76, 28}, "59e2ab", true));
        return bigDecimalSubtract;
    }

    private static final BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{95, 65, 89, 13, 71, 12}, "c51d42c5970d", 1));
        Intrinsics.checkNotNullParameter(bigDecimal2, C0000.decode(new byte[]{94, 65, 91, 7, 70}, "153b464a137f", true));
        BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide, C0000.decode(new byte[]{87, 90, 20, 8, 83, 92, 29, 25, 24, 26, 75}, "33ba795764bd77", 0.0f));
        return bigDecimalDivide;
    }

    private static final BigDecimal inc(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{15, 70, 11, 11, 68, 88}, "32cb7fe92e4695f4", true));
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, C0000.decode(new byte[]{81, 83, 92, 27, 74, 72, 30, 30}, "0783df", 1));
        return bigDecimalAdd;
    }

    private static final BigDecimal minus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{8, 64, 95, 15, 66, 7}, "447f193d157dfd", 6));
        Intrinsics.checkNotNullParameter(bigDecimal2, C0000.decode(new byte[]{92, 70, 9, 1, 68}, "32ad602e3d9543", 5));
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, C0000.decode(new byte[]{22, 76, 82, 71, 68, 0, 2, 69, 25, 28, 27, 74, 76}, "e9036aa1125d", 7));
        return bigDecimalSubtract;
    }

    private static final BigDecimal plus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{94, 77, 13, 91, 74, 7}, "b9e299f2d9", 0.0f));
        Intrinsics.checkNotNullParameter(bigDecimal2, C0000.decode(new byte[]{86, 64, 14, 93, 22}, "94f8d7", 3));
        BigDecimal bigDecimalAdd = bigDecimal.add(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, C0000.decode(new byte[]{85, 0, 84, 17, 77, 28, 27, 17}, "4d09c258", 1));
        return bigDecimalAdd;
    }

    private static final BigDecimal rem(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{94, 18, 14, 93, 16, 91}, "bff4cecb", 3));
        Intrinsics.checkNotNullParameter(bigDecimal2, C0000.decode(new byte[]{88, 68, 91, 85, 68}, "703060", false));
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(bigDecimalRemainder, C0000.decode(new byte[]{67, 80, 93, 5, 88, 95, 5, 92, 65, 26, 74, 26, 31, 28}, "150d11a932d4", 0.0f));
        return bigDecimalRemainder;
    }

    private static final BigDecimal times(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{5, 17, 13, 81, 21, 14}, "9ee8f08a", 6));
        Intrinsics.checkNotNullParameter(bigDecimal2, C0000.decode(new byte[]{87, 64, 81, 92, 22}, "8499dceeb05be4", false));
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, C0000.decode(new byte[]{93, 77, 88, 66, 12, 66, 92, 28, 25, 30, 31, 22, 25}, "0846e20e1018", true));
        return bigDecimalMultiply;
    }

    private static final BigDecimal toBigDecimal(double d, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{12, 82, 21, 89, 113, 89, 86, 16, 83, 28, 64}, "a3a1268d6d4bbe81", 0.0f));
        return new BigDecimal(String.valueOf(d), mathContext);
    }

    private static final BigDecimal toBigDecimal(float f, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{8, 85, 16, 95, 33, 10, 94, 69, 3, 64, 16}, "e4d7be01f8da62", 6));
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    private static final BigDecimal toBigDecimal(int i) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{67, 85, 85, 19, 81, 44, 2, 30, 31, 26, 27, 29}, "549f4cd614", 0.0f));
        return bigDecimalValueOf;
    }

    private static final BigDecimal toBigDecimal(int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{14, 82, 76, 91, 122, 13, 95, 65, 80, 78, 23}, "c3839b1556", 7));
        return new BigDecimal(i, mathContext);
    }

    private static final BigDecimal toBigDecimal(long j) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{21, 84, 88, 70, 1, 126, 80, 31, 76, 72, 30, 29}, "c543d167bf04", 0.0f));
        return bigDecimalValueOf;
    }

    private static final BigDecimal toBigDecimal(long j, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, C0000.decode(new byte[]{15, 86, 16, 10, 115, 92, 95, 76, 7, 79, 16}, "b7db0318"));
        return new BigDecimal(j, mathContext);
    }

    private static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, C0000.decode(new byte[]{4, 68, 89, 95, 71, 10}, "801644e0", 0.0f));
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        Intrinsics.checkNotNullExpressionValue(bigDecimalNegate, C0000.decode(new byte[]{93, 0, 87, 89, 70, 85, 17, 22, 30, 79, 30}, "3e0820980a77", 1));
        return bigDecimalNegate;
    }

    private static final BigDecimal toBigDecimal(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    private static final BigDecimal toBigDecimal(double d) {
        return new BigDecimal(String.valueOf(d));
    }
}
