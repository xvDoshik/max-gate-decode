package com.google.android.datatransport.cct.internal;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    public final NetworkConnectionInfo.MobileSubtype mobileSubtype;
    public final NetworkConnectionInfo.NetworkType networkType;

    public AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.networkType = networkType;
        this.mobileSubtype = mobileSubtype;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NetworkConnectionInfo) {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            NetworkConnectionInfo.NetworkType networkType = this.networkType;
            if (networkType != null ? networkType.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType) : ((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType == null) {
                NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
                if (mobileSubtype != null ? mobileSubtype.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).mobileSubtype) : ((AutoValue_NetworkConnectionInfo) networkConnectionInfo).mobileSubtype == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        int iHashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
        return (mobileSubtype != null ? mobileSubtype.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{47, 86, 69, 67, 88, 69, 89, 37, 89, 88, 15, 86, 82, 64, 94, 88, 92, 47, 88, 80, 14, 72, 95, 81, 67, 64, 93, 20, 93, 98, 24, 67, 84, 9}, "a314772f66", 0.0f));
        sb.append(this.networkType);
        sb.append(C0000.decode(new byte[]{74, 24, 88, 87, 3, 92, 10, 4, 98, 19, 87, 68, 74, 70, 93, 92}, "f858a5fa1f50368a", 4));
        sb.append(this.mobileSubtype);
        sb.append(C0000.decode(new byte[]{73}, "4c95125d82e2451e", false));
        return sb.toString();
    }
}
