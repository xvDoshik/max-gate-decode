package androidx.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public final Data merge(ArrayList arrayList) throws Throwable {
        ConnectionPool connectionPool = new ConnectionPool(7);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            linkedHashMap.putAll(Collections.unmodifiableMap(((Data) obj).mValues));
        }
        connectionPool.putAll(linkedHashMap);
        Data data = new Data((HashMap) connectionPool.delegate);
        Data.toByteArrayInternal(data);
        return data;
    }
}
