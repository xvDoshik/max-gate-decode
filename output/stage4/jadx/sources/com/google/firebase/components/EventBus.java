package com.google.firebase.components;

import androidx.tracing.Trace;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EventBus implements Subscriber, Publisher {
    public final UiExecutor defaultExecutor;
    public final HashMap handlerMap;
    public ArrayDeque pendingEvents;

    public EventBus() {
        UiExecutor uiExecutor = UiExecutor.INSTANCE;
        this.handlerMap = new HashMap();
        this.pendingEvents = new ArrayDeque();
        this.defaultExecutor = uiExecutor;
    }

    public final void subscribe(TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0) {
        UiExecutor uiExecutor = this.defaultExecutor;
        synchronized (this) {
            try {
                uiExecutor.getClass();
                if (!this.handlerMap.containsKey(Trace.class)) {
                    this.handlerMap.put(Trace.class, new ConcurrentHashMap());
                }
                ((ConcurrentHashMap) this.handlerMap.get(Trace.class)).put(transportImpl$$ExternalSyntheticLambda0, uiExecutor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
