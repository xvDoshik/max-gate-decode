package com.google.android.datatransport.cct.internal;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_ClientInfo extends ClientInfo {
    public final AutoValue_AndroidClientInfo androidClientInfo;

    public AutoValue_ClientInfo(AutoValue_AndroidClientInfo autoValue_AndroidClientInfo) {
        this.androidClientInfo = autoValue_AndroidClientInfo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        Object obj2 = ClientInfo.ClientType.ANDROID_FIREBASE;
        if (obj2.equals(obj2)) {
            return this.androidClientInfo.equals(((AutoValue_ClientInfo) clientInfo).androidClientInfo);
        }
        return false;
    }

    public final int hashCode() {
        return ((ClientInfo.ClientType.ANDROID_FIREBASE.hashCode() ^ 1000003) * 1000003) ^ this.androidClientInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{34, 88, 94, 80, 90, 68, 45, 93, 95, 13, 29, 1, 8, 13, 4, 90, 67, 97, 77, 64, 1, 14}, "a47540d39bfbdd", 0.0f));
        sb.append(ClientInfo.ClientType.ANDROID_FIREBASE);
        sb.append(C0000.decode(new byte[]{20, 65, 89, 86, 82, 65, 87, 8, 92, 123, 90, 90, 93, 15, 76, 113, 88, 85, 87, 92}, "8a8863", 0.0f));
        sb.append(this.androidClientInfo);
        sb.append(C0000.decode(new byte[]{25}, "d18c37", 0.0f));
        return sb.toString();
    }
}
