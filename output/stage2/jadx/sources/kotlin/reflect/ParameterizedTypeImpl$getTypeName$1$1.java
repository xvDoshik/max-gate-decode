package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements Function1<Type, String> {
    public static final ParameterizedTypeImpl$getTypeName$1$1 INSTANCE = new ParameterizedTypeImpl$getTypeName$1$1();

    ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, C0000.decode(new byte[]{18, 78, 73, 3, 54, 91, 98, 17, 20, 94, 87, 1}, "f79fb41e", false), C0000.decode(new byte[]{23, 74, 69, 4, 96, 13, 101, 68, 17, 90, 91, 6, 28, 46, 92, 81, 21, 82, 26, 13, 85, 12, 81, 31, 17, 86, 83, 13, 81, 1, 66, 31, 55, 74, 69, 4, 15, 75, 122, 90, 2, 69, 84, 78, 88, 3, 88, 87, 76, 96, 65, 19, 93, 12, 81, 11}, "c35a4b60", 0.0f), 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Type type) {
        Intrinsics.checkNotNullParameter(type, C0000.decode(new byte[]{19, 86}, "cfe698f52418a1", true));
        return TypesJVMKt.typeToString(type);
    }
}
