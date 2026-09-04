package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;
    private final int flags;

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        return C0000.decode(new byte[]{94, 80, 13, 81, 70, 7}, "b9c829ec6e").equals(getName()) ? C0000.decode(new byte[]{87, 89, 94, 21, 77, 69, 77, 1, 21, 94, 74, 24, 25, 115, 91, 66, 92, 15, 87, 23, 74, 7, 7, 93, 93, 91, 69, 81, 91, 88, 16, 15, 74, 23, 86, 13, 21, 17, 89, 78, 80, 81, 88, 87, 82, 10, 92, 30}, "460f978ba18818", true) : C0000.decode(new byte[]{4, 66, 93, 81, 65, 12, 94, 88, 22}, "b7325e16606b0e33") + getName() + C0000.decode(new byte[]{16, 27, 45, 11, 77, 9, 80, 87, 21, 19, 86, 2, 89, 92, 84, 69, 89, 92, 8, 68, 80, 22, 25, 87, 90, 21, 19, 5, 67, 88, 94, 93, 81, 81, 10, 1, 16}, "03fd9e995a3d5971", false);
    }

    public FunctionReference(int i) {
        this(i, NO_RECEIVER, null, null, null, 0);
    }

    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.function(this);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && Intrinsics.areEqual(getBoundReceiver(), functionReference.getBoundReceiver()) && Intrinsics.areEqual(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }
}
