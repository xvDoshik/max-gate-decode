package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CollectionsKt extends CollectionsKt__MutableCollectionsKt {
    public static final void joinTo(Collection collection, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function1 function1) {
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : collection) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            CloseableKt.appendElement(sb, obj, function1);
        }
        sb.append(charSequence3);
    }

    public static String joinToString$default(Collection collection, String str, Function1 function1, int i) {
        if ((i & 1) != 0) {
            str = C0000.decode(new byte[]{31, 16}, "301cf693", false);
        }
        String str2 = str;
        String strDecode = (i & 2) != 0 ? "" : C0000.decode(new byte[]{109}, "67a6b27fde", 0.0f);
        String strDecode2 = (i & 4) == 0 ? C0000.decode(new byte[]{100}, "9607cecd56") : "";
        if ((i & 32) != 0) {
            function1 = null;
        }
        StringBuilder sb = new StringBuilder();
        joinTo(collection, sb, str2, strDecode, strDecode2, function1);
        return sb.toString();
    }

    public static List toList(Iterable iterable) {
        ArrayList arrayList;
        boolean z = iterable instanceof Collection;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return emptyList;
            }
            if (size != 1) {
                return new ArrayList(collection);
            }
            return Collections.singletonList(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        if (z) {
            arrayList = new ArrayList((Collection) iterable);
        } else {
            arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        int size2 = arrayList.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayList : Collections.singletonList(arrayList.get(0));
        }
        return emptyList;
    }
}
