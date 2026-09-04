package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0010\n\u0002\b\u0005\u001a\u001f\u0010\u0014\u001a\u00020\u0015\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\t*\u0006\u0012\u0002\b\u00030\u0016¢\u0006\u0002\u0010\u0017\"-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038G¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"-\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"+\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007\"+\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011\";\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"'\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0019*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\";\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\"\u000e\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e*\b\u0012\u0004\u0012\u0002H\u001d0\u001e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"java", "Ljava/lang/Class;", "T", "Lkotlin/reflect/KClass;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaPrimitiveType", "", "getJavaPrimitiveType", "javaObjectType", "getJavaObjectType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "javaClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "annotationClass", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JvmClassMappingKt {
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T t) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{13, 23, 14, 92, 23, 10}, "1cf5d45a485fbe", 4));
        Class<? extends Annotation> clsAnnotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(clsAnnotationType, C0000.decode(new byte[]{84, 10, 95, 13, 70, 80, 77, 91, 11, 10, 53, 74, 69, 1, 25, 76, 28, 31, 16}, "5d1b2192dda3", 3));
        KClass<? extends T> kotlinClass = getKotlinClass(clsAnnotationType);
        Intrinsics.checkNotNull(kotlinClass, C0000.decode(new byte[]{10, 22, 84, 8, 24, 82, 81, 10, 11, 13, 65, 23, 6, 6, 24, 7, 89, 66, 68, 68, 17, 13, 21, 89, 11, 13, 21, 10, 77, 93, 92, 68, 17, 27, 69, 82, 68, 8, 87, 16, 84, 88, 94, 74, 23, 7, 83, 91, 1, 0, 76, 74, 115, 114, 92, 5, 22, 17, 9, 88, 17, 23, 24, 48, 24, 94, 86, 68, 14, 13, 65, 91, 13, 13, 22, 14, 78, 92, 30, 46, 19, 15, 118, 91, 5, 16, 75, 41, 89, 65, 64, 13, 11, 5, 126, 67, 74, 95, 95, 1, 76, 28, 81, 10, 11, 13, 65, 86, 16, 10, 87, 10, 123, 93, 81, 23, 22, 92, 11}, "dc8d810deb57"));
        return kotlinClass;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r4) {
        Intrinsics.checkNotNullParameter(r4, C0000.decode(new byte[]{9, 70, 89, 81, 66, 90}, "52181df22427"));
        Class<E> declaringClass = r4.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, C0000.decode(new byte[]{82, 87, 70, 112, 93, 90, 89, 83, 64, 93, 86, 94, 118, 94, 83, 71, 75, 17, 27, 28, 28, 29}, "522489"));
        return declaringClass;
    }

    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r0) {
    }

    public static final <T> Class<T> getJavaClass(T t) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{11, 21, 10, 8, 67, 14}, "7aba00e80e25b5", false));
        Class<T> cls = (Class<T>) t.getClass();
        Intrinsics.checkNotNull(cls, C0000.decode(new byte[]{8, 16, 94, 90, 25, 2, 85, 94, 88, 9, 68, 24, 6, 92, 70, 6, 83, 69, 77, 65, 64, 95, 22, 8, 95, 86, 73, 87, 19, 9, 94, 22, 77, 24, 68, 85, 22, 12, 81, 78, 5, 23, 10, 4, 92, 81, 23, 34, 88, 81, 69, 21, 12, 108, 68, 86, 0, 69, 89, 89, 77, 13, 93, 94, 24, 12, 70, 85, 74, 115, 16, 8, 113, 90, 88, 18, 71, 125, 87, 22, 64, 81, 10, 94, 45, 17, 28, 10, 94, 4, 64, 29, 92, 7, 70, 89, 39, 85, 7, 22, 65, 8, 7}, "fe269a406f08d9"));
        return cls;
    }

    public static final <T> Class<T> getJavaClass(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, C0000.decode(new byte[]{12, 16, 10, 90, 68, 9}, "0db377", false));
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        Intrinsics.checkNotNull(cls, C0000.decode(new byte[]{10, 77, 89, 90, 69, 81, 0, 91, 90, 92, 68, 65, 84, 7, 68, 91, 84, 69, 17, 18, 21, 90, 20, 93, 95, 15, 27, 12, 17, 84, 89, 22, 17, 75, 17, 80, 20, 89, 81, 23, 87, 76, 8, 89, 91, 81, 75, 113, 13, 84, 71, 64, 12, 53, 22, 13, 2, 24, 94, 89, 17, 94, 8, 91, 26, 89, 70, 12, 24, 40, 18, 85, 118, 90, 4, 65, 18, 120, 85, 67, 64, 8, 88, 5, 47, 76, 27, 10, 2, 87, 21, 24, 94, 82, 70, 0, 8, 92}, "d856e2a5430a6b"));
        return cls;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass kClass) {
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, C0000.decode(new byte[]{95, 67, 94, 15, 69, 12}, "c76f62c665", 0.0f));
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        boolean zIsPrimitive = cls.isPrimitive();
        String strDecode = C0000.decode(new byte[]{10, 17, 90, 92, 69, 90, 87, 94, 87, 92, 66, 23, 80, 80, 17, 7, 5, 23, 66, 16, 17, 86, 22, 94, 86, 93, 27, 89, 71, 89, 93, 68, 16, 29, 70, 85, 69, 83, 87, 70, 88, 29, 90, 86, 92, 82, 31, 39, 8, 5, 69, 67, 89, 109, 22, 95, 95, 19, 93, 88, 70, 89, 88, 10, 74, 14, 64, 93, 75, 115, 64, 93, 122, 95, 87, 68, 65, 120, 80, 20, 20, 13, 88, 87, 46, 77, 24, 12, 94, 86, 66, 26, 88, 84, 71, 5, 43, 6, 92, 85, 6, 77, 98, 73, 73, 86, 8, 9}, "dd60e9609367251d", 0.0f);
        if (!zIsPrimitive) {
            Intrinsics.checkNotNull(cls, strDecode);
            return cls;
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals(C0000.decode(new byte[]{83, 14, 22, 7, 13, 3}, "7aceaf", false))) {
                        cls = (Class<T>) Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals(C0000.decode(new byte[]{89, 89, 77}, "07979f8aa52c", 0.0f))) {
                        cls = (Class<T>) Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals(C0000.decode(new byte[]{87, 64, 18, 85}, "59f09d30", false))) {
                        cls = (Class<T>) Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals(C0000.decode(new byte[]{91, 91, 7, 68}, "83f61657f62e4043"))) {
                        cls = (Class<T>) Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals(C0000.decode(new byte[]{95, 87, 92, 87}, "3820dd74", 1))) {
                        cls = (Class<T>) Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals(C0000.decode(new byte[]{68, 86, 80, 82}, "29961769a471164d"))) {
                        cls = (Class<T>) Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(C0000.decode(new byte[]{82, 86, 95, 85, 85, 0, 15}, "09090aa33e24c2"))) {
                        cls = (Class<T>) Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals(C0000.decode(new byte[]{95, 91, 92, 0, 70}, "973a26419fdc", 0.0f))) {
                        cls = (Class<T>) Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals(C0000.decode(new byte[]{71, 13, 90, 67, 76}, "4e518b293ef1", true))) {
                        cls = (Class<T>) Short.class;
                    }
                    break;
            }
        }
        Intrinsics.checkNotNull(cls, strDecode);
        return cls;
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, C0000.decode(new byte[]{12, 64, 80, 92, 74, 88}, "04859f94d1", 0.0f));
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (cls.isPrimitive()) {
            Intrinsics.checkNotNull(cls, C0000.decode(new byte[]{93, 17, 14, 89, 17, 80, 88, 12, 95, 90, 65, 20, 6, 82, 19, 7, 3, 70, 69, 19, 77, 13, 17, 91, 90, 90, 73, 89, 70, 8, 14, 21, 69, 74, 73, 7, 17, 95, 84, 66, 5, 25, 95, 5, 12, 82, 31, 112, 85, 3, 66, 70, 9, 96, 68, 88, 85, 68, 9, 90, 69, 95, 80, 12, 31, 95, 67, 89, 74, 125, 69, 9, 33, 89, 80, 64, 74, 47, 80, 69, 69, 93, 10, 80, 120, 16, 76, 9, 86, 86, 77, 79, 91, 84, 67, 85, 52, 69, 90, 9, 11, 65, 88, 69, 92, 54, 72, 69, 80, 10, 90}, "3db5139b1554d7"));
            return cls;
        }
        String name = cls.getName();
        if (name == null) {
            return null;
        }
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals(C0000.decode(new byte[]{8, 0, 16, 0, 26, 13, 82, 10, 94, 76, 122, 10, 66, 81, 2, 3, 16}, "bafa4a3d9b3d64ef", 0.0f))) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals(C0000.decode(new byte[]{91, 4, 78, 82, 28, 94, 2, 91, 87, 31, 34, 9, 94, 4, 76}, "1e8322c501de", true))) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals(C0000.decode(new byte[]{93, 86, 68, 81, 26, 89, 2, 92, 94, 25, 100, 14, 87, 19, 71}, "772045c2977f8a35"))) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals(C0000.decode(new byte[]{83, 81, 71, 3, 27, 95, 2, 93, 1, 28, 34, 11, 88, 66, 80, 1, 65, 86, 17}, "901b53c3f2ac", true))) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals(C0000.decode(new byte[]{15, 88, 18, 86, 22, 92, 82, 88, 81, 23, 35, 94, 10, 85, 1, 86, 86}, "e9d7803669a1"))) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals(C0000.decode(new byte[]{94, 2, 20, 2, 74, 88, 5, 11, 2, 28, 33, 76, 64, 6}, "4cbcd4dee2c5", 0.0f))) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals(C0000.decode(new byte[]{94, 7, 70, 88, 75, 89, 88, 86, 2, 25, 40, 12, 8, 95}, "4f09e598e7dcf8", 0.0f))) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals(C0000.decode(new byte[]{83, 80, 68, 84, 76, 89, 81, 91, 94, 31, 100, 90, 11, 81}, "9125b505"))) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals(C0000.decode(new byte[]{11, 80, 65, 3, 75, 15, 0, 92, 80, 75, 119, 10, 20, 83, 91, 7}, "a17beca27e3e"))) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, C0000.decode(new byte[]{11, 16, 12, 12, 71, 9}, "7dde47", 5));
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, C0000.decode(new byte[]{15, 16, 11, 88, 18, 92}, "3dc1ab24cc22133b"));
        Class<KClass<T>> cls = (Class<KClass<T>>) kClass.getClass();
        Intrinsics.checkNotNull(cls, C0000.decode(new byte[]{10, 65, 84, 91, 68, 86, 0, 92, 88, 11, 17, 70, 80, 86, 70, 7, 5, 71, 76, 23, 16, 90, 65, 92, 89, 10, 72, 8, 71, 95, 10, 68, 16, 77, 72, 82, 68, 95, 0, 68, 87, 74, 9, 7, 92, 84, 72, 39, 8, 85, 75, 68, 88, 94, 14, 70, 90, 13, 11, 72, 64, 86, 0, 8, 1, 87, 76, 25, 47, 118, 13, 83, 69, 23, 89, 50, 18, 92, 0, 68, 15, 91, 76, 91, 13, 91, 79, 88, 64, 9, 75, 44, 68, 94, 37, 8, 5, 71, 75, 122, 5, 69, 17, 91, 88, 3, 46, 18, 28, 15, 1, 1, 16, 25, 82, 86, 18, 84, 34, 94, 87, 23, 22, 88, 12, 13}, "d487d5a26def23fd", true));
        return cls;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{9, 71, 13, 95, 23, 6}, "53e6d84c85672f", 0.0f));
        Intrinsics.reifiedOperationMarker(4, C0000.decode(new byte[]{101}, "157d74a340", 0.0f));
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }
}
