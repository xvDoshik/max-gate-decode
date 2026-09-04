package com.google.firebase.messaging;

import android.content.Context;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.cloudmessaging.zzac;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ServiceStarter implements Factory {
    public static ServiceStarter instance;
    public Object firebaseMessagingServiceClassName;
    public Object hasAccessNetworkStatePermission;
    public Object hasWakeLockPermission;
    public Object messagingEvents;

    public static synchronized ServiceStarter getInstance() {
        try {
            if (instance == null) {
                ServiceStarter serviceStarter = new ServiceStarter();
                serviceStarter.firebaseMessagingServiceClassName = null;
                serviceStarter.hasWakeLockPermission = null;
                serviceStarter.hasAccessNetworkStatePermission = null;
                serviceStarter.messagingEvents = new ArrayDeque();
                instance = serviceStarter;
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new Dispatcher((Executor) ((Provider) this.firebaseMessagingServiceClassName).get(), (EventStore) ((Provider) this.hasWakeLockPermission).get(), (WorkTagDao_Impl) ((zzac) this.hasAccessNetworkStatePermission).get(), (SynchronizationGuard) ((Provider) this.messagingEvents).get());
    }

    public boolean hasAccessNetworkStatePermission(Context context) {
        if (((Boolean) this.hasAccessNetworkStatePermission) == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission(C0000.decode(new byte[]{83, 95, 82, 19, 9, 88, 84, 27, 64, 85, 71, 93, 80, 65, 65, 88, 89, 15, 72, 112, 115, 118, 117, 99, 102, 111, 119, 119, 102, 102, 121, 51, 45, 110, 99, 97, 113, 100, 112}, "216af105005092", 2)) == 0);
        }
        ((Boolean) this.hasWakeLockPermission).booleanValue();
        return ((Boolean) this.hasAccessNetworkStatePermission).booleanValue();
    }

    public boolean hasWakeLockPermission(Context context) {
        if (((Boolean) this.hasWakeLockPermission) == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission(C0000.decode(new byte[]{89, 92, 93, 22, 9, 91, 81, 22, 69, 85, 74, 95, 80, 23, 21, 91, 90, 86, 27, 103, 121, 121, 124, 59, 42, 125, 118, 115}, "829df25850")) == 0);
        }
        ((Boolean) this.hasWakeLockPermission).booleanValue();
        return ((Boolean) this.hasWakeLockPermission).booleanValue();
    }
}
