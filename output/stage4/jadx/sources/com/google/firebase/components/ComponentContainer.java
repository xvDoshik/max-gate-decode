package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface ComponentContainer {
    default Object get(Class cls) {
        return get(Qualified.unqualified(cls));
    }

    Provider getProvider(Qualified qualified);

    default Provider getProvider(Class cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    default Set setOf(Qualified qualified) {
        return (Set) setOfProvider(qualified).get();
    }

    Provider setOfProvider(Qualified qualified);

    default Object get(Qualified qualified) {
        Provider provider = getProvider(qualified);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }
}
