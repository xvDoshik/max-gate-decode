package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"cast", "T", "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KClasses {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(KClass<T> kClass, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, C0000.decode(new byte[]{14, 23, 89, 92, 75, 10}, "2c1584", 0.0f));
        if (!kClass.isInstance(obj)) {
            throw new ClassCastException(C0000.decode(new byte[]{101, 83, 8, 67, 81, 25, 5, 89, 86, 94, 92, 70, 68, 84, 81, 25, 5, 89, 75, 68, 19, 70, 11, 22}, "32d649f880", 1) + kClass.getQualifiedName());
        }
        Intrinsics.checkNotNull(obj, C0000.decode(new byte[]{15, 76, 93, 88, 69, 86, 5, 13, 92, 10, 16, 22, 3, 6, 19, 85, 0, 74, 69, 20, 17, 90, 68, 13, 93, 11, 73, 88, 20, 15, 95, 22, 21, 64, 65, 81, 69, 97, 68, 12, 84, 69, 15, 89, 21, 15, 90, 88, 79, 75, 84, 82, 9, 80, 7, 23, 28, 46, 39, 90, 0, 16, 64, 83, 18, 23, 82, 85, 22, 65}, "a914e5dc2ed6ac36", true));
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T safeCast(KClass<T> kClass, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, C0000.decode(new byte[]{10, 22, 13, 81, 16, 91}, "6be8ce05f517862e"));
        if (!kClass.isInstance(obj)) {
            return null;
        }
        Intrinsics.checkNotNull(obj, C0000.decode(new byte[]{12, 66, 91, 94, 21, 84, 88, 91, 92, 11, 66, 68, 0, 82, 23, 81, 84, 68, 77, 21, 70, 11, 22, 10, 13, 89, 26, 92, 64, 91, 85, 21, 70, 29, 70, 1, 66, 99, 23, 93, 83, 23, 82, 90, 70, 8, 95, 10, 76, 69, 82, 84, 89, 82, 90, 65, 28, 47, 117, 8, 3, 68, 68, 87, 70, 25, 74, 84, 84, 1, 117, 5, 17, 67}, "b77257952d6d"));
        return obj;
    }
}
