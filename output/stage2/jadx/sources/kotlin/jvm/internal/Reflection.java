package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class Reflection {
    private static final KClass[] EMPTY_K_CLASS_ARRAY;
    static final String REFLECTION_NOT_AVAILABLE = C0000.decode(new byte[]{19, 73, ByteCompanionObject.MAX_VALUE, 87, 68, 90, 94, 89, 17, 66, 84, 2, 95, 4, 87, 76, 89, 89, 89, 23, 88, 67, 17, 10, 92, 21, 20, 89, 70, 87, 94, 91, 80, 82, 93, 1, 26}, "3a480677101d", 6);
    private static final ReflectionFactory factory;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName(C0000.decode(new byte[]{14, 9, 21, 15, 10, 13, 74, 65, 0, 0, 13, 6, 0, 23, 74, 89, 19, 11, 79, 10, 13, 23, 1, 65, 11, 7, 13, 77, 49, 6, 2, 95, 0, 5, 21, 10, 12, 13, 34, 82, 6, 18, 14, 17, 26, 42, 9, 67, 9}, "efacccd3", false)).newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        factory = reflectionFactory;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return factory.getOrCreateKotlinPackage(cls, "");
    }

    public static KClass createKotlinClass(Class cls) {
        return factory.createKotlinClass(cls);
    }

    public static KClass createKotlinClass(Class cls, String str) {
        return factory.createKotlinClass(cls, str);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return factory.getOrCreateKotlinPackage(cls, str);
    }

    public static KClass getOrCreateKotlinClass(Class cls) {
        return factory.getOrCreateKotlinClass(cls);
    }

    public static KClass getOrCreateKotlinClass(Class cls, String str) {
        return factory.getOrCreateKotlinClass(cls, str);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return EMPTY_K_CLASS_ARRAY;
        }
        KClass[] kClassArr = new KClass[length];
        for (int i = 0; i < length; i++) {
            kClassArr[i] = getOrCreateKotlinClass(clsArr[i]);
        }
        return kClassArr;
    }

    public static String renderLambdaToString(Lambda lambda) {
        return factory.renderLambdaToString(lambda);
    }

    public static String renderLambdaToString(FunctionBase functionBase) {
        return factory.renderLambdaToString(functionBase);
    }

    public static KFunction function(FunctionReference functionReference) {
        return factory.function(functionReference);
    }

    public static KProperty0 property0(PropertyReference0 propertyReference0) {
        return factory.property0(propertyReference0);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return factory.mutableProperty0(mutablePropertyReference0);
    }

    public static KProperty1 property1(PropertyReference1 propertyReference1) {
        return factory.property1(propertyReference1);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return factory.mutableProperty1(mutablePropertyReference1);
    }

    public static KProperty2 property2(PropertyReference2 propertyReference2) {
        return factory.property2(propertyReference2);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return factory.mutableProperty2(mutablePropertyReference2);
    }

    public static KType typeOf(KClassifier kClassifier) {
        return factory.typeOf(kClassifier, Collections.emptyList(), false);
    }

    public static KType typeOf(Class cls) {
        return factory.typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), false);
    }

    public static KType typeOf(Class cls, KTypeProjection kTypeProjection) {
        return factory.typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(kTypeProjection), false);
    }

    public static KType typeOf(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        ReflectionFactory reflectionFactory = factory;
        KClass orCreateKotlinClass = getOrCreateKotlinClass(cls);
        KTypeProjection[] kTypeProjectionArr = new KTypeProjection[2];
        kTypeProjectionArr[0] = kTypeProjection;
        kTypeProjectionArr[1] = kTypeProjection2;
        return reflectionFactory.typeOf(orCreateKotlinClass, Arrays.asList(kTypeProjectionArr), false);
    }

    public static KType typeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        return factory.typeOf(getOrCreateKotlinClass(cls), ArraysKt.toList(kTypeProjectionArr), false);
    }

    public static KType nullableTypeOf(KClassifier kClassifier) {
        return factory.typeOf(kClassifier, Collections.emptyList(), true);
    }

    public static KType nullableTypeOf(Class cls) {
        return factory.typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), true);
    }

    public static KType nullableTypeOf(Class cls, KTypeProjection kTypeProjection) {
        return factory.typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(kTypeProjection), true);
    }

    public static KType nullableTypeOf(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        ReflectionFactory reflectionFactory = factory;
        KClass orCreateKotlinClass = getOrCreateKotlinClass(cls);
        KTypeProjection[] kTypeProjectionArr = new KTypeProjection[2];
        kTypeProjectionArr[0] = kTypeProjection;
        kTypeProjectionArr[1] = kTypeProjection2;
        return reflectionFactory.typeOf(orCreateKotlinClass, Arrays.asList(kTypeProjectionArr), true);
    }

    public static KType nullableTypeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        return factory.typeOf(getOrCreateKotlinClass(cls), ArraysKt.toList(kTypeProjectionArr), true);
    }

    public static KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        return factory.typeParameter(obj, str, kVariance, z);
    }

    public static void setUpperBounds(KTypeParameter kTypeParameter, KType kType) {
        factory.setUpperBounds(kTypeParameter, Collections.singletonList(kType));
    }

    public static void setUpperBounds(KTypeParameter kTypeParameter, KType... kTypeArr) {
        factory.setUpperBounds(kTypeParameter, ArraysKt.toList(kTypeArr));
    }

    public static KType platformType(KType kType, KType kType2) {
        return factory.platformType(kType, kType2);
    }

    public static KType mutableCollectionType(KType kType) {
        return factory.mutableCollectionType(kType);
    }

    public static KType nothingType(KType kType) {
        return factory.nothingType(kType);
    }
}
