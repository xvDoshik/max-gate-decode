package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SynchronizedLazyImpl implements Serializable {
    public Lambda initializer;
    public volatile Object _value = UNINITIALIZED_VALUE.INSTANCE;
    public final Object lock = this;

    /* JADX WARN: Multi-variable type inference failed */
    public SynchronizedLazyImpl(Function0 function0) {
        this.initializer = (Lambda) function0;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final Object getValue() {
        Object objInvoke;
        Object obj = this._value;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        if (obj != uninitialized_value) {
            return obj;
        }
        synchronized (this.lock) {
            objInvoke = this._value;
            if (objInvoke == uninitialized_value) {
                objInvoke = this.initializer.invoke();
                this._value = objInvoke;
                this.initializer = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE ? String.valueOf(getValue()) : C0000.decode(new byte[]{116, 5, 28, 75, 24, 20, 81, 14, 66, 87, 19, 93, 91, 64, 24, 13, 8, 91, 76, 11, 81, 14, 94, 72, 86, 87, 20, 77, 93, 16, 72}, "8df28b0b723344", false);
    }
}
