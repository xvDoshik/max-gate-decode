package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002J\u0014\u0010\u0010\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H&¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "Key", "Element", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CoroutineContext {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            Intrinsics.checkNotNullParameter(coroutineContext2, C0000.decode(new byte[]{1, 14, 88, 18, 85, 65, 68}, "ba6f090c3fb3"));
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, new Function2() { // from class: kotlin.coroutines.CoroutineContext$DefaultImpls$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoroutineContext.DefaultImpls.plus$lambda$0((CoroutineContext) obj, (CoroutineContext.Element) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CoroutineContext plus$lambda$0(CoroutineContext coroutineContext, Element element) {
            CombinedContext combinedContext;
            Intrinsics.checkNotNullParameter(coroutineContext, C0000.decode(new byte[]{84, 86, 80}, "553eff3f", false));
            Intrinsics.checkNotNullParameter(element, C0000.decode(new byte[]{81, 93, 1, 95, 0, 8, 77}, "41d2ef94a449f5", 0.0f));
            CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element.getKey());
            if (coroutineContextMinusKey == EmptyCoroutineContext.INSTANCE) {
                return element;
            }
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(ContinuationInterceptor.INSTANCE);
            if (continuationInterceptor == null) {
                combinedContext = new CombinedContext(coroutineContextMinusKey, element);
            } else {
                CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(ContinuationInterceptor.INSTANCE);
                combinedContext = coroutineContextMinusKey2 == EmptyCoroutineContext.INSTANCE ? new CombinedContext(element, continuationInterceptor) : new CombinedContext(new CombinedContext(coroutineContextMinusKey2, element), continuationInterceptor);
            }
            return combinedContext;
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0003H\u0096\u0002¢\u0006\u0002\u0010\bJ5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Element extends CoroutineContext {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{87, 69, 92, 70, 89, 65, 88, 11, 90}, "8594851d44"));
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                Intrinsics.checkNotNullParameter(key, C0000.decode(new byte[]{88, 92, 78}, "3975e9ecd488", 7));
                if (!Intrinsics.areEqual(element.getKey(), key)) {
                    return null;
                }
                Intrinsics.checkNotNull(element, C0000.decode(new byte[]{88, 22, 88, 93, 18, 6, 87, 91, 8, 94, 22, 18, 84, 6, 20, 82, 83, 22, 66, 21, 18, 94, 66, 92, 89, 13, 25, 95, 71, 9, 90, 21, 18, 72, 18, 87, 22, 38, 20, 94, 84, 69, 93, 90, 18, 93, 11, 92, 24, 0, 91, 67, 93, 16, 66, 92, 8, 84, 17, 28, 117, 12, 70, 94, 71, 17, 95, 91, 3, 114, 13, 92, 66, 6, 76, 69, 28, 32, 90, 80, 11, 84, 12, 70, 24, 4, 81, 69}, "6c412e65f1b2"));
                return element;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                Intrinsics.checkNotNullParameter(key, C0000.decode(new byte[]{10, 86, 28}, "a3e0aa4c047f4ddf", 0.0f));
                return Intrinsics.areEqual(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                Intrinsics.checkNotNullParameter(coroutineContext, C0000.decode(new byte[]{1, 94, 93, 76, 0, 79, 16}, "b138e7d6ef", 2));
                return DefaultImpls.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        CoroutineContext minusKey(Key<?> key);
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Key<E extends Element> {
    }

    <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}
