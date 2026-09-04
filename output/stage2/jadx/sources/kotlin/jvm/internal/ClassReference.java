package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010I\u001a\u00020JH\u0002J\u0013\u0010K\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010(\u001a\u0004\b-\u0010\u001eR(\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010(\u001a\u0004\b0\u0010\u001eR\u001c\u00101\u001a\u0004\u0018\u0001028VX\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b7\u0010(\u001a\u0004\b6\u00108R\u001a\u00109\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b9\u00108R\u001a\u0010;\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b<\u0010(\u001a\u0004\b;\u00108R\u001a\u0010=\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b>\u0010(\u001a\u0004\b=\u00108R\u001a\u0010?\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010(\u001a\u0004\b?\u00108R\u001a\u0010A\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bB\u0010(\u001a\u0004\bA\u00108R\u001a\u0010C\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bD\u0010(\u001a\u0004\bC\u00108R\u001a\u0010E\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bF\u0010(\u001a\u0004\bE\u00108R\u001a\u0010G\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bH\u0010(\u001a\u0004\bG\u00108¨\u0006Q"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "error", "", "equals", "other", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    private static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    static {
        int i = 0;
        List listListOf = CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        FUNCTION_CLASSES = MapsKt.toMap(arrayList);
        HashMap<String, String> map = new HashMap<>();
        String strDecode = C0000.decode(new byte[]{0, 12, 92, 92, 1, 3, 95}, "bc30db1c12ff99");
        String strDecode2 = C0000.decode(new byte[]{8, 9, 69, 9, 88, 93, 27, 33, 12, 95, 13, 92, 86, 92}, "cf1e135cc0a972fa", true);
        map.put(strDecode, strDecode2);
        String strDecode3 = C0000.decode(new byte[]{87, 91, 7, 64}, "43f27c82122d7d", true);
        String strDecode4 = C0000.decode(new byte[]{91, 90, 68, 95, 10, 15, 31, 33, 90, 85, 19}, "0503ca1b24ac0d", 0.0f);
        map.put(strDecode3, strDecode4);
        String strDecode5 = C0000.decode(new byte[]{4, 28, 68, 3}, "fe0fe65845ea03d7");
        String strDecode6 = C0000.decode(new byte[]{10, 92, 18, 93, 11, 87, 25, 38, 24, 71, 3}, "a3f1b97d", 3);
        map.put(strDecode5, strDecode6);
        String strDecode7 = C0000.decode(new byte[]{16, 93, 91, 64, 17}, "c542e565ef70");
        String strDecode8 = C0000.decode(new byte[]{95, 12, 77, 95, 95, 12, 74, 101, 92, 12, 75, 71}, "4c936bd6", 5);
        map.put(strDecode7, strDecode8);
        String strDecode9 = C0000.decode(new byte[]{11, 95, 69}, "b11c603b7dfe", false);
        String strDecode10 = C0000.decode(new byte[]{83, 86, 23, 13, 88, 90, 79, 121, 88, 18}, "89ca14a06f", 0.0f);
        map.put(strDecode9, strDecode10);
        String strDecode11 = C0000.decode(new byte[]{84, 92, 10, 80, 66}, "20e168", false);
        String strDecode12 = C0000.decode(new byte[]{88, 10, 69, 9, 90, 11, 79, 115, 94, 13, 83, 16}, "3e1e3ea52b2d", 5);
        map.put(strDecode11, strDecode12);
        String strDecode13 = C0000.decode(new byte[]{89, 90, 13, 1}, "55cf87c676ae", 1);
        String strDecode14 = C0000.decode(new byte[]{89, 10, 65, 95, 89, 12, 72, 125, 90, 94, 2}, "2e530bf150ed", 0.0f);
        map.put(strDecode13, strDecode14);
        String strDecode15 = C0000.decode(new byte[]{1, 92, 67, 82, 91, 82}, "e36077e6bfb037", true);
        String strDecode16 = C0000.decode(new byte[]{91, 87, 71, 85, 80, 87, 30, 124, 92, 76, 91, 85, 85}, "083999", true);
        map.put(strDecode15, strDecode16);
        primitiveFqNames = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(C0000.decode(new byte[]{90, 83, 70, 3, 23, 14, 83, 94, 82, 75, 36, 88, 95, 94, 85, 3, 87}, "020b9b205ef7", 0.0f), strDecode2);
        map2.put(C0000.decode(new byte[]{93, 82, 66, 83, 22, 91, 80, 91, 87, 25, 122, 10, 87, 71, 86, 80, 64, 87, 74}, "73428715079b65"), strDecode4);
        map2.put(C0000.decode(new byte[]{15, 89, 65, 89, 29, 15, 84, 90, 5, 25, 119, 76, 17, 93}, "e8783c54b755", true), strDecode6);
        map2.put(C0000.decode(new byte[]{93, 84, 69, 2, 24, 85, 86, 91, 84, 77, 101, 81, 88, 71, 71}, "753c69", 0.0f), strDecode8);
        map2.put(C0000.decode(new byte[]{83, 87, 19, 81, 26, 84, 89, 8, 1, 24, 45, 89, 67, 6, 94, 83, 23}, "96e0488ff6d77c", true), strDecode10);
        map2.put(C0000.decode(new byte[]{91, 83, 64, 4, 79, 10, 85, 10, 86, 28, 112, 9, 14, 7, 64}, "126eaf4d", 4), strDecode12);
        map2.put(C0000.decode(new byte[]{89, 87, 78, 0, 25, 15, 80, 11, 87, 76, 46, 9, 11, 3}, "368a7c1e0bbfeddd", 0.0f), strDecode14);
        map2.put(C0000.decode(new byte[]{90, 82, 66, 89, 24, 94, 4, 90, 87, 29, 112, 87, 67, 80, 9, 81}, "034862e4"), strDecode16);
        primitiveWrapperFqNames = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put(C0000.decode(new byte[]{15, 3, 66, 7, 77, 95, 89, 88, 81, 72, 120, 4, 82, 93, 6, 22}, "eb4fc3866f7f88", true), C0000.decode(new byte[]{82, 87, 67, 91, 12, 8, 23, 121, 89, 78}, "9877ef"));
        map3.put(C0000.decode(new byte[]{11, 87, 69, 86, 77, 89, 85, 8, 87, 28, 106, 71, 19, 95, 93, 80}, "a637c54f0293", 7), C0000.decode(new byte[]{92, 90, 76, 8, 10, 91, 25, 102, 76, 22, 10, 91, 80}, "758dc5", true));
        map3.put(C0000.decode(new byte[]{14, 80, 23, 89, 27, 95, 0, 90, 84, 29, 38, 88, 5, 67, 50, 93, 68, 70, 4, 90, 80, 86}, "d1a853a433e0", false), C0000.decode(new byte[]{95, 94, 21, 92, 92, 95, 76, 122, 13, 7, 70, 98, 4, 65, 64, 84, 12, 90, 0}, "41a051b9ef"));
        map3.put(C0000.decode(new byte[]{89, 2, 68, 88, 26, 14, 84, 95, 94, 76, 103, 11, 64, 86, 67, 3, 87, 93, 92}, "3c294b519b", true), C0000.decode(new byte[]{8, 87, 18, 92, 80, 8, 76, 97, 93, 65, 94, 64, 82, 6, 88, 93}, "c8f09fb553173d48", 3));
        map3.put(C0000.decode(new byte[]{91, 4, 66, 82, 24, 94, 80, 11, 83, 29, 117, 94, 94, 11, 81, 82, 84, 94, 84}, "1e4362", true), C0000.decode(new byte[]{82, 91, 64, 95, 11, 91, 76, 113, 85, 91, 90, 86, 3, 87, 14, 87}, "9443b5b2", 0.0f));
        map3.put(C0000.decode(new byte[]{8, 0, 71, 4, 79, 10, 84, 91, 80, 31, 123, 16, 15, 3, 84, 23}, "ba1eaf55715e"), C0000.decode(new byte[]{8, 86, 64, 15, 80, 15, 27, 125, 19, 85, 7, 83, 69}, "c94c9a53f8e6740e", 0.0f));
        map3.put(C0000.decode(new byte[]{93, 81, 79, 85, 76, 13, 83, 88, 1, 29, 116, 95, 84, 68, 3, 19, 83, 84, 10, 86}, "7094ba26f3", false), C0000.decode(new byte[]{93, 87, 70, 14, 93, 8, 24, 123, 93, 15, 68, 7, 68, 89, 80, 14, 81}, "682b4f"));
        map3.put(C0000.decode(new byte[]{8, 87, 66, 86, 27, 94, 84, 95, 5, 24, 113, 89, 64, 95}, "b6475251", 0.0f), C0000.decode(new byte[]{90, 91, 66, 8, 80, 13, 30, 39, 8, 77, 89}, "146d9c0bf84a59", 0.0f));
        map3.put(C0000.decode(new byte[]{8, 84, 71, 83, 75, 9, 3, 91, 86, 28, 4, 11, 12, 90, 69, 83, 17, 12, 13, 91, 31, 115, 11, 11, 13, 65, 80, 70, 12, 10, 12}, "b512ee", 0.0f), C0000.decode(new byte[]{92, 90, 70, 90, 89, 88, 79, 34, 92, 15, 88, 65, 83, 66, 89, 89, 15}, "752606ac2a", 1));
        map3.put(C0000.decode(new byte[]{83, 89, 71, 4, 31, 88, 88, 86, 86, 75, 120, 64, 92, 74, 80, 7, 93, 81}, "981e14", true), C0000.decode(new byte[]{8, 86, 68, 94, 8, 92, 72, 83, 89, 9, 88, 86, 0, 77, 89, 93, 15, 65, 72, 121, 66, 0, 70, 82, 1, 85, 85}, "c902a2f06e43", 1));
        map3.put(C0000.decode(new byte[]{95, 0, 67, 82, 29, 67, 22, 80, 14, 72, 40, 77, 6, 20, 85, 67, 90, 19}, "5a5336b9bfa9cf47"), C0000.decode(new byte[]{94, 13, 21, 84, 93, 15, 27, 1, 14, 84, 88, 4, 86, 22, 8, 87, 90, 18, 27, 43, 21, 93, 70, 0, 65, 13, 19}, "5ba84a", 0.0f));
        map3.put(C0000.decode(new byte[]{95, 3, 78, 4, 22, 17, 65, 11, 85, 77, 118, 13, 84, 9, 93, 7, 65, 11, 86, 13}, "5b8e8d5b9c", 4), C0000.decode(new byte[]{92, 91, 64, 88, 90, 93, 27, 83, 14, 91, 91, 81, 87, 64, 90, 92, 91, 67, 79, 116, 88, 88, 88, 81, 80, 71, 92, 95, 15}, "74443350a7", 0.0f));
        map3.put(C0000.decode(new byte[]{82, 82, 79, 81, 72, 16, 69, 11, 84, 29, 117, 89, 21, 17}, "8390fe1b", 3), C0000.decode(new byte[]{15, 9, 23, 8, 13, 10, 74, 5, 12, 8, 8, 1, 7, 18, 10, 11, 10, 23, 74, 42, 10, 23, 16}, "dfcddd"));
        map3.put(C0000.decode(new byte[]{89, 84, 65, 84, 28, 68, 76, 81, 91, 29, 49, 4, 71}, "3575218873ba", true), C0000.decode(new byte[]{13, 13, 17, 89, 91, 88, 31, 87, 93, 15, 10, 7, 6, 65, 91, 89, 95, 71, 28, 48, 3, 22}, "fbe526142c", true));
        map3.put(C0000.decode(new byte[]{15, 2, 20, 88, 74, 77, 70, 15, 8, 30, 45, 95, 17, 68, 43, 77, 0, 17, 3, 77, 11, 74}, "ecb9d82fd0a6b0b9", 4), C0000.decode(new byte[]{95, 86, 65, 85, 11, 92, 24, 5, 11, 9, 92, 85, 84, 64, 95, 9, 90, 74, 27, 117, 11, 65, 66, 47, 16, 0, 66, 81, 67, 91, 68}, "4959b26fde00746f", true));
        map3.put(C0000.decode(new byte[]{95, 4, 69, 7, 75, 16, 76, 93, 15, 22, 43, 86, 65}, "5e3fee84c8f71a24", 7), C0000.decode(new byte[]{83, 95, 16, 93, 81, 15, 79, 83, 93, 94, 84, 85, 7, 69, 81, 14, 15, 67, 28, ByteCompanionObject.MAX_VALUE, 89, 64}, "80d18aa022", true));
        map3.put(C0000.decode(new byte[]{14, 81, 18, 89, 30, 70, 64, 95, 8, 26, 120, 2, 21, 70, 33, 94, 16, 74, 73}, "d0d80346d45ceb", 0.0f), C0000.decode(new byte[]{82, 87, 21, 9, 90, 88, 23, 91, 14, 9, 95, 83, 90, 76, 8, 10, 93, 69, 23, 117, 0, 21, 29, 115, 87, 76, 19, 28}, "98ae36", 0.0f));
        map3.put(C0000.decode(new byte[]{83, 12, 68, 9, 12, 90, 79, 89, 23, 14, 30, 81, 86, 23, 85, 23, 11, 85, 13, 29, 50, 23, 66, 81, 86, 4, 115, 10, 8, 68, 0, 93, 8, 12, 94, 119, 90, 9, 85, 6, 17}, "8c0ee4a3ac08", 0.0f), C0000.decode(new byte[]{9, 14, 66, 95, 15, 87, 26, 54, 66, 70, 89, 94, 3, 25, 112, 93, 15, 17, 87, 93, 15, 86, 90}, "ba63f94e6400d732", 0.0f));
        map3.put(C0000.decode(new byte[]{14, 92, 65, 10, 88, 87, 24, 15, 71, 9, 75, 90, 91, 18, 84, 75, 88, 4, 93, 74, 32, 93, 64, 11, 114, 86, 91, 21, 80, 10, 12, 92, 91, 41, 83, 83, 83, 6, 69}, "e35f196e1d"), C0000.decode(new byte[]{92, 88, 16, 8, 8, 92, 23, 116, 89, 66, 9, 74, 34, 93, 84, 65, 86, 89, 13, 11, 15}, "77dda291"));
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, C0000.decode(new byte[]{13, 81, 0, 76, 76, 78, 0, 88, 68, 83, 22, 6, 73, 22, 79, 26, 24}, "16e8a8a4", 0.0f));
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{10, 93, 70, 95, 8, 10, 75, 95, 66, 15, 76, 81, 15, 70, 87, 65, 15, 5, 9, 27}, "a223ade54bb8", 4));
            Intrinsics.checkNotNull(str);
            Pair pair = TuplesKt.to(sb.append(StringsKt.substringAfterLast$default(str, '.', (String) null, 2, (Object) null)).append(C0000.decode(new byte[]{123, 95, 89, 22, 87, 13, 95, 9, 93, 44, 81, 14, 93, 83, 69}, "804f6c6f3c3d8011")).toString(), str + C0000.decode(new byte[]{27, 117, 14, 15, 73, 7, 92, 10, 90, 88}, "56ab9f2c", 0.0f));
            map3.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            map3.put(entry.getKey().getName(), C0000.decode(new byte[]{9, 89, 64, 84, 13, 12, 72, 115, 23, 13, 5, 65, 11, 89, 90}, "b648dbf5bcf5") + entry.getValue().intValue());
        }
        classFqNames = map3;
        HashMap<String, String> map4 = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        Iterator<T> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            Intrinsics.checkNotNull(str2);
            linkedHashMap.put(key, StringsKt.substringAfterLast$default(str2, '.', (String) null, 2, (Object) null));
        }
        simpleNames = linkedHashMap;
    }

    public ClassReference(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, C0000.decode(new byte[]{91, 116, 9, 82, 66, 68}, "17e317c9"));
        this.jClass = cls;
    }

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void isValue$annotations() {
    }

    public String toString() {
        return getJClass() + C0000.decode(new byte[]{66, 78, 42, 93, 77, 10, 80, 94, 22, 20, 6, 84, 84, 1, 1, 18, 8, 93, 87, 70, 80, 67, 22, 8, 12, 70, 24, 5, 20, 7, 8, 94, 88, 4, 85, 85, 31}, "bfa29f906fc28d", false);
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return INSTANCE.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return INSTANCE.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        return INSTANCE.isInstance(value, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006R&\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000b0\u000b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "primitiveFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveWrapperFqNames", "classFqNames", "simpleNames", "kotlin.jvm.PlatformType", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getClassQualifiedName(Class<?> jClass) {
            String str;
            Intrinsics.checkNotNullParameter(jClass, C0000.decode(new byte[]{88, 38, 15, 5, 64, 16}, "2ecd3c", false));
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) ClassReference.classFqNames.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) ClassReference.classFqNames.get(componentType.getName())) != null) {
                str2 = str + C0000.decode(new byte[]{112, 16, 70, 3, 24}, "1b4ba5d9", true);
            }
            return str2 == null ? C0000.decode(new byte[]{95, 86, 16, 85, 12, 89, 74, 35, 23, 64, 85, 64}, "49d9e7dbe2", 5) : str2;
        }

        public final String getClassSimpleName(Class<?> jClass) {
            String str;
            Intrinsics.checkNotNullParameter(jClass, C0000.decode(new byte[]{82, 117, 15, 88, 21, 17}, "86c9fb55"));
            String str2 = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (!jClass.isLocalClass()) {
                if (!jClass.isArray()) {
                    String str3 = (String) ClassReference.simpleNames.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
                Class<?> componentType = jClass.getComponentType();
                boolean zIsPrimitive = componentType.isPrimitive();
                String strDecode = C0000.decode(new byte[]{32, 75, 67, 88, 76}, "a9195cb3", true);
                if (zIsPrimitive && (str = (String) ClassReference.simpleNames.get(componentType.getName())) != null) {
                    str2 = str + strDecode;
                }
                return str2 == null ? strDecode : str2;
            }
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNull(simpleName);
                String strSubstringAfter$default = StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + Typography.dollar, (String) null, 2, (Object) null);
                if (strSubstringAfter$default != null) {
                    return strSubstringAfter$default;
                }
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                Intrinsics.checkNotNull(simpleName);
                return StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + Typography.dollar, (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNull(simpleName);
            return StringsKt.substringAfter$default(simpleName, Typography.dollar, (String) null, 2, (Object) null);
        }

        public final boolean isInstance(Object value, Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, C0000.decode(new byte[]{82, 115, 91, 83, 74, 66}, "80729186f3544aa4", 0));
            Map map = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map, C0000.decode(new byte[]{13, 65, 95, 92, 23, 80, 2, 93, 86, 12, 21, 25, 81, 85, 67, 87, 82, 67, 67, 19, 23, 92, 24, 13, 14, 87, 30, 94, 22, 88, 95, 16, 67, 74, 19, 86, 24, 8, 14, 77, 95, 89, 13, 26, 80, 95, 91, 95, 6, 80, 76, 10, 14, 87, 64, 30, 46, 85, 67, 12, 124, 19, 12, 85, 24, 8, 14, 77, 95, 89, 13, 26, 80, 95, 91, 95, 6, 80, 76, 10, 14, 87, 64, 30, 46, 85, 67, 67, 124, 71, 60, 108, 117, 2, 17, 74, 120, 68, 77, 83, 86, 68, 27, 19, 53, 19, 87, 5, 65, 82, 92, 68, 15, 93, 93, 30, 84, 92, 15, 95, 93, 0, 21, 80, 92, 94, 16, 26, 126, 81, 71, 64, 40, 71, 103, 60, 44, 88, 67, 67, 40, 64, 29, 87, 82, 71, 93}, "c43073c38ca930", true));
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return TypeIntrinsics.isFunctionOfArity(value, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass));
            }
            return jClass.isInstance(value);
        }

        private Companion() {
        }
    }
}
