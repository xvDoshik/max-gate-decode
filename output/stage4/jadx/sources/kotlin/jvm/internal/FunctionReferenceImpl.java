package kotlin.jvm.internal;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import kotlin.Function;
import kotlin.reflect.KCallable;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class FunctionReferenceImpl extends CallableReference implements FunctionBase, KCallable, Function {
    public final int arity;
    public final int flags;

    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        super(CallableReference.NoReceiver.INSTANCE, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = 0;
    }

    public final KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReferenceImpl) {
            FunctionReferenceImpl functionReferenceImpl = (FunctionReferenceImpl) obj;
            return this.name.equals(functionReferenceImpl.name) && this.signature.equals(functionReferenceImpl.signature) && this.flags == functionReferenceImpl.flags && this.arity == functionReferenceImpl.arity && this.receiver.equals(functionReferenceImpl.receiver) && getOwner().equals(functionReferenceImpl.getOwner());
        }
        if (!(obj instanceof FunctionReferenceImpl)) {
            return false;
        }
        KCallable kCallable = this.reflected;
        if (kCallable == null) {
            computeReflected();
            this.reflected = this;
            kCallable = this;
        }
        return obj.equals(kCallable);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    public final int hashCode() {
        getOwner();
        return this.signature.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.name, getOwner().hashCode() * 31, 31);
    }

    public final String toString() {
        KCallable kCallable = this.reflected;
        if (kCallable == null) {
            computeReflected();
            this.reflected = this;
            kCallable = this;
        }
        if (kCallable != this) {
            return kCallable.toString();
        }
        String strDecode = C0000.decode(new byte[]{11, 15, 91, 15, 18, 14}, "7f5ff0e39a56");
        String str = this.name;
        return strDecode.equals(str) ? C0000.decode(new byte[]{87, 88, 11, 65, 68, 71, 23, 85, 68, 12, 17, 21, 26, 127, 91, 67, 9, 91, 94, 21, 16, 83, 86, 15, 6, 86, 70, 93, 91, 89, 69, 91, 67, 21, 12, 89, 68, 67, 2, 67, 83, 93, 88, 86, 7, 94, 85, 28}, "47e205b60cc524", 0.0f) : NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{83, 71, 91, 85, 68, 94, 86, 86, 21}, "52560798", 0.0f), str, C0000.decode(new byte[]{20, 16, 47, 86, 71, 13, 10, 10, 24, 16, 81, 94, 8, 92, 80, 21, 10, 11, 86, 66, 93, 75, 68, 87, 92, 21, 67, 5, 78, 3, 93, 84, 5, 91, 95, 4, 74}, "48d93acd8b", 4));
    }
}
