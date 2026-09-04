package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Objects;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Uploader f$0;
    public final /* synthetic */ AutoValue_TransportContext f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Runnable f$3;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda0(Uploader uploader, AutoValue_TransportContext autoValue_TransportContext, int i, Runnable runnable) {
        this.f$0 = uploader;
        this.f$1 = autoValue_TransportContext;
        this.f$2 = i;
        this.f$3 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final AutoValue_TransportContext autoValue_TransportContext = this.f$1;
        final int i = this.f$2;
        Runnable runnable = this.f$3;
        final Uploader uploader = this.f$0;
        SynchronizationGuard synchronizationGuard = uploader.guard;
        try {
            EventStore eventStore = uploader.eventStore;
            Objects.requireNonNull(eventStore);
            ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new CctTransportBackend$$ExternalSyntheticLambda0(5, eventStore));
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader.context.getSystemService(C0000.decode(new byte[]{2, 14, 93, 86, 1, 84, 77, 12, 68, 91, 65, 64}, "aa38d79e2259", false))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda2
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        uploader.workScheduler.schedule(autoValue_TransportContext, i + 1, false);
                        return null;
                    }
                });
            } else {
                uploader.logAndUpdateState(autoValue_TransportContext, i);
            }
        } catch (SynchronizationException unused) {
            uploader.workScheduler.schedule(autoValue_TransportContext, i + 1, false);
        } finally {
            runnable.run();
        }
    }
}
