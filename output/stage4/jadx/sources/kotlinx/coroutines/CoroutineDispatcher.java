package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements CoroutineContext.Element {
    public CoroutineDispatcher() {
        super(ContinuationInterceptor$Key.$$INSTANCE);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        CoroutineContext.Element elementTryCast$kotlin_stdlib;
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            if (this.key == abstractCoroutineContextKey && (elementTryCast$kotlin_stdlib = abstractCoroutineContextKey.tryCast$kotlin_stdlib(this)) != null) {
                return elementTryCast$kotlin_stdlib;
            }
        } else if (ContinuationInterceptor$Key.$$INSTANCE == key) {
            return this;
        }
        return null;
    }

    public boolean isDispatchNeeded() {
        return !(this instanceof Unconfined);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (kotlin.coroutines.ContinuationInterceptor$Key.$$INSTANCE == r2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        return kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0019, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r2.tryCast$kotlin_stdlib(r1) == null) goto L14;
     */
    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.coroutines.CoroutineContext minusKey(kotlin.coroutines.CoroutineContext.Key r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof kotlin.coroutines.AbstractCoroutineContextKey
            if (r0 == 0) goto L12
            kotlin.coroutines.AbstractCoroutineContextKey r2 = (kotlin.coroutines.AbstractCoroutineContextKey) r2
            kotlin.coroutines.CoroutineContext$Key r0 = r1.key
            if (r0 == r2) goto Lb
            return r1
        Lb:
            kotlin.coroutines.CoroutineContext$Element r2 = r2.tryCast$kotlin_stdlib(r1)
            if (r2 == 0) goto L19
            goto L16
        L12:
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor$Key.$$INSTANCE
            if (r0 != r2) goto L19
        L16:
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            return r2
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineDispatcher.minusKey(kotlin.coroutines.CoroutineContext$Key):kotlin.coroutines.CoroutineContext");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }
}
