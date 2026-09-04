package androidx.startup;

import android.content.Context;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AppInitializer {
    public static volatile AppInitializer sInstance;
    public static final Object sLock = new Object();
    public final Context mContext;
    public final HashSet mDiscovered = new HashSet();
    public final HashMap mInitialized = new HashMap();

    public AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public final void discoverAndInitialize(Bundle bundle) {
        HashSet hashSet;
        String string = this.mContext.getString(2131427328);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.mDiscovered;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    doInitialize((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new StartupException(e);
            }
        }
    }

    public final void doInitialize(Class cls, HashSet hashSet) {
        HashMap map = this.mInitialized;
        String strDecode = C0000.decode(new byte[]{123, 4, 86, 91, 95, 16, 24, 12, 86, 92, 68, 13, 89, 9, 81, 79, 85, 68}, "8e850d");
        if (Trace.isEnabled()) {
            try {
                android.os.Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                android.os.Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException(strDecode + cls.getName() + C0000.decode(new byte[]{27, 24, 39, 73, 90, 15, 80, 24, 0, 85, 77, 6, 86, 76, 1, 84, 23}, "58d09c", 0.0f));
        }
        if (map.containsKey(cls)) {
            map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                Initializer initializer = (Initializer) cls.getDeclaredConstructor(null).newInstance(null);
                initializer.dependencies();
                List<Class> list = Collections.EMPTY_LIST;
                if (!list.isEmpty()) {
                    for (Class cls2 : list) {
                        if (!map.containsKey(cls2)) {
                            doInitialize(cls2, hashSet);
                        }
                    }
                }
                Object objCreate = initializer.create(this.mContext);
                hashSet.remove(cls);
                map.put(cls, objCreate);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        android.os.Trace.endSection();
    }
}
