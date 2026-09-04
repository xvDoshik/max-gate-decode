package kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aA\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001\u001a8\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010\u001a\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\b\u0012\u0004\u0012\u00020\u00120\u0001H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0011\u001a\u0004\u0018\u0001H\f\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001H\u0007¢\u0006\u0002\u0010\u0016\u001aG\u0010\u0017\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a;\u0010\u001b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010H\u0007¢\u0006\u0002\u0010\u001c\u001a\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u0012*\b\u0012\u0004\u0012\u00020\u00120\u0001H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a)\u0010\u001d\u001a\u0004\u0018\u0001H\f\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001H\u0007¢\u0006\u0002\u0010\u0016\u001aG\u0010\u001e\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a;\u0010\u001f\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010H\u0007¢\u0006\u0002\u0010\u001c\u001a5\u0010 \u001a\u00020!\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020!0\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\b\"\u001a5\u0010 \u001a\u00020#\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020#0\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\b$\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "maxBy", "selector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public static final <R> Sequence<R> filterIsInstance(Sequence<?> sequence, final Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{9, 68, 93, 89, 67, 7}, "505009fc89dc", false));
        Intrinsics.checkNotNullParameter(cls, C0000.decode(new byte[]{14, 90, 0, 68, 21}, "e6a7f39f7ef4d485", 4));
        Sequence<R> sequenceFilter = SequencesKt.filter(sequence, new Function1() { // from class: kotlin.sequences.SequencesKt___SequencesJvmKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(cls.isInstance(obj));
            }
        });
        Intrinsics.checkNotNull(sequenceFilter, C0000.decode(new byte[]{95, 19, 88, 92, 22, 7, 80, 8, 90, 95, 66, 68, 83, 3, 20, 83, 87, 23, 69, 70, 64, 95, 22, 10, 94, 8, 25, 94, 67, 8, 93, 70, 64, 73, 70, 1, 17, 13, 91, 68, 90, 13, 95, 72, 71, 85, 71, 17, 84, 8, 87, 85, 69, 74, 98, 3, 69, 69, 83, 10, 82, 3, 8, 98, 22, 11, 87, 70, 95, 95, 66, 8, 88, 8, 26, 67, 83, 21, 68, 3, 90, 83, 83, 23, 31, 53, 81, 65, 67, 1, 95, 5, 81, 67, 125, 16, 110, 57, 107, 99, 83, 21, 68, 3, 90, 83, 83, 23, 123, 16, 89, 123, 66, 74, 87, 15, 88, 68, 83, 22, 120, 21, 125, 94, 69, 16, 80, 8, 87, 85, 8}, "1f406d"));
        return sequenceFilter;
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> sequence, C c, Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{15, 23, 95, 95, 74, 12}, "3c7692e301dd"));
        Intrinsics.checkNotNullParameter(c, C0000.decode(new byte[]{6, 7, 17, 21, 11, 87, 88, 67, 11, 13, 12}, "bbbab997"));
        Intrinsics.checkNotNullParameter(cls, C0000.decode(new byte[]{14, 91, 88, 74, 74}, "e7999f22"));
        for (Object obj : sequence) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{5, 77, 94, 12, 70, 12}, "996e527c58", true));
        return SequencesKt.maxOrNull(sequence);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m1306max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{93, 67, 90, 89, 68, 14}, "a720705c8b", 0.0f));
        return SequencesKt.maxOrNull(sequence);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m1307max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{93, 68, 94, 80, 66, 13}, "a0691300fda265"));
        return SequencesKt.maxOrNull(sequence);
    }

    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [T] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{9, 22, 12, 91, 70, 10}, "5bd254cbafbbde", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{22, 6, 15, 85, 80, 67, 13, 22}, "ecc037bdf1cd", 0.0f));
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = function1.invoke(next);
        do {
            T next2 = it.next();
            R rInvoke2 = function1.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object maxWith(Sequence sequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{15, 68, 95, 95, 69, 92}, "30766b", 5));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{5, 86, 93, 66, 0, 23, 7, 77, 95, 64}, "f902ae", 0.0f));
        return SequencesKt.maxWithOrNull(sequence, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{14, 64, 95, 90, 66, 88}, "24731f", false));
        return SequencesKt.minOrNull(sequence);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m1308min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{89, 66, 12, 11, 75, 92}, "e6db8bbd97", 0.0f));
        return SequencesKt.minOrNull(sequence);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m1309min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{4, 67, 12, 11, 67, 88}, "87db0fa719b71d", 0));
        return SequencesKt.minOrNull(sequence);
    }

    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [T] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{89, 18, 14, 91, 64, 95}, "eff23a32163de3be", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{18, 4, 9, 81, 86, 65, 89, 64}, "aae45562765d1977", true));
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = function1.invoke(next);
        do {
            T next2 = it.next();
            R rInvoke2 = function1.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object minWith(Sequence sequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{9, 66, 93, 89, 68, 13}, "5650733eb5f6ac", 7));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{84, 14, 94, 64, 84, 16, 7, 76, 93, 19}, "7a305bf82a399ce4"));
        return SequencesKt.minWithOrNull(sequence, comparator);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Sequence<? extends T> sequence, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{93, 23, 81, 93, 69, 12}, "ac9462cd8c"));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{22, 6, 14, 4, 5, 64, 88, 70}, "ecbaf474e3e2f822"));
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{70, 87, 94, 68, 81, 41, 80, 77, 75, 76, 72, 31}, "06214f6eebf65a"));
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(function1.invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, C0000.decode(new byte[]{5, 84, 86, 16, 25, 28, 74, 25}, "d02872d05b", 4));
        }
        return bigDecimalValueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(Sequence<? extends T> sequence, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{94, 67, 12, 81, 21, 13}, "b7d8f3c0cd", true));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{18, 4, 90, 86, 82, 65, 90, 68}, "aa631556ed641c55", 7));
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{70, 86, 94, 64, 83, 119, 7, 26, 79, 30, 30, 26}, "072568a2a003f6d6", 1));
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(function1.invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, C0000.decode(new byte[]{87, 87, 5, 31, 29, 27, 25, 77}, "63a7357dbaf5e8fa", false));
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{93, 71, 81, 80, 21, 13}, "a399f362dd5b7731", 0.0f));
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{88, 71, 94, 13, 21, 92}, "d36dfb20", false));
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{1, 12, 94, 65, 3, 17, 85, 22, 91, 16}, "bc31bc4b4be1d56f"));
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }
}
