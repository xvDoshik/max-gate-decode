package kotlin.jvm.internal;

import java.io.Serializable;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Lambda implements FunctionBase, Serializable {
    public final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    public final String toString() {
        Reflection.factory.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        return string.startsWith(C0000.decode(new byte[]{91, 87, 71, 84, 12, 15, 30, 82, 69, 85, 75, 7, 69, 86, 80, 76, 12, 14, 94, 75, 29}, "0838ea", false)) ? string.substring(21) : string;
    }
}
