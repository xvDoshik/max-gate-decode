package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import java.util.concurrent.Executor;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TransportRuntime {
    public static volatile DaggerTransportRuntimeComponent instance;
    public final Clock eventClock;
    public final Scheduler scheduler;
    public final Uploader uploader;
    public final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, Dispatcher dispatcher) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler;
        this.uploader = uploader;
        ((Executor) dispatcher.executorServiceOrNull).execute(new CoroutineWorker$$ExternalSyntheticLambda0(9, dispatcher));
    }

    public static TransportRuntime getInstance() {
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = instance;
        if (daggerTransportRuntimeComponent != null) {
            return (TransportRuntime) daggerTransportRuntimeComponent.transportRuntimeProvider.get();
        }
        throw new IllegalStateException(C0000.decode(new byte[]{127, 12, 23, 17, 11, 87, 10, 67, 92, 5, 10, 12, 75, 6, 7, 16}, "1cc1b9c75dfe", 6));
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (instance == null) {
                        PackageManagerWrapper packageManagerWrapper = new PackageManagerWrapper();
                        context.getClass();
                        packageManagerWrapper.zza = context;
                        instance = packageManagerWrapper.build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
