package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DoubleCheck implements Provider {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance;
    public volatile Factory provider;

    public static Provider provider(Factory factory) {
        if (factory instanceof DoubleCheck) {
            return factory;
        }
        DoubleCheck doubleCheck = new DoubleCheck();
        doubleCheck.instance = UNINITIALIZED;
        doubleCheck.provider = factory;
        return doubleCheck;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.instance;
        Object obj3 = UNINITIALIZED;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.instance;
                if (obj == obj3) {
                    obj = this.provider.get();
                    Object obj4 = this.instance;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException(C0000.decode(new byte[]{54, 80, 14, 22, 7, 81, 25, 70, 23, 92, 64, 90, 1, 86, 19, 70, 21, 84, 74, 22, 12, 93, 64, 92, 14, 86, 5, 70, 16, 80, 90, 67, 23, 64, 95, 69, 0, 95, 24, 70, 16, 80, 77, 67, 23, 93, 95, 93, 2, 19, 5, 15, 4, 83, 92, 68, 0, 93, 66, 19, 23, 86, 18, 19, 14, 65, 74, 12, 69}, "e3afb596e363") + obj4 + C0000.decode(new byte[]{25, 18, 22}, "946ef8", true) + obj + C0000.decode(new byte[]{79, 69, 103, 91, 12, 66, 65, 12, 64, 19, 9, 88, 10, 0, 95, 74, 69, 85, 20, 0, 19, 71, 10, 17, 0, 69, 80, 90, 23, 82, 20, 9, 82, 65, 69, 85, 4, 21, 86, 93, 1, 84, 15, 6, 74, 29}, "ae33e1", false));
                    }
                    this.instance = obj;
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
