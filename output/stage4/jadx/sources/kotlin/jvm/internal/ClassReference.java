package kotlin.jvm.internal;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase$query$cursorFactory$1;
import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.io.CloseableKt;
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
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ClassReference implements KClass, ClassBasedDeclarationContainer {
    public static final Map FUNCTION_CLASSES;
    public static final LinkedHashMap simpleNames;
    public final Class jClass;

    static {
        Map mapSingletonMap;
        List listListOf = CollectionsKt__CollectionsKt.listOf(Function0.class, Function1.class, Function2.class, WorkConstraintsTracker$track$$inlined$combine$1$3.class, FrameworkSQLiteDatabase$query$cursorFactory$1.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf));
        int i = 0;
        int i2 = 0;
        for (Object obj : listListOf) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException(C0000.decode(new byte[]{113, 90, 1, 86, 65, 68, 87, 66, 0, 65, 95, 8, 87, 67, 69, 91, 88, 23, 24, 92, 4, 67, 73, 1, 86, 81, 1, 29}, "84e39d", 3));
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        int size = arrayList.size();
        if (size == 0) {
            mapSingletonMap = EmptyMap.INSTANCE;
        } else if (size != 1) {
            mapSingletonMap = new LinkedHashMap(CloseableKt.mapCapacity(arrayList.size()));
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                Pair pair = (Pair) obj2;
                mapSingletonMap.put(pair.first, pair.second);
            }
        } else {
            Pair pair2 = (Pair) arrayList.get(0);
            mapSingletonMap = Collections.singletonMap(pair2.first, pair2.second);
        }
        FUNCTION_CLASSES = mapSingletonMap;
        HashMap map = new HashMap();
        String strDecode = C0000.decode(new byte[]{6, 12, 87, 90, 84, 83, 15}, "dc8612aa");
        String strDecode2 = C0000.decode(new byte[]{13, 88, 64, 85, 93, 87, 31, 32, 9, 88, 88, 92, 85, 87}, "f749491b", 5);
        map.put(strDecode, strDecode2);
        String strDecode3 = C0000.decode(new byte[]{83, 11, 84, 23}, "0c5eee", 0.0f);
        String strDecode4 = C0000.decode(new byte[]{88, 90, 21, 93, 11, 94, 24, 119, 91, 84, 19}, "35a1b064");
        map.put(strDecode3, strDecode4);
        String strDecode5 = C0000.decode(new byte[]{82, 76, 76, 81}, "05847fc5", 6);
        String strDecode6 = C0000.decode(new byte[]{88, 95, 71, 14, 81, 93, 24, 33, 24, 17, 82}, "303b836cae71");
        map.put(strDecode5, strDecode6);
        String strDecode7 = C0000.decode(new byte[]{70, 93, 90, 70, 18}, "5554f529fc45eaae", 0.0f);
        String strDecode8 = C0000.decode(new byte[]{13, 89, 65, 15, 92, 13, 25, 98, 91, 92, 23, 22}, "f65c5c7133eb", true);
        map.put(strDecode7, strDecode8);
        String strDecode9 = C0000.decode(new byte[]{11, 93, 66}, "b36ad0db", true);
        String strDecode10 = C0000.decode(new byte[]{88, 86, 68, 10, 90, 8, 30, 123, 95, 66}, "390f3f0216fe33", 1);
        map.put(strDecode9, strDecode10);
        String strDecode11 = C0000.decode(new byte[]{82, 9, 94, 7, 68}, "4e1f05", true);
        String strDecode12 = C0000.decode(new byte[]{90, 86, 71, 95, 90, 8, 25, 117, 14, 13, 80, 77}, "19333f73bb", 0.0f);
        map.put(strDecode11, strDecode12);
        String strDecode13 = C0000.decode(new byte[]{85, 94, 91, 2}, "915e0285aa8bf3", 1);
        String strDecode14 = C0000.decode(new byte[]{94, 93, 71, 13, 93, 13, 22, 47, 92, 89, 2}, "523a4c8c37edf3");
        map.put(strDecode13, strDecode14);
        String strDecode15 = C0000.decode(new byte[]{85, 14, 22, 84, 85, 3}, "1ac69fc645", false);
        String strDecode16 = C0000.decode(new byte[]{8, 9, 23, 14, 13, 86, 76, 116, 92, 67, 0, 14, 82}, "cfcbd8b036bb7b", 0.0f);
        map.put(strDecode15, strDecode16);
        HashMap map2 = new HashMap();
        map2.put(C0000.decode(new byte[]{89, 2, 23, 84, 79, 89, 80, 10, 84, 77, 35, 90, 14, 89, 84, 5, 93}, "3ca5a51d", false), strDecode2);
        map2.put(C0000.decode(new byte[]{11, 81, 18, 2, 30, 89, 86, 95, 6, 30, 39, 11, 81, 71, 86, 82, 21, 85, 22}, "a0dc0571", true), strDecode4);
        map2.put(C0000.decode(new byte[]{82, 83, 18, 88, 79, 90, 0, 8, 95, 77, 36, 77, 17, 1}, "82d9a6af8cf4ed89", 0.0f), strDecode6);
        map2.put(C0000.decode(new byte[]{89, 83, 18, 83, 25, 10, 4, 90, 86, 27, 55, 88, 12, 16, 71}, "32d27fe415d0cb", 1), strDecode8);
        map2.put(C0000.decode(new byte[]{83, 7, 20, 82, 72, 15, 85, 86, 6, 28, 42, 90, 77, 3, 5, 86, 20}, "9fb3fc48a2c4", 5), strDecode10);
        map2.put(C0000.decode(new byte[]{14, 82, 79, 83, 28, 10, 0, 13, 95, 24, 34, 95, 86, 83, 70}, "d3922fac86"), strDecode12);
        map2.put(C0000.decode(new byte[]{9, 4, 69, 80, 22, 15, 88, 91, 87, 72, 47, 10, 93, 86}, "ce318c950f", 0.0f), strDecode14);
        map2.put(C0000.decode(new byte[]{90, 84, 69, 86, 24, 10, 81, 91, 84, 25, 114, 9, 69, 87, 95, 82}, "05376f", 0.0f), strDecode16);
        HashMap map3 = new HashMap();
        map3.put(C0000.decode(new byte[]{88, 85, 67, 86, 28, 93, 82, 91, 3, 79, 44, 4, 92, 1, 1, 64}, "24572135dacf6db4", true), C0000.decode(new byte[]{9, 88, 23, 92, 11, 87, 75, 35, 91, 79}, "b7c0b9eb563c461b"));
        map3.put(C0000.decode(new byte[]{93, 89, 79, 7, 74, 93, 82, 91, 2, 30, 102, 17, 69, 81, 87, 1}, "789fd135e05e", 0.0f), C0000.decode(new byte[]{92, 89, 22, 15, 90, 91, 25, 101, 22, 17, 90, 91, 80}, "76bc35", false));
        map3.put(C0000.decode(new byte[]{93, 89, 20, 7, 76, 10, 5, 95, 6, 25, 39, 10, 5, 67, 101, 1, 70, 77, 7, 8, 1, 3}, "78bfbfd1a7dbd16d", 0.0f), C0000.decode(new byte[]{95, 93, 67, 85, 13, 87, 76, 122, 13, 80, 75, 49, 6, 64, 65, 87, 89, 90, 1}, "4279d9b9e19bc1", 4));
        map3.put(C0000.decode(new byte[]{83, 86, 23, 3, 75, 89, 83, 11, 80, 77, 109, 95, 19, 13, 18, 84, 80, 9, 82}, "97abe52e7c"), C0000.decode(new byte[]{10, 88, 77, 92, 88, 86, 79, 99, 81, 66, 94, 79, 0, 85, 85, 85}, "a79018", 1));
        map3.put(C0000.decode(new byte[]{14, 81, 21, 82, 79, 13, 82, 92, 3, 30, 32, 95, 14, 15, 86, 83, 6, 92, 6}, "d0c3aa32", 4), C0000.decode(new byte[]{92, 86, 68, 9, 81, 93, 25, 122, 92, 10, 86, 86, 86, 91, 92, 0}, "790e83", 0.0f));
        map3.put(C0000.decode(new byte[]{89, 86, 65, 84, 79, 89, 80, 91, 84, 25, 121, 64, 12, 87, 84, 71}, "3775a515", 7), C0000.decode(new byte[]{82, 91, 69, 9, 88, 15, 76, 127, 70, 92, 91, 81, 67}, "941e1ab131", 0));
        map3.put(C0000.decode(new byte[]{15, 4, 19, 85, 27, 9, 84, 89, 2, 75, 38, 91, 88, 21, 84, 69, 4, 7, 9, 81}, "eee45e57", 0.0f), C0000.decode(new byte[]{83, 12, 68, 88, 8, 91, 30, 123, 92, 14, 66, 81, 68, 85, 90, 15, 85}, "8c04a5083c2064"));
        map3.put(C0000.decode(new byte[]{95, 80, 16, 4, 26, 95, 7, 86, 87, 25, 112, 95, 19, 8}, "51fe43f807", true), C0000.decode(new byte[]{89, 87, 71, 95, 12, 92, 29, 38, 90, 20, 14}, "2833e23c4acb88", 0));
        map3.put(C0000.decode(new byte[]{82, 83, 64, 86, 31, 88, 80, 93, 83, 28, 81, 8, 12, 88, 76, 83, 66, 94, 94, 90, 31, 114, 90, 92, 95, 18, 3, 67, 81, 93, 88}, "82671413420fb7", false), C0000.decode(new byte[]{94, 94, 17, 92, 13, 86, 75, 36, 12, 92, 12, 18, 4, 18, 92, 94, 11}, "51e0d8eeb2cfef"));
        map3.put(C0000.decode(new byte[]{11, 84, 66, 89, 24, 90, 84, 10, 86, 72, 40, 65, 81, 74, 87, 84, 89, 1}, "a548665d1f", 1), C0000.decode(new byte[]{83, 86, 64, 90, 10, 91, 23, 81, 94, 15, 93, 1, 91, 77, 93, 89, 13, 70, 23, 123, 69, 6, 67, 5, 90, 85, 81}, "8946c5921c1d", 0.0f));
        map3.put(C0000.decode(new byte[]{90, 86, 18, 86, 25, 64, 18, 94, 89, 77, 120, 65, 7, 66, 7, 21, 95, 69}, "07d775f75c15b0fa", 3), C0000.decode(new byte[]{82, 14, 21, 8, 15, 12, 23, 2, 14, 8, 10, 7, 90, 21, 8, 11, 8, 17, 23, 40, 21, 1, 20, 3, 77, 14, 19}, "9aadfb"));
        map3.put(C0000.decode(new byte[]{90, 82, 18, 80, 29, 64, 67, 91, 89, 77, 117, 94, 92, 95, 1, 82, 71, 92, 88, 92}, "03d135725c61", 0.0f), C0000.decode(new byte[]{92, 94, 66, 13, 10, 88, 25, 84, 88, 93, 90, 4, 0, 66, 94, 88, 89, 66, 24, 34, 12, 90, 91, 82, 84, 69, 95, 14, 13}, "716ac677", 0.0f));
        map3.put(C0000.decode(new byte[]{82, 0, 78, 84, 22, 22, 71, 81, 89, 23, 125, 94, 75, 21}, "8a858c385917"), C0000.decode(new byte[]{14, 87, 77, 90, 88, 8, 75, 0, 14, 9, 88, 3, 80, 22, 12, 87, 87, 69, 31, 42, 12, 16, 21}, "e8961fecae4f3b", 5));
        map3.put(C0000.decode(new byte[]{14, 0, 18, 7, 26, 66, 22, 90, 89, 79, 99, 85, 70}, "dadf47b35a0020db", false), C0000.decode(new byte[]{8, 14, 68, 8, 90, 95, 76, 87, 93, 88, 15, 4, 83, 16, 90, 94, 12, 71, 28, 103, 6, 21}, "ca0d31b424", 6));
        map3.put(C0000.decode(new byte[]{15, 82, 71, 88, 72, 68, 17, 90, 93, 23, 42, 88, 22, 71, 120, 77, 3, 67, 4, 71, 94, 75}, "e319f1", true), C0000.decode(new byte[]{13, 86, 18, 10, 12, 86, 27, 87, 89, 88, 10, 0, 83, 77, 15, 86, 8, 21, 75, 116, 92, 71, 66, 125, 18, 0, 66, 88, 18, 86, 20}, "f9ffe85464fe09", 5));
        map3.put(C0000.decode(new byte[]{8, 85, 66, 7, 27, 66, 17, 81, 14, 26, 121, 7, 69}, "b44f57e8", 0.0f), C0000.decode(new byte[]{10, 91, 68, 94, 15, 93, 79, 87, 95, 94, 10, 86, 2, 64, 89, 93, 8, 64, 79, 121, 81, 66}, "a402f3"));
        map3.put(C0000.decode(new byte[]{94, 81, 21, 89, 24, 71, 65, 92, 91, 77, 120, 87, 22, 20, 113, 94, 23, 74, 79}, "40c862557c56f0", 0.0f), C0000.decode(new byte[]{14, 86, 70, 94, 15, 10, 30, 90, 90, 93, 9, 92, 81, 70, 15, 11, 94, 74, 27, 124, 4, 73, 28, 119, 8, 16, 66, 64}, "e922fd0951", false));
        map3.put(C0000.decode(new byte[]{82, 95, 66, 10, 80, 91, 23, 90, 64, 11, 23, 92, 87, 68, 83, 20, 87, 84, 85, 30, 101, 18, 75, 92, 87, 87, 117, 9, 84, 69, 88, 94, 95, 9, 87, 122, 91, 90, 83, 5, 77}, "906f95", true), C0000.decode(new byte[]{89, 89, 65, 14, 80, 15, 28, 101, 65, 16, 80, 15, 85, 24, 118, 13, 84, 17, 83, 88, 92, 13, 87}, "265b9a"));
        map3.put(C0000.decode(new byte[]{9, 91, 17, 91, 95, 92, 76, 94, 19, 90, 24, 91, 12, 64, 0, 69, 88, 83, 14, 26, 32, 89, 67, 95, 33, 91, 8, 71, 87, 92, 11, 91, 11, 120, 84, 88, 7, 87, 17}, "b4e762", 7), C0000.decode(new byte[]{82, 11, 77, 92, 95, 86, 77, 112, 92, 22, 84, 74, 122, 95, 91, 72, 2, 91, 91, 12, 87}, "9d9068c52c"));
        map3.putAll(map);
        map3.putAll(map2);
        for (String str : map.values()) {
            map3.put(C0000.decode(new byte[]{14, 14, 66, 91, 15, 10, 28, 83, 68, 12, 74, 91, 12, 17, 87, 19, 11, 0, 90, 25}, "ea67fd292ad2be2a", 5) + StringsKt.substringAfterLast$default(str) + C0000.decode(new byte[]{123, 88, 84, 70, 80, 91, 12, 87, 95, 125, 90, 93, 92, 85, 69}, "879615e812", 7), str.concat(C0000.decode(new byte[]{27, 119, 87, 12, 65, 87, 86, 92, 95, 94}, "548a168500", 0.0f)));
        }
        for (Map.Entry entry : FUNCTION_CLASSES.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), C0000.decode(new byte[]{13, 89, 68, 15, 95, 8, 74, 37, 19, 88, 83, 23, 95, 9, 10}, "f60c6fdc", false) + iIntValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(CloseableKt.mapCapacity(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt.substringAfterLast$default((String) entry2.getValue()));
        }
        simpleNames = linkedHashMap;
    }

    public ClassReference(Class cls) {
        this.jClass = cls;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ClassReference) && ResultKt.getJavaObjectType(this).equals(ResultKt.getJavaObjectType((KClass) obj));
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.jClass;
    }

    public final int hashCode() {
        return ResultKt.getJavaObjectType(this).hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jClass.toString());
        sb.append(C0000.decode(new byte[]{22, 77, 123, 86, 67, 94, 80, 91, 21, 69, 84, 80, 90, 0, 83, 77, 94, 93, 87, 21, 92, 68, 17, 88, 89, 17, 16, 88, 65, 83, 80, 89, 84, 85, 93, 83, 31}, "6e0972955716", false));
        return sb.toString();
    }
}
