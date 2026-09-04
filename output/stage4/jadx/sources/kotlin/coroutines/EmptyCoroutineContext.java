package kotlin.coroutines;

import java.io.Serializable;
import kotlin.jvm.functions.Function2;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return obj;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return coroutineContext;
    }

    public final String toString() {
        return C0000.decode(new byte[]{119, 84, 19, 76, 79, 39, 92, 65, 89, 70, 64, 80, 87, 4, 119, 87, 92, 77, 6, 64, 66}, "29c86d3363499a48", true);
    }
}
