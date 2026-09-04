package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KFunction;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{37, 70, 12, 91, 71, 10, 12, 93, 3, 84, 19, 10, 13, 71, 7, 74, 85, 2, 0, 86, 66, 91, 92, 13, 16, 71, 16, 77, 80, 23, 12, 65, 66, 92, 92, 6, 16, 19, 12, 87, 71, 67, 16, 70, 18, 72, 92, 17, 23, 19, 16, 93, 85, 15, 6, 80, 22, 81, 92, 13}, "c3b83c", 5));
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return C0000.decode(new byte[]{87, 66, 11, 66, 94, 8, 76, 83, 70, 95, 87, 6, 84, 23}, "17eb7f86496e", 0.0f) + this.funInterface.getName();
    }

    public FunInterfaceConstructorReference(Class cls) {
        super(1);
        this.funInterface = cls;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FunInterfaceConstructorReference) {
            return this.funInterface.equals(((FunInterfaceConstructorReference) obj).funInterface);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }
}
