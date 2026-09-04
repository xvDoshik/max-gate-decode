package androidx.work;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public final Data merge(ArrayList arrayList) throws Throwable {
        Object objNewInstance;
        ConnectionPool connectionPool = new ConnectionPool(7);
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            for (Map.Entry entry : Collections.unmodifiableMap(((Data) obj).mValues).entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value != null ? value.getClass() : String.class;
                Object obj2 = map.get(str);
                if (obj2 != null) {
                    Class<?> cls2 = obj2.getClass();
                    if (cls2.equals(cls)) {
                        int length = Array.getLength(obj2);
                        int length2 = Array.getLength(value);
                        Object objNewInstance2 = Array.newInstance(obj2.getClass().getComponentType(), length + length2);
                        System.arraycopy(obj2, 0, objNewInstance2, 0, length);
                        System.arraycopy(value, 0, objNewInstance2, length, length2);
                        value = objNewInstance2;
                    } else {
                        if (!Intrinsics.areEqual(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        int length3 = Array.getLength(obj2);
                        objNewInstance = Array.newInstance(cls, length3 + 1);
                        System.arraycopy(obj2, 0, objNewInstance, 0, length3);
                        Array.set(objNewInstance, length3, value);
                        value = objNewInstance;
                    }
                } else if (!cls.isArray()) {
                    objNewInstance = Array.newInstance(cls, 1);
                    Array.set(objNewInstance, 0, value);
                    value = objNewInstance;
                }
                map.put(str, value);
            }
        }
        connectionPool.putAll(map);
        Data data = new Data((HashMap) connectionPool.delegate);
        Data.toByteArrayInternal(data);
        return data;
    }
}
