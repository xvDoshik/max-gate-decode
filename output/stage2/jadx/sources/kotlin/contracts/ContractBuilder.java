package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;
import p000.C0000;

/* JADX INFO: compiled from: ContractBuilder.kt */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\u0005\u001a\u00020\u0006H'J&\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lkotlin/contracts/ContractBuilder;", "", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContractBuilder {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ CallsInPlace callsInPlace$default(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException(C0000.decode(new byte[]{102, 69, 73, 87, 16, 23, 85, 89, 89, 92, 74, 18, 21, 94, 66, 80, 21, 84, 92, 84, 3, 66, 90, 76, 21, 81, 75, 85, 23, 90, 83, 86, 65, 67, 25, 92, 13, 67, 22, 75, 64, 64, 73, 93, 16, 67, 83, 92, 21, 89, 87, 18, 22, 95, 95, 75, 21, 68, 88, 64, 5, 82, 66, 20, 21, 86, 76, 92, 1, 67, 95, 87, 91, 10, 25, 81, 3, 91, 90, 75, 124, 94, 105, 94, 3, 84, 83}, "5092b768", 0.0f));
            }
            if ((i & 2) != 0) {
                invocationKind = InvocationKind.UNKNOWN;
            }
            return contractBuilder.callsInPlace(function, invocationKind);
        }
    }

    <R> CallsInPlace callsInPlace(Function<? extends R> lambda, InvocationKind kind);

    Returns returns();

    Returns returns(Object value);

    ReturnsNotNull returnsNotNull();
}
