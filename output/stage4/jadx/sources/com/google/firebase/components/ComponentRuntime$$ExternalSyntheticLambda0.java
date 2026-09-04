package com.google.firebase.components;

import android.os.StrictMode;
import com.google.firebase.concurrent.CustomThreadFactory;
import com.google.firebase.concurrent.DelegatingScheduledExecutorService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class ComponentRuntime$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return Collections.EMPTY_SET;
            case 1:
                return null;
            case 2:
                Lazy lazy = ExecutorsRegistrar.BG_EXECUTOR;
                StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                builderDetectNetwork.detectResourceMismatches();
                builderDetectNetwork.detectUnbufferedIo();
                return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(4, new CustomThreadFactory(C0000.decode(new byte[]{112, 93, 70, 1, 90, 80, 74, 86, 69, 113, 88, 80, 9, 80, 68, 91, 65, 10, 92}, "644d8193e393b7"), 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.SCHEDULER.get());
            case 3:
                Lazy lazy2 = ExecutorsRegistrar.BG_EXECUTOR;
                return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new CustomThreadFactory(C0000.decode(new byte[]{112, 94, 68, 93, 85, 89, 69, 82, 22, 116, 94, 76, 83}, "676878", 5), 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.SCHEDULER.get());
            case 4:
                Lazy lazy3 = ExecutorsRegistrar.BG_EXECUTOR;
                return new DelegatingScheduledExecutorService(Executors.newCachedThreadPool(new CustomThreadFactory(C0000.decode(new byte[]{32, 10, 23, 84, 81, 7, 69, 1, 20, 112, 94, 88, 85, 90, 15, 13, 2}, "fce13f6d422761", 7), 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.SCHEDULER.get());
            default:
                Lazy lazy4 = ExecutorsRegistrar.BG_EXECUTOR;
                return Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory(C0000.decode(new byte[]{112, 15, 75, 4, 81, 88, 70, 83, 22, 53, 90, 9, 86, 93, 64, 90, 83, 20}, "6f9a3956", 0.0f), 0, null));
        }
    }
}
