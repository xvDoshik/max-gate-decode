package com.google.android.datatransport.runtime;

import java.util.HashMap;
import java.util.Map;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_EventInternal {
    public final Map autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, HashMap map) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = map;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_EventInternal) {
            AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj;
            Integer num2 = autoValue_EventInternal.code;
            if (this.transportName.equals(autoValue_EventInternal.transportName) && ((num = this.code) != null ? num.equals(num2) : num2 == null) && this.encodedPayload.equals(autoValue_EventInternal.encodedPayload) && this.eventMillis == autoValue_EventInternal.eventMillis && this.uptimeMillis == autoValue_EventInternal.uptimeMillis && this.autoMetadata.equals(autoValue_EventInternal.autoMetadata)) {
                return true;
            }
        }
        return false;
    }

    public final String get(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        return str2 == null ? "" : str2;
    }

    public final int getInteger(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final int hashCode() {
        int iHashCode = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003;
        long j = this.eventMillis;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.uptimeMillis;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    public final Request toBuilder() {
        Request request = new Request();
        String str = this.transportName;
        if (str == null) {
            throw new NullPointerException(C0000.decode(new byte[]{124, 76, 94, 15, 17, 23, 68, 87, 92, 74, 66, 12, 67, 23, 120, 87, 95, 92}, "292c1c66"));
        }
        request.method = str;
        request.url = this.code;
        EncodedPayload encodedPayload = this.encodedPayload;
        if (encodedPayload == null) {
            throw new NullPointerException(C0000.decode(new byte[]{42, 77, 8, 15, 66, 85, 92, 85, 90, 93, 1, 92, 52, 2, 27, 92, 93, 87, 81}, "d8dcb02659"));
        }
        request.headers = encodedPayload;
        request.body = Long.valueOf(this.eventMillis);
        request.tags = Long.valueOf(this.uptimeMillis);
        request.lazyCacheControl = new HashMap(this.autoMetadata);
        return request;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{118, 21, 81, 93, 65, 45, 86, 23, 87, 20, 93, 2, 88, 72, 65, 22, 89, 13, 65, 22, 92, 17, 64, 125, 84, 9, 93, 94}, "3c435d8c2f"));
        sb.append(this.transportName);
        sb.append(C0000.decode(new byte[]{73, 22, 0, 92, 1, 86, 5}, "e6c3e38dfeb6", false));
        sb.append(this.code);
        sb.append(C0000.decode(new byte[]{77, 68, 93, 12, 84, 93, 6, 83, 5, 52, 89, 27, 91, 93, 3, 82, 92}, "ad8b72b6"));
        sb.append(this.encodedPayload);
        sb.append(C0000.decode(new byte[]{26, 16, 1, 69, 83, 13, 64, 125, 88, 9, 90, 89, 23, 14}, "60d36c401e", 0));
        sb.append(this.eventMillis);
        sb.append(C0000.decode(new byte[]{25, 68, 76, 66, 68, 11, 9, 3, 120, 13, 85, 94, 89, 17, 89}, "5d920bdf"));
        sb.append(this.uptimeMillis);
        sb.append(C0000.decode(new byte[]{29, 20, 3, 67, 65, 88, 44, 0, 77, 2, 85, 85, 22, 87, 8}, "14b657ae9c", 1));
        sb.append(this.autoMetadata);
        sb.append(C0000.decode(new byte[]{72}, "5f8c031cc3d750"));
        return sb.toString();
    }
}
