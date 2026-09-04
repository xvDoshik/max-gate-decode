package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KCallable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CallableReference implements KCallable, Serializable {
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public transient KCallable reflected;
    public final String signature;

    public final class NoReceiver implements Serializable {
        public static final NoReceiver INSTANCE = new NoReceiver();
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    public final ClassBasedDeclarationContainer getOwner() {
        boolean z = this.isTopLevel;
        Class cls = this.owner;
        if (z) {
            Reflection.factory.getClass();
            return new PackageReference(cls);
        }
        Reflection.factory.getClass();
        return new ClassReference(cls);
    }
}
