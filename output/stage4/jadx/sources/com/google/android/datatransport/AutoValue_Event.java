package com.google.android.datatransport;

import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_Event {
    public final MessagingClientEventExtension payload;
    public final AutoValue_ProductData productData;

    public AutoValue_Event(MessagingClientEventExtension messagingClientEventExtension, AutoValue_ProductData autoValue_ProductData) {
        this.payload = messagingClientEventExtension;
        this.productData = autoValue_ProductData;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_Event)) {
            return false;
        }
        AutoValue_Event autoValue_Event = (AutoValue_Event) obj;
        AutoValue_ProductData autoValue_ProductData = autoValue_Event.productData;
        if (!this.payload.equals(autoValue_Event.payload)) {
            return false;
        }
        Object obj2 = Priority.DEFAULT;
        return obj2.equals(obj2) && this.productData.equals(autoValue_ProductData);
    }

    public final int hashCode() {
        return this.productData.hashCode() ^ (((((1000003 * 1000003) ^ this.payload.hashCode()) * 1000003) ^ Priority.DEFAULT.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{118, 16, 85, 88, 23, 66, 0, 11, 84, 1, 91, 10, 70, 10, 92, 26, 67, 73, 2, 29, 92, 11, 7, 0, 14}, "3f06c9cd0dfd", 3));
        sb.append(this.payload);
        sb.append(C0000.decode(new byte[]{21, 65, 69, 17, 95, 94, 16, 13, 21, 29, 10}, "9a5c61bdad755c", true));
        sb.append(Priority.DEFAULT);
        sb.append(C0000.decode(new byte[]{21, 18, 69, 64, 92, 1, 64, 2, 68, 116, 89, 21, 7, 5}, "92523e5a008af863", 0.0f));
        sb.append(this.productData);
        sb.append(C0000.decode(new byte[]{31}, "bf3899c9"));
        return sb.toString();
    }
}
