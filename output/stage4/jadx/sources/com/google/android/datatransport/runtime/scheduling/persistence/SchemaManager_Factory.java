package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SchemaManager_Factory implements Factory {
    public final /* synthetic */ int $r8$classId;
    public final Provider contextProvider;

    public /* synthetic */ SchemaManager_Factory(Provider provider, int i) {
        this.$r8$classId = i;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return new SchemaManager((Context) this.contextProvider.get(), C0000.decode(new byte[]{0, 10, 85, 24, 6, 89, 93, 3, 93, 3, 23, 81, 13, 1, 74, 89, 8, 82, 28, 0, 80, 18, 88, 68, 17, 4, 86, 69, 17, 89, 64, 16, 31, 3, 79, 85, 13, 17, 75}, "ce86a62d1f90", 0.0f), Integer.valueOf(SchemaManager.SCHEMA_VERSION).intValue());
            default:
                String packageName = ((Context) this.contextProvider.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException(C0000.decode(new byte[]{34, 83, 88, 89, 92, 22, 17, 68, 82, 21, 20, 64, 88, 23, 93, 23, 93, 90, 23, 7, 19, 93, 91, 23, 82, 66, 95, 89, 89, 76, 33, 124, 67, 91, 95, 3, 83, 90, 82, 65, 33, 98, 68, 88, 69, 11, 85, 83, 68, 65, 12, 87, 66, 95, 92, 6}, "a2673b167a"));
        }
    }
}
