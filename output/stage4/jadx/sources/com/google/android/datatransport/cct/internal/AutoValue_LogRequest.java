package com.google.android.datatransport.cct.internal;

import java.util.ArrayList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_LogRequest extends LogRequest {
    public final AutoValue_ClientInfo clientInfo;
    public final ArrayList logEvents;
    public final Integer logSource;
    public final String logSourceName;
    public final long requestTimeMs;
    public final long requestUptimeMs;

    public AutoValue_LogRequest(long j, long j2, AutoValue_ClientInfo autoValue_ClientInfo, Integer num, String str, ArrayList arrayList) {
        QosTier qosTier = QosTier.DEFAULT;
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = autoValue_ClientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
        Object obj2 = QosTier.DEFAULT;
        ArrayList arrayList = autoValue_LogRequest.logEvents;
        String str = autoValue_LogRequest.logSourceName;
        Integer num = autoValue_LogRequest.logSource;
        AutoValue_ClientInfo autoValue_ClientInfo = autoValue_LogRequest.clientInfo;
        if (this.requestTimeMs != autoValue_LogRequest.requestTimeMs || this.requestUptimeMs != autoValue_LogRequest.requestUptimeMs || !this.clientInfo.equals(autoValue_ClientInfo)) {
            return false;
        }
        Integer num2 = this.logSource;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.logSourceName;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return this.logEvents.equals(arrayList) && obj2.equals(obj2);
    }

    public final int hashCode() {
        long j = this.requestTimeMs;
        long j2 = this.requestUptimeMs;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.clientInfo.hashCode()) * 1000003;
        Integer num = this.logSource;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.logSourceName;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.logEvents.hashCode()) * 1000003) ^ QosTier.DEFAULT.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{116, 95, 3, 106, 87, 67, 77, 85, 23, 76, 73, 64, 93, 65, 17, 93, 65, 70, 108, 89, 9, 93, 127, 65, 5}, "80d822", false));
        sb.append(this.requestTimeMs);
        sb.append(C0000.decode(new byte[]{74, 16, 22, 81, 71, 22, 80, 71, 18, 49, 65, 64, 13, 90, 1, 41, 21, 13}, "f0d46c54fd14d7dd"));
        sb.append(this.requestUptimeMs);
        sb.append(C0000.decode(new byte[]{24, 20, 1, 90, 88, 83, 93, 68, 123, 94, 82, 91, 95}, "44b6163020", 0.0f));
        sb.append(this.clientInfo);
        sb.append(C0000.decode(new byte[]{78, 16, 10, 12, 85, 103, 12, 64, 68, 85, 4, 92}, "b0fc24c566aa", false));
        sb.append(this.logSource);
        sb.append(C0000.decode(new byte[]{78, 19, 90, 92, 95, 102, 93, 17, 68, 91, 81, 44, 80, 15, 82, 92}, "b363852d684b1b7a", 0.0f));
        sb.append(this.logSourceName);
        sb.append(C0000.decode(new byte[]{30, 68, 13, 87, 83, 124, 79, 85, 88, 68, 21, 13}, "2da8499060f0", true));
        sb.append(this.logEvents);
        sb.append(C0000.decode(new byte[]{21, 19, 64, 14, 69, 102, 89, 84, 75, 14}, "931a6201", 0.0f));
        sb.append(QosTier.DEFAULT);
        sb.append(C0000.decode(new byte[]{79}, "236858839db7", 0.0f));
        return sb.toString();
    }
}
