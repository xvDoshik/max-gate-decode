package kotlin.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface CoroutineContext {

    public interface Element extends CoroutineContext {
        Key getKey();
    }

    public interface Key {
    }

    /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$plus$1, reason: invalid class name */
    public final class AnonymousClass1 extends Lambda implements Function2 {
        public static final AnonymousClass1 INSTANCE;
        public static final AnonymousClass1 INSTANCE$1;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 2;
            INSTANCE$1 = new AnonymousClass1(i, 1);
            INSTANCE = new AnonymousClass1(i, 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CombinedContext combinedContext;
            switch (this.$r8$classId) {
                case 0:
                    Element element = (Element) obj2;
                    CoroutineContext coroutineContextMinusKey = ((CoroutineContext) obj).minusKey(element.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    if (coroutineContextMinusKey == emptyCoroutineContext) {
                        return element;
                    }
                    ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
                    CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) coroutineContextMinusKey.get(continuationInterceptor$Key);
                    if (coroutineDispatcher == null) {
                        combinedContext = new CombinedContext(coroutineContextMinusKey, element);
                    } else {
                        CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(continuationInterceptor$Key);
                        if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(element, coroutineDispatcher);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, element), coroutineDispatcher);
                    }
                    return combinedContext;
                default:
                    String str = (String) obj;
                    Element element2 = (Element) obj2;
                    if (str.length() == 0) {
                        return element2.toString();
                    }
                    return str + C0000.decode(new byte[]{27, 70}, "7fc93a2699a623", true) + element2;
            }
        }
    }

    Object fold(Object obj, Function2 function2);

    Element get(Key key);

    CoroutineContext minusKey(Key key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
