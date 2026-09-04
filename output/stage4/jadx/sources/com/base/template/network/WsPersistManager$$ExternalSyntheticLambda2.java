package com.base.template.network;

import androidx.tracing.Trace;
import com.base.template.NativeBridge;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import org.json.JSONException;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class WsPersistManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.$r8$classId) {
            case 0:
                Object obj = WsPersistManager.lock;
                try {
                    Thread.sleep(2000L);
                    if (WsPersistManager.isConnected) {
                        WsPersistManager.sendHeartbeat(WsPersistManager.connectContext);
                    }
                    while (WsPersistManager.isConnected && !Thread.interrupted()) {
                        LongRange longRange = new LongRange(15000L, 40000L);
                        AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                        Thread.sleep(Trace.random(longRange));
                        if (WsPersistManager.isConnected) {
                            WsPersistManager.sendHeartbeat(WsPersistManager.connectContext);
                        }
                    }
                } catch (InterruptedException unused) {
                    return;
                }
                break;
            case 1:
                NativeBridge.triggerRegister();
                NativeBridge.triggerHeartbeat();
                break;
            default:
                int i = AlarmManagerSchedulerBroadcastReceiver.$r8$clinit;
                break;
        }
    }
}
