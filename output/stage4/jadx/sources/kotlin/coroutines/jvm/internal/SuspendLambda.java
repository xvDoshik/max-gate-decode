package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Reflection;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class SuspendLambda extends ContinuationImpl implements FunctionBase {
    public final int arity;

    public SuspendLambda(int i, Continuation continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final String toString() {
        if (this.completion != null) {
            return super.toString();
        }
        Reflection.factory.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        return string.startsWith(C0000.decode(new byte[]{83, 11, 70, 95, 95, 88, 22, 14, 68, 94, 24, 80, 77, 10, 81, 71, 95, 89, 86, 23, 28}, "8d2366", 0.0f)) ? string.substring(21) : string;
    }
}
