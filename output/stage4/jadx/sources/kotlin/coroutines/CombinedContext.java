package kotlin.coroutines;

import androidx.tracing.Trace;
import java.io.Serializable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CombinedContext implements CoroutineContext, Serializable {
    public final CoroutineContext.Element element;
    public final CoroutineContext left;

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        this.left = coroutineContext;
        this.element = element;
    }

    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (this == obj) {
            return true;
        }
        if (obj instanceof CombinedContext) {
            CombinedContext combinedContext = (CombinedContext) obj;
            int i = 2;
            CombinedContext combinedContext2 = combinedContext;
            int i2 = 2;
            while (true) {
                CoroutineContext coroutineContext = combinedContext2.left;
                combinedContext2 = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
                if (combinedContext2 == null) {
                    break;
                }
                i2++;
            }
            CombinedContext combinedContext3 = this;
            while (true) {
                CoroutineContext coroutineContext2 = combinedContext3.left;
                combinedContext3 = coroutineContext2 instanceof CombinedContext ? (CombinedContext) coroutineContext2 : null;
                if (combinedContext3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                CombinedContext combinedContext4 = this;
                while (true) {
                    CoroutineContext.Element element = combinedContext4.element;
                    if (!Intrinsics.areEqual(combinedContext.get(element.getKey()), element)) {
                        zAreEqual = false;
                        break;
                    }
                    CoroutineContext coroutineContext3 = combinedContext4.left;
                    if (!(coroutineContext3 instanceof CombinedContext)) {
                        CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext3;
                        zAreEqual = Intrinsics.areEqual(combinedContext.get(element2.getKey()), element2);
                        break;
                    }
                    combinedContext4 = (CombinedContext) coroutineContext3;
                }
                if (zAreEqual) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(this.left.fold(obj, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext.Element element = combinedContext.element.get(key);
            if (element != null) {
                return element;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public final int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        CoroutineContext.Element element = this.element;
        CoroutineContext.Element element2 = element.get(key);
        CoroutineContext coroutineContext = this.left;
        if (element2 != null) {
            return coroutineContext;
        }
        CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(key);
        if (coroutineContextMinusKey == coroutineContext) {
            return this;
        }
        return coroutineContextMinusKey == EmptyCoroutineContext.INSTANCE ? element : new CombinedContext(coroutineContextMinusKey, element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return Trace.plus(this, coroutineContext);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{110}, "525567bc35"));
        sb.append((String) fold("", CoroutineContext.AnonymousClass1.INSTANCE$1));
        sb.append(']');
        return sb.toString();
    }
}
