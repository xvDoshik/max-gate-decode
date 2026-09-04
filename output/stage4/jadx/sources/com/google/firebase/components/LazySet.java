package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class LazySet implements Provider {
    public volatile Set actualSet;
    public volatile Set providers;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        if (this.actualSet == null) {
            synchronized (this) {
                try {
                    if (this.actualSet == null) {
                        this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                        synchronized (this) {
                            try {
                                Iterator it = this.providers.iterator();
                                while (it.hasNext()) {
                                    this.actualSet.add(((Provider) it.next()).get());
                                }
                                this.providers = null;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }
}
