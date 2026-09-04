package kotlin.jvm.internal;

import java.util.List;
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
public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = C0000.decode(new byte[]{90, 94, 76, 92, 89, 86, 74, 88, 79, 93, 72, 95, 68, 88, 82, 69, 81, 95, 94, 75, 74}, "118008d290f916");

    public KFunction function(FunctionReference functionReference) {
        return functionReference;
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public KProperty0 property0(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 property1(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KProperty2 property2(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String renderLambdaToString(FunctionBase functionBase) {
        String string = functionBase.getClass().getGenericInterfaces()[0].toString();
        String strDecode = C0000.decode(new byte[]{91, 11, 77, 10, 95, 91, 29, 14, 70, 9, 23, 0, 67, 91, 80, 16, 89, 11, 87, 21, 24}, "0d9f653d", true);
        return string.startsWith(strDecode) ? string.substring(strDecode.length()) : string;
    }

    public KClass createKotlinClass(Class cls) {
        return new ClassReference(cls);
    }

    public KClass createKotlinClass(Class cls, String str) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    public KClass getOrCreateKotlinClass(Class cls) {
        return new ClassReference(cls);
    }

    public KClass getOrCreateKotlinClass(Class cls, String str) {
        return new ClassReference(cls);
    }

    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    public KType typeOf(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return new TypeReference(kClassifier, list, z);
    }

    public KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        return new TypeParameterReference(obj, str, kVariance, z);
    }

    public void setUpperBounds(KTypeParameter kTypeParameter, List<KType> list) {
        ((TypeParameterReference) kTypeParameter).setUpperBounds(list);
    }

    public KType platformType(KType kType, KType kType2) {
        return new TypeReference(kType.getClassifier(), kType.getArguments(), kType2, ((TypeReference) kType).getFlags());
    }

    public KType mutableCollectionType(KType kType) {
        TypeReference typeReference = (TypeReference) kType;
        return new TypeReference(kType.getClassifier(), kType.getArguments(), typeReference.getPlatformTypeUpperBound(), typeReference.getFlags() | 2);
    }

    public KType nothingType(KType kType) {
        TypeReference typeReference = (TypeReference) kType;
        return new TypeReference(kType.getClassifier(), kType.getArguments(), typeReference.getPlatformTypeUpperBound(), typeReference.getFlags() | 4);
    }
}
