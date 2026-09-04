package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.work.impl.AutoMigration_14_15;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkerWrapper;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory$InstanceHolder;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.api.Api;
import com.google.firebase.messaging.ServiceStarter;
import javax.inject.Provider;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class PackageManagerWrapper {
    public Context zza;

    public DaggerTransportRuntimeComponent build() {
        Context context = this.zza;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + C0000.decode(new byte[]{25, 8, 17, 67, 68, 66, 83, 82, 67, 71, 1, 66}, "9ed00b17c4d670c7"));
        }
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = new DaggerTransportRuntimeComponent();
        daggerTransportRuntimeComponent.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory$InstanceHolder.INSTANCE);
        ConnectionPool connectionPool = new ConnectionPool(12, context);
        daggerTransportRuntimeComponent.setApplicationContextProvider = connectionPool;
        daggerTransportRuntimeComponent.metadataBackendRegistryProvider = DoubleCheck.provider(new WorkLauncherImpl(connectionPool, new ConnectionPool(11, connectionPool)));
        ConnectionPool connectionPool2 = daggerTransportRuntimeComponent.setApplicationContextProvider;
        daggerTransportRuntimeComponent.schemaManagerProvider = new SchemaManager_Factory(connectionPool2, 0);
        Provider provider = DoubleCheck.provider(new Api(daggerTransportRuntimeComponent.schemaManagerProvider, DoubleCheck.provider(new SchemaManager_Factory(connectionPool2, 1)), 4, false));
        daggerTransportRuntimeComponent.sQLiteEventStoreProvider = provider;
        AutoMigration_14_15 autoMigration_14_15 = new AutoMigration_14_15();
        ConnectionPool connectionPool3 = daggerTransportRuntimeComponent.setApplicationContextProvider;
        zzac zzacVar = new zzac(connectionPool3, provider, autoMigration_14_15, 5);
        Provider provider2 = daggerTransportRuntimeComponent.executorProvider;
        Provider provider3 = daggerTransportRuntimeComponent.metadataBackendRegistryProvider;
        Request.Builder builder = new Request.Builder();
        builder.url = provider2;
        builder.method = provider3;
        builder.headers = zzacVar;
        builder.body = provider;
        builder.tags = provider;
        WorkerWrapper.Builder builder2 = new WorkerWrapper.Builder();
        builder2.mAppContext = connectionPool3;
        builder2.mForegroundProcessor = provider3;
        builder2.mWorkTaskExecutor = provider;
        builder2.mConfiguration = zzacVar;
        builder2.mWorkDatabase = provider2;
        builder2.mWorkSpec = provider;
        builder2.mTags = provider;
        ServiceStarter serviceStarter = new ServiceStarter();
        serviceStarter.firebaseMessagingServiceClassName = provider2;
        serviceStarter.hasWakeLockPermission = provider;
        serviceStarter.hasAccessNetworkStatePermission = zzacVar;
        serviceStarter.messagingEvents = provider;
        daggerTransportRuntimeComponent.transportRuntimeProvider = DoubleCheck.provider(new zzac(builder, builder2, serviceStarter, 4));
        return daggerTransportRuntimeComponent;
    }
}
