package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_PersistedEvent {
    public final AutoValue_EventInternal event;
    public final long id;
    public final AutoValue_TransportContext transportContext;

    public AutoValue_PersistedEvent(long j, AutoValue_TransportContext autoValue_TransportContext, AutoValue_EventInternal autoValue_EventInternal) {
        this.id = j;
        this.transportContext = autoValue_TransportContext;
        this.event = autoValue_EventInternal;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_PersistedEvent) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) obj;
            if (this.id == autoValue_PersistedEvent.id && this.transportContext.equals(autoValue_PersistedEvent.transportContext) && this.event.equals(autoValue_PersistedEvent.event)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.id;
        return ((((((int) ((j >>> 32) ^ j)) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003) ^ this.event.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{105, 92, 66, 22, 95, 22, 22, 85, 93, 124, 70, 0, 88, 17, 25, 89, 93, 4}, "990e6eb0", 1));
        sb.append(this.id);
        sb.append(C0000.decode(new byte[]{21, 21, 70, 69, 85, 87, 68, 19, 86, 71, 70, 116, 91, 87, 67, 6, 65, 65, 15}, "9527497c", 0.0f));
        sb.append(this.transportContext);
        sb.append(C0000.decode(new byte[]{78, 65, 83, 71, 84, 95, 23, 15}, "ba6111c296"));
        sb.append(this.event);
        sb.append(C0000.decode(new byte[]{69}, "867e05ea4cf180", true));
        return sb.toString();
    }
}
