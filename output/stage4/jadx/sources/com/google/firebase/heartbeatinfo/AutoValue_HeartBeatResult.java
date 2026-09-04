package com.google.firebase.heartbeatinfo;

import java.util.ArrayList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_HeartBeatResult {
    public final ArrayList usedDates;
    public final String userAgent;

    public AutoValue_HeartBeatResult(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException(C0000.decode(new byte[]{123, 67, 13, 93, 21, 16, 70, 83, 19, 112, 82, 0, 91, 66}, "56a15e", 0.0f));
        }
        this.userAgent = str;
        this.usedDates = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_HeartBeatResult)) {
            return false;
        }
        AutoValue_HeartBeatResult autoValue_HeartBeatResult = (AutoValue_HeartBeatResult) obj;
        return this.userAgent.equals(autoValue_HeartBeatResult.userAgent) && this.usedDates.equals(autoValue_HeartBeatResult.usedDates);
    }

    public final int hashCode() {
        return ((this.userAgent.hashCode() ^ 1000003) * 1000003) ^ this.usedDates.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{123, 81, 87, 69, 67, 116, 81, 81, 21, 102, 0, 67, 19, 10, 71, 79, 67, 68, 82, 68, 117, 87, 4, 90, 17, 13}, "34677640a4e0ff", 7));
        sb.append(this.userAgent);
        sb.append(C0000.decode(new byte[]{74, 21, 70, 64, 84, 5, 32, 83, 23, 93, 17, 10}, "f5331ad2c8b7", false));
        sb.append(this.usedDates);
        sb.append(C0000.decode(new byte[]{28}, "a0d2f28bfce9", 3));
        return sb.toString();
    }
}
