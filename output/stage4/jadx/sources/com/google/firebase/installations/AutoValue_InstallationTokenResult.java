package com.google.firebase.installations;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_InstallationTokenResult {
    public final String token;
    public final long tokenCreationTimestamp;
    public final long tokenExpirationTimestamp;

    public AutoValue_InstallationTokenResult(String str, long j, long j2) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.tokenCreationTimestamp = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_InstallationTokenResult) {
            AutoValue_InstallationTokenResult autoValue_InstallationTokenResult = (AutoValue_InstallationTokenResult) obj;
            if (this.token.equals(autoValue_InstallationTokenResult.token) && this.tokenExpirationTimestamp == autoValue_InstallationTokenResult.tokenExpirationTimestamp && this.tokenCreationTimestamp == autoValue_InstallationTokenResult.tokenCreationTimestamp) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.token.hashCode() ^ 1000003) * 1000003;
        long j = this.tokenExpirationTimestamp;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.tokenCreationTimestamp;
        return i ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{47, 94, 18, 18, 0, 88, 95, 85, 17, 12, 12, 95, 100, 92, 9, 7, 8, 98, 4, 21, 20, 88, 71, 79, 17, 10, 8, 84, 94, 14}, "f0afa434eec103bb", true));
        sb.append(this.token);
        sb.append(C0000.decode(new byte[]{24, 17, 23, 87, 89, 3, 86, 32, 30, 73, 11, 16, 86, 18, 93, 94, 13, 108, 91, 11, 93, 22, 18, 88, 15, 18, 10}, "41c82f8ef9bb7f", 1));
        sb.append(this.tokenExpirationTimestamp);
        sb.append(C0000.decode(new byte[]{74, 24, 16, 11, 92, 7, 87, 123, 64, 3, 83, 69, 15, 87, 10, 48, 94, 15, 92, 75, 70, 7, 95, 65, 91}, "f8dd7b982f21", 0.0f));
        sb.append(this.tokenCreationTimestamp);
        sb.append(C0000.decode(new byte[]{27}, "f538a4db40", 0.0f));
        return sb.toString();
    }
}
