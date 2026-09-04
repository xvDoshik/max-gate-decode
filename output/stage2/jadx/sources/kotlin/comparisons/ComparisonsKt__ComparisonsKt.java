package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u001aY\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u000226\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\t\u001aG\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022 \u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\t\u001aA\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a]\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e2\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00112\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0014\u001aY\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u000226\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\u0016\u001aC\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00112\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aC\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00112\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aW\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001as\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00112\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001aW\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001as\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00112\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001au\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u001128\b\u0004\u0010\u001e\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00010\u001fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\"\u001aT\u0010#\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011H\u0086\u0004¢\u0006\u0002\u0010$\u001aT\u0010%\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011H\u0086\u0004¢\u0006\u0002\u0010$\u001aE\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\b\b\u0000\u0010\u0002*\u00020'2\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011¢\u0006\u0002\u0010(\u001a2\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\b¢\u0006\u0002\u0010)\u001aE\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\b\b\u0000\u0010\u0002*\u00020'2\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011¢\u0006\u0002\u0010(\u001a2\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\b¢\u0006\u0002\u0010)\u001a+\u0010+\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\u0010)\u001a+\u0010,\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\u0010)\u001a5\u0010-\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011¢\u0006\u0002\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2 = {"compareValuesBy", "", "T", "a", "b", "selectors", "", "Lkotlin/Function1;", "", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "selector", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "K", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareBy", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "compareByDescending", "thenBy", "(Ljava/util/Comparator;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function2;)Ljava/util/Comparator;", "then", "(Ljava/util/Comparator;Ljava/util/Comparator;)Ljava/util/Comparator;", "thenDescending", "nullsFirst", "", "(Ljava/util/Comparator;)Ljava/util/Comparator;", "()Ljava/util/Comparator;", "nullsLast", "naturalOrder", "reverseOrder", "reversed", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
public class ComparisonsKt__ComparisonsKt {
    private static final <T, K> Comparator<T> compareBy(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{80, 94, 15, 73, 83, 64, 82, 69, 13, 75}, "31b922", 5));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{21, 84, 14, 84, 0, 18, 95, 68}, "f1b1cf0662d97dad", 4));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.3
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function2 = function1;
                return comparator2.compare((Object) function2.invoke(t), (Object) function2.invoke(t2));
            }
        };
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{21, 6, 95, 80, 84, 68, 87, 69}, "fc357087ee", true));
        return new AnonymousClass2(function1);
    }

    public static final <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, C0000.decode(new byte[]{74, 4, 84, 4, 80, 23, 12, 19, 74}, "9a8a3cca931b823b", false));
        if (function1Arr.length > 0) {
            return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(function1Arr, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{37, 4, 81, 15, 7, 86, 69, 20, 6, 66, 22, 12, 74, 6, 15, 87, 11, 18, 77}, "ce8cb2efc3", false).toString());
    }

    private static final <T, K> Comparator<T> compareByDescending(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{90, 14, 11, 72, 89, 74, 2, 70, 86, 65}, "9af888c29341", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{71, 80, 90, 0, 86, 16, 91, 19}, "456e5d4ab7"));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.2
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function2 = function1;
                return comparator2.compare((Object) function2.invoke(t2), (Object) function2.invoke(t));
            }
        };
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{23, 6, 93, 80, 91, 69, 92, 16}, "dc15813b0b87", true));
        return new AnonymousClass1(function1);
    }

    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{1, 95, 91, 71, 80, 16, 5, 16, 10, 70}, "b0671bdde4cc", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{65, 4, 95, 84, 87, 22, 93, 64}, "2a314b22", 4));
        return comparator.compare(function1.invoke(t), function1.invoke(t2));
    }

    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{71, 92, 9, 3, 5, 76, 91, 75}, "49eff8"));
        return ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
    }

    public static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, C0000.decode(new byte[]{16, 84, 85, 7, 90, 64, 91, 66, 16}, "c19b9440", 0));
        if (function1Arr.length > 0) {
            return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, function1Arr);
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{119, 81, 80, 95, 6, 2, 17, 66, 92, 66, 22, 15, 67, 85, 84, 86, 13, 18, 31}, "1093cf", 6).toString());
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(naturalOrderComparator, C0000.decode(new byte[]{90, 71, 15, 9, 20, 2, 85, 92, 13, 10, 64, 65, 86, 87, 67, 6, 85, 18, 64, 18, 23, 10, 20, 15, 91, 92, 78, 11, 65, 13, 88, 18, 23, 28, 68, 4, 20, 88, 2, 19, 85, 79, 65, 70, 10, 9, 26, 34, 91, 95, 19, 4, 70, 0, 64, 93, 17, 89, 96, 65, 91, 84, 67, 14, 91, 21, 88, 91, 13, 75, 87, 14, 89, 66, 2, 23, 93, 18, 91, 92, 16, 75, 119, 14, 89, 66, 2, 23, 93, 18, 91, 92, 16, 46, 64, 62, 107, 113, 12, 8, 68, 0, 70, 91, 16, 10, 90, 18, ByteCompanionObject.MAX_VALUE, 70, 77, 11, 85, 21, 65, 64, 2, 9, 123, 19, 80, 87, 17, 91}, "42ce4a", 0.0f));
        return naturalOrderComparator;
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{80, 12, 84, 72, 83, 68, 84, 76, 92, 17}, "3c982658", 2));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
            }
        };
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{6, 86, 95, 20, 81, 70, 7, 68, 87, 75}, "e92d04f08933"));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
            }
        };
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(reverseOrderComparator, C0000.decode(new byte[]{90, 71, 93, 14, 20, 2, 89, 92, 88, 95, 68, 66, 82, 92, 69, 7, 85, 65, 69, 66, 64, 14, 24, 92, 89, 94, 29, 12, 69, 85, 9, 68, 64, 75, 65, 7, 20, 11, 89, 68, 87, 30, 69, 22, 89, 85, 75, 39, 91, 95, 65, 3, 70, 0, 76, 93, 68, 12, 100, 66, 95, 95, 69, 15, 91, 70, 93, 11, 90, 79, 91, 93, 91, 64, 81, 16, 89, 74, 10, 10, 71, 28, 114, 13, 89, 17, 89, 64, 95, 67, 95, 12, 67, 114, 17, 59, 107, 113, 94, 15, 68, 0, 74, 91, 69, 95, 94, 17, 123, 77, 75, 22, 81, 68, 84, 16, 71, 4, 119, 64, 82, 85, 66, 92}, "421b4a82600b09ed"));
        return reverseOrderComparator;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{8, 76, 91, 88, 69, 15}, "483161daf85ae889", false));
        if (comparator instanceof ReversedComparator) {
            return ((ReversedComparator) comparator).getComparator();
        }
        boolean zAreEqual = Intrinsics.areEqual(comparator, NaturalOrderComparator.INSTANCE);
        String strDecode = C0000.decode(new byte[]{12, 64, 10, 14, 16, 83, 5, 8, 12, 90, 18, 66, 82, 85, 68, 5, 3, 70, 18, 66, 68, 95, 68, 8, 13, 91, 75, 12, 69, 92, 8, 70, 22, 76, 22, 7, 16, 90, 5, 16, 3, 27, 19, 22, 89, 92, 74, 37, 13, 88, 22, 3, 66, 81, 16, 9, 16, 9, 50, 66, 95, 86, 68, 13, 13, 65, 10, 11, 94, 30, 7, 9, 15, 69, 7, 16, 89, 67, 11, 8, 17, 27, 37, 13, 93, 64, 5, 20, 11, 70, 9, 12, 67, 123, 16, 57, Base64.padSymbol, 118, 9, 15, 64, 81, 22, 15, 17, 90, 8, 17, 123, 68, 74, 20, 7, 67, 3, 16, 67, 85, 0, 88}, "b5fb00df", 0.0f);
        if (zAreEqual) {
            ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
            Intrinsics.checkNotNull(reverseOrderComparator, strDecode);
            return reverseOrderComparator;
        }
        if (!Intrinsics.areEqual(comparator, ReverseOrderComparator.INSTANCE)) {
            return new ReversedComparator(comparator);
        }
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(naturalOrderComparator, strDecode);
        return naturalOrderComparator;
    }

    public static final <T> Comparator<T> then(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{12, 76, 9, 93, 65, 92}, "08a42b", 7));
        Intrinsics.checkNotNullParameter(comparator2, C0000.decode(new byte[]{91, 86, 14, 18, 82, 74, 5, 65, 94, 64}, "89cb38d5128ea0", 4));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.then$lambda$1$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
            }
        };
    }

    private static final <T, K> Comparator<T> thenBy(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{15, 69, 13, 10, 18, 13}, "31eca34202d62060"));
        Intrinsics.checkNotNullParameter(comparator2, C0000.decode(new byte[]{81, 94, 94, 66, 86, 23, 85, 17, 93, 71}, "21327e4e2544", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{23, 82, 95, 4, 82, 76, 11, 64}, "d73a18d25f5d2a", 0.0f));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenBy.2
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Comparator<? super K> comparator3 = comparator2;
                Function1<T, K> function2 = function1;
                return comparator3.compare((Object) function2.invoke(t), (Object) function2.invoke(t2));
            }
        };
    }

    private static final <T> Comparator<T> thenBy(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{5, 77, 13, 95, 23, 90}, "99e6dd37309486", 0.0f));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{23, 93, 14, 93, 82, 71, 11, 74}, "d8b813", 0.0f));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenBy.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Function1<T, Comparable<?>> function2 = function1;
                return ComparisonsKt.compareValues(function2.invoke(t), function2.invoke(t2));
            }
        };
    }

    private static final <T, K> Comparator<T> thenByDescending(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{94, 18, 11, 80, 22, 7}, "bfc9e9", 0.0f));
        Intrinsics.checkNotNullParameter(comparator2, C0000.decode(new byte[]{91, 86, 88, 17, 85, 20, 80, 16, 87, 75}, "895a4f1d", false));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{18, 81, 95, 87, 0, 77, 14, 70}, "a432c9", 6));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenByDescending.2
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Comparator<? super K> comparator3 = comparator2;
                Function1<T, K> function2 = function1;
                return comparator3.compare((Object) function2.invoke(t2), (Object) function2.invoke(t));
            }
        };
    }

    private static final <T> Comparator<T> thenByDescending(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{8, 16, 95, 15, 17, 88}, "4d7fbfd5cc21", 5));
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{75, 83, 9, 4, 5, 66, 87, 68}, "86eaf6", 2));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenByDescending.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Function1<T, Comparable<?>> function2 = function1;
                return ComparisonsKt.compareValues(function2.invoke(t2), function2.invoke(t));
            }
        };
    }

    private static final <T> Comparator<T> thenComparator(final Comparator<T> comparator, final Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{90, 17, 89, 89, 65, 90}, "fe102d", 2));
        Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{1, 12, 11, 67, 85, 20, 80, 21, 14, 92}, "bcf34f9fa2ca", true));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenComparator.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : function2.invoke(t, t2).intValue();
            }
        };
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, C0000.decode(new byte[]{88, 16, 14, 90, 23, 90}, "ddf3dd3003d8fa"));
        Intrinsics.checkNotNullParameter(comparator2, C0000.decode(new byte[]{1, 9, 93, 19, 89, 20, 80, 65, 13, 20}, "bf0c8f15", 7));
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
            }
        };
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int iCompareValues = ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
            if (iCompareValues != 0) {
                return iCompareValues;
            }
        }
        return 0;
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] function1Arr, Object obj, Object obj2) {
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(obj, obj2, function1Arr);
    }

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2, reason: invalid class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Comparable<?>> function1) {
            this.$selector = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Function1<T, Comparable<?>> function1 = this.$selector;
            return ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
        }
    }

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1, reason: invalid class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super T, ? extends Comparable<?>> function1) {
            this.$selector = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Function1<T, Comparable<?>> function1 = this.$selector;
            return ComparisonsKt.compareValues(function1.invoke(t2), function1.invoke(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator comparator, Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator comparator, Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }
}
