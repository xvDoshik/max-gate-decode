package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StartStopTokens {
    public final Object lock = new Object();
    public final LinkedHashMap runs = new LinkedHashMap();

    public final StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        synchronized (this.lock) {
            startStopToken = (StartStopToken) this.runs.remove(workGenerationalId);
        }
        return startStopToken;
    }

    public final StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        synchronized (this.lock) {
            try {
                LinkedHashMap linkedHashMap = this.runs;
                Object startStopToken2 = linkedHashMap.get(workGenerationalId);
                if (startStopToken2 == null) {
                    startStopToken2 = new StartStopToken(workGenerationalId);
                    linkedHashMap.put(workGenerationalId, startStopToken2);
                }
                startStopToken = (StartStopToken) startStopToken2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public final List remove(String str) {
        List list;
        synchronized (this.lock) {
            try {
                LinkedHashMap linkedHashMap = this.runs;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (Intrinsics.areEqual(((WorkGenerationalId) entry.getKey()).workSpecId, str)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    this.runs.remove((WorkGenerationalId) it.next());
                }
                list = CollectionsKt.toList(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }
}
