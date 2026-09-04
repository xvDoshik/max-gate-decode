package okhttp3.internal.platform.android;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.EmptyMap;
import okhttp3.OkHttpClient;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AndroidLog {
    public static final CopyOnWriteArraySet configuredLoggers = new CopyOnWriteArraySet();
    public static final Map knownLoggers;

    static {
        Map mapSingletonMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, C0000.decode(new byte[]{43, 10, 122, 70, 68, 73}, "da220974046f0b"));
        }
        linkedHashMap.put(OkHttpClient.class.getName(), C0000.decode(new byte[]{95, 8, 81, 65, 17, 67, 75, 123, 15, 113, 18, 64, 64, 32, 85, 92, 0, 93, 17}, "0c95e3e4d9f4"));
        linkedHashMap.put(Http2.class.getName(), C0000.decode(new byte[]{87, 13, 13, 71, 23, 18, 30, 127, 17, 69, 20, 2}, "8fe3cb07e1d0", 7));
        linkedHashMap.put(TaskRunner.class.getName(), C0000.decode(new byte[]{86, 89, 89, 66, 76, 20, 29, 97, 83, 64, 95, 97, 76, 92, 95, 83, 74}, "92168d352343", 0.0f));
        linkedHashMap.put(C0000.decode(new byte[]{89, 10, 93, 66, 70, 73, 81, 22, 8, 87, 85, 10, 66, 83, 80, 74, 7, 74, 19, 93, 68, 79, 120, 89, 81, 82, 53, 93, 7, 107, 83, 19, 67, 83, 64}, "6a5629b8e8", true), C0000.decode(new byte[]{9, 83, 9, 17, 69, 68, 75, 126, 9, 91, 10, 50, 84, 86, 54, 86, 20, 78, 4, 23}, "f8ae14e3", 3));
        int size = linkedHashMap.size();
        if (size == 0) {
            mapSingletonMap = EmptyMap.INSTANCE;
        } else if (size != 1) {
            mapSingletonMap = new LinkedHashMap(linkedHashMap);
        } else {
            Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
            mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        }
        knownLoggers = mapSingletonMap;
    }
}
