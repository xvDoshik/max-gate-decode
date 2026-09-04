package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements Function1<Class<?>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, C0000.decode(new byte[]{87, 81, 64, 119, 10, 9, 64, 10, 91, 86, 93, 66, 100, 65, 20, 92}, "0444ed0e533608d9"), C0000.decode(new byte[]{2, 3, 65, 32, 94, 8, 66, 89, 15, 4, 92, 70, 49, 31, 69, 6, 25, 76, 126, 92, 0, 23, 83, 29, 9, 7, 91, 4, 30, 38, 94, 87, 18, 18, 9}, "ef5c1e26aa22", 0.0f), 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Class<?> invoke(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, C0000.decode(new byte[]{18, 85}, "be5a0575", 0.0f));
        return cls.getComponentType();
    }
}
