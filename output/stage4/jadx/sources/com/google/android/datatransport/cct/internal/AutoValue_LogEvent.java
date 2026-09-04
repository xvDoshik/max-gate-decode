package com.google.android.datatransport.cct.internal;

import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_LogEvent extends LogEvent {
    public final Integer eventCode;
    public final long eventTimeMs;
    public final long eventUptimeMs;
    public final NetworkConnectionInfo networkConnectionInfo;
    public final byte[] sourceExtension;
    public final String sourceExtensionJsonProto3;
    public final long timezoneOffsetSeconds;

    public AutoValue_LogEvent(long j, Integer num, long j2, byte[] bArr, String str, long j3, NetworkConnectionInfo networkConnectionInfo) {
        this.eventTimeMs = j;
        this.eventCode = num;
        this.eventUptimeMs = j2;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j3;
        this.networkConnectionInfo = networkConnectionInfo;
    }

    public final boolean equals(Object obj) {
        Integer num;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogEvent) {
            LogEvent logEvent = (LogEvent) obj;
            AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) logEvent;
            NetworkConnectionInfo networkConnectionInfo2 = autoValue_LogEvent.networkConnectionInfo;
            String str2 = autoValue_LogEvent.sourceExtensionJsonProto3;
            Integer num2 = autoValue_LogEvent.eventCode;
            if (this.eventTimeMs == autoValue_LogEvent.eventTimeMs && ((num = this.eventCode) != null ? num.equals(num2) : num2 == null) && this.eventUptimeMs == autoValue_LogEvent.eventUptimeMs) {
                if (Arrays.equals(this.sourceExtension, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).sourceExtension : autoValue_LogEvent.sourceExtension) && ((str = this.sourceExtensionJsonProto3) != null ? str.equals(str2) : str2 == null) && this.timezoneOffsetSeconds == autoValue_LogEvent.timezoneOffsetSeconds && ((networkConnectionInfo = this.networkConnectionInfo) != null ? networkConnectionInfo.equals(networkConnectionInfo2) : networkConnectionInfo2 == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.eventTimeMs;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.eventCode;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j2 = this.eventUptimeMs;
        int iHashCode2 = (((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.timezoneOffsetSeconds;
        int i2 = (iHashCode3 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
        return i2 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{121, 9, 86, 117, 19, 85, 93, 16, 30, 80, 66, 86, 91, 18, 101, 89, 8, 85, 126, 23, 88}, "5f10e03de543", 0.0f));
        sb.append(this.eventTimeMs);
        sb.append(C0000.decode(new byte[]{21, 67, 93, 64, 1, 10, 23, 113, 13, 83, 1, 9}, "9c86ddc2b7d4", false));
        sb.append(this.eventCode);
        sb.append(C0000.decode(new byte[]{78, 67, 0, 19, 92, 92, 64, 55, 18, 66, 91, 89, 7, 46, 22, 88}, "bcee924bb624", 0.0f));
        sb.append(this.eventUptimeMs);
        sb.append(C0000.decode(new byte[]{28, 16, 65, 11, 76, 68, 6, 4, 33, 73, 69, 92, 86, 74, 94, 92, 94, 13}, "002d96ead1198973", 4));
        sb.append(Arrays.toString(this.sourceExtension));
        sb.append(C0000.decode(new byte[]{26, 67, 21, 11, 66, 20, 85, 6, 35, 28, 67, 3, 88, 16, 15, 11, 89, 44, 69, 12, 8, 52, 69, 9, 66, 12, 85, 89}, "6cfd7f", 6));
        sb.append(this.sourceExtensionJsonProto3);
        sb.append(C0000.decode(new byte[]{29, 69, 71, 15, 14, 83, 24, 86, 91, 4, 127, 84, 87, 22, 86, 18, 48, 83, 1, 86, 91, 5, 67, 15}, "1e3fc6b95a02", 0.0f));
        sb.append(this.timezoneOffsetSeconds);
        sb.append(C0000.decode(new byte[]{24, 17, 8, 87, 17, 69, 95, 68, 82, 39, 90, 93, 94, 85, 87, 69, 15, 93, 11, 123, 94, 80, 86, 89}, "41f2e2069d5300", true));
        sb.append(this.networkConnectionInfo);
        sb.append(C0000.decode(new byte[]{76}, "197654f1e00567e1", 0.0f));
        return sb.toString();
    }
}
