package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CollectionsKt__CollectionsKt extends CharsKt {
    public static int getLastIndex(List list) {
        return list.size() - 1;
    }

    public static List listOf(Object... objArr) {
        return objArr.length > 0 ? Arrays.asList(objArr) : EmptyList.INSTANCE;
    }

    public static ArrayList listOfNotNull(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static ArrayList mutableListOf(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(objArr, true));
    }
}
