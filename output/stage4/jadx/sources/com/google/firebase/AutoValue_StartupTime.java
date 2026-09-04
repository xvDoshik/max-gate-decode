package com.google.firebase;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_StartupTime extends StartupTime {
    public final long elapsedRealtime;
    public final long epochMillis;
    public final long uptimeMillis;

    public AutoValue_StartupTime(long j, long j2, long j3) {
        this.epochMillis = j;
        this.elapsedRealtime = j2;
        this.uptimeMillis = j3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StartupTime) {
            AutoValue_StartupTime autoValue_StartupTime = (AutoValue_StartupTime) ((StartupTime) obj);
            if (this.epochMillis == autoValue_StartupTime.epochMillis && this.elapsedRealtime == autoValue_StartupTime.elapsedRealtime && this.uptimeMillis == autoValue_StartupTime.uptimeMillis) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.epochMillis;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.elapsedRealtime;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.uptimeMillis;
        return i2 ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{54, 18, 83, 69, 18, 77, 21, 50, 91, 90, 3, 67, 0, 22, 93, 84, 14, 117, 12, 10, 94, 94, 21, 5}, "ef27f8", 0.0f));
        sb.append(this.epochMillis);
        sb.append(C0000.decode(new byte[]{79, 66, 3, 93, 89, 22, 23, 80, 81, 100, 80, 82, 94, 18, 10, 15, 3, 12}, "cbf18fd556532f"));
        sb.append(this.elapsedRealtime);
        sb.append(C0000.decode(new byte[]{26, 23, 17, 70, 65, 8, 84, 0, 46, 81, 15, 13, 95, 68, 89}, "67d65a9ec8ca"));
        sb.append(this.uptimeMillis);
        sb.append(C0000.decode(new byte[]{74}, "7ed147", false));
        return sb.toString();
    }
}
