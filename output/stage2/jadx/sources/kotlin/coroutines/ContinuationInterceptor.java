package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H&J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J(\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "releaseInterceptedContinuation", "", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "Key", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContinuationInterceptor extends CoroutineContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(ContinuationInterceptor continuationInterceptor, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, C0000.decode(new byte[]{91, 64, 83, 71, 5, 71, 94, 13, 91}, "4065d37b5f7f059d"));
            return (R) CoroutineContext.Element.DefaultImpls.fold(continuationInterceptor, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, C0000.decode(new byte[]{9, 93, 31}, "b8f366c80ca99944", false));
            if (!(key instanceof AbstractCoroutineContextKey)) {
                if (ContinuationInterceptor.INSTANCE != key) {
                    return null;
                }
                Intrinsics.checkNotNull(continuationInterceptor, C0000.decode(new byte[]{87, 71, 91, 15, 24, 0, 84, 88, 11, 90, 22, 22, 87, 1, 25, 81, 86, 16, 76, 67, 65, 89, 69, 91, 13, 88, 24, 10, 76, 94, 91, 67, 76, 26, 69, 83, 69, 112, 66, 89, 83, 68, 82, 93, 67, 15, 81, 13, 27, 85, 10, 71, 13, 67, 65, 13, 87, 87, 68, 77, 123, 12, 91, 66, 12, 91, 23, 87, 65, 13, 86, 92, 126, 13, 76, 6, 71, 85, 0, 69, 22, 89, 71, 74, 94, 87, 67}, "927c8c56e5b65d"));
                return continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            if (abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) {
                E e = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(continuationInterceptor);
                if (e instanceof CoroutineContext.Element) {
                    return e;
                }
            }
            return null;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, C0000.decode(new byte[]{92, 82, 65}, "7781a37f6f09", 0.0f));
            if (!(key instanceof AbstractCoroutineContextKey)) {
                return ContinuationInterceptor.INSTANCE == key ? EmptyCoroutineContext.INSTANCE : continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.INSTANCE;
        }

        public static CoroutineContext plus(ContinuationInterceptor continuationInterceptor, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(coroutineContext, C0000.decode(new byte[]{2, 14, 86, 22, 80, 28, 68}, "aa8b5d02a918f6d2", true));
            return CoroutineContext.Element.DefaultImpls.plus(continuationInterceptor, coroutineContext);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor continuationInterceptor, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{80, 86, 86, 77, 11, 15, 65, 84, 66, 94, 92, 87}, "3989ba4567", 5));
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(Continuation<?> continuation);

    /* JADX INFO: renamed from: kotlin.coroutines.ContinuationInterceptor$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
